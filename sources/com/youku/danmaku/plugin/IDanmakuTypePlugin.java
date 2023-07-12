package com.youku.danmaku.plugin;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.Duration;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDanmakuTypePlugin {
    public static final int DANMAKU_DEFAULT_SUB_TYPE = -1;
    public static final int DANMAKU_GUIDE_SUB_TYPE = -3;
    public static final int DANMAKU_SPECIAL_STOP_SUB_TYPE = -2;

    BaseDanmaku getDanmakuInstance(int i, int i2, Duration duration);

    BaseDanmaku getDanmakuInstance(int i, int i2, Duration duration, IDanmakuSettingPlugin iDanmakuSettingPlugin);
}
