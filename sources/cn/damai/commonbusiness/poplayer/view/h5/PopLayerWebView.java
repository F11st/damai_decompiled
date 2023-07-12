package cn.damai.commonbusiness.poplayer.view.h5;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Looper;
import android.taobao.windvane.extra.uc.WVUCWebChromeClient;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVWebChromeClient;
import android.taobao.windvane.webview.WVWebView;
import android.taobao.windvane.webview.WVWebViewClient;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.FrameLayout;
import cn.damai.h5container.DMBridge;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.factory.PLViewInfo;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.utils.ConsoleLogger$Level;
import com.alibaba.security.common.track.model.C3834a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.net.URLEncoder;
import org.json.JSONObject;
import org.json.JSONTokener;
import tb.dt1;
import tb.et1;
import tb.i13;
import tb.p40;
import tb.t01;

/* compiled from: Taobao */
@PLViewInfo(isDefaultType = true, type = C3834a.C3837c.d)
/* loaded from: classes4.dex */
public class PopLayerWebView extends PopLayerBaseView<IWVWebView, t01> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final String TAG = PopLayerWebView.class.getSimpleName();
    private String mUrl;
    private boolean mWebViewAddEnable;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.poplayer.view.h5.PopLayerWebView$a */
    /* loaded from: classes4.dex */
    public class C0776a extends WVUCWebChromeClient {
        private static transient /* synthetic */ IpChange $ipChange;

        C0776a(Context context) {
            super(context);
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebChromeClient, com.uc.webview.export.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-581148360")) {
                return ((Boolean) ipChange.ipc$dispatch("-581148360", new Object[]{this, consoleMessage})).booleanValue();
            }
            try {
                PopLayerWebView.this.sendLog(consoleMessage);
            } catch (Throwable th) {
                dt1.c("H5 WVUCWebChromeClient onConsoleMessage error", th);
            }
            return super.onConsoleMessage(consoleMessage);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.poplayer.view.h5.PopLayerWebView$b */
    /* loaded from: classes4.dex */
    public class C0777b extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BaseConfigItem a;

        C0777b(BaseConfigItem baseConfigItem) {
            this.a = baseConfigItem;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "373988881")) {
                ipChange.ipc$dispatch("373988881", new Object[]{this, view});
                return;
            }
            AlertDialog create = new AlertDialog.Builder(PopLayerWebView.this.getContext().getApplicationContext(), 3).setMessage(this.a.toString()).setTitle(String.format("Configuration DescItem for %s", this.a.uuid)).create();
            create.getWindow().setType(2038);
            create.show();
        }
    }

    public PopLayerWebView(Context context) {
        super(context);
        this.mWebViewAddEnable = true;
    }

    private IWVWebView buildWebView(Context context, BaseConfigItem baseConfigItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1421746983")) {
            return (IWVWebView) ipChange.ipc$dispatch("1421746983", new Object[]{this, context, baseConfigItem});
        }
        if (!TextUtils.isEmpty(this.mUrl) && this.mUrl.contains("poplayer_force_use_native_webkit")) {
            WVWebView wVWebView = new WVWebView(context);
            wVWebView.setWebViewClient(new WVWebViewClient(context));
            wVWebView.setWebChromeClient(new WVWebChromeClient(context) { // from class: cn.damai.commonbusiness.poplayer.view.h5.PopLayerWebView.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.taobao.windvane.webview.WVWebChromeClient, android.webkit.WebChromeClient
                public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1019157863")) {
                        return ((Boolean) ipChange2.ipc$dispatch("-1019157863", new Object[]{this, consoleMessage})).booleanValue();
                    }
                    try {
                        PopLayerWebView.this.sendLog(consoleMessage);
                    } catch (Throwable th) {
                        dt1.c("H5 WVWebChromeClient onConsoleMessage error", th);
                    }
                    return super.onConsoleMessage(consoleMessage);
                }
            });
            dt1.b("buildWebView,use native webkit. contains:poplayer_force_use_native_webkit", new Object[0]);
            return wVWebView;
        }
        WVUCWebView wVUCWebView = new WVUCWebView(context);
        wVUCWebView.setWebViewClient(new WVUCWebViewClient(context));
        wVUCWebView.setWebChromeClient(new C0776a(context));
        dt1.b("buildWebView,use default UC webview.", new Object[0]);
        return wVUCWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMeOnMainThread() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876357394")) {
            ipChange.ipc$dispatch("1876357394", new Object[]{this});
            return;
        }
        try {
            InnerView innerview = this.mInnerView;
            if (innerview != 0) {
                ((IWVWebView) innerview).loadUrl("about:blank");
                InnerView innerview2 = this.mInnerView;
                if (innerview2 instanceof WVWebView) {
                    ((WVWebView) innerview2).getSettings().setJavaScriptEnabled(false);
                }
                InnerView innerview3 = this.mInnerView;
                if (innerview3 instanceof WVUCWebView) {
                    ((WVUCWebView) innerview3).getSettings().setJavaScriptEnabled(false);
                }
                if (((View) this.mInnerView).getParent() != null) {
                    removeView((View) this.mInnerView);
                }
                InnerView innerview4 = this.mInnerView;
                if (innerview4 instanceof WVWebView) {
                    ((WVWebView) innerview4).destroy();
                } else if (innerview4 instanceof WVUCWebView) {
                    ((WVUCWebView) innerview4).destroy();
                }
                destroy();
                this.mInnerView = null;
            }
            ((t01) this.mPopRequest).n(null);
            this.mPopRequest = null;
            dt1.b("%s.destroyView.success", TAG);
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLog(ConsoleMessage consoleMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "349237734")) {
            ipChange.ipc$dispatch("349237734", new Object[]{this, consoleMessage});
        } else {
            consoleLog(String.format("%s\n@source-%s:lineNumber-%s", consoleMessage.message(), consoleMessage.sourceId(), Integer.valueOf(consoleMessage.lineNumber())), ConsoleLogger$Level.find(i13.WEBCONSOLE_LOGCAT_MAP.get(consoleMessage.messageLevel()).charValue()));
        }
    }

    private void setWebView(IWVWebView iWVWebView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1123388227")) {
            ipChange.ipc$dispatch("-1123388227", new Object[]{this, iWVWebView});
        } else if (iWVWebView == this.mInnerView) {
        } else {
            iWVWebView.loadUrl(String.format("javascript:(function () {Object.defineProperty(window,'_ua_popLayer',{value:%s});}());", String.format("\"PopLayer/%s\"", PopLayer.getReference().getVersion())));
            InnerView innerview = this.mInnerView;
            if (innerview != 0) {
                removeView((View) innerview);
            }
            this.mInnerView = iWVWebView;
            try {
                i13.a(getContext(), this);
            } catch (Throwable unused) {
            }
            try {
                if (this.mWebViewAddEnable) {
                    addView((View) iWVWebView, new FrameLayout.LayoutParams(-1, -1));
                } else {
                    dt1.a("PopLayerWebView try add webview, WebView had destroyed,url:" + this.mUrl);
                }
            } catch (Throwable th) {
                dt1.c("PopLayerWebView.addView error", th);
            }
            dt1.b("%s.setWebView.success", TAG);
        }
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void destroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138201893")) {
            ipChange.ipc$dispatch("-2138201893", new Object[]{this});
            return;
        }
        super.destroyView();
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            removeMeOnMainThread();
        } else {
            post(new Runnable() { // from class: cn.damai.commonbusiness.poplayer.view.h5.PopLayerWebView.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-528264862")) {
                        ipChange2.ipc$dispatch("-528264862", new Object[]{this});
                    } else {
                        PopLayerWebView.this.removeMeOnMainThread();
                    }
                }
            });
        }
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public SpannableStringBuilder getInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "82428153")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("82428153", new Object[]{this});
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            BaseConfigItem r = getPopRequest().r();
            p40.a(spannableStringBuilder, "UUID", r.uuid, null, new C0777b(r));
            p40.a(spannableStringBuilder, "PopTimes", et1.b(r.uuid, -1) + "", null, null);
            if (getWebView() != null) {
                p40.a(spannableStringBuilder, "URL", getWebView().getUrl(), null, null);
            }
            p40.a(spannableStringBuilder, "Event", getPopRequest().s().toString(), null, null);
            p40.a(spannableStringBuilder, "ModalThreshold", String.format("%.2f", Float.valueOf(getPenetrateAlpha() / 255.0f)) + "/" + getPenetrateAlpha(), null, null);
        } catch (Throwable unused) {
            p40.a(spannableStringBuilder, "Error", "getInfo Error", null, null);
        }
        return spannableStringBuilder;
    }

    public IWVWebView getWebView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "555381901") ? (IWVWebView) ipChange.ipc$dispatch("555381901", new Object[]{this}) : (IWVWebView) this.mInnerView;
    }

    public void loadUrl(Context context, String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1054439231")) {
            ipChange.ipc$dispatch("-1054439231", new Object[]{this, context, str});
        } else if (getWebView() == null || TextUtils.isEmpty(str)) {
        } else {
            String str3 = this.mUrl;
            try {
                if (!TextUtils.isEmpty(getPopRequest().s().param)) {
                    str3 = str3 + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + URLEncoder.encode(str2, "utf-8");
                }
            } catch (Exception e) {
                dt1.c("reformatUrl.error." + e.toString(), e);
            }
            dt1.b("Load url : %s.", str3);
            try {
                DMBridge.resume(context);
                getWebView().loadUrl(str3);
            } catch (Exception e2) {
                dt1.c("loadUrl.error." + e2.toString(), e2);
            }
        }
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void onActivityPaused() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1900420276")) {
            ipChange.ipc$dispatch("1900420276", new Object[]{this});
            return;
        }
        try {
            super.onActivityPaused();
            IWVWebView webView = getWebView();
            if (webView != null) {
                if (webView instanceof WVWebView) {
                    ((WVWebView) webView).onPause();
                } else if (webView instanceof WVUCWebView) {
                    ((WVUCWebView) webView).onPause();
                }
            }
        } catch (Throwable th) {
            dt1.c("H5 onActivityPaused error", th);
        }
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void onActivityResumed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1728295247")) {
            ipChange.ipc$dispatch("-1728295247", new Object[]{this});
            return;
        }
        try {
            super.onActivityResumed();
            IWVWebView webView = getWebView();
            if (webView != null) {
                if (webView instanceof WVWebView) {
                    ((WVWebView) webView).onResume();
                } else if (webView instanceof WVUCWebView) {
                    ((WVUCWebView) webView).onResume();
                }
            }
        } catch (Throwable th) {
            dt1.c("H5 onActivityResumed error", th);
        }
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void onReceiveEvent(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-265047762")) {
            ipChange.ipc$dispatch("-265047762", new Object[]{this, str, str2});
        } else if (getWebView() != null) {
            getWebView().fireEvent(str, str2);
        }
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void onViewAdded(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "734767690")) {
            ipChange.ipc$dispatch("734767690", new Object[]{this, context});
        } else {
            loadUrl(context, this.mUrl);
        }
    }

    public void setHardwareAccleration(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1225151049")) {
            ipChange.ipc$dispatch("-1225151049", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View view = (View) getWebView();
        if (view == null || z) {
            return;
        }
        view.setLayerType(1, null);
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void init(Context context, t01 t01Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1009578757")) {
            ipChange.ipc$dispatch("1009578757", new Object[]{this, context, t01Var});
            return;
        }
        JSONObject jSONObject = null;
        try {
            String str = t01Var.r().params;
            if (!TextUtils.isEmpty(str)) {
                jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            }
            if (jSONObject == null) {
                return;
            }
        } catch (Throwable th) {
            dt1.c("PopLayerView init fail.", th);
        }
        setVisibility(4);
        BaseConfigItem r = t01Var.r();
        if (r == null) {
            dt1.b("PopLayerWebView init error,Poprequest`s config is empty.", new Object[0]);
            return;
        }
        this.mUrl = jSONObject.optString("url");
        IWVWebView buildWebView = buildWebView(context, r);
        if (buildWebView == null) {
            dt1.b("PopLayerWebView init error,build webview error.", new Object[0]);
            return;
        }
        setWebView(buildWebView);
        setHardwareAccleration(jSONObject.optBoolean("enableHardwareAcceleration", false));
        setPenetrateAlpha((int) (r.modalThreshold * 255.0d));
        showCloseButton(r.showCloseBtn);
        setPopRequest(t01Var);
    }
}
