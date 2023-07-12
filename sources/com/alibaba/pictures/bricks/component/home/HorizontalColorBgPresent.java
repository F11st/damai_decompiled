package com.alibaba.pictures.bricks.component.home;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.component.horizontal.GenericHorizontalContract;
import com.alient.onearch.adapter.component.horizontal.GenericHorizontalModel;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HorizontalColorBgPresent extends AbsPresenter<GenericItem<ItemValue>, GenericHorizontalModel, HorizontalColorBgView> implements GenericHorizontalContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ComponentConfigBean.ComponentBean componentConfig;
    private boolean isInited;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalColorBgPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        ComponentConfigBean.ComponentBean.LayoutBean layout;
        RecyclerView recyclerView;
        String pathConfig;
        ComponentConfigBean.ComponentBean componentBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1940508530")) {
            ipChange.ipc$dispatch("1940508530", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((HorizontalColorBgPresent) genericItem);
        ConfigManager configManager = genericItem.getPageContext().getConfigManager();
        HashMap<String, Object> hashMap = null;
        if (configManager != null && (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) != null) {
            ComponentConfigManager companion = ComponentConfigManager.Companion.getInstance();
            Context context = ((HorizontalColorBgView) getView()).getRecyclerView().getContext();
            b41.h(context, "view.recyclerView.context");
            SparseArray<ComponentConfigBean.ComponentBean> componentConfigs = companion.getComponentConfigs(context, pathConfig);
            if (componentConfigs != null) {
                componentBean = componentConfigs.get(genericItem.getType() > 32768 ? genericItem.getType() >> 16 : genericItem.getType());
            } else {
                componentBean = null;
            }
            this.componentConfig = componentBean;
        }
        HorizontalColorBgView horizontalColorBgView = (HorizontalColorBgView) getView();
        if (!this.isInited) {
            GenericFragment fragment = genericItem.getPageContext().getFragment();
            RecyclerView.RecycledViewPool recycledViewPool = (fragment == null || (recyclerView = fragment.getRecyclerView()) == null) ? null : recyclerView.getRecycledViewPool();
            ComponentConfigBean.ComponentBean componentBean2 = this.componentConfig;
            if (componentBean2 != null && (layout = componentBean2.getLayout()) != null) {
                hashMap = layout.getParams();
            }
            horizontalColorBgView.initRecyclerSettings(recycledViewPool, hashMap);
            this.isInited = true;
        }
        horizontalColorBgView.getRecyclerView().swapAdapter(genericItem.getComponent().getInnerAdapter(), false);
        JSONObject data = genericItem.getComponent().getProperty().getData();
        b41.g(data, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
        ((HorizontalColorBgView) getView()).bindView(data);
    }
}
