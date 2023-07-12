package me.ele.altriax.launcher.real.time.data.utils;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MonitorLog {
    private static final Map<String, String> ELEGANT_LOG = new HashMap();

    public static void elegantLogJoin(@NonNull String str, @NonNull String str2) {
        if (AltriaXLaunchTime.isOpen()) {
            ELEGANT_LOG.put(str, str2);
        }
    }

    public static void elegantLogLaunch() {
        if (AltriaXLaunchTime.isOpen()) {
            Map<String, String> map = ELEGANT_LOG;
            if (map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    AltriaXLaunchTime.v(entry.getKey(), entry.getValue());
                }
            }
            ELEGANT_LOG.clear();
        }
    }
}
