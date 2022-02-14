DROP TABLE IF EXISTS orders;

CREATE TABLE IF NOT EXISTS orders(
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id VARCHAR(255) UNIQUE,
    order_date VARCHAR(255),
    received BOOL,
    payed BOOL,
    supplier_id VARCHAR(255)
)engine=InnoDB;