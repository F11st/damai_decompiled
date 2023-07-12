package android.taobao.windvane.extra.uc;

import android.taobao.windvane.fullspan.SpanWrapper;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.WVUrlUtil;
import android.webkit.ValueCallback;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.android.IDiagnoseInterface;
import com.taobao.android.diagnose.scene.engine.api.Facts;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class UCCoreController {
    private static final String TAG = "UCCoreController";
    private static final AtomicBoolean sRegisteredThreadANRCallback = new AtomicBoolean(false);

    public static void registerThreadANRCallback(final SpanWrapper spanWrapper) {
        if (sRegisteredThreadANRCallback.compareAndSet(false, true)) {
            spanWrapper.log("registerThreadANRCallback");
            new ValueCallback<Map<String, Object>>() { // from class: android.taobao.windvane.extra.uc.UCCoreController.1
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(Map<String, Object> map) {
                    try {
                        String str = "ThreadWatchdog get callback. pid: " + ((Integer) map.get("pid")).intValue() + AVFSCacheConstants.COMMA_SEP + "tid: " + ((Integer) map.get("tid")).intValue() + AVFSCacheConstants.COMMA_SEP + "threadName: " + ((String) map.get("threadName")) + AVFSCacheConstants.COMMA_SEP + "state: " + ((String) map.get("state")) + AVFSCacheConstants.COMMA_SEP + "type: " + ((String) map.get("type")) + AVFSCacheConstants.COMMA_SEP + "url: " + ((String) map.get("url")) + AVFSCacheConstants.COMMA_SEP + "webviewCount: " + ((Integer) map.get("webviewCount")).intValue() + AVFSCacheConstants.COMMA_SEP + "taskInfo: " + ((String) map.get("taskInfo")) + AVFSCacheConstants.COMMA_SEP + "elapseInMs: " + ((Integer) map.get("elapseInMs")).intValue() + AVFSCacheConstants.COMMA_SEP + "alarmInMs: " + ((Integer) map.get("alarmInMs")).intValue() + AVFSCacheConstants.COMMA_SEP + "stack: " + ((String) map.get("stack"));
                        SpanWrapper.this.log(str);
                        String removeQueriesUrl = WVUrlUtil.getRemoveQueriesUrl((String) map.get("url"));
                        AppMonitorUtil.commitFail("ThreadWatchdog", 0, removeQueriesUrl, str);
                        Facts facts = new Facts();
                        facts.put("url", removeQueriesUrl);
                        facts.put("threadName", (String) map.get("threadName"));
                        IDiagnoseInterface.getInstance().sceneTrigger("windvane_render_timeout", facts);
                    } catch (Throwable th) {
                        AppMonitorUtil.commitFail("ThreadWatchdog", 1, WVUrlUtil.getRemoveQueriesUrl((String) map.get("url")), "err:" + th + " StackTrace::" + CommonUtils.getStackTrace(th));
                    }
                }
            };
        }
    }
}
