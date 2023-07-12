package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.store.LogStoreMgr;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.motu.tbrest.rest.RestConstants;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class za1 {
    public static void a(Map<String, String> map) {
        boolean z;
        Logger.q();
        if (map != null) {
            String str = map.get(LogField.EVENTID.toString());
            if (!map.containsKey(RestConstants.LogContentKeys.PRIORITY) && ("2201".equalsIgnoreCase(str) || "2202".equalsIgnoreCase(str))) {
                map.put(RestConstants.LogContentKeys.PRIORITY, "4");
            }
            String remove = map.containsKey(RestConstants.LogContentKeys.PRIORITY) ? map.remove(RestConstants.LogContentKeys.PRIORITY) : "3";
            String a = ya1.b().a(str);
            if (!TextUtils.isEmpty(a)) {
                remove = a;
            }
            if (map.containsKey(RestConstants.PrivateLogFields.SEND_LOG_SYNC)) {
                map.remove(RestConstants.PrivateLogFields.SEND_LOG_SYNC);
                z = true;
            } else {
                z = false;
            }
            int i = bt2.g().k() ? bt2.g().i(map) : 0;
            qa1 qa1Var = new qa1(remove, null, str, map);
            if (i > 0) {
                Logger.f("", "topicId", Integer.valueOf(i));
                qa1Var.e(i);
                com.alibaba.analytics.core.sync.e.h().f(qa1Var);
            }
            if (z) {
                LogStoreMgr.l().e(qa1Var);
            } else {
                LogStoreMgr.l().d(qa1Var);
            }
        }
    }
}
