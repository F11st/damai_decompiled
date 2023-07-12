package com.ut.mini.mtop;

import android.text.TextUtils;
import java.util.HashMap;
import mtopsdk.mtop.stat.IMtopMonitor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTMtopMonitor implements IMtopMonitor {
    static final String MTOP_HEAD = "mtop-x-ut-config";

    @Override // mtopsdk.mtop.stat.IMtopMonitor
    public void onCommit(String str, HashMap<String, String> hashMap) {
        try {
            if (!TextUtils.equals(IMtopMonitor.MtopMonitorType.TYPE_RESPONSE, str) || hashMap == null) {
                return;
            }
            String str2 = hashMap.get(MTOP_HEAD);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            UTMtopConfigMgr.activateMtopConfig(str2);
        } catch (Throwable unused) {
        }
    }
}
