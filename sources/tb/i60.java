package tb;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.taobao.monitor.impl.data.AbsWebView;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class i60 extends AbsWebView {
    public static final i60 INSTANCE = new i60();
    private String e;

    private i60() {
    }

    @Override // com.taobao.monitor.impl.data.AbsWebView
    public int d(View view) {
        WebView webView = (WebView) view;
        String url = webView.getUrl();
        if (!TextUtils.equals(this.e, url)) {
            this.e = url;
            return 0;
        }
        return webView.getProgress();
    }

    @Override // com.taobao.monitor.impl.data.IWebView
    public boolean isWebView(View view) {
        return view instanceof WebView;
    }
}
