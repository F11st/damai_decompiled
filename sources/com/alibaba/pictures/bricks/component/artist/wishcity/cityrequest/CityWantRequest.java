package com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest;

import com.alibaba.motu.crashreporter.Constants;
import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.alibaba.pictures.bricks.component.home.FollowStateBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CityWantRequest extends DamaiBaseRequest<FollowStateBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String dmChannel;
    @Nullable
    private String extras;
    @Nullable
    private String group;
    @Nullable
    private String operateType;
    @NotNull
    private String pageName;
    private int returnRelationStatus;
    @Nullable
    private String subTargetId;
    @Nullable
    private String targetId;
    @Nullable
    private String targetType;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum GroupType {
        PROJECT_GROUP("PROJECT_GROUP"),
        IP_GROUP("IP_GROUP"),
        ARTIST_GROUP("ARTIST_GROUP"),
        USER_GROUP("USER_GROUP"),
        BRAND_GROUP("BRAND_GROUP"),
        VENUE_GROUP("VENUE_GROUP");
        
        @NotNull
        private final String value;

        GroupType(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum PageName {
        DM_ITEM_DETAIL("DM_ITEM_DETAIL"),
        DM_ARTIST_DETAIL("DM_ARTIST_DETAIL"),
        DM_APP_HOME("DM_APP_HOME"),
        DM_MY_FOLLOW_LIST("DM_MY_FOLLOW_LIST"),
        TPP_ITEM_DETAIL("TPP_ITEM_DETAIL"),
        TPP_ARTIST_DETAIL("TPP_ARTIST_DETAIL"),
        TPP_APP_HOME("TPP_APP_HOME"),
        COMMON("COMMON");
        
        @NotNull
        private final String value;

        PageName(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum TargetType {
        ARTIST("ARTIST"),
        IP("IP"),
        IP_CITY_REMIND("IP_CITY_REMIND"),
        ITEM("ITEM"),
        USER(Constants.USER),
        BRAND(Constants.BRAND),
        VENUE("VENUE");
        
        @NotNull
        private final String value;

        TargetType(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    public CityWantRequest() {
        this.API_NAME = "mtop.damai.wireless.follow.relation.update.v2";
        this.VERSION = "1.0";
        this.NEED_ECODE = true;
        this.NEED_SESSION = true;
        this.pageName = PageName.COMMON.getValue();
    }

    @Nullable
    public final String getDmChannel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-532422743") ? (String) ipChange.ipc$dispatch("-532422743", new Object[]{this}) : this.dmChannel;
    }

    @Nullable
    public final String getExtras() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1856106634") ? (String) ipChange.ipc$dispatch("1856106634", new Object[]{this}) : this.extras;
    }

    @Nullable
    public final String getGroup() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "705259374") ? (String) ipChange.ipc$dispatch("705259374", new Object[]{this}) : this.group;
    }

    @Nullable
    public final String getOperateType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1547752627") ? (String) ipChange.ipc$dispatch("-1547752627", new Object[]{this}) : this.operateType;
    }

    @NotNull
    public final String getPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1119233183") ? (String) ipChange.ipc$dispatch("-1119233183", new Object[]{this}) : this.pageName;
    }

    public final int getReturnRelationStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "267486702") ? ((Integer) ipChange.ipc$dispatch("267486702", new Object[]{this})).intValue() : this.returnRelationStatus;
    }

    @Nullable
    public final String getSubTargetId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "153823835") ? (String) ipChange.ipc$dispatch("153823835", new Object[]{this}) : this.subTargetId;
    }

    @Nullable
    public final String getTargetId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-877648077") ? (String) ipChange.ipc$dispatch("-877648077", new Object[]{this}) : this.targetId;
    }

    @Nullable
    public final String getTargetType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "347972754") ? (String) ipChange.ipc$dispatch("347972754", new Object[]{this}) : this.targetType;
    }

    public final void setDmChannel(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1290440723")) {
            ipChange.ipc$dispatch("-1290440723", new Object[]{this, str});
        } else {
            this.dmChannel = str;
        }
    }

    public final void setExtras(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "309638804")) {
            ipChange.ipc$dispatch("309638804", new Object[]{this, str});
        } else {
            this.extras = str;
        }
    }

    public final void setGroup(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1415395640")) {
            ipChange.ipc$dispatch("-1415395640", new Object[]{this, str});
        } else {
            this.group = str;
        }
    }

    public final void setOperateType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1259324873")) {
            ipChange.ipc$dispatch("1259324873", new Object[]{this, str});
        } else {
            this.operateType = str;
        }
    }

    public final void setPageName(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-218818147")) {
            ipChange.ipc$dispatch("-218818147", new Object[]{this, str});
            return;
        }
        b41.i(str, "<set-?>");
        this.pageName = str;
    }

    public final void setReturnRelationStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643350668")) {
            ipChange.ipc$dispatch("-1643350668", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.returnRelationStatus = i;
        }
    }

    public final void setSubTargetId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1826379653")) {
            ipChange.ipc$dispatch("-1826379653", new Object[]{this, str});
        } else {
            this.subTargetId = str;
        }
    }

    public final void setTargetId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1319614453")) {
            ipChange.ipc$dispatch("-1319614453", new Object[]{this, str});
        } else {
            this.targetId = str;
        }
    }

    public final void setTargetType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "87337356")) {
            ipChange.ipc$dispatch("87337356", new Object[]{this, str});
        } else {
            this.targetType = str;
        }
    }
}
