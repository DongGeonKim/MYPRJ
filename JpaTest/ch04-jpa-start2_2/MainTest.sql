DELETE MEMBER;
DELETE TEAM;

SELECT * FROM MEMBER;
SELECT * FROM TEAM;

DROP table MEMBER; 
DROP table TEAM;

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