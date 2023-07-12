package com.alient.onearch.adapter.responsive.util;

import android.app.Activity;
import com.alibaba.android.vlayout.AbstractC3289a;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.recyclerview.layouthelper.FeedStaggeredGridLayoutHelper;
import com.youku.arch.v3.recyclerview.layouthelper.GridFixAutoStatLayoutHelper;
import com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.wt2;
import tb.ye2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\f\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u000f"}, d2 = {"Lcom/alient/onearch/adapter/responsive/util/ResponsiveLayoutDataUtil;", "", "Lcom/youku/arch/v3/core/IContext;", Constants.PAGE_CONTEXT, "", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "updatedComponents", "Ltb/wt2;", "notifyResponsiveLayoutAdapterChanged", "component", "responsiveLayoutAdapter", "responsiveLayoutHelper", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class ResponsiveLayoutDataUtil {
    @NotNull
    public static final ResponsiveLayoutDataUtil INSTANCE = new ResponsiveLayoutDataUtil();

    private ResponsiveLayoutDataUtil() {
    }

    public final void notifyResponsiveLayoutAdapterChanged(@NotNull final IContext iContext, @NotNull final List<? extends IComponent<ComponentValue>> list) {
        b41.i(iContext, Constants.PAGE_CONTEXT);
        b41.i(list, "updatedComponents");
        if (!list.isEmpty()) {
            iContext.runOnUIThread(new Function0<wt2>() { // from class: com.alient.onearch.adapter.responsive.util.ResponsiveLayoutDataUtil$notifyResponsiveLayoutAdapterChanged$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    try {
                        IContainer<ModelValue> pageContainer = IContext.this.getPageContainer();
                        if (pageContainer != null) {
                            pageContainer.updateContentAdapter();
                        }
                        for (IComponent<ComponentValue> iComponent : list) {
                            ResponsiveLayoutDataUtil.INSTANCE.responsiveLayoutAdapter(iComponent);
                            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iComponent.getAdapter();
                            if (adapter != null) {
                                adapter.notifyItemRangeChanged(0, iComponent.getChildCount());
                            }
                        }
                    } catch (Exception e) {
                        if (AppInfoProviderProxy.isDebuggable()) {
                            throw e;
                        }
                    }
                }
            });
        }
    }

    public final void responsiveLayoutAdapter(@NotNull IComponent<ComponentValue> iComponent) {
        b41.i(iComponent, "component");
        if (iComponent.getAdapter() == null) {
            return;
        }
        INSTANCE.responsiveLayoutHelper(iComponent);
    }

    public final void responsiveLayoutHelper(@NotNull IComponent<ComponentValue> iComponent) {
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter;
        AbstractC3289a layoutHelper;
        b41.i(iComponent, "component");
        Activity activity = iComponent.getPageContext().getActivity();
        if (activity == null || (adapter = iComponent.getAdapter()) == null || (layoutHelper = adapter.getLayoutHelper()) == null) {
            return;
        }
        if (layoutHelper instanceof GridFixAutoStatLayoutHelper) {
            GridFixAutoStatLayoutHelper gridFixAutoStatLayoutHelper = (GridFixAutoStatLayoutHelper) layoutHelper;
            gridFixAutoStatLayoutHelper.setSpanCount(ye2.INSTANCE.d(activity, gridFixAutoStatLayoutHelper.getRawSpanCount()));
        } else if (layoutHelper instanceof StaggeredGridLayoutHelper) {
            StaggeredGridLayoutHelper staggeredGridLayoutHelper = (StaggeredGridLayoutHelper) layoutHelper;
            staggeredGridLayoutHelper.setLane(ye2.INSTANCE.d(activity, staggeredGridLayoutHelper.getRawLane()));
        } else if (layoutHelper instanceof FeedStaggeredGridLayoutHelper) {
            FeedStaggeredGridLayoutHelper feedStaggeredGridLayoutHelper = (FeedStaggeredGridLayoutHelper) layoutHelper;
            feedStaggeredGridLayoutHelper.setLane(ye2.INSTANCE.d(activity, feedStaggeredGridLayoutHelper.getRawLane()));
        }
    }
}
