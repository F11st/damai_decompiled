package cn.damai.seat.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionBean;
import cn.damai.seat.R$string;
import cn.damai.seat.bean.HeadBean;
import cn.damai.seat.bean.SeatProfile;
import cn.damai.seat.bean.UtDynamic;
import cn.damai.seat.bean.UtExtra;
import cn.damai.seat.bean.UtStatus;
import cn.damai.seat.bean.biz.CompressSeatStatus;
import cn.damai.seat.bean.biz.SeatDynamic;
import cn.damai.seat.contract.SeatContract;
import cn.damai.seat.helper.b;
import cn.damai.seat.listener.Action;
import cn.damai.seat.listener.OnSubmitListener;
import cn.damai.seat.listener.RegionSeatRequestChecker;
import cn.damai.seat.listener.SeatComputeListener;
import cn.damai.seat.listener.SimpleCallBack;
import cn.damai.seat.listener.net.MtopSeatDynamicListener;
import cn.damai.seat.listener.net.MtopStatusCompressListener;
import cn.damai.seat.listener.seatui.ApiType;
import cn.damai.seat.listener.seatui.OnJpgSeatUiListener;
import cn.damai.seat.request.MtopSeatDynamicRequest;
import cn.damai.seat.request.MtopStatusCompressRequest;
import cn.damai.seat.support.combine.OnSeatCombineListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.e92;
import tb.f92;
import tb.h61;
import tb.hs;
import tb.k92;
import tb.kn1;
import tb.l92;
import tb.o92;
import tb.r92;
import tb.ub;
import tb.w82;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SeatModel extends SeatModelImpl implements SeatContract.SeatModel, OnSeatCombineListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private SeatDynamic mDynamic;
    private l92 mOption;
    private TbParams mParams;
    private PriceLevel mPrice;
    private List<PriceLevel> mPriceList;
    private String mPrivilegeSkuIds;
    private Region mRegion;
    private RegionData mRegionData;
    private String mRegionId;
    private SeatProfile mSeat;
    private b mSeatBasket;
    private w82 mSeatCombiner;
    private h61 mUiListener = new h61();

    @Override // cn.damai.seat.contract.SeatContract.SeatModel
    public boolean changePrice(PriceLevel priceLevel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925122743")) {
            return ((Boolean) ipChange.ipc$dispatch("925122743", new Object[]{this, priceLevel, Integer.valueOf(i)})).booleanValue();
        }
        if (priceLevel == this.mPrice) {
            this.mPrice = null;
        } else {
            this.mPrice = priceLevel;
        }
        return true;
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatModel
    public boolean changeSeat(SeatNew seatNew, boolean z, Action action) {
        PriceLevel priceLevel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923390989")) {
            return ((Boolean) ipChange.ipc$dispatch("923390989", new Object[]{this, seatNew, Boolean.valueOf(z), action})).booleanValue();
        }
        boolean j = this.mSeatBasket.j(seatNew, z);
        if (z && j && (priceLevel = this.mPrice) != null && seatNew.priceLevel != priceLevel.getPriceId()) {
            this.mPrice = null;
            action.call();
        }
        return j;
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatModel
    public void computeSeat(SeatComputeListener seatComputeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "694900695")) {
            ipChange.ipc$dispatch("694900695", new Object[]{this, seatComputeListener});
        } else {
            this.mSeatBasket.l(seatComputeListener);
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatModel
    public TbParams getParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1222683270") ? (TbParams) ipChange.ipc$dispatch("1222683270", new Object[]{this}) : this.mParams;
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatModel
    public List<PriceLevel> getPriceList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-970749076") ? (List) ipChange.ipc$dispatch("-970749076", new Object[]{this}) : this.mPriceList;
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatModel
    public SeatProfile getSeatInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "112406972") ? (SeatProfile) ipChange.ipc$dispatch("112406972", new Object[]{this}) : this.mSeat;
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatModel
    public PriceLevel getSelectPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1494240340") ? (PriceLevel) ipChange.ipc$dispatch("-1494240340", new Object[]{this}) : this.mPrice;
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatModel
    public boolean isLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "531830061")) {
            return ((Boolean) ipChange.ipc$dispatch("531830061", new Object[]{this})).booleanValue();
        }
        w82 w82Var = this.mSeatCombiner;
        return (w82Var == null || !w82Var.isPrepared() || this.mDynamic == null) ? false : true;
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatModel
    public void load(boolean z, OnJpgSeatUiListener onJpgSeatUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1178685970")) {
            ipChange.ipc$dispatch("-1178685970", new Object[]{this, Boolean.valueOf(z), onJpgSeatUiListener});
            return;
        }
        this.mUiListener.a(onJpgSeatUiListener);
        TbParams tbParams = this.mParams;
        this.mOption = l92.g(tbParams.itemId, tbParams.performId, this.mRegionData, z, tbParams.xorPerformId);
        k92.r().h(this.mOption, new RequestListener<SeatBox, e92>() { // from class: cn.damai.seat.model.SeatModel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
            public void onFail(kn1<e92> kn1Var, String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-816815472")) {
                    ipChange2.ipc$dispatch("-816815472", new Object[]{this, kn1Var, str, str2});
                    return;
                }
                SeatModel seatModel = SeatModel.this;
                seatModel.pageAlarm(seatModel.mOption.d(), "JPG选座页", str, str2, "seatselect", null);
                SeatModel.this.mUiListener.onFail(222, str, str2, null);
                o92.l().w(UtExtra.fail(SeatModel.this.mParams, kn1Var, str, str2));
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
            public void onSuccess(kn1<e92> kn1Var, SeatBox seatBox) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "256782585")) {
                    ipChange2.ipc$dispatch("256782585", new Object[]{this, kn1Var, seatBox});
                    return;
                }
                SeatModel seatModel = SeatModel.this;
                seatModel.mSeat = new SeatProfile(seatBox.get(seatModel.mRegionId));
                SeatModel.this.mSeatBasket.g(seatBox.mPackageSeatMap);
                SeatModel.this.mSeatCombiner.e(seatBox);
                o92.l().w(UtExtra.success(SeatModel.this.mParams, kn1Var));
            }
        });
        refresh(onJpgSeatUiListener);
    }

    @Override // cn.damai.seat.model.SeatModelImpl, cn.damai.seat.contract.BaseSeatModel
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "18099555")) {
            ipChange.ipc$dispatch("18099555", new Object[]{this});
            return;
        }
        super.onDestroy();
        TbParams tbParams = this.mParams;
        if (tbParams != null && tbParams.isOpenSeatDirect()) {
            if (this.mOption != null) {
                k92 r = k92.r();
                r.q(this.mOption);
                r.b(this.mOption);
            }
            b bVar = this.mSeatBasket;
            if (bVar != null) {
                bVar.A();
            }
        }
        w82 w82Var = this.mSeatCombiner;
        if (w82Var != null) {
            w82Var.h();
        }
    }

    @Override // cn.damai.seat.support.combine.OnSeatCombineListener
    public void onSeatCombineFinish(RegionSeatRequestChecker regionSeatRequestChecker, SeatBox seatBox) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1336030498")) {
            ipChange.ipc$dispatch("-1336030498", new Object[]{this, regionSeatRequestChecker, seatBox});
            return;
        }
        r92.f("onSeatCombineFinish");
        if (this.mSeatBasket.D() != 51) {
            this.mUiListener.toast(R$string.seat_sold_reselect_tip);
        }
        this.mUiListener.showSeatUi(this.mSeat, getIconProvider(), this.mPrice, isLoadFinish());
        this.mUiListener.onSelectSeatChanged();
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatModel
    public void prepare(TbParams tbParams, SimpleCallBack<String> simpleCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251741589")) {
            ipChange.ipc$dispatch("1251741589", new Object[]{this, tbParams, simpleCallBack});
            return;
        }
        this.mParams = tbParams;
        initPageAlarmExt(tbParams);
        this.mRegionData = new hs().a(tbParams.xorPerformId);
        if (TextUtils.isEmpty(tbParams.openRegionId)) {
            this.mRegion = f92.j(this.mRegionData);
        } else {
            this.mRegion = f92.C(tbParams.openRegionId, this.mRegionData);
        }
        RegionData regionData = this.mRegionData;
        if (regionData != null && regionData.checkBaseValid() && this.mRegion != null) {
            this.mRegionId = this.mRegion.id + "";
            newIconProvider(3);
            b a = tbParams.isOpenSeatDirect() ? ub.a(tbParams.basketNo, this.mParams) : ub.b(this.mParams);
            this.mSeatBasket = a;
            RegionData regionData2 = this.mRegionData;
            ArrayList<Region> arrayList = regionData2.ri.regionList;
            TbParams tbParams2 = this.mParams;
            a.f(arrayList, tbParams2.limitCount, tbParams2.itemLimitPerOrder, regionData2.isNeedPreCheck);
            TbParams tbParams3 = this.mParams;
            this.mSeatCombiner = new w82(this, tbParams3.itemId, tbParams3.performId, this.mRegionData.ri.vesion);
            if (!this.mParams.isOpenSeatDirect()) {
                this.mPrice = f92.D(this.mParams.itemId);
            }
            TbParams tbParams4 = this.mParams;
            this.mPrivilegeSkuIds = f92.p(tbParams4.privilegeId, tbParams4.itemId, tbParams4.firstPayChooseSeat);
            simpleCallBack.onSuccess(this.mRegion.name);
            return;
        }
        pageAlarm("", "JPG选座页", "", "区域或者场次数据异常，请重试[预加载]", "seatselect", null);
        simpleCallBack.onFail("", "区域或者场次数据异常，请重试");
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatModel
    public PromotionDataBean promotion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1472513610")) {
            return (PromotionDataBean) ipChange.ipc$dispatch("-1472513610", new Object[]{this});
        }
        SeatDynamic seatDynamic = this.mDynamic;
        if (seatDynamic == null || !seatDynamic.showPromotion()) {
            return null;
        }
        long j = this.mParams.itemId;
        PromotionBean promotionBean = this.mDynamic.promotionDetail;
        return new PromotionDataBean("preferentialexplain", j, promotionBean.promotionGroupList, promotionBean.promotionRemark, null, null);
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatModel
    public void refresh(OnJpgSeatUiListener onJpgSeatUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "346509113")) {
            ipChange.ipc$dispatch("346509113", new Object[]{this, onJpgSeatUiListener});
            return;
        }
        this.mUiListener.a(onJpgSeatUiListener);
        this.mSeatCombiner.removeDynamic();
        this.mDynamic = null;
        TbParams tbParams = this.mParams;
        MtopStatusCompressRequest mtopStatusCompressRequest = new MtopStatusCompressRequest(tbParams.itemId, tbParams.projectId, tbParams.performId, this.mRegionData.ri.vesion, this.mRegionId, this.mSeatBasket.p());
        TbParams tbParams2 = this.mParams;
        addBusiness(mtopStatusCompressRequest.request(new MtopStatusCompressListener(tbParams2.itemId, tbParams2.performId) { // from class: cn.damai.seat.model.SeatModel.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.seat.listener.net.OnNetBizListener
            public void onNetFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1517636376")) {
                    ipChange2.ipc$dispatch("-1517636376", new Object[]{this, str, str2});
                    return;
                }
                SeatModel.this.pageAlarm("mtop.damai.wireless.seat.queryperformseatstatus", "JPG选座页", str, str2, "seatselect", null);
                SeatModel.this.mUiListener.onFail(333, str, str2, null);
                o92.l().x(new UtStatus(false, SeatModel.this.mParams, str, str2));
            }

            @Override // cn.damai.seat.listener.net.OnNetBizListener
            public void onNetSuccess(@NonNull CompressSeatStatus compressSeatStatus) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1838314055")) {
                    ipChange2.ipc$dispatch("1838314055", new Object[]{this, compressSeatStatus});
                    return;
                }
                SeatModel.this.mSeatCombiner.g(compressSeatStatus);
                o92.l().x(new UtStatus(true, SeatModel.this.mParams, null, null));
            }
        }));
        TbParams tbParams3 = this.mParams;
        MtopSeatDynamicRequest mtopSeatDynamicRequest = new MtopSeatDynamicRequest(tbParams3.projectId, tbParams3.itemId, tbParams3.performId, null, tbParams3.privilegeId, this.mPrivilegeSkuIds, tbParams3.hasPromotion);
        TbParams tbParams4 = this.mParams;
        addBusiness(mtopSeatDynamicRequest.request(new MtopSeatDynamicListener(tbParams4.itemId, tbParams4.performId) { // from class: cn.damai.seat.model.SeatModel.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.seat.listener.net.OnNetBizListener
            public void onNetFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-748466361")) {
                    ipChange2.ipc$dispatch("-748466361", new Object[]{this, str, str2});
                    return;
                }
                SeatModel.this.pageAlarm("mtop.damai.wireless.seat.dynamicInfo", "JPG选座页", str, str2, "seatselect", null);
                SeatModel.this.mUiListener.onFail(ApiType.API_DYNAMIC, str, str2, null);
                o92.l().u(new UtDynamic(false, SeatModel.this.mParams, str, str2));
            }

            @Override // cn.damai.seat.listener.net.OnNetBizListener
            public void onNetSuccess(@NonNull SeatDynamic seatDynamic) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2113652521")) {
                    ipChange2.ipc$dispatch("-2113652521", new Object[]{this, seatDynamic});
                    return;
                }
                SeatModel.this.mDynamic = seatDynamic;
                SeatModel.this.mSeatBasket.h(seatDynamic.needCalc(), seatDynamic.calcFailSafe(), seatDynamic.calculateTag(), seatDynamic.getPriceManager());
                List<PriceLevel> E = f92.E(SeatModel.this.mDynamic.priceList);
                SeatModel seatModel = SeatModel.this;
                seatModel.mPriceList = f92.h(E, seatModel.mRegion);
                SeatModel seatModel2 = SeatModel.this;
                seatModel2.mPrice = f92.B(seatModel2.mPriceList, SeatModel.this.mPrice);
                SeatModel.this.mUiListener.showPriceList(SeatModel.this.mPriceList, SeatModel.this.mPrice, SeatModel.this.getIconProvider());
                SeatModel.this.mSeatCombiner.f(seatDynamic.getPriceManager());
                SeatModel.this.mUiListener.showHeadView(new HeadBean(seatDynamic, false));
                if (f92.A(SeatModel.this.mPriceList)) {
                    SeatModel.this.mUiListener.toast(R$string.seat_sold_out_tip);
                }
                SeatModel seatModel3 = SeatModel.this;
                seatModel3.utExposureDiscountInfo("seatselect", seatModel3.mParams.itemId, seatDynamic.getSkuPromotionRelations());
                o92.l().u(new UtDynamic(true, SeatModel.this.mParams, null, null));
            }
        }));
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatModel
    public boolean shouldShowDiffRowTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2022331654")) {
            return ((Boolean) ipChange.ipc$dispatch("-2022331654", new Object[]{this})).booleanValue();
        }
        RegionData regionData = this.mRegionData;
        return regionData != null && regionData.sameRowNotify && this.mSeatBasket.w();
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatModel
    public void submitSeat(OnSubmitListener onSubmitListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1018631589")) {
            ipChange.ipc$dispatch("-1018631589", new Object[]{this, onSubmitListener});
        } else {
            this.mSeatBasket.C(onSubmitListener);
        }
    }
}
