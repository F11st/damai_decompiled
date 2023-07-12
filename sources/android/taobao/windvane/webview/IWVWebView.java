package android.taobao.windvane.webview;

import android.content.Context;
import android.view.View;
import android.webkit.ValueCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IWVWebView {
    public static final ConcurrentHashMap<String, Integer> JsbridgeHis = new ConcurrentHashMap<>();
    public static final List<Runnable> taskQueue = new ArrayList();

    Context _getContext();

    boolean _post(Runnable runnable);

    void addJsObject(String str, Object obj);

    boolean allowAllOpen();

    boolean back();

    boolean canUseGlobalUrlConfig();

    boolean canUseUrlConfig();

    void clearCache();

    void evaluateJavascript(String str);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void fireEvent(String str, String str2);

    Context getContext();

    String getDataOnActive();

    Object getJsObject(String str);

    int getPageLoadedCount();

    String getUrl();

    String getUserAgentString();

    View getView();

    void hideLoadingView();

    void loadUrl(String str);

    void refresh();

    void setAllowAllOpen(boolean z);

    void setDataOnActive(String str);

    void setGlobalUrlConfigSwitch(boolean z);

    void setUrlConfigSwitch(boolean z);

    void setUserAgentString(String str);

    void showLoadingView();
}
