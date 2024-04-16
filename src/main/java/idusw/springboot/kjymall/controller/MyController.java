package idusw.springboot.kjymall.controller;

import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody

@RestController
public class MyController {
    @GetMapping(value={"my", "my/"})
    public String getMy(HttpServletRequest request){
        // /my?fav=값 or /my/?fav=값
        return "<h1>" + request.getParameter("fav") + "</h1>"; // view 지정 없이 바로 응답
    }

}
