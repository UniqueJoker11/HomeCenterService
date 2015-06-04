package colin.app.service.inter;

import antlr.actions.cpp.ActionLexerTokenTypes;
import colin.app.common.bean.AticleDetailInfo;
import colin.app.core.pojo.AticleEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by joker on 14-10-12.
 */
public interface IAticleManageService {

    /**
     *
     * */
    public boolean saveAticleContent(Map<String, Object> params);

    /**
     *
     * */
    public boolean editAticleContent(Map<String, String[]>  params);

    /**
     *
     * */
    public boolean deleteAticleContent(Map<String, Object> params);

    /**
     *
     * */
    public boolean updateAticleContent(Map<String, Object> params);

    /**
     * 分页查询所有的书籍
     */
    public Map<String, Object> searchAticlePageContent(Map<String, Object> params);

    /**
     * 获取文章的详情
     *
     * @param id
     * @return
     */
    public AticleDetailInfo getAticleDetailInfo(String prevId, String id, String nextId);

    /**
     * 按照点击次数进行排序
     *
     * @return
     */
    public List<AticleEntity> getAticleClickRank();

    /**
     * 按照最新的发布时间排序
     * @return
     */
    public List<AticleEntity> getAticlePublishTimeRank();
}
