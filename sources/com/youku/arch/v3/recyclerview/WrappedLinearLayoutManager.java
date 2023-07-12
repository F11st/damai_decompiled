package com.youku.arch.v3.recyclerview;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alibaba.gaiax.GXTemplateEngine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0013\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014B#\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0013\u0010\u0018B-\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u001dJ\u001c\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\tH\u0016J$\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\tH\u0016¨\u0006\u001f"}, d2 = {"Lcom/youku/arch/v3/recyclerview/WrappedLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", WXBasicComponentType.RECYCLER, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "Ltb/wt2;", "onLayoutChildren", "", GXTemplateEngine.C3344g.TYPE_ON_SCROLL_STATE_CHANGED, Constants.Name.DISTANCE_Y, "scrollVerticallyBy", "findLastCompletelyVisibleItemPosition", "recyclerView", "position", "smoothScrollToPosition", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "(Landroid/content/Context;IZ)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WrappedLinearLayoutManager extends LinearLayoutManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final float MILLISECONDS_PER_INCH = 160.0f;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/recyclerview/WrappedLinearLayoutManager$Companion;", "", "", "MILLISECONDS_PER_INCH", UTConstant.Args.UT_SUCCESS_F, "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public WrappedLinearLayoutManager(@Nullable Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int findLastCompletelyVisibleItemPosition() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1895839568")) {
            return ((Integer) ipChange.ipc$dispatch("-1895839568", new Object[]{this})).intValue();
        }
        try {
            return super.findLastCompletelyVisibleItemPosition();
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
            return -1;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(@NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "196873448")) {
            ipChange.ipc$dispatch("196873448", new Object[]{this, recycler, state});
            return;
        }
        b41.i(recycler, WXBasicComponentType.RECYCLER);
        b41.i(state, "state");
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1305072642")) {
            ipChange.ipc$dispatch("-1305072642", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        try {
            super.onScrollStateChanged(i);
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, @NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1939259695")) {
            return ((Integer) ipChange.ipc$dispatch("-1939259695", new Object[]{this, Integer.valueOf(i), recycler, state})).intValue();
        }
        b41.i(recycler, WXBasicComponentType.RECYCLER);
        b41.i(state, "state");
        try {
            return super.scrollVerticallyBy(i, recycler, state);
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
            return 0;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "643845275")) {
            ipChange.ipc$dispatch("643845275", new Object[]{this, recyclerView, state, Integer.valueOf(i)});
            return;
        }
        b41.i(recyclerView, "recyclerView");
        b41.i(state, "state");
        final Context context = recyclerView.getContext();
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(context) { // from class: com.youku.arch.v3.recyclerview.WrappedLinearLayoutManager$smoothScrollToPosition$linearSmoothScroller$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateDtToFit(int i2, int i3, int i4, int i5, int i6) {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-1360159129") ? ((Integer) ipChange2.ipc$dispatch("-1360159129", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})).intValue() : (i4 + ((i5 - i4) / 2)) - (i2 + ((i3 - i2) / 2));
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1821174082")) {
                    return ((Float) ipChange2.ipc$dispatch("-1821174082", new Object[]{this, displayMetrics})).floatValue();
                }
                b41.i(displayMetrics, "displayMetrics");
                return 160.0f / displayMetrics.densityDpi;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            @Nullable
            public PointF computeScrollVectorForPosition(int i2) {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-127325546") ? (PointF) ipChange2.ipc$dispatch("-127325546", new Object[]{this, Integer.valueOf(i2)}) : WrappedLinearLayoutManager.this.computeScrollVectorForPosition(i2);
            }
        };
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    public WrappedLinearLayoutManager(@Nullable Context context, int i, boolean z) {
        super(context, i, z);
    }

    public WrappedLinearLayoutManager(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
