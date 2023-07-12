package com.alipay.camera;

import android.hardware.Camera;
import android.os.Message;
import android.os.SystemClock;
import com.alipay.camera.base.AntCamera;
import com.alipay.camera2.util.SystraceWrapper;
import com.alipay.mobile.bqcscanservice.CameraHandler;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class NewAutoFocusManager extends AntCamera.AutoFocusCallbackProxy implements CameraHandler.OnMessageHandleCallback {
    public static final long AUTO_FOCUS_CHECK = 2000;
    public static final long AUTO_FOCUS_DELAY = 1000;
    public static final String TAG = "NewAutoFocusManager";
    private long a;
    private CameraHandler b;
    private int c;
    private int d;
    private AntCamera e;
    private boolean f;
    private boolean g;
    private long h;

    public NewAutoFocusManager(AntCamera antCamera, CameraHandler cameraHandler) {
        MPaasLogger.d(TAG, new Object[]{"AutoFocus-New:(", Long.valueOf(SystemClock.elapsedRealtime()), jn1.BRACKET_END_STR});
        this.e = antCamera;
        this.b = cameraHandler;
        if (cameraHandler != null) {
            cameraHandler.addCallback(CameraHandler.AUTO_FOCUS_MESSAGE, this);
            this.b.addCallback(CameraHandler.AUTO_FOCUS_CHECK, this);
        }
    }

    private void a(boolean z) {
        char c;
        Camera.Parameters parameters;
        this.f = true;
        char c2 = 0;
        this.d = 0;
        this.c = 0;
        if (this.e != null) {
            if (!this.g) {
                this.h = SystemClock.elapsedRealtime();
            }
            if (MPaasLogger.isDebuggable() && (parameters = this.e.getParameters()) != null) {
                try {
                    MPaasLogger.d(TAG, new Object[]{"AutoFocus-Length:(", Float.valueOf(parameters.getFocalLength()), jn1.BRACKET_END_STR});
                    List<Camera.Area> focusAreas = parameters.getFocusAreas();
                    int i = 0;
                    while (focusAreas != null && i < focusAreas.size()) {
                        Camera.Area area = focusAreas.get(i);
                        Object[] objArr = new Object[8];
                        objArr[c2] = "AutoFocus-Area:(";
                        objArr[1] = Integer.valueOf(area.rect.left);
                        objArr[2] = ",";
                        objArr[3] = Integer.valueOf(area.rect.top);
                        objArr[4] = ",";
                        objArr[5] = Integer.valueOf(area.rect.right);
                        objArr[6] = ",";
                        objArr[7] = Integer.valueOf(area.rect.bottom);
                        MPaasLogger.d(TAG, objArr);
                        i++;
                        c2 = 0;
                    }
                    float[] fArr = new float[3];
                    this.e.getParameters().getFocusDistances(fArr);
                    MPaasLogger.d(TAG, new Object[]{"AutoFocus-Distance:(", Float.valueOf(fArr[0]), ",", Float.valueOf(fArr[1]), ",", Float.valueOf(fArr[2]), jn1.BRACKET_END_STR});
                } catch (Exception e) {
                    c = 0;
                    MPaasLogger.e(TAG, new Object[]{e.getMessage()});
                }
            }
            c = 0;
            Object[] objArr2 = new Object[3];
            objArr2[c] = "AutoFocus-Start:(";
            objArr2[1] = Boolean.valueOf(this.e != null);
            objArr2[2] = jn1.BRACKET_END_STR;
            MPaasLogger.d(TAG, objArr2);
            try {
                this.e.cancelAutoFocus();
            } catch (Throwable th) {
                MPaasLogger.e(TAG, new Object[]{"cancelAutoFocus error"}, th);
            }
            this.e.autoFocus((AntCamera.AutoFocusCallbackProxy) this);
            this.a = SystemClock.elapsedRealtime();
            if (z) {
                sendMessageDelayed(CameraHandler.AUTO_FOCUS_CHECK.intValue(), 2000L);
            }
        }
    }

    public void clearMessage(int i) {
        CameraHandler cameraHandler = this.b;
        if (cameraHandler != null) {
            cameraHandler.clearMessages(i);
        }
    }

    public void destroy() {
        Object[] objArr = new Object[2];
        objArr[0] = "destroy: ";
        objArr[1] = Boolean.valueOf(this.e != null);
        MPaasLogger.d(TAG, objArr);
        stopAutoFocus();
        CameraHandler cameraHandler = this.b;
        if (cameraHandler != null) {
            cameraHandler.removeCallback(CameraHandler.AUTO_FOCUS_MESSAGE);
            this.b.removeCallback(CameraHandler.AUTO_FOCUS_CHECK);
        }
        this.e = null;
    }

    @Override // com.alipay.camera.base.AntCamera.AutoFocusCallbackProxy
    public void onAutoFocusProxy(boolean z, AntCamera antCamera) {
        if (!z) {
            this.c++;
        } else {
            this.d++;
        }
        MPaasLogger.d(TAG, new Object[]{"AutoFocus-Callback:(", Boolean.valueOf(z), jn1.BRACKET_END_STR});
        sendMessageDelayed(CameraHandler.AUTO_FOCUS_MESSAGE.intValue(), 1000L);
        if (this.g) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.h;
        long j2 = elapsedRealtime - j;
        if (j2 > 0 && j > 0) {
            WalletBury.addWalletBury("recordFirstAutoFocus", new Class[]{Boolean.TYPE, Long.TYPE}, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)});
        }
        this.g = true;
    }

    @Override // com.alipay.mobile.bqcscanservice.CameraHandler.OnMessageHandleCallback
    public void onHandleMessage(Message message) {
        if (message != null) {
            int i = message.what;
            if (i == CameraHandler.AUTO_FOCUS_MESSAGE.intValue()) {
                MPaasLogger.d(TAG, new Object[]{"onGetAuto_FocusMessage"});
                if (this.f) {
                    a(false);
                    return;
                }
                return;
            }
            Integer num = CameraHandler.AUTO_FOCUS_CHECK;
            if (i == num.intValue()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.a;
                if (this.f && elapsedRealtime >= 3000) {
                    a(false);
                }
                MPaasLogger.d(TAG, new Object[]{"onGetAuto_FocusCheck: ", Long.valueOf(elapsedRealtime)});
                sendMessageDelayed(num.intValue(), 2000L);
            }
        }
    }

    public void sendMessageDelayed(int i, long j) {
        CameraHandler cameraHandler = this.b;
        if (cameraHandler != null) {
            cameraHandler.sendMessageDelayed(i, j);
        }
    }

    public void startAutoFocus() {
        a(true);
    }

    public void stopAutoFocus() {
        this.f = false;
        Object[] objArr = new Object[2];
        objArr[0] = "stopAuto_Focus: ";
        objArr[1] = Boolean.valueOf(this.e != null);
        MPaasLogger.d(TAG, objArr);
        if (this.e != null) {
            try {
                SystraceWrapper.beginTrace("cancelAutoFocus");
                this.e.cancelAutoFocus();
                SystraceWrapper.endTrace();
            } catch (Throwable th) {
                MPaasLogger.e(TAG, new Object[]{"cancelAutoFocus error"}, th);
            }
            clearMessage(CameraHandler.AUTO_FOCUS_MESSAGE.intValue());
            clearMessage(CameraHandler.AUTO_FOCUS_CHECK.intValue());
        }
        Class cls = Integer.TYPE;
        WalletBury.addWalletBury("recordCameraFocusError", new Class[]{cls, cls}, new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d)});
        this.c = 0;
        this.d = 0;
        this.h = 0L;
        this.g = false;
    }
}
