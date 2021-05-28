package Project.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RestController
@RequestMapping("/api/test")
@CrossOrigin
public class Test {

    @GetMapping
    @ResponseBody
    public String getAllCategories(){
        return "test";
    }
}