package com.taobao.android.tlog.protocol.model.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.joint.point.JointPoint;
import com.taobao.android.tlog.protocol.model.reply.ParseHelper;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class HeapDumpRequest {
    private String TAG = "TLOG.Protocol.LogUploadRequest";
    public Boolean allowForeground;
    public Integer heapSizeThreshold;
    public JointPoint start;
    public String uploadId;

    public void parse(JSON json, CommandInfo commandInfo) throws Exception {
        JointPoint jointPointParse;
        JSONObject jSONObject = (JSONObject) json;
        if (jSONObject.containsKey("allowForeground")) {
            this.allowForeground = jSONObject.getBoolean("allowForeground");
        }
        if (jSONObject.containsKey("heapSizeThreshold")) {
            this.heapSizeThreshold = jSONObject.getInteger("heapSizeThreshold");
        }
        if (jSONObject.containsKey("uploadId")) {
            this.uploadId = jSONObject.getString("uploadId");
        }
        if (jSONObject.containsKey("uploadId")) {
            this.uploadId = jSONObject.getString("uploadId");
        }
        if (jSONObject.containsKey("start")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("start");
            String str = null;
            if (jSONObject2 != null && jSONObject2.containsKey("type")) {
                str = jSONObject2.getString("type");
            }
            if (str == null || (jointPointParse = ParseHelper.jointPointParse(str, jSONObject2)) == null) {
                return;
            }
            jointPointParse.type = str;
            this.start = jointPointParse;
        }
    }
}
