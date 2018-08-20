package net.magicreal.module.service.impl;

import net.magicreal.module.manager.ArManager;
import net.magicreal.module.service.ArService;
import net.magicreal.module.util.projectconfig.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static net.magicreal.module.util.filters.JwtUtils.createJWT;
import static net.magicreal.module.util.projectconfig.ConstantInterface.*;

/**
 * @author: maochangan
 * @date: 2018/8/18 18:33
 * @description: ar service
 */
@Service
public class ArServiceImpl implements ArService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ArManager arManager;


    @Override
    public SerResult<String> getToken() {
        try {
            String key = createJWT("maochangan", 10, 10, AUDIENCE_CLIENT_ID, AUDIENCE_NAME, AUDIENCE_EXPIRES_SECOND, AUDIENCE_BASE64_SECRET);
            if (null == key) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(key);
            }
        } catch (Exception e) {
            logger.error("获取token失败：" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Integer> testJdbc() {
        try {
            SerResult<Integer> result = arManager.testSql();
            if (result.isSuccess()) {
                return result;
            }else{
                return SerResult.createFail();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return SerResult.createError();
        }
    }
}
