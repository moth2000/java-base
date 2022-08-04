CREATE TABLE scu_study_db.account (
 account_id varchar(20) NOT NULL COMMENT '账号ID',
userName varchar(100) DEFAULT "" NOT NULL COMMENT '用户名',
password varchar(200) NOT NULL COMMENT '密码',
balance DOUBLE DEFAULT 0 NULL COMMENT '余额'
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE scu_study_db.transfer_order (
order_id BIGINT UNSIGNED auto_increment NOT NULL COMMENT '订单号',
from_account_id varchar(100) NOT NULL COMMENT '转账人用户id',
to_account_id varchar(100) NOT NULL COMMENT '被转账人用户id',
amount DOUBLE NOT NULL COMMENT '转账金额',
is_success TINYINT(1) DEFAULT 0 NOT NULL COMMENT '转账是否成功',
`time` DATETIME NULL COMMENT '转账日期',
primary key(order_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='转账记录';

CREATE TABLE `cash_order`(
    #写数据字段
    `order_id` bigint unsigned auto_increment NOT NULL COMMENT '订单号',
    `account_id` varchar(100) NOT NULL  comment '账号ID',
    `amount` double NOT NULL COMMENT '金额',
    `is_success` tinyint(1) DEFAULT 0 NOT NULL comment '是否成功',
    `time` datetime NULL comment '时间',
    `type` varchar(100) NOT NULL comment '类型',
    primary key (order_id)
)ENGINE = InnoDB comment = '提现记录';

insert into cash_order(`account_id`, `amount`, `is_success`, `time`, `type`)
values
(1,12,1,'2020-01-01 00:00:00','DEPOSIT'),
(2,12,1,'2020-01-01 00:00:00','DEPOSIT'),
(3,12,1,'2020-01-01 00:00:00','DEPOSIT'),
(4,12,1,'2020-01-01 00:00:00','DEPOSIT'),
(5,12,1,'2020-01-01 00:00:00','DEPOSIT');

select account_id,amount
from cash_order
where amount > 5;

delete from cash_order
where amount > 11;

update cash_order set amount = amount + 1, is_success = 0
where order_id = 4;

