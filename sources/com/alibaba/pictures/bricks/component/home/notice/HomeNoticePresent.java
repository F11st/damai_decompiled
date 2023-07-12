package com.alibaba.pictures.bricks.component.home.notice;

import android.view.View;
import com.alibaba.pictures.bricks.bean.HomeNoticeBean;
import com.alibaba.pictures.bricks.component.home.notice.HomeNoticeContract;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeNoticePresent extends AbsPresenter<GenericItem<ItemValue>, HomeNoticeModel, HomeNoticeView> implements HomeNoticeContract.Present {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeNoticePresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @Override // com.alibaba.pictures.bricks.component.home.notice.HomeNoticeContract.Present
    public void expose(@NotNull HomeNoticeBean homeNoticeBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-495612001")) {
            ipChange.ipc$dispatch("-495612001", new Object[]{this, homeNoticeBean});
            return;
        }
        b41.i(homeNoticeBean, "bean");
        View renderView = ((HomeNoticeView) getView()).getRenderView();
        Action itemAction = getItemAction();
        UserTrackProviderProxy.expose(renderView, itemAction != null ? itemAction.getTrackInfo() : null);
    }

    @NotNull
    public final Map<String, String> getTrackArgs(@NotNull HomeNoticeBean homeNoticeBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1134127522")) {
            return (Map) ipChange.ipc$dispatch("1134127522", new Object[]{this, homeNoticeBean});
        }
        b41.i(homeNoticeBean, "bean");
        Map<String, String> trackArgs = getTrackArgs();
        b41.h(trackArgs, "trackArgs");
        trackArgs.put("contentlabel", homeNoticeBean.notice + '+' + homeNoticeBean.url);
        return trackArgs;
    }

    @Override // com.alibaba.pictures.bricks.component.home.notice.HomeNoticeContract.Present
    public void onClick(@NotNull HomeNoticeBean homeNoticeBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "238327618")) {
            ipChange.ipc$dispatch("238327618", new Object[]{this, homeNoticeBean});
            return;
        }
        b41.i(homeNoticeBean, "bean");
        Action action = new Action();
        action.setActionType(1);
        Action itemAction = getItemAction();
        action.setActionUrl(itemAction != null ? itemAction.getActionUrl() : null);
        NavProviderProxy.getProxy().toUri(((GenericItem) getItem()).getPageContext().getActivity(), action);
        Action itemAction2 = getItemAction();
        UserTrackProviderProxy.click(itemAction2 != null ? itemAction2.getTrackInfo() : null, true);
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "343397660")) {
            ipChange.ipc$dispatch("343397660", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((HomeNoticePresent) genericItem);
        HomeNoticeView homeNoticeView = (HomeNoticeView) getView();
        HomeNoticeBean value = ((HomeNoticeModel) getModel()).getValue();
        b41.h(value, "model.value");
        HomeNoticeBean homeNoticeBean = value;
        Action itemAction = getItemAction();
        homeNoticeView.bindView(homeNoticeBean, itemAction != null ? itemAction.getActionUrl() : null);
    }
}
