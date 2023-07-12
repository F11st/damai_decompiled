package cn.damai.commonbusiness.seatbiz.sku.qilin.model;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.seatbiz.common.bean.OrderPrice;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.SkuBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.DengjiRequest;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.SkuRequest;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.SuanjiaRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.sd2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SkuModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private MutableLiveData<SkuBean> mSkuBean = new MutableLiveData<>();
    private MutableLiveData<FollowDataBean> mFollowDataBean = new MutableLiveData<>();
    private MutableLiveData<OrderPrice> mOrderPrice = new MutableLiveData<>();
    private sd2 mRepository = new sd2();

    public SkuModel(Context context) {
        this.mContext = context;
    }

    public void dengjiRequest(DengjiRequest dengjiRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807803938")) {
            ipChange.ipc$dispatch("1807803938", new Object[]{this, dengjiRequest});
        } else {
            this.mRepository.a(dengjiRequest, new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) { // from class: cn.damai.commonbusiness.seatbiz.sku.qilin.model.SkuModel.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "261487166")) {
                        ipChange2.ipc$dispatch("261487166", new Object[]{this, str, str2});
                    } else {
                        SkuModel.this.mFollowDataBean.setValue(null);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(FollowDataBean followDataBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "551418850")) {
                        ipChange2.ipc$dispatch("551418850", new Object[]{this, followDataBean});
                    } else {
                        SkuModel.this.mFollowDataBean.setValue(followDataBean);
                    }
                }
            });
        }
    }

    public MutableLiveData<FollowDataBean> getFollowDataBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "836589284") ? (MutableLiveData) ipChange.ipc$dispatch("836589284", new Object[]{this}) : this.mFollowDataBean;
    }

    public MutableLiveData<OrderPrice> getOrderPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1794720052") ? (MutableLiveData) ipChange.ipc$dispatch("1794720052", new Object[]{this}) : this.mOrderPrice;
    }

    public MutableLiveData<SkuBean> getSkuBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1747326226") ? (MutableLiveData) ipChange.ipc$dispatch("1747326226", new Object[]{this}) : this.mSkuBean;
    }

    public void skuRequest(final SkuRequest skuRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-753665326")) {
            ipChange.ipc$dispatch("-753665326", new Object[]{this, skuRequest});
        } else {
            this.mRepository.b(skuRequest, new DMMtopResultRequestListener<SkuBean>(SkuBean.class) { // from class: cn.damai.commonbusiness.seatbiz.sku.qilin.model.SkuModel.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "269246525")) {
                        ipChange2.ipc$dispatch("269246525", new Object[]{this, str, str2});
                    } else {
                        SkuModel.this.mSkuBean.setValue(SkuBean.error(str, str2, skuRequest));
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
                public void onSuccess(SkuBean skuBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1240217969")) {
                        ipChange2.ipc$dispatch("-1240217969", new Object[]{this, skuBean});
                    } else {
                        SkuModel.this.mSkuBean.setValue(skuBean);
                    }
                }
            });
        }
    }

    public void suanjiaRequest(SuanjiaRequest suanjiaRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1282979522")) {
            ipChange.ipc$dispatch("-1282979522", new Object[]{this, suanjiaRequest});
        } else {
            this.mRepository.c(suanjiaRequest, new DMMtopRequestListener<OrderPrice>(OrderPrice.class) { // from class: cn.damai.commonbusiness.seatbiz.sku.qilin.model.SkuModel.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "253727807")) {
                        ipChange2.ipc$dispatch("253727807", new Object[]{this, str, str2});
                    } else {
                        SkuModel.this.mOrderPrice.setValue(null);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(OrderPrice orderPrice) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-698088467")) {
                        ipChange2.ipc$dispatch("-698088467", new Object[]{this, orderPrice});
                    } else {
                        SkuModel.this.mOrderPrice.setValue(orderPrice);
                    }
                }
            });
        }
    }
}
