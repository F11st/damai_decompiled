package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.damai.common.user.C0529c;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$raw;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStagoryView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.pp2;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectTimerAndStagoryView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int LOTTIE_TYPE_NONE_STRATEGY = 2;
    private static final int LOTTIE_TYPE_STRATEGY = 1;
    private ImageView countDownTip;
    private boolean isPlaying;
    private boolean isShowing;
    private LottieAnimationView lottieStrategy;
    private Context mContex;
    private LinearLayout mCountDownLayout;
    private View mLineView;
    private String mProjectId;
    private DMIconFontTextView mResetAttendeesCloseBtn;
    private ConstraintLayout mResetAttendeesLayoutCl;
    private TextView mResetAttendeesMidTv;
    private TextView mResetAttendeesTitleTv;
    private RelativeLayout mSingleStagoryLayout;
    private LinearLayout mTimeAndStagoryLayout;
    private TextView mTvCountDownRemindText;
    private TextView mTvDay;
    private TextView mTvHour;
    private TextView mTvMinute;
    private TextView mTvRemindMeButton;
    private TextView mTvSecond;
    private TextView mTvStrategy;
    private final int minMark;
    private TypeEnum minType;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public enum StateEnum {
        INIT,
        TIMER,
        STAGORY
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public enum TypeEnum {
        INIT,
        LARGER,
        LESS
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStagoryView$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2364a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2364a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1386342834")) {
                ipChange.ipc$dispatch("1386342834", new Object[]{this, view});
                return;
            }
            C0529c.e().x(pp2.u().b2(ProjectTimerAndStagoryView.this.mProjectId));
            ProjectTimerAndStagoryView projectTimerAndStagoryView = ProjectTimerAndStagoryView.this;
            projectTimerAndStagoryView.playAnim(projectTimerAndStagoryView.mResetAttendeesLayoutCl, 8);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStagoryView$b  reason: invalid class name */
    /* loaded from: classes16.dex */
    public class animationAnimation$AnimationListenerC2365b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ View b;

        animationAnimation$AnimationListenerC2365b(int i, View view) {
            this.a = i;
            this.b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1863848692")) {
                ipChange.ipc$dispatch("-1863848692", new Object[]{this, animation});
                return;
            }
            if (this.a == 8) {
                this.b.setVisibility(8);
            }
            ProjectTimerAndStagoryView.this.isPlaying = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1091787032")) {
                ipChange.ipc$dispatch("-1091787032", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1662030491")) {
                ipChange.ipc$dispatch("-1662030491", new Object[]{this, animation});
            }
        }
    }

    public ProjectTimerAndStagoryView(Context context) {
        super(context);
        this.minMark = 9;
        this.minType = TypeEnum.INIT;
        this.isShowing = false;
        this.isPlaying = false;
        this.mContex = context;
        init();
    }

    private void disEnableClickRemindMeBtn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1468612274")) {
            ipChange.ipc$dispatch("-1468612274", new Object[]{this});
            return;
        }
        if (this.mTvRemindMeButton.getVisibility() == 0) {
            this.mTvRemindMeButton.setVisibility(8);
        }
        if (this.mTvStrategy.getVisibility() != 0 && this.lottieStrategy.getVisibility() == 0) {
            this.countDownTip.setVisibility(0);
        } else {
            this.countDownTip.setVisibility(8);
        }
    }

    private void enableClickRemindMeBtn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1698693786")) {
            ipChange.ipc$dispatch("1698693786", new Object[]{this});
            return;
        }
        TypeEnum typeEnum = this.minType;
        TypeEnum typeEnum2 = TypeEnum.LARGER;
        if (typeEnum != typeEnum2) {
            this.countDownTip.setVisibility(8);
            if (this.mTvRemindMeButton.getVisibility() != 0) {
                this.mTvRemindMeButton.setVisibility(0);
                pp2.u().E1(this.mTvRemindMeButton, this.mProjectId);
            }
        }
        this.minType = typeEnum2;
    }

    private void hideCountDownView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1596507358")) {
            ipChange.ipc$dispatch("-1596507358", new Object[]{this});
            return;
        }
        this.mTimeAndStagoryLayout.setVisibility(8);
        this.mCountDownLayout.setVisibility(8);
        this.countDownTip.setVisibility(8);
    }

    private void hideLineView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "803758649")) {
            ipChange.ipc$dispatch("803758649", new Object[]{this});
        } else {
            this.mLineView.setVisibility(8);
        }
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1158656036")) {
            ipChange.ipc$dispatch("1158656036", new Object[]{this});
            return;
        }
        LayoutInflater.from(getContext()).inflate(R$layout.project_detail_item_bottom_layout, this);
        this.mResetAttendeesLayoutCl = (ConstraintLayout) findViewById(R$id.ll_reset_attendees_layout);
        this.mResetAttendeesMidTv = (TextView) findViewById(R$id.tv_reset_attendees_mid);
        this.mResetAttendeesTitleTv = (TextView) findViewById(R$id.tv_reset_attendees_title);
        this.mResetAttendeesCloseBtn = (DMIconFontTextView) findViewById(R$id.tv_close_reset_attendees);
        this.mResetAttendeesLayoutCl.setOnClickListener(new View.OnClickListener() { // from class: tb.pw1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProjectTimerAndStagoryView.lambda$init$0(view);
            }
        });
        this.mResetAttendeesCloseBtn.setOnClickListener(new View$OnClickListenerC2364a());
        this.mResetAttendeesLayoutCl.setVisibility(8);
        this.mLineView = findViewById(R$id.rl_timer_stagory_line);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.rl_timer_stagory);
        this.mTimeAndStagoryLayout = linearLayout;
        linearLayout.setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R$id.trade_count_down_tip_icon);
        this.countDownTip = imageView;
        imageView.setVisibility(8);
        TextView textView = (TextView) findViewById(R$id.tv_strategy);
        this.mTvStrategy = textView;
        textView.setVisibility(8);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R$id.lottie_strategy);
        this.lottieStrategy = lottieAnimationView;
        lottieAnimationView.setVisibility(8);
        TextView textView2 = (TextView) findViewById(R$id.tv_remind_me);
        this.mTvRemindMeButton = textView2;
        textView2.setVisibility(8);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R$id.ll_count_down);
        this.mCountDownLayout = linearLayout2;
        linearLayout2.setVisibility(8);
        this.mTvCountDownRemindText = (TextView) this.mCountDownLayout.findViewById(R$id.tv_count_down_remind);
        this.mTvDay = (TextView) this.mCountDownLayout.findViewById(R$id.tv_day_count_down);
        this.mTvHour = (TextView) this.mCountDownLayout.findViewById(R$id.tv_hour_count_down);
        this.mTvMinute = (TextView) this.mCountDownLayout.findViewById(R$id.tv_minute_count_down);
        this.mTvSecond = (TextView) this.mCountDownLayout.findViewById(R$id.tv_second_count_down);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R$id.ll_strategy_single);
        this.mSingleStagoryLayout = relativeLayout;
        relativeLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$init$0(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1994217771")) {
            ipChange.ipc$dispatch("-1994217771", new Object[]{view});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAnim(final View view, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1875403040")) {
            ipChange.ipc$dispatch("1875403040", new Object[]{this, view, Integer.valueOf(i)});
        } else if (view.getVisibility() == i || this.isPlaying) {
        } else {
            view.clearAnimation();
            final TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, i == 8 ? 0.0f : 1.0f, 2, i == 8 ? 1.0f : 0.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setAnimationListener(new animationAnimation$AnimationListenerC2365b(i, view));
            this.isPlaying = true;
            view.post(new Runnable() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStagoryView.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-992117636")) {
                        ipChange2.ipc$dispatch("-992117636", new Object[]{this});
                        return;
                    }
                    if (i == 0) {
                        view.setVisibility(0);
                    }
                    view.requestLayout();
                    view.startAnimation(translateAnimation);
                }
            });
        }
    }

    private void setLottieStrategy(boolean z, int i, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1702436451")) {
            ipChange.ipc$dispatch("1702436451", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)});
        } else if (z) {
            this.lottieStrategy.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTvRemindMeButton.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.lottieStrategy.getLayoutParams();
            if (1 != i) {
                if (2 == i) {
                    layoutParams.topMargin = t60.a(this.mContex, 21.0f);
                    ((ViewGroup.MarginLayoutParams) layoutParams2).width = t60.a(this.mContex, 63.0f);
                    ((ViewGroup.MarginLayoutParams) layoutParams2).height = t60.a(this.mContex, 63.0f);
                    this.lottieStrategy.setImageResource(R$drawable.trade_damai_maixiaokai_icon);
                }
            } else if (!z2) {
                layoutParams.topMargin = t60.a(this.mContex, 30.0f);
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = t60.a(this.mContex, 149.0f);
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = t60.a(this.mContex, 63.0f);
                this.lottieStrategy.setAnimation(R$raw.trade_normal_strategy);
                this.lottieStrategy.playAnimation();
            } else {
                layoutParams.topMargin = t60.a(this.mContex, 30.0f);
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = t60.a(this.mContex, 200.0f);
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = t60.a(this.mContex, 63.0f);
                this.lottieStrategy.setAnimation(R$raw.trade_prompt_strategy_add);
                this.lottieStrategy.playAnimation();
            }
        } else {
            this.countDownTip.setVisibility(8);
            this.lottieStrategy.setVisibility(8);
        }
    }

    private void showCountDownView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-447257891")) {
            ipChange.ipc$dispatch("-447257891", new Object[]{this});
            return;
        }
        showLineView();
        this.mTimeAndStagoryLayout.setVisibility(0);
        this.mCountDownLayout.setVisibility(0);
    }

    private void showLineView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-191426146")) {
            ipChange.ipc$dispatch("-191426146", new Object[]{this});
        } else {
            this.mLineView.setVisibility(0);
        }
    }

    public void hideResetAttendees() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "833510696")) {
            ipChange.ipc$dispatch("833510696", new Object[]{this});
        } else {
            playAnim(this.mResetAttendeesLayoutCl, 8);
        }
    }

    public boolean isShowing() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "702706175") ? ((Boolean) ipChange.ipc$dispatch("702706175", new Object[]{this})).booleanValue() : this.isShowing;
    }

    public void setCountDownTime(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "414522336")) {
            ipChange.ipc$dispatch("414522336", new Object[]{this, str, str2, str3, str4});
            return;
        }
        this.mTvDay.setText(str);
        this.mTvHour.setText(str2);
        this.mTvMinute.setText(str3);
        this.mTvSecond.setText(str4);
        try {
            if ((!TextUtils.isEmpty(str) ? Long.valueOf(str).longValue() : 0L) > 0) {
                enableClickRemindMeBtn();
                return;
            }
            if ((!TextUtils.isEmpty(str2) ? Long.valueOf(str2).longValue() : 0L) > 0) {
                enableClickRemindMeBtn();
            } else if (Long.valueOf(str3).longValue() > 9) {
                enableClickRemindMeBtn();
            } else {
                disEnableClickRemindMeBtn();
            }
        } catch (Exception unused) {
            this.minType = TypeEnum.INIT;
        }
    }

    public StateEnum setCountDownVisibility(boolean z, boolean z2, boolean z3, boolean z4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-873233371")) {
            return (StateEnum) ipChange.ipc$dispatch("-873233371", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)});
        }
        if (z) {
            showCountDownView();
            if (this.mSingleStagoryLayout.getVisibility() == 0) {
                this.mSingleStagoryLayout.setVisibility(8);
                this.mTvStrategy.setVisibility(0);
                if (z4) {
                    pp2.u().c2(this.mResetAttendeesLayoutCl, this.mProjectId);
                    playAnim(this.mResetAttendeesLayoutCl, 0);
                }
                setLottieStrategy(true, 1, z3);
                pp2.u().v2(this.mTvStrategy, this.mProjectId);
            } else if (this.mTvStrategy.getVisibility() == 0) {
                setLottieStrategy(true, 1, z3);
            } else {
                setLottieStrategy(true, 2, z3);
            }
            this.isShowing = true;
            return StateEnum.TIMER;
        }
        hideCountDownView();
        setLottieStrategy(false, 0, z3);
        if (z2) {
            this.mTvStrategy.setVisibility(8);
            this.mResetAttendeesLayoutCl.setVisibility(8);
            this.mSingleStagoryLayout.setVisibility(8);
            hideLineView();
            this.isShowing = false;
            return StateEnum.INIT;
        } else if (this.mTvStrategy.getVisibility() == 0) {
            this.mTvStrategy.setVisibility(8);
            this.mResetAttendeesLayoutCl.setVisibility(8);
            this.mSingleStagoryLayout.setVisibility(0);
            showLineView();
            pp2.u().v2(this.mSingleStagoryLayout, this.mProjectId);
            this.isShowing = true;
            return StateEnum.STAGORY;
        } else if (this.mSingleStagoryLayout.getVisibility() == 0) {
            showLineView();
            this.isShowing = true;
            return StateEnum.STAGORY;
        } else {
            hideLineView();
            this.isShowing = false;
            return StateEnum.INIT;
        }
    }

    public void setOnRemindMeClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1320498115")) {
            ipChange.ipc$dispatch("1320498115", new Object[]{this, onClickListener});
        } else if (onClickListener != null) {
            this.mTvRemindMeButton.setOnClickListener(onClickListener);
        }
    }

    public void setProjectId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1738053740")) {
            ipChange.ipc$dispatch("1738053740", new Object[]{this, str});
        } else {
            this.mProjectId = str;
        }
    }

    public void setStrategoryClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1042447439")) {
            ipChange.ipc$dispatch("1042447439", new Object[]{this, onClickListener});
        } else if (onClickListener != null) {
            this.mTvStrategy.setOnClickListener(onClickListener);
            this.mSingleStagoryLayout.setOnClickListener(onClickListener);
        }
    }

    public StateEnum setStrategyVisibility(boolean z, boolean z2, boolean z3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437009811")) {
            return (StateEnum) ipChange.ipc$dispatch("437009811", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)});
        }
        if (z) {
            showLineView();
            if (this.mTimeAndStagoryLayout.getVisibility() == 0) {
                this.mTvStrategy.setVisibility(0);
                if (z3) {
                    pp2.u().c2(this.mResetAttendeesLayoutCl, this.mProjectId);
                    playAnim(this.mResetAttendeesLayoutCl, 0);
                }
                setLottieStrategy(true, 1, z2);
                this.mSingleStagoryLayout.setVisibility(8);
                pp2.u().v2(this.mTvStrategy, this.mProjectId);
                this.isShowing = true;
                return StateEnum.TIMER;
            }
            this.mTvStrategy.setVisibility(8);
            this.mResetAttendeesLayoutCl.setVisibility(8);
            setLottieStrategy(false, 0, z2);
            this.mSingleStagoryLayout.setVisibility(0);
            pp2.u().v2(this.mSingleStagoryLayout, this.mProjectId);
            this.isShowing = true;
            return StateEnum.STAGORY;
        }
        this.mTvStrategy.setVisibility(8);
        this.mResetAttendeesLayoutCl.setVisibility(8);
        this.mSingleStagoryLayout.setVisibility(8);
        if (this.mTimeAndStagoryLayout.getVisibility() != 0) {
            setLottieStrategy(false, 0, z2);
            hideLineView();
            this.isShowing = false;
            return StateEnum.INIT;
        }
        showLineView();
        setLottieStrategy(true, 2, z2);
        this.isShowing = true;
        return StateEnum.TIMER;
    }

    public void updateCountDownRemindText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1245224998")) {
            ipChange.ipc$dispatch("1245224998", new Object[]{this, str});
        } else {
            this.mTvCountDownRemindText.setText(str);
        }
    }

    public void updateRemindMeBtnText(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-197058591")) {
            ipChange.ipc$dispatch("-197058591", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mTvRemindMeButton.setText(z ? "取消提醒" : "添加提醒");
        this.mTvRemindMeButton.setTextColor(getResources().getColor(z ? R$color.color_69717C : R$color.color_FF2869));
    }

    public ProjectTimerAndStagoryView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.minMark = 9;
        this.minType = TypeEnum.INIT;
        this.isShowing = false;
        this.isPlaying = false;
        this.mContex = context;
        init();
    }

    public ProjectTimerAndStagoryView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.minMark = 9;
        this.minType = TypeEnum.INIT;
        this.isShowing = false;
        this.isPlaying = false;
        this.mContex = context;
        init();
    }
}
