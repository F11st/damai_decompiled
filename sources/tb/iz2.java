package tb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.motu.crashreporter.IUTCrashCaughtListener;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class iz2 implements IUTCrashCaughtListener {
    private String a = "";
    private String b = "";
    private String c = "";

    private void a() {
        List<JSONObject> componentsExceedGPULimit;
        if (TextUtils.isEmpty(this.c) || (componentsExceedGPULimit = WXSDKManager.v().y(this.c).getComponentsExceedGPULimit()) == null || componentsExceedGPULimit.isEmpty()) {
            return;
        }
        this.b = componentsExceedGPULimit.toString();
    }

    public void b(String str) {
        this.a = str;
    }

    public void c(String str) {
        this.c = str;
    }

    @Override // com.alibaba.motu.crashreporter.IUTCrashCaughtListener
    public Map<String, Object> onCrashCaught(Thread thread, Throwable th) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.a)) {
            hashMap.put(WXEnvironment.WEEX_CURRENT_KEY, this.a);
        }
        a();
        if (!TextUtils.isEmpty(this.b)) {
            hashMap.put("wx_exceed_limit_component_info", this.b);
        }
        return hashMap;
    }
}
