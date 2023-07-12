package com.alient.onearch.adapter.component.horizontal;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alient.onearch.adapter.component.horizontal.GenericHorizontalContract;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B3\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/alient/onearch/adapter/component/horizontal/GenericHorizontalPresenter;", "Lcom/alient/onearch/adapter/view/AbsPresenter;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/horizontal/GenericHorizontalModel;", "Lcom/alient/onearch/adapter/component/horizontal/GenericHorizontalView;", "Lcom/alient/onearch/adapter/component/horizontal/GenericHorizontalContract$Presenter;", "item", "Ltb/wt2;", UCCore.LEGACY_EVENT_INIT, "", "isInited", "Z", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "componentConfig", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "historyItem", "Lcom/youku/arch/v3/core/item/GenericItem;", "", "mClassName", "vClassName", "Landroid/view/View;", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class GenericHorizontalPresenter extends AbsPresenter<GenericItem<ItemValue>, GenericHorizontalModel, GenericHorizontalView> implements GenericHorizontalContract.Presenter {
    @Nullable
    private ComponentConfigBean.ComponentBean componentConfig;
    @Nullable
    private GenericItem<ItemValue> historyItem;
    private boolean isInited;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericHorizontalPresenter(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        RecyclerView recyclerView;
        ComponentConfigBean.ComponentBean.LayoutBean layout;
        String pathConfig;
        b41.i(genericItem, "item");
        super.init((GenericHorizontalPresenter) genericItem);
        ConfigManager configManager = genericItem.getPageContext().getConfigManager();
        HashMap<String, Object> hashMap = null;
        if (configManager != null && (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) != null) {
            ComponentConfigManager companion = ComponentConfigManager.Companion.getInstance();
            Context context = ((GenericHorizontalView) getView()).getRecyclerView().getContext();
            b41.h(context, "view.recyclerView.context");
            SparseArray<ComponentConfigBean.ComponentBean> componentConfigs = companion.getComponentConfigs(context, pathConfig);
            this.componentConfig = componentConfigs == null ? null : componentConfigs.get(PageUtil.INSTANCE.getItemType(genericItem));
        }
        GenericHorizontalView genericHorizontalView = (GenericHorizontalView) getView();
        if (!this.isInited) {
            GenericFragment fragment = genericItem.getPageContext().getFragment();
            RecyclerView.RecycledViewPool recycledViewPool = (fragment == null || (recyclerView = fragment.getRecyclerView()) == null) ? null : recyclerView.getRecycledViewPool();
            ComponentConfigBean.ComponentBean componentBean = this.componentConfig;
            if (componentBean != null && (layout = componentBean.getLayout()) != null) {
                hashMap = layout.getParams();
            }
            genericHorizontalView.initRecyclerSettings(recycledViewPool, hashMap);
            this.isInited = true;
        }
        genericHorizontalView.getRecyclerView().swapAdapter(genericItem.getComponent().getInnerAdapter(), false);
    }
}
