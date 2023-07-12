package com.taobao.android.tlog.protocol;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.utils.Base64;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TLogReply {
    private String TAG;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class CreateInstance {
        private static TLogReply instance = new TLogReply();

        private CreateInstance() {
        }
    }

    public static synchronized TLogReply getInstance() {
        TLogReply tLogReply;
        synchronized (TLogReply.class) {
            tLogReply = CreateInstance.instance;
        }
        return tLogReply;
    }

    public CommandInfo parseCommandInfo(byte[] bArr, String str, String str2, String str3) throws Exception {
        JSONObject parseObject = JSON.parseObject(str);
        CommandInfo commandInfo = new CommandInfo();
        commandInfo.forward = bArr;
        commandInfo.serviceId = str3;
        commandInfo.userId = str2;
        if (parseObject.containsKey("type")) {
            commandInfo.msgType = parseObject.getString("type");
        }
        if (parseObject.containsKey("headers")) {
            JSONObject jSONObject = (JSONObject) parseObject.get("headers");
            if (jSONObject.containsKey(Constants.appKeyName)) {
                commandInfo.appKey = jSONObject.getString(Constants.appKeyName);
            }
            if (jSONObject.containsKey(Constants.appIdName)) {
                commandInfo.appId = jSONObject.getString(Constants.appIdName);
            }
            if (jSONObject.containsKey(Constants.requestIdName)) {
                commandInfo.requestId = jSONObject.getString(Constants.requestIdName);
            }
            if (jSONObject.containsKey(Constants.opCodeName)) {
                commandInfo.opCode = jSONObject.getString(Constants.opCodeName);
            }
            if (jSONObject.containsKey(Constants.replyIdName)) {
                commandInfo.replyId = jSONObject.getString(Constants.replyIdName);
            }
            if (jSONObject.containsKey(Constants.replyCode)) {
                commandInfo.replyCode = jSONObject.getString(Constants.replyCode);
            }
            if (jSONObject.containsKey(Constants.sessionIdName)) {
                commandInfo.sessionId = jSONObject.getString(Constants.sessionIdName);
            }
            if (jSONObject.containsKey(Constants.replyMsg)) {
                commandInfo.replyMessage = jSONObject.getString(Constants.replyMsg);
            }
        }
        if (parseObject.containsKey("data")) {
            commandInfo.data = parseObject.getJSONObject("data");
        }
        return commandInfo;
    }

    public String parseContent(String str, String str2, String str3, byte[] bArr) throws Exception {
        return new String(Base64.decode(bArr), "utf-8");
    }

    private TLogReply() {
        this.TAG = "TLogReply";
    }
}
