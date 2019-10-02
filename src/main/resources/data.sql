INSERT INTO TB_COMPANY values (1, 'AV LINS VANSCONCELOS', 'BUILDIT', 0123456789,'BUILDIT');
INSERT INTO TB_COMPANY values (2, 'AV CELSO GARCIA', 'ORACLE', 987654,'ORACLE');

INSERT INTO TB_CATEGORY values (1, 'Category description', 'Principal', null);
INSERT INTO TB_CATEGORY values (2, 'Category description', 'Others', 1);


INSERT INTO TB_PRODUCT values(1, 'BDI0001', 'Just an example of a product description', '0.5 KG', 'Build It Product', '', 10.00, 1, 1 );
INSERT INTO TB_PRODUCT values(2, 'ORC0001', 'Just an example of a product description', '1 KG', 'Oracle Product', '', 5.00, 1, 2 );
INSERT INTO TB_PRODUCT values(3, 'ORC9999', 'Just an example of a product description', '2 inches', 'Oracle Product (2)', '', 9.00, 2, 2 );

INSERT INTO TB_EMPLOYEE values (1, 'buildit@fiap.com.br','Matheus','nimda','ROLE_ADMIN', 1);
INSERT INTO TB_EMPLOYEE values (3, 'teste@fiap.com.br','Thiago','nimda','ROLE_ADMIN', 1);
INSERT INTO TB_EMPLOYEE values (2, 'user@fiap.com.br','Ana Julia','nimda','ROLE_USER', 1);
INSERT INTO TB_EMPLOYEE values (4, 'oracle@gmail.com.br','Thiago','nimda','ROLE_ADMIN', 2);

INSERT  INTO TB_CUSTOMER values (1, 'AV JUNDIAI, 69 - Apto 190', {ts '1997-12-24 18:47:52.69'}, '42933007643', 'customer@gmail.com', 'Augusta','customer', '(11)99113-3700', null);

INSERT  INTO TB_VEHICLE values (1, 'WHITE', 'Toyota Yaris Hatch', 'ABC-1234', 2019);

INSERT  INTO TB_DRIVER values (1, 'AV JOAO MEDEIROS', {ts '1997-12-24 18:47:52.69'}, '44944008743', 'driver@gmail.com', 'Maria', 'driver', '(11)99456-1234', null, '531768758731', 1);

INSERT INTO TB_ORDER values (1, {ts '2019-09-22 13:15:00.10'}, 25, 1, 1);
INSERT INTO TB_ORDER_PRODUCT values (1, 2, 1, 1);
INSERT INTO TB_ORDER_PRODUCT values (2, 1, 1, 2);