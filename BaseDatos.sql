USE clientes;

create table persona(
  idPersona int auto_increment primary key,
  nombre varchar(100),  
  genero varchar(15),
  edad int,
  direccion varchar(200),
  telefono varchar(150)
);

create table cliente(  
  idCliente int auto_increment primary key,
  idPersona int not null,
  contrasenia varchar(100),
  estado smallint,
  foreign key (idPersona) references persona(idPersona)
);

create table cuenta(
  numeroCuenta int auto_increment primary key,
  tipoCuenta varchar(10),
  saldoInicial decimal(14,2),
  saldoActual decimal(14,2),
  estado smallint,
  idCliente int,
  foreign key (idCliente) references cliente(idCliente)
);

create table movimiento(
  idMovimiento int auto_increment primary key,
  numeroCuenta int,
  fechaMovimiento datetime,
  valor decimal(14,2),
  saldo decimal(14,2),
  foreign key(numeroCuenta) references cuenta(numeroCuenta)
);
  