package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view;

import android.app.Activity;
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
import android.widget.Space;
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
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ITimeCountDownManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.TimeCountDownManagerImpl;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectSpecialBuyPromptView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStagoryView;
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
import tb.mr1;
import tb.pp2;
import tb.qv1;
import tb.s60;
import tb.v;
import tb.zn2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ProjectSpecialBuyPromptView extends LineLinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final CalendarsResolver.RemindMeListener calenderRemindMeListener;
    @Nullable
    private OnTimeCountDownListener countDownListener;
    private final long downTime;
    private boolean hasRobTicketStrategyModule;
    private final long intervalTime;
    private boolean isPlaying;
    @Nullable
    private String itemName;
    @NotNull
    private final LottieAnimationView lottieTmStrategy;
    @Nullable
    private ProjectMemberPrompt memberPromptMo;
    private final int minMark;
    @NotNull
    private ProjectTimerAndStagoryView.TypeEnum minType;
    @Nullable
    private String projectId;
    @NotNull
    private final TextView projectTimerAction;
    @NotNull
    private final DMDigitTextView projectTimerDay;
    @NotNull
    private final TextView projectTimerDayTxt;
    @NotNull
    private final TextView projectTimerDesc;
    @NotNull
    private final DMDigitTextView projectTimerHours;
    @NotNull
    private final ViewGroup projectTimerLayout;
    @NotNull
    private final ImageView promptDescIcon;
    @NotNull
    private final TextView promptExchangeActionView;
    @NotNull
    private final TextView promptExchangeDesc;
    @NotNull
    private final TextView promptExchangeType;
    @NotNull
    private final ViewGroup promptLayout;
    @Nullable
    private SpecialBuyPromptListener promptListener;
    @NotNull
    private final ImageView promptVipLogoImg;
    @NotNull
    private final DMIconFontTextView resetAttendeesCloseBtn;
    @NotNull
    private final ConstraintLayout resetAttendeesLayout;
    @NotNull
    private final TextView resetAttendeesMidTv;
    @NotNull
    private final TextView resetAttendeesTitleTv;
    @NotNull
    private final Space spaceView;
    @Nullable
    private CountDownTimer timeDown;
    @Nullable
    private ITimeCountDownManager timerCountDownManager;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface SpecialBuyPromptListener {
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
            if (AndroidInstantRuntime.support(ipChange, "389128893")) {
                ipChange.ipc$dispatch("389128893", new Object[]{this});
                return;
            }
            ProjectSpecialBuyPromptView.this.lottieTmStrategy.playAnimation();
            ProjectSpecialBuyPromptView.this.cancelDownAnim();
            ProjectSpecialBuyPromptView.this.strategyAnim();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1374798065")) {
                ipChange.ipc$dispatch("1374798065", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class b implements OnTimeCountDownListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownFinished(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-894190087")) {
                ipChange.ipc$dispatch("-894190087", new Object[]{this, Long.valueOf(j)});
                return;
            }
            OnTimeCountDownListener countDownListener = ProjectSpecialBuyPromptView.this.getCountDownListener();
            if (countDownListener != null) {
                countDownListener.onCountDownFinished(j);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownStart(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "666708371")) {
                ipChange.ipc$dispatch("666708371", new Object[]{this, str, str2, str3, str4});
                return;
            }
            OnTimeCountDownListener countDownListener = ProjectSpecialBuyPromptView.this.getCountDownListener();
            if (countDownListener != null) {
                countDownListener.onCountDownStart(str, str2, str3, str4);
            }
            ProjectSpecialBuyPromptView.this.setCountDownTime(str, str2, str3, str4);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownTip(long j, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1651058790")) {
                ipChange.ipc$dispatch("-1651058790", new Object[]{this, Long.valueOf(j), str, str2, str3, str4});
                return;
            }
            OnTimeCountDownListener countDownListener = ProjectSpecialBuyPromptView.this.getCountDownListener();
            if (countDownListener != null) {
                countDownListener.onCountDownTip(j, str, str2, str3, str4);
            }
            ProjectSpecialBuyPromptView.this.setCountDownTime(str, str2, str3, str4);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class c implements MemberAuthPopWindow.ICustomDialogEventListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow.ICustomDialogEventListener
        public void dialogItemEvent(@Nullable String str) {
            SpecialBuyPromptListener promptListener;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "188432789")) {
                ipChange.ipc$dispatch("188432789", new Object[]{this, str});
            } else if (!b41.d("success", str) || (promptListener = ProjectSpecialBuyPromptView.this.getPromptListener()) == null) {
            } else {
                promptListener.onVipRefresh();
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
            if (AndroidInstantRuntime.support(ipChange, "-1997592909")) {
                ipChange.ipc$dispatch("-1997592909", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(pp2.u().c1(ProjectSpecialBuyPromptView.this.getProjectId(), "1"));
            ProjectSpecialBuyPromptView.this.updateProjectReminderBtnText(true);
            ProjectSpecialBuyPromptView.this.addReminderSuccessDialog();
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void candelRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-120370649")) {
                ipChange.ipc$dispatch("-120370649", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(pp2.u().c1(ProjectSpecialBuyPromptView.this.getProjectId(), "2"));
            ProjectSpecialBuyPromptView.this.updateProjectReminderBtnText(false);
            ProjectSpecialBuyPromptView.this.cancelReminderSuccess();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static final class e implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ View b;
        final /* synthetic */ ProjectSpecialBuyPromptView c;

        e(int i, View view, ProjectSpecialBuyPromptView projectSpecialBuyPromptView) {
            this.a = i;
            this.b = view;
            this.c = projectSpecialBuyPromptView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1758832164")) {
                ipChange.ipc$dispatch("-1758832164", new Object[]{this, animation});
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
            if (AndroidInstantRuntime.support(ipChange, "719407128")) {
                ipChange.ipc$dispatch("719407128", new Object[]{this, animation});
            } else {
                b41.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "474605109")) {
                ipChange.ipc$dispatch("474605109", new Object[]{this, animation});
            } else {
                b41.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProjectSpecialBuyPromptView(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ ProjectSpecialBuyPromptView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m89_init_$lambda0(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "385257596")) {
            ipChange.ipc$dispatch("385257596", new Object[]{view});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m90_init_$lambda1(ProjectSpecialBuyPromptView projectSpecialBuyPromptView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-819796001")) {
            ipChange.ipc$dispatch("-819796001", new Object[]{projectSpecialBuyPromptView, view});
            return;
        }
        b41.i(projectSpecialBuyPromptView, "this$0");
        cn.damai.common.user.c.e().x(pp2.u().b2(projectSpecialBuyPromptView.projectId));
        projectSpecialBuyPromptView.playAnim(projectSpecialBuyPromptView.resetAttendeesLayout, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m91_init_$lambda2(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1420180738")) {
            ipChange.ipc$dispatch("-1420180738", new Object[]{view});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addReminderSuccessDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401746370")) {
            ipChange.ipc$dispatch("-401746370", new Object[]{this});
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            qv1.f(activity, "添加日历提醒成功", "开抢前10分钟将收到手机日历提醒，可在系统日历中更改提醒时间");
        }
    }

    private final void bindProjectTimerView(final ProjectMemberPrompt projectMemberPrompt) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2068872744")) {
            ipChange.ipc$dispatch("-2068872744", new Object[]{this, projectMemberPrompt});
        } else if (projectMemberPrompt.isPromptInSale()) {
            this.projectTimerLayout.setVisibility(8);
            this.spaceView.setVisibility(8);
        } else {
            this.projectTimerLayout.setVisibility(0);
            this.spaceView.setVisibility(0);
            this.projectTimerDesc.setText(projectMemberPrompt.getPreBuyTime());
            if (this.timerCountDownManager == null) {
                this.timerCountDownManager = TimeCountDownManagerImpl.c(new b());
            }
            long scd = projectMemberPrompt.getScd();
            long a2 = zn2.a();
            if (scd > 0 && scd > a2) {
                ITimeCountDownManager iTimeCountDownManager = this.timerCountDownManager;
                if (iTimeCountDownManager != null) {
                    iTimeCountDownManager.setCountDown(scd - a2);
                }
                ITimeCountDownManager iTimeCountDownManager2 = this.timerCountDownManager;
                if (iTimeCountDownManager2 != null) {
                    iTimeCountDownManager2.startCountDown();
                }
            }
            this.projectTimerAction.setOnClickListener(new View.OnClickListener() { // from class: tb.kw1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProjectSpecialBuyPromptView.m92bindProjectTimerView$lambda4(ProjectSpecialBuyPromptView.this, projectMemberPrompt, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindProjectTimerView$lambda-4  reason: not valid java name */
    public static final void m92bindProjectTimerView$lambda4(ProjectSpecialBuyPromptView projectSpecialBuyPromptView, ProjectMemberPrompt projectMemberPrompt, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "364076362")) {
            ipChange.ipc$dispatch("364076362", new Object[]{projectSpecialBuyPromptView, projectMemberPrompt, view});
            return;
        }
        b41.i(projectSpecialBuyPromptView, "this$0");
        b41.i(projectMemberPrompt, "$memberPromptMo");
        projectSpecialBuyPromptView.processCalendarRemind(projectSpecialBuyPromptView.enableCalenderRemind(), projectSpecialBuyPromptView.itemName, projectMemberPrompt.getPreBuyTimestamp(), projectSpecialBuyPromptView.calenderRemindMeListener);
    }

    private final void bindPromptView(final ProjectMemberPrompt projectMemberPrompt) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "691291680")) {
            ipChange.ipc$dispatch("691291680", new Object[]{this, projectMemberPrompt});
            return;
        }
        TextView textView = this.promptExchangeType;
        String priorityPurchaseTypeName = projectMemberPrompt.getPriorityPurchaseTypeName();
        if (priorityPurchaseTypeName == null) {
            priorityPurchaseTypeName = "专享购";
        }
        textView.setText(priorityPurchaseTypeName);
        this.promptExchangeType.getPaint().setFakeBoldText(true);
        cn.damai.common.image.a b2 = cn.damai.common.image.a.b();
        String vipLogo = projectMemberPrompt.getVipLogo();
        ImageView imageView = this.promptVipLogoImg;
        int i = R$drawable.trade_tm_vip_icon;
        b2.loadinto(vipLogo, imageView, i, i);
        this.promptExchangeDesc.setText(projectMemberPrompt.getSnatchTicketsTag());
        this.promptDescIcon.setVisibility(b41.d(projectMemberPrompt.getPrivilegeStart(), Boolean.TRUE) ? 0 : 8);
        this.promptExchangeActionView.setText(projectMemberPrompt.getButtonText());
        this.promptExchangeActionView.setBackgroundResource(projectMemberPrompt.isButtonLight() ? R$drawable.bg_f5ac8b_ff886e_corner11 : R$drawable.bg_half_f5ac8b_ff886e_corner11);
        pp2.u().j2(this.promptExchangeActionView, this.projectId, projectMemberPrompt.isPromptBeforeSale() ? "1" : "2", projectMemberPrompt.getButtonStatus());
        this.promptLayout.setOnClickListener(new View.OnClickListener() { // from class: tb.jw1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProjectSpecialBuyPromptView.m93bindPromptView$lambda3(ProjectSpecialBuyPromptView.this, projectMemberPrompt, view);
            }
        });
        if (projectMemberPrompt.isPromptBeforeSale()) {
            ViewGroup.LayoutParams layoutParams = this.promptExchangeActionView.getLayoutParams();
            marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                s60 s60Var = s60.INSTANCE;
                Context context = getContext();
                b41.h(context, WPKFactory.INIT_KEY_CONTEXT);
                marginLayoutParams.bottomMargin = s60Var.a(context, 7.5f);
            }
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.promptExchangeActionView.getLayoutParams();
            marginLayoutParams = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            if (marginLayoutParams != null) {
                s60 s60Var2 = s60.INSTANCE;
                Context context2 = getContext();
                b41.h(context2, WPKFactory.INIT_KEY_CONTEXT);
                marginLayoutParams.bottomMargin = s60Var2.a(context2, 19.5f);
            }
        }
        updateCalenderReminderText(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindPromptView$lambda-3  reason: not valid java name */
    public static final void m93bindPromptView$lambda3(ProjectSpecialBuyPromptView projectSpecialBuyPromptView, ProjectMemberPrompt projectMemberPrompt, View view) {
        boolean s;
        boolean s2;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-810856605")) {
            ipChange.ipc$dispatch("-810856605", new Object[]{projectSpecialBuyPromptView, projectMemberPrompt, view});
            return;
        }
        b41.i(projectSpecialBuyPromptView, "this$0");
        b41.i(projectMemberPrompt, "$memberPromptMo");
        cn.damai.common.user.c.e().x(pp2.u().i2(projectSpecialBuyPromptView.projectId, projectMemberPrompt.isPromptBeforeSale() ? "1" : "2", projectMemberPrompt.getButtonStatus()));
        if (LoginManager.k().q()) {
            if (projectMemberPrompt.isMemberAuthPage()) {
                DMNav.from(projectSpecialBuyPromptView.getContext()).toUri(k23.j());
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
                DMNav.from(projectSpecialBuyPromptView.getContext()).toUri(projectMemberPrompt.getSpeedUpCardUrl());
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
                DMNav.from(projectSpecialBuyPromptView.getContext()).toUri(projectMemberPrompt.getAlipayDetailUrl());
                return;
            } else if (projectMemberPrompt.isAuthPopWindow()) {
                Context context = projectSpecialBuyPromptView.getContext();
                Context context2 = projectSpecialBuyPromptView.getContext();
                k23.g(context, context2 instanceof Activity ? (Activity) context2 : null, gb.PROJECT_PAGE, new c());
                return;
            } else {
                SpecialBuyPromptListener specialBuyPromptListener = projectSpecialBuyPromptView.promptListener;
                if (specialBuyPromptListener != null) {
                    specialBuyPromptListener.showVIPCreditExchange();
                    return;
                }
                return;
            }
        }
        LoginManager k = LoginManager.k();
        Context context3 = projectSpecialBuyPromptView.getContext();
        k.x(context3 instanceof Activity ? (Activity) context3 : null, new Intent(), 4130);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelReminderSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-865958179")) {
            ipChange.ipc$dispatch("-865958179", new Object[]{this});
        } else {
            ToastUtil.i("取消提醒成功");
        }
    }

    private final void disEnableClickRemindMeBtn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1001613388")) {
            ipChange.ipc$dispatch("1001613388", new Object[]{this});
            return;
        }
        ProjectTimerAndStagoryView.TypeEnum typeEnum = this.minType;
        ProjectTimerAndStagoryView.TypeEnum typeEnum2 = ProjectTimerAndStagoryView.TypeEnum.LESS;
        if (typeEnum != typeEnum2) {
            this.projectTimerAction.setVisibility(8);
        }
        this.minType = typeEnum2;
    }

    private final boolean enableCalenderRemind() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1463882120")) {
            return ((Boolean) ipChange.ipc$dispatch("-1463882120", new Object[]{this})).booleanValue();
        }
        ProjectMemberPrompt projectMemberPrompt = this.memberPromptMo;
        return projectMemberPrompt != null && projectMemberPrompt.getPreBuyTimestamp() > 0 && projectMemberPrompt.getScd() > 600;
    }

    private final void enableClickRemindMeBtn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1854336092")) {
            ipChange.ipc$dispatch("1854336092", new Object[]{this});
            return;
        }
        ProjectTimerAndStagoryView.TypeEnum typeEnum = this.minType;
        ProjectTimerAndStagoryView.TypeEnum typeEnum2 = ProjectTimerAndStagoryView.TypeEnum.LARGER;
        if (typeEnum != typeEnum2) {
            this.projectTimerAction.setVisibility(0);
        }
        this.minType = typeEnum2;
    }

    private final void playAnim(final View view, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1896517278")) {
            ipChange.ipc$dispatch("-1896517278", new Object[]{this, view, Integer.valueOf(i)});
        } else if (view == null || view.getVisibility() == i || this.isPlaying) {
        } else {
            view.clearAnimation();
            final TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, i == 8 ? 0.0f : 1.0f, 2, i == 8 ? 1.0f : 0.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setAnimationListener(new e(i, view, this));
            this.isPlaying = true;
            view.post(new Runnable() { // from class: tb.nw1
                @Override // java.lang.Runnable
                public final void run() {
                    ProjectSpecialBuyPromptView.m94playAnim$lambda9(i, view, translateAnimation);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: playAnim$lambda-9  reason: not valid java name */
    public static final void m94playAnim$lambda9(int i, View view, Animation animation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1729072689")) {
            ipChange.ipc$dispatch("1729072689", new Object[]{Integer.valueOf(i), view, animation});
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
        if (AndroidInstantRuntime.support(ipChange, "301754971")) {
            ipChange.ipc$dispatch("301754971", new Object[]{this, Boolean.valueOf(z), str, Long.valueOf(j), remindMeListener});
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (z) {
                qv1.e(activity, str, j, remindMeListener);
            } else {
                qv1.f(activity, "抱歉，不能添加日历提醒", "距开抢前10分钟不能添加日历提醒，请实时关注商品动态");
            }
        }
    }

    static /* synthetic */ void processCalendarRemind$default(ProjectSpecialBuyPromptView projectSpecialBuyPromptView, boolean z, String str, long j, CalendarsResolver.RemindMeListener remindMeListener, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        projectSpecialBuyPromptView.processCalendarRemind(z, str, j, remindMeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCountDownTime(String str, String str2, String str3, String str4) {
        long j;
        long j2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1522371874")) {
            ipChange.ipc$dispatch("1522371874", new Object[]{this, str, str2, str3, str4});
            return;
        }
        this.projectTimerDay.setText(str);
        this.projectTimerHours.setText(str2 + jn1.CONDITION_IF_MIDDLE + str3 + jn1.CONDITION_IF_MIDDLE + str4);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void strategyAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1158477358")) {
            ipChange.ipc$dispatch("-1158477358", new Object[]{this});
            return;
        }
        a aVar = new a(this.downTime, this.intervalTime);
        this.timeDown = aVar;
        aVar.start();
    }

    private final void tmVipCountDownViewHide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1322556862")) {
            ipChange.ipc$dispatch("-1322556862", new Object[]{this});
            return;
        }
        setTmLottieStrategy(false, false);
        setVisibility(8);
    }

    private final void tmVipCountDownViewShow(ProjectMemberPrompt projectMemberPrompt, boolean z) {
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "1169779677")) {
            ipChange.ipc$dispatch("1169779677", new Object[]{this, projectMemberPrompt, Boolean.valueOf(z)});
            return;
        }
        setVisibility(0);
        bindData(projectMemberPrompt);
        setTmLottieStrategy((this.hasRobTicketStrategyModule && projectMemberPrompt != null && projectMemberPrompt.isPromptBeforeSale()) ? false : false, z);
    }

    private final void updateCalenderReminderText(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1944789472")) {
            ipChange.ipc$dispatch("1944789472", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            if (!ir1.i(mr1.CALENDAR)) {
                updateProjectReminderBtnText(false);
                return;
            }
            Context context = getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                String str = this.itemName;
                ProjectMemberPrompt projectMemberPrompt = this.memberPromptMo;
                updateProjectReminderBtnText(qv1.d(activity, str, projectMemberPrompt != null ? projectMemberPrompt.getPreBuyTimestamp() : 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateProjectReminderBtnText(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "38359109")) {
            ipChange.ipc$dispatch("38359109", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.projectTimerLayout.getVisibility() == 0) {
            updateProjectReminderBtnText(this.projectTimerAction, z);
        }
    }

    public final void bindData(@Nullable ProjectMemberPrompt projectMemberPrompt) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246698689")) {
            ipChange.ipc$dispatch("-1246698689", new Object[]{this, projectMemberPrompt});
            return;
        }
        this.memberPromptMo = projectMemberPrompt;
        if (projectMemberPrompt != null && (projectMemberPrompt.isPromptInSale() || projectMemberPrompt.isPromptBeforeSale())) {
            setVisibility(0);
            bindProjectTimerView(projectMemberPrompt);
            bindPromptView(projectMemberPrompt);
            return;
        }
        tmVipCountDownViewHide();
    }

    public final void cancelDownAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1138953559")) {
            ipChange.ipc$dispatch("-1138953559", new Object[]{this});
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

    @Nullable
    public final OnTimeCountDownListener getCountDownListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "103155487") ? (OnTimeCountDownListener) ipChange.ipc$dispatch("103155487", new Object[]{this}) : this.countDownListener;
    }

    @Nullable
    public final String getItemName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1038422912") ? (String) ipChange.ipc$dispatch("-1038422912", new Object[]{this}) : this.itemName;
    }

    @Nullable
    public final String getProjectId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2063541064") ? (String) ipChange.ipc$dispatch("2063541064", new Object[]{this}) : this.projectId;
    }

    @Nullable
    public final SpecialBuyPromptListener getPromptListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "630852687") ? (SpecialBuyPromptListener) ipChange.ipc$dispatch("630852687", new Object[]{this}) : this.promptListener;
    }

    @Nullable
    public final ITimeCountDownManager getTimerCountDownManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-242801790") ? (ITimeCountDownManager) ipChange.ipc$dispatch("-242801790", new Object[]{this}) : this.timerCountDownManager;
    }

    public final void hideResetAttendees() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1290041322")) {
            ipChange.ipc$dispatch("1290041322", new Object[]{this});
        } else {
            playAnim(this.resetAttendeesLayout, 8);
        }
    }

    public final void setCountDownListener(@Nullable OnTimeCountDownListener onTimeCountDownListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1204933821")) {
            ipChange.ipc$dispatch("-1204933821", new Object[]{this, onTimeCountDownListener});
        } else {
            this.countDownListener = onTimeCountDownListener;
        }
    }

    @Nullable
    public final ProjectTimerAndStagoryView.StateEnum setCountDownVisibility(boolean z, boolean z2, @Nullable ProjectMemberPrompt projectMemberPrompt, boolean z3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1284125431")) {
            return (ProjectTimerAndStagoryView.StateEnum) ipChange.ipc$dispatch("-1284125431", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), projectMemberPrompt, Boolean.valueOf(z3)});
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
        if (AndroidInstantRuntime.support(ipChange, "-2008667042")) {
            ipChange.ipc$dispatch("-2008667042", new Object[]{this, str});
        } else {
            this.itemName = str;
        }
    }

    public final void setOnStrategyClickListener(@Nullable View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1264453131")) {
            ipChange.ipc$dispatch("1264453131", new Object[]{this, onClickListener});
        } else if (onClickListener != null) {
            this.lottieTmStrategy.setOnClickListener(onClickListener);
        }
    }

    public final void setProjectId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1875025966")) {
            ipChange.ipc$dispatch("1875025966", new Object[]{this, str});
        } else {
            this.projectId = str;
        }
    }

    public final void setPromptListener(@Nullable SpecialBuyPromptListener specialBuyPromptListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1187484615")) {
            ipChange.ipc$dispatch("-1187484615", new Object[]{this, specialBuyPromptListener});
        } else {
            this.promptListener = specialBuyPromptListener;
        }
    }

    @NotNull
    public final ProjectTimerAndStagoryView.StateEnum setTmLottieStrategy(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-214849519")) {
            return (ProjectTimerAndStagoryView.StateEnum) ipChange.ipc$dispatch("-214849519", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
        this.hasRobTicketStrategyModule = z;
        if (z) {
            this.lottieTmStrategy.setVisibility(0);
            if (z2) {
                pp2.u().c2(this.resetAttendeesLayout, this.projectId);
                playAnim(this.resetAttendeesLayout, 0);
            }
            this.lottieTmStrategy.setAnimation(R$raw.trade_prompt_strategy);
            this.lottieTmStrategy.playAnimation();
        } else {
            this.lottieTmStrategy.setVisibility(8);
            cancelDownAnim();
        }
        return ProjectTimerAndStagoryView.StateEnum.TIMER;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProjectSpecialBuyPromptView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(context).inflate(R$layout.project_detail_vip_special_buy_bottom_layout, this);
        View findViewById = findViewById(R$id.ll_reset_attendees_layout);
        b41.h(findViewById, "findViewById(R.id.ll_reset_attendees_layout)");
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById;
        this.resetAttendeesLayout = constraintLayout;
        View findViewById2 = findViewById(R$id.tv_reset_attendees_title);
        b41.h(findViewById2, "findViewById(R.id.tv_reset_attendees_title)");
        this.resetAttendeesTitleTv = (TextView) findViewById2;
        View findViewById3 = findViewById(R$id.tv_reset_attendees_mid);
        b41.h(findViewById3, "findViewById(R.id.tv_reset_attendees_mid)");
        this.resetAttendeesMidTv = (TextView) findViewById3;
        View findViewById4 = findViewById(R$id.tv_close_reset_attendees);
        b41.h(findViewById4, "findViewById(R.id.tv_close_reset_attendees)");
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) findViewById4;
        this.resetAttendeesCloseBtn = dMIconFontTextView;
        View findViewById5 = findViewById(R$id.member_lottie_strategy);
        b41.h(findViewById5, "findViewById(R.id.member_lottie_strategy)");
        this.lottieTmStrategy = (LottieAnimationView) findViewById5;
        View findViewById6 = findViewById(R$id.project_timer_layout);
        b41.h(findViewById6, "findViewById(R.id.project_timer_layout)");
        ViewGroup viewGroup = (ViewGroup) findViewById6;
        this.projectTimerLayout = viewGroup;
        View findViewById7 = findViewById(R$id.prompt_timer_day);
        b41.h(findViewById7, "findViewById(R.id.prompt_timer_day)");
        this.projectTimerDay = (DMDigitTextView) findViewById7;
        View findViewById8 = findViewById(R$id.prompt_timer_day_text);
        b41.h(findViewById8, "findViewById(R.id.prompt_timer_day_text)");
        this.projectTimerDayTxt = (TextView) findViewById8;
        View findViewById9 = findViewById(R$id.prompt_timer_day_hours);
        b41.h(findViewById9, "findViewById(R.id.prompt_timer_day_hours)");
        this.projectTimerHours = (DMDigitTextView) findViewById9;
        View findViewById10 = findViewById(R$id.prompt_timer_desc);
        b41.h(findViewById10, "findViewById(R.id.prompt_timer_desc)");
        this.projectTimerDesc = (TextView) findViewById10;
        View findViewById11 = findViewById(R$id.prompt_timer_reminder);
        b41.h(findViewById11, "findViewById(R.id.prompt_timer_reminder)");
        this.projectTimerAction = (TextView) findViewById11;
        View findViewById12 = findViewById(R$id.prompt_layout);
        b41.h(findViewById12, "findViewById(R.id.prompt_layout)");
        this.promptLayout = (ViewGroup) findViewById12;
        View findViewById13 = findViewById(R$id.prompt_vip_icon);
        b41.h(findViewById13, "findViewById(R.id.prompt_vip_icon)");
        this.promptVipLogoImg = (ImageView) findViewById13;
        View findViewById14 = findViewById(R$id.prompt_exchange_desc_icon);
        b41.h(findViewById14, "findViewById(R.id.prompt_exchange_desc_icon)");
        this.promptDescIcon = (ImageView) findViewById14;
        View findViewById15 = findViewById(R$id.prompt_desc);
        b41.h(findViewById15, "findViewById(R.id.prompt_desc)");
        this.promptExchangeDesc = (TextView) findViewById15;
        View findViewById16 = findViewById(R$id.prompt_exchange_action);
        b41.h(findViewById16, "findViewById(R.id.prompt_exchange_action)");
        this.promptExchangeActionView = (TextView) findViewById16;
        View findViewById17 = findViewById(R$id.prompt_timer_exchange_type);
        b41.h(findViewById17, "findViewById(R.id.prompt_timer_exchange_type)");
        this.promptExchangeType = (TextView) findViewById17;
        View findViewById18 = findViewById(R$id.space);
        b41.h(findViewById18, "findViewById(R.id.space)");
        this.spaceView = (Space) findViewById18;
        this.minMark = 9;
        this.minType = ProjectTimerAndStagoryView.TypeEnum.INIT;
        this.downTime = 5525L;
        this.intervalTime = 500L;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: tb.lw1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProjectSpecialBuyPromptView.m89_init_$lambda0(view);
            }
        });
        dMIconFontTextView.setOnClickListener(new View.OnClickListener() { // from class: tb.iw1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProjectSpecialBuyPromptView.m90_init_$lambda1(ProjectSpecialBuyPromptView.this, view);
            }
        });
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: tb.mw1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProjectSpecialBuyPromptView.m91_init_$lambda2(view);
            }
        });
        this.calenderRemindMeListener = new d();
    }

    private final void updateProjectReminderBtnText(TextView textView, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-508639041")) {
            ipChange.ipc$dispatch("-508639041", new Object[]{this, textView, Boolean.valueOf(z)});
            return;
        }
        textView.setText(z ? "取消提醒" : "添加提醒");
        textView.setBackground(ResourcesCompat.getDrawable(getResources(), z ? R$drawable.bg_border_corner_1a0_25 : R$drawable.bg_trans_border_ff866e_corner11, null));
        textView.setTextColor(ResourcesCompat.getColor(getResources(), z ? R$color.color_69717C : R$color.color_FF866E, null));
    }
}
