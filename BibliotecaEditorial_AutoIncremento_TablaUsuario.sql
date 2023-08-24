CREATE SEQUENCE usuario_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE Usuario (
    UsuarioID NUMBER DEFAULT usuario_seq.NEXTVAL PRIMARY KEY,
    NombreUsuario VARCHAR2(255),
    DireccionUsuario VARCHAR2(255),
    IdentificacionUsuario VARCHAR2(255)
);

SELECT sequence_name FROM user_sequences WHERE sequence_name = 'USUARIO_SEQ';

DROP TABLE USUARIO

INSERT INTO Usuario (NombreUsuario, DireccionUsuario, IdentificacionUsuario)
VALUES ('Nombre del Usuario', 'Dirección del Usuario', 'Identificación del Usuario');

ALTER TABLE "EFINAL"."USUARIO" MODIFY "USUARIOID" NUMBER DEFAULT usuario_seq.NEXTVAL PRIMARY KEY;

ALTER TABLE "EFINAL"."USUARIO"
MODIFY "USUARIOID" NUMBER DEFAULT usuario_seq.NEXTVAL;
