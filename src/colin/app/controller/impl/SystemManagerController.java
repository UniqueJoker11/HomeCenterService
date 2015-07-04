package colin.app.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ASUS on 2015/4/21.
 */
@Controller
@RequestMapping("/manage")
public class SystemManagerController {
    /**
     * 系统退出登录
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/userLogOff.html", method = RequestMethod.GET)
    public String logOffSystem(HttpServletRequest request) {
        //清除Session
        HttpSession session = request.getSession();
        session.removeAttribute("loginName");
        session.removeAttribute("loginId");
        return "login";
    }

    /**
     * 用户登录页面
     *
     * @return
     */
    @RequestMapping(value = "/userLogin.html", method = RequestMethod.GET)
    public String logInSystem() {
        return "login";
    }

    @RequestMapping(value = "/aticle.html", method = RequestMethod.GET)
    public String showAticleHtml() {
        return "aticle";
    }

    @RequestMapping(value = "/music.html", method = RequestMethod.GET)
    public String showMusicHtml() {
        return "music";
    }

    @RequestMapping(value = "/video.html", method = RequestMethod.GET)
    public String showVideoHtml() {
        return "video";
    }

    @RequestMapping(value = "/picture.html", method = RequestMethod.GET)
    public String showPictureHtml() {
        return "picture";
    }

    @RequestMapping(value = "/blog_manage_masterInfo.html", method = RequestMethod.GET)
    public String showMasterHtml() {
        return "blog_manage_masterInfo";
    }
}
