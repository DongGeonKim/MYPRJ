CREATE TABLE TEST_USER(
	SEQ NUMBER NOT NULL,
	ID VARCHAR2(20) NOT NULL,
	PW VARCHAR2(500) NOT NULL,
	USER_NAME VARCHAR2(50) NOT NULL,
	REG_DATE DATE DEFAULT SYSDATE,
	MOD_DATE DATE DEFAULT SYSDATE
);
ALTER TABLE TEST_USER ADD (CONSTRAINT PK_TEST_USER PRIMARY KEY (SEQ, ID));

CREATE SEQUENCE SEQ_TEST_USER;

CREATE TABLE TEST_USER_ROLE(
	TEST_USER_SEQ NUMBER NOT NULL,
	USER_ROLE VARCHAR2(30) NOT NULL
);

CREATE INDEX IDX_TEST_USER_ROLE ON TEST_USER_ROLE (TEST_USER_SEQ ASC);

INSERT INTO TEST_USER
VALUES(SEQ_TEST_USER.NEXTVAL, 'test', 'test', '�׽�Ʈ', SYSDATE, SYSDATE);

INSERT INTO TEST_USER_ROLE
VALUES(SEQ_TEST_USER.CURRVAL, 'ROLE_USER');

COMMIT;