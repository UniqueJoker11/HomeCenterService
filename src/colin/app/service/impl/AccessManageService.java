package colin.app.service.impl;

import colin.app.common.DateUtils;
import colin.app.core.dao.AccessManageDao;
import colin.app.core.pojo.AccessEntity;
import colin.app.service.inter.IAccessManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2015/3/27.
 */
@Service
@Transactional
public class AccessManageService implements IAccessManageService{

    @Resource
    AccessManageDao accessManageDao;
    @Override
    public boolean addNetAccessTime() {
        //获取今日的日期
        boolean result=false;
        String currentDate= DateUtils.getCurrentDateOfDay();
        Map<String,Object> searchParams=new HashMap<String,Object>();
        searchParams.put("access_date",currentDate);
        List<AccessEntity> resultList=accessManageDao.seletcObjectByMap(AccessEntity.class, searchParams);
        if(resultList!=null&&!resultList.isEmpty()){
            //假如存在,则更新数据
            AccessEntity accessEntity=resultList.get(0);
            accessEntity.setAccess_time(accessEntity.getAccess_time()+1);
            result=accessManageDao.updateObjInfo(accessEntity);
        }else{
            //假如不存在，则新添数据
            AccessEntity accessEntity=new AccessEntity();
            accessEntity.setAccess_date(currentDate);
            accessEntity.setAccess_time(1);
            result=accessManageDao.addObjInfo(accessEntity);
        }
        return result;
    }
}
