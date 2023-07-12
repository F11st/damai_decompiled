package com.youku.upsplayer.data;

import com.youku.upsplayer.module.UpsTimeTraceBean;
import com.youku.upsplayer.module.UtAntiTheaftBean;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ConnectStat {
    public String errMsg;
    public Map<String, List<String>> header;
    public MTopUpsRequest mTopUpsRequest;
    public UpsTimeTraceBean mUpsTimeTraceBean;
    public String rawUpsData;
    public Map<String, String> statsMap;
    public String url;
    public int response_code = 0;
    public boolean connect_success = false;
    public long connect_time = 0;
    public long read_time = 0;
    public UtAntiTheaftBean utMsg = null;
}
