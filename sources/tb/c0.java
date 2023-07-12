package tb;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class c0 extends SurfaceTexture {
    private static transient /* synthetic */ IpChange $ipChange;
    public SurfaceTexture a;

    public c0() {
        super(0);
        this.a = null;
    }

    @Override // android.graphics.SurfaceTexture
    @TargetApi(16)
    public void attachToGLContext(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1139966728")) {
            ipChange.ipc$dispatch("1139966728", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.a.attachToGLContext(i);
        }
    }

    @Override // android.graphics.SurfaceTexture
    @TargetApi(16)
    public void detachFromGLContext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1713760792")) {
            ipChange.ipc$dispatch("1713760792", new Object[]{this});
            return;
        }
        try {
            this.a.detachFromGLContext();
        } catch (Exception e) {
            try {
                Method declaredMethod = SurfaceTexture.class.getDeclaredMethod("nativeDetachFromGLContext", new Class[0]);
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(this.a, new Object[0])).intValue();
                Log.d("APSurfaceTexture", "nativeDetachFromGLContext invoke retCode:" + intValue);
            } catch (Exception e2) {
                Log.e("APSurfaceTexture", "nativeDetachFromGLContext invoke exception:" + e2.getMessage());
            }
            Log.e("APSurfaceTexture", "mSurface.detachFromGLContext() exception:" + e.getMessage());
        }
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1001848282") ? ((Boolean) ipChange.ipc$dispatch("-1001848282", new Object[]{this, obj})).booleanValue() : this.a.equals(obj);
    }

    @Override // android.graphics.SurfaceTexture
    public long getTimestamp() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2096760455") ? ((Long) ipChange.ipc$dispatch("-2096760455", new Object[]{this})).longValue() : this.a.getTimestamp();
    }

    @Override // android.graphics.SurfaceTexture
    public void getTransformMatrix(float[] fArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "977350841")) {
            ipChange.ipc$dispatch("977350841", new Object[]{this, fArr});
        } else {
            this.a.getTransformMatrix(fArr);
        }
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1451621923") ? ((Integer) ipChange.ipc$dispatch("-1451621923", new Object[]{this})).intValue() : this.a.hashCode();
    }

    @Override // android.graphics.SurfaceTexture
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1766586466")) {
            ipChange.ipc$dispatch("-1766586466", new Object[]{this});
            return;
        }
        super.release();
        this.a.release();
    }

    @Override // android.graphics.SurfaceTexture
    @TargetApi(19)
    public void releaseTexImage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1580374154")) {
            ipChange.ipc$dispatch("1580374154", new Object[]{this});
        } else {
            this.a.releaseTexImage();
        }
    }

    @Override // android.graphics.SurfaceTexture
    @TargetApi(15)
    public void setDefaultBufferSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-652111419")) {
            ipChange.ipc$dispatch("-652111419", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            this.a.setDefaultBufferSize(i, i2);
        }
    }

    @Override // android.graphics.SurfaceTexture
    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373204226")) {
            ipChange.ipc$dispatch("373204226", new Object[]{this, onFrameAvailableListener});
        } else {
            this.a.setOnFrameAvailableListener(onFrameAvailableListener);
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "119150535") ? (String) ipChange.ipc$dispatch("119150535", new Object[]{this}) : this.a.toString();
    }

    @Override // android.graphics.SurfaceTexture
    public void updateTexImage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "257441128")) {
            ipChange.ipc$dispatch("257441128", new Object[]{this});
        } else {
            this.a.updateTexImage();
        }
    }
}
