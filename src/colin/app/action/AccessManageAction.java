package colin.app.action;

import colin.app.common.ReturnContext;
import colin.app.service.impl.AccessManageService;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by ASUS on 2015/3/27.
 * 网站访问记录
 */
@Controller
public class AccessManageAction {

    @Resource
    private AccessManageService accessManageService;
    @RequestMapping(value = "/addNewAccessTime.action",method= RequestMethod.POST)
    public Object addNetAccessTime(HttpServletRequest request){
        boolean result=accessManageService.addNetAccessTime();
        ReturnContext returnContext=new ReturnContext();
        if(result){
            returnContext.setIsSuccess(true);
            returnContext.setRetsultMsg("记录访问成功");
        }else{
            returnContext.setIsSuccess(false);
            returnContext.setRetsultMsg("记录访问失败");
        }
        return returnContext;
    }

}
