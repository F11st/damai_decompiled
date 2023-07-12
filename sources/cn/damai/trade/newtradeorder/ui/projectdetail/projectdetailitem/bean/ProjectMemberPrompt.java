package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.graphics.Bitmap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public final class ProjectMemberPrompt implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int PRIORITY_PURCHASE_TYPE_PRESALE = 1;
    public static final int PRIORITY_PURCHASE_TYPE_SPECIAL = 2;
    @Nullable
    private String alipayDetailUrl;
    @Nullable
    private String asac;
    @Nullable
    private Integer baseScore;
    @Nullable
    private String buttonStatus;
    @Nullable
    private String buttonText;
    @Nullable
    private ArrayList<ProfitDetailContent> contents;
    @Nullable
    private String exchange4Dm;
    @Nullable
    private String exchangeRule;
    @Nullable
    private String exchangeStartTime;
    @Nullable
    private String itemSaleStage;
    private long launchMsrdc;
    private long launchScd;
    @Nullable
    private String launchTag;
    @Nullable
    private String launchTime;
    private long launchTimeStamp;
    @Nullable
    private String layerButtonText;
    @Nullable
    private String layerTitle;
    @Nullable
    private Integer memberLevel;
    private long msrdc;
    @Nullable
    private Long poolRemainingCount;
    @Nullable
    private String postImgUrl;
    @Nullable
    private String preBuyTime;
    private long preBuyTimestamp;
    @Nullable
    private Integer priorityPurchaseType;
    @Nullable
    private String priorityPurchaseTypeName;
    @Nullable
    private String profitDesc;
    @Nullable
    private String profitId;
    @Nullable
    private String profitName;
    @Nullable
    private String profitType;
    @Nullable
    private Integer reductionScore;
    private long scd;
    @Nullable
    private String score;
    @Nullable
    private Integer scoreDiscount;
    @Nullable
    private String snatchTicketsTag;
    @Nullable
    private String speedUpCardUrl;
    @Nullable
    private String spreadId;
    @Nullable
    private String userScore;
    @Nullable
    private String vipLogo;
    private final long serialVersionUID = -1;
    @Nullable
    private Boolean privilegeStart = Boolean.FALSE;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static final class BannerVO implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private Bitmap localBitmap;
        @Nullable
        private String pic;
        @Nullable
        private String url;

        @Nullable
        public final Bitmap getLocalBitmap() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "558502017") ? (Bitmap) ipChange.ipc$dispatch("558502017", new Object[]{this}) : this.localBitmap;
        }

        @Nullable
        public final String getPic() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1231989395") ? (String) ipChange.ipc$dispatch("-1231989395", new Object[]{this}) : this.pic;
        }

        @Nullable
        public final String getUrl() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1436386514") ? (String) ipChange.ipc$dispatch("1436386514", new Object[]{this}) : this.url;
        }

        public final void setLocalBitmap(@Nullable Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "996870751")) {
                ipChange.ipc$dispatch("996870751", new Object[]{this, bitmap});
            } else {
                this.localBitmap = bitmap;
            }
        }

        public final void setPic(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1881582505")) {
                ipChange.ipc$dispatch("1881582505", new Object[]{this, str});
            } else {
                this.pic = str;
            }
        }

        public final void setUrl(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1298110236")) {
                ipChange.ipc$dispatch("-1298110236", new Object[]{this, str});
            } else {
                this.url = str;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static final class ITEM_SALE_STAGE {
        @NotNull
        public static final String BEFORE_SALE = "BEFORE_SALE";
        @NotNull
        public static final ITEM_SALE_STAGE INSTANCE = new ITEM_SALE_STAGE();
        @NotNull
        public static final String IN_SALE = "IN_SALE";

        private ITEM_SALE_STAGE() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static final class ProfitDetailContent implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private List<BannerVO> banners;
        @Nullable
        private String content;
        @Nullable
        private String subTitle;
        @Nullable
        private String title;

        @Nullable
        public final List<BannerVO> getBanners() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "297416612") ? (List) ipChange.ipc$dispatch("297416612", new Object[]{this}) : this.banners;
        }

        @Nullable
        public final String getContent() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-861309073") ? (String) ipChange.ipc$dispatch("-861309073", new Object[]{this}) : this.content;
        }

        @Nullable
        public final String getSubTitle() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1884917624") ? (String) ipChange.ipc$dispatch("1884917624", new Object[]{this}) : this.subTitle;
        }

        @Nullable
        public final String getTitle() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "771206798") ? (String) ipChange.ipc$dispatch("771206798", new Object[]{this}) : this.title;
        }

        public final void setBanners(@Nullable List<BannerVO> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-268072640")) {
                ipChange.ipc$dispatch("-268072640", new Object[]{this, list});
            } else {
                this.banners = list;
            }
        }

        public final void setContent(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1747936231")) {
                ipChange.ipc$dispatch("1747936231", new Object[]{this, str});
            } else {
                this.content = str;
            }
        }

        public final void setSubTitle(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1579423642")) {
                ipChange.ipc$dispatch("-1579423642", new Object[]{this, str});
            } else {
                this.subTitle = str;
            }
        }

        public final void setTitle(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "628974504")) {
                ipChange.ipc$dispatch("628974504", new Object[]{this, str});
            } else {
                this.title = str;
            }
        }
    }

    @Nullable
    public final String getAlipayDetailUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-633731734") ? (String) ipChange.ipc$dispatch("-633731734", new Object[]{this}) : this.alipayDetailUrl;
    }

    @Nullable
    public final String getAsac() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1084718316") ? (String) ipChange.ipc$dispatch("-1084718316", new Object[]{this}) : this.asac;
    }

    @Nullable
    public final Integer getBaseScore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-944469136") ? (Integer) ipChange.ipc$dispatch("-944469136", new Object[]{this}) : this.baseScore;
    }

    @Nullable
    public final String getButtonStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-374257660") ? (String) ipChange.ipc$dispatch("-374257660", new Object[]{this}) : this.buttonStatus;
    }

    @Nullable
    public final String getButtonText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1067972479") ? (String) ipChange.ipc$dispatch("1067972479", new Object[]{this}) : this.buttonText;
    }

    @Nullable
    public final ArrayList<ProfitDetailContent> getContents() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1775619424") ? (ArrayList) ipChange.ipc$dispatch("1775619424", new Object[]{this}) : this.contents;
    }

    @Nullable
    public final String getExchange4Dm() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2009094800") ? (String) ipChange.ipc$dispatch("2009094800", new Object[]{this}) : this.exchange4Dm;
    }

    @Nullable
    public final String getExchangeRule() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "461837951") ? (String) ipChange.ipc$dispatch("461837951", new Object[]{this}) : this.exchangeRule;
    }

    @Nullable
    public final String getExchangeStartTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "62205410") ? (String) ipChange.ipc$dispatch("62205410", new Object[]{this}) : this.exchangeStartTime;
    }

    @Nullable
    public final String getItemSaleStage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-974033638") ? (String) ipChange.ipc$dispatch("-974033638", new Object[]{this}) : this.itemSaleStage;
    }

    public final long getLaunchMsrdc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1641532678") ? ((Long) ipChange.ipc$dispatch("1641532678", new Object[]{this})).longValue() : this.launchMsrdc;
    }

    public final long getLaunchScd() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-141210787") ? ((Long) ipChange.ipc$dispatch("-141210787", new Object[]{this})).longValue() : this.launchScd;
    }

    @Nullable
    public final String getLaunchTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1907700515") ? (String) ipChange.ipc$dispatch("-1907700515", new Object[]{this}) : this.launchTag;
    }

    @Nullable
    public final String getLaunchTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "433241760") ? (String) ipChange.ipc$dispatch("433241760", new Object[]{this}) : this.launchTime;
    }

    public final long getLaunchTimeStamp() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1288272581") ? ((Long) ipChange.ipc$dispatch("-1288272581", new Object[]{this})).longValue() : this.launchTimeStamp;
    }

    @Nullable
    public final String getLayerButtonText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "690927334") ? (String) ipChange.ipc$dispatch("690927334", new Object[]{this}) : this.layerButtonText;
    }

    @Nullable
    public final String getLayerTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-152063097") ? (String) ipChange.ipc$dispatch("-152063097", new Object[]{this}) : this.layerTitle;
    }

    @Nullable
    public final Integer getMemberLevel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1933896455") ? (Integer) ipChange.ipc$dispatch("1933896455", new Object[]{this}) : this.memberLevel;
    }

    public final long getMsrdc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1804293107") ? ((Long) ipChange.ipc$dispatch("1804293107", new Object[]{this})).longValue() : this.msrdc;
    }

    @Nullable
    public final Long getPoolRemainingCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1938261590") ? (Long) ipChange.ipc$dispatch("-1938261590", new Object[]{this}) : this.poolRemainingCount;
    }

    @Nullable
    public final String getPostImgUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "454053612") ? (String) ipChange.ipc$dispatch("454053612", new Object[]{this}) : this.postImgUrl;
    }

    @Nullable
    public final String getPreBuyTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-598657072") ? (String) ipChange.ipc$dispatch("-598657072", new Object[]{this}) : this.preBuyTime;
    }

    public final long getPreBuyTimestamp() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1247994443") ? ((Long) ipChange.ipc$dispatch("1247994443", new Object[]{this})).longValue() : this.preBuyTimestamp;
    }

    @Nullable
    public final Integer getPriorityPurchaseType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1662729656") ? (Integer) ipChange.ipc$dispatch("-1662729656", new Object[]{this}) : this.priorityPurchaseType;
    }

    @Nullable
    public final String getPriorityPurchaseTypeName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-25859446") ? (String) ipChange.ipc$dispatch("-25859446", new Object[]{this}) : this.priorityPurchaseTypeName;
    }

    @Nullable
    public final Boolean getPrivilegeStart() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2073547660") ? (Boolean) ipChange.ipc$dispatch("2073547660", new Object[]{this}) : this.privilegeStart;
    }

    @Nullable
    public final String getProfitDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-841902091") ? (String) ipChange.ipc$dispatch("-841902091", new Object[]{this}) : this.profitDesc;
    }

    @Nullable
    public final String getProfitId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-610422849") ? (String) ipChange.ipc$dispatch("-610422849", new Object[]{this}) : this.profitId;
    }

    @Nullable
    public final String getProfitName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1865044719") ? (String) ipChange.ipc$dispatch("1865044719", new Object[]{this}) : this.profitName;
    }

    @Nullable
    public final String getProfitType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-546620898") ? (String) ipChange.ipc$dispatch("-546620898", new Object[]{this}) : this.profitType;
    }

    @Nullable
    public final Integer getReductionScore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1303719352") ? (Integer) ipChange.ipc$dispatch("-1303719352", new Object[]{this}) : this.reductionScore;
    }

    public final long getScd() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-328750710") ? ((Long) ipChange.ipc$dispatch("-328750710", new Object[]{this})).longValue() : this.scd;
    }

    @Nullable
    public final String getScore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "228946568") ? (String) ipChange.ipc$dispatch("228946568", new Object[]{this}) : this.score;
    }

    @Nullable
    public final Integer getScoreDiscount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1100531838") ? (Integer) ipChange.ipc$dispatch("1100531838", new Object[]{this}) : this.scoreDiscount;
    }

    @Nullable
    public final String getSnatchTicketsTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1177737466") ? (String) ipChange.ipc$dispatch("-1177737466", new Object[]{this}) : this.snatchTicketsTag;
    }

    @Nullable
    public final String getSpeedUpCardUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1613041437") ? (String) ipChange.ipc$dispatch("1613041437", new Object[]{this}) : this.speedUpCardUrl;
    }

    @Nullable
    public final String getSpreadId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "967067054") ? (String) ipChange.ipc$dispatch("967067054", new Object[]{this}) : this.spreadId;
    }

    @Nullable
    public final String getUserScore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-587291779") ? (String) ipChange.ipc$dispatch("-587291779", new Object[]{this}) : this.userScore;
    }

    @Nullable
    public final String getVipLogo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1084291486") ? (String) ipChange.ipc$dispatch("1084291486", new Object[]{this}) : this.vipLogo;
    }

    public final boolean isAuthPopWindow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2051384213") ? ((Boolean) ipChange.ipc$dispatch("-2051384213", new Object[]{this})).booleanValue() : b41.d(this.buttonStatus, "4");
    }

    public final boolean isButtonLight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1153274656") ? ((Boolean) ipChange.ipc$dispatch("1153274656", new Object[]{this})).booleanValue() : isSpeedUpCardPage() || isAuthPopWindow() || isMemberAuthPage() || b41.d(this.buttonStatus, "6") || isMemberAlipayPage();
    }

    public final boolean isMemberAlipayPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1529233435") ? ((Boolean) ipChange.ipc$dispatch("1529233435", new Object[]{this})).booleanValue() : b41.d(this.buttonStatus, "14");
    }

    public final boolean isMemberAuthPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-944932419") ? ((Boolean) ipChange.ipc$dispatch("-944932419", new Object[]{this})).booleanValue() : b41.d(this.buttonStatus, "5");
    }

    public final boolean isPromptBeforeSale() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "300697092") ? ((Boolean) ipChange.ipc$dispatch("300697092", new Object[]{this})).booleanValue() : b41.d(ITEM_SALE_STAGE.BEFORE_SALE, this.itemSaleStage);
    }

    public final boolean isPromptInSale() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "602075678") ? ((Boolean) ipChange.ipc$dispatch("602075678", new Object[]{this})).booleanValue() : b41.d(ITEM_SALE_STAGE.IN_SALE, this.itemSaleStage);
    }

    public final boolean isSeniorVip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1214735753")) {
            return ((Boolean) ipChange.ipc$dispatch("-1214735753", new Object[]{this})).booleanValue();
        }
        Integer num = this.memberLevel;
        return (num == null || num == null || num.intValue() != 10) ? false : true;
    }

    public final boolean isSpecialBuy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2072862527")) {
            return ((Boolean) ipChange.ipc$dispatch("-2072862527", new Object[]{this})).booleanValue();
        }
        Integer num = this.priorityPurchaseType;
        return num != null && 2 == num.intValue();
    }

    public final boolean isSpeedUpCardPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-377806749") ? ((Boolean) ipChange.ipc$dispatch("-377806749", new Object[]{this})).booleanValue() : b41.d(this.buttonStatus, "3");
    }

    public final void setAlipayDetailUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2110966092")) {
            ipChange.ipc$dispatch("2110966092", new Object[]{this, str});
        } else {
            this.alipayDetailUrl = str;
        }
    }

    public final void setAsac(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440713802")) {
            ipChange.ipc$dispatch("440713802", new Object[]{this, str});
        } else {
            this.asac = str;
        }
    }

    public final void setBaseScore(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1027381054")) {
            ipChange.ipc$dispatch("-1027381054", new Object[]{this, num});
        } else {
            this.baseScore = num;
        }
    }

    public final void setButtonStatus(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1680795482")) {
            ipChange.ipc$dispatch("1680795482", new Object[]{this, str});
        } else {
            this.buttonStatus = str;
        }
    }

    public final void setButtonText(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "932492351")) {
            ipChange.ipc$dispatch("932492351", new Object[]{this, str});
        } else {
            this.buttonText = str;
        }
    }

    public final void setContents(@Nullable ArrayList<ProfitDetailContent> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869802512")) {
            ipChange.ipc$dispatch("-869802512", new Object[]{this, arrayList});
        } else {
            this.contents = arrayList;
        }
    }

    public final void setExchange4Dm(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-147554586")) {
            ipChange.ipc$dispatch("-147554586", new Object[]{this, str});
        } else {
            this.exchange4Dm = str;
        }
    }

    public final void setExchangeRule(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1829955647")) {
            ipChange.ipc$dispatch("1829955647", new Object[]{this, str});
        } else {
            this.exchangeRule = str;
        }
    }

    public final void setExchangeStartTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1355604780")) {
            ipChange.ipc$dispatch("-1355604780", new Object[]{this, str});
        } else {
            this.exchangeStartTime = str;
        }
    }

    public final void setItemSaleStage(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1998935396")) {
            ipChange.ipc$dispatch("-1998935396", new Object[]{this, str});
        } else {
            this.itemSaleStage = str;
        }
    }

    public final void setLaunchMsrdc(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "267969894")) {
            ipChange.ipc$dispatch("267969894", new Object[]{this, Long.valueOf(j)});
        } else {
            this.launchMsrdc = j;
        }
    }

    public final void setLaunchScd(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1913979153")) {
            ipChange.ipc$dispatch("-1913979153", new Object[]{this, Long.valueOf(j)});
        } else {
            this.launchScd = j;
        }
    }

    public final void setLaunchTag(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-974378695")) {
            ipChange.ipc$dispatch("-974378695", new Object[]{this, str});
        } else {
            this.launchTag = str;
        }
    }

    public final void setLaunchTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1564290754")) {
            ipChange.ipc$dispatch("-1564290754", new Object[]{this, str});
        } else {
            this.launchTime = str;
        }
    }

    public final void setLaunchTimeStamp(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31414737")) {
            ipChange.ipc$dispatch("31414737", new Object[]{this, Long.valueOf(j)});
        } else {
            this.launchTimeStamp = j;
        }
    }

    public final void setLayerButtonText(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "225724240")) {
            ipChange.ipc$dispatch("225724240", new Object[]{this, str});
        } else {
            this.layerButtonText = str;
        }
    }

    public final void setLayerTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766095159")) {
            ipChange.ipc$dispatch("1766095159", new Object[]{this, str});
        } else {
            this.layerTitle = str;
        }
    }

    public final void setMemberLevel(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "515403531")) {
            ipChange.ipc$dispatch("515403531", new Object[]{this, num});
        } else {
            this.memberLevel = num;
        }
    }

    public final void setMsrdc(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1647534873")) {
            ipChange.ipc$dispatch("1647534873", new Object[]{this, Long.valueOf(j)});
        } else {
            this.msrdc = j;
        }
    }

    public final void setPoolRemainingCount(@Nullable Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "163910846")) {
            ipChange.ipc$dispatch("163910846", new Object[]{this, l});
        } else {
            this.poolRemainingCount = l;
        }
    }

    public final void setPostImgUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-919123342")) {
            ipChange.ipc$dispatch("-919123342", new Object[]{this, str});
        } else {
            this.postImgUrl = str;
        }
    }

    public final void setPreBuyTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "806583822")) {
            ipChange.ipc$dispatch("806583822", new Object[]{this, str});
        } else {
            this.preBuyTime = str;
        }
    }

    public final void setPreBuyTimestamp(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1346281153")) {
            ipChange.ipc$dispatch("1346281153", new Object[]{this, Long.valueOf(j)});
        } else {
            this.preBuyTimestamp = j;
        }
    }

    public final void setPriorityPurchaseType(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-173672062")) {
            ipChange.ipc$dispatch("-173672062", new Object[]{this, num});
        } else {
            this.priorityPurchaseType = num;
        }
    }

    public final void setPriorityPurchaseTypeName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "712509332")) {
            ipChange.ipc$dispatch("712509332", new Object[]{this, str});
        } else {
            this.priorityPurchaseTypeName = str;
        }
    }

    public final void setPrivilegeStart(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "168093226")) {
            ipChange.ipc$dispatch("168093226", new Object[]{this, bool});
        } else {
            this.privilegeStart = bool;
        }
    }

    public final void setProfitDesc(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1855922825")) {
            ipChange.ipc$dispatch("1855922825", new Object[]{this, str});
        } else {
            this.profitDesc = str;
        }
    }

    public final void setProfitId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1625566977")) {
            ipChange.ipc$dispatch("-1625566977", new Object[]{this, str});
        } else {
            this.profitId = str;
        }
    }

    public final void setProfitName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-128071985")) {
            ipChange.ipc$dispatch("-128071985", new Object[]{this, str});
        } else {
            this.profitName = str;
        }
    }

    public final void setProfitType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1875262080")) {
            ipChange.ipc$dispatch("-1875262080", new Object[]{this, str});
        } else {
            this.profitType = str;
        }
    }

    public final void setReductionScore(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1182506366")) {
            ipChange.ipc$dispatch("-1182506366", new Object[]{this, num});
        } else {
            this.reductionScore = num;
        }
    }

    public final void setScd(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "335498594")) {
            ipChange.ipc$dispatch("335498594", new Object[]{this, Long.valueOf(j)});
        } else {
            this.scd = j;
        }
    }

    public final void setScore(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "998776558")) {
            ipChange.ipc$dispatch("998776558", new Object[]{this, str});
        } else {
            this.score = str;
        }
    }

    public final void setScoreDiscount(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "935916404")) {
            ipChange.ipc$dispatch("935916404", new Object[]{this, num});
        } else {
            this.scoreDiscount = num;
        }
    }

    public final void setSnatchTicketsTag(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "973049496")) {
            ipChange.ipc$dispatch("973049496", new Object[]{this, str});
        } else {
            this.snatchTicketsTag = str;
        }
    }

    public final void setSpeedUpCardUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-652429727")) {
            ipChange.ipc$dispatch("-652429727", new Object[]{this, str});
        } else {
            this.speedUpCardUrl = str;
        }
    }

    public final void setSpreadId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31979760")) {
            ipChange.ipc$dispatch("31979760", new Object[]{this, str});
        } else {
            this.spreadId = str;
        }
    }

    public final void setUserScore(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1303586457")) {
            ipChange.ipc$dispatch("1303586457", new Object[]{this, str});
        } else {
            this.userScore = str;
        }
    }

    public final void setVipLogo(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1932011416")) {
            ipChange.ipc$dispatch("1932011416", new Object[]{this, str});
        } else {
            this.vipLogo = str;
        }
    }
}
