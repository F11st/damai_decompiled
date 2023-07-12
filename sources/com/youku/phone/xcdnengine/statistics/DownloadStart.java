package com.youku.phone.xcdnengine.statistics;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DownloadStart extends Statistic {
    private static final String MONITOR_POINT = "start";

    public DownloadStart() {
        add(Keys.BIZ_ID, 0.0d);
        add(Keys.URL, "");
        add(Keys.VERSION, "");
        add(Keys.DOMAIN, "");
        register();
    }

    @Override // com.youku.phone.xcdnengine.statistics.Statistic
    public String getMonitorPoint() {
        return "start";
    }

    public DownloadStart setBizId(int i) {
        add(Keys.BIZ_ID, i);
        return this;
    }

    public DownloadStart setDomain(String str) {
        add(Keys.DOMAIN, str);
        return this;
    }

    public DownloadStart setUrl(String str) {
        if (str != null && str.length() > 0) {
            add(Keys.URL, str);
        }
        return this;
    }

    public DownloadStart setVersion(String str) {
        if (str != null) {
            add(Keys.VERSION, str);
        }
        return this;
    }
}
