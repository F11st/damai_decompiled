package com.taobao.weex.ui.component.list;

import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface ListComponentView {
    WXRecyclerView getInnerView();

    RecyclerViewBaseAdapter getRecyclerViewBaseAdapter();

    void notifyStickyRemove(WXCell wXCell);

    void notifyStickyShow(WXCell wXCell);

    void setRecyclerViewBaseAdapter(RecyclerViewBaseAdapter recyclerViewBaseAdapter);

    void updateStickyView(int i);
}
