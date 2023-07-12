package com.youku.usercenter.passport.orange;

import com.youku.usercenter.passport.PassportManager;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class RollBackSwitch {
    public static final String ROLLBACK_REGISTER_MTOP = "rollbackRegisterMtop";
    public static final String ROLLBACK_TRUST_LOGIN = "rollbackTrustLogin";
    public static final String ROLLBACK_USER_LOGIN_TOKEN = "rollbackUserToken";

    public static boolean willRollBack(String str) {
        if (PassportManager.getInstance().getConfig().isUseOrange()) {
            return OrangeManager.getRollbackSwitch(str);
        }
        return false;
    }
}
