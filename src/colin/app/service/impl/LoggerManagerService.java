package colin.app.service.impl;

import colin.app.core.dao.LoggerManageDao;
import colin.app.core.pojo.LoggerEntity;
import colin.app.service.inter.ILoggerManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by joker on 15-2-4.
 */
@Service
@Transactional
public class LoggerManagerService implements ILoggerManageService {
    @Resource
    private LoggerManageDao loggerManageDao;
    /**
     * user register info save
     *
     * @param loggerEntity
     */

    @Override
    public boolean saveLoggerInfo(LoggerEntity loggerEntity) {
        return loggerManageDao.addObjInfo(loggerEntity);
    }
}
