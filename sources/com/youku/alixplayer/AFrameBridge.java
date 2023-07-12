package com.youku.alixplayer;

import androidx.annotation.Keep;
import com.youku.alixplayer.util.SystemSoLoader;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes.dex */
public class AFrameBridge {
    private long mNativeId;

    static {
        SystemSoLoader.load("alixplayer");
    }

    public native List<String> aframeInit();

    public native Map<String, String> aframeInvoke(String str, Map<String, String> map);
}
