package anet.channel;

import anet.channel.statist.RequestStatistic;
import java.util.List;
import java.util.Map;
import tb.he;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface RequestCb {
    void onDataReceive(he heVar, boolean z);

    void onFinish(int i, String str, RequestStatistic requestStatistic);

    void onResponseCode(int i, Map<String, List<String>> map);
}
