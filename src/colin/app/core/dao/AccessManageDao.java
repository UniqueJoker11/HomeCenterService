package colin.app.core.dao;

import colin.app.common.bean.Page;
import colin.app.core.dao.common.CommonDao;
import colin.app.core.pojo.AccessEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by ASUS on 2015/3/27.
 */
@Repository
public class AccessManageDao extends CommonDao<AccessEntity>{
    @Override
    public Page<AccessEntity> searchObjPageInfo(Map<String, Object> paramsMap) {
        return null;
    }
}
