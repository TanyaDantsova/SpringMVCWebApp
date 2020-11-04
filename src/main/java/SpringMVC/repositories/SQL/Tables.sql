
CREATE TABLE Users
(
    Id       INT         NOT NULL auto_increment,
    Login    VARCHAR(15) NOT NULL UNIQUE,
    Password VARCHAR(15) NOT NULL,
    PRIMARY KEY (Id)
);

CREATE TABLE Orders
(
    Id          INT    NOT NULL AUTO_INCREMENT,
    Id_user     INT    NOT NULL,
    Total_price DOUBLE NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (Id_user) REFERENCES Users (Id)
);

CREATE TABLE Goods
(
    Id    INT         NOT NULL AUTO_INCREMENT,
    Title VARCHAR(15) NOT NULL UNIQUE,
    Price DOUBLE      NOT NULL,
    PRIMARY KEY (Id)
);

CREATE TABLE Orders_Goods
(
    Id       INT NOT NULL AUTO_INCREMENT,
    Id_Good  INT NOT NULL,
    Id_Order INT NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (Id_Good) REFERENCES Goods (Id),
    FOREIGN KEY (Id_Order) REFERENCES Orders (Id)
);