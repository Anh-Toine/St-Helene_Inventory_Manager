DROP TABLE IF EXISTS product;

CREATE TABLE IF NOT EXISTS product (
    product_id INT(4) AUTO_INCREMENT PRIMARY KEY,
    bar_code INT(100),
    brand VARCHAR(255),
    category_id INT(100),
    price DOUBLE,
    product_name VARCHAR(255),
    quantity INT(100),
    quantity_sold INT(100)
) engine=InnoDB;