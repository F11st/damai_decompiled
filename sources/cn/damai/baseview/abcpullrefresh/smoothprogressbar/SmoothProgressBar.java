package cn.damai.baseview.abcpullrefresh.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import cn.damai.baseview.abcpullrefresh.smoothprogressbar.SmoothProgressDrawable;
import cn.damai.uikit.R$attr;
import cn.damai.uikit.R$bool;
import cn.damai.uikit.R$color;
import cn.damai.uikit.R$dimen;
import cn.damai.uikit.R$integer;
import cn.damai.uikit.R$string;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ae2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SmoothProgressBar extends ProgressBar {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int INTERPOLATOR_ACCELERATE = 0;
    private static final int INTERPOLATOR_ACCELERATEDECELERATE = 2;
    private static final int INTERPOLATOR_DECELERATE = 3;
    private static final int INTERPOLATOR_LINEAR = 1;

    public SmoothProgressBar(Context context) {
        this(context, null);
    }

    private SmoothProgressDrawable checkIndeterminateDrawable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1146118356")) {
            return (SmoothProgressDrawable) ipChange.ipc$dispatch("-1146118356", new Object[]{this});
        }
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null && (indeterminateDrawable instanceof SmoothProgressDrawable)) {
            return (SmoothProgressDrawable) indeterminateDrawable;
        }
        throw new RuntimeException("The drawable is not a SmoothProgressDrawable");
    }

    public void applyStyle(int i) {
        int resourceId;
        int[] intArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1979166355")) {
            ipChange.ipc$dispatch("-1979166355", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        Interpolator interpolator = null;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.SmoothProgressBar, 0, i);
        int i2 = R$styleable.SmoothProgressBar_spb_color;
        if (obtainStyledAttributes.hasValue(i2)) {
            setSmoothProgressDrawableColor(obtainStyledAttributes.getColor(i2, 0));
        }
        int i3 = R$styleable.SmoothProgressBar_spb_colors;
        if (obtainStyledAttributes.hasValue(i3) && (resourceId = obtainStyledAttributes.getResourceId(i3, 0)) != 0 && (intArray = getResources().getIntArray(resourceId)) != null && intArray.length > 0) {
            setSmoothProgressDrawableColors(intArray);
        }
        int i4 = R$styleable.SmoothProgressBar_spb_sections_count;
        if (obtainStyledAttributes.hasValue(i4)) {
            setSmoothProgressDrawableSectionsCount(obtainStyledAttributes.getInteger(i4, 0));
        }
        int i5 = R$styleable.SmoothProgressBar_spb_stroke_separator_length;
        if (obtainStyledAttributes.hasValue(i5)) {
            setSmoothProgressDrawableSeparatorLength(obtainStyledAttributes.getDimensionPixelSize(i5, 0));
        }
        int i6 = R$styleable.SmoothProgressBar_spb_stroke_width;
        if (obtainStyledAttributes.hasValue(i6)) {
            setSmoothProgressDrawableStrokeWidth(obtainStyledAttributes.getDimension(i6, 0.0f));
        }
        int i7 = R$styleable.SmoothProgressBar_spb_speed;
        if (obtainStyledAttributes.hasValue(i7)) {
            setSmoothProgressDrawableSpeed(obtainStyledAttributes.getFloat(i7, 0.0f));
        }
        int i8 = R$styleable.SmoothProgressBar_spb_progressiveStart_speed;
        if (obtainStyledAttributes.hasValue(i8)) {
            setSmoothProgressDrawableProgressiveStartSpeed(obtainStyledAttributes.getFloat(i8, 0.0f));
        }
        int i9 = R$styleable.SmoothProgressBar_spb_progressiveStop_speed;
        if (obtainStyledAttributes.hasValue(i9)) {
            setSmoothProgressDrawableProgressiveStopSpeed(obtainStyledAttributes.getFloat(i9, 0.0f));
        }
        int i10 = R$styleable.SmoothProgressBar_spb_reversed;
        if (obtainStyledAttributes.hasValue(i10)) {
            setSmoothProgressDrawableReversed(obtainStyledAttributes.getBoolean(i10, false));
        }
        int i11 = R$styleable.SmoothProgressBar_spb_mirror_mode;
        if (obtainStyledAttributes.hasValue(i11)) {
            setSmoothProgressDrawableMirrorMode(obtainStyledAttributes.getBoolean(i11, false));
        }
        int i12 = R$styleable.SmoothProgressBar_spb_progressiveStart_activated;
        if (obtainStyledAttributes.hasValue(i12)) {
            setProgressiveStartActivated(obtainStyledAttributes.getBoolean(i12, false));
        }
        if (obtainStyledAttributes.hasValue(i12)) {
            setProgressiveStartActivated(obtainStyledAttributes.getBoolean(i12, false));
        }
        int i13 = R$styleable.SmoothProgressBar_spb_gradients;
        if (obtainStyledAttributes.hasValue(i13)) {
            setSmoothProgressDrawableUseGradients(obtainStyledAttributes.getBoolean(i13, false));
        }
        int i14 = R$styleable.SmoothProgressBar_spb_generate_background_with_colors;
        if (obtainStyledAttributes.hasValue(i14) && obtainStyledAttributes.getBoolean(i14, false)) {
            setSmoothProgressDrawableBackgroundDrawable(ae2.a(checkIndeterminateDrawable().r(), checkIndeterminateDrawable().s()));
        }
        int i15 = R$styleable.SmoothProgressBar_spb_interpolator;
        if (obtainStyledAttributes.hasValue(i15)) {
            int integer = obtainStyledAttributes.getInteger(i15, -1);
            if (integer == 0) {
                interpolator = new AccelerateInterpolator();
            } else if (integer == 1) {
                interpolator = new LinearInterpolator();
            } else if (integer == 2) {
                interpolator = new AccelerateDecelerateInterpolator();
            } else if (integer == 3) {
                interpolator = new DecelerateInterpolator();
            }
            if (interpolator != null) {
                setInterpolator(interpolator);
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-615595857")) {
            ipChange.ipc$dispatch("-615595857", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (isIndeterminate() && (getIndeterminateDrawable() instanceof SmoothProgressDrawable) && !((SmoothProgressDrawable) getIndeterminateDrawable()).isRunning()) {
            getIndeterminateDrawable().draw(canvas);
        }
    }

    public void progressiveStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "285953058")) {
            ipChange.ipc$dispatch("285953058", new Object[]{this});
        } else {
            checkIndeterminateDrawable().w();
        }
    }

    public void progressiveStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1501999612")) {
            ipChange.ipc$dispatch("-1501999612", new Object[]{this});
        } else {
            checkIndeterminateDrawable().y();
        }
    }

    @Override // android.widget.ProgressBar
    public void setInterpolator(Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2117388867")) {
            ipChange.ipc$dispatch("-2117388867", new Object[]{this, interpolator});
            return;
        }
        super.setInterpolator(interpolator);
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable == null || !(indeterminateDrawable instanceof SmoothProgressDrawable)) {
            return;
        }
        ((SmoothProgressDrawable) indeterminateDrawable).F(interpolator);
    }

    public void setProgressiveStartActivated(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1155297939")) {
            ipChange.ipc$dispatch("1155297939", new Object[]{this, Boolean.valueOf(z)});
        } else {
            checkIndeterminateDrawable().H(z);
        }
    }

    public void setSmoothProgressDrawableBackgroundDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-78775282")) {
            ipChange.ipc$dispatch("-78775282", new Object[]{this, drawable});
        } else {
            checkIndeterminateDrawable().B(drawable);
        }
    }

    public void setSmoothProgressDrawableCallbacks(SmoothProgressDrawable.Callbacks callbacks) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1517302948")) {
            ipChange.ipc$dispatch("1517302948", new Object[]{this, callbacks});
        } else {
            checkIndeterminateDrawable().C(callbacks);
        }
    }

    public void setSmoothProgressDrawableColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-47758478")) {
            ipChange.ipc$dispatch("-47758478", new Object[]{this, Integer.valueOf(i)});
        } else {
            checkIndeterminateDrawable().D(i);
        }
    }

    public void setSmoothProgressDrawableColors(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-828035852")) {
            ipChange.ipc$dispatch("-828035852", new Object[]{this, iArr});
        } else {
            checkIndeterminateDrawable().E(iArr);
        }
    }

    public void setSmoothProgressDrawableInterpolator(Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1161988458")) {
            ipChange.ipc$dispatch("-1161988458", new Object[]{this, interpolator});
        } else {
            checkIndeterminateDrawable().F(interpolator);
        }
    }

    public void setSmoothProgressDrawableMirrorMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1781656512")) {
            ipChange.ipc$dispatch("-1781656512", new Object[]{this, Boolean.valueOf(z)});
        } else {
            checkIndeterminateDrawable().G(z);
        }
    }

    public void setSmoothProgressDrawableProgressiveStartSpeed(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-49641668")) {
            ipChange.ipc$dispatch("-49641668", new Object[]{this, Float.valueOf(f)});
        } else {
            checkIndeterminateDrawable().I(f);
        }
    }

    public void setSmoothProgressDrawableProgressiveStopSpeed(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-683199868")) {
            ipChange.ipc$dispatch("-683199868", new Object[]{this, Float.valueOf(f)});
        } else {
            checkIndeterminateDrawable().J(f);
        }
    }

    public void setSmoothProgressDrawableReversed(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-785096768")) {
            ipChange.ipc$dispatch("-785096768", new Object[]{this, Boolean.valueOf(z)});
        } else {
            checkIndeterminateDrawable().K(z);
        }
    }

    public void setSmoothProgressDrawableSectionsCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "740004752")) {
            ipChange.ipc$dispatch("740004752", new Object[]{this, Integer.valueOf(i)});
        } else {
            checkIndeterminateDrawable().L(i);
        }
    }

    public void setSmoothProgressDrawableSeparatorLength(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1265502982")) {
            ipChange.ipc$dispatch("-1265502982", new Object[]{this, Integer.valueOf(i)});
        } else {
            checkIndeterminateDrawable().M(i);
        }
    }

    public void setSmoothProgressDrawableSpeed(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "623769363")) {
            ipChange.ipc$dispatch("623769363", new Object[]{this, Float.valueOf(f)});
        } else {
            checkIndeterminateDrawable().N(f);
        }
    }

    public void setSmoothProgressDrawableStrokeWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1716803334")) {
            ipChange.ipc$dispatch("-1716803334", new Object[]{this, Float.valueOf(f)});
        } else {
            checkIndeterminateDrawable().O(f);
        }
    }

    public void setSmoothProgressDrawableUseGradients(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-714939654")) {
            ipChange.ipc$dispatch("-714939654", new Object[]{this, Boolean.valueOf(z)});
        } else {
            checkIndeterminateDrawable().P(z);
        }
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.spbStyle);
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            setIndeterminateDrawable(new SmoothProgressDrawable.C0285a(context).b());
            return;
        }
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmoothProgressBar, i, 0);
        int color = obtainStyledAttributes.getColor(R$styleable.SmoothProgressBar_spb_color, resources.getColor(R$color.spb_default_color));
        int integer = obtainStyledAttributes.getInteger(R$styleable.SmoothProgressBar_spb_sections_count, resources.getInteger(R$integer.spb_default_sections_count));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SmoothProgressBar_spb_stroke_separator_length, resources.getDimensionPixelSize(R$dimen.spb_default_stroke_separator_length));
        float dimension = obtainStyledAttributes.getDimension(R$styleable.SmoothProgressBar_spb_stroke_width, resources.getDimension(R$dimen.spb_default_stroke_width));
        float f = obtainStyledAttributes.getFloat(R$styleable.SmoothProgressBar_spb_speed, Float.parseFloat(resources.getString(R$string.spb_default_speed)));
        float f2 = obtainStyledAttributes.getFloat(R$styleable.SmoothProgressBar_spb_progressiveStart_speed, f);
        float f3 = obtainStyledAttributes.getFloat(R$styleable.SmoothProgressBar_spb_progressiveStop_speed, f);
        int integer2 = obtainStyledAttributes.getInteger(R$styleable.SmoothProgressBar_spb_interpolator, -1);
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.SmoothProgressBar_spb_reversed, resources.getBoolean(R$bool.spb_default_reversed));
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.SmoothProgressBar_spb_mirror_mode, resources.getBoolean(R$bool.spb_default_mirror_mode));
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.SmoothProgressBar_spb_colors, 0);
        boolean z3 = obtainStyledAttributes.getBoolean(R$styleable.SmoothProgressBar_spb_progressiveStart_activated, resources.getBoolean(R$bool.spb_default_progressiveStart_activated));
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.SmoothProgressBar_spb_background);
        boolean z4 = obtainStyledAttributes.getBoolean(R$styleable.SmoothProgressBar_spb_generate_background_with_colors, false);
        boolean z5 = obtainStyledAttributes.getBoolean(R$styleable.SmoothProgressBar_spb_gradients, false);
        obtainStyledAttributes.recycle();
        Interpolator interpolator = integer2 == -1 ? getInterpolator() : null;
        if (interpolator == null) {
            if (integer2 == 1) {
                interpolator = new LinearInterpolator();
            } else if (integer2 == 2) {
                interpolator = new AccelerateDecelerateInterpolator();
            } else if (integer2 != 3) {
                interpolator = new AccelerateInterpolator();
            } else {
                interpolator = new DecelerateInterpolator();
            }
        }
        int[] intArray = resourceId != 0 ? resources.getIntArray(resourceId) : null;
        SmoothProgressDrawable.C0285a f4 = new SmoothProgressDrawable.C0285a(context).p(f).k(f2).l(f3).h(interpolator).n(integer).o(dimensionPixelSize).q(dimension).m(z).i(z2).j(z3).f(z5);
        if (drawable != null) {
            f4.a(drawable);
        }
        if (z4) {
            f4.e();
        }
        if (intArray != null && intArray.length > 0) {
            f4.d(intArray);
        } else {
            f4.c(color);
        }
        setIndeterminateDrawable(f4.b());
    }
}
