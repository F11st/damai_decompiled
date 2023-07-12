package com.tencent.open;

import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import com.youku.media.arch.instruments.statistics.ConfigReporter;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.a */
/* loaded from: classes11.dex */
public class C7067a {
    public static void a(Window window) {
        if (window == null) {
            return;
        }
        window.setFlags(1024, 1024);
        int i = Build.VERSION.SDK_INT;
        if (i >= 16) {
            window.getDecorView().setSystemUiVisibility(1280);
        }
        if (i >= 21) {
            window.addFlags(Integer.MIN_VALUE);
            if (i >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
                return;
            }
            return;
        }
        window.addFlags(ConfigReporter.BIT_GETTER_IMP);
    }
}
