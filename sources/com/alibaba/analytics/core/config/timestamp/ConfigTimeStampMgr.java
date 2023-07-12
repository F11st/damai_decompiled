package com.alibaba.analytics.core.config.timestamp;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import tb.fo2;
import tb.hl2;
import tb.ve0;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class ConfigTimeStampMgr {
    private static ConfigTimeStampMgr c;
    private static Map<String, String> d = Collections.synchronizedMap(new HashMap());
    private ScheduledFuture a;
    private Runnable b = new Runnable() { // from class: com.alibaba.analytics.core.config.timestamp.ConfigTimeStampMgr.1
        @Override // java.lang.Runnable
        public void run() {
            if (Variables.n().j() != null) {
                ArrayList arrayList = new ArrayList(ConfigTimeStampMgr.d.size());
                for (String str : ConfigTimeStampMgr.d.keySet()) {
                    arrayList.add(new fo2(str, (String) ConfigTimeStampMgr.d.get(str)));
                }
                Variables.n().k().b(fo2.class);
                Variables.n().k().q(arrayList);
                return;
            }
            Logger.v("storeTask.run()", WPKFactory.INIT_KEY_CONTEXT, null);
        }
    };

    private ConfigTimeStampMgr() {
        List<? extends ve0> i;
        if (Variables.n().j() == null || (i = Variables.n().k().i(fo2.class, null, null, -1)) == null) {
            return;
        }
        for (int i2 = 0; i2 < i.size(); i2++) {
            d.put(((fo2) i.get(i2)).a, ((fo2) i.get(i2)).b);
        }
    }

    public static synchronized ConfigTimeStampMgr c() {
        ConfigTimeStampMgr configTimeStampMgr;
        synchronized (ConfigTimeStampMgr.class) {
            if (c == null) {
                c = new ConfigTimeStampMgr();
            }
            configTimeStampMgr = c;
        }
        return configTimeStampMgr;
    }

    public String b(String str) {
        String str2 = d.get(str);
        return TextUtils.isEmpty(str2) ? "0" : str2;
    }

    public void d(String str, String str2) {
        d.put(str, str2);
        this.a = hl2.c().d(this.a, this.b, 10000L);
    }
}
