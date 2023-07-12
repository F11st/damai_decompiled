package com.alibaba.pictures.bricks.coupon.order.bean;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ShopAndItemInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String itemId;
    @Nullable
    private String itemName;
    @Nullable
    private String itemPicUrl;
    @Nullable
    private String shopDetailUrl;
    @Nullable
    private String shopId;
    @NotNull
    private JSONObject shopJson;
    @Nullable
    private String shopName;

    public ShopAndItemInfo(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "shopJson");
        this.shopJson = jSONObject;
    }

    @Nullable
    public final String getItemId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-64532064") ? (String) ipChange.ipc$dispatch("-64532064", new Object[]{this}) : this.itemId;
    }

    @Nullable
    public final String getItemName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1814888304") ? (String) ipChange.ipc$dispatch("-1814888304", new Object[]{this}) : this.itemName;
    }

    @Nullable
    public final String getItemPicUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2068646390") ? (String) ipChange.ipc$dispatch("-2068646390", new Object[]{this}) : this.itemPicUrl;
    }

    @Nullable
    public final String getShopDetailUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1115780692") ? (String) ipChange.ipc$dispatch("-1115780692", new Object[]{this}) : this.shopDetailUrl;
    }

    @Nullable
    public final String getShopId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1828367037") ? (String) ipChange.ipc$dispatch("-1828367037", new Object[]{this}) : this.shopId;
    }

    @NotNull
    public final JSONObject getShopJson() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-695377808") ? (JSONObject) ipChange.ipc$dispatch("-695377808", new Object[]{this}) : this.shopJson;
    }

    @Nullable
    public final String getShopName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-348215437") ? (String) ipChange.ipc$dispatch("-348215437", new Object[]{this}) : this.shopName;
    }

    public final void setItemId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "899381310")) {
            ipChange.ipc$dispatch("899381310", new Object[]{this, str});
        } else {
            this.itemId = str;
        }
    }

    public final void setItemName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-309290418")) {
            ipChange.ipc$dispatch("-309290418", new Object[]{this, str});
        } else {
            this.itemName = str;
        }
    }

    public final void setItemPicUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1813412076")) {
            ipChange.ipc$dispatch("-1813412076", new Object[]{this, str});
        } else {
            this.itemPicUrl = str;
        }
    }

    public final void setShopDetailUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2098126774")) {
            ipChange.ipc$dispatch("-2098126774", new Object[]{this, str});
        } else {
            this.shopDetailUrl = str;
        }
    }

    public final void setShopId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2055071995")) {
            ipChange.ipc$dispatch("2055071995", new Object[]{this, str});
        } else {
            this.shopId = str;
        }
    }

    public final void setShopJson(@NotNull JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-605029716")) {
            ipChange.ipc$dispatch("-605029716", new Object[]{this, jSONObject});
            return;
        }
        b41.i(jSONObject, "<set-?>");
        this.shopJson = jSONObject;
    }

    public final void setShopName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2087071797")) {
            ipChange.ipc$dispatch("-2087071797", new Object[]{this, str});
        } else {
            this.shopName = str;
        }
    }
}
