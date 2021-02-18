CREATE TABLE merchants(id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30), description VARCHAR(60));
    
CREATE TABLE offers(id BIGINT PRIMARY KEY AUTO_INCREMENT,
    merchant_id BIGINT NOT NULL, status VARCHAR NOT NULL, description VARCHAR(30),
    validityInMinutes INT, currency VARCHAR(3),price DECIMAL, createDateTime TIMESTAMP,
    CONSTRAINT fk_merchant_offer FOREIGN KEY(merchant_id) references merchants(id));    