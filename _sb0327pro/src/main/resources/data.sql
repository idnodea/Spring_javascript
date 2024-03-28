-- Products 테이블에 데이터 삽입
INSERT INTO Product (prod_name, prod_price,prod_quantity) values ('베베숲 물티슈', 2700, 80);
INSERT INTO Product (prod_name, prod_price,prod_quantity) values ('여름 토퍼', 35180, 80);
INSERT INTO Product (prod_name, prod_price,prod_quantity) values ('페이크 삭스', 860, 80);
INSERT INTO Product (prod_name, prod_price,prod_quantity) values ('우산', 2900, 80);

-- member_pro 테이블에 데이터 삽입
insert into member_pro(member_name,member_email,member_tel) values('홍길동','aaa@korea.com','010-1111-1111');
insert into member_pro(member_name,member_email,member_tel) values('김하나','bbb@korea.com','010-2222-2222');
insert into member_pro(member_name,member_email,member_tel) values('이두리','ccc@korea.com','010-3333-3333');

-- order_pro 테이블에 데이터 삽입 (pro_id 컬럼 값을 추가해야 합니다.)
-- 아래 pro_id 값은 예시입니다. 실제 Products 테이블에 삽입된 prod_id 값을 참조해야 합니다.
insert into order_pro(order_name,order_email,order_tel, pro_id,prod_quantity) values('홍길동','aaa@korea.com','010-1111-1111', 1,1);
insert into order_pro(order_name,order_email,order_tel, pro_id,prod_quantity) values('주문자1','abc@korea.com','010-1111-1234', 2,1);
insert into order_pro(order_name,order_email,order_tel, pro_id,prod_quantity) values('주문자2','cc1@korea.com','010-3333-3421', 3,1);

-- INSERT INTO Products (prod_name, prod_price) values ('베베숲 물티슈', 2700);
-- INSERT INTO Products (prod_name, prod_price) values ('여름 토퍼', 35180);
-- INSERT INTO Products (prod_name, prod_price) values ('페이크 삭스', 860);
-- INSERT INTO Products (prod_name, prod_price) values ('우산', 2900);

-- insert into member_pro(member_name,member_email,member_tel) values('홍길동','aaa@korea.com','010-1111-1111');
-- insert into member_pro(member_name,member_email,member_tel) values('김하나','bbb@korea.com','010-2222-2222');
-- insert into member_pro(member_name,member_email,member_tel) values('이두리','ccc@korea.com','010-3333-3333');

-- insert into order_pro(order_name,order_email,order_tel) values('홍길동','aaa@korea.com','010-1111-1111');
-- insert into order_pro(order_name,order_email,order_tel) values('주문자1','abc@korea.com','010-1111-1234');
-- insert into order_pro(order_name,order_email,order_tel) values('주문자2','cc1@korea.com','010-3333-3421');