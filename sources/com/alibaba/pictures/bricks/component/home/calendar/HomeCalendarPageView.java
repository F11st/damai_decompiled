package com.alibaba.pictures.bricks.component.home.calendar;

import android.content.Context;
import android.view.View;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.onearch.adapter.component.pager.PagerGridView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.C8690g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.da0;
import tb.k50;
import tb.ro;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeCalendarPageView extends PagerGridView {
    private static transient /* synthetic */ IpChange $ipChange;
    private static boolean SCROLLER_TAG;
    @Nullable
    private Scroller customScroller;
    @NotNull
    public static final C3466a Companion = new C3466a(null);
    @NotNull
    private static final String SCROLLER_TAG_KEY = "HOME_CALENDAR_SCROLLER";

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPageView$a */
    /* loaded from: classes7.dex */
    public static final class C3466a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3466a() {
        }

        public /* synthetic */ C3466a(k50 k50Var) {
            this();
        }

        public final boolean a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2067890782") ? ((Boolean) ipChange.ipc$dispatch("2067890782", new Object[]{this})).booleanValue() : HomeCalendarPageView.SCROLLER_TAG;
        }

        @NotNull
        public final String b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-533828218") ? (String) ipChange.ipc$dispatch("-533828218", new Object[]{this}) : HomeCalendarPageView.SCROLLER_TAG_KEY;
        }

        public final void c(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1863577402")) {
                ipChange.ipc$dispatch("-1863577402", new Object[]{this, Boolean.valueOf(z)});
            } else {
                HomeCalendarPageView.SCROLLER_TAG = z;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeCalendarPageView(@NotNull View view) {
        super(view);
        b41.i(view, "contentView");
    }

    private final void customScroller() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "182012274")) {
            ipChange.ipc$dispatch("182012274", new Object[]{this});
            return;
        }
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(getGridViewPager(), this.customScroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alient.onearch.adapter.component.pager.PagerGridView, com.alient.onearch.adapter.component.pager.PagerGridContract.View
    public void renderPagerInView(int i, int i2, int i3, int i4, int i5, @NotNull List<? extends VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869818338")) {
            ipChange.ipc$dispatch("-869818338", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), list});
            return;
        }
        b41.i(list, "childAdapters");
        super.renderPagerInView(i, i2, i3, i4, i5, list);
        HomeCalendarPresent.Companion.a(0);
        this.customScroller = new Scroller(getGridViewPager().getContext());
        customScroller();
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        s60 s60Var = s60.INSTANCE;
        Context context = getGridViewPager().getContext();
        b41.h(context, "gridViewPager.context");
        Context context2 = getGridViewPager().getContext();
        b41.h(context2, "gridViewPager.context");
        ref$IntRef.element = (DisplayMetrics.getwidthPixels(s60Var.f(context)) / 6) + s60Var.b(context2, 18);
        C8690g.b(ro.a(da0.b()), null, null, new HomeCalendarPageView$renderPagerInView$1(list, this, ref$IntRef, null), 3, null);
    }
}
