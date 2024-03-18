CREATE TABLE member0305(
    memberno INT PRIMARY KEY,
    memberID VARCHAR2(20),
    memberPassword VARCHAR2(20),
    memberName VARCHAR2(20),
    memberGender VARCHAR2(20),
    memberEmail VARCHAR2(50)
);

CREATE SEQUENCE seq_member0305
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 999999999999999999999999999
NOCYCLE
NOCACHE;

INSERT INTO member0305 (memberId, memberPassword, memberName, memberGender, memberEmail)
VALUES ('admin', '123456', 'ȫ�浿', '����', 'admin@korea.com');

CREATE TABLE board0305(
    memberID VARCHAR2(20) PRIMARY KEY,
    boardTitle VARCHAR2(50),
    --memberID VARCHAR2(20),
   memberno Int,
    boardDate DATE,
    boardContent VARCHAR2(2024),
    boardAvailable int
    -- ���� ���� �����Ǿ� �ִ��� Ȯ��: 1�� ��� �Խñ�, 0�� ��� ������ ��
    hits  int
);