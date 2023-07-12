package cn.damai.search.model;

import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.search.bean.SearchAccountResponse;
import cn.damai.search.bean.SearchFollowResponse;
import cn.damai.search.presenter.SearchAccountRepository;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.ja1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchAccountViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String mCurrentType;
    private String mKeyWord;
    private MutableLiveData<Integer> mPageIndex;
    private SearchAccountRepository mRepository;

    public SearchAccountViewModel(@NonNull Application application) {
        super(application);
        this.mPageIndex = new MutableLiveData<>();
        this.mRepository = new SearchAccountRepository();
    }

    public MutableLiveData<SearchAccountResponse> getAccountData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-845508785")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-845508785", new Object[]{this});
        }
        SearchBAccountRequest searchBAccountRequest = new SearchBAccountRequest();
        searchBAccountRequest.keyword = this.mKeyWord;
        searchBAccountRequest.baccountType = this.mCurrentType;
        searchBAccountRequest.pageNumber = this.mPageIndex.getValue().intValue();
        double[] b = ja1.b();
        if (b != null) {
            searchBAccountRequest.longitude = String.valueOf(b[0]);
            searchBAccountRequest.latitude = String.valueOf(b[1]);
        }
        return this.mRepository.b(searchBAccountRequest);
    }

    public MutableLiveData<SearchFollowResponse> getFollowState(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1793509148")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-1793509148", new Object[]{this, str, str2});
        }
        FollowRequest followRequest = new FollowRequest();
        followRequest.operateType = "1";
        followRequest.targetId = str;
        followRequest.targetType = str2;
        return this.mRepository.a(followRequest);
    }

    public MutableLiveData<Integer> getPageIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "98959515") ? (MutableLiveData) ipChange.ipc$dispatch("98959515", new Object[]{this}) : this.mPageIndex;
    }

    public void initParam(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1325766099")) {
            ipChange.ipc$dispatch("-1325766099", new Object[]{this, bundle});
        } else if (bundle != null) {
            this.mKeyWord = bundle.getString("keyword");
            this.mCurrentType = bundle.getString("type");
        } else {
            this.mKeyWord = "";
            this.mCurrentType = "2";
        }
    }
}
