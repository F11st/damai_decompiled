package tb;

import com.taobao.android.ultron.common.model.IDMEvent;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class r32 {
    public static void a(Map<String, List<IDMEvent>> map) {
        List<IDMEvent> value;
        if (map == null) {
            return;
        }
        for (Map.Entry<String, List<IDMEvent>> entry : map.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                for (IDMEvent iDMEvent : value) {
                    if (iDMEvent != null) {
                        iDMEvent.record();
                    }
                }
            }
        }
    }

    public static void b(Map<String, List<IDMEvent>> map) {
        List<IDMEvent> value;
        if (map == null) {
            return;
        }
        for (Map.Entry<String, List<IDMEvent>> entry : map.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                for (IDMEvent iDMEvent : value) {
                    if (iDMEvent != null) {
                        iDMEvent.rollBack();
                    }
                }
            }
        }
    }
}
