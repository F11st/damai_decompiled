package cn.damai.launcher.splash;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import cn.damai.common.AppConfig;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.image.blur.ImageBlurHelper;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.PriorityTask;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.update.UpdateUtil;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.launcher.splash.api.GetTimeStampRequest;
import cn.damai.launcher.splash.api.GetTimeStampResponse;
import cn.damai.launcher.splash.api.SplashApi;
import cn.damai.launcher.splash.api.SplashResponse;
import cn.damai.launcher.splash.model.AdBitmapResTool;
import cn.damai.launcher.splash.model.AdLoader;
import cn.damai.launcher.splash.model.bean.AdBitmapRes;
import cn.damai.launcher.splash.model.listener.OnAdSetUpUiListener;
import cn.damai.launcher.ut.LauncherUTHelper;
import cn.damai.launcher.utils.InitUtils;
import cn.damai.launcher.utils.PrivacyUtils;
import cn.damai.launcher.utils.SplashSchemaUtil;
import cn.damai.launcher.utils.SplashXFlushHelper;
import cn.damai.wantsee.StartConfig;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.android.alibaba.ip.server.InstantPatcher;
import com.ut.mini.module.appstatus.UTAppStatusMonitor;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.b23;
import tb.b30;
import tb.cb1;
import tb.cs;
import tb.fd;
import tb.k3;
import tb.kg2;
import tb.m61;
import tb.m62;
import tb.mu0;
import tb.n6;
import tb.nu1;
import tb.pl;
import tb.qy0;
import tb.ru1;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class SplashMainActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HOMEPAGE_OUTER_URL = "HOMEPAGE_OUTER_URL";
    private static final String TAG = "Splash";
    private long mAdsDisplayStartTs;
    private TextView mAdsLabel;
    private View mClickZone;
    private TextView mClickZoneLabel;
    private ViewStub mSplashAdStub;
    private ImageView mSplashImage;
    private View mSplashLayout;
    private SplashResponse mSplashResp;
    private SplashRoundProgressBar mSplashRoundProgressBar;
    private AtomicBoolean mHasDone = new AtomicBoolean(false);
    @SuppressLint({"HandlerLeak"})
    Handler handler = new Handler();
    private boolean isDraw = false;
    private boolean isAdWidthResized = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void ShowPrivacyDialogStageTwo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1520441769")) {
            ipChange.ipc$dispatch("1520441769", new Object[]{this});
        } else {
            new DMDialog(this).o(false).v("您需要同意相关协议才能继续使用大麦").x(2).q("若您不同意，很遗憾我们将无法为您提供服务。").t(3).n("查看协议", new DialogInterface.OnClickListener() { // from class: cn.damai.launcher.splash.SplashMainActivity.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1789181555")) {
                        ipChange2.ipc$dispatch("-1789181555", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    } else {
                        SplashMainActivity.this.showPrivacyDialogStageOne();
                    }
                }
            }).i("退出应用", new DialogInterface.OnClickListener(this) { // from class: cn.damai.launcher.splash.SplashMainActivity.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1536204718")) {
                        ipChange2.ipc$dispatch("1536204718", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                        return;
                    }
                    k3.b().clearStack();
                    System.exit(0);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterSplashDisplayFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295007730")) {
            ipChange.ipc$dispatch("-295007730", new Object[]{this});
            return;
        }
        cb1.b(TAG, "afterSplashDisplayFinish/in hasDone?" + this.mHasDone.get());
        if (this.mHasDone.get()) {
            return;
        }
        this.mSplashImage.setOnClickListener(null);
        this.mSplashRoundProgressBar.setOnClickListener(null);
        gotoMainActivity(true);
        long currentTimeMillis = System.currentTimeMillis() - this.mAdsDisplayStartTs;
        SplashResponse splashResponse = this.mSplashResp;
        String pic = splashResponse != null ? splashResponse.getPic() : null;
        SplashResponse splashResponse2 = this.mSplashResp;
        LauncherUTHelper.getInstance().i(currentTimeMillis, pic, splashResponse2 != null ? splashResponse2.getSchema() : null);
        setAPMAdTime(currentTimeMillis);
    }

    private void afterSplashImageReady(Drawable drawable, final SplashResponse splashResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1483230733")) {
            ipChange.ipc$dispatch("1483230733", new Object[]{this, drawable, splashResponse});
            return;
        }
        cb1.b(TAG, "afterSplashImageReady d:" + drawable);
        if (this.mHasDone.get()) {
            cb1.b(TAG, "afterSplashImageReady HAS DONE, GOTO NEXT PAGE!");
            gotoMainActivity(true);
        } else if (drawable == null) {
            cb1.b(TAG, "afterSplashImageReady d is NULL!");
            gotoMainActivity(true);
        } else {
            ensureInflateViewStub();
            this.mSplashLayout.setVisibility(0);
            this.mSplashImage.setImageDrawable(drawable);
            fillAdBlurBgWhenFoldMode(drawable, this.mSplashLayout);
            if (splashResponse != null && splashResponse.getShowLabelInt() == 0) {
                this.mAdsLabel.setVisibility(8);
            } else {
                this.mAdsLabel.setVisibility(0);
            }
            this.mAdsDisplayStartTs = System.currentTimeMillis();
            if (splashResponse != null && !wh2.j(splashResponse.getSchema())) {
                if (!wh2.j(splashResponse.getClickJumpDescription())) {
                    this.mClickZoneLabel.setText(splashResponse.getClickJumpDescription());
                }
                this.mClickZone.setOnClickListener(new View.OnClickListener() { // from class: cn.damai.launcher.splash.SplashMainActivity.9
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1393653414")) {
                            ipChange2.ipc$dispatch("1393653414", new Object[]{this, view});
                            return;
                        }
                        SplashResponse splashResponse2 = splashResponse;
                        if (splashResponse2 == null || wh2.j(splashResponse2.getSchema())) {
                            return;
                        }
                        SplashMainActivity.this.mHasDone.compareAndSet(false, true);
                        try {
                            SplashMainActivity.this.gotoMainActivity(false);
                            Bundle bundle = new Bundle();
                            bundle.putBoolean(MonitorType.SKIP, true);
                            bundle.putString("from_page", "welcome");
                            DMNav.from(SplashMainActivity.this.mContext).withExtras(bundle).toUri(splashResponse.getSchema());
                        } catch (Exception e) {
                            cb1.b(SplashMainActivity.TAG, "afterSplashImageReady.onClick EXCEPTION:" + e.getMessage());
                            e.printStackTrace();
                            SplashXFlushHelper.a(e.getMessage(), z20.c(), splashResponse.getSchema());
                        }
                        long currentTimeMillis = System.currentTimeMillis() - SplashMainActivity.this.mAdsDisplayStartTs;
                        LauncherUTHelper.getInstance().i(currentTimeMillis, splashResponse.getPic(), splashResponse.getSchema());
                        C0529c.e().x(LauncherUTHelper.getInstance().h(splashResponse, z20.d(), splashResponse.getPic()));
                        SplashMainActivity.this.setAPMAdTime(currentTimeMillis);
                    }
                });
                this.mClickZone.setVisibility(0);
                if (SplashSchemaUtil.a(splashResponse.getSchema())) {
                    this.mClickZone.setVisibility(8);
                    findViewById(R$id.iv_splash_ad_logo_layout).setVisibility(8);
                    findViewById(R$id.iv_splash_arc).setVisibility(8);
                }
            } else {
                this.mClickZone.setVisibility(8);
                findViewById(R$id.iv_splash_ad_logo_layout).setVisibility(8);
                findViewById(R$id.iv_splash_arc).setVisibility(8);
            }
            if (splashResponse != null && splashResponse.getSkippableInt() == 0) {
                this.mSplashRoundProgressBar.setVisibility(8);
            } else {
                this.mSplashRoundProgressBar.setOnClickListener(new View.OnClickListener() { // from class: cn.damai.launcher.splash.SplashMainActivity.10
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1923340678")) {
                            ipChange2.ipc$dispatch("1923340678", new Object[]{this, view});
                            return;
                        }
                        SplashMainActivity.this.mHasDone.compareAndSet(false, true);
                        SplashMainActivity.this.gotoMainActivity(true);
                        long currentTimeMillis = System.currentTimeMillis() - SplashMainActivity.this.mAdsDisplayStartTs;
                        SplashResponse splashResponse2 = splashResponse;
                        String pic = splashResponse2 != null ? splashResponse2.getPic() : null;
                        SplashResponse splashResponse3 = splashResponse;
                        LauncherUTHelper.getInstance().i(currentTimeMillis, pic, splashResponse3 != null ? splashResponse3.getSchema() : null);
                        SplashMainActivity.this.setAPMAdTime(currentTimeMillis);
                    }
                });
            }
            doSplashCountDown(splashResponse != null ? splashResponse.getDisplayDurationInt() : 3);
            LauncherUTHelper.f(this.mClickZone, splashResponse);
        }
    }

    private void closeMe() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-556864710")) {
            ipChange.ipc$dispatch("-556864710", new Object[]{this});
            return;
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: cn.damai.launcher.splash.SplashMainActivity.15
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1342971525")) {
                        ipChange2.ipc$dispatch("1342971525", new Object[]{this});
                    } else {
                        SplashMainActivity.this.finish();
                    }
                }
            }, 100L);
        } else {
            finish();
        }
    }

    private void doSplashCountDown(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-139033672")) {
            ipChange.ipc$dispatch("-139033672", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mSplashLayout.getVisibility() == 0) {
            final long j = i * 1000;
            this.mSplashRoundProgressBar.setMax(100);
            new CountDownTimer(j, 50L) { // from class: cn.damai.launcher.splash.SplashMainActivity.13
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1776136646")) {
                        ipChange2.ipc$dispatch("1776136646", new Object[]{this});
                    } else {
                        SplashMainActivity.this.afterSplashDisplayFinish();
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1351406392")) {
                        ipChange2.ipc$dispatch("-1351406392", new Object[]{this, Long.valueOf(j2)});
                    } else {
                        SplashMainActivity.this.mSplashRoundProgressBar.setProgress((int) ((((float) j2) / ((float) j)) * 100.0f));
                    }
                }
            }.start();
        }
    }

    private void ensureInflateViewStub() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "450616494")) {
            ipChange.ipc$dispatch("450616494", new Object[]{this});
            return;
        }
        ViewStub viewStub = this.mSplashAdStub;
        if (viewStub == null || this.mSplashLayout != null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.mSplashLayout = inflate.findViewById(R$id.splash_layout);
        this.mSplashImage = (ImageView) inflate.findViewById(R$id.splash_image);
        this.mSplashRoundProgressBar = (SplashRoundProgressBar) inflate.findViewById(R$id.homepage_advert_pb);
        this.mAdsLabel = (TextView) inflate.findViewById(R$id.tv_splash_ads_label);
        this.mClickZone = inflate.findViewById(R$id.splash_ads_click_zone);
        this.mClickZoneLabel = (TextView) inflate.findViewById(R$id.tv_splash_ads_click);
        resizeAdWidthWhenFoldMode(this.mSplashImage);
        this.mSplashImage.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() { // from class: cn.damai.launcher.splash.SplashMainActivity.11
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.ViewTreeObserver.OnDrawListener
            public void onDraw() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1208509581")) {
                    ipChange2.ipc$dispatch("-1208509581", new Object[]{this});
                } else if (SplashMainActivity.this.mSplashImage == null || SplashMainActivity.this.mSplashImage.getTag() != null || SplashMainActivity.this.mSplashImage.getDrawable() == null) {
                } else {
                    SplashMainActivity.this.mSplashImage.setTag(Boolean.TRUE);
                    fd.a("App onCreate -> Splash AD ImageView draw with drawable", 100);
                }
            }
        });
        setAdMarginTop();
    }

    private void fillAdBlurBgWhenFoldMode(Drawable drawable, final View view) {
        final Bitmap bitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1854845438")) {
            ipChange.ipc$dispatch("1854845438", new Object[]{this, drawable, view});
        } else if (this.isAdWidthResized && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            fd.e(SecExceptionCode.SEC_ERROR_PKG_VALID_UNKNOWN_ERR);
            nu1.a(new PriorityTask("workerThread2", mu0.a(), 1) { // from class: cn.damai.launcher.splash.SplashMainActivity.12
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.util.PriorityTask
                public void doTask() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-507212313")) {
                        ipChange2.ipc$dispatch("-507212313", new Object[]{this});
                        return;
                    }
                    try {
                        final Bitmap g = ImageBlurHelper.g(mu0.a(), null, bitmap, 16, 20);
                        if (g == null) {
                            return;
                        }
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn.damai.launcher.splash.SplashMainActivity.12.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "-935501637")) {
                                    ipChange3.ipc$dispatch("-935501637", new Object[]{this});
                                    return;
                                }
                                view.setBackground(new BitmapDrawable(SplashMainActivity.this.getResources(), g));
                                fd.a("广告高斯背景生成", SecExceptionCode.SEC_ERROR_PKG_VALID_UNKNOWN_ERR);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoMainActivity(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1177923231")) {
            ipChange.ipc$dispatch("1177923231", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        C0529c.e().x(pl.j().t("首页", 0));
        Bundle bundle = new Bundle();
        bundle.putString(HOMEPAGE_OUTER_URL, getIntent().getStringExtra(HOMEPAGE_OUTER_URL));
        DMNav.from(this).withExtras(bundle).setTransition(0, 0).toUri(NavUri.b(cs.n));
        closeMe();
    }

    private void hideSystemBars() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "251074639")) {
            ipChange.ipc$dispatch("251074639", new Object[]{this});
            return;
        }
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
        windowInsetsControllerCompat.setSystemBarsBehavior(2);
    }

    private void initEvn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1381655837")) {
            ipChange.ipc$dispatch("1381655837", new Object[]{this});
        } else {
            nu1.a(new PriorityTask("ApnInit", this) { // from class: cn.damai.launcher.splash.SplashMainActivity.14
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.util.PriorityTask
                public void doTask() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1094018327")) {
                        ipChange2.ipc$dispatch("-1094018327", new Object[]{this});
                    } else {
                        n6.g();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSetting() {
        BitmapDrawable bitmapDrawable;
        SplashResponse splashResponse;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1007275338")) {
            ipChange.ipc$dispatch("1007275338", new Object[]{this});
            return;
        }
        initEvn();
        try {
            if (!ru1.d()) {
                InitUtils.g();
            }
            UpdateUtil.h(this);
            InstantPatcher.create(mu0.a()).applyPatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (HomeGrabTicketHideAdUtil.isHideAd()) {
            cb1.c(TAG, "Ticket Grab，cancel splash request!!!");
            gotoMainActivity(false);
        } else {
            AdBitmapRes cacheGet = AdBitmapResTool.cacheGet();
            if (cacheGet != null && (bitmapDrawable = cacheGet.mAdBitmapDrawable) != null && (splashResponse = cacheGet.mAdSplashRes) != null) {
                showAdLayoutNow(bitmapDrawable, splashResponse);
                cb1.c(fd.TAG, "Splash Ad Use Provider preprocess bitmap");
                new Handler().postDelayed(new Runnable() { // from class: cn.damai.launcher.splash.SplashMainActivity.6
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-623559571")) {
                            ipChange2.ipc$dispatch("-623559571", new Object[]{this});
                        } else {
                            new AdLoader(SplashMainActivity.this, null).autoFetch(false);
                        }
                    }
                }, 200L);
            } else {
                cb1.c(fd.TAG, "Splash Ad No Use Provider preprocess bitmap");
                startSplashQuery();
            }
        }
        startTimeStampQuery();
        if (StartConfig.isUseNewHomePreload()) {
            preloadHome();
        }
    }

    private void preloadHome() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "951711970")) {
            ipChange.ipc$dispatch("951711970", new Object[]{this});
            return;
        }
        try {
            qy0.class.getMethod("preload", Activity.class).invoke(null, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resizeAdWidthWhenFoldMode(ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-412109385")) {
            ipChange.ipc$dispatch("-412109385", new Object[]{this, imageView});
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        DisplayMetrics c = m62.c(this);
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(c);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(c);
        float f = i2;
        float f2 = i / f;
        if (f2 > 0.703125f) {
            layoutParams.width = (int) (f * 0.5625f);
            layoutParams.height = -1;
            this.isAdWidthResized = true;
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
            this.isAdWidthResized = false;
        }
        if (AppConfig.v()) {
            cb1.c("ScreenMode", "screen w=" + i + " h=" + i2 + " whRatio=" + f2 + " limitWhRatio=0.703125 betterWhRatio=0.5625 " + (this.isAdWidthResized ? "whRatio>limitWhRatio 广告发生适配+高斯生成" : "whRatio<=limitWhRatio保持广告全屏"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAPMAdTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1134100816")) {
            ipChange.ipc$dispatch("-1134100816", new Object[]{this, Long.valueOf(j)});
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("splash_ad", "闪屏停留时间");
        hashMap.put("闪屏停留时间", String.valueOf(j));
        b30.a().c("splash_ad", hashMap);
    }

    private void setAdMarginTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008958722")) {
            ipChange.ipc$dispatch("-2008958722", new Object[]{this});
            return;
        }
        int a = kg2.a(this);
        if (a > 0) {
            ViewGroup.LayoutParams layoutParams = this.mAdsLabel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = a;
            }
            ViewGroup.LayoutParams layoutParams2 = this.mSplashRoundProgressBar.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = a;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAdLayoutNow(Drawable drawable, @NonNull SplashResponse splashResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24483282")) {
            ipChange.ipc$dispatch("-24483282", new Object[]{this, drawable, splashResponse});
            return;
        }
        this.mSplashResp = splashResponse;
        try {
            afterSplashImageReady(drawable, splashResponse);
            b23.e(b23.a, SplashXFlushHelper.BUSINESS_NAME_MONITORPOINT, "homepage:jsondata={apiName: " + SplashXFlushHelper.SPLASH_ADS_DOWNLOAD_API_NAME + ", pic:" + splashResponse.getPic() + ", cityId:" + z20.c() + "}");
        } catch (Exception e) {
            e.printStackTrace();
            SplashXFlushHelper.d(SplashApi.API_SPLASH_ADVERT, "", e.getMessage(), m61.e(splashResponse), z20.c());
            gotoMainActivity(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPrivacyDialogStageOne() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807051567")) {
            ipChange.ipc$dispatch("1807051567", new Object[]{this});
        } else {
            new DMDialog(this).o(false).v("温馨提示").u(PrivacyUtils.b(this)).n("同意", new DialogInterface.OnClickListener() { // from class: cn.damai.launcher.splash.SplashMainActivity.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "566623695")) {
                        ipChange2.ipc$dispatch("566623695", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                        return;
                    }
                    SplashMainActivity.this.initSetting();
                    UTAppStatusMonitor.getInstance().onActivityStarted(null);
                    ru1.l(true);
                    ru1.a();
                }
            }).i("不同意", new DialogInterface.OnClickListener() { // from class: cn.damai.launcher.splash.SplashMainActivity.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-402957328")) {
                        ipChange2.ipc$dispatch("-402957328", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    } else {
                        SplashMainActivity.this.ShowPrivacyDialogStageTwo();
                    }
                }
            }).show();
        }
    }

    private void startSplashQuery() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931165281")) {
            ipChange.ipc$dispatch("1931165281", new Object[]{this});
            return;
        }
        fd.e(205);
        new AdLoader(this, new OnAdSetUpUiListener() { // from class: cn.damai.launcher.splash.SplashMainActivity.8
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.launcher.splash.model.listener.OnAdSetUpUiListener
            public void dispatchNoneAdAction(int i, String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "894467406")) {
                    ipChange2.ipc$dispatch("894467406", new Object[]{this, Integer.valueOf(i), str, str2});
                } else {
                    SplashMainActivity.this.gotoMainActivity(false);
                }
            }

            @Override // cn.damai.launcher.splash.model.listener.OnAdSetUpUiListener
            public void dispatchShowAdAction(boolean z, Drawable drawable, @NonNull SplashResponse splashResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1873219164")) {
                    ipChange2.ipc$dispatch("1873219164", new Object[]{this, Boolean.valueOf(z), drawable, splashResponse});
                    return;
                }
                fd.a("Splash get Ad drawable isUseCache=" + z, 205);
                SplashMainActivity.this.showAdLayoutNow(drawable, splashResponse);
            }
        }).start();
    }

    private void startTimeStampQuery() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-506466186")) {
            ipChange.ipc$dispatch("-506466186", new Object[]{this});
            return;
        }
        GetTimeStampRequest getTimeStampRequest = new GetTimeStampRequest();
        final long currentTimeMillis = System.currentTimeMillis();
        getTimeStampRequest.request(new DMMtopRequestListener<GetTimeStampResponse>(GetTimeStampResponse.class) { // from class: cn.damai.launcher.splash.SplashMainActivity.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1476249846")) {
                    ipChange2.ipc$dispatch("-1476249846", new Object[]{this, str, str2});
                    return;
                }
                cb1.c("requestServerTimeStamp", "requestServerTimeStamp failed" + str2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(GetTimeStampResponse getTimeStampResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "136293156")) {
                    ipChange2.ipc$dispatch("136293156", new Object[]{this, getTimeStampResponse});
                    return;
                }
                long currentTimeMillis2 = (System.currentTimeMillis() - currentTimeMillis) >> 1;
                if (getTimeStampResponse != null) {
                    try {
                        if (TextUtils.isEmpty(getTimeStampResponse.t)) {
                            return;
                        }
                        z20.T("serverTimeDiff", String.valueOf((Long.parseLong(getTimeStampResponse.t) + currentTimeMillis2) - System.currentTimeMillis()));
                    } catch (Exception unused) {
                        cb1.c("requestServerTimeStamp", "requestServerTimeStamp format failed");
                    }
                }
            }
        });
    }

    private void useSpecialScreen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494289058")) {
            ipChange.ipc$dispatch("1494289058", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected void addContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1244938781")) {
            ipChange.ipc$dispatch("-1244938781", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "943261128")) {
            ipChange.ipc$dispatch("943261128", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // android.app.Activity
    public void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1610213357")) {
            ipChange.ipc$dispatch("1610213357", new Object[]{this});
        } else {
            super.finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1446047522") ? ((Integer) ipChange.ipc$dispatch("1446047522", new Object[]{this})).intValue() : R$layout.splash_activity;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "15801497")) {
            ipChange.ipc$dispatch("15801497", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860707506")) {
            ipChange.ipc$dispatch("1860707506", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1706179243")) {
            ipChange.ipc$dispatch("1706179243", new Object[]{this});
            return;
        }
        ((ViewGroup) findViewById(R$id.splash_layout_container)).getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() { // from class: cn.damai.launcher.splash.SplashMainActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.ViewTreeObserver.OnDrawListener
            public void onDraw() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1805897226")) {
                    ipChange2.ipc$dispatch("1805897226", new Object[]{this});
                } else if (SplashMainActivity.this.isDraw) {
                } else {
                    SplashMainActivity.this.isDraw = true;
                    fd.a("Splash onCreate -> firstDraw", 201);
                    fd.a("App onCreate -> Splash first draw", 100);
                }
            }
        });
        this.mSplashAdStub = (ViewStub) findViewById(R$id.id_splash_ad_view_stub);
        ((ImageView) findViewById(R$id.id_splash_holder_view)).setImageDrawable(new ShapeDrawable());
        if (ru1.d()) {
            initSetting();
        } else {
            showPrivacyDialogStageOne();
        }
        hideSystemBars();
        useSpecialScreen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "426403794")) {
            ipChange.ipc$dispatch("426403794", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-434899025")) {
            ipChange.ipc$dispatch("-434899025", new Object[]{this, bundle});
            return;
        }
        fd.e(201);
        super.onCreate(bundle);
        if (ru1.d()) {
            setDamaiUTKeyBuilder(LauncherUTHelper.getInstance().g("welcome"));
            C0529c.e().K(this);
        }
        fd.a("Splash onCreate finish", 201);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1603744081")) {
            ipChange.ipc$dispatch("-1603744081", new Object[]{this});
            return;
        }
        super.onDestroy();
        AdBitmapResTool.cache(null);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1258352072")) {
            ipChange.ipc$dispatch("1258352072", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "368428877")) {
            ipChange.ipc$dispatch("368428877", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1917961164")) {
            ipChange.ipc$dispatch("-1917961164", new Object[]{this});
            return;
        }
        super.onResume();
        fd.a("App onCreate -> Splash onResume", 100);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1068897183")) {
            ipChange.ipc$dispatch("1068897183", new Object[]{this, Integer.valueOf(i)});
        } else {
            super.setContentView(R$layout.splash_activity);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1170689514")) {
            return (String) ipChange.ipc$dispatch("-1170689514", new Object[]{this});
        }
        return null;
    }
}
