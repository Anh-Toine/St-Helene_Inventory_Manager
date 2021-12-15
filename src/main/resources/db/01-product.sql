DROP TABLE IF EXISTS product;

CREATE TABLE IF NOT EXISTS product (
    productId INT(4) AUTO_INCREMENT PRIMARY KEY,
    barCode INT(100),
    brand VARCHAR(255),
    categoryId INT(100),
    price DOUBLE,
    productName VARCHAR(255),
    quantity INT(100),
    quantitySold INT(100)
) engine=InnoDB;