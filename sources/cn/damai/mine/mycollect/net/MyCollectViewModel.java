package cn.damai.mine.mycollect.net;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.mine.mycollect.bean.MyCollectFollowResponse;
import cn.damai.mine.mycollect.bean.MyCollectResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MyCollectViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public final int TYPE_JOIN;
    public final int TYPE_PROJECT;
    private MutableLiveData<Integer> mPageIndex;
    private MyCollectRepository mRepository;

    public MyCollectViewModel(@NonNull Application application) {
        super(application);
        this.TYPE_PROJECT = 7;
        this.TYPE_JOIN = 13;
        this.mPageIndex = new MutableLiveData<>();
        this.mRepository = new MyCollectRepository();
    }

    public MutableLiveData<MyCollectFollowResponse> cancelFollowData(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1862273770")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-1862273770", new Object[]{this, str, str2});
        }
        FollowRequest followRequest = new FollowRequest();
        followRequest.operateType = "0";
        followRequest.targetId = str;
        followRequest.targetType = str2;
        return this.mRepository.cancelFollowResult(followRequest);
    }

    public MutableLiveData<MyCollectResponse> getCollectData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122875923")) {
            return (MutableLiveData) ipChange.ipc$dispatch("1122875923", new Object[]{this});
        }
        MyCollectRequest myCollectRequest = new MyCollectRequest();
        myCollectRequest.pageNo = this.mPageIndex.getValue().intValue();
        myCollectRequest.type = 7;
        return this.mRepository.getCollectData(myCollectRequest);
    }

    public MutableLiveData<MyCollectResponse> getJoinData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906195667")) {
            return (MutableLiveData) ipChange.ipc$dispatch("1906195667", new Object[]{this});
        }
        MyCollectRequest myCollectRequest = new MyCollectRequest();
        myCollectRequest.pageNo = this.mPageIndex.getValue().intValue();
        myCollectRequest.type = 13;
        return this.mRepository.getJoinData(myCollectRequest);
    }

    public MutableLiveData<Integer> getPageIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2060236386") ? (MutableLiveData) ipChange.ipc$dispatch("2060236386", new Object[]{this}) : this.mPageIndex;
    }
}
