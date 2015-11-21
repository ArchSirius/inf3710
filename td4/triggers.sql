--2.A
CREATE OR REPLACE TRIGGER inscrire_organisateur
AFTER INSERT ON Sortie
FOR EACH ROW

BEGIN
    INSERT INTO Inscription
	(pseudo, idSort, statut)
	VALUES
	(:NEW.responsable, :NEW.idSort, 0);
END;


--2.B
CREATE OR REPLACE TRIGGER sorties_simultanees
BEFORE INSERT ON Inscription
FOR EACH ROW

DECLARE
  newDate DATE;
  nb INTEGER;

BEGIN
  SELECT dte INTO newDate
  FROM Sortie
  WHERE idSort = :NEW.idSort;
  
  SELECT COUNT(*) INTO nb
  FROM SORTIE S
  WHERE
    extract(HOUR FROM (S.dte - newDate)) < 4 AND
    extract(HOUR FROM (S.dte - newDate)) > -4 AND
    extract(DAY FROM (S.dte - newDate)) = 0
  ;

	if nb > 1 then
	RAISE_APPLICATION_ERROR(-20000, 'Sorties concurrentes');
	end if;
END;
