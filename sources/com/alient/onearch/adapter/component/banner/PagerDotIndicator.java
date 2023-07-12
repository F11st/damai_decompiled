package com.alient.onearch.adapter.component.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alient.onearch.adapter.R;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.n;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.i31;
import tb.k50;
import tb.n31;
import tb.ty1;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 B2\u00020\u0001:\u0002BCB'\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\u0006¢\u0006\u0004\b@\u0010AJ&\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010!\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001fH\u0014J\u0018\u0010$\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010%R\u001c\u0010'\u001a\b\u0018\u00010&R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010-R\u0016\u00101\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010-R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b2\u0010-R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b3\u0010-R\u0016\u00104\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010-R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010-R\u0016\u00109\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006D"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/PagerDotIndicator;", "Landroid/view/View;", "Landroid/graphics/Paint$Style;", "defaultStyle", "", "isAntiAliasDefault", "", "defaultColor", "Landroid/graphics/Paint;", "getDefaultPaintConfig", "", "coordinate", "Lkotlin/Pair;", "getXYPositionsByCoordinate", "position", "getDotCoordinate", "getDotYCoordinate", "getDistanceBetweenTheCenterOfTwoDots", "getRadius", "getPaint", "getCalculatedWidth", "dp", "dpToPx", "Ltb/wt2;", "removeAllSources", "getItemCount", "isRtl", "getRTLPosition", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "attachToRecyclerView", "Landroid/graphics/Canvas;", "canvas", "onDraw", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/alient/onearch/adapter/component/banner/PagerDotIndicator$InternalRecyclerScrollListener;", "internalRecyclerScrollListener", "Lcom/alient/onearch/adapter/component/banner/PagerDotIndicator$InternalRecyclerScrollListener;", "Landroid/view/animation/DecelerateInterpolator;", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "dotCount", "I", "fadingDotCount", "selectedDotRadiusPx", "dotRadiusPx", "dotSeparationDistancePx", "dotColor", "selectedDotColor", "selectedDotPaint", "Landroid/graphics/Paint;", "dotPaint", "selectedItemPosition", "intermediateSelectedItemPosition", "offsetPercent", UTConstant.Args.UT_SUCCESS_F, "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "InternalRecyclerScrollListener", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class PagerDotIndicator extends View {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_DOT_COUNT = 5;
    private static final float DEFAULT_DOT_RADIUS_DP = 6.5f;
    private static final int DEFAULT_DOT_SEPARATION_DISTANCE_DP = 12;
    private static final int DEFAULT_FADING_DOT_COUNT = 10;
    private static final float DEFAULT_SELECTED_DOT_RADIUS_DP = 6.5f;
    @ColorInt
    private int dotColor;
    private int dotCount;
    @NotNull
    private Paint dotPaint;
    private int dotRadiusPx;
    private int dotSeparationDistancePx;
    private int fadingDotCount;
    private int intermediateSelectedItemPosition;
    @Nullable
    private InternalRecyclerScrollListener internalRecyclerScrollListener;
    @NotNull
    private final DecelerateInterpolator interpolator;
    private float offsetPercent;
    @Nullable
    private RecyclerView recyclerView;
    @ColorInt
    private int selectedDotColor;
    @NotNull
    private Paint selectedDotPaint;
    private int selectedDotRadiusPx;
    private int selectedItemPosition;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/PagerDotIndicator$Companion;", "", "", "DEFAULT_DOT_COUNT", "I", "", "DEFAULT_DOT_RADIUS_DP", UTConstant.Args.UT_SUCCESS_F, "DEFAULT_DOT_SEPARATION_DISTANCE_DP", "DEFAULT_FADING_DOT_COUNT", "DEFAULT_SELECTED_DOT_RADIUS_DP", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/PagerDotIndicator$InternalRecyclerScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroid/view/View;", "getMostVisibleChild", "child", "", "calculatePercentVisible", "mostVisibleChild", "Ltb/wt2;", "setIntermediateSelectedItemPosition", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", Constants.Name.DISTANCE_Y, GXTemplateEngine.g.TYPE_ON_SCROLLED, "previousMostVisibleChild", "Landroid/view/View;", "<init>", "(Lcom/alient/onearch/adapter/component/banner/PagerDotIndicator;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes10.dex */
    public final class InternalRecyclerScrollListener extends RecyclerView.OnScrollListener {
        @Nullable
        private View previousMostVisibleChild;
        final /* synthetic */ PagerDotIndicator this$0;

        public InternalRecyclerScrollListener(PagerDotIndicator pagerDotIndicator) {
            b41.i(pagerDotIndicator, "this$0");
            this.this$0 = pagerDotIndicator;
        }

        private final float calculatePercentVisible(View view) {
            int left = view.getLeft();
            int right = view.getRight();
            int width = view.getWidth();
            if (left >= 0) {
                if (right <= this.this$0.getWidth()) {
                    return 1.0f;
                }
                right = this.this$0.getWidth() - left;
            }
            return right / width;
        }

        private final View getMostVisibleChild() {
            RecyclerView.LayoutManager layoutManager;
            RecyclerView.LayoutManager layoutManager2;
            RecyclerView recyclerView = this.this$0.recyclerView;
            Integer valueOf = (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) ? null : Integer.valueOf(layoutManager.getChildCount());
            b41.f(valueOf);
            int intValue = valueOf.intValue() - 1;
            if (intValue < 0) {
                return null;
            }
            float f = 0.0f;
            View view = null;
            while (true) {
                int i = intValue - 1;
                RecyclerView recyclerView2 = this.this$0.recyclerView;
                View childAt = (recyclerView2 == null || (layoutManager2 = recyclerView2.getLayoutManager()) == null) ? null : layoutManager2.getChildAt(intValue);
                if (childAt != null) {
                    float calculatePercentVisible = calculatePercentVisible(childAt);
                    if (calculatePercentVisible >= f) {
                        view = childAt;
                        f = calculatePercentVisible;
                    }
                }
                if (i < 0) {
                    return view;
                }
                intValue = i;
            }
        }

        private final void setIntermediateSelectedItemPosition(View view) {
            RecyclerView.ViewHolder findContainingViewHolder;
            RecyclerView recyclerView = this.this$0.recyclerView;
            if (recyclerView == null || (findContainingViewHolder = recyclerView.findContainingViewHolder(view)) == null) {
                return;
            }
            this.this$0.intermediateSelectedItemPosition = findContainingViewHolder.getAdapterPosition();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
            b41.i(recyclerView, "recyclerView");
            View mostVisibleChild = getMostVisibleChild();
            if (mostVisibleChild != null) {
                setIntermediateSelectedItemPosition(mostVisibleChild);
                this.this$0.offsetPercent = mostVisibleChild.getLeft() / mostVisibleChild.getMeasuredWidth();
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            PagerDotIndicator pagerDotIndicator = this.this$0;
            if (this.previousMostVisibleChild != linearLayoutManager.findViewByPosition(i >= 0 ? linearLayoutManager.findLastVisibleItemPosition() : linearLayoutManager.findFirstVisibleItemPosition())) {
                pagerDotIndicator.selectedItemPosition = pagerDotIndicator.intermediateSelectedItemPosition;
            }
            this.previousMostVisibleChild = mostVisibleChild;
            this.this$0.invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PagerDotIndicator(@NotNull Context context) {
        this(context, null, 0, 6, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PagerDotIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ PagerDotIndicator(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final int dpToPx(float f) {
        return (int) (f * (getResources().getDisplayMetrics().densityDpi / 160));
    }

    private final int getCalculatedWidth() {
        return (((this.dotCount + (this.fadingDotCount * 2)) - 1) * getDistanceBetweenTheCenterOfTwoDots()) + (this.dotRadiusPx * 2);
    }

    private final Paint getDefaultPaintConfig(Paint.Style style, boolean z, @ColorInt int i) {
        Paint paint = new Paint();
        paint.setStyle(style);
        paint.setAntiAlias(z);
        paint.setColor(i);
        return paint;
    }

    static /* synthetic */ Paint getDefaultPaintConfig$default(PagerDotIndicator pagerDotIndicator, Paint.Style style, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            style = Paint.Style.FILL;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return pagerDotIndicator.getDefaultPaintConfig(style, z, i);
    }

    private final int getDistanceBetweenTheCenterOfTwoDots() {
        return (this.dotRadiusPx * 2) + this.dotSeparationDistancePx;
    }

    private final float getDotCoordinate(int i) {
        return ((i - this.intermediateSelectedItemPosition) * getDistanceBetweenTheCenterOfTwoDots()) + (getDistanceBetweenTheCenterOfTwoDots() * 1.0f);
    }

    private final int getDotYCoordinate() {
        return this.selectedDotRadiusPx;
    }

    private final int getItemCount() {
        RecyclerView.Adapter adapter;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null || (adapter = recyclerView.getAdapter()) == null) {
            return 0;
        }
        return adapter.getItemCount();
    }

    private final Paint getPaint(float f) {
        return Math.abs(f) < ((float) (getDistanceBetweenTheCenterOfTwoDots() / 2)) ? this.selectedDotPaint : this.dotPaint;
    }

    private final int getRTLPosition(int i) {
        return (getItemCount() - i) - 1;
    }

    private final float getRadius(float f) {
        int i;
        float abs = Math.abs(f);
        float distanceBetweenTheCenterOfTwoDots = (this.dotCount / 2) * getDistanceBetweenTheCenterOfTwoDots();
        if (abs < getDistanceBetweenTheCenterOfTwoDots() / 2) {
            i = this.selectedDotRadiusPx;
        } else if (abs <= distanceBetweenTheCenterOfTwoDots) {
            i = this.dotRadiusPx;
        } else {
            return this.interpolator.getInterpolation(1 - ((abs - distanceBetweenTheCenterOfTwoDots) / ((getCalculatedWidth() / 2.01f) - distanceBetweenTheCenterOfTwoDots))) * this.dotRadiusPx;
        }
        return i;
    }

    private final Pair<Float, Float> getXYPositionsByCoordinate(float f) {
        return new Pair<>(Float.valueOf((getWidth() / 2) + f), Float.valueOf(getDotYCoordinate()));
    }

    private final boolean isRtl() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    private final void removeAllSources() {
        RecyclerView recyclerView;
        InternalRecyclerScrollListener internalRecyclerScrollListener = this.internalRecyclerScrollListener;
        if (internalRecyclerScrollListener != null && (recyclerView = this.recyclerView) != null) {
            recyclerView.removeOnScrollListener(internalRecyclerScrollListener);
        }
        this.recyclerView = null;
    }

    public final void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        removeAllSources();
        this.recyclerView = recyclerView;
        InternalRecyclerScrollListener internalRecyclerScrollListener = new InternalRecyclerScrollListener(this);
        this.internalRecyclerScrollListener = internalRecyclerScrollListener;
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.addOnScrollListener(internalRecyclerScrollListener);
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        n31 h;
        int q;
        b41.i(canvas, "canvas");
        super.onDraw(canvas);
        h = ty1.h(0, getItemCount());
        q = n.q(h, 10);
        ArrayList<Number> arrayList = new ArrayList(q);
        Iterator<Integer> it = h.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(getDotCoordinate(((i31) it).nextInt())));
        }
        for (Number number : arrayList) {
            float floatValue = number.floatValue();
            Pair<Float, Float> xYPositionsByCoordinate = getXYPositionsByCoordinate(floatValue);
            canvas.drawCircle(xYPositionsByCoordinate.component1().floatValue(), xYPositionsByCoordinate.component2().floatValue(), getRadius(floatValue), getPaint(floatValue));
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getCalculatedWidth(), this.selectedDotRadiusPx * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PagerDotIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.interpolator = new DecelerateInterpolator();
        this.dotCount = 5;
        this.fadingDotCount = 10;
        this.selectedDotRadiusPx = dpToPx(6.5f);
        this.dotRadiusPx = dpToPx(6.5f);
        this.dotSeparationDistancePx = dpToPx(12.0f);
        this.dotColor = ContextCompat.getColor(context, R.color.default_indicator_color);
        this.selectedDotColor = ContextCompat.getColor(context, R.color.default_selected_indicator_color);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PagerIndicator, 0, 0);
            this.dotCount = obtainStyledAttributes.getInteger(R.styleable.PagerIndicator_dotCount, 5);
            this.fadingDotCount = obtainStyledAttributes.getInt(R.styleable.PagerIndicator_fadingDotCount, 10);
            this.dotRadiusPx = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PagerIndicator_dotRadius, this.dotRadiusPx);
            this.selectedDotRadiusPx = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PagerIndicator_selectedDotRadius, this.selectedDotRadiusPx);
            this.dotColor = obtainStyledAttributes.getColor(R.styleable.PagerIndicator_indicatorColor, this.dotColor);
            this.selectedDotColor = obtainStyledAttributes.getColor(R.styleable.PagerIndicator_selectedIndicatorColor, this.selectedDotColor);
            this.dotSeparationDistancePx = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PagerIndicator_dotSeparation, this.dotSeparationDistancePx);
            obtainStyledAttributes.recycle();
        }
        this.selectedDotPaint = getDefaultPaintConfig$default(this, null, false, this.selectedDotColor, 3, null);
        this.dotPaint = getDefaultPaintConfig$default(this, null, false, this.dotColor, 3, null);
    }
}
