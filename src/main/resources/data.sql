CREATE TABLE CAR (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    chassi VARCHAR(17),
    name VARCHAR(255),
    manufacturer VARCHAR(255),
    caryear INTEGER,
    color VARCHAR(255),
    status VARCHAR(255),
    placa VARCHAR(255)
); 

INSERT INTO CAR(chassi, name, manufacturer, caryear, color, status, placa) VALUES('0PWZZZ322VT004259', 'Fiat Uno', 'Ford car', 2021, 'black', 'ACTIVATED', 'PAM1994');

INSERT INTO CAR(chassi, name, manufacturer, caryear, color, status, placa) VALUES('9BWZZZ377VT004251', 'Lamborghini Urus', 'Automobili Lamborghini S.P.A.', 2021, 'white', 'ACTIVATED', 'OPA0148');

INSERT INTO CAR(chassi, name, manufacturer, caryear, color, status, placa) VALUES('2BWZZZ379TT304950', 'Camaro', 'Automobili EUA', 2021, 'yellow', 'DEACTIVATED', 'REN0160');

INSERT INTO CAR(chassi, name, manufacturer, caryear, color, status, placa) VALUES('3BWKKZ375VT034211', 'Captiva', 'Automobili S.P.A.', 2021, 'silver', 'ACTIVATED', 'EOA0114');

INSERT INTO CAR(chassi, name, manufacturer, caryear, color, status, placa) VALUES('8BWKPZ377VT001218', 'Lamborghini Urus', 'Automobili Lamborghini S.P.A.', 2021, 'blue', 'RENTED', 'FAT3276');

INSERT INTO CAR(chassi, name, manufacturer, caryear, color, status, placa) VALUES('7BWGFD377PO009866', 'Palio', 'Chevrolet', 2021, 'silver', 'RESERVED', 'AOZ0010');