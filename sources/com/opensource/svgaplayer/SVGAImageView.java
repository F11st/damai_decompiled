package com.opensource.svgaplayer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.youku.live.livesdk.wkit.component.Constants;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.s42;
import tb.t42;
import tb.y42;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0001EB\u0013\b\u0016\u0012\b\u0010=\u001a\u0004\u0018\u00010<¢\u0006\u0004\b>\u0010?B\u001d\b\u0016\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b>\u0010@B%\b\u0016\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010A\u001a\u00020\u0015¢\u0006\u0004\b>\u0010BB-\b\u0016\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010A\u001a\u00020\u0015\u0012\u0006\u0010C\u001a\u00020\u0015¢\u0006\u0004\b>\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0014J\u0006\u0010\b\u001a\u00020\u0002J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000bJ\u0016\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u000bR*\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006F"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView;", "Landroid/widget/ImageView;", "Ltb/wt2;", "setSoftwareLayerType", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "loadAttrs", "onDetachedFromWindow", "startAnimation", "Ltb/y42;", "range", "", "reverse", "pauseAnimation", "stopAnimation", Constants.TAG_CLEAR_STRING, "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "videoItem", "setVideoItem", "Ltb/t42;", "dynamicItem", "", TypedValues.Attributes.S_FRAME, "andPlay", "stepToFrame", "", "percentage", "stepToPercentage", "<set-?>", "isAnimating", "Z", "()Z", "setAnimating", "(Z)V", "loops", "I", "getLoops", "()I", "setLoops", "(I)V", "clearsAfterStop", "getClearsAfterStop", "setClearsAfterStop", "Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "fillMode", "Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "getFillMode", "()Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "setFillMode", "(Lcom/opensource/svgaplayer/SVGAImageView$FillMode;)V", "Lcom/opensource/svgaplayer/SVGACallback;", WXBridgeManager.METHOD_CALLBACK, "Lcom/opensource/svgaplayer/SVGACallback;", "getCallback", "()Lcom/opensource/svgaplayer/SVGACallback;", "setCallback", "(Lcom/opensource/svgaplayer/SVGACallback;)V", "Landroid/animation/ValueAnimator;", "animator", "Landroid/animation/ValueAnimator;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "FillMode", "library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes10.dex */
public class SVGAImageView extends ImageView {
    private ValueAnimator animator;
    @Nullable
    private SVGACallback callback;
    private boolean clearsAfterStop;
    @NotNull
    private FillMode fillMode;
    private boolean isAnimating;
    private int loops;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "", "<init>", "(Ljava/lang/String;I)V", "Backward", "Forward", "library_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes10.dex */
    public enum FillMode {
        Backward,
        Forward
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ValueAnimator a;
        final /* synthetic */ SVGAImageView b;
        final /* synthetic */ s42 c;

