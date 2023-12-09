package com.utest.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePageUI extends PageObject {

    public static final Target BTN_REGISTER = Target.the("Boton join today").locatedBy(".unauthenticated-nav-bar__sign-up");

}
