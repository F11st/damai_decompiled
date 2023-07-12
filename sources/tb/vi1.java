package tb;

import com.alibaba.motu.crashreporter.IUTCrashCaughtListener;
import com.taobao.updatecenter.hotpatch.HotPatchManager;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vi1 implements IUTCrashCaughtListener {
    long a;

    public vi1(long j) {
        this.a = j;
    }

    @Override // com.alibaba.motu.crashreporter.IUTCrashCaughtListener
    public Map<String, Object> onCrashCaught(Thread thread, Throwable th) {
        if (thread == null && th == null) {
            if (System.currentTimeMillis() - this.a <= 10000) {
                HotPatchManager.getInstance().setNativeCrashFlag();
                HotPatchManager.getInstance().cleanPatchs(true);
                return null;
            }
            return null;
        } else if (th != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            th.printStackTrace(new PrintStream(byteArrayOutputStream));
            HotPatchManager.getInstance().setJavaCrashFlag(byteArrayOutputStream.toString().contains("_CF_"));
            return null;
        } else {
            return null;
        }
    }
}
