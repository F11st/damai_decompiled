package cn.damai.category.inventory.model;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.category.inventory.bean.DetailedBeanResponse;
import cn.damai.category.inventory.bean.DetailedFollowResponse;
import cn.damai.category.inventory.repository.DetailedRespository;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DetailedModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private final MutableLiveData<DetailedFollowResponse> followLiveData;
    private String mId;
    private DetailedRespository mRepository;

    public DetailedModel(@NonNull Application application) {
        super(application);
        this.mId = "";
        this.followLiveData = new MutableLiveData<>();
        this.mRepository = new DetailedRespository();
    }

    public void getAttentionState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1169224774")) {
            ipChange.ipc$dispatch("-1169224774", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mRepository.b(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) { // from class: cn.damai.category.inventory.model.DetailedModel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1807871477")) {
                    ipChange2.ipc$dispatch("-1807871477", new Object[]{this, str, str2});
                    return;
                }
                DetailedFollowResponse detailedFollowResponse = new DetailedFollowResponse();
                detailedFollowResponse.requestSuccess = false;
                detailedFollowResponse.errorCode = str;
                detailedFollowResponse.errorMsg = str2;
                DetailedModel.this.followLiveData.setValue(detailedFollowResponse);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-770625803")) {
                    ipChange2.ipc$dispatch("-770625803", new Object[]{this, followDataBean});
                    return;
                }
                DetailedFollowResponse detailedFollowResponse = new DetailedFollowResponse();
                detailedFollowResponse.data = followDataBean;
                detailedFollowResponse.requestSuccess = true;
                DetailedModel.this.followLiveData.setValue(detailedFollowResponse);
            }
        }, z ? "0" : "1", this.mId);
    }

    public String getDetailedId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-56855202") ? (String) ipChange.ipc$dispatch("-56855202", new Object[]{this}) : this.mId;
    }

    public MutableLiveData<DetailedBeanResponse> getDetailedListData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-354696225") ? (MutableLiveData) ipChange.ipc$dispatch("-354696225", new Object[]{this}) : this.mRepository.a(this.mId);
    }

    public MutableLiveData<DetailedFollowResponse> getFollowLiveData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1861646830") ? (MutableLiveData) ipChange.ipc$dispatch("1861646830", new Object[]{this}) : this.followLiveData;
    }

    public void initParam(Intent intent) {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1090307261")) {
            ipChange.ipc$dispatch("-1090307261", new Object[]{this, intent});
        } else if (intent == null || (extras = intent.getExtras()) == null) {
        } else {
            this.mId = extras.getString("id");
        }
    }
}
