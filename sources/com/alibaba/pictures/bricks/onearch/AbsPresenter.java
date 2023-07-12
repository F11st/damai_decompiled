package com.alibaba.pictures.bricks.onearch;

import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.view.IContract;
import com.youku.arch.v3.view.IContract.Model;
import com.youku.arch.v3.view.IContract.View;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import tb.n91;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class AbsPresenter<D extends IItem<ItemValue>, M extends IContract.Model<D>, V extends IContract.View> extends com.alient.onearch.adapter.view.AbsPresenter<D, M, V> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TRACKINFO_AB_BUCKET = "ABTrackInfo";
    public static final String TRACKINFO_AB_PREAB = "PreABTrackInfo";

    public AbsPresenter(String str, String str2, android.view.View view, EventHandler eventHandler, JSONObject jSONObject) {
        super(str, str2, view, eventHandler, jSONObject);
    }

    @Nullable
    private TrackInfo getTrackInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2033376785")) {
            return (TrackInfo) ipChange.ipc$dispatch("2033376785", new Object[]{this});
        }
        MODEL model = this.model;
        if (model == 0) {
            return null;
        }
        return ((AbsModel) model).getCompatTrackInfo();
    }

    public Map<String, String> getTrackArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "432104965")) {
            return (Map) ipChange.ipc$dispatch("432104965", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        try {
            GenericFragment fragment = this.item.getPageContext().getFragment();
            if (fragment instanceof IBaseTrack) {
                HashMap<String, String> args = ((IBaseTrack) fragment).getTrackInfo().getArgs();
                if (!n91.c(args)) {
                    hashMap.putAll(args);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public void onItemClick(@NotNull android.view.View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782023744")) {
            ipChange.ipc$dispatch("782023744", new Object[]{this, view});
        } else {
            super.onItemClick(view);
        }
    }

    public void userTrack(TrackType trackType, android.view.View view, String str, String str2, String str3, Map<String, String> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1131537012")) {
            ipChange.ipc$dispatch("1131537012", new Object[]{this, trackType, view, str, str2, str3, map, Boolean.valueOf(z)});
        } else if (UserTrackProviderProxy.getProxy() != null) {
            if (getTrackInfo() != null) {
                if (map == null) {
                    map = new HashMap<>();
                }
                if (trackType == TrackType.click && ((AbsModel) this.model).getPabBucket() != null) {
                    map.put("PreABTrackInfo", ((AbsModel) this.model).getPabBucket().toJSONString());
                }
                if (((AbsModel) this.model).getAbBucket() != null) {
                    map.put("ABTrackInfo", ((AbsModel) this.model).getAbBucket().toJSONString());
                }
            }
            TrackInfo trackInfo = new TrackInfo();
            trackInfo.setSpmb(str);
            trackInfo.setSpmc(str2);
            trackInfo.setSpmd(str3);
            trackInfo.setArgs((HashMap) map);
            if (trackType == TrackType.click) {
                UserTrackProviderProxy.getProxy().click(view, trackInfo, z);
            } else if (trackType == TrackType.expose) {
                UserTrackProviderProxy.getProxy().expose(view, trackInfo);
            }
        }
    }

    public void userTrackClick(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "502986842")) {
            ipChange.ipc$dispatch("502986842", new Object[]{this, Boolean.valueOf(z)});
        } else if (getTrackInfo() == null) {
        } else {
            userTrackClick(getTrackInfo().getSpmd(), getTrackInfo().getArgs(), z);
        }
    }

    public void userTrackExpose(android.view.View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1417240654")) {
            ipChange.ipc$dispatch("1417240654", new Object[]{this, view});
        } else if (getTrackInfo() == null) {
        } else {
            userTrackExpose(view, getTrackInfo().getSpmd(), getTrackInfo().getArgs());
        }
    }

    public AbsPresenter(String str, String str2, android.view.View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
    }

    public AbsPresenter(String str, String str2, android.view.View view, EventHandler eventHandler, Map map) {
        super(str, str2, view, eventHandler, map);
    }

    public void userTrackClick(Map<String, String> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "601327017")) {
            ipChange.ipc$dispatch("601327017", new Object[]{this, map, Boolean.valueOf(z)});
        } else if (getTrackInfo() == null) {
        } else {
            userTrack(TrackType.click, null, getTrackInfo().getSpmb(), getTrackInfo().getSpmc(), getTrackInfo().getSpmd(), map, z);
        }
    }

    public void userTrackExpose(android.view.View view, String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592640797")) {
            ipChange.ipc$dispatch("-592640797", new Object[]{this, view, str, str2, map});
        } else if (getTrackInfo() == null) {
        } else {
            userTrack(TrackType.expose, view, getTrackInfo().getSpmb(), str, str2, map, false);
        }
    }

    public AbsPresenter(M m, V v, EventHandler eventHandler, String str) {
        super(m, v, eventHandler, str);
    }

    public void userTrackExpose(android.view.View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1718594920")) {
            ipChange.ipc$dispatch("-1718594920", new Object[]{this, view, str});
        } else if (getTrackInfo() == null) {
        } else {
            userTrackExpose(view, str, getTrackInfo().getArgs());
        }
    }

    public void userTrackClick(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1125977520")) {
            ipChange.ipc$dispatch("-1125977520", new Object[]{this, str, Boolean.valueOf(z)});
        } else if (getTrackInfo() == null) {
        } else {
            userTrackClick(str, getTrackInfo().getArgs(), z);
        }
    }

    public void userTrackExpose(android.view.View view, String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-194050579")) {
            ipChange.ipc$dispatch("-194050579", new Object[]{this, view, str, map});
        } else if (getTrackInfo() == null) {
        } else {
            userTrack(TrackType.expose, view, getTrackInfo().getSpmb(), getTrackInfo().getSpmc(), str, map, false);
        }
    }

    public void userTrackClick(String str, Map<String, String> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1660313357")) {
            ipChange.ipc$dispatch("-1660313357", new Object[]{this, str, map, Boolean.valueOf(z)});
        } else if (getTrackInfo() == null) {
        } else {
            userTrack(TrackType.click, null, getTrackInfo().getSpmb(), getTrackInfo().getSpmc(), str, map, z);
        }
    }

    public void userTrackExpose(android.view.View view, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1336011401")) {
            ipChange.ipc$dispatch("-1336011401", new Object[]{this, view, map});
        } else if (getTrackInfo() == null) {
        } else {
            userTrackExpose(view, getTrackInfo().getSpmd(), map);
        }
    }

    public void userTrackClick(String str, String str2, Map<String, String> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1498103229")) {
            ipChange.ipc$dispatch("1498103229", new Object[]{this, str, str2, map, Boolean.valueOf(z)});
        } else if (getTrackInfo() == null) {
        } else {
            userTrack(TrackType.click, null, getTrackInfo().getSpmb(), str, str2, map, z);
        }
    }
}
