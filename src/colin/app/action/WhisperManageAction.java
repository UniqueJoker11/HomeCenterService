package colin.app.action;

import colin.app.common.ReturnContext;
import colin.app.core.pojo.WhisperEntity;
import colin.app.service.inter.IWhisperManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2015/4/23.
 */
@Controller
public class WhisperManageAction {

    @Resource
    private IWhisperManageService whisperManageService;

    @ResponseBody
    @RequestMapping(value = "/addWhisperInfo.action", method = RequestMethod.POST)
    public Object addWhisperInfo(@RequestParam String whisperContent, HttpServletRequest request) {
        ReturnContext returnContext = new ReturnContext();
        HttpSession session = request.getSession();
        String loginName = session.getAttribute("loginName").toString();
        Map<String, Object> savedParams = new HashMap<String, Object>();
        savedParams.put("whisperContent",whisperContent);
        savedParams.put("createUser",loginName);
        returnContext.setIsSuccess(whisperManageService.addWhisperInfo(savedParams));
        return  returnContext;
    }
    @ResponseBody
    @RequestMapping(value = "/getWhisperInfo.action",method =RequestMethod.POST )
    public Object getAllWhisperInfo(HttpServletRequest request){
        ReturnContext returnContext=new ReturnContext();
        List<WhisperEntity> whisperEntityList=whisperManageService.getAllWhisperInfo();
        if(whisperEntityList==null||whisperEntityList.isEmpty()){
            returnContext.setIsSuccess(false);
        }else{
            returnContext.setIsSuccess(true);
            returnContext.setRetsultData(whisperEntityList);
        }
        return returnContext;
    }
    @ResponseBody
    @RequestMapping()
    public Object searchWhisperInfo(HttpServletRequest request){
        ReturnContext returnContext=new ReturnContext();
        return  returnContext;
    }
}
