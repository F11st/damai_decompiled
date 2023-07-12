package tb;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.monitor.impl.processor.IProcessorFactory;
import com.taobao.monitor.impl.processor.launcher.LauncherProcessor;
import com.taobao.monitor.network.UploadStorage;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class j81 implements IProcessorFactory<LauncherProcessor> {
    private void c() {
        if (jd0.i) {
            return;
        }
        SharedPreferences.Editor edit = fu0.e().a().getSharedPreferences(xu1.DEFAULT_SAVE_DIR, 0).edit();
        edit.putString(nu2.KEY_LAST_LAUNCH_SESSION, "");
        edit.apply();
    }

    private void d() {
        boolean z = lu0.r != 1;
        lu0.r = 1;
        if (jd0.E) {
            UploadStorage.a().e(new nu2(z));
            UploadStorage.a().f(true);
        }
    }

    public LauncherProcessor a(String str) {
        d();
        c();
        if (TextUtils.isEmpty(str)) {
            if (jd0.i) {
                return new h91();
            }
            return null;
        } else if (jd0.i) {
            return new h91(str);
        } else {
            return null;
        }
    }

    @Override // com.taobao.monitor.impl.processor.IProcessorFactory
    /* renamed from: b */
    public LauncherProcessor createProcessor() {
        d();
        c();
        if (jd0.i) {
            return new LauncherProcessor();
        }
        return null;
    }
}
