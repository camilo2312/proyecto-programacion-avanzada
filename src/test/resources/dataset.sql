--usuario (cedula, nombre_completo, telefono, email, nombreusuario, contraseña, estado, puntosacululados, direccion)

insert into usuario values (1094923724, "Daniel Esteban Tusarma Guerrero", "3206768686", "dannynacio@gmail.com",
                            "Tusarman", "d4n73l", "ACTIVO", 210, "Finca el cofre corregimiento el caimo");
insert into usuario values (1099233413, "Juan Camilo Ramos Rodriguez", "3116178594", "juanc.ramosr@uqvirtual.com",
                            "Mago", "1234567890", "ACTIVO", 120, "circasia quindio");
insert into usuario values (1098123651, "Orlando Narvaez Baracaldo", "3168669742", "chachonarvaez@gmail.com",
                            "Chacho", "0987654321", "INACTIVO", 15, "Barrio la pavona mz 11 c # 12");
insert into usuario values (1094936382, "Julian Andres Quiroga Ballen", "3128190284", "tazmania@.com",
                            "Taz", "taz123", "ACTIVO", 20, "Barrio montevideo mz 5 casa # 4");
insert into usuario values (1101237842, "Jose Andres Monsalve", "3117842291", "joseam@gmail.com",
                            "mM0012", "0oo00123", "INACTIVO", 112, "barrio la nueva tebaida");



--moderador (cedula, nombre_completo, email, numero_telefono, nombre_usuario, contrasena, estado, direccion)

insert into moderador values (111111111, "Juan Pérez", "juan.perez@gmail.com", "1234567890", "juanperez", "0o0o0o0o", "ACTIVO", "Calle 123, Bogota");

insert into moderador values (222222222, "María González", "maria.gonzalez@gmail.com", "9876543210", "mariagonzalez", "d467dgt", "INACTIVO", "Avenida 44 N  n 33");

insert into moderador values (333333333, "Carlos Ramírez", "carlos.ramirez@gmail.com", "5555555555", "carlosramirez", "112234fg", "ACTIVO", "Calle 12 # 23");

insert into moderador values (444444444, "Ana Torres", "ana.torres@gmail.com", "1111111111", "anatorres", "fg33.lAD", "INACTIVO", "Avenida del rio c # 12 Pereira");

insert into moderador values (555555555, "Pedro Silva", "pedro.silva@gmail.com", "9999999999", "pedrosilva", "lisj230098", "ACTIVO", "Ruta 34, Sector 12");



--promocion (Idcupon, porcentajedescuento, fechainicio, fechafin)

insert into promocion values (1, 10.5, '2023-04-23', '2023-05-23');

insert into promocion values (2, 15.25, '2023-04-24', '2023-05-24');

insert into promocion values (3, 20.0, '2023-04-25', '2023-05-25');

insert into promocion values (4, 12.75, '2023-04-26', '2023-05-26');

insert into promocion values (5, 8.99, '2023-04-27', '2023-05-27');


--producto (codigo, nombre, descripcion, precio, disponibilidad, fechavencimiento, fechapublicacion, estado, idCupon)

insert into producto values (1, "Celular Samsung Galaxy A13 128GB", "El mejor celular del mercado en el momento", 645000.00, 10, '2023-06-30', '2023-04-23', "ACTIVO", 1);

insert into producto values (2, "Televisor LG 42 pulgadas", "El mejor televisor para las reuniones familares", 1200000.00, 5, '2023-07-31', '2023-04-23', "ACTIVO", 2);

insert into producto values (3, "Nevera Haceb de 400 L no frost", "Con la ultima tecnologia para conservar tus alimentos", 2200000.00, 0, '2023-08-31', '2023-04-23', 'INACTIVO', 1);

insert into producto values (4, "freidora de aire Oster 3L","Para cocinar tus alimentos libres de grasas", 240000.00, 15, '2023-09-30', '2023-04-23', 'ACTIVO', 3);

insert into producto values (5, "Computador portatil Hp 14 pulgadas intel core I5 8 GB RAM", "Multifuncional y potente para realizar tus trabajos del dia", 2200000.00, 8, '2023-10-31', '2023-04-23', 'ACTIVO', 4);


-- direccion (codigo, descripcion, codigopostal)

insert into direccion values (1, "El caimo Armenia Quindio", 12345);

insert into direccion values (2, "Circasia Quindio", 67890);

insert into direccion values (3, "Ibague Tolima", 54321);

insert into direccion values (4, "La tebaida Quindio", 98765);

insert into direccion values (5, "Barrio la grecia mz 3 casa # 7",12345)
