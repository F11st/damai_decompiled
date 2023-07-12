package com.alibaba.pictures.bricks.component.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.NestedBannerBean;
import com.alibaba.pictures.bricks.component.home.NestedBannerContract;
import com.alibaba.pictures.bricks.component.home.NestedBannerView;
import com.alibaba.pictures.bricks.view.BannerAttachedAutoPlayCondition;
import com.alibaba.pictures.bricks.view.NestedBanner;
import com.alibaba.pictures.bricks.view.NestedBannerIndicatorView;
import com.alibaba.pictures.bricks.view.NestedListener;
import com.alibaba.pictures.bricks.view.NestedRecyclerView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.uplayer.AliMediaPlayer;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ap2;
import tb.b41;
import tb.lj1;
import tb.nd;
import tb.s60;
import tb.ty1;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class NestedBannerView extends AbsView<GenericItem<ItemValue>, NestedBannerModel, NestedBannerPresent> implements NestedBannerContract.View, NestedListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isInSuperFrameState;
    private boolean isLargeScreen;
    @NotNull
    private final View itemView;
    private final NestedBanner mBanner;
    private final ViewGroup mBannerContainer;
    @Nullable
    private OnBannerListener mBannerListener;
    @Nullable
    private ValueAnimator mCollapseAnimator;
    @NotNull
    private final Context mContext;
    @Nullable
    private ArrayList<NestedBannerBean> mCurList;
    private final float mHeightShouldFold;
    private final NestedBannerIndicatorView mIndicator;
    @Nullable
    private Integer mLastMove;
    private final int mMaxHeight;
    private final int mMinHeight;
    @Nullable
    private NestedRecyclerView mNestedRecyclerView;
    @NotNull
    private final ArrayList<NestedBannerBean> mSuperList;
    @NotNull
    private final ArrayList<NestedBannerBean> mTotalList;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "663754937")) {
                ipChange.ipc$dispatch("663754937", new Object[]{this, view});
                return;
            }
            if (NestedBannerView.this.mNestedRecyclerView == null) {
                NestedBannerView.this.mNestedRecyclerView = NestedRecyclerView.Companion.a(view);
            }
            NestedRecyclerView nestedRecyclerView = NestedBannerView.this.mNestedRecyclerView;
            if (nestedRecyclerView != null) {
                NestedBannerView nestedBannerView = NestedBannerView.this;
                nd.b("Banner " + nestedBannerView.mBanner.hashCode() + " add listener into RecyclerView", null, 2, null);
                nestedRecyclerView.addListener(nestedBannerView);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1958128906")) {
                ipChange.ipc$dispatch("-1958128906", new Object[]{this, view});
                return;
            }
            NestedRecyclerView nestedRecyclerView = NestedBannerView.this.mNestedRecyclerView;
            if (nestedRecyclerView != null) {
                NestedBannerView nestedBannerView = NestedBannerView.this;
                nd.b("Banner " + nestedBannerView.mBanner.hashCode() + " remove listener form RecyclerView", null, 2, null);
                nestedRecyclerView.removeListener(nestedBannerView);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b implements OnBannerListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.alibaba.pictures.bricks.component.home.OnBannerListener
        public void onBannerItemClick(@NotNull View view, @NotNull NestedBannerBean nestedBannerBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "882291759")) {
                ipChange.ipc$dispatch("882291759", new Object[]{this, view, nestedBannerBean, Integer.valueOf(i)});
                return;
            }
            b41.i(view, "view");
            b41.i(nestedBannerBean, "bean");
            OnBannerListener mBannerListener = NestedBannerView.this.getMBannerListener();
            if (mBannerListener != null) {
                mBannerListener.onBannerItemClick(view, nestedBannerBean, i);
            }
        }

        @Override // com.alibaba.pictures.bricks.component.home.OnBannerListener
        public void onBannerViewExpose(@NotNull View view, @NotNull NestedBannerBean nestedBannerBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1050695625")) {
                ipChange.ipc$dispatch("1050695625", new Object[]{this, view, nestedBannerBean, Integer.valueOf(i)});
                return;
            }
            b41.i(view, "view");
            b41.i(nestedBannerBean, "bean");
            OnBannerListener mBannerListener = NestedBannerView.this.getMBannerListener();
            if (mBannerListener != null) {
                mBannerListener.onBannerViewExpose(view, nestedBannerBean, i);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class c implements BannerAttachedAutoPlayCondition {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // com.alibaba.pictures.bricks.view.BannerAttachedAutoPlayCondition
        public boolean isCanAutoPlay() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-520392297")) {
                return ((Boolean) ipChange.ipc$dispatch("-520392297", new Object[]{this})).booleanValue();
            }
            NestedRecyclerView nestedRecyclerView = NestedBannerView.this.mNestedRecyclerView;
            if (nestedRecyclerView != null) {
                return nestedRecyclerView.getScrollState() == 0;
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class d extends AnimatorListenerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Function1<Boolean, wt2> a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super Boolean, wt2> function1) {
            this.a = function1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "860218077")) {
                ipChange.ipc$dispatch("860218077", new Object[]{this, animator});
            } else {
                this.a.invoke(Boolean.TRUE);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedBannerView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        this.mBannerContainer = (ViewGroup) view.findViewById(R$id.id_bricks_banner_container);
        NestedBanner nestedBanner = (NestedBanner) view.findViewById(R$id.id_bricks_nested_banner_view);
        this.mBanner = nestedBanner;
        NestedBannerIndicatorView nestedBannerIndicatorView = (NestedBannerIndicatorView) view.findViewById(R$id.id_bricks_banner_indicator_view);
        this.mIndicator = nestedBannerIndicatorView;
        s60 s60Var = s60.INSTANCE;
        Context context = view.getContext();
        b41.h(context, "itemView.context");
        this.mMaxHeight = s60Var.b(context, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD_UPGEAR_NEED_BUFFER);
        Context context2 = view.getContext();
        b41.h(context2, "itemView.context");
        this.mMinHeight = s60Var.b(context2, 70);
        Context context3 = view.getContext();
        b41.h(context3, "itemView.context");
        this.mHeightShouldFold = DisplayMetrics.getheightPixels(s60Var.f(context3)) / 5.0f;
        this.mTotalList = new ArrayList<>();
        this.mSuperList = new ArrayList<>();
        Context context4 = view.getContext();
        b41.h(context4, "itemView.context");
        this.mContext = context4;
        view.addOnAttachStateChangeListener(new a());
        nestedBanner.setViewBinder(new lj1(new b()));
        nestedBanner.setAutoPlayCondition(new c());
        b41.h(nestedBannerIndicatorView, "mIndicator");
        nestedBanner.setViewIndicator(nestedBannerIndicatorView);
    }

    private final void ensureCancelLastAnimator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169068394")) {
            ipChange.ipc$dispatch("1169068394", new Object[]{this});
            return;
        }
        ValueAnimator valueAnimator = this.mCollapseAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        this.mCollapseAnimator = null;
    }

    private final void expandBannerView(boolean z, boolean z2, Function1<? super Boolean, wt2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1427132198")) {
            ipChange.ipc$dispatch("-1427132198", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), function1});
            return;
        }
        ensureCancelLastAnimator();
        final ViewGroup viewGroup = this.mBannerContainer;
        final ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams != null) {
            b41.h(layoutParams, "layoutParams");
            int i = z ? this.mMaxHeight : this.mMinHeight;
            int i2 = layoutParams.height;
            if (i == i2) {
                function1.invoke(Boolean.FALSE);
            } else if (!z2) {
                viewGroup.getLayoutParams().height = i;
                function1.invoke(Boolean.TRUE);
                viewGroup.requestLayout();
            } else {
                ValueAnimator ofInt = ValueAnimator.ofInt(i2, i);
                this.mCollapseAnimator = ofInt;
                ofInt.setDuration(150L);
                ofInt.addListener(new d(function1));
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tb.kj1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        NestedBannerView.m125expandBannerView$lambda3$lambda2$lambda1$lambda0(layoutParams, this, viewGroup, valueAnimator);
                    }
                });
                ofInt.start();
            }
        }
    }

    static /* synthetic */ void expandBannerView$default(NestedBannerView nestedBannerView, boolean z, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        nestedBannerView.expandBannerView(z, z2, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: expandBannerView$lambda-3$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m125expandBannerView$lambda3$lambda2$lambda1$lambda0(ViewGroup.LayoutParams layoutParams, NestedBannerView nestedBannerView, ViewGroup viewGroup, ValueAnimator valueAnimator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1508543709")) {
            ipChange.ipc$dispatch("1508543709", new Object[]{layoutParams, nestedBannerView, viewGroup, valueAnimator});
            return;
        }
        b41.i(layoutParams, "$this_layoutP");
        b41.i(nestedBannerView, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        b41.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        int i = layoutParams.height - intValue;
        layoutParams.height = intValue;
        NestedRecyclerView nestedRecyclerView = nestedBannerView.mNestedRecyclerView;
        if (nestedRecyclerView != null) {
            nestedRecyclerView.scrollBy(0, -i);
        }
        viewGroup.requestLayout();
    }

    private final boolean isBannerViewSupportExpand() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-646829695")) {
            return ((Boolean) ipChange.ipc$dispatch("-646829695", new Object[]{this})).booleanValue();
        }
        if (this.isLargeScreen || this.mSuperList.isEmpty()) {
            return false;
        }
        Object c2 = ap2.INSTANCE.c(this.mCurList, this.mBanner.getCurrentItem());
        if (c2 instanceof NestedBannerBean) {
            return ((NestedBannerBean) c2).isSuperFrameBanner();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049 A[Catch: Exception -> 0x0029, TRY_LEAVE, TryCatch #0 {Exception -> 0x0029, blocks: (B:7:0x0020, B:16:0x002f, B:19:0x003c, B:20:0x0043, B:22:0x0049), top: B:29:0x0020 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean isNeedUpdateBanner(java.util.List<? extends com.alibaba.pictures.bricks.bean.NestedBannerBean> r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.component.home.NestedBannerView.$ipChange
            java.lang.String r1 = "503022495"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L1e
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r6
            r2[r4] = r7
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            return r7
        L1e:
            if (r7 == 0) goto L2b
            boolean r0 = r7.isEmpty()     // Catch: java.lang.Exception -> L29
            if (r0 == 0) goto L27
            goto L2b
        L27:
            r0 = 0
            goto L2c
        L29:
            r7 = move-exception
            goto L60
        L2b:
            r0 = 1
        L2c:
            if (r0 == 0) goto L2f
            return r4
        L2f:
            java.util.ArrayList<com.alibaba.pictures.bricks.bean.NestedBannerBean> r0 = r6.mTotalList     // Catch: java.lang.Exception -> L29
            int r0 = r0.size()     // Catch: java.lang.Exception -> L29
            int r1 = r7.size()     // Catch: java.lang.Exception -> L29
            if (r0 == r1) goto L3c
            return r4
        L3c:
            java.util.ArrayList<com.alibaba.pictures.bricks.bean.NestedBannerBean> r0 = r6.mTotalList     // Catch: java.lang.Exception -> L29
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L29
            r1 = 0
        L43:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Exception -> L29
            if (r2 == 0) goto L5f
            int r2 = r1 + 1
            java.lang.Object r5 = r0.next()     // Catch: java.lang.Exception -> L29
            com.alibaba.pictures.bricks.bean.NestedBannerBean r5 = (com.alibaba.pictures.bricks.bean.NestedBannerBean) r5     // Catch: java.lang.Exception -> L29
            java.lang.Object r1 = r7.get(r1)     // Catch: java.lang.Exception -> L29
            boolean r1 = tb.b41.d(r5, r1)     // Catch: java.lang.Exception -> L29
            if (r1 != 0) goto L5d
            r3 = 1
            goto L5f
        L5d:
            r1 = r2
            goto L43
        L5f:
            return r3
        L60:
            r7.printStackTrace()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.home.NestedBannerView.isNeedUpdateBanner(java.util.List):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBannerView(boolean z) {
        Object c2;
        int U;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2107844509")) {
            ipChange.ipc$dispatch("-2107844509", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isInSuperFrameState = z;
        ArrayList<NestedBannerBean> arrayList = this.mCurList;
        int currentItem = this.mBanner.getCurrentItem();
        ArrayList<NestedBannerBean> arrayList2 = z ? this.mSuperList : this.mTotalList;
        this.mCurList = arrayList2;
        this.mBanner.forceUpdate(arrayList2);
        if (arrayList == null || this.mCurList == null || (c2 = ap2.INSTANCE.c(arrayList, currentItem)) == null) {
            return;
        }
        ArrayList<NestedBannerBean> arrayList3 = this.mCurList;
        b41.f(arrayList3);
        U = CollectionsKt___CollectionsKt.U(arrayList3, c2);
        if (U >= 0) {
            this.mBanner.setCurrentItem(U, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFirstInitItem() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2090374581")) {
            ipChange.ipc$dispatch("2090374581", new Object[]{this});
            return;
        }
        int size = this.mTotalList.size();
        if (size > 0) {
            if (this.isLargeScreen) {
                this.mBanner.setCurrentItem(size < 3 ? 0 : 1, false);
            } else {
                this.mBanner.setCurrentItem(0, false);
            }
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.NestedBannerContract.View
    public void bind(@Nullable List<? extends NestedBannerBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "629566003")) {
            ipChange.ipc$dispatch("629566003", new Object[]{this, list});
        } else if (isNeedUpdateBanner(list)) {
            nd.b("Banner " + this.mBanner.hashCode() + " bind new data", null, 2, null);
            this.mBanner.stopAnimation();
            ensureCancelLastAnimator();
            this.mTotalList.clear();
            this.mSuperList.clear();
            if (list != null) {
                for (NestedBannerBean nestedBannerBean : list) {
                    this.mTotalList.add(nestedBannerBean);
                    if (nestedBannerBean.isSuperFrameBanner()) {
                        this.mSuperList.add(nestedBannerBean);
                    }
                }
            }
            showBannerView(false);
            showFirstInitItem();
            expandBannerView(false, false, new Function1<Boolean, wt2>() { // from class: com.alibaba.pictures.bricks.component.home.NestedBannerView$bind$2
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return wt2.INSTANCE;
                }

                public final void invoke(boolean z) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "823755946")) {
                        ipChange2.ipc$dispatch("823755946", new Object[]{this, Boolean.valueOf(z)});
                    } else {
                        NestedBannerView.this.mBanner.startAnimation();
                    }
                }
            });
        } else {
            nd.b("Banner " + this.mBanner.hashCode() + " same data return", null, 2, null);
        }
    }

    @Override // com.alibaba.pictures.bricks.view.NestedListener
    public void dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr) {
        ViewGroup.LayoutParams layoutParams;
        int a2;
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-260306726")) {
            ipChange.ipc$dispatch("-260306726", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), iArr});
        } else if (i2 == 0 || !this.mBanner.isSelfAttachedToWindow() || !isBannerViewSupportExpand() || (layoutParams = this.mBannerContainer.getLayoutParams()) == null) {
        } else {
            this.mLastMove = Integer.valueOf(i2);
            int i4 = layoutParams.height;
            if (i2 > 0) {
                if (i4 < this.mMaxHeight) {
                    if (!this.isInSuperFrameState) {
                        showBannerView(true);
                    }
                    a2 = ty1.d(this.mMaxHeight, i2 + i4);
                    layoutParams.height = a2;
                    this.mBannerContainer.requestLayout();
                    i3 = a2 - i4;
                }
                if (iArr == null && iArr.length == 2) {
                    iArr[1] = i3;
                }
            } else if (this.itemView.getTop() <= this.mHeightShouldFold) {
            } else {
                int i5 = this.mMinHeight;
                if (i4 > i5) {
                    a2 = ty1.a(i5, i2 + i4);
                    layoutParams.height = a2;
                    this.mBannerContainer.requestLayout();
                    i3 = a2 - i4;
                }
                if (iArr == null) {
                }
            }
        }
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1502043007") ? (View) ipChange.ipc$dispatch("1502043007", new Object[]{this}) : this.itemView;
    }

    @Nullable
    public final OnBannerListener getMBannerListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1544438240") ? (OnBannerListener) ipChange.ipc$dispatch("1544438240", new Object[]{this}) : this.mBannerListener;
    }

    @Override // com.alibaba.pictures.bricks.component.home.NestedBannerContract.View
    public boolean isLargeScreenMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "178947407") ? ((Boolean) ipChange.ipc$dispatch("178947407", new Object[]{this})).booleanValue() : this.isLargeScreen;
    }

    public final void setMBannerListener(@Nullable OnBannerListener onBannerListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2105326764")) {
            ipChange.ipc$dispatch("-2105326764", new Object[]{this, onBannerListener});
        } else {
            this.mBannerListener = onBannerListener;
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.NestedBannerContract.View
    public void setScreenMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1796086182")) {
            ipChange.ipc$dispatch("-1796086182", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mBanner.stopAnimation();
        ensureCancelLastAnimator();
        this.isLargeScreen = z;
        ViewGroup viewGroup = this.mBannerContainer;
        if (viewGroup != null) {
            viewGroup.setClipChildren(!z);
        }
        NestedBanner nestedBanner = this.mBanner;
        if (nestedBanner != null) {
            nestedBanner.setClipChildren(!z);
            nestedBanner.setOffscreenPageLimit(z ? 2 : 1);
            nestedBanner.setPageMargin(z ? s60.INSTANCE.b(this.mContext, 6) : 0);
            ViewGroup.LayoutParams layoutParams = nestedBanner.getLayoutParams();
            if (layoutParams != null) {
                b41.h(layoutParams, "layoutParams");
                if (z) {
                    int i = (int) (this.mMinHeight * 5.1f);
                    s60 s60Var = s60.INSTANCE;
                    layoutParams.width = DisplayMetrics.getwidthPixels(s60Var.f(this.mContext)) - s60Var.b(this.mContext, 36) > i ? i : -1;
                    nestedBanner.requestLayout();
                } else {
                    layoutParams.width = -1;
                    nestedBanner.requestLayout();
                }
            }
        }
        expandBannerView$default(this, false, false, new Function1<Boolean, wt2>() { // from class: com.alibaba.pictures.bricks.component.home.NestedBannerView$setScreenMode$3
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return wt2.INSTANCE;
            }

            public final void invoke(boolean z2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-147121487")) {
                    ipChange2.ipc$dispatch("-147121487", new Object[]{this, Boolean.valueOf(z2)});
                    return;
                }
                NestedBannerView.this.showBannerView(false);
                NestedBannerView.this.showFirstInitItem();
            }
        }, 2, null);
    }

    @Override // com.alibaba.pictures.bricks.view.NestedListener
    public void startNestedScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-299830619")) {
            ipChange.ipc$dispatch("-299830619", new Object[]{this});
            return;
        }
        this.mBanner.stopAnimation();
        ensureCancelLastAnimator();
        this.mLastMove = null;
    }

    @Override // com.alibaba.pictures.bricks.view.NestedListener
    public void stopNestedScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2025261543")) {
            ipChange.ipc$dispatch("-2025261543", new Object[]{this});
            return;
        }
        if (isBannerViewSupportExpand()) {
            Integer num = this.mLastMove;
            if (num != null) {
                final boolean z = num.intValue() >= 0;
                expandBannerView$default(this, z, false, new Function1<Boolean, wt2>() { // from class: com.alibaba.pictures.bricks.component.home.NestedBannerView$stopNestedScroll$1$1
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ wt2 invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return wt2.INSTANCE;
                    }

                    public final void invoke(boolean z2) {
                        boolean z3;
                        boolean z4;
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1365790261")) {
                            ipChange2.ipc$dispatch("1365790261", new Object[]{this, Boolean.valueOf(z2)});
                            return;
                        }
                        if (z) {
                            z4 = this.isInSuperFrameState;
                            if (!z4) {
                                this.showBannerView(true);
                            }
                        } else {
                            z3 = this.isInSuperFrameState;
                            if (z3) {
                                this.showBannerView(false);
                            }
                        }
                        this.mBanner.startAnimation();
                    }
                }, 2, null);
            } else {
                num = null;
            }
            if (num == null) {
                this.mBanner.startAnimation();
            }
        } else {
            expandBannerView$default(this, false, false, new Function1<Boolean, wt2>() { // from class: com.alibaba.pictures.bricks.component.home.NestedBannerView$stopNestedScroll$3
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return wt2.INSTANCE;
                }

                public final void invoke(boolean z2) {
                    boolean z3;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "277744800")) {
                        ipChange2.ipc$dispatch("277744800", new Object[]{this, Boolean.valueOf(z2)});
                        return;
                    }
                    z3 = NestedBannerView.this.isInSuperFrameState;
                    if (z3) {
                        NestedBannerView.this.showBannerView(false);
                    }
                    NestedBannerView.this.mBanner.startAnimation();
                }
            }, 2, null);
        }
        this.mLastMove = null;
    }
}
