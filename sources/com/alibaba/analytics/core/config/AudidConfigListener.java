package com.alibaba.analytics.core.config;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.utils.Logger;
import java.io.File;
import tb.hl2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AudidConfigListener implements SystemConfigMgr.IKVChangeListener {
    public static final String KEY = "audid";

    public AudidConfigListener() {
        b(SystemConfigMgr.i().h(KEY));
    }

    private void a(final Context context, final boolean z) {
        hl2.c().f(new Runnable() { // from class: com.alibaba.analytics.core.config.AudidConfigListener.1
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                if (context2 == null) {
                    return;
                }
                try {
                    File fileStreamPath = context2.getFileStreamPath("3c9b584e65e6c983");
                    if (fileStreamPath.exists()) {
                        if (!z) {
                            fileStreamPath.delete();
                        }
                    } else if (z) {
                        fileStreamPath.createNewFile();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private void b(String str) {
        Logger.f("AudidConfigListener", "parseConfig value", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("0".equalsIgnoreCase(str)) {
            a(Variables.n().j(), true);
        } else {
            a(Variables.n().j(), false);
        }
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        b(str2);
    }
}
