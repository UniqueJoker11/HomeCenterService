package colin.app.service.impl;

import colin.app.common.DateUtils;
import colin.app.common.bean.Page;
import colin.app.core.dao.AticleManageDao;
import colin.app.core.pojo.AticleEntity;
import colin.app.service.inter.IAticleManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joker on 14-10-12.
 */
@Service
@Transactional
public class AticleManageService implements IAticleManageService{

    @Resource
    private AticleManageDao aticleManageDao;
    /**
     * @param params
     */


    @Override
    public boolean saveAticleContent(Map<String, Object> params) {
        AticleEntity aticleEntity=new AticleEntity();
        aticleEntity.setAticleName(params.get("aticleTitle").toString());
        aticleEntity.setAticleCrTime(DateUtils.getCurrentDate());
        aticleEntity.setAticleCrUser(params.get("loginName").toString());
        aticleEntity.setAticleDigest(params.get("aticleDigest").toString());
        System.out.println(params.get("aticleDigest").toString());
        aticleEntity.setAticleContent(params.get("aticleContent").toString());
        aticleEntity.setAticleReadNum("0");
        boolean result=aticleManageDao.addObjInfo(aticleEntity);
        return result;
    }

    /**
     * @param params
     */
    @Override
    public boolean editAticleContent(Map<String, Object> params) {
        return false;
    }

    /**
     * @param params
     */
    @Override
    public boolean deleteAticleContent(Map<String, Object> params) {
        return false;
    }

    /**
     * @param params
     */
    @Override
    public boolean updateAticleContent(Map<String, Object> params) {
        return false;
    }

    /**
     * 分页查询所有的书籍
     *
     * @param params
     */
    @Override
    public  Map<String,Object> searchAticlePageContent(Map<String, Object> params) {
        Map<String,Object> resultMap=new HashMap<String,Object>();
        Page<AticleEntity> pageContent=aticleManageDao.searchObjPageInfo(params);
        resultMap.put("pageContent",pageContent);
        return resultMap;
    }
}
