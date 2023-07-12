package com.alient.onearch.adapter;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alient.onearch.adapter.monitor.CMSRenderMonitorPoint;
import com.alient.onearch.adapter.monitor.MonitorConstant;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GenericVirtualLayoutManager extends VirtualLayoutManager {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class ProtectedLayoutState extends ExposeLinearLayoutManagerEx.C3282c {
        ProtectedLayoutState() {
        }

        @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx.C3282c
        public View next(RecyclerView.Recycler recycler) {
            try {
                return super.next(recycler);
            } catch (Exception e) {
                if (!AppInfoProviderProxy.isDebuggable()) {
                    CMSRenderMonitorPoint.Companion.commitCMSRenderMonitorFail(MonitorConstant.CMS_VIEW_HOLDER_POSITION_ERROR, "", null);
                    return null;
                }
                throw e;
            }
        }
    }

    public GenericVirtualLayoutManager(@NonNull @NotNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.android.vlayout.VirtualLayoutManager, com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public void ensureLayoutStateExpose() {
        if (this.mLayoutState == null) {
            this.mLayoutState = new ProtectedLayoutState();
        }
        super.ensureLayoutStateExpose();
    }

    @Override // com.alibaba.android.vlayout.VirtualLayoutManager, com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
            if (!AppInfoProviderProxy.isDebuggable()) {
                CMSRenderMonitorPoint.Companion.commitCMSRenderMonitorFail(MonitorConstant.CMS_LAYOUT_CHILDREN_ERROR, "", null);
                e.printStackTrace();
                return;
            }
            throw e;
        }
    }

    public GenericVirtualLayoutManager(@NonNull @NotNull Context context, int i) {
        super(context, i);
    }

    public GenericVirtualLayoutManager(@NonNull @NotNull Context context, int i, boolean z) {
        super(context, i, z);
    }
}
