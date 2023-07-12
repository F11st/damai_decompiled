package android.taobao.windvane.webview;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVSchemeInterceptService {
    private static WVSchemeIntercepterInterface mIntercepter;

    public static WVSchemeIntercepterInterface getWVSchemeIntercepter() {
        return mIntercepter;
    }

    public static void registerWVURLintercepter(WVSchemeIntercepterInterface wVSchemeIntercepterInterface) {
        mIntercepter = wVSchemeIntercepterInterface;
    }
}
