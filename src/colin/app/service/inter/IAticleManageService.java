package colin.app.service.inter;

import colin.app.common.bean.AticleDetailInfo;
import colin.app.core.pojo.AticleEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by joker on 14-10-12.
 */
public interface IAticleManageService{

    /**
     *
     * */
    public boolean saveAticleContent(Map<String,Object> params);

    /**
     *
     * */
    public boolean editAticleContent(Map<String,Object> params);

    /**
     *
     * */
    public boolean deleteAticleContent(Map<String,Object> params);

    /**
     *
     * */
    public boolean updateAticleContent(Map<String,Object> params);
    /**
     * 分页查询所有的书籍
     * */
    public Map<String,Object> searchAticlePageContent(Map<String,Object> params);

    /**
     * 获取文章的详情
     * @param id
     * @return
     */
    public AticleDetailInfo getAticleDetailInfo(String prevId,String id,String nextId);

}
