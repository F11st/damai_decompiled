package com.taomai.android.h5container.webview;

import android.content.Context;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.taomai.android.h5container.utils.WebViewLongClickHandler;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.yk2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007¨\u0006\u0011"}, d2 = {"Lcom/taomai/android/h5container/webview/TaoMaiUCWebView;", "Landroid/taobao/windvane/extra/uc/WVUCWebView;", "", "url", "Ltb/wt2;", "loadUrl", "doDestory", "", "realScrollY", "realScrollX", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public class TaoMaiUCWebView extends WVUCWebView {
    @JvmOverloads
    public TaoMaiUCWebView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public TaoMaiUCWebView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ TaoMaiUCWebView(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void doDestory() {
        setVisibility(8);
        WebSettings settings = getSettings();
        b41.h(settings, "settings");
        settings.setJavaScriptEnabled(false);
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        removeAllViews();
        try {
            coreDestroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebView, com.uc.webview.export.WebView, android.taobao.windvane.webview.IWVWebView
    public void loadUrl(@NotNull String str) {
        b41.i(str, "url");
        super.loadUrl(str);
    }

    public final int realScrollX() {
        View view = getView();
        if (view != null) {
            return view.getScrollX();
        }
        return 0;
    }

    public final int realScrollY() {
        View view = getView();
        if (view != null) {
            return view.getScrollY();
        }
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TaoMaiUCWebView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (yk2.a()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        WebSettings settings = getSettings();
        b41.h(settings, "settings");
        StringBuilder sb = new StringBuilder();
        WebSettings settings2 = getSettings();
        b41.h(settings2, "settings");
        sb.append(settings2.getUserAgentString());
        sb.append(yk2.b());
        settings.setUserAgentString(sb.toString());
        new WebViewLongClickHandler(this).k();
    }
}
