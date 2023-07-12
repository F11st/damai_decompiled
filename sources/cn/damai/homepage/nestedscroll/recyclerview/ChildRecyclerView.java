package cn.damai.homepage.nestedscroll.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.Nullable;
import cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollParent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.nj1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ChildRecyclerView extends AbstractRecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    private NestedScrollParent mNestedScrollParent;

    public ChildRecyclerView(Context context) {
        super(context);
    }

    public final NestedScrollParent getNestedScrollParent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1608599520") ? (NestedScrollParent) ipChange.ipc$dispatch("-1608599520", new Object[]{this}) : this.mNestedScrollParent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.homepage.nestedscroll.recyclerview.AbstractRecyclerView
    public boolean isAccepted(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2040851903")) {
            return ((Boolean) ipChange.ipc$dispatch("-2040851903", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        if (i > 0) {
            return true;
        }
        return super.isAccepted(i);
    }

    @Override // cn.damai.homepage.nestedscroll.overscroll.IOverScroll
    public boolean onReachedEdge(int i, int i2) {
        float f;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "131355751")) {
            return ((Boolean) ipChange.ipc$dispatch("131355751", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
        }
        this.mInterceptTouch = true;
        int scrollState = getScrollState();
        if (scrollState == 0 || scrollState == 1) {
            if (nj1.a(this.mNestedScrollParent, this) && this.mNestedScrollParent.acceptNestedScroll(i)) {
                this.mInterceptTouch = false;
                this.mNestedScrollParent.dispatchNestedScroll(i);
                return true;
            }
        } else if (scrollState == 2) {
            if (nj1.a(this.mNestedScrollParent, this) && this.mNestedScrollParent.acceptNestedFling(this.mVelocityY)) {
                this.mInterceptTouch = false;
                float invokeCurrentVelocity = invokeCurrentVelocity();
                if (Math.abs(invokeCurrentVelocity) <= 2.0E-5f) {
                    invokeCurrentVelocity = this.mVelocityY;
                    f = 0.5f;
                } else {
                    f = 0.65f;
                }
                this.mNestedScrollParent.dispatchNestedFling((int) (invokeCurrentVelocity * f));
            } else {
                z = false;
            }
            this.mVelocityY = 0;
            return z;
        }
        return false;
    }

    @Override // cn.damai.homepage.nestedscroll.recyclerview.AbstractRecyclerView, cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild
    public void onScrolledByNestedParent(NestedScrollParent nestedScrollParent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1840508339")) {
            ipChange.ipc$dispatch("-1840508339", new Object[]{this, nestedScrollParent});
        } else {
            Log.e("Child", "onScrolledByNestedParent");
        }
    }

    @Override // cn.damai.homepage.nestedscroll.recyclerview.AbstractRecyclerView, cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild
    public void setNestedScrollParent(NestedScrollParent nestedScrollParent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1606975490")) {
            ipChange.ipc$dispatch("-1606975490", new Object[]{this, nestedScrollParent});
        } else {
            this.mNestedScrollParent = nestedScrollParent;
        }
    }

    public ChildRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChildRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
