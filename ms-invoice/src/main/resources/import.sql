 

create table invoice(
	id_invoice  SERIAL not null,
	amount numeric(17,2),
	state  int,
	constraint pk_invoice primary key (id_invoice)
);
INSERT INTO public.invoice (amount, state) VALUES(1500.00, 1);
INSERT INTO public.invoice (amount, state) VALUES(300.00, 1);
INSERT INTO public.invoice (amount, state) VALUES(500.00, 1);
INSERT INTO public.invoice (amount, state) VALUES(1800.00, 1);
INSERT INTO public.invoice (amount, state) VALUES(3000.00, 1);


