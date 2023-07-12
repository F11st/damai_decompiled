package cn.damai.issue.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMLinearLayoutIssue extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private IssueSoftControl listener;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface IssueSoftControl {
        void dispatchDown(MotionEvent motionEvent);
    }

    public DMLinearLayoutIssue(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IssueSoftControl issueSoftControl;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-981282423")) {
            return ((Boolean) ipChange.ipc$dispatch("-981282423", new Object[]{this, motionEvent})).booleanValue();
        }
        if (motionEvent.getAction() == 0 && (issueSoftControl = this.listener) != null) {
            issueSoftControl.dispatchDown(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setListener(IssueSoftControl issueSoftControl) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807422184")) {
            ipChange.ipc$dispatch("1807422184", new Object[]{this, issueSoftControl});
        } else {
            this.listener = issueSoftControl;
        }
    }

    public DMLinearLayoutIssue(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMLinearLayoutIssue(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
