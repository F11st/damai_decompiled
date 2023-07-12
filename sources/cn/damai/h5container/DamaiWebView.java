package cn.damai.h5container;

import android.content.Context;
import android.util.AttributeSet;
import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taomai.android.h5container.webview.TaoMaiUCWebView;
import com.uc.webview.export.WebSettings;
import tb.gs2;
import tb.ks2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DamaiWebView extends TaoMaiUCWebView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context context;
    private JSBridge mJSBridge;

    public DamaiWebView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1082290940")) {
            ipChange.ipc$dispatch("-1082290940", new Object[]{this});
            return;
        }
        this.mJSBridge = new JSBridge(this.context, this);
        String q = AppConfig.q();
        WebSettings settings = getSettings();
        settings.setUserAgentString(getSettings().getUserAgentString() + " DamaiApp Android v" + q + " ," + ks2.USER_AGENT);
        addJavascriptInterface(this.mJSBridge, "JSBridge");
    }

    public JSBridge getJSBridge() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1762204169") ? (JSBridge) ipChange.ipc$dispatch("-1762204169", new Object[]{this}) : this.mJSBridge;
    }

    @Override // com.uc.webview.export.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1366394112")) {
            ipChange.ipc$dispatch("1366394112", new Object[]{this, str, str2, str3, str4, str5});
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // com.taomai.android.h5container.webview.TaoMaiUCWebView, android.taobao.windvane.extra.uc.WVUCWebView, com.uc.webview.export.WebView, android.taobao.windvane.webview.IWVWebView
    public void loadUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-348862537")) {
            ipChange.ipc$dispatch("-348862537", new Object[]{this, str});
            return;
        }
        DamaiCookieManager.getInstance().setDamaiCookie(str, z20.q());
        super.loadUrl(gs2.a(str));
    }

    public DamaiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public DamaiWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }
}
