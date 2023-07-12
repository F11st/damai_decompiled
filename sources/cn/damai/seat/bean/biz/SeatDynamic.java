package cn.damai.seat.bean.biz;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.PriceSummary;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionBean;
import cn.damai.seat.bean.IPriceManager;
import cn.damai.seat.bean.PriceManagerImpl;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SeatDynamic implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Deprecated
    public PromotionBean mktPromotion;
    public ItemSku performBasicInfo;
    public List<Price> priceList;
    public PromotionBean promotionDetail;
    public List<StandPriceSummary> standColorList;
    private LongSparseArray<Price> tempMap;

    public boolean calcFailSafe() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "593710055")) {
            return ((Boolean) ipChange.ipc$dispatch("593710055", new Object[]{this})).booleanValue();
        }
        ItemSku itemSku = this.performBasicInfo;
        return itemSku != null && itemSku.calcFailSafe;
    }

    public String calculateTag() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "781317681")) {
            return (String) ipChange.ipc$dispatch("781317681", new Object[]{this});
        }
        ItemSku itemSku = this.performBasicInfo;
        if (itemSku != null) {
            return itemSku.calculateTag;
        }
        return null;
    }

    @NonNull
    public IPriceManager getPriceManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "324422363") ? (IPriceManager) ipChange.ipc$dispatch("324422363", new Object[]{this}) : new PriceManagerImpl(this.priceList);
    }

    public String getSkuPromotionRelations() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2140024376")) {
            return (String) ipChange.ipc$dispatch("2140024376", new Object[]{this});
        }
        PromotionBean promotionBean = this.promotionDetail;
        if (promotionBean != null) {
            return promotionBean.skuPromotionRelations;
        }
        return null;
    }

    @NonNull
    public HashMap<String, ArrayList<PriceSummary>> getSummaryMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1013831902")) {
            return (HashMap) ipChange.ipc$dispatch("1013831902", new Object[]{this});
        }
        HashMap<String, ArrayList<PriceSummary>> hashMap = new HashMap<>();
        if (!cb2.d(this.standColorList)) {
            for (StandPriceSummary standPriceSummary : this.standColorList) {
                ArrayList<PriceSummary> arrayList = standPriceSummary.priceColors;
                if (!cb2.d(arrayList)) {
                    hashMap.put(standPriceSummary.standId, arrayList);
                }
            }
        }
        return hashMap;
    }

    public boolean hasPromotion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "871482718")) {
            return ((Boolean) ipChange.ipc$dispatch("871482718", new Object[]{this})).booleanValue();
        }
        PromotionBean promotionBean = this.promotionDetail;
        return (promotionBean == null || cb2.d(promotionBean.promotionGroupList)) ? false : true;
    }

    public boolean needCalc() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "942318652")) {
            return ((Boolean) ipChange.ipc$dispatch("942318652", new Object[]{this})).booleanValue();
        }
        ItemSku itemSku = this.performBasicInfo;
        return itemSku != null && itemSku.needCalc;
    }

    public boolean showPromotion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-325465179") ? ((Boolean) ipChange.ipc$dispatch("-325465179", new Object[]{this})).booleanValue() : hasPromotion();
    }

    public void updateRegions(List<Region> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "74424258")) {
            ipChange.ipc$dispatch("74424258", new Object[]{this, list});
        } else if (!cb2.d(list)) {
            HashMap<String, ArrayList<PriceSummary>> summaryMap = getSummaryMap();
            for (Region region : list) {
                StringBuilder sb = new StringBuilder();
                sb.append(region.id);
                sb.append("");
                region.state = !cb2.d(summaryMap.get(sb.toString())) ? 1 : 0;
            }
        }
    }
}
