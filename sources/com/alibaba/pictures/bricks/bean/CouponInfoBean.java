package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private BuyBtnVO buyBtnVO;
    @Nullable
    private String categoryId;
    @Nullable
    private String itemId;
    @Nullable
    private String itemName;
    @Nullable
    private String itemStatus;
    @Nullable
    private String itemType;
    @Nullable
    private String purchaseLimit;
    @Nullable
    private String sales;
    @Nullable
    private List<TicketNote> serviceNoteList;
    @Nullable
    private ShareInfoBean shareDO;
    @Nullable
    private ArrayList<SkuInfoBean> skuList;
    @Nullable
    private String storeName;

    @Nullable
    public final BuyBtnVO getBuyBtnVO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1503593872") ? (BuyBtnVO) ipChange.ipc$dispatch("1503593872", new Object[]{this}) : this.buyBtnVO;
    }

    @Nullable
    public final String getCategoryId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-532698303") ? (String) ipChange.ipc$dispatch("-532698303", new Object[]{this}) : this.categoryId;
    }

    @Nullable
    public final String getItemId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "798597654") ? (String) ipChange.ipc$dispatch("798597654", new Object[]{this}) : this.itemId;
    }

    @Nullable
    public final String getItemName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1275917434") ? (String) ipChange.ipc$dispatch("-1275917434", new Object[]{this}) : this.itemName;
    }

    @Nullable
    public final String getItemStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1067861139") ? (String) ipChange.ipc$dispatch("-1067861139", new Object[]{this}) : this.itemStatus;
    }

    @Nullable
    public final String getItemType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "607384245") ? (String) ipChange.ipc$dispatch("607384245", new Object[]{this}) : this.itemType;
    }

    @Nullable
    public final String getPurchaseLimit() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1748506200") ? (String) ipChange.ipc$dispatch("-1748506200", new Object[]{this}) : this.purchaseLimit;
    }

    @Nullable
    public final String getSales() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1349458298") ? (String) ipChange.ipc$dispatch("1349458298", new Object[]{this}) : this.sales;
    }

    @Nullable
    public final List<TicketNote> getServiceNoteList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1692573158") ? (List) ipChange.ipc$dispatch("-1692573158", new Object[]{this}) : this.serviceNoteList;
    }

    @Nullable
    public final ShareInfoBean getShareDO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-932908325") ? (ShareInfoBean) ipChange.ipc$dispatch("-932908325", new Object[]{this}) : this.shareDO;
    }

    @Nullable
    public final ArrayList<SkuInfoBean> getSkuList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1809597009") ? (ArrayList) ipChange.ipc$dispatch("1809597009", new Object[]{this}) : this.skuList;
    }

    @Nullable
    public final String getStoreName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-98609670") ? (String) ipChange.ipc$dispatch("-98609670", new Object[]{this}) : this.storeName;
    }

    public final void setBuyBtnVO(@Nullable BuyBtnVO buyBtnVO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1483060218")) {
            ipChange.ipc$dispatch("1483060218", new Object[]{this, buyBtnVO});
        } else {
            this.buyBtnVO = buyBtnVO;
        }
    }

    public final void setCategoryId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1443661635")) {
            ipChange.ipc$dispatch("-1443661635", new Object[]{this, str});
        } else {
            this.categoryId = str;
        }
    }

    public final void setItemId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1886598792")) {
            ipChange.ipc$dispatch("1886598792", new Object[]{this, str});
        } else {
            this.itemId = str;
        }
    }

    public final void setItemName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-781062632")) {
            ipChange.ipc$dispatch("-781062632", new Object[]{this, str});
        } else {
            this.itemName = str;
        }
    }

    public final void setItemStatus(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-853840367")) {
            ipChange.ipc$dispatch("-853840367", new Object[]{this, str});
        } else {
            this.itemStatus = str;
        }
    }

    public final void setItemType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766714569")) {
            ipChange.ipc$dispatch("1766714569", new Object[]{this, str});
        } else {
            this.itemType = str;
        }
    }

    public final void setPurchaseLimit(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237781042")) {
            ipChange.ipc$dispatch("-237781042", new Object[]{this, str});
        } else {
            this.purchaseLimit = str;
        }
    }

    public final void setSales(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374901820")) {
            ipChange.ipc$dispatch("1374901820", new Object[]{this, str});
        } else {
            this.sales = str;
        }
    }

    public final void setServiceNoteList(@Nullable List<TicketNote> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1893277302")) {
            ipChange.ipc$dispatch("-1893277302", new Object[]{this, list});
        } else {
            this.serviceNoteList = list;
        }
    }

    public final void setShareDO(@Nullable ShareInfoBean shareInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1102852641")) {
            ipChange.ipc$dispatch("1102852641", new Object[]{this, shareInfoBean});
        } else {
            this.shareDO = shareInfoBean;
        }
    }

    public final void setSkuList(@Nullable ArrayList<SkuInfoBean> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373570439")) {
            ipChange.ipc$dispatch("373570439", new Object[]{this, arrayList});
        } else {
            this.skuList = arrayList;
        }
    }

    public final void setStoreName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-727137348")) {
            ipChange.ipc$dispatch("-727137348", new Object[]{this, str});
        } else {
            this.storeName = str;
        }
    }
}
