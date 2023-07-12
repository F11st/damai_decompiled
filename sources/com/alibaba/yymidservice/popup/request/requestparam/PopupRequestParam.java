package com.alibaba.yymidservice.popup.request.requestparam;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.request.PicBaseRequest;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import com.alient.gaiax.container.util.ChannelUtil;
import com.taobao.orange.OConstant;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class PopupRequestParam extends PicBaseRequest<PopupResponseBean> {
    @Nullable
    private JSONObject args;
    @Nullable
    private String comboChannel;
    @Nullable
    private String comboCityId;
    @Nullable
    private ArrayList<String> eventType;
    @Nullable
    private String queryType;
    @Nullable
    private String sceneType;

    public PopupRequestParam() {
        ChannelUtil channelUtil = ChannelUtil.INSTANCE;
        if (channelUtil.isDamaiApp()) {
            this.API_NAME = "mtop.damai.mec.popup.get";
            this.comboChannel = "1";
        } else if (channelUtil.isTppApp()) {
            this.API_NAME = "mtop.film.life.popup.get";
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
    public final ArrayList<String> getEventType() {
        return this.eventType;
    }

    @Nullable
    public final String getQueryType() {
        return this.queryType;
    }

    @Nullable
    public final String getSceneType() {
        return this.sceneType;
    }

    public final void setArgs(@Nullable JSONObject jSONObject) {
        this.args = jSONObject;
        if (jSONObject == null) {
            this.args = new JSONObject();
        }
    }

    public final void setComboChannel(@Nullable String str) {
        this.comboChannel = str;
    }

    public final void setComboCityId(@Nullable String str) {
        this.comboCityId = str;
    }

    public final void setEventType(@Nullable ArrayList<String> arrayList) {
        this.eventType = arrayList;
    }

    public final void setQueryType(@Nullable String str) {
        this.queryType = str;
    }

    public final void setSceneType(@Nullable String str) {
        this.sceneType = str;
    }
}
