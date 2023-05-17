import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.reportsFolder;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

    @Listeners({SoftAsserts.class})
    public class SelenideTest {
        public SelenideTest(){
            Configuration.timeout=4500; //default 4000
            Configuration.browser="chrome";
            baseUrl="https://the-internet.herokuapp.com";
            reportsFolder="src/main/resources/Failed";
        }

        @Test
        public void dropdownTest(){
            open("/dropdown");
            $("#dropdown").selectOptionContainingText("tion 2");
            $("#dropdown").getSelectedOption().shouldHave(exactText("Option 2"));
        }

        @Test
        public void inputTest(){
            open("/inputs");
            $("input[type=number]").setValue("100");
            $("input[type=number]").shouldBe(empty);
        }
}
