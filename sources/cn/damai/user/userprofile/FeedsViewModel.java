package cn.damai.user.userprofile;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.user.userprofile.bean.FeedsRequest;
import cn.damai.user.userprofile.bean.FeedsResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class FeedsViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ARG_BID = "bid";
    public static final String ARG_FEEDTYPE = "feedType";
    public static final String ARG_TARGETTYPE = "targetType";
    public static final String ARG_USERID = "userid";
    private long bid;
    private int feedType;
    MutableLiveData<FeedsResponse> feedsResponse;
    UserIndexRepository repository;
    private int targetType;
    private String userid;

    public FeedsViewModel(@NonNull Application application) {
        super(application);
        this.repository = new UserIndexRepository(application.getApplicationContext());
    }

    public MutableLiveData<FeedsResponse> getFeeds(@NonNull FeedsRequest feedsRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1668156081")) {
            return (MutableLiveData) ipChange.ipc$dispatch("1668156081", new Object[]{this, feedsRequest});
        }
        feedsRequest.targetType = this.targetType;
        feedsRequest.bid = this.bid + "";
        int i = this.feedType;
        feedsRequest.feedType = i;
        if (i == FeedsRequest.FEED_TYPE_DONGTAI) {
            feedsRequest.sourceId = this.userid + "";
        } else {
            feedsRequest.sourceId = this.bid + "";
        }
        feedsRequest.refreshHeader = true;
        Log.d("feedlist", "feedsRequest : " + feedsRequest.toParam());
        MutableLiveData<FeedsResponse> a = this.repository.a(feedsRequest);
        if (this.feedsResponse == null) {
            this.feedsResponse = a;
        }
        return this.feedsResponse;
    }

    public void initParams(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "626944300")) {
            ipChange.ipc$dispatch("626944300", new Object[]{this, bundle});
            return;
        }
        this.targetType = bundle.getInt("targetType");
        this.userid = bundle.getString(ARG_USERID);
        this.bid = bundle.getLong("bid");
        this.feedType = bundle.getInt("feedType");
    }
}
