package backend.controllers;
import backend.services.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import model.test.TestResponse;
import model.test.TestRequest;

@RestController
public class TrafficController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrafficController.class);
    private final TestService dataService;

    public TrafficController(TestService dataService) {
        LOGGER.info("Setting up QueueController");
        this.dataService = dataService;
    }

    @GetMapping("/data/")
    public TestResponse getBasicEntry(@RequestBody TestRequest basicDataRequest) {
        return dataService.getData(basicDataRequest.getLocator());
    }
}
