package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "steps",
        tags = "@deleteProduct"
)

public class DeleteProductFromBucketRunnerTest {
    @BeforeClass
    public static void setup() {
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
    }
}
