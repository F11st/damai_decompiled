package com.alibaba.android.ultron.vfw.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.ArrayList;
import java.util.List;
import tb.ay2;
import tb.co2;
import tb.cy2;
import tb.ny2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> implements IAdapter {
    private ay2 a;
    private List<IDMComponent> b = new ArrayList();
    private cy2 c;

    public RecyclerViewAdapter(ay2 ay2Var) {
        this.a = ay2Var;
        this.c = (cy2) ay2Var.getService(cy2.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int i) {
        String str;
        co2.e("RecyclerViewBindView", "onBind start");
        IDMComponent iDMComponent = this.b.get(i);
        this.c.b(recyclerViewHolder, iDMComponent);
        if (iDMComponent != null) {
            JSONObject containerInfo = iDMComponent.getContainerInfo();
            String simpleName = recyclerViewHolder.c() != null ? recyclerViewHolder.c().getClass().getSimpleName() : "null";
            if (containerInfo != null) {
                str = containerInfo.getString("name");
            } else {
                str = "native-" + simpleName;
            }
        } else {
            str = "";
        }
        co2.a("RecyclerViewBindView", "onBind end, " + str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (-1 == i) {
            return new RecyclerViewHolder(ny2.a(this.a.l()));
        }
        co2.e("RecyclerViewCreateView", "createView start");
        RecyclerViewHolder c = this.c.c(viewGroup, i);
        co2.a("RecyclerViewCreateView", "createView end, viewtype: " + i);
        return c;
    }

    @Override // com.alibaba.android.ultron.vfw.adapter.IAdapter
    public List<IDMComponent> getData() {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<IDMComponent> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.c.f(this.b.get(i));
    }

    @Override // com.alibaba.android.ultron.vfw.adapter.IAdapter
    public void setData(List<IDMComponent> list) {
        if (list != null) {
            this.b.clear();
            this.b.addAll(list);
        }
    }
}
