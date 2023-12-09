package com.utest.questions;

import com.utest.userinterfaces.RegisterUserFormUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ElementVisibleQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(RegisterUserFormUI.LBL_SUCCESS_REGISTER).answeredBy(actor);
    }

}
