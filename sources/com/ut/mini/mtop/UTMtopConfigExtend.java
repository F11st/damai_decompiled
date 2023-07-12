package com.ut.mini.mtop;

import com.alibaba.analytics.utils.Logger;
import com.ut.mini.UTAnalytics;
import com.ut.mini.extend.UTExtendSwitch;
import com.ut.mini.module.plugin.UTPlugin;
import com.ut.mini.module.plugin.UTPluginMgr;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.stat.MtopMonitor;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTMtopConfigExtend {
    private static final String UT_MODULE = "UTMtopConfig";
    private static final String UT_PARAM_CNT = "utparam-cnt";
    private static final int[] attentionEventIds = {2001};
    private static boolean mInit;

    public static synchronized void init() {
        synchronized (UTMtopConfigExtend.class) {
            if (!UTExtendSwitch.bUTMtopConfig) {
                Logger.v("UTMtopConfigExtend", "disable UTMtopConfig");
            } else if (mInit) {
            } else {
                mInit = true;
                MtopMonitor.addResponseHeaderMonitor("mtop-x-ut-config", new UTMtopMonitor());
                Logger.v("UTMtopConfigExtend", "addResponseHeaderMonitor");
                UTPluginMgr.getInstance().registerPlugin(new UTPlugin() { // from class: com.ut.mini.mtop.UTMtopConfigExtend.1
                    @Override // com.ut.mini.module.plugin.UTPlugin
                    public int[] getAttentionEventIds() {
                        return UTMtopConfigExtend.attentionEventIds;
                    }

                    @Override // com.ut.mini.module.plugin.UTPlugin
                    public String getPluginName() {
                        return UTMtopConfigExtend.UT_MODULE;
                    }

                    @Override // com.ut.mini.module.plugin.UTPlugin
                    public Map<String, String> onEventDispatch(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
                        try {
                            String utparamCnt = UTMtopConfigMgr.getUtparamCnt(str);
                            if (yh2.f(utparamCnt)) {
                                return null;
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("utparam-cnt", utparamCnt);
                            UTAnalytics.getInstance().getDefaultTracker().updateNextPageUtparam(utparamCnt);
                            return hashMap;
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                });
            }
        }
    }
}
