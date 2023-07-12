package com.alibaba.pictures.bricks.channel.activity;

import android.content.Context;
import android.os.Bundle;
import cn.damai.common.AppConfig;
import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.uikit.view.SimpleTitleLayout;
import com.alibaba.pictures.bricks.fragment.NewChannelFragment;
import com.alibaba.pictures.ut.DogCat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;
import tb.ko;
import tb.mf;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class NewShowCalendarActivity<T extends AbstractC0470a<?, ?>, E extends BaseModel> extends DamaiBaseActivity<T, E> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C3446a Companion = new C3446a(null);
    @NotNull
    public static final String DEFAULT_CALENDAR_H5_ONLINE_URL = "https://m.damai.cn/shows/pages/show-calendar.html";
    @NotNull
    public static final String DEFAULT_CALENDAR_H5_PRE_URL = "https://market.wapa.damai.cn/shows/pages/show-calendar.html";
    @NotNull
    public static final String DEFAULT_CALENDAR_SHARE_IMG_URL = "https://gw.alicdn.com/imgextra/i2/O1CN01xjKPc21xmdhRd4rpp_!!6000000006486-2-tps-500-550.png";
    @NotNull
    private static final String DEFAULT_CALENDAR_URI = "damai://cms_common_second_v2?patternName=dm_calendar_node&patternVersion=1.0&dateType=10&sortType=10";
    @NotNull
    public static final String ORANGE_CONFIG_KEY_CALENDAR_H5 = "calendar_page_share_url";

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.channel.activity.NewShowCalendarActivity$a */
    /* loaded from: classes7.dex */
    public static final class C3446a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3446a() {
        }

        public /* synthetic */ C3446a(k50 k50Var) {
            this();
        }

        public final void a(@NotNull Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1889229448")) {
                ipChange.ipc$dispatch("1889229448", new Object[]{this, context});
                return;
            }
            b41.i(context, "activity");
            DMNav.from(context).toUri(NewShowCalendarActivity.DEFAULT_CALENDAR_URI);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.channel.activity.NewShowCalendarActivity$b */
    /* loaded from: classes7.dex */
    public static final class C3447b implements SimpleTitleLayout.OnBtnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ NewShowCalendarActivity<T, E> a;

        C3447b(NewShowCalendarActivity<T, E> newShowCalendarActivity) {
            this.a = newShowCalendarActivity;
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-437648494")) {
                ipChange.ipc$dispatch("-437648494", new Object[]{this});
            } else {
                this.a.finish();
            }
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "516036878")) {
                ipChange.ipc$dispatch("516036878", new Object[]{this});
                return;
            }
            DogCat.INSTANCE.d().q(mf.CALENDAR_PAGE, "top", "share").j();
            Bundle bundle = new Bundle();
            bundle.putString("title", "大麦演出日历");
            bundle.putString("message", "挑合适时间，选想看演出～");
            bundle.putString("producturl", ko.d().getString(NewShowCalendarActivity.ORANGE_CONFIG_KEY_CALENDAR_H5, AppConfig.g() == AppConfig.EnvMode.online ? NewShowCalendarActivity.DEFAULT_CALENDAR_H5_ONLINE_URL : NewShowCalendarActivity.DEFAULT_CALENDAR_H5_PRE_URL));
            bundle.putString("imageurl", NewShowCalendarActivity.DEFAULT_CALENDAR_SHARE_IMG_URL);
            ShareManager E = ShareManager.E();
            NewShowCalendarActivity<T, E> newShowCalendarActivity = this.a;
            E.O(newShowCalendarActivity, bundle, newShowCalendarActivity.getLayoutId());
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-361518889")) {
            ipChange.ipc$dispatch("-361518889", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1242407245") ? ((Integer) ipChange.ipc$dispatch("-1242407245", new Object[]{this})).intValue() : R$layout.activity_new_show_calendar;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1721917656")) {
            ipChange.ipc$dispatch("-1721917656", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-468978685")) {
            ipChange.ipc$dispatch("-468978685", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1798069434")) {
            ipChange.ipc$dispatch("1798069434", new Object[]{this});
            return;
        }
        C0529c.e().K(this);
        removeHeadTitleView();
        SimpleTitleLayout simpleTitleLayout = (SimpleTitleLayout) findViewById(R$id.channel_id_stl);
        simpleTitleLayout.enableImmersiveMode(this);
        simpleTitleLayout.showShareBtn(true, 1);
        simpleTitleLayout.setAlpha(0.0f);
        simpleTitleLayout.switchMode(true);
        simpleTitleLayout.enableDivider(false);
        simpleTitleLayout.setListener(new C3447b(this));
        NewChannelFragment newChannelFragment = new NewChannelFragment();
        Bundle bundle = new Bundle();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            bundle.putAll(extras);
        }
        newChannelFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R$id.channel_fragment_container, newChannelFragment).commitAllowingStateLoss();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    @NotNull
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-57471001") ? (String) ipChange.ipc$dispatch("-57471001", new Object[]{this}) : "频道页";
    }
}
