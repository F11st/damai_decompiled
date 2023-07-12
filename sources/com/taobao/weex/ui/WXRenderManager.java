package com.taobao.weex.ui;

import android.opengl.GLES10;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXRuntimeException;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.dom.RenderContext;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.ui.action.BasicGraphicAction;
import com.taobao.weex.ui.action.GraphicActionBatchAction;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXRenderManager {
    private static int mOpenGLRenderLimitValue = 0;
    private static int nativeBatchTimes = 0;
    private static final String sKeyAction = "Action";
    private String mCurrentBatchInstanceId = null;
    private ArrayList<Map<String, Object>> mBatchActions = new ArrayList<>();
    private final int MAX_DROP_FRAME_NATIVE_BATCH = 2000;
    private volatile ConcurrentHashMap<String, RenderContextImpl> mRenderContext = new ConcurrentHashMap<>();
    private WXRenderHandler mWXRenderHandler = new WXRenderHandler();

    public static int getOpenGLRenderLimitValue() {
        if (mOpenGLRenderLimitValue == 0) {
            int i = 0;
            try {
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                egl10.eglInitialize(eglGetDisplay, new int[2]);
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr = new int[1];
                egl10.eglChooseConfig(eglGetDisplay, new int[]{12351, 12430, 12329, 0, 12339, 1, 12344}, eGLConfigArr, 1, iArr);
                if (iArr[0] == 0) {
                    i = -1;
                    egl10.eglTerminate(eglGetDisplay);
                } else {
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    EGLSurface eglCreatePbufferSurface = egl10.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, 12344});
                    EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 1, 12344});
                    egl10.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
                    int[] iArr2 = new int[1];
                    GLES10.glGetIntegerv(3379, iArr2, 0);
                    EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                    egl10.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                    egl10.eglDestroySurface(eglGetDisplay, eglCreatePbufferSurface);
                    egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
                    egl10.eglTerminate(eglGetDisplay);
                    i = iArr2[0];
                }
            } catch (Exception e) {
                WXLogUtils.e(WXLogUtils.getStackTrace(e));
            }
            mOpenGLRenderLimitValue = i;
        }
        return mOpenGLRenderLimitValue;
    }

    private void postAllStashedGraphicAction(String str, BasicGraphicAction basicGraphicAction) {
        BasicGraphicAction basicGraphicAction2;
        int i;
        RenderContextImpl renderContextImpl = this.mRenderContext.get(str);
        ArrayList arrayList = renderContextImpl != null ? new ArrayList(this.mBatchActions) : null;
        this.mBatchActions.clear();
        this.mCurrentBatchInstanceId = null;
        nativeBatchTimes = 0;
        if (renderContextImpl == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Object obj = ((Map) arrayList.get(i2)).get(sKeyAction);
            if ((obj instanceof BasicGraphicAction) && (i = (basicGraphicAction2 = (BasicGraphicAction) obj).mActionType) != 1 && i != 2) {
                arrayList2.add(basicGraphicAction2);
            }
        }
        postGraphicAction(str, new GraphicActionBatchAction(basicGraphicAction.getWXSDKIntance(), basicGraphicAction.getRef(), arrayList2));
    }

    public List<WXSDKInstance> getAllInstances() {
        if (this.mRenderContext == null || this.mRenderContext.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, RenderContextImpl> entry : this.mRenderContext.entrySet()) {
            RenderContextImpl value = entry.getValue();
            if (value != null) {
                arrayList.add(value.getWXSDKInstance());
            }
        }
        return arrayList;
    }

    public RenderContext getRenderContext(String str) {
        return this.mRenderContext.get(str);
    }

    @Nullable
    public WXComponent getWXComponent(String str, String str2) {
        RenderContext renderContext;
        if (str == null || TextUtils.isEmpty(str2) || (renderContext = getRenderContext(str)) == null) {
            return null;
        }
        return renderContext.getComponent(str2);
    }

    public WXSDKInstance getWXSDKInstance(String str) {
        RenderContextImpl renderContextImpl = this.mRenderContext.get(str);
        if (renderContextImpl == null) {
            return null;
        }
        return renderContextImpl.getWXSDKInstance();
    }

    public void postGraphicAction(String str, BasicGraphicAction basicGraphicAction) {
        if (this.mRenderContext.get(str) == null) {
            return;
        }
        String str2 = this.mCurrentBatchInstanceId;
        if (str2 != null && str != null && !str2.equals(str) && this.mBatchActions.size() > 0) {
            ArrayList<Map<String, Object>> arrayList = this.mBatchActions;
            Object obj = arrayList.get(arrayList.size() - 1).get(sKeyAction);
            if (obj instanceof BasicGraphicAction) {
                postAllStashedGraphicAction(this.mCurrentBatchInstanceId, (BasicGraphicAction) obj);
            }
        }
        int i = basicGraphicAction.mActionType;
        if (i == 2) {
            postAllStashedGraphicAction(str, basicGraphicAction);
            return;
        }
        if (i == 1 || this.mBatchActions.size() > 0) {
            int i2 = nativeBatchTimes + 1;
            nativeBatchTimes = i2;
            if (i2 > 2000) {
                postAllStashedGraphicAction(str, basicGraphicAction);
            } else {
                HashMap hashMap = new HashMap(1);
                hashMap.put(sKeyAction, basicGraphicAction);
                this.mBatchActions.add(hashMap);
                this.mCurrentBatchInstanceId = str;
                return;
            }
        }
        this.mWXRenderHandler.post(str, basicGraphicAction);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void postOnUiThread(Runnable runnable, long j) {
        this.mWXRenderHandler.postDelayed(WXThread.secure(runnable), j);
    }

    public void registerComponent(String str, String str2, WXComponent wXComponent) {
        RenderContextImpl renderContextImpl = this.mRenderContext.get(str);
        if (renderContextImpl != null) {
            renderContextImpl.registerComponent(str2, wXComponent);
            if (renderContextImpl.getInstance() != null) {
                renderContextImpl.getInstance().getApmForInstance().D(WXInstanceApm.KEY_PAGE_STATS_MAX_COMPONENT_NUM, renderContextImpl.getComponentCount());
            }
        }
    }

    public void registerInstance(WXSDKInstance wXSDKInstance) {
        if (wXSDKInstance.getInstanceId() == null) {
            WXErrorCode wXErrorCode = WXErrorCode.WX_RENDER_ERR_INSTANCE_ID_NULL;
            WXExceptionUtils.commitCriticalExceptionRT(null, wXErrorCode, "registerInstance", wXErrorCode.getErrorMsg() + "instanceId is null", null);
            return;
        }
        this.mRenderContext.put(wXSDKInstance.getInstanceId(), new RenderContextImpl(wXSDKInstance));
    }

    public void removeRenderStatement(String str) {
        if (WXUtils.isUiThread()) {
            RenderContextImpl remove = this.mRenderContext.remove(str);
            if (remove != null) {
                remove.destroy();
            }
            if (str == null) {
                this.mWXRenderHandler.removeCallbacksAndMessages(null);
                return;
            } else {
                this.mWXRenderHandler.removeMessages(str.hashCode());
                return;
            }
        }
        throw new WXRuntimeException("[WXRenderManager] removeRenderStatement can only be called in main thread");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void removeTask(Runnable runnable) {
        this.mWXRenderHandler.removeCallbacks(runnable);
    }

    public WXComponent unregisterComponent(String str, String str2) {
        RenderContextImpl renderContextImpl = this.mRenderContext.get(str);
        if (renderContextImpl != null) {
            if (renderContextImpl.getInstance() != null) {
                renderContextImpl.getInstance().getApmForInstance().D(WXInstanceApm.KEY_PAGE_STATS_MAX_COMPONENT_NUM, renderContextImpl.getComponentCount());
            }
            return renderContextImpl.unregisterComponent(str2);
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void postOnUiThread(Runnable runnable, String str) {
        this.mWXRenderHandler.post(str, WXThread.secure(runnable));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void postOnUiThread(Runnable runnable) {
        this.mWXRenderHandler.post(WXThread.secure(runnable));
    }
}
