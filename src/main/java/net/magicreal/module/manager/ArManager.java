package net.magicreal.module.manager;

import net.magicreal.module.util.projectconfig.SerResult;

/**
 * @author: maochangan
 * @date: 2018/8/18 18:34
 * @description: ar manager
 */
public interface ArManager {


    /**
     * 数据库连接测试
     * @return
     */
    SerResult<Integer> testSql();
}
