package com.taobao.weex;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.taobao.weex.WeexFrameRateControl;
import com.taobao.weex.render.WXAbstractRenderContainer;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RenderContainer extends WXAbstractRenderContainer implements WeexFrameRateControl.VSyncListener {
    private WeexFrameRateControl mFrameRateControl;

    public RenderContainer(Context context) {
        super(context);
        this.mFrameRateControl = new WeexFrameRateControl(this);
    }

    @Override // com.taobao.weex.WeexFrameRateControl.VSyncListener
    public void OnVSync() {
        WeakReference<WXSDKInstance> weakReference = this.mSDKInstance;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mSDKInstance.get().OnVSync();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i) {
        WeexFrameRateControl weexFrameRateControl;
        super.dispatchWindowVisibilityChanged(i);
        if (i == 8) {
            WeexFrameRateControl weexFrameRateControl2 = this.mFrameRateControl;
            if (weexFrameRateControl2 != null) {
                weexFrameRateControl2.f();
            }
        } else if (i != 0 || (weexFrameRateControl = this.mFrameRateControl) == null) {
        } else {
            weexFrameRateControl.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        WeexFrameRateControl weexFrameRateControl = this.mFrameRateControl;
        if (weexFrameRateControl != null) {
            weexFrameRateControl.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeexFrameRateControl weexFrameRateControl = this.mFrameRateControl;
        if (weexFrameRateControl != null) {
            weexFrameRateControl.f();
        }
    }

    public RenderContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrameRateControl = new WeexFrameRateControl(this);
    }

    public RenderContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFrameRateControl = new WeexFrameRateControl(this);
    }

    @TargetApi(21)
    public RenderContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mFrameRateControl = new WeexFrameRateControl(this);
    }
}
