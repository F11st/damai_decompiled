package tb;

import android.app.Activity;
import com.taobao.monitor.impl.processor.launcher.LauncherProcessor;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class h91 extends LauncherProcessor {
    public h91() {
    }

    @Override // com.taobao.monitor.impl.processor.launcher.LauncherProcessor, com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityCreated(Activity activity, Map<String, Object> map, long j) {
        super.onActivityCreated(activity, map, j);
        Object obj = map.get("blackPage");
        if (obj == null || !activity.getClass().getName().equals(obj.toString())) {
            return;
        }
        this.d = null;
    }

    public h91(String str) {
        super(str);
    }
}
