package colin.app.action;

import colin.app.common.CommonUtils;
import colin.app.common.ReturnContext;
import colin.app.service.inter.IUserManageService;
import org.hibernate.loader.custom.Return;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joker on 14-9-13.
 */
@Controller
public class UserManageAction {
    @Resource
    private IUserManageService userManageService;

    /*检测用户名和密码是否正确，不正确则返回数据*/
    @ResponseBody
    @RequestMapping(value = "/validateUserInfo.action", method = RequestMethod.POST)
    public Object saveUserInfo(@RequestParam String username, @RequestParam String password) {
        ReturnContext returnContext = ReturnContext.createReturnContext();
        Map<String, Object> paramsMap = CommonUtils.initParamsMap();
        if (CommonUtils.handleEmptyStr(username)) {
            paramsMap.put("username", username);
        } else {
            returnContext.setIsSuccess(false);
            returnContext.setRetsultMsg("用户名不能为空！");
            returnContext.setFieldName("username");
            return returnContext;
        }
        if (CommonUtils.handleEmptyStr(password)) {
            paramsMap.put("password", password);
        } else {
            returnContext.setIsSuccess(false);
            returnContext.setFieldName("password");
            returnContext.setRetsultMsg("用户名不能为空！");
            return returnContext;
        }
        boolean result = this.userManageService.validateRegisterUserInfo(paramsMap);
        if (!result) {
            returnContext.setIsSuccess(false);
            returnContext.setFieldName("saveInfo");
            returnContext.setRetsultMsg("保存用户注册信息失败");
            return returnContext;
        } else {

            returnContext.setIsSuccess(true);
            return returnContext;
        }

    }
/**
 * 检测用户名和密码是否匹配
 * */

@ResponseBody
@RequestMapping(value = "/validateUserLogin.action",method = RequestMethod.POST)
public ReturnContext validateUserLoginInfo(@RequestParam String username,@RequestParam String password){
    Map<String,Object> params=new HashMap<String,Object>();
    params.put("username",username);
    params.put("password",password);
    boolean returnResult=userManageService.validateUserInfo(params);
    ReturnContext returnContext=ReturnContext.createReturnContext();
    returnContext.setIsSuccess(returnResult);
    return returnContext;
}
/**
     * 检测用户名是否存在
     */
    @ResponseBody
    @RequestMapping(value ="/isUsernameExists.action",method = RequestMethod.POST)
    public ReturnContext isUsernameExists(@RequestParam String username) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        boolean returnResult = userManageService.validateUserInfo(params);
        //声明返回结果对象
        ReturnContext returnContext = ReturnContext.createReturnContext();
        returnContext.setIsSuccess(returnResult);
        return returnContext;
    }

    /**
     * hasParams 0没有参数，1有参数
     */
    @ResponseBody
    @RequestMapping(value = "/queryUserInfo.action", method = RequestMethod.POST)
    public Object queryUserInfo(HttpServletRequest request) {
        String hasParams = request.getParameter("hasParams");
        Map<String, Object> paramsMap = CommonUtils.initParamsMap();
        ReturnContext returnContext = ReturnContext.createReturnContext();
        if (hasParams.equals(0)) {
            paramsMap.put("hasParams", false);

        } else {
            paramsMap.put("hasParams", true);
            paramsMap.put("username", request.getParameter("username"));
        }
        returnContext.setIsSuccess(true);
        returnContext.setRetsultData(this.userManageService.queryUserInfo(paramsMap));
        return returnContext;
    }
    @ResponseBody
    @RequestMapping(value = "/registerUserInfo.action",method = RequestMethod.POST)
    public Object registerUsername(@RequestParam String username,@RequestParam String userpw){
         ReturnContext returnContext=new ReturnContext();
         if(!username.equals("")){
           if(!userpw.equals("")){
                Map<String,Object> params=new HashMap<String,Object>();
               params.put("username",username);
               params.put("userpw",userpw);
               if(userManageService.registerUserInfo(params)){
                   returnContext.setIsSuccess(true);
               }else{
                   returnContext.setIsSuccess(false);
                   returnContext.setRetsultMsg("注册用户出现问题，请稍候重试！");
               }
           }else{
               returnContext.setIsSuccess(false);
               returnContext.setRetsultMsg("密码不能为空！");
           }
         }else{
             returnContext.setIsSuccess(false);
             returnContext.setRetsultMsg("用户名不能为空！");
         }
         return  returnContext;
    }
}
