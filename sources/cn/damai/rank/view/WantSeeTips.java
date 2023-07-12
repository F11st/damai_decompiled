package cn.damai.rank.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.mine.activity.MineMainActivity;
import cn.damai.rank.view.WantSeeTips;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cs;
import tb.k50;
import tb.q60;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public final class WantSeeTips extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private DMIconFontTextView arrow;
    @NotNull
    private FrameLayout container;
    @NotNull
    private LottieAnimationView lottieView;
    @NotNull
    private TextView openBtn;
    @Nullable
    private a pageSource;
    @NotNull
    private TextView subTitle;
    @Nullable
    private CountDownTimer timer;
    @NotNull
    private TextView title;
    @NotNull
    private View view;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static abstract class a {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private String a;
        @Nullable
        private String b;
        @Nullable
        private String c;
        @Nullable
        private String d;
        @Nullable
        private String e;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.rank.view.WantSeeTips$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0065a extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final C0065a INSTANCE = new C0065a();

            private C0065a() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1386215595")) {
                    return ((Boolean) ipChange.ipc$dispatch("1386215595", new Object[]{this})).booleanValue();
                }
                return false;
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1671521436") ? (String) ipChange.ipc$dispatch("1671521436", new Object[]{this}) : "种草成功，可以去 [我的] 页面找到哦～";
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1615891434") ? (String) ipChange.ipc$dispatch("1615891434", new Object[]{this}) : "已加入 [我的-想看想玩-现场]";
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public static final class b extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final b INSTANCE = new b();

            private b() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public int a() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1491534073") ? ((Integer) ipChange.ipc$dispatch("1491534073", new Object[]{this})).intValue() : q60.a(AppInfoProviderProxy.getAppContext(), 9.0f);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "746930737")) {
                    return ((Boolean) ipChange.ipc$dispatch("746930737", new Object[]{this})).booleanValue();
                }
                return true;
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @Nullable
            public String d() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "287386349") ? (String) ipChange.ipc$dispatch("287386349", new Object[]{this}) : g();
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @Nullable
            public String e() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1628561783") ? (String) ipChange.ipc$dispatch("-1628561783", new Object[]{this}) : f();
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1420453726")) {
                    return (String) ipChange.ipc$dispatch("-1420453726", new Object[]{this});
                }
                String j = j();
                return j == null ? c.INSTANCE.q() ? "没有开启提醒，容易错过重要信息哦～" : "已加入想看想玩，开售时提醒你～" : j;
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1972746844")) {
                    return (String) ipChange.ipc$dispatch("-1972746844", new Object[]{this});
                }
                String k = k();
                return k == null ? "已加入 [我的-想看想玩]" : k;
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean q() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "512544304") ? ((Boolean) ipChange.ipc$dispatch("512544304", new Object[]{this})).booleanValue() : !PermissionsHelper.a(AppInfoProviderProxy.getAppContext());
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public static final class c extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final c INSTANCE = new c();

            private c() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public int a() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "49303685") ? ((Integer) ipChange.ipc$dispatch("49303685", new Object[]{this})).intValue() : q60.a(AppInfoProviderProxy.getAppContext(), 9.0f);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-963838427")) {
                    return ((Boolean) ipChange.ipc$dispatch("-963838427", new Object[]{this})).booleanValue();
                }
                return true;
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-311836778") ? (String) ipChange.ipc$dispatch("-311836778", new Object[]{this}) : q() ? "没有开启提醒，容易错过重要信息哦～" : "已加入想看想玩，开售时提醒你～";
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1302111024") ? (String) ipChange.ipc$dispatch("1302111024", new Object[]{this}) : "已加入 [我的-想看想玩]";
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean q() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "341911844") ? ((Boolean) ipChange.ipc$dispatch("341911844", new Object[]{this})).booleanValue() : !PermissionsHelper.a(AppInfoProviderProxy.getAppContext());
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public static final class d extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final d INSTANCE = new d();

            private d() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-927232063") ? ((Boolean) ipChange.ipc$dispatch("-927232063", new Object[]{this})).booleanValue() : c().length() > 0;
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-716594638")) {
                    return (String) ipChange.ipc$dispatch("-716594638", new Object[]{this});
                }
                if (c().length() > 0) {
                    return c() + "，快去看看吧～";
                }
                return "暂无演出计划，再去逛逛吧～";
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-46324204") ? (String) ipChange.ipc$dispatch("-46324204", new Object[]{this}) : "赞～已收到你的想看";
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public static final class e extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final e INSTANCE = new e();

            private e() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public int a() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1379951201") ? ((Integer) ipChange.ipc$dispatch("-1379951201", new Object[]{this})).intValue() : q60.a(AppInfoProviderProxy.getAppContext(), 9.0f);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1864083637")) {
                    return ((Boolean) ipChange.ipc$dispatch("-1864083637", new Object[]{this})).booleanValue();
                }
                return false;
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "860314428")) {
                    return (String) ipChange.ipc$dispatch("860314428", new Object[]{this});
                }
                String j = j();
                return j == null ? "" : j;
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-600893110")) {
                    return (String) ipChange.ipc$dispatch("-600893110", new Object[]{this});
                }
                String k = k();
                return k == null ? "" : k;
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public static final class f extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final f INSTANCE = new f();

            private f() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "563608833")) {
                    return ((Boolean) ipChange.ipc$dispatch("563608833", new Object[]{this})).booleanValue();
                }
                return true;
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "626868082") ? (String) ipChange.ipc$dispatch("626868082", new Object[]{this}) : "上榜演出非常抢手，记得及时购票哦～";
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-791637804") ? (String) ipChange.ipc$dispatch("-791637804", new Object[]{this}) : "已加入 [我的-想看想玩]";
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public static final class g extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final g INSTANCE = new g();

            private g() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "591158248")) {
                    return ((Boolean) ipChange.ipc$dispatch("591158248", new Object[]{this})).booleanValue();
                }
                return true;
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1432071527") ? (String) ipChange.ipc$dispatch("-1432071527", new Object[]{this}) : "上榜演出非常抢手，记得及时购票哦～";
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-322722035") ? (String) ipChange.ipc$dispatch("-322722035", new Object[]{this}) : "已加入 [我的-想看想玩-合辑]";
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public static final class h extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final h INSTANCE = new h();

            private h() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-880918080")) {
                    return ((Boolean) ipChange.ipc$dispatch("-880918080", new Object[]{this})).booleanValue();
                }
                return true;
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "366572145") ? (String) ipChange.ipc$dispatch("366572145", new Object[]{this}) : "上榜演出非常抢手，记得及时购票哦～";
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1760450101") ? (String) ipChange.ipc$dispatch("1760450101", new Object[]{this}) : "已加入 [我的-想看想玩]";
            }
        }

        private a() {
            this.a = "";
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        public int a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "89441957") ? ((Integer) ipChange.ipc$dispatch("89441957", new Object[]{this})).intValue() : q60.a(AppInfoProviderProxy.getAppContext(), 20.0f);
        }

        public abstract boolean b();

        @NotNull
        public final String c() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "57413318") ? (String) ipChange.ipc$dispatch("57413318", new Object[]{this}) : this.a;
        }

        @Nullable
        public String d() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "855479193") ? (String) ipChange.ipc$dispatch("855479193", new Object[]{this}) : "";
        }

        @Nullable
        public String e() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1194594211") ? (String) ipChange.ipc$dispatch("-1194594211", new Object[]{this}) : "";
        }

        @Nullable
        public final String f() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2097963464") ? (String) ipChange.ipc$dispatch("2097963464", new Object[]{this}) : this.d;
        }

        @Nullable
        public final String g() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1379008863") ? (String) ipChange.ipc$dispatch("1379008863", new Object[]{this}) : this.e;
        }

        @NotNull
        public abstract String h();

        @NotNull
        public abstract String i();

        @Nullable
        public final String j() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1003299366") ? (String) ipChange.ipc$dispatch("1003299366", new Object[]{this}) : this.c;
        }

        @Nullable
        public final String k() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1424411296") ? (String) ipChange.ipc$dispatch("1424411296", new Object[]{this}) : this.b;
        }

        public final void l(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-520138384")) {
                ipChange.ipc$dispatch("-520138384", new Object[]{this, str});
                return;
            }
            b41.i(str, "<set-?>");
            this.a = str;
        }

        public final void m(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1352846930")) {
                ipChange.ipc$dispatch("-1352846930", new Object[]{this, str});
            } else {
                this.d = str;
            }
        }

        public final void n(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1595490209")) {
                ipChange.ipc$dispatch("-1595490209", new Object[]{this, str});
            } else {
                this.e = str;
            }
        }

        public final void o(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1435390328")) {
                ipChange.ipc$dispatch("1435390328", new Object[]{this, str});
            } else {
                this.c = str;
            }
        }

        public final void p(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-758127658")) {
                ipChange.ipc$dispatch("-758127658", new Object[]{this, str});
            } else {
                this.b = str;
            }
        }

        public boolean q() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "542215940")) {
                return ((Boolean) ipChange.ipc$dispatch("542215940", new Object[]{this})).booleanValue();
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static final class b extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
            super(5500L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1766882878")) {
                ipChange.ipc$dispatch("1766882878", new Object[]{this});
                return;
            }
            WantSeeTips.this.hideAnim();
            WantSeeTips.this.view.setVisibility(8);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-658968240")) {
                ipChange.ipc$dispatch("-658968240", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeTips(@NotNull Context context) {
        this(context, null, 0, 6, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeTips(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeTips(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_rank_want_see_tip, (ViewGroup) this, true);
        b41.h(inflate, "from(context).inflate(R.…want_see_tip, this, true)");
        this.view = inflate;
        ((RelativeLayout) inflate.findViewById(R$id.want_see_bottombar_tip_bg)).setOnClickListener(new View.OnClickListener() { // from class: tb.p03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WantSeeTips.m75_init_$lambda0(WantSeeTips.this, context, view);
            }
        });
        ((DMIconFontTextView) this.view.findViewById(R$id.want_see_bottombar_tip_close)).setOnClickListener(new View.OnClickListener() { // from class: tb.o03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WantSeeTips.m76_init_$lambda1(WantSeeTips.this, view);
            }
        });
        View findViewById = this.view.findViewById(R$id.fl_want_see_tips_container);
        b41.h(findViewById, "view.findViewById(R.id.fl_want_see_tips_container)");
        this.container = (FrameLayout) findViewById;
        View findViewById2 = this.view.findViewById(R$id.want_see__bottombar_tip_texttop);
        b41.h(findViewById2, "view.findViewById(R.id.w…e__bottombar_tip_texttop)");
        this.title = (TextView) findViewById2;
        View findViewById3 = this.view.findViewById(R$id.want_see__bottombar_tip_subtitle);
        b41.h(findViewById3, "view.findViewById(R.id.w…__bottombar_tip_subtitle)");
        this.subTitle = (TextView) findViewById3;
        View findViewById4 = this.view.findViewById(R$id.want_see_bottombar_tip_arrow);
        b41.h(findViewById4, "view.findViewById(R.id.w…_see_bottombar_tip_arrow)");
        this.arrow = (DMIconFontTextView) findViewById4;
        View findViewById5 = this.view.findViewById(R$id.tv_open_notification);
        b41.h(findViewById5, "view.findViewById(R.id.tv_open_notification)");
        this.openBtn = (TextView) findViewById5;
        View findViewById6 = this.view.findViewById(R$id.live_icon);
        b41.h(findViewById6, "view.findViewById(R.id.live_icon)");
        this.lottieView = (LottieAnimationView) findViewById6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m75_init_$lambda0(WantSeeTips wantSeeTips, Context context, View view) {
        boolean s;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "420586718")) {
            ipChange.ipc$dispatch("420586718", new Object[]{wantSeeTips, context, view});
            return;
        }
        b41.i(wantSeeTips, "this$0");
        b41.i(context, "$context");
        a aVar = wantSeeTips.pageSource;
        if (b41.d(aVar, a.h.INSTANCE) ? true : b41.d(aVar, a.f.INSTANCE)) {
            wantSeeTips.cancel();
            DMNav.from(context).setTransition(0, 0).toUri(cs.m().d("key_want_see_tips_page_name", "WantedPage").c(MineMainActivity.KEY_WANT_SEE_SUB_TAB_INDEX, 1));
        } else if (b41.d(aVar, a.c.INSTANCE)) {
            wantSeeTips.cancel();
            a aVar2 = wantSeeTips.pageSource;
            if ((aVar2 == null || !aVar2.q()) ? false : false) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:" + context.getPackageName()));
                context.startActivity(intent);
                return;
            }
            DMNav.from(context).setTransition(0, 0).toUri(cs.m().d("key_want_see_tips_page_name", "WantedPage"));
        } else {
            if (b41.d(aVar, a.b.INSTANCE)) {
                wantSeeTips.cancel();
                a aVar3 = wantSeeTips.pageSource;
                if (aVar3 != null && aVar3.q()) {
                    Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent2.setData(Uri.parse("package:" + context.getPackageName()));
                    context.startActivity(intent2);
                    return;
                }
                a aVar4 = wantSeeTips.pageSource;
                String g = aVar4 != null ? aVar4.g() : null;
                if (g != null) {
                    s = o.s(g);
                    if (!s) {
                        z = false;
                    }
                }
                if (!z) {
                    DMNav transition = DMNav.from(context).setTransition(0, 0);
                    a aVar5 = wantSeeTips.pageSource;
                    transition.toUri(aVar5 != null ? aVar5.d() : null);
                    return;
                }
                DMNav.from(context).setTransition(0, 0).toUri(cs.m().d("key_want_see_tips_page_name", "WantedPage"));
            } else if (b41.d(aVar, a.g.INSTANCE)) {
                wantSeeTips.cancel();
                DMNav.from(context).setTransition(0, 0).toUri(cs.m().d("key_want_see_tips_page_name", "WantedPage").c(MineMainActivity.KEY_WANT_SEE_SUB_TAB_INDEX, 4));
            } else if (b41.d(aVar, a.d.INSTANCE)) {
                a aVar6 = wantSeeTips.pageSource;
                if ((aVar6 == null || !aVar6.b()) ? false : false) {
                    wantSeeTips.cancel();
                    a aVar7 = wantSeeTips.pageSource;
                    xr.c("ip_drama_want_see_tips_click", aVar7 != null ? aVar7.c() : null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m76_init_$lambda1(WantSeeTips wantSeeTips, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1187941055")) {
            ipChange.ipc$dispatch("1187941055", new Object[]{wantSeeTips, view});
            return;
        }
        b41.i(wantSeeTips, "this$0");
        CountDownTimer countDownTimer = wantSeeTips.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        wantSeeTips.view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cancel$lambda-4  reason: not valid java name */
    public static final void m77cancel$lambda4(WantSeeTips wantSeeTips) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "208937850")) {
            ipChange.ipc$dispatch("208937850", new Object[]{wantSeeTips});
            return;
        }
        b41.i(wantSeeTips, "this$0");
        wantSeeTips.view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467961403")) {
            ipChange.ipc$dispatch("467961403", new Object[]{this});
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        translateAnimation.setDuration(500L);
        startAnimation(translateAnimation);
    }

    private final void updateUI(a aVar) {
        boolean s;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1686289029")) {
            ipChange.ipc$dispatch("-1686289029", new Object[]{this, aVar});
            return;
        }
        this.title.setText(aVar.i());
        this.subTitle.setText(aVar.h());
        this.arrow.setVisibility(aVar.b() ? 0 : 8);
        this.container.setPadding(0, 0, 0, aVar.a());
        this.openBtn.setVisibility(aVar.q() ? 0 : 8);
        String e = aVar.e();
        if (e != null) {
            s = o.s(e);
            if (!s) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        this.lottieView.setAnimationFromUrl(aVar.e());
    }

    public final void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1434821868")) {
            ipChange.ipc$dispatch("-1434821868", new Object[]{this});
        } else {
            cancel(100L);
        }
    }

    public final void setPageSource(@NotNull a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1277589636")) {
            ipChange.ipc$dispatch("-1277589636", new Object[]{this, aVar});
            return;
        }
        b41.i(aVar, "pageSource");
        this.pageSource = aVar;
        updateUI(aVar);
    }

    public final void showAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "976531488")) {
            ipChange.ipc$dispatch("976531488", new Object[]{this});
            return;
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(500L);
        startAnimation(translateAnimation);
        this.view.setVisibility(0);
        this.timer = new b().start();
    }

    public final void updateSubTitle(@NotNull a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "339044351")) {
            ipChange.ipc$dispatch("339044351", new Object[]{this, aVar});
            return;
        }
        b41.i(aVar, "pageSource");
        this.subTitle.setText(aVar.h());
    }

    public final void cancel(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529774544")) {
            ipChange.ipc$dispatch("-1529774544", new Object[]{this, Long.valueOf(j)});
            return;
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.view.postDelayed(new Runnable() { // from class: tb.q03
            @Override // java.lang.Runnable
            public final void run() {
                WantSeeTips.m77cancel$lambda4(WantSeeTips.this);
            }
        }, j);
    }

    public /* synthetic */ WantSeeTips(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
