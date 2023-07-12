package com.taomai.android.h5container;

import android.app.Application;
import android.content.Context;
import android.taobao.windvane.WindVaneSDK;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVConfigManager;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.extra.config.TBConfigManager;
import android.taobao.windvane.extra.jsbridge.TBJsApiManager;
import android.taobao.windvane.extra.jsbridge.TBUploadService;
import android.taobao.windvane.file.WVFileUtils;
import android.taobao.windvane.jsbridge.api.WVAPI;
import android.taobao.windvane.jsbridge.api.WVCamera;
import android.taobao.windvane.monitor.WVMonitor;
import android.taobao.windvane.packageapp.WVPackageAppConfig;
import android.taobao.windvane.packageapp.WVPackageAppManager;
import android.taobao.windvane.packageapp.WVPackageAppService;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.log.AndroidLog;
import android.taobao.windvane.webview.IWVWebView;
import com.alibaba.motu.crashreporter.MotuCrashReporter;
import com.taomai.android.h5container.api.TMActionPlugin;
import com.taomai.android.h5container.api.TMCamera;
import com.taomai.android.h5container.utils.ActivityStackManager;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.kl;
import tb.qm;
import tb.ts2;
import tb.uh1;
import tb.yk2;
import tb.zk2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class TaoMaiH5Container {
    @NotNull
    public static final TaoMaiH5Container INSTANCE = new TaoMaiH5Container();
    @Nullable
    private static NavHandler a;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&¨\u0006\r"}, d2 = {"Lcom/taomai/android/h5container/TaoMaiH5Container$NavHandler;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "url", "", "fromOverrideUrlLoading", "Landroid/taobao/windvane/webview/IWVWebView;", "webView", "Ltb/wt2;", "handleUrl", "shouldOverrideUrlLoading", "h5container_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes11.dex */
    public interface NavHandler {
        void handleUrl(@NotNull Context context, @NotNull String str, boolean z, @Nullable IWVWebView iWVWebView);

        boolean shouldOverrideUrlLoading(@NotNull Context context, @NotNull String str, @NotNull IWVWebView iWVWebView);
    }

    private TaoMaiH5Container() {
    }

    @JvmStatic
    private static final void a() {
        WVConfigManager.getInstance().setUpdateConfigEnable(true);
        WVServerConfig.DOMAIN_PATTERN = "^https?:\\/\\/(([^/\\?#]+\\.)*((taobao|taopiaopiao|damai|piao|youku|alimebot|ycceleb|tmall|juhuasuan|xiami|amap|taobaocdn|alipay|etao|alibaba|aliyun|alimama|weibo|tanx|laiwang|alicdn|mmstat|yunos|alibaba-inc|alitrip|aliloan|kanbox|wirlesshare|dingtalk|alimei|cnzz|kuaidadi|autonavi|m\\.yintai|polyinno|spdyidea|h5util|h5tool|5945i|miaostreet|1688|yuekeyun)\\.com|(taopiaopiao|damai|piao|tb|tbcdn|weibo|mashort|mybank|ba\\.ugame\\.uc|game\\.uc)\\.cn|(fastidea|juzone)\\.(me|cc)|lwurl\\.to|taobao\\.net|tdd\\.la|yao\\.95095\\.com|tmall\\.hk|ahd\\.so|atb\\.so|mshare\\.cc|juhs\\.me|h5.guobei.com.cn|xianyu\\.mobi)([\\?|#|/].*)?|go(/.*)?)$";
    }

    @Nullable
    public static final NavHandler b() {
        return a;
    }

    @JvmStatic
    public static final void c(@NotNull Context context, @NotNull zk2 zk2Var) {
        Application application;
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(zk2Var, "params");
        if (context instanceof Application) {
            application = (Application) context;
        } else {
            Context applicationContext = context.getApplicationContext();
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            application = (Application) applicationContext;
        }
        yk2.a = application;
        yk2.d(zk2Var.b());
        yk2.INSTANCE.e(zk2Var.c());
        zk2Var.reducePermission = true;
        WindVaneSDK.init(context, zk2Var);
        a();
        d(context);
        if (!zk2Var.a()) {
            TaoLog.setImpl(new AndroidLog());
            TaoLog.setLogSwitcher(true);
        }
        f();
        Context applicationContext2 = context.getApplicationContext();
        if (!(applicationContext2 instanceof Application)) {
            applicationContext2 = null;
        }
        Application application2 = (Application) applicationContext2;
        if (application2 != null) {
            application2.registerActivityLifecycleCallbacks(ActivityStackManager.Companion.a());
        }
        qm.Companion.a();
    }

    @JvmStatic
    private static final void d(Context context) {
        WVAPI.setup();
        WVMonitor.init();
        WVCamera.registerUploadService(TBUploadService.class);
        TMCamera.registerUploadService(TBUploadService.class);
        GlobalConfig.zType = "3";
        WVPackageAppService.registerWvPackageAppConfig(new WVPackageAppConfig());
        WVPackageAppManager.getInstance().init(context, true);
        TBJsApiManager.initJsApi();
        TBConfigManager.getInstance().init(context);
        MotuCrashReporter.getInstance().setCrashCaughtListener(new ts2());
        uh1.a();
    }

    @JvmStatic
    public static final void e(@NotNull String str, @NotNull TMActionPlugin.IWVAPIPlugin iWVAPIPlugin) {
        b41.i(str, "actionName");
        b41.i(iWVAPIPlugin, "impl");
        TMActionPlugin.Companion.a().put(str, iWVAPIPlugin);
    }

    @JvmStatic
    private static final void f() {
        kl.a();
    }

    @JvmStatic
    public static final void g(@NotNull String str) {
        b41.i(str, "authority");
        WVFileUtils.setAuthority(str);
    }

    public static final void h(@Nullable NavHandler navHandler) {
        a = navHandler;
    }
}
