package com.febatis.pagamento.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.febatis.pagamento.enums.PaymentType;
import com.febatis.pagamento.model.Greeting;
import com.febatis.pagamento.model.Person;
import com.febatis.pagamento.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static net.logstash.logback.argument.StructuredArguments.value;

@Controller
@RequestMapping("hello-world")
public class HelloWorldController {

    private static final Logger logger
            = LoggerFactory.getLogger(HelloWorldController.class);

    private static final String template = "Hello, %s!";
    private static final String templateType = "PaymentType: %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonService personService;

    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
        logger.info("Example log from {}", HelloWorldController.class.getSimpleName());
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/throw-exception")
    @ResponseBody
    public Greeting throwException(@RequestParam(name = "name", required = false, defaultValue = "Estranho") String name) {
        throw new RuntimeException("Ocorreu erro: " + name);
    }

    @GetMapping("/search-faq")
    @ResponseBody
    public Greeting searchFaq(@RequestParam String search) {
        logger.info("search: {}", value("search", search));
        return new Greeting(counter.incrementAndGet(), String.format(templateType, search));
    }

    @GetMapping("/find-examples")
    @ResponseBody
    public Greeting findExamples() {
        personService.findExamples();
        return new Greeting(counter.incrementAndGet(), String.format(template, "User"));
    }

    @GetMapping("/find-all")
    @ResponseBody
    public List<Person> findAll() {
        return personService.findAll();
    }

    @PostMapping("/do-payment/{paymentType}")
    @ResponseBody
    public Greeting doPayment(@PathVariable PaymentType paymentType) {
        logger.info("Payment Type: {}", value("PaymentType", paymentType));
        return new Greeting(counter.incrementAndGet(), String.format(templateType, paymentType));
    }

}
