package colin.app.service.impl;

import colin.app.common.CommonUtils;
import colin.app.common.DateUtils;
import colin.app.core.dao.WhisperManageDao;
import colin.app.core.pojo.WhisperEntity;
import colin.app.service.inter.IWhisperManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2015/4/23.
 */
@Transactional
@Service
public class WhisperManageService implements IWhisperManageService{
    @Resource
    private WhisperManageDao whisperManageDao;
    /**
     * 添加悄悄话
     *
     * @param params
     * @return
     */
    @Override
    public boolean addWhisperInfo(Map<String, Object> params) {
        WhisperEntity whisperEntity=new WhisperEntity();
        whisperEntity.setWhisper_content(params.get("whisperContent").toString());
        whisperEntity.setCreate_user(params.get("createUser").toString());
        whisperEntity.setCreate_time(DateUtils.getCurrentDate());
        return  whisperManageDao.addObjInfo(whisperEntity);
    }

    /**
     * 删除悄悄话
     *
     * @param params
     * @return
     */
    @Override
    public boolean delWhisperInfo(Map<String, Object> params) {
        WhisperEntity whisperEntity=whisperManageDao.selectUniqueObject(WhisperEntity.class, params);
        return whisperManageDao.deleteObjInfo(whisperEntity);
    }

    /**
     * 更新悄悄话
     *
     * @param params
     * @return
     */
    @Override
    public boolean updateWhisperInfo(Map<String, Object> params) {
        return false;
    }

    /**
     * @return
     */
    @Override
    public List<WhisperEntity> getAllWhisperInfo() {
        List<WhisperEntity> resultList=whisperManageDao.selectAllObject(WhisperEntity.class);
        return resultList;
    }
}
