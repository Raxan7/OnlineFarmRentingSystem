CREATE TABLE user (
    email VARCHAR(100) PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    password VARCHAR(100),
    user_type VARCHAR(20) CHECK(user_type IN('ADMINISTRATOR', 'BUYER', 'SELLER'))
);

CREATE TABLE farm (
	id INT AUTO_INCREMENT PRIMARY KEY,
    location VARCHAR(100),
    description TEXT,
    image LONGBLOB,
    farm_size VARCHAR(5) NOT NULL,
    farm_price VARCHAR(100) NOT NULL,
    status VARCHAR(50) CHECK(status IN('RENT', 'PURCHASE')),
    sales_status VARCHAR(50) CHECK(sales_status IN('AVAILABLE', 'SOLD')),
    contact VARCHAR(100),
    owner VARCHAR (100) NOT NULL,
    FOREIGN KEY (owner) 
    REFERENCES user(email),
    buyer_id VARCHAR(100),
    FOREIGN KEY (buyer_id) 
    REFERENCES user(email)
);