package android.taobao.windvane.monitor;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface WVJSBrdigeMonitorInterface {
    void commitParamParseError(String str, String str2, String str3, String str4);

    @Deprecated
    void didCallAtURL(String str, String str2, String str3);

    @Deprecated
    void didCallBackAtURL(String str, String str2, String str3, String str4);

    @Deprecated
    void didOccurError(String str, String str2, String str3, String str4);

    void onJsBridgeReturn(String str, String str2, String str3, String str4, String str5);
}
