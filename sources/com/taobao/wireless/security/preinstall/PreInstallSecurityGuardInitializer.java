package com.taobao.wireless.security.preinstall;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.initialize.C4023a;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class PreInstallSecurityGuardInitializer {
    private PreInstallSecurityGuardInitializer() {
    }

    public static int Initialize(Context context) {
        return Initialize(context, null);
    }

    public static int Initialize(Context context, String str) {
        try {
            IInitializeComponent initializer = SecurityGuardManager.getInitializer();
            if (initializer == null || !(initializer instanceof C4023a)) {
                return 1;
            }
            return ((C4023a) initializer).a(context, str, false);
        } catch (SecException e) {
            e.printStackTrace();
            return 1;
        }
    }
}
