package com.alibaba.pictures.bricks.component.script;

import android.view.View;
import com.alibaba.pictures.bricks.bean.SearchScriptBean;
import com.alibaba.pictures.bricks.component.script.ScriptContract;
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
public final class ScriptPresenter extends AbsPresenter<GenericItem<ItemValue>, ScriptModel, ScriptView> implements ScriptContract.Present, OnItemListener<SearchScriptBean> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptPresenter(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @Override // com.alibaba.pictures.bricks.onearch.AbsPresenter
    @NotNull
    public Map<String, String> getTrackArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1690747353")) {
            return (Map) ipChange.ipc$dispatch("-1690747353", new Object[]{this});
        }
        Map<String, String> trackArgs = super.getTrackArgs();
        b41.h(trackArgs, "trackArgs");
        SearchScriptBean data = ((ScriptModel) getModel()).getData();
        trackArgs.put("biz_id", (data == null || (r1 = data.getId()) == null) ? "" : "");
        trackArgs.put("biz_type", "剧本");
        return trackArgs;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1230123484")) {
            ipChange.ipc$dispatch("1230123484", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((ScriptPresenter) genericItem);
        ((ScriptView) getView()).bindData(((ScriptModel) getModel()).getData());
        if (genericItem.getComponent().getChildCount() - 1 == genericItem.getIndex()) {
            ((ScriptView) getView()).getDivline().setVisibility(8);
        } else {
            ((ScriptView) getView()).getDivline().setVisibility(0);
        }
        w72.a(this, ((ScriptView) getView()).getRenderView());
    }

    @Override // com.alibaba.pictures.bricks.listener.OnItemListener
    public void onItemClick(@NotNull SearchScriptBean searchScriptBean, int i) {
        String schema;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1978350000")) {
            ipChange.ipc$dispatch("1978350000", new Object[]{this, searchScriptBean, Integer.valueOf(i)});
            return;
        }
        b41.i(searchScriptBean, "bean");
        String schema2 = searchScriptBean.getSchema();
        if ((schema2 == null || schema2.length() == 0) ? true : true) {
            schema = "damai://V1/ScriptDetail?scriptId=" + searchScriptBean.getId();
        } else {
            schema = searchScriptBean.getSchema();
        }
        Action action = new Action();
        action.setActionType(1);
        action.setActionUrl(schema);
        NavProviderProxy.getProxy().toUri(((GenericItem) getItem()).getPageContext().getActivity(), action);
        userTrackClick(getTrackArgs(), true);
    }

    @Override // com.alibaba.pictures.bricks.listener.OnItemListener
    public void onItemExpose(@NotNull View view, @NotNull SearchScriptBean searchScriptBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1250963644")) {
            ipChange.ipc$dispatch("-1250963644", new Object[]{this, view, searchScriptBean, Integer.valueOf(i)});
            return;
        }
        b41.i(view, "itemView");
        b41.i(searchScriptBean, "bean");
        userTrackExpose(((ScriptView) getView()).getRenderView(), getTrackArgs());
    }
}
