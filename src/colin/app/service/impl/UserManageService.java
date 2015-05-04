package colin.app.service.impl;

import colin.app.core.dao.UserManageDao;
import colin.app.core.pojo.UserEntity;
import colin.app.service.inter.IUserManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by joker on 14-9-13.
 */
@Service
@Transactional
public class UserManageService implements IUserManageService {

    @Resource
    private UserManageDao userManageDao;

    /*
    * 验证注册账号是否存在，存在返回true，否则false
    *
    * */
    @Override
    @Transactional
    public boolean validateRegisterUserInfo(Map<String, Object> paramsMap) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(paramsMap.get("username").toString());
        userEntity.setPassword(paramsMap.get("password").toString());
        List<UserEntity> resultList = this.userManageDao.selectUniqueObject(UserEntity.class, paramsMap);
        if (resultList == null || resultList.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * query user info
     */
    @Override
    @Transactional
    public List<UserEntity> queryUserInfo(Map<String, Object> paramsMap) {
        return userManageDao.seletcObjectByMap(UserEntity.class,paramsMap);
    }

    /**
     * validate userLogin
     *
     * @param paramsMap
     */
    @Override
    public boolean validateUserInfo(Map<String, Object> paramsMap) {
        boolean result = true;
        if (paramsMap != null) {
            UserEntity resultEntity = userManageDao.selectUniqueObject(UserEntity.class,paramsMap);
            if(resultEntity==null){
                result=false;
            }
        }
        return result;

    }

    /**
     * 添加注册用户
     *
     * @param paramsMap
     * @return
     */
    @Override
    public boolean registerUserInfo(Map<String, Object> paramsMap) {
        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(paramsMap.get("username").toString());
        userEntity.setPassword(paramsMap.get("userpw").toString());
        boolean result=userManageDao.addObjInfo(userEntity);
        return result;
    }
}
