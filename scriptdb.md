CREATE DATABASE belton_gym;

use belton_gym;

INSERT INTO user_type (id, name) VALUES
(UUID(), 'Administrador'),
(UUID(), 'Entrenador'),
(UUID(), 'Cliente');	

-- Usuarios
INSERT INTO user (document, regis_date, user_type_id, address, email, password, lastname, name, tel) 
SELECT 12345678, '2024-03-01', ut.id, 'Calle 1 #12-34', 'admin@gym.com', '$2a$12$5U.3ha5W7DcrKtAslh67IuDPc7Zc4wOsV1BcAy8QwV6LPOKIg19.i', 'Pérez', 'Carlos', '3001234567'
FROM user_type ut WHERE ut.name = 'Administrador'
UNION ALL
SELECT 87654321, '2024-03-02', ut.id, 'Calle 2 #23-45', 'coach@gym.com', '$2a$12$OXIERktQMEzX7wBr04Xj/.Tfy8mmnL0J6xGGfh1etj7Gyb1ywRMRa', 'López', 'Ana', '3017654321'
FROM user_type ut WHERE ut.name = 'Entrenador'
UNION ALL
SELECT 56781234, '2024-03-03', ut.id, 'Calle 3 #34-56', 'client@gym.com', '$2a$12$UpvrIKgzJzHX9euB9mG18eYoEve37DzDM1uUo53dAorMpPF0Wg8J6', 'Gómez', 'Luis', '3023456789'
FROM user_type ut WHERE ut.name = 'Cliente';

-- Asistencia
INSERT INTO attendance (id, entry_time, exit_time, user_id, comment)
SELECT UUID(), '2024-03-10 08:00:00', '2024-03-10 10:00:00', u.id, 'Sesión de entrenamiento'
FROM user u WHERE u.document = 56781234;

-- Tipos de membresía
INSERT INTO membership_type (id, name) VALUES
(UUID(), 'Mensual'),
(UUID(), 'Trimestral'),
(UUID(), 'Anual');

-- Membresías
INSERT INTO membership (id, start_date, end_date, membership_type_id, user_id, comment)
SELECT UUID(), '2024-03-01', '2024-06-01', mt.id, u.id, 'Membresía renovada'
FROM membership_type mt, user u
WHERE mt.name = 'Trimestral' AND u.document = 56781234;

-- Productos
INSERT INTO product (id, price, stock, description, name) VALUES
(UUID(), 150000, 10, 'Proteína en polvo', 'Proteína Whey'),
(UUID(), 50000, 20, 'Guantes para gimnasio', 'Guantes Deportivos');

-- Proveedores
INSERT INTO supplier (id, phone, email, name) VALUES
(UUID(), 3101234567, 'proveedor@suplementos.com', 'Suplementos Gym');

-- Compras a proveedores
INSERT INTO supplier_purchase (id, date, total, supplier_id)
SELECT UUID(), '2024-03-05', 500000, s.id
FROM supplier s WHERE s.name = 'Suplementos Gym';

-- Detalles de compra a proveedores
INSERT INTO purchase_detail (id, quantity, product_id, purchase_id)
SELECT UUID(), 5, p.id, sp.id
FROM product p, supplier_purchase sp
WHERE p.name = 'Proteína Whey' AND sp.total = 500000;

-- Ventas
INSERT INTO sales (id, date, total, user_id)
SELECT UUID(), '2024-03-06', 150000, u.id
FROM user u WHERE u.document = 56781234;

-- Detalles de venta
INSERT INTO sale_detail (id, quantity, product_id, sale_id)
SELECT UUID(), 1, p.id, s.id
FROM product p, sales s
WHERE p.name = 'Proteína Whey' AND s.total = 150000;