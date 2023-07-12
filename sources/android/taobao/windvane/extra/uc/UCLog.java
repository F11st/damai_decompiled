package android.taobao.windvane.extra.uc;

import android.taobao.windvane.util.TaoLog;
import com.uc.webview.export.internal.interfaces.INetLogger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class UCLog implements INetLogger {
    private static final int LEVEL_ERROR = 0;
    boolean mEnable = true;
    int level = 0;

    @Override // com.uc.webview.export.internal.interfaces.INetLogger
    public void d(String str, String str2) {
        if ("cancel_log".equals(str)) {
            TaoLog.e("alinetwork", "cancel reason:" + str2);
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.INetLogger
    public void e(String str, String str2) {
        if ("cancel_log".equals(str)) {
            TaoLog.e("alinetwork", "cancel reason:" + str2);
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.INetLogger
    public boolean getEnable() {
        return this.mEnable;
    }

    @Override // com.uc.webview.export.internal.interfaces.INetLogger
    public int getLogLevel() {
        return this.level;
    }

    @Override // com.uc.webview.export.internal.interfaces.INetLogger
    public void i(String str, String str2) {
    }

    @Override // com.uc.webview.export.internal.interfaces.INetLogger
    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    @Override // com.uc.webview.export.internal.interfaces.INetLogger
    public void setLogLevel(int i) {
        this.level = i;
    }

    @Override // com.uc.webview.export.internal.interfaces.INetLogger
    public void w(String str, String str2) {
    }
}
