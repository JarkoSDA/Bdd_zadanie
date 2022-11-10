package Steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.css.CSS;

public class WikipediaSteps {

    private static WebDriver driver;
    @BeforeAll
    public static void  setUp() {
        driver = new ChromeDriver();

    }
        @Given ("Uzytkownik jest na stronie {string}")
                public void uzytkownikJestNaStronie(String adresUrl) {
            driver.navigate().to(adresUrl);
        }
        @When("^Uzytkownik wpisuje (.+) w pole wyszukiwania$")
        public void uzytkownik_wpisuje_w_pole_wyszukiwania(String fraza)  {
        driver.findElement(By.name("search")).sendKeys(fraza);

        }

        @When("Uzytkownik klika w przycisk Szukaj")
        public void uzytkownikKlikaWPrzyciskSzukaj(){
        driver.findElement(By.tagName("button")).click();
        }

        @Then("^(.+) zostaje poprawnie wyszukany$")
        public void zostaje_poprawnie_wyszukany(String tekst)  {
        //Assert.assertTrue(driver.findElement(By.id("firstHeading")).getText().toLowerCase().contains(tekst));
        //Assert.assertTrue(driver.findElement(By.id("firstHeading")).getText().toLowerCase().startsWith(tekst));
        Assert.assertEquals(tekst+"[edytuj]",driver.findElement(By.id("firstHeading")).getText().toLowerCase());
    }






    @AfterAll
    public static void tearDown(){
        driver.close();
    }
}
