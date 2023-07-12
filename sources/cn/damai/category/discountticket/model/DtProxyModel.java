package cn.damai.category.discountticket.model;

import cn.damai.category.discountticket.bean.HeaderData;
import cn.damai.category.discountticket.bean.biz.DtParams;
import cn.damai.category.discountticket.bean.biz.FirstPageData;
import cn.damai.category.discountticket.bean.biz.MorePageData;
import cn.damai.category.discountticket.contract.DiscountTicketContract;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DtProxyModel extends BaseDiscountModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private DiscountTicketContract.DtModel mRealModel;

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public boolean changeCityId(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-172922318") ? ((Boolean) ipChange.ipc$dispatch("-172922318", new Object[]{this, str})).booleanValue() : this.mRealModel.changeCityId(str);
    }

    @Override // cn.damai.category.discountticket.model.BaseDiscountModel, cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "795700406")) {
            ipChange.ipc$dispatch("795700406", new Object[]{this});
            return;
        }
        DiscountTicketContract.DtModel dtModel = this.mRealModel;
        if (dtModel != null) {
            dtModel.destroy();
        }
        super.destroy();
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public ProjectItemBean firstProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1383540633") ? (ProjectItemBean) ipChange.ipc$dispatch("-1383540633", new Object[]{this}) : this.mRealModel.firstProject();
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public String getCityId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "769464140") ? (String) ipChange.ipc$dispatch("769464140", new Object[]{this}) : this.mRealModel.getCityId();
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public HeaderData getHeaderData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "706022520") ? (HeaderData) ipChange.ipc$dispatch("706022520", new Object[]{this}) : this.mRealModel.getHeaderData();
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void load(BaseListener<FirstPageData> baseListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1680112246")) {
            ipChange.ipc$dispatch("1680112246", new Object[]{this, baseListener});
        } else {
            this.mRealModel.load(baseListener);
        }
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void loadMore(OnTListener<MorePageData> onTListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2115195241")) {
            ipChange.ipc$dispatch("-2115195241", new Object[]{this, onTListener});
        } else {
            this.mRealModel.loadMore(onTListener);
        }
    }

    public void prepare(DtParams dtParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "860565395")) {
            ipChange.ipc$dispatch("860565395", new Object[]{this, dtParams});
        } else if (dtParams.isTypeMoreDiscountActivity()) {
            this.mRealModel = new MoreDiscountModel(dtParams.extra, dtParams.cityId);
        } else {
            this.mRealModel = new DiscountTicketModel(dtParams.cityId);
        }
    }

    @Override // cn.damai.category.discountticket.model.BaseDiscountModel, cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void share(OnShareListener onShareListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104044062")) {
            ipChange.ipc$dispatch("2104044062", new Object[]{this, onShareListener});
        } else {
            this.mRealModel.share(onShareListener);
        }
    }
}
