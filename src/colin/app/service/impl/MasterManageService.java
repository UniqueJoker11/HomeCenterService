package colin.app.service.impl;

import colin.app.common.bean.Page;
import colin.app.core.dao.MasterManageDao;
import colin.app.core.pojo.MasterEntity;
import colin.app.service.inter.IMasterManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2015/4/21.
 */
@Transactional
@Service
public class MasterManageService implements IMasterManageService{
    @Resource
    private MasterManageDao masterManageDao;
    /**
     * 添加新的博主信息
     *
     * @param params
     * @return
     */
    @Override
    public boolean addMasterInfo(Map<String, Object> params) {
        MasterEntity masterEntity=new MasterEntity();
        masterEntity.setMaster_carrer(params.get("masterCarrer").toString());
        masterEntity.setMaster_header(params.get("masterHeader").toString());
        masterEntity.setMaster_introduce(params.get("masterIntroduce").toString());
        masterEntity.setMaster_name(params.get("masterName").toString());
        masterEntity.setMaster_words(params.get("masterWords").toString());
        return masterManageDao.addObjInfo(masterEntity);
    }

    /**
     * 更新博主信息
     *
     * @param parmas
     * @return
     */
    @Override
    public boolean updateMasterInfo(Map<String, Object> parmas) {
        List<MasterEntity> masterEntityList=masterManageDao.selectAllObject(MasterEntity.class);
        MasterEntity currentMasterEntity=masterEntityList.get(0);
        if(parmas.containsKey("masterName")){
            currentMasterEntity.setMaster_name(parmas.get("masterName").toString());
        }
        if(parmas.containsKey("masterCarrer")){
            currentMasterEntity.setMaster_carrer(parmas.get("masterCarrer").toString());
        }
        if(parmas.containsKey("masterIntroduce")){
            currentMasterEntity.setMaster_introduce(parmas.get("masterIntroduce").toString());
        }
        if(parmas.containsKey("masterWords")){
            currentMasterEntity.setMaster_words(parmas.get("masterWords").toString());
        }
        return masterManageDao.updateObjInfo(currentMasterEntity);
    }

    /**
     * 删除博主信息
     *
     * @param params
     * @return
     */
    @Override
    public boolean deleateMasterInfo(Map<String, Object> params) {
        return false;
    }

    /**
     * 查找博主信息
     *
     * @param searchParams
     * @return
     */
    @Override
    public Map<String,Object> searchMasterInfo(Map<String, Object> searchParams) {

        List<MasterEntity> resultList=masterManageDao.selectAllObject(MasterEntity.class);
        Map<String,Object> result=new HashMap<String,Object>();
        if(resultList.isEmpty()||resultList.size()==0){
            result.put("isExist",false);
        }else{
            result.put("isExist",true);
            result.put("entity",resultList);
        }
        return result;
    }
}
