-- drop table public.cepentity;
INSERT INTO public.tb_endereco (cd_latitude,cd_longitude,cd_cep,cd_estado,cd_tipo_endereco,nm_bairro,nm_cidade,nm_endereco) VALUES
	 (-23.96435,-46.33243,'11060001','SP','AVENIDA','Gonzaga','Santos','Ana Costa'),
	 (-24.02543,-46.47702,'11704280','SP','RUA','Ocian','Praia Grande','José de Alencar'),
	 (-23.93047,-46.40554,'11533180','SP','RUA','Jardim Casqueiro','Cubatão','São Vicente'),
	 (-23.94729,-46.35691,'11080160','SP','RUA','Morro Nova Cintra','Santos','Paulo Clemente Santini'),
	 (-22.99545,-47.50506,'13360027','SP','PRACA','Centro','Capivari','Cônego Fragoso'),
	 (-9.97876,-67.81015,'69900001','AC','BECO','Base','Rio Branco','Estado do Acre'),
	 (-9.66255,-35.72515,'57085578','AL','RUA','Benedito Bentes','Maceió','Jornalista Tamal Zaidan'),
	 (0.0325,-51.06659,'68900001','AP','AVENIDA','Central','Macapá','Antônio Coelho de Carvalho'),
	 (-3.03145,-60.01148,'69039733','AM','RUA','Novo Israel','Manaus','Estrela de Davi'),
	 (-12.83594,-38.37961,'41400025','BA','RUA','Nova Esperança','Salvador','da Vitória da Ceasa'),
	 (-3.77427,-38.61401,'60530530','CE','RUA','Conjunto Ceará II','Fortaleza','303'),
	 (-20.27701,-40.30074,'29066010','ES','RUA','Mata da Praia','Vitória','Ana Vieira Mafra'),
	 (-16.65215,-49.1566,'75256144','GO','AVENIDA','Jardim das Oliveiras','Senador Canedo','Macaúbas'),
	 (-2.52495,-44.28553,'65035470','MA','RUA','Liberdade','São Luís','Nossa Senhora das Graças'),
	 (-15.63427,-56.02183,'78088500','MT','AVENIDA','Altos do Coxipó','Cuiabá','Doutor Meirelles');

INSERT INTO public.tb_entregador (nome, cpf, numero_telefone) VALUES ('Lukas', '1234578', '6185201452');
INSERT INTO public.tb_entregador (nome, cpf, numero_telefone) VALUES ('Marcos', '98765432', '6685203254');
INSERT INTO public.tb_entregador (nome, cpf, numero_telefone) VALUES ('João', '85236974', '5598520136');

INSERT INTO tb_pedidos (cd_cliente, dt_criacao, ds_status_pedido, cd_cep, nr_endereco, ds_complemento_endereco) VALUES (1,CURRENT_TIMESTAMP, 'Aguardando Entrega', '7785210', '25', 'Rua');
INSERT INTO tb_pedidos (cd_cliente, dt_criacao, ds_status_pedido, cd_cep, nr_endereco, ds_complemento_endereco) VALUES (2,CURRENT_TIMESTAMP, 'Aguardando Entrega', '75201254', '40', 'Casa');
INSERT INTO tb_pedidos (cd_cliente, dt_criacao, ds_status_pedido, cd_cep, nr_endereco, ds_complemento_endereco) VALUES (3,CURRENT_TIMESTAMP, 'Aguardando Entrega', '77854136', '55', 'Apartamento');

INSERT INTO tb_entrega (cd_entregador, cd_pedido, data_entrega) VALUES (1, 1,'2024-05-18 19:00:00');
INSERT INTO tb_entrega (cd_entregador, cd_pedido, data_entrega) VALUES (2, 2,'2024-05-19 20:00:00');
INSERT INTO tb_entrega (cd_entregador, cd_pedido, data_entrega) VALUES (3, 3,'2024-05-20 21:00:00');