package com.ut.mini.extend;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.core.WVUserTrack;
import com.ut.mini.module.process.AbsMultiProcessAdapter;
import com.ut.mini.module.process.MultiProcessManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WindvaneExtend {
    public static void registerWindvane(boolean z) {
        Class<WVUserTrack> cls = WVUserTrack.class;
        if (!UTExtendSwitch.bWindvaneExtend) {
            Logger.v("UTAnalytics", "user disable WVTBUserTrack ");
        } else if (z) {
            Logger.v("UTAnalytics", "Has registered WVTBUserTrack plugin,not need to register again! ");
        } else {
            Class<? extends WVApiPlugin> cls2 = null;
            try {
                AbsMultiProcessAdapter multiProcessAdapter = MultiProcessManager.getMultiProcessAdapter();
                if (multiProcessAdapter != null) {
                    cls2 = multiProcessAdapter.isUiSubProcess() ? multiProcessAdapter.getSubProcessWVApiPluginClass() : cls;
                }
                if (cls2 != null) {
                    cls = cls2;
                }
                WVPluginManager.registerPlugin("WVTBUserTrack", (Class<? extends WVApiPlugin>) cls, true);
                Logger.f("UTAnalytics", "register WVTBUserTrack Success");
            } catch (Throwable th) {
                Logger.i("UTAnalytics", "Exception", th.toString());
            }
        }
    }
}
