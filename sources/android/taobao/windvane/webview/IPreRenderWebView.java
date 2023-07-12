package android.taobao.windvane.webview;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IPreRenderWebView {
    long getExpireTime();

    boolean isPreLoad();

    boolean isPreRenderSuccess();

    void preRenderInit(String str);

    void setExpireTime(long j);

    void setPreRenderSuccess(boolean z);
}
