package io.github.kimmking.gateway.server;

import org.springframework.http.HttpRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String sayHello(HttpServletRequest request) {
//        String code = request.getHeader("exchange-cloud");
        return "hello world";
    }

    @GetMapping("/api/date")
    public String getDate(HttpServletRequest request) {
        String nioSet = request.getHeader("nio");
        if (nioSet == null) {
            return LocalDateTime.now().toString();

        } else {
            return LocalDateTime.now().toString() + " " + nioSet;
        }
    }
}
