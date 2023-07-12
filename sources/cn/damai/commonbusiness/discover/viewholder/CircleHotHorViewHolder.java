package cn.damai.commonbusiness.discover.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.discover.adapter.CircleAdapter;
import cn.damai.commonbusiness.discover.bean.CircleBean;
import cn.damai.commonbusiness.discover.bean.CircleListWrapBean;
import cn.damai.tetris.component.discover.view.NIndicator;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class CircleHotHorViewHolder extends BaseViewHolderV2<CircleListWrapBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final CircleAdapter c;
    private final TextView d;
    private final NIndicator e;

    public CircleHotHorViewHolder(View view, OnItemBindListener<CircleBean> onItemBindListener) {
        super(view);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.circle_hor_list);
        this.d = (TextView) view.findViewById(R$id.tv_circle_hor_title);
        NIndicator nIndicator = (NIndicator) view.findViewById(R$id.nIndicator);
        this.e = nIndicator;
        nIndicator.bindRecyclerView(recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager((Context) mu0.a(), 2, 0, false));
        CircleAdapter circleAdapter = new CircleAdapter(onItemBindListener);
        this.c = circleAdapter;
        recyclerView.setAdapter(circleAdapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2
    /* renamed from: d */
    public void c(CircleListWrapBean circleListWrapBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-66248985")) {
            ipChange.ipc$dispatch("-66248985", new Object[]{this, circleListWrapBean, Integer.valueOf(i)});
        } else if (circleListWrapBean == null) {
        } else {
            this.c.c(circleListWrapBean.themes);
            this.e.setVisibility(circleListWrapBean.themes.size() > 4 ? 0 : 8);
            if (circleListWrapBean.mTitleBean == null) {
                this.d.setVisibility(8);
                return;
            }
            this.d.setVisibility(0);
            this.d.setText(circleListWrapBean.mTitleBean.title);
        }
    }
}
