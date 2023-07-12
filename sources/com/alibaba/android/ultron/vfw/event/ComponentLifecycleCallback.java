package com.alibaba.android.ultron.vfw.event;

import android.view.ViewGroup;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface ComponentLifecycleCallback {
    void onBindData(RecyclerViewHolder recyclerViewHolder, IDMComponent iDMComponent, Map<String, Object> map);

    void onCreateViewHolder(ViewGroup viewGroup, int i, Map<String, Object> map);
}
