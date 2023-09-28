

DROP TABLE  employee;

create table employee
(
    id serial PRIMARY key,
    name VARCHAR (50) not null,
    surname VARCHAR (50) not null,
    phone VARCHAR (15),
    position_eml VARCHAR (50) not null,
    date_of_employment DATE NOT NULL DEFAULT CURRENT_DATE ,
    date_of_dismissal DATE ,
    salary NUMERIC(10, 2)
);

INSERT INTO employee (name, surname, phone, position_eml, date_of_employment, date_of_dismissal, salary)
VALUES
    ('John', 'Doe', '123-456-7890', 'Manager', '2023-01-15', NULL, 50000.00),
    ('Jane', 'Smith', '987-654-3210', 'Engineer', '2022-07-10', NULL, 60000.00),
    ('Michael', 'Johnson', '555-123-4567', 'Engineer', '2022-03-20', '2023-02-28', 45000.00),
    ('Emily', 'Brown', '111-222-3333', 'Designer', '2022-09-05', NULL, 55000.00),
    ('William', 'Davis', '444-555-6666', 'Developer', '2023-05-03', NULL, 65000.00);



    SELECT name FROM employee ORDER BY name;

    SELECT * FROM employee WHERE date_of_dismissal IS NULL;

    SELECT name FROM employee WHERE name LIKE 'B%' ORDER BY name DESC;

    SELECT DISTINCT position_eml FROM employee;

    SELECT * FROM employee
    WHERE date_of_employment BETWEEN '2022-01-01' AND '2023-01-01';



