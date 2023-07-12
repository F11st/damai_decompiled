package com.youku.live.dsl.alarm;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IYoukuLiveAlarm {
    void commitFail(String str, String str2, String str3);

    void commitFail(String str, String str2, String str3, Map<String, String> map);

    void commitSuccess(String str, String str2);

    void commitSuccess(String str, String str2, Map<String, String> map);
}
