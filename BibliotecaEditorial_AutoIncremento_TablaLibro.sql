-- Crear secuencia para Libro
CREATE SEQUENCE libro_seq START WITH 1 INCREMENT BY 1;

-- Crear tabla Libro
CREATE TABLE Libro (
    LibroID NUMBER DEFAULT libro_seq.NEXTVAL PRIMARY KEY,
    AutorID NUMBER,
    CategoriaID NUMBER,
    Titulo VARCHAR2(255),
    Anio NUMBER
);

-- Consultar si la secuencia para Libro se creó exitosamente
SELECT sequence_name FROM user_sequences WHERE sequence_name = 'LIBRO_SEQ';

-- Insertar un registro en la tabla Libro
INSERT INTO Libro (AutorID, CategoriaID, Titulo, Anio)
VALUES (1, 1, 'Título del Libro', 2023);

-- Modificar la columna LibroID para usar la secuencia
ALTER TABLE Libro MODIFY LibroID NUMBER DEFAULT libro_seq.NEXTVAL;

-- Si deseas que LibroID sea clave primaria y se genere automáticamente, utiliza este comando
ALTER TABLE Libro
MODIFY LibroID NUMBER DEFAULT libro_seq.NEXTVAL;

INSERT INTO Libro (AutorID, CategoriaID, Titulo, Anio)
VALUES (?, ?, ?, ?);

ALTER TABLE Libro RENAME COLUMN anio TO año;
