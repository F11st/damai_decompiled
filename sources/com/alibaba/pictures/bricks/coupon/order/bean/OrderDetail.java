package com.alibaba.pictures.bricks.coupon.order.bean;

import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPayInfo;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.pictures.bricks.bean.CouponOrderInfoBean;
import com.alibaba.pictures.bricks.bean.CouponServiceRuleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class OrderDetail implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String buttonJumpUrl;
    @Nullable
    private String buttonStatus;
    @Nullable
    private ArrayList<String> faqItems;
    @Nullable
    private Goods goodsVO;
    @Nullable
    private List<GaiaXBean> gx;
    @Nullable
    private String itemId;
    @Nullable
    private Notice noticeVO;
    @Nullable
    private CouponOrderInfoBean orderInfoVO;
    @Nullable
    private ArrayList<OrderDetailPayInfo> paymentInfoList;
    @Nullable
    private ArrayList<CouponServiceRuleBean> ruleContexts;
    @Nullable
    private JSONObject shopAndItemInfoVO;
    @Nullable
    private StatusInfo statusInfo;
    @Nullable
    private String yellowTips;
    @Nullable
    private String yellowTipsIcon;

    @Nullable
    public final String getButtonJumpUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1005890838") ? (String) ipChange.ipc$dispatch("1005890838", new Object[]{this}) : this.buttonJumpUrl;
    }

    @Nullable
    public final String getButtonStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1113885715") ? (String) ipChange.ipc$dispatch("1113885715", new Object[]{this}) : this.buttonStatus;
    }

    @Nullable
    public final ArrayList<String> getFaqItems() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1486399041") ? (ArrayList) ipChange.ipc$dispatch("1486399041", new Object[]{this}) : this.faqItems;
    }

    @Nullable
    public final Goods getGoodsVO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1847347838") ? (Goods) ipChange.ipc$dispatch("1847347838", new Object[]{this}) : this.goodsVO;
    }

    @Nullable
    public final List<GaiaXBean> getGx() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2012035737") ? (List) ipChange.ipc$dispatch("-2012035737", new Object[]{this}) : this.gx;
    }

    @Nullable
    public final String getItemId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-724317219") ? (String) ipChange.ipc$dispatch("-724317219", new Object[]{this}) : this.itemId;
    }

    @Nullable
    public final Notice getNoticeVO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1101938892") ? (Notice) ipChange.ipc$dispatch("-1101938892", new Object[]{this}) : this.noticeVO;
    }

    @Nullable
    public final CouponOrderInfoBean getOrderInfoVO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-98927594") ? (CouponOrderInfoBean) ipChange.ipc$dispatch("-98927594", new Object[]{this}) : this.orderInfoVO;
    }

    @Nullable
    public final ArrayList<OrderDetailPayInfo> getPaymentInfoList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1368627073") ? (ArrayList) ipChange.ipc$dispatch("1368627073", new Object[]{this}) : this.paymentInfoList;
    }

    @Nullable
    public final ArrayList<CouponServiceRuleBean> getRuleContexts() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1642343947") ? (ArrayList) ipChange.ipc$dispatch("1642343947", new Object[]{this}) : this.ruleContexts;
    }

    @Nullable
    public final JSONObject getShopAndItemInfoVO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "107115134") ? (JSONObject) ipChange.ipc$dispatch("107115134", new Object[]{this}) : this.shopAndItemInfoVO;
    }

    @Nullable
    public final StatusInfo getStatusInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "140950907") ? (StatusInfo) ipChange.ipc$dispatch("140950907", new Object[]{this}) : this.statusInfo;
    }

    @JSONField(deserialize = false, serialize = false)
    @Nullable
    public final GaiaXBean getValidGaiaXBean(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2042399691")) {
            return (GaiaXBean) ipChange.ipc$dispatch("-2042399691", new Object[]{this, str});
        }
        b41.i(str, "templateId");
        List<GaiaXBean> list = this.gx;
        if (list != null) {
            for (GaiaXBean gaiaXBean : list) {
                if (gaiaXBean != null && b41.d(gaiaXBean.getTemplateId(), str) && gaiaXBean.isValid()) {
                    return gaiaXBean;
                }
            }
            return null;
        }
        return null;
    }

    @Nullable
    public final String getYellowTips() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1538153189") ? (String) ipChange.ipc$dispatch("-1538153189", new Object[]{this}) : this.yellowTips;
    }

    @Nullable
    public final String getYellowTipsIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-91429068") ? (String) ipChange.ipc$dispatch("-91429068", new Object[]{this}) : this.yellowTipsIcon;
    }

    public final void setButtonJumpUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-750818784")) {
            ipChange.ipc$dispatch("-750818784", new Object[]{this, str});
        } else {
            this.buttonJumpUrl = str;
        }
    }

    public final void setButtonStatus(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "568599851")) {
            ipChange.ipc$dispatch("568599851", new Object[]{this, str});
        } else {
            this.buttonStatus = str;
        }
    }

    public final void setFaqItems(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1245699793")) {
            ipChange.ipc$dispatch("-1245699793", new Object[]{this, arrayList});
        } else {
            this.faqItems = arrayList;
        }
    }

    public final void setGoodsVO(@Nullable Goods goods) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2021271954")) {
            ipChange.ipc$dispatch("-2021271954", new Object[]{this, goods});
        } else {
            this.goodsVO = goods;
        }
    }

    public final void setGx(@Nullable List<GaiaXBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "621981765")) {
            ipChange.ipc$dispatch("621981765", new Object[]{this, list});
        } else {
            this.gx = list;
        }
    }

    public final void setItemId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1920877985")) {
            ipChange.ipc$dispatch("1920877985", new Object[]{this, str});
        } else {
            this.itemId = str;
        }
    }

    public final void setNoticeVO(@Nullable Notice notice) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1663402962")) {
            ipChange.ipc$dispatch("1663402962", new Object[]{this, notice});
        } else {
            this.noticeVO = notice;
        }
    }

    public final void setOrderInfoVO(@Nullable CouponOrderInfoBean couponOrderInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-67525164")) {
            ipChange.ipc$dispatch("-67525164", new Object[]{this, couponOrderInfoBean});
        } else {
            this.orderInfoVO = couponOrderInfoBean;
        }
    }

    public final void setPaymentInfoList(@Nullable ArrayList<OrderDetailPayInfo> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1656281175")) {
            ipChange.ipc$dispatch("1656281175", new Object[]{this, arrayList});
        } else {
            this.paymentInfoList = arrayList;
        }
    }

    public final void setRuleContexts(@Nullable ArrayList<CouponServiceRuleBean> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1875389605")) {
            ipChange.ipc$dispatch("1875389605", new Object[]{this, arrayList});
        } else {
            this.ruleContexts = arrayList;
        }
    }

    public final void setShopAndItemInfoVO(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "865026502")) {
            ipChange.ipc$dispatch("865026502", new Object[]{this, jSONObject});
        } else {
            this.shopAndItemInfoVO = jSONObject;
        }
    }

    public final void setStatusInfo(@Nullable StatusInfo statusInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-124584165")) {
            ipChange.ipc$dispatch("-124584165", new Object[]{this, statusInfo});
        } else {
            this.statusInfo = statusInfo;
        }
    }

    public final void setYellowTips(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1746975267")) {
            ipChange.ipc$dispatch("1746975267", new Object[]{this, str});
        } else {
            this.yellowTips = str;
        }
    }

    public final void setYellowTipsIcon(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951407830")) {
            ipChange.ipc$dispatch("-1951407830", new Object[]{this, str});
        } else {
            this.yellowTipsIcon = str;
        }
    }
}
