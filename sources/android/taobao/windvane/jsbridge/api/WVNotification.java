package android.taobao.windvane.jsbridge.api;

import android.media.ToneGenerator;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.util.TaoLog;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVNotification extends WVApiPlugin {
    private static final String TAG = "WVNotification";

    public final void beep(String str, WVCallBackContext wVCallBackContext) {
        try {
            final int parseInt = Integer.parseInt(new JSONObject(str).optString(AdUtConstants.XAD_UT_ARG_COUNT));
            new Thread() { // from class: android.taobao.windvane.jsbridge.api.WVNotification.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    ToneGenerator toneGenerator = new ToneGenerator(1, 100);
                    for (int i = 0; i < parseInt; i++) {
                        toneGenerator.startTone(24);
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    toneGenerator.stopTone();
                    toneGenerator.release();
                }
            }.start();
            wVCallBackContext.success("{}");
        } catch (JSONException unused) {
            TaoLog.e("WVNotification", "openWindow: param parse to JSON error, param=" + str);
            wVCallBackContext.error("param error");
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("beep".equals(str)) {
            beep(str2, wVCallBackContext);
            return true;
        }
        return false;
    }
}
