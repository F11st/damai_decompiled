package cn.damai.commonbusiness.fission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.fission.bean.FissionInfoBean;
import cn.damai.commonbusiness.fission.bean.FissionViewPagerBean;
import cn.damai.commonbusiness.fission.util.FissionUtil;
import cn.damai.commonbusiness.fission.view.FissionShareItemView;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.commonbusiness.util.Utils;
import cn.damai.commonbusiness.view.DmViewPager;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.HavanaProxy;
import cn.damai.login.havana.ILoginListener;
import cn.damai.uikit.banner.transformer.carousel.ScaleInTransformer;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.wxapi.ShareUtil;
import com.ali.user.open.core.Site;
import com.alibaba.security.common.track.model.a;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.kg2;
import tb.nb2;
import tb.rj0;
import tb.t60;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class FissionActivity extends DamaiBaseActivity implements FissionUtil.FissionViewInterface, ILoginListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private LinearLayout cd_fission_reward_layout;
    private String channel;
    private TextView copy_url;
    private String fromWhere;
    private FissionShareItemView icon_friend;
    private FissionShareItemView icon_generate_image;
    private FissionShareItemView icon_weibo;
    private FissionShareItemView icon_wx;
    private String imageUrl;
    private LinearLayout indicatorLayout;
    private List<ImageView> indicators;
    private TextView jubao_desc;
    private long lastClickTime;
    private View mHeaderTitleView;
    private String mainMessage;
    private FissionViewPagerAdapter pagerAdapter;
    private String producturl;
    private String projectName;
    private String sceneType;
    private ScrollView scrollView;
    private String subMessage;
    private TextView subTitlePrefix;
    private TextView subTitleSuffix;
    private TextView tvMyInviteRecord;
    private DMDigitTextView tvRewardAmountTip;
    private TextView tvRewardMainTitle;
    private DMIconFontTextView tvTitleBack;
    private TextView tvrRuleTip;
    private String uniqueIdent;
    private DmViewPager viewPager;
    private int viewPagerCount = 2;
    private FissionViewPagerBean viewPagerBean = new FissionViewPagerBean();
    private FissionInfoBean infoBean = new FissionInfoBean();
    private ArrayList<FissionViewPagerBean> viewPagerResults = new ArrayList<>();
    private int dataLoadCount = 0;
    private String style_type = "word";
    FissionUtil fissionUtil = new FissionUtil();

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements DMRGBUtil.OnFetchColorListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.util.DMRGBUtil.OnFetchColorListener
        public void onFetchColor(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1020674252")) {
                ipChange.ipc$dispatch("-1020674252", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            FissionActivity.this.viewPagerBean.bgColor = i;
            FissionActivity.this.setShareColor(i);
            FissionActivity.this.setDownPartData();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements GenerateImageUtil.OnImageGenerateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ String b;

        b(View view, String str) {
            this.a = view;
            this.b = str;
        }

        @Override // cn.damai.commonbusiness.share.generateimage.GenerateImageUtil.OnImageGenerateListener
        public void onFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-146607417")) {
                ipChange.ipc$dispatch("-146607417", new Object[]{this});
            } else {
                this.a.setClickable(true);
            }
        }

        @Override // cn.damai.commonbusiness.share.generateimage.GenerateImageUtil.OnImageGenerateListener
        public void onSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1916918354")) {
                ipChange.ipc$dispatch("-1916918354", new Object[]{this});
                return;
            }
            this.a.setClickable(true);
            if ("weixin_friend".equals(this.b)) {
                ShareManager.E().m0(FissionActivity.this);
            } else if (Site.WEIBO.equals(this.b)) {
                ShareManager.E().p0(FissionActivity.this);
            }
            ShareManager.E().C();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-762438980")) {
                ipChange.ipc$dispatch("-762438980", new Object[]{this, view});
            } else if (FissionActivity.this.isFastDoubleClick()) {
            } else {
                cn.damai.common.user.c.e().x(rj0.h().k(0, "weixin", FissionActivity.this.style_type, false));
                FissionActivity fissionActivity = FissionActivity.this;
                fissionActivity.toShare(0, fissionActivity.getShareUrl(), FissionActivity.this.subMessage, FissionActivity.this.uniqueIdent, FissionActivity.this.channel);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1348851389")) {
                ipChange.ipc$dispatch("1348851389", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(rj0.h().k(1, "pengyouquan", FissionActivity.this.style_type, false));
            FissionActivity fissionActivity = FissionActivity.this;
            fissionActivity.createPic("weixin_friend", view, fissionActivity, fissionActivity.getShareUrl(), FissionActivity.this.imageUrl, FissionActivity.this.projectName, FissionActivity.this.subMessage, FissionActivity.this.uniqueIdent, FissionActivity.this.getImageUrl());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-834825538")) {
                ipChange.ipc$dispatch("-834825538", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(rj0.h().k(3, Site.WEIBO, FissionActivity.this.style_type, false));
            FissionActivity fissionActivity = FissionActivity.this;
            fissionActivity.createPic(Site.WEIBO, view, fissionActivity, fissionActivity.getShareUrl(), FissionActivity.this.imageUrl, FissionActivity.this.projectName, FissionActivity.this.subMessage, FissionActivity.this.uniqueIdent, FissionActivity.this.getImageUrl());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1276464831")) {
                ipChange.ipc$dispatch("1276464831", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(rj0.h().k(2, "poster", FissionActivity.this.style_type, true));
            FissionActivity fissionActivity = FissionActivity.this;
            fissionActivity.createPic("gen_image", view, fissionActivity, fissionActivity.getShareUrl(), FissionActivity.this.imageUrl, FissionActivity.this.projectName, FissionActivity.this.subMessage, FissionActivity.this.uniqueIdent, FissionActivity.this.getImageUrl());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1204078273")) {
                ipChange.ipc$dispatch("1204078273", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(rj0.h().g("top", "details", Boolean.TRUE));
            Bundle bundle = new Bundle();
            bundle.putString("url", FissionActivity.this.infoBean.shareInfo.detailLinkUrl);
            DMNav.from(FissionActivity.this).withExtras(bundle).toUri(NavUri.b(a.c.d));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class h implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-979598654")) {
                ipChange.ipc$dispatch("-979598654", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(rj0.h().i());
            LoginManager.k().x(FissionActivity.this, new Intent(), 2000);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class i implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1890732405")) {
                ipChange.ipc$dispatch("1890732405", new Object[]{this, dVar});
            } else {
                FissionActivity.this.colorDefault();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class j implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        j() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2022404278")) {
                ipChange.ipc$dispatch("-2022404278", new Object[]{this, eVar});
            } else if (eVar == null || eVar.b == null) {
            } else {
                FissionViewPagerBean fissionViewPagerBean = FissionActivity.this.viewPagerBean;
                Bitmap bitmap = eVar.b;
                fissionViewPagerBean.bitmap = bitmap;
                FissionActivity.this.getColor(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void colorDefault() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "828155680")) {
            ipChange.ipc$dispatch("828155680", new Object[]{this});
            return;
        }
        int parseColor = Color.parseColor("#f5f5f5");
        this.viewPagerBean.bgColor = parseColor;
        setShareColor(parseColor);
        setDownPartData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createPic(String str, View view, Activity activity, String str2, String str3, String str4, String str5, String str6, String str7) {
        FissionInfoBean.ActivityInfo activityInfo;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1449999352")) {
            ipChange.ipc$dispatch("1449999352", new Object[]{this, str, view, activity, str2, str3, str4, str5, str6, str7});
        } else if (activity == null) {
        } else {
            view.setClickable(false);
            DMShareMessage dMShareMessage = new DMShareMessage();
            dMShareMessage.shareImageStyle = GenerateImageUtil.STYLE_GENERATE_NEW_SHARE;
            dMShareMessage.sharePictureUrl = str3;
            dMShareMessage.shareTitle = str4;
            dMShareMessage.shareContent = str5;
            dMShareMessage.shareLink = str2;
            if (getViewPagerBmp() != null) {
                dMShareMessage.businessBitmap = getViewPagerBmp();
                dMShareMessage.projectId = str6;
                dMShareMessage.commentType = "";
                dMShareMessage.fromWhere = this.fromWhere;
                dMShareMessage.bgImageUrl = str7;
                FissionInfoBean fissionInfoBean = this.infoBean;
                if (fissionInfoBean != null && (activityInfo = fissionInfoBean.shareInfo) != null && "2".equals(activityInfo.shareType)) {
                    dMShareMessage.tip = "快来看演出 邀你领优惠";
                } else {
                    dMShareMessage.tip = "来大麦看演出";
                }
                if (!"weixin_friend".equals(str) && !Site.WEIBO.equals(str)) {
                    z = false;
                }
                GenerateImageUtil.q(activity, dMShareMessage, z);
                GenerateImageUtil.G(new b(view, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getColor(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1319232931")) {
            ipChange.ipc$dispatch("-1319232931", new Object[]{this, bitmap});
        } else {
            DMRGBUtil.g(1.0f, bitmap, this.imageUrl, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getImageUrl() {
        FissionInfoBean.ActivityInfo activityInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816690658")) {
            return (String) ipChange.ipc$dispatch("-1816690658", new Object[]{this});
        }
        FissionInfoBean fissionInfoBean = this.infoBean;
        if (fissionInfoBean == null || (activityInfo = fissionInfoBean.shareInfo) == null) {
            return null;
        }
        return activityInfo.bgImageUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getShareUrl() {
        FissionInfoBean.ActivityInfo activityInfo;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956657894")) {
            return (String) ipChange.ipc$dispatch("-1956657894", new Object[]{this});
        }
        FissionInfoBean fissionInfoBean = this.infoBean;
        if (fissionInfoBean != null && (activityInfo = fissionInfoBean.shareInfo) != null && (str = activityInfo.shareUrl) != null) {
            if (!"1".equals(this.channel) && !"3".equals(this.channel)) {
                if ("2".equals(this.channel)) {
                    return this.infoBean.shareInfo.shareUrl + "id=" + this.uniqueIdent;
                }
                return str;
            }
            return this.infoBean.shareInfo.shareUrl + "itemId=" + this.uniqueIdent + "&from=appshare";
        }
        return this.producturl;
    }

    private Bitmap getViewPagerBmp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-8974643")) {
            return (Bitmap) ipChange.ipc$dispatch("-8974643", new Object[]{this});
        }
        int measuredWidth = this.viewPager.getMeasuredWidth();
        int measuredHeight = this.viewPager.getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        this.pagerAdapter.c().draw(new Canvas(createBitmap));
        return Utils.j(createBitmap, measuredWidth * 1.4d, measuredHeight * 1.4d);
    }

    private void initIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1566892147")) {
            ipChange.ipc$dispatch("-1566892147", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.indicators = arrayList;
        arrayList.clear();
        for (int i2 = 0; i2 < this.viewPagerCount; i2++) {
            ImageView imageView = new ImageView(this);
            if (i2 == 0) {
                imageView.setImageResource(R$drawable.cb_pigeonindicator_selected);
            } else {
                imageView.setImageResource(R$drawable.cb_circleindicator_00000_unselected);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(t60.a(this, 6.0f), t60.a(this, 6.0f));
            layoutParams.setMargins(t60.a(this, 5.0f), 0, t60.a(this, 5.0f), 0);
            this.indicatorLayout.addView(imageView, layoutParams);
            this.indicators.add(imageView);
        }
    }

    private void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1639861022")) {
            ipChange.ipc$dispatch("1639861022", new Object[]{this});
            return;
        }
        this.viewPager.setPageMargin(t60.a(this, 15.0f));
        this.viewPager.setOffscreenPageLimit(3);
        this.viewPager.setPageTransformer(false, new ScaleInTransformer(0.9f));
        this.pagerAdapter = new FissionViewPagerAdapter(this);
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: cn.damai.commonbusiness.fission.FissionActivity.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1306916718")) {
                    ipChange2.ipc$dispatch("-1306916718", new Object[]{this, Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f2, int i3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1105413937")) {
                    ipChange2.ipc$dispatch("1105413937", new Object[]{this, Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-763488675")) {
                    ipChange2.ipc$dispatch("-763488675", new Object[]{this, Integer.valueOf(i2)});
                    return;
                }
                cn.damai.common.user.c.e().x(rj0.h().j(i2));
                FissionActivity.this.refreshIndicator(i2);
            }
        });
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1572589134")) {
            ipChange.ipc$dispatch("1572589134", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.scrollView = (ScrollView) findViewById(R$id.cb_fission_scrollview);
        this.mHeaderTitleView = findViewById(R$id.cb_title_bar_space_view);
        this.tvTitleBack = (DMIconFontTextView) findViewById(R$id.cb_title_left_icon);
        this.tvrRuleTip = (TextView) findViewById(R$id.cb_title_text_url);
        this.tvMyInviteRecord = (TextView) findViewById(R$id.cb_my_invite_record);
        this.cd_fission_reward_layout = (LinearLayout) findViewById(R$id.cd_fission_reward_layout);
        this.subTitlePrefix = (TextView) findViewById(R$id.cd_fission_subtitleprefix);
        this.subTitleSuffix = (TextView) findViewById(R$id.cd_fission_subtitlesuffix);
        this.tvRewardAmountTip = (DMDigitTextView) findViewById(R$id.cd_fission_reward_amount);
        this.tvRewardMainTitle = (TextView) findViewById(R$id.cd_fission_reward_main_title);
        this.viewPager = (DmViewPager) findViewById(R$id.cd_fission_viewpager);
        this.indicatorLayout = (LinearLayout) findViewById(R$id.indicator_container);
        this.icon_wx = (FissionShareItemView) findViewById(R$id.icon_wx);
        this.icon_friend = (FissionShareItemView) findViewById(R$id.icon_friend);
        this.icon_weibo = (FissionShareItemView) findViewById(R$id.icon_weibo);
        this.icon_generate_image = (FissionShareItemView) findViewById(R$id.icon_generate_image);
        this.jubao_desc = (TextView) findViewById(R$id.jubao_desc);
        this.copy_url = (TextView) findViewById(R$id.copy_url);
        setStatusBar();
        setListiner();
        initViewPager();
        initIndicator();
        setShareListener();
        setShareColor(Color.parseColor("#f5f6f7"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFastDoubleClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1430419967")) {
            return ((Boolean) ipChange.ipc$dispatch("1430419967", new Object[]{this})).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Log.e("lastClickTime", "long = " + (currentTimeMillis - this.lastClickTime));
        if (currentTimeMillis - this.lastClickTime < 500) {
            this.lastClickTime = currentTimeMillis;
            return true;
        }
        this.lastClickTime = currentTimeMillis;
        return false;
    }

    private void loadImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-430450655")) {
            ipChange.ipc$dispatch("-430450655", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            setDownPartData();
        } else {
            cn.damai.common.image.a.b().e(str).k(new DMRoundedCornersBitmapProcessor(24, 0)).n(new j()).e(new i()).f();
        }
    }

    private void notifAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-136406305")) {
            ipChange.ipc$dispatch("-136406305", new Object[]{this});
            return;
        }
        this.viewPagerResults.clear();
        this.viewPagerResults.add(this.viewPagerBean);
        this.viewPagerResults.add(this.viewPagerBean);
        int a2 = DisplayMetrics.getwidthPixels(t60.b(this)) - (t60.a(this, 68.0f) * 2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.viewPager.getLayoutParams();
        layoutParams.height = t60.a(this, 75.0f) + r1;
        layoutParams.width = a2;
        this.viewPager.setLayoutParams(layoutParams);
        this.pagerAdapter.d(this.viewPagerResults);
        this.pagerAdapter.f(a2);
        this.pagerAdapter.e(r1);
        this.viewPager.setAdapter(this.pagerAdapter);
        this.pagerAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshIndicator(int i2) {
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1591883399")) {
            ipChange.ipc$dispatch("-1591883399", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        while (true) {
            int i4 = this.viewPagerCount;
            if (i3 < i4) {
                if (i2 % i4 == i3) {
                    this.indicators.get(i3).setImageResource(R$drawable.cb_pigeonindicator_selected);
                } else {
                    this.indicators.get(i3).setImageResource(R$drawable.cb_circleindicator_00000_unselected);
                }
                i3++;
            } else {
                viewPagerType(i2);
                return;
            }
        }
    }

    private void requestData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880639213")) {
            ipChange.ipc$dispatch("-880639213", new Object[]{this});
            return;
        }
        this.fissionUtil.i(this);
        FissionUtil fissionUtil = this.fissionUtil;
        fissionUtil.h(this, fissionUtil.f("", "", "", "", "", "", "", this.channel, this.sceneType, "1"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownPartData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1193268501")) {
            ipChange.ipc$dispatch("-1193268501", new Object[]{this});
            return;
        }
        int i2 = this.dataLoadCount + 1;
        this.dataLoadCount = i2;
        if (i2 == 2) {
            notifAdapter();
            this.dataLoadCount = 0;
        }
    }

    private void setListiner() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2007255706")) {
            ipChange.ipc$dispatch("2007255706", new Object[]{this});
            return;
        }
        this.tvrRuleTip.setOnClickListener(this);
        this.copy_url.setOnClickListener(this);
        this.jubao_desc.setOnClickListener(this);
        this.tvTitleBack.setOnClickListener(this);
        setShareListener();
    }

    private void setRewardAmount(FissionInfoBean.ActivityInfo activityInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "462926900")) {
            ipChange.ipc$dispatch("462926900", new Object[]{this, activityInfo});
            return;
        }
        if (activityInfo == null) {
            activityInfo = new FissionInfoBean.ActivityInfo();
        }
        if (TextUtils.isEmpty(activityInfo.subTitlePrefix) && TextUtils.isEmpty(activityInfo.subTitleHighlight) && TextUtils.isEmpty(activityInfo.subTitleSuffix)) {
            this.tvRewardAmountTip.setVisibility(8);
            this.subTitleSuffix.setVisibility(8);
            this.subTitlePrefix.setVisibility(0);
            this.subTitlePrefix.setText(getResources().getString(R$string.damai_fission_subtitle_default));
        } else {
            if (!TextUtils.isEmpty(activityInfo.subTitlePrefix)) {
                this.subTitlePrefix.setVisibility(0);
                this.subTitlePrefix.setText(activityInfo.subTitlePrefix);
            } else {
                this.subTitlePrefix.setVisibility(8);
            }
            if (!TextUtils.isEmpty(activityInfo.subTitleHighlight)) {
                this.tvRewardAmountTip.setText(activityInfo.subTitleHighlight);
                this.tvRewardAmountTip.setVisibility(0);
            } else {
                this.tvRewardAmountTip.setVisibility(8);
            }
            if (!TextUtils.isEmpty(activityInfo.subTitleSuffix)) {
                this.subTitleSuffix.setText(activityInfo.subTitleSuffix);
                this.subTitleSuffix.setVisibility(0);
            } else {
                this.subTitleSuffix.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty(activityInfo.mainTitle)) {
            this.tvRewardMainTitle.setText(activityInfo.mainTitle);
        } else {
            this.tvRewardMainTitle.setText(getResources().getString(R$string.damai_fission_maintitle_default));
        }
    }

    private void setRuleView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1982571381")) {
            ipChange.ipc$dispatch("-1982571381", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.tvrRuleTip.setVisibility(0);
        } else {
            this.tvrRuleTip.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShareColor(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-135866499")) {
            ipChange.ipc$dispatch("-135866499", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.icon_generate_image.update(i2);
        this.icon_friend.update(i2);
        this.icon_wx.update(i2);
        this.icon_weibo.update(i2);
    }

    private void setShareListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-91043155")) {
            ipChange.ipc$dispatch("-91043155", new Object[]{this});
            return;
        }
        this.icon_wx.setListener(new c());
        this.icon_friend.setListener(new d());
        this.icon_weibo.setListener(new e());
        this.icon_generate_image.setListener(new f());
    }

    private void setStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1779435425")) {
            ipChange.ipc$dispatch("-1779435425", new Object[]{this});
            return;
        }
        View findViewById = this.mHeaderTitleView.findViewById(R$id.cb_title_bar_space_view);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.setLayoutParams(new LinearLayout.LayoutParams(-1, kg2.a(this)));
                findViewById.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            return;
        }
        kg2.f(this, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    private void setUpPartData(FissionInfoBean fissionInfoBean) {
        FissionInfoBean.ActivityInfo activityInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807387338")) {
            ipChange.ipc$dispatch("1807387338", new Object[]{this, fissionInfoBean});
        } else if (fissionInfoBean == null || (activityInfo = fissionInfoBean.shareInfo) == null) {
        } else {
            setRuleView(!TextUtils.isEmpty(activityInfo.ruleUrl));
            showMyInviteRecord(fissionInfoBean.userInfo != null);
            setRewardAmount(fissionInfoBean.shareInfo);
        }
    }

    private void showMyInviteRecord(boolean z) {
        FissionInfoBean.ActivityInfo activityInfo;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "10195833")) {
            ipChange.ipc$dispatch("10195833", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        FissionInfoBean fissionInfoBean = this.infoBean;
        if (fissionInfoBean != null && (activityInfo = fissionInfoBean.shareInfo) != null && (fissionInfoBean == null || activityInfo == null || !TextUtils.isEmpty(activityInfo.detailLinkUrl))) {
            if (z) {
                this.tvMyInviteRecord.setOnClickListener(new g());
                str = "明细>";
            } else {
                this.tvMyInviteRecord.setOnClickListener(new h());
                str = "去登录>";
            }
            SpannableString spannableString = new SpannableString("我的邀请记录 " + str);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#30AEFF")), 7, str.length() + 7, 33);
            this.tvMyInviteRecord.setText(spannableString);
            this.tvMyInviteRecord.setVisibility(0);
            return;
        }
        this.tvMyInviteRecord.setVisibility(8);
    }

    private void showReport(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1238468313")) {
            ipChange.ipc$dispatch("-1238468313", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.jubao_desc.setVisibility(0);
        } else {
            this.jubao_desc.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toShare(int i2, String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-149881405")) {
            ipChange.ipc$dispatch("-149881405", new Object[]{this, Integer.valueOf(i2), str, str2, str3, str4});
            return;
        }
        ShareUtil shareUtil = new ShareUtil(this, this.fromWhere);
        shareUtil.initShareData(this.projectName, str2, this.imageUrl, str, null, "", Long.parseLong(str3));
        shareUtil.shareByWchart(i2);
    }

    private void updatePageUT(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1621122991")) {
            ipChange.ipc$dispatch("-1621122991", new Object[]{this, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", String.valueOf(z20.E()));
        hashMap.put("invite_code", str);
        a.b bVar = new a.b();
        bVar.i(rj0.SHARE_PAGE).j(hashMap);
        cn.damai.common.user.c.e().l(this, bVar);
    }

    private void viewPagerType(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "568593967")) {
            ipChange.ipc$dispatch("568593967", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 == 0) {
            this.style_type = "picture";
        } else if (i2 == 1) {
            this.style_type = "word";
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005733606")) {
            ipChange.ipc$dispatch("1005733606", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "882832196") ? ((Integer) ipChange.ipc$dispatch("882832196", new Object[]{this})).intValue() : R$layout.commonbusiness_fission_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-264004425")) {
            ipChange.ipc$dispatch("-264004425", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1776658516")) {
            ipChange.ipc$dispatch("1776658516", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1159035337")) {
            ipChange.ipc$dispatch("1159035337", new Object[]{this});
        } else {
            initViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-995860624")) {
            ipChange.ipc$dispatch("-995860624", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        ShareManager.E().r0(i2, i3, intent);
    }

    public void onBackPresss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-69342744")) {
            ipChange.ipc$dispatch("-69342744", new Object[]{this});
        } else {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "735781743")) {
            ipChange.ipc$dispatch("735781743", new Object[]{this, view});
        } else if (view.getId() == R$id.cb_title_text_url) {
            cn.damai.common.user.c.e().x(rj0.h().g("top", "rule", Boolean.FALSE));
            FissionInfoBean.ActivityInfo activityInfo = this.infoBean.shareInfo;
            if (activityInfo == null || TextUtils.isEmpty(activityInfo.ruleUrl)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", this.infoBean.shareInfo.ruleUrl);
            DMNav.from(this).withExtras(bundle).toUri(NavUri.b(a.c.d));
        } else if (view.getId() == R$id.jubao_desc) {
            cn.damai.common.user.c.e().x(rj0.h().g("bottom", "report", Boolean.TRUE));
            if ("1".equals(this.channel)) {
                ShareManager.E().b0(this, 1, this.uniqueIdent, 1);
            } else if ("2".equals(this.channel)) {
                ShareManager.E().b0(this, 6, this.uniqueIdent, 1);
            }
        } else if (view.getId() == R$id.copy_url) {
            if (this.infoBean == null || this.mContext == null) {
                return;
            }
            cn.damai.common.user.c.e().x(rj0.h().g("bottom", "copy_url", Boolean.FALSE));
            Context context = this.mContext;
            nb2.a(context, getShareUrl());
        } else if (view.getId() == R$id.cb_title_left_icon) {
            onBackPresss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-2037811247")) {
            ipChange.ipc$dispatch("-2037811247", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        HavanaProxy.v().g(this);
        setDamaiUTKeyBuilder(rj0.h().f(rj0.SHARE_PAGE, null));
        if (getIntent() != null) {
            this.imageUrl = getIntent().getStringExtra("imageUrl");
            this.uniqueIdent = getIntent().getStringExtra("uniqueIdent");
            this.projectName = getIntent().getStringExtra("projectName");
            this.mainMessage = getIntent().getStringExtra("mainMessage");
            this.subMessage = getIntent().getStringExtra("subMessage");
            this.channel = getIntent().getStringExtra("channel");
            this.sceneType = getIntent().getStringExtra("sceneType");
            this.producturl = getIntent().getStringExtra("producturl");
            this.fromWhere = "fissionShare";
            FissionViewPagerBean fissionViewPagerBean = this.viewPagerBean;
            fissionViewPagerBean.mainMessage = this.mainMessage;
            fissionViewPagerBean.subMessage = this.subMessage;
            fissionViewPagerBean.imageUrl = this.imageUrl;
            fissionViewPagerBean.channel = this.channel;
        }
        requestData();
        loadImage(this.imageUrl);
        if (!"1".equals(this.channel) && !"2".equals(this.channel)) {
            z = false;
        }
        showReport(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1385335983")) {
            ipChange.ipc$dispatch("-1385335983", new Object[]{this});
            return;
        }
        super.onDestroy();
        HavanaProxy.v().Q(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954760871")) {
            return ((Boolean) ipChange.ipc$dispatch("954760871", new Object[]{this, Integer.valueOf(i2), keyEvent})).booleanValue();
        }
        if (i2 == 4) {
            onBackPresss();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "978546150")) {
            ipChange.ipc$dispatch("978546150", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-194786449")) {
            ipChange.ipc$dispatch("-194786449", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154939288")) {
            ipChange.ipc$dispatch("-154939288", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "105987204")) {
            ipChange.ipc$dispatch("105987204", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1165869189")) {
            ipChange.ipc$dispatch("1165869189", new Object[]{this});
        } else if (TextUtils.isEmpty(z20.E())) {
        } else {
            this.dataLoadCount++;
            requestData();
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2108839125")) {
            ipChange.ipc$dispatch("2108839125", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1829862226")) {
            ipChange.ipc$dispatch("1829862226", new Object[]{this});
        } else {
            super.onResume();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "485741240")) {
            return (String) ipChange.ipc$dispatch("485741240", new Object[]{this});
        }
        return null;
    }

    @Override // cn.damai.commonbusiness.fission.util.FissionUtil.FissionViewInterface
    public void showEmptyPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-708241555")) {
            ipChange.ipc$dispatch("-708241555", new Object[]{this});
            return;
        }
        this.viewPagerBean.chickenSoup = getResources().getString(R$string.damai_fission_chickensoup_default);
        setRewardAmount(null);
        setDownPartData();
        updatePageUT("");
    }

    @Override // cn.damai.commonbusiness.fission.util.FissionUtil.FissionViewInterface
    public void showErrorView(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "778428816")) {
            ipChange.ipc$dispatch("778428816", new Object[]{this, str, str2});
        } else {
            showEmptyPage();
        }
    }

    @Override // cn.damai.commonbusiness.fission.util.FissionUtil.FissionViewInterface
    public void showView(FissionInfoBean fissionInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-864163340")) {
            ipChange.ipc$dispatch("-864163340", new Object[]{this, fissionInfoBean});
            return;
        }
        this.infoBean = fissionInfoBean;
        if (fissionInfoBean.shareInfo == null && fissionInfoBean.userInfo == null) {
            return;
        }
        this.scrollView.setVisibility(0);
        FissionViewPagerBean fissionViewPagerBean = this.viewPagerBean;
        FissionInfoBean fissionInfoBean2 = this.infoBean;
        fissionViewPagerBean.userInfo = fissionInfoBean2.userInfo;
        FissionInfoBean.ActivityInfo activityInfo = fissionInfoBean2.shareInfo;
        if (activityInfo != null) {
            if (TextUtils.isEmpty(activityInfo.chickenSoup)) {
                this.viewPagerBean.chickenSoup = getResources().getString(R$string.damai_fission_chickensoup_default);
            } else {
                this.viewPagerBean.chickenSoup = this.infoBean.shareInfo.chickenSoup;
            }
        } else {
            fissionViewPagerBean.chickenSoup = getResources().getString(R$string.damai_fission_chickensoup_default);
        }
        setUpPartData(this.infoBean);
        setDownPartData();
        FissionInfoBean.UserInfo userInfo = fissionInfoBean.userInfo;
        if (userInfo != null) {
            updatePageUT(userInfo.shareCode);
        } else {
            updatePageUT("");
        }
    }
}
