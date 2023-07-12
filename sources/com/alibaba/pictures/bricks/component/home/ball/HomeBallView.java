package com.alibaba.pictures.bricks.component.home.ball;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.HomeBallBean;
import com.alibaba.pictures.bricks.component.home.ball.HomeBallContract;
import com.alibaba.pictures.bricks.component.home.ball.HomeBallView;
import com.alibaba.pictures.bricks.view.BrickRotateAnim;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.C9796v;
import tb.b41;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeBallView extends AbsView<GenericItem<ItemValue>, HomeBallModel, HomeBallPresent> implements HomeBallContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final long bgDuration;
    @Nullable
    private Handler handler;
    private final ImageView icon;
    private boolean isChange;
    @NotNull
    private final View itemView;
    private final LinearLayout llLabel;
    private int num;
    private int pos;
    private final FrameLayout rlLabel;
    @Nullable
    private BrickRotateAnim rotateAnim;
    private final long textDuration;
    private final TextView title;
    private final TextView tvLabel;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.home.ball.HomeBallView$a */
    /* loaded from: classes7.dex */
    public static final class View$OnAttachStateChangeListenerC3463a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HomeBallBean b;

        View$OnAttachStateChangeListenerC3463a(HomeBallBean homeBallBean) {
            this.b = homeBallBean;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-493995464")) {
                ipChange.ipc$dispatch("-493995464", new Object[]{this, view});
                return;
            }
            b41.i(view, "v");
            System.out.println((Object) "onAnimationEnd  onViewAttachedToWindow");
            if (HomeBallView.this.llLabel != null && HomeBallView.this.llLabel.getVisibility() == 0 && HomeBallView.this.getNum() == 2 && b41.d(HomeBallView.this.llLabel.getTag(), "clearAnim")) {
                if (HomeBallView.this.rlLabel.getAnimation() == null || HomeBallView.this.tvLabel.getAnimation() == null) {
                    System.out.println((Object) ("onAnimationEnd 动画展示屏幕了 " + this.b.icon1 + this.b.icon2));
                    HomeBallView.this.rlBgAnim(this.b);
                    HomeBallView.this.llLabel.setTag("nextclearAnim");
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2135232693")) {
                ipChange.ipc$dispatch("2135232693", new Object[]{this, view});
                return;
            }
            b41.i(view, "v");
            System.out.println((Object) "onAnimationEnd  onViewDetachedFromWindow");
            if (HomeBallView.this.llLabel != null && HomeBallView.this.llLabel.getVisibility() == 0 && HomeBallView.this.getNum() == 2 && b41.d(HomeBallView.this.llLabel.getTag(), "nextclearAnim")) {
                System.out.println((Object) ("onAnimationEnd 动画离开屏幕->清除  " + this.b.icon1 + this.b.icon2));
                HomeBallView.this.resetAnim();
                HomeBallView.this.llLabel.setTag("clearAnim");
                return;
            }
            System.out.println((Object) ("onAnimationEnd 动画离开屏幕->不清除动画  " + this.b.icon1 + this.b.icon2));
            HomeBallView.this.llLabel.setTag("nextclearAnim");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.home.ball.HomeBallView$b  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class animationAnimation$AnimationListenerC3464b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HomeBallBean b;

        animationAnimation$AnimationListenerC3464b(HomeBallBean homeBallBean) {
            this.b = homeBallBean;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(HomeBallView homeBallView, HomeBallBean homeBallBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "771825765")) {
                ipChange.ipc$dispatch("771825765", new Object[]{homeBallView, homeBallBean});
                return;
            }
            b41.i(homeBallView, "this$0");
            b41.i(homeBallBean, "$bean");
            if (homeBallView.getNum() == 2 && homeBallView.llLabel.getVisibility() == 0) {
                System.out.println((Object) "onAnimationEnd 动画复用");
                homeBallView.rlBgAnim(homeBallBean);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1179353020")) {
                ipChange.ipc$dispatch("1179353020", new Object[]{this, animation});
                return;
            }
            b41.i(animation, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
            System.out.println((Object) "onAnimationEnd 动画复用记录ddddddddd");
            if (HomeBallView.this.handler == null) {
                HomeBallView.this.handler = new Handler();
            }
            Handler handler = HomeBallView.this.handler;
            if (handler != null) {
                final HomeBallView homeBallView = HomeBallView.this;
                final HomeBallBean homeBallBean = this.b;
                handler.postDelayed(new Runnable() { // from class: tb.ax0
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeBallView.animationAnimation$AnimationListenerC3464b.b(HomeBallView.this, homeBallBean);
                    }
                }, 2000L);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "760731192")) {
                ipChange.ipc$dispatch("760731192", new Object[]{this, animation});
            } else {
                b41.i(animation, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2017913835")) {
                ipChange.ipc$dispatch("-2017913835", new Object[]{this, animation});
                return;
            }
            b41.i(animation, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
            HomeBallView.this.setChange(true);
            HomeBallView homeBallView = HomeBallView.this;
            homeBallView.setPos((homeBallView.getPos() + 1) % 2);
            System.out.println((Object) ("onAnimationEnd 开始文字缩小 text = " + ((Object) HomeBallView.this.tvLabel.getText())));
            HomeBallView.this.tvScaleAnim(1.0f, 0.2f, 1.0f, 0.2f, this.b);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.home.ball.HomeBallView$c  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class animationAnimation$AnimationListenerC3465c implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HomeBallBean b;

        animationAnimation$AnimationListenerC3465c(HomeBallBean homeBallBean) {
            this.b = homeBallBean;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1050799910")) {
                ipChange.ipc$dispatch("-1050799910", new Object[]{this, animation});
                return;
            }
            b41.i(animation, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
            String str = HomeBallView.this.isChange() ? "需要执行动画" : "不需要执行动画";
            System.out.println((Object) ("onAnimationEnd 开始文字onAnimationEnd  " + str));
            if (HomeBallView.this.isChange()) {
                HomeBallView.this.setChange(false);
                HomeBallView.this.tvLabelContent(this.b);
                System.out.println((Object) ("onAnimationEnd 开始文字放大 text = " + ((Object) HomeBallView.this.tvLabel.getText())));
                HomeBallView.this.tvScaleAnim(0.2f, 1.0f, 0.2f, 1.0f, this.b);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1123895386")) {
                ipChange.ipc$dispatch("1123895386", new Object[]{this, animation});
            } else {
                b41.i(animation, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2006198861")) {
                ipChange.ipc$dispatch("-2006198861", new Object[]{this, animation});
            } else {
                b41.i(animation, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeBallView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        this.title = (TextView) view.findViewById(R$id.bricks_ball_name);
        this.icon = (ImageView) view.findViewById(R$id.bricks_ball_icon);
        this.llLabel = (LinearLayout) view.findViewById(R$id.bricks_ball_label_layout);
        this.rlLabel = (FrameLayout) view.findViewById(R$id.bricks_ball_rl_label);
        this.tvLabel = (TextView) view.findViewById(R$id.bricks_ball_label);
        this.textDuration = 300L;
        this.bgDuration = 600L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-0  reason: not valid java name */
    public static final void m131bindView$lambda0(HomeBallView homeBallView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1059541918")) {
            ipChange.ipc$dispatch("1059541918", new Object[]{homeBallView, successEvent});
            return;
        }
        b41.i(homeBallView, "this$0");
        Drawable drawable = successEvent.drawable;
        if (drawable == null) {
            homeBallView.icon.setImageResource(R$drawable.bricks_home_ball_icon);
        } else {
            homeBallView.icon.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-1  reason: not valid java name */
    public static final void m132bindView$lambda1(HomeBallView homeBallView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-642026304")) {
            ipChange.ipc$dispatch("-642026304", new Object[]{homeBallView, failEvent});
            return;
        }
        b41.i(homeBallView, "this$0");
        homeBallView.icon.setImageResource(R$drawable.bricks_home_ball_icon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-844211780")) {
            ipChange.ipc$dispatch("-844211780", new Object[]{this});
            return;
        }
        if (this.handler != null) {
            System.out.println((Object) "onAnimationEnd  初始化已经设置的");
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.handler = null;
        }
        this.rlLabel.clearAnimation();
        this.tvLabel.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rlBgAnim(HomeBallBean homeBallBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1716773990")) {
            ipChange.ipc$dispatch("-1716773990", new Object[]{this, homeBallBean});
            return;
        }
        BrickRotateAnim brickRotateAnim = this.rotateAnim;
        if (brickRotateAnim != null) {
            brickRotateAnim.setDuration(this.bgDuration);
            brickRotateAnim.setRepeatCount(0);
            brickRotateAnim.setAnimationListener(new animationAnimation$AnimationListenerC3464b(homeBallBean));
            brickRotateAnim.setInterpolator(new LinearInterpolator());
            this.rlLabel.startAnimation(brickRotateAnim);
        }
    }

    private final void setLabelWidth(String str, String str2) {
        float measureText;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1047169436")) {
            ipChange.ipc$dispatch("1047169436", new Object[]{this, str, str2});
            return;
        }
        if (str.length() > str2.length()) {
            measureText = this.tvLabel.getPaint().measureText(str);
        } else {
            measureText = this.tvLabel.getPaint().measureText(str2);
        }
        setParamWidth((int) measureText);
    }

    private final void setParamWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-441668094")) {
            ipChange.ipc$dispatch("-441668094", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        s60 s60Var = s60.INSTANCE;
        Context context = this.itemView.getContext();
        b41.h(context, "itemView.context");
        int b = i + s60Var.b(context, 11);
        Context context2 = this.itemView.getContext();
        b41.h(context2, "itemView.context");
        int b2 = s60Var.b(context2, 52);
        ViewGroup.LayoutParams layoutParams = this.tvLabel.getLayoutParams();
        if (b >= b2) {
            b = b2;
        }
        layoutParams.width = b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tvLabelContent(HomeBallBean homeBallBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123977135")) {
            ipChange.ipc$dispatch("-123977135", new Object[]{this, homeBallBean});
        } else if (this.pos == 0) {
            this.tvLabel.setText(homeBallBean.icon1);
        } else {
            this.tvLabel.setText(homeBallBean.icon2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tvScaleAnim(float f, float f2, float f3, float f4, HomeBallBean homeBallBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "921260725")) {
            ipChange.ipc$dispatch("921260725", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), homeBallBean});
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f3, f4, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setRepeatCount(0);
        scaleAnimation.setDuration(this.textDuration);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new animationAnimation$AnimationListenerC3465c(homeBallBean));
        this.tvLabel.startAnimation(scaleAnimation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0134 A[Catch: Exception -> 0x015b, TryCatch #0 {Exception -> 0x015b, blocks: (B:57:0x012e, B:59:0x0134, B:61:0x013c, B:62:0x014c), top: B:65:0x012e }] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    @Override // com.alibaba.pictures.bricks.component.home.ball.HomeBallContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bindView(@org.jetbrains.annotations.NotNull com.alibaba.pictures.bricks.bean.HomeBallBean r10) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.home.ball.HomeBallView.bindView(com.alibaba.pictures.bricks.bean.HomeBallBean):void");
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-941281232") ? (View) ipChange.ipc$dispatch("-941281232", new Object[]{this}) : this.itemView;
    }

    public final int getNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1237825487") ? ((Integer) ipChange.ipc$dispatch("-1237825487", new Object[]{this})).intValue() : this.num;
    }

    public final int getPos() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1185929565") ? ((Integer) ipChange.ipc$dispatch("-1185929565", new Object[]{this})).intValue() : this.pos;
    }

    @Nullable
    public final BrickRotateAnim getRotateAnim() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-543548892") ? (BrickRotateAnim) ipChange.ipc$dispatch("-543548892", new Object[]{this}) : this.rotateAnim;
    }

    public final boolean isChange() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1641761640") ? ((Boolean) ipChange.ipc$dispatch("-1641761640", new Object[]{this})).booleanValue() : this.isChange;
    }

    public final void setChange(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-19251638")) {
            ipChange.ipc$dispatch("-19251638", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isChange = z;
        }
    }

    public final void setNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076016647")) {
            ipChange.ipc$dispatch("-2076016647", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.num = i;
        }
    }

    public final void setPos(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-467243065")) {
            ipChange.ipc$dispatch("-467243065", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.pos = i;
        }
    }

    public final void setRotateAnim(@Nullable BrickRotateAnim brickRotateAnim) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-394829450")) {
            ipChange.ipc$dispatch("-394829450", new Object[]{this, brickRotateAnim});
        } else {
            this.rotateAnim = brickRotateAnim;
        }
    }
}
