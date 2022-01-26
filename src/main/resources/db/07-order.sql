DROP TABLE IF EXISTS `order`;

CREATE TABLE IF NOT EXISTS `order`(
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id VARCHAR(255) UNIQUE,
    order_date VARCHAR(255),
    received BOOL,
    payed BOOL,
    supplier_id INT,
    FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id)
               ON DELETE CASCADE
)engine=InnoDB;