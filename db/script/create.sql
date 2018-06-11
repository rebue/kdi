/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/6/11 9:23:11                            */
/*==============================================================*/


DROP TABLE IF EXISTS KDI_COMPANY;

DROP TABLE IF EXISTS KDI_LOGISTIC;

DROP TABLE IF EXISTS KDI_SENDER;

DROP TABLE IF EXISTS KDI_TRACE;

/*==============================================================*/
/* Table: KDI_COMPANY                                           */
/*==============================================================*/
CREATE TABLE KDI_COMPANY
(
   ID                   BIGINT NOT NULL COMMENT '快递公司信息ID',
   COMPANY_NAME         VARCHAR(50) NOT NULL COMMENT '快递公司名称',
   COMPANY_ACCOUNT      VARCHAR(50) NOT NULL COMMENT '快递公司账号',
   COMPANY_PWD          VARCHAR(50) NOT NULL COMMENT '快递公司密码',
   COMPANY_CODE         VARCHAR(50) NOT NULL COMMENT '快递公司编号',
   PAY_TYPE             TINYINT NOT NULL COMMENT '支付类型
            运费支付方式:
            1-现付
            2-到付
            3-月结
            4-第三方付',
   ENTRY_TIME           DATETIME NOT NULL COMMENT '录入时间',
   PRIMARY KEY (ID)
);

ALTER TABLE KDI_COMPANY COMMENT '快递公司信息';

/*==============================================================*/
/* Table: KDI_LOGISTIC                                          */
/*==============================================================*/
CREATE TABLE KDI_LOGISTIC
(
   ID                   BIGINT NOT NULL COMMENT '物流订单ID',
   SHIPPER_CODE         VARCHAR(10) NOT NULL COMMENT '快递公司编码',
   LOGISTIC_CODE        VARCHAR(30) NOT NULL COMMENT '物流订单号',
   LOGISTIC_STATUS      VARCHAR(3) NOT NULL DEFAULT '0' COMMENT '物流订单状态
            0-无轨迹
            1-已揽收
            2-在途中 201-到达派件城市 202-派件中 211-已放入快递柜或驿站
            3-已签收 311-已取出快递柜或驿站
            4-问题件 401-发货无信息 402-超时未签收 403-超时未更新 404-拒收(退件) 412-快递柜或驿站超时未取',
   ORDER_TIME           DATETIME NOT NULL COMMENT '下单时间',
   UPDATE_TIME          DATETIME NOT NULL COMMENT '更新时间',
   ESTIMATED_ARRIVAL_TIME DATETIME COMMENT '预计到达时间',
   CITY                 VARCHAR(20) COMMENT '所在城市',
   PAY_TYPE             TINYINT COMMENT '支付类型
            运费支付方式:
            1-现付
            2-到付
            3-月结
            4-第三方付',
   EXP_TYPE             TINYINT COMMENT '快递类型
            1-标准快件
            
            详细快递类型参考《快递公司快递业务类型.xlsx》',
   ORDER_ID             BIGINT NOT NULL COMMENT '订单ID',
   ORDER_TITLE          VARCHAR(100) COMMENT '订单标题',
   ORDER_DETAIL         VARCHAR(300) COMMENT '订单详情',
   SENDER_NAME          VARCHAR(30) COMMENT '发件人名称',
   SENDER_TEL           VARCHAR(20) COMMENT '发件人电话',
   SENDER_MOBILE        VARCHAR(20) COMMENT '发件人手机',
   SENDER_PROVINCE      VARCHAR(20) COMMENT '发件省',
   SENDER_CITY          VARCHAR(20) COMMENT '发件市',
   SENDER_EXP_AREA      VARCHAR(20) COMMENT '发件区',
   SENDER_ADDRESS       VARCHAR(300) COMMENT '发件人详细地址',
   SENDER_POST_CODE     CHAR(6) COMMENT '发件地邮编',
   RECEIVER_NAME        VARCHAR(30) COMMENT '收件人名称',
   RECEIVER_TEL         VARCHAR(20) COMMENT '收件人电话',
   RECEIVER_MOBILE      VARCHAR(20) COMMENT '收件人手机',
   RECEIVER_PROVINCE    VARCHAR(20) COMMENT '收件省',
   RECEIVER_CITY        VARCHAR(20) COMMENT '收件市',
   RECEIVER_EXP_AREA    VARCHAR(20) COMMENT '收件区',
   RECEIVER_ADDRESS     VARCHAR(300) COMMENT '收件人详细地址',
   RECEIVER_POST_CODE   CHAR(6) COMMENT '收件地邮编',
   PRINT_PAGE           TEXT COMMENT '打印页面',
   PRIMARY KEY (ID),
   KEY AK_SHIPPER_LOGISTIC_CODE (SHIPPER_CODE, LOGISTIC_CODE),
   UNIQUE KEY AK_ORDER_ID (ORDER_ID)
);

ALTER TABLE KDI_LOGISTIC COMMENT '物流订单';

/*==============================================================*/
/* Table: KDI_SENDER                                            */
/*==============================================================*/
CREATE TABLE KDI_SENDER
(
   ID                   BIGINT NOT NULL COMMENT '发件人信息ID',
   SENDER_NAME          VARCHAR(30) NOT NULL COMMENT '发件人名称',
   SENDER_TEL           VARCHAR(20) COMMENT '发件人电话',
   SENDER_MOBILE        VARCHAR(20) COMMENT '发件人手机',
   SENDER_PROVINCE      VARCHAR(20) NOT NULL COMMENT '发件省',
   SENDER_CITY          VARCHAR(20) NOT NULL COMMENT '发件市',
   SENDER_EXP_AREA      VARCHAR(20) NOT NULL COMMENT '发件区',
   SENDER_ADDRESS       VARCHAR(300) NOT NULL COMMENT '发件人详细地址',
   SENDER_POST_CODE     CHAR(6) NOT NULL COMMENT '发件地邮编',
   IS_DEFAULT           BOOL NOT NULL COMMENT '是否为默认发件人（true：默认  false：不是默认）',
   ENTRY_TIME           DATETIME NOT NULL COMMENT '录入时间',
   PRIMARY KEY (ID)
);

ALTER TABLE KDI_SENDER COMMENT '发件人信息';

/*==============================================================*/
/* Table: KDI_TRACE                                             */
/*==============================================================*/
CREATE TABLE KDI_TRACE
(
   ID                   BIGINT NOT NULL COMMENT '物流轨迹ID',
   LOGISTIC_ID          BIGINT NOT NULL COMMENT '物流ID',
   TRACE_DESC           VARCHAR(100) NOT NULL COMMENT '轨迹描述',
   HAPPEN_TIME          DATETIME NOT NULL COMMENT '发生时间',
   LOGISTIC_STATUS      VARCHAR(3) COMMENT '物流状态
            1-已揽收
            2-在途中 201-到达派件城市 202-派件中 211-已放入快递柜或 驿站
            3-已签收 311-已取出快递柜或 驿站
            4-问题件 401-发货无信息 402-超时未签收 403-超时未更新 404-拒收(退件) 412-快递柜或驿站超 时未取',
   CITY                 VARCHAR(20) COMMENT '所在城市',
   PRIMARY KEY (ID)
);

ALTER TABLE KDI_TRACE COMMENT '物流轨迹';

