package com.youku.danmaku.engine.danmaku.loader.android;

import com.youku.danmaku.engine.danmaku.loader.ILoader;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmakuLoaderFactory {
    public static String TAG_ACFUN = "acfun";
    public static String TAG_BILI = "bili";

    public static ILoader create(String str) {
        if (TAG_BILI.equalsIgnoreCase(str)) {
            return BiliDanmakuLoader.instance();
        }
        if (TAG_ACFUN.equalsIgnoreCase(str)) {
            return AcFunDanmakuLoader.instance();
        }
        return null;
    }
}
