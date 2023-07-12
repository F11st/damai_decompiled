package com.youku.danmaku.plugin;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDanmakuDataPlugin {
    public static final int DANMAKU_REFRESH_MODE_APPEND = 1;
    public static final int DANMAKU_REFRESH_MODE_REPLACE = 0;
    public static final String DATA_QUERY_KEY = "queryKey";
    public static final String DATA_QUERY_MINUTE = "queryMinute";
    public static final String DATA_QUERY_SECOND = "querySecond";

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface DanmakuDataCallback {
        void onGetDanmakuList(long j, List<BaseDanmaku> list);
    }

    int getDanmakuRefreshMode();

    void triggerFetchDataWithParams(Map<String, Object> map, long j, DanmakuDataCallback danmakuDataCallback);
}
