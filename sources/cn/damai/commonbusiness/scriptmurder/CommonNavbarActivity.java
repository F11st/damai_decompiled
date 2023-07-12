package cn.damai.commonbusiness.scriptmurder;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity;
import cn.damai.commonbusiness.view.AttentionView;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.kg2;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public abstract class CommonNavbarActivity extends SimpleBaseActivity implements INavStatusBarFeature {
    private static transient /* synthetic */ IpChange $ipChange;
    public Action actionAuth;
    public Action actionFollow;
    public Action actionShare;
    private AttentionView attentionView;

    private final void initTranslucentStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1027146659")) {
            ipChange.ipc$dispatch("1027146659", new Object[]{this});
            return;
        }
        Window window = getWindow();
        window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(1024);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m14onCreate$lambda0(CommonNavbarActivity commonNavbarActivity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-648226549")) {
            ipChange.ipc$dispatch("-648226549", new Object[]{commonNavbarActivity, view});
            return;
        }
        b41.i(commonNavbarActivity, "this$0");
        commonNavbarActivity.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m15onCreate$lambda1(CommonNavbarActivity commonNavbarActivity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "135152426")) {
            ipChange.ipc$dispatch("135152426", new Object[]{commonNavbarActivity, view});
            return;
        }
        b41.i(commonNavbarActivity, "this$0");
        commonNavbarActivity.share();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m16onCreate$lambda2(CommonNavbarActivity commonNavbarActivity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "918531401")) {
            ipChange.ipc$dispatch("918531401", new Object[]{commonNavbarActivity, view});
            return;
        }
        b41.i(commonNavbarActivity, "this$0");
        commonNavbarActivity.report();
    }

    public abstract void addFragment();

    public abstract void addUtPage();

    @NotNull
    public Action getActionAuth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "268414236")) {
            return (Action) ipChange.ipc$dispatch("268414236", new Object[]{this});
        }
        Action action = this.actionAuth;
        if (action != null) {
            return action;
        }
        b41.A("actionAuth");
        return null;
    }

    @NotNull
    public Action getActionFollow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1372167717")) {
            return (Action) ipChange.ipc$dispatch("1372167717", new Object[]{this});
        }
        Action action = this.actionFollow;
        if (action != null) {
            return action;
        }
        b41.A("actionFollow");
        return null;
    }

    @NotNull
    public Action getActionShare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-279385873")) {
            return (Action) ipChange.ipc$dispatch("-279385873", new Object[]{this});
        }
        Action action = this.actionShare;
        if (action != null) {
            return action;
        }
        b41.A("actionShare");
        return null;
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-443915097") ? ((Integer) ipChange.ipc$dispatch("-443915097", new Object[]{this})).intValue() : R$layout.activity_common_nav_bar;
    }

    public void initAttentionView(@NotNull String str, int i, @NotNull String str2) {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-885985881")) {
            ipChange.ipc$dispatch("-885985881", new Object[]{this, str, Integer.valueOf(i), str2});
            return;
        }
        b41.i(str, "id");
        b41.i(str2, "type");
        View findViewById = findViewById(R$id.title_navbar_attention);
        b41.g(findViewById, "null cannot be cast to non-null type cn.damai.commonbusiness.view.AttentionView");
        AttentionView attentionView = (AttentionView) findViewById;
        this.attentionView = attentionView;
        AttentionView attentionView2 = null;
        if (attentionView == null) {
            b41.A("attentionView");
            attentionView = null;
        }
        attentionView.setInitParams(str, str2);
        AttentionView attentionView3 = this.attentionView;
        if (attentionView3 == null) {
            b41.A("attentionView");
            attentionView3 = null;
        }
        attentionView3.setVisibility(0);
        AttentionView attentionView4 = this.attentionView;
        if (attentionView4 == null) {
            b41.A("attentionView");
            attentionView4 = null;
        }
        attentionView4.setState(i);
        AttentionView attentionView5 = this.attentionView;
        if (attentionView5 == null) {
            b41.A("attentionView");
            attentionView5 = null;
        }
        attentionView5.setPage("venue_new");
        AttentionView attentionView6 = this.attentionView;
        if (attentionView6 == null) {
            b41.A("attentionView");
            attentionView6 = null;
        }
        attentionView6.setModule("top");
        if (this.actionFollow == null || (trackInfo = getActionFollow().getTrackInfo()) == null) {
            return;
        }
        b41.h(trackInfo, "trackInfo");
        AttentionView attentionView7 = this.attentionView;
        if (attentionView7 == null) {
            b41.A("attentionView");
            attentionView7 = null;
        }
        attentionView7.setPage(trackInfo.getSpmb());
        AttentionView attentionView8 = this.attentionView;
        if (attentionView8 == null) {
            b41.A("attentionView");
            attentionView8 = null;
        }
        attentionView8.setModule(trackInfo.getSpmc());
        AttentionView attentionView9 = this.attentionView;
        if (attentionView9 == null) {
            b41.A("attentionView");
        } else {
            attentionView2 = attentionView9;
        }
        attentionView2.setArgsMap(trackInfo.getArgs());
    }

    public abstract void initBaseInfo(@NotNull Object obj);

    public void initPageAction(@NotNull Object obj) {
        Object obj2;
        Object obj3;
        Object obj4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-146492894")) {
            ipChange.ipc$dispatch("-146492894", new Object[]{this, obj});
            return;
        }
        b41.i(obj, "bean");
        boolean z = obj instanceof HashMap;
        HashMap hashMap = z ? (HashMap) obj : null;
        if (hashMap != null && (obj4 = hashMap.get("report")) != null) {
            Action action = obj4 instanceof Action ? (Action) obj4 : null;
            if (action != null) {
                setActionAuth(action);
                findViewById(R$id.title_navbar_report).setVisibility(0);
            }
        }
        HashMap hashMap2 = z ? (HashMap) obj : null;
        if (hashMap2 != null && (obj3 = hashMap2.get("share")) != null) {
            Action action2 = obj3 instanceof Action ? (Action) obj3 : null;
            if (action2 != null) {
                setActionShare(action2);
                findViewById(R$id.title_navbar_share).setVisibility(0);
            }
        }
        HashMap hashMap3 = z ? (HashMap) obj : null;
        if (hashMap3 == null || (obj2 = hashMap3.get(StarFragment.KEY_FOLLOW)) == null) {
            return;
        }
        Action action3 = obj2 instanceof Action ? (Action) obj2 : null;
        if (action3 != null) {
            setActionFollow(action3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "774095668")) {
            ipChange.ipc$dispatch("774095668", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(getLayoutId());
        setImmersionStyle();
        addFragment();
        addUtPage();
        c.e().K(this);
        View findViewById = findViewById(R$id.common_navbar_back);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: tb.il
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonNavbarActivity.m14onCreate$lambda0(CommonNavbarActivity.this, view);
                }
            });
        }
        View findViewById2 = findViewById(R$id.title_navbar_share);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: tb.hl
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonNavbarActivity.m15onCreate$lambda1(CommonNavbarActivity.this, view);
                }
            });
        }
        View findViewById3 = findViewById(R$id.title_navbar_report);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new View.OnClickListener() { // from class: tb.gl
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonNavbarActivity.m16onCreate$lambda2(CommonNavbarActivity.this, view);
                }
            });
        }
    }

    @Override // cn.damai.commonbusiness.scriptmurder.INavStatusBarFeature
    public void onHeaderInfoUpdate(@NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-870329036")) {
            ipChange.ipc$dispatch("-870329036", new Object[]{this, obj});
            return;
        }
        b41.i(obj, "bean");
        initPageAction(obj);
        initBaseInfo(obj);
    }

    public abstract void onShareClick();

    public void report() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295322873")) {
            ipChange.ipc$dispatch("-295322873", new Object[]{this});
        } else if (this.actionAuth != null) {
            Action actionAuth = getActionAuth();
            DMNav.from(this).toUri(actionAuth.getActionUrl());
            TrackInfo trackInfo = actionAuth.getTrackInfo();
            if (trackInfo != null) {
                b41.h(trackInfo, "trackInfo");
                c.e().x(new a.b().i(trackInfo.getSpmb()).f(trackInfo.getSpmc()).l(trackInfo.getSpmd()).g(true).j(trackInfo.getArgs()));
            }
        }
    }

    public void setActionAuth(@NotNull Action action) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "935475664")) {
            ipChange.ipc$dispatch("935475664", new Object[]{this, action});
            return;
        }
        b41.i(action, "<set-?>");
        this.actionAuth = action;
    }

    public void setActionFollow(@NotNull Action action) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "23715047")) {
            ipChange.ipc$dispatch("23715047", new Object[]{this, action});
            return;
        }
        b41.i(action, "<set-?>");
        this.actionFollow = action;
    }

    public void setActionShare(@NotNull Action action) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "438440949")) {
            ipChange.ipc$dispatch("438440949", new Object[]{this, action});
            return;
        }
        b41.i(action, "<set-?>");
        this.actionShare = action;
    }

    @Override // cn.damai.commonbusiness.scriptmurder.INavStatusBarFeature
    public void setDarkStatusBarFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "664574180")) {
            ipChange.ipc$dispatch("664574180", new Object[]{this});
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(9216);
        View findViewById = findViewById(R$id.common_navbar_back);
        b41.g(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(ContextCompat.getColor(this, R$color.color_3C3F44));
    }

    public void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1873935897")) {
            ipChange.ipc$dispatch("-1873935897", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar_gap);
        if (findViewById != null) {
            findViewById.getLayoutParams().height = kg2.a(this);
            findViewById.setVisibility(0);
        }
        View findViewById2 = findViewById(R$id.nav_bar);
        ViewGroup.LayoutParams layoutParams = findViewById2 != null ? findViewById2.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = findViewById.getLayoutParams().height + t60.a(this, 43.0f);
        }
        initTranslucentStatusBar();
        setLightStatusBarFontColor();
    }

    @Override // cn.damai.commonbusiness.scriptmurder.INavStatusBarFeature
    public void setLightStatusBarFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-720344876")) {
            ipChange.ipc$dispatch("-720344876", new Object[]{this});
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(1024);
        View findViewById = findViewById(R$id.common_navbar_back);
        b41.g(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(ContextCompat.getColor(this, R$color.white));
    }

    @Override // cn.damai.commonbusiness.scriptmurder.INavStatusBarFeature
    public void setNavBarColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1497726649")) {
            ipChange.ipc$dispatch("1497726649", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        View findViewById = findViewById(R$id.nav_bar);
        if (findViewById != null) {
            findViewById.setBackgroundColor(i);
        }
    }

    @Override // cn.damai.commonbusiness.scriptmurder.INavStatusBarFeature
    public void setNavBarTitle(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1938303231")) {
            ipChange.ipc$dispatch("1938303231", new Object[]{this, str});
            return;
        }
        b41.i(str, "title");
        View findViewById = findViewById(R$id.main_title);
        TextView textView = findViewById instanceof TextView ? (TextView) findViewById : null;
        if (textView != null) {
            textView.setVisibility(str.length() == 0 ? 8 : 0);
            textView.setText(str);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    @NotNull
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-262169893") ? (String) ipChange.ipc$dispatch("-262169893", new Object[]{this}) : "";
    }

    public void share() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890457904")) {
            ipChange.ipc$dispatch("1890457904", new Object[]{this});
            return;
        }
        onShareClick();
        shareUt();
    }

    public final void shareUt() {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2629457")) {
            ipChange.ipc$dispatch("2629457", new Object[]{this});
        } else if (this.actionShare == null || (trackInfo = getActionShare().getTrackInfo()) == null) {
        } else {
            b41.h(trackInfo, "trackInfo");
            c e = c.e();
            a.b i = new a.b().i(trackInfo.getSpmb());
            String spmc = trackInfo.getSpmc();
            if (spmc == null) {
                spmc = "top";
            } else {
                b41.h(spmc, "info.spmc ?: \"top\"");
            }
            a.b f = i.f(spmc);
            String spmd = trackInfo.getSpmd();
            if (spmd == null) {
                spmd = "share";
            } else {
                b41.h(spmd, "info.spmd ?: \"share\"");
            }
            e.x(f.l(spmd).g(false).j(trackInfo.getArgs()));
        }
    }
}
