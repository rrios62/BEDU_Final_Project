SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bedujbiis-------------------------------------
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `bec` ;
USE `bec` ;

-- -----------------------------------------------------
-- Table `bec`.`clientes`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `bec`.`clientes` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NOT NULL,
  `Contacto` VARCHAR(50) NOT NULL,
  `CorreoContacto` VARCHAR(50) NOT NULL,
  `telefono` VARCHAR(10) NOT NULL,
  `direccion` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE INDEX `idCliente_UNIQUE` (`idCliente` ASC) VISIBLE);

-- -----------------------------------------------------
-- Table `bec`.`empleados`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `bec`.`empleados` (
  `idEmpleado` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `cargo` VARCHAR(50) NOT NULL,
  `telefono` VARCHAR(10) NOT NULL,
  `actividad` VARCHAR(50) NOT NULL,
  `numero_empleado` INT NOT NULL,
  PRIMARY KEY (`idEmpleado`));
  UNIQUE INDEX `idEmpleado_UNIQUE` (`idEmpleado` ASC) VISIBLE);

-- -----------------------------------------------------
-- Table `bec`.`pedidos`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `bec`.`pedidos`(
  `idPedido` INT NOT NULL AUTO_INCREMENT,
  `cliente` VARCHAR(50) NOT NULL,
  `contacto` VARCHAR(50) NOT NULL,
  `equipo` VARCHAR(20) NOT NULL,
  `fecha` DATE NOT NULL,
  `potencia` INT NOT NULL,
  `unidad_medida` VARCHAR(5) NOT NULL,
  `rpm` INT NOT NULL,
  `frecuencia` INT NOT NULL,
  `amperes` INT NOT NULL,
  `marca` VARCHAR(20) NOT NULL,
  `serie` VARCHAR(20) NOT NULL,
  `desensamble` VARCHAR(50) NOT NULL,
  `ensamble` VARCHAR(50) NOT NULL,
  `embobinado` VARCHAR(50) NOT NULL,
  `pruebas` VARCHAR(50) NOT NULL,
  `notas` VARCHAR(50) NOT NULL,
  `estatus` VARCHAR(20) NOT NULL,
  `factura` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idPedido`),
  UNIQUE INDEX `idPedido_UNIQUE` (`idPedido` ASC) VISIBLE);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


