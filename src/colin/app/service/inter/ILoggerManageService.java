package colin.app.service.inter;

import colin.app.core.pojo.LoggerEntity;

import java.util.Map;

/**
 * Created by joker on 15-2-4.
 */
public interface ILoggerManageService {
    /**
     * user register info save
     */
    public boolean saveLoggerInfo(LoggerEntity loggerEntity);
}
