package cn.damai.user.star;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.user.common.SingleLiveEvent;
import cn.damai.user.star.bean.StarIndexRequest;
import cn.damai.user.star.bean.StarIndexResponse;
import cn.damai.user.star.bean.StarInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class StarViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private final SingleLiveEvent<Object> clickEvent;
    public int feedsTabIndex;
    public String id;
    StarRepository repository;
    public int showType;
    public String sinapath;
    MutableLiveData<StarIndexResponse> starInfo;
    public String type;

    public StarViewModel(@NonNull Application application) {
        super(application);
        this.clickEvent = new SingleLiveEvent<>();
        this.feedsTabIndex = 0;
        this.repository = new StarRepository(application.getApplicationContext());
    }

    public SingleLiveEvent<Object> getClickEvent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1528497941") ? (SingleLiveEvent) ipChange.ipc$dispatch("-1528497941", new Object[]{this}) : this.clickEvent;
    }

    public StarInfo getStarValue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1962555056")) {
            return (StarInfo) ipChange.ipc$dispatch("1962555056", new Object[]{this});
        }
        MutableLiveData<StarIndexResponse> mutableLiveData = this.starInfo;
        if (mutableLiveData == null || mutableLiveData.getValue() == null || this.starInfo.getValue().data == null) {
            return null;
        }
        return this.starInfo.getValue().data;
    }

    public Map getUtArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "594753338")) {
            return (Map) ipChange.ipc$dispatch("594753338", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("biz_id", this.id);
        hashMap.put("biz_type", this.type);
        return hashMap;
    }

    public MutableLiveData<StarIndexResponse> requestStarInfo(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-532536008")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-532536008", new Object[]{this, Long.valueOf(j)});
        }
        StarIndexRequest starIndexRequest = new StarIndexRequest();
        starIndexRequest.artistId = j;
        try {
            starIndexRequest.currentCityId = Long.parseLong(z20.c());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        MutableLiveData<StarIndexResponse> a = this.repository.a(starIndexRequest);
        if (this.starInfo == null) {
            this.starInfo = a;
        }
        return this.starInfo;
    }

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-556159128")) {
            ipChange.ipc$dispatch("-556159128", new Object[]{this});
        } else {
            this.starInfo = null;
        }
    }
}
