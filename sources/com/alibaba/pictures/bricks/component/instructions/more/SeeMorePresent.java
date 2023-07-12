package com.alibaba.pictures.bricks.component.instructions.more;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.bean.TicketNote;
import com.alibaba.pictures.bricks.component.instructions.more.SeeMoreContract;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jt1;
import tb.tq2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class SeeMorePresent extends AbsPresenter<GenericItem<ItemValue>, SeeMoreModel, SeeMoreView> implements SeeMoreContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final List<TicketNote> instructions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeeMorePresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
        this.instructions = new ArrayList();
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1468207338")) {
            return ((Boolean) ipChange.ipc$dispatch("1468207338", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public void onItemClick(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-687282388")) {
            ipChange.ipc$dispatch("-687282388", new Object[]{this, view});
            return;
        }
        b41.i(view, "view");
        super.onItemClick(view);
        new jt1().d(view, this.instructions, "购买须知");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        String string;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1186836690")) {
            ipChange.ipc$dispatch("1186836690", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((SeeMorePresent) genericItem);
        JSONObject data = genericItem.getProperty().getData();
        if (data != null && (string = data.getString("content")) != null) {
            ((SeeMoreView) getView()).renderContent(string);
        }
        if (this.instructions.isEmpty()) {
            JSONObject data2 = genericItem.getProperty().getData();
            Object obj = data2 != null ? data2.get("instructions") : null;
            List<JSONObject> list = tq2.m(obj) ? (List) obj : null;
            if (list != null) {
                for (JSONObject jSONObject : list) {
                    List<TicketNote> list2 = this.instructions;
                    Object javaObject = jSONObject.toJavaObject(TicketNote.class);
                    b41.h(javaObject, "it.toJavaObject(TicketNote::class.java)");
                    list2.add(javaObject);
                }
            }
        }
    }
}
