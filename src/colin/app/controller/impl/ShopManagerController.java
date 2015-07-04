package colin.app.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 购物Controller
 * Created by ASUS on 2015/7/4.
 */
@Controller
public class ShopManagerController {
    /**
     * 显示购物页面
     * @return
     */
    @RequestMapping(value = "/blog_shop.html",method = RequestMethod.GET)
    public String showShopHtml(){
        return "blog_shop";
    }
}
