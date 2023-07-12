package anet.channel.statist;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "cookieMonitor")
/* loaded from: classes.dex */
public class CookieMonitorStat extends StatObject {
    @Dimension
    public String cookieName;
    @Dimension
    public String cookieText;
    @Dimension
    public int missType;
    @Dimension
    public String setCookie;
    @Dimension
    public String url;

    public CookieMonitorStat(String str) {
        this.url = str;
    }
}
