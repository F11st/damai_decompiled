package com.uc.webview.export;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.print.PrintDocumentAdapter;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.extension.CommonExtension;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.extension.UCExtension;
import com.uc.webview.export.internal.AbstractC7213a;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.interfaces.IWebViewOverride;
import com.uc.webview.export.internal.interfaces.InvokeObject;
import com.uc.webview.export.internal.uc.startup.C7302b;
import com.uc.webview.export.internal.utility.C7327d;
import com.uc.webview.export.internal.utility.C7345n;
import com.uc.webview.export.internal.utility.C7349p;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class WebView extends FrameLayout implements IWebViewOverride {
    public static final int CORE_TYPE_ANDROID = 2;
    public static final int CORE_TYPE_U3 = 1;
    public static final int CORE_TYPE_U4 = 3;
    public static final int CREATE_FLAG_FORCE_USING_SYSTEM = 2;
    public static final int CREATE_FLAG_QUICK = 1;
    public static final int DEFAULT_CORE_TYPE = 1;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    private WebSettings a;
    private AbstractC7213a b;
    private CommonExtension c;
    private UCExtension d;
    private boolean e;
    private C7175a f;
    private int g;
    private WebViewCountting h;
    private boolean i;
    protected IWebView mWebView;
    private RuntimeException n;
    private boolean o;
    protected static int[] sInstanceCount = {0, 0, 0, 0};
    private static AtomicInteger j = new AtomicInteger();
    private static AtomicInteger k = new AtomicInteger();
    private static AtomicInteger l = new AtomicInteger();
    private static boolean m = true;

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public interface FindListener {
        void onFindResultReceived(int i, int i2, boolean z);
    }

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public class HitTestResult {
        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;
        private IWebView.IHitTestResult b;

        /* synthetic */ HitTestResult(WebView webView, IWebView.IHitTestResult iHitTestResult, byte b) {
            this(iHitTestResult);
        }

        public String getExtra() {
            return this.b.getExtra();
        }

        public int getType() {
            return this.b.getType();
        }

        protected HitTestResult() {
        }

        private HitTestResult(IWebView.IHitTestResult iHitTestResult) {
            this.b = iHitTestResult;
        }
    }

    /* compiled from: Taobao */
    @Reflection
    /* loaded from: classes11.dex */
    static class WebViewCountting {
        WebViewCountting() {
        }
    }

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public class WebViewTransport {
        private WebView b;

        public WebViewTransport() {
        }

        public synchronized WebView getWebView() {
            return this.b;
        }

        public synchronized void setWebView(WebView webView) {
            this.b = webView;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.WebView$a */
    /* loaded from: classes11.dex */
    static class C7175a extends MutableContextWrapper {
        WebView a;

        public C7175a(Context context, WebView webView) {
            super(context);
            if (context != null) {
                this.a = webView;
                return;
            }
            throw new IllegalArgumentException("Base context can not be null.");
        }

        @Override // android.content.MutableContextWrapper
        public final void setBaseContext(Context context) {
            super.setBaseContext(context);
            WebView webView = this.a;
            if (webView != null) {
                WebView.a(webView, this);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.WebView$b */
    /* loaded from: classes11.dex */
    public static abstract class AbstractC7176b {
    }

    public WebView(Context context) throws RuntimeException {
        this(context, null, 16842885, false, (byte) 0);
    }

    public static <T extends WebView> void asyncNew(Class<T> cls, Class<?>[] clsArr, Object[] objArr, ValueCallback<Pair<T, Throwable>> valueCallback) {
        C7345n.a(new RunnableC7207e(cls, clsArr, objArr, valueCallback));
    }

    private void d() {
        if (this.mWebView == null) {
            if (this.n != null) {
                throw new IllegalStateException("WebView had destroyed,forbid it's interfaces to be called.", this.n);
            }
            throw new IllegalStateException("WebView had destroyed,forbid it's interfaces to be called.");
        }
    }

    private static void e() {
        C7349p.a((Map<String, String>) new C7177a());
    }

    public static void enableSlowWholeDocumentDraw() {
        SDKFactory.m();
    }

    private void f() {
        if (this.o) {
            new RuntimeException("add or remove view in export.WebView.draw").printStackTrace();
        }
    }

    public static int getCoreType() {
        return SDKFactory.e();
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        if (getCoreType() == 2) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    android.webkit.WebView.setWebContentsDebuggingEnabled(z);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        UCCore.notifyCoreEvent(100, new Boolean(z));
    }

    public void addJavascriptInterface(Object obj, String str) {
        d();
        this.mWebView.addJavascriptInterface(obj, str);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        f();
        super.addView(view, layoutParams);
    }

    public boolean canGoBack() {
        d();
        return this.mWebView.canGoBack();
    }

    public boolean canGoBackOrForward(int i) {
        d();
        return this.mWebView.canGoBackOrForward(i);
    }

    public boolean canGoForward() {
        d();
        return this.mWebView.canGoForward();
    }

    @Deprecated
    public Picture capturePicture() {
        d();
        return this.mWebView.capturePicture();
    }

    public void clearCache(boolean z) {
        d();
        this.mWebView.clearCache(z);
    }

    public void clearFormData() {
        d();
        this.mWebView.clearFormData();
    }

    public void clearHistory() {
        d();
        this.mWebView.clearHistory();
    }

    public void clearMatches() {
        d();
        this.mWebView.clearMatches();
    }

    public void clearSslPreferences() {
        d();
        this.mWebView.clearSslPreferences();
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
    }

    public WebBackForwardList copyBackForwardList() {
        d();
        return this.mWebView.copyBackForwardListInner();
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebViewOverride
    public void coreComputeScroll() {
        IWebView iWebView = this.mWebView;
        if (iWebView != null) {
            iWebView.superComputeScroll();
        }
    }

    public void coreDestroy() {
        IWebView iWebView = this.mWebView;
        if (iWebView != null) {
            iWebView.superDestroy();
        }
    }

    public boolean coreDispatchTouchEvent(MotionEvent motionEvent) {
        IWebView iWebView = this.mWebView;
        if (iWebView != null) {
            return iWebView.superDispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebViewOverride
    public void coreDraw(Canvas canvas) {
        IWebView iWebView = this.mWebView;
        if (iWebView != null) {
            iWebView.superDraw(canvas);
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebViewOverride
    public void coreOnConfigurationChanged(Configuration configuration) {
        IWebView iWebView = this.mWebView;
        if (iWebView != null) {
            iWebView.superOnConfigurationChanged(configuration);
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebViewOverride
    public void coreOnInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (this.mWebView != null) {
            accessibilityEvent.setClassName(WebView.class.getName());
            ((InvokeObject) this.mWebView).invoke(2, new Object[]{accessibilityEvent});
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebViewOverride
    public void coreOnInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (this.mWebView != null) {
            accessibilityNodeInfo.setClassName(WebView.class.getName());
            ((InvokeObject) this.mWebView).invoke(1, new Object[]{accessibilityNodeInfo});
        }
    }

    public void coreOnScrollChanged(int i, int i2, int i3, int i4) {
        IWebView iWebView = this.mWebView;
        if (iWebView != null) {
            iWebView.superOnScrollChanged(i, i2, i3, i4);
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebViewOverride
    public void coreOnVisibilityChanged(View view, int i) {
        IWebView iWebView = this.mWebView;
        if (iWebView != null) {
            iWebView.superOnVisibilityChanged(view, i);
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebViewOverride
    public boolean coreOverScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        IWebView iWebView = this.mWebView;
        if (iWebView != null) {
            return iWebView.superOverScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        }
        return false;
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebViewOverride
    public boolean corePerformAccessibilityAction(int i, Bundle bundle) {
        if (this.mWebView != null) {
            return Boolean.parseBoolean(((InvokeObject) this.mWebView).invoke(3, new Object[]{Integer.valueOf(i), bundle}).toString());
        }
        return false;
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebViewOverride
    public void coreRequestLayout() {
        IWebView iWebView = this.mWebView;
        if (iWebView != null) {
            iWebView.superRequestLayout();
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.IWebViewOverride
    public void coreSetVisibility(int i) {
        IWebView iWebView = this.mWebView;
        if (iWebView != null) {
            iWebView.superSetVisibility(i);
        }
    }

    @TargetApi(19)
    public PrintDocumentAdapter createPrintDocumentAdapter(String str) {
        if (Build.VERSION.SDK_INT >= 19 && SDKFactory.b() && getCoreType() == 3) {
            IWebView iWebView = this.mWebView;
            if (iWebView instanceof InvokeObject) {
                return (PrintDocumentAdapter) ((InvokeObject) iWebView).invoke(11, new Object[]{str});
            }
        }
        return null;
    }

    public WebMessagePort[] createWebMessageChannel() {
        d();
        Object createWebMessageChannelInner = this.mWebView.createWebMessageChannelInner();
        if (createWebMessageChannelInner instanceof WebMessagePort[]) {
            return (WebMessagePort[]) createWebMessageChannelInner;
        }
        return null;
    }

    public void destroy() {
        synchronized (this) {
            if (!this.i) {
                this.i = true;
                this.h = null;
            } else {
                throw new RuntimeException("destroy() already called.");
            }
        }
        boolean isAttachedToWindow = Build.VERSION.SDK_INT >= 19 ? isAttachedToWindow() : true;
        this.n = new RuntimeException("This is the stack of destroying WebView, isAttachedToWindow:" + isAttachedToWindow);
        this.mWebView.destroy();
        if (this.g == 3) {
            l.decrementAndGet();
        } else {
            k.decrementAndGet();
        }
        this.mWebView = null;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        C7175a c7175a = this.f;
        if (c7175a != null) {
            Context baseContext = c7175a.getBaseContext();
            if (baseContext != null) {
                try {
                    Field declaredField = ContextWrapper.class.getDeclaredField("mBase");
                    if (declaredField != null) {
                        declaredField.setAccessible(true);
                        declaredField.set(c7175a, baseContext.getApplicationContext());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e2) {
                    e2.printStackTrace();
                }
            }
            if (c7175a.a != null) {
                c7175a.a = null;
            }
            this.f = null;
        }
        j.decrementAndGet();
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        d();
        return this.mWebView.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void documentHasImages(Message message) {
        d();
        this.mWebView.documentHasImages(message);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        if (isDestroied()) {
            return;
        }
        try {
            this.o = true;
            super.draw(canvas);
            this.o = false;
        } catch (Throwable th) {
            this.o = false;
            Log.e("WebView", "Exception happens in Webview.draw", th);
            throw th;
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        d();
        com.uc.webview.export.cyclone.Log.i("export.WebView", "evaluateJavascript, this: " + hashCode() + ", partScript: " + a(str));
        this.mWebView.evaluateJavascript(str, valueCallback);
    }

    public void findAllAsync(String str) {
        d();
        this.mWebView.findAllAsync(str);
    }

    public void findNext(boolean z) {
        d();
        this.mWebView.findNext(z);
    }

    public void flingScroll(int i, int i2) {
        d();
        this.mWebView.flingScroll(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return WebView.class.getName();
    }

    public SslCertificate getCertificate() {
        d();
        return this.mWebView.getCertificate();
    }

    public CommonExtension getCommonExtension() {
        return this.c;
    }

    public int getContentHeight() {
        d();
        return this.mWebView.getContentHeight();
    }

    public View getCoreView() {
        d();
        return this.mWebView.getView();
    }

    public int getCurrentViewCoreType() {
        return this.g;
    }

    public Bitmap getFavicon() {
        d();
        return this.mWebView.getFavicon();
    }

    public HitTestResult getHitTestResult() {
        d();
        if (this.mWebView.getHitTestResultInner() != null) {
            return new HitTestResult(this, this.mWebView.getHitTestResultInner(), (byte) 0);
        }
        return null;
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        d();
        return this.mWebView.getHttpAuthUsernamePassword(str, str2);
    }

    public String getOriginalUrl() {
        d();
        return this.mWebView.getOriginalUrl();
    }

    public int getProgress() {
        d();
        return this.mWebView.getProgress();
    }

    @Deprecated
    public float getScale() {
        d();
        return this.mWebView.getScale();
    }

    public WebSettings getSettings() {
        d();
        return this.a;
    }

    public String getTitle() {
        d();
        return this.mWebView.getTitle();
    }

    public UCExtension getUCExtension() {
        return this.d;
    }

    public String getUrl() {
        d();
        return this.mWebView.getUrl();
    }

    public void goBack() {
        d();
        this.mWebView.goBack();
    }

    public void goBackOrForward(int i) {
        d();
        this.mWebView.goBackOrForward(i);
    }

    public void goForward() {
        d();
        this.mWebView.goForward();
    }

    public void invokeZoomPicker() {
        d();
        this.mWebView.invokeZoomPicker();
    }

    public boolean isDestroied() {
        return this.i || this.mWebView == null;
    }

    @Override // android.view.View
    public boolean isHorizontalScrollBarEnabled() {
        d();
        return this.mWebView.isHorizontalScrollBarEnabled();
    }

    public boolean isPrivateBrowsingEnabled() {
        Boolean bool = (Boolean) ((InvokeObject) this.mWebView).invoke(8, null);
        return bool != null && bool.booleanValue();
    }

    @Override // android.view.View
    public boolean isVerticalScrollBarEnabled() {
        d();
        return this.mWebView.isVerticalScrollBarEnabled();
    }

    public void loadData(String str, String str2, String str3) {
        d();
        com.uc.webview.export.cyclone.Log.i("export.WebView", "loadData, this: " + hashCode() + ", mimeType: " + str2 + ", partData: " + a(str));
        this.mWebView.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        com.uc.webview.export.cyclone.Log.i("export.WebView", "loadDataWithBaseURL, this: " + hashCode() + ", url: " + str);
        d();
        this.mWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        com.uc.webview.export.cyclone.Log.i("export.WebView", "loadUrl, this: " + hashCode() + ", url: " + str);
        d();
        this.mWebView.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IWebView iWebView = this.mWebView;
        if (iWebView == null || this.b == null) {
            return;
        }
        AbstractC7213a.a(iWebView);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        IWebView iWebView = this.mWebView;
        if (iWebView != null) {
            return iWebView.onCreateInputConnection(editorInfo);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        AbstractC7213a abstractC7213a;
        super.onDetachedFromWindow();
        IWebView iWebView = this.mWebView;
        if (iWebView == null || (abstractC7213a = this.b) == null) {
            return;
        }
        abstractC7213a.b(iWebView);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (motionEvent == null || (motionEvent.getSource() & 8194) != 8194) {
            return onInterceptTouchEvent;
        }
        return false;
    }

    public void onPause() {
        d();
        this.mWebView.onPause();
    }

    public void onResume() {
        d();
        this.mWebView.onResume();
    }

    @Override // android.view.View
    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        AbstractC7213a abstractC7213a;
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mWebView == null || (abstractC7213a = this.b) == null) {
            return;
        }
        abstractC7213a.a(i, i2);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        AbstractC7213a abstractC7213a;
        super.onWindowVisibilityChanged(i);
        IWebView iWebView = this.mWebView;
        if (iWebView == null || (abstractC7213a = this.b) == null) {
            return;
        }
        abstractC7213a.a(iWebView, i);
    }

    @Override // android.view.View
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public boolean pageDown(boolean z) {
        d();
        return this.mWebView.pageDown(z);
    }

    public boolean pageUp(boolean z) {
        d();
        return this.mWebView.pageUp(z);
    }

    public void pauseTimers() {
        d();
        this.mWebView.pauseTimers();
    }

    public void postUrl(String str, byte[] bArr) {
        d();
        this.mWebView.postUrl(str, bArr);
    }

    public void postVisualStateCallback(long j2, AbstractC7176b abstractC7176b) {
        this.mWebView.postVisualStateCallback(j2, abstractC7176b);
    }

    public void postWebMessage(WebMessage webMessage, Uri uri) {
        d();
        this.mWebView.postWebMessageInner(webMessage, uri);
    }

    public void reload() {
        d();
        this.mWebView.reload();
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        f();
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        f();
        super.removeAllViewsInLayout();
    }

    public void removeJavascriptInterface(String str) {
        d();
        try {
            this.mWebView.removeJavascriptInterface(str);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        f();
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        f();
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        f();
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        f();
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        f();
        super.removeViewsInLayout(i, i2);
    }

    public void requestFocusNodeHref(Message message) {
        d();
        this.mWebView.requestFocusNodeHref(message);
    }

    public void requestImageRef(Message message) {
        d();
        this.mWebView.requestImageRef(message);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        d();
        return this.mWebView.restoreStateInner(bundle);
    }

    public void resumeTimers() {
        d();
        this.mWebView.resumeTimers();
    }

    public WebBackForwardList saveState(Bundle bundle) {
        d();
        return this.mWebView.saveStateInner(bundle);
    }

    public void saveWebArchive(String str) {
        d();
        this.mWebView.saveWebArchive(str);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        IWebView iWebView = this.mWebView;
        if (iWebView != null) {
            iWebView.setBackgroundColor(i);
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        d();
        this.mWebView.setDownloadListener(downloadListener);
    }

    public void setFindListener(FindListener findListener) {
        d();
        this.mWebView.setFindListener(findListener);
    }

    @Override // android.view.View
    public void setHorizontalScrollBarEnabled(boolean z) {
        d();
        this.mWebView.setHorizontalScrollBarEnabled(z);
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        d();
        this.mWebView.setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    public void setInitialScale(int i) {
        d();
        this.mWebView.setInitialScale(i);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (getCoreView() == null || layoutParams.height >= 0) {
            return;
        }
        getCoreView().setLayoutParams(new FrameLayout.LayoutParams(layoutParams));
    }

    public void setNetworkAvailable(boolean z) {
        d();
        this.mWebView.setNetworkAvailable(z);
    }

    @Override // android.view.View
    public void setOnKeyListener(View.OnKeyListener onKeyListener) {
        d();
        if (onKeyListener != null) {
            this.mWebView.setOnKeyListener(new View$OnKeyListenerC7206d(this, onKeyListener));
        } else {
            this.mWebView.setOnKeyListener(null);
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        d();
        if (onLongClickListener != null) {
            this.mWebView.setOnLongClickListener(new View$OnLongClickListenerC7178b(this, onLongClickListener));
        } else {
            this.mWebView.setOnLongClickListener(null);
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        d();
        if (onTouchListener != null) {
            this.mWebView.setOnTouchListener(new View$OnTouchListenerC7205c(this, onTouchListener));
        } else {
            this.mWebView.setOnTouchListener(null);
        }
    }

    @Override // android.view.View
    public final void setOverScrollMode(int i) {
        if (this.mWebView == null || getCoreType() == 1) {
            return;
        }
        this.mWebView.setOverScrollMode(i);
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        IWebView iWebView = this.mWebView;
        if (iWebView != null) {
            iWebView.setScrollBarStyle(i);
        }
        super.setScrollBarStyle(i);
    }

    @Override // android.view.View
    public void setVerticalScrollBarEnabled(boolean z) {
        d();
        this.mWebView.setVerticalScrollBarEnabled(z);
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        d();
        this.mWebView.setVerticalScrollbarOverlay(z);
    }

    @Override // android.view.View
    public final void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        d();
        this.mWebView.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        d();
        this.mWebView.setWebViewClient(webViewClient);
    }

    public void stopLoading() {
        d();
        this.mWebView.stopLoading();
    }

    public void zoomBy(float f) {
        d();
        double d = f;
        if (d < 0.01d) {
            throw new IllegalArgumentException("zoomFactor must be greater than 0.01.");
        }
        if (d <= 100.0d) {
            if (getCoreType() == 2) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        ReflectionUtil.invoke(getCoreView(), "zoomBy", new Class[]{Float.TYPE}, new Object[]{Float.valueOf(f)});
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            }
            ((InvokeObject) this.mWebView).invoke(7, new Object[]{Float.valueOf(f)});
            return;
        }
        throw new IllegalArgumentException("zoomFactor must be less than 100.");
    }

    public boolean zoomIn() {
        d();
        return this.mWebView.zoomIn();
    }

    public boolean zoomOut() {
        d();
        return this.mWebView.zoomOut();
    }

    public WebView(Context context, boolean z) throws RuntimeException {
        this(context, null, 16842885, z, (byte) 0);
    }

    private static String a(String str) {
        return str == null ? "" : str.length() <= 256 ? str : str.substring(0, 256);
    }

    public WebView(Context context, AttributeSet attributeSet) throws RuntimeException {
        this(context, attributeSet, 16842885, false, (byte) 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        f();
        super.addView(view, i);
    }

    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        d();
        this.mWebView.saveWebArchive(str, z, valueCallback);
    }

    public WebView(Context context, AttributeSet attributeSet, boolean z) throws RuntimeException {
        this(context, attributeSet, 16842885, z, (byte) 0);
    }

    static /* synthetic */ void a(WebView webView, Context context) {
        IWebView iWebView = webView.mWebView;
        if (iWebView == null || iWebView.getUCExtension() == null) {
            return;
        }
        webView.mWebView.getUCExtension().invoke(25, new Object[]{context});
    }

    public void loadUrl(String str, Map<String, String> map) {
        com.uc.webview.export.cyclone.Log.i("export.WebView", "loadUrl with headers, this: " + hashCode() + ", url: " + str);
        d();
        this.mWebView.loadUrl(str, map);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) throws RuntimeException {
        this(context, attributeSet, i, false, (byte) 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        f();
        super.addView(view, i, layoutParams);
    }

    public WebView(Context context, AttributeSet attributeSet, boolean z, int i) throws RuntimeException {
        this(context, attributeSet, i, z, (byte) 0);
    }

    @Deprecated
    public WebView(Context context, AttributeSet attributeSet, int i, boolean z) throws RuntimeException {
        this(context, attributeSet, i, false, (byte) 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        f();
        super.addView(view);
    }

    private WebView(Context context, AttributeSet attributeSet, int i, boolean z, byte b) throws RuntimeException {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.e = true;
        this.h = new WebViewCountting();
        this.i = false;
        this.n = null;
        this.o = false;
        if (context != null) {
            if (m) {
                com.uc.webview.export.cyclone.Log.rInfo("ucstartup", "begin create new first export WebView");
                C7327d.a("HasNewUCWebView", "true");
                C7302b.a(526);
            }
            C7175a c7175a = new C7175a(context, this);
            this.f = c7175a;
            int[] iArr = new int[1];
            IWebView a = SDKFactory.a(c7175a, attributeSet, this, z, iArr);
            this.mWebView = a;
            a.setOverrideObject(this);
            int i2 = iArr[0];
            this.g = i2;
            int[] iArr2 = sInstanceCount;
            iArr2[i2] = iArr2[i2] + 1;
            this.b = SDKFactory.a(i2, this.f.getApplicationContext());
            WebSettings settingsInner = this.mWebView.getSettingsInner();
            this.a = settingsInner;
            settingsInner.setMixedContentMode(0);
            if (attributeSet == null) {
                addView(this.mWebView.getView(), new FrameLayout.LayoutParams(-1, -1));
            } else if (SDKFactory.l()) {
                addView(this.mWebView.getView());
            } else {
                addView(this.mWebView.getView(), generateLayoutParams(attributeSet));
            }
            this.c = new CommonExtension(this.mWebView);
            this.d = SDKFactory.a(context, this.mWebView, this.g);
            if (!SDKFactory.f) {
                setWillNotDraw(false);
            }
            if (this.g == 3) {
                IWebView iWebView = this.mWebView;
                if (iWebView instanceof InvokeObject) {
                    ((InvokeObject) iWebView).invoke(9, null);
                }
            }
            if (m) {
                m = false;
                C7302b.a(527);
                com.uc.webview.export.cyclone.Log.rInfo("ucstartup", "end create first export WebView");
            }
            j.incrementAndGet();
            if (this.g == 3) {
                l.incrementAndGet();
            } else {
                k.incrementAndGet();
            }
            e();
            return;
        }
        throw new IllegalArgumentException("Invalid context argument");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        f();
        super.addView(view, i, i2);
    }
}
