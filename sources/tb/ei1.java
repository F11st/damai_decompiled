package tb;

import android.opengl.GLSurfaceView;
import com.heytap.mcssdk.constant.MessageConstant$MessageType;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ei1 implements GLSurfaceView.EGLConfigChooser {
    private boolean a = true;

    private static EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, boolean z) {
        for (EGLConfig eGLConfig : eGLConfigArr) {
            int b = b(egl10, eGLDisplay, eGLConfig, 12325, 0);
            int b2 = b(egl10, eGLDisplay, eGLConfig, 12326, 0);
            int b3 = b(egl10, eGLDisplay, eGLConfig, 12324, 0);
            int b4 = b(egl10, eGLDisplay, eGLConfig, 12323, 0);
            int b5 = b(egl10, eGLDisplay, eGLConfig, 12322, 0);
            int b6 = b(egl10, eGLDisplay, eGLConfig, 12339, 0);
            if (b3 == 8 && b4 == 8 && b5 == 8 && b == 0 && b2 == 0 && (!z || (b6 & 4096) != 0)) {
                return eGLConfig;
            }
        }
        return null;
    }

    private static int b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        int[] iArr = new int[1];
        return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr) ? iArr[0] : i2;
    }

    @Override // android.opengl.GLSurfaceView.EGLConfigChooser
    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 0, 12326, 0, 12352, 64, 12339, MessageConstant$MessageType.MESSAGE_ALARM, 12344};
        int[] iArr2 = new int[1];
        if (!egl10.eglChooseConfig(eGLDisplay, iArr, null, 0, iArr2) && this.a) {
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
        iArr[15] = 4;
        if (egl10.eglChooseConfig(eGLDisplay, iArr, null, 0, iArr2)) {
            int i = iArr2[0];
            if (i > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                if (egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2)) {
                    EGLConfig a = a(egl10, eGLDisplay, eGLConfigArr, this.a);
                    if (a != null) {
                        return a;
                    }
                    throw new IllegalArgumentException("No config chosen");
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("No configs match configSpec");
        }
        throw new IllegalArgumentException("eglChooseConfig failed");
    }
}
