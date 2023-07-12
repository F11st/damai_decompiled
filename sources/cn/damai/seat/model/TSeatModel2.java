package cn.damai.seat.model;

import android.graphics.Picture;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeatData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeatExtInfo;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.PriceInfo;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionBean;
import cn.damai.seat.R$string;
import cn.damai.seat.bean.HeadBean;
import cn.damai.seat.bean.UtDynamic;
import cn.damai.seat.bean.UtExtra;
import cn.damai.seat.bean.UtStatus;
import cn.damai.seat.bean.biz.CompressSeatStatus;
import cn.damai.seat.bean.biz.Price;
import cn.damai.seat.bean.biz.SeatDynamic;
import cn.damai.seat.contract.TbSeatContract;
import cn.damai.seat.helper.b;
import cn.damai.seat.listener.Action;
import cn.damai.seat.listener.OnSubmitListener;
import cn.damai.seat.listener.RegionSeatRequestChecker;
import cn.damai.seat.listener.SeatComputeListener;
import cn.damai.seat.listener.SimpleCallBack;
import cn.damai.seat.listener.net.ImageListener;
import cn.damai.seat.listener.seatui.ApiType;
import cn.damai.seat.listener.seatui.OnSeatUiListener;
import cn.damai.seat.request.BufferUtil;
import cn.damai.seat.support.combine.OnPicCombineListener;
import cn.damai.seat.support.combine.OnSeatCombineListener;
import cn.damai.tool2.bufferkit.BufferListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.e92;
import tb.f92;
import tb.h82;
import tb.hs;
import tb.i82;
import tb.j82;
import tb.k82;
import tb.k92;
import tb.kn1;
import tb.l11;
import tb.l92;
import tb.ls1;
import tb.ms1;
import tb.mx1;
import tb.n82;
import tb.o92;
import tb.p11;
import tb.p92;
import tb.q82;
import tb.r11;
import tb.r92;
import tb.s92;
import tb.u92;
import tb.ud;
import tb.w82;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TSeatModel2 extends SeatModelImpl implements TbSeatContract.TbSeatModel, OnPicCombineListener, OnSeatCombineListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private SeatDynamic mDynamic;
    private r11[] mImgOptions;
    private TbParams mParams;
    private ls1 mPicCombiner;
    private PriceLevel mPrice;
    private Picture mPriceFilterPicture;
    private List<Price> mPriceList;
    private String mPrivilegeSkuIds;
    private RegionData mRegionData;
    private List<Region> mRegions;
    private q82 mSeat3DVrOption;
    private b mSeatBasket;
    private w82 mSeatCombiner;
    private l92 mSeatOption;
    private p92 mUiListener = new p92();
    private s92 mSeatViewData = new s92();

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSeatVrInfo(boolean z) {
        RegionSeatData regionSeatData;
        RegionSeatExtInfo regionSeatExtInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1661421153")) {
            ipChange.ipc$dispatch("-1661421153", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        RegionData regionData = this.mRegionData;
        if (regionData == null || (regionSeatData = regionData.regionSeatData) == null || !regionSeatData.has3dvrImg || (regionSeatExtInfo = regionSeatData.seatExtInfo) == null) {
            return;
        }
        this.mSeat3DVrOption = q82.g(regionSeatExtInfo.seat3dvrInfo, z, this.mParams.xorPerformId);
        h82.r().h(this.mSeat3DVrOption, new RequestListener<SeatBox, i82>() { // from class: cn.damai.seat.model.TSeatModel2.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
            public void onFail(kn1<i82> kn1Var, String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-402865169")) {
                    ipChange2.ipc$dispatch("-402865169", new Object[]{this, kn1Var, str, str2});
                    return;
                }
                r92.f("Seat VR Loader fail code" + str + " msg" + str2);
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
            public void onSuccess(kn1<i82> kn1Var, SeatBox seatBox) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1058284888")) {
                    ipChange2.ipc$dispatch("1058284888", new Object[]{this, kn1Var, seatBox});
                } else {
                    TSeatModel2.this.update3DVrData(seatBox);
                }
            }
        });
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public boolean changePrice(PriceLevel priceLevel, int i) {
        PriceLevel priceLevel2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1612445579")) {
            return ((Boolean) ipChange.ipc$dispatch("-1612445579", new Object[]{this, priceLevel, Integer.valueOf(i)})).booleanValue();
        }
        if (this.mPrice == priceLevel) {
            this.mPrice = null;
        } else {
            this.mPrice = priceLevel;
        }
        if (!this.mRegionData.isSmallVenue() && (priceLevel2 = this.mPrice) != null) {
            this.mPriceFilterPicture = this.mPicCombiner.b(priceLevel2);
        } else {
            this.mPriceFilterPicture = null;
        }
        return true;
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public boolean changeSeat(SeatNew seatNew, boolean z, Action action) {
        PriceLevel priceLevel;
        boolean z2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "825392143")) {
            return ((Boolean) ipChange.ipc$dispatch("825392143", new Object[]{this, seatNew, Boolean.valueOf(z), action})).booleanValue();
        }
        boolean j = this.mSeatBasket.j(seatNew, z);
        if (z && j && (priceLevel = this.mPrice) != null) {
            long j2 = seatNew.isPackaged ? seatNew.packagedPriceIndexId : seatNew.priceLevel;
            if (priceLevel.isFreeCombineTiaoPiao()) {
                z2 = !this.mPrice.getSubPriceIds().contains(Long.valueOf(j2));
            } else {
                z2 = j2 != this.mPrice.getPriceId();
            }
            if (z2) {
                this.mPrice = null;
                this.mPriceFilterPicture = null;
                action.call();
            }
        }
        return j;
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void computeSeat(SeatComputeListener seatComputeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372986279")) {
            ipChange.ipc$dispatch("-1372986279", new Object[]{this, seatComputeListener});
        } else {
            this.mSeatBasket.l(seatComputeListener);
        }
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public SeatNew getLastedSelectSeat() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-7122439") ? (SeatNew) ipChange.ipc$dispatch("-7122439", new Object[]{this}) : this.mSeatBasket.y();
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public TbParams getParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "268998852") ? (TbParams) ipChange.ipc$dispatch("268998852", new Object[]{this}) : this.mParams;
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public Picture getPriceFilterPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2055899658") ? (Picture) ipChange.ipc$dispatch("2055899658", new Object[]{this}) : this.mPriceFilterPicture;
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public List<? extends PriceLevel> getPriceList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-987590930") ? (List) ipChange.ipc$dispatch("-987590930", new Object[]{this}) : this.mPriceList;
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public PriceLevel getSelectPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1445520302") ? (PriceLevel) ipChange.ipc$dispatch("1445520302", new Object[]{this}) : this.mPrice;
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public s92 getViewData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "318494743") ? (s92) ipChange.ipc$dispatch("318494743", new Object[]{this}) : this.mSeatViewData;
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public boolean isLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529758229")) {
            return ((Boolean) ipChange.ipc$dispatch("-1529758229", new Object[]{this})).booleanValue();
        }
        w82 w82Var = this.mSeatCombiner;
        return w82Var != null && this.mPicCombiner != null && w82Var.isPrepared() && this.mPicCombiner.isPrepared();
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void load(final boolean z, OnSeatUiListener onSeatUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-524771735")) {
            ipChange.ipc$dispatch("-524771735", new Object[]{this, Boolean.valueOf(z), onSeatUiListener});
            return;
        }
        this.mUiListener.a(onSeatUiListener);
        TbParams tbParams = this.mParams;
        this.mSeatOption = l92.g(tbParams.itemId, tbParams.performId, this.mRegionData, z, tbParams.xorPerformId);
        r11[] f = r11.f(this.mRegionData, z, this.mParams.xorPerformId);
        this.mImgOptions = f;
        if (this.mSeatOption == null || f == null) {
            return;
        }
        k92.r().h(this.mSeatOption, new RequestListener<SeatBox, e92>() { // from class: cn.damai.seat.model.TSeatModel2.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
            public void onFail(kn1<e92> kn1Var, String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1258210926")) {
                    ipChange2.ipc$dispatch("-1258210926", new Object[]{this, kn1Var, str, str2});
                    return;
                }
                r92.f("SeatLoader fail code" + str + " msg" + str2);
                TSeatModel2 tSeatModel2 = TSeatModel2.this;
                tSeatModel2.pageAlarm(tSeatModel2.mSeatOption.d(), "SVG选座页", str, str2, "seatselect", null);
                TSeatModel2.this.mUiListener.onFail(222, str, str2, null);
                o92.l().w(UtExtra.fail(TSeatModel2.this.mParams, kn1Var, str, str2));
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
            public void onSuccess(kn1<e92> kn1Var, SeatBox seatBox) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2114626043")) {
                    ipChange2.ipc$dispatch("2114626043", new Object[]{this, kn1Var, seatBox});
                    return;
                }
                r92.f("SeatLoader success " + seatBox.getTotalSeatCount());
                TSeatModel2.this.mSeatBasket.g(seatBox.mPackageSeatMap);
                TSeatModel2.this.mSeatCombiner.e(seatBox);
                o92.l().w(UtExtra.success(TSeatModel2.this.mParams, kn1Var));
                TSeatModel2.this.loadSeatVrInfo(z);
            }
        });
        p11 t = p11.t();
        TbParams tbParams2 = this.mParams;
        t.r(new ImageListener(tbParams2.itemId, tbParams2.performId) { // from class: cn.damai.seat.model.TSeatModel2.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.seat.listener.net.ImageListener
            public void onNetFail(kn1<l11> kn1Var, String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1084613174")) {
                    ipChange2.ipc$dispatch("1084613174", new Object[]{this, kn1Var, str, str2});
                    return;
                }
                r92.f("ImageLoader fail code" + str + " msg" + str2);
                if (TSeatModel2.this.mRegionData != null && TSeatModel2.this.mRegionData.ri != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("rainbowSvgImg", TSeatModel2.this.mRegionData.ri.rainbowSvgImg);
                    TSeatModel2 tSeatModel2 = TSeatModel2.this;
                    tSeatModel2.pageAlarm(tSeatModel2.mRegionData.ri.seatSvgImg, "SVG选座页", str, str2, "seatselect", hashMap);
                }
                TSeatModel2.this.mUiListener.onFail(111, str, str2, kn1Var.d());
                o92.l().v(UtExtra.fail(TSeatModel2.this.mParams, kn1Var, str, str2));
            }

            @Override // cn.damai.seat.listener.net.ImageListener
            public void onNetSuccess(kn1<l11> kn1Var, ImageData imageData) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1756301088")) {
                    ipChange2.ipc$dispatch("-1756301088", new Object[]{this, kn1Var, imageData});
                    return;
                }
                r92.f("ImageLoader success");
                TSeatModel2.this.mPicCombiner.c(imageData);
                o92.l().v(UtExtra.success(TSeatModel2.this.mParams, kn1Var));
            }
        }, this.mImgOptions);
        refresh(onSeatUiListener);
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void load3DVrImageData(SeatNew seatNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1872284007")) {
            ipChange.ipc$dispatch("1872284007", new Object[]{this, seatNew});
        } else if (seatNew == null || seatNew.vr3DImg == null) {
        } else {
            s92 viewData = getViewData();
            RegionData regionData = viewData.i;
            n82 g = n82.g(true, regionData.xorPerformId, regionData.cityId, seatNew.sid, seatNew.kanTaiId, seatNew.vr3DImg.getImg(), seatNew.vr3DImg.getImgHash(), viewData.i.regionSeatData.seatExtInfo.seat3dvrInfo, u92.b().d());
            if (g != null) {
                k82.r().h(g, new RequestListener<ImageData, j82>() { // from class: cn.damai.seat.model.TSeatModel2.3
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
                    public void onFail(kn1<j82> kn1Var, String str, String str2) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "743675344")) {
                            ipChange2.ipc$dispatch("743675344", new Object[]{this, kn1Var, str, str2});
                        }
                    }

                    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
                    public void onSuccess(kn1<j82> kn1Var, ImageData imageData) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1043922938")) {
                            ipChange2.ipc$dispatch("1043922938", new Object[]{this, kn1Var, imageData});
                        }
                    }
                });
            }
        }
    }

    @Override // cn.damai.seat.model.SeatModelImpl, cn.damai.seat.contract.BaseSeatModel
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "114191717")) {
            ipChange.ipc$dispatch("114191717", new Object[]{this});
            return;
        }
        super.onDestroy();
        try {
            p92 p92Var = this.mUiListener;
            if (p92Var != null) {
                p92Var.a(null);
            }
            w82 w82Var = this.mSeatCombiner;
            if (w82Var != null) {
                w82Var.h();
            }
            b bVar = this.mSeatBasket;
            if (bVar != null) {
                bVar.A();
            }
            k92 r = k92.r();
            h82 r2 = h82.r();
            p11 t = p11.t();
            l92 l92Var = this.mSeatOption;
            if (l92Var != null) {
                r.b(l92Var);
                r.q(this.mSeatOption);
            }
            q82 q82Var = this.mSeat3DVrOption;
            if (q82Var != null) {
                r2.b(q82Var);
                r2.q(this.mSeat3DVrOption);
            }
            r11[] r11VarArr = this.mImgOptions;
            if (r11VarArr != null) {
                t.c(r11VarArr);
                t.s(this.mImgOptions);
            }
            TbParams tbParams = this.mParams;
            if (tbParams == null || !tbParams.firstPayChooseSeat) {
                return;
            }
            r.p();
            t.p();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // cn.damai.seat.support.combine.OnPicCombineListener
    public void onPicCombineFinish(ms1 ms1Var) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-919235913")) {
            ipChange.ipc$dispatch("-919235913", new Object[]{this, ms1Var});
            return;
        }
        r92.f("onPicCombineFinish");
        if (this.mPrice != null && !this.mRegionData.isSmallVenue()) {
            this.mPriceFilterPicture = this.mPicCombiner.b(this.mPrice);
        }
        this.mSeatViewData.b(ms1Var);
        this.mUiListener.showPriceList(this.mPriceList, this.mPrice, getIconProvider());
        this.mUiListener.showSeatUi(this.mSeatViewData, (this.mPicCombiner.isPrepared() && this.mSeatCombiner.isPrepared()) ? false : false);
    }

    @Override // cn.damai.seat.support.combine.OnSeatCombineListener
    public void onSeatCombineFinish(RegionSeatRequestChecker regionSeatRequestChecker, SeatBox seatBox) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-2133565984")) {
            ipChange.ipc$dispatch("-2133565984", new Object[]{this, regionSeatRequestChecker, seatBox});
            return;
        }
        r92.f("onSeatCombineFinish");
        if (this.mSeatBasket.D() != 51) {
            this.mUiListener.toast(R$string.seat_sold_reselect_tip);
        }
        this.mSeatViewData.a(regionSeatRequestChecker, seatBox);
        this.mUiListener.showSeatUi(this.mSeatViewData, (this.mPicCombiner.isPrepared() && this.mSeatCombiner.isPrepared()) ? false : false);
        this.mUiListener.onSelectSeatChanged();
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void prepare(@NonNull TbParams tbParams, SimpleCallBack<RegionData> simpleCallBack) {
        RegionSeatExtInfo regionSeatExtInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "278749011")) {
            ipChange.ipc$dispatch("278749011", new Object[]{this, tbParams, simpleCallBack});
            return;
        }
        this.mParams = tbParams;
        initPageAlarmExt(tbParams);
        RegionData a = new hs().a(tbParams.xorPerformId);
        this.mRegionData = a;
        if (a != null && a.checkBaseValid()) {
            newIconProvider(this.mRegionData.ri.seatStyle);
            this.mRegions = f92.g(this.mRegionData.ri.regionList);
            TbParams tbParams2 = this.mParams;
            this.mSeatCombiner = new w82(this, tbParams2.itemId, tbParams2.performId, this.mRegionData.ri.vesion);
            this.mPicCombiner = new ls1(this.mRegionData, this);
            this.mSeatViewData.c(getIconProvider(), this.mRegionData, this.mRegions);
            b bVar = new b(tbParams);
            this.mSeatBasket = bVar;
            List<Region> list = this.mRegions;
            TbParams tbParams3 = this.mParams;
            bVar.f(list, tbParams3.limitCount, tbParams3.itemLimitPerOrder, this.mRegionData.isNeedPreCheck);
            TbParams tbParams4 = this.mParams;
            if (!tbParams4.firstPayChooseSeat) {
                this.mPrice = f92.D(tbParams4.itemId);
            }
            TbParams tbParams5 = this.mParams;
            this.mPrivilegeSkuIds = f92.p(tbParams5.privilegeId, tbParams5.itemId, tbParams5.firstPayChooseSeat);
            RegionSeatData regionSeatData = this.mRegionData.regionSeatData;
            if (regionSeatData != null && (regionSeatExtInfo = regionSeatData.seatExtInfo) != null && regionSeatExtInfo.seat3dvrInfo != null) {
                u92.b().c(this.mRegionData.regionSeatData.seatExtInfo.seat3dvrInfo.imgDecrypt);
            }
            simpleCallBack.onSuccess(this.mRegionData);
            return;
        }
        pageAlarm("", "SVG选座页", "", "数据异常，请退出重试![预加载]", "seatselect", null);
        simpleCallBack.onFail("", "麦麦开小差了，请稍后重试哦");
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public PromotionDataBean promotion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-534246924")) {
            return (PromotionDataBean) ipChange.ipc$dispatch("-534246924", new Object[]{this});
        }
        SeatDynamic seatDynamic = this.mDynamic;
        if (seatDynamic == null || !seatDynamic.showPromotion()) {
            return null;
        }
        long j = this.mParams.itemId;
        PromotionBean promotionBean = this.mDynamic.promotionDetail;
        return new PromotionDataBean("preferentialexplain", j, promotionBean.promotionGroupList, promotionBean.promotionRemark, null, null);
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void refresh(OnSeatUiListener onSeatUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1020280958")) {
            ipChange.ipc$dispatch("1020280958", new Object[]{this, onSeatUiListener});
            return;
        }
        this.mUiListener.a(onSeatUiListener);
        this.mPicCombiner.removeDynamic();
        this.mSeatCombiner.removeDynamic();
        TbParams tbParams = this.mParams;
        addCancelable(new mx1(BufferUtil.loadDynamic(tbParams.projectId, tbParams.itemId, tbParams.performId, tbParams.firstPayChooseSeat ? tbParams.payFirstPriceIds : null, tbParams.privilegeId, this.mPrivilegeSkuIds, tbParams.hasPromotion, new BufferListener<SeatDynamic>() { // from class: cn.damai.seat.model.TSeatModel2.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.tool2.bufferkit.BufferListener
            public void doRequestAsync() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1381699869")) {
                    ipChange2.ipc$dispatch("-1381699869", new Object[]{this});
                }
            }

            @Override // cn.damai.tool2.bufferkit.BufferListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1780922514")) {
                    ipChange2.ipc$dispatch("1780922514", new Object[]{this, str, str2});
                    return;
                }
                r92.f("SeatDynamicApi fail code" + str + " msg" + str2);
                TSeatModel2.this.mUiListener.onFail(ApiType.API_DYNAMIC, str, str2, null);
                o92.l().u(new UtDynamic(false, TSeatModel2.this.mParams, str, str2));
            }

            @Override // cn.damai.tool2.bufferkit.BufferListener
            public void onSuccess(SeatDynamic seatDynamic) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "4081580")) {
                    ipChange2.ipc$dispatch("4081580", new Object[]{this, seatDynamic});
                    return;
                }
                r92.f("SeatDynamicApi success");
                TSeatModel2.this.mDynamic = seatDynamic;
                TSeatModel2.this.mSeatBasket.h(seatDynamic.needCalc(), seatDynamic.calcFailSafe(), seatDynamic.calculateTag(), seatDynamic.getPriceManager());
                TSeatModel2.this.mPriceList = seatDynamic.priceList;
                TSeatModel2 tSeatModel2 = TSeatModel2.this;
                tSeatModel2.mPrice = f92.B(tSeatModel2.mPriceList, TSeatModel2.this.mPrice);
                seatDynamic.updateRegions(TSeatModel2.this.mRegions);
                PriceInfo priceInfo = new PriceInfo(seatDynamic.getSummaryMap());
                TSeatModel2.this.mPicCombiner.d(priceInfo);
                TSeatModel2.this.mSeatCombiner.f(seatDynamic.getPriceManager());
                TSeatModel2.this.mUiListener.showHeadView(new HeadBean(seatDynamic, !TSeatModel2.this.mParams.firstPayChooseSeat));
                if (!priceInfo.hasSeat()) {
                    TSeatModel2.this.mUiListener.toast(R$string.seat_sold_out_tip);
                }
                o92.l().u(new UtDynamic(true, TSeatModel2.this.mParams, null, null));
                TSeatModel2 tSeatModel22 = TSeatModel2.this;
                tSeatModel22.utExposureDiscountInfo("seatselect", tSeatModel22.mParams.itemId, seatDynamic.getSkuPromotionRelations());
            }
        }, new ud() { // from class: cn.damai.seat.model.TSeatModel2.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // tb.ud
            public boolean is4Preload() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1207987839")) {
                    return ((Boolean) ipChange2.ipc$dispatch("-1207987839", new Object[]{this})).booleanValue();
                }
                return false;
            }
        })));
        TbParams tbParams2 = this.mParams;
        addCancelable(new mx1(BufferUtil.loadStatus(tbParams2.itemId, tbParams2.projectId, tbParams2.performId, this.mRegionData.ri.vesion, null, this.mSeatBasket.p(), new BufferListener<CompressSeatStatus>() { // from class: cn.damai.seat.model.TSeatModel2.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.tool2.bufferkit.BufferListener
            public void doRequestAsync() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-958998043")) {
                    ipChange2.ipc$dispatch("-958998043", new Object[]{this});
                }
            }

            @Override // cn.damai.tool2.bufferkit.BufferListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1765403796")) {
                    ipChange2.ipc$dispatch("1765403796", new Object[]{this, str, str2});
                    return;
                }
                r92.f("CompressStatusApi fail code" + str + " msg" + str2);
                TSeatModel2.this.pageAlarm("mtop.damai.wireless.seat.dynamicInfo", "SVG选座页", str, str2, "seatselect", null);
                TSeatModel2.this.mUiListener.onFail(333, str, str2, null);
                o92.l().x(new UtStatus(false, TSeatModel2.this.mParams, str, str2));
            }

            @Override // cn.damai.tool2.bufferkit.BufferListener
            public void onSuccess(CompressSeatStatus compressSeatStatus) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-829357325")) {
                    ipChange2.ipc$dispatch("-829357325", new Object[]{this, compressSeatStatus});
                    return;
                }
                r92.f("CompressStatusApi success");
                TSeatModel2.this.mSeatCombiner.g(compressSeatStatus);
                o92.l().x(new UtStatus(true, TSeatModel2.this.mParams, null, null));
            }
        }, new ud() { // from class: cn.damai.seat.model.TSeatModel2.8
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // tb.ud
            public boolean is4Preload() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1498631555")) {
                    return ((Boolean) ipChange2.ipc$dispatch("1498631555", new Object[]{this})).booleanValue();
                }
                return false;
            }
        })));
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void removeAllSeat() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-784078466")) {
            ipChange.ipc$dispatch("-784078466", new Object[]{this});
        } else {
            this.mSeatBasket.B();
        }
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public boolean shouldShowDiffRowTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "37139896")) {
            return ((Boolean) ipChange.ipc$dispatch("37139896", new Object[]{this})).booleanValue();
        }
        RegionData regionData = this.mRegionData;
        return regionData != null && regionData.sameRowNotify && this.mSeatBasket.w();
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void submitSeat(OnSubmitListener onSubmitListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "649463773")) {
            ipChange.ipc$dispatch("649463773", new Object[]{this, onSubmitListener});
        } else {
            this.mSeatBasket.C(onSubmitListener);
        }
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void update3DVrData(SeatBox seatBox) {
        SeatBox d;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1691193446")) {
            ipChange.ipc$dispatch("-1691193446", new Object[]{this, seatBox});
        } else if (seatBox == null || (d = this.mSeatCombiner.d()) == null) {
        } else {
            d.seat3DVrInfoMap = seatBox.seat3DVrInfoMap;
            d.bindVrData();
        }
    }
}
