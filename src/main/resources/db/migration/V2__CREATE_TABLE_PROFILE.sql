CREATE TABLE storcars.profile (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    thumbnail VARCHAR(255),
    createAt DATETIME,
    updateAt DATETIME,
    CONSTRAINT profile_to_user_fk
    FOREIGN KEY (user_id)
    REFERENCES storcars.user (id)
);