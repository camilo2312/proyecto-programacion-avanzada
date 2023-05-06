insert into usuario values ('1094923724', '1234', 'dannynacio@gmail.com', 'ACTIVO', 'Daniel Esteban', 'dtusarma', '3206768686',0);




insert into usuario values ('1099233413', 'Juan Camilo Ramos Rodriguez', '3116178594', 'juanc.ramosr@uqvirtual.com',
                            'Mago', '1234567890', 'ACTIVO', 120, 'circasia quindio');
insert into usuario values ('1098123651', 'Orlando Narvaez Baracaldo', '3168669742', 'chachonarvaez@gmail.com',
                            'Chacho', '0987654321', 'INACTIVO', 15, 'Barrio la pavona mz 11 c # 12');
insert into usuario values ('1094936382', 'Julian Andres Quiroga Ballen', '3128190284', 'tazmania@.com',
                            'Taz', 'taz123', 'ACTIVO', 20, 'Barrio montevideo mz 5 casa # 4');
insert into usuario values ('1101237842', 'Jose Andres Monsalve', '3117842291', 'joseam@gmail.com',
                            'mM0012', '0oo00123', 'INACTIVO', 112, 'barrio la nueva tebaida');

-- direccion (codigo, descripcion, codigopostal)

insert into direccion (codigo_postal, descripcion, moderador_cedula, usuario_cedula) values (6000, 'Calle 123, Bogota', '', '1101237842');

insert into direccion (codigo_postal, descripcion, moderador_cedula, usuario_cedula) values (6000, 'Avenida 44 N  n 33', '', '1101237842');

insert into direccion (codigo_postal, descripcion, moderador_cedula, usuario_cedula) values (6000, 'Calle 12 # 23', '', '1101237842');

insert into direccion (codigo_postal, descripcion, moderador_cedula, usuario_cedula) values (6000, 'Avenida del rio c # 12 Pereira', '', '1101237842');

insert into direccion (codigo_postal, descripcion, moderador_cedula, usuario_cedula) values (6000, 'Ruta 34, Sector 12', '', '1101237842')





--moderador (cedula, nombre_completo, email, numero_telefono, nombre_usuario, contrasena, estado, direccion)

    insert into moderador values (111111111, 'Juan Pérez', 'juan.perez@gmail.com', '1234567890', 'juanperez', '0o0o0o0o', 'ACTIVO', 'Calle 123, Bogota');

insert into moderador values (222222222, 'María González', 'maria.gonzalez@gmail.com', '9876543210', 'mariagonzalez', 'd467dgt', 'INACTIVO', 'Avenida 44 N  n 33');

insert into moderador values (333333333, 'Carlos Ramírez', 'carlos.ramirez@gmail.com', '5555555555', 'carlosramirez', '112234fg', 'ACTIVO', 'Calle 12 # 23');

insert into moderador values (444444444, 'Ana Torres', 'ana.torres@gmail.com', '1111111111', 'anatorres', 'fg33.lAD', 'INACTIVO', 'Avenida del rio c # 12 Pereira');

insert into moderador values (555555555, 'Pedro Silva', 'pedro.silva@gmail.com', '9999999999', 'pedrosilva', 'lisj230098', 'ACTIVO', 'Ruta 34, Sector 12');



--promocion (Idcupon, porcentajedescuento, fechainicio, fechafin)

insert into promocion values (1, 10.5, '2023-04-23', '2023-05-23');

insert into promocion values (2, 15.25, '2023-04-24', '2023-05-24');

insert into promocion values (3, 20.0, '2023-04-25', '2023-05-25');

insert into promocion values (4, 12.75, '2023-04-26', '2023-05-26');

insert into promocion values (5, 8.99, '2023-04-27', '2023-05-27');


--producto (codigo, nombre, descripcion, precio, disponibilidad, fechavencimiento, fechapublicacion, estado, idCupon)

insert into producto values (1, 'Celular Samsung Galaxy A13 128GB', 'El mejor celular del mercado en el momento', 645000.00, 10, '2023-06-30', '2023-04-23', 'ACTIVO', 1);

