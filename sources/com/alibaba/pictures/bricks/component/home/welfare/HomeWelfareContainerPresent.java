package com.alibaba.pictures.bricks.component.home.welfare;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
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
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.util.ViewUtil;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import java.util.Map;
import kotlin.collections.C8214m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeWelfareContainerPresent extends AbsPresenter<GenericItem<ItemValue>, HomeWelfareContainerModel, HomeWelfareContainerView> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ComponentConfigBean.ComponentBean componentConfig;
    private boolean isInited;
    @Nullable
    private VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> listAdapter;
    @Nullable
    private GenericItem<ItemValue> oldItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeWelfareContainerPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    private final int getDimenId(Context context, Map<String, ? extends Object> map, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1499987715")) {
            return ((Integer) ipChange.ipc$dispatch("1499987715", new Object[]{this, context, map, str})).intValue();
        }
        if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), Constants.DIMEN);
        }
        return 0;
    }

    private final void update() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-976804778")) {
            ipChange.ipc$dispatch("-976804778", new Object[]{this});
            return;
        }
        HomeWelfareContainerView homeWelfareContainerView = (HomeWelfareContainerView) getView();
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter = this.listAdapter;
        if (vBaseAdapter != null) {
            homeWelfareContainerView.getRecyclerView().swapAdapter(vBaseAdapter, false);
        }
    }

    @Nullable
    public final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> getListAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1482205140") ? (VBaseAdapter) ipChange.ipc$dispatch("-1482205140", new Object[]{this}) : this.listAdapter;
    }

    public final void setListAdapter(@Nullable VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2077282646")) {
            ipChange.ipc$dispatch("-2077282646", new Object[]{this, vBaseAdapter});
        } else {
            this.listAdapter = vBaseAdapter;
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        ComponentConfigBean.ComponentBean.LayoutBean layout;
        RecyclerView recyclerView;
        Activity activity;
        ConfigManager configManager;
        String pathConfig;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1776687679")) {
            ipChange.ipc$dispatch("-1776687679", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        long currentTimeMillis = System.currentTimeMillis();
        super.init((HomeWelfareContainerPresent) genericItem);
        if (b41.d(this.oldItem, genericItem)) {
            LogUtil.e("bricks $" + HomeWelfareContainerPresent.class.getName() + " old", new Object[0]);
            return;
        }
        this.oldItem = genericItem;
        if (this.componentConfig == null && (activity = genericItem.getPageContext().getActivity()) != null && (configManager = genericItem.getPageContext().getConfigManager()) != null && (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) != null) {
            SparseArray<ComponentConfigBean.ComponentBean> componentConfigs = ComponentConfigManager.Companion.getInstance().getComponentConfigs(activity, pathConfig);
            this.componentConfig = componentConfigs != null ? componentConfigs.get(PageUtil.INSTANCE.getItemType(genericItem)) : null;
        }
        HomeWelfareContainerView homeWelfareContainerView = (HomeWelfareContainerView) getView();
        if (!this.isInited) {
            GenericFragment fragment = genericItem.getPageContext().getFragment();
            RecyclerView.RecycledViewPool recycledViewPool = (fragment == null || (recyclerView = fragment.getRecyclerView()) == null) ? null : recyclerView.getRecycledViewPool();
            ComponentConfigBean.ComponentBean componentBean = this.componentConfig;
            homeWelfareContainerView.initRecyclerSettings(recycledViewPool, (componentBean == null || (layout = componentBean.getLayout()) == null) ? null : layout.getParams());
            this.isInited = true;
        }
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = genericItem.getComponent().getAdapter();
        if ((adapter != null ? adapter.getInnerAdapter() : null) != null) {
            Activity activity2 = genericItem.getComponent().getPageContext().getActivity();
            if (activity2 != null) {
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter2 = genericItem.getComponent().getAdapter();
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = adapter2 != null ? adapter2.getInnerAdapter() : null;
                if (innerAdapter != null) {
                    innerAdapter.setContext(activity2);
                }
            }
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter3 = genericItem.getComponent().getAdapter();
            this.listAdapter = adapter3 != null ? adapter3.getInnerAdapter() : null;
            ((HomeWelfareContainerView) getView()).bindView(genericItem.getComponent().getProperty().getData());
        } else {
            GenericFactory<IComponent<ComponentValue>, Node> componentFactory = genericItem.getComponent().getModule().getComponentFactory();
            GenericComponent genericComponent = (GenericComponent) (componentFactory != null ? componentFactory.create(new Config<>(genericItem.getPageContext(), genericItem.getType(), genericItem.getProperty(), 0, false, 24, null)) : null);
            if (genericComponent != null) {
                genericComponent.initProperties(genericItem.getProperty());
                List<Node> children = genericComponent.getProperty().getChildren();
                if (children != null) {
                    int i = 0;
                    for (Object obj : children) {
                        int i2 = i + 1;
                        if (i < 0) {
                            C8214m.p();
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
                genericComponent.setModule(genericItem.getComponent().getModule());
                Activity activity3 = genericItem.getComponent().getPageContext().getActivity();
                if (activity3 != null) {
                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter4 = genericComponent.getAdapter();
                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter2 = adapter4 != null ? adapter4.getInnerAdapter() : null;
                    if (innerAdapter2 != null) {
                        innerAdapter2.setContext(activity3);
                    }
                }
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter5 = genericComponent.getAdapter();
                this.listAdapter = adapter5 != null ? adapter5.getInnerAdapter() : null;
            }
            ((HomeWelfareContainerView) getView()).bindView(genericItem.getProperty().getData());
        }
        update();
        LogUtil.e("bricks $" + HomeWelfareContainerPresent.class.getName() + ' ' + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }
}
