INSERT INTO TB_CATEGORY values (1, 'Category description', 'Principal', null);
INSERT INTO TB_CATEGORY values (2, 'Category description', 'Others', 1);


INSERT INTO TB_PRODUCT values(1, 'Just an example of a product description Just an example of a product description', '8"', 'Alicate universal 8" em aço carbono', '', 'BD0001', 19.50, 1);
INSERT INTO TB_PRODUCT values(2, 'Just an example of a product description', '1 Un/ 18L', 'Tinta Coral Acrilica Fosca', 'erro', 'BD0002', 279.90, 1);
INSERT INTO TB_PRODUCT values(3, 'Just an example of a product description', '30 x 30', 'Tijolo', 'https://appsisecommerces3.s3.amazonaws.com/clientes/cliente11837/produtos/7274/Z8569.jpg', 'BD0003', 3.00, 2);

INSERT INTO TB_EMPLOYEE values (1, 'buildit@fiap.com.br','Matheus','nimda','ROLE_ADMIN');
INSERT INTO TB_EMPLOYEE values (2, 'admin@fiap.com.br','Thiago','nimda','ROLE_ADMIN');
INSERT INTO TB_EMPLOYEE values (3, 'user@fiap.com.br','Ana Julia','user','ROLE_USER');


INSERT  INTO TB_CUSTOMER values (1, 'AV JUNDIAI, 69 - Apto 190', {ts '1997-12-24 18:47:52.69'}, '42933007643', 'customer@gmail.com', 'Augusta','customer', '(11)99113-3700', null);

INSERT  INTO TB_VEHICLE values (1, 'WHITE', 'Toyota Yaris Hatch', 'ABC-1234', 2019);

INSERT  INTO TB_DRIVER values (1, 'AV JOAO MEDEIROS', {ts '1997-12-24 18:47:52.69'}, '44944008743', 'driver@gmail.com', 'Maria', 'driver', '(11)99456-1234', null, '531768758731', 1);

INSERT INTO TB_ORDER values (1, {ts '2019-09-22 13:15:00.10'}, 25, 'CANCELADO', 1, 1);
INSERT INTO TB_ORDER values (2, {ts '2019-09-22 13:15:00.10'}, 30, 'PREPARANDO', 1, 1);

INSERT INTO TB_ORDER_PRODUCT values (1, 2, 1, 1);
INSERT INTO TB_ORDER_PRODUCT values (2, 1, 1, 3);
INSERT INTO TB_ORDER_PRODUCT values (3, 1, 2, 1);