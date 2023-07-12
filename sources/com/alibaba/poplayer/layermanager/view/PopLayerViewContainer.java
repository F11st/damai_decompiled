package com.alibaba.poplayer.layermanager.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.alibaba.poplayer.R$id;
import com.alibaba.poplayer.R$layout;
import java.lang.ref.WeakReference;
import tb.dt1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PopLayerViewContainer extends FrameLayout {
    private WeakReference<Activity> mActivityAttachTo;
    private Canvas mPageCanvas;
    private SandoContainer mSandoContainer;

    public PopLayerViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context);
    }

    private void initialize(Context context) {
        View.inflate(context, R$layout.pop_layer_container, this);
        this.mPageCanvas = (Canvas) findViewById(R$id.poplayer_view);
        SandoContainer sandoContainer = (SandoContainer) findViewById(R$id.sando_container);
        this.mSandoContainer = sandoContainer;
        sandoContainer.setPopLayerContainer(this);
        dt1.b("PopLayerViewContainer.initialize.success?this=%s", this);
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.mActivityAttachTo;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public Canvas getCanvas() {
        return this.mPageCanvas;
    }

    public SandoContainer getSandoContainer() {
        return this.mSandoContainer;
    }

    public void setActivity(Activity activity) {
        this.mActivityAttachTo = new WeakReference<>(activity);
    }

    public void showSandoContainer(boolean z) {
        this.mSandoContainer.setVisibility(z ? 0 : 8);
        dt1.b("PopLayerViewContainer.showSandoContainer?show=%s", Boolean.valueOf(z));
    }

    public PopLayerViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context);
    }

    public PopLayerViewContainer(Context context) {
        super(context);
        initialize(context);
    }
}
