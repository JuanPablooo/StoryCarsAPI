CREATE TABLE type_profile (
    user_id INT  NOT NULL,
    profile_types INTEGER,
    CONSTRAINT type_profile_of_user_fk
    FOREIGN KEY (user_id)
    REFERENCES user (id)
);