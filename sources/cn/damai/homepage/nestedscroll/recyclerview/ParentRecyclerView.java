package cn.damai.homepage.nestedscroll.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.nj1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ParentRecyclerView extends AbstractRecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    private NestedScrollChild mNestedScrollChild;

    public ParentRecyclerView(Context context) {
        super(context);
    }

    public final NestedScrollChild getNestedScrollChild() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "229790776") ? (NestedScrollChild) ipChange.ipc$dispatch("229790776", new Object[]{this}) : this.mNestedScrollChild;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.homepage.nestedscroll.recyclerview.AbstractRecyclerView
    public boolean isAccepted(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1093917519")) {
            return ((Boolean) ipChange.ipc$dispatch("1093917519", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        if (i < 0) {
            return true;
        }
        return super.isAccepted(i);
    }

    @Override // cn.damai.homepage.nestedscroll.overscroll.IOverScroll
    public boolean onReachedEdge(int i, int i2) {
        float f;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1478105483")) {
            return ((Boolean) ipChange.ipc$dispatch("-1478105483", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
        }
        this.mInterceptTouch = true;
        int scrollState = getScrollState();
        if (scrollState == 0 || scrollState == 1) {
            if (nj1.a(this, this.mNestedScrollChild) && this.mNestedScrollChild.acceptNestedScroll(i)) {
                this.mInterceptTouch = false;
                this.mNestedScrollChild.dispatchNestedScroll(i);
                return true;
            }
        } else if (scrollState == 2) {
            if (nj1.a(this, this.mNestedScrollChild) && this.mNestedScrollChild.acceptNestedFling(this.mVelocityY)) {
                this.mInterceptTouch = false;
                float invokeCurrentVelocity = invokeCurrentVelocity();
                if (Math.abs(invokeCurrentVelocity) <= 2.0E-5f) {
                    invokeCurrentVelocity = this.mVelocityY;
                    f = 0.5f;
                } else {
                    f = 0.46f;
                }
                this.mNestedScrollChild.dispatchNestedFling((int) (invokeCurrentVelocity * f));
            } else {
                z = false;
            }
            this.mVelocityY = 0;
            return z;
        }
        return false;
    }

    @Override // cn.damai.homepage.nestedscroll.recyclerview.AbstractRecyclerView, cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollParent
    public void setNestedScrollChild(NestedScrollChild nestedScrollChild) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2027208996")) {
            ipChange.ipc$dispatch("-2027208996", new Object[]{this, nestedScrollChild});
        } else {
            this.mNestedScrollChild = nestedScrollChild;
        }
    }

    public ParentRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ParentRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
