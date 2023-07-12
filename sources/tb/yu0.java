package tb;

import androidx.annotation.NonNull;
import com.alibaba.android.onescheduler.IGroupPriorityInterceptor;
import com.alibaba.android.onescheduler.IScheduler;
import com.alibaba.android.onescheduler.group.Group;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class yu0 {
    public static final int MAX_GROUP_CONCURRENT_NUM = 10;
    private IScheduler b;
    @NonNull
    private Map<String, Group> a = new ConcurrentHashMap();
    private IGroupPriorityInterceptor c = new dd2();

    public yu0(IScheduler iScheduler) {
        this.b = iScheduler;
    }

    public void a(String str, int i) {
        if (i > 10) {
            wm1.a("concurrents is exceed 10", new Object[0]);
            i = 10;
        }
        Group group = this.a.get(str);
        if (group == null) {
            group = new Group(this.b);
            group.setPriority(this.c.intercept(str));
            this.a.put(str, group);
        }
        group.setConcurrents(i);
    }

    public void b(String str) {
        Group remove = this.a.remove(str);
        if (remove != null) {
            remove.destroy();
        }
    }

    public String c() {
        JSONObject a;
        Set<Map.Entry> entrySet = new HashMap(this.a).entrySet();
        JSONArray jSONArray = new JSONArray();
        if (entrySet != null && entrySet.size() > 0) {
            for (Map.Entry entry : entrySet) {
                String str = (String) entry.getKey();
                Group group = (Group) entry.getValue();
                if (group != null && (a = group.a()) != null) {
                    try {
                        a.put("name", str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jSONArray.put(a);
                }
            }
        }
        return jSONArray.toString();
    }

    public Group d(String str) {
        return this.a.get(str);
    }

    public void e(String str) {
        Group group = this.a.get(str);
        if (group == null) {
            return;
        }
        group.pause();
    }

    public void f(String str) {
        Group group = this.a.get(str);
        if (group == null) {
            return;
        }
        group.resume();
    }
}
