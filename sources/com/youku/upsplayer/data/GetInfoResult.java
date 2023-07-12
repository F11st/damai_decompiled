package com.youku.upsplayer.data;

import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class GetInfoResult {
    public ConnectStat connectStat;
    public String data;
    public Map<String, List<String>> header;

    public GetInfoResult(String str, Map<String, List<String>> map, ConnectStat connectStat) {
        this.data = null;
        this.header = null;
        this.connectStat = null;
        this.data = str;
        this.header = map;
        this.connectStat = connectStat;
    }
}
