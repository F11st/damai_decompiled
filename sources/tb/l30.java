package tb;

import android.util.Log;
import com.alibaba.emas.datalab.DatalabBizType;
import com.alibaba.fastjson.JSON;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class l30 {
    AtomicBoolean a;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    private static class b {
        private static l30 a = new l30();
    }

    public static l30 c() {
        return b.a;
    }

    public void a(String str, DatalabBizType datalabBizType, Set<String> set) {
        try {
            if (!datalabBizType.equals(DatalabBizType.zcache) || set == null) {
                return;
            }
            ((m22) ((m22) ((m22) ((m22) m22.f("zcache-downloadList").d("bizType", datalabBizType.toString())).d("sourceType", str)).d("listValue", JSON.toJSONString(set))).e("dcount", Double.valueOf(1.0d))).h();
        } catch (Exception e) {
            Log.e("Datalab.metricService", "datalab download list", e);
        }
    }

    public void b(String str, DatalabBizType datalabBizType, String str2, String str3) {
        try {
            if (datalabBizType.equals(DatalabBizType.zcache) && str3 != null) {
                ((o22) ((o22) ((o22) ((o22) ((o22) o22.f("zcache-error").d("bizType", datalabBizType.toString())).d("sourceType", str)).d("errorCode", str2)).d("errorMsg", str3)).e("dcount", Double.valueOf(1.0d))).h();
            } else if (datalabBizType.equals(DatalabBizType.update)) {
                ((o22) ((o22) ((o22) ((o22) ((o22) o22.f("update-notify").d("bizType", datalabBizType.toString())).d("sourceType", str)).d("errorCode", str2)).d("errorMsg", str3)).e("dcount", Double.valueOf(1.0d))).h();
            }
        } catch (Exception e) {
            Log.e("Datalab.metricService", "datalab error happen", e);
        }
    }

    public void d() {
        try {
            if (this.a.compareAndSet(false, true)) {
                Log.e("Datalab.metricService", "run: regist data service start ");
                HashSet hashSet = new HashSet();
                hashSet.add("dcount");
                HashSet hashSet2 = new HashSet();
                hashSet2.add("bizType");
                hashSet2.add("sourceType");
                hashSet2.add("listValue");
                m22.f("zcache-downloadList").g(hashSet2, hashSet);
                HashSet hashSet3 = new HashSet();
                hashSet3.add("bizType");
                hashSet3.add("sourceType");
                hashSet3.add("errorCode");
                hashSet3.add("errorMsg");
                o22.f("zcache-error").g(hashSet3, hashSet);
                HashSet hashSet4 = new HashSet();
                hashSet4.add("bizType");
                hashSet4.add("sourceType");
                hashSet4.add("errorCode");
                hashSet4.add("errorMsg");
                o22.f("update-notify").g(hashSet4, hashSet);
                Log.e("Datalab.metricService", "run: regist data service end ");
            }
        } catch (Exception e) {
            Log.e("Datalab.metricService", "datalab data init error", e);
        }
    }

    private l30() {
        this.a = new AtomicBoolean(false);
    }
}
