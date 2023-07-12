package tb;

import android.util.Log;
import com.alibaba.emas.datalab.metrics.listener.DatalabMetricListener;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class o30 {
    private static String b = "DatalabMetricService";
    private List<DatalabMetricListener> a;

    /* compiled from: Taobao */
    /* renamed from: tb.o30$b */
    /* loaded from: classes6.dex */
    private static class C9503b {
        private static o30 a = new o30();
    }

    public static o30 a() {
        return C9503b.a;
    }

    public List<DatalabMetricListener> b() {
        return this.a;
    }

    public Boolean c(DatalabMetricListener datalabMetricListener) {
        if (datalabMetricListener != null) {
            try {
                this.a.add(datalabMetricListener);
            } catch (Exception e) {
                Log.e(b, "regist failure ", e);
            }
        }
        return Boolean.TRUE;
    }

    private o30() {
        this.a = new ArrayList();
    }
}
