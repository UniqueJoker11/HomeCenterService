package colin.app.core.dao;

import colin.app.common.bean.Page;
import colin.app.core.dao.common.CommonDao;
import colin.app.core.pojo.LoggerEntity;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by joker on 15-2-4.
 */
@Repository
public class LoggerManageDao extends CommonDao<LoggerEntity> {

    /**
     * 分页数据查找,初始化，首次调用该方法。此后调用新的的方法
     *
     * @param paramsMap
     */
    @Override
    public Page<LoggerEntity> searchObjPageInfo(Map<String, Object> paramsMap) {
        return null;
    }

    /**
     * 查询数据
     *
     * @param criteria
     */
    public Map<String, Object> searchObjInfo(DetachedCriteria criteria) {
        return null;
    }

    /**
     * 验证数据是否存在
     *
     * @param criteria
     */
    public boolean isObjExists(DetachedCriteria criteria) {
        return false;
    }
}
