UPDATE vehiculo 
SET activo = FALSE
WHERE placa = 'M-456DEF';

SELECT placa, propietario, tipo, activo 
FROM vehiculo 
WHERE placa = 'M-456DEF';