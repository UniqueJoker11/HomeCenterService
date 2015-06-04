package colin.app.action;

import colin.app.common.ReturnContext;
import colin.app.core.pojo.MasterEntity;
import colin.app.service.impl.MasterManageService;
import colin.app.service.inter.IMasterManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpContext;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by ASUS on 2015/4/21.
 */
@Controller
public class MasterManageAction {
    @Resource
    private IMasterManageService masterManageService;

    /**
     * 获取博主信息
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getMasterInfo.action", method = RequestMethod.POST)
    public Object getMasterInfo(HttpServletRequest request) {
        ReturnContext returnContext = new ReturnContext();
        Map<String, Object> resultMap = masterManageService.searchMasterInfo(null);
        if (Boolean.valueOf(resultMap.get("isExist").toString())) {
            returnContext.setIsSuccess(true);
            returnContext.setRetsultData((List<MasterEntity>) resultMap.get("entity"));
        } else {
            returnContext.setIsSuccess(false);
        }
        return returnContext;
    }

    /**
     * 上传头像
     *
     * @param masterheaderpic
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/masterpicupload.action", method = RequestMethod.POST)
    public Object uploadMasterInfoPic(@RequestParam MultipartFile masterheaderpic, HttpServletRequest request) {
        ReturnContext returnContext = new ReturnContext();
        //获取文件信息，上传到指定的位置
        try {
            masterheaderpic.transferTo(saveUploadFile(request.getServletContext()));
            returnContext.setIsSuccess(true);
            returnContext.setRetsultMsg("upload/header/header.jpg");
        } catch (IOException e) {
            e.printStackTrace();
            returnContext.setIsSuccess(false);
        }
        return returnContext;
    }

    public File saveUploadFile(ServletContext servletContext) throws IOException {
        ServletContextResource contextResource = new ServletContextResource(servletContext, "upload\\header\\header.jpg");
        if (!contextResource.exists()) {
            contextResource.getFile().createNewFile();
        }
        return contextResource.getFile();
    }

    @ResponseBody
    @RequestMapping(value = "/updateMasterInfo.action", method = RequestMethod.POST)
    public Object updateMasterInfo(HttpServletRequest request) {
        ReturnContext returnContext = new ReturnContext();
        Map<String, String[]> paramsMap = request.getParameterMap();
        Map<String,Object> updateParams=new HashMap<String,Object>();
        Iterator<String> paramsKeys = paramsMap.keySet().iterator();
        while (paramsKeys.hasNext()) {
            String currentKey = paramsKeys.next();
            updateParams.put(currentKey,paramsMap.get(currentKey)[0]);
        }
        if(masterManageService.updateMasterInfo(updateParams)){
            returnContext.setIsSuccess(true);
        }else{
            returnContext.setIsSuccess(false);
        }
        return returnContext;
    }

    @ResponseBody
    @RequestMapping(value = "/addMasterInfo.action", method = RequestMethod.POST)
    public Object addMasterInfo(@RequestParam String masterName, @RequestParam String masterCarrer, @RequestParam String masterHeader, @RequestParam String masterIntroduce, @RequestParam String masterWords) {
        ReturnContext returnContext = new ReturnContext();
        Map<String,Object> paramsMap=new HashMap<String,Object>();
        paramsMap.put("masterName",masterName);
        paramsMap.put("masterCarrer",masterCarrer);
        paramsMap.put("masterHeader",masterHeader);
        paramsMap.put("masterIntroduce",masterIntroduce);
        paramsMap.put("masterWords",masterWords);
        returnContext.setIsSuccess(masterManageService.addMasterInfo(paramsMap));
        return returnContext;

    }
}
