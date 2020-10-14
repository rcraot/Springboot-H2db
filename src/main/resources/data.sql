DROP TABLE IF EXISTS product;
CREATE TABLE IF NOT EXISTS product (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255)
);
INSERT INTO product (id, name, description) VALUES (1, 'Samsung S5', 'Smart Phone');
INSERT INTO product (id, name, description) values(2, 'Whirlpool', 'refregerator');
INSERT INTO product (id, name, description) values(3, 'Sony Bravo', 'LED Television');
INSERT INTO product (id, name, description) values(4, 'Lenovo', 'Digtal Book');
INSERT INTO product (id, name, description) values(5, 'Phillips', 'Head phones');
INSERT INTO product (id, name, description) values(6, 'Hyundai', 'Car, Hatch-back');
INSERT INTO product (id, name, description) values(7, 'Boing', 'Aircraft');