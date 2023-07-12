package cn.damai.mine.model;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.wannasee.Wanna2SeeRequest;
import cn.damai.commonbusiness.wannasee.bean.WannaBean;
import cn.damai.mine.bean.PageData;
import cn.damai.mine.bean.PageType;
import cn.damai.mine.listener.OnBizListener;
import cn.damai.mine.listener.OnWannaBeanListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class WannaSeeModel extends AbsModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnWannaBeanListener mListener;
    private final PageType mType;
    private int pageNo = 1;

    public WannaSeeModel(PageType pageType, OnWannaBeanListener onWannaBeanListener) {
        this.mType = pageType;
        this.mListener = onWannaBeanListener;
    }

    static /* synthetic */ int access$108(WannaSeeModel wannaSeeModel) {
        int i = wannaSeeModel.pageNo;
        wannaSeeModel.pageNo = i + 1;
        return i;
    }

    public void load(final boolean z, final OnBizListener<PageData<List>> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1612538712")) {
            ipChange.ipc$dispatch("1612538712", new Object[]{this, Boolean.valueOf(z), onBizListener});
            return;
        }
        if (z) {
            this.pageNo = 1;
        }
        this.mHolder.a(new Wanna2SeeRequest(this.mType.requestType, this.pageNo).request(new DMMtopRequestListener<WannaBean>(WannaBean.class) { // from class: cn.damai.mine.model.WannaSeeModel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1999773945")) {
                    ipChange2.ipc$dispatch("-1999773945", new Object[]{this, str, str2});
                } else {
                    onBizListener.onBizFail(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(WannaBean wannaBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-495999783")) {
                    ipChange2.ipc$dispatch("-495999783", new Object[]{this, wannaBean});
                } else if (wannaBean != null) {
                    if (z && WannaSeeModel.this.mListener != null) {
                        WannaSeeModel.this.mListener.onWannaBean(wannaBean);
                    }
                    WannaSeeModel.access$108(WannaSeeModel.this);
                    onBizListener.onBizSuccess(PageData.success(z, wannaBean.hasNext, WannaSeeModel.this.mType.getListByType(wannaBean)));
                } else {
                    onFail("", "");
                }
            }
        }));
    }
}
