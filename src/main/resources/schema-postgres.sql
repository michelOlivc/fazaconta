
CREATE SEQUENCE hibernate_sequence START 1;

CREATE TABLE IF NOT EXISTS public.product (
	id int4 NOT NULL,
	"name" varchar NULL,
	price numeric NULL,
	CONSTRAINT product_pk PRIMARY KEY (id)
);
