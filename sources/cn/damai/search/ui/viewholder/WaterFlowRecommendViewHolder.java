package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.ui.adapter.WaterFlowAdapter;
import cn.damai.search.ui.decoration.WaterGridItemDecoration;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class WaterFlowRecommendViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private DamaiRootRecyclerView a;
    private WaterFlowAdapter b;
    private List c;

    public WaterFlowRecommendViewHolder(Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.waterflow_recyclerview, (ViewGroup) null));
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.c = new ArrayList();
        this.a = (DamaiRootRecyclerView) this.itemView.findViewById(R$id.waterflow_rv);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        this.a.setAnimation(null);
        this.a.addItemDecoration(new WaterGridItemDecoration());
        this.a.setLayoutManager(staggeredGridLayoutManager);
        WaterFlowAdapter waterFlowAdapter = new WaterFlowAdapter(context, this.c);
        this.b = waterFlowAdapter;
        this.a.setAdapter(waterFlowAdapter);
    }

    public void a(List list, String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "74911155")) {
            ipChange.ipc$dispatch("74911155", new Object[]{this, list, str, Integer.valueOf(i), str2});
            return;
        }
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.clear();
        this.c.addAll(list);
        WaterFlowAdapter waterFlowAdapter = this.b;
        if (waterFlowAdapter != null) {
            waterFlowAdapter.d(str, i, str2);
            this.b.notifyDataSetChanged();
        }
    }
}
