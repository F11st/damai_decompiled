package com.ut.mini.behavior.edgecomputing.datacollector;

import com.alibaba.analytics.AnalyticsMgr;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GlobalData {
    public static String cold_start_id;
    public static String session_id;

    GlobalData() {
    }

    public static String getUserid() {
        return AnalyticsMgr.J();
    }
}
