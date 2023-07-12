package com.taobao.monitor.adapter;

import android.app.Application;
import java.io.Serializable;
import java.util.HashMap;
import tb.vm2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TMAPMAdapterLauncher implements Serializable {
    public void init(final Application application, final HashMap<String, Object> hashMap) {
        new TMAPMInitiator().init(application, hashMap);
        vm2.d(new Runnable() { // from class: com.taobao.monitor.adapter.TMAPMAdapterLauncher.1
            @Override // java.lang.Runnable
            public void run() {
                new TBAPMAdapterLauncherPart2().init(application, hashMap);
            }
        });
    }
}
