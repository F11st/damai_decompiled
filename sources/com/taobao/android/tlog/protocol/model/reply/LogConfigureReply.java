package com.taobao.android.tlog.protocol.model.reply;

import com.ali.user.mobile.ui.WebConstant;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.android.tlog.protocol.builder.HeaderBuilder;
import com.taobao.android.tlog.protocol.builder.UploadDataBuilder;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.reply.base.LogReplyBaseInfo;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LogConfigureReply {
    private String TAG = "TLOG.Protocol.LogConfigureReply";
    private String replyType = "REPLY";
    public UploadTokenInfo tokenInfo;
    public String tokenType;

    public String build(CommandInfo commandInfo, LogReplyBaseInfo logReplyBaseInfo) throws Exception {
        if (logReplyBaseInfo == null) {
            return null;
        }
        Map<String, String> buildReplyHeaders = HeaderBuilder.buildReplyHeaders(commandInfo, logReplyBaseInfo);
        JSONObject jSONObject = new JSONObject();
        String str = this.tokenType;
        if (str != null) {
            jSONObject.put(WebConstant.WEB_LOGIN_TOKEN_TYPE, (Object) str);
        }
        UploadTokenInfo uploadTokenInfo = this.tokenInfo;
        if (uploadTokenInfo != null) {
            jSONObject.put("tokenInfo", (Object) uploadTokenInfo);
        }
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
