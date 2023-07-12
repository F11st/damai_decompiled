package com.ali.user.mobile.app.dataprovider;

import android.text.TextUtils;
import com.taobao.login4android.config.LoginSwitch;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class OrangeConfig {
    private final String DEFAULT_VALUE = "none";

    private BooleanOrangeResult doBooleanReadOrangeConfig(String str) {
        BooleanOrangeResult booleanOrangeResult = new BooleanOrangeResult();
        String config = LoginSwitch.getConfig(str, "none");
        if (TextUtils.equals(config, "none")) {
            booleanOrangeResult.orangeExist = false;
        } else {
            booleanOrangeResult.orangeExist = true;
            booleanOrangeResult.value = TextUtils.equals("true", config);
        }
        return booleanOrangeResult;
    }

    private IntOrangeResult doIntReadOrangeConfig(String str) {
        IntOrangeResult intOrangeResult = new IntOrangeResult();
        String config = LoginSwitch.getConfig(str, "none");
        if (TextUtils.equals(config, "none")) {
            intOrangeResult.orangeExist = false;
        } else {
            intOrangeResult.orangeExist = true;
            try {
                intOrangeResult.value = Integer.parseInt(config);
            } catch (Throwable unused) {
                intOrangeResult.orangeExist = false;
            }
        }
        return intOrangeResult;
    }

    private StringOrangeResult doStringReadOrangeConfig(String str) {
        StringOrangeResult stringOrangeResult = new StringOrangeResult();
        String config = LoginSwitch.getConfig(str, "none");
        if (TextUtils.equals(config, "none")) {
            stringOrangeResult.orangeExist = false;
        } else {
            stringOrangeResult.orangeExist = true;
            stringOrangeResult.value = config;
        }
        return stringOrangeResult;
    }

    public StringOrangeResult customProtocol() {
        return doStringReadOrangeConfig(LoginSwitch.PROTOCOL);
    }

    public IntOrangeResult getMaxHistorySize() {
        return doIntReadOrangeConfig(LoginSwitch.MAX_HISTORY_NUM);
    }

    public IntOrangeResult getMaxSessionSize() {
        return doIntReadOrangeConfig(LoginSwitch.MAX_SESSION_NUM);
    }

    public IntOrangeResult getMtopTimeOutMilliSecond() {
        return doIntReadOrangeConfig(LoginSwitch.RPC_TIMEOUT_MS);
    }

    public StringOrangeResult helpLink() {
        return doStringReadOrangeConfig(LoginSwitch.HELP_LINK);
    }

    public BooleanOrangeResult isNeedUpdateUTAccount() {
        return doBooleanReadOrangeConfig(LoginSwitch.ENABLE_UPDATE_UT);
    }

    public BooleanOrangeResult isSaveHistoryWithoutSalt() {
        return doBooleanReadOrangeConfig(LoginSwitch.SAVE_HISTORY_WITHOUT_SALT);
    }

    public BooleanOrangeResult needEnterPriseRegister() {
        return doBooleanReadOrangeConfig(LoginSwitch.ENABLE_EA_REG);
    }

    public BooleanOrangeResult needFindPassword() {
        return doBooleanReadOrangeConfig(LoginSwitch.ENABLE_FIND_PASSWORD);
    }

    public BooleanOrangeResult needHelp() {
        return doBooleanReadOrangeConfig(LoginSwitch.ENABLE_HELP);
    }

    public BooleanOrangeResult needRegister() {
        return doBooleanReadOrangeConfig(LoginSwitch.ENABLE_REGISTER);
    }

    public BooleanOrangeResult registerSidToMtop() {
        return doBooleanReadOrangeConfig(LoginSwitch.ENABLE_REG_SESSION_MTOP);
    }

    public BooleanOrangeResult supportGuidePage() {
        return doBooleanReadOrangeConfig(LoginSwitch.SUPPORT_GUIDE_PAGE);
    }

    public BooleanOrangeResult supportHistotyLoginPage() {
        return doBooleanReadOrangeConfig(LoginSwitch.SUPPORT_HISTORY_LOGIN_PAGE);
    }
}
