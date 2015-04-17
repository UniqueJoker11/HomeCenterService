package colin.app.core.dao;

import colin.app.common.bean.Page;
import colin.app.core.dao.common.CommonDao;
import colin.app.core.pojo.CommentEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by ASUS on 2015/3/26.
 */
@Repository
public class CommentManageDao extends CommonDao<CommentEntity> {
    @Override
    public Page<CommentEntity> searchObjPageInfo(Map<String, Object> paramsMap) {
        return null;
    }
}
