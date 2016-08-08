create table MEMBER ( 
    ID int identity not null, 
    age int, 
    createdDate datetime2, 
    description varchar(MAX), 
    lastModifiedDate datetime2, 
    ROLE_TYPE varchar(255), 
    NAME      varchar(10) not null, 
    TEAM_ID   int, 
    LOCKER_ID int,
    primary key (ID) 
    );  
create table TEAM ( 
    TEAM_ID int identity not null, 
    TEAM_NAME varchar(255), 
    primary key (TEAM_ID) 
    );


CREATE TABLE dbo.Item (
    DTYPE          VARCHAR(31) NOT NULL, 
    ITEM_ID        BIGINT IDENTITY(1,1) NOT NULL, 
    name           VARCHAR(255), 
    author         VARCHAR(255), 
    isbn           VARCHAR(255), 
    actor          VARCHAR(255), 
    director       VARCHAR(255), 
    artist         VARCHAR(255)
);
    
    
INSERT INTO dbo.MEMBER
  ( age, createdDate, description, lastModifiedDate, ROLE_TYPE, NAME, TEAM_ID, LOCKER_ID)
VALUES
  ( 2, '', '', '', '', '지한1', 1, 0);

INSERT INTO dbo.MEMBER
  ( age, createdDate, description, lastModifiedDate, ROLE_TYPE, NAME, TEAM_ID, LOCKER_ID)
VALUES
  ( 2, '', '', '', '', '지한2', 1, 0);

INSERT INTO dbo.MEMBER
  ( age, createdDate, description, lastModifiedDate, ROLE_TYPE, NAME, TEAM_ID, LOCKER_ID)
VALUES
  ( 2, '', '', '', '', '지한1', 4, 0);

INSERT INTO dbo.MEMBER
  ( age, createdDate, description, lastModifiedDate, ROLE_TYPE, NAME, TEAM_ID, LOCKER_ID)
VALUES
  ( 2, '', '', '', '', '지한2', 4, 0);

INSERT INTO dbo.MEMBER
  ( age, createdDate, description, lastModifiedDate, ROLE_TYPE, NAME, TEAM_ID, LOCKER_ID)
VALUES
  ( 2, '', '', '', '', '지한1', 5, 0);

INSERT INTO dbo.MEMBER
  ( age, createdDate, description, lastModifiedDate, ROLE_TYPE, NAME, TEAM_ID, LOCKER_ID)
VALUES
  ( 2, '', '', '', '', '지한2', 5, 0);

INSERT INTO dbo.MEMBER
  ( age, createdDate, description, lastModifiedDate, ROLE_TYPE, NAME, TEAM_ID, LOCKER_ID)
VALUES
  ( 2, '', '', '', '', '지한1', 6, 0);

INSERT INTO dbo.MEMBER
  (ID, age, createdDate, description, lastModifiedDate, ROLE_TYPE, NAME, TEAM_ID, LOCKER_ID)
VALUES
  ( 2, '', '', '', '', '지한2', 6, 0);

INSERT INTO dbo.MEMBER
  ( age, createdDate, description, lastModifiedDate, ROLE_TYPE, NAME, TEAM_ID, LOCKER_ID)
VALUES
  ( 2, '', '', '', '', '지한1', 8, 0);

INSERT INTO dbo.MEMBER
  ( age, createdDate, description, lastModifiedDate, ROLE_TYPE, NAME, TEAM_ID, LOCKER_ID)
VALUES
  (14, 2, '', '', '', '', '지한2', 8, 0);

INSERT INTO dbo.MEMBER
  ( age, createdDate, description, lastModifiedDate, ROLE_TYPE, NAME, TEAM_ID, LOCKER_ID)
VALUES
  ( 2, '', '', '', '', '지한1', 9, 0);

INSERT INTO dbo.MEMBER
  ( age, createdDate, description, lastModifiedDate, ROLE_TYPE, NAME, TEAM_ID, LOCKER_ID)
VALUES
  ( 2, '', '', '', '', '지한2', 9, 0);

INSERT INTO dbo.MEMBER
  ( age, createdDate, description, lastModifiedDate, ROLE_TYPE, NAME, TEAM_ID, LOCKER_ID)
VALUES
  ( 2, '', '', '', '', '지한1', 10, 0);

INSERT INTO dbo.MEMBER
  ( age, createdDate, description, lastModifiedDate, ROLE_TYPE, NAME, TEAM_ID, LOCKER_ID)
VALUES
  ( 2, '', '', '', '', '지한2', 10, 0);

  
INSERT INTO dbo.TEAM
  ( TEAM_NAME)
VALUES
  ( 'TEAM1');

INSERT INTO dbo.TEAM
  ( TEAM_NAME)
VALUES
  ( 'TEAM1');

INSERT INTO dbo.TEAM
  ( TEAM_NAME)
VALUES
  ( 'TEAM2');

INSERT INTO dbo.TEAM
  ( TEAM_NAME)
VALUES
  ( 'TEAM1');

INSERT INTO dbo.TEAM
  ( TEAM_NAME)
VALUES
  ( 'TEAM1');

INSERT INTO dbo.TEAM
  ( TEAM_NAME)
VALUES
  ( 'TEAM1');

INSERT INTO dbo.TEAM
  ( TEAM_NAME)
VALUES
  ( 'TEAM1');

