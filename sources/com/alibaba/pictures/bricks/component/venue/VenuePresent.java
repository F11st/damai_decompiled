package com.alibaba.pictures.bricks.component.venue;

import android.text.TextUtils;
import android.view.View;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import com.alibaba.pictures.bricks.component.venue.VenueContract;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.EventHandler;
import java.util.Map;
import tb.w72;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VenuePresent extends AbsPresenter<IItem<ItemValue>, VenueContract.Model<IItem<ItemValue>>, VenueContract.View> implements VenueContract.Presenter<IItem<ItemValue>, VenueContract.Model<IItem<ItemValue>>> {
    private static transient /* synthetic */ IpChange $ipChange;

    public VenuePresent(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
    }

    @Override // com.alibaba.pictures.bricks.onearch.AbsPresenter
    public Map<String, String> getTrackArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1658089094")) {
            return (Map) ipChange.ipc$dispatch("-1658089094", new Object[]{this});
        }
        Map<String, String> trackArgs = super.getTrackArgs();
        trackArgs.put("biz_type", ErrControlViewInfo.TYPE_VENUE);
        trackArgs.put("biz_id", ((VenueContract.Model) this.model).getVenue().damaiId);
        return trackArgs;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.youku.arch.v3.DomainObject, com.youku.arch.v3.IItem] */
    @Override // com.alibaba.pictures.bricks.component.venue.VenueContract.Presenter
    public void gotoDetail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "998854595")) {
            ipChange.ipc$dispatch("998854595", new Object[]{this});
            return;
        }
        userTrackClick(getTrackArgs(), true);
        Action action = new Action();
        action.setActionType(1);
        if (TextUtils.isEmpty(((VenueContract.Model) this.model).getVenue().schema)) {
            action.setActionUrl("damai://V1/UserprofilePage?userType=3&userId=" + ((VenueContract.Model) this.model).getVenue().damaiId);
        } else {
            action.setActionUrl(((VenueContract.Model) this.model).getVenue().schema);
        }
        NavProviderProxy.getProxy().toUri(getItem().getPageContext().getActivity(), action);
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "51819211")) {
            ipChange.ipc$dispatch("51819211", new Object[]{this, iItem});
            return;
        }
        super.init(iItem);
        ((VenueContract.View) this.view).renderName(((VenueContract.Model) this.model).getVenue().name);
        ((VenueContract.View) this.view).renderLocation(((VenueContract.Model) this.model).getVenue().address);
        ((VenueContract.View) this.view).renderDistance(((VenueContract.Model) this.model).getVenue().distance);
        if (!TextUtils.isEmpty(((VenueContract.Model) this.model).getVenue().performanceTitles) && !TextUtils.isEmpty(((VenueContract.Model) this.model).getVenue().performanceCount) && !"0".equals(((VenueContract.Model) this.model).getVenue().performanceCount)) {
            ((VenueContract.View) this.view).renderPerformanceCount(((VenueContract.Model) this.model).getVenue().performanceCount + "场在售演出");
            ((VenueContract.View) this.view).renderPerformanceContent("：" + ((VenueContract.Model) this.model).getVenue().performanceTitles);
        } else {
            ((VenueContract.View) this.view).renderPerformanceCount("");
            ((VenueContract.View) this.view).renderPerformanceContent("");
        }
        w72.a(this, ((VenueContract.View) this.view).getRenderView());
        userTrackExpose(((VenueContract.View) this.view).getRenderView(), getTrackArgs());
    }
}
