BEGIN;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE IF NOT EXISTS public.company_category
(
    id uuid NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT company_category_pkey PRIMARY KEY (id)
);
INSERT INTO public.company_category(
	id, name)
	VALUES (uuid_generate_v4(),'Agriculture');
COMMIT;