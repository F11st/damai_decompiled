package com.taobao.weex;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;
import android.view.Choreographer;
import com.taobao.weex.common.WXErrorCode;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WeexFrameRateControl {
    private WeakReference<VSyncListener> a;
    private final Choreographer b;
    private final Choreographer.FrameCallback c;
    private final Runnable d;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface VSyncListener {
        void OnVSync();
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.WeexFrameRateControl$a */
    /* loaded from: classes11.dex */
    class Choreographer$FrameCallbackC6947a implements Choreographer.FrameCallback {
        Choreographer$FrameCallbackC6947a() {
        }

        @Override // android.view.Choreographer.FrameCallback
        @SuppressLint({"NewApi"})
        public void doFrame(long j) {
            VSyncListener vSyncListener;
            if (WeexFrameRateControl.this.a == null || (vSyncListener = (VSyncListener) WeexFrameRateControl.this.a.get()) == null) {
                return;
            }
            try {
                vSyncListener.OnVSync();
                WeexFrameRateControl.this.b.postFrameCallback(WeexFrameRateControl.this.c);
            } catch (UnsatisfiedLinkError e) {
                if (vSyncListener instanceof WXSDKInstance) {
                    ((WXSDKInstance) vSyncListener).onRenderError(WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorCode(), Log.getStackTraceString(e));
                }
            }
        }
    }

    public WeexFrameRateControl(VSyncListener vSyncListener) {
        this.a = new WeakReference<>(vSyncListener);
        if (Build.VERSION.SDK_INT > 15) {
            this.b = Choreographer.getInstance();
            this.c = new Choreographer$FrameCallbackC6947a();
            this.d = null;
            return;
        }
        this.d = new Runnable() { // from class: com.taobao.weex.WeexFrameRateControl.2
            @Override // java.lang.Runnable
            public void run() {
                VSyncListener vSyncListener2;
                if (WeexFrameRateControl.this.a == null || (vSyncListener2 = (VSyncListener) WeexFrameRateControl.this.a.get()) == null) {
                    return;
                }
                try {
                    vSyncListener2.OnVSync();
                    WXSDKManager.v().G().postOnUiThread(WeexFrameRateControl.this.d, 16L);
                } catch (UnsatisfiedLinkError e) {
                    if (vSyncListener2 instanceof WXSDKInstance) {
                        ((WXSDKInstance) vSyncListener2).onRenderError(WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorCode(), Log.getStackTraceString(e));
                    }
                }
            }
        };
        this.b = null;
        this.c = null;
    }

    @SuppressLint({"NewApi"})
    public void e() {
        Choreographer choreographer = this.b;
        if (choreographer != null) {
            choreographer.postFrameCallback(this.c);
        } else if (this.d != null) {
            WXSDKManager.v().G().postOnUiThread(this.d, 16L);
        }
    }

    @SuppressLint({"NewApi"})
    public void f() {
        Choreographer choreographer = this.b;
        if (choreographer != null) {
            choreographer.removeFrameCallback(this.c);
        } else if (this.d != null) {
            WXSDKManager.v().G().removeTask(this.d);
        }
    }
}
