package tb;

import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.store.LogStoreMgr;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.appmonitor.model.UTDimensionValueSet;
import com.alibaba.appmonitor.pool.ReuseJSONArray;
import com.alibaba.fastjson.JSON;
import com.alibaba.motu.tbrest.rest.RestConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class gt2 {
    public static void a(vs2 vs2Var) {
        if (vs2Var == null) {
            return;
        }
        LogStoreMgr.l().d(new qa1(vs2Var.a, String.valueOf(vs2Var.b), vs2Var.c, vs2Var.d, vs2Var.e, vs2Var.f));
        com.alibaba.appmonitor.pool.a.a().offer(vs2Var);
    }

    public static void b(UTDimensionValueSet uTDimensionValueSet, qf0 qf0Var) {
        Integer eventId = uTDimensionValueSet.getEventId();
        if (eventId != null) {
            EventType eventType = EventType.getEventType(eventId.intValue());
            vs2 vs2Var = (vs2) com.alibaba.appmonitor.pool.a.a().poll(vs2.class, new Object[0]);
            vs2Var.b = RestConstants.EventID.AGGREGATION_LOG;
            vs2Var.c = qf0Var.a;
            vs2Var.d = qf0Var.b;
            vs2Var.f.putAll(com.alibaba.appmonitor.delegate.a.c());
            if (uTDimensionValueSet.getMap() != null) {
                vs2Var.f.putAll(uTDimensionValueSet.getMap());
                vs2Var.f.remove("commitDay");
            }
            HashMap hashMap = new HashMap();
            hashMap.put("meta", p72.b());
            hashMap.put("_event_id", eventId);
            ReuseJSONArray reuseJSONArray = (ReuseJSONArray) com.alibaba.appmonitor.pool.a.a().poll(ReuseJSONArray.class, new Object[0]);
            reuseJSONArray.add(qf0Var.b());
            com.alibaba.appmonitor.pool.a.a().offer(qf0Var);
            hashMap.put("data", reuseJSONArray);
            vs2Var.f.put(eventType.getAggregateEventArgsKey(), JSON.toJSONString(hashMap));
            vs2Var.f.put(LogField.EVENTID.toString(), String.valueOf((int) RestConstants.EventID.AGGREGATION_LOG));
            c(vs2Var);
            com.alibaba.appmonitor.pool.a.a().offer(reuseJSONArray);
        }
    }

    public static void c(vs2 vs2Var) {
        LogStoreMgr.l().d(new qa1(vs2Var.a, String.valueOf(vs2Var.b), vs2Var.c, vs2Var.d, vs2Var.e, vs2Var.f));
        com.alibaba.appmonitor.pool.a.a().offer(vs2Var);
    }

    public static void d(Map<UTDimensionValueSet, List<qf0>> map) {
        Integer eventId;
        for (Map.Entry<UTDimensionValueSet, List<qf0>> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            UTDimensionValueSet key = entry.getKey();
            List<qf0> value = entry.getValue();
            if (value.size() != 0 && (eventId = key.getEventId()) != null) {
                EventType eventType = EventType.getEventType(eventId.intValue());
                int i = 0;
                vs2 vs2Var = (vs2) com.alibaba.appmonitor.pool.a.a().poll(vs2.class, new Object[0]);
                vs2Var.b = eventId.intValue();
                vs2Var.f.putAll(com.alibaba.appmonitor.delegate.a.c());
                if (key.getMap() != null) {
                    vs2Var.f.putAll(key.getMap());
                    vs2Var.f.remove("commitDay");
                }
                HashMap hashMap = new HashMap();
                hashMap.put("meta", p72.b());
                ReuseJSONArray reuseJSONArray = (ReuseJSONArray) com.alibaba.appmonitor.pool.a.a().poll(ReuseJSONArray.class, new Object[0]);
                for (qf0 qf0Var : value) {
                    reuseJSONArray.add(qf0Var.b());
                    if (i == 0) {
                        sb.append(qf0Var.a);
                        sb2.append(qf0Var.b);
                    } else {
                        sb.append(",");
                        sb.append(qf0Var.a);
                        sb2.append(",");
                        sb2.append(qf0Var.b);
                    }
                    i++;
                    com.alibaba.appmonitor.pool.a.a().offer(qf0Var);
                }
                hashMap.put("data", reuseJSONArray);
                vs2Var.f.put(eventType.getAggregateEventArgsKey(), JSON.toJSONString(hashMap));
                String sb3 = sb.toString();
                String sb4 = sb2.toString();
                vs2Var.f.put(LogField.ARG1.toString(), sb3);
                vs2Var.f.put(LogField.ARG2.toString(), sb4);
                vs2Var.c = sb3;
                vs2Var.d = sb4;
                c(vs2Var);
                com.alibaba.appmonitor.pool.a.a().offer(reuseJSONArray);
            }
            com.alibaba.appmonitor.pool.a.a().offer(key);
        }
    }
}
