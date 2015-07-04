package colin.app.service.impl;

import colin.app.common.DateUtils;
import colin.app.common.bean.AticleBean;
import colin.app.common.bean.AticleDetailInfo;
import colin.app.common.bean.Page;
import colin.app.core.dao.AticleManageDao;
import colin.app.core.dao.BrowserManageDao;
import colin.app.core.dao.CommentManageDao;
import colin.app.core.pojo.AticleEntity;
import colin.app.core.pojo.BrowserEntity;
import colin.app.core.pojo.CommentEntity;
import colin.app.service.inter.IAticleManageService;
import org.beetl.ext.fn.ParseInt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by joker on 14-10-12.
 */
@Service
@Transactional
public class AticleManageService implements IAticleManageService {

    @Resource
    private AticleManageDao aticleManageDao;
    @Resource
    private CommentManageDao commentManageDao;
    @Resource
    private BrowserManageDao browserManageDao;

    /**
     * @param params
     */


    @Override
    public boolean saveAticleContent(Map<String, Object> params) {
        AticleEntity aticleEntity = new AticleEntity();
        aticleEntity.setAticleId(UUID.randomUUID().toString());
        aticleEntity.setAticleName(params.get("aticleTitle").toString());
        aticleEntity.setAticleCrTime(DateUtils.getCurrentDate());
        aticleEntity.setAticleCrUser(params.get("aticleCrUser").toString());
        aticleEntity.setAticleDigest(params.get("aticleDigest").toString());
        aticleEntity.setAticleContent(params.get("aticleContent").toString());
        aticleEntity.setAticleCategory(params.get("aticleCatagory").toString());
        aticleEntity.setKeyWords(params.get("keyWords").toString());
        aticleEntity.setAticleCoverImg(params.get("aticleCoverImg").toString());
        aticleEntity.setAticleReadNum("0");
        boolean result = aticleManageDao.addObjInfo(aticleEntity);
        return result;
    }

    /**
     * @param params
     */
    @Override
    public boolean editAticleContent(Map<String, String[]> params) {
        Map<String,Object> queryParams=new HashMap<>();
        queryParams.put("aticleId", params.get("aticleId")[0]);
        AticleEntity aticleEntity = aticleManageDao.selectUniqueObject(AticleEntity.class, queryParams);
        if (params.containsKey("aticleCategory")) {
            aticleEntity.setAticleCategory(params.get("aticleCategory")[0].toString());
        }
        if (params.containsKey("aticleContent")) {
            aticleEntity.setAticleContent(params.get("aticleContent")[0].toString());
        }
        if (params.containsKey("aticleCoverImg")) {
            aticleEntity.setAticleCoverImg(params.get("aticleCoverImg")[0].toString());
        }
        if (params.containsKey("aticleDigest")) {
            aticleEntity.setAticleDigest(params.get("aticleDigest")[0].toString());
        }
        if (params.containsKey("aticleName")) {
            aticleEntity.setAticleName(params.get("aticleName")[0].toString());
        }
        if (params.containsKey("aticleReadNum")) {
            aticleEntity.setAticleReadNum(aticleEntity.getAticleReadNum()+1);
        }
        if (params.containsKey("keyWords")) {
            aticleEntity.setKeyWords(params.get("keyWords")[0].toString());
        }
        return this.aticleManageDao.updateObjInfo(aticleEntity);
    }

    /**
     * @param params
     */
    @Override
    public boolean deleteAticleContent(Map<String, Object> params) {
        AticleEntity aticleEntity = aticleManageDao.selectUniqueObject(AticleEntity.class, params);
        boolean result = false;
        if (aticleEntity != null) {
            result = aticleManageDao.deleteObjInfo(aticleEntity);
        }
        return result;
    }

    /**
     * @param params
     */
    @Override
    public boolean updateAticleContent(Map<String, Object> params) {
        return false;
    }

    /**
     * 分页查询所有的文章，后台管理用
     *
     * @param params
     */
    @Override
    public Page<AticleBean> searchAticlePageContent(Map<String, Object> params) {
        //获取分页的查询对象
        Page<AticleEntity> pageContent = aticleManageDao.searchObjPageInfo(params);

        List<AticleEntity> aticleList = pageContent.getResultList();

        Page<AticleBean> resultPage = new Page<AticleBean>();

        List<AticleBean> aticleBeanList = new ArrayList<AticleBean>();

        for (AticleEntity aticleEntity : aticleList) {
           //获取文章实体类的转换Bean
            AticleBean aticleBean=this.transferAticleEntity(aticleEntity);
            //查询出所有的评论数
            Map<String, Object> commentParams = new HashMap<String, Object>();
            commentParams.put("comment_aticleId", aticleEntity.getAticleId());
            List<CommentEntity> commentList = commentManageDao.seletcObjectByMap(CommentEntity.class, commentParams);
            if (commentList.isEmpty() || commentList.size() == 0) {
                aticleBean.setAticleCommentNum(0);
            } else {
                aticleBean.setAticleCommentNum(commentList.size());
            }
            //查询出所有文章的浏览数目
            Map<String, Object> browserParams = new HashMap<String, Object>();
            browserParams.put("browser_aticleId", aticleEntity.getAticleId());
            List<BrowserEntity> browserList = browserManageDao.seletcObjectByMap(BrowserEntity.class, browserParams);
            if (browserList.isEmpty() || browserList.size() == 0) {
                aticleBean.setAticleBrowserNum(0);
            } else {
                aticleBean.setAticleBrowserNum(browserList.size());
            }

            aticleBeanList.add(aticleBean);
        }
        resultPage.setCurrentPage(pageContent.getCurrentPage());
        resultPage.setPageSize(pageContent.getPageSize());
        resultPage.setResultList(aticleBeanList);
        resultPage.setTotalPage(pageContent.getTotalPage());
        resultPage.setTotalRecord(pageContent.getTotalRecord());
        return resultPage;
    }

