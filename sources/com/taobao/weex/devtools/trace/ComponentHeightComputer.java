package com.taobao.weex.devtools.trace;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXScroller;
import com.taobao.weex.ui.component.list.WXListComponent;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ComponentHeightComputer {
    private ComponentHeightComputer() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeComponentContentHeight(@NonNull WXComponent wXComponent) {
        View hostView = wXComponent.getHostView();
        if (hostView == null) {
            return 0;
        }
        if (wXComponent instanceof WXListComponent) {
            BounceRecyclerView bounceRecyclerView = (BounceRecyclerView) ((WXListComponent) wXComponent).getHostView();
            if (bounceRecyclerView == null) {
                return 0;
            }
            WXRecyclerView innerView = bounceRecyclerView.getInnerView();
            if (innerView == null) {
                return bounceRecyclerView.getMeasuredHeight();
            }
            return innerView.computeVerticalScrollRange();
        } else if (wXComponent instanceof WXScroller) {
            WXScroller wXScroller = (WXScroller) wXComponent;
            if (!ViewUtils.isVerticalScroller(wXScroller)) {
                return hostView.getMeasuredHeight();
            }
            ViewGroup innerView2 = wXScroller.getInnerView();
            if (innerView2 == null) {
                return hostView.getMeasuredHeight();
            }
            if (innerView2.getChildCount() != 1) {
                return hostView.getMeasuredHeight();
            }
            return innerView2.getChildAt(0).getMeasuredHeight();
        } else {
            return hostView.getMeasuredHeight();
        }
    }
}
