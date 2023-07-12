package com.ali.user.mobile.eventbus;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class Event {
    public String name;
    public Map<String, Object> params;

    public static Event newEvent(String str, Map<String, Object> map) {
        Event event = new Event();
        event.name = str;
        event.params = map;
        return event;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Event event = (Event) obj;
            String str = this.name;
            if (str == null) {
                return event.name == null;
            }
            return str.equals(event.name);
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        return 31 + (str == null ? 0 : str.hashCode());
    }
}
