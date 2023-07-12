package com.alibaba.gaiax.render.utils;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.GXIContainer;
import com.alibaba.gaiax.render.view.container.GXContainer;
import com.alibaba.gaiax.render.view.container.GXViewHolder;
import com.alibaba.gaiax.render.view.container.slider.GXSliderView;
import com.alibaba.gaiax.render.view.container.slider.GXSliderViewAdapter;
import com.alibaba.gaiax.render.view.container.slider.GXViewPager;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.os0;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class GXContainerUtils {
    @NotNull
    public static final GXContainerUtils INSTANCE = new GXContainerUtils();

    private GXContainerUtils() {
    }

    private final void d(GXIContainer gXIContainer, Function1<? super View, wt2> function1) {
        GXViewPager viewPager;
        View c;
        try {
            if (gXIContainer instanceof GXContainer) {
                if (((GXContainer) gXIContainer).getLayoutManager() instanceof LinearLayoutManager) {
                    RecyclerView.LayoutManager layoutManager = ((GXContainer) gXIContainer).getLayoutManager();
                    if (layoutManager != null) {
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition() + 1;
                        if (findFirstVisibleItemPosition > findLastVisibleItemPosition) {
                            return;
                        }
                        while (true) {
                            int i = findFirstVisibleItemPosition + 1;
                            RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((GXContainer) gXIContainer).findViewHolderForLayoutPosition(findFirstVisibleItemPosition);
                            GXViewHolder gXViewHolder = findViewHolderForLayoutPosition instanceof GXViewHolder ? (GXViewHolder) findViewHolderForLayoutPosition : null;
                            if (gXViewHolder != null) {
                                View view = gXViewHolder.itemView;
                                b41.h(view, "it.itemView");
                                function1.invoke(view);
                            }
                            if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                                return;
                            }
                            findFirstVisibleItemPosition = i;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    }
                } else if (!(((GXContainer) gXIContainer).getLayoutManager() instanceof GridLayoutManager)) {
                } else {
                    RecyclerView.LayoutManager layoutManager2 = ((GXContainer) gXIContainer).getLayoutManager();
                    if (layoutManager2 != null) {
                        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager2;
                        int findFirstVisibleItemPosition2 = gridLayoutManager.findFirstVisibleItemPosition();
                        int findLastVisibleItemPosition2 = gridLayoutManager.findLastVisibleItemPosition() + 1;
                        if (findFirstVisibleItemPosition2 > findLastVisibleItemPosition2) {
                            return;
                        }
                        while (true) {
                            int i2 = findFirstVisibleItemPosition2 + 1;
                            RecyclerView.ViewHolder findViewHolderForLayoutPosition2 = ((GXContainer) gXIContainer).findViewHolderForLayoutPosition(findFirstVisibleItemPosition2);
                            GXViewHolder gXViewHolder2 = findViewHolderForLayoutPosition2 instanceof GXViewHolder ? (GXViewHolder) findViewHolderForLayoutPosition2 : null;
                            if (gXViewHolder2 != null) {
                                View view2 = gXViewHolder2.itemView;
                                b41.h(view2, "it.itemView");
                                function1.invoke(view2);
                            }
                            if (findFirstVisibleItemPosition2 == findLastVisibleItemPosition2) {
                                return;
                            }
                            findFirstVisibleItemPosition2 = i2;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                    }
                }
            } else {
                if ((gXIContainer instanceof GXSliderView) && (viewPager = ((GXSliderView) gXIContainer).getViewPager()) != null) {
                    PagerAdapter adapter = viewPager.getAdapter();
                    if ((adapter instanceof GXSliderViewAdapter) && (c = ((GXSliderViewAdapter) adapter).c(viewPager.getCurrentItem())) != null) {
                        function1.invoke(c);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                GXTemplateEngine a = GXTemplateEngine.Companion.a();
                View childAt = viewGroup.getChildAt(0);
                b41.h(childAt, "view.getChildAt(0)");
                a.s(childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                GXTemplateEngine a = GXTemplateEngine.Companion.a();
                View childAt = viewGroup.getChildAt(0);
                b41.h(childAt, "view.getChildAt(0)");
                a.t(childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                GXTemplateEngine a = GXTemplateEngine.Companion.a();
                View childAt = viewGroup.getChildAt(0);
                b41.h(childAt, "view.getChildAt(0)");
                a.y(childAt);
            }
        }
    }

    public final void e(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        CopyOnWriteArraySet<GXIContainer> d = os0Var.d();
        if (d == null) {
            return;
        }
        for (GXIContainer gXIContainer : d) {
            GXContainerUtils gXContainerUtils = INSTANCE;
            b41.h(gXIContainer, "container");
            gXContainerUtils.d(gXIContainer, new Function1<View, wt2>() { // from class: com.alibaba.gaiax.render.utils.GXContainerUtils$notifyOnAppear$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(View view) {
                    invoke2(view);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View view) {
                    b41.i(view, AdvanceSetting.NETWORK_TYPE);
                    GXContainerUtils.INSTANCE.g(view);
                }
            });
        }
    }

    public final void f(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        CopyOnWriteArraySet<GXIContainer> d = os0Var.d();
        if (d == null) {
            return;
        }
        for (GXIContainer gXIContainer : d) {
            GXContainerUtils gXContainerUtils = INSTANCE;
            b41.h(gXIContainer, "container");
            gXContainerUtils.d(gXIContainer, new Function1<View, wt2>() { // from class: com.alibaba.gaiax.render.utils.GXContainerUtils$notifyOnDisappear$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(View view) {
                    invoke2(view);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View view) {
                    b41.i(view, AdvanceSetting.NETWORK_TYPE);
                    GXContainerUtils.INSTANCE.h(view);
                }
            });
        }
    }
}
