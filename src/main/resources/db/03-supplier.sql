DROP TABLE IF EXISTS supplier;

CREATE TABLE IF NOT EXISTS supplier(
    supplier_id INT PRIMARY KEY AUTO_INCREMENT,
    supplier_name VARCHAR(255) UNIQUE,
    representative_name VARCHAR(255) UNIQUE,
    email VARCHAR(255) UNIQUE,
    phone_number VARCHAR(255) UNIQUE
)engine=InnoDB;


