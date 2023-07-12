package cn.damai.commonbusiness.tab;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import cn.damai.common.DamaiConstants;
import cn.damai.common.badge.DMBadgeListener;
import cn.damai.common.badge.bean.BadgeNodeItem;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.home.bean.TabExtraBean;
import cn.damai.commonbusiness.tab.TabbarLayout;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tb.a30;
import tb.at;
import tb.cb1;
import tb.cb2;
import tb.cs;
import tb.pl;
import tb.sk2;
import tb.uq;
import tb.wu0;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DamaiTabbarManager implements TabbarLayout.TabBarListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TabBar = "TabBar_V2";
    public static final String TabBar_SERVER_DATA = "TabBar_server_data";
    private static final String h = "DamaiTabbarManager";
    private AppCompatActivity a;
    private TabbarLayout b;
    private String c;
    private TabbarLayout.TabBarListener d;
    private sk2 e;
    private DamaiTabViewHelper f;
    private DMBadgeListener g;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements DMBadgeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.common.badge.DMBadgeListener
        public void badgeChanged(String str, BadgeNodeItem badgeNodeItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "858941558")) {
                ipChange.ipc$dispatch("858941558", new Object[]{this, str, badgeNodeItem});
                return;
            }
            if ("DM_USER_MY".equals(str)) {
                if (badgeNodeItem == null || badgeNodeItem.getCount() <= 0) {
                    DamaiTabbarManager.this.i(DamaiConstants.TAB_MINE);
                } else {
                    String str2 = DamaiTabbarManager.h;
                    cb1.b(str2, "count = " + badgeNodeItem.getCount());
                    DamaiTabbarManager.this.t(DamaiConstants.TAB_MINE);
                }
            }
            uq.a().i("DM_USER_MY", DamaiTabbarManager.this.g);
        }

        @Override // cn.damai.common.badge.DMBadgeListener
        public void badgeQueryFail(List<String> list, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "310964670")) {
                ipChange.ipc$dispatch("310964670", new Object[]{this, list, str, str2});
            } else {
                uq.a().i("DM_USER_MY", DamaiTabbarManager.this.g);
            }
        }
    }

    public DamaiTabbarManager(AppCompatActivity appCompatActivity, TabbarLayout tabbarLayout, TabbarLayout.TabBarListener tabBarListener) {
        a30 a30Var = new a30();
        this.e = a30Var;
        this.a = appCompatActivity;
        this.b = tabbarLayout;
        this.d = tabBarListener;
        tabbarLayout.setTabViewFactory(a30Var);
        DamaiTabViewHelper damaiTabViewHelper = new DamaiTabViewHelper(this.a);
        this.f = damaiTabViewHelper;
        damaiTabViewHelper.f(this.b.getContainerLayout());
        k();
        TabbarDataManager.e().c(this);
        if (wu0.e()) {
            at.a(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "421514162")) {
            ipChange.ipc$dispatch("421514162", new Object[]{this, str});
        } else {
            r(str, TabbarLayout.BadgeType.NONE);
        }
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-856245027")) {
            ipChange.ipc$dispatch("-856245027", new Object[]{this});
        } else {
            this.g = new a();
        }
    }

    private void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-778689381")) {
            ipChange.ipc$dispatch("-778689381", new Object[]{this});
        } else {
            this.b.setTabBackGroundPic(this.f.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1103911635")) {
            ipChange.ipc$dispatch("-1103911635", new Object[]{this, str});
        } else {
            r(str, TabbarLayout.BadgeType.POINT);
        }
    }

    public void e(Map<String, TabExtraBean> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "682681007")) {
            ipChange.ipc$dispatch("682681007", new Object[]{this, map});
            return;
        }
        TabbarLayout tabbarLayout = this.b;
        if (tabbarLayout == null || cb2.d(tabbarLayout.getTabViews())) {
            return;
        }
        List<ITabView> tabViews = this.b.getTabViews();
        Set<String> hashSet = map == null ? new HashSet<>() : map.keySet();
        for (ITabView iTabView : tabViews) {
            String tab = iTabView.getTab();
            TabExtraBean tabExtraBean = null;
            if (map != null && hashSet.contains(tab)) {
                tabExtraBean = map.get(tab);
            }
            iTabView.updateTopCoverIcon(tabExtraBean);
        }
    }

    public String f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-727666857") ? (String) ipChange.ipc$dispatch("-727666857", new Object[]{this}) : this.c;
    }

    public Activity g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1628001237") ? (Activity) ipChange.ipc$dispatch("-1628001237", new Object[]{this}) : this.a;
    }

    public DamaiTabViewHelper h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-334671755") ? (DamaiTabViewHelper) ipChange.ipc$dispatch("-334671755", new Object[]{this}) : this.f;
    }

    public void j(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "455004618")) {
            ipChange.ipc$dispatch("455004618", new Object[]{this, str});
            return;
        }
        s(str);
        this.b.setCurrentTab(str);
        this.b.setTabBarListener(this);
        this.b.setUp(this.f.c());
        q();
        e(TabbarDataManager.e().g());
        if (TextUtils.equals(str, DamaiConstants.TAB_HOME)) {
            n();
        } else if (TextUtils.equals(str, DamaiConstants.TAB_MINE)) {
        } else {
            o();
        }
    }

    public void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876979008")) {
            ipChange.ipc$dispatch("1876979008", new Object[]{this});
        } else {
            this.b.invalidatePopView();
        }
    }

    public void m(String str) {
        TabbarLayout tabbarLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1927535727")) {
            ipChange.ipc$dispatch("-1927535727", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str) && (tabbarLayout = this.b) != null) {
            List<ITabView> tabViews = tabbarLayout.getTabViews();
            if (cb2.d(tabViews)) {
                return;
            }
            for (ITabView iTabView : tabViews) {
                if (TextUtils.equals(str, iTabView.getTab())) {
                    View clickView = iTabView.getClickView();
                    if (clickView != null) {
                        clickView.performClick();
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1032150853")) {
            ipChange.ipc$dispatch("1032150853", new Object[]{this});
        } else if (LoginManager.k().q()) {
            uq.a().g("DM_USER_MY", this.g);
            uq.a().d(new ArrayList() { // from class: cn.damai.commonbusiness.tab.DamaiTabbarManager.2
                {
                    add("DM_USER_MY");
                    add(uq.f);
                }
            });
        }
    }

    public void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1586893849")) {
            ipChange.ipc$dispatch("-1586893849", new Object[]{this});
        } else if (LoginManager.k().q()) {
            uq.a().g("DM_USER_MY", this.g);
            uq.a().e("DM_USER_MY");
        }
    }

    @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
    public void onTabClicked(TabItem tabItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1319953982")) {
            ipChange.ipc$dispatch("1319953982", new Object[]{this, tabItem});
            return;
        }
        if (!tabItem.tab.equals(DamaiConstants.TAB_CENTER)) {
            s(tabItem.tab);
        }
        TabbarLayout.TabBarListener tabBarListener = this.d;
        if (tabBarListener != null) {
            tabBarListener.onTabClicked(tabItem);
        }
        Bundle bundle = null;
        if (TextUtils.equals(DamaiConstants.TAB_FIND, tabItem.tab)) {
            TabbarDataManager e = TabbarDataManager.e();
            Bundle makeFindBundleIfNeed = TabExtraBean.makeFindBundleIfNeed(e.f(DamaiConstants.TAB_FIND));
            e.k(DamaiConstants.TAB_FIND);
            bundle = makeFindBundleIfNeed;
        }
        try {
            if (DamaiConstants.TAB_HOME.equals(tabItem.tab)) {
                c.e().x(pl.j().t("首页", 0));
                DMNav.from(this.a).toUri(NavUri.b(cs.n));
                this.a.overridePendingTransition(0, 0);
            } else if (DamaiConstants.TAB_CATEGORY.equals(tabItem.tab)) {
                c.e().x(pl.j().t("全部", 1));
                DMNav.from(this.a).setTransition(0, 0).toUri(NavUri.b(cs.p));
            } else if (DamaiConstants.TAB_FIND.equals(tabItem.tab)) {
                c.e().x(pl.j().t("发现", 2));
                if (bundle != null) {
                    DMNav.from(this.a).setTransition(0, 0).withExtras(bundle).toUri(NavUri.b(cs.PAGE_DISCOVER));
                } else {
                    DMNav.from(this.a).setTransition(0, 0).toUri(NavUri.b(cs.PAGE_DISCOVER));
                }
            } else if (DamaiConstants.TAB_MEMBER.equals(tabItem.tab)) {
                c.e().x(pl.j().t("票夹", 3));
                DMNav.from(this.a).setTransition(0, 0).toUri(NavUri.b("member_ticketwalletlist"));
            } else if (DamaiConstants.TAB_MINE.equals(tabItem.tab)) {
                c.e().x(pl.j().t("我的", 4));
                DMNav.from(this.a).setTransition(0, 0).toUri(cs.m());
            } else if (DamaiConstants.TAB_HUIYUAN.equals(tabItem.tab)) {
                DMNav.from(this.a).setTransition(0, 0).toUri(NavUri.b(cs.q));
            }
        } catch (Throwable th) {
            Log.w("", th);
        }
    }

    @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
    public void onTabLongClicked(TabItem tabItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1048950750")) {
            ipChange.ipc$dispatch("-1048950750", new Object[]{this, tabItem});
            return;
        }
        TabbarLayout.TabBarListener tabBarListener = this.d;
        if (tabBarListener != null) {
            tabBarListener.onTabLongClicked(tabItem);
        }
    }

    @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
    public void onTabReselected(TabItem tabItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-677483003")) {
            ipChange.ipc$dispatch("-677483003", new Object[]{this, tabItem});
            return;
        }
        TabbarLayout.TabBarListener tabBarListener = this.d;
        if (tabBarListener != null) {
            tabBarListener.onTabReselected(tabItem);
        }
    }

    @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
    public void onTabSelected(TabItem tabItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1424599598")) {
            ipChange.ipc$dispatch("-1424599598", new Object[]{this, tabItem});
            return;
        }
        TabbarLayout.TabBarListener tabBarListener = this.d;
        if (tabBarListener != null) {
            tabBarListener.onTabSelected(tabItem);
        }
    }

    public void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1178157299")) {
            ipChange.ipc$dispatch("1178157299", new Object[]{this});
        } else {
            TabbarDataManager.e().j(this);
        }
    }

    public void r(String str, TabbarLayout.BadgeType badgeType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-831558717")) {
            ipChange.ipc$dispatch("-831558717", new Object[]{this, str, badgeType});
        } else {
            this.b.setBadge(str, badgeType, "");
        }
    }

    public void s(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1102247783")) {
            ipChange.ipc$dispatch("1102247783", new Object[]{this, str});
        } else {
            this.c = str;
        }
    }

    public void u(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1846664183")) {
            ipChange.ipc$dispatch("1846664183", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            this.b.setBadge(str, TabbarLayout.BadgeType.POINT, "");
        } else {
            this.b.setBadge(str, TabbarLayout.BadgeType.NONE, "");
        }
        TabbarDataManager.e().onTabbarBadgeChanged(str, z ? TabbarLayout.BadgeType.POINT : TabbarLayout.BadgeType.NONE);
    }
}
