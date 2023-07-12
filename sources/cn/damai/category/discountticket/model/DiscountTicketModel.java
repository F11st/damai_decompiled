package cn.damai.category.discountticket.model;

import android.text.TextUtils;
import cn.damai.category.discountticket.bean.CommonDiscountData;
import cn.damai.category.discountticket.bean.CouponListRes;
import cn.damai.category.discountticket.bean.DiscountResData;
import cn.damai.category.discountticket.bean.HeaderCouponBean;
import cn.damai.category.discountticket.bean.HeaderData;
import cn.damai.category.discountticket.bean.NearDiscountData;
import cn.damai.category.discountticket.bean.biz.BannerBean;
import cn.damai.category.discountticket.bean.biz.BannerWrap;
import cn.damai.category.discountticket.bean.biz.Column3WrapBean;
import cn.damai.category.discountticket.bean.biz.DiscountTipBean;
import cn.damai.category.discountticket.bean.biz.FirstPageData;
import cn.damai.category.discountticket.bean.biz.MorePageData;
import cn.damai.category.discountticket.bean.biz.ViewMoreBean;
import cn.damai.category.discountticket.request.DiscountTicketWrapRequest;
import cn.damai.category.discountticket.request.SearchListRequest;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.o90;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DiscountTicketModel extends BaseDiscountModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private String mCityId;
    private CouponListRes mCouponListRes;
    private HeaderData mHeaderData;
    private DiscountResData mResData;
    private ProjectItemBean mShareProject;
    private int pageIndex = 1;
    private int curCount = 0;

    public DiscountTicketModel(String str) {
        this.mCityId = TextUtils.isEmpty(str) ? z20.c() : str;
    }

    static /* synthetic */ int access$008(DiscountTicketModel discountTicketModel) {
        int i = discountTicketModel.pageIndex;
        discountTicketModel.pageIndex = i + 1;
        return i;
    }

    static /* synthetic */ int access$512(DiscountTicketModel discountTicketModel, int i) {
        int i2 = discountTicketModel.curCount + i;
        discountTicketModel.curCount = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FirstPageData formatFirstPageData(DiscountResData discountResData, CouponListRes couponListRes) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "757761213")) {
            return (FirstPageData) ipChange.ipc$dispatch("757761213", new Object[]{this, discountResData, couponListRes});
        }
        String str3 = null;
        FirstPageData firstPageData = new FirstPageData(true, null, null);
        ArrayList arrayList = new ArrayList();
        firstPageData.headerData = discountResData.headerData;
        boolean hasCoupons = couponListRes.hasCoupons();
        NearDiscountData nearDiscountData = discountResData.nearDiscountData;
        if (hasCoupons) {
            if (nearDiscountData != null) {
                str3 = nearDiscountData.title;
                str = nearDiscountData.shortDesc;
                str2 = nearDiscountData.ruleUrl;
            } else {
                str = null;
                str2 = null;
            }
            arrayList.add(new HeaderCouponBean(str3, str, str2, couponListRes.couponActivities));
        }
        if (nearDiscountData != null) {
            List<ProjectItemBean> list = nearDiscountData.nearDiscountItems;
            o90.c(0, list);
            List<Column3WrapBean> adapterList = Column3WrapBean.toAdapterList(list);
            if (wh2.e(adapterList) > 0) {
                arrayList.addAll(adapterList);
            }
            if (nearDiscountData.hasMore) {
                arrayList.add(new ViewMoreBean());
            }
        }
        List<BannerBean> list2 = discountResData.bannerData;
        if (!o90.b(list2)) {
            arrayList.add(new BannerWrap(list2));
        }
        CommonDiscountData commonDiscountData = discountResData.commonDiscountData;
        if (commonDiscountData != null) {
            List<ProjectItemBean> list3 = commonDiscountData.commonDiscountItems;
            o90.c(0, list3);
            if (wh2.e(list3) > 0) {
                if (arrayList.size() > 0) {
                    arrayList.add(new DiscountTipBean(commonDiscountData.title, commonDiscountData.desc));
                }
                arrayList.addAll(list3);
            }
            firstPageData.hasMore = commonDiscountData.hasMore;
        }
        firstPageData.data = arrayList;
        return firstPageData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHasMore(SearchResultBean searchResultBean) {
        List<ProjectItemBean> list;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1906238179") ? ((Boolean) ipChange.ipc$dispatch("1906238179", new Object[]{this, searchResultBean})).booleanValue() : (searchResultBean == null || (list = searchResultBean.projectInfo) == null || list.size() == 0 || this.curCount >= searchResultBean.total) ? false : true;
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public boolean changeCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-644953641")) {
            return ((Boolean) ipChange.ipc$dispatch("-644953641", new Object[]{this, str})).booleanValue();
        }
        if (TextUtils.equals(str, this.mCityId)) {
            return false;
        }
        this.mCityId = str;
        return true;
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public ProjectItemBean firstProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "318901964") ? (ProjectItemBean) ipChange.ipc$dispatch("318901964", new Object[]{this}) : this.mShareProject;
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public String getCityId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1128394383") ? (String) ipChange.ipc$dispatch("-1128394383", new Object[]{this}) : this.mCityId;
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public HeaderData getHeaderData() {
        DiscountResData discountResData;
        NearDiscountData nearDiscountData;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067621859")) {
            return (HeaderData) ipChange.ipc$dispatch("-2067621859", new Object[]{this});
        }
        HeaderData headerData = this.mHeaderData;
        if (headerData != null && (discountResData = this.mResData) != null && (nearDiscountData = discountResData.nearDiscountData) != null) {
            headerData.tempTitle = nearDiscountData.title;
        }
        return headerData;
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void load(final BaseListener<FirstPageData> baseListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-962757711")) {
            ipChange.ipc$dispatch("-962757711", new Object[]{this, baseListener});
            return;
        }
        this.pageIndex = 1;
        this.curCount = 0;
        addBusiness(new DiscountTicketWrapRequest(this.mCityId, new DiscountTicketWrapRequest.OnWrapListener() { // from class: cn.damai.category.discountticket.model.DiscountTicketModel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.category.discountticket.request.DiscountTicketWrapRequest.OnWrapListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1357213091")) {
                    ipChange2.ipc$dispatch("1357213091", new Object[]{this, str, str2});
                } else {
                    baseListener.onFail(str, str2);
                }
            }

            @Override // cn.damai.category.discountticket.request.DiscountTicketWrapRequest.OnWrapListener
            public void onRes(DiscountResData discountResData, CouponListRes couponListRes) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "88829610")) {
                    ipChange2.ipc$dispatch("88829610", new Object[]{this, discountResData, couponListRes});
                    return;
                }
                DiscountTicketModel.access$008(DiscountTicketModel.this);
                DiscountTicketModel.this.mResData = discountResData;
                DiscountTicketModel.this.mCouponListRes = couponListRes;
                DiscountTicketModel.this.mHeaderData = discountResData.headerData;
                DiscountTicketModel.this.mShareProject = discountResData.getFirstProject();
                DiscountTicketModel.this.curCount = discountResData.getUnNearProjectCount();
                DiscountTicketModel discountTicketModel = DiscountTicketModel.this;
                baseListener.onSuccess(discountTicketModel.formatFirstPageData(discountTicketModel.mResData, DiscountTicketModel.this.mCouponListRes));
            }
        }).g());
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void loadMore(final OnTListener<MorePageData> onTListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513613956")) {
            ipChange.ipc$dispatch("-513613956", new Object[]{this, onTListener});
        } else {
            addBusiness(SearchListRequest.request(this.mCityId, false, this.pageIndex, new BaseListener<SearchResultBean>() { // from class: cn.damai.category.discountticket.model.DiscountTicketModel.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.category.discountticket.model.BaseListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1349453732")) {
                        ipChange2.ipc$dispatch("1349453732", new Object[]{this, str, str2});
                    } else {
                        onTListener.callBack(new MorePageData(false, str, str));
                    }
                }

                @Override // cn.damai.category.discountticket.model.BaseListener
                public void onSuccess(SearchResultBean searchResultBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2027001042")) {
                        ipChange2.ipc$dispatch("2027001042", new Object[]{this, searchResultBean});
                        return;
                    }
                    DiscountTicketModel.access$008(DiscountTicketModel.this);
                    List<ProjectItemBean> list = searchResultBean.projectInfo;
                    o90.c(DiscountTicketModel.this.curCount, list);
                    MorePageData morePageData = new MorePageData(true, null, null);
                    morePageData.data = list;
                    DiscountTicketModel.access$512(DiscountTicketModel.this, wh2.e(list));
                    morePageData.hasMore = DiscountTicketModel.this.isHasMore(searchResultBean);
                    onTListener.callBack(morePageData);
                }
            }));
        }
    }
}
