package cn.damai.seat.model;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ClickedPerform;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net.MtopRegionDataListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.request.MtopBBCAreaInfoRequest;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionBean;
import cn.damai.seat.R$string;
import cn.damai.seat.bean.HeadBean;
import cn.damai.seat.bean.biz.Price;
import cn.damai.seat.bean.biz.SeatDynamic;
import cn.damai.seat.contract.RegionContract;
import cn.damai.seat.helper.b;
import cn.damai.seat.listener.OnPerformListener;
import cn.damai.seat.listener.SimpleCallBack;
import cn.damai.seat.listener.net.ImageListener;
import cn.damai.seat.listener.net.MtopSeatDynamicListener;
import cn.damai.seat.listener.seatui.ApiType;
import cn.damai.seat.listener.seatui.OnJpgRegionUiListener;
import cn.damai.seat.request.MtopSeatDynamicRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.cr;
import tb.f92;
import tb.fr1;
import tb.g61;
import tb.hs;
import tb.kn1;
import tb.l11;
import tb.p11;
import tb.q92;
import tb.r11;
import tb.u01;
import tb.ub;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RegionModel extends SeatModelImpl implements RegionContract.RegionModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private SeatDynamic mDynamic;
    private r11 mJpgOption;
    private TbParams mParams;
    private List<Price> mPriceList;
    private String mPrivilegeSkuIds;
    private RegionData mRegionData;
    private List<Region> mRegions;
    private b mSeatBasket;
    private PriceLevel mSelected;
    private g61 mUiListener = new g61();
    private Map<String, String> pageAlarmExt = new HashMap();
    private Bitmap venueImage;

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public void changePerform(@NonNull final ClickedPerform clickedPerform, final OnPerformListener onPerformListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1189075699")) {
            ipChange.ipc$dispatch("-1189075699", new Object[]{this, clickedPerform, onPerformListener});
        } else if (!clickedPerform.isHasPerform() || onPerformListener == null) {
        } else {
            long j = clickedPerform.perform.performId;
            if ((j == this.mParams.performId) && isLoadFinish()) {
                PriceLevel n = f92.n(clickedPerform.price, this.mPriceList);
                if (n == null || !n.isSalable() || n == this.mSelected) {
                    return;
                }
                this.mSelected = n;
                onPerformListener.onPriceChangedOnly();
                return;
            }
            onPerformListener.doNetWork(true);
            loadRegionData(j, new SimpleCallBack<RegionData>() { // from class: cn.damai.seat.model.RegionModel.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.seat.listener.SimpleCallBack
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2017456196")) {
                        ipChange2.ipc$dispatch("2017456196", new Object[]{this, str, str2});
                        return;
                    }
                    onPerformListener.doNetWork(false);
                    onPerformListener.onNetFail(str, str2);
                }

                @Override // cn.damai.seat.listener.SimpleCallBack
                public void onSuccess(RegionData regionData) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-81710454")) {
                        ipChange2.ipc$dispatch("-81710454", new Object[]{this, regionData});
                        return;
                    }
                    onPerformListener.doNetWork(false);
                    ClickedPerform clickedPerform2 = clickedPerform;
                    long c = f92.c(clickedPerform2.basic.itemId, clickedPerform2.perform.performId);
                    TbParams tbParams = RegionModel.this.mParams;
                    ClickedPerform clickedPerform3 = clickedPerform;
                    TbParams tbParams2 = new TbParams(tbParams, clickedPerform3.basic, clickedPerform3.perform, clickedPerform3.appNewUlTron(), clickedPerform.h5NewUlTron());
                    tbParams2.skuId = c;
                    onPerformListener.onPerformChanged(tbParams2, regionData.isSmallVenue());
                }
            });
        }
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public TbParams createParams2SeatPage(Region region) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-178455292")) {
            return (TbParams) ipChange.ipc$dispatch("-178455292", new Object[]{this, region});
        }
        TbParams tbParams = new TbParams(this.mParams);
        tbParams.basketNo = this.mSeatBasket.b;
        tbParams.openRegionId = region.id + "";
        return tbParams;
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public TbParams getParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1225338313") ? (TbParams) ipChange.ipc$dispatch("-1225338313", new Object[]{this}) : this.mParams;
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public List<? extends PriceLevel> getPriceList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2021870373") ? (List) ipChange.ipc$dispatch("-2021870373", new Object[]{this}) : this.mPriceList;
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public List<Region> getRegions() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2138473939") ? (List) ipChange.ipc$dispatch("2138473939", new Object[]{this}) : this.mRegions;
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public PriceLevel getSelectPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1956623067") ? (PriceLevel) ipChange.ipc$dispatch("1956623067", new Object[]{this}) : this.mSelected;
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public boolean isLoadFinish() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-850388066") ? ((Boolean) ipChange.ipc$dispatch("-850388066", new Object[]{this})).booleanValue() : (this.venueImage == null || this.mDynamic == null) ? false : true;
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public void load(boolean z, OnJpgRegionUiListener onJpgRegionUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "157344080")) {
            ipChange.ipc$dispatch("157344080", new Object[]{this, Boolean.valueOf(z), onJpgRegionUiListener});
            return;
        }
        this.mUiListener.a(onJpgRegionUiListener);
        this.mJpgOption = r11.h(z, this.mRegionData.ri.seatImg, this.mParams.xorPerformId);
        p11 t = p11.t();
        TbParams tbParams = this.mParams;
        t.r(new ImageListener(tbParams.itemId, tbParams.performId) { // from class: cn.damai.seat.model.RegionModel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.seat.listener.net.ImageListener
            public void onNetFail(kn1<l11> kn1Var, String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1563860760")) {
                    ipChange2.ipc$dispatch("-1563860760", new Object[]{this, kn1Var, str, str2});
                    return;
                }
                RegionModel.this.pageAlarm("", "JPG选区页", str, str2, q92.PAGE_AREA, null);
                RegionModel.this.mUiListener.onFail(111, str, str2, null);
            }

            @Override // cn.damai.seat.listener.net.ImageListener
            public void onNetSuccess(kn1<l11> kn1Var, ImageData imageData) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2075091694")) {
                    ipChange2.ipc$dispatch("-2075091694", new Object[]{this, kn1Var, imageData});
                    return;
                }
                RegionModel.this.venueImage = imageData.getJPG();
                RegionModel.this.mUiListener.showRegionUi(RegionModel.this.venueImage, RegionModel.this.mRegions, RegionModel.this.mSelected, RegionModel.this.isLoadFinish());
            }
        }, this.mJpgOption);
        refresh(onJpgRegionUiListener);
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public void loadRegionData(long j, final SimpleCallBack<RegionData> simpleCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "687253331")) {
            ipChange.ipc$dispatch("687253331", new Object[]{this, Long.valueOf(j), simpleCallBack});
            return;
        }
        u01.c(this.mParams.itemId, j, false);
        String str = this.mParams.cityId;
        long a = fr1.a(j);
        addBusiness(new MtopBBCAreaInfoRequest(str, a, (String) null, cr.c()).request(new MtopRegionDataListener(this.mParams.itemId, str, j, a) { // from class: cn.damai.seat.model.RegionModel.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net.MtopRegionDataListener
            public void onBizFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1370273280")) {
                    ipChange2.ipc$dispatch("-1370273280", new Object[]{this, str2, str3});
                    return;
                }
                RegionModel.this.pageAlarm("mtop.damai.wireless.project.getB2B2CAreaInfo", "JPG选区页", str2, str3, q92.PAGE_AREA, null);
                simpleCallBack.onFail(str2, str3);
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net.MtopRegionDataListener
            public void onRegionData(@NonNull RegionData regionData) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2133375552")) {
                    ipChange2.ipc$dispatch("2133375552", new Object[]{this, regionData});
                } else {
                    simpleCallBack.onSuccess(regionData);
                }
            }
        }));
    }

    @Override // cn.damai.seat.model.SeatModelImpl, cn.damai.seat.contract.BaseSeatModel
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-875223918")) {
            ipChange.ipc$dispatch("-875223918", new Object[]{this});
            return;
        }
        super.onDestroy();
        if (this.mJpgOption != null) {
            p11 t = p11.t();
            t.q(this.mJpgOption);
            t.b(this.mJpgOption);
        }
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public void onPriceSelectChanged(PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829154982")) {
            ipChange.ipc$dispatch("-1829154982", new Object[]{this, priceLevel});
        } else if (priceLevel == this.mSelected) {
            this.mSelected = null;
        } else {
            this.mSelected = priceLevel;
        }
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public void prepare(TbParams tbParams, SimpleCallBack<TbParams> simpleCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752700282")) {
            ipChange.ipc$dispatch("-1752700282", new Object[]{this, tbParams, simpleCallBack});
            return;
        }
        this.mParams = tbParams;
        initPageAlarmExt(tbParams);
        this.mRegionData = new hs().a(tbParams.xorPerformId);
        this.mSeatBasket = ub.b(tbParams);
        RegionData regionData = this.mRegionData;
        if (regionData != null && regionData.checkBaseValid()) {
            newIconProvider(3);
            this.mRegions = new ArrayList(this.mRegionData.ri.regionList);
            this.mSelected = f92.D(this.mParams.itemId);
            TbParams tbParams2 = this.mParams;
            this.mPrivilegeSkuIds = f92.p(tbParams2.privilegeId, tbParams2.itemId, tbParams2.firstPayChooseSeat);
            simpleCallBack.onSuccess(this.mParams);
            return;
        }
        pageAlarm("", "JPG选区页", "", "数据异常，请退出重试![预加载]", q92.PAGE_AREA, null);
        simpleCallBack.onFail("", "麦麦开小差了，请稍后重试哦");
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public PromotionDataBean promotion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1869930393")) {
            return (PromotionDataBean) ipChange.ipc$dispatch("-1869930393", new Object[]{this});
        }
        SeatDynamic seatDynamic = this.mDynamic;
        if (seatDynamic == null || !seatDynamic.showPromotion()) {
            return null;
        }
        long j = this.mParams.itemId;
        PromotionBean promotionBean = this.mDynamic.promotionDetail;
        return new PromotionDataBean("preferentialexplain", j, promotionBean.promotionGroupList, promotionBean.promotionRemark, null, null);
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public void refresh(OnJpgRegionUiListener onJpgRegionUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1458500507")) {
            ipChange.ipc$dispatch("1458500507", new Object[]{this, onJpgRegionUiListener});
            return;
        }
        this.mUiListener.a(onJpgRegionUiListener);
        this.mDynamic = null;
        TbParams tbParams = this.mParams;
        MtopSeatDynamicRequest mtopSeatDynamicRequest = new MtopSeatDynamicRequest(tbParams.projectId, tbParams.itemId, tbParams.performId, null, tbParams.privilegeId, this.mPrivilegeSkuIds, tbParams.hasPromotion);
        TbParams tbParams2 = this.mParams;
        addBusiness(mtopSeatDynamicRequest.request(new MtopSeatDynamicListener(tbParams2.itemId, tbParams2.performId) { // from class: cn.damai.seat.model.RegionModel.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.seat.listener.net.OnNetBizListener
            public void onNetFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "906481879")) {
                    ipChange2.ipc$dispatch("906481879", new Object[]{this, str, str2});
                    return;
                }
                RegionModel.this.pageAlarm("mtop.damai.wireless.seat.dynamicInfo", "JPG选区页", str, str2, q92.PAGE_AREA, null);
                RegionModel.this.mUiListener.onFail(ApiType.API_DYNAMIC, str, str2, null);
            }

            @Override // cn.damai.seat.listener.net.OnNetBizListener
            public void onNetSuccess(@NonNull SeatDynamic seatDynamic) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1480225465")) {
                    ipChange2.ipc$dispatch("-1480225465", new Object[]{this, seatDynamic});
                    return;
                }
                RegionModel.this.mDynamic = seatDynamic;
                RegionModel regionModel = RegionModel.this;
                regionModel.mPriceList = regionModel.mDynamic.priceList;
                RegionModel regionModel2 = RegionModel.this;
                regionModel2.mSelected = f92.B(regionModel2.mPriceList, RegionModel.this.mSelected);
                RegionModel.this.mDynamic.updateRegions(RegionModel.this.mRegions);
                RegionModel.this.mUiListener.showPriceList(RegionModel.this.mPriceList, RegionModel.this.mSelected, RegionModel.this.getIconProvider());
                RegionModel.this.mUiListener.showHeadView(new HeadBean(RegionModel.this.mDynamic, true));
                RegionModel.this.mUiListener.showRegionUi(RegionModel.this.venueImage, RegionModel.this.mRegions, RegionModel.this.mSelected, RegionModel.this.isLoadFinish());
                if (f92.A(RegionModel.this.mPriceList)) {
                    RegionModel.this.mUiListener.toast(R$string.seat_sold_out_tip);
                }
                RegionModel regionModel3 = RegionModel.this;
                regionModel3.utExposureDiscountInfo(q92.PAGE_AREA, regionModel3.mParams.itemId, RegionModel.this.mDynamic.getSkuPromotionRelations());
            }
        }));
    }
}
