package cn.damai.user.userhome.view.usercenter;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.model.RealNameAuthStatusBean;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.login.LoginManager;
import cn.damai.uikit.util.DialogUtil;
import cn.damai.uikit.view.avatar.AvatarConfig;
import cn.damai.uikit.view.avatar.AvatarView;
import cn.damai.user.userhome.bean.UserHomeDataBean;
import cn.damai.user.userhome.bean.UserInfoBean;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import tb.gw0;
import tb.hv2;
import tb.jm1;
import tb.m62;
import tb.mu0;
import tb.r92;
import tb.sk1;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UserCenterHeaderPanel implements View.OnClickListener, HeaderUiController, Runnable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DEFAULT_BG_URL = "DEFAULT_BG_URL";
    private final boolean isMineTab;
    private View mAchieveLayout;
    private TextView mAchieveTv;
    private Activity mActivity;
    private AttentionView mAttentionView;
    private View mAuthLayout;
    private RealNameAuthStatusBean mAuthStatusBean;
    private AvatarView mAvatar;
    private LottieAnimationView mAvatarLottieView;
    private ViewGroup mDescLayout;
    private View mDnaArrow;
    private View mDnaUi;
    private TextView mDnaValueTv;
    private View mEditBtn;
    private TextView mFansCountTv;
    private TextView mFocusCountTv;
    private View mGoLoginTip;
    private View mHeadBgImgClickArea;
    private ImageView mHeaderBgImg;
    private View mHeaderInfoLayout;
    private UserHomeDataBean mHomeDataBean;
    private TextView mIpInfoTv;
    private View mIpLayout;
    private TextView mNameAuthTv;
    private View mOldMemberTag;
    private ValueAnimator mShowDnaAnimator;
    private String mShowingBackGUrl;
    private TextView mUserDescTv;
    private TextView mUserNameTv;
    private ImageView mUserTypeTagImg;
    private sk1 mUtListener;
    private TextView mVerifyTv;
    private TextView mZanCountTv;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.userhome.view.usercenter.UserCenterHeaderPanel$a */
    /* loaded from: classes9.dex */
    public class C2728a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        C2728a(UserCenterHeaderPanel userCenterHeaderPanel, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1761403312")) {
                ipChange.ipc$dispatch("1761403312", new Object[]{this, c0502e});
            } else if (c0502e == null || (drawable = c0502e.a) == null) {
            } else {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                int a = intrinsicHeight > 0 ? (int) ((intrinsicWidth * m62.a(mu0.a(), 16.0f)) / intrinsicHeight) : -2;
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                if (layoutParams != null && layoutParams.width != a) {
                    layoutParams.width = a;
                    this.a.requestLayout();
                }
                this.a.setImageDrawable(drawable);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.userhome.view.usercenter.UserCenterHeaderPanel$b */
    /* loaded from: classes9.dex */
    public class C2729b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2729b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1591026013")) {
                ipChange.ipc$dispatch("1591026013", new Object[]{this, c0501d});
            } else {
                UserCenterHeaderPanel.this.mHeaderBgImg.setImageResource(R$drawable.user_center_header_default);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.userhome.view.usercenter.UserCenterHeaderPanel$c */
    /* loaded from: classes9.dex */
    public class C2730c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        C2730c(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "545249586")) {
                ipChange.ipc$dispatch("545249586", new Object[]{this, c0502e});
            } else if (c0502e == null || c0502e.a == null) {
                UserCenterHeaderPanel.this.mHeaderBgImg.setImageResource(R$drawable.user_center_header_default);
            } else {
                UserCenterHeaderPanel.this.mShowingBackGUrl = this.a;
                UserCenterHeaderPanel.this.mHeaderBgImg.setImageDrawable(c0502e.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.userhome.view.usercenter.UserCenterHeaderPanel$d */
    /* loaded from: classes17.dex */
    public class DialogInterface$OnClickListenerC2731d implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC2731d(UserCenterHeaderPanel userCenterHeaderPanel) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1169455105")) {
                ipChange.ipc$dispatch("1169455105", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.userhome.view.usercenter.UserCenterHeaderPanel$e */
    /* loaded from: classes17.dex */
    public class C2732e implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2732e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1856362442")) {
                ipChange.ipc$dispatch("-1856362442", new Object[]{this, valueAnimator});
            } else {
                UserCenterHeaderPanel.this.mDnaUi.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        }
    }

    public UserCenterHeaderPanel(Activity activity, View view, boolean z, HeadUserTrackListener headUserTrackListener) {
        sk1 sk1Var = new sk1();
        this.mUtListener = sk1Var;
        this.isMineTab = z;
        this.mActivity = activity;
        sk1Var.a(headUserTrackListener);
        View findViewById = view.findViewById(R$id.user_center_header_id);
        this.mHeaderBgImg = (ImageView) findViewById.findViewById(R$id.user_center_header_bg_img);
        this.mHeadBgImgClickArea = findViewById.findViewById(R$id.user_center_header_bg_click_area);
        this.mHeaderInfoLayout = findViewById.findViewById(R$id.user_center_header_info_layout);
        this.mUserNameTv = (TextView) findViewById.findViewById(R$id.user_center_header_user_name);
        this.mUserTypeTagImg = (ImageView) findViewById.findViewById(R$id.user_center_user_type_tag);
        this.mOldMemberTag = findViewById.findViewById(R$id.user_center_damai_old_member_tag);
        this.mDescLayout = (ViewGroup) findViewById.findViewById(R$id.user_center_header_user_desc_layout);
        this.mUserDescTv = (TextView) findViewById.findViewById(R$id.user_center_header_user_desc);
        this.mAuthLayout = findViewById.findViewById(R$id.user_center_header_real_name_auth_layout);
        this.mNameAuthTv = (TextView) findViewById.findViewById(R$id.user_center_header_real_name_auth_status);
        this.mVerifyTv = (TextView) findViewById.findViewById(R$id.user_center_header_verify_status);
        View findViewById2 = findViewById.findViewById(R$id.user_center_header_focus_count_ui);
        this.mFocusCountTv = (TextView) findViewById.findViewById(R$id.user_center_header_focus_count);
        View findViewById3 = findViewById.findViewById(R$id.user_center_header_fans_count_ui);
        this.mFansCountTv = (TextView) findViewById.findViewById(R$id.user_center_header_fans_count);
        View findViewById4 = findViewById.findViewById(R$id.user_center_header_zan_count_ui);
        this.mZanCountTv = (TextView) findViewById.findViewById(R$id.user_center_header_zan_count);
        this.mAchieveLayout = findViewById.findViewById(R$id.user_center_header_achievement_layout);
        this.mAchieveTv = (TextView) findViewById.findViewById(R$id.user_center_header_achievement_tv);
        this.mAvatarLottieView = (LottieAnimationView) findViewById.findViewById(R$id.user_center_header_lottie);
        this.mAvatar = (AvatarView) findViewById.findViewById(R$id.user_center_header_avatar_view);
        this.mAttentionView = (AttentionView) findViewById.findViewById(R$id.user_center_header_follow_btn);
        this.mEditBtn = findViewById.findViewById(R$id.user_center_header_edit);
        this.mDnaUi = findViewById.findViewById(R$id.user_center_dna_ui);
        this.mDnaValueTv = (TextView) findViewById.findViewById(R$id.user_center_dna_value);
        this.mDnaArrow = findViewById.findViewById(R$id.user_center_dna_arrow);
        this.mGoLoginTip = findViewById.findViewById(R$id.user_center_go_login_tip);
        View findViewById5 = findViewById.findViewById(R$id.user_info_back_g);
        this.mIpLayout = findViewById.findViewById(R$id.user_center_header_ip_layout);
        this.mIpInfoTv = (TextView) findViewById.findViewById(R$id.user_center_header_ip_info);
        this.mAttentionView.setBackGroundState(R$drawable.uikit_attention_btn_followed, R$drawable.uikit_attention_btn_un_follow);
        this.mAttentionView.setTextColorState(R$color.color_9C9CA5, R$color.white);
        this.mAvatar.setOnClickListener(this);
        this.mDnaUi.setOnClickListener(this);
        this.mEditBtn.setOnClickListener(this);
        this.mHeadBgImgClickArea.setOnClickListener(this);
        this.mAuthLayout.setOnClickListener(this);
        this.mGoLoginTip.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById3.setOnClickListener(this);
        findViewById4.setOnClickListener(this);
        findViewById5.setOnClickListener(this);
        this.mIpLayout.setOnClickListener(this);
        showEmptyHeadView(ModeEmpty.EMPTY_DEFAULT);
    }

    private void loadImgViewAndResize(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "242400326")) {
            ipChange.ipc$dispatch("242400326", new Object[]{this, str, imageView});
        } else {
            C0504a.b().c(str).n(new C2728a(this, imageView)).f();
        }
    }

    private void setHeaderInfoLayoutMarginTop(boolean z) {
        int a;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1305434839")) {
            ipChange.ipc$dispatch("-1305434839", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        int a2 = m62.a(mu0.a(), 22.0f);
        if (!z) {
            a = m62.a(mu0.a(), 97.0f);
        } else {
            a = m62.a(mu0.a(), 138.0f);
        }
        ViewGroup.LayoutParams layoutParams = this.mHeaderInfoLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams.topMargin != a) {
                marginLayoutParams.topMargin = a;
                this.mHeaderInfoLayout.requestLayout();
            }
        }
        ViewGroup.LayoutParams layoutParams2 = this.mHeadBgImgClickArea.getLayoutParams();
        int i = a2 + a;
        if (layoutParams2 == null || layoutParams2.height == i) {
            return;
        }
        layoutParams2.height = i;
        this.mHeadBgImgClickArea.requestLayout();
    }

    private void setUpAvatarBgLottieView(UserHomeDataBean userHomeDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-529862264")) {
            ipChange.ipc$dispatch("-529862264", new Object[]{this, userHomeDataBean});
        } else if (this.mAvatarLottieView.getTag() == null) {
            if (TextUtils.isEmpty(userHomeDataBean.getMyHeadAreaBgImg()) && LoginManager.k().q()) {
                this.mAvatarLottieView.setTag(1);
                this.mAvatarLottieView.setRepeatCount(1);
                this.mAvatarLottieView.setVisibility(0);
                this.mAvatarLottieView.postDelayed(new Runnable() { // from class: cn.damai.user.userhome.view.usercenter.UserCenterHeaderPanel.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1235190567")) {
                            ipChange2.ipc$dispatch("1235190567", new Object[]{this});
                        } else {
                            UserCenterHeaderPanel.this.mAvatarLottieView.setVisibility(8);
                        }
                    }
                }, 1500L);
            }
        }
    }

    private void setUpAvatarView(UserInfoBean userInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1928844999")) {
            ipChange.ipc$dispatch("1928844999", new Object[]{this, userInfoBean});
            return;
        }
        AvatarConfig createConfig = UserInfoBean.createConfig(userInfoBean);
        createConfig.clearDrawableWhenDiffUrlSet = false;
        this.mAvatar.update(createConfig, userInfoBean.getImgUrl());
    }

    private void setUpDnaLayoutIfAllow(UserHomeDataBean userHomeDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-670483681")) {
            ipChange.ipc$dispatch("-670483681", new Object[]{this, userHomeDataBean});
            return;
        }
        String dnaSimilar = userHomeDataBean.getDnaSimilar();
        String goDnaUrl = userHomeDataBean.getGoDnaUrl();
        int i = (int) jm1.i(dnaSimilar, 0.0f);
        if (!this.isMineTab && !userHomeDataBean.isMySelf() && i > 0) {
            this.mUtListener.onExposeDnaLayout(this.mDnaUi);
            this.mDnaArrow.setVisibility(TextUtils.isEmpty(goDnaUrl) ? 4 : 0);
            this.mDnaValueTv.setText(i + "%");
            if (this.mDnaUi.getTag() == null) {
                this.mDnaUi.setTag(1);
                this.mDnaUi.postDelayed(this, 500L);
                return;
            }
            ValueAnimator valueAnimator = this.mShowDnaAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.mDnaUi.removeCallbacks(this);
            this.mDnaUi.scrollTo(0, 0);
            this.mDnaUi.setVisibility(0);
            return;
        }
        this.mDnaUi.setVisibility(4);
    }

    private void setUpUserDescLayout(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-721108550")) {
            ipChange.ipc$dispatch("-721108550", new Object[]{this, str, str2, str3});
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            this.mDescLayout.setVisibility(8);
        } else {
            this.mDescLayout.setVisibility(0);
            if (TextUtils.isEmpty(str)) {
                this.mAuthLayout.setVisibility(8);
            } else {
                this.mAuthLayout.setVisibility(0);
                this.mNameAuthTv.setText(str);
            }
            if (TextUtils.isEmpty(str2)) {
                this.mVerifyTv.setVisibility(8);
            } else {
                this.mVerifyTv.setVisibility(0);
                this.mVerifyTv.setText(str2);
            }
            if (TextUtils.isEmpty(str3)) {
                this.mUserDescTv.setVisibility(8);
                return;
            }
            this.mUserDescTv.setVisibility(0);
            this.mUserDescTv.setText(str3);
        }
    }

    private void setUserHeadBackgroundView(String str, String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "472436723")) {
            ipChange.ipc$dispatch("472436723", new Object[]{this, str, str2});
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            z = false;
        }
        setHeaderInfoLayoutMarginTop(z);
        if (TextUtils.isEmpty(str)) {
            str = !TextUtils.isEmpty(str2) ? str2 : DEFAULT_BG_URL;
        }
        if (TextUtils.equals(this.mShowingBackGUrl, str)) {
            return;
        }
        if (TextUtils.equals(DEFAULT_BG_URL, str)) {
            this.mShowingBackGUrl = str;
            this.mHeaderBgImg.setImageResource(R$drawable.user_center_header_default);
            return;
        }
        C0504a.b().c(str).n(new C2730c(str)).e(new C2729b()).f();
    }

    private void setUserTypeTagView(UserInfoBean userInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2005865590")) {
            ipChange.ipc$dispatch("2005865590", new Object[]{this, userInfoBean});
        } else if (userInfoBean.userTypeCode == 2) {
            this.mUserTypeTagImg.setVisibility(8);
        } else {
            String str = userInfoBean.userTypeIcon;
            if (TextUtils.isEmpty(str)) {
                this.mUserTypeTagImg.setVisibility(8);
                return;
            }
            this.mUserTypeTagImg.setVisibility(0);
            loadImgViewAndResize(str, this.mUserTypeTagImg);
        }
    }

    private void showIPExplainDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "68010628")) {
            ipChange.ipc$dispatch("68010628", new Object[]{this});
        } else if (this.mActivity.isFinishing()) {
        } else {
            new DMDialog(this.mActivity).v("IP属地说明").q("为维护网络安全、保障良好生态和社区的真实性，根据网络运营商数据，展示用户IP属地信息。").n("我知道了", new DialogInterface$OnClickListenerC2731d(this)).show();
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.GetAttentionView
    public AttentionView getAttentionView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2004122021") ? (AttentionView) ipChange.ipc$dispatch("2004122021", new Object[]{this}) : this.mAttentionView;
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void hideRealNameAuthView() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1014342643")) {
            ipChange.ipc$dispatch("1014342643", new Object[]{this});
            return;
        }
        this.mAuthLayout.setVisibility(8);
        int childCount = this.mDescLayout.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                z = false;
                break;
            } else if (this.mDescLayout.getChildAt(i).getVisibility() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.mDescLayout.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        RealNameAuthStatusBean realNameAuthStatusBean;
        String str;
        String str2;
        String str3;
        IpChange ipChange = $ipChange;
        boolean z = false;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-2124076388")) {
            ipChange.ipc$dispatch("-2124076388", new Object[]{this, view});
        } else if (r92.c() || (activity = this.mActivity) == null || activity.isFinishing()) {
        } else {
            if (this.isMineTab && !LoginManager.k().q()) {
                this.mUtListener.onUtOpenLoginPageClick();
                LoginManager.k().v(this.mActivity);
            } else if (this.mHomeDataBean == null) {
            } else {
                int id = view.getId();
                if (id == R$id.user_center_header_avatar_view) {
                    this.mUtListener.onUtHeadAvatarClick();
                    if (this.isMineTab) {
                        gw0.f(this.mActivity, gw0.b(this.mHomeDataBean));
                    } else {
                        gw0.g(this.mActivity, gw0.b(this.mHomeDataBean));
                    }
                } else if (id == R$id.user_center_header_bg_click_area) {
                    if (this.isMineTab) {
                        this.mUtListener.onUtHeadBackImgClick();
                        gw0.j(this.mActivity, gw0.c(this.mHomeDataBean));
                    }
                } else if (id == R$id.user_center_dna_ui) {
                    if (this.mDnaUi.getVisibility() == 0) {
                        String goDnaUrl = this.mHomeDataBean.getGoDnaUrl();
                        if (TextUtils.isEmpty(goDnaUrl)) {
                            this.mUtListener.onUtDNAViewClick(false);
                            final Dialog b = DialogUtil.b(this.mActivity);
                            b.show();
                            this.mDnaUi.postDelayed(new Runnable() { // from class: cn.damai.user.userhome.view.usercenter.UserCenterHeaderPanel.5
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // java.lang.Runnable
                                public void run() {
                                    IpChange ipChange2 = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange2, "449136547")) {
                                        ipChange2.ipc$dispatch("449136547", new Object[]{this});
                                    } else if (b.isShowing()) {
                                        b.dismiss();
                                    }
                                }
                            }, DanmakuFactory.MIN_DANMAKU_DURATION);
                            return;
                        }
                        this.mUtListener.onUtDNAViewClick(true);
                        DMNav.from(this.mActivity).toUri(goDnaUrl);
                    }
                } else if (id == R$id.user_center_header_edit) {
                    if (this.isMineTab) {
                        this.mUtListener.onUtOpenUserInfoEditClick();
                        gw0.k(this.mActivity, this.mHomeDataBean.getUserInfo());
                    }
                } else {
                    if (id == R$id.user_center_header_focus_count_ui) {
                        z = (this.isMineTab || this.mHomeDataBean.isMySelf()) ? true : true;
                        if (this.isMineTab) {
                            str3 = z20.i();
                        } else {
                            UserInfoBean userInfo = this.mHomeDataBean.getUserInfo();
                            str3 = userInfo != null ? userInfo.havanaIdStr : null;
                        }
                        this.mUtListener.onUtOpenRelateInfoClick("follow_btn");
                        gw0.i(this.mActivity, str3, z);
                    } else if (id == R$id.user_center_header_fans_count_ui) {
                        if (this.isMineTab) {
                            str2 = z20.i();
                        } else {
                            UserInfoBean userInfo2 = this.mHomeDataBean.getUserInfo();
                            str2 = userInfo2 != null ? userInfo2.havanaIdStr : null;
                        }
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        this.mUtListener.onUtOpenRelateInfoClick("fans");
                        gw0.h(this.mActivity, str2, (this.isMineTab || this.mHomeDataBean.isMySelf()) ? true : true);
                    } else if (id == R$id.user_center_header_zan_count_ui) {
                        if (this.isMineTab) {
                            str = z20.i();
                        } else {
                            UserInfoBean userInfo3 = this.mHomeDataBean.getUserInfo();
                            String str4 = userInfo3 != null ? userInfo3.havanaIdStr : null;
                            z2 = this.mHomeDataBean.isMySelf();
                            str = str4;
                        }
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        this.mUtListener.onUtOpenRelateInfoClick("thumb");
                        gw0.l(this.mActivity, str, z2);
                    } else if (id == R$id.user_center_header_real_name_auth_layout) {
                        if (!this.isMineTab || (realNameAuthStatusBean = this.mAuthStatusBean) == null) {
                            return;
                        }
                        this.mUtListener.onUtOpenRealNameAuthClick(realNameAuthStatusBean);
                        gw0.e(this.mActivity, this.mAuthStatusBean);
                    } else if (id == R$id.user_center_header_ip_layout) {
                        showIPExplainDialog();
                    }
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-45115244")) {
            ipChange.ipc$dispatch("-45115244", new Object[]{this});
            return;
        }
        int measuredWidth = this.mDnaUi.getMeasuredWidth();
        this.mDnaUi.scrollTo(measuredWidth, 0);
        this.mDnaUi.setVisibility(0);
        ValueAnimator ofInt = ValueAnimator.ofInt(measuredWidth, 0);
        this.mShowDnaAnimator = ofInt;
        ofInt.setDuration(300L);
        this.mShowDnaAnimator.setInterpolator(new LinearInterpolator());
        this.mShowDnaAnimator.addUpdateListener(new C2732e());
        this.mShowDnaAnimator.start();
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void setBGAtmosphereUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1588816751")) {
            ipChange.ipc$dispatch("1588816751", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            setUserHeadBackgroundView(str, null);
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void setUserAvatarUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1042811980")) {
            ipChange.ipc$dispatch("1042811980", new Object[]{this, str});
        } else {
            this.mAvatar.setAvatarUrl(str);
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void setUserNickView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494293524")) {
            ipChange.ipc$dispatch("1494293524", new Object[]{this, str});
        } else if (!wh2.j(str)) {
            if (str.length() > 12) {
                str = str.substring(0, 12) + (char) 8230;
            }
            this.mUserNameTv.setText(str);
        } else {
            this.mUserNameTv.setText("");
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void showEmptyHeadView(ModeEmpty modeEmpty) {
        AvatarConfig defaultConfig;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-552911632")) {
            ipChange.ipc$dispatch("-552911632", new Object[]{this, modeEmpty});
            return;
        }
        if (modeEmpty == ModeEmpty.NONE_LOGIN) {
            defaultConfig = AvatarConfig.mineTabNoneLoginConfig();
            this.mGoLoginTip.setVisibility(0);
            str = "HI~欢迎来到大麦";
        } else {
            defaultConfig = AvatarConfig.defaultConfig();
            this.mGoLoginTip.setVisibility(8);
            str = "";
        }
        this.mAvatar.update(defaultConfig, null);
        this.mUserNameTv.setText(str);
        this.mFocusCountTv.setText("0");
        this.mZanCountTv.setText("0");
        this.mFansCountTv.setText("0");
        this.mAttentionView.setVisibility(8);
        this.mEditBtn.setVisibility(8);
        this.mDnaUi.setVisibility(4);
        this.mDescLayout.setVisibility(8);
        this.mUserTypeTagImg.setVisibility(8);
        this.mOldMemberTag.setVisibility(8);
        this.mAchieveLayout.setVisibility(8);
        this.mIpLayout.setVisibility(8);
        setUserHeadBackgroundView(null, null);
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void update(UserHomeDataBean userHomeDataBean, RealNameAuthStatusBean realNameAuthStatusBean) {
        String str;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1685206153")) {
            ipChange.ipc$dispatch("-1685206153", new Object[]{this, userHomeDataBean, realNameAuthStatusBean});
            return;
        }
        this.mHomeDataBean = userHomeDataBean;
        this.mAuthStatusBean = realNameAuthStatusBean;
        if (userHomeDataBean != null && userHomeDataBean.getUserInfo() != null) {
            this.mGoLoginTip.setVisibility(8);
            this.mFocusCountTv.setText(hv2.a(userHomeDataBean.getMyFollowCount()));
            this.mFansCountTv.setText(hv2.a(userHomeDataBean.getFansCount()));
            this.mZanCountTv.setText(hv2.a(userHomeDataBean.getPraiseWantCount()));
            this.mAchieveLayout.setVisibility(8);
            UserInfoBean userInfo = userHomeDataBean.getUserInfo();
            setUserNickView(userInfo.userNick);
            setUserHeadBackgroundView(userHomeDataBean.getMyHeadAreaBgImg(), userInfo.headBgImg);
            String str2 = TextUtils.isEmpty(userInfo.userIntro) ? "在大麦，记录我的精彩" : userInfo.userIntro;
            String str3 = null;
            if (this.isMineTab) {
                str = userInfo.getUserNickStatus();
                if (realNameAuthStatusBean != null) {
                    int accountVerifyCode = realNameAuthStatusBean.getAccountVerifyCode();
                    if (accountVerifyCode == 1) {
                        str3 = "完善实名认证";
                    } else if (accountVerifyCode == 5) {
                        str3 = "实名认证失败";
                    }
                }
            } else {
                str = null;
            }
            setUpUserDescLayout(str3, str, str2);
            setUpAvatarView(userInfo);
            setUserTypeTagView(userInfo);
            setUpDnaLayoutIfAllow(userHomeDataBean);
            setUpAvatarBgLottieView(userHomeDataBean);
            this.mEditBtn.setVisibility(this.isMineTab ? 0 : 8);
            this.mAttentionView.setVisibility((this.isMineTab || userHomeDataBean.isMySelf()) ? false : false ? 0 : 8);
            this.mOldMemberTag.setVisibility(userHomeDataBean.isVip() ? 0 : 8);
            if (TextUtils.isEmpty(userInfo.region)) {
                this.mIpLayout.setVisibility(8);
                return;
            }
            this.mIpLayout.setVisibility(0);
            this.mIpInfoTv.setText("IP归属地：" + userInfo.region);
            return;
        }
        showEmptyHeadView(ModeEmpty.EMPTY_DEFAULT);
    }
}
