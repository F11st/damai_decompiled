package com.uc.webview.export.cyclone;

import android.util.Pair;
import com.taobao.weex.ui.component.WXComponent;
import java.util.ArrayList;

/* compiled from: Taobao */
@Constant
/* loaded from: classes11.dex */
public class UCLogger {
    private static ArrayList<Pair<Pair<String, String>, UCLogger>> sCachedLoggers;
    private int mLevel;
    private String mTag;

    private UCLogger(String str, String str2) {
        this.mLevel = getLogLevel(str);
        this.mTag = str2;
    }

    public static UCLogger create(String str, String str2) {
        if (Log.enabled()) {
            return new UCLogger(str, str2);
        }
        return null;
    }

    public static int createToken(String str, String str2) {
        if (sCachedLoggers == null) {
            synchronized (UCLogger.class) {
                if (sCachedLoggers == null) {
                    sCachedLoggers = new ArrayList<>(20);
                }
            }
        }
        try {
            synchronized (sCachedLoggers) {
                r0 = sCachedLoggers.add(new Pair<>(new Pair(str, str2), create(str, str2))) ? sCachedLoggers.size() - 1 : -1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return r0;
    }

    public static boolean enable(String str, String str2) {
        return Log.enabled();
    }

    private int getLogLevel(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 101:
                if (str.equals("e")) {
                    c = 0;
                    break;
                }
                break;
            case 105:
                if (str.equals("i")) {
                    c = 1;
                    break;
                }
                break;
            case 119:
                if (str.equals(WXComponent.PROP_FS_WRAP_CONTENT)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 3;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 0;
        }
    }

    public static boolean print(int i, String str, Throwable... thArr) {
        UCLogger uCLogger;
        if (i < 0 || !Log.enabled() || (uCLogger = (UCLogger) sCachedLoggers.get(i).second) == null) {
            return false;
        }
        uCLogger.print(str, thArr);
        return true;
    }

    public void print(String str, Throwable... thArr) {
        if (Log.enabled()) {
            Log.print(this.mLevel, this.mTag, str, (thArr == null || thArr.length <= 0 || thArr[0] == null) ? null : thArr[0]);
        }
    }
}
