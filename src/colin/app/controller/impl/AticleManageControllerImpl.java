package colin.app.controller.impl;

import colin.app.service.inter.IAticleManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by joker on 14-10-12.
 */
@Controller
public class AticleManageControllerImpl {

    @Resource
    public IAticleManageService aticleManageService;

    @RequestMapping(value="/aticleSaveContent.html")
    public String saveAticleContent(HttpServletRequest request){
        //Map<String, String[]> hashMap=request.get("");
        String aticleContentTitle=request.getParameter("aticleTitle");
        String aticleDigest=request.getParameter("aticleDigest");
        String aticleContent=request.getParameter("");
        return "";
    }
}
