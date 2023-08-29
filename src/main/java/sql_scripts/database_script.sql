CREATE TABLE user (
    email VARCHAR(100) PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    password VARCHAR(100)
);

CREATE TABLE farm (
    location VARCHAR(100),
    description TEXT,
    image LONGBLOB,
    farm_size VARCHAR(5),
    status VARCHAR(50) CHECK(status IN('RENT', 'PURCHASE')),
    contact VARCHAR(100)
)