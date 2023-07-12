package android.taobao.windvane.monitor;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface WVPerformanceMonitorInterface {
    public static final int FROMTYPE_CACHE = 2;
    public static final int FROMTYPE_COMBO = 8;
    public static final int FROMTYPE_NETWORK = 1;
    public static final int FROMTYPE_NETWORK_UC_ALI = 6;
    public static final int FROMTYPE_NETWORK_UC_UC = 5;
    public static final int FROMTYPE_PACKAGEAPP = 3;
    public static final int FROMTYPE_ZCACHE = 4;
    public static final int FROM_UC_WEBVIEW = 70;
    public static final int FROM_UC_WEBVIEW_E = 71;
    public static final int FROM_UC_WEBVIEW_PAGECACHE = 72;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class NetStat {
        public long dataSpeed;
        public long dnsTime;
        public long firstDataTime;
        public short isDNSTimeout;
        public boolean isSSL;
        public long oneWayTime;
        public long postBodyTime;
        public long recDataTime;
        public long serverRT;
        public int spdy;
        public long tcpLinkDate;
        public long totalSize;
        public long waitTime;
    }

    void didExitAtTime(String str, long j);

    void didGetPageStatusCode(String str, int i, int i2, String str2, String str3, String str4, Map<String, String> map, NetStat netStat);

    void didGetResourceStatusCode(String str, int i, int i2, Map<String, String> map, NetStat netStat);

    void didGetResourceVerifyCode(String str, long j, long j2, int i, int i2);

    void didPageDomLoadAtTime(String str, long j);

    void didPageFinishLoadAtTime(String str, long j);

    void didPageOccurSelfDefinedEvent(String str, String str2, long j);

    void didPagePerformanceInfo(String str, String str2);

    void didPageReceiveFirstByteAtTime(String str, long j);

    void didPageStartInFSP(String str, long j);

    void didPageStartLoadAtTime(String str, long j);

    void didPerformanceCheckResult(String str, long j, String str2, String str3, String str4);

    void didResourceFinishLoadAtTime(String str, long j, String str2, long j2);

    void didResourceStartLoadAtTime(String str, long j);

    void didWebViewInitAtTime(long j);
}
