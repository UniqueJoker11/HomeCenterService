package colin.app.core.dao;

import colin.app.common.bean.Page;
import colin.app.core.dao.common.CommonDao;
import colin.app.core.pojo.FriendWebsiteEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by DELL on 2015/7/2.
 */
@Repository
public class FriendWebsiteManageDao extends CommonDao<FriendWebsiteEntity>{
    /**
     * 分页数据查找,初始化，首次调用该方法。此后调用新的的方法
     *
     * @param paramsMap
     */
    @Override
    public Page<FriendWebsiteEntity> searchObjPageInfo(Map<String, Object> paramsMap) {
        return null;
    }
}
