package com.alibaba.aliweex.plugin;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes5.dex */
public class SimpleAudioPlayer extends WVApiPlugin {
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        WXLogUtils.e("SimpleAudioPlayer has been removed, use weex audio module instead.");
        return false;
    }
}
