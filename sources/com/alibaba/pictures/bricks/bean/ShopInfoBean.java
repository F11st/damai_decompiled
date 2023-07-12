package com.alibaba.pictures.bricks.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.pictures.bricks.component.imgcard.BannerBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ShopInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String address;
    @Nullable
    private ArrayList<BannerBean> banners;
    @Nullable
    private String certificationIcon;
    @Nullable
    private String commentDetailUrl;
    @Nullable
    private String distance;
    @Nullable
    private String dmScore;
    @Nullable
    private String envScore;
    private boolean hasCertificationInfo;
    @Nullable
    private ArrayList<String> highlightWord;
    @Nullable
    private String id;
    @Nullable
    private String latitude;
    @Nullable
    private String longitude;
    @Nullable
    private String mapUrl;
    @Nullable
    private String name;
    @Nullable
    private ArrayList<String> openTime;
    @Nullable
    private String orderNum;
    @Nullable
    private ArrayList<OrderItem> orders;
    @Nullable
    private String partnerInfoIcon;
    @Nullable
    private String partnerInfoUrl;
    @Nullable
    private String priceLow;
    @Nullable
    private String schema;
    @Nullable
    private ArrayList<TuanItemBean> scriptItemList;
    @Nullable
    private String scriptItemSize;
    @Nullable
    private String scriptScore;
    @Nullable
    private ShareInfoBean shareDO;
    @Nullable
    private String status;
    @Nullable
    private String storeScore;
    @Nullable
    private String storeStatus;
    @Nullable
    private ArrayList<String> tags;
    @Nullable
    private String tel;
    @Nullable
    private ArrayList<String> tels;
    @Nullable
    private String url;

    @Nullable
    public final String getAddress() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "756321042") ? (String) ipChange.ipc$dispatch("756321042", new Object[]{this}) : this.address;
    }

    @Nullable
    public final ArrayList<BannerBean> getBanners() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "195500021") ? (ArrayList) ipChange.ipc$dispatch("195500021", new Object[]{this}) : this.banners;
    }

    @JSONField(deserialize = false, serialize = false)
    @NotNull
    public final ArrayList<BottomAction> getCallActionList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-864893648")) {
            return (ArrayList) ipChange.ipc$dispatch("-864893648", new Object[]{this});
        }
        ArrayList<BottomAction> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = this.tels;
        if (arrayList2 != null) {
            for (String str : arrayList2) {
                arrayList.add(new BottomAction(str, str));
            }
        }
        return arrayList;
    }

    @Nullable
    public final String getCertificationIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-527411663") ? (String) ipChange.ipc$dispatch("-527411663", new Object[]{this}) : this.certificationIcon;
    }

    @Nullable
    public final String getCommentDetailUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1990188567") ? (String) ipChange.ipc$dispatch("1990188567", new Object[]{this}) : this.commentDetailUrl;
    }

    @Nullable
    public final String getDistance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "626826317") ? (String) ipChange.ipc$dispatch("626826317", new Object[]{this}) : this.distance;
    }

    @Nullable
    public final String getDmScore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "225182247") ? (String) ipChange.ipc$dispatch("225182247", new Object[]{this}) : this.dmScore;
    }

    @Nullable
    public final String getEnvScore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1411361277") ? (String) ipChange.ipc$dispatch("1411361277", new Object[]{this}) : this.envScore;
    }

    public final boolean getHasCertificationInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "263890046") ? ((Boolean) ipChange.ipc$dispatch("263890046", new Object[]{this})).booleanValue() : this.hasCertificationInfo;
    }

    @Nullable
    public final ArrayList<String> getHighlightWord() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "29710654") ? (ArrayList) ipChange.ipc$dispatch("29710654", new Object[]{this}) : this.highlightWord;
    }

    @Nullable
    public final String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-429286349") ? (String) ipChange.ipc$dispatch("-429286349", new Object[]{this}) : this.id;
    }

    @Nullable
    public final String getLatitude() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1998641988") ? (String) ipChange.ipc$dispatch("1998641988", new Object[]{this}) : this.latitude;
    }

    @Nullable
    public final String getLongitude() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1603617933") ? (String) ipChange.ipc$dispatch("1603617933", new Object[]{this}) : this.longitude;
    }

    @Nullable
    public final String getMapUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1037934347") ? (String) ipChange.ipc$dispatch("1037934347", new Object[]{this}) : this.mapUrl;
    }

    @Nullable
    public final String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-156437917") ? (String) ipChange.ipc$dispatch("-156437917", new Object[]{this}) : this.name;
    }

    @Nullable
    public final ArrayList<String> getOpenTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1917015413") ? (ArrayList) ipChange.ipc$dispatch("-1917015413", new Object[]{this}) : this.openTime;
    }

    @Nullable
    public final String getOrderNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-138984912") ? (String) ipChange.ipc$dispatch("-138984912", new Object[]{this}) : this.orderNum;
    }

    @Nullable
    public final ArrayList<OrderItem> getOrders() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2110507811") ? (ArrayList) ipChange.ipc$dispatch("-2110507811", new Object[]{this}) : this.orders;
    }

    @Nullable
    public final String getPartnerInfoIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-3995699") ? (String) ipChange.ipc$dispatch("-3995699", new Object[]{this}) : this.partnerInfoIcon;
    }

    @Nullable
    public final String getPartnerInfoUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1765242001") ? (String) ipChange.ipc$dispatch("1765242001", new Object[]{this}) : this.partnerInfoUrl;
    }

    @Nullable
    public final String getPriceLow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-540667229") ? (String) ipChange.ipc$dispatch("-540667229", new Object[]{this}) : this.priceLow;
    }

    @Nullable
    public final String getSchema() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-382462151") ? (String) ipChange.ipc$dispatch("-382462151", new Object[]{this}) : this.schema;
    }

    @Nullable
    public final ArrayList<TuanItemBean> getScriptItemList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1118491994") ? (ArrayList) ipChange.ipc$dispatch("-1118491994", new Object[]{this}) : this.scriptItemList;
    }

    @Nullable
    public final String getScriptItemSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1456644407") ? (String) ipChange.ipc$dispatch("1456644407", new Object[]{this}) : this.scriptItemSize;
    }

    @Nullable
    public final String getScriptScore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1687964325") ? (String) ipChange.ipc$dispatch("1687964325", new Object[]{this}) : this.scriptScore;
    }

    @Nullable
    public final ShareInfoBean getShareDO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1504735669") ? (ShareInfoBean) ipChange.ipc$dispatch("-1504735669", new Object[]{this}) : this.shareDO;
    }

    @Nullable
    public final String getStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1010130698") ? (String) ipChange.ipc$dispatch("1010130698", new Object[]{this}) : this.status;
    }

    @Nullable
    public final String getStoreScore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1861076297") ? (String) ipChange.ipc$dispatch("1861076297", new Object[]{this}) : this.storeScore;
    }

    @Nullable
    public final String getStoreStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2128920495") ? (String) ipChange.ipc$dispatch("-2128920495", new Object[]{this}) : this.storeStatus;
    }

    @Nullable
    public final ArrayList<String> getTags() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1835913705") ? (ArrayList) ipChange.ipc$dispatch("1835913705", new Object[]{this}) : this.tags;
    }

    @Nullable
    public final String getTel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1538570041") ? (String) ipChange.ipc$dispatch("1538570041", new Object[]{this}) : this.tel;
    }

    @Nullable
    public final ArrayList<String> getTels() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "163880810") ? (ArrayList) ipChange.ipc$dispatch("163880810", new Object[]{this}) : this.tels;
    }

    @Nullable
    public final String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2058406541") ? (String) ipChange.ipc$dispatch("2058406541", new Object[]{this}) : this.url;
    }

    @JSONField(deserialize = false, serialize = false)
    public final boolean isShopOpened() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-96546393") ? ((Boolean) ipChange.ipc$dispatch("-96546393", new Object[]{this})).booleanValue() : b41.d("2", this.status);
    }

    public final void setAddress(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "354862244")) {
            ipChange.ipc$dispatch("354862244", new Object[]{this, str});
        } else {
            this.address = str;
        }
    }

    public final void setBanners(@Nullable ArrayList<BannerBean> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876171363")) {
            ipChange.ipc$dispatch("1876171363", new Object[]{this, arrayList});
        } else {
            this.banners = arrayList;
        }
    }

    public final void setCertificationIcon(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1841102437")) {
            ipChange.ipc$dispatch("1841102437", new Object[]{this, str});
        } else {
            this.certificationIcon = str;
        }
    }

    public final void setCommentDetailUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "394508711")) {
            ipChange.ipc$dispatch("394508711", new Object[]{this, str});
        } else {
            this.commentDetailUrl = str;
        }
    }

    public final void setDistance(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1925548495")) {
            ipChange.ipc$dispatch("-1925548495", new Object[]{this, str});
        } else {
            this.distance = str;
        }
    }

    public final void setDmScore(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1069428783")) {
            ipChange.ipc$dispatch("1069428783", new Object[]{this, str});
        } else {
            this.dmScore = str;
        }
    }

    public final void setEnvScore(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "920198785")) {
            ipChange.ipc$dispatch("920198785", new Object[]{this, str});
        } else {
            this.envScore = str;
        }
    }

    public final void setHasCertificationInfo(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1754831194")) {
            ipChange.ipc$dispatch("-1754831194", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.hasCertificationInfo = z;
        }
    }

    public final void setHighlightWord(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1969756986")) {
            ipChange.ipc$dispatch("1969756986", new Object[]{this, arrayList});
        } else {
            this.highlightWord = arrayList;
        }
    }

    public final void setId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1581622773")) {
            ipChange.ipc$dispatch("-1581622773", new Object[]{this, str});
        } else {
            this.id = str;
        }
    }

    public final void setLatitude(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1946031642")) {
            ipChange.ipc$dispatch("1946031642", new Object[]{this, str});
        } else {
            this.latitude = str;
        }
    }

    public final void setLongitude(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "502310793")) {
            ipChange.ipc$dispatch("502310793", new Object[]{this, str});
        } else {
            this.longitude = str;
        }
    }

    public final void setMapUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "716101683")) {
            ipChange.ipc$dispatch("716101683", new Object[]{this, str});
        } else {
            this.mapUrl = str;
        }
    }

    public final void setName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-847364901")) {
            ipChange.ipc$dispatch("-847364901", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public final void setOpenTime(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "622634533")) {
            ipChange.ipc$dispatch("622634533", new Object[]{this, arrayList});
        } else {
            this.openTime = arrayList;
        }
    }

    public final void setOrderNum(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "104107182")) {
            ipChange.ipc$dispatch("104107182", new Object[]{this, str});
        } else {
            this.orderNum = str;
        }
    }

    public final void setOrders(@Nullable ArrayList<OrderItem> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-745916141")) {
            ipChange.ipc$dispatch("-745916141", new Object[]{this, arrayList});
        } else {
            this.orders = arrayList;
        }
    }

    public final void setPartnerInfoIcon(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "157946697")) {
            ipChange.ipc$dispatch("157946697", new Object[]{this, str});
        } else {
            this.partnerInfoIcon = str;
        }
    }

    public final void setPartnerInfoUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-229179539")) {
            ipChange.ipc$dispatch("-229179539", new Object[]{this, str});
        } else {
            this.partnerInfoUrl = str;
        }
    }

    public final void setPriceLow(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "536857243")) {
            ipChange.ipc$dispatch("536857243", new Object[]{this, str});
        } else {
            this.priceLow = str;
        }
    }

    public final void setSchema(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-366516795")) {
            ipChange.ipc$dispatch("-366516795", new Object[]{this, str});
        } else {
            this.schema = str;
        }
    }

    public final void setScriptItemList(@Nullable ArrayList<TuanItemBean> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1376964502")) {
            ipChange.ipc$dispatch("-1376964502", new Object[]{this, arrayList});
        } else {
            this.scriptItemList = arrayList;
        }
    }

    public final void setScriptItemSize(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1205770361")) {
            ipChange.ipc$dispatch("-1205770361", new Object[]{this, str});
        } else {
            this.scriptItemSize = str;
        }
    }

    public final void setScriptScore(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1512664719")) {
            ipChange.ipc$dispatch("-1512664719", new Object[]{this, str});
        } else {
            this.scriptScore = str;
        }
    }

    public final void setShareDO(@Nullable ShareInfoBean shareInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "556074161")) {
            ipChange.ipc$dispatch("556074161", new Object[]{this, shareInfoBean});
        } else {
            this.shareDO = shareInfoBean;
        }
    }

    public final void setStatus(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-145811436")) {
            ipChange.ipc$dispatch("-145811436", new Object[]{this, str});
        } else {
            this.status = str;
        }
    }

    public final void setStoreScore(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-251093067")) {
            ipChange.ipc$dispatch("-251093067", new Object[]{this, str});
        } else {
            this.storeScore = str;
        }
    }

    public final void setStoreStatus(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "422990149")) {
            ipChange.ipc$dispatch("422990149", new Object[]{this, str});
        } else {
            this.storeStatus = str;
        }
    }

    public final void setTags(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1683017863")) {
            ipChange.ipc$dispatch("1683017863", new Object[]{this, arrayList});
        } else {
            this.tags = arrayList;
        }
    }

    public final void setTel(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1869579101")) {
            ipChange.ipc$dispatch("1869579101", new Object[]{this, str});
        } else {
            this.tel = str;
        }
    }

    public final void setTels(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1389605670")) {
            ipChange.ipc$dispatch("1389605670", new Object[]{this, arrayList});
        } else {
            this.tels = arrayList;
        }
    }

    public final void setUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "804641417")) {
            ipChange.ipc$dispatch("804641417", new Object[]{this, str});
        } else {
            this.url = str;
        }
    }
}