insert into producto values (2, 'Televisor LG 42 pulgadas', 'El mejor televisor para las reuniones familares', 1200000.00, 5, '2023-07-31', '2023-04-23', 'ACTIVO', 2);

insert into producto values (3, 'Nevera Haceb de 400 L no frost', 'Con la ultima tecnologia para conservar tus alimentos', 2200000.00, 0, '2023-08-31', '2023-04-23', 'INACTIVO', 1);

insert into producto values (4, 'freidora de aire Oster 3L','Para cocinar tus alimentos libres de grasas', 240000.00, 15, '2023-09-30', '2023-04-23', 'ACTIVO', 3);

insert into producto values (5, 'Computador portatil Hp 14 pulgadas intel core I5 8 GB RAM', 'Multifuncional y potente para realizar tus trabajos del dia', 2200000.00, 8, '2023-10-31', '2023-04-23', 'ACTIVO', 4);



-- comentario (codigo, descripcion, fechacreacion, idusuario, idproducto)

insert into comentario values (1, 'Producto de excelente calidad', '2023-04-23', 1, 1);

insert into comentario values (2, 'El mejor producto que exixte de todos', '2023-04-23', 2, 1);

insert into comentario values (3, 'El producto se demoro mucho para llegar', '2023-04-23', 3, 2);

insert into comentario values (4, 'La calidad excelente, recomendado', '2023-04-23', 4, 3);

insert into comentario values (5, 'Llega con las especificaciones mostradas y muy rapida la entrega', '2023-04-23', 5, 4);



-- compra (codigo, fechacreacion, precioTotal, mediopago, estadocompra, codigoUsuario, direccion)

insert into compra values (1, '2023-04-23', 50000.00, 'EFECTY', 'APROBADA', 1094923724, 'Finca el cofre corregimiento el caimo');

insert into compra values (2, '2023-04-23', 75000.00, 'EFECTIVO', 'RECHAZADA', 1094923724, 'Finca el cofre corregimiento el caimo');

insert into compra values (3, '2023-04-23', 100000.00, 'TRANSFERENCIA', 'APROBADA', 1099233413, 'circasia quindio');

insert into compra values (4, '2023-04-23', 25000.00, 'EFECTIVO', 'CANCELADA', 1098123651, 'Barrio la pavona mz 11 c # 12');

insert into compra values (5, '2023-04-23', 80000.00, 'EFECTIVO', 'APROBADA', 1099233413, 'circasia quindio');



-- detallecompra (codigo, unidades, precioProducto, codigoProducto, codigoCompra)
insert into detallecompra values (1, 10, 50000.00, 1, 1);

insert into detallecompra values (2, 5, 75000.00, 2, 2);

insert into detallecompra values (3, 8, 60000.00, 3, 4);

insert into detallecompra values (4, 15, 45000.00, 4, 3);

insert into detallecompra values (5, 20, 80000.00, 5, 5);


-- usuarioproducto (codigo, unidades, precioProducto, codigoProducto, codigoCompra)

insert into usuarioproducto values (1, 2);

insert into usuarioproducto values (2, 4);

insert into usuarioproducto values (3, 5);

insert into usuarioproducto values (1, 3);

insert into usuarioproducto values (5, 1);



-- productocategoria (codigo, unidades, precioProducto, codigoProducto, codigoCompra)

insert into productocategoria values (3, 2);

insert into productocategoria values (2, 1);

insert into productocategoria values (4, 4);

insert into productocategoria values (5, 3);

insert into productocategoria values (1, 5);



-- moderadorproducto (moderadorCodigo, productoCodigo, estado)

insert into moderadorproducto values (1, 2, 'ACTIVO');

insert into moderadorproducto values (3, 2, 'ACTIVO');

insert into moderadorproducto values (2, 5, 'INACTIVO');

insert into moderadorproducto values (5, 1, 'ACTIVO');

insert into moderadorproducto values (4, 4, 'ACTIVO');



-- moderadorproducto (codigoImagenURL, productoCodigo, comentarioCodigo)

insert into imagen values (1, 2, 1);

insert into imagen values (2, 2, 4);

insert into imagen values (3, 4, 2);

insert into imagen values (4, 1, 5);

insert into imagen values (5, 5, 3);
