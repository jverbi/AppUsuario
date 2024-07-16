CREATE TABLE autorizacion(
   id bigint NOT NULL auto_increment,
   login varchar(100) NOT NULL,
   clave varchar(300) NOT NULL,

   PRIMARY KEY(id)
);