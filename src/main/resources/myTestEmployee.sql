
DELETE from employee;

CREATE TABLE IF NOT EXISTS employeeTest(id serial PRIMARY key,
    name VARCHAR (50) not null,
    surname VARCHAR (50) not null,
    phone VARCHAR (15),
    position_eml VARCHAR (50) not null,
    date_of_employment DATE NOT NULL DEFAULT CURRENT_DATE,
    date_of_dismissal DATE ,
    salary NUMERIC(10, 2));


SELECT id,name  FROM employee where id = -19;

INSERT INTO employeeTest (name, surname, position_eml)
VALUES
    ('John', 'Doe', 'Manager' );

    select * FROM employeeTest;

select * FROM employeeTest where id = 100;