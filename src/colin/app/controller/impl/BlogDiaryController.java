package colin.app.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 2015/7/4.
 */
@Controller
public class BlogDiaryController {

    /**
     * 显示日记页面
     * @param request
     * @return
     */
    @RequestMapping("blog_diary")
    public String showBlogDiary(HttpServletRequest request) {
        return "blog_diary";
    }
}