        a(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, y42 y42Var, s42 s42Var, boolean z) {
            this.a = valueAnimator;
            this.b = sVGAImageView;
            this.c = s42Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            s42 s42Var = this.c;
            Object animatedValue = this.a.getAnimatedValue();
            if (animatedValue != null) {
                s42Var.d(((Integer) animatedValue).intValue());
                SVGACallback callback = this.b.getCallback();
                if (callback != null) {
                    callback.onStep(this.c.a(), (this.c.a() + 1) / this.c.b().d());
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class b implements Animator.AnimatorListener {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ SVGAImageView c;
        final /* synthetic */ s42 d;

        b(int i, int i2, SVGAImageView sVGAImageView, y42 y42Var, s42 s42Var, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = sVGAImageView;
            this.d = s42Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animator) {
            this.c.isAnimating = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animator) {
            this.c.isAnimating = false;
            this.c.stopAnimation();
            if (!this.c.getClearsAfterStop()) {
                if (b41.d(this.c.getFillMode(), FillMode.Backward)) {
                    this.d.d(this.a);
                } else if (b41.d(this.c.getFillMode(), FillMode.Forward)) {
                    this.d.d(this.b);
                }
            }
            SVGACallback callback = this.c.getCallback();
            if (callback != null) {
                callback.onFinished();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animator) {
            SVGACallback callback = this.c.getCallback();
            if (callback != null) {
                callback.onRepeat();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animator) {
            this.c.isAnimating = true;
        }
    }

    public SVGAImageView(@Nullable Context context) {
        super(context);
        this.clearsAfterStop = true;
        this.fillMode = FillMode.Forward;
        setSoftwareLayerType();
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R$styleable.SVGAImageView, 0, 0);
        this.loops = obtainStyledAttributes.getInt(R$styleable.SVGAImageView_loopCount, 0);
        this.clearsAfterStop = obtainStyledAttributes.getBoolean(R$styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.SVGAImageView_antiAlias, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R$styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (b41.d(string, "0")) {
                this.fillMode = FillMode.Backward;
            } else if (b41.d(string, "1")) {
                this.fillMode = FillMode.Forward;
            }
        }
        String string2 = obtainStyledAttributes.getString(R$styleable.SVGAImageView_source);
        if (string2 != null) {
            Context context = getContext();
            b41.e(context, WPKFactory.INIT_KEY_CONTEXT);
            new Thread(new SVGAImageView$loadAttrs$$inlined$let$lambda$1(string2, new SVGAParser(context), this, z, z2)).start();
        }
        obtainStyledAttributes.recycle();
    }

    private final void setAnimating(boolean z) {
        this.isAnimating = z;
    }

    private final void setSoftwareLayerType() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    public static /* bridge */ /* synthetic */ void startAnimation$default(SVGAImageView sVGAImageView, y42 y42Var, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            sVGAImageView.startAnimation(y42Var, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startAnimation");
    }

    @Nullable
    public final SVGACallback getCallback() {
        return this.callback;
    }

    public final boolean getClearsAfterStop() {
        return this.clearsAfterStop;
    }

    @NotNull
    public final FillMode getFillMode() {
        return this.fillMode;
    }

    public final int getLoops() {
        return this.loops;
    }

    public final boolean isAnimating() {
        return this.isAnimating;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.animator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        SVGACallback sVGACallback = this.callback;
        if (sVGACallback != null) {
            sVGACallback.onPause();
        }
    }

    public final void setCallback(@Nullable SVGACallback sVGACallback) {
        this.callback = sVGACallback;
    }

    public final void setClearsAfterStop(boolean z) {
        this.clearsAfterStop = z;
    }

    public final void setFillMode(@NotNull FillMode fillMode) {
        b41.j(fillMode, "<set-?>");
        this.fillMode = fillMode;
    }

    public final void setLoops(int i) {
        this.loops = i;
    }

    public final void setVideoItem(@NotNull SVGAVideoEntity sVGAVideoEntity) {
        b41.j(sVGAVideoEntity, "videoItem");
        setVideoItem(sVGAVideoEntity, new t42());
    }

    public final void startAnimation() {
        startAnimation(null, false);
    }

    public final void stepToFrame(int i, boolean z) {
        pauseAnimation();
        Drawable drawable = getDrawable();
        if (!(drawable instanceof s42)) {
            drawable = null;
        }
        s42 s42Var = (s42) drawable;
        if (s42Var != null) {
            s42Var.d(i);
            if (z) {
                startAnimation();
                ValueAnimator valueAnimator = this.animator;
                if (valueAnimator != null) {
                    valueAnimator.setCurrentPlayTime(Math.max(0.0f, Math.min(1.0f, i / s42Var.b().d())) * ((float) valueAnimator.getDuration()));
                }
            }
        }
    }

    public final void stepToPercentage(double d, boolean z) {
        Drawable drawable = getDrawable();
        if (!(drawable instanceof s42)) {
            drawable = null;
        }
        s42 s42Var = (s42) drawable;
        if (s42Var != null) {
            int d2 = (int) (s42Var.b().d() * d);
            if (d2 >= s42Var.b().d() && d2 > 0) {
                d2 = s42Var.b().d() - 1;
            }
            stepToFrame(d2, z);
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.clearsAfterStop);
    }

    public final void setVideoItem(@NotNull SVGAVideoEntity sVGAVideoEntity, @NotNull t42 t42Var) {
        b41.j(sVGAVideoEntity, "videoItem");
        b41.j(t42Var, "dynamicItem");
        s42 s42Var = new s42(sVGAVideoEntity, t42Var);
        s42Var.c(this.clearsAfterStop);
        setImageDrawable(s42Var);
    }

    public final void startAnimation(@Nullable y42 y42Var, boolean z) {
        stopAnimation(false);
        Drawable drawable = getDrawable();
        if (!(drawable instanceof s42)) {
            drawable = null;
        }
        s42 s42Var = (s42) drawable;
        if (s42Var != null) {
            s42Var.c(false);
            ImageView.ScaleType scaleType = getScaleType();
            b41.e(scaleType, "scaleType");
            s42Var.e(scaleType);
            SVGAVideoEntity b2 = s42Var.b();
            if (b2 != null) {
                int max = Math.max(0, 0);
                int min = Math.min(b2.d() - 1, (Integer.MAX_VALUE + 0) - 1);
                ValueAnimator ofInt = ValueAnimator.ofInt(max, min);
                double d = 1.0d;
                try {
                    Class<?> cls = Class.forName("android.animation.ValueAnimator");
                    Field declaredField = cls.getDeclaredField("sDurationScale");
                    if (declaredField != null) {
                        declaredField.setAccessible(true);
                        double d2 = declaredField.getFloat(cls);
                        if (d2 == 0.0d) {
                            try {
                                declaredField.setFloat(cls, 1.0f);
                                Log.e("SVGAPlayer", "The animation duration scale has been reset to 1.0x, because you closed it on developer options.");
                            } catch (Exception unused) {
                            }
                        }
                        d = d2;
                    }
                } catch (Exception unused2) {
                }
                ofInt.setInterpolator(new LinearInterpolator());
                ofInt.setDuration((long) ((((min - max) + 1) * (1000 / b2.c())) / d));
                int i = this.loops;
                ofInt.setRepeatCount(i <= 0 ? 99999 : i - 1);
                ofInt.addUpdateListener(new a(ofInt, this, y42Var, s42Var, z));
                ofInt.addListener(new b(max, min, this, y42Var, s42Var, z));
                if (z) {
                    ofInt.reverse();
                } else {
                    ofInt.start();
                }
                this.animator = ofInt;
            }
        }
    }

    public final void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.animator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof s42)) {
            drawable = null;
        }
        s42 s42Var = (s42) drawable;
        if (s42Var != null) {
            s42Var.c(z);
        }
    }

    public SVGAImageView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clearsAfterStop = true;
        this.fillMode = FillMode.Forward;
        setSoftwareLayerType();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.clearsAfterStop = true;
        this.fillMode = FillMode.Forward;
        setSoftwareLayerType();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.clearsAfterStop = true;
        this.fillMode = FillMode.Forward;
        setSoftwareLayerType();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }
}
