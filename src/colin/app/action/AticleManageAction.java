package colin.app.action;

import colin.app.common.CommonUtils;
import colin.app.common.DateUtils;
import colin.app.common.ReturnContext;
import colin.app.core.pojo.AticleEntity;
import colin.app.service.inter.IAticleManageService;
import org.springframework.core.io.*;
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
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joker on 14-10-23.
 * 文章的内容管理
 */
@Controller
public class AticleManageAction {
    @Resource
    public IAticleManageService aticleManageService;

    /**
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveAticleContet.action", method = RequestMethod.POST)
    public Object saveAtcileContent(HttpServletRequest request) {
        System.out.println("开始记录日志信息");
        ReturnContext returnContext = new ReturnContext();
        HttpSession session = request.getSession();
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
                String aticleContent = "";
                try {
                    aticleContent = URLDecoder.decode(request.getParameter("aticleContent"), "UTF-8");
                    System.out.println(aticleContent);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                //文章分类
                String aticleCatagory = request.getParameter("aticleCategory");
                //文章封面图
                String aticleCoverImg = request.getParameter("aticleCoverImg");
                //文章关键字
                String keyWords = request.getParameter("keyWords");
                //文章作者
                String aticleAuthor = request.getParameter("aticleAuthor");
                //保存内容
                Map<String, Object> paramsMap = new HashMap<String, Object>();

                paramsMap.put("aticleTitle", aticleTitle);
                paramsMap.put("aticleDigest", aticleDigest);
                paramsMap.put("aticleContent", aticleContent);

                paramsMap.put("loginName", session.getAttribute("loginName"));
                paramsMap.put("aticleCatagory", aticleCatagory);
                paramsMap.put("aticleCoverImg", aticleCoverImg);
                paramsMap.put("keyWords", keyWords);
                paramsMap.put("aticleCrUser", aticleAuthor);
                boolean result = aticleManageService.saveAticleContent(paramsMap);
                returnContext.setIsSuccess(result);
                return returnContext;
            }
        }
    }

    /**
     * 获取文章内容具体信息
     *
     * @param currentPage
     * @param pageSize
     * @param currentIndex
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fetchAticlePageInfo", method = RequestMethod.POST)
    public Map<String, Object> fetchAticlePageInfo(@RequestParam String currentPage, @RequestParam String pageSize, @RequestParam String currentIndex, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("currentPage", currentPage);
        params.put("pageSize", pageSize);
        params.put("currentIndex", currentIndex);
        Map<String, Object> resultMap = aticleManageService.searchAticlePageContent(params);
        return resultMap;
    }

    /**
     * 上查文章封面图片
     *
     * @param aticleCoverImg
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadAticleCoverImg.action", method = RequestMethod.POST)
    public Object uploadAticleCoverImg(MultipartFile aticleCoverImg, HttpServletRequest request) {
        ReturnContext returnContext = new ReturnContext();
        float result = CommonUtils.fetchTheFileSize(aticleCoverImg.getSize());
        if (result > 4l) {
            returnContext.setIsSuccess(false);
            returnContext.setRetsultMsg("上传文件大小超过4M");
        } else {
            //重新生成文件名，规则当前日期yyyymmddhhmmss
            StringBuilder imgName = new StringBuilder(DateUtils.getCurrentDateInfo());
            imgName.append(aticleCoverImg.getOriginalFilename().substring(aticleCoverImg.getOriginalFilename().lastIndexOf(".")));
            try {
                File uploadImgFile = initImgSaveFile(request.getServletContext(), imgName.toString());
                aticleCoverImg.transferTo(uploadImgFile);
                returnContext.setIsSuccess(true);
                returnContext.setRetsultMsg(request.getContextPath() + "/upload/images/" + imgName.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return returnContext;
    }

    /**
     * 删除选中文章内容
     *
     * @param aticleId
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAticleInfo.action", method = RequestMethod.POST)
    public Object deleteAticleInfo(@RequestParam int aticleId, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("aticleId", aticleId);
        boolean result = aticleManageService.deleteAticleContent(params);
        ReturnContext returnContext = new ReturnContext();
        returnContext.setIsSuccess(result);
        return returnContext;
    }

    private File initImgSaveFile(ServletContext servletContext, String fileName) throws IOException {
        ServletContextResource fileSystemResource = new ServletContextResource(servletContext, "upload\\images" + File.separator + fileName);
        System.out.println(fileSystemResource.getFile().getPath());
        if (!fileSystemResource.exists()) {
            fileSystemResource.getFile().createNewFile();
        }
        return fileSystemResource.getFile();
    }

    /**
     * 按照点击量排序
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAticleClickRank.action", method = RequestMethod.POST)
    public Object getAticleClickRank(HttpServletRequest request) {
        ReturnContext returnContext = new ReturnContext();
        List<AticleEntity> resultList = aticleManageService.getAticleClickRank();
        if (resultList == null || resultList.isEmpty()) {
            returnContext.setIsSuccess(false);
        } else {
            returnContext.setIsSuccess(true);
            returnContext.setRetsultData(resultList);
        }
        return returnContext;
    }

    /**
     * 按照发布顺序排序
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAticlePublishRank.action", method = RequestMethod.POST)
    public Object getAticlePublishRank(HttpServletRequest request) {
        ReturnContext returnContext = new ReturnContext();
        List<AticleEntity> resultList = aticleManageService.getAticlePublishTimeRank();
        if (resultList == null || resultList.isEmpty()) {
            returnContext.setIsSuccess(false);
        } else {
            returnContext.setIsSuccess(true);
            returnContext.setRetsultData(resultList);
        }
        return returnContext;
    }

    /**
     * 更新文章的具体内容信息
     * 备注：获取更新选项，
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/upadteAticleInfo.action",method = RequestMethod.POST)
    public Object updateAticleContent(HttpServletRequest request) {
        Map<String, String[]> parametersMap = request.getParameterMap();
        boolean result=this.aticleManageService.editAticleContent(parametersMap);
        ReturnContext returnContext=new ReturnContext();
        return returnContext;
    }
}
