DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`
(
    `id`         int(11)                                NOT NULL AUTO_INCREMENT,
    `user_id`    int(11)                                NOT NULL,
    `role_id`    int(11)                                NOT NULL,
    `created_by` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
    `created_at` timestamp default now()                NOT NULL,
    `updated_by` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
    `updated_at` timestamp default now()                NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`user_id`, `role_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='user role';

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`         int(11)                                 NOT NULL AUTO_INCREMENT,
    `name`       varchar(20) COLLATE utf8mb4_unicode_ci  NOT NULL,
    `password`   varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
    `created_by` varchar(20) COLLATE utf8mb4_unicode_ci  NOT NULL,
    `created_at` timestamp default now()                 NOT NULL,
    `updated_by` varchar(20) COLLATE utf8mb4_unicode_ci  NOT NULL,
    `updated_at` timestamp default now()                 NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000001
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='user';

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    `id`         int(11)                                NOT NULL AUTO_INCREMENT,
    `name`       varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
    `created_by` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
    `created_at` timestamp default now()                NOT NULL,
    `updated_by` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
    `updated_at` timestamp default now()                NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='role';

DROP TABLE IF EXISTS `client`;
CREATE TABLE `client`
(
    `id`         int(11)                                 NOT NULL AUTO_INCREMENT,
    `company_id` int(11)                                 NOT NULL,
    `name`       varchar(20) COLLATE utf8mb4_unicode_ci  NOT NULL,
    `email`      varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
    `phone`      varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
    `created_by` varchar(20) COLLATE utf8mb4_unicode_ci  NOT NULL,
    `created_at` timestamp default now()                 NOT NULL,
    `updated_by` varchar(20) COLLATE utf8mb4_unicode_ci  NOT NULL,
    `updated_at` timestamp default now()                 NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='client';

DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`
(
    `id`         int(11)                                 NOT NULL AUTO_INCREMENT,
    `name`       varchar(20) COLLATE utf8mb4_unicode_ci  NOT NULL,
    `address`    varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
    `created_by` varchar(20) COLLATE utf8mb4_unicode_ci  NOT NULL,
    `created_at` timestamp default now()                 NOT NULL,
    `updated_by` varchar(20) COLLATE utf8mb4_unicode_ci  NOT NULL,
    `updated_at` timestamp default now()                 NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='company';


INSERT INTO role(name, created_by, updated_by) VALUES ('super', 'system', 'system');
INSERT INTO role(name, created_by, updated_by) VALUES ('manager', 'system', 'system');
INSERT INTO role(name, created_by, updated_by) VALUES ('operator', 'system', 'system');

INSERT INTO demo.user (name, password, created_by, created_at, updated_by, updated_at) VALUES ('super', '$2a$10$oXfT0ztvznNXvJMsX0AcouiTWFavd9mUTz6la6n/j35CQeVm8bft6', 'system', '2021-07-26 02:21:41', 'system', '2021-07-26 02:21:41');
INSERT INTO demo.user (name, password, created_by, created_at, updated_by, updated_at) VALUES ('manager', '$2a$10$cceUZdkyjgEYntXKqzl3DuiPTUdkOv6FzY69W8vNbcF38DfXY2ANe', 'system', '2021-07-26 02:21:50', 'system', '2021-07-26 02:21:50');
INSERT INTO demo.user (name, password, created_by, created_at, updated_by, updated_at) VALUES ('operator', '$2a$10$Yql.gShgKvAgwV9hhxdZ2.yTWdwpEMSHjeqGRLmRy4Ijom1s8tMKO', 'system', '2021-07-26 02:21:59', 'system', '2021-07-26 02:21:59');

INSERT INTO demo.user_role (id, user_id, role_id, created_by, created_at, updated_by, updated_at) VALUES (1, 1000001, 1, 'system', '2021-07-26 02:21:41', 'system', '2021-07-26 02:21:41');
INSERT INTO demo.user_role (id, user_id, role_id, created_by, created_at, updated_by, updated_at) VALUES (2, 1000002, 2, 'system', '2021-07-26 02:21:50', 'system', '2021-07-26 02:21:50');
INSERT INTO demo.user_role (id, user_id, role_id, created_by, created_at, updated_by, updated_at) VALUES (3, 1000003, 3, 'system', '2021-07-26 02:21:59', 'system', '2021-07-26 02:21:59');