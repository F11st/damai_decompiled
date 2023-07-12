package com.tencent.open.web.security;

import android.content.Context;
import com.tencent.connect.auth.AuthAgent;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class JniInterface {
    public static boolean isJniOk;

    public static native boolean BackSpaceChar(boolean z, int i);

    public static native boolean clearAllPWD();

    public static native String d1(String str);

    public static native String d2(String str);

    public static native String getPWDKeyToMD5(String str);

    public static native boolean insetTextToArray(int i, String str, int i2);

    public static void loadSo() {
        if (isJniOk) {
            return;
        }
        try {
            Context a = g.a();
            if (a != null) {
                if (new File(a.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME).exists()) {
                    System.load(a.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME);
                    isJniOk = true;
                    SLog.i("openSDK_LOG.JniInterface", "-->load lib success:" + AuthAgent.SECURE_LIB_NAME);
                } else {
                    SLog.i("openSDK_LOG.JniInterface", "-->fail, because so is not exists:" + AuthAgent.SECURE_LIB_NAME);
                }
            } else {
                SLog.i("openSDK_LOG.JniInterface", "-->load lib fail, because context is null:" + AuthAgent.SECURE_LIB_NAME);
            }
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.JniInterface", "-->load lib error:" + AuthAgent.SECURE_LIB_NAME, th);
        }
    }
}
