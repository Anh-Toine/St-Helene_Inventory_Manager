DROP TABLE IF EXISTS category;

CREATE TABLE IF NOT EXISTS category (
    category_id INT(4) AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255),
    taxable BOOL,
    tax DOUBLE
) engine=InnoDB;