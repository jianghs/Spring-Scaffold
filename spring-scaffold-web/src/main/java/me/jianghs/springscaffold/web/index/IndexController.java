package me.jianghs.springscaffold.web.index;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: indexController
 * @description: TODO
 * @author: jianghs430
 * @createDate: 2020/8/18 13:15
 * @version: 1.0
 */
@RestController
@RequestMapping(value = "/scaffold")
public class IndexController {
    @GetMapping("/home")
    public String index() {
        return "index";
    }
}
