CREATE TABLE vehicle(
    id INT AUTO_INCREMENT PRIMARY KEY,
    create_at DATETIME NOT NULL DEFAULT NOW(),
    update_at DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW(),
    name VARCHAR(100) NOT NULL,
    thumbnail VARCHAR(250),
    description VARCHAR(250),
    year VARCHAR(12),
    price  DOUBLE,
    type varchar(250)
);