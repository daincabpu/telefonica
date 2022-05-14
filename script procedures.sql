
create or replace FUNCTION public.buscar_x_tip_nrodoc(
	IN p_in_tipo_documento smallint, 
	IN p_in_nro_documento character varying
)
  returns TABLE (
	cliente_id bigint, 
	nombres varchar,
	ape_paterno varchar,
	ape_materno varchar,
	tipo_documento smallint,
	nro_documento varchar,
	lineas_moviles json
) 
AS $$
BEGIN
    RETURN QUERY 
	WITH cli AS
	(
		Select c.* from cliente c where 
		(p_in_tipo_documento ISNULL or c.tipo_documento = p_in_tipo_documento)
		AND (p_in_nro_documento ISNULL OR c.nro_documento = p_in_nro_documento)
		AND c.estado = 'A'
	),
	lin as
	(
		Select lm.* from linea_movil lm
		inner join cli c ON lm.cliente_id = c.cliente_id
		WHERE lm.estado = 'A'
	),
	ofe as 
	(
		SELECT o.linea_movil_id, o.cliente_id , json_agg(o) as ofertas FROM oferta o 
		inner join lin lm ON lm.linea_movil_id = o.linea_movil_id
		and o.cliente_id = lm.cliente_id
		group by o.linea_movil_id, o.cliente_id
	),
	ln_ofe as
	(
		select lin.cliente_id, lin.nro_telefono, lin.tipo, lin.nombre_plan, lin.estado, ofe.ofertas  from lin
		left join ofe ON lin.linea_movil_id = ofe.linea_movil_id
		and ofe.cliente_id = lin.cliente_id
	),
	ln_ofe_js as
	(
		select ln_ofe.cliente_id, json_agg(ln_ofe) as lineas_moviles   
		from ln_ofe
		group by ln_ofe.cliente_id
	)
	SELECT
        c.cliente_id , 
		c.nombres ,
		c.ape_paterno ,
		c.ape_materno ,
		c.tipo_documento ,
		c.nro_documento ,
        lnof.lineas_moviles
    FROM
        cli c left join ln_ofe_js lnof ON lnof.cliente_id = c.cliente_id; 
END; $$ 

LANGUAGE 'plpgsql';
