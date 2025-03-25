-- Insert Departments
INSERT INTO department (id, creation_date, department_head_id, name)
VALUES (
        '11111111-1111-1111-1111-111111111111',
        '2020-01-01',
        NULL,
        'Engineering'
    ),
    (
        '22222222-2222-2222-2222-222222222222',
        '2019-03-15',
        NULL,
        'Marketing'
    ),
    (
        '33333333-3333-3333-3333-333333333333',
        '2021-06-10',
        NULL,
        'Sales'
    ),
    (
        '44444444-4444-4444-4444-444444444444',
        '2018-09-20',
        NULL,
        'HR'
    ),
    (
        '55555555-5555-5555-5555-555555555555',
        '2022-11-05',
        NULL,
        'Finance'
    );
-- Insert Employees
INSERT INTO employee (
        id,
        name,
        dob,
        join_date,
        salary,
        bonus_percentage,
        is_company_head,
        department_id,
        manager_id,
        title,
        street,
        city,
        state,
        zip_code
    )
VALUES -- Department Heads
    (
        'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
        'Alice Johnson',
        '1985-05-12',
        '2010-06-15',
        120000,
        10,
        true,
        '11111111-1111-1111-1111-111111111111',
        NULL,
        'Engineering Manager',
        '123 Tech Park',
        'San Francisco',
        'CA',
        '94107'
    ),
    (
        'bbbbbbb1-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
        'Bob Smith',
        '1978-08-22',
        '2005-07-01',
        130000,
        12,
        true,
        '22222222-2222-2222-2222-222222222222',
        NULL,
        'Marketing Director',
        '456 Market St',
        'New York',
        'NY',
        '10001'
    ),
    (
        'ccccccc1-cccc-cccc-cccc-cccccccccccc',
        'Charlie Adams',
        '1982-11-30',
        '2008-09-23',
        125000,
        11,
        true,
        '33333333-3333-3333-3333-333333333333',
        NULL,
        'Sales Head',
        '789 Commerce Dr',
        'Los Angeles',
        'CA',
        '90012'
    ),
    (
        'ddddddd1-dddd-dddd-dddd-dddddddddddd',
        'David Green',
        '1990-04-15',
        '2015-05-20',
        110000,
        9,
        true,
        '44444444-4444-4444-4444-444444444444',
        NULL,
        'HR Manager',
        '234 People St',
        'Chicago',
        'IL',
        '60604'
    ),
    (
        'eeeeeee1-eeee-eeee-eeee-eeeeeeeeeeee',
        'Emma Watson',
        '1987-12-05',
        '2012-03-10',
        115000,
        10,
        true,
        '55555555-5555-5555-5555-555555555555',
        NULL,
        'Finance Manager',
        '567 Money Blvd',
        'Miami',
        'FL',
        '33101'
    ),
    -- Employees in Engineering
    (
        'aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
        'Frank Lee',
        '1992-06-24',
        '2018-09-01',
        85000,
        7,
        false,
        '11111111-1111-1111-1111-111111111111',
        'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
        'Software Engineer',
        '12 Dev St',
        'San Francisco',
        'CA',
        '94107'
    ),
    (
        'aaaaaaa3-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
        'Grace Kim',
        '1994-07-10',
        '2020-01-15',
        80000,
        6,
        false,
        '11111111-1111-1111-1111-111111111111',
        'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
        'Software Engineer',
        '15 Code Rd',
        'San Francisco',
        'CA',
        '94107'
    ),
    (
        'aaaaaaa4-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
        'Henry Wong',
        '1989-02-17',
        '2015-03-25',
        95000,
        8,
        false,
        '11111111-1111-1111-1111-111111111111',
        'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
        'Lead Engineer',
        '22 Backend Ave',
        'San Francisco',
        'CA',
        '94107'
    ),
    -- Employees in Marketing
    (
        'bbbbbbb2-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
        'Isabella Turner',
        '1995-05-25',
        '2021-04-10',
        75000,
        5,
        false,
        '22222222-2222-2222-2222-222222222222',
        'bbbbbbb1-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
        'Marketing Executive',
        '23 Brand St',
        'New York',
        'NY',
        '10001'
    ),
    (
        'bbbbbbb3-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
        'Jack Brown',
        '1991-09-18',
        '2017-06-20',
        82000,
        6,
        false,
        '22222222-2222-2222-2222-222222222222',
        'bbbbbbb1-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
        'Senior Marketing Manager',
        '67 Media Rd',
        'New York',
        'NY',
        '10001'
    ),
    -- Employees in Sales
    (
        'ccccccc2-cccc-cccc-cccc-cccccccccccc',
        'Kelly Roberts',
        '1993-11-12',
        '2019-05-18',
        78000,
        5,
        false,
        '33333333-3333-3333-3333-333333333333',
        'ccccccc1-cccc-cccc-cccc-cccccccccccc',
        'Sales Executive',
        '98 Sales St',
        'Los Angeles',
        'CA',
        '90012'
    ),
    (
        'ccccccc3-cccc-cccc-cccc-cccccccccccc',
        'Lucas Hall',
        '1985-07-20',
        '2010-12-01',
        88000,
        7,
        false,
        '33333333-3333-3333-3333-333333333333',
        'ccccccc1-cccc-cccc-cccc-cccccccccccc',
        'Sales Manager',
        '21 Revenue Rd',
        'Los Angeles',
        'CA',
        '90012'
    ),
    -- Employees in HR
    (
        'ddddddd2-dddd-dddd-dddd-dddddddddddd',
        'Maria Lopez',
        '1997-03-22',
        '2022-06-15',
        72000,
        4,
        false,
        '44444444-4444-4444-4444-444444444444',
        'ddddddd1-dddd-dddd-dddd-dddddddddddd',
        'HR Associate',
        '43 People Ave',
        'Chicago',
        'IL',
        '60604'
    ),
    (
        'ddddddd3-dddd-dddd-dddd-dddddddddddd',
        'Nathan Scott',
        '1988-01-30',
        '2016-08-11',
        90000,
        6,
        false,
        '44444444-4444-4444-4444-444444444444',
        'ddddddd1-dddd-dddd-dddd-dddddddddddd',
        'HR Specialist',
        '76 Hiring Blvd',
        'Chicago',
        'IL',
        '60604'
    ),
    -- Employees in Finance
    (
        'eeeeeee2-eeee-eeee-eeee-eeeeeeeeeeee',
        'Olivia White',
        '1996-04-08',
        '2021-09-30',
        78000,
        5,
        false,
        '55555555-5555-5555-5555-555555555555',
        'eeeeeee1-eeee-eeee-eeee-eeeeeeeeeeee',
        'Accountant',
        '29 Money St',
        'Miami',
        'FL',
        '33101'
    ),
    (
        'eeeeeee3-eeee-eeee-eeee-eeeeeeeeeeee',
        'Peter Evans',
        '1990-12-10',
        '2014-07-15',
        88000,
        7,
        false,
        '55555555-5555-5555-5555-555555555555',
        'eeeeeee1-eeee-eeee-eeee-eeeeeeeeeeee',
        'Senior Accountant',
        '56 Finance Rd',
        'Miami',
        'FL',
        '33101'
    );
-- Update Department Heads
UPDATE department
SET department_head_id = 'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa'
WHERE id = '11111111-1111-1111-1111-111111111111';
UPDATE department
SET department_head_id = 'bbbbbbb1-bbbb-bbbb-bbbb-bbbbbbbbbbbb'
WHERE id = '22222222-2222-2222-2222-222222222222';
UPDATE department
SET department_head_id = 'ccccccc1-cccc-cccc-cccc-cccccccccccc'
WHERE id = '33333333-3333-3333-3333-333333333333';
UPDATE department
SET department_head_id = 'ddddddd1-dddd-dddd-dddd-dddddddddddd'
WHERE id = '44444444-4444-4444-4444-444444444444';
UPDATE department
SET department_head_id = 'eeeeeee1-eeee-eeee-eeee-eeeeeeeeeeee'
WHERE id = '55555555-5555-5555-5555-555555555555';