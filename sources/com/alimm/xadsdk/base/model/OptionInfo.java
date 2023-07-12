package com.alimm.xadsdk.base.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.youku.live.dago.liveplayback.widget.Constants;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class OptionInfo implements BaseInfo {
    @JSONField(name = Constants.ACTION_PARAMS_AREA)
    private String mArea;
    private AreaInfo mAreaInfo;
    @JSONField(name = "nav_link")
    private String mNavLink;
    @JSONField(name = "vote_link")
    private String mVoteUrl;

    public AreaInfo getAreaInfo() {
        return this.mAreaInfo;
    }

    public String getNavLink() {
        return this.mNavLink;
    }

    public String getVoteUrl() {
        return this.mVoteUrl;
    }

    public OptionInfo setArea(String str) {
        this.mArea = str;
        this.mAreaInfo = new AreaInfo(str);
        return this;
    }

    public OptionInfo setNavLink(String str) {
        this.mNavLink = str;
        return this;
    }

    public OptionInfo setVoteUrl(String str) {
        this.mVoteUrl = str;
        return this;
    }
}
