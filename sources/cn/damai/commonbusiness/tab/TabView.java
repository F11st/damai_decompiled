package cn.damai.commonbusiness.tab;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.image.C0504a;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.home.bean.TabExtraBean;
import cn.damai.commonbusiness.tab.TabbarLayout;
import cn.damai.uikit.image.IImageLoader;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;
import tb.mu0;
import tb.pk2;
import tb.t60;
import tb.w32;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TabView extends FrameLayout implements ITabView {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final OvershootInterpolator OVERSHOOT_INTERPOLATOR = new OvershootInterpolator(4.0f);
    private AnimatorSet mAnimatorSet;
    private View mBadgeView;
    private View mClickView;
    private CoverImageView mCoverImg;
    private View mCoverUi;
    private LinearLayout mDefaultLayout;
    private LottieAnimationView mIconImageView;
    private int mItemMaxSize;
    private TextView mLabelTextView;
    private boolean mSelected;
    private TabItem mTabItem;
    private String mTabName;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.tab.TabView$a */
    /* loaded from: classes.dex */
    public class C0930a extends pk2 {
        private static transient /* synthetic */ IpChange $ipChange;

        C0930a() {
        }

        @Override // tb.pk2, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2033254616")) {
                ipChange.ipc$dispatch("-2033254616", new Object[]{this, animator});
                return;
            }
            super.onAnimationEnd(animator);
            TabClickStatusManager.b().d(TabView.this.mTabName);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.tab.TabView$b */
    /* loaded from: classes.dex */
    public class C0931b implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0931b() {
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.C2496b c2496b) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "728138201")) {
                ipChange.ipc$dispatch("728138201", new Object[]{this, c2496b});
            } else {
                TabView.this.mCoverImg.setImageDrawable(c2496b.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.tab.TabView$c */
    /* loaded from: classes.dex */
    public class C0932c implements IImageLoader.IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0932c(TabView tabView) {
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
        public void onFail(IImageLoader.C2495a c2495a) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1528047358")) {
                ipChange.ipc$dispatch("-1528047358", new Object[]{this, c2495a});
            }
        }
    }

    public TabView(@NonNull Context context) {
        this(context, null);
    }

    private void setCoverIconBackground(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1516066232")) {
            ipChange.ipc$dispatch("1516066232", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            this.mCoverUi.setBackground(new w32(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{i, i2}, m62.a(mu0.a(), 17.0f)));
        }
    }

    private void setIconSize(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1631257204")) {
            ipChange.ipc$dispatch("1631257204", new Object[]{this, bitmap});
        } else if (this.mIconImageView == null || bitmap == null) {
        } else {
            int a = t60.a(getContext(), bitmap.getWidth() / 3);
            int a2 = t60.a(getContext(), bitmap.getHeight() / 3);
            int i2 = this.mItemMaxSize;
            if (a > i2) {
                a2 *= i2 / a;
                a = i2;
            } else {
                i = ((i2 - a) / 2) - t60.a(getContext(), 7.0f);
            }
            ViewGroup.LayoutParams layoutParams = this.mIconImageView.getLayoutParams();
            layoutParams.width = a;
            layoutParams.height = a2;
            this.mIconImageView.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mBadgeView.getLayoutParams();
            layoutParams2.topMargin = t60.a(getContext(), 8.0f);
            layoutParams2.rightMargin = i;
            this.mBadgeView.setLayoutParams(layoutParams2);
        }
    }

    private void startAnimaton() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1380386479")) {
            ipChange.ipc$dispatch("-1380386479", new Object[]{this});
            return;
        }
        AnimatorSet animatorSet = this.mAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        LinearLayout linearLayout = this.mDefaultLayout;
        linearLayout.setScaleX(1.0f);
        linearLayout.setScaleY(1.0f);
        linearLayout.animate().cancel();
        this.mAnimatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, ImageView.SCALE_Y, 1.0f, 1.1f, 1.0f, 1.1f, 1.0f);
        ofFloat.setDuration(500L);
        OvershootInterpolator overshootInterpolator = OVERSHOOT_INTERPOLATOR;
        ofFloat.setInterpolator(overshootInterpolator);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(linearLayout, ImageView.SCALE_X, 1.0f, 1.1f, 1.0f, 1.1f, 1.0f);
        ofFloat2.setDuration(500L);
        ofFloat2.setInterpolator(overshootInterpolator);
        this.mAnimatorSet.playTogether(ofFloat, ofFloat2);
        this.mAnimatorSet.start();
    }

    protected void bindTabItem() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1324983317")) {
            ipChange.ipc$dispatch("-1324983317", new Object[]{this});
            return;
        }
        TabItem tabItem = this.mTabItem;
        if (tabItem == null) {
            return;
        }
        this.mLabelTextView.setText(tabItem.tabText);
        if (this.mSelected) {
            TabItem tabItem2 = this.mTabItem;
            int i = tabItem2.tabImageType;
            if (i == TabItem.ICON_TYPE_RES) {
                this.mIconImageView.setImageResource(tabItem2.selectedIconId);
            } else if (i == TabItem.ICON_TYPE_BITMAP) {
                this.mIconImageView.setImageBitmap(tabItem2.selectedBitmap);
                setIconSize(this.mTabItem.selectedBitmap);
            }
            this.mLabelTextView.setTextColor(Color.parseColor(this.mTabItem.tabTextSelectColor));
            startAnimaton();
            return;
        }
        TabItem tabItem3 = this.mTabItem;
        int i2 = tabItem3.tabImageType;
        if (i2 == TabItem.ICON_TYPE_RES) {
            this.mIconImageView.setImageResource(tabItem3.normalIconId);
        } else if (i2 == TabItem.ICON_TYPE_BITMAP) {
            this.mIconImageView.setImageBitmap(tabItem3.normalBitmap);
            setIconSize(this.mTabItem.normalBitmap);
        }
        this.mLabelTextView.setTextColor(Color.parseColor(this.mTabItem.tabTextNormalColor));
    }

    @Override // cn.damai.commonbusiness.tab.ITabView
    public View getClickView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "396254207") ? (View) ipChange.ipc$dispatch("396254207", new Object[]{this}) : this.mClickView;
    }

    @Override // cn.damai.commonbusiness.tab.ITabView
    public LottieAnimationView getLottieAnimationView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-907473566") ? (LottieAnimationView) ipChange.ipc$dispatch("-907473566", new Object[]{this}) : this.mIconImageView;
    }

    @Override // cn.damai.commonbusiness.tab.ITabView
    public String getTab() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-676987701")) {
            return (String) ipChange.ipc$dispatch("-676987701", new Object[]{this});
        }
        TabItem tabItem = this.mTabItem;
        return tabItem != null ? tabItem.tab : "";
    }

    @Override // cn.damai.commonbusiness.tab.ITabView
    public View getTabView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-135674926") ? (View) ipChange.ipc$dispatch("-135674926", new Object[]{this}) : this;
    }

    @Override // cn.damai.commonbusiness.tab.ITabView
    public void onTabSelected() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-78170811")) {
            ipChange.ipc$dispatch("-78170811", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.tab.ITabView
    public void setBadge(TabbarLayout.BadgeType badgeType, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-242953336")) {
            ipChange.ipc$dispatch("-242953336", new Object[]{this, badgeType, str});
        } else if (badgeType == null) {
        } else {
            if (badgeType == TabbarLayout.BadgeType.NONE) {
                this.mBadgeView.setVisibility(4);
            } else if (badgeType == TabbarLayout.BadgeType.POINT) {
                this.mBadgeView.setVisibility(0);
            }
        }
    }

    @Override // cn.damai.commonbusiness.tab.ITabView
    public void setTabAnimatorListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849443898")) {
            ipChange.ipc$dispatch("-1849443898", new Object[]{this});
            return;
        }
        LottieAnimationView lottieAnimationView = this.mIconImageView;
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.addAnimatorListener(new C0930a());
    }

    @Override // cn.damai.commonbusiness.tab.ITabView
    public void setUpTabItem(TabItem tabItem, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1924758915")) {
            ipChange.ipc$dispatch("-1924758915", new Object[]{this, tabItem, str});
            return;
        }
        this.mTabItem = tabItem;
        this.mTabName = str;
        this.mSelected = TextUtils.equals(str, tabItem.tab);
        bindTabItem();
    }

    @Override // cn.damai.commonbusiness.tab.ITabView
    public void updateTopCoverIcon(TabExtraBean tabExtraBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734743484")) {
            ipChange.ipc$dispatch("1734743484", new Object[]{this, tabExtraBean});
        } else if (tabExtraBean != null) {
            this.mCoverUi.setVisibility(0);
            this.mIconImageView.setVisibility(8);
            int a = m62.a(mu0.a(), 34.0f);
            this.mCoverImg.setImageDrawable(mu0.a().getResources().getDrawable(R$drawable.uikit_default_image_bg_gradient));
            C0504a.b().load(tabExtraBean.iconUrl, a, a, new C0931b(), new C0932c(this));
        } else {
            this.mCoverUi.setVisibility(8);
            this.mIconImageView.setVisibility(0);
        }
    }

    public TabView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R$layout.home_default_tab_widget, this);
        this.mDefaultLayout = (LinearLayout) findViewById(R$id.default_frame);
        this.mIconImageView = (LottieAnimationView) findViewById(R$id.tab_image);
        this.mLabelTextView = (TextView) findViewById(R$id.tab_text);
        this.mBadgeView = findViewById(R$id.v_badge);
        this.mClickView = findViewById(R$id.tab_click_view);
        this.mItemMaxSize = DisplayMetrics.getwidthPixels(t60.b(getContext())) / 5;
        this.mCoverImg = (CoverImageView) findViewById(R$id.tab_temp_cover_img);
        this.mCoverUi = findViewById(R$id.tab_temp_cover_img_ui);
        setCoverIconBackground(Color.parseColor("#FF3DAE"), Color.parseColor("#FF7F60"));
    }
}
