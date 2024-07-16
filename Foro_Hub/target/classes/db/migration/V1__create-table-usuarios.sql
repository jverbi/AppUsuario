CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL UNIQUE,
    mensaje VARCHAR(500) NOT NULL UNIQUE,
    fecha_de_creacion VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    facultad VARCHAR(50) NOT NULL,
    curso VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

