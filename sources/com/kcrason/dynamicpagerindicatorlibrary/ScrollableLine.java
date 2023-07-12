package com.kcrason.dynamicpagerindicatorlibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.ali.user.mobile.app.constant.UTConstant;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jw2;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\u0004¢\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J.\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0014R\u0016\u0010\u0013\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0016\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014¨\u0006&"}, d2 = {"Lcom/kcrason/dynamicpagerindicatorlibrary/ScrollableLine;", "Landroid/view/View;", "Ltb/wt2;", "initScrollableLine", "", "indicatorLineHeight", "setIndicatorLineHeight", "", "indicatorLineRadius", "setIndicatorLineRadius", "indicatorStartX", "indicatorEndX", "indicatorStartColor", "indicatorEndColor", "fraction", "updateScrollLineWidth", "Landroid/graphics/Canvas;", "canvas", "onDraw", "mIndicatorLineRadius", UTConstant.Args.UT_SUCCESS_F, "mIndicatorLineHeight", "I", "Landroid/graphics/RectF;", "mRectF", "Landroid/graphics/RectF;", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Paint;", "mIndicatorStartX", "mIndicatorEndX", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicpagerindicatorlibrary_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes10.dex */
public final class ScrollableLine extends View {
    private HashMap _$_findViewCache;
    private float mIndicatorEndX;
    private int mIndicatorLineHeight;
    private float mIndicatorLineRadius;
    private float mIndicatorStartX;
    private Paint mPaint;
    private RectF mRectF;

    @JvmOverloads
    public ScrollableLine(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public ScrollableLine(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ScrollableLine(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void initScrollableLine() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = this.mPaint;
        if (paint2 == null) {
            b41.u();
        }
        paint2.setStyle(Paint.Style.FILL);
        this.mRectF = new RectF();
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        b41.j(canvas, "canvas");
        super.onDraw(canvas);
        RectF rectF = this.mRectF;
        if (rectF == null) {
            b41.u();
        }
        rectF.set(this.mIndicatorStartX, 0.0f, this.mIndicatorEndX, this.mIndicatorLineHeight);
        RectF rectF2 = this.mRectF;
        if (rectF2 == null) {
            b41.u();
        }
        float f = this.mIndicatorLineRadius;
        Paint paint = this.mPaint;
        if (paint == null) {
            b41.u();
        }
        canvas.drawRoundRect(rectF2, f, f, paint);
    }

    public final void setIndicatorLineHeight(int i) {
        this.mIndicatorLineHeight = i;
    }

    @NotNull
    public final ScrollableLine setIndicatorLineRadius(float f) {
        this.mIndicatorLineRadius = f;
        return this;
    }

    public final void updateScrollLineWidth(float f, float f2, int i, int i2, float f3) {
        this.mIndicatorStartX = f;
        this.mIndicatorEndX = f2;
        Paint paint = this.mPaint;
        if (paint == null) {
            b41.u();
        }
        paint.setColor(jw2.INSTANCE.b(i, i2, f3));
        postInvalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ScrollableLine(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.j(context, WPKFactory.INIT_KEY_CONTEXT);
        initScrollableLine();
    }
}
