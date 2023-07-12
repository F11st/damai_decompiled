package com.taobao.android.launcher.statistics.report;

import mtopsdk.mtop.domain.IMTOPDataObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DAGRequest implements IMTOPDataObject {
    public String performanceData;
    public String API_NAME = "mtop.taobao.tmq.performance.reportPerformance";
    public String VERSION = "1.0";
    public boolean NEED_ECODE = false;
    public boolean NEED_SESSION = false;

    public DAGRequest(String str) {
        this.performanceData = null;
        this.performanceData = str;
    }
}
