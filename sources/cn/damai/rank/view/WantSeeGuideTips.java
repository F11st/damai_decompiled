package cn.damai.rank.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.rank.view.WantSeeGuideTips;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alient.onearch.adapter.util.DisplayUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.d23;
import tb.gb;
import tb.k50;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public final class WantSeeGuideTips extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C1545a Companion = new C1545a(null);
    private static boolean wantSeeGuideTipsShown;
    @Nullable
    private Long projectId;
    @Nullable
    private AbstractC1546b scenesSource;
    @NotNull
    private TextView subTitle;
    @Nullable
    private CountDownTimer timer;
    @NotNull
    private TextView title;
    @NotNull
    private View view;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.rank.view.WantSeeGuideTips$a */
    /* loaded from: classes15.dex */
    public static final class C1545a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C1545a() {
        }

        public /* synthetic */ C1545a(k50 k50Var) {
            this();
        }

        public final boolean a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-445601134") ? ((Boolean) ipChange.ipc$dispatch("-445601134", new Object[]{this})).booleanValue() : WantSeeGuideTips.wantSeeGuideTipsShown;
        }

        public final void b(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "309441146")) {
                ipChange.ipc$dispatch("309441146", new Object[]{this, Boolean.valueOf(z)});
            } else {
                WantSeeGuideTips.wantSeeGuideTipsShown = z;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.rank.view.WantSeeGuideTips$b */
    /* loaded from: classes15.dex */
    public static abstract class AbstractC1546b {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private String a;
        @Nullable
        private String b;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.rank.view.WantSeeGuideTips$b$a */
        /* loaded from: classes6.dex */
        public static final class C1547a extends AbstractC1546b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final C1547a INSTANCE = new C1547a();

            private C1547a() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.AbstractC1546b
            @NotNull
            public String e() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1910226816") ? (String) ipChange.ipc$dispatch("-1910226816", new Object[]{this}) : "标 [想看]，以后更好查找～";
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.AbstractC1546b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "652860038") ? (String) ipChange.ipc$dispatch("652860038", new Object[]{this}) : "还没做好决定？";
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.AbstractC1546b
            public int k() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-838645963")) {
                    return ((Integer) ipChange.ipc$dispatch("-838645963", new Object[]{this})).intValue();
                }
                return 1;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.rank.view.WantSeeGuideTips$b$b */
        /* loaded from: classes6.dex */
        public static final class C1548b extends AbstractC1546b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final C1548b INSTANCE = new C1548b();

            private C1548b() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.AbstractC1546b
            @NotNull
            public String e() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-2062972732") ? (String) ipChange.ipc$dispatch("-2062972732", new Object[]{this}) : "标 [想看]，记录心动演出～";
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.AbstractC1546b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-902883134") ? (String) ipChange.ipc$dispatch("-902883134", new Object[]{this}) : "感觉有点心动？";
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.AbstractC1546b
            public int k() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-867165319")) {
                    return ((Integer) ipChange.ipc$dispatch("-867165319", new Object[]{this})).intValue();
                }
                return 3;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.rank.view.WantSeeGuideTips$b$c */
        /* loaded from: classes6.dex */
        public static final class C1549c extends AbstractC1546b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final C1549c INSTANCE = new C1549c();

            private C1549c() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.AbstractC1546b
            @NotNull
            public String e() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1351088601") ? (String) ipChange.ipc$dispatch("-1351088601", new Object[]{this}) : "标 [想看]，记录心动演出～";
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.AbstractC1546b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "483479103") ? (String) ipChange.ipc$dispatch("483479103", new Object[]{this}) : "感觉有点心动？";
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.AbstractC1546b
            public int k() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-414002724")) {
                    return ((Integer) ipChange.ipc$dispatch("-414002724", new Object[]{this})).intValue();
                }
                return 2;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.rank.view.WantSeeGuideTips$b$d */
        /* loaded from: classes6.dex */
        public static final class C1550d extends AbstractC1546b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final C1550d INSTANCE = new C1550d();

            private C1550d() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.AbstractC1546b
            @NotNull
            public String e() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "615345221") ? (String) ipChange.ipc$dispatch("615345221", new Object[]{this}) : "标 [想看]，及时获取优惠信息～";
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.AbstractC1546b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "189582561") ? (String) ipChange.ipc$dispatch("189582561", new Object[]{this}) : "还没做好决定？";
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.AbstractC1546b
            public int k() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "100610554")) {
                    return ((Integer) ipChange.ipc$dispatch("100610554", new Object[]{this})).intValue();
                }
                return 0;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.rank.view.WantSeeGuideTips$b$e */
        /* loaded from: classes6.dex */
        public static final class C1551e extends AbstractC1546b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final C1551e INSTANCE = new C1551e();

            private C1551e() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.AbstractC1546b
            @NotNull
            public String e() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1646181301")) {
                    return (String) ipChange.ipc$dispatch("-1646181301", new Object[]{this});
                }
                String g = g();
                return g == null ? "" : g;
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.AbstractC1546b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2002165093")) {
                    return (String) ipChange.ipc$dispatch("-2002165093", new Object[]{this});
                }
                String h = h();
                return h == null ? "" : h;
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.AbstractC1546b
            public int k() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1290847232")) {
                    return ((Integer) ipChange.ipc$dispatch("-1290847232", new Object[]{this})).intValue();
                }
                return -1;
            }
        }

        private AbstractC1546b() {
            this.a = "";
            this.b = "";
        }

        public /* synthetic */ AbstractC1546b(k50 k50Var) {
            this();
        }

        public int a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-774350033") ? ((Integer) ipChange.ipc$dispatch("-774350033", new Object[]{this})).intValue() : q60.a(AppInfoProviderProxy.getAppContext(), 0.0f);
        }

        @NotNull
        public final String b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2025032762") ? (String) ipChange.ipc$dispatch("-2025032762", new Object[]{this}) : gb.PROJECT_PAGE;
        }

        @NotNull
        public final String c() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1813681849") ? (String) ipChange.ipc$dispatch("-1813681849", new Object[]{this}) : "bottom";
        }

        @NotNull
        public final String d() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1602330936") ? (String) ipChange.ipc$dispatch("-1602330936", new Object[]{this}) : "want-tips";
        }

        @NotNull
        public abstract String e();

        @NotNull
        public abstract String f();

        @Nullable
        public final String g() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "261528924") ? (String) ipChange.ipc$dispatch("261528924", new Object[]{this}) : this.b;
        }

        @Nullable
        public final String h() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1800669994") ? (String) ipChange.ipc$dispatch("1800669994", new Object[]{this}) : this.a;
        }

        public final void i(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-84656894")) {
                ipChange.ipc$dispatch("-84656894", new Object[]{this, str});
            } else {
                this.b = str;
            }
        }

        public final void j(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1979009908")) {
                ipChange.ipc$dispatch("-1979009908", new Object[]{this, str});
            } else {
                this.a = str;
            }
        }

        public abstract int k();
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.rank.view.WantSeeGuideTips$c */
    /* loaded from: classes15.dex */
    public static final class CountDownTimerC1552c extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        CountDownTimerC1552c() {
            super(5500L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-633660324")) {
                ipChange.ipc$dispatch("-633660324", new Object[]{this});
                return;
            }
            WantSeeGuideTips.this.hideAnim();
            WantSeeGuideTips.this.view.setVisibility(8);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1290594446")) {
                ipChange.ipc$dispatch("-1290594446", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.rank.view.WantSeeGuideTips$d  reason: invalid class name */
    /* loaded from: classes15.dex */
    public static final class animationAnimation$AnimationListenerC1553d implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        animationAnimation$AnimationListenerC1553d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1280385593")) {
                ipChange.ipc$dispatch("1280385593", new Object[]{this, animation});
            } else {
                WantSeeGuideTips.this.guideAnim();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-149961061")) {
                ipChange.ipc$dispatch("-149961061", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "585108306")) {
                ipChange.ipc$dispatch("585108306", new Object[]{this, animation});
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeGuideTips(@NotNull Context context) {
        this(context, null, 0, 6, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeGuideTips(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeGuideTips(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_want_see_guide_tips, (ViewGroup) this, true);
        b41.h(inflate, "from(context).inflate(R.…e_guide_tips, this, true)");
        this.view = inflate;
        View findViewById = inflate.findViewById(R$id.want_see_guide_title);
        b41.h(findViewById, "view.findViewById(R.id.want_see_guide_title)");
        this.title = (TextView) findViewById;
        View findViewById2 = this.view.findViewById(R$id.want_see_guide_subtitle);
        b41.h(findViewById2, "view.findViewById(R.id.want_see_guide_subtitle)");
        this.subTitle = (TextView) findViewById2;
        ((DMIconFontTextView) this.view.findViewById(R$id.want_see_guide_close)).setOnClickListener(new View.OnClickListener() { // from class: tb.c03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WantSeeGuideTips.m70_init_$lambda0(WantSeeGuideTips.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m70_init_$lambda0(WantSeeGuideTips wantSeeGuideTips, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1505283264")) {
            ipChange.ipc$dispatch("-1505283264", new Object[]{wantSeeGuideTips, view});
            return;
        }
        b41.i(wantSeeGuideTips, "this$0");
        CountDownTimer countDownTimer = wantSeeGuideTips.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        wantSeeGuideTips.view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cancel$lambda-5  reason: not valid java name */
    public static final void m71cancel$lambda5(WantSeeGuideTips wantSeeGuideTips) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1367770515")) {
            ipChange.ipc$dispatch("-1367770515", new Object[]{wantSeeGuideTips});
            return;
        }
        b41.i(wantSeeGuideTips, "this$0");
        wantSeeGuideTips.view.setVisibility(8);
    }

    public static final boolean getWantSeeGuideTipsShown() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1274994166") ? ((Boolean) ipChange.ipc$dispatch("-1274994166", new Object[0])).booleanValue() : Companion.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void guideAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "650065229")) {
            ipChange.ipc$dispatch("650065229", new Object[]{this});
            return;
        }
        DisplayUtil displayUtil = DisplayUtil.INSTANCE;
        Context context = getContext();
        b41.h(context, WPKFactory.INIT_KEY_CONTEXT);
        float dp2px = displayUtil.dp2px(context, 1.5f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", this.view.getTranslationY() - dp2px, this.view.getTranslationY() + dp2px);
        if (ofFloat != null) {
            ofFloat.setDuration(1000L);
            ofFloat.setInterpolator(new CycleInterpolator(1.0f));
            ofFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-323137699")) {
            ipChange.ipc$dispatch("-323137699", new Object[]{this});
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        translateAnimation.setDuration(500L);
        startAnimation(translateAnimation);
    }

    public static final void setWantSeeGuideTipsShown(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "368060930")) {
            ipChange.ipc$dispatch("368060930", new Object[]{Boolean.valueOf(z)});
        } else {
            Companion.b(z);
        }
    }

    private final void updateUI(AbstractC1546b abstractC1546b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1571465263")) {
            ipChange.ipc$dispatch("1571465263", new Object[]{this, abstractC1546b});
            return;
        }
        this.title.setText(abstractC1546b.f());
        this.subTitle.setText(abstractC1546b.e());
        this.view.setPadding(0, 0, 0, abstractC1546b.a());
    }

    public final void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1607926966")) {
            ipChange.ipc$dispatch("1607926966", new Object[]{this});
        } else {
            cancel(0L);
        }
    }

    @Nullable
    public final Long getProjectId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2121292349") ? (Long) ipChange.ipc$dispatch("-2121292349", new Object[]{this}) : this.projectId;
    }

    public final void setProjectId(@Nullable Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1659534243")) {
            ipChange.ipc$dispatch("-1659534243", new Object[]{this, l});
        } else {
            this.projectId = l;
        }
    }

    public final void setScenesSource(@NotNull AbstractC1546b abstractC1546b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "666063986")) {
            ipChange.ipc$dispatch("666063986", new Object[]{this, abstractC1546b});
            return;
        }
        b41.i(abstractC1546b, "scenesSource");
        this.scenesSource = abstractC1546b;
        updateUI(abstractC1546b);
    }

    public final void showAnim() {
        HashMap<String, String> hashMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "185432386")) {
            ipChange.ipc$dispatch("185432386", new Object[]{this});
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
        this.timer = new CountDownTimerC1552c().start();
        translateAnimation.setAnimationListener(new animationAnimation$AnimationListenerC1553d());
        AbstractC1546b abstractC1546b = this.scenesSource;
        if (b41.d(abstractC1546b, AbstractC1546b.C1550d.INSTANCE) ? true : b41.d(abstractC1546b, AbstractC1546b.C1548b.INSTANCE) ? true : b41.d(abstractC1546b, AbstractC1546b.C1547a.INSTANCE) ? true : b41.d(abstractC1546b, AbstractC1546b.C1549c.INSTANCE)) {
            HashMap<String, String> f = d23.f();
            if (f != null) {
                f.put("item_id", String.valueOf(this.projectId));
                AbstractC1546b abstractC1546b2 = this.scenesSource;
                f.put("type", String.valueOf(abstractC1546b2 != null ? Integer.valueOf(abstractC1546b2.k()) : null));
                hashMap = f;
            } else {
                hashMap = null;
            }
            C0529c e = C0529c.e();
            AbstractC1546b abstractC1546b3 = this.scenesSource;
            String d = abstractC1546b3 != null ? abstractC1546b3.d() : null;
            AbstractC1546b abstractC1546b4 = this.scenesSource;
            String c = abstractC1546b4 != null ? abstractC1546b4.c() : null;
            AbstractC1546b abstractC1546b5 = this.scenesSource;
            e.G(this, d, c, abstractC1546b5 != null ? abstractC1546b5.b() : null, hashMap);
        }
    }

    public final void cancel(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1693841202")) {
            ipChange.ipc$dispatch("-1693841202", new Object[]{this, Long.valueOf(j)});
            return;
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.view.postDelayed(new Runnable() { // from class: tb.d03
            @Override // java.lang.Runnable
            public final void run() {
                WantSeeGuideTips.m71cancel$lambda5(WantSeeGuideTips.this);
            }
        }, j);
    }

    public /* synthetic */ WantSeeGuideTips(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
