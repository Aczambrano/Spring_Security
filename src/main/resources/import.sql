-- contraseñas: clave123,clave456 y clave789

INSERT INTO usuario (username, name, password, role) VALUES ('lmarquez', 'luis márquez', '$2a$10$PJY1BpiHHoKEBQW9EOl3AOh96/EyIHafv3pp3TIe6TUuEXSdUvqp6', 'ROLE_CUSTOMER');
INSERT INTO usuario (username, name, password, role) VALUES ('fperez', 'fulano pérez', '$2a$10$XCkL6/GvKmro2oIxxokPjelFlGv9mmamKD1vJtENd4j1HpuelZOai', 'ROLE_ASSISTANT_ADMINISTRATOR');
INSERT INTO usuario (username, name, password, role) VALUES ('mhernandez', 'mengano hernández', '$2a$10$8z8Ar2tRiH0PpuQqgiL1Pend4kvVu/R.jOttjv0W8NkR187phwRcy', 'ROLE_ADMINISTRATOR');


-- CREACIÓN DE CATEGORIAS
INSERT INTO category (name, status) VALUES ('Electrónica', 'ENABLED');
INSERT INTO category (name, status) VALUES ('Ropa', 'ENABLED');
INSERT INTO category (name, status) VALUES ('Deportes', 'ENABLED');
INSERT INTO category (name, status) VALUES ('Hogar', 'ENABLED');

-- CREACIÓN DE PRODUCTOS
INSERT INTO product (name, price, status, category_id) VALUES ('Smartphone', 500.00, 'ENABLED', 1);
INSERT INTO product (name, price, status, category_id) VALUES ('Auriculares Bluetooth', 50.00, 'DISABLED', 1);
INSERT INTO product (name, price, status, category_id) VALUES ('Tablet', 300.00, 'ENABLED', 1);

INSERT INTO product (name, price, status, category_id) VALUES ('Camiseta', 25.00, 'ENABLED', 2);
INSERT INTO product (name, price, status, category_id) VALUES ('Pantalones', 35.00, 'ENABLED', 2);
INSERT INTO product (name, price, status, category_id) VALUES ('Zapatos', 45.00, 'ENABLED', 2);

INSERT INTO product (name, price, status, category_id) VALUES ('Balón de Fútbol', 20.00, 'ENABLED', 3);
INSERT INTO product (name, price, status, category_id) VALUES ('Raqueta de Tenis', 80.00, 'DISABLED', 3);

INSERT INTO product (name, price, status, category_id) VALUES ('Aspiradora', 120.00, 'ENABLED', 4);
INSERT INTO product (name, price, status, category_id) VALUES ('Licuadora', 50.00, 'ENABLED', 4);