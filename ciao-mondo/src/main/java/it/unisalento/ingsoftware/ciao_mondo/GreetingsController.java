package it.unisalento.ingsoftware.ciao_mondo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/")
public class GreetingsController {

    @GetMapping
    public ModelAndView greetings() {
        String greetingMessage = getGreetingsByTime(LocalTime.now()) + " Mondo!";
        return new ModelAndView("hello-world").addObject("message", greetingMessage);
    }

    public static String getGreetingsByTime(LocalTime time) {
        String greetings;
        if (time.isBefore(LocalTime.NOON)) {
            greetings = "Buongiorno,";
        } else if (time.isBefore(LocalTime.of(18, 0))){
            greetings = "Buon pomeriggio,";
        } else {
            greetings = "Buonasera,";
        }
        DateTimeFormatter myFormatObject = DateTimeFormatter.ofPattern("HH:mm:ss");
        greetings = greetings + " sono le ore " + time.format(myFormatObject);
        return greetings;
    }

    @GetMapping(params = "req-param")
    public String greetingsWithParam() {
        return "hello-world-params";
    }

    @GetMapping(headers = "req-header=hValue")
    public String greetingsWithHeader() {
        return "hello-world-headers";
    }
}
