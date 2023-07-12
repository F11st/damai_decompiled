package com.taobao.ma.core;

import com.taobao.ma.common.config.MaConfig;
import com.taobao.ma.common.log.LogLevel;
import com.taobao.ma.common.log.MaLogger;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Ma {
    private static MaConfig mConfig = new MaConfig();
    private static Map<String, String> utMap = new HashMap();

    public static MaConfig getMaConfig() {
        return mConfig;
    }

    public static Map<String, String> getUtMap() {
        return utMap;
    }

    public static void init() {
        init(null);
    }

    private static void initUtMap() {
        utMap.put("utdid", mConfig.utdid);
        utMap.put("appkey", mConfig.appkey);
    }

    public static void init(MaConfig maConfig) {
        if (maConfig == null) {
            return;
        }
        mConfig = maConfig;
        if (maConfig.isDebug) {
            MaLogger.setLogLevel(LogLevel.DEBUG);
        }
        initUtMap();
    }
}