    /**
     * 获取文章实体类的转换Bean
     * @param aticleEntity
     * @return
     */
    private AticleBean transferAticleEntity(AticleEntity aticleEntity){
        AticleBean aticleBean = new AticleBean();
        aticleBean.setAticleId(aticleEntity.getAticleId());
        aticleBean.setAticleTitle(aticleEntity.getAticleName());
        aticleBean.setAticleAuthor(aticleEntity.getAticleCrUser());
        aticleBean.setAticleCreateDate(aticleEntity.getAticleCrTime());
        aticleBean.setAticleDigest(aticleEntity.getAticleDigest());
        aticleBean.setAticleCoverImg(aticleEntity.getAticleCoverImg());
        aticleBean.setAticleCategory(aticleEntity.getAticleCategory());
        return aticleBean;
    }
    /**
     * 获取文章详细内容
     * @param prevId
     * @param id
     * @param nextId
     * @return
     */
    @Override
    public AticleDetailInfo getAticleDetailInfo(String prevId, String id, String nextId) {
        AticleDetailInfo aticleDetailInfo = new AticleDetailInfo();
        boolean result = true;
        if (!prevId.equals("0")) {
            Map<String, Object> prevParams = new HashMap<String, Object>();
            prevParams.put("aticleId",prevId);
            AticleEntity preAticleEntity = aticleManageDao.selectUniqueObject(AticleEntity.class, prevParams);
            if (preAticleEntity != null) {
                aticleDetailInfo.setPrevTitle(preAticleEntity.getAticleName());
                aticleDetailInfo.setPreAticleId(preAticleEntity.getAticleId());
            }
        }
        if (!nextId.equals("0")) {
            Map<String, Object> nextParams = new HashMap<String, Object>();
            nextParams.put("aticleId",nextId);
            AticleEntity nextAticleEntity = aticleManageDao.selectUniqueObject(AticleEntity.class, nextParams);
            if (nextAticleEntity != null) {
                aticleDetailInfo.setNextTitle(nextAticleEntity.getAticleName());
                aticleDetailInfo.setNextAticleId(nextAticleEntity.getAticleId());
            }
        }
        if (!id.equals("")) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("aticleId", id);
            AticleEntity aticleEntity = aticleManageDao.selectUniqueObject(AticleEntity.class, params);
            aticleEntity.setAticleReadNum(String.valueOf(Integer.valueOf(aticleEntity.getAticleReadNum()) + 1));
            aticleManageDao.updateObjInfo(aticleEntity);
            aticleDetailInfo.setAticleCategory(aticleEntity.getAticleCategory());
            aticleDetailInfo.setAticleAuthor(aticleEntity.getAticleCrUser());
            aticleDetailInfo.setAticleContent(aticleEntity.getAticleContent());
            aticleDetailInfo.setAticleCreateDate(aticleEntity.getAticleCrTime());
            aticleDetailInfo.setAticleTitle(aticleEntity.getAticleName());
            aticleDetailInfo.setKeyWords(aticleEntity.getKeyWords());
            aticleDetailInfo.setAticleId(aticleEntity.getAticleId());
        } else {
            result = false;
        }
        if (result) {
            return aticleDetailInfo;
        } else {
            return null;
        }

    }

    /**
     * 获取文章排名
     * @return
     */
    public List<AticleEntity> getAticleClickRank() {
        return aticleManageDao.getOrderObjects(AticleEntity.class, null, "aticleReadNum", 0, 5);
    }

    /**
     * @return
     */
    @Override
    public List<AticleEntity> getAticlePublishTimeRank() {
        return aticleManageDao.getOrderObjects(AticleEntity.class, null, "aticleCrTime", 0, 5);
    }

    /**
     * 根绝ID获取文章具体信息
     *
     * @param params
     * @return
     */
    @Override
    public AticleEntity fetchSingleAticleService(Map<String,Object> params) {
        return this.aticleManageDao.selectUniqueObject(AticleEntity.class,params);
    }
}
