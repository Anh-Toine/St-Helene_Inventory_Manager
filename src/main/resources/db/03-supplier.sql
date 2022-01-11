DROP TABLE IF EXISTS supplier;

CREATE TABLE IF NOT EXISTS supplier(
    supplier_id INT PRIMARY KEY AUTO_INCREMENT,
    supplier_name VARCHAR(255),
    representative_name VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(255)
)engine=InnoDB;


