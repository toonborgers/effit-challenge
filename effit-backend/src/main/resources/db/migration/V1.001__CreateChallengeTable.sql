CREATE TABLE CHALLENGE(
    ID UUID NOT NULL PRIMARY KEY,
    NAME VARCHAR(50) NOT NULL,
    POINTS INT NOT NULL,
    DESCRIPTION VARCHAR(255)
);