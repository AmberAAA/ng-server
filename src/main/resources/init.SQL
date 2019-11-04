CREATE TABLE `server-dev`.`todo_master`(
                                           `id` INT(32) UNSIGNED NOT NULL AUTO_INCREMENT,
                                           `title` VARCHAR(256) NOT NULL,
                                           `state` TINYINT(1) NOT NULL DEFAULT '0',
                                           `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                           `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                           PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8mb4;


CREATE TABLE `server-dev`.`todo_child`(
                                          `id` INT(32) UNSIGNED NOT NULL AUTO_INCREMENT,
                                          `title` VARCHAR(256),
                                          `state` TINYINT(1) DEFAULT 0,
                                          `master_id` INT(32) UNSIGNED,
                                          `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                          `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                          PRIMARY KEY (`id`),
                                          INDEX `idx_master_id` (`master_id`),
                                          FOREIGN KEY (`master_id`) REFERENCES `server-dev`.`todo_master`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE
) ENGINE=INNODB CHARSET=utf8mb4;


CREATE TABLE `server-dev`.`user`(
                                          `id` INT(32) UNSIGNED NOT NULL AUTO_INCREMENT,
                                          `name` VARCHAR(32),
                                          `password` VARCHAR(32),
                                          `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                          `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                          PRIMARY KEY (`id`),
                                          UNIQUE INDEX `idx_name` (`name`)
) ENGINE=INNODB CHARSET=utf8mb4;