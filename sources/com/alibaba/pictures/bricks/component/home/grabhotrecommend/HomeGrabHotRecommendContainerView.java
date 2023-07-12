package com.alibaba.pictures.bricks.component.home.grabhotrecommend;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$anim;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$raw;
import com.alibaba.pictures.bricks.bean.HomeGrabHotRecoBean;
import com.alibaba.pictures.bricks.bean.TitleNode;
import com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerContract;
import com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerView;
import com.alibaba.pictures.bricks.util.UTUtil;
import com.alibaba.pictures.bricks.view.DMUpMarqueeView;
import com.alibaba.pictures.ut.ClickCat;
import com.alibaba.pictures.ut.DogCat;
import com.alient.onearch.adapter.component.banner.loop.LoopBannerView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.C9796v;
import tb.ap2;
import tb.b41;
import tb.bb2;
import tb.ou0;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeGrabHotRecommendContainerView extends LoopBannerView implements HomeGrabHotRecommendContainerContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ImageView bgLayout;
    @NotNull
    private final View itemView;
    private final LottieAnimationView lottie;
    @NotNull
    private final DMUpMarqueeView marqueeView;
    private String spmc;
    private String spmd;
    private final LinearLayout subTitleView;
    private final ImageView titleIcon;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerView$a  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class animationAnimation$AnimationListenerC3476a implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Animation b;

        animationAnimation$AnimationListenerC3476a(Animation animation) {
            this.b = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2125390653")) {
                ipChange.ipc$dispatch("-2125390653", new Object[]{this, animation});
                return;
            }
            b41.i(animation, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
            View currentView = HomeGrabHotRecommendContainerView.this.marqueeView.getCurrentView();
            View findViewById = currentView.findViewById(R$id.home_grab_content_text);
            b41.h(findViewById, "currentView.findViewById…d.home_grab_content_text)");
            ((TextView) findViewById).startAnimation(this.b);
            Object tag = currentView.getTag();
            b41.g(tag, "null cannot be cast to non-null type com.alibaba.pictures.bricks.bean.TitleNode");
            TitleNode titleNode = (TitleNode) tag;
            HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView = HomeGrabHotRecommendContainerView.this;
            HashMap<String, String> hashMap = new HashMap<>();
            homeGrabHotRecommendContainerView.setTrackInfo(hashMap, titleNode.itemId, titleNode.comboDispatchId);
            UTUtil uTUtil = UTUtil.INSTANCE;
            StringBuilder sb = new StringBuilder();
            String str2 = homeGrabHotRecommendContainerView.spmd;
            if (str2 == null) {
                b41.A("spmd");
                str2 = null;
            }
            sb.append(str2);
            sb.append(titleNode.index);
            String sb2 = sb.toString();
            String str3 = homeGrabHotRecommendContainerView.spmc;
            if (str3 == null) {
                b41.A("spmc");
                str = null;
            } else {
                str = str3;
            }
            P presenter = homeGrabHotRecommendContainerView.getPresenter();
            b41.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerPresent");
            String pageName = ((GenericItem) ((HomeGrabHotRecommendContainerPresent) presenter).getItem()).getPageContext().getPageName();
            if (pageName == null) {
                pageName = "home";
            }
            uTUtil.c(sb2, str, pageName, "1.0", 3000L, hashMap, 2201);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1617672239")) {
                ipChange.ipc$dispatch("-1617672239", new Object[]{this, animation});
            } else {
                b41.i(animation, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "399215452")) {
                ipChange.ipc$dispatch("399215452", new Object[]{this, animation});
            } else {
                b41.i(animation, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeGrabHotRecommendContainerView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        this.bgLayout = (ImageView) view.findViewById(R$id.bricks_hotrecommend_layout);
        this.titleIcon = (ImageView) view.findViewById(R$id.bricks_hotrecommend_title);
        View findViewById = view.findViewById(R$id.hotrecommend_subtitle_content);
        b41.h(findViewById, "itemView.findViewById(R.…commend_subtitle_content)");
        this.marqueeView = (DMUpMarqueeView) findViewById;
        this.subTitleView = (LinearLayout) view.findViewById(R$id.hotrecommend_subtitle);
        this.lottie = (LottieAnimationView) view.findViewById(R$id.bricks_hotrecommend_lottie_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-4$lambda-0  reason: not valid java name */
    public static final void m141bindView$lambda4$lambda0(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2041810218")) {
            ipChange.ipc$dispatch("-2041810218", new Object[]{homeGrabHotRecommendContainerView, successEvent});
            return;
        }
        b41.i(homeGrabHotRecommendContainerView, "this$0");
        Drawable drawable = successEvent.drawable;
        if (drawable == null) {
            homeGrabHotRecommendContainerView.bgLayout.setBackgroundResource(R$drawable.bricks_hotrecommend_bg);
        } else {
            homeGrabHotRecommendContainerView.bgLayout.setBackground(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-4$lambda-1  reason: not valid java name */
    public static final void m142bindView$lambda4$lambda1(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1779024218")) {
            ipChange.ipc$dispatch("-1779024218", new Object[]{homeGrabHotRecommendContainerView, failEvent});
            return;
        }
        b41.i(homeGrabHotRecommendContainerView, "this$0");
        homeGrabHotRecommendContainerView.bgLayout.setBackgroundResource(R$drawable.bricks_hotrecommend_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-4$lambda-2  reason: not valid java name */
    public static final void m143bindView$lambda4$lambda2(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView, HomeGrabHotRecoBean homeGrabHotRecoBean, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "403681297")) {
            ipChange.ipc$dispatch("403681297", new Object[]{homeGrabHotRecommendContainerView, homeGrabHotRecoBean, successEvent});
            return;
        }
        b41.i(homeGrabHotRecommendContainerView, "this$0");
        b41.i(homeGrabHotRecoBean, "$this_data");
        Drawable drawable = successEvent.drawable;
        if (drawable == null) {
            homeGrabHotRecommendContainerView.titleDefaultIcon(homeGrabHotRecoBean.isHotRecommendType());
            return;
        }
        homeGrabHotRecommendContainerView.titleIcon.setImageDrawable(drawable);
        ViewGroup.LayoutParams layoutParams = homeGrabHotRecommendContainerView.titleIcon.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int width = successEvent.bitmap.getWidth();
        s60 s60Var = s60.INSTANCE;
        Context context = homeGrabHotRecommendContainerView.itemView.getContext();
        b41.h(context, "itemView.context");
        layoutParams.width = (width * s60Var.b(context, 14)) / successEvent.bitmap.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-4$lambda-3  reason: not valid java name */
    public static final void m144bindView$lambda4$lambda3(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView, HomeGrabHotRecoBean homeGrabHotRecoBean, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1812785653")) {
            ipChange.ipc$dispatch("-1812785653", new Object[]{homeGrabHotRecommendContainerView, homeGrabHotRecoBean, failEvent});
            return;
        }
        b41.i(homeGrabHotRecommendContainerView, "this$0");
        b41.i(homeGrabHotRecoBean, "$this_data");
        homeGrabHotRecommendContainerView.titleDefaultIcon(homeGrabHotRecoBean.isHotRecommendType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-7  reason: not valid java name */
    public static final void m145bindView$lambda7(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1908298219")) {
            ipChange.ipc$dispatch("1908298219", new Object[]{homeGrabHotRecommendContainerView, view});
            return;
        }
        b41.i(homeGrabHotRecommendContainerView, "this$0");
        homeGrabHotRecommendContainerView.performItemClick();
    }

    private final View createView(TitleNode titleNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1209998336")) {
            return (View) ipChange.ipc$dispatch("-1209998336", new Object[]{this, titleNode});
        }
        View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.bricks_home_grab_flippercontent, (ViewGroup) null);
        b41.h(inflate, "from(itemView.context)\n …rab_flippercontent, null)");
        View findViewById = inflate.findViewById(R$id.home_grab_content_text);
        b41.h(findViewById, "view.findViewById(R.id.home_grab_content_text)");
        ((TextView) findViewById).setText(titleNode.title);
        inflate.setTag(titleNode);
        return inflate;
    }

    private final void initFlipper(List<? extends TitleNode> list) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-788526388")) {
            ipChange.ipc$dispatch("-788526388", new Object[]{this, list});
            return;
        }
        this.marqueeView.setOnItemClickListener(new DMUpMarqueeView.OnItemClickListener() { // from class: tb.ix0
            @Override // com.alibaba.pictures.bricks.view.DMUpMarqueeView.OnItemClickListener
            public final void onItemClick(int i2, View view) {
                HomeGrabHotRecommendContainerView.m146initFlipper$lambda11(HomeGrabHotRecommendContainerView.this, i2, view);
            }
        });
        this.marqueeView.setFlipInterval(4000);
        this.marqueeView.setAnimationDuration(500L);
        ArrayList arrayList = new ArrayList();
        for (TitleNode titleNode : list) {
            if (!TextUtils.isEmpty(titleNode.title)) {
                arrayList.add(createView(titleNode));
                titleNode.index = i;
                i++;
            }
        }
        this.marqueeView.setItems(arrayList);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.itemView.getContext(), R$anim.bricks_scale_boom);
        b41.h(loadAnimation, "loadAnimation(itemView.c…R.anim.bricks_scale_boom)");
        Animation inAnimation = this.marqueeView.getInAnimation();
        if (inAnimation != null) {
            inAnimation.setAnimationListener(new animationAnimation$AnimationListenerC3476a(loadAnimation));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initFlipper$lambda-11  reason: not valid java name */
    public static final void m146initFlipper$lambda11(HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView, int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "630261701")) {
            ipChange.ipc$dispatch("630261701", new Object[]{homeGrabHotRecommendContainerView, Integer.valueOf(i), view});
            return;
        }
        b41.i(homeGrabHotRecommendContainerView, "this$0");
        homeGrabHotRecommendContainerView.performItemClick();
    }

    private final void performItemClick() {
        Object tag;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "951709723")) {
            ipChange.ipc$dispatch("951709723", new Object[]{this});
            return;
        }
        View currentView = this.marqueeView.getCurrentView();
        if (currentView == null || (tag = currentView.getTag()) == null) {
            return;
        }
        TitleNode titleNode = (TitleNode) tag;
        HashMap<String, String> hashMap = new HashMap<>();
        setTrackInfo(hashMap, titleNode.itemId, titleNode.comboDispatchId);
        int i = titleNode.index;
        ClickCat d = DogCat.INSTANCE.d();
        P presenter = getPresenter();
        b41.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerPresent");
        String pageName = ((GenericItem) ((HomeGrabHotRecommendContainerPresent) presenter).getItem()).getPageContext().getPageName();
        if (pageName == null) {
            pageName = "home";
        }
        ClickCat n = d.n(pageName);
        String str = this.spmc;
        String str2 = null;
        if (str == null) {
            b41.A("spmc");
            str = null;
        }
        StringBuilder sb = new StringBuilder();
        String str3 = this.spmd;
        if (str3 == null) {
            b41.A("spmd");
        } else {
            str2 = str3;
        }
        sb.append(str2);
        sb.append(i);
        n.r(str, sb.toString()).o(hashMap).j();
        Action action = new Action();
        action.setActionType(1);
        action.setActionUrl(titleNode.schema);
        NavProviderProxy.getProxy().toUri(this.itemView.getContext(), action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTrackInfo(HashMap<String, String> hashMap, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "675162767")) {
            ipChange.ipc$dispatch("675162767", new Object[]{this, hashMap, str, str2});
            return;
        }
        if (str != null) {
            hashMap.put("item_id", str);
        }
        if (str2 != null) {
            hashMap.put("dispatch_id", str2);
        }
    }

    private final void titleDefaultIcon(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-301995993")) {
            ipChange.ipc$dispatch("-301995993", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.titleIcon.setImageResource(R$drawable.bricks_hotrecommend_title);
        } else {
            this.titleIcon.setImageResource(R$drawable.bricks_grab_title);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerContract.View
    @RequiresApi(21)
    public void bindView(@Nullable JSONObject jSONObject, @Nullable String str) {
        List<TitleNode> list;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "942612717")) {
            ipChange.ipc$dispatch("942612717", new Object[]{this, jSONObject, str});
            return;
        }
        getBanner().setRoundCorners(0.0f);
        getBanner().setAutoTurningTime(DanmakuFactory.MIN_DANMAKU_DURATION);
        getBanner().getViewPager2().setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
        getBanner().getViewPager2().setUserInputEnabled(false);
        final HomeGrabHotRecoBean homeGrabHotRecoBean = (HomeGrabHotRecoBean) ap2.INSTANCE.j(jSONObject, HomeGrabHotRecoBean.class);
        if (homeGrabHotRecoBean != null) {
            JSONObject jSONObject6 = homeGrabHotRecoBean.action;
            String string = (jSONObject6 == null || (jSONObject4 = jSONObject6.getJSONObject("item")) == null || (jSONObject5 = jSONObject4.getJSONObject("trackInfo")) == null) ? null : jSONObject5.getString("spmc");
            if (string == null) {
                string = ou0.GRAB_PAGE;
            } else {
                b41.h(string, "this.action?.getJSONObje…(\"spmc\")?:\"snatch_ticket\"");
            }
            this.spmc = string;
            JSONObject jSONObject7 = homeGrabHotRecoBean.action;
            String string2 = (jSONObject7 == null || (jSONObject2 = jSONObject7.getJSONObject("item")) == null || (jSONObject3 = jSONObject2.getJSONObject("trackInfo")) == null) ? null : jSONObject3.getString("spmd");
            if (string2 == null) {
                string2 = "more_item_";
            } else {
                b41.h(string2, "this.action?.getJSONObje…ing(\"spmd\")?:\"more_item_\"");
            }
            this.spmd = string2;
            ImageLoaderProviderProxy.getProxy().load(homeGrabHotRecoBean.bgPic, new IImageSuccListener() { // from class: tb.lx0
                @Override // com.alient.oneservice.image.IImageSuccListener
                public final void onSuccess(SuccessEvent successEvent) {
                    HomeGrabHotRecommendContainerView.m141bindView$lambda4$lambda0(HomeGrabHotRecommendContainerView.this, successEvent);
                }
            }, new IImageFailListener() { // from class: tb.jx0
                @Override // com.alient.oneservice.image.IImageFailListener
                public final void onFail(FailEvent failEvent) {
                    HomeGrabHotRecommendContainerView.m142bindView$lambda4$lambda1(HomeGrabHotRecommendContainerView.this, failEvent);
                }
            });
            ImageLoaderProviderProxy.getProxy().load(homeGrabHotRecoBean.titlePic, new IImageSuccListener() { // from class: tb.mx0
                @Override // com.alient.oneservice.image.IImageSuccListener
                public final void onSuccess(SuccessEvent successEvent) {
                    HomeGrabHotRecommendContainerView.m143bindView$lambda4$lambda2(HomeGrabHotRecommendContainerView.this, homeGrabHotRecoBean, successEvent);
                }
            }, new IImageFailListener() { // from class: tb.kx0
                @Override // com.alient.oneservice.image.IImageFailListener
                public final void onFail(FailEvent failEvent) {
                    HomeGrabHotRecommendContainerView.m144bindView$lambda4$lambda3(HomeGrabHotRecommendContainerView.this, homeGrabHotRecoBean, failEvent);
                }
            });
            if (homeGrabHotRecoBean.isHotRecommendType()) {
                if (this.lottie.getVisibility() != 8) {
                    this.lottie.setVisibility(8);
                    this.lottie.cancelAnimation();
                }
            } else {
                if (this.lottie.getVisibility() == 8) {
                    this.lottie.setVisibility(0);
                }
                this.lottie.setAnimation(R$raw.bricks_circle_allround);
                this.lottie.playAnimation();
                this.lottie.setRepeatMode(1);
                this.lottie.setRepeatCount(-1);
                if (homeGrabHotRecoBean.isProjectType()) {
                    ViewGroup.LayoutParams layoutParams = this.lottie.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                    if (marginLayoutParams != null) {
                        s60 s60Var = s60.INSTANCE;
                        Context context = this.itemView.getContext();
                        b41.h(context, "itemView.context");
                        marginLayoutParams.leftMargin = s60Var.a(context, -37.5f);
                    }
                } else {
                    ViewGroup.LayoutParams layoutParams2 = this.lottie.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
                    if (marginLayoutParams2 != null) {
                        s60 s60Var2 = s60.INSTANCE;
                        Context context2 = this.itemView.getContext();
                        b41.h(context2, "itemView.context");
                        marginLayoutParams2.leftMargin = s60Var2.a(context2, -36.5f);
                    }
                }
            }
        } else {
            this.bgLayout.setBackgroundResource(R$drawable.bricks_hotrecommend_bg);
            this.titleIcon.setImageResource(R$drawable.bricks_hotrecommend_title);
        }
        if (!bb2.d(homeGrabHotRecoBean != null ? homeGrabHotRecoBean.noticeList : null)) {
            this.subTitleView.setVisibility(0);
            if (homeGrabHotRecoBean != null && (list = homeGrabHotRecoBean.noticeList) != null) {
                initFlipper(list);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: tb.hx0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeGrabHotRecommendContainerView.m145bindView$lambda7(HomeGrabHotRecommendContainerView.this, view);
                }
            });
            return;
        }
        this.subTitleView.setVisibility(8);
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-436235089") ? (View) ipChange.ipc$dispatch("-436235089", new Object[]{this}) : this.itemView;
    }
}
