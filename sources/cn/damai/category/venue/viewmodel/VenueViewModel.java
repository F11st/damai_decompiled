package cn.damai.category.venue.viewmodel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cn.damai.category.venue.bean.VenueQueryResponse;
import cn.damai.common.aac.DamaiViewModel;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cx2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class VenueViewModel extends DamaiViewModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private int mPageNo;
    private Object[] mQueryRequest = new Object[3];
    private MutableLiveData<VenueQueryResponse> mQueryBean = new MutableLiveData<>();
    private MutableLiveData<String> toastEvent = new MutableLiveData<>();
    private cx2 mRepository = new cx2();

    public VenueViewModel(Context context) {
        this.mContext = context;
    }

    public MutableLiveData<VenueQueryResponse> getQueryBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1130894187") ? (MutableLiveData) ipChange.ipc$dispatch("1130894187", new Object[]{this}) : this.mQueryBean;
    }

    public MutableLiveData<String> getToastEvent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-147000034") ? (MutableLiveData) ipChange.ipc$dispatch("-147000034", new Object[]{this}) : this.toastEvent;
    }

    public void query(int i, String str, String str2, String str3, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965675065")) {
            ipChange.ipc$dispatch("965675065", new Object[]{this, Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2)});
        } else {
            this.mRepository.a(i, 20, str, str2, str3, i2, new DMMtopRequestListener<VenueQueryResponse>(VenueQueryResponse.class) { // from class: cn.damai.category.venue.viewmodel.VenueViewModel.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str4, String str5) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1217858831")) {
                        ipChange2.ipc$dispatch("1217858831", new Object[]{this, str4, str5});
                    } else {
                        VenueViewModel.this.toastEvent.setValue(str5);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(VenueQueryResponse venueQueryResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "435487792")) {
                        ipChange2.ipc$dispatch("435487792", new Object[]{this, venueQueryResponse});
                    } else {
                        VenueViewModel.this.mQueryBean.setValue(venueQueryResponse);
                    }
                }
            });
        }
    }

    public void setQueryRequest(int i, String str, String str2, String str3, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1913111112")) {
            ipChange.ipc$dispatch("-1913111112", new Object[]{this, Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2)});
            return;
        }
        this.mPageNo = i;
        query(i, str, str2, str3, i2);
    }
}
