package cn.damai.rank.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.wannasee.WantSeePosterTipsMarkRequest;
import cn.damai.rank.view.WantSeePosterTips;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.image.C2497a;
import cn.damai.uikit.image.IImageLoader;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.uikit.view.SeeAnimateView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cc0;
import tb.d23;
import tb.dc0;
import tb.gb;
import tb.k50;
import tb.q60;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public final class WantSeePosterTips extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C1554a Companion = new C1554a(null);
    private static boolean wantSeePosterTipsShown;
    @NotNull
    private DMIconFontTextView arrow;
    @NotNull
    private final TranslateAnimation arrowAnimation;
    @Nullable
    private ActionListener listener;
    @Nullable
    private AbstractC1555b pageSource;
    @NotNull
    private LinearLayout parentTitle;
    @NotNull
    private RoundImageView poster;
    @Nullable
    private Long projectId;
    private long startTime;
    @NotNull
    private TextView subTitle;
    @Nullable
    private CountDownTimer timer;
    @NotNull
    private TextView title;
    @NotNull
    private TextView titleSuffix;
    @NotNull
    private View view;
    @NotNull
    private SeeAnimateView wantSeeView;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface ActionListener {
        void click();

        void hide(long j);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.rank.view.WantSeePosterTips$a */
    /* loaded from: classes15.dex */
    public static final class C1554a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C1554a() {
        }

        public /* synthetic */ C1554a(k50 k50Var) {
            this();
        }

        public final boolean a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "682175308") ? ((Boolean) ipChange.ipc$dispatch("682175308", new Object[]{this})).booleanValue() : WantSeePosterTips.wantSeePosterTipsShown;
        }

        public final void b(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-600070504")) {
                ipChange.ipc$dispatch("-600070504", new Object[]{this, Boolean.valueOf(z)});
            } else {
                WantSeePosterTips.wantSeePosterTipsShown = z;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.rank.view.WantSeePosterTips$b */
    /* loaded from: classes15.dex */
    public static abstract class AbstractC1555b {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private WantSeeIconUpdate a;
        @Nullable
        private String b;
        @Nullable
        private String c;
        @Nullable
        private String d;
        @Nullable
        private String e;
        @Nullable
        private String f;
        @Nullable
        private Integer g;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.rank.view.WantSeePosterTips$b$a */
        /* loaded from: classes6.dex */
        public static final class C1556a extends AbstractC1555b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final C1556a INSTANCE = new C1556a();

            private C1556a() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            public boolean a() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "835714894")) {
                    return ((Boolean) ipChange.ipc$dispatch("835714894", new Object[]{this})).booleanValue();
                }
                return false;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-929552257")) {
                    return (String) ipChange.ipc$dispatch("-929552257", new Object[]{this});
                }
                String m = m();
                return m == null ? "" : m;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            @NotNull
            public String g() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1177815783")) {
                    return (String) ipChange.ipc$dispatch("1177815783", new Object[]{this});
                }
                String n = n();
                return n == null ? "" : n;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            public int h() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2061188809")) {
                    return ((Integer) ipChange.ipc$dispatch("-2061188809", new Object[]{this})).intValue();
                }
                return 60;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            public boolean i() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-113794882")) {
                    return ((Boolean) ipChange.ipc$dispatch("-113794882", new Object[]{this})).booleanValue();
                }
                return false;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.rank.view.WantSeePosterTips$b$b */
        /* loaded from: classes6.dex */
        public static final class C1557b extends AbstractC1555b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final C1557b INSTANCE = new C1557b();

            private C1557b() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            public boolean a() {
                IpChange ipChange = $ipChange;
                boolean z = false;
                if (AndroidInstantRuntime.support(ipChange, "340042659")) {
                    return ((Boolean) ipChange.ipc$dispatch("340042659", new Object[]{this})).booleanValue();
                }
                String b = b();
                return !((b == null || b.length() == 0) ? true : true);
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-432127596")) {
                    return (String) ipChange.ipc$dispatch("-432127596", new Object[]{this});
                }
                String m = m();
                return m == null ? "" : m;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            @NotNull
            public String g() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "80843250")) {
                    return (String) ipChange.ipc$dispatch("80843250", new Object[]{this});
                }
                String n = n();
                return n == null ? "" : n;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            public int h() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1991476034")) {
                    return ((Integer) ipChange.ipc$dispatch("1991476034", new Object[]{this})).intValue();
                }
                return 30;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            public boolean i() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-955158903")) {
                    return ((Boolean) ipChange.ipc$dispatch("-955158903", new Object[]{this})).booleanValue();
                }
                return true;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.rank.view.WantSeePosterTips$b$c */
        /* loaded from: classes6.dex */
        public static final class C1558c extends AbstractC1555b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final C1558c INSTANCE = new C1558c();

            private C1558c() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            public boolean a() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1902394276")) {
                    return ((Boolean) ipChange.ipc$dispatch("-1902394276", new Object[]{this})).booleanValue();
                }
                return true;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "86902285") ? (String) ipChange.ipc$dispatch("86902285", new Object[]{this}) : "大麦超懂你，可以点击了解更多哦～";
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            @NotNull
            public String g() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-272644071") ? (String) ipChange.ipc$dispatch("-272644071", new Object[]{this}) : "哇～又发现了相似好演出";
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            public int h() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "869388393")) {
                    return ((Integer) ipChange.ipc$dispatch("869388393", new Object[]{this})).intValue();
                }
                return 12;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            public boolean i() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "76874352")) {
                    return ((Boolean) ipChange.ipc$dispatch("76874352", new Object[]{this})).booleanValue();
                }
                return false;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.rank.view.WantSeePosterTips$b$d */
        /* loaded from: classes6.dex */
        public static final class C1559d extends AbstractC1555b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final C1559d INSTANCE = new C1559d();

            private C1559d() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            public boolean a() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "446822590")) {
                    return ((Boolean) ipChange.ipc$dispatch("446822590", new Object[]{this})).booleanValue();
                }
                return false;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "852010479")) {
                    return (String) ipChange.ipc$dispatch("852010479", new Object[]{this});
                }
                String m = m();
                return m == null ? "" : m;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            @NotNull
            public String g() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "300024695")) {
                    return (String) ipChange.ipc$dispatch("300024695", new Object[]{this});
                }
                String n = n();
                return n == null ? "" : n;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            public int h() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1235465785")) {
                    return ((Integer) ipChange.ipc$dispatch("-1235465785", new Object[]{this})).intValue();
                }
                return 30;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.AbstractC1555b
            public boolean i() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "908754254")) {
                    return ((Boolean) ipChange.ipc$dispatch("908754254", new Object[]{this})).booleanValue();
                }
                return true;
            }
        }

        private AbstractC1555b() {
            this.a = new WantSeeIconUpdate(false, false, false, null, 8, null);
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
        }

        public /* synthetic */ AbstractC1555b(k50 k50Var) {
            this();
        }

        public abstract boolean a();

        @Nullable
        public final String b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1661800978") ? (String) ipChange.ipc$dispatch("1661800978", new Object[]{this}) : this.f;
        }

        @NotNull
        public String c() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-468777981") ? (String) ipChange.ipc$dispatch("-468777981", new Object[]{this}) : gb.PROJECT_PAGE;
        }

        @NotNull
        public String d() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-257427068") ? (String) ipChange.ipc$dispatch("-257427068", new Object[]{this}) : "bottom";
        }

        @NotNull
        public String e() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-46076155") ? (String) ipChange.ipc$dispatch("-46076155", new Object[]{this}) : "wanted_tips";
        }

        @NotNull
        public abstract String f();

        @NotNull
        public abstract String g();

        public abstract int h();

        public abstract boolean i();

        @Nullable
        public final Integer j() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-135651716") ? (Integer) ipChange.ipc$dispatch("-135651716", new Object[]{this}) : this.g;
        }

        @Nullable
        public final String k() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-809434386") ? (String) ipChange.ipc$dispatch("-809434386", new Object[]{this}) : this.e;
        }

        @NotNull
        public final WantSeeIconUpdate l() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1239164179") ? (WantSeeIconUpdate) ipChange.ipc$dispatch("1239164179", new Object[]{this}) : this.a;
        }

        @Nullable
        public final String m() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1561829529") ? (String) ipChange.ipc$dispatch("1561829529", new Object[]{this}) : this.d;
        }

        @Nullable
        public final String n() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-641525491") ? (String) ipChange.ipc$dispatch("-641525491", new Object[]{this}) : this.b;
        }

        @Nullable
        public final String o() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1842028418") ? (String) ipChange.ipc$dispatch("-1842028418", new Object[]{this}) : this.c;
        }

        public final void p(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1418869236")) {
                ipChange.ipc$dispatch("-1418869236", new Object[]{this, str});
            } else {
                this.f = str;
            }
        }

        public final void q(@Nullable Integer num) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1417561138")) {
                ipChange.ipc$dispatch("-1417561138", new Object[]{this, num});
            } else {
                this.g = num;
            }
        }

        public final void r(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1432545616")) {
                ipChange.ipc$dispatch("-1432545616", new Object[]{this, str});
            } else {
                this.e = str;
            }
        }

        public final void s(@NotNull WantSeeIconUpdate wantSeeIconUpdate) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1786238905")) {
                ipChange.ipc$dispatch("-1786238905", new Object[]{this, wantSeeIconUpdate});
                return;
            }
            b41.i(wantSeeIconUpdate, "<set-?>");
            this.a = wantSeeIconUpdate;
        }

        public final void t(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1569956197")) {
                ipChange.ipc$dispatch("1569956197", new Object[]{this, str});
            } else {
                this.d = str;
            }
        }

        public final void u(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-377658615")) {
                ipChange.ipc$dispatch("-377658615", new Object[]{this, str});
            } else {
                this.b = str;
            }
        }

        public final void v(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-986492744")) {
                ipChange.ipc$dispatch("-986492744", new Object[]{this, str});
            } else {
                this.c = str;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.rank.view.WantSeePosterTips$c */
    /* loaded from: classes15.dex */
    public static final class CountDownTimerC1560c extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        CountDownTimerC1560c() {
            super(5500L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1160359466")) {
                ipChange.ipc$dispatch("1160359466", new Object[]{this});
                return;
            }
            WantSeePosterTips.this.hideAnim();
            WantSeePosterTips.this.view.setVisibility(8);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1371270172")) {
                ipChange.ipc$dispatch("-1371270172", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.rank.view.WantSeePosterTips$d */
    /* loaded from: classes15.dex */
    public static final class CountDownTimerC1561d extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        CountDownTimerC1561d() {
            super(5500L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "332485873")) {
                ipChange.ipc$dispatch("332485873", new Object[]{this});
                return;
            }
            WantSeePosterTips.this.hideAnim();
            WantSeePosterTips.this.view.setVisibility(8);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-566691779")) {
                ipChange.ipc$dispatch("-566691779", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeePosterTips(@NotNull Context context) {
        this(context, null, 0, 6, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeePosterTips(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ WantSeePosterTips(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m72_init_$lambda0(WantSeePosterTips wantSeePosterTips, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697540584")) {
            ipChange.ipc$dispatch("-1697540584", new Object[]{wantSeePosterTips, view});
            return;
        }
        b41.i(wantSeePosterTips, "this$0");
        wantSeePosterTips.cancel();
        wantSeePosterTips.view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m73_init_$lambda2(WantSeePosterTips wantSeePosterTips, Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1564161342")) {
            ipChange.ipc$dispatch("-1564161342", new Object[]{wantSeePosterTips, context, view});
            return;
        }
        b41.i(wantSeePosterTips, "this$0");
        b41.i(context, "$context");
        ActionListener actionListener = wantSeePosterTips.listener;
        if (actionListener != null) {
            actionListener.click();
        }
        AbstractC1555b abstractC1555b = wantSeePosterTips.pageSource;
        if (b41.d(abstractC1555b, AbstractC1555b.C1558c.INSTANCE) ? true : b41.d(abstractC1555b, AbstractC1555b.C1557b.INSTANCE)) {
            wantSeePosterTips.cancel();
            AbstractC1555b abstractC1555b2 = wantSeePosterTips.pageSource;
            if (abstractC1555b2 != null) {
                DMNav.from(context).setTransition(0, 0).toUri(abstractC1555b2.b());
            }
        }
    }

    private final void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1415271617")) {
            ipChange.ipc$dispatch("1415271617", new Object[]{this});
            return;
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        ActionListener actionListener = this.listener;
        if (actionListener != null) {
            actionListener.hide(System.currentTimeMillis() - this.startTime);
        }
        this.arrowAnimation.cancel();
        this.view.postDelayed(new Runnable() { // from class: tb.j03
            @Override // java.lang.Runnable
            public final void run() {
                WantSeePosterTips.m74cancel$lambda7(WantSeePosterTips.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cancel$lambda-7  reason: not valid java name */
    public static final void m74cancel$lambda7(WantSeePosterTips wantSeePosterTips) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "339488765")) {
            ipChange.ipc$dispatch("339488765", new Object[]{wantSeePosterTips});
            return;
        }
        b41.i(wantSeePosterTips, "this$0");
        wantSeePosterTips.view.setVisibility(8);
    }

    public static final boolean getWantSeePosterTipsShown() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1056147180") ? ((Boolean) ipChange.ipc$dispatch("-1056147180", new Object[0])).booleanValue() : Companion.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-781334360")) {
            ipChange.ipc$dispatch("-781334360", new Object[]{this});
            return;
        }
        ActionListener actionListener = this.listener;
        if (actionListener != null) {
            actionListener.hide(System.currentTimeMillis() - this.startTime);
        }
        this.arrowAnimation.cancel();
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        translateAnimation.setDuration(500L);
        startAnimation(translateAnimation);
    }

    public static final void setWantSeePosterTipsShown(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1346507216")) {
            ipChange.ipc$dispatch("1346507216", new Object[]{Boolean.valueOf(z)});
        } else {
            Companion.b(z);
        }
    }

    private final void updateUI(AbstractC1555b abstractC1555b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "8565787")) {
            ipChange.ipc$dispatch("8565787", new Object[]{this, abstractC1555b});
            return;
        }
        this.title.setText(abstractC1555b.g());
        this.subTitle.setText(abstractC1555b.f());
        this.arrow.setVisibility(abstractC1555b.a() ? 0 : 8);
        TextView textView = this.titleSuffix;
        textView.setVisibility(abstractC1555b.i() ? 0 : 8);
        textView.setText(abstractC1555b.o());
        ViewGroup.LayoutParams layoutParams = this.parentTitle.getLayoutParams();
        b41.g(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams).setMarginEnd(q60.a(AppInfoProviderProxy.getAppContext(), abstractC1555b.h()));
        IImageLoader a = C2497a.a();
        String k = abstractC1555b.k();
        RoundImageView roundImageView = this.poster;
        int i = R$drawable.uikit_default_image_bg_grey;
        a.loadinto(k, roundImageView, i, i);
        WantSeeIconUpdate l = abstractC1555b.l();
        if (l.getShowWantSeeIcon()) {
            this.wantSeeView.setVisibility(0);
            this.wantSeeView.setOnClickListener(l.getListener());
            if (l.isFollow()) {
                this.wantSeeView.setFollowImage();
            } else {
                this.wantSeeView.setCancelImage();
            }
            if (l.getPlayAnimate()) {
                if (l.isFollow()) {
                    this.wantSeeView.clickAnimate();
                    return;
                } else {
                    this.wantSeeView.cancelAnimate();
                    return;
                }
            }
            return;
        }
        this.wantSeeView.setVisibility(8);
    }

    @Nullable
    public final ActionListener getListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-310075570") ? (ActionListener) ipChange.ipc$dispatch("-310075570", new Object[]{this}) : this.listener;
    }

    @Nullable
    public final Long getProjectId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-644064616") ? (Long) ipChange.ipc$dispatch("-644064616", new Object[]{this}) : this.projectId;
    }

    public final void hideCloseView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1092833484")) {
            ipChange.ipc$dispatch("-1092833484", new Object[]{this});
        } else {
            ((DMIconFontTextView) this.view.findViewById(R$id.want_see_poster_close)).setVisibility(8);
        }
    }

    public final boolean isShowing() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1066503832") ? ((Boolean) ipChange.ipc$dispatch("1066503832", new Object[]{this})).booleanValue() : this.view.getVisibility() == 0;
    }

    public final void mark(@Nullable Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "691166541")) {
            ipChange.ipc$dispatch("691166541", new Object[]{this, l});
            return;
        }
        WantSeePosterTipsMarkRequest wantSeePosterTipsMarkRequest = new WantSeePosterTipsMarkRequest();
        wantSeePosterTipsMarkRequest.setTargetId(String.valueOf(l));
        cc0.a(wantSeePosterTipsMarkRequest).doOnKTSuccess(new Function1<Object, wt2>() { // from class: cn.damai.rank.view.WantSeePosterTips$mark$2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(Object obj) {
                invoke2(obj);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Object obj) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2040922490")) {
                    ipChange2.ipc$dispatch("2040922490", new Object[]{this, obj});
                } else {
                    b41.i(obj, AdvanceSetting.NETWORK_TYPE);
                }
            }
        }).doOnKTFail(new Function1<dc0<Object>, wt2>() { // from class: cn.damai.rank.view.WantSeePosterTips$mark$3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(dc0<Object> dc0Var) {
                invoke2(dc0Var);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull dc0<Object> dc0Var) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1105311961")) {
                    ipChange2.ipc$dispatch("-1105311961", new Object[]{this, dc0Var});
                } else {
                    b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                }
            }
        });
    }

    public final void resumeTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "926573335")) {
            ipChange.ipc$dispatch("926573335", new Object[]{this});
            return;
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = new CountDownTimerC1560c().start();
    }

    public final void setListener(@Nullable ActionListener actionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677542784")) {
            ipChange.ipc$dispatch("-1677542784", new Object[]{this, actionListener});
        } else {
            this.listener = actionListener;
        }
    }

    public final void setPageSource(@NotNull AbstractC1555b abstractC1555b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1813055190")) {
            ipChange.ipc$dispatch("1813055190", new Object[]{this, abstractC1555b});
            return;
        }
        b41.i(abstractC1555b, "pageSource");
        this.pageSource = abstractC1555b;
        updateUI(abstractC1555b);
    }

    public final void setProjectId(@Nullable Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1184852520")) {
            ipChange.ipc$dispatch("1184852520", new Object[]{this, l});
        } else {
            this.projectId = l;
        }
    }

    public final void showAnim() {
        HashMap<String, String> hashMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-272764275")) {
            ipChange.ipc$dispatch("-272764275", new Object[]{this});
            return;
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.startTime = System.currentTimeMillis();
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        this.arrow.startAnimation(this.arrowAnimation);
        translateAnimation.setDuration(500L);
        startAnimation(translateAnimation);
        this.view.setVisibility(0);
        this.timer = new CountDownTimerC1561d().start();
        if (b41.d(this.pageSource, AbstractC1555b.C1559d.INSTANCE)) {
            HashMap<String, String> f = d23.f();
            if (f != null) {
                f.put("item_id", String.valueOf(this.projectId));
                AbstractC1555b abstractC1555b = this.pageSource;
                f.put("type", String.valueOf(abstractC1555b != null ? abstractC1555b.j() : null));
                hashMap = f;
            } else {
                hashMap = null;
            }
            C0529c e = C0529c.e();
            AbstractC1555b abstractC1555b2 = this.pageSource;
            String e2 = abstractC1555b2 != null ? abstractC1555b2.e() : null;
            AbstractC1555b abstractC1555b3 = this.pageSource;
            String d = abstractC1555b3 != null ? abstractC1555b3.d() : null;
            AbstractC1555b abstractC1555b4 = this.pageSource;
            e.G(this, e2, d, abstractC1555b4 != null ? abstractC1555b4.c() : null, hashMap);
        }
    }

    public final void stopTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1466620820")) {
            ipChange.ipc$dispatch("-1466620820", new Object[]{this});
            return;
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeePosterTips(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_want_see_poster_tips, (ViewGroup) this, true);
        b41.h(inflate, "from(context).inflate(R.…_poster_tips, this, true)");
        this.view = inflate;
        View findViewById = inflate.findViewById(R$id.ll_parent_title);
        b41.h(findViewById, "view.findViewById(R.id.ll_parent_title)");
        this.parentTitle = (LinearLayout) findViewById;
        View findViewById2 = this.view.findViewById(R$id.want_see_poster_title);
        b41.h(findViewById2, "view.findViewById(R.id.want_see_poster_title)");
        this.title = (TextView) findViewById2;
        View findViewById3 = this.view.findViewById(R$id.want_see_poster_title_suffix);
        b41.h(findViewById3, "view.findViewById(R.id.w…_see_poster_title_suffix)");
        this.titleSuffix = (TextView) findViewById3;
        View findViewById4 = this.view.findViewById(R$id.want_see_poster_subtitle);
        b41.h(findViewById4, "view.findViewById(R.id.want_see_poster_subtitle)");
        this.subTitle = (TextView) findViewById4;
        View findViewById5 = this.view.findViewById(R$id.want_see_poster_img);
        b41.h(findViewById5, "view.findViewById(R.id.want_see_poster_img)");
        this.poster = (RoundImageView) findViewById5;
        View findViewById6 = this.view.findViewById(R$id.want_see_poster_arrow);
        b41.h(findViewById6, "view.findViewById(R.id.want_see_poster_arrow)");
        this.arrow = (DMIconFontTextView) findViewById6;
        View findViewById7 = this.view.findViewById(R$id.want_see_animate_icon);
        b41.h(findViewById7, "view.findViewById(R.id.want_see_animate_icon)");
        this.wantSeeView = (SeeAnimateView) findViewById7;
        ((DMIconFontTextView) this.view.findViewById(R$id.want_see_poster_close)).setOnClickListener(new View.OnClickListener() { // from class: tb.h03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WantSeePosterTips.m72_init_$lambda0(WantSeePosterTips.this, view);
            }
        });
        ((ViewGroup) this.view.findViewById(R$id.want_see_poster_bg)).setOnClickListener(new View.OnClickListener() { // from class: tb.i03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WantSeePosterTips.m73_init_$lambda2(WantSeePosterTips.this, context, view);
            }
        });
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -2.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new OvershootInterpolator());
        translateAnimation.setDuration(500L);
        translateAnimation.setRepeatCount(10);
        translateAnimation.setRepeatMode(2);
        this.arrowAnimation = translateAnimation;
    }
}
