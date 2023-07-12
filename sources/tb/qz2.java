package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.aliweex.IConfigAdapter;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.adapter.IWXJscProcessManager;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class qz2 implements IWXJscProcessManager {
    long a = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;

    @Override // com.taobao.weex.adapter.IWXJscProcessManager
    public boolean enableBackUpThreadCache() {
        IConfigAdapter c = com.alibaba.aliweex.a.l().c();
        if (c == null) {
            return true;
        }
        oz2 j = oz2.j();
        return "true".equals(c.getConfig("android_weex_ext_config", oz2.key_enableBackUpThreadCache, j.i(j.e)));
    }

    @Override // com.taobao.weex.adapter.IWXJscProcessManager
    public boolean enableBackupThread() {
        IConfigAdapter c;
        if (zz2.e() && (c = com.alibaba.aliweex.a.l().c()) != null) {
            oz2 j = oz2.j();
            return "true".equals(c.getConfig("android_weex_ext_config", oz2.key_enableBackUpThread, j.i(j.d)));
        }
        return false;
    }

    @Override // com.taobao.weex.adapter.IWXJscProcessManager
    public long rebootTimeout() {
        IConfigAdapter c = com.alibaba.aliweex.a.l().c();
        if (c == null) {
            return this.a;
        }
        try {
            return Integer.parseInt(c.getConfig("android_weex_ext_config", "rebootJscTimeout", String.valueOf(this.a)));
        } catch (Exception unused) {
            return this.a;
        }
    }

    @Override // com.taobao.weex.adapter.IWXJscProcessManager
    public boolean shouldReboot() {
        if (WXEnvironment.isApkDebugable()) {
            return false;
        }
        IConfigAdapter c = com.alibaba.aliweex.a.l().c();
        if (c == null) {
            return true;
        }
        return "true".equals(c.getConfig("android_weex_ext_config", "enableRebootJsc", "true"));
    }

    @Override // com.taobao.weex.adapter.IWXJscProcessManager
    public boolean withException(WXSDKInstance wXSDKInstance) {
        boolean z;
        Context context;
        if (wXSDKInstance != null && (context = wXSDKInstance.getContext()) != null) {
            String name = context.getClass().getName();
            if (!TextUtils.isEmpty(name)) {
                z = name.contains("WXActivity");
                return !z;
            }
        }
        z = false;
        return !z;
    }
}
