package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SecurityInit {
    public static int Initialize(Context context) throws JAQException {
        try {
            return SecurityGuardManager.getInitializer().initialize(context);
        } catch (SecException e) {
            e.printStackTrace();
            throw new JAQException(e.getErrorCode());
        }
    }

    public static boolean setGlobalUserData(String str, String str2) throws JAQException {
        try {
            return SecurityGuardManager.setGlobalUserData(str, str2);
        } catch (SecException e) {
            throw new JAQException(e.getErrorCode());
        }
    }
}
