package com.alient.onearch.adapter.component.banner.loop;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import com.alient.onearch.adapter.component.banner.loop.LoopBannerContract;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B3\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/loop/LoopBannerPresenter;", "Lcom/alient/onearch/adapter/view/AbsPresenter;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/banner/loop/LoopBannerModel;", "Lcom/alient/onearch/adapter/component/banner/loop/LoopBannerView;", "Lcom/alient/onearch/adapter/component/banner/loop/LoopBannerContract$Presenter;", "item", "Ltb/wt2;", UCCore.LEGACY_EVENT_INIT, "", "position", "onPageChanged", "", "isInited", "Z", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "componentConfig", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "", "mClassName", "vClassName", "Landroid/view/View;", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class LoopBannerPresenter extends AbsPresenter<GenericItem<ItemValue>, LoopBannerModel, LoopBannerView> implements LoopBannerContract.Presenter {
    @Nullable
    private ComponentConfigBean.ComponentBean componentConfig;
    private boolean isInited;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoopBannerPresenter(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @Override // com.alient.onearch.adapter.component.banner.loop.LoopBannerContract.Presenter
    public void onPageChanged(int i) {
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        ComponentConfigBean.ComponentBean.LayoutBean layout;
        Activity activity;
        ConfigManager configManager;
        String pathConfig;
        b41.i(genericItem, "item");
        super.init((LoopBannerPresenter) genericItem);
        HashMap<String, Object> hashMap = null;
        if (this.componentConfig == null && (activity = genericItem.getPageContext().getActivity()) != null && (configManager = genericItem.getPageContext().getConfigManager()) != null && (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) != null) {
            SparseArray<ComponentConfigBean.ComponentBean> componentConfigs = ComponentConfigManager.Companion.getInstance().getComponentConfigs(activity, pathConfig);
            this.componentConfig = componentConfigs == null ? null : componentConfigs.get(PageUtil.INSTANCE.getItemType(genericItem));
        }
        if (!this.isInited) {
            LoopBannerView loopBannerView = (LoopBannerView) getView();
            ComponentConfigBean.ComponentBean componentBean = this.componentConfig;
            if (componentBean != null && (layout = componentBean.getLayout()) != null) {
                hashMap = layout.getParams();
            }
            loopBannerView.initBannerSetting(hashMap);
            this.isInited = true;
        }
        ((LoopBannerView) getView()).setAdapter(genericItem.getComponent().getInnerAdapter());
    }
}
