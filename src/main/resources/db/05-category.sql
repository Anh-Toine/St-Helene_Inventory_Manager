DROP TABLE IF EXISTS category;

CREATE TABLE IF NOT EXISTS category (
    id INT(4) AUTO_INCREMENT PRIMARY KEY,
    category_id VARCHAR(36) UNIQUE ,
    category_name VARCHAR(255),
    taxable BOOL,
    tax DOUBLE
) engine=InnoDB;