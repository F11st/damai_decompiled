package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.youku.live.dago.liveplayback.widget.PluginName;
import com.youku.playerservice.axp.modules.history.PlayerHistoryModule;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Fee {
    @JSONField(name = PluginName.AD)
    public int ad;
    @JSONField(name = "own_channel_id")
    public int own_channel_id;
    @JSONField(name = "paid_type")
    public String[] paid_type;
    @JSONField(name = PlayerHistoryModule.INT_SHOW_VIDEO_TYPE)
    public int video_type;
}
