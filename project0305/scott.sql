--CREATE TABLE "user" (
--    userID VARCHAR2(20),
--    userPassword VARCHAR2(20),
--    userName VARCHAR2(20),
--    userGender VARCHAR2(20),
--    userEmail VARCHAR2(50),
--    PRIMARY KEY (userID)
--);
--
--INSERT INTO "user" (userID, userPassword, userName, userGender, userEmail)
--VALUES ('admin', '123456', 'ȫ�浿', '����', 'admin@korea.com');


CREATE table "bbs"(
    bbsID INT,
    bbsTitle VARCHAR2(50),
     userID VARCHAR2(20),
     bbsDate DATE,
     bbsContent VARCHAR2(2024),
        bbsAvailable int,
        PRIMARY KEY (bbsID)
--���� ���� �����Ǿ��ִ���,  ��Ϸ����� 1�� ��� �Խ��Ǳ�, 0�� ��� ������ ��        

);
