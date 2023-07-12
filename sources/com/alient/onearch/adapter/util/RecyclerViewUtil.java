package com.alient.onearch.adapter.util;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J(\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¨\u0006\u0010"}, d2 = {"Lcom/alient/onearch/adapter/util/RecyclerViewUtil;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "position", "scrollByHeight", "Ltb/wt2;", "smoothScrollToPosition", "", "millisecondsPerInch", "smoothScrollToPositionSpeed", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class RecyclerViewUtil {
    @NotNull
    public static final RecyclerViewUtil INSTANCE = new RecyclerViewUtil();

    private RecyclerViewUtil() {
    }

    public final void smoothScrollToPosition(@Nullable final Context context, @NotNull RecyclerView recyclerView, int i, final int i2) {
        b41.i(recyclerView, "recyclerView");
        if (i < 0) {
            return;
        }
        try {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null || !(layoutManager instanceof LinearLayoutManager)) {
                return;
            }
            LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(i2, context) { // from class: com.alient.onearch.adapter.util.RecyclerViewUtil$smoothScrollToPosition$linearSmoothScroller$1
                final /* synthetic */ Context $context;
                final /* synthetic */ int $scrollByHeight;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(context);
                    this.$context = context;
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                public int calculateDyToMakeVisible(@NotNull View view, int i3) {
                    b41.i(view, "view");
                    try {
                        RecyclerView.LayoutManager layoutManager2 = getLayoutManager();
                        if (layoutManager2 != null && layoutManager2.canScrollVertically()) {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            if (layoutParams != null) {
                                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                                return calculateDtToFit((layoutManager2.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - this.$scrollByHeight, (layoutManager2.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) - this.$scrollByHeight, layoutManager2.getPaddingTop(), layoutManager2.getHeight() - layoutManager2.getPaddingBottom(), i3);
                            }
                            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                        }
                        return 0;
                    } catch (Exception unused) {
                        return super.calculateDyToMakeVisible(view, i3);
                    }
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected int getVerticalSnapPreference() {
                    return -1;
                }
            };
            linearSmoothScroller.setTargetPosition(i);
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            if (layoutManager2 == null) {
                return;
            }
            layoutManager2.startSmoothScroll(linearSmoothScroller);
        } catch (Exception unused) {
        }
    }

    public final void smoothScrollToPositionSpeed(@Nullable final Context context, @NotNull final RecyclerView recyclerView, int i, final float f) {
        b41.i(recyclerView, "recyclerView");
        if (i < 0) {
            return;
        }
        try {
            LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(f, context) { // from class: com.alient.onearch.adapter.util.RecyclerViewUtil$smoothScrollToPositionSpeed$linearSmoothScroller$1
                final /* synthetic */ Context $context;
                final /* synthetic */ float $millisecondsPerInch;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(context);
                    this.$context = context;
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                public int calculateDyToMakeVisible(@NotNull View view, int i2) {
                    b41.i(view, "view");
                    try {
                        RecyclerView.LayoutManager layoutManager = getLayoutManager();
                        if (layoutManager != null && layoutManager.canScrollVertically()) {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            if (layoutParams != null) {
                                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                                return calculateDtToFit(layoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin, layoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i2);
                            }
                            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                        }
                        return 0;
                    } catch (Exception unused) {
                        return super.calculateDyToMakeVisible(view, i2);
                    }
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
                    b41.i(displayMetrics, "displayMetrics");
                    return this.$millisecondsPerInch / displayMetrics.densityDpi;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
                @Nullable
                public PointF computeScrollVectorForPosition(int i2) {
                    try {
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) RecyclerView.this.getLayoutManager();
                        b41.f(linearLayoutManager);
                        View childAt = linearLayoutManager.getChildAt(0);
                        b41.f(childAt);
                        return new PointF(0.0f, i2 < linearLayoutManager.getPosition(childAt) ? -1 : 1);
                    } catch (Exception unused) {
                        return new PointF(0.0f, 1.0f);
                    }
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected int getVerticalSnapPreference() {
                    return -1;
                }
            };
            linearSmoothScroller.setTargetPosition(i);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            b41.f(layoutManager);
            layoutManager.startSmoothScroll(linearSmoothScroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
