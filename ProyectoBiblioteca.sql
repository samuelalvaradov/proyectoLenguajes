--------------------------------------------------------
-- Archivo creado  - jueves-julio-20-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table AUTOR
--------------------------------------------------------

  CREATE TABLE "BIBLIOTECA"."AUTOR" 
   (	"AUTORID" NUMBER, 
	"NOMBREAUTOR" VARCHAR2(100 BYTE), 
	"PAISAUTOR" VARCHAR2(100 BYTE), 
	"FECHACREACION" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CATEGORIA
--------------------------------------------------------

  CREATE TABLE "BIBLIOTECA"."CATEGORIA" 
   (	"CATEGORIAID" NUMBER, 
	"NOMBRECAT" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table EDITORIAL
--------------------------------------------------------

  CREATE TABLE "BIBLIOTECA"."EDITORIAL" 
   (	"EDITORIALID" NUMBER, 
	"LIBROID" NUMBER, 
	"DIRECCIONEDITORIAL" VARCHAR2(100 BYTE), 
	"CIUDADEDITORIAL" VARCHAR2(100 BYTE), 
	"PAISEDITORIAL" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table LIBRO
--------------------------------------------------------

  CREATE TABLE "BIBLIOTECA"."LIBRO" 
   (	"LIBROID" NUMBER, 
	"AUTORID" NUMBER, 
	"CATEGORIAID" NUMBER, 
	"TITULO" VARCHAR2(100 BYTE), 
	"ANIO" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PRESTAMO
--------------------------------------------------------

  CREATE TABLE "BIBLIOTECA"."PRESTAMO" 
   (	"PRESTAMOID" NUMBER, 
	"USUARIOID" NUMBER, 
	"LIBROID" NUMBER, 
	"FECHAPRESTAMO" DATE, 
	"FECHADEVOLUCION" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

  CREATE TABLE "BIBLIOTECA"."USUARIO" 
   (	"USUARIOID" NUMBER, 
	"NOMBREUSUARIO" VARCHAR2(100 BYTE), 
	"DIRECCIONUSUARIO" VARCHAR2(100 BYTE), 
	"IDENTIFICACIONUSUARIO" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for View AUTORESPORPAIS
--------------------------------------------------------

  CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "BIBLIOTECA"."AUTORESPORPAIS" ("NOMBREAUTOR", "PAISAUTOR") AS 
  SELECT a.NombreAutor, a.PaisAutor
FROM Autor a
;
--------------------------------------------------------
--  DDL for View EDITORIALESPORLIBRO
--------------------------------------------------------

  CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "BIBLIOTECA"."EDITORIALESPORLIBRO" ("DIRECCIONEDITORIAL", "CIUDADEDITORIAL", "PAISEDITORIAL", "TITULO") AS 
  SELECT e.DireccionEditorial, e.CiudadEditorial, e.PaisEditorial, l.Titulo
FROM Editorial e
JOIN Libro l
ON e.LibroID = l.LibroID
;
--------------------------------------------------------
--  DDL for View LIBROSPORANIO
--------------------------------------------------------

  CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "BIBLIOTECA"."LIBROSPORANIO" ("TITULO", "ANIO") AS 
  SELECT l.Titulo, l.Anio 
FROM Libro l
;
--------------------------------------------------------
--  DDL for View LIBROSPORAUTOR
--------------------------------------------------------

  CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "BIBLIOTECA"."LIBROSPORAUTOR" ("TITULO", "NOMBREAUTOR") AS 
  SELECT l.Titulo, a.NombreAutor
FROM Libro l
JOIN Autor a
ON l.AutorID = a.AutorID
;
--------------------------------------------------------
--  DDL for View LIBROSPORCATEGORIA
--------------------------------------------------------

  CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "BIBLIOTECA"."LIBROSPORCATEGORIA" ("TITULO", "NOMBRECAT") AS 
  SELECT l.Titulo, c.NombreCat
FROM Libro l
JOIN Categoria c
ON l.CategoriaID = c.CategoriaID
;
--------------------------------------------------------
--  DDL for View LIBROSPOREDITORIAL
--------------------------------------------------------

  CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "BIBLIOTECA"."LIBROSPOREDITORIAL" ("TITULO", "DIRECCIONEDITORIAL", "CIUDADEDITORIAL", "PAISEDITORIAL") AS 
  SELECT l.Titulo, e.DireccionEditorial, e.CiudadEditorial, e.PaisEditorial
FROM Libro l
JOIN Editorial e
ON l.LibroID = e.LibroID
;
--------------------------------------------------------
--  DDL for View PRESTAMOSPENDIENTES
--------------------------------------------------------

  CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "BIBLIOTECA"."PRESTAMOSPENDIENTES" ("FECHAPRESTAMO", "FECHADEVOLUCION", "NOMBREUSUARIO", "TITULO") AS 
  SELECT p.FechaPrestamo, p.FechaDevolucion, u.NombreUsuario, l.Titulo 
FROM Prestamo p 
JOIN Usuario u 
ON p.UsuarioID = u.UsuarioID 
JOIN Libro l 
ON p.LibroID = l.LibroID 
WHERE p.FechaDevolucion IS NULL
;
--------------------------------------------------------
--  DDL for View PRESTAMOSPORLIBRO
--------------------------------------------------------

  CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "BIBLIOTECA"."PRESTAMOSPORLIBRO" ("FECHAPRESTAMO", "FECHADEVOLUCION", "TITULO") AS 
  SELECT p.FechaPrestamo, p.FechaDevolucion, l.Titulo
FROM Prestamo p
JOIN Libro l
ON p.LibroID = l.LibroID
;
--------------------------------------------------------
--  DDL for View PRESTAMOSPORUSUARIO
--------------------------------------------------------

  CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "BIBLIOTECA"."PRESTAMOSPORUSUARIO" ("FECHAPRESTAMO", "FECHADEVOLUCION", "NOMBREUSUARIO") AS 
  SELECT p.FechaPrestamo, p.FechaDevolucion, u.NombreUsuario
FROM Prestamo p
JOIN Usuario u
ON p.UsuarioID = u.UsuarioID
;
--------------------------------------------------------
--  DDL for View USUARIOSPORIDENTIFICACION
--------------------------------------------------------

  CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "BIBLIOTECA"."USUARIOSPORIDENTIFICACION" ("NOMBREUSUARIO", "IDENTIFICACIONUSUARIO") AS 
  SELECT u.NombreUsuario, u.IdentificacionUsuario
FROM Usuario u
;
REM INSERTING into BIBLIOTECA.AUTOR
SET DEFINE OFF;
REM INSERTING into BIBLIOTECA.CATEGORIA
SET DEFINE OFF;
REM INSERTING into BIBLIOTECA.EDITORIAL
SET DEFINE OFF;
REM INSERTING into BIBLIOTECA.LIBRO
SET DEFINE OFF;
REM INSERTING into BIBLIOTECA.PRESTAMO
SET DEFINE OFF;
REM INSERTING into BIBLIOTECA.USUARIO
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Trigger ACTUALIZAR_EDITORIAL
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BIBLIOTECA"."ACTUALIZAR_EDITORIAL" 
AFTER UPDATE ON Libro
FOR EACH ROW
BEGIN
    UPDATE Editorial SET LibroID = :NEW.LibroID WHERE LibroID = :OLD.LibroID;
END;
/
ALTER TRIGGER "BIBLIOTECA"."ACTUALIZAR_EDITORIAL" ENABLE;
--------------------------------------------------------
--  DDL for Trigger AGREGAR_LIBRO_NUEVO_AUTOR
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BIBLIOTECA"."AGREGAR_LIBRO_NUEVO_AUTOR" 
AFTER INSERT ON Autor
FOR EACH ROW
BEGIN
    INSERT INTO Libro (LibroID, AutorID, Titulo, Año) VALUES (seq_LibroID.NEXTVAL, :NEW.AutorID, 'Nuevo libro', 2023);
END;
/
ALTER TRIGGER "BIBLIOTECA"."AGREGAR_LIBRO_NUEVO_AUTOR" ENABLE;
--------------------------------------------------------
--  DDL for Trigger AUTORFECHACREACION
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BIBLIOTECA"."AUTORFECHACREACION" 
BEFORE INSERT ON Autor
FOR EACH ROW
BEGIN
    :new.FechaCreacion := SYSDATE;
END;

/
ALTER TRIGGER "BIBLIOTECA"."AUTORFECHACREACION" ENABLE;
--------------------------------------------------------
--  DDL for Procedure ACTUALIZARAUTOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."ACTUALIZARAUTOR" (
    p_AutorID IN Autor.AutorID%TYPE,
    p_NombreAutor IN Autor.NombreAutor%TYPE,
    p_PaisAutor IN Autor.PaisAutor%TYPE
) AS
BEGIN
    UPDATE Autor
    SET NombreAutor = p_NombreAutor,
        PaisAutor = p_PaisAutor
    WHERE AutorID = p_AutorID;
END;

/
--------------------------------------------------------
--  DDL for Procedure ACTUALIZARCATEGORIA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."ACTUALIZARCATEGORIA" (
    p_CategoriaID IN Categoria.CategoriaID%TYPE,
    p_NombreCat IN Categoria.NombreCat%TYPE
) AS
BEGIN
    UPDATE Categoria
    SET NombreCat = p_NombreCat
    WHERE CategoriaID = p_CategoriaID;
END;

/
--------------------------------------------------------
--  DDL for Procedure ACTUALIZAREDITORIAL
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."ACTUALIZAREDITORIAL" (
    p_EditorialID IN Editorial.EditorialID%TYPE,
    p_LibroID IN Editorial.LibroID%TYPE,
    p_DireccionEditorial IN Editorial.DireccionEditorial%TYPE,
    p_CiudadEditorial IN Editorial.CiudadEditorial%TYPE,
    p_PaisEditorial IN Editorial.PaisEditorial%TYPE
) AS
BEGIN
    UPDATE Editorial
    SET LibroID = p_LibroID,
        DireccionEditorial = p_DireccionEditorial,
        CiudadEditorial = p_CiudadEditorial,
        PaisEditorial = p_PaisEditorial
    WHERE EditorialID = p_EditorialID;
END;

/
--------------------------------------------------------
--  DDL for Procedure ACTUALIZARLIBRO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."ACTUALIZARLIBRO" (
    p_LibroID IN Libro.LibroID%TYPE,
    p_AutorID IN Libro.AutorID%TYPE,
    p_CategoriaID IN Libro.CategoriaID%TYPE,
    p_Titulo IN Libro.Titulo%TYPE,
    p_Anio IN Libro. Anio %TYPE
) AS
BEGIN
    UPDATE Libro
    SET AutorID = p_AutorID,
        CategoriaID = p_CategoriaID,
        Titulo = p_Titulo,
        Anio = p_Anio
    WHERE LibroID = p_LibroID;
END;

/
--------------------------------------------------------
--  DDL for Procedure ACTUALIZARPRESTAMO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."ACTUALIZARPRESTAMO" (
    p_PrestamoID IN Prestamo.PrestamoID%TYPE,
    p_UsuarioID IN Prestamo.UsuarioID%TYPE,
    p_LibroID IN Prestamo.LibroID%TYPE,
    p_FechaPrestamo IN Prestamo.FechaPrestamo%TYPE,
    p_FechaDevolucion IN Prestamo.FechaDevolucion%TYPE
) AS
BEGIN
    UPDATE Prestamo
    SET UsuarioID = p_UsuarioID,
        LibroID = p_LibroID,
        FechaPrestamo = p_FechaPrestamo,
        FechaDevolucion = p_FechaDevolucion
    WHERE PrestamoID = p_PrestamoID;
END;

/
--------------------------------------------------------
--  DDL for Procedure ACTUALIZARUSUARIO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."ACTUALIZARUSUARIO" (
    p_UsuarioID IN Usuario.UsuarioID%TYPE,
    p_NombreUsuario IN Usuario.NombreUsuario%TYPE,
    p_DireccionUsuario IN Usuario.DireccionUsuario%TYPE,
    p_IdentificacionUsuario IN Usuario.IdentificacionUsuario%TYPE
) AS
BEGIN
    UPDATE Usuario
    SET NombreUsuario = p_NombreUsuario,
        DireccionUsuario = p_DireccionUsuario,
        IdentificacionUsuario = p_IdentificacionUsuario
    WHERE UsuarioID = p_UsuarioID;
END;

/
--------------------------------------------------------
--  DDL for Procedure CREARAUTOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."CREARAUTOR" (
 p_NombreAutor IN Autor.NombreAutor%TYPE,
 p_PaisAutor IN Autor.PaisAutor%TYPE
) AS
BEGIN
 INSERT INTO Autor (NombreAutor, PaisAutor)
 VALUES (p_NombreAutor, p_PaisAutor);
END;

/
--------------------------------------------------------
--  DDL for Procedure CREARCATEGORIA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."CREARCATEGORIA" (
    p_NombreCat IN Categoria.NombreCat%TYPE
) AS
BEGIN
    INSERT INTO Categoria (NombreCat)
    VALUES (p_NombreCat);
END;

/
--------------------------------------------------------
--  DDL for Procedure CREAREDITORIAL
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."CREAREDITORIAL" (
    p_LibroID IN Editorial.LibroID%TYPE,
    p_DireccionEditorial IN Editorial.DireccionEditorial%TYPE,
    p_CiudadEditorial IN Editorial.CiudadEditorial%TYPE,
    p_PaisEditorial IN Editorial.PaisEditorial%TYPE
) AS
BEGIN
    INSERT INTO Editorial (LibroID, DireccionEditorial, CiudadEditorial, PaisEditorial)
    VALUES (p_LibroID, p_DireccionEditorial, p_CiudadEditorial, p_PaisEditorial);
END;

/
--------------------------------------------------------
--  DDL for Procedure CREARLIBRO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."CREARLIBRO" (
    p_AutorID IN Libro.AutorID%TYPE,
    p_CategoriaID IN Libro.CategoriaID%TYPE,
    p_Titulo IN Libro.Titulo%TYPE,
    p_Anio IN Libro.Anio%TYPE
) AS
BEGIN
    INSERT INTO Libro (AutorID, CategoriaID, Titulo, Anio)
    VALUES (p_AutorID, p_CategoriaID, p_Titulo, p_Anio);
END;

/
--------------------------------------------------------
--  DDL for Procedure CREARPRESTAMO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."CREARPRESTAMO" (
    p_UsuarioID IN Prestamo.UsuarioID%TYPE,
    p_LibroID IN Prestamo.LibroID%TYPE,
    p_FechaPrestamo IN Prestamo.FechaPrestamo%TYPE,
    p_FechaDevolucion IN Prestamo.FechaDevolucion%TYPE
) AS
BEGIN
    INSERT INTO Prestamo (UsuarioID, LibroID, FechaPrestamo, FechaDevolucion)
    VALUES (p_UsuarioID, p_LibroID, p_FechaPrestamo, p_FechaDevolucion);
END;

/
--------------------------------------------------------
--  DDL for Procedure CREARUSUARIO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."CREARUSUARIO" (
    p_NombreUsuario IN Usuario.NombreUsuario%TYPE,
    p_DireccionUsuario IN Usuario.DireccionUsuario%TYPE,
    p_IdentificacionUsuario IN Usuario.IdentificacionUsuario%TYPE
) AS
BEGIN
    INSERT INTO Usuario (NombreUsuario, DireccionUsuario, IdentificacionUsuario)
    VALUES (p_NombreUsuario, p_DireccionUsuario, p_IdentificacionUsuario);
END;

/
--------------------------------------------------------
--  DDL for Procedure ELIMINARAUTOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."ELIMINARAUTOR" (
    p_AutorID IN Autor.AutorID%TYPE
) AS
BEGIN
    DELETE FROM Autor
    WHERE AutorID = p_AutorID;
END;

/
--------------------------------------------------------
--  DDL for Procedure ELIMINARCATEGORIA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."ELIMINARCATEGORIA" (
    p_CategoriaID IN Categoria.CategoriaID%TYPE
) AS
BEGIN
    DELETE FROM Categoria
    WHERE CategoriaID = p_CategoriaID;
END;

/
--------------------------------------------------------
--  DDL for Procedure ELIMINAREDITORIAL
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."ELIMINAREDITORIAL" (
    p_EditorialID IN Editorial.EditorialID%TYPE
) AS
BEGIN
    DELETE FROM Editorial
    WHERE EditorialID = p_EditorialID;
END;

/
--------------------------------------------------------
--  DDL for Procedure ELIMINARLIBRO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."ELIMINARLIBRO" (
    p_LibroID IN Libro.LibroID%TYPE
) AS
BEGIN
    DELETE FROM Libro
    WHERE LibroID = p_LibroID;
END;

/
--------------------------------------------------------
--  DDL for Procedure ELIMINARPRESTAMO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."ELIMINARPRESTAMO" (
    p_PrestamoID IN Prestamo.PrestamoID%TYPE
) AS
BEGIN
    DELETE FROM Prestamo
    WHERE PrestamoID = p_PrestamoID;
END;

/
--------------------------------------------------------
--  DDL for Procedure ELIMINARUSUARIO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."ELIMINARUSUARIO" (
    p_UsuarioID IN Usuario.UsuarioID%TYPE
) AS
BEGIN
    DELETE FROM Usuario
    WHERE UsuarioID = p_UsuarioID;
END;

/
--------------------------------------------------------
--  DDL for Procedure LEERCATEGORIAS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."LEERCATEGORIAS" (
    p_Cursor OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_Cursor FOR
        SELECT * FROM Categoria;
END;

/
--------------------------------------------------------
--  DDL for Procedure LEEREDITORIALES
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."LEEREDITORIALES" (
    p_Cursor OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_Cursor FOR
        SELECT * FROM Editorial;
END;

/
--------------------------------------------------------
--  DDL for Procedure LEERLLIBROS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."LEERLLIBROS" (
    p_Cursor OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_Cursor FOR
        SELECT * FROM Libro;
END;

/
--------------------------------------------------------
--  DDL for Procedure LEERPRESTAMOS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."LEERPRESTAMOS" (
    p_Cursor OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_Cursor FOR
        SELECT * FROM Prestamo;
END;

/
--------------------------------------------------------
--  DDL for Procedure LEERUSUARIOS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."LEERUSUARIOS" (
    p_Cursor OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_Cursor FOR
        SELECT * FROM Usuario;
END;

/
--------------------------------------------------------
--  DDL for Procedure VERAUTORES
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BIBLIOTECA"."VERAUTORES" (
    p_Cursor OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_Cursor FOR
        SELECT * FROM Autor;
END;

/
--------------------------------------------------------
--  DDL for Function CALCULARPROMEDIODIASPRESTAMO
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BIBLIOTECA"."CALCULARPROMEDIODIASPRESTAMO" RETURN NUMBER AS
    v_PromedioDias NUMBER;
BEGIN
    SELECT AVG(FechaDevolucion - FechaPrestamo)
    INTO v_PromedioDias
    FROM Prestamo;

    RETURN v_PromedioDias;
END;

/
--------------------------------------------------------
--  DDL for Function OBTENERLIBROSMASPRESTADOS
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BIBLIOTECA"."OBTENERLIBROSMASPRESTADOS" (
   p_Cantidad IN NUMBER 
) RETURN SYS_REFCURSOR AS 
   v_Cursor SYS_REFCURSOR; 
BEGIN 
   OPEN v_Cursor FOR 
      SELECT l.LibroID, l.Titulo, COUNT(*) as CantidadPrestamos 
      FROM Prestamo p JOIN Libro l ON p.LibroID = l.LibroID 
      GROUP BY l.LibroID, l.Titulo 
      ORDER BY CantidadPrestamos DESC 
      FETCH FIRST p_Cantidad ROWS ONLY; 

   RETURN v_Cursor; 
END; 

/
--------------------------------------------------------
--  DDL for Function OBTENERTOTALAUTORES
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BIBLIOTECA"."OBTENERTOTALAUTORES" RETURN NUMBER AS
    v_TotalAutores NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_TotalAutores
    FROM Autor;

    RETURN v_TotalAutores;
END;

/
--------------------------------------------------------
--  DDL for Function OBTENERTOTALCATEGORIAS
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BIBLIOTECA"."OBTENERTOTALCATEGORIAS" RETURN NUMBER AS
    v_TotalCategorias NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_TotalCategorias
    FROM Categoria;

    RETURN v_TotalCategorias;
END;

/
--------------------------------------------------------
--  DDL for Function OBTENERTOTALEDITORIALES
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BIBLIOTECA"."OBTENERTOTALEDITORIALES" RETURN NUMBER AS
    v_TotalEditoriales NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_TotalEditoriales
    FROM Editorial;

    RETURN v_TotalEditoriales;
END;

/
--------------------------------------------------------
--  DDL for Function OBTENERTOTALLIBROS
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BIBLIOTECA"."OBTENERTOTALLIBROS" RETURN NUMBER AS
    v_TotalLibros NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_TotalLibros
    FROM Libro;

    RETURN v_TotalLibros;
END;

/
--------------------------------------------------------
--  DDL for Function OBTENERTOTALPRESTAMOS
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BIBLIOTECA"."OBTENERTOTALPRESTAMOS" RETURN NUMBER AS
    v_TotalPrestamos NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_TotalPrestamos
    FROM Prestamo;

    RETURN v_TotalPrestamos;
END;

/
--------------------------------------------------------
--  DDL for Function OBTENERTOTALUSUARIOS
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BIBLIOTECA"."OBTENERTOTALUSUARIOS" RETURN NUMBER AS
    v_TotalUsuarios NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_TotalUsuarios
    FROM Usuario;

    RETURN v_TotalUsuarios;
END;

/
--------------------------------------------------------
--  Constraints for Table PRESTAMO
--------------------------------------------------------

  ALTER TABLE "BIBLIOTECA"."PRESTAMO" ADD PRIMARY KEY ("PRESTAMOID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "BIBLIOTECA"."USUARIO" ADD PRIMARY KEY ("USUARIOID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table AUTOR
--------------------------------------------------------

  ALTER TABLE "BIBLIOTECA"."AUTOR" ADD PRIMARY KEY ("AUTORID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table LIBRO
--------------------------------------------------------

  ALTER TABLE "BIBLIOTECA"."LIBRO" ADD PRIMARY KEY ("LIBROID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CATEGORIA
--------------------------------------------------------

  ALTER TABLE "BIBLIOTECA"."CATEGORIA" ADD PRIMARY KEY ("CATEGORIAID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EDITORIAL
--------------------------------------------------------

  ALTER TABLE "BIBLIOTECA"."EDITORIAL" ADD PRIMARY KEY ("EDITORIALID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EDITORIAL
--------------------------------------------------------

  ALTER TABLE "BIBLIOTECA"."EDITORIAL" ADD FOREIGN KEY ("LIBROID")
	  REFERENCES "BIBLIOTECA"."LIBRO" ("LIBROID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table LIBRO
--------------------------------------------------------

  ALTER TABLE "BIBLIOTECA"."LIBRO" ADD FOREIGN KEY ("AUTORID")
	  REFERENCES "BIBLIOTECA"."AUTOR" ("AUTORID") ENABLE;
  ALTER TABLE "BIBLIOTECA"."LIBRO" ADD FOREIGN KEY ("CATEGORIAID")
	  REFERENCES "BIBLIOTECA"."CATEGORIA" ("CATEGORIAID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PRESTAMO
--------------------------------------------------------

  ALTER TABLE "BIBLIOTECA"."PRESTAMO" ADD FOREIGN KEY ("USUARIOID")
	  REFERENCES "BIBLIOTECA"."USUARIO" ("USUARIOID") ENABLE;
  ALTER TABLE "BIBLIOTECA"."PRESTAMO" ADD FOREIGN KEY ("LIBROID")
	  REFERENCES "BIBLIOTECA"."LIBRO" ("LIBROID") ENABLE;
