package com.alient.onearch.adapter.component.tab.generic;

import android.view.View;
import com.alibaba.fastjson.JSONArray;
import com.alient.onearch.adapter.component.tab.base.BaseTabPresenter;
import com.alient.onearch.adapter.component.tab.generic.GenericTabContract;
import com.alient.onearch.adapter.widget.RichTitle;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B3\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ2\u0010\u000f\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0016J&\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016¨\u0006 "}, d2 = {"Lcom/alient/onearch/adapter/component/tab/generic/GenericTabPresenter;", "Lcom/alient/onearch/adapter/component/tab/base/BaseTabPresenter;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/tab/generic/GenericTabModel;", "Lcom/alient/onearch/adapter/component/tab/generic/GenericTabView;", "Lcom/alient/onearch/adapter/component/tab/generic/GenericTabContract$Presenter;", "", "Lcom/alient/onearch/adapter/widget/RichTitle;", "childComponentTitles", "Lcom/alibaba/fastjson/JSONArray;", "childComponentBtns", "Lcom/youku/arch/v3/core/Node;", "childComponentNodes", "Ltb/wt2;", "renderTabInView", "", "type", "", "", "params", "", "onMessage", "mClassName", "vClassName", "Landroid/view/View;", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class GenericTabPresenter extends BaseTabPresenter<GenericItem<ItemValue>, GenericTabModel, GenericTabView> implements GenericTabContract.Presenter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericTabPresenter(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        b41.i(str, "type");
        return ((GenericTabView) getView()).dispatchViewHolderMessage(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.youku.arch.v3.IItem] */
    @Override // com.alient.onearch.adapter.component.tab.base.BaseTabPresenter
    public void renderTabInView(@NotNull List<RichTitle> list, @NotNull List<? extends JSONArray> list2, @NotNull List<? extends Node> list3) {
        b41.i(list, "childComponentTitles");
        b41.i(list2, "childComponentBtns");
        b41.i(list3, "childComponentNodes");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Node node : list3) {
            arrayList.add(Integer.valueOf(node.getType()));
        }
        ((GenericItem) getItem()).getExtra().putIntegerArrayList("componentTypes", arrayList);
        if (list.size() <= 1) {
            ((GenericTabView) getView()).hideTabIndicator();
        } else {
            ((GenericTabView) getView()).showTabIndicator();
        }
        ((GenericTabView) getView()).setChildComponentData(getItem(), list, list2, list3);
    }
}
