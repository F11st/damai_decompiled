package com.youku.gaiax.provider.module.js;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.hh1;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/provider/module/js/MotuJSErrorReportUtils;", "", "", "messageCode", "message", "Ltb/wt2;", "sendGaiaXJSError", "msg", "sendError", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class MotuJSErrorReportUtils {
    @NotNull
    public static final MotuJSErrorReportUtils INSTANCE = new MotuJSErrorReportUtils();

    private MotuJSErrorReportUtils() {
    }

    private final void sendGaiaXJSError(String str, String str2) {
    }

    public final void sendError(@NotNull String str) {
        b41.i(str, "msg");
        try {
            JSONObject parseObject = JSON.parseObject(str);
            String string = parseObject.getString(hh1.DIMEN_BIZ);
            String string2 = parseObject.getString("templateId");
            String string3 = parseObject.getString("templateVersion");
            String string4 = parseObject.getString("message");
            b41.h(string4, "message");
            sendGaiaXJSError(((Object) string) + "##" + ((Object) string2) + "##" + ((Object) string3) + "##" + ((Object) string4), string4);
        } catch (Exception unused) {
        }
    }
}
