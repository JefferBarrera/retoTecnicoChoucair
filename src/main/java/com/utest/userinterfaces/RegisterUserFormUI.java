package com.utest.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RegisterUserFormUI extends PageObject {

    public static final Target TXT_FIRST_NAME = Target.the("Caja de texto primer nombre").locatedBy("#firstName");
    public static final Target TXT_LAST_NAME = Target.the("Caja de texto apellido").locatedBy("#lastName");
    public static final Target TXT_EMAIL = Target.the("Caja de texto email").locatedBy("#email");
    public static final Target LIST_MONTH_BIRTH = Target.the("Lista mes nacimiento").locatedBy("#birthMonth");
    public static final Target LIST_DAY_BIRTH = Target.the("Lista dia nacimiento").locatedBy("#birthDay");
    public static final Target LIST_YEAR_BIRTH = Target.the("Lista año nacimiento").locatedBy("#birthYear");
    public static final Target BTN_NEXT = Target.the("Boton siguiente").locatedBy(".btn.btn-blue");
    public static final Target BTN_COMPLETE = Target.the("Boton completar").locatedBy("#laddaBtn");

    public static final Target TXT_PASSWORD = Target.the("Caja de texto contrasena").locatedBy("#password");
    public static final Target TXT_POSTAL_CODE = Target.the("Caja de texto codigo postal").locatedBy("#zip");
    public static final Target BTN_MAX_MAP = Target.the("Boton maximizar mapa").locatedBy(".gm-control-active.gm-fullscreen-control");
    public static final Target TXT_DEVICE = Target.the("Caja de texto tipo dispositivo").locatedBy("[name='osId']");
    public static final Target TXT_CONFIRM_PASSWORD = Target.the("Caja de texto confirmar password").locatedBy("#confirmPassword");
    public static final Target CHK_TERMS_CONDITIONS = Target.the("Checkbox terminos condiciones").locatedBy("#termOfUse");
    public static final Target CHK_POLICYS = Target.the("Checkbox politicas").locatedBy("#privacySetting");

    public static final Target LBL_SUCCESS_REGISTER = Target.the("Label de mensaje exitoso").locatedBy("//h1[contains(text(), 'Welcome to the world')]");

}
