package com.alibaba.pictures.bricks.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.text.DecimalFormat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class QuickUpNumTextView extends AppCompatTextView implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private UpAnimatorListener animatorListener;
    private float cancelNum;
    private float endNum;
    private boolean hasPlayAnimation;
    private boolean isCanceled;
    @NotNull
    private DataListener mListen;
    @NotNull
    private final ValueAnimator valueAnimator;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface DataListener {
        @NotNull
        String onDataUpdate(float f);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface UpAnimatorListener {
        void onEnd();
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.QuickUpNumTextView$a */
    /* loaded from: classes7.dex */
    public static final class C3582a implements DataListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C3582a() {
        }

        @Override // com.alibaba.pictures.bricks.view.QuickUpNumTextView.DataListener
        @NotNull
        public String onDataUpdate(float f) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1388981634") ? (String) ipChange.ipc$dispatch("-1388981634", new Object[]{this, Float.valueOf(f)}) : String.valueOf(f);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.QuickUpNumTextView$b */
    /* loaded from: classes7.dex */
    public static final class C3583b implements DataListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        C3583b(String str) {
            this.a = str;
        }

        @Override // com.alibaba.pictures.bricks.view.QuickUpNumTextView.DataListener
        @NotNull
        public String onDataUpdate(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1218226575")) {
                return (String) ipChange.ipc$dispatch("1218226575", new Object[]{this, Float.valueOf(f)});
            }
            String format = new DecimalFormat(this.a).format(Float.valueOf(f));
            b41.h(format, "DecimalFormat(patterns).format(data)");
            return format;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickUpNumTextView(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.valueAnimator = new ValueAnimator();
        this.mListen = new C3582a();
    }

    public static /* synthetic */ void animatorStart$default(QuickUpNumTextView quickUpNumTextView, float f, long j, float f2, int i, Object obj) {
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        quickUpNumTextView.animatorStart(f, j, f2);
    }

    public final void animatorStart(float f, long j, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1395595424")) {
            ipChange.ipc$dispatch("1395595424", new Object[]{this, Float.valueOf(f), Long.valueOf(j), Float.valueOf(f2)});
            return;
        }
        if (this.endNum == f) {
            return;
        }
        if (this.cancelNum == f) {
            return;
        }
        this.endNum = f;
        if (this.valueAnimator.isRunning()) {
            this.valueAnimator.cancel();
        }
        if (this.hasPlayAnimation) {
            setText(this.mListen.onDataUpdate(f));
            return;
        }
        this.valueAnimator.setFloatValues(Math.max(f2, this.cancelNum), f);
        this.valueAnimator.setDuration(j);
        this.valueAnimator.addUpdateListener(this);
        this.valueAnimator.addListener(this);
        this.valueAnimator.start();
    }

    @Nullable
    public final UpAnimatorListener getAnimatorListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "276958299") ? (UpAnimatorListener) ipChange.ipc$dispatch("276958299", new Object[]{this}) : this.animatorListener;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@Nullable Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-703757771")) {
            ipChange.ipc$dispatch("-703757771", new Object[]{this, animator});
            return;
        }
        ValueAnimator valueAnimator = animator instanceof ValueAnimator ? (ValueAnimator) animator : null;
        Object animatedValue = valueAnimator != null ? valueAnimator.getAnimatedValue() : null;
        Float f = animatedValue instanceof Float ? animatedValue : null;
        if (f != null) {
            float floatValue = f.floatValue();
            this.isCanceled = true;
            this.cancelNum = floatValue;
            return;
        }
        this.valueAnimator.end();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@Nullable Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-34804454")) {
            ipChange.ipc$dispatch("-34804454", new Object[]{this, animator});
        } else if (this.isCanceled) {
        } else {
            this.hasPlayAnimation = true;
            setText(this.mListen.onDataUpdate(this.endNum));
            UpAnimatorListener upAnimatorListener = this.animatorListener;
            if (upAnimatorListener != null) {
                upAnimatorListener.onEnd();
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@Nullable Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1609817844")) {
            ipChange.ipc$dispatch("1609817844", new Object[]{this, animator});
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@Nullable Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-531743757")) {
            ipChange.ipc$dispatch("-531743757", new Object[]{this, animator});
        } else {
            this.isCanceled = false;
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@Nullable ValueAnimator valueAnimator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2029774827")) {
            ipChange.ipc$dispatch("2029774827", new Object[]{this, valueAnimator});
            return;
        }
        Object animatedValue = valueAnimator != null ? valueAnimator.getAnimatedValue() : null;
        Float f = animatedValue instanceof Float ? (Float) animatedValue : null;
        if (f != null) {
            setText(this.mListen.onDataUpdate(f.floatValue()));
        } else {
            this.valueAnimator.end();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1517843320")) {
            ipChange.ipc$dispatch("-1517843320", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        if (this.valueAnimator.isRunning()) {
            this.valueAnimator.end();
        }
    }

    public final void setAnimatorListener(@Nullable UpAnimatorListener upAnimatorListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1517010811")) {
            ipChange.ipc$dispatch("-1517010811", new Object[]{this, upAnimatorListener});
        } else {
            this.animatorListener = upAnimatorListener;
        }
    }

    public final void setListener(@NotNull DataListener dataListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "643642468")) {
            ipChange.ipc$dispatch("643642468", new Object[]{this, dataListener});
            return;
        }
        b41.i(dataListener, "listen");
        this.mListen = dataListener;
    }

    public final void setQuickPattern(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687851268")) {
            ipChange.ipc$dispatch("-1687851268", new Object[]{this, str});
            return;
        }
        b41.i(str, "patterns");
        this.mListen = new C3583b(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickUpNumTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.valueAnimator = new ValueAnimator();
        this.mListen = new C3582a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickUpNumTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.valueAnimator = new ValueAnimator();
        this.mListen = new C3582a();
    }
}
