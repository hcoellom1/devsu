USE clientes;

create table persona(
  id_persona int auto_increment primary key,
  nombre varchar(100),  
  genero varchar(15),
  edad int,
  direccion varchar(200),
  telefono varchar(150)
);

create table cliente(  
  id_cliente int auto_increment primary key,
  id_persona int not null,
  contrasenia varchar(100),
  estado smallint,
  foreign key (id_persona) references persona(id_persona)
);

create table cuenta(
  numero_cuenta int auto_increment primary key,
  tipo_cuenta varchar(10),
  saldo_inicial decimal(14,2),  
  estado smallint,
  id_cliente int,
  foreign key (id_cliente) references cliente(id_cliente)
);

create table movimiento(
  id_movimiento int auto_increment primary key,
  numero_cuenta int,
  fecha_movimiento datetime,
  valor decimal(14,2),
  saldo decimal(14,2),
  foreign key(numero_cuenta) references cuenta(numero_cuenta)
);
  