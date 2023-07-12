package com.alibaba.pictures.bricks.component.home;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.home.HorizontalPageContract;
import com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPresent;
import com.alibaba.pictures.bricks.component.home.calendar.NIndicator;
import com.alient.onearch.adapter.component.horizontal.GenericHorizontalView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.util.ViewUtil;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HorizontalPageView extends GenericHorizontalView implements HorizontalPageContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private static boolean SCROLLER_TAG;
    @NotNull
    private final FrameLayout container;
    @NotNull
    private final NIndicator indicator;
    @NotNull
    private final View itemView;
    @NotNull
    public static final C3455a Companion = new C3455a(null);
    @NotNull
    private static final String SCROLLER_TAG_KEY = "HOME_CALENDAR_SCROLLER";

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class HorizontalViewItemDecoration extends RecyclerView.ItemDecoration {
        private static transient /* synthetic */ IpChange $ipChange;
        private final int a;
        private final int b;
        private final int c;

        public HorizontalViewItemDecoration(HorizontalPageView horizontalPageView, int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect rect, int i, @NotNull RecyclerView recyclerView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-916230543")) {
                ipChange.ipc$dispatch("-916230543", new Object[]{this, rect, Integer.valueOf(i), recyclerView});
                return;
            }
            b41.i(rect, "outRect");
            b41.i(recyclerView, "parent");
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                if (i == 0) {
                    int i2 = this.b;
                    if (i2 != 0) {
                        rect.left = i2;
                    } else {
                        rect.left = this.a;
                    }
                } else if (i == adapter.getItemCount() - 1) {
                    int i3 = this.c;
                    if (i3 != 0) {
                        rect.right = i3;
                    } else {
                        rect.right = this.a;
                    }
                    rect.left = this.a;
                } else {
                    rect.left = this.a;
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.home.HorizontalPageView$a */
    /* loaded from: classes7.dex */
    public static final class C3455a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3455a() {
        }

        public /* synthetic */ C3455a(k50 k50Var) {
            this();
        }

        @NotNull
        public final String a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1433968088") ? (String) ipChange.ipc$dispatch("1433968088", new Object[]{this}) : HorizontalPageView.SCROLLER_TAG_KEY;
        }

        public final void b(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1790975512")) {
                ipChange.ipc$dispatch("1790975512", new Object[]{this, Boolean.valueOf(z)});
            } else {
                HorizontalPageView.SCROLLER_TAG = z;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalPageView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        View findViewById = view.findViewById(R$id.indicator);
        b41.h(findViewById, "itemView.findViewById(R.id.indicator)");
        this.indicator = (NIndicator) findViewById;
        View findViewById2 = view.findViewById(R$id.container);
        b41.h(findViewById2, "itemView.findViewById(R.id.container)");
        this.container = (FrameLayout) findViewById2;
    }

    private final int getDimenId(Context context, Map<String, ? extends Object> map, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-740154445")) {
            return ((Integer) ipChange.ipc$dispatch("-740154445", new Object[]{this, context, map, str})).intValue();
        }
        if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), Constants.DIMEN);
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    @Override // com.alibaba.pictures.bricks.component.home.HorizontalPageContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bindView(@org.jetbrains.annotations.Nullable com.alibaba.fastjson.JSONObject r8) {
        /*
            r7 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.component.home.HorizontalPageView.$ipChange
            java.lang.String r1 = "940877923"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r7
            r2[r3] = r8
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            if (r8 == 0) goto L36
            java.lang.String r0 = "total"
            java.lang.Object r8 = r8.get(r0)     // Catch: java.lang.NumberFormatException -> L2a
            if (r8 == 0) goto L36
            java.lang.String r8 = r8.toString()     // Catch: java.lang.NumberFormatException -> L2a
            int r8 = java.lang.Integer.parseInt(r8)     // Catch: java.lang.NumberFormatException -> L2a
            goto L37
        L2a:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()
            if (r8 == 0) goto L36
            com.youku.gaiax.js.utils.Log r0 = com.youku.gaiax.js.utils.Log.INSTANCE
            r0.e(r8)
        L36:
            r8 = 0
        L37:
            com.alibaba.pictures.bricks.component.home.calendar.NIndicator r0 = r7.indicator
            r1 = 3
            if (r8 <= r1) goto L3e
            r2 = 0
            goto L40
        L3e:
            r2 = 8
        L40:
            r0.setVisibility(r2)
            java.lang.String r0 = "itemView.context"
            tb.s60 r2 = tb.s60.INSTANCE
            if (r8 <= r1) goto L58
            android.view.View r3 = r7.itemView
            android.content.Context r3 = r3.getContext()
            tb.b41.h(r3, r0)
            r0 = 4
            int r0 = r2.b(r3, r0)
            goto L65
        L58:
            android.view.View r5 = r7.itemView
            android.content.Context r5 = r5.getContext()
            tb.b41.h(r5, r0)
            int r0 = r2.b(r5, r3)
        L65:
            android.widget.FrameLayout r2 = r7.container
            r2.setPadding(r4, r4, r4, r0)
            if (r8 <= r1) goto Lbf
            boolean r8 = com.alibaba.pictures.bricks.component.home.HorizontalPageView.SCROLLER_TAG
            if (r8 != 0) goto Lbf
            java.lang.String r8 = com.alibaba.pictures.bricks.component.home.HorizontalPageView.SCROLLER_TAG_KEY
            boolean r8 = com.youku.middlewareservice.provider.kvdata.SPProviderProxy.getPreferenceBoolean(r8)
            if (r8 != 0) goto Lbf
            kotlin.jvm.internal.Ref$IntRef r8 = new kotlin.jvm.internal.Ref$IntRef
            r8.<init>()
            tb.s60 r0 = tb.s60.INSTANCE
            androidx.recyclerview.widget.RecyclerView r1 = r7.getRecyclerView()
            android.content.Context r1 = r1.getContext()
            java.lang.String r2 = "recyclerView.context"
            tb.b41.h(r1, r2)
            android.util.DisplayMetrics r1 = r0.f(r1)
            int r1 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(r1)
            int r1 = r1 / 6
            androidx.recyclerview.widget.RecyclerView r3 = r7.getRecyclerView()
            android.content.Context r3 = r3.getContext()
            tb.b41.h(r3, r2)
            r2 = 18
            int r0 = r0.b(r3, r2)
            int r1 = r1 + r0
            r8.element = r1
            kotlinx.coroutines.CoroutineDispatcher r0 = tb.da0.b()
            kotlinx.coroutines.CoroutineScope r1 = tb.ro.a(r0)
            r2 = 0
            r3 = 0
            com.alibaba.pictures.bricks.component.home.HorizontalPageView$bindView$3 r4 = new com.alibaba.pictures.bricks.component.home.HorizontalPageView$bindView$3
            r0 = 0
            r4.<init>(r7, r8, r0)
            r5 = 3
            r6 = 0
            kotlinx.coroutines.C8658e.b(r1, r2, r3, r4, r5, r6)
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.home.HorizontalPageView.bindView(com.alibaba.fastjson.JSONObject):void");
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "682128175") ? (View) ipChange.ipc$dispatch("682128175", new Object[]{this}) : this.itemView;
    }

    @Override // com.alient.onearch.adapter.component.horizontal.GenericHorizontalView, com.alient.onearch.adapter.component.horizontal.GenericHorizontalContract.View
    public void initRecyclerSettings(@Nullable RecyclerView.RecycledViewPool recycledViewPool, @Nullable Map<String, ? extends Object> map) {
        int intValue;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1493016261")) {
            ipChange.ipc$dispatch("1493016261", new Object[]{this, recycledViewPool, map});
            return;
        }
        super.initRecyclerSettings(recycledViewPool, map);
        if (map == null) {
            return;
        }
        int dimenId = getDimenId(getRecyclerView().getContext(), map, Constants.GAP);
        int dimensionPixelSize = dimenId != 0 ? getRecyclerView().getContext().getResources().getDimensionPixelSize(dimenId) : 0;
        int dimenId2 = getDimenId(getRecyclerView().getContext(), map, "listMarginLeft");
        int dimensionPixelSize2 = dimenId2 != 0 ? getRecyclerView().getContext().getResources().getDimensionPixelSize(dimenId2) : 0;
        int dimenId3 = getDimenId(getRecyclerView().getContext(), map, "listMarginRight");
        int dimensionPixelSize3 = dimenId3 != 0 ? getRecyclerView().getContext().getResources().getDimensionPixelSize(dimenId3) : 0;
        if (map.get(Constants.Name.COLUMN_COUNT) == null) {
            intValue = 0;
        } else {
            Object obj = map.get(Constants.Name.COLUMN_COUNT);
            b41.g(obj, "null cannot be cast to non-null type kotlin.Int");
            intValue = ((Integer) obj).intValue();
        }
        getRecyclerView().removeItemDecorationAt(getRecyclerView().getItemDecorationCount() - 1);
        getRecyclerView().addItemDecoration(new HorizontalViewItemDecoration(this, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, intValue));
        this.indicator.bindRecyclerView(getRecyclerView());
        HomeCalendarPresent.Companion.a(0);
    }
}
