package cn.damai.user.brand;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.user.brand.bean.BrandInfoRerquest;
import cn.damai.user.brand.bean.BrandInfoResult;
import cn.damai.user.brand.bean.BrandNearbyShowRerquest;
import cn.damai.user.brand.bean.BrandResponse;
import cn.damai.user.brand.bean.BrandShowResponse;
import cn.damai.user.common.SingleLiveEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BrandViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    MutableLiveData<BrandResponse> brandInfo;
    private final SingleLiveEvent<Object> clickEvent;
    BrandRepository repository;
    public String sinapath;

    public BrandViewModel(@NonNull Application application) {
        super(application);
        this.clickEvent = new SingleLiveEvent<>();
        this.repository = new BrandRepository(application.getApplicationContext());
    }

    public BrandInfoResult getBrandValue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-701026246")) {
            return (BrandInfoResult) ipChange.ipc$dispatch("-701026246", new Object[]{this});
        }
        MutableLiveData<BrandResponse> mutableLiveData = this.brandInfo;
        if (mutableLiveData == null || mutableLiveData.getValue() == null || this.brandInfo.getValue().data == null) {
            return null;
        }
        return this.brandInfo.getValue().data;
    }

    public SingleLiveEvent<Object> getClickEvent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-78766373") ? (SingleLiveEvent) ipChange.ipc$dispatch("-78766373", new Object[]{this}) : this.clickEvent;
    }

    public MutableLiveData<BrandResponse> requestBrandInfo(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1235419737")) {
            return (MutableLiveData) ipChange.ipc$dispatch("1235419737", new Object[]{this, str, str2, str3});
        }
        BrandInfoRerquest brandInfoRerquest = new BrandInfoRerquest();
        brandInfoRerquest.bid = str;
        brandInfoRerquest.cityId = str2;
        brandInfoRerquest.projectId = str3;
        MutableLiveData<BrandResponse> a = this.repository.a(brandInfoRerquest);
        if (this.brandInfo == null) {
            this.brandInfo = a;
        }
        return this.brandInfo;
    }

    public MutableLiveData<BrandShowResponse> requestNearbyShows(String str, String str2, int i, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "339839862")) {
            return (MutableLiveData) ipChange.ipc$dispatch("339839862", new Object[]{this, str, str2, Integer.valueOf(i), str3});
        }
        BrandNearbyShowRerquest brandNearbyShowRerquest = new BrandNearbyShowRerquest();
        brandNearbyShowRerquest.bid = str;
        brandNearbyShowRerquest.cityId = str2;
        brandNearbyShowRerquest.pageNo = i;
        brandNearbyShowRerquest.excludeProjectId = str3;
        return this.repository.b(brandNearbyShowRerquest);
    }

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "556655480")) {
            ipChange.ipc$dispatch("556655480", new Object[]{this});
        } else {
            this.brandInfo = null;
        }
    }
}
