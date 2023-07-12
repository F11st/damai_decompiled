package com.taobao.weex.render;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.weex.WXSDKInstance;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXAbstractRenderContainer extends FrameLayout {
    protected boolean mHasConsumeEvent;
    protected WeakReference<WXSDKInstance> mSDKInstance;

    public WXAbstractRenderContainer(@NonNull Context context) {
        super(context);
        this.mHasConsumeEvent = false;
    }

    public void createInstanceRenderView(String str) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mHasConsumeEvent = true;
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean hasConsumeEvent() {
        return this.mHasConsumeEvent;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        WXSDKInstance wXSDKInstance;
        super.onSizeChanged(i, i2, i3, i4);
        WeakReference<WXSDKInstance> weakReference = this.mSDKInstance;
        if (weakReference == null || (wXSDKInstance = weakReference.get()) == null) {
            return;
        }
        wXSDKInstance.setSize(i, i2);
    }

    public void setSDKInstance(WXSDKInstance wXSDKInstance) {
        this.mSDKInstance = new WeakReference<>(wXSDKInstance);
    }

    public WXAbstractRenderContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHasConsumeEvent = false;
    }

    public WXAbstractRenderContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasConsumeEvent = false;
    }

    @TargetApi(21)
    public WXAbstractRenderContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mHasConsumeEvent = false;
    }
}
