package colin.app.core.dao;

import colin.app.common.bean.Page;
import colin.app.core.dao.common.CommonDao;
import colin.app.core.pojo.WhisperEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by ASUS on 2015/4/23.
 */
@Repository
public class WhisperManageDao extends CommonDao<WhisperEntity>{
    /**
     * 分页数据查找,初始化，首次调用该方法。此后调用新的的方法
     *
     * @param paramsMap
     */
    @Override
    public Page searchObjPageInfo(Map paramsMap) {
        return null;
    }
}
