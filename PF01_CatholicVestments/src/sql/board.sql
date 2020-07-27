DROP TABLE BOARD;
CREATE TABLE BOARD(
	NO NUMBER PRIMARY KEY,
	TITLE VARCHAR2(100) NOT NULL,
	USER_ID VARCHAR2(30) DEFAULT "익명",
	CONTENT VARCHAR2(4000),
	BOARDABLE NUMBER(1) DEFAULT 1, -- 0: DELETE, 1: READ 
	WRITE_DATE DATE DEFAULT SYSDATE
);

DROP SEQUENCE BOARD_SEQ;
CREATE SEQUENCE BOARD_SEQ
START WITH 1001
INCREMENT BY 1
MAXVALUE 999999
NOCACHE
NOCYCLE;

INSERT INTO BOARD(NO, TITLE, USER_ID, CONTENT)
	VALUES(BOARD_SEQ.NEXTVAL, '총 균 쇠', '에밀리','인간의 문명에 관한 인류사 장르의 책');
INSERT INTO BOARD(NO, TITLE, USER_ID, CONTENT)
	VALUES(BOARD_SEQ.NEXTVAL, '안나 카레니나', '앨리스','행복한 가장은 모두 비슷하지만 불행한 가정은 저마다의 이유가 있다.');
INSERT INTO BOARD(NO, TITLE, USER_ID, CONTENT)
	VALUES(BOARD_SEQ.NEXTVAL, '닥터 프로스트', '제임스','극복하지 못하면 닮아간다.');
	
SELECT * FROM BOARD;
