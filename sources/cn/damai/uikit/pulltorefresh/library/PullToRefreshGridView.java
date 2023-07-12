package cn.damai.uikit.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import cn.damai.uikit.R$id;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PullToRefreshGridView extends PullToRefreshAdapterViewBase<GridView> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class InternalGridView extends GridView implements EmptyViewMethodAccessor {
        private static transient /* synthetic */ IpChange $ipChange;

        public InternalGridView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.AdapterView, cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyView(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1821695249")) {
                ipChange.ipc$dispatch("-1821695249", new Object[]{this, view});
            } else {
                PullToRefreshGridView.this.setEmptyView(view);
            }
        }

        @Override // cn.damai.uikit.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyViewInternal(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1707784180")) {
                ipChange.ipc$dispatch("-1707784180", new Object[]{this, view});
            } else {
                super.setEmptyView(view);
            }
        }
    }

    /* compiled from: Taobao */
    @TargetApi(9)
    /* loaded from: classes8.dex */
    public final class InternalGridViewSDK9 extends InternalGridView {
        private static transient /* synthetic */ IpChange $ipChange;

        public InternalGridViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.view.View
        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "430244766")) {
                return ((Boolean) ipChange.ipc$dispatch("430244766", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z)})).booleanValue();
            }
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            b.d(PullToRefreshGridView.this, i, i3, i2, i4, z);
            return overScrollBy;
        }
    }

    public PullToRefreshGridView(Context context) {
        super(context);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "444411531") ? (PullToRefreshBase.Orientation) ipChange.ipc$dispatch("444411531", new Object[]{this}) : PullToRefreshBase.Orientation.VERTICAL;
    }

    public PullToRefreshGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public final GridView createRefreshableView(Context context, AttributeSet attributeSet) {
        GridView internalGridView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-419677022")) {
            return (GridView) ipChange.ipc$dispatch("-419677022", new Object[]{this, context, attributeSet});
        }
        if (Build.VERSION.SDK_INT >= 9) {
            internalGridView = new InternalGridViewSDK9(context, attributeSet);
        } else {
            internalGridView = new InternalGridView(context, attributeSet);
        }
        internalGridView.setId(R$id.gridview);
        return internalGridView;
    }

    public PullToRefreshGridView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }

    public PullToRefreshGridView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }
}
