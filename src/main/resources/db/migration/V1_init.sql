CREATE DATABASE IF NOT EXISTS nombre_de_tu_base_de_datos;


CREATE TABLE IF NOT EXISTS country (
id INT PRIMARY KEY AUTO_INCREMENT,
code VARCHAR(10) UNIQUE NOT NULL,
country_name VARCHAR(100) NOT NULL,
continent_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS user (
id INT PRIMARY KEY AUTO_INCREMENT,
fullname VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
gender VARCHAR(10) NOT NULL,
date_of_birth DATE NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
country_id INT,
FOREIGN KEY (country_id) REFERENCES country(id)
    );

CREATE TABLE IF NOT EXISTS merchant (
                                        id INT PRIMARY KEY AUTO_INCREMENT,
                                        merchant_name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    admin_id INT NOT NULL,
    country_id INT,
    FOREIGN KEY (country_id) REFERENCES country(id)
    );

CREATE TABLE IF NOT EXISTS product (
                                       id INT PRIMARY KEY AUTO_INCREMENT,
                                       description VARCHAR(255) NOT NULL,
    merchant_id INT,
    price DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (merchant_id) REFERENCES merchant(id)
    );

CREATE TABLE IF NOT EXISTS order_table (
    id INT PRIMARY KEY AUTO_INCREMENT,
     status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES user(id)
    );

CREATE TABLE IF NOT EXISTS order_item (
    id INT PRIMARY KEY AUTO_INCREMENT,
    quantity INT NOT NULL,
    order_id INT,
     product_id INT,
    FOREIGN KEY (order_id) REFERENCES order_table(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
    );
