package cn.damai.category.discountticket.model;

import android.text.TextUtils;
import cn.damai.category.discountticket.bean.HeaderData;
import cn.damai.category.discountticket.bean.biz.Column3WrapBean;
import cn.damai.category.discountticket.bean.biz.DiscountTipBean;
import cn.damai.category.discountticket.bean.biz.FirstPageData;
import cn.damai.category.discountticket.bean.biz.MorePageData;
import cn.damai.category.discountticket.request.SearchListRequest;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.o90;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MoreDiscountModel extends BaseDiscountModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private int curCount = 0;
    private String mCityId;
    private HeaderData mHeaderData;
    private Column3WrapBean mLastItem;
    private ProjectItemBean mShareProject;
    private int pageIndex;

    public MoreDiscountModel(HeaderData headerData, String str) {
        this.mHeaderData = headerData;
        this.mCityId = o90.a(str);
    }

    static /* synthetic */ int access$008(MoreDiscountModel moreDiscountModel) {
        int i = moreDiscountModel.pageIndex;
        moreDiscountModel.pageIndex = i + 1;
        return i;
    }

    static /* synthetic */ int access$112(MoreDiscountModel moreDiscountModel, int i) {
        int i2 = moreDiscountModel.curCount + i;
        moreDiscountModel.curCount = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasMore(SearchResultBean searchResultBean) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-664078430") ? ((Boolean) ipChange.ipc$dispatch("-664078430", new Object[]{this, searchResultBean})).booleanValue() : (searchResultBean == null || o90.b(searchResultBean.projectInfo) || this.curCount >= searchResultBean.total) ? false : true;
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public boolean changeCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1947141742")) {
            return ((Boolean) ipChange.ipc$dispatch("1947141742", new Object[]{this, str})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public ProjectItemBean firstProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2075368029") ? (ProjectItemBean) ipChange.ipc$dispatch("-2075368029", new Object[]{this}) : this.mShareProject;
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public String getCityId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1727385208") ? (String) ipChange.ipc$dispatch("-1727385208", new Object[]{this}) : this.mCityId;
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public HeaderData getHeaderData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-376260428") ? (HeaderData) ipChange.ipc$dispatch("-376260428", new Object[]{this}) : this.mHeaderData;
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void load(final BaseListener<FirstPageData> baseListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1524426566")) {
            ipChange.ipc$dispatch("-1524426566", new Object[]{this, baseListener});
            return;
        }
        this.mLastItem = null;
        this.mShareProject = null;
        this.pageIndex = 1;
        this.curCount = 0;
        addBusiness(SearchListRequest.request(this.mCityId, true, 1, new BaseListener<SearchResultBean>() { // from class: cn.damai.category.discountticket.model.MoreDiscountModel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.category.discountticket.model.BaseListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-122137094")) {
                    ipChange2.ipc$dispatch("-122137094", new Object[]{this, str, str2});
                } else {
                    baseListener.onFail(str, str2);
                }
            }

            @Override // cn.damai.category.discountticket.model.BaseListener
            public void onSuccess(SearchResultBean searchResultBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-135153604")) {
                    ipChange2.ipc$dispatch("-135153604", new Object[]{this, searchResultBean});
                } else if (searchResultBean != null) {
                    MoreDiscountModel.access$008(MoreDiscountModel.this);
                    List<ProjectItemBean> list = searchResultBean.projectInfo;
                    MoreDiscountModel.this.curCount = wh2.e(list);
                    boolean hasMore = MoreDiscountModel.this.hasMore(searchResultBean);
                    ArrayList arrayList = new ArrayList();
                    if (MoreDiscountModel.this.mHeaderData != null && !TextUtils.isEmpty(MoreDiscountModel.this.mHeaderData.tempTitle)) {
                        arrayList.add(new DiscountTipBean(MoreDiscountModel.this.mHeaderData.tempTitle, null));
                    }
                    if (!o90.b(list)) {
                        MoreDiscountModel.this.mShareProject = list.get(0);
                        List<Column3WrapBean> adapterList = Column3WrapBean.toAdapterList(list);
                        if (!o90.b(adapterList)) {
                            MoreDiscountModel.this.mLastItem = adapterList.get(adapterList.size() - 1);
                            arrayList.addAll(adapterList);
                        }
                    }
                    FirstPageData firstPageData = new FirstPageData(true, null, null);
                    firstPageData.data = arrayList;
                    firstPageData.headerData = MoreDiscountModel.this.mHeaderData;
                    firstPageData.hasMore = hasMore;
                    baseListener.onSuccess(firstPageData);
                } else {
                    onFail("", "");
                }
            }
        }));
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void loadMore(final OnTListener<MorePageData> onTListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2111955")) {
            ipChange.ipc$dispatch("2111955", new Object[]{this, onTListener});
        } else {
            addBusiness(SearchListRequest.request(this.mCityId, true, this.pageIndex, new BaseListener<SearchResultBean>() { // from class: cn.damai.category.discountticket.model.MoreDiscountModel.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.category.discountticket.model.BaseListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-129896453")) {
                        ipChange2.ipc$dispatch("-129896453", new Object[]{this, str, str2});
                    } else {
                        onTListener.callBack(new MorePageData(false, str, str2));
                    }
                }

                @Override // cn.damai.category.discountticket.model.BaseListener
                public void onSuccess(SearchResultBean searchResultBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "819075291")) {
                        ipChange2.ipc$dispatch("819075291", new Object[]{this, searchResultBean});
                        return;
                    }
                    MoreDiscountModel.access$008(MoreDiscountModel.this);
                    List<ProjectItemBean> list = searchResultBean.projectInfo;
                    MoreDiscountModel.access$112(MoreDiscountModel.this, wh2.e(list));
                    boolean hasMore = MoreDiscountModel.this.hasMore(searchResultBean);
                    if (MoreDiscountModel.this.mLastItem != null) {
                        list = MoreDiscountModel.this.mLastItem.supply(list);
                    }
                    List<Column3WrapBean> adapterList = Column3WrapBean.toAdapterList(list);
                    if (!o90.b(adapterList)) {
                        MoreDiscountModel.this.mLastItem = adapterList.get(adapterList.size() - 1);
                    }
                    MorePageData morePageData = new MorePageData(true, null, null);
                    morePageData.data = adapterList;
                    morePageData.hasMore = hasMore;
                    onTListener.callBack(morePageData);
                }
            }));
        }
    }
}
