use animalpets;

CREATE TABLE `Animal` (
	`idAnimal` INT(20) NOT NULL AUTO_INCREMENT,
    `Especie` VARCHAR(20),
	`Vertebrado` BOOLEAN,
	`Terrestre` BOOLEAN,
	PRIMARY KEY (`idAnimal`)
);

CREATE TABLE `Mascota`(
`idMascota` INT(20) NOT NULL AUTO_INCREMENT,
`dniDueño` VARCHAR(9),
`nombreMascota` VARCHAR(20),
`seguroMedico` BOOLEAN,
`Estado` VARCHAR(20),
`animalId` INT(20),
PRIMARY KEY (`idMascota`)
);

ALTER TABLE mascota
ADD CONSTRAINT `mascota_animal_fk` FOREIGN KEY (`animalId`) REFERENCES `animal` (`idAnimal`) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO animal (Especie ,Vertebrado, Terrestre)
VALUES ("Perro" ,true, true), ("Conejo",true, true), ("Canario",true, true), ("Gato",true, true), ("Serpiente",true, true), ("Perro",true, true);

INSERT INTO mascota ( dniDueño, nombreMascota,Estado ,seguroMedico  , animalId)
values ("47785445J","Pepito", "Vivo", true, 1), ("47785565J","Paco", "Vivo" , true, 2), ("47782345J","Manuel", "Vivo",true, 3), ("47712345J","Manolo", "Vivo",true, 4), ("23785445J","Coco", "Vivo",false, 5), ("47785565J","Roberto", "Vivo",true, 6);