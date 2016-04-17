/**
 * Created by terzeron on 2016-04-16.
 */

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello world!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);

        // You can connect to the localhost:8080
    }
}
