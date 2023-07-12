package com.alibaba.pictures.bricks.component.project.tour;

import android.text.TextUtils;
import android.view.View;
import com.alibaba.pictures.bricks.component.project.tour.TourContract;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.event.EventHandler;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TourPresent extends AbsPresenter<IItem<ItemValue>, TourContract.Model<IItem<ItemValue>>, TourContract.View> implements TourContract.Presenter<IItem<ItemValue>, TourContract.Model<IItem<ItemValue>>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String TOUR_ITEM;
    private final String TOUR_MORE;
    private final String TOUR_TOP_ITEM;

    public TourPresent(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
        this.TOUR_MORE = "tour_more";
        this.TOUR_TOP_ITEM = "tour_top_item";
        this.TOUR_ITEM = "tour_item_";
    }

    private void typeMap(Map<String, String> map, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1963083586")) {
            ipChange.ipc$dispatch("-1963083586", new Object[]{this, map, str, str2});
            return;
        }
        map.put("item_id", str);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put("discount_type", str2);
    }

    @Override // com.alibaba.pictures.bricks.component.project.tour.TourContract.Presenter
    public void dispatchAction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-4882403")) {
            ipChange.ipc$dispatch("-4882403", new Object[]{this});
            return;
        }
        userTrackClick("tour_more", getTrackArgs(), false);
        HashMap hashMap = new HashMap();
        hashMap.put("tabIndex", 1);
        getEventHandler().onMessage("switch_search_result_tab", hashMap);
    }

    public Map<String, String> getTrackArgsTemp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1236296348")) {
            return (Map) ipChange.ipc$dispatch("1236296348", new Object[]{this});
        }
        HashMap hashMap = new HashMap(getTrackArgs());
        typeMap(hashMap, ((TourContract.Model) this.model).getTourBean().topItem.id, ((TourContract.Model) this.model).getTourBean().topItem.gotMarketUTValue());
        return hashMap;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-888464011")) {
            ipChange.ipc$dispatch("-888464011", new Object[]{this, iItem});
            return;
        }
        super.init(iItem);
        if (((TourContract.Model) this.model).getTourBean() == null) {
            return;
        }
        ((TourContract.View) this.view).setCountDownServerTime(((TourContract.Model) this.model).getServerTime(), ((TourContract.Model) this.model).getNativeDiffTime());
        if (!TextUtils.isEmpty(iItem.getPageContext().getBundle().getString("tabtitle"))) {
            ((TourContract.View) this.view).setExpandState(!"全部".equals(iItem.getPageContext().getBundle().getString("tabtitle")));
        }
        ((TourContract.View) this.view).handlerData(((TourContract.Model) this.model).getTourBean());
        ModelValue property = this.item.getComponent().getModule().getContainer().getProperty();
        if (property.getData() != null && property.getData().containsKey("comboDegrade") && property.getData().getBooleanValue("comboDegrade")) {
            ((TourContract.View) this.view).getHolder().v(false);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.tour.TourContract.Presenter
    public void moreUserExpose() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1662311863")) {
            ipChange.ipc$dispatch("-1662311863", new Object[]{this});
        } else {
            userTrackExpose(((TourContract.View) this.view).getMoreTourLayout(), "tour_more", getTrackArgs());
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.tour.TourContract.Presenter
    public void projectUserClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1526879113")) {
            ipChange.ipc$dispatch("1526879113", new Object[]{this});
        } else {
            userTrackClick("tour_top_item", getTrackArgsTemp(), true);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.tour.TourContract.Presenter
    public void projectUserExpose() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1817097707")) {
            ipChange.ipc$dispatch("-1817097707", new Object[]{this});
        } else {
            userTrackExpose(((TourContract.View) this.view).getProjectContainer(), "tour_top_item", getTrackArgsTemp());
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.tour.TourContract.Presenter
    public void tourCityUserClick(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "941301046")) {
            ipChange.ipc$dispatch("941301046", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap(getTrackArgs());
        typeMap(hashMap, str, null);
        userTrackClick("tour_item_" + i, hashMap, true);
    }

    @Override // com.alibaba.pictures.bricks.component.project.tour.TourContract.Presenter
    public void tourCityUserExpose(View view, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1632543582")) {
            ipChange.ipc$dispatch("-1632543582", new Object[]{this, view, str, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(getTrackArgs());
        typeMap(hashMap, str, null);
        userTrackExpose(view, "tour_item_" + i, hashMap);
    }
}
