package com.alibaba.pictures.bricks.component.imgcard;

import android.os.Bundle;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.component.imgcard.BannerContract;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.tq2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class BannerPresent extends AbsPresenter<GenericItem<ItemValue>, BannerModel, ImageCardView> implements BannerContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String PRE_STICKY_HEADER = "EventBus://business/";

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "656042550")) {
            return ((Boolean) ipChange.ipc$dispatch("656042550", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public void onItemClick(@NotNull View view) {
        JSONObject data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "125045624")) {
            ipChange.ipc$dispatch("125045624", new Object[]{this, view});
            return;
        }
        b41.i(view, "view");
        super.onItemClick(view);
        List<IItem<ItemValue>> items = ((GenericItem) getItem()).getComponent().getItems();
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        b41.g(items, "null cannot be cast to non-null type kotlin.collections.MutableList<com.youku.arch.v3.core.item.GenericItem<com.alient.onearch.adapter.pom.BasicItemValue>>");
        List<GenericItem> b = tq2.b(items);
        if (b != null) {
            for (GenericItem genericItem : b) {
                Node node = genericItem.getNode();
                if (node != null && (data = node.getData()) != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("img", data.getString("url"));
                    Boolean bool = data.getBoolean("isVideo");
                    b41.h(bool, "it.getBoolean(\"isVideo\")");
                    if (bool.booleanValue()) {
                        hashMap.put("url", data.getString("videoUrl"));
                        arrayList.add(hashMap);
                    } else {
                        arrayList2.add(hashMap);
                    }
                }
            }
        }
        bundle.putSerializable("video_info_map", arrayList);
        bundle.putSerializable("pic_info_map", arrayList2);
        bundle.putInt("position", ((GenericItem) getItem()).getIndex());
        Action action = new Action();
        action.setActionType(1);
        action.setActionUrl("damai://videobrowse");
        action.setExtra(bundle);
        NavProviderProxy.getProxy().toUri(((GenericItem) getItem()).getPageContext().getActivity(), action);
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1299442438")) {
            ipChange.ipc$dispatch("1299442438", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((BannerPresent) genericItem);
        ((ImageCardView) getView()).renderImage(((BannerModel) getModel()).getContent());
    }
}
