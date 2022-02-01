DROP TABLE IF EXISTS user_roles;

CREATE TABLE IF NOT EXISTS user_roles (
    user_id INT(4),
    role_id INT(4)
) engine=InnoDB;