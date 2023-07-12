package tb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class c31 {
    private List<String> listenEvents = new ArrayList();

    public void addInterceptEvent(String str) {
        if (this.listenEvents.contains(str)) {
            return;
        }
        this.listenEvents.add(str);
    }

    public List<String> getListenEvents() {
        return this.listenEvents;
    }

    public abstract void onFireEvent(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2);

    public void onInterceptFireEvent(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        if (map != null && this.listenEvents.contains(str3)) {
            onFireEvent(str, str2, str3, map, map2);
        }
    }
}
