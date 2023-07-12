package com.alibaba.pictures.bricks.component.home.grabhotrecommend;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotRecommendContainerContract;
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
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeGrabHotRecommendContainerPresent extends AbsPresenter<GenericItem<ItemValue>, HomeGrabHotRecommendContainerModel, HomeGrabHotRecommendContainerView> implements HomeGrabHotRecommendContainerContract.Present {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ComponentConfigBean.ComponentBean componentConfig;
    private boolean isInited;
    @Nullable
    private VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> listAdapter;
    @Nullable
    private GenericItem<ItemValue> oldItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeGrabHotRecommendContainerPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    private final void update() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1109363962")) {
            ipChange.ipc$dispatch("1109363962", new Object[]{this});
            return;
        }
        HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView = (HomeGrabHotRecommendContainerView) getView();
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter = this.listAdapter;
        if (vBaseAdapter != null) {
            homeGrabHotRecommendContainerView.setAdapter(vBaseAdapter);
        }
    }

    @Nullable
    public final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> getListAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1478384888") ? (VBaseAdapter) ipChange.ipc$dispatch("-1478384888", new Object[]{this}) : this.listAdapter;
    }

    public final void setListAdapter(@Nullable VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1958854834")) {
            ipChange.ipc$dispatch("-1958854834", new Object[]{this, vBaseAdapter});
        } else {
            this.listAdapter = vBaseAdapter;
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        ComponentConfigBean.ComponentBean.LayoutBean layout;
        Activity activity;
        ConfigManager configManager;
        String pathConfig;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1607126173")) {
            ipChange.ipc$dispatch("1607126173", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        long currentTimeMillis = System.currentTimeMillis();
        super.init((HomeGrabHotRecommendContainerPresent) genericItem);
        if (b41.d(this.oldItem, genericItem)) {
            LogUtil.e("bricks " + HomeGrabHotRecommendContainerPresent.class.getName() + " old", new Object[0]);
            return;
        }
        this.oldItem = genericItem;
        if (this.componentConfig == null && (activity = genericItem.getPageContext().getActivity()) != null && (configManager = genericItem.getPageContext().getConfigManager()) != null && (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) != null) {
            SparseArray<ComponentConfigBean.ComponentBean> componentConfigs = ComponentConfigManager.Companion.getInstance().getComponentConfigs(activity, pathConfig);
            this.componentConfig = componentConfigs != null ? componentConfigs.get(PageUtil.INSTANCE.getItemType(genericItem)) : null;
        }
        if (!this.isInited) {
            HomeGrabHotRecommendContainerView homeGrabHotRecommendContainerView = (HomeGrabHotRecommendContainerView) getView();
            ComponentConfigBean.ComponentBean componentBean = this.componentConfig;
            homeGrabHotRecommendContainerView.initBannerSetting((componentBean == null || (layout = componentBean.getLayout()) == null) ? null : layout.getParams());
            this.isInited = true;
        }
        Bundle bundle = genericItem.getPageContext().getBundle();
        String string = bundle != null ? bundle.getString("initElapsedRealtime") : null;
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
            ((HomeGrabHotRecommendContainerView) getView()).bindView(genericItem.getComponent().getProperty().getData(), string);
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
            ((HomeGrabHotRecommendContainerView) getView()).bindView(genericItem.getProperty().getData(), string);
        }
        update();
        LogUtil.e("bricks $" + HomeGrabHotRecommendContainerPresent.class.getName() + ' ' + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }
}
