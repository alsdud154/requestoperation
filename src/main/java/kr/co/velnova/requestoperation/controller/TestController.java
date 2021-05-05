package kr.co.velnova.requestoperation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class TestController {
    /*
    * HttpServletRequest에 조작한 parameter 값들이 있음
    * */
    @RequestMapping("/search-lang")
    @ResponseBody
    public String searchLang(HttpServletRequest request) {
        String msg = "lang : " + request.getParameter("lang");

        Map<String, String[]> parameterMap = request.getParameterMap();

        parameterMap.keySet().forEach(key -> System.out.println("key = " + key + ", value = " + request.getParameter(key)));

        return msg;
    }
}
