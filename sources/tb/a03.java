package tb;

import android.content.Context;
import android.taobao.windvane.webview.IWVWebView;
import android.view.View;
import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class a03 implements IWVWebView {
    private WXSDKInstance a;
    private String b = null;

    public a03(WXSDKInstance wXSDKInstance) {
        this.a = wXSDKInstance;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public boolean _post(Runnable runnable) {
        return false;
    }

    public void a() {
        this.a = null;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void addJsObject(String str, Object obj) {
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public boolean back() {
        return false;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void clearCache() {
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void evaluateJavascript(String str) {
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void fireEvent(String str, String str2) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = (JSONObject) JSON.parse(str2);
        for (String str3 : jSONObject.keySet()) {
            hashMap.put(str3, jSONObject.getString(str3));
        }
        this.a.fireGlobalEventCallback(str, hashMap);
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public Context getContext() {
        WXSDKInstance wXSDKInstance = this.a;
        return wXSDKInstance == null ? WXEnvironment.getApplication() : wXSDKInstance.getContext();
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public String getDataOnActive() {
        return this.b;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public Object getJsObject(String str) {
        return null;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public String getUrl() {
        WXSDKInstance wXSDKInstance = this.a;
        return wXSDKInstance != null ? wXSDKInstance.getBundleUrl() : "WXWindVaneWebView";
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public String getUserAgentString() {
        return nz2.a(this.a.getContext(), WXEnvironment.getConfig());
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public View getView() {
        return this.a.getContainerView();
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void hideLoadingView() {
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void loadUrl(String str) {
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void refresh() {
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setDataOnActive(String str) {
        this.b = str;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setUserAgentString(String str) {
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void showLoadingView() {
    }
}
