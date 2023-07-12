package com.alibaba.pictures.bricks.component.script;

import android.view.View;
import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.alibaba.pictures.bricks.listener.OnItemListener;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.w72;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ScriptShopPresenter extends AbsPresenter<GenericItem<ItemValue>, ScriptShopModel, ScriptShopView> implements ScriptShopContract$Present, OnItemListener<ShopInfoBean> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptShopPresenter(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @NotNull
    public final Map<String, String> getTrackArgs(@NotNull ShopInfoBean shopInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1425655317")) {
            return (Map) ipChange.ipc$dispatch("-1425655317", new Object[]{this, shopInfoBean});
        }
        b41.i(shopInfoBean, "bean");
        Map<String, String> trackArgs = getTrackArgs();
        b41.h(trackArgs, "trackArgs");
        trackArgs.put("biz_type", "店铺");
        trackArgs.put("biz_id", shopInfoBean.getId());
        return trackArgs;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "120687986")) {
            ipChange.ipc$dispatch("120687986", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((ScriptShopPresenter) genericItem);
        ((ScriptShopView) getView()).bindData(((ScriptShopModel) getModel()).getValue(), 0, this);
        if (genericItem.getComponent().getChildCount() - 1 == genericItem.getIndex()) {
            ((ScriptShopView) getView()).getDivline().setVisibility(8);
        } else {
            ((ScriptShopView) getView()).getDivline().setVisibility(0);
        }
        w72.a(this, ((ScriptShopView) getView()).getRenderView());
    }

    @Override // com.alibaba.pictures.bricks.listener.OnItemListener
    public void onItemClick(@NotNull ShopInfoBean shopInfoBean, int i) {
        String schema;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "879047415")) {
            ipChange.ipc$dispatch("879047415", new Object[]{this, shopInfoBean, Integer.valueOf(i)});
            return;
        }
        b41.i(shopInfoBean, "bean");
        String schema2 = shopInfoBean.getSchema();
        if ((schema2 == null || schema2.length() == 0) ? true : true) {
            schema = "damai://V1/ScriptPlay?storeId=" + shopInfoBean.getId();
        } else {
            schema = shopInfoBean.getSchema();
        }
        Action action = new Action();
        action.setActionType(1);
        action.setActionUrl(schema);
        NavProviderProxy.getProxy().toUri(((GenericItem) getItem()).getPageContext().getActivity(), action);
        userTrackClick(getTrackArgs(shopInfoBean), true);
    }

    @Override // com.alibaba.pictures.bricks.listener.OnItemListener
    public void onItemExpose(@NotNull View view, @NotNull ShopInfoBean shopInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1567640459")) {
            ipChange.ipc$dispatch("1567640459", new Object[]{this, view, shopInfoBean, Integer.valueOf(i)});
            return;
        }
        b41.i(view, "itemView");
        b41.i(shopInfoBean, "bean");
        userTrackExpose(((ScriptShopView) getView()).getRenderView(), getTrackArgs(shopInfoBean));
    }
}
