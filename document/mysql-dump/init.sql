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
  AUTO_INCREMENT = 1000001
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
  AUTO_INCREMENT = 1000001
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='company';


INSERT INTO role(name, created_by, updated_by) VALUES ('super', 'system', 'system');
INSERT INTO role(name, created_by, updated_by) VALUES ('manager', 'system', 'system');
INSERT INTO role(name, created_by, updated_by) VALUES ('operator', 'system', 'system');

INSERT INTO demo.user (id, name, password, created_by, created_at, updated_by, updated_at) VALUES (1, 'adm', '$2a$10$y3Fk9YL1fL1dJAybITovr.ilZQnyKMHqzwbRDzQ31GiNFDNPRyREa', 'system', now(), 'system', now());
INSERT INTO demo.user (id, name, password, created_by, created_at, updated_by, updated_at) VALUES (2, 'lead', '$2a$10$.faDvHFrI4CbHTRtFz6EluIaN4/9aK2dMVv4e8KpTLXHdk7nq92eu', 'system', now(), 'system', now());
INSERT INTO demo.user (id, name, password, created_by, created_at, updated_by, updated_at) VALUES (3, 'customer', '$2a$10$sMD7XhQFQ4cwjnt8TV1xeuLqD4Z8qY8wbKC68AIhFSV9dytfIUrWm', 'system', now(), 'system', now());