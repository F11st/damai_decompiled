package cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean;

import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Iterator;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SkuPerform {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PERFORM_TAG_FIXED_TAO_PIAO = 5;
    public static final int PERFORM_TAG_NO_PRIVILEGE = 4;
    public static final int PERFORM_TAG_NO_TICKET = 1;
    public static final int PERFORM_TAG_PRE_SALE = 2;
    public static final int PERFORM_TAG_PROMOTION = 3;
    public static final int PERFORM_TYPE_FIRST_PAY_LAST_SEAT = 2;
    public static final int PERFORM_TYPE_FIRST_SEAT_LAST_PAY = 1;
    public static final int PERFORM_TYPE_NOT_SUPPORT_SEAT = 3;
    public static final int PERFORM_TYPE_PRE_SALE = 2;
    public int buyNum;
    public int chooseSeatType;
    private boolean isSelected;
    public boolean isSpecialPerform;
    public long itemId;
    public List<SkuPerformBase> itemPerforms;
    public String itemTitle;
    public long nationalStandardCityId;
    public String performBeginTime;
    public long performDate;
    public String performDesc;
    public long performId;
    public String performName;
    public String performStartDate;
    public String performTagDesc;
    public int performTagValue;
    public String performTime;
    public String performTimeDetail;
    private int pos;
    public long projectId;
    public long projectIdOfTC;
    public String promotionRemark;
    public List<String> promotionTags;
    public List<SkuPerformPromotion> promotions;
    public int saleForm;
    public String seatTip;
    public int singleLimit;
    public List<SkuPrice> skuList;
    public String skuPromotionRelations;
    public int privilegeLimitBuy = 99999;
    public boolean permissionWithPrivilegeBuy = true;
    public boolean hasPromotion = false;

    public boolean containsPrice(SkuPrice skuPrice) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1502538758")) {
            return ((Boolean) ipChange.ipc$dispatch("-1502538758", new Object[]{this, skuPrice})).booleanValue();
        }
        if (skuPrice != null && !cb2.d(this.skuList)) {
            Iterator<SkuPrice> it = this.skuList.iterator();
            while (it.hasNext()) {
                if (it.next().skuId == skuPrice.skuId) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-553860388")) {
            return ((Boolean) ipChange.ipc$dispatch("-553860388", new Object[]{this, obj})).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkuPerform) {
            SkuPerform skuPerform = (SkuPerform) obj;
            return this.performId == skuPerform.performId && this.itemId == skuPerform.itemId && this.projectId == skuPerform.projectId;
        }
        return false;
    }

    public int getPos() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2107554256") ? ((Integer) ipChange.ipc$dispatch("-2107554256", new Object[]{this})).intValue() : this.pos;
    }

    public String getShowName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1517551217")) {
            return (String) ipChange.ipc$dispatch("-1517551217", new Object[]{this});
        }
        if (this.isSpecialPerform) {
            return this.performName;
        }
        return this.performBeginTime;
    }

    public long getSkuId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "947736031")) {
            return ((Long) ipChange.ipc$dispatch("947736031", new Object[]{this, Long.valueOf(j)})).longValue();
        }
        if (cb2.d(this.skuList)) {
            return -1L;
        }
        for (SkuPrice skuPrice : this.skuList) {
            if (skuPrice.priceId == j) {
                return skuPrice.skuId;
            }
        }
        return -1L;
    }

    public SkuPrice getSkuPrice(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1084725346")) {
            return (SkuPrice) ipChange.ipc$dispatch("1084725346", new Object[]{this, Long.valueOf(j)});
        }
        if (cb2.d(this.skuList)) {
            return null;
        }
        for (SkuPrice skuPrice : this.skuList) {
            if (skuPrice.priceId == j) {
                return skuPrice;
            }
        }
        return null;
    }

    @Nullable
    public String getSkuTagByPriceIdIfHasPromotion(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2010666935")) {
            return (String) ipChange.ipc$dispatch("2010666935", new Object[]{this, Long.valueOf(j)});
        }
        if (cb2.d(this.skuList)) {
            return null;
        }
        for (SkuPrice skuPrice : this.skuList) {
            if (skuPrice.priceId == j && skuPrice.isType4Promotion()) {
                return skuPrice.skuTag;
            }
        }
        return null;
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086451347")) {
            return ((Integer) ipChange.ipc$dispatch("1086451347", new Object[]{this})).intValue();
        }
        long j = this.performId;
        long j2 = this.itemId;
        long j3 = this.projectId;
        return (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
    }

    public boolean isHasPromotion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1293566516") ? ((Boolean) ipChange.ipc$dispatch("-1293566516", new Object[]{this})).booleanValue() : !cb2.d(this.promotions);
    }

    public boolean isSelected() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1344208102") ? ((Boolean) ipChange.ipc$dispatch("-1344208102", new Object[]{this})).booleanValue() : this.isSelected;
    }

    public void setPos(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1027162586")) {
            ipChange.ipc$dispatch("1027162586", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.pos = i;
        }
    }

    public void setSelected(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1789299006")) {
            ipChange.ipc$dispatch("-1789299006", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isSelected = z;
        }
    }
}
