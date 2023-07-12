package com.tencent.connect.auth;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.hms.api.ConnectionResult;
import com.tencent.connect.auth.C7046b;
import com.tencent.connect.avatar.C7050a;
import com.tencent.connect.common.Constants;
import com.tencent.open.C7067a;
import com.tencent.open.b.C7087h;
import com.tencent.open.c.C7092c;
import com.tencent.open.c.C7093d;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C7126m;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.web.C7129a;
import com.tencent.open.web.security.C7131b;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.tencent.connect.auth.a */
/* loaded from: classes11.dex */
public class DialogC7041a extends Dialog {
    private String a;
    private C7043b b;
    private IUiListener c;
    private Handler d;
    private FrameLayout e;
    private LinearLayout f;
    private FrameLayout g;
    private ProgressBar h;
    private String i;
    private C7093d j;
    private Context k;
    private C7131b l;
    private boolean m;
    private int n;
    private String o;
    private String p;
    private long q;
    private long r;
    private HashMap<String, Runnable> s;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.tencent.connect.auth.a$a */
    /* loaded from: classes11.dex */
    public class C7042a extends WebViewClient {
        private C7042a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            DialogC7041a.this.g.setVisibility(8);
            if (DialogC7041a.this.j != null) {
                DialogC7041a.this.j.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            DialogC7041a.this.d.removeCallbacks((Runnable) DialogC7041a.this.s.remove(str));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            DialogC7041a.this.g.setVisibility(0);
            DialogC7041a.this.q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(DialogC7041a.this.o)) {
                DialogC7041a.this.d.removeCallbacks((Runnable) DialogC7041a.this.s.remove(DialogC7041a.this.o));
            }
            DialogC7041a.this.o = str;
            DialogC7041a dialogC7041a = DialogC7041a.this;
            RunnableC7045d runnableC7045d = new RunnableC7045d(dialogC7041a.o);
            DialogC7041a.this.s.put(str, runnableC7045d);
            DialogC7041a.this.d.postDelayed(runnableC7045d, 120000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            SLog.i("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i + " | description: " + str);
            if (!C7126m.b(DialogC7041a.this.k)) {
                DialogC7041a.this.b.onError(new UiError(9001, "当前网络不可用，请稍后重试！", str2));
                DialogC7041a.this.dismiss();
            } else if (!DialogC7041a.this.o.startsWith("https://imgcache.qq.com/ptlogin/static/qzsjump.html?")) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - DialogC7041a.this.q;
                if (DialogC7041a.this.n >= 1 || elapsedRealtime >= DialogC7041a.this.r) {
                    DialogC7041a.this.j.loadUrl(DialogC7041a.this.a());
                    return;
                }
                DialogC7041a.m(DialogC7041a.this);
                DialogC7041a.this.d.postDelayed(new Runnable() { // from class: com.tencent.connect.auth.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DialogC7041a.this.j.loadUrl(DialogC7041a.this.o);
                    }
                }, 500L);
            } else {
                DialogC7041a.this.b.onError(new UiError(i, str, str2));
                DialogC7041a.this.dismiss();
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            SLog.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            List<String> pathSegments;
            SLog.v("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject c = C7126m.c(str);
                DialogC7041a dialogC7041a = DialogC7041a.this;
                dialogC7041a.m = dialogC7041a.e();
                if (!DialogC7041a.this.m) {
                    if (c.optString("fail_cb", null) != null) {
                        DialogC7041a.this.a(c.optString("fail_cb"), "");
                    } else if (c.optInt("fall_to_wv") == 1) {
                        DialogC7041a dialogC7041a2 = DialogC7041a.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(DialogC7041a.this.a);
                        sb.append(DialogC7041a.this.a.indexOf("?") > -1 ? "&" : "?");
                        dialogC7041a2.a = sb.toString();
                        DialogC7041a dialogC7041a3 = DialogC7041a.this;
                        dialogC7041a3.a = DialogC7041a.this.a + "browser_error=1";
                        DialogC7041a.this.j.loadUrl(DialogC7041a.this.a);
                    } else {
                        String optString = c.optString("redir", null);
                        if (optString != null) {
                            DialogC7041a.this.j.loadUrl(optString);
                        }
                    }
                }
                return true;
            } else if (str.startsWith("auth://tauth.qq.com/")) {
                DialogC7041a.this.b.onComplete(C7126m.c(str));
                DialogC7041a.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                DialogC7041a.this.b.onCancel();
                DialogC7041a.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CLOSE_URI)) {
                DialogC7041a.this.dismiss();
                return true;
            } else if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
                if (str.startsWith("auth://progress")) {
                    try {
                        pathSegments = Uri.parse(str).getPathSegments();
                    } catch (Exception unused) {
                    }
                    if (pathSegments.isEmpty()) {
                        return true;
                    }
                    int intValue = Integer.valueOf(pathSegments.get(0)).intValue();
                    if (intValue == 0) {
                        DialogC7041a.this.g.setVisibility(8);
                        DialogC7041a.this.j.setVisibility(0);
                    } else if (intValue == 1) {
                        DialogC7041a.this.g.setVisibility(0);
                    }
                    return true;
                } else if (!str.startsWith("auth://onLoginSubmit")) {
                    if (DialogC7041a.this.l.a(DialogC7041a.this.j, str)) {
                        return true;
                    }
                    SLog.i("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                    return false;
                } else {
                    try {
                        List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                        if (!pathSegments2.isEmpty()) {
                            DialogC7041a.this.p = pathSegments2.get(0);
                        }
                    } catch (Exception unused2) {
                    }
                    return true;
                }
            } else {
                try {
                    if (str.startsWith(Constants.DOWNLOAD_URI)) {
                        parse = Uri.parse(Uri.decode(str.substring(11)));
                    } else {
                        parse = Uri.parse(Uri.decode(str));
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.addFlags(268435456);
                    DialogC7041a.this.k.startActivity(intent);
                } catch (Exception e) {
                    SLog.e("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e);
                }
                return true;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.tencent.connect.auth.a$b */
    /* loaded from: classes11.dex */
    private class C7043b extends DefaultUiListener {
        String a;
        String b;
        private String d;
        private IUiListener e;

        public C7043b(String str, String str2, String str3, IUiListener iUiListener) {
            this.d = str;
            this.a = str2;
            this.b = str3;
            this.e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            C7087h a = C7087h.a();
            a.a(this.d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.a, false);
            IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.a;
            } else {
                str = this.a;
            }
            C7087h.a().a(this.d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            DialogC7041a.this.a(str);
            IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.e = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            try {
                onComplete(C7126m.d(str));
            } catch (JSONException e) {
                e.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.tencent.connect.auth.a$c */
    /* loaded from: classes11.dex */
    private class HandlerC7044c extends Handler {
        private C7043b b;

        public HandlerC7044c(C7043b c7043b, Looper looper) {
            super(looper);
            this.b = c7043b;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                this.b.a((String) message.obj);
            } else if (i == 2) {
                this.b.onCancel();
            } else if (i != 3) {
            } else {
                DialogC7041a.b(DialogC7041a.this.k, (String) message.obj);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.tencent.connect.auth.a$d */
    /* loaded from: classes11.dex */
    class RunnableC7045d implements Runnable {
        String a;

        public RunnableC7045d(String str) {
            this.a = "";
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SLog.v("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.a + " | mRetryUrl: " + DialogC7041a.this.o);
            if (this.a.equals(DialogC7041a.this.o)) {
                DialogC7041a.this.b.onError(new UiError(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, "请求页面超时，请稍后重试！", DialogC7041a.this.o));
                DialogC7041a.this.dismiss();
            }
        }
    }

    public DialogC7041a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.m = false;
        this.q = 0L;
        this.r = 30000L;
        this.k = context;
        this.a = str2;
        this.b = new C7043b(str, str2, qQToken.getAppId(), iUiListener);
        this.d = new HandlerC7044c(this.b, context.getMainLooper());
        this.c = iUiListener;
        this.i = str;
        this.l = new C7131b();
        getWindow().setSoftInputMode(32);
    }

    static /* synthetic */ int m(DialogC7041a dialogC7041a) {
        int i = dialogC7041a.n;
        dialogC7041a.n = i + 1;
        return i;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.s.clear();
        this.d.removeCallbacksAndMessages(null);
        try {
            Context context = this.k;
            if ((context instanceof Activity) && !((Activity) context).isFinishing() && isShowing()) {
                super.dismiss();
                SLog.i("openSDK_LOG.AuthDialog", "-->dismiss dialog");
            }
        } catch (Exception e) {
            SLog.e("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e);
        }
        C7093d c7093d = this.j;
        if (c7093d != null) {
            c7093d.destroy();
            this.j = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.m) {
            this.b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        C7067a.a(getWindow());
        b();
        d();
        this.s = new HashMap<>();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        C7046b a = C7046b.a();
        String c = a.c();
        C7046b.C7047a c7047a = new C7046b.C7047a();
        c7047a.a = this.c;
        c7047a.b = this;
        c7047a.c = c;
        String a2 = a.a(c7047a);
        String str = this.a;
        String substring = str.substring(0, str.indexOf("?"));
        Bundle b = C7126m.b(this.a);
        b.putString("token_key", c);
        b.putString("serial", a2);
        b.putString("browser", "1");
        String str2 = substring + "?" + HttpUtils.encodeUrl(b);
        this.a = str2;
        return C7126m.a(this.k, str2);
    }

    private void b() {
        c();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        C7093d c7093d = new C7093d(this.k);
        this.j = c7093d;
        if (Build.VERSION.SDK_INT >= 11) {
            c7093d.setLayerType(1, null);
        }
        this.j.setLayoutParams(layoutParams);
        layoutParams.gravity = 17;
        C7092c c7092c = new C7092c(this.k);
        c7092c.setLayoutParams(layoutParams);
        c7092c.addView(this.j);
        FrameLayout frameLayout = new FrameLayout(this.k);
        this.e = frameLayout;
        frameLayout.addView(c7092c);
        this.e.setBackgroundColor(-1);
        this.e.addView(this.g);
        String string = C7126m.b(this.a).getString("style");
        if (string != null && "qr".equals(string)) {
            a(this.e);
        }
        setContentView(this.e);
    }

    private void c() {
        TextView textView;
        this.h = new ProgressBar(this.k);
        this.h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f = new LinearLayout(this.k);
        if (this.i.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f.setLayoutParams(layoutParams2);
        this.f.addView(this.h);
        if (textView != null) {
            this.f.addView(textView);
        }
        this.g = new FrameLayout(this.k);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.g.setLayoutParams(layoutParams3);
        this.g.setBackgroundColor(Color.parseColor("#B3000000"));
        this.g.addView(this.f);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.j.setVerticalScrollBarEnabled(false);
        this.j.setHorizontalScrollBarEnabled(false);
        this.j.setWebViewClient(new C7042a());
        this.j.setWebChromeClient(new WebChromeClient());
        this.j.clearFormData();
        this.j.clearSslPreferences();
        this.j.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.connect.auth.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.j.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.connect.auth.a.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action == 0 || action == 1) && !view.hasFocus()) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
        });
        WebSettings settings = this.j.getSettings();
        C7129a.a(this.j);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        SLog.v("openSDK_LOG.AuthDialog", "-->mUrl : " + this.a);
        String str = this.a;
        this.o = str;
        this.j.loadUrl(str);
        this.j.setVisibility(4);
        this.l.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.connect.auth.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    if (JniInterface.isJniOk) {
                        JniInterface.clearAllPWD();
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.p) && this.p.length() >= 4) {
            String str2 = this.p;
            String substring = str2.substring(str2.length() - 4);
            sb.append("_u_");
            sb.append(substring);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        String str = this.a;
        String str2 = "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
        SLog.i("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://imgcache.qq.com/ptlogin/static/qzsjump.html?");
        return str2;
    }

    private void a(ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.k);
        int a = C7050a.a(this.k, 15.6f);
        int a2 = C7050a.a(this.k, 25.2f);
        int a3 = C7050a.a(this.k, 10.0f);
        int i = a3 * 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a + i, a2 + i);
        layoutParams.leftMargin = a3;
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(a3, a3, a3, a3);
        imageView.setImageDrawable(C7126m.a("h5_qr_back.png", this.k));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.connect.auth.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC7041a.this.dismiss();
                if (DialogC7041a.this.m || DialogC7041a.this.b == null) {
                    return;
                }
                DialogC7041a.this.b.onCancel();
            }
        });
        viewGroup.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        try {
            JSONObject d = C7126m.d(str);
            int i = d.getInt("type");
            Toast.makeText(context.getApplicationContext(), d.getString("msg"), i).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        this.j.loadUrl("javascript:" + str + jn1.BRACKET_START_STR + str2 + ");void(" + System.currentTimeMillis() + ");");
    }
}
