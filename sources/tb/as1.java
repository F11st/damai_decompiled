package tb;

import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.ImageStageDispatcher;
import com.taobao.phenix.lifecycle.IPhenixLifeCycle;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.uc.webview.export.media.MessageID;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class as1 implements IPhenixLifeCycle {
    private ImageStageDispatcher a = null;

    public as1() {
        a();
    }

    private void a() {
        IDispatcher b = ca0.b(C8934b0.IMAGE_STAGE_DISPATCHER);
        if (b instanceof ImageStageDispatcher) {
            this.a = (ImageStageDispatcher) b;
        }
    }

    private void b(Map map) {
        if (jd0.d) {
            e30.a("image", map);
        }
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onCancel(String str, String str2, Map<String, Object> map) {
        if (!ca0.c(this.a)) {
            this.a.f(3);
        }
        HashMap hashMap = new HashMap(map);
        hashMap.put("procedureName", "ImageLib");
        hashMap.put(TLogEventConst.PARAM_UPLOAD_STAGE, "onCancel");
        hashMap.put("requestId", str);
        hashMap.put("requestUrl", str2);
        b(hashMap);
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onError(String str, String str2, Map<String, Object> map) {
        if (!ca0.c(this.a)) {
            this.a.f(2);
        }
        HashMap hashMap = new HashMap(map);
        hashMap.put("procedureName", "ImageLib");
        hashMap.put(TLogEventConst.PARAM_UPLOAD_STAGE, MessageID.onError);
        hashMap.put("requestId", str);
        hashMap.put("requestUrl", str2);
        b(hashMap);
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onEvent(String str, String str2, Map<String, Object> map) {
        String b = map != null ? t52.b(map.get("requestUrl"), "") : null;
        HashMap hashMap = new HashMap(map);
        hashMap.put("procedureName", "ImageLib");
        hashMap.put(TLogEventConst.PARAM_UPLOAD_STAGE, str2);
        hashMap.put("requestId", str);
        hashMap.put("requestUrl", b);
        b(hashMap);
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onFinished(String str, String str2, Map<String, Object> map) {
        if (!ca0.c(this.a)) {
            this.a.f(1);
        }
        HashMap hashMap = new HashMap(map);
        hashMap.put("procedureName", "ImageLib");
        hashMap.put(TLogEventConst.PARAM_UPLOAD_STAGE, "onFinished");
        hashMap.put("requestId", str);
        hashMap.put("requestUrl", str2);
        b(hashMap);
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onRequest(String str, String str2, Map<String, Object> map) {
        if (!ca0.c(this.a)) {
            this.a.f(0);
        }
        try {
            HashMap hashMap = new HashMap(map);
            hashMap.put("procedureName", "ImageLib");
            hashMap.put(TLogEventConst.PARAM_UPLOAD_STAGE, "onRequest");
            hashMap.put("requestId", str);
            hashMap.put("requestUrl", str2);
            b(hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
