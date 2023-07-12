package cn.damai.commonbusiness.seatbiz.sku.qilin.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PriceBean extends PromotionTag {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -8764346722871543329L;
    public int auctionUnit;
    public boolean buyPermission;
    public boolean clickable;
    public double dashPrice;
    public int followRelationTargetType;
    public boolean freePackage;
    public int frontEndStatus;
    public boolean hasPromotion;
    public int holdingQuantity;
    public int index;
    public long itemId;
    @Deprecated
    public String mktPromotionContent;
    public List<PricePromotionBean> mktPromotionText;
    public int mq;
    public String packageTag;
    public boolean packagesFlag;
    public double price;
    public long priceId;
    public String priceIdOfTC;
    public String priceName;
    public String sfpt;
    public long skuId;
    public int status;
    @Deprecated
    public List<TagBean> tags;
    public TipBean tips;
    public String toastTips;

    public PriceBean() {
    }

    public boolean isTypePromotion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-501546834") ? ((Boolean) ipChange.ipc$dispatch("-501546834", new Object[]{this})).booleanValue() : this.packagesFlag || this.hasPromotion;
    }

    public PriceBean(long j, long j2) {
        this.skuId = j;
        this.priceId = j2;
    }
}
