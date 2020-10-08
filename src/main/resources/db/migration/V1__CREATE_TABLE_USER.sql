CREATE TABLE storcars.user (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    createAt DATETIME,
    updateAt DATETIME
);