package com.ali.user.mobile.login.history;

import android.util.Log;
import com.ali.user.mobile.app.init.Debuggable;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LoginHistoryManager {
    private static final boolean DEBUG;
    private static final String TAG;
    private static LoginHistoryManager instance;

    static {
        boolean isDebug = Debuggable.isDebug();
        DEBUG = isDebug;
        TAG = isDebug ? "LoginHistoryManager" : LoginHistoryManager.class.getSimpleName();
    }

    private LoginHistoryManager() {
    }

    public static LoginHistoryManager getInstance() {
        if (instance == null) {
            instance = new LoginHistoryManager();
        }
        return instance;
    }

    public void saveHistory(HistoryAccount historyAccount, String str) {
        try {
            SecurityGuardManagerWraper.putLoginHistory(historyAccount, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void saveHistoryWithNoSalt(HistoryAccount historyAccount) {
        try {
            SecurityGuardManagerWraper.saveHistoryOnly(historyAccount);
        } catch (Throwable th) {
            if (DEBUG) {
                Log.e(TAG, "saveHistoryWithNoSalt: ", th);
            }
        }
    }
}
