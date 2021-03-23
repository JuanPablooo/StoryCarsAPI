CREATE TABLE image (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    url VARCHAR(300)
);

CREATE TABLE image_vehicle (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    image_id INT NOT NULL,
    vehicle_id INT NOT NULL,
    CONSTRAINT image_to_vehicle_fk
       FOREIGN KEY (image_id)
       REFERENCES image(id),
    CONSTRAINT vehicle_to_image_fk
     FOREIGN KEY (vehicle_id)
       REFERENCES vehicle(id)
);

