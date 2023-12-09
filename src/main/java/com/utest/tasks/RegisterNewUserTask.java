package com.utest.tasks;

import com.utest.userinterfaces.HomePageUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Map;

import static com.utest.userinterfaces.RegisterUserFormUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegisterNewUserTask implements Task {

    private final Map<String, String> dataUser;

    public RegisterNewUserTask(Map<String, String> dataUser) {
        this.dataUser = dataUser;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Click.on(HomePageUI.BTN_REGISTER).performAs(actor);
        completePersonalInfo(actor);
        completeAddressInfo(actor);
        completeDeviceInfo(actor);
        completeRegistration(actor);
    }

    public <T extends Actor> void completePersonalInfo(T actor) {
        actor.attemptsTo(
                Enter.theValue(dataUser.get("firstName")).into(TXT_FIRST_NAME),
                Enter.theValue(dataUser.get("lastName")).into(TXT_LAST_NAME),
                Enter.theValue(dataUser.get("email")).into(TXT_EMAIL),
                SelectFromOptions.byVisibleText(dataUser.get("birthMonth")).from(LIST_MONTH_BIRTH),
                SelectFromOptions.byVisibleText(dataUser.get("birthDay")).from(LIST_DAY_BIRTH),
                SelectFromOptions.byVisibleText(dataUser.get("birthYear")).from(LIST_YEAR_BIRTH),
                Click.on(BTN_NEXT)
        );
    }

    public <T extends Actor> void completeAddressInfo(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_POSTAL_CODE, isClickable()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_MAX_MAP, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_NEXT)
        );
    }

    public <T extends Actor> void completeDeviceInfo(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_DEVICE, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_NEXT)
        );
    }

    public <T extends Actor> void completeRegistration(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_COMPLETE, isClickable()).forNoMoreThan(30).seconds(),
                Enter.theValue(dataUser.get("clave")).into(TXT_PASSWORD),
                Enter.theValue(dataUser.get("clave")).into(TXT_CONFIRM_PASSWORD),
                Click.on(CHK_TERMS_CONDITIONS),
                Click.on(CHK_POLICYS),
                Click.on(BTN_COMPLETE),
                WaitUntil.the(LBL_SUCCESS_REGISTER, isVisible()).forNoMoreThan(30).seconds()
        );
    }

    public static Performable withData(Map<String, String> dataUser) {
        return Instrumented.instanceOf(RegisterNewUserTask.class).withProperties(dataUser);
    }
}
