package com.taobao.android.tlog.protocol.model.reply;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.android.tlog.protocol.builder.HeaderBuilder;
import com.taobao.android.tlog.protocol.builder.UploadDataBuilder;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.reply.base.LogReplyBaseInfo;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class UserDefineUploadReply {
    private String TAG = "TLOG.Protocol.UserDefineUploadReply";
    private String replyType = "REPLY";

    public String build(CommandInfo commandInfo, LogReplyBaseInfo logReplyBaseInfo) throws Exception {
        if (logReplyBaseInfo == null) {
            return null;
        }
        Map<String, String> buildReplyHeaders = HeaderBuilder.buildReplyHeaders(commandInfo, logReplyBaseInfo);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (commandInfo.forward != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("content", new String(commandInfo.forward, "utf-8"));
            jSONObject2.put("forward", (Object) linkedHashMap);
        }
        jSONObject2.put("version", (Object) Constants.version);
        jSONObject2.put("type", (Object) this.replyType);
        jSONObject2.put("headers", (Object) buildReplyHeaders);
        jSONObject2.put("data", (Object) jSONObject);
        return UploadDataBuilder.buildLogUploadContent(jSONObject2.toString());
    }
}
