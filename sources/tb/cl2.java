package tb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.taobao.windvane.webview.IWVWebView;
import com.taomai.android.h5container.TaoMaiH5Container;
import com.uc.webview.export.WebBackForwardList;
import com.uc.webview.export.WebHistoryItem;
import com.uc.webview.export.WebView;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.ref.WeakReference;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.qm;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cl2 extends WVUCWebViewClient {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cl2(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
    public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
    public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
        boolean F;
        TaoMaiH5Container.NavHandler b;
        WeakReference<Context> weakReference = this.mContext;
        Context context = weakReference != null ? weakReference.get() : null;
        if (!(context instanceof Activity)) {
            context = null;
        }
        Activity activity = (Activity) context;
        if (activity != null && str != null && (b = TaoMaiH5Container.b()) != null) {
            Objects.requireNonNull(webView, "null cannot be cast to non-null type android.taobao.windvane.webview.IWVWebView");
            if (b.shouldOverrideUrlLoading(activity, str, (IWVWebView) webView)) {
                WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
                if (copyBackForwardList != null) {
                    if (copyBackForwardList.getSize() == 0 && !activity.isFinishing()) {
                        activity.finish();
                        return true;
                    }
                    qm.a aVar = qm.Companion;
                    WebHistoryItem currentItem = copyBackForwardList.getCurrentItem();
                    if (aVar.d(currentItem != null ? currentItem.getUrl() : null) && !activity.isFinishing()) {
                        activity.finish();
                    }
                }
                return true;
            }
        }
        if (str != null) {
            F = kotlin.text.o.F(str, "http", false, 2, null);
            if (!F) {
                TaoMaiH5Container.NavHandler b2 = TaoMaiH5Container.b();
                if (b2 == null) {
                    return false;
                }
                if (activity != null) {
                    if (!(webView instanceof IWVWebView)) {
                        webView = null;
                    }
                    b2.handleUrl(activity, str, true, (IWVWebView) webView);
                    return true;
                }
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
