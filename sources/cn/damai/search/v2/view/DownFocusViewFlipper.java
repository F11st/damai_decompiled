package cn.damai.search.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ViewFlipper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class DownFocusViewFlipper extends ViewFlipper {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnDispatchDownListener mListener;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnDispatchDownListener {
        void onDispatchDown();
    }

    public DownFocusViewFlipper(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        OnDispatchDownListener onDispatchDownListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1581899183")) {
            return ((Boolean) ipChange.ipc$dispatch("-1581899183", new Object[]{this, motionEvent})).booleanValue();
        }
        if (motionEvent.getAction() == 0 && (onDispatchDownListener = this.mListener) != null) {
            onDispatchDownListener.onDispatchDown();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setListener(OnDispatchDownListener onDispatchDownListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2026719999")) {
            ipChange.ipc$dispatch("2026719999", new Object[]{this, onDispatchDownListener});
        } else {
            this.mListener = onDispatchDownListener;
        }
    }

    public DownFocusViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
