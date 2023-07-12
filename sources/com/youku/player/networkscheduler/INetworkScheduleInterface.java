package com.youku.player.networkscheduler;

import java.util.ArrayList;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface INetworkScheduleInterface {
    boolean getDomainMappingRule(Map<String, String> map);

    boolean resolveIpsFromDomain(String str, ArrayList<String> arrayList);
}
