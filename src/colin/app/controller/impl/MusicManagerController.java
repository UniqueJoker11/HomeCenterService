package colin.app.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 2015/7/4.
 */
@Controller
public class MusicManagerController {
    @RequestMapping(value ="/blog_music.html",method = RequestMethod.GET)
    public String showMusicHtml(HttpServletRequest request){
        return "blog_music";
    }
}
