CREATE TABLE public.employee(
    employee_id character varying PRIMARY KEY,
    last_name character varying NOT NULL,
    first_name character varying NOT NULL,
    middle_name character varying NOT NULL,
    position character varying NOT NULL,
    date_of_hiring date not null,
    date_of_dismissal date not null,
    office_id character varying NOT NULL
);