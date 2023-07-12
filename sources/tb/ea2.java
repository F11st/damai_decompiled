package tb;

import com.alibaba.appmonitor.event.EventType;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ea2 {
    public static final String TNET_REQUEST_SEND_OFFLINE = "tnet_request_send";
    public static final String UPLOAD_TRAFFIC_OFFLINE = "upload_traffic";
    private static HashMap<Integer, String> g = null;
    public static int h = 0;
    public static int i = 0;
    public static int j = 0;
    public static int k = 0;
    public static int l = 0;
    public static int m = 0;
    public static final String module = "AppMonitor";
    public static int n;
    public static int o;
    public static int p;
    public static int q;
    public static int r;
    public static int s;
    public String a;
    public EventType b;
    public String c;
    public Double d;
    public DimensionValueSet e;
    public MeasureValueSet f;

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        g = hashMap;
        h = 1;
        i = 2;
        j = 3;
        k = 4;
        l = 5;
        m = 6;
        n = 7;
        o = 8;
        p = 9;
        q = 10;
        r = 11;
        s = 12;
        hashMap.put(1, "sampling_monitor");
        g.put(Integer.valueOf(i), "db_clean");
        g.put(Integer.valueOf(l), "db_monitor");
        g.put(Integer.valueOf(j), "upload_failed");
        g.put(Integer.valueOf(k), UPLOAD_TRAFFIC_OFFLINE);
        g.put(Integer.valueOf(m), "config_arrive");
        g.put(Integer.valueOf(n), TNET_REQUEST_SEND_OFFLINE);
        g.put(Integer.valueOf(o), "tnet_create_session");
        g.put(Integer.valueOf(p), "tnet_request_timeout");
        g.put(Integer.valueOf(q), "tent_request_error");
        g.put(Integer.valueOf(r), "datalen_overflow");
        g.put(Integer.valueOf(s), "logs_timeout");
    }

    private ea2(String str, String str2, Double d) {
        this.a = "";
        this.b = null;
        this.a = str;
        this.c = str2;
        this.d = d;
        this.b = EventType.COUNTER;
    }

    public static ea2 a(int i2, String str, Double d) {
        return new ea2(b(i2), str, d);
    }

    private static String b(int i2) {
        return g.get(Integer.valueOf(i2));
    }

    public String toString() {
        return "SelfMonitorEvent{arg='" + this.c + "', monitorPoint='" + this.a + "', type=" + this.b + ", value=" + this.d + ", dvs=" + this.e + ", mvs=" + this.f + '}';
    }
}
