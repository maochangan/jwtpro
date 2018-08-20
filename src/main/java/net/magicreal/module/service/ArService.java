package net.magicreal.module.service;

import net.magicreal.module.util.projectconfig.SerResult;

/**
 * @author: maochangan
 * @date: 2018/8/18 18:33
 * @description: ar service
 */
public interface ArService {


    /**
     * 获取token 测试
     * @return
     */
    SerResult<String> getToken();

    /**
     * 数据库连接测试
     * @return
     */
    SerResult<Integer> testJdbc();
}
