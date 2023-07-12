package com.alient.onearch.adapter.component.horizontal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.GenericFactory;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.event.ViewHolderEvent;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.util.ViewUtil;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import com.youku.arch.v3.view.render.AbsRenderPlugin;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.arch.v3.view.render.OnRenderListener;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001EB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\bC\u0010DJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J0\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0016\u0010\u0014\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J&\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\n2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u0016R\u0019\u0010\u001a\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dRH\u0010!\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020 0\u001f\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0019\u00108\u001a\u0002078\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R(\u0010=\u001a\b\u0012\u0002\b\u0003\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006F"}, d2 = {"Lcom/alient/onearch/adapter/component/horizontal/GenericHorizontalViewHolder;", "Lcom/alient/onearch/adapter/view/BaseViewHolder;", "", "Ltb/wt2;", "update", "getPositionAndOffset", "scrollToPosition", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "", "data", "paramName", "", "getDimenId", "onCreate", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "item", "bindData", "setStyle", "type", "params", "", "onMessage", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "listAdapter", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "getListAdapter", "()Lcom/youku/arch/v3/adapter/VBaseAdapter;", "setListAdapter", "(Lcom/youku/arch/v3/adapter/VBaseAdapter;)V", "lastPosition", "I", "lastOffset", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "componentConfig", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemDecoration", "()Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "setItemDecoration", "(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lcom/youku/arch/v3/core/component/GenericComponent;", "fakeComponent", "Lcom/youku/arch/v3/core/component/GenericComponent;", "getFakeComponent", "()Lcom/youku/arch/v3/core/component/GenericComponent;", "setFakeComponent", "(Lcom/youku/arch/v3/core/component/GenericComponent;)V", "<init>", "(Landroid/view/View;)V", "HorizontalViewItemDecoration", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class GenericHorizontalViewHolder extends BaseViewHolder<Object> {
    @Nullable
    private ComponentConfigBean.ComponentBean componentConfig;
    @Nullable
    private GenericComponent<?> fakeComponent;
    @Nullable
    private RecyclerView.ItemDecoration itemDecoration;
    private int lastOffset;
    private int lastPosition;
    @Nullable
    private VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> listAdapter;
    @Nullable
    private RecyclerView.RecycledViewPool recycledViewPool;
    @NotNull
    private final RecyclerView recyclerView;
    @NotNull
    private final View view;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/alient/onearch/adapter/component/horizontal/GenericHorizontalViewHolder$HorizontalViewItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "", "itemPosition", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Ltb/wt2;", "getItemOffsets", Constants.GAP, "I", Constants.Name.MARGIN_LEFT, Constants.Name.MARGIN_RIGHT, "<init>", "(Lcom/alient/onearch/adapter/component/horizontal/GenericHorizontalViewHolder;III)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes10.dex */
    public final class HorizontalViewItemDecoration extends RecyclerView.ItemDecoration {
        private final int gap;
        private final int marginLeft;
        private final int marginRight;
        final /* synthetic */ GenericHorizontalViewHolder this$0;

        public HorizontalViewItemDecoration(GenericHorizontalViewHolder genericHorizontalViewHolder, int i, int i2, int i3) {
            b41.i(genericHorizontalViewHolder, "this$0");
            this.this$0 = genericHorizontalViewHolder;
            this.gap = i;
            this.marginLeft = i2;
            this.marginRight = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect rect, int i, @NotNull RecyclerView recyclerView) {
            b41.i(rect, "outRect");
            b41.i(recyclerView, "parent");
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter == null) {
                return;
            }
            if (i == 0) {
                int i2 = this.marginLeft;
                if (i2 != 0) {
                    rect.left = i2;
                } else {
                    rect.left = this.gap;
                }
            }
            if (i == adapter.getItemCount() - 1) {
                int i3 = this.marginRight;
                if (i3 != 0) {
                    rect.right = i3;
                    return;
                } else {
                    rect.right = this.gap;
                    return;
                }
            }
            rect.right = this.gap / 2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericHorizontalViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.view = view;
        View findViewById = view.findViewById(R.id.horizontal_container);
        b41.h(findViewById, "view.findViewById(R.id.horizontal_container)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.alient.onearch.adapter.component.horizontal.GenericHorizontalViewHolder.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView2, int i) {
                b41.i(recyclerView2, "recyclerView");
                super.onScrollStateChanged(recyclerView2, i);
                if (recyclerView2.getLayoutManager() != null) {
                    GenericHorizontalViewHolder.this.getPositionAndOffset();
                }
            }
        });
    }

    private final int getDimenId(Context context, Map<String, ? extends Object> map, String str) {
        if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), com.youku.arch.v3.data.Constants.DIMEN);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getPositionAndOffset() {
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        View childAt = linearLayoutManager.getChildAt(0);
        if (childAt == null) {
            return;
        }
        this.lastOffset = childAt.getTop();
        this.lastPosition = linearLayoutManager.getPosition(childAt);
    }

    private final void scrollToPosition() {
        if (this.recyclerView.getLayoutManager() == null || this.lastPosition < 0) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        linearLayoutManager.scrollToPositionWithOffset(this.lastPosition, this.lastOffset);
    }

    private final void update() {
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter = this.listAdapter;
        if (vBaseAdapter == null) {
            return;
        }
        getRecyclerView().swapAdapter(vBaseAdapter, true);
        scrollToPosition();
        OnRenderListener onRenderListener = getOnRenderListener();
        if (onRenderListener == null) {
            return;
        }
        onRenderListener.onRenderSuccess((AbsRenderPlugin<?, ?>) null, getView(), getView().getWidth(), getView().getHeight());
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.youku.arch.v3.core.ComponentValue, com.youku.arch.v3.core.Node] */
    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        RecyclerView recyclerView;
        b41.i(iItem, "item");
        if (this.recycledViewPool == null && iItem.getPageContext().getFragment() != null) {
            GenericFragment fragment = iItem.getPageContext().getFragment();
            RecyclerView.RecycledViewPool recycledViewPool = (fragment == null || (recyclerView = fragment.getRecyclerView()) == null) ? null : recyclerView.getRecycledViewPool();
            this.recycledViewPool = recycledViewPool;
            this.recyclerView.setRecycledViewPool(recycledViewPool);
        }
        setStyle(iItem);
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iItem.getComponent().getAdapter();
        if ((adapter == null ? null : adapter.getInnerAdapter()) != null) {
            Activity activity = iItem.getComponent().getPageContext().getActivity();
            if (activity != null) {
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter2 = iItem.getComponent().getAdapter();
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = adapter2 == null ? null : adapter2.getInnerAdapter();
                if (innerAdapter != null) {
                    innerAdapter.setContext(activity);
                }
            }
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter3 = iItem.getComponent().getAdapter();
            this.listAdapter = adapter3 != null ? adapter3.getInnerAdapter() : null;
            update();
            return;
        }
        GenericFactory<IComponent<ComponentValue>, Node> componentFactory = iItem.getComponent().getModule().getComponentFactory();
        GenericComponent<?> genericComponent = (GenericComponent) (componentFactory == null ? null : componentFactory.create(new Config<>(iItem.getPageContext(), iItem.getType(), iItem.getProperty(), 0, false, 24, null)));
        if (genericComponent == null) {
            return;
        }
        setFakeComponent(genericComponent);
        genericComponent.initProperties(iItem.getProperty());
        List<Node> children = genericComponent.getProperty().getChildren();
        if (children != null) {
            int i = 0;
            for (Object obj : children) {
                int i2 = i + 1;
                if (i < 0) {
                    m.p();
                }
                Node node = (Node) obj;
                try {
                    IItem<ItemValue> createItem = genericComponent.createItem(new Config<>(genericComponent.getPageContext(), node.getType(), node, 0, false, 24, null));
                    if (createItem != null) {
                        genericComponent.childItems.add(i, createItem);
                        createItem.setIndex(i);
                        createItem.onAdd();
                        genericComponent.getChildIndexUpdater().onChildAdded(genericComponent);
                    }
                } catch (Exception e) {
                    if (AppInfoProviderProxy.isDebuggable()) {
                        throw new RuntimeException(e);
                    }
                }
                i = i2;
            }
        }
        genericComponent.setModule(iItem.getComponent().getModule());
        Activity activity2 = iItem.getComponent().getPageContext().getActivity();
        if (activity2 != null) {
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter4 = genericComponent.getAdapter();
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter2 = adapter4 == null ? null : adapter4.getInnerAdapter();
            if (innerAdapter2 != null) {
                innerAdapter2.setContext(activity2);
            }
        }
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter5 = genericComponent.getAdapter();
        setListAdapter(adapter5 != null ? adapter5.getInnerAdapter() : null);
    }

    @Nullable
    public final GenericComponent<?> getFakeComponent() {
        return this.fakeComponent;
    }

    @Nullable
    public final RecyclerView.ItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    @Nullable
    public final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> getListAdapter() {
        return this.listAdapter;
    }

    @NotNull
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder
    public void onCreate() {
        super.onCreate();
        RecyclerView recyclerView = this.recyclerView;
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getView().getContext(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(false);
        wt2 wt2Var = wt2.INSTANCE;
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.youku.arch.v3.adapter.VBaseHolder, com.youku.arch.v3.event.EventHandler
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        b41.i(str, "type");
        if (b41.d(str, ViewHolderEvent.ON_VIEW_SELECTED)) {
            Object obj = map == null ? null : map.get("selected");
            if (b41.d(obj instanceof Boolean ? (Boolean) obj : null, Boolean.TRUE)) {
                update();
            }
        }
        return super.onMessage(str, map);
    }

    public final void setFakeComponent(@Nullable GenericComponent<?> genericComponent) {
        this.fakeComponent = genericComponent;
    }

    public final void setItemDecoration(@Nullable RecyclerView.ItemDecoration itemDecoration) {
        this.itemDecoration = itemDecoration;
    }

    public final void setListAdapter(@Nullable VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter) {
        this.listAdapter = vBaseAdapter;
    }

    public void setStyle(@NotNull IItem<ItemValue> iItem) {
        ComponentConfigBean.ComponentBean.LayoutBean layout;
        HashMap<String, Object> params;
        int dimenId;
        String pathConfig;
        ComponentConfigBean.ComponentBean componentBean;
        b41.i(iItem, "item");
        ConfigManager configManager = iItem.getPageContext().getConfigManager();
        if (configManager != null && (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) != null) {
            SparseArray<ComponentConfigBean.ComponentBean> componentConfigs = ComponentConfigManager.Companion.getInstance().getComponentConfigs(getContext(), pathConfig);
            if (componentConfigs == null) {
                componentBean = null;
            } else {
                int type = iItem.getType();
                int type2 = iItem.getType();
                if (type > 32768) {
                    type2 >>= 16;
                }
                componentBean = componentConfigs.get(type2);
            }
            this.componentConfig = componentBean;
        }
        ComponentConfigBean.ComponentBean componentBean2 = this.componentConfig;
        if (componentBean2 == null || (layout = componentBean2.getLayout()) == null || (params = layout.getParams()) == null || (dimenId = getDimenId(getContext(), params, com.youku.arch.v3.data.Constants.GAP)) == 0) {
            return;
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(dimenId);
        int dimenId2 = getDimenId(getContext(), params, "listMarginLeft");
        int dimensionPixelSize2 = dimenId2 != 0 ? getContext().getResources().getDimensionPixelSize(dimenId2) : 0;
        int dimenId3 = getDimenId(getContext(), params, "listMarginRight");
        int dimensionPixelSize3 = dimenId3 != 0 ? getContext().getResources().getDimensionPixelSize(dimenId3) : 0;
        RecyclerView recyclerView = getRecyclerView();
        RecyclerView.ItemDecoration itemDecoration = getItemDecoration();
        if (itemDecoration != null) {
            recyclerView.removeItemDecoration(itemDecoration);
        }
        HorizontalViewItemDecoration horizontalViewItemDecoration = new HorizontalViewItemDecoration(this, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3);
        recyclerView.addItemDecoration(horizontalViewItemDecoration);
        wt2 wt2Var = wt2.INSTANCE;
        setItemDecoration(horizontalViewItemDecoration);
    }
}
