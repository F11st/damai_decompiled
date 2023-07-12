package com.youku.live.widgets.protocol;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface IEventDispatcher {
    public static final int DISPATCH_MODE_ASYNC = 1;
    public static final int DISPATCH_MODE_SYNC = 0;

    boolean addEventHandler(String str, IEventHandler iEventHandler);

    void deleteEventHandler(String str, IEventHandler iEventHandler);

    void postEvent(int i, String str, Map<String, Object> map);
}
