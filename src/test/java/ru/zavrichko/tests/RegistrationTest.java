package ru.zavrichko.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationTest extends TestBase {

    @Owner("azavrichko")
    @Feature("Registration")
    @Story("Registration")
    @DisplayName("Registration")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void RegistrationTest() {
        // Open website

        step("Open", () -> {
            open("/automation-practice-form");
        });

        step("Write name", () -> {
            $("#firstName").setValue("Alex");
        });

        step("Write lastname", () -> {
            $("#lastName").setValue("Smirnov");
        });

        step("Write email", () -> {
            $("#userEmail").setValue("alex.smirnov@gmail.com");
        });

        step("Write phone", () -> {
            $(".custom-control-label").click();
            $("#userNumber").setValue("5648798798");
        });

        step("Write date", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").click();
            $(".react-datepicker__month-select").selectOption("May");
            $(".react-datepicker__year-select").selectOption("2014");
            $x("//div[contains(text(),'15')]").click();
        });

        step("Write hobby", () -> {
            $("#subjectsInput").setValue("Eng").pressEnter();
            $x("//label[contains(text(),'Sports')]").click();
            $x("//label[contains(text(),'Reading')]").click();
            $x("//label[contains(text(),'Music')]").click();
        });

        step("Write address", () -> {
            $("#currentAddress").setValue("Moscow, Manoilov Street, 64");
        });

        step("Write state", () -> {
            $("#react-select-3-input").setValue("NCR").pressEnter();
        });

        step("Write town", () -> {
            $("#react-select-4-input").setValue("Gurgaon").pressEnter();
        });

        step("Submit", () -> {
            $("#submit").click();
        });

        // Assertion

        step("Check visible", () -> {
            $("#example-modal-sizes-title-lg").shouldBe(visible);
        });

        step("Check table", () -> {
            $(".table-responsive").shouldHave(text("Alex"));
            $(".table-responsive").shouldHave(text("Smirnov"));
            $(".table-responsive").shouldHave(text("alex.smirnov@gmail.com"));
            $(".table-responsive").shouldHave(text("Male"));
            $(".table-responsive").shouldHave(text("5648798798"));
            $(".table-responsive").shouldHave(text("15 May,2014"));
            $(".table-responsive").shouldHave(text("English"));
            $(".table-responsive").shouldHave(text("Sports, Reading, Music"));
            $(".table-responsive").shouldHave(text("NCR Gurgaon"));
        });
    }
    @Test
    @AllureId("7832")
    @DisplayName("RegistrationTest")
    @Owner("allure8")
    void SearchTest() {
        step("Open", () -> {
            open("https://google.com");
        });
        step("Submit", () -> {
            $("#submit").click();
        });
    }

}
