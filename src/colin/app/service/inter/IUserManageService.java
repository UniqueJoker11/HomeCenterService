package colin.app.service.inter;

import colin.app.core.pojo.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by joker on 14-9-13.
 */
public interface IUserManageService {
    /**
     * user register info save
     */
    public boolean validateRegisterUserInfo(Map<String, Object> paramsMap);

    /**
     * query user info
     */

    public List<UserEntity> queryUserInfo(Map<String, Object> paramsMap);

    /**
     * validate userLogin
     * */
    public boolean validateUserInfo(Map<String,Object> paramsMap);

    /**
     * 添加注册用户
     * @param paramsMap
     * @return
     */
    public boolean registerUserInfo(Map<String,Object> paramsMap);
 }
