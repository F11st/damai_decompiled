package cn.damai.uikit.pulltorefresh.ptrheader;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import tb.rx1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PtrUiHeader extends FrameLayout implements PtrUIHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private PullToRefreshHeaderView mInnerView;

    public PtrUiHeader(@NonNull Context context) {
        this(context, null);
    }

    public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, rx1 rx1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2087852624")) {
            ipChange.ipc$dispatch("-2087852624", new Object[]{this, ptrFrameLayout, Boolean.valueOf(z), Byte.valueOf(b), rx1Var});
            return;
        }
        this.mInnerView.onStart(false, rx1Var.e(), 0);
        this.mInnerView.onMove(false, false, rx1Var.d());
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "905872271")) {
            ipChange.ipc$dispatch("905872271", new Object[]{this, ptrFrameLayout});
        } else {
            this.mInnerView.onRefresh();
        }
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045222767")) {
            ipChange.ipc$dispatch("-2045222767", new Object[]{this, ptrFrameLayout});
        } else {
            this.mInnerView.onReset();
        }
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1611618993")) {
            ipChange.ipc$dispatch("1611618993", new Object[]{this, ptrFrameLayout});
        } else {
            this.mInnerView.onReset();
        }
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIReset(PtrFrameLayout ptrFrameLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1423139178")) {
            ipChange.ipc$dispatch("-1423139178", new Object[]{this, ptrFrameLayout});
        } else {
            this.mInnerView.onReset();
        }
    }

    public PtrUiHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PtrUiHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        PullToRefreshHeaderView pullToRefreshHeaderView = PullToRefreshHeaderView.getInstance(context);
        this.mInnerView = pullToRefreshHeaderView;
        addView(pullToRefreshHeaderView, new FlowLayout.LayoutParams(-1, -2));
    }
}
