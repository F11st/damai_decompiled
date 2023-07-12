package cn.damai.category.grab.model;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cn.damai.category.grab.bean.GrabBean;
import cn.damai.category.grab.request.GrabRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.nu0;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class GrabModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private MutableLiveData<GrabBean> mGrabBean = new MutableLiveData<>();
    private nu0 mRepository = new nu0();

    public GrabModel(Context context) {
        this.mContext = context;
    }

    public MutableLiveData<GrabBean> getGrabBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-859805477") ? (MutableLiveData) ipChange.ipc$dispatch("-859805477", new Object[]{this}) : this.mGrabBean;
    }

    public void grabRequest(GrabRequest grabRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2117254175")) {
            ipChange.ipc$dispatch("-2117254175", new Object[]{this, grabRequest});
        } else {
            this.mRepository.a(grabRequest, new DMMtopRequestListener<GrabBean>(GrabBean.class) { // from class: cn.damai.category.grab.model.GrabModel.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-626535901")) {
                        ipChange2.ipc$dispatch("-626535901", new Object[]{this, str, str2});
                    } else {
                        GrabModel.this.mGrabBean.setValue(null);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(GrabBean grabBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1977518171")) {
                        ipChange2.ipc$dispatch("1977518171", new Object[]{this, grabBean});
                    } else {
                        GrabModel.this.mGrabBean.setValue(grabBean);
                    }
                }
            });
        }
    }
}
