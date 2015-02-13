package colin.app.controller.impl;

import colin.app.service.inter.IUserManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class UserManageControllerImpl {

    @Resource
    private IUserManageService iUserManageService;

    /**
     * 用户登录完善
     * */
    @RequestMapping(value = "/userLogin.html")
    public String userLogin(HttpServletRequest request,HttpServletResponse response){
        Map<String,String[]> paramsStr=request.getParameterMap();
        Map<String,Object> paramsMap=new HashMap<String, Object>();
        paramsMap.put("username",request.getParameter("userLoginName"));
        paramsMap.put("password",request.getParameter("userLoginPassword"));
        boolean resturnResult=iUserManageService.validateUserInfo(paramsMap);
        if(resturnResult){
            HttpSession session=request.getSession();
            session.setAttribute("loginName",request.getParameter("userLoginName"));
            return "index";
        }else{
            request.setAttribute("isError",true);
            return "login";
        }

    }


}
