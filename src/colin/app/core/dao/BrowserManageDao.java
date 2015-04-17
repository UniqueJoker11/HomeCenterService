package colin.app.core.dao;

/**
 * Created by ASUS on 2015/3/26.
 */

import colin.app.common.bean.Page;
import colin.app.core.dao.common.CommonDao;
import colin.app.core.pojo.BrowserEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class BrowserManageDao extends CommonDao<BrowserEntity>{

    @Override
    public Page<BrowserEntity> searchObjPageInfo(Map<String, Object> paramsMap) {
        return null;
    }
}
