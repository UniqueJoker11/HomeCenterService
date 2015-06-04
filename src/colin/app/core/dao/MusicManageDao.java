package colin.app.core.dao;

import colin.app.common.bean.Page;
import colin.app.core.dao.common.CommonDao;
import colin.app.core.pojo.MusicEntity;

import java.util.Map;

/**
 * Created by DELL on 2015/5/25.
 */
public class MusicManageDao extends CommonDao<MusicEntity> {
    /**
     * 分页数据查找,初始化，首次调用该方法。此后调用新的的方法
     *
     * @param paramsMap
     */
    @Override
    public Page<MusicEntity> searchObjPageInfo(Map<String, Object> paramsMap) {
        return null;
    }
}
