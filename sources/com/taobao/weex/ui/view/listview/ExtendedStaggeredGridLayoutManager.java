package com.taobao.weex.ui.view.listview;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ExtendedStaggeredGridLayoutManager extends StaggeredGridLayoutManager {
    public ExtendedStaggeredGridLayoutManager(int i, int i2) {
        super(i, i2);
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        if (i == -1) {
            WXLogUtils.e("ExtendedStaggeredGridLayoutManager: onItemsRemoved  Error Invalid Index : positionStart :" + i + "  itemCount:" + i2);
            return;
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.e("ExtendedStaggeredGridLayoutManager: onItemsRemoved  positionStart :" + i + "  itemCount:" + i2);
        }
        super.onItemsRemoved(recyclerView, i, i2);
    }
}
