package com.taobao.android.tlog.protocol.builder;

import com.taobao.android.tlog.protocol.Constants;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.reply.base.LogReplyBaseInfo;
import com.taobao.android.tlog.protocol.utils.RandomIdUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class HeaderBuilder {
    public static Map<String, String> buildReplyHeaders(CommandInfo commandInfo, LogReplyBaseInfo logReplyBaseInfo) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = logReplyBaseInfo.appKey;
        if (str != null) {
            linkedHashMap.put(Constants.appKeyName, str);
        }
        String str2 = logReplyBaseInfo.appId;
        if (str2 != null) {
            linkedHashMap.put(Constants.appIdName, str2);
        }
        String str3 = logReplyBaseInfo.utdid;
        if (str3 != null) {
            linkedHashMap.put(Constants.deviceIdName, str3);
        }
        String str4 = commandInfo.requestId;
        if (str4 != null) {
            linkedHashMap.put(Constants.requestIdName, str4);
        }
        linkedHashMap.put(Constants.replyIdName, RandomIdUtils.getRandomId());
        linkedHashMap.put(Constants.sessionIdName, RandomIdUtils.getRandomId());
        linkedHashMap.put(Constants.opCodeName, logReplyBaseInfo.replyOpCode);
        String str5 = logReplyBaseInfo.replyCode;
        if (str5 != null) {
            linkedHashMap.put(Constants.replyCode, str5);
        }
        String str6 = logReplyBaseInfo.replyMsg;
        if (str6 != null) {
            linkedHashMap.put(Constants.replyMsg, str6);
        }
        return linkedHashMap;
    }
}
