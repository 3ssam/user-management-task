-- Authorities
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (1, 'CREATE_ROLE', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (2, 'UPDATE_ROLE', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (3, 'DELETE_ROLE', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (4, 'READ_ROLE', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (5, 'READ_ALL_ROLES', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (6, 'ASSIGN_AUTHORITY_TO_ROLE', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);

INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (7, 'CREATE_AUTHORITY', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (8, 'UPDATE_AUTHORITY', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (9, 'DELETE_AUTHORITY', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (10, 'READ_AUTHORITY', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);
INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (11, 'READ_Authorities', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);

INSERT INTO authority (id, name, status, created_at, updated_at, created_by, updated_by)
values (12, 'CREATE_USER', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);

-- Roles
INSERT INTO role (id, name, status, created_at, updated_at, created_by, updated_by)
values (1, 'SUPER_ADMIN', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);
INSERT INTO role (id, name, status, created_at, updated_at, created_by, updated_by)
values (2, 'ADMIN', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);
INSERT INTO role (id, name, status, created_at, updated_at, created_by, updated_by)
values (3, 'USER', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);
INSERT INTO role (id, name, status, created_at, updated_at, created_by, updated_by)
values (4, 'DEVELOPER', true, '2022-09-07 00:00:00.00', '2022-09-07 00:00:00.00', 1, 1);

-- Roles-Authorities
-- Super Admin Authorities
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 1);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 2);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 3);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 4);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 5);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 6);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 7);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 8);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 9);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 10);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 11);
INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 12);

-- Admin Authorities
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 1);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 2);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 3);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 4);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 5);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 6);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 7);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 8);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 9);
INSERT INTO role_authority (role_id, authority_id)
VALUES (2, 10);

-- User Authorities
INSERT INTO role_authority (role_id, authority_id)
VALUES (3, 7);
INSERT INTO role_authority (role_id, authority_id)
VALUES (3, 8);
INSERT INTO role_authority (role_id, authority_id)
VALUES (3, 9);
INSERT INTO role_authority (role_id, authority_id)
VALUES (3, 10);
INSERT INTO role_authority (role_id, authority_id)
VALUES (3, 11);

-- Developer Authorities
INSERT INTO role_authority (role_id, authority_id)
VALUES (4, 12);

-- Users
-- password for all user is 123456

--Super Admin User
INSERT INTO user (id, name, email, password_hash, activated, suspended, role_id, created_at, updated_at, created_by,
                  updated_by)
values (1, 'Mohamed Essam', 'mohamed_ekamel@rayacorp.com',
        '$2a$10$DBTrOEC7LCBflu90yBg/8OBGiHK8dH3ddJGJp3ioneVrbGiUPKl1G', true, false, 1, '2022-09-07 00:00:00.00',
        '2022-09-07 00:00:00.00', null, null);

-- Admin User
INSERT INTO user (id, name, email, password_hash, activated, suspended, role_id, created_at, updated_at, created_by,
                  updated_by)
values (2, 'Omar Ahmed', 'omar.ahmed@rayacorp.com',
        '$2a$10$DBTrOEC7LCBflu90yBg/8OBGiHK8dH3ddJGJp3ioneVrbGiUPKl1G', true, false, 2, '2022-09-07 00:00:00.00',
        '2022-09-07 00:00:00.00', 1, 1);

-- User
INSERT INTO user (id, name, email, password_hash, activated, suspended, role_id, created_at, updated_at, created_by,
                  updated_by)
values (3, 'Ahmed Nasr', 'ahmed.nasr@rayacorp.com',
        '$2a$10$DBTrOEC7LCBflu90yBg/8OBGiHK8dH3ddJGJp3ioneVrbGiUPKl1G', true, false, 3, '2022-09-07 00:00:00.00',
        '2022-09-07 00:00:00.00', 1, 1);

-- Developer User
INSERT INTO user (id, name, email, password_hash, activated, suspended, role_id, created_at, updated_at, created_by,
                  updated_by)
values (4, 'Yousef Rabie', 'yousef.rabie@rayacorp.com',
        '$2a$10$DBTrOEC7LCBflu90yBg/8OBGiHK8dH3ddJGJp3ioneVrbGiUPKl1G', true, false, 4, '2022-09-07 00:00:00.00',
        '2022-09-07 00:00:00.00', 1, 1);

