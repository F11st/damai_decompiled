package cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PricePromotionBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SkuPrice {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int SKU_TAG_NO_PRIVILEGE = 4;
    public static final int SKU_TAG_TYPE_NO_TICKET = 1;
    public static final int SKU_TAG_TYPE_PROMOTION = 3;
    public static final int SKU_TAG_TYPE_TAO_PIAO = 5;
    public String dashPrice;
    private boolean isSelected;
    public boolean packagesFlag;
    public boolean permissionWithPrivilegeBuy;
    public double price;
    public long priceId;
    public long priceIdOfTC;
    public String promotionCopyWrite;
    public int quality;
    public int quantitySellAble;
    public int quantityWithHolding;
    public List<SkuDisCountBean> ruleTextContents;
    public boolean skuEnable;
    public long skuId;
    public String skuName;
    public String skuPromotionText;
    public int skuStatus;
    public String skuTag;
    public int skuTagType;
    public int ticketNum;

    public SkuPrice() {
        this.permissionWithPrivilegeBuy = true;
    }

    public static List<SkuDisCountBean> to(List<PricePromotionBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2137659726")) {
            return (List) ipChange.ipc$dispatch("2137659726", new Object[]{list});
        }
        if (cb2.d(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new SkuDisCountBean(list.get(i)));
        }
        return arrayList;
    }

    public double getOriginPrice() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1628535164")) {
            return ((Double) ipChange.ipc$dispatch("-1628535164", new Object[]{this})).doubleValue();
        }
        try {
            return Double.parseDouble(this.dashPrice);
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0d;
        }
    }

    public boolean isCanShowDashPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-544719597") ? ((Boolean) ipChange.ipc$dispatch("-544719597", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.dashPrice) || getOriginPrice() == this.price) ? false : true;
    }

    public boolean isSelected() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2050570942") ? ((Boolean) ipChange.ipc$dispatch("-2050570942", new Object[]{this})).booleanValue() : this.isSelected;
    }

    public boolean isType4Promotion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1716813972")) {
            return ((Boolean) ipChange.ipc$dispatch("1716813972", new Object[]{this})).booleanValue();
        }
        int i = this.skuTagType;
        return i == 5 || i == 3;
    }

    public void setSelected(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1999155478")) {
            ipChange.ipc$dispatch("-1999155478", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isSelected = z;
        }
    }

    public SkuPrice(PriceBean priceBean) {
        this.permissionWithPrivilegeBuy = true;
        this.skuId = priceBean.skuId;
        this.priceId = priceBean.priceId;
        this.permissionWithPrivilegeBuy = priceBean.buyPermission;
        this.price = priceBean.price;
        this.skuName = priceBean.priceName;
        this.quantitySellAble = priceBean.mq;
        this.dashPrice = String.valueOf(priceBean.dashPrice);
        this.packagesFlag = priceBean.packagesFlag;
        this.ruleTextContents = to(priceBean.mktPromotionText);
    }
}
