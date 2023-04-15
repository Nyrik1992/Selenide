package ru.netology.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {
    @Test
    void shouldToTestForm() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $$x("//input [@type='text']").get(0).val("Казань");
        $$x("//input [@type='text']").get(1).val("Иванов Иван");
        $$x("//input [@type='tel']").get(1).val("+71112233445");
        $("[data-test-id='agreement']").click();
        $(withText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(20));
    }


}
