package com.taobao.tao.log.upload;

import android.content.Context;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UploaderParam extends CommandInfo {
    public Map<String, String> params;
    public Context context = null;
    public String appVersion = null;
    public String logFilePathTmp = null;
    public String fileContentType = null;

    public void build(CommandInfo commandInfo) {
        if (commandInfo != null) {
            this.appKey = commandInfo.appKey;
            this.appId = commandInfo.appId;
            this.userId = commandInfo.userId;
            this.serviceId = commandInfo.serviceId;
            this.requestId = commandInfo.requestId;
            this.replyId = commandInfo.replyId;
            this.sessionId = commandInfo.sessionId;
            this.replyCode = commandInfo.replyCode;
            this.replyMessage = commandInfo.replyMessage;
            this.opCode = commandInfo.opCode;
            this.data = commandInfo.data;
        }
    }
}
