package com.taomai.android.h5container.webview;

import android.content.Context;
import android.taobao.windvane.webview.WVWebView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.uc.webview.export.cyclone.update.UpdateService;
import com.uc.webview.export.extension.UCCore;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fb1;
import tb.yk2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B%\b\u0016\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010 \u001a\u00020\r¢\u0006\u0004\b!\u0010\"B\u001d\b\u0016\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b!\u0010#B\u0013\b\u0016\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b!\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0006\u0010\b\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J(\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0014R\u0016\u0010\u0013\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/taomai/android/h5container/webview/TaoMaiWebView;", "Landroid/taobao/windvane/webview/WVWebView;", "Ltb/wt2;", UCCore.LEGACY_EVENT_INIT, "", "url", "loadUrl", "onResume", "doDestory", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "", "scrollX", "scrollY", "clampedX", "clampedY", "onOverScrolled", "isScrollX", "Z", "Landroid/view/ViewParent;", "scrollableViewParent", "Landroid/view/ViewParent;", "getScrollableViewParent", "()Landroid/view/ViewParent;", "setScrollableViewParent", "(Landroid/view/ViewParent;)V", "Landroid/content/Context;", UpdateService.OPTION_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public class TaoMaiWebView extends WVWebView {
    private boolean isScrollX;
    @Nullable
    private ViewParent scrollableViewParent;

    public TaoMaiWebView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
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
            destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public final ViewParent getScrollableViewParent() {
        return this.scrollableViewParent;
    }

    public final void init() {
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
        WebSettings settings3 = getSettings();
        b41.h(settings3, "settings");
        settings3.setAllowContentAccess(true);
        WebSettings settings4 = getSettings();
        b41.h(settings4, "settings");
        settings4.setMediaPlaybackRequiresUserGesture(false);
    }

    @Override // android.taobao.windvane.webview.WVWebView, android.webkit.WebView, android.taobao.windvane.webview.IWVWebView
    public void loadUrl(@NotNull String str) {
        b41.i(str, "url");
        super.loadUrl(str);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        fb1.a("TaoMaiWebView", "onOverScrolled :" + z);
        this.isScrollX = z;
    }

    @Override // android.taobao.windvane.webview.WVWebView, android.webkit.WebView
    public void onResume() {
        super.onResume();
    }

    @Override // android.taobao.windvane.webview.WVWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        b41.i(motionEvent, "event");
        if (motionEvent.getPointerCount() == 1) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.isScrollX = false;
                ViewParent viewParent = this.scrollableViewParent;
                if (viewParent != null) {
                    viewParent.requestDisallowInterceptTouchEvent(true);
                }
            } else if (action != 2) {
                ViewParent viewParent2 = this.scrollableViewParent;
                if (viewParent2 != null) {
                    viewParent2.requestDisallowInterceptTouchEvent(false);
                }
            } else {
                ViewParent viewParent3 = this.scrollableViewParent;
                if (viewParent3 != null) {
                    viewParent3.requestDisallowInterceptTouchEvent(!this.isScrollX);
                }
                fb1.a("TaoMaiWebView", "onTouchEvent :拦截处理" + (true ^ this.isScrollX));
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setScrollableViewParent(@Nullable ViewParent viewParent) {
        this.scrollableViewParent = viewParent;
    }

    public TaoMaiWebView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TaoMaiWebView(@Nullable Context context) {
        super(context);
        init();
    }
}
