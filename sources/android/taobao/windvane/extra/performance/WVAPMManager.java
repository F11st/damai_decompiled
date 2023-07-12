package android.taobao.windvane.extra.performance;

import com.taobao.monitor.performance.IWXApmAdapter;
import java.util.Map;
import tb.C8890a0;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVAPMManager {
    private static int index;
    private IWXApmAdapter apmAdapter;

    public WVAPMManager(String str) {
        try {
            this.apmAdapter = C8890a0.a().createApmAdapterByType(str);
        } catch (Throwable unused) {
        }
    }

    public void addBiz(String str, Map<String, Object> map) {
    }

    public void addBizAbTest(String str, Map<String, Object> map) {
    }

    public void addBizStage(String str, Map<String, Object> map) {
    }

    public void addProperty(String str, Object obj) {
        IWXApmAdapter iWXApmAdapter = this.apmAdapter;
        if (iWXApmAdapter == null) {
            return;
        }
        iWXApmAdapter.addProperty(str, obj);
    }

    public void addStatistic(String str, double d) {
        IWXApmAdapter iWXApmAdapter = this.apmAdapter;
        if (iWXApmAdapter == null) {
            return;
        }
        iWXApmAdapter.addStatistic(str, d);
    }

    public void onEnd() {
        IWXApmAdapter iWXApmAdapter = this.apmAdapter;
        if (iWXApmAdapter == null) {
            return;
        }
        iWXApmAdapter.onEnd();
    }

    public void onEvent(String str, Object obj) {
    }

    public void onStage(String str, long j) {
        IWXApmAdapter iWXApmAdapter = this.apmAdapter;
        if (iWXApmAdapter == null) {
            return;
        }
        iWXApmAdapter.onStage(str, j);
    }

    public void onStart(String str) {
        IWXApmAdapter iWXApmAdapter = this.apmAdapter;
        if (iWXApmAdapter == null) {
            return;
        }
        iWXApmAdapter.onStart(str);
    }

    public void onStop() {
        IWXApmAdapter iWXApmAdapter = this.apmAdapter;
        if (iWXApmAdapter == null) {
            return;
        }
        iWXApmAdapter.onStop();
    }

    public void onStart() {
        StringBuilder sb = new StringBuilder();
        sb.append("WV_");
        int i = index;
        index = i + 1;
        sb.append(i);
        onStart(sb.toString());
    }
}
