package tb;

import android.view.View;
import com.taobao.monitor.impl.data.IWebView;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class k13 implements IWebView {
    public static final k13 INSTANCE = new k13();
    private IWebView a;

    public k13 a(IWebView iWebView) {
        this.a = iWebView;
        return this;
    }

    @Override // com.taobao.monitor.impl.data.IWebView
    public boolean isWebView(View view) {
        IWebView iWebView = this.a;
        if (iWebView != null) {
            return iWebView.isWebView(view);
        }
        return false;
    }

    @Override // com.taobao.monitor.impl.data.IWebView
    public int webViewProgress(View view) {
        IWebView iWebView = this.a;
        if (iWebView != null) {
            return iWebView.webViewProgress(view);
        }
        return 0;
    }
}
