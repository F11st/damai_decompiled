package cn.damai.onearch.view;

import androidx.annotation.Nullable;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.core.ut.TrackType;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.oneservice.ut.TrackInfo;
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
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class AbsPresenter<D extends IItem<ItemValue>, M extends IContract.Model<D>, V extends IContract.View> extends com.alient.onearch.adapter.view.AbsPresenter<D, M, V> {
    private static transient /* synthetic */ IpChange $ipChange;

    public AbsPresenter(String str, String str2, android.view.View view, EventHandler eventHandler, JSONObject jSONObject) {
        super(str, str2, view, eventHandler, jSONObject);
    }

    @Nullable
    private TrackInfo getTrackInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1314764372")) {
            return (TrackInfo) ipChange.ipc$dispatch("-1314764372", new Object[]{this});
        }
        MODEL model = this.model;
        if (model == 0) {
            return null;
        }
        return ((AbsModel) model).getCompatTrackInfo();
    }

    public Map<String, String> getTrackArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-932212854")) {
            return (Map) ipChange.ipc$dispatch("-932212854", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        try {
            GenericFragment fragment = this.item.getPageContext().getFragment();
            if (fragment instanceof BaseFragment) {
                HashMap<String, String> args = ((BaseFragment) fragment).getTrackInfo().getArgs();
                if (!cb2.f(args)) {
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
        if (AndroidInstantRuntime.support(ipChange, "526424901")) {
            ipChange.ipc$dispatch("526424901", new Object[]{this, view});
        } else {
            super.onItemClick(view);
        }
    }

    public void userTrack(TrackType trackType, android.view.View view, String str, String str2, String str3, Map<String, String> map, boolean z) {
        Map<String, String> map2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1228039701")) {
            ipChange.ipc$dispatch("-1228039701", new Object[]{this, trackType, view, str, str2, str3, map, Boolean.valueOf(z)});
        } else if (TrackProxy.a() != null) {
            if (getTrackInfo() != null) {
                Map<String, String> hashMap = map == null ? new HashMap<>() : map;
                if (trackType == TrackType.click && ((AbsModel) this.model).getPabBucket() != null) {
                    hashMap.put("PreABTrackInfo", ((AbsModel) this.model).getPabBucket().toJSONString());
                }
                if (((AbsModel) this.model).getAbBucket() != null) {
                    hashMap.put("ABTrackInfo", ((AbsModel) this.model).getAbBucket().toJSONString());
                }
                map2 = hashMap;
            } else {
                map2 = map;
            }
            TrackProxy.a().userTrack(trackType, view, str, str2, str3, map2, z);
        }
    }

    public void userTrackClick(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1796763659")) {
            ipChange.ipc$dispatch("-1796763659", new Object[]{this, Boolean.valueOf(z)});
        } else if (getTrackInfo() == null) {
        } else {
            userTrackClick(getTrackInfo().getSpmd(), getTrackInfo().getArgs(), z);
        }
    }

    public void userTrackExpose(android.view.View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1920742611")) {
            ipChange.ipc$dispatch("1920742611", new Object[]{this, view});
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
        if (AndroidInstantRuntime.support(ipChange, "345728174")) {
            ipChange.ipc$dispatch("345728174", new Object[]{this, map, Boolean.valueOf(z)});
        } else if (getTrackInfo() == null) {
        } else {
            userTrack(TrackType.click, null, getTrackInfo().getSpmb(), getTrackInfo().getSpmc(), getTrackInfo().getSpmd(), map, z);
        }
    }

    public void userTrackExpose(android.view.View view, String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1690952766")) {
            ipChange.ipc$dispatch("1690952766", new Object[]{this, view, str, str2, map});
        } else if (getTrackInfo() == null) {
        } else {
            userTrack(TrackType.expose, view, getTrackInfo().getSpmb(), str, str2, map, false);
        }
    }

    public AbsPresenter(M m, V v, EventHandler eventHandler, String str) {
        super(m, v, eventHandler, str);
    }

    public void userTrackClick(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-694093525")) {
            ipChange.ipc$dispatch("-694093525", new Object[]{this, str, Boolean.valueOf(z)});
        } else if (getTrackInfo() == null) {
        } else {
            userTrackClick(str, getTrackInfo().getArgs(), z);
        }
    }

    public void userTrackExpose(android.view.View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-309661731")) {
            ipChange.ipc$dispatch("-309661731", new Object[]{this, view, str});
        } else if (getTrackInfo() == null) {
        } else {
            userTrackExpose(view, str, getTrackInfo().getArgs());
        }
    }

    public void userTrackClick(String str, Map<String, String> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1921493176")) {
            ipChange.ipc$dispatch("1921493176", new Object[]{this, str, map, Boolean.valueOf(z)});
        } else if (getTrackInfo() == null) {
        } else {
            userTrack(TrackType.click, null, getTrackInfo().getSpmb(), getTrackInfo().getSpmc(), str, map, z);
        }
    }

    public void userTrackExpose(android.view.View view, String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "781686280")) {
            ipChange.ipc$dispatch("781686280", new Object[]{this, view, str, map});
        } else if (getTrackInfo() == null) {
        } else {
            userTrack(TrackType.expose, view, getTrackInfo().getSpmb(), getTrackInfo().getSpmc(), str, map, false);
        }
    }

    public void userTrackClick(String str, String str2, Map<String, String> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-132989374")) {
            ipChange.ipc$dispatch("-132989374", new Object[]{this, str, str2, map, Boolean.valueOf(z)});
        } else if (getTrackInfo() == null) {
        } else {
            userTrack(TrackType.click, null, getTrackInfo().getSpmb(), str, str2, map, z);
        }
    }

    public void userTrackExpose(android.view.View view, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1969158574")) {
            ipChange.ipc$dispatch("-1969158574", new Object[]{this, view, map});
        } else if (getTrackInfo() == null) {
        } else {
            userTrackExpose(view, getTrackInfo().getSpmd(), map);
        }
    }
}
