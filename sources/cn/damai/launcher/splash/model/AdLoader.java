package cn.damai.launcher.splash.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.launcher.splash.api.SplashResponse;
import cn.damai.launcher.splash.model.bean.AdCacheResult;
import cn.damai.launcher.splash.model.bean.AdFileResult;
import cn.damai.launcher.splash.model.listener.OnAdFetchListener;
import cn.damai.launcher.splash.model.listener.OnAdSetUpUiListener;
import cn.damai.launcher.splash.model.listener.OnAdXFlushProcessor;
import cn.damai.launcher.utils.SplashSchemaUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.cb1;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AdLoader implements OnAdFetchListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "AdLoader";
    private Context mContext;
    @Nullable
    private OnAdSetUpUiListener mListener;
    private OnAdXFlushProcessor mXFlushProcessor;
    private boolean isNeedUpdateUi = false;
    private AtomicBoolean isDispatchedFail = new AtomicBoolean(false);

    public AdLoader(Context context, @Nullable OnAdSetUpUiListener onAdSetUpUiListener) {
        this.mListener = onAdSetUpUiListener;
        this.mContext = context;
    }

    private void loadImg(String str, final OnBizListener<Drawable> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-83336992")) {
            ipChange.ipc$dispatch("-83336992", new Object[]{this, str, onBizListener});
        } else {
            C0504a.b().c(str).n(new DMImageCreator.DMImageSuccListener() { // from class: cn.damai.launcher.splash.model.AdLoader.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                public void onSuccess(DMImageCreator.C0502e c0502e) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1090795507")) {
                        ipChange2.ipc$dispatch("1090795507", new Object[]{this, c0502e});
                        return;
                    }
                    Drawable drawable = c0502e.a;
                    if (drawable != null) {
                        onBizListener.onBizSuccess(drawable);
                    } else {
                        onBizListener.onBizFail("-1", "drawable none");
                    }
                }
            }).e(new DMImageCreator.DMImageFailListener() { // from class: cn.damai.launcher.splash.model.AdLoader.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                public void onFail(DMImageCreator.C0501d c0501d) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1454630110")) {
                        ipChange2.ipc$dispatch("1454630110", new Object[]{this, c0501d});
                        return;
                    }
                    OnBizListener onBizListener2 = onBizListener;
                    onBizListener2.onBizFail(c0501d.a + "", "DMImageLoader.onFail");
                }
            }).f();
        }
    }

    public static void log(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-624124541")) {
            ipChange.ipc$dispatch("-624124541", new Object[]{str});
        } else {
            cb1.f(TAG, str);
        }
    }

    public void autoFetch(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-444491902")) {
            ipChange.ipc$dispatch("-444491902", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isNeedUpdateUi = z;
        new AdFetcher(this).doAdFetch();
    }

    @Override // cn.damai.launcher.splash.model.listener.OnAdFetchListener
    public void dispatchAdFetchPhaseFail(int i, String str, String str2) {
        OnAdSetUpUiListener onAdSetUpUiListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1596301766")) {
            ipChange.ipc$dispatch("1596301766", new Object[]{this, Integer.valueOf(i), str, str2});
            return;
        }
        log("fetch phase fail: why:" + i + " reason:" + AdConstant.code2String(i) + " code:" + str + " msg:" + str2);
        OnAdXFlushProcessor onAdXFlushProcessor = this.mXFlushProcessor;
        if (onAdXFlushProcessor != null) {
            onAdXFlushProcessor.dispatchAdFetchPhaseFail(i, str, str2);
        }
        if (AdConstant.isCodeNeedClearCache(i)) {
            AdBitmapResTool.applySpSplashResString(this.mContext, "");
        }
        if (this.isNeedUpdateUi && this.isDispatchedFail.compareAndSet(false, true) && (onAdSetUpUiListener = this.mListener) != null) {
            onAdSetUpUiListener.dispatchNoneAdAction(i, str, str2);
        }
    }

    @Override // cn.damai.launcher.splash.model.listener.OnAdFetchListener
    public void dispatchAdFetchSuccess(@NonNull File file, @NonNull final SplashResponse splashResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1035569614")) {
            ipChange.ipc$dispatch("-1035569614", new Object[]{this, file, splashResponse});
            return;
        }
        log("fetch success endTime:" + splashResponse.getEndTime() + " now:" + System.currentTimeMillis() + " " + splashResponse.getPic() + "");
        if (TextUtils.isEmpty(splashResponse.getSchema()) || SplashSchemaUtil.a(splashResponse.getSchema())) {
            splashResponse.setAdSupportUseCache(false);
            splashResponse.setEndTime(null);
        }
        OnAdXFlushProcessor onAdXFlushProcessor = this.mXFlushProcessor;
        if (onAdXFlushProcessor != null) {
            onAdXFlushProcessor.dispatchAdFetchSuccess(file, splashResponse);
        }
        AdBitmapResTool.applySpSplashResString(this.mContext, m61.e(splashResponse));
        if (!this.isNeedUpdateUi || this.isDispatchedFail.get()) {
            return;
        }
        loadImg(file.getAbsolutePath(), new OnBizListener<Drawable>() { // from class: cn.damai.launcher.splash.model.AdLoader.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
            public void onBizFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1158218895")) {
                    ipChange2.ipc$dispatch("1158218895", new Object[]{this, str, str2});
                } else {
                    AdLoader.this.dispatchAdFetchPhaseFail(4, str, str2);
                }
            }

            @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
            public void onBizSuccess(Drawable drawable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-15333166")) {
                    ipChange2.ipc$dispatch("-15333166", new Object[]{this, drawable});
                } else if (AdLoader.this.mListener != null) {
                    AdLoader.this.mListener.dispatchShowAdAction(false, drawable, splashResponse);
                }
            }
        });
    }

    public AdCacheResult isShouldUseCacheAd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1195056404")) {
            return (AdCacheResult) ipChange.ipc$dispatch("-1195056404", new Object[]{this});
        }
        SplashResponse spCacheSplashRes = AdBitmapResTool.getSpCacheSplashRes(this.mContext);
        if (spCacheSplashRes != null && spCacheSplashRes.isPicUrlValid() && !spCacheSplashRes.isAdEndTimeOverCurrentTime()) {
            if (!spCacheSplashRes.isAdSupportUseCache()) {
                return AdCacheResult.noneCacheAd();
            }
            if (!TextUtils.equals(spCacheSplashRes.getDiffCityId(), AdBitmapResTool.getCityId(this.mContext))) {
                return AdCacheResult.noneCacheAd();
            }
            AdFileResult isHasCacheAdFile = AdFile.isHasCacheAdFile(this.mContext, spCacheSplashRes.getPic());
            if (isHasCacheAdFile.isHasCacheAdFile) {
                return new AdCacheResult(true, spCacheSplashRes, isHasCacheAdFile.cacheAdFile);
            }
            return AdCacheResult.noneCacheAd();
        }
        return AdCacheResult.noneCacheAd();
    }

    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1972277275")) {
            ipChange.ipc$dispatch("1972277275", new Object[]{this});
            return;
        }
        final AdCacheResult isShouldUseCacheAd = isShouldUseCacheAd();
        boolean z = isShouldUseCacheAd.isUseCache;
        this.mXFlushProcessor = new OnAdXFlushProcessor(z);
        if (z) {
            loadImg(isShouldUseCacheAd.adCacheFile.getAbsolutePath(), new OnBizListener<Drawable>() { // from class: cn.damai.launcher.splash.model.AdLoader.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
                public void onBizFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1149291150")) {
                        ipChange2.ipc$dispatch("-1149291150", new Object[]{this, str, str2});
                    } else {
                        AdLoader.this.autoFetch(true);
                    }
                }

                @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
                public void onBizSuccess(Drawable drawable) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2095511281")) {
                        ipChange2.ipc$dispatch("-2095511281", new Object[]{this, drawable});
                        return;
                    }
                    if (AdLoader.this.mListener != null) {
                        AdLoader.this.mListener.dispatchShowAdAction(true, drawable, isShouldUseCacheAd.cacheRes);
                    }
                    AdLoader.log("use cache 快速上屏 ");
                    AdLoader.this.autoFetch(false);
                }
            });
            return;
        }
        log("none use cache 开始异步加载 ");
        autoFetch(true);
    }
}
