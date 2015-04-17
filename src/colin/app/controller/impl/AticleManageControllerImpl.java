package colin.app.controller.impl;

import colin.app.common.ReturnContext;
import colin.app.common.bean.AticleDetailInfo;
import colin.app.service.inter.IAticleManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
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
    @RequestMapping(value = "/getAticleDeatil.html",method = RequestMethod.GET)
    public String getAticleDeatilInfo(HttpServletRequest request){
        String prevId="",id="",nextId="";
        if(request.getParameter("prevId")!=null){
            prevId=request.getParameter("prevId").toString();
        }
        if (request.getParameter("id")!=null){
            id=request.getParameter("id").toString();
        }
        if(request.getParameter("nextId")!=null){
            nextId=request.getParameter("nextId").toString();
        }
        AticleDetailInfo aticleDetailInfo=aticleManageService.getAticleDetailInfo(prevId,id,nextId);
        if(aticleDetailInfo!=null){
            request.setAttribute("aticleDetailInfo",aticleDetailInfo);
            return "blog_content";
        }else{
            return "blog_index";
        }

    }
}
