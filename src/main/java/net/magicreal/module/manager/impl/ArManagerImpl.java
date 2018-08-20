package net.magicreal.module.manager.impl;

import net.magicreal.module.dao.ArDao;
import net.magicreal.module.manager.ArManager;
import net.magicreal.module.util.projectconfig.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: maochangan
 * @date: 2018/8/18 18:35
 * @description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ArManagerImpl implements ArManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ArDao arDao;

    @Override
    public SerResult<Integer> testSql() {
        try {
            int result = arDao.arCount();
            return SerResult.createSuccess(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return SerResult.createError();
        }
    }
}
