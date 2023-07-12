package com.youku.phone.xcdnengine.statistics;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DownloadEnd extends Statistic {
    private static final String MONITOR_POINT = "end";

    public DownloadEnd() {
        add(Keys.BIZ_ID, 0.0d);
        add(Keys.URL, "");
        add(Keys.VERSION, "");
        add(Keys.DOMAIN, "");
        add(Keys.COST, "-1");
        add(Keys.ERR_CODE, "-1");
        add(Keys.T1, "0");
        add(Keys.T2, "0");
        add(Keys.T3, "0");
        add(Keys.T8, "0");
        add(Keys.FILE_SIZE, "0");
        add(Keys.AVG_SPEED, "0");
        add(Keys.NAME, "");
        register();
    }

    @Override // com.youku.phone.xcdnengine.statistics.Statistic
    public String getMonitorPoint() {
        return "end";
    }

    public DownloadEnd setBizId(int i) {
        add(Keys.BIZ_ID, i);
        return this;
    }

    public DownloadEnd setCost(String str) {
        if (str != null) {
            add(Keys.COST, str);
        }
        return this;
    }

    public DownloadEnd setDomain(String str) {
        if (str != null) {
            add(Keys.DOMAIN, str);
        }
        return this;
    }

    public DownloadEnd setError(String str) {
        if (str != null) {
            add(Keys.ERR_CODE, str);
        }
        return this;
    }

    public DownloadEnd setFile(String str, String str2) {
        if (str != null) {
            add(Keys.NAME, str);
        }
        if (str2 != null) {
            add(Keys.FILE_SIZE, str2);
        }
        return this;
    }

    public DownloadEnd setSpeed(String str) {
        if (str != null) {
            add(Keys.AVG_SPEED, str);
        }
        return this;
    }

    public DownloadEnd setTraffic(String str, String str2, String str3, String str4) {
        if (str != null) {
            add(Keys.T1, str);
        }
        if (str2 != null) {
            add(Keys.T2, str2);
        }
        if (str3 != null) {
            add(Keys.T3, str3);
        }
        if (str4 != null) {
            add(Keys.T8, str4);
        }
        return this;
    }

    public DownloadEnd setUrl(String str) {
        if (str != null && str.length() > 0) {
            add(Keys.URL, str);
        }
        return this;
    }

    public DownloadEnd setVersion(String str) {
        if (str != null) {
            add(Keys.VERSION, str);
        }
        return this;
    }
}
