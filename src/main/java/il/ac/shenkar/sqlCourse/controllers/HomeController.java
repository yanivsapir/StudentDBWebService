package il.ac.shenkar.sqlCourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;

/**
 * Created by ysapir on 11/29/2015.
 */
@Controller
public class HomeController {

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
