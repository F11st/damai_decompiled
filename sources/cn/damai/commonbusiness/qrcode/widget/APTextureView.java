package cn.damai.commonbusiness.qrcode.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import tb.c0;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class APTextureView extends TextureView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "APTextureView";
    private Field mSurfaceField;

    public APTextureView(Context context) {
        super(context);
        this.mSurfaceField = null;
    }

    private void afterSetSurfaceTexture() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1386363705")) {
            ipChange.ipc$dispatch("-1386363705", new Object[]{this});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("afterSetSurfaceTexture Build.VERSION.SDK_INT:");
        int i = Build.VERSION.SDK_INT;
        sb.append(i);
        Log.d(TAG, sb.toString());
        if (i < 16 || i > 20) {
            return;
        }
        try {
            if (this.mSurfaceField == null) {
                Field declaredField = TextureView.class.getDeclaredField("mSurface");
                this.mSurfaceField = declaredField;
                declaredField.setAccessible(true);
            }
            SurfaceTexture surfaceTexture = (SurfaceTexture) this.mSurfaceField.get(this);
            if (surfaceTexture == null || (surfaceTexture instanceof c0)) {
                return;
            }
            c0 c0Var = new c0();
            c0Var.a = surfaceTexture;
            this.mSurfaceField.set(this, c0Var);
            Log.d(TAG, "afterSetSurfaceTexture wrap mSurface");
        } catch (Exception e) {
            Log.e(TAG, "afterSetSurfaceTexture exception:" + e.getMessage());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2038200432")) {
            ipChange.ipc$dispatch("-2038200432", new Object[]{this});
            return;
        }
        try {
            super.onDetachedFromWindow();
        } catch (Exception e) {
            Log.e(TAG, "onDetachedFromWindow exception:" + e.getMessage());
        }
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-11133648")) {
            ipChange.ipc$dispatch("-11133648", new Object[]{this, surfaceTexture});
            return;
        }
        super.setSurfaceTexture(surfaceTexture);
        afterSetSurfaceTexture();
    }

    public APTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSurfaceField = null;
    }

    public APTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSurfaceField = null;
    }
}
