package cn.damai.commonbusiness.skeleton;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ShimmerLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final byte DEFAULT_ANGLE = 20;
    private static final int DEFAULT_ANIMATION_DURATION = 1500;
    private static final byte MAX_ANGLE_VALUE = 45;
    private static final byte MAX_GRADIENT_CENTER_COLOR_WIDTH_VALUE = 1;
    private static final byte MAX_MASK_WIDTH_VALUE = 1;
    private static final byte MIN_ANGLE_VALUE = -45;
    private static final byte MIN_GRADIENT_CENTER_COLOR_WIDTH_VALUE = 0;
    private static final byte MIN_MASK_WIDTH_VALUE = 0;
    private boolean autoStart;
    private Canvas canvasForShimmerMask;
    private float gradientCenterColorWidth;
    private Paint gradientTexturePaint;
    private boolean isAnimationReversed;
    private boolean isAnimationStarted;
    private Bitmap localMaskBitmap;
    private ValueAnimator maskAnimator;
    private Bitmap maskBitmap;
    private int maskOffsetX;
    private Rect maskRect;
    private float maskWidth;
    private int shimmerAngle;
    private int shimmerAnimationDuration;
    private int shimmerColor;
    private ViewTreeObserver.OnPreDrawListener startAnimationPreDrawListener;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.skeleton.ShimmerLayout$a */
    /* loaded from: classes.dex */
    public class ViewTreeObserver$OnPreDrawListenerC0924a implements ViewTreeObserver.OnPreDrawListener {
        private static transient /* synthetic */ IpChange $ipChange;

        ViewTreeObserver$OnPreDrawListenerC0924a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "149996530")) {
                return ((Boolean) ipChange.ipc$dispatch("149996530", new Object[]{this})).booleanValue();
            }
            ShimmerLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ShimmerLayout.this.startShimmerAnimation();
            return true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.skeleton.ShimmerLayout$b */
    /* loaded from: classes.dex */
    public class C0925b implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        C0925b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-152626451")) {
                ipChange.ipc$dispatch("-152626451", new Object[]{this, valueAnimator});
                return;
            }
            ShimmerLayout.this.maskOffsetX = this.a + ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (ShimmerLayout.this.maskOffsetX + this.b >= 0) {
                ShimmerLayout.this.invalidate();
            }
        }
    }

    public ShimmerLayout(Context context) {
        this(context, null);
    }

    private Rect calculateBitmapMaskRect() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1444698919") ? (Rect) ipChange.ipc$dispatch("1444698919", new Object[]{this}) : new Rect(0, 0, calculateMaskWidth(), getHeight());
    }

    private int calculateMaskWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "242106214") ? ((Integer) ipChange.ipc$dispatch("242106214", new Object[]{this})).intValue() : (int) (((getWidth() * this.maskWidth) / Math.cos(Math.toRadians(Math.abs(this.shimmerAngle)))) + (getHeight() * Math.tan(Math.toRadians(Math.abs(this.shimmerAngle)))));
    }

    private Bitmap createBitmap(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-989102598")) {
            return (Bitmap) ipChange.ipc$dispatch("-989102598", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ALPHA_8);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return null;
        }
    }

    private void createShimmerPaint() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "839378894")) {
            ipChange.ipc$dispatch("839378894", new Object[]{this});
        } else if (this.gradientTexturePaint != null) {
        } else {
            int reduceColorAlphaValueToZero = reduceColorAlphaValueToZero(this.shimmerColor);
            float width = getWidth() * this.maskWidth;
            float height = this.shimmerAngle >= 0 ? getHeight() : 0.0f;
            int i = this.shimmerColor;
            LinearGradient linearGradient = new LinearGradient(0.0f, height, ((float) Math.cos(Math.toRadians(this.shimmerAngle))) * width, height + (((float) Math.sin(Math.toRadians(this.shimmerAngle))) * width), new int[]{reduceColorAlphaValueToZero, i, i, reduceColorAlphaValueToZero}, getGradientColorDistribution(), Shader.TileMode.CLAMP);
            Bitmap bitmap = this.localMaskBitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            ComposeShader composeShader = new ComposeShader(linearGradient, new BitmapShader(bitmap, tileMode, tileMode), PorterDuff.Mode.DST_IN);
            Paint paint = new Paint();
            this.gradientTexturePaint = paint;
            paint.setAntiAlias(true);
            this.gradientTexturePaint.setDither(true);
            this.gradientTexturePaint.setFilterBitmap(true);
            this.gradientTexturePaint.setShader(composeShader);
        }
    }

    private void dispatchDrawShimmer(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "141524677")) {
            ipChange.ipc$dispatch("141524677", new Object[]{this, canvas});
            return;
        }
        super.dispatchDraw(canvas);
        Bitmap maskBitmap = getMaskBitmap();
        this.localMaskBitmap = maskBitmap;
        if (maskBitmap == null) {
            return;
        }
        if (this.canvasForShimmerMask == null) {
            this.canvasForShimmerMask = new Canvas(this.localMaskBitmap);
        }
        this.canvasForShimmerMask.drawColor(0, PorterDuff.Mode.CLEAR);
        this.canvasForShimmerMask.save();
        this.canvasForShimmerMask.translate(-this.maskOffsetX, 0.0f);
        super.dispatchDraw(this.canvasForShimmerMask);
        this.canvasForShimmerMask.restore();
        drawShimmer(canvas);
        this.localMaskBitmap = null;
    }

    private void drawShimmer(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1209601377")) {
            ipChange.ipc$dispatch("-1209601377", new Object[]{this, canvas});
            return;
        }
        createShimmerPaint();
        canvas.save();
        canvas.translate(this.maskOffsetX, 0.0f);
        Rect rect = this.maskRect;
        canvas.drawRect(rect.left, 0.0f, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.maskRect), this.gradientTexturePaint);
        canvas.restore();
    }

    private int getColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-171482340")) {
            return ((Integer) ipChange.ipc$dispatch("-171482340", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return getContext().getColor(i);
        }
        return getResources().getColor(i);
    }

    private float[] getGradientColorDistribution() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-163438629")) {
            return (float[]) ipChange.ipc$dispatch("-163438629", new Object[]{this});
        }
        float[] fArr = {0.0f, 0.5f - (r1 / 2.0f), (r1 / 2.0f) + 0.5f, 1.0f};
        float f = this.gradientCenterColorWidth;
        return fArr;
    }

    private Bitmap getMaskBitmap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2067607120")) {
            return (Bitmap) ipChange.ipc$dispatch("2067607120", new Object[]{this});
        }
        if (this.maskBitmap == null) {
            this.maskBitmap = createBitmap(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.maskRect), getHeight());
        }
        return this.maskBitmap;
    }

    private Animator getShimmerAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-414186615")) {
            return (Animator) ipChange.ipc$dispatch("-414186615", new Object[]{this});
        }
        ValueAnimator valueAnimator = this.maskAnimator;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        if (this.maskRect == null) {
            this.maskRect = calculateBitmapMaskRect();
        }
        int width = getWidth();
        int i = getWidth() > com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.maskRect) ? -width : -com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.maskRect);
        int width2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.maskRect);
        int i2 = width - i;
        ValueAnimator ofInt = this.isAnimationReversed ? ValueAnimator.ofInt(i2, 0) : ValueAnimator.ofInt(0, i2);
        this.maskAnimator = ofInt;
        ofInt.setDuration(this.shimmerAnimationDuration);
        this.maskAnimator.setRepeatCount(-1);
        this.maskAnimator.addUpdateListener(new C0925b(i, width2));
        return this.maskAnimator;
    }

    private int reduceColorAlphaValueToZero(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1195940826") ? ((Integer) ipChange.ipc$dispatch("-1195940826", new Object[]{this, Integer.valueOf(i)})).intValue() : Color.argb(0, Color.red(i), Color.green(i), Color.blue(i));
    }

    private void releaseBitMaps() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1712345590")) {
            ipChange.ipc$dispatch("-1712345590", new Object[]{this});
            return;
        }
        this.canvasForShimmerMask = null;
        Bitmap bitmap = this.maskBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.maskBitmap = null;
        }
    }

    private void resetIfStarted() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1147902414")) {
            ipChange.ipc$dispatch("-1147902414", new Object[]{this});
        } else if (this.isAnimationStarted) {
            resetShimmering();
            startShimmerAnimation();
        }
    }

    private void resetShimmering() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2140507859")) {
            ipChange.ipc$dispatch("2140507859", new Object[]{this});
            return;
        }
        ValueAnimator valueAnimator = this.maskAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.maskAnimator.removeAllUpdateListeners();
        }
        this.maskAnimator = null;
        this.gradientTexturePaint = null;
        this.isAnimationStarted = false;
        releaseBitMaps();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1149566916")) {
            ipChange.ipc$dispatch("-1149566916", new Object[]{this, canvas});
        } else if (this.isAnimationStarted && getWidth() > 0 && getHeight() > 0) {
            if ((getContext().getResources().getConfiguration().uiMode & 48) == 32) {
                super.dispatchDraw(canvas);
            } else {
                dispatchDrawShimmer(canvas);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-392540292")) {
            ipChange.ipc$dispatch("-392540292", new Object[]{this});
            return;
        }
        resetShimmering();
        super.onDetachedFromWindow();
    }

    public void setAnimationReversed(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "987778545")) {
            ipChange.ipc$dispatch("987778545", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isAnimationReversed = z;
        resetIfStarted();
    }

    public void setGradientCenterColorWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1700724103")) {
            ipChange.ipc$dispatch("1700724103", new Object[]{this, Float.valueOf(f)});
        } else if (f > 0.0f && 1.0f > f) {
            this.gradientCenterColorWidth = f;
            resetIfStarted();
        } else {
            throw new IllegalArgumentException(String.format("gradientCenterColorWidth value must be higher than %d and less than %d", (byte) 0, (byte) 1));
        }
    }

    public void setMaskWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1153324623")) {
            ipChange.ipc$dispatch("-1153324623", new Object[]{this, Float.valueOf(f)});
        } else if (f > 0.0f && 1.0f >= f) {
            this.maskWidth = f;
            resetIfStarted();
        } else {
            throw new IllegalArgumentException(String.format("maskWidth value must be higher than %d and less or equal to %d", (byte) 0, (byte) 1));
        }
    }

    public void setShimmerAngle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-417436556")) {
            ipChange.ipc$dispatch("-417436556", new Object[]{this, Integer.valueOf(i)});
        } else if (i >= -45 && 45 >= i) {
            this.shimmerAngle = i;
            resetIfStarted();
        } else {
            throw new IllegalArgumentException(String.format("shimmerAngle value must be between %d and %d", Byte.valueOf((byte) MIN_ANGLE_VALUE), Byte.valueOf((byte) MAX_ANGLE_VALUE)));
        }
    }

    public void setShimmerAnimationDuration(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1988268583")) {
            ipChange.ipc$dispatch("-1988268583", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.shimmerAnimationDuration = i;
        resetIfStarted();
    }

    public void setShimmerColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2049090812")) {
            ipChange.ipc$dispatch("-2049090812", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.shimmerColor = i;
        resetIfStarted();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2034077748")) {
            ipChange.ipc$dispatch("2034077748", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setVisibility(i);
        if (i == 0) {
            if (this.autoStart) {
                startShimmerAnimation();
                return;
            }
            return;
        }
        stopShimmerAnimation();
    }

    public void startShimmerAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-558356962")) {
            ipChange.ipc$dispatch("-558356962", new Object[]{this});
        } else if (this.isAnimationStarted) {
        } else {
            if (getWidth() == 0) {
                this.startAnimationPreDrawListener = new ViewTreeObserver$OnPreDrawListenerC0924a();
                getViewTreeObserver().addOnPreDrawListener(this.startAnimationPreDrawListener);
                return;
            }
            getShimmerAnimation().start();
            this.isAnimationStarted = true;
        }
    }

    public void stopShimmerAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "133720866")) {
            ipChange.ipc$dispatch("133720866", new Object[]{this});
            return;
        }
        if (this.startAnimationPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.startAnimationPreDrawListener);
        }
        resetShimmering();
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ShimmerLayout, 0, 0);
        try {
            this.shimmerAngle = obtainStyledAttributes.getInteger(R$styleable.ShimmerLayout_shimmer_angle, 20);
            this.shimmerAnimationDuration = obtainStyledAttributes.getInteger(R$styleable.ShimmerLayout_shimmer_animation_duration, 1500);
            this.shimmerColor = obtainStyledAttributes.getColor(R$styleable.ShimmerLayout_shimmer_color, getColor(R$color.shimmer_color));
            this.autoStart = obtainStyledAttributes.getBoolean(R$styleable.ShimmerLayout_shimmer_auto_start, false);
            this.maskWidth = obtainStyledAttributes.getFloat(R$styleable.ShimmerLayout_shimmer_mask_width, 0.5f);
            this.gradientCenterColorWidth = obtainStyledAttributes.getFloat(R$styleable.ShimmerLayout_shimmer_gradient_center_color_width, 0.1f);
            this.isAnimationReversed = obtainStyledAttributes.getBoolean(R$styleable.ShimmerLayout_shimmer_reverse_animation, false);
            obtainStyledAttributes.recycle();
            setMaskWidth(this.maskWidth);
            setGradientCenterColorWidth(this.gradientCenterColorWidth);
            setShimmerAngle(this.shimmerAngle);
            if (this.autoStart && getVisibility() == 0) {
                startShimmerAnimation();
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
