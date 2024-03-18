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
--VALUES ('admin', '123456', '홍길동', '남자', 'admin@korea.com');


CREATE table "bbs"(
    bbsID INT,
    bbsTitle VARCHAR2(50),
     userID VARCHAR2(20),
     bbsDate DATE,
     bbsContent VARCHAR2(2024),
        bbsAvailable int,
        PRIMARY KEY (bbsID)
--현재 글이 삭제되어있는지,  어베일러블이 1인 경우 게시판글, 0인 경우 삭제된 글        

);
