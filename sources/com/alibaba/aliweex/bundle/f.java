package com.alibaba.aliweex.bundle;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.taobao.windvane.webview.WVSchemeInterceptService;
import android.taobao.windvane.webview.WVSchemeIntercepterInterface;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.alibaba.aliweex.adapter.IEventModuleAdapter;
import com.taobao.orange.OConstant;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.component.NestedContainer;
import com.taobao.weex.ui.component.WXEmbed;
import com.taobao.weex.utils.WXUtils;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import tb.ev2;
import tb.uz2;
import tb.zz2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class f implements WXSDKInstance.NestedInstanceInterceptor {
    protected ArrayList<b> a = new ArrayList<>();
    protected Handler b;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class a extends WXEmbed.ClickToReloadListener {
        private static String h = "_wx_tpl";
        private static String i = "wh_weex";
        private Context a;
        private Handler b;
        private WVUCWebView c;
        private WXSDKInstance e;
        private boolean d = false;
        Object f = null;
        String g = "";

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.aliweex.bundle.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class C0129a extends WVUCWebViewClient {
            C0129a(Context context) {
                super(context);
            }

            @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (!TextUtils.isEmpty(str) && str.startsWith("https://err.tmall.com") && str.contains("wh_weex=true")) {
                    str = str.replace("wh_weex=true", "wh_weex=false");
                }
                IEventModuleAdapter f = com.alibaba.aliweex.a.l().f();
                if (f != null) {
                    f.openURL(a.this.a, str);
                    return true;
                }
                return true;
            }
        }

        protected a(Context context, Handler handler) {
            this.a = context;
            this.b = handler;
        }

        private String d(String str) {
            WVSchemeIntercepterInterface wVSchemeIntercepter = WVSchemeInterceptService.getWVSchemeIntercepter();
            if (wVSchemeIntercepter != null) {
                str = wVSchemeIntercepter.dealUrlScheme(str);
            }
            Uri parse = Uri.parse(str);
            if (parse == null || !parse.isHierarchical()) {
                return null;
            }
            if (parse.getBooleanQueryParameter(i, false)) {
                return str;
            }
            String queryParameter = parse.getQueryParameter(h);
            if (TextUtils.isEmpty(queryParameter)) {
                return null;
            }
            Uri.Builder buildUpon = Uri.parse(queryParameter).buildUpon();
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames != null && queryParameterNames.size() > 0) {
                for (String str2 : queryParameterNames) {
                    if (str2 != h) {
                        buildUpon.appendQueryParameter(str2, parse.getQueryParameter(str2));
                    }
                }
            }
            return buildUpon.toString();
        }

        public void b() {
            WVUCWebView wVUCWebView = this.c;
            if (wVUCWebView != null) {
                wVUCWebView.coreDestroy();
                this.c = null;
            }
            this.e = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public WXSDKInstance c() {
            return this.e;
        }

        void e(WXSDKInstance wXSDKInstance) {
            this.e = wXSDKInstance;
        }

        @Override // com.taobao.weex.ui.component.WXEmbed.ClickToReloadListener, com.taobao.weex.ui.component.NestedContainer.OnNestedInstanceEventListener
        public void onCreated(NestedContainer nestedContainer, WXSDKInstance wXSDKInstance) {
            super.onCreated(nestedContainer, wXSDKInstance);
            nestedContainer.renderNewURL(zz2.ERROR_BUNDLE_URL);
        }

        @Override // com.taobao.weex.ui.component.WXEmbed.ClickToReloadListener, com.taobao.weex.ui.component.NestedContainer.OnNestedInstanceEventListener
        public void onException(NestedContainer nestedContainer, String str, String str2) {
            boolean z;
            WVUCWebView wVUCWebView;
            WXSDKInstance wXSDKInstance = this.e;
            boolean shouldDegrade = wXSDKInstance != null ? WeexPageFragment.shouldDegrade(wXSDKInstance, str, str2) : false;
            if (this.f != null && !TextUtils.isEmpty(this.g) && !shouldDegrade) {
                WXSDKInstance wXSDKInstance2 = this.e;
                Map<String, Object> e = uz2.e(wXSDKInstance2 != null ? wXSDKInstance2.getContext() : null, this.f, this.g);
                if (e != null && e.get("fatBundleUrl") != null) {
                    ((WXEmbed) nestedContainer).renderNewURL(e.get("fatBundleUrl").toString());
                    this.g = null;
                }
            }
            if (shouldDegrade) {
                ViewGroup viewContainer = nestedContainer.getViewContainer();
                if (nestedContainer instanceof WXEmbed) {
                    WXEmbed wXEmbed = (WXEmbed) nestedContainer;
                    if (wXEmbed.getEvents().contains(OConstant.SYSKEY_DOWNGRADE)) {
                        wXEmbed.fireEvent(OConstant.SYSKEY_DOWNGRADE);
                    }
                    z = WXUtils.getBoolean(wXEmbed.getAttrs().get("nestedScrollEnabled"), Boolean.FALSE).booleanValue();
                } else {
                    z = false;
                }
                if (z) {
                    wVUCWebView = new NestedScrollingWebView(viewContainer.getContext());
                } else {
                    wVUCWebView = new WVUCWebView(viewContainer.getContext());
                }
                this.c = wVUCWebView;
                WebSettings settings = wVUCWebView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setAppCacheEnabled(true);
                settings.setUseWideViewPort(true);
                settings.setDomStorageEnabled(true);
                settings.setSupportZoom(false);
                settings.setBuiltInZoomControls(false);
                wVUCWebView.setVerticalScrollBarEnabled(true);
                wVUCWebView.setScrollBarStyle(0);
                wVUCWebView.setWebViewClient(new C0129a(this.a));
                wVUCWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                viewContainer.removeAllViews();
                viewContainer.addView(wVUCWebView);
                wVUCWebView.loadUrl(((WXEmbed) nestedContainer).getSrc());
                this.d = true;
                return;
            }
            super.onException(nestedContainer, str, str2);
        }

        @Override // com.taobao.weex.ui.component.WXEmbed.ClickToReloadListener, com.taobao.weex.ui.component.NestedContainer.OnNestedInstanceEventListener
        public boolean onPreCreate(NestedContainer nestedContainer, String str) {
            Handler handler;
            if (ev2.d(str)) {
                if (ev2.h(str) && (handler = this.b) != null) {
                    handler.sendEmptyMessage(18);
                }
                ViewGroup viewContainer = nestedContainer.getViewContainer();
                if ((viewContainer.getChildAt(0) instanceof ProgressBar) || this.d) {
                    return true;
                }
                ProgressBar progressBar = new ProgressBar(viewContainer.getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                progressBar.setLayoutParams(layoutParams);
                viewContainer.removeAllViews();
                viewContainer.addView(progressBar);
                return true;
            }
            return false;
        }

        @Override // com.taobao.weex.ui.component.WXEmbed.ClickToReloadListener, com.taobao.weex.ui.component.NestedContainer.OnNestedInstanceEventListener
        public String transformUrl(String str) {
            String d = d(str);
            WXSDKInstance wXSDKInstance = this.e;
            if (wXSDKInstance != null) {
                d = uz2.o(wXSDKInstance, d);
            }
            WXSDKInstance wXSDKInstance2 = this.e;
            Pair<String, Object> f = uz2.f(wXSDKInstance2 != null ? wXSDKInstance2.getContext() : null, d, d);
            if (f != null) {
                String str2 = (String) f.first;
                this.f = f.second;
                this.g = str2;
                return str2;
            }
            return d;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class b {
        public NestedContainer a;
        public a b;

        public b(a aVar, NestedContainer nestedContainer) {
            this.b = aVar;
            this.a = nestedContainer;
        }
    }

    public f(Context context, Handler handler) {
        this.b = handler;
    }

    public void a() {
        ArrayList<b> arrayList = this.a;
        if (arrayList != null) {
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                a aVar = it.next().b;
                if (aVar != null) {
                    aVar.b();
                }
            }
            this.a.clear();
            this.a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NestedContainer b(WXSDKInstance wXSDKInstance) {
        ArrayList<b> arrayList = this.a;
        if (arrayList != null) {
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next.b.c() == wXSDKInstance) {
                    return next.a;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<b> c() {
        return this.a;
    }

    @Override // com.taobao.weex.WXSDKInstance.NestedInstanceInterceptor
    public void onCreateNestInstance(WXSDKInstance wXSDKInstance, NestedContainer nestedContainer) {
        a aVar = new a(wXSDKInstance.getContext(), this.b);
        aVar.e(wXSDKInstance);
        nestedContainer.setOnNestEventListener(aVar);
        this.a.add(new b(aVar, nestedContainer));
    }
}
