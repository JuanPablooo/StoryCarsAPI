CREATE TABLE profile (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    thumbnail VARCHAR(255),
    create_at DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW(),
    update_at DATETIME  NOT NULL DEFAULT NOW(),
    CONSTRAINT profile_to_user_fk
    FOREIGN KEY (user_id)
    REFERENCES storcars.user (id)
);