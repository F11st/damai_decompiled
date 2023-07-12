package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.logic.view.custom.CameraGLSurfaceView;
import com.alibaba.security.common.d.d;
import java.text.DecimalFormat;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class BaseCameraWidgetParent extends FrameLayout {
    private static final String b = "BaseCameraWidgetParent";
    protected CameraGLSurfaceView a;

    public BaseCameraWidgetParent(Context context) {
        super(context);
    }

    private static void d() {
    }

    public final void a(int i, int i2, int i3, boolean z) {
        float parseFloat;
        DecimalFormat decimalFormat = new DecimalFormat("#0");
        if (!z) {
            parseFloat = Float.parseFloat(decimalFormat.format(d.c(getContext())));
        } else {
            parseFloat = Float.parseFloat(decimalFormat.format(d.a(getContext()) * 2.0f));
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
        int i4 = (int) parseFloat;
        layoutParams.width = i4;
        layoutParams.height = (int) ((Float.parseFloat(decimalFormat.format(i)) / Float.parseFloat(decimalFormat.format(i2))) * parseFloat);
        layoutParams.gravity = 49;
        layoutParams.topMargin = i3 - (i4 / 2);
        this.a.setLayoutParams(layoutParams);
    }

    public final void b() {
        CameraGLSurfaceView cameraGLSurfaceView = this.a;
        if (cameraGLSurfaceView != null) {
            cameraGLSurfaceView.onPause();
        }
    }

    public final void c() {
        CameraGLSurfaceView cameraGLSurfaceView = this.a;
        if (cameraGLSurfaceView != null) {
            cameraGLSurfaceView.onResume();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (CameraGLSurfaceView) findViewById(R.id.abfl_widget_camera_surface);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.a.setRenderer(renderer);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        this.a.setVisibility(i);
        super.setVisibility(i);
    }

    public BaseCameraWidgetParent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseCameraWidgetParent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a() {
        CameraGLSurfaceView cameraGLSurfaceView = this.a;
        if (cameraGLSurfaceView != null) {
            cameraGLSurfaceView.requestRender();
        }
    }

    public final void a(Runnable runnable) {
        CameraGLSurfaceView cameraGLSurfaceView = this.a;
        if (cameraGLSurfaceView != null) {
            cameraGLSurfaceView.queueEvent(runnable);
        }
    }
}
