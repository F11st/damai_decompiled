package com.youku.upsplayer.module;

import com.ali.user.mobile.login.model.LoginConstant;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class StreamExt {
    @JSONField(name = "chinaDrmExtInf")
    public String chinaDrmExtInf;
    @JSONField(name = "copyright_key")
    public String copyright_key;
    @JSONField(name = "dofConfigFile")
    public String dofConfigFile;
    @JSONField(name = "hls_logo")
    public String hls_logo;
    @JSONField(name = "hls_subtitle")
    public String hls_subtitle;
    @JSONField(name = "iv")
    public String iv;
    @JSONField(name = "one_seg_flag")
    public int one_seg_flag;
    @JSONField(name = "playConfig")
    public JSONObject playconf;
    @JSONField(name = "rotationAngle6dof")
    public String rotationAngle6dof;
    @JSONField(name = "skipCnt")
    public int skipCnt = -1;
    @JSONField(name = LoginConstant.START_TIME)
    public double start_time = -1.0d;
    @JSONField(name = "subtitle_lang")
    public String subtitle_lang;
    @JSONField(name = "type")
    public String type;
    @JSONField(name = "uri")
    public String uri;
}
