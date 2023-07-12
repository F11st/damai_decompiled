package com.xiaomi.push;

import android.os.Build;
import android.system.Os;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cp {
    public static long a(String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                if (new File(str).exists()) {
                    return Os.stat(str).st_size;
                }
                return 0L;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return 0L;
            }
        }
        return 0L;
    }
}
