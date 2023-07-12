package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import cn.damai.common.nav.DMNav;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.calendar.remind.CalendarsResolver;
import cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow;
import cn.damai.login.LoginManager;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$raw;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectMemberPrompt;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStagoryView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStrategyTmPromptView;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.activity.ProjectDetailActivity;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.number.DMDigitTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.gb;
import tb.ir1;
import tb.jn1;
import tb.k23;
import tb.k50;
import tb.m62;
import tb.mr1;
import tb.pp2;
import tb.qv1;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public final class ProjectTimerAndStrategyTmPromptView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final CalendarsResolver.RemindMeListener calendRemindMeListener;
    @Nullable
    private ProjectDetailActivity damaiBaseActivity;
    private final long downTime;
    @Nullable
    private ConstraintLayout.LayoutParams exchangeActionParam;
    @Nullable
    private ConstraintLayout exchangeLayout;
    private boolean hasRobTicketStrategyModule;
    private final long intervalTime;
    private boolean isPlaying;
    @Nullable
    private String itemName;
    @Nullable
    private LottieAnimationView lottieTmStrategy;
    @Nullable
    private View lottieTmStrategyHolder;
    @Nullable
    private Context mContext;
    @Nullable
    private String mProjectId;
    @Nullable
    private DMIconFontTextView mResetAttendeesCloseBtn;
    @Nullable
    private ConstraintLayout mResetAttendeesLayoutCl;
    @Nullable
    private TextView mResetAttendeesMidTv;
    @Nullable
    private TextView mResetAttendeesTitleTv;
    @Nullable
    private TextView mTvPromptRemindMeButton;
    @Nullable
    private TextView mTvRemindMeButton;
    @Nullable
    private ProjectMemberPrompt memberPrompt;
    private final int minMark;
    @NotNull
    private ProjectTimerAndStagoryView.TypeEnum minType;
    @Nullable
    private DMDigitTextView normalSaleCountDown;
    @Nullable
    private TextView normalSaleDesc;
    @Nullable
    private TextView normalSaleTimeDesc;
    @Nullable
    private ConstraintLayout.LayoutParams normalSaleTimeDescParam;
    @NotNull
    private final CalendarsResolver.RemindMeListener promptCalenderRemindMeListener;
    @Nullable
    private TextView promptExchangeAction;
    @Nullable
    private DMDigitTextView promptExchangeCountDown;
    @Nullable
    private TextView promptExchangeDesc;
    @Nullable
    private ImageView promptExchangeDescIcon;
    @Nullable
    private ConstraintLayout.LayoutParams promptExchangeDescParam;
    @Nullable
    private TextView promptExchangeType;
    @Nullable
    private ProjectPromptListener promptListener;
    @Nullable
    private ImageView promptVipIcon;
    @Nullable
    private CountDownTimer timeDown;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface ProjectPromptListener {
        void onVipRefresh();

        void showVIPCreditExchange();
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public final class a extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-721190996")) {
                ipChange.ipc$dispatch("-721190996", new Object[]{this});
                return;
            }
            LottieAnimationView lottieAnimationView = ProjectTimerAndStrategyTmPromptView.this.lottieTmStrategy;
            if (lottieAnimationView != null) {
                lottieAnimationView.playAnimation();
            }
            ProjectTimerAndStrategyTmPromptView.this.cancelDownAnim();
            ProjectTimerAndStrategyTmPromptView.this.strategyAnim();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "923339298")) {
                ipChange.ipc$dispatch("923339298", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class b implements CalendarsResolver.RemindMeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void addRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1279399051")) {
                ipChange.ipc$dispatch("-1279399051", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(pp2.u().o(ProjectTimerAndStrategyTmPromptView.this.mProjectId, "1", "2"));
            ProjectTimerAndStrategyTmPromptView.this.updateRemindMeBtnText(true);
            ProjectTimerAndStrategyTmPromptView.this.addRemindmeSuccessDialog();
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void candelRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1934215643")) {
                ipChange.ipc$dispatch("-1934215643", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(pp2.u().o(ProjectTimerAndStrategyTmPromptView.this.mProjectId, "2", "2"));
            ProjectTimerAndStrategyTmPromptView.this.updateRemindMeBtnText(false);
            ProjectTimerAndStrategyTmPromptView.this.cancelRemindmeSuccess();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static final class c implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ View b;
        final /* synthetic */ ProjectTimerAndStrategyTmPromptView c;

        c(int i, View view, ProjectTimerAndStrategyTmPromptView projectTimerAndStrategyTmPromptView) {
            this.a = i;
            this.b = view;
            this.c = projectTimerAndStrategyTmPromptView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1023435765")) {
                ipChange.ipc$dispatch("-1023435765", new Object[]{this, animation});
                return;
            }
            b41.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
            if (this.a == 8) {
                this.b.setVisibility(8);
            }
            this.c.isPlaying = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "285352841")) {
                ipChange.ipc$dispatch("285352841", new Object[]{this, animation});
            } else {
                b41.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1479059292")) {
                ipChange.ipc$dispatch("-1479059292", new Object[]{this, animation});
            } else {
                b41.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class d implements CalendarsResolver.RemindMeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void addRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1885146918")) {
                ipChange.ipc$dispatch("1885146918", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(pp2.u().o(ProjectTimerAndStrategyTmPromptView.this.mProjectId, "1", "1"));
            ProjectTimerAndStrategyTmPromptView.this.promptUpdateRemindMeBtnText(true);
            ProjectTimerAndStrategyTmPromptView.this.addRemindmeSuccessDialog();
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void candelRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1477400364")) {
                ipChange.ipc$dispatch("-1477400364", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(pp2.u().o(ProjectTimerAndStrategyTmPromptView.this.mProjectId, "2", "1"));
            ProjectTimerAndStrategyTmPromptView.this.promptUpdateRemindMeBtnText(false);
            ProjectTimerAndStrategyTmPromptView.this.cancelRemindmeSuccess();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class e implements MemberAuthPopWindow.ICustomDialogEventListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow.ICustomDialogEventListener
        public void dialogItemEvent(@Nullable String str) {
            ProjectPromptListener projectPromptListener;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-190373043")) {
                ipChange.ipc$dispatch("-190373043", new Object[]{this, str});
            } else if (!b41.d("success", str) || (projectPromptListener = ProjectTimerAndStrategyTmPromptView.this.promptListener) == null) {
            } else {
                projectPromptListener.onVipRefresh();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProjectTimerAndStrategyTmPromptView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProjectTimerAndStrategyTmPromptView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ ProjectTimerAndStrategyTmPromptView(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addRemindmeSuccessDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1227609766")) {
            ipChange.ipc$dispatch("-1227609766", new Object[]{this});
        } else {
            qv1.f(this.damaiBaseActivity, "添加日历提醒成功", "开抢前10分钟将收到手机日历提醒，可在系统日历中更改提醒时间");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelRemindmeSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "285109111")) {
            ipChange.ipc$dispatch("285109111", new Object[]{this});
        } else {
            ToastUtil.i("取消提醒成功");
        }
    }

    private final void disEnableClickRemindMeBtn() {
        ProjectMemberPrompt projectMemberPrompt;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-741546437")) {
            ipChange.ipc$dispatch("-741546437", new Object[]{this});
            return;
        }
        ProjectTimerAndStagoryView.TypeEnum typeEnum = this.minType;
        ProjectTimerAndStagoryView.TypeEnum typeEnum2 = ProjectTimerAndStagoryView.TypeEnum.LESS;
        if (typeEnum != typeEnum2 && (projectMemberPrompt = this.memberPrompt) != null) {
            if (projectMemberPrompt.isPromptBeforeSale()) {
                TextView textView = this.mTvPromptRemindMeButton;
                if (textView != null && textView.getVisibility() == 0) {
                    TextView textView2 = this.mTvPromptRemindMeButton;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    promptSaleDescWidth(false);
                }
                TextView textView3 = this.mTvRemindMeButton;
                if (!(textView3 != null && textView3.getVisibility() == 0)) {
                    TextView textView4 = this.mTvRemindMeButton;
                    if (textView4 != null) {
                        textView4.setVisibility(0);
                    }
                    normalSaleDescWidth(true);
                }
            } else {
                TextView textView5 = this.mTvPromptRemindMeButton;
                if (textView5 != null && textView5.getVisibility() == 0) {
                    TextView textView6 = this.mTvPromptRemindMeButton;
                    if (textView6 != null) {
                        textView6.setVisibility(8);
                    }
                    promptSaleDescWidth(false);
                }
                TextView textView7 = this.mTvRemindMeButton;
                if ((textView7 == null || textView7.getVisibility() != 0) ? false : false) {
                    TextView textView8 = this.mTvRemindMeButton;
                    if (textView8 != null) {
                        textView8.setVisibility(8);
                    }
                    normalSaleDescWidth(false);
                }
            }
        }
        this.minType = typeEnum2;
    }

    private final boolean enableCalenderRemind(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "97214547")) {
            return ((Boolean) ipChange.ipc$dispatch("97214547", new Object[]{this, Boolean.valueOf(z)})).booleanValue();
        }
        ProjectMemberPrompt projectMemberPrompt = this.memberPrompt;
        if (projectMemberPrompt != null) {
            if (z) {
                if (projectMemberPrompt.getPreBuyTimestamp() > 0 && projectMemberPrompt.getScd() > 600) {
                    return true;
                }
            } else if (projectMemberPrompt.getLaunchTimeStamp() > 0 && projectMemberPrompt.getLaunchScd() > 600) {
                return true;
            }
            return false;
        }
        return false;
    }

    private final void enableClickRemindMeBtn() {
        ProjectMemberPrompt projectMemberPrompt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1386951475")) {
            ipChange.ipc$dispatch("-1386951475", new Object[]{this});
            return;
        }
        ProjectTimerAndStagoryView.TypeEnum typeEnum = this.minType;
        ProjectTimerAndStagoryView.TypeEnum typeEnum2 = ProjectTimerAndStagoryView.TypeEnum.LARGER;
        if (typeEnum != typeEnum2 && (projectMemberPrompt = this.memberPrompt) != null) {
            if (projectMemberPrompt.isPromptBeforeSale()) {
                TextView textView = this.mTvPromptRemindMeButton;
                if (!(textView != null && textView.getVisibility() == 0)) {
                    TextView textView2 = this.mTvPromptRemindMeButton;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                    promptSaleDescWidth(true);
                }
                TextView textView3 = this.mTvRemindMeButton;
                if (!(textView3 != null && textView3.getVisibility() == 0)) {
                    TextView textView4 = this.mTvRemindMeButton;
                    if (textView4 != null) {
                        textView4.setVisibility(0);
                    }
                    normalSaleDescWidth(true);
                }
            } else {
                TextView textView5 = this.mTvPromptRemindMeButton;
                if (textView5 != null && textView5.getVisibility() == 0) {
                    TextView textView6 = this.mTvPromptRemindMeButton;
                    if (textView6 != null) {
                        textView6.setVisibility(8);
                    }
                    promptSaleDescWidth(false);
                }
                TextView textView7 = this.mTvRemindMeButton;
                if (!(textView7 != null && textView7.getVisibility() == 0)) {
                    TextView textView8 = this.mTvRemindMeButton;
                    if (textView8 != null) {
                        textView8.setVisibility(0);
                    }
                    normalSaleDescWidth(true);
                }
            }
        }
        this.minType = typeEnum2;
    }

    private final long getCalendSellTime(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "651270599")) {
            return ((Long) ipChange.ipc$dispatch("651270599", new Object[]{this, Boolean.valueOf(z)})).longValue();
        }
        ProjectMemberPrompt projectMemberPrompt = this.memberPrompt;
        if (projectMemberPrompt != null) {
            if (z) {
                if (projectMemberPrompt != null) {
                    return projectMemberPrompt.getPreBuyTimestamp();
                }
                return 0L;
            } else if (projectMemberPrompt != null) {
                return projectMemberPrompt.getLaunchTimeStamp();
            } else {
                return 0L;
            }
        }
        return 0L;
    }

    private final void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1458155799")) {
            ipChange.ipc$dispatch("1458155799", new Object[]{this});
            return;
        }
        LayoutInflater.from(getContext()).inflate(R$layout.project_detail_member_prompt_bottom_layout, this);
        this.lottieTmStrategy = (LottieAnimationView) findViewById(R$id.member_lottie_strategy);
        this.lottieTmStrategyHolder = findViewById(R$id.member_lottie_strategy_holder);
        this.mResetAttendeesLayoutCl = (ConstraintLayout) findViewById(R$id.ll_reset_attendees_layout);
        this.mResetAttendeesTitleTv = (TextView) findViewById(R$id.tv_reset_attendees_title);
        this.mResetAttendeesMidTv = (TextView) findViewById(R$id.tv_reset_attendees_mid);
        this.mResetAttendeesCloseBtn = (DMIconFontTextView) findViewById(R$id.tv_close_reset_attendees);
        ConstraintLayout constraintLayout = this.mResetAttendeesLayoutCl;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: tb.uw1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProjectTimerAndStrategyTmPromptView.m95init$lambda0(view);
                }
            });
        }
        DMIconFontTextView dMIconFontTextView = this.mResetAttendeesCloseBtn;
        if (dMIconFontTextView != null) {
            dMIconFontTextView.setOnClickListener(new View.OnClickListener() { // from class: tb.sw1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProjectTimerAndStrategyTmPromptView.m96init$lambda1(ProjectTimerAndStrategyTmPromptView.this, view);
                }
            });
        }
        this.exchangeLayout = (ConstraintLayout) findViewById(R$id.tm_prompt_timer_exchange_layout);
        this.promptVipIcon = (ImageView) findViewById(R$id.tm_prompt_vip_icon);
        this.promptExchangeType = (TextView) findViewById(R$id.tm_prompt_timer_exchange_type);
        this.promptExchangeDesc = (TextView) findViewById(R$id.tm_prompt_timer_exchange_desc);
        this.promptExchangeDescIcon = (ImageView) findViewById(R$id.tm_prompt_timer_exchange_desc_icon);
        this.promptExchangeCountDown = (DMDigitTextView) findViewById(R$id.tm_prompt_timer_exchange_down);
        this.mTvPromptRemindMeButton = (TextView) findViewById(R$id.tv_member_timer_exchange_remind_me);
        this.promptExchangeAction = (TextView) findViewById(R$id.tv_member_timer_exchange_action);
        this.normalSaleDesc = (TextView) findViewById(R$id.normal_start_sale_desc);
        this.normalSaleCountDown = (DMDigitTextView) findViewById(R$id.normal_start_sale_down);
        this.normalSaleTimeDesc = (TextView) findViewById(R$id.normal_start_sale_time);
        this.mTvRemindMeButton = (TextView) findViewById(R$id.tv_normal_start_sale_remind_me);
        TextView textView = this.promptExchangeAction;
        ViewGroup.LayoutParams layoutParams = textView != null ? textView.getLayoutParams() : null;
        b41.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.exchangeActionParam = (ConstraintLayout.LayoutParams) layoutParams;
        TextView textView2 = this.promptExchangeDesc;
        ViewGroup.LayoutParams layoutParams2 = textView2 != null ? textView2.getLayoutParams() : null;
        b41.g(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.promptExchangeDescParam = (ConstraintLayout.LayoutParams) layoutParams2;
        TextView textView3 = this.normalSaleTimeDesc;
        ViewGroup.LayoutParams layoutParams3 = textView3 != null ? textView3.getLayoutParams() : null;
        b41.g(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.normalSaleTimeDescParam = (ConstraintLayout.LayoutParams) layoutParams3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: init$lambda-0  reason: not valid java name */
    public static final void m95init$lambda0(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "618567469")) {
            ipChange.ipc$dispatch("618567469", new Object[]{view});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: init$lambda-1  reason: not valid java name */
    public static final void m96init$lambda1(ProjectTimerAndStrategyTmPromptView projectTimerAndStrategyTmPromptView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-95701505")) {
            ipChange.ipc$dispatch("-95701505", new Object[]{projectTimerAndStrategyTmPromptView, view});
            return;
        }
        b41.i(projectTimerAndStrategyTmPromptView, "this$0");
        cn.damai.common.user.c.e().x(pp2.u().b2(projectTimerAndStrategyTmPromptView.mProjectId));
        projectTimerAndStrategyTmPromptView.playAnim(projectTimerAndStrategyTmPromptView.mResetAttendeesLayoutCl, 8);
    }

    private final void normalSaleDescWidth(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "669347512")) {
            ipChange.ipc$dispatch("669347512", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            ConstraintLayout.LayoutParams layoutParams = this.promptExchangeDescParam;
            if (layoutParams != null) {
                layoutParams.matchConstraintMaxWidth = m62.a(this.damaiBaseActivity, 210.0f);
            }
            ConstraintLayout.LayoutParams layoutParams2 = this.promptExchangeDescParam;
            if (layoutParams2 == null) {
                return;
            }
            layoutParams2.matchConstraintMinWidth = m62.a(this.damaiBaseActivity, 100.0f);
        } else {
            ConstraintLayout.LayoutParams layoutParams3 = this.normalSaleTimeDescParam;
            if (layoutParams3 != null) {
                layoutParams3.matchConstraintMaxWidth = m62.a(this.damaiBaseActivity, 266.0f);
            }
            ConstraintLayout.LayoutParams layoutParams4 = this.normalSaleTimeDescParam;
            if (layoutParams4 == null) {
                return;
            }
            layoutParams4.matchConstraintMinWidth = m62.a(this.damaiBaseActivity, 156.0f);
        }
    }

    private final void playAnim(final View view, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1921287917")) {
            ipChange.ipc$dispatch("-1921287917", new Object[]{this, view, Integer.valueOf(i)});
        } else if (view == null || view.getVisibility() == i || this.isPlaying) {
        } else {
            view.clearAnimation();
            final TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, i == 8 ? 0.0f : 1.0f, 2, i == 8 ? 1.0f : 0.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setAnimationListener(new c(i, view, this));
            this.isPlaying = true;
            view.post(new Runnable() { // from class: tb.vw1
                @Override // java.lang.Runnable
                public final void run() {
                    ProjectTimerAndStrategyTmPromptView.m97playAnim$lambda2(i, view, translateAnimation);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: playAnim$lambda-2  reason: not valid java name */
    public static final void m97playAnim$lambda2(int i, View view, Animation animation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "849633287")) {
            ipChange.ipc$dispatch("849633287", new Object[]{Integer.valueOf(i), view, animation});
            return;
        }
        b41.i(animation, "$animation");
        if (i == 0) {
            view.setVisibility(0);
        }
        view.requestLayout();
        view.startAnimation(animation);
    }

    private final void processCalendarRemind(boolean z, String str, long j, CalendarsResolver.RemindMeListener remindMeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-910441526")) {
            ipChange.ipc$dispatch("-910441526", new Object[]{this, Boolean.valueOf(z), str, Long.valueOf(j), remindMeListener});
        } else if (z) {
            qv1.e(this.damaiBaseActivity, str, j, remindMeListener);
        } else {
            qv1.f(this.damaiBaseActivity, "抱歉，不能添加日历提醒", "距开抢前10分钟不能添加日历提醒，请实时关注商品动态");
        }
    }

    static /* synthetic */ void processCalendarRemind$default(ProjectTimerAndStrategyTmPromptView projectTimerAndStrategyTmPromptView, boolean z, String str, long j, CalendarsResolver.RemindMeListener remindMeListener, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        projectTimerAndStrategyTmPromptView.processCalendarRemind(z, str, j, remindMeListener);
    }

    private final void promptSaleDescWidth(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1536801755")) {
            ipChange.ipc$dispatch("1536801755", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            ConstraintLayout.LayoutParams layoutParams = this.promptExchangeDescParam;
            if (layoutParams != null) {
                layoutParams.matchConstraintMaxWidth = m62.a(this.damaiBaseActivity, 105.0f);
            }
            ConstraintLayout.LayoutParams layoutParams2 = this.promptExchangeDescParam;
            if (layoutParams2 == null) {
                return;
            }
            layoutParams2.matchConstraintMinWidth = m62.a(this.damaiBaseActivity, 95.0f);
        } else {
            ConstraintLayout.LayoutParams layoutParams3 = this.normalSaleTimeDescParam;
            if (layoutParams3 != null) {
                layoutParams3.matchConstraintMaxWidth = m62.a(this.damaiBaseActivity, 181.0f);
            }
            ConstraintLayout.LayoutParams layoutParams4 = this.normalSaleTimeDescParam;
            if (layoutParams4 == null) {
                return;
            }
            layoutParams4.matchConstraintMinWidth = m62.a(this.damaiBaseActivity, 151.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void promptUpdateRemindMeBtnText(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792271472")) {
            ipChange.ipc$dispatch("-1792271472", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        TextView textView = this.mTvPromptRemindMeButton;
        if (textView != null) {
            textView.setText(z ? "取消提醒" : "添加提醒");
        }
        TextView textView2 = this.mTvPromptRemindMeButton;
        if (textView2 != null) {
            textView2.setBackground(ResourcesCompat.getDrawable(getResources(), z ? R$drawable.bg_border_corner_1a0_25 : R$drawable.bg_trans_border_ff866e_corner11, null));
        }
        TextView textView3 = this.mTvPromptRemindMeButton;
        if (textView3 != null) {
            textView3.setTextColor(ResourcesCompat.getColor(getResources(), z ? R$color.color_69717C : R$color.color_FF2869, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void strategyAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "909677443")) {
            ipChange.ipc$dispatch("909677443", new Object[]{this});
            return;
        }
        a aVar = new a(this.downTime, this.intervalTime);
        this.timeDown = aVar;
        aVar.start();
    }

    private final void tmVipCountDownView(final ProjectMemberPrompt projectMemberPrompt) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1964754181")) {
            ipChange.ipc$dispatch("1964754181", new Object[]{this, projectMemberPrompt});
            return;
        }
        if (projectMemberPrompt != null) {
            this.memberPrompt = projectMemberPrompt;
            TextView textView = this.promptExchangeType;
            if (textView != null) {
                textView.setText(projectMemberPrompt.getPriorityPurchaseTypeName());
            }
            cn.damai.common.image.a b2 = cn.damai.common.image.a.b();
            String vipLogo = projectMemberPrompt.getVipLogo();
            ImageView imageView = this.promptVipIcon;
            int i = R$drawable.trade_tm_vip_icon;
            b2.loadinto(vipLogo, imageView, i, i);
            TextView textView2 = this.promptExchangeAction;
            if (textView2 != null) {
                textView2.setText(projectMemberPrompt.getButtonText());
            }
            if (projectMemberPrompt.isButtonLight()) {
                TextView textView3 = this.promptExchangeAction;
                if (textView3 != null) {
                    textView3.setBackgroundResource(R$drawable.bg_f5ac8b_ff886e_corner11);
                }
            } else {
                TextView textView4 = this.promptExchangeAction;
                if (textView4 != null) {
                    textView4.setBackgroundResource(R$drawable.bg_half_f5ac8b_ff886e_corner11);
                }
            }
            pp2.u().a2(this.promptExchangeAction, this.mProjectId, projectMemberPrompt.isPromptBeforeSale() ? "1" : "2", projectMemberPrompt.getButtonStatus());
            TextView textView5 = this.normalSaleDesc;
            if (textView5 != null) {
                textView5.setText(projectMemberPrompt.getLaunchTag());
            }
            TextView textView6 = this.normalSaleTimeDesc;
            if (textView6 != null) {
                textView6.setText(projectMemberPrompt.getLaunchTime());
            }
            if (projectMemberPrompt.isPromptBeforeSale()) {
                TextView textView7 = this.promptExchangeDesc;
                if (textView7 != null) {
                    textView7.setText(projectMemberPrompt.getPreBuyTime());
                }
                ImageView imageView2 = this.promptExchangeDescIcon;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                TextView textView8 = this.mTvPromptRemindMeButton;
                if (textView8 != null) {
                    textView8.setVisibility(0);
                }
                promptSaleDescWidth(true);
                normalSaleDescWidth(true);
            } else {
                ImageView imageView3 = this.promptExchangeDescIcon;
                if (imageView3 != null) {
                    imageView3.setVisibility(0);
                }
                TextView textView9 = this.promptExchangeDesc;
                if (textView9 != null) {
                    textView9.setText(projectMemberPrompt.getSnatchTicketsTag());
                }
                TextView textView10 = this.mTvPromptRemindMeButton;
                if (textView10 != null) {
                    textView10.setVisibility(8);
                }
                ConstraintLayout.LayoutParams layoutParams = this.exchangeActionParam;
                if (layoutParams != null) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
                }
                if (layoutParams != null) {
                    layoutParams.topToTop = 0;
                }
                if (layoutParams != null) {
                    layoutParams.bottomToBottom = 0;
                }
                promptSaleDescWidth(false);
                normalSaleDescWidth(true);
            }
            ConstraintLayout constraintLayout = this.exchangeLayout;
            if (constraintLayout != null) {
                constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: tb.tw1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ProjectTimerAndStrategyTmPromptView.m98tmVipCountDownView$lambda5$lambda4(ProjectTimerAndStrategyTmPromptView.this, projectMemberPrompt, view);
                    }
                });
            }
            updateCalendRemindText(true);
        }
        TextView textView11 = this.mTvPromptRemindMeButton;
        if (textView11 != null) {
            textView11.setOnClickListener(new View.OnClickListener() { // from class: tb.qw1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProjectTimerAndStrategyTmPromptView.m99tmVipCountDownView$lambda6(ProjectTimerAndStrategyTmPromptView.this, view);
                }
            });
        }
        TextView textView12 = this.mTvRemindMeButton;
        if (textView12 != null) {
            textView12.setOnClickListener(new View.OnClickListener() { // from class: tb.rw1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProjectTimerAndStrategyTmPromptView.m100tmVipCountDownView$lambda7(ProjectTimerAndStrategyTmPromptView.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: tmVipCountDownView$lambda-5$lambda-4  reason: not valid java name */
    public static final void m98tmVipCountDownView$lambda5$lambda4(ProjectTimerAndStrategyTmPromptView projectTimerAndStrategyTmPromptView, ProjectMemberPrompt projectMemberPrompt, View view) {
        boolean s;
        boolean s2;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "463144193")) {
            ipChange.ipc$dispatch("463144193", new Object[]{projectTimerAndStrategyTmPromptView, projectMemberPrompt, view});
            return;
        }
        b41.i(projectTimerAndStrategyTmPromptView, "this$0");
        cn.damai.common.user.c.e().x(pp2.u().Z1(projectTimerAndStrategyTmPromptView.mProjectId, projectMemberPrompt.isPromptBeforeSale() ? "1" : "2", projectMemberPrompt.getButtonStatus()));
        if (LoginManager.k().q()) {
            if (projectMemberPrompt.isMemberAuthPage()) {
                DMNav.from(projectTimerAndStrategyTmPromptView.mContext).toUri(k23.j());
                return;
            } else if (projectMemberPrompt.isSpeedUpCardPage()) {
                String speedUpCardUrl = projectMemberPrompt.getSpeedUpCardUrl();
                if (speedUpCardUrl != null) {
                    s2 = o.s(speedUpCardUrl);
                    if (!s2) {
                        z = false;
                    }
                }
                if (z) {
                    return;
                }
                DMNav.from(projectTimerAndStrategyTmPromptView.mContext).toUri(projectMemberPrompt.getSpeedUpCardUrl());
                return;
            } else if (projectMemberPrompt.isMemberAlipayPage()) {
                String alipayDetailUrl = projectMemberPrompt.getAlipayDetailUrl();
                if (alipayDetailUrl != null) {
                    s = o.s(alipayDetailUrl);
                    if (!s) {
                        z = false;
                    }
                }
                if (z) {
                    return;
                }
                DMNav.from(projectTimerAndStrategyTmPromptView.mContext).toUri(projectMemberPrompt.getAlipayDetailUrl());
                return;
            } else if (projectMemberPrompt.isAuthPopWindow()) {
                k23.g(projectTimerAndStrategyTmPromptView.mContext, projectTimerAndStrategyTmPromptView.damaiBaseActivity, gb.PROJECT_PAGE, new e());
                return;
            } else {
                ProjectPromptListener projectPromptListener = projectTimerAndStrategyTmPromptView.promptListener;
                if (projectPromptListener != null) {
                    projectPromptListener.showVIPCreditExchange();
                    return;
                }
                return;
            }
        }
        LoginManager.k().x(projectTimerAndStrategyTmPromptView.damaiBaseActivity, new Intent(), 4130);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: tmVipCountDownView$lambda-6  reason: not valid java name */
    public static final void m99tmVipCountDownView$lambda6(ProjectTimerAndStrategyTmPromptView projectTimerAndStrategyTmPromptView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-736924836")) {
            ipChange.ipc$dispatch("-736924836", new Object[]{projectTimerAndStrategyTmPromptView, view});
            return;
        }
        b41.i(projectTimerAndStrategyTmPromptView, "this$0");
        projectTimerAndStrategyTmPromptView.processCalendarRemind(projectTimerAndStrategyTmPromptView.enableCalenderRemind(true), projectTimerAndStrategyTmPromptView.itemName, projectTimerAndStrategyTmPromptView.getCalendSellTime(true), projectTimerAndStrategyTmPromptView.promptCalenderRemindMeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: tmVipCountDownView$lambda-7  reason: not valid java name */
    public static final void m100tmVipCountDownView$lambda7(ProjectTimerAndStrategyTmPromptView projectTimerAndStrategyTmPromptView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592515141")) {
            ipChange.ipc$dispatch("-592515141", new Object[]{projectTimerAndStrategyTmPromptView, view});
            return;
        }
        b41.i(projectTimerAndStrategyTmPromptView, "this$0");
        projectTimerAndStrategyTmPromptView.processCalendarRemind(projectTimerAndStrategyTmPromptView.enableCalenderRemind(false), projectTimerAndStrategyTmPromptView.itemName, projectTimerAndStrategyTmPromptView.getCalendSellTime(false), projectTimerAndStrategyTmPromptView.calendRemindMeListener);
    }

    private final void tmVipCountDownViewHide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-268877133")) {
            ipChange.ipc$dispatch("-268877133", new Object[]{this});
            return;
        }
        setTmLottieStrategy(false, false);
        setVisibility(8);
    }

    private final void tmVipCountDownViewShow(ProjectMemberPrompt projectMemberPrompt, boolean z) {
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "1950667980")) {
            ipChange.ipc$dispatch("1950667980", new Object[]{this, projectMemberPrompt, Boolean.valueOf(z)});
            return;
        }
        setVisibility(0);
        tmVipCountDownView(projectMemberPrompt);
        setTmLottieStrategy((!this.hasRobTicketStrategyModule || projectMemberPrompt == null) ? false : false, z);
    }

    private final void updateCalendRemindText(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1216992501")) {
            ipChange.ipc$dispatch("1216992501", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            if (!ir1.i(mr1.CALENDAR)) {
                promptUpdateRemindMeBtnText(false);
                updateRemindMeBtnText(false);
                return;
            }
            promptUpdateRemindMeBtnText(qv1.d(this.damaiBaseActivity, this.itemName, getCalendSellTime(true)));
            updateRemindMeBtnText(qv1.d(this.damaiBaseActivity, this.itemName, getCalendSellTime(false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRemindMeBtnText(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1012263444")) {
            ipChange.ipc$dispatch("1012263444", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        TextView textView = this.mTvRemindMeButton;
        if (textView != null) {
            textView.setText(z ? "取消提醒" : "添加提醒");
        }
        TextView textView2 = this.mTvRemindMeButton;
        if (textView2 != null) {
            textView2.setBackground(ResourcesCompat.getDrawable(getResources(), z ? R$drawable.bg_border_corner_1a0_25 : R$drawable.bg_trans_border_ff866e_corner11, null));
        }
        TextView textView3 = this.mTvRemindMeButton;
        if (textView3 != null) {
            textView3.setTextColor(getResources().getColor(z ? R$color.color_69717C : R$color.color_FF2869));
        }
    }

    public final void cancelDownAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2082919450")) {
            ipChange.ipc$dispatch("2082919450", new Object[]{this});
            return;
        }
        CountDownTimer countDownTimer = this.timeDown;
        if (countDownTimer != null) {
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.timeDown = null;
        }
    }

    public final void hideResetAttendees() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1229863131")) {
            ipChange.ipc$dispatch("1229863131", new Object[]{this});
        } else {
            playAnim(this.mResetAttendeesLayoutCl, 8);
        }
    }

    public final void setCountDownTime(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        long j;
        long j2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130382163")) {
            ipChange.ipc$dispatch("2130382163", new Object[]{this, str, str2, str3, str4});
            return;
        }
        String str5 = str + "天 " + str2 + jn1.CONDITION_IF_MIDDLE + str3 + jn1.CONDITION_IF_MIDDLE + str4;
        ProjectMemberPrompt projectMemberPrompt = this.memberPrompt;
        if (projectMemberPrompt != null) {
            if (projectMemberPrompt.isPromptBeforeSale()) {
                DMDigitTextView dMDigitTextView = this.promptExchangeCountDown;
                if (dMDigitTextView != null) {
                    dMDigitTextView.setText(str5);
                }
                DMDigitTextView dMDigitTextView2 = this.promptExchangeCountDown;
                if (dMDigitTextView2 != null) {
                    dMDigitTextView2.setVisibility(0);
                }
                DMDigitTextView dMDigitTextView3 = this.normalSaleCountDown;
                if (dMDigitTextView3 != null) {
                    dMDigitTextView3.setVisibility(8);
                }
            } else {
                DMDigitTextView dMDigitTextView4 = this.normalSaleCountDown;
                if (dMDigitTextView4 != null) {
                    dMDigitTextView4.setText(str5);
                }
                DMDigitTextView dMDigitTextView5 = this.promptExchangeCountDown;
                if (dMDigitTextView5 != null) {
                    dMDigitTextView5.setVisibility(8);
                }
                DMDigitTextView dMDigitTextView6 = this.normalSaleCountDown;
                if (dMDigitTextView6 != null) {
                    dMDigitTextView6.setVisibility(0);
                }
            }
        }
        try {
            if (TextUtils.isEmpty(str)) {
                j = 0;
            } else {
                Long valueOf = Long.valueOf(str);
                b41.h(valueOf, "valueOf(days)");
                j = valueOf.longValue();
            }
            if (j > 0) {
                enableClickRemindMeBtn();
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                j2 = 0;
            } else {
                Long valueOf2 = Long.valueOf(str2);
                b41.h(valueOf2, "valueOf(hours)");
                j2 = valueOf2.longValue();
            }
            if (j2 > 0) {
                enableClickRemindMeBtn();
                return;
            }
            Long valueOf3 = Long.valueOf(str3);
            b41.h(valueOf3, "min");
            if (valueOf3.longValue() > this.minMark) {
                enableClickRemindMeBtn();
            } else {
                disEnableClickRemindMeBtn();
            }
        } catch (Exception unused) {
            this.minType = ProjectTimerAndStagoryView.TypeEnum.INIT;
        }
    }

    @Nullable
    public final ProjectTimerAndStagoryView.StateEnum setCountDownVisibility(boolean z, boolean z2, @Nullable ProjectMemberPrompt projectMemberPrompt, boolean z3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1880589254")) {
            return (ProjectTimerAndStagoryView.StateEnum) ipChange.ipc$dispatch("-1880589254", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), projectMemberPrompt, Boolean.valueOf(z3)});
        }
        if (z) {
            if (projectMemberPrompt != null) {
                tmVipCountDownViewShow(projectMemberPrompt, z3);
            }
            return ProjectTimerAndStagoryView.StateEnum.TIMER;
        }
        tmVipCountDownViewHide();
        return ProjectTimerAndStagoryView.StateEnum.INIT;
    }

    public final void setItemName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1518410445")) {
            ipChange.ipc$dispatch("1518410445", new Object[]{this, str});
        } else {
            this.itemName = str;
        }
    }

    public final void setOnStrategyClickListener(@Nullable View.OnClickListener onClickListener) {
        LottieAnimationView lottieAnimationView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-689211270")) {
            ipChange.ipc$dispatch("-689211270", new Object[]{this, onClickListener});
        } else if (onClickListener == null || (lottieAnimationView = this.lottieTmStrategy) == null) {
        } else {
            lottieAnimationView.setOnClickListener(onClickListener);
        }
    }

    public final void setProjectId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-454721633")) {
            ipChange.ipc$dispatch("-454721633", new Object[]{this, str});
        } else {
            this.mProjectId = str;
        }
    }

    public final void setPromptParam(@NotNull ProjectDetailActivity projectDetailActivity, @NotNull ProjectPromptListener projectPromptListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-207251512")) {
            ipChange.ipc$dispatch("-207251512", new Object[]{this, projectDetailActivity, projectPromptListener});
            return;
        }
        b41.i(projectDetailActivity, "damaiBaseActivity");
        b41.i(projectPromptListener, "lister");
        this.damaiBaseActivity = projectDetailActivity;
        this.promptListener = projectPromptListener;
    }

    @NotNull
    public final ProjectTimerAndStagoryView.StateEnum setTmLottieStrategy(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "336943874")) {
            return (ProjectTimerAndStagoryView.StateEnum) ipChange.ipc$dispatch("336943874", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
        this.hasRobTicketStrategyModule = z;
        if (z) {
            LottieAnimationView lottieAnimationView = this.lottieTmStrategy;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
            }
            if (z2) {
                pp2.u().c2(this.mResetAttendeesLayoutCl, this.mProjectId);
                playAnim(this.mResetAttendeesLayoutCl, 0);
            }
            View view = this.lottieTmStrategyHolder;
            if (view != null) {
                view.setVisibility(0);
            }
            LottieAnimationView lottieAnimationView2 = this.lottieTmStrategy;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.setAnimation(R$raw.trade_prompt_strategy);
            }
            LottieAnimationView lottieAnimationView3 = this.lottieTmStrategy;
            if (lottieAnimationView3 != null) {
                lottieAnimationView3.playAnimation();
            }
        } else {
            LottieAnimationView lottieAnimationView4 = this.lottieTmStrategy;
            if (lottieAnimationView4 != null) {
                lottieAnimationView4.setVisibility(8);
            }
            View view2 = this.lottieTmStrategyHolder;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            cancelDownAnim();
        }
        return ProjectTimerAndStagoryView.StateEnum.TIMER;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProjectTimerAndStrategyTmPromptView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.itemName = "";
        this.minMark = 9;
        this.minType = ProjectTimerAndStagoryView.TypeEnum.INIT;
        this.downTime = 5525L;
        this.intervalTime = 500L;
        this.mContext = context;
        init();
        this.calendRemindMeListener = new b();
        this.promptCalenderRemindMeListener = new d();
    }
}
