package com.ali.user.mobile.eventbus;

import android.text.TextUtils;
import com.ali.user.mobile.log.TLogAdapter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class EventBus {
    private static final EventBus INSTANCE = new EventBus();
    private final ConcurrentHashMap<String, List<EventListener>> eventListeners = new ConcurrentHashMap<>();

    public static EventBus getDefault() {
        return INSTANCE;
    }

    public void registerEventListener(String str, EventListener eventListener) {
        if ((eventListener == null) || (str == null)) {
            return;
        }
        List<EventListener> list = this.eventListeners.get(str);
        if (list == null) {
            this.eventListeners.putIfAbsent(str, new CopyOnWriteArrayList());
            list = this.eventListeners.get(str);
        }
        list.add(eventListener);
    }

    public void sendEvent(String str) {
        sendEvent(str, null);
    }

    public void unregisterEventListener(String str, EventListener eventListener) {
        List<EventListener> list = this.eventListeners.get(str);
        if (list == null) {
            return;
        }
        list.remove(eventListener);
    }

    public void sendEvent(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sendEvent(Event.newEvent(str, map));
    }

    private void sendEvent(Event event) {
        List<EventListener> list = this.eventListeners.get(event.name);
        if (list == null || list.size() == 0) {
            return;
        }
        for (EventListener eventListener : list) {
            try {
                eventListener.onEvent(event);
            } catch (Throwable th) {
                TLogAdapter.e("eventBus", "fail to execute the event " + event.name + " the error message is " + th.getMessage(), th);
            }
        }
    }
}
