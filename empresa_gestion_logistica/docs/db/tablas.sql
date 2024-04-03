

-- Creacion de tablas

create table
  public.cli_cliente (
    cli_id text not null,
    cli_email text not null,
    cli_nombre text not null default ''::text,
    cli_telefono text null,
    cli_tipo_id text not null default 'C'::text,
    cli_direccion text null,
    cli_estado text not null default 'A'::text,
    constraint cli_cliente_pkey primary key (cli_id)
  ) tablespace pg_default;

create table
  public.pro_producto (
    pro_id text not null,
    pro_tipo text not null default 'T'::text,
    pro_nombre text not null,
    pro_cantidad numeric not null default '0'::numeric,
    pro_valor_unitario numeric not null default '0'::numeric,
    pro_estado text not null default 'A'::text,
    constraint pro_producto_pkey primary key (pro_id)
  ) tablespace pg_default;

create table
  public.alm_almacen (
    alm_id text not null,
    alm_tipo text not null default 'T'::text,
    alm_nombre text not null,
    alm_descripcion text null,
    alm_direccion text not null,
    alm_estado text not null default 'A'::text,
    constraint alm_almacen_pkey primary key (alm_id)
  ) tablespace pg_default;

create table
  public.tra_transporte (
    tra_id text not null,
    tra_tipo text not null default 'T'::text,
    tra_matricula text not null,
    tra_marca text not null,
    tra_modelo text not null,
    tra_id_responsable text not null,
    tra_nom_responsable text null,
    tra_estado text not null,
    constraint tra_transporte_pkey primary key (tra_id)
    constraint tra_transporte_tra_matricula_key unique (tra_matricula)
  ) tablespace pg_default;

create table
  public.ent_entrega (
    ent_id text not null,
    ent_cli text not null,
    ent_pro text not null,
    ent_alm text not null,
    ent_tra text not null,
    ent_num_guia text not null,
    ent_fec_registro timestamp with time zone not null,
    ent_fec_entrega timestamp with time zone null,
    ent_estado text not null default 'A'::text,
    ent_tipo text not null default 'T'::text,
    ent_cantidad numeric not null default '0'::numeric,
    ent_valor_total numeric not null default '0'::numeric,
    ent_valor_descuento numeric null default '0'::numeric,
    constraint ent_entrega_pkey primary key (ent_id),
    constraint ent_entrega_ent_num_guia_key unique (ent_num_guia),
    constraint public_ent_entrega_ent_alm_fkey foreign key (ent_alm) references alm_almacen (alm_id),
    constraint public_ent_entrega_ent_cli_fkey foreign key (ent_cli) references cli_cliente (cli_id),
    constraint public_ent_entrega_ent_pro_fkey foreign key (ent_pro) references pro_producto (pro_id),
    constraint public_ent_entrega_ent_tra_fkey foreign key (ent_tra) references tra_transporte (tra_id)
  ) tablespace pg_default;


-- Index

CREATE UNIQUE INDEX cli_cliente_pkey ON public.cli_cliente USING btree (cli_id);
CREATE UNIQUE INDEX pro_producto_pkey ON public.pro_producto USING btree (pro_id);
CREATE UNIQUE INDEX alm_almacen_pkey ON public.alm_almacen USING btree (alm_id);
CREATE UNIQUE INDEX tra_transporte_pkey ON public.tra_transporte USING btree (tra_id);
CREATE UNIQUE INDEX tra_transporte_tra_matricula_key ON public.tra_transporte USING btree (tra_matricula);
CREATE UNIQUE INDEX ent_entrega_pkey ON public.ent_entrega USING btree (ent_id);
CREATE UNIQUE INDEX ent_entrega_ent_num_guia_key ON public.ent_entrega USING btree (ent_num_guia);