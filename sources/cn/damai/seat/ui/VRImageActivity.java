package cn.damai.seat.ui;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.blur.ImageBlurHelper;
import cn.damai.common.util.toastutil.C0537a;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeat3DVrInfo;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.seat.R$color;
import cn.damai.seat.R$drawable;
import cn.damai.seat.R$id;
import cn.damai.seat.R$layout;
import cn.damai.solid.bean.VRAlarmBean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import java.util.HashMap;
import tb.j82;
import tb.k82;
import tb.kg2;
import tb.kn1;
import tb.n82;
import tb.u92;
import tb.zr;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VRImageActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String VR_CITY_ID = "VR_CITY_ID";
    public static final String VR_FLOORID_ID = "VR_FLOOR_ID";
    public static final String VR_Img_HASH = "VR_IMG_HASH";
    public static final String VR_Img_Url = "VR_IMG_URL";
    public static final String VR_REGION_3DVR_INFO = "VR_REGION_3DVR_INFO";
    public static final String VR_SEAT_ID = "VR_SEAT_ID";
    public static final String VR_Thumb_Img_Url = "VR_THUMB_IMG_URL";
    public static final String VR_XOR_PERFORM_ID = "VR_XOR_PERFORM_ID";
    private VRAlarmBean mBean;
    private String mCityId;
    private String mFloorId;
    private TextView mLoadingTipTv;
    private LottieAnimationView mLoadingView;
    private View mMainView;
    private View mMaskView;
    private ImageView mPreloadView;
    private RegionSeat3DVrInfo mRegionSeat3DVrInfo;
    private long mSeatId;
    private VrPanoramaView mVRView;
    private VrPanoramaView.Options mVRViewOptions;
    private String mVrImageUrl;
    private String mVrImggeHash;
    private long mXorPerformId;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.ui.VRImageActivity$a */
    /* loaded from: classes7.dex */
    public class C1715a extends VrPanoramaEventListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1715a() {
        }

        @Override // com.google.vr.sdk.widgets.common.VrEventListener
        public void onClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1790973853")) {
                ipChange.ipc$dispatch("1790973853", new Object[]{this});
            } else {
                super.onClick();
            }
        }

        @Override // com.google.vr.sdk.widgets.common.VrEventListener
        public void onDisplayModeChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2133993165")) {
                ipChange.ipc$dispatch("2133993165", new Object[]{this, Integer.valueOf(i)});
            } else {
                super.onDisplayModeChanged(i);
            }
        }

        @Override // com.google.vr.sdk.widgets.common.VrEventListener
        public void onLoadError(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1575432915")) {
                ipChange.ipc$dispatch("-1575432915", new Object[]{this, str});
                return;
            }
            super.onLoadError(str);
            VRImageActivity.this.showError("", str);
        }

        @Override // com.google.vr.sdk.widgets.common.VrEventListener
        public void onLoadSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "742177992")) {
                ipChange.ipc$dispatch("742177992", new Object[]{this});
                return;
            }
            super.onLoadSuccess();
            VRImageActivity.this.dismissLoading();
            VRImageActivity.this.alpha();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.ui.VRImageActivity$b */
    /* loaded from: classes7.dex */
    public class C1716b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1716b(VRImageActivity vRImageActivity) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1072294328")) {
                ipChange.ipc$dispatch("-1072294328", new Object[]{this, c0501d});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.ui.VRImageActivity$c */
    /* loaded from: classes7.dex */
    public class C1717c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        C1717c(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1852689955")) {
                ipChange.ipc$dispatch("-1852689955", new Object[]{this, c0502e});
            } else if (c0502e == null || (bitmap = c0502e.b) == null) {
            } else {
                VRImageActivity.this.mPreloadView.setImageBitmap(ImageBlurHelper.f(VRImageActivity.this, this.a, bitmap, 10));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.ui.VRImageActivity$d */
    /* loaded from: classes7.dex */
    public class C1718d implements RequestListener<ImageData, j82> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        C1718d(String str) {
            this.a = str;
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
        /* renamed from: a */
        public void onSuccess(kn1<j82> kn1Var, ImageData imageData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1378775372")) {
                ipChange.ipc$dispatch("1378775372", new Object[]{this, kn1Var, imageData});
            } else if (imageData == null || imageData.getJPG() == null) {
                VRImageActivity.this.showError(this.a);
            } else {
                VRImageActivity.this.mVRView.loadImageFromBitmap(imageData.getJPG(), VRImageActivity.this.mVRViewOptions);
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
        public void onFail(kn1<j82> kn1Var, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1643968094")) {
                ipChange.ipc$dispatch("-1643968094", new Object[]{this, kn1Var, str, str2});
            } else {
                VRImageActivity.this.showError(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.ui.VRImageActivity$e */
    /* loaded from: classes7.dex */
    public class C1719e implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        C1719e(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-277415989")) {
                ipChange.ipc$dispatch("-277415989", new Object[]{this, c0501d});
            } else {
                VRImageActivity.this.showError(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.ui.VRImageActivity$f */
    /* loaded from: classes7.dex */
    public class C1720f implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        C1720f(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "618046752")) {
                ipChange.ipc$dispatch("618046752", new Object[]{this, c0502e});
            } else if (c0502e == null || (bitmap = c0502e.b) == null) {
                VRImageActivity.this.showError(this.a);
            } else {
                VRImageActivity.this.mVRView.loadImageFromBitmap(bitmap, VRImageActivity.this.mVRViewOptions);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.ui.VRImageActivity$g */
    /* loaded from: classes16.dex */
    public class C1721g implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1721g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "36459426")) {
                ipChange.ipc$dispatch("36459426", new Object[]{this, valueAnimator});
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            VRImageActivity.this.mPreloadView.setAlpha(floatValue);
            VRImageActivity.this.mMaskView.setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alpha() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "748113013")) {
            ipChange.ipc$dispatch("748113013", new Object[]{this});
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(600L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new C1721g());
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2108250747")) {
            ipChange.ipc$dispatch("-2108250747", new Object[]{this});
            return;
        }
        this.mLoadingView.cancelAnimation();
        this.mLoadingView.setVisibility(8);
        this.mLoadingTipTv.setVisibility(8);
    }

    private void hideStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1055692652")) {
            ipChange.ipc$dispatch("-1055692652", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            kg2.f(this, true, R$color.black);
        } else {
            kg2.f(this, false, R$color.black);
        }
    }

    private void initVRView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1793708826")) {
            ipChange.ipc$dispatch("-1793708826", new Object[]{this});
            return;
        }
        VrPanoramaView vrPanoramaView = (VrPanoramaView) findViewById(R$id.vr_pan_view);
        this.mVRView = vrPanoramaView;
        vrPanoramaView.setPureTouchTracking(true);
        this.mVRView.setDisplayMode(1);
        this.mVRView.setInfoButtonEnabled(false);
        this.mVRView.setStereoModeButtonEnabled(false);
        this.mVRView.setFullscreenButtonEnabled(false);
        this.mVRView.setEventListener((VrPanoramaEventListener) new C1715a());
        VrPanoramaView.Options options = new VrPanoramaView.Options();
        this.mVRViewOptions = options;
        options.inputType = 1;
    }

    private void load360Image(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "297604877")) {
            ipChange.ipc$dispatch("297604877", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str) && this.mVRView != null) {
            if (u92.b().d()) {
                k82.r().h(n82.g(true, this.mXorPerformId, this.mCityId, this.mSeatId, this.mFloorId, str, this.mVrImggeHash, this.mRegionSeat3DVrInfo, true), new C1718d(str));
                return;
            }
            DMImageCreator c = C0504a.b().c(str);
            int i = R$drawable.bg_border_corner_6_solid_f5f5f5;
            c.i(i).c(i).n(new C1720f(str)).e(new C1719e(str)).f();
        } else {
            C0537a.i(this, "VR 参数异常");
        }
    }

    private void loadMaskView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-691769782")) {
            ipChange.ipc$dispatch("-691769782", new Object[]{this, str});
            return;
        }
        DMImageCreator c = C0504a.b().c(str);
        int i = R$drawable.bg_border_corner_6_solid_f5f5f5;
        c.i(i).c(i).n(new C1717c(str)).e(new C1716b(this)).f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showError(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1255115150")) {
            ipChange.ipc$dispatch("-1255115150", new Object[]{this, str});
        } else {
            showError(str, null);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "580871103")) {
            ipChange.ipc$dispatch("580871103", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-993561909") ? ((Integer) ipChange.ipc$dispatch("-993561909", new Object[]{this})).intValue() : R$layout.vrimage_activity;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1697320464")) {
            ipChange.ipc$dispatch("1697320464", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        onResponseSuccess(this.mMainView);
        this.mLoadingView.setVisibility(0);
        this.mLoadingView.playAnimation();
        this.mLoadingTipTv.setVisibility(0);
        load360Image(this.mVrImageUrl);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1846779365")) {
            ipChange.ipc$dispatch("-1846779365", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483374686")) {
            ipChange.ipc$dispatch("-1483374686", new Object[]{this});
            return;
        }
        hideStatusBar();
        hideBaseLayout();
        this.mMainView = findViewById(R$id.layout_main);
        ((DMIconFontTextView) findViewById(R$id.ic_close)).setOnClickListener(this);
        this.mMaskView = findViewById(R$id.mask_view);
        this.mPreloadView = (ImageView) findViewById(R$id.iv_preload_view);
        this.mLoadingView = (LottieAnimationView) findViewById(R$id.loading_view);
        this.mLoadingTipTv = (TextView) findViewById(R$id.tv_loading_tip);
        try {
            initVRView();
        } catch (Throwable th) {
            C0537a.i(this, "VR系统参数异常");
            th.printStackTrace();
        }
        Intent intent = getIntent();
        this.mBean = (VRAlarmBean) intent.getParcelableExtra(VRAlarmBean.VR_ALARM_KEY);
        this.mVrImageUrl = intent.getStringExtra(VR_Img_Url);
        this.mVrImggeHash = intent.getStringExtra(VR_Img_HASH);
        this.mSeatId = intent.getLongExtra(VR_SEAT_ID, 0L);
        this.mFloorId = intent.getStringExtra(VR_FLOORID_ID);
        this.mXorPerformId = intent.getLongExtra(VR_XOR_PERFORM_ID, 0L);
        this.mCityId = intent.getStringExtra(VR_CITY_ID);
        this.mRegionSeat3DVrInfo = (RegionSeat3DVrInfo) intent.getSerializableExtra(VR_REGION_3DVR_INFO);
        loadMaskView(intent.getStringExtra(VR_Thumb_Img_Url));
        this.mLoadingView.playAnimation();
        try {
            load360Image(this.mVrImageUrl);
        } catch (Throwable th2) {
            th2.printStackTrace();
            C0537a.i(this, "VR系统参数异常");
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1750022904")) {
            ipChange.ipc$dispatch("-1750022904", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view.getId() == R$id.ic_close) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1763580406")) {
            ipChange.ipc$dispatch("1763580406", new Object[]{this});
            return;
        }
        super.onStop();
        LottieAnimationView lottieAnimationView = this.mLoadingView;
        if (lottieAnimationView == null || !lottieAnimationView.isAnimating()) {
            return;
        }
        this.mLoadingView.cancelAnimation();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088297985")) {
            return (String) ipChange.ipc$dispatch("-2088297985", new Object[]{this});
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1793304508")) {
            ipChange.ipc$dispatch("1793304508", new Object[]{this, str, str2});
            return;
        }
        if (str2 == null) {
            str2 = "网络不太顺畅哦～";
        }
        HashMap hashMap = new HashMap();
        VRAlarmBean vRAlarmBean = this.mBean;
        if (vRAlarmBean != null) {
            hashMap.putAll(vRAlarmBean.toMap());
        }
        hashMap.put("seatId", String.valueOf(this.mSeatId));
        hashMap.put("floorId", this.mFloorId);
        dismissLoading();
        zr.INSTANCE.a().a(str).c("").d(str2).g("VR选座页").e(hashMap).f(false).b();
        onResponseError("网络不太顺畅哦～", "", str, this.mMainView, true);
    }
}
