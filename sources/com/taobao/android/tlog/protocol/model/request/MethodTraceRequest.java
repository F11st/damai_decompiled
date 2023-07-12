package com.taobao.android.tlog.protocol.model.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.joint.point.JointPoint;
import com.taobao.android.tlog.protocol.model.reply.ParseHelper;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MethodTraceRequest {
    private String TAG = "TLOG.Protocol.MethodTraceRequest";
    public Integer maxTrys;
    public Long samplingInterval;
    public JointPoint start;
    public JointPoint stop;
    public String uploadId;
    public Boolean useMmap;

    public void parse(JSON json, CommandInfo commandInfo) throws Exception {
        JointPoint jointPointParse;
        JointPoint jointPointParse2;
        JSONObject jSONObject = (JSONObject) json;
        if (jSONObject.containsKey("samplingInterval")) {
            this.samplingInterval = jSONObject.getLong("samplingInterval");
        }
        if (jSONObject.containsKey("maxTrys")) {
            this.maxTrys = jSONObject.getInteger("maxTrys");
        }
        if (jSONObject.containsKey("useMmap")) {
            this.useMmap = jSONObject.getBoolean("useMmap");
        }
        if (jSONObject.containsKey("uploadId")) {
            this.uploadId = jSONObject.getString("uploadId");
        }
        String str = null;
        if (jSONObject.containsKey("start")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("start");
            String string = (jSONObject2 == null || !jSONObject2.containsKey("type")) ? null : jSONObject2.getString("type");
            if (string != null && (jointPointParse2 = ParseHelper.jointPointParse(string, jSONObject2)) != null) {
                jointPointParse2.type = string;
                this.start = jointPointParse2;
            }
        }
        if (jSONObject.containsKey("stop")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("stop");
            if (jSONObject3 != null && jSONObject3.containsKey("type")) {
                str = jSONObject3.getString("type");
            }
            if (str == null || (jointPointParse = ParseHelper.jointPointParse(str, jSONObject3)) == null) {
                return;
            }
            jointPointParse.type = str;
            this.stop = jointPointParse;
        }
    }
}
