package backend.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import model.test.TestResponse;

@Service
public class TestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);

    public TestService() {
    }

    public TestResponse getData(String locator) {
        LOGGER.info("Gettind data for locator: {}", locator);
        return new TestResponse(locator, "TEMP");
    }
}
