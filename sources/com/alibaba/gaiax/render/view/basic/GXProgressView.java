package com.alibaba.gaiax.render.view.basic;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.Keep;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.youku.arch.v3.core.Constants;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.mq0;
import tb.ty1;
import tb.wt2;
import tb.xr0;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001.B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)B\u001b\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b(\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tJ(\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0014J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0015\u001a\u0004\u0018\u00010\tR\u001c\u0010\u0017\u001a\u00020\u00168B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006/"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/GXProgressView;", "Landroid/view/View;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Ltb/wt2;", "initView", "updateProgressPath", "Lcom/alibaba/fastjson/JSONObject;", "data", "onBindData", "Ltb/xr0;", Constants.CONFIG, "setConfig", "", WXComponent.PROP_FS_WRAP_CONTENT, "h", "oldw", "oldh", "onSizeChanged", "Landroid/graphics/Canvas;", "canvas", "onDraw", "getConfig", "", "percent", UTConstant.Args.UT_SUCCESS_F, "getPercent", "()F", "currentProgressWidth", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Paint;", "Landroid/graphics/Path;", "bgPath", "Landroid/graphics/Path;", "progressPath", "Landroid/animation/Animator;", "animator", "Landroid/animation/Animator;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "a", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public final class GXProgressView extends View implements GXIViewBindData {
    @NotNull
    public static final C3364a Companion = new C3364a(null);
    private static final float PADDING = 1.0f;
    @NotNull
    private static final String PROGRESS_WIDTH_VALUE_HOLDER = "PROGRESS_WIDTH_VALUE_HOLDER";
    @Nullable
    private Animator animator;
    @NotNull
    private final Path bgPath;
    @Nullable
    private xr0 config;
    private float currentProgressWidth;
    @NotNull
    private final Paint mPaint;
    private float percent;
    @NotNull
    private final Path progressPath;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.render.view.basic.GXProgressView$a */
    /* loaded from: classes6.dex */
    public static final class C3364a {
        private C3364a() {
        }

        public /* synthetic */ C3364a(k50 k50Var) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.render.view.basic.GXProgressView$b */
    /* loaded from: classes6.dex */
    public static final class C3365b implements ValueAnimator.AnimatorUpdateListener {
        C3365b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue(GXProgressView.PROGRESS_WIDTH_VALUE_HOLDER);
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            GXProgressView.this.progressPath.reset();
            GXProgressView.this.progressPath.moveTo(1.0f, 1.0f);
            float f = floatValue + 1.0f;
            GXProgressView.this.progressPath.lineTo(f, 1.0f);
            GXProgressView.this.progressPath.lineTo(f, GXProgressView.this.getMeasuredHeight() - 1.0f);
            GXProgressView.this.progressPath.lineTo(1.0f, GXProgressView.this.getMeasuredHeight() - 1.0f);
            GXProgressView.this.progressPath.close();
            GXProgressView.this.invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXProgressView(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.mPaint = new Paint();
        this.bgPath = new Path();
        this.progressPath = new Path();
        initView();
    }

    private final float getPercent() {
        float c;
        float f = this.percent;
        if (f < 0.0f) {
            return 0.0f;
        }
        c = ty1.c(f, 1.0f);
        return c;
    }

    private final void initView() {
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(1.0f);
    }

    private final void updateProgressPath() {
        float measuredWidth = (getMeasuredWidth() - 2.0f) * getPercent();
        xr0 xr0Var = this.config;
        if ((xr0Var == null || xr0Var.a()) ? false : true) {
            this.progressPath.reset();
            this.progressPath.moveTo(1.0f, 1.0f);
            float f = measuredWidth + 1.0f;
            this.progressPath.lineTo(f, 1.0f);
            this.progressPath.lineTo(f, getMeasuredHeight() - 1.0f);
            this.progressPath.lineTo(1.0f, getMeasuredHeight() - 1.0f);
            this.progressPath.close();
        } else {
            Animator animator = this.animator;
            if (animator != null) {
                animator.cancel();
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setValues(PropertyValuesHolder.ofFloat(PROGRESS_WIDTH_VALUE_HOLDER, this.currentProgressWidth, measuredWidth));
            valueAnimator.setDuration(300L);
            valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimator.addUpdateListener(new C3365b());
            valueAnimator.start();
            wt2 wt2Var = wt2.INSTANCE;
            this.animator = valueAnimator;
        }
        this.currentProgressWidth = measuredWidth;
    }

    @Nullable
    public final xr0 getConfig() {
        return this.config;
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(@Nullable JSONObject jSONObject) {
        Float f;
        if (jSONObject == null || (f = jSONObject.getFloat("value")) == null) {
            return;
        }
        this.percent = f.floatValue();
        updateProgressPath();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        mq0 d;
        mq0 f;
        super.onDraw(canvas);
        Paint paint = this.mPaint;
        xr0 xr0Var = this.config;
        int i = -7829368;
        if (xr0Var != null && (f = xr0Var.f()) != null) {
            i = f.c(getContext());
        }
        paint.setColor(i);
        if (canvas != null) {
            canvas.drawPath(this.bgPath, this.mPaint);
        }
        if (getPercent() > 0.0f) {
            Paint paint2 = this.mPaint;
            xr0 xr0Var2 = this.config;
            int i2 = -16776961;
            if (xr0Var2 != null && (d = xr0Var2.d()) != null) {
                i2 = d.c(getContext());
            }
            paint2.setColor(i2);
            if (canvas == null) {
                return;
            }
            canvas.drawPath(this.progressPath, this.mPaint);
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onResetData() {
        GXIViewBindData.C3361a.a(this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i2;
        this.mPaint.setPathEffect(new CornerPathEffect((f - 2.0f) / 2));
        this.bgPath.reset();
        this.bgPath.moveTo(1.0f, 1.0f);
        float f2 = i - 1.0f;
        this.bgPath.lineTo(f2, 1.0f);
        float f3 = f - 1.0f;
        this.bgPath.lineTo(f2, f3);
        this.bgPath.lineTo(1.0f, f3);
        this.bgPath.close();
        updateProgressPath();
    }

    public final void setConfig(@Nullable xr0 xr0Var) {
        this.config = xr0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.mPaint = new Paint();
        this.bgPath = new Path();
        this.progressPath = new Path();
        initView();
    }
}
