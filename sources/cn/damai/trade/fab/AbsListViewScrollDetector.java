package cn.damai.trade.fab;

import android.widget.AbsListView;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public abstract class AbsListViewScrollDetector implements AbsListView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mLastScrollY;
    private AbsListView mListView;
    private int mPreviousFirstVisibleItem;
    private int mScrollThreshold;

    private int getTopItemScrollY() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "465292372")) {
            return ((Integer) ipChange.ipc$dispatch("465292372", new Object[]{this})).intValue();
        }
        AbsListView absListView = this.mListView;
        if (absListView == null || absListView.getChildAt(0) == null) {
            return 0;
        }
        return this.mListView.getChildAt(0).getTop();
    }

    private boolean isSameRow(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1523190486") ? ((Boolean) ipChange.ipc$dispatch("1523190486", new Object[]{this, Integer.valueOf(i)})).booleanValue() : i == this.mPreviousFirstVisibleItem;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826125787")) {
            ipChange.ipc$dispatch("826125787", new Object[]{this, absListView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (i3 == 0) {
        } else {
            if (isSameRow(i)) {
                int topItemScrollY = getTopItemScrollY();
                if (Math.abs(this.mLastScrollY - topItemScrollY) > this.mScrollThreshold) {
                    if (this.mLastScrollY > topItemScrollY) {
                        onScrollUp();
                    } else {
                        onScrollDown();
                    }
                }
                this.mLastScrollY = topItemScrollY;
                return;
            }
            if (i > this.mPreviousFirstVisibleItem) {
                onScrollUp();
            } else {
                onScrollDown();
            }
            this.mLastScrollY = getTopItemScrollY();
            this.mPreviousFirstVisibleItem = i;
        }
    }

    abstract void onScrollDown();

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "138649150")) {
            ipChange.ipc$dispatch("138649150", new Object[]{this, absListView, Integer.valueOf(i)});
        }
    }

    abstract void onScrollUp();

    public void setListView(@NonNull AbsListView absListView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "471618779")) {
            ipChange.ipc$dispatch("471618779", new Object[]{this, absListView});
        } else {
            this.mListView = absListView;
        }
    }

    public void setScrollThreshold(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-44486096")) {
            ipChange.ipc$dispatch("-44486096", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mScrollThreshold = i;
        }
    }
}
