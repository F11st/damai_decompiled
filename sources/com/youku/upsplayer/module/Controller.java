package com.youku.upsplayer.module;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.upsplayer.util.AssertUtil;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Controller {
    @JSONField(name = IRequestConst.AD_HTTPS)
    public boolean ad_https;
    @JSONField(name = "app_disable")
    public boolean app_disable;
    @JSONField(name = "autoClarityStartLevel")
    public int autoClarityStartLevel;
    @JSONField(name = "baipai_source")
    public String baipai_source;
    @JSONField(name = "buy_guide")
    public boolean buy_guide;
    @JSONField(name = "circle")
    private boolean circle;
    @JSONField(name = "clientCoreParaJsonStr")
    public String clientCoreParaJsonStr;
    @JSONField(name = "continuous")
    private boolean continuous;
    @JSONField(name = "dof_degrade_mode")
    public int dof_degrade_mode;
    @JSONField(name = "download_disable")
    public boolean download_disable;
    @JSONField(name = "html5_disable")
    private boolean html5_disable;
    @JSONField(name = "is_phone_stream")
    public String is_phone_stream;
    @JSONField(name = "like_disabled")
    private boolean like_disabled;
    @JSONField(name = "new_core")
    private boolean new_core;
    @JSONField(name = "pay_guid")
    public boolean pay_guid;
    @JSONField(name = "pay_info_ext")
    public String pay_info_ext;
    @JSONField(name = "play_mode")
    private int play_mode;
    @JSONField(name = "play_u_state")
    private int play_u_state;
    @JSONField(name = FeatureManager.FEATURE_KEY_POST_PROCESS)
    public boolean post_process;
    @JSONField(name = "pressure")
    public int pressure;
    @JSONField(name = "quick_mode")
    public String quick_mode;
    @JSONField(name = "share_disable")
    private boolean share_disable;
    @JSONField(name = "startClarity")
    public int startClarity;
    @JSONField(name = "startClarityTips")
    public JSONObject startClarityTips;
    @JSONField(name = "stream_config")
    public boolean stream_config;
    @JSONField(name = "stream_mode")
    public int stream_mode;
    @JSONField(name = "tipSwitch")
    public boolean tipSwitch;
    @JSONField(name = "video_capture")
    private boolean video_capture;
    @JSONField(name = "yi_plus")
    private boolean yi_plus;

    public String getIs_phone_stream() {
        return this.is_phone_stream;
    }

    public int getPlay_mode() {
        AssertUtil.assertUpsV1();
        return this.play_mode;
    }

    public int getPlay_u_state() {
        AssertUtil.assertUpsV1();
        return this.play_u_state;
    }

    public boolean getStream_config() {
        return this.stream_config;
    }

    public int getStream_mode() {
        return this.stream_mode;
    }

    public boolean isApp_disable() {
        return this.app_disable;
    }

    public boolean isCircle() {
        AssertUtil.assertUpsV1();
        return this.circle;
    }

    public boolean isContinuous() {
        AssertUtil.assertUpsV1();
        return this.continuous;
    }

    public boolean isDownload_disable() {
        return this.download_disable;
    }

    public boolean isHtml5_disable() {
        AssertUtil.assertUpsV1();
        return this.html5_disable;
    }

    public boolean isLike_disabled() {
        AssertUtil.assertUpsV1();
        return this.like_disabled;
    }

    public boolean isNew_core() {
        AssertUtil.assertUpsV1();
        return this.new_core;
    }

    public boolean isShare_disable() {
        AssertUtil.assertUpsV1();
        return this.share_disable;
    }

    public boolean isVideo_capture() {
        AssertUtil.assertUpsV1();
        return this.video_capture;
    }

    public boolean isYi_plus() {
        AssertUtil.assertUpsV1();
        return this.yi_plus;
    }

    public void setApp_disable(boolean z) {
        this.app_disable = z;
    }

    public void setCircle(boolean z) {
        this.circle = z;
    }

    public void setContinuous(boolean z) {
        this.continuous = z;
    }

    public void setDownload_disable(boolean z) {
        this.download_disable = z;
    }

    public void setHtml5_disable(boolean z) {
        this.html5_disable = z;
    }

    public void setIs_phone_stream(String str) {
        this.is_phone_stream = str;
    }

    public void setLike_disabled(boolean z) {
        this.like_disabled = z;
    }

    public void setNew_core(boolean z) {
        this.new_core = z;
    }

    public void setPlay_mode(int i) {
        this.play_mode = i;
    }

    public void setPlay_u_state(int i) {
        this.play_u_state = i;
    }

    public void setShare_disable(boolean z) {
        this.share_disable = z;
    }

    public void setStream_config(boolean z) {
        this.stream_config = z;
    }

    public void setStream_mode(int i) {
        this.stream_mode = i;
    }

    public void setVideo_capture(boolean z) {
        this.video_capture = z;
    }

    public void setYi_plus(boolean z) {
        this.yi_plus = z;
    }
}
