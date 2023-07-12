package cn.damai.tetris.component.online.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.tetris.component.drama.viewholder.OnItemClickListener;
import cn.damai.tetris.component.online.bean.ProjectInfoBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;
import tb.mu0;
import tb.nf;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class OnLineProListViewHolder extends BaseViewHolderV2<ProjectInfoBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private OnLinePosterView i;
    private OnItemClickListener<ProjectInfoBean> j;
    private int k;
    private int l;
    private TextView m;
    private LinearLayout n;

    public OnLineProListViewHolder(Context context, ViewGroup viewGroup, OnItemClickListener<ProjectInfoBean> onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.item_tetris_online_card, viewGroup, false));
        this.k = 0;
        this.l = 0;
        View findViewById = this.itemView.findViewById(R$id.pro_inner_layout);
        this.n = (LinearLayout) this.itemView.findViewById(R$id.onlive_date_layout);
        this.c = (TextView) this.itemView.findViewById(R$id.item_title);
        this.f = (TextView) this.itemView.findViewById(R$id.onlive_date);
        this.d = (TextView) this.itemView.findViewById(R$id.item_price_tv);
        this.h = (TextView) this.itemView.findViewById(R$id.tv_project_price_confirm);
        this.g = (TextView) this.itemView.findViewById(R$id.item_price_above);
        this.e = (TextView) this.itemView.findViewById(R$id.item_price_desc);
        this.i = (OnLinePosterView) this.itemView.findViewById(R$id.item_poster);
        this.m = (TextView) this.itemView.findViewById(R$id.item_price_flag);
        this.j = onItemClickListener;
        findViewById.setOnClickListener(this);
        this.k = m62.a(mu0.a(), 98.0f);
        this.l = m62.a(mu0.a(), 131.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2
    /* renamed from: d */
    public void c(ProjectInfoBean projectInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1205084418")) {
            ipChange.ipc$dispatch("1205084418", new Object[]{this, projectInfoBean, Integer.valueOf(i)});
        } else if (projectInfoBean == null) {
        } else {
            String str = projectInfoBean.priceStr;
            if (str != null && !TextUtils.isEmpty(str)) {
                this.d.setVisibility(8);
                this.m.setVisibility(8);
                this.h.setVisibility(0);
                this.h.setText(projectInfoBean.priceStr);
                this.g.setVisibility(8);
            } else if (projectInfoBean.price != null) {
                this.d.setVisibility(0);
                this.d.setText(projectInfoBean.price);
                this.h.setVisibility(8);
                this.m.setVisibility(0);
                this.g.setVisibility(0);
            }
            this.c.setText(projectInfoBean.itemName);
            this.i.setImageUrlForWebp(projectInfoBean.poster, this.k, this.l);
            this.i.setPicList(projectInfoBean.artistList);
            String str2 = projectInfoBean.itemFlag;
            if (str2 != null) {
                this.e.setText(str2);
            }
            if (projectInfoBean.liveStatus == 3) {
                this.i.setOnliveTag(false);
                this.n.setVisibility(8);
            } else {
                this.i.setOnliveTag(true);
                this.n.setVisibility(0);
            }
            long j = projectInfoBean.startPerformTime;
            if (j != 0) {
                this.f.setText(nf.q(projectInfoBean.currentTime, j));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        T t;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-381493336")) {
            ipChange.ipc$dispatch("-381493336", new Object[]{this, view});
            return;
        }
        OnItemClickListener<ProjectInfoBean> onItemClickListener = this.j;
        if (onItemClickListener == null || (t = this.a) == 0) {
            return;
        }
        onItemClickListener.onItemClick((ProjectInfoBean) t, this.b);
    }
}
