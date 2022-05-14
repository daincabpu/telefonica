

drop table if exists public.oferta;
drop table if exists public.linea_movil;
drop table if exists public.cliente;

create table if not exists public.cliente
(
    "cliente_id" bigint not null ,
    "nombres" character varying(100) collate pg_catalog."default",
    "ape_paterno" character varying(100) collate pg_catalog."default",
    "ape_materno" character varying(100) collate pg_catalog."default",
    "tipo_documento" smallint,
    "nro_documento" character varying(11) collate pg_catalog."default",
    "estado" char(1),
    "fecha_nacimiento" date,
    constraint "pk_cliente" primary key ("cliente_id")
)

tablespace pg_default;

alter table if exists public.cliente
    owner to postgres;
	
create sequence if not exists public."cliente_seq"
    increment 1
    start 1
    minvalue 1
    maxvalue 9223372036854775807
    cache 1
    owned by cliente."cliente_id";

alter sequence public."cliente_seq"
    owner to postgres;

alter table if exists public.cliente
    alter column "cliente_id" set default nextval('"cliente_seq"'::regclass);

create index if not exists "idx_cliente_estado"
    on public.cliente using btree
    ("estado" asc nulls last)
    tablespace pg_default;
	
create index if not exists "idx_cliente_tipdoc"
    on public.cliente using btree
    ("tipo_documento" asc nulls last)
    tablespace pg_default;

create index if not exists "idx_cliente_nrodoc"
    on public.cliente using btree
    ("nro_documento" asc nulls last)
    tablespace pg_default;
	

create table if not exists public.linea_movil
(
    "linea_movil_id" bigint not null,
    "cliente_id" bigint not null,
    "nro_telefono" character varying(13) collate pg_catalog."default",
    "tipo" char(3),
    "nombre_plan" character varying(100) collate pg_catalog."default",
    "estado" char(1),
    constraint "pk_linea_movil" primary key ("linea_movil_id"),
    constraint "fk_linmov_cliente" foreign key ("cliente_id")
        references public.cliente ("cliente_id") match simple
        on update no action
        on delete no action
        not valid
)

tablespace pg_default;

alter table if exists public.linea_movil
    owner to postgres;

create sequence if not exists public."linea_movil_seq"
    increment 1
    start 1
    minvalue 1
    maxvalue 9223372036854775807
    cache 1
    owned by linea_movil."linea_movil_id";

alter sequence public."linea_movil_seq"
    owner to postgres;
	
alter table if exists public.linea_movil
    alter column "linea_movil_id" set default nextval('"linea_movil_seq"'::regclass);	
	
create index if not exists "idx_lineamovil_cliente_id"
    on public.linea_movil using btree
    ("cliente_id" asc nulls last)
    tablespace pg_default;
	
create index if not exists "idx_lineamovil_estado"
    on public.linea_movil using btree
    ("estado" asc nulls last)
    tablespace pg_default;

create index if not exists "idx_lineamovil_tipo"
    on public.linea_movil using btree
    ("tipo" asc nulls last)
    tablespace pg_default;
	

	

create table if not exists public.oferta
(
    "oferta_id" bigint not null ,
    "linea_movil_id" bigint not null,
    "cliente_id" bigint not null,
    "codigo_oferta" character varying(50) collate pg_catalog."default",
    "descripcion" character varying(500) collate pg_catalog."default",
    "fecha_inicio" date,
    "fecha_fin" date,
    "estado" char(1),
    constraint "pk_oferta" primary key ("oferta_id"),
    constraint "fk_oferta_cliente" foreign key ("cliente_id")
        references public.cliente ("cliente_id") match simple
        on update no action
        on delete no action
        not valid,
    constraint "fk_oferta_linmov" foreign key ("linea_movil_id")
        references public.linea_movil ("linea_movil_id") match simple
        on update no action
        on delete no action
        not valid
)

tablespace pg_default;

alter table if exists public.oferta
    owner to postgres;
	
create sequence if not exists public."oferta_seq"
    increment 1
    start 1
    minvalue 1
    maxvalue 9223372036854775807
    cache 1
    owned by oferta."oferta_id";

alter sequence public."oferta_seq"
    owner to postgres;	

alter table if exists public.oferta
    alter column "oferta_id" set default nextval('"oferta_seq"'::regclass);	

create index if not exists "idx_oferta_lineamovil_id"
    on public.oferta using btree
    ("cliente_id" asc nulls last)
    tablespace pg_default;


create index if not exists "idx_oferta_cliente_id"
    on public.oferta using btree
    ("linea_movil_id" asc nulls last)
    tablespace pg_default;

create index if not exists "idx_oferta_estado"
    on public.linea_movil using btree
    ("estado" asc nulls last)
    tablespace pg_default;
	
	