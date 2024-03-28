-- Products 테이블이 존재한다면 삭제
-- DROP TABLE IF EXISTS Products;

-- Products 테이블 생성
CREATE TABLE IF NOT EXISTS products (
    prod_id bigint AUTO_INCREMENT PRIMARY KEY,
    prod_name VARCHAR(255) NOT NULL,
    prod_price INT NOT NULL,
    prod_quantity bigint NOT NULL
);

-- member_pro 테이블이 존재한다면 삭제
-- DROP TABLE IF EXISTS member_pro;

-- member_pro 테이블 생성
CREATE TABLE member_pro
(
    member_id IDENTITY PRIMARY KEY,
    member_name VARCHAR(60) NOT NULL,
    member_email VARCHAR(80) NOT NULL,
    member_tel VARCHAR(40) NOT NULL
);

-- order_pro 테이블이 존재한다면 삭제
-- DROP TABLE IF EXISTS order_pro;

-- order_pro 테이블 생성
CREATE TABLE IF NOT EXISTS order_pro(
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    order_name VARCHAR(255) NOT NULL,
    order_email VARCHAR(255) NOT NULL,
    order_tel VARCHAR(255) NOT NULL,
    prod_id bigint,
    FOREIGN KEY (prod_id) REFERENCES products(prod_id),
    prod_quantity bigint,
    FOREIGN KEY (prod_id) REFERENCES products(prod_id)
);



-- DROP TABLE IF EXISTS Products;
-- CREATE TABLE Products
-- (
--     prod_id IDENTITY PRIMARY KEY,
--     prod_name VARCHAR(255) NOT NULL,
--     prod_price INT NOT NULL
-- );

-- DROP TABLE IF EXISTS member_pro;
-- CREATE TABLE member_pro
-- (
--     member_id IDENTITY PRIMARY KEY,
--     member_name VARCHAR(60) NOT NULL,
--     member_email VARCHAR(80) NOT NULL,
--     member_tel VARCHAR(40) NOT NULL
-- );

-- DROP TABLE IF EXISTS order_pro;
-- CREATE TABLE order_pro
-- (
--     order_id IDENTITY PRIMARY KEY,
--     order_name VARCHAR(60) NOT NULL,
--     order_email VARCHAR(80) NOT NULL,
--     order_tel VARCHAR(80) NOT NULL,
--     pro_id INT NOT NULL,
--     UNIQUE(pro_id)
-- );

-- -- 여기에 외래 키 제약 조건을 추가합니다.
-- ALTER TABLE order_pro
-- ADD CONSTRAINT fk_product
-- FOREIGN KEY (pro_id)
-- REFERENCES Products (prod_id);