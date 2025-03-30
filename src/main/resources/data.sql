-- tipos de usuario
INSERT INTO `user_type` (id, name) VALUES
(UUID(), 'Administrador'),
(UUID(), 'Entrenador'),
(UUID(), 'Cliente');

-- usuarios
INSERT INTO `user` (id, document, regis_date, user_type_id, address, email, lastname, name, tel) VALUES
(UUID(), 12345678, '2024-03-01', (SELECT id FROM `user_type` WHERE name='Administrador'), 'Calle 1 #12-34', 'admin@gym.com', 'Pérez', 'Carlos', '3001234567'),
(UUID(), 87654321, '2024-03-02', (SELECT id FROM `user_type` WHERE name='Entrenador'), 'Calle 2 #23-45', 'coach@gym.com', 'López', 'Ana', '3017654321'),
(UUID(), 56781234, '2024-03-03', (SELECT id FROM `user_type` WHERE name='Cliente'), 'Calle 3 #34-56', 'client@gym.com', 'Gómez', 'Luis', '3023456789');

-- asistencia
INSERT INTO `attendance` (id, entry_time, exit_time, user_id, comment) VALUES
(UUID(), '2024-03-10 08:00:00', '2024-03-10 10:00:00', (SELECT id FROM `user` WHERE name='Luis'), 'Sesión de entrenamiento');

-- Insertando tipos de membresía
INSERT INTO `membership_type` (id, name) VALUES
(UUID(), 'Mensual'),
(UUID(), 'Trimestral'),
(UUID(), 'Anual');

-- membresías
INSERT INTO `membership` (id, start_date, end_date, membership_type_id, user_id, comment) VALUES
(UUID(), '2024-03-01', '2024-06-01', (SELECT id FROM `membership_type` WHERE name='Trimestral'), (SELECT id FROM `user` WHERE name='Luis'), 'Membresía renovada');

-- productos
INSERT INTO `product` (id, price, stock, description, name) VALUES
(UUID(), 150000, 10, 'Proteína en polvo', 'Proteína Whey'),
(UUID(), 50000, 20, 'Guantes para gimnasio', 'Guantes Deportivos');

-- proveedores
INSERT INTO `supplier` (id, phone, email, name) VALUES
(UUID(), 3101234567, 'proveedor@suplementos.com', 'Suplementos Gym');

-- compras a proveedores
INSERT INTO `supplier_purchase` (id, date, total, supplier_id) VALUES
(UUID(), '2024-03-05', 500000, (SELECT id FROM `supplier` WHERE name='Suplementos Gym'));

-- detalles de compra a proveedores
INSERT INTO `purchase_detail` (id, quantity, product_id, purchase_id) VALUES
(UUID(), 5, (SELECT id FROM `product` WHERE name='Proteína Whey'), (SELECT id FROM `supplier_purchase` WHERE total=500000));

-- ventas
INSERT INTO `sales` (id, date, total, user_id) VALUES
(UUID(), '2024-03-06', 150000, (SELECT id FROM `user` WHERE name='Luis'));

-- detalles de venta
INSERT INTO `sale_detail` (id, quantity, product_id, sale_id) VALUES
(UUID(), 1, (SELECT id FROM `product` WHERE name='Proteína Whey'), (SELECT id FROM `sales` WHERE total=150000));

