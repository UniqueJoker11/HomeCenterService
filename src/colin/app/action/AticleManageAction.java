package colin.app.action;

import colin.app.common.ReturnContext;
import colin.app.service.inter.IAticleManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joker on 14-10-23.
 * 文章的内容管理
 */
@Controller
public class AticleManageAction {
    @Resource
    public IAticleManageService aticleManageService;

    @ResponseBody
    @RequestMapping(value = "/saveAticleContet.action", method = RequestMethod.POST)
    public Object saveAtcileContent(HttpServletRequest request) {
        System.out.println("开始记录日志信息");
        ReturnContext returnContext = new ReturnContext();
        HttpSession session=request.getSession();
        String aticleTitle = request.getParameter("aticleTitle");
        if (aticleTitle.length() > 200) {
            returnContext.setIsSuccess(false);
            returnContext.setRetsultMsg("文章标题过长");
            return returnContext;
        } else {
            String aticleDigest = request.getParameter("aticleDigest");
            if (aticleDigest.length() > 500) {
                returnContext.setIsSuccess(true);
                returnContext.setRetsultMsg("文章摘要过长");
                return returnContext;
            } else {
                String aticleContent ="";
                try {
                    aticleContent =URLDecoder.decode(request.getParameter("aticleContent"),"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Map<String,Object> paramsMap=new HashMap<String,Object>();
                paramsMap.put("aticleTitle",aticleTitle);
                paramsMap.put("aticleDigest",aticleDigest);
                paramsMap.put("aticleContent",aticleContent);
                paramsMap.put("loginName",session.getAttribute("loginName"));
                boolean result=aticleManageService.saveAticleContent(paramsMap);
                returnContext.setIsSuccess(result);
                return returnContext;
            }
        }
    }
    @ResponseBody
    @RequestMapping(value = "fetchAticlePageInfo")
    public Map<String,Object> fetchAticlePageInfo(@RequestParam String currentPage,@RequestParam String pageSize,HttpServletRequest request){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("currentPage",currentPage);
        params.put("pageSize",pageSize);
        Map<String,Object> resultMap=aticleManageService.searchAticlePageContent(params);
        return resultMap;
    }
}
