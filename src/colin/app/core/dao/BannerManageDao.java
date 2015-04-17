package colin.app.core.dao;

import colin.app.common.bean.Page;
import colin.app.core.dao.common.CommonDao;
import colin.app.core.pojo.BannerEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by ASUS on 2015/3/27.
 */
@Repository
public class BannerManageDao extends CommonDao<BannerEntity>{
    @Override
    public Page<BannerEntity> searchObjPageInfo(Map<String, Object> paramsMap) {
        return null;
    }
}
