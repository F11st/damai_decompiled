package com.alibaba.pictures.bricks.component.script;

import android.view.View;
import com.alibaba.pictures.bricks.bean.SearchScriptCouponBean;
import com.alibaba.pictures.bricks.component.script.ScriptCouponContract;
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
public final class ScriptCouponPresent extends AbsPresenter<GenericItem<ItemValue>, ScriptCouponModel, ScriptCouponView> implements ScriptCouponContract.Present, OnItemListener<SearchScriptCouponBean> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptCouponPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @Override // com.alibaba.pictures.bricks.onearch.AbsPresenter
    @NotNull
    public Map<String, String> getTrackArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1023072332")) {
            return (Map) ipChange.ipc$dispatch("-1023072332", new Object[]{this});
        }
        Map<String, String> trackArgs = super.getTrackArgs();
        b41.h(trackArgs, "trackInfo");
        SearchScriptCouponBean data = ((ScriptCouponModel) getModel()).getData();
        trackArgs.put("biz_id", (data == null || (r1 = data.getProjectId()) == null) ? "" : "");
        trackArgs.put("biz_type", "团购券");
        return trackArgs;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1612268753")) {
            ipChange.ipc$dispatch("-1612268753", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((ScriptCouponPresent) genericItem);
        ((ScriptCouponView) getView()).bindData(((ScriptCouponModel) getModel()).getValue());
        if (genericItem.getComponent().getChildCount() - 1 == genericItem.getIndex()) {
            ((ScriptCouponView) getView()).getDivline().setVisibility(8);
        } else {
            ((ScriptCouponView) getView()).getDivline().setVisibility(0);
        }
        w72.a(this, ((ScriptCouponView) getView()).getRenderView());
    }

    @Override // com.alibaba.pictures.bricks.listener.OnItemListener
    public void onItemClick(@NotNull SearchScriptCouponBean searchScriptCouponBean, int i) {
        String schema;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "943196297")) {
            ipChange.ipc$dispatch("943196297", new Object[]{this, searchScriptCouponBean, Integer.valueOf(i)});
            return;
        }
        b41.i(searchScriptCouponBean, "bean");
        String schema2 = searchScriptCouponBean.getSchema();
        if ((schema2 == null || schema2.length() == 0) ? true : true) {
            schema = "damai://V1/ScriptCouponDetail?couponId=" + searchScriptCouponBean.getProjectId();
        } else {
            schema = searchScriptCouponBean.getSchema();
        }
        Action action = new Action();
        action.setActionType(1);
        action.setActionUrl(schema);
        NavProviderProxy.getProxy().toUri(((GenericItem) getItem()).getPageContext().getActivity(), action);
        userTrackClick(getTrackArgs(), true);
    }

    @Override // com.alibaba.pictures.bricks.listener.OnItemListener
    public void onItemExpose(@NotNull View view, @NotNull SearchScriptCouponBean searchScriptCouponBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1112885347")) {
            ipChange.ipc$dispatch("-1112885347", new Object[]{this, view, searchScriptCouponBean, Integer.valueOf(i)});
            return;
        }
        b41.i(view, "itemView");
        b41.i(searchScriptCouponBean, "bean");
        userTrackExpose(((ScriptCouponView) getView()).getRenderView(), getTrackArgs());
    }
}
