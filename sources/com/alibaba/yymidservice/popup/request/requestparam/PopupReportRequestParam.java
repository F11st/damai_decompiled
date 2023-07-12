package com.alibaba.yymidservice.popup.request.requestparam;

import com.alibaba.yymidservice.popup.request.PicBaseRequest;
import com.alibaba.yymidservice.popup.request.bean.PopupReportResponseBean;
import com.alient.gaiax.container.util.ChannelUtil;
import com.taobao.orange.OConstant;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class PopupReportRequestParam extends PicBaseRequest<PopupReportResponseBean> {
    @Nullable
    private JSONObject args;
    @Nullable
    private String comboChannel;
    @Nullable
    private String comboCityId;
    @Nullable
    private String pkId;

    public PopupReportRequestParam() {
        ChannelUtil channelUtil = ChannelUtil.INSTANCE;
        if (channelUtil.isDamaiApp()) {
            this.API_NAME = "mtop.damai.mec.popup.report";
            this.comboChannel = "1";
        } else if (channelUtil.isTppApp()) {
            this.API_NAME = "mtop.film.life.popup.report";
            this.comboChannel = OConstant.CODE_POINT_EXP_BIND_SERVICE;
        }
        this.VERSION = "1.0";
        this.NEED_ECODE = false;
        this.NEED_SESSION = false;
    }

    @Nullable
    public final JSONObject getArgs() {
        return this.args;
    }

    @Nullable
    public final String getComboChannel() {
        return this.comboChannel;
    }

    @Nullable
    public final String getComboCityId() {
        return this.comboCityId;
    }

    @Nullable
    public final String getPkId() {
        return this.pkId;
    }

    public final void setArgs(@Nullable JSONObject jSONObject) {
        this.args = jSONObject;
    }

    public final void setComboChannel(@Nullable String str) {
        this.comboChannel = str;
    }

    public final void setComboCityId(@Nullable String str) {
        this.comboCityId = str;
    }

    public final void setPkId(@Nullable String str) {
        this.pkId = str;
    }
}
