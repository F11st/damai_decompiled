package com.taobao.weex.ui.component;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.view.IWebView;
import com.taobao.weex.ui.view.WXWebView;
import com.taobao.weex.utils.WXUtils;
import java.util.HashMap;
import java.util.Map;
import tb.jg1;

/* compiled from: Taobao */
@Component(lazyload = false)
/* loaded from: classes11.dex */
public class WXWeb extends WXComponent {
    public static final String GO_BACK = "goBack";
    public static final String GO_FORWARD = "goForward";
    public static final String POST_MESSAGE = "postMessage";
    public static final String RELOAD = "reload";
    protected IWebView mWebView;

    @Deprecated
    public WXWeb(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireEvent(String str, Object obj) {
        if (getEvents().contains("error")) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", str);
            hashMap.put("errorMsg", obj);
            fireEvent("error", (Map<String, Object>) hashMap);
        }
    }

    private IWebView getWebView() {
        return this.mWebView;
    }

    private void loadDataWithBaseURL(String str) {
        getWebView().loadDataWithBaseURL(str);
    }

    private void loadUrl(String str) {
        getWebView().loadUrl(str);
    }

    protected void createWebView() {
        String str = null;
        try {
            Uri parse = Uri.parse(WXSDKManager.v().y(getInstanceId()).getBundleUrl());
            String scheme = parse.getScheme();
            String authority = parse.getAuthority();
            if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(authority)) {
                str = scheme + jg1.SCHEME_SLASH + authority;
            }
        } catch (Exception unused) {
        }
        this.mWebView = new WXWebView(getContext(), str);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        getWebView().destroy();
    }

    @JSMethod
    public void goBack() {
        getWebView().goBack();
    }

    @JSMethod
    public void goForward() {
        getWebView().goForward();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected View initComponentHostView(@NonNull Context context) {
        this.mWebView.setOnErrorListener(new IWebView.OnErrorListener() { // from class: com.taobao.weex.ui.component.WXWeb.1
            @Override // com.taobao.weex.ui.view.IWebView.OnErrorListener
            public void onError(String str, Object obj) {
                WXWeb.this.fireEvent(str, obj);
            }
        });
        this.mWebView.setOnPageListener(new IWebView.OnPageListener() { // from class: com.taobao.weex.ui.component.WXWeb.2
            @Override // com.taobao.weex.ui.view.IWebView.OnPageListener
            public void onPageFinish(String str, boolean z, boolean z2) {
                if (WXWeb.this.getEvents().contains(Constants.Event.PAGEFINISH)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("url", str);
                    hashMap.put("canGoBack", Boolean.valueOf(z));
                    hashMap.put("canGoForward", Boolean.valueOf(z2));
                    WXWeb.this.fireEvent(Constants.Event.PAGEFINISH, (Map<String, Object>) hashMap);
                }
            }

            @Override // com.taobao.weex.ui.view.IWebView.OnPageListener
            public void onPageStart(String str) {
                if (WXWeb.this.getEvents().contains(Constants.Event.PAGESTART)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("url", str);
                    WXWeb.this.fireEvent(Constants.Event.PAGESTART, (Map<String, Object>) hashMap);
                }
            }

            @Override // com.taobao.weex.ui.view.IWebView.OnPageListener
            public void onReceivedTitle(String str) {
                if (WXWeb.this.getEvents().contains(Constants.Event.RECEIVEDTITLE)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("title", str);
                    WXWeb.this.fireEvent(Constants.Event.RECEIVEDTITLE, (Map<String, Object>) hashMap);
                }
            }
        });
        this.mWebView.setOnMessageListener(new IWebView.OnMessageListener() { // from class: com.taobao.weex.ui.component.WXWeb.3
            @Override // com.taobao.weex.ui.view.IWebView.OnMessageListener
            public void onMessage(Map<String, Object> map) {
                WXWeb.this.fireEvent("message", map);
            }
        });
        return this.mWebView.getView();
    }

    @JSMethod
    public void postMessage(Object obj) {
        getWebView().postMessage(obj);
    }

    @JSMethod
    public void reload() {
        getWebView().reload();
    }

    public void setAction(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals(GO_BACK)) {
            goBack();
        } else if (str.equals(GO_FORWARD)) {
            goForward();
        } else if (str.equals("reload")) {
            reload();
        } else if (str.equals(POST_MESSAGE)) {
            postMessage(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -896505829:
                if (str.equals("source")) {
                    c = 0;
                    break;
                }
                break;
            case 114148:
                if (str.equals("src")) {
                    c = 1;
                    break;
                }
                break;
            case 537088620:
                if (str.equals(Constants.Name.SHOW_LOADING)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                String string = WXUtils.getString(obj, null);
                if (string != null) {
                    setSource(string);
                }
                return true;
            case 1:
                String string2 = WXUtils.getString(obj, null);
                if (string2 != null) {
                    setUrl(string2);
                }
                return true;
            case 2:
                Boolean bool = WXUtils.getBoolean(obj, null);
                if (bool != null) {
                    setShowLoading(bool.booleanValue());
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = Constants.Name.SHOW_LOADING)
    public void setShowLoading(boolean z) {
        getWebView().setShowLoading(z);
    }

    @WXComponentProp(name = "source")
    public void setSource(String str) {
        if (TextUtils.isEmpty(str) || getHostView() == null) {
            return;
        }
        loadDataWithBaseURL(str);
    }

    @WXComponentProp(name = "src")
    public void setUrl(String str) {
        if (TextUtils.isEmpty(str) || getHostView() == null || TextUtils.isEmpty(str)) {
            return;
        }
        loadUrl(getInstance().rewriteUri(Uri.parse(str), "web").toString());
    }

    public WXWeb(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        createWebView();
    }
}
