package com.youku.live.widgets.protocol2.usertacker;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface IUserTracker {
    void pvEnd(Map<String, String> map);

    void pvStart(Map<String, String> map);

    void pvUpdate(Map<String, String> map);

    void setCommonParams(Map<String, String> map);
}
