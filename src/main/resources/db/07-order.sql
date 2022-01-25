DROP TABLE IF EXISTS order;
CREATE TABLE order(
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    order_date VARCHAR(255),
    received BOOL,
    payed BOOL,
    supplier_id INT,
    FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id)
               ON DELETE CASCADE
)engine=InnoDB;