DROP DATABASE IF EXISTS students;
CREATE DATABASE students;

USE students;

CREATE TABLE students(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    totalGrades DOUBLE
);

CREATE TABLE results(
    maxMark DOUBLE,
    minMark DOUBLE,
    studentsAverage DOUBLE
);

INSERT INTO students(id, name, totalGrades) VALUES (1, "osamax01", 92), (2, "Sasha", 88);
