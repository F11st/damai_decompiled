package tb;

import android.util.Log;
import com.alibaba.emas.datalab.metrics.listener.DatalabMetricListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class n30 implements DatalabMetricListener {
    public static String a = "yyyy-MM-dd HH:mm:ss";

    @Override // com.alibaba.emas.datalab.metrics.listener.DatalabMetricListener
    public void dataCommit(String str, String str2, Map<String, String> map, Map<String, Double> map2) {
        if (str != null && str2 != null) {
            try {
                if (str.equals("DataLab-ResourceDownload") && str2.equals("zcacheUpdate")) {
                    Log.i("metricListener", ">>>>>>>>>> remove datalab commit data, module: " + str + " point: " + str2);
                    return;
                }
                HashMap hashMap = new HashMap();
                if (map != null) {
                    hashMap.putAll(map);
                }
                if (map2 != null) {
                    hashMap.putAll(map2);
                }
                Log.i("metricListener", ">>>>>>>>>> datalab commit data, module: " + str + " point: " + str2);
                new SimpleDateFormat(a).format(new Date());
            } catch (Exception e) {
                Log.e("metricListener", "data commit error ", e);
            } catch (UnsatisfiedLinkError unused) {
            }
        }
    }
}
