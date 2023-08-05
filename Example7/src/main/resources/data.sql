INSERT INTO `HOLIDAYS`
(`day`, `reason`, `type`, `created_at`, `created_by`)
VALUES ('Jan 1', 'New Year''s Day', 'FESTIVAL', CURDATE(), 'DBA'),
       ('Oct 31', 'Halloween', 'FESTIVAL', CURDATE(), 'DBA'),
       ('Nov 24', 'Thanksgiving Day', 'FESTIVAL', CURDATE(), 'DBA'),
       ('Dec 25', 'Christmas', 'FESTIVAL', CURDATE(), 'DBA'),
       ('Jan 17', 'Martin Luther King Day', 'FEDERAL', CURDATE(), 'DBA'),
       ('July 4', 'Independence Day', 'FEDERAL', CURDATE(), 'DBA'),
       ('Sep 5', 'Labor Day', 'FEDERAL', CURDATE(), 'DBA'),
       ('Nov 11', 'Veterans Day', 'FEDERAL', CURDATE(), 'DBA');
