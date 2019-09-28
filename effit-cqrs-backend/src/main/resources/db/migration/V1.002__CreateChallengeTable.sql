CREATE TABLE CHALLENGE(
    ID UUID NOT NULL PRIMARY KEY,
    FK_COMPETITION_ID UUID REFERENCES COMPETITION(ID),
    NAME VARCHAR(50) NOT NULL,
    POINTS INT NOT NULL,
    DESCRIPTION VARCHAR(255)
);
