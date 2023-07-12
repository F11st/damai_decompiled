package com.alibaba.emas.publish.channel.poplayer;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import androidx.annotation.Keep;
import com.alibaba.emas.publish.EmasPublishService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
@Keep
/* loaded from: classes6.dex */
public class PublishPopJSBridge extends WVApiPlugin {
    private static final String hasUpdateName = "hasUpdate";
    private static final String tag = "EPublish.PopJs";
    private static final String uriName = "uri";

    private void doPopUpdate(String str, WVCallBackContext wVCallBackContext) {
        try {
            JSONObject parseObject = JSON.parseObject(str);
            String string = parseObject.getString("uri");
            Boolean bool = parseObject.getBoolean(hasUpdateName);
            if (string == null) {
                WVResult wVResult = new WVResult();
                wVResult.addData("error", "uri is null");
                wVCallBackContext.error(wVResult);
            } else if (bool == null) {
                WVResult wVResult2 = new WVResult();
                wVResult2.addData("error", "hasUpdate is null");
                wVCallBackContext.error(wVResult2);
            } else {
                EmasPublishService.getInstance().publishPopService.a(string, bool);
                wVCallBackContext.success(new WVResult());
            }
        } catch (Exception unused) {
            wVCallBackContext.error();
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (str2 != null && str2.length() > 0) {
            doPopUpdate(str2, wVCallBackContext);
            return true;
        }
        WVResult wVResult = new WVResult();
        wVResult.addData("error", "params is null or length <= 0");
        wVCallBackContext.error(wVResult);
        return false;
    }
}
