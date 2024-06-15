package com.nageoffer.shortlink.admin.test;

/**
 * ClassName:UserTableShardingTest
 * Description:
 * 用户表分表
 * @Author DubPAN
 * @Create2024/5/22 17:05
 * @Version 1.0
 */
public class UserTableShardingTest {
    public static final String SQL ="CREATE TABLE `t_link_stats_today_%d` (" +
            "`id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID'," +
            "`gid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'default' COMMENT '分组标识',\n" +
            "`full_short_url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '短链接',\n" +
            "`date` date DEFAULT NULL COMMENT '日期'," +
            "`today_pv` int DEFAULT '0' COMMENT '今日PV'," +
            "`today_uv` int DEFAULT '0' COMMENT '今日UV'," +
            "`today_uip` int DEFAULT '0' COMMENT '今日IP数'," +
            "`create_time` datetime DEFAULT NULL COMMENT '创建时间'," +
            "`update_time` datetime DEFAULT NULL COMMENT '修改时间'," +
            "`del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除'," +
            "PRIMARY KEY (`id`) USING BTREE," +
            "UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`gid`,`date`) USING BTREE" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;";
    public static void main(String[] args) {
        for (int i = 0;i<16;i++){//分成16张表
            System.out.printf((SQL)+"%n",i);
        }
    }
}
