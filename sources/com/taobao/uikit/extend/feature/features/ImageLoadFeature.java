package com.taobao.uikit.extend.feature.features;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import com.taobao.phenix.compat.stat.TBImageLifeCycleMonitor;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.phenix.intf.event.IRetryHandlerOnFailure;
import com.taobao.phenix.loader.network.HttpCodeResponseException;
import com.taobao.tao.image.ImageStrategyConfig;
import com.taobao.tao.util.TBImageUrlStrategy;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.taobao.uikit.feature.callback.LayoutCallback;
import com.taobao.uikit.feature.features.AbsFeature;
import com.taobao.uikit.image.R;
import com.taobao.uikit.utils.UIKITLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import tb.ce1;
import tb.ds1;
import tb.h42;
import tb.h62;
import tb.nh0;
import tb.p22;
import tb.tq1;
import tb.ui2;
import tb.ur1;
import tb.v;
import tb.wr1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ImageLoadFeature extends AbsFeature<ImageView> implements LayoutCallback {
    private static final int L_SCROLLING = 1;
    private static final int L_SHOWING = 0;
    private static final int S_DONE_FAIL = 3;
    private static final int S_DONE_SUC = 2;
    private static final int S_INIT = 0;
    private static final int S_LOADING = 1;
    private static final int S_LOAD_IMMEDIATE = 4;
    protected ObjectAnimator mAlphaAnim;
    private String mCacheKey4PlaceHolder;
    private Context mContext;
    private boolean mEnableSizeInLayoutParams;
    private int mErrorImageId;
    protected boolean mFadeIn;
    private TUrlImageView.FinalUrlInspector mFinalUrlInspector;
    private PhenixOptions mGlobalPhenixOptions;
    private WeakReference<ImageView> mHostReference;
    private int mKeepBackgroundState;
    private int mLastMaxViewSize;
    private ds1 mLastResTicket;
    private PhenixOptions mNextPhenixOptions;
    private Drawable mPlaceHoldForeground;
    protected int mPlaceHoldResourceId;
    private String mPriorityModuleName;
    private Boolean mSkipAutoSize;
    private ImageStrategyConfig mStrategyConfig;
    private ds1 mTicket;
    private String mUrl;
    protected IPhenixListener<nh0> mUserFailListener;
    protected IPhenixListener<ui2> mUserSuccListener;
    private boolean mNoRepeatOnError = true;
    protected int mLoadState = 0;
    private int mScrollState = 0;
    protected String mLoadingUrl = "";
    private boolean mWhenNullClearImg = true;
    private boolean mEnabledLoadOnFling = true;
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private ImageLoadSuccListener mSuccListener = new ImageLoadSuccListener();
    private ImageLoadFailListener mFailListener = new ImageLoadFailListener();
    private ImageRetryHandler mRetryHandler = new ImageRetryHandler();
    private boolean mUserCalledSetImageUrl = false;
    private IPhenixListener<ce1> mMemoryMissListener = new IPhenixListener<ce1>() { // from class: com.taobao.uikit.extend.feature.features.ImageLoadFeature.1
        @Override // com.taobao.phenix.intf.event.IPhenixListener
        public boolean onHappen(ce1 ce1Var) {
            ImageLoadFeature imageLoadFeature = ImageLoadFeature.this;
            int i = imageLoadFeature.mLoadState;
            imageLoadFeature.fillImageDrawable(imageLoadFeature.getHost(), null, false, ImageLoadFeature.this.mWhenNullClearImg);
            ImageLoadFeature.this.mLoadState = i;
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class ImageLoadFailListener implements IPhenixListener<nh0> {
        wr1 mCreator;

        ImageLoadFailListener() {
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        public boolean onHappen(nh0 nh0Var) {
            UIKITLog.d(TUrlImageView.LOG_TAG, "load image failed, state=%d, url=%s", Integer.valueOf(ImageLoadFeature.this.mLoadState), ImageLoadFeature.this.mUrl);
            int f = nh0Var.f();
            if (f == -1 || f == 404) {
                ImageLoadFeature.this.mNoRepeatOnError = true;
            } else {
                ImageLoadFeature.this.mNoRepeatOnError = false;
            }
            nh0Var.a().b(true);
            ImageLoadFeature imageLoadFeature = ImageLoadFeature.this;
            imageLoadFeature.fillImageDrawable(imageLoadFeature.getHost(), null, true, ImageLoadFeature.this.mWhenNullClearImg);
            ImageLoadFeature imageLoadFeature2 = ImageLoadFeature.this;
            imageLoadFeature2.mLoadState = 3;
            IPhenixListener<nh0> iPhenixListener = imageLoadFeature2.mUserFailListener;
            if (iPhenixListener != null) {
                iPhenixListener.onHappen(nh0Var);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("resultCode", String.valueOf(nh0Var.f()));
            hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("oriUrl", ImageLoadFeature.this.mUrl);
            TBImageLifeCycleMonitor a = TBImageLifeCycleMonitor.a();
            wr1 wr1Var = this.mCreator;
            a.onError(wr1Var != null ? String.valueOf(wr1Var.x()) : "", nh0Var.b(), hashMap);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class ImageLoadSuccListener implements IPhenixListener<ui2> {
        private boolean isInLayoutPass;
        wr1 mCreator;

        ImageLoadSuccListener() {
        }

        public boolean applyEvent(final ui2 ui2Var, boolean z) {
            String str;
            String b = ui2Var.b();
            if (b != null && (str = ImageLoadFeature.this.mLoadingUrl) != null && !b.startsWith(str)) {
                UIKITLog.w(TUrlImageView.LOG_TAG, "callback url not match target url, callback=%s, target=%s", b, ImageLoadFeature.this.mLoadingUrl);
                return true;
            }
            final ImageView host = ImageLoadFeature.this.getHost();
            if (host == null) {
                ImageLoadFeature.this.mLoadState = 3;
                return false;
            } else if (z && this.isInLayoutPass) {
                host.post(new Runnable() { // from class: com.taobao.uikit.extend.feature.features.ImageLoadFeature.ImageLoadSuccListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageLoadSuccListener.this.applyEvent(ui2Var, false);
                    }
                });
                return true;
            } else {
                ImageLoadFeature.this.mLoadState = 3;
                BitmapDrawable f = ui2Var.f();
                if (f == null) {
                    ImageLoadFeature imageLoadFeature = ImageLoadFeature.this;
                    imageLoadFeature.fillImageDrawable(host, null, false, imageLoadFeature.mWhenNullClearImg);
                    return true;
                }
                boolean i = ui2Var.i();
                ImageLoadFeature imageLoadFeature2 = ImageLoadFeature.this;
                boolean z2 = imageLoadFeature2.mFadeIn;
                if (imageLoadFeature2.isViewBitmapDifferentWith(host, f.getBitmap())) {
                    z2 = false;
                }
                if (!z && !i && z2 && ImageLoadFeature.this.mLoadState != 2) {
                    host.setImageDrawable(f);
                    ImageLoadFeature imageLoadFeature3 = ImageLoadFeature.this;
                    ObjectAnimator objectAnimator = imageLoadFeature3.mAlphaAnim;
                    if (objectAnimator != null) {
                        if (!objectAnimator.isRunning()) {
                            ImageLoadFeature.this.mAlphaAnim.start();
                        }
                    } else {
                        imageLoadFeature3.mAlphaAnim = ObjectAnimator.ofInt(host, "alpha", 0, 255);
                        ImageLoadFeature.this.mAlphaAnim.setInterpolator(new AccelerateInterpolator());
                        ImageLoadFeature.this.mAlphaAnim.setDuration(300L);
                        ImageLoadFeature.this.mAlphaAnim.addListener(new AnimatorListenerAdapter() { // from class: com.taobao.uikit.extend.feature.features.ImageLoadFeature.ImageLoadSuccListener.2
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (ImageLoadFeature.this.mKeepBackgroundState < 0 || (ImageLoadFeature.this.mKeepBackgroundState == 0 && ImageLoadFeature.this.mPlaceHoldResourceId != 0)) {
                                    host.setBackgroundDrawable(null);
                                }
                            }
                        });
                        ImageLoadFeature.this.mAlphaAnim.start();
                    }
                } else {
                    ImageLoadFeature imageLoadFeature4 = ImageLoadFeature.this;
                    imageLoadFeature4.fillImageDrawable(host, f, false, imageLoadFeature4.mWhenNullClearImg);
                }
                if (!i) {
                    ui2Var.a().b(true);
                    ImageLoadFeature imageLoadFeature5 = ImageLoadFeature.this;
                    imageLoadFeature5.mLoadState = 2;
                    IPhenixListener<ui2> iPhenixListener = imageLoadFeature5.mUserSuccListener;
                    if (iPhenixListener != null) {
                        iPhenixListener.onHappen(ui2Var);
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put("intermediate", Boolean.valueOf(i));
                hashMap.put(v.TAK_ABILITY_SHOW_POP_ANIMATION, Boolean.valueOf(z2));
                hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
                TBImageLifeCycleMonitor a = TBImageLifeCycleMonitor.a();
                wr1 wr1Var = this.mCreator;
                a.onFinished(wr1Var != null ? String.valueOf(wr1Var.x()) : "", b, hashMap);
                return true;
            }
        }

        public void setIsInLayoutPass(boolean z) {
            this.isInLayoutPass = z;
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        public boolean onHappen(ui2 ui2Var) {
            return applyEvent(ui2Var, ui2Var.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class ImageRetryHandler implements IRetryHandlerOnFailure {
        private String retryUrl;

        ImageRetryHandler() {
        }

        @Override // com.taobao.phenix.intf.event.IRetryHandlerOnFailure
        public String getRetryUrl(wr1 wr1Var, Throwable th) {
            if ((th instanceof HttpCodeResponseException) && ((HttpCodeResponseException) th).getHttpCode() == 404) {
                ImageLoadFeature imageLoadFeature = ImageLoadFeature.this;
                String str = this.retryUrl;
                imageLoadFeature.mLoadingUrl = str;
                return str;
            }
            return null;
        }

        public ImageRetryHandler setRetryUrl(String str) {
            if (str != null && str.endsWith(TBImageUrlStrategy.END_IMAGE_URL)) {
                this.retryUrl = str.substring(0, str.length() - 13);
            } else {
                this.retryUrl = str;
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillImageDrawable(ImageView imageView, BitmapDrawable bitmapDrawable, boolean z, boolean z2) {
        Drawable drawable;
        if (imageView == null) {
            return;
        }
        ds1 ds1Var = this.mLastResTicket;
        if (ds1Var != null) {
            ds1Var.cancel();
            this.mLastResTicket = null;
        }
        if (bitmapDrawable != null) {
            imageView.setImageDrawable(bitmapDrawable);
            int i = this.mKeepBackgroundState;
            if (i < 0 || (i == 0 && this.mPlaceHoldResourceId != 0)) {
                imageView.setBackgroundDrawable(null);
            }
        } else if (z && z2) {
            imageView.setImageDrawable(null);
            int i2 = this.mErrorImageId;
            if (i2 == 0) {
                i2 = this.mPlaceHoldResourceId;
            }
            placeBgResImage(i2);
        } else if ((z2 || isViewDrawableSameWith(imageView, null)) && (drawable = this.mPlaceHoldForeground) != null) {
            imageView.setImageDrawable(drawable);
        } else if (z2) {
            imageView.setImageDrawable(null);
            placeBgResImage(this.mPlaceHoldResourceId);
        }
    }

    private String getPriorityModuleName() {
        PhenixOptions phenixOptions = this.mNextPhenixOptions;
        if (phenixOptions != null) {
            return phenixOptions.priorityModuleName;
        }
        String str = this.mPriorityModuleName;
        if (str != null) {
            return str;
        }
        PhenixOptions phenixOptions2 = this.mGlobalPhenixOptions;
        if (phenixOptions2 != null) {
            return phenixOptions2.priorityModuleName;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isViewBitmapDifferentWith(ImageView imageView, Bitmap bitmap) {
        if (imageView instanceof TUrlImageView) {
            return ((TUrlImageView) imageView).isViewBitmapDifferentWith(bitmap);
        }
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if ((drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() != bitmap) {
                return true;
            }
        }
        return false;
    }

    private boolean isViewDrawableSameWith(ImageView imageView, Drawable drawable) {
        if (imageView instanceof TUrlImageView) {
            return ((TUrlImageView) imageView).isDrawableSameWith(drawable);
        }
        return imageView != null && imageView.getDrawable() == drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean loadImageIfNecessary(boolean r11) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.uikit.extend.feature.features.ImageLoadFeature.loadImageIfNecessary(boolean):boolean");
    }

    private void placeBgResImage(int i) {
        ImageView host = getHost();
        if (i == 0 || host == null) {
            return;
        }
        if (!h42.c(this.mContext, i)) {
            host.setBackgroundResource(i);
        } else {
            this.mLastResTicket = ur1.o().z(this.mContext).s(h62.r(i)).N(4).Q(new IPhenixListener<ui2>() { // from class: com.taobao.uikit.extend.feature.features.ImageLoadFeature.3
                @Override // com.taobao.phenix.intf.event.IPhenixListener
                public boolean onHappen(ui2 ui2Var) {
                    tq1 tq1Var;
                    ImageView host2 = ImageLoadFeature.this.getHost();
                    if (host2 == null || (tq1Var = (tq1) ui2Var.f()) == null) {
                        return false;
                    }
                    NinePatchDrawable convert2NinePatchDrawable = tq1Var.convert2NinePatchDrawable();
                    if (convert2NinePatchDrawable != null) {
                        tq1Var = convert2NinePatchDrawable;
                    }
                    host2.setBackgroundDrawable(tq1Var);
                    return false;
                }
            }).n();
        }
    }

    @Override // com.taobao.uikit.feature.callback.LayoutCallback
    public void afterOnLayout(boolean z, int i, int i2, int i3, int i4) {
        int max = Math.max(i3 - i, i4 - i2);
        int i5 = this.mLastMaxViewSize;
        boolean z2 = i5 > 0 && max - i5 >= 100;
        this.mLastMaxViewSize = max;
        if (z2 || this.mLoadState != 2) {
            if (z2) {
                resetState();
            }
            loadImageIfNecessary(true);
        }
    }

    @Override // com.taobao.uikit.feature.callback.LayoutCallback
    public void beforeOnLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // com.taobao.uikit.feature.features.AbsFeature
    public void constructor(Context context, AttributeSet attributeSet, int i) {
        constructor(context, attributeSet, i, null);
    }

    public void enableLoadOnFling(boolean z) {
        this.mEnabledLoadOnFling = z;
    }

    public void enableSizeInLayoutParams(boolean z) {
        this.mEnableSizeInLayoutParams = z;
    }

    public ImageLoadFeature failListener(IPhenixListener<nh0> iPhenixListener) {
        this.mUserFailListener = iPhenixListener;
        return this;
    }

    public String getImageUrl() {
        return this.mUrl;
    }

    public String getLoadingUrl() {
        return this.mLoadingUrl;
    }

    public boolean isFadeIn() {
        return this.mFadeIn;
    }

    public void keepBackgroundOnForegroundUpdate(boolean z) {
        this.mKeepBackgroundState = z ? 1 : -1;
    }

    public void pause() {
        this.mScrollState = 1;
    }

    public void reload(boolean z) {
        setImageUrl(this.mUrl, this.mCacheKey4PlaceHolder, z, true, this.mNextPhenixOptions);
    }

    public void resetState() {
        this.mLoadState = 0;
    }

    public void resume() {
        if (this.mScrollState == 1) {
            this.mScrollState = 0;
            int i = this.mLoadState;
            if (i == 0 || i == 4) {
                resetState();
                loadImageIfNecessary(false);
            }
        }
    }

    public p22 retrieveImageData() {
        String str = this.mLoadingUrl;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ur1.o().f(getPriorityModuleName(), str, 0, false);
    }

    public void setErrorImageResId(int i) {
        this.mErrorImageId = i;
    }

    public void setFadeIn(boolean z) {
        this.mFadeIn = z;
    }

    public void setFinalUrlInspector(TUrlImageView.FinalUrlInspector finalUrlInspector) {
        this.mFinalUrlInspector = finalUrlInspector;
    }

    public void setImageUrl(String str) {
        setImageUrl(str, null, false, false, null);
    }

    public void setPhenixOptions(PhenixOptions phenixOptions) {
        this.mGlobalPhenixOptions = phenixOptions;
    }

    public void setPlaceHoldForeground(Drawable drawable) {
        this.mPlaceHoldForeground = drawable;
    }

    public void setPlaceHoldImageResId(int i) {
        this.mPlaceHoldResourceId = i;
    }

    public void setPriorityModuleName(String str) {
        this.mPriorityModuleName = str;
    }

    public void setStrategyConfig(Object obj) {
        if (obj instanceof ImageStrategyConfig) {
            this.mStrategyConfig = (ImageStrategyConfig) obj;
        }
    }

    public void setWhenNullClearImg(boolean z) {
        this.mWhenNullClearImg = z;
    }

    public boolean skipAutoSize(boolean z) {
        this.mSkipAutoSize = Boolean.valueOf(z);
        return z;
    }

    public ImageLoadFeature succListener(IPhenixListener<ui2> iPhenixListener) {
        this.mUserSuccListener = iPhenixListener;
        return this;
    }

    public void constructor(Context context, AttributeSet attributeSet, int i, boolean[] zArr) {
        TypedArray obtainStyledAttributes;
        if (attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageLoadFeature, i, 0)) == null) {
            return;
        }
        this.mFadeIn = obtainStyledAttributes.getBoolean(R.styleable.ImageLoadFeature_uik_fade_in, false);
        int i2 = R.styleable.ImageLoadFeature_uik_skip_auto_size;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.mSkipAutoSize = Boolean.valueOf(obtainStyledAttributes.getBoolean(i2, false));
        }
        this.mWhenNullClearImg = obtainStyledAttributes.getBoolean(R.styleable.ImageLoadFeature_uik_when_null_clear_img, true);
        this.mPlaceHoldResourceId = obtainStyledAttributes.getResourceId(R.styleable.ImageLoadFeature_uik_place_hold_background, 0);
        this.mErrorImageId = obtainStyledAttributes.getResourceId(R.styleable.ImageLoadFeature_uik_error_background, 0);
        this.mPlaceHoldForeground = obtainStyledAttributes.getDrawable(R.styleable.ImageLoadFeature_uik_place_hold_foreground);
        if (zArr != null) {
            zArr[0] = obtainStyledAttributes.getBoolean(R.styleable.ImageLoadFeature_uik_auto_release_image, true);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // com.taobao.uikit.feature.features.AbsFeature
    public ImageView getHost() {
        WeakReference<ImageView> weakReference = this.mHostReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.taobao.uikit.feature.features.AbsFeature
    public void setHost(ImageView imageView) {
        if (imageView == null) {
            this.mHostReference = null;
            this.mUserSuccListener = null;
            this.mUserFailListener = null;
            ds1 ds1Var = this.mTicket;
            if (ds1Var != null) {
                ds1Var.cancel();
                return;
            }
            return;
        }
        this.mHostReference = new WeakReference<>(imageView);
        this.mContext = imageView.getContext().getApplicationContext();
        if (TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        loadImageIfNecessary(false);
    }

    public void setImageUrl(String str, String str2, boolean z, boolean z2, PhenixOptions phenixOptions) {
        int i;
        this.mUserCalledSetImageUrl = true;
        if (z2 || (i = this.mLoadState) == 0 || i == 3 || !TextUtils.equals(this.mUrl, str) || !TextUtils.equals(this.mCacheKey4PlaceHolder, str2) || !PhenixOptions.isSame(this.mNextPhenixOptions, phenixOptions)) {
            this.mUrl = str;
            this.mCacheKey4PlaceHolder = str2;
            this.mNoRepeatOnError = false;
            resetState();
            this.mNextPhenixOptions = phenixOptions;
            ImageView host = getHost();
            if (host != null) {
                if (z) {
                    if (this.mUrl == null) {
                        ur1.o().d(this.mTicket);
                        fillImageDrawable(host, null, false, true);
                        return;
                    }
                    this.mMainHandler.post(new Runnable() { // from class: com.taobao.uikit.extend.feature.features.ImageLoadFeature.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageLoadFeature.this.loadImageIfNecessary(false);
                        }
                    });
                    return;
                }
                loadImageIfNecessary(false);
            }
        }
    }
}
