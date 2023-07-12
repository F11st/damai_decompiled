package com.huawei.hms.hatool;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class w0 {
    public static w0 c = new w0();
    public boolean a = false;
    public Context b = b.i();

    public static w0 b() {
        return c;
    }

    @TargetApi(24)
    public boolean a() {
        boolean z;
        if (!this.a) {
            Context context = this.b;
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) context.getSystemService("user");
                if (userManager != null) {
                    z = userManager.isUserUnlocked();
                } else {
                    this.a = false;
                }
            } else {
                z = true;
            }
            this.a = z;
        }
        return this.a;
    }
}
