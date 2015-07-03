package colin.app.controller.impl;

import colin.app.common.bean.AticleBean;
import colin.app.common.bean.Page;
import colin.app.core.pojo.AticleEntity;
import colin.app.service.inter.IAticleManageService;
import colin.app.service.inter.IMasterManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2015/7/3.
 */
@Controller
public class BlogIndexController {
    /**
     * 文章管理service
     */
    @Autowired
    private IAticleManageService aticleManageService;
    /**
     * 博主信息管理service
     */
    @Autowired
    private IMasterManageService masterManageService;

    /**
     * 初始化博客首页的内容
     *
     * @return
     */
    @RequestMapping(value = "/blog_index.html", method = RequestMethod.GET)
    public ModelAndView initBlogIndexPage(HttpServletRequest request) {
        //声明页面地址和属性
        ModelAndView blogIndex = new ModelAndView("blog_index");
        //获取首页的文章内容
        Page<AticleBean> aticleResultInfo = aticleManageService.searchAticlePageContent(null);
        //获取首页的博主信息
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", request.getSession().getAttribute("loginId").toString());
        Map<String, Object> masterResultInfo = masterManageService.searchMasterInfo(params);
        //获取首页的文章排名
        List<AticleEntity> aticleRankResultInfo = aticleManageService.getAticleClickRank();
        request.setAttribute("aticleResultInfo", aticleResultInfo);
        request.setAttribute("masterResultInfo", masterResultInfo);
        request.setAttribute("aticleRankResultInfo",aticleRankResultInfo);
        return blogIndex;
    }
}
