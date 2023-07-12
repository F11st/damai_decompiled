package com.alibaba.pictures.bricks.component.script;

import com.alibaba.pictures.bricks.bean.SaleModelTagsBean;
import com.alibaba.pictures.bricks.bean.ShareInfoBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ScriptInfoHeaderBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String favoriteFlag;
    private boolean hasPlayed;
    @Nullable
    private String name;
    @Nullable
    private ArrayList<SaleModelTagsBean> saleModelTags;
    @Nullable
    private ShareInfoBean shareDO;
    @Nullable
    private String url;
    @NotNull
    private String id = "";
    @Nullable
    private String shareUrl = "";

    @Nullable
    public final String getFavoriteFlag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-996439883") ? (String) ipChange.ipc$dispatch("-996439883", new Object[]{this}) : this.favoriteFlag;
    }

    public final boolean getHasPlayed() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "850593550") ? ((Boolean) ipChange.ipc$dispatch("850593550", new Object[]{this})).booleanValue() : this.hasPlayed;
    }

    @NotNull
    public final String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1059355048") ? (String) ipChange.ipc$dispatch("1059355048", new Object[]{this}) : this.id;
    }

    @Nullable
    public final String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "203835032") ? (String) ipChange.ipc$dispatch("203835032", new Object[]{this}) : this.name;
    }

    @Nullable
    public final ArrayList<SaleModelTagsBean> getSaleModelTags() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-732466986") ? (ArrayList) ipChange.ipc$dispatch("-732466986", new Object[]{this}) : this.saleModelTags;
    }

    @Nullable
    public final ShareInfoBean getShareDO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-136031050") ? (ShareInfoBean) ipChange.ipc$dispatch("-136031050", new Object[]{this}) : this.shareDO;
    }

    @Nullable
    public final String getShareUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "493855645") ? (String) ipChange.ipc$dispatch("493855645", new Object[]{this}) : this.shareUrl;
    }

    @Nullable
    public final String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "961649592") ? (String) ipChange.ipc$dispatch("961649592", new Object[]{this}) : this.url;
    }

    public final void setFavoriteFlag(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-426984247")) {
            ipChange.ipc$dispatch("-426984247", new Object[]{this, str});
        } else {
            this.favoriteFlag = str;
        }
    }

    public final void setHasPlayed(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1232800898")) {
            ipChange.ipc$dispatch("-1232800898", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.hasPlayed = z;
        }
    }

    public final void setId(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1616587574")) {
            ipChange.ipc$dispatch("1616587574", new Object[]{this, str});
            return;
        }
        b41.i(str, "<set-?>");
        this.id = str;
    }

    public final void setName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1731161926")) {
            ipChange.ipc$dispatch("1731161926", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public final void setSaleModelTags(@Nullable ArrayList<SaleModelTagsBean> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-182913374")) {
            ipChange.ipc$dispatch("-182913374", new Object[]{this, arrayList});
        } else {
            this.saleModelTags = arrayList;
        }
    }

    public final void setShareDO(@Nullable ShareInfoBean shareInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36244390")) {
            ipChange.ipc$dispatch("36244390", new Object[]{this, shareInfoBean});
        } else {
            this.shareDO = shareInfoBean;
        }
    }

    public final void setShareUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752672031")) {
            ipChange.ipc$dispatch("-1752672031", new Object[]{this, str});
        } else {
            this.shareUrl = str;
        }
    }

    public final void setUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1164914366")) {
            ipChange.ipc$dispatch("1164914366", new Object[]{this, str});
        } else {
            this.url = str;
        }
    }
}
