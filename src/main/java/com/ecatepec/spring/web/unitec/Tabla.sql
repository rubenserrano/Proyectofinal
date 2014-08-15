create table usuario (id_usuario integer primary key
                  auto_increment,
                nombre varchar(80),
                sueldo float);



create table nomina (id_nomina integer auto_increment primary key, saldo float,id_usuario integer,
                     constraint foreign key(id_usuario) references usuario(id_usuario));

create table datos (id_datos integer auto_increment primary key, aPaterno varchar(80),aMaterno varchar(80),id_nomina integer,
                     constraint foreign key(id_nomina) references nomina(id_nomina));
