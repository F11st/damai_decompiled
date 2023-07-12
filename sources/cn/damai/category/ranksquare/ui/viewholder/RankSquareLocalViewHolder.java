package cn.damai.category.ranksquare.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.ranksquare.bean.RankSquareGroupItemBean;
import cn.damai.category.ranksquare.ui.adapter.RankSquareLocalAdapter;
import cn.damai.common.user.C0529c;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;
import tb.zy1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RankSquareLocalViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private RecyclerView a;
    private TextView b;
    private Context c;
    private RankSquareLocalAdapter d;
    private boolean e;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.ranksquare.ui.viewholder.RankSquareLocalViewHolder$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0436a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0436a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2069380781")) {
                ipChange.ipc$dispatch("-2069380781", new Object[]{this, view});
            } else if (((Boolean) view.getTag()).booleanValue() && RankSquareLocalViewHolder.this.d != null) {
                C0529c.e().x(zy1.f().m());
                RankSquareLocalViewHolder rankSquareLocalViewHolder = RankSquareLocalViewHolder.this;
                rankSquareLocalViewHolder.e = !rankSquareLocalViewHolder.e;
                RankSquareLocalViewHolder.this.d.c(RankSquareLocalViewHolder.this.e);
                RankSquareLocalViewHolder.this.d.notifyDataSetChanged();
                RankSquareLocalViewHolder.this.g();
            }
        }
    }

    public RankSquareLocalViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.rank_square_grid_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.c = layoutInflater.getContext();
        this.e = false;
        f(this.itemView);
    }

    private void f(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-263611662")) {
            ipChange.ipc$dispatch("-263611662", new Object[]{this, view});
            return;
        }
        this.a = (RecyclerView) view.findViewById(R$id.rc_local_rank);
        this.a.setLayoutManager(new GridLayoutManager(this.c, 3));
        RankSquareLocalAdapter rankSquareLocalAdapter = new RankSquareLocalAdapter(this.c);
        this.d = rankSquareLocalAdapter;
        this.a.setAdapter(rankSquareLocalAdapter);
        TextView textView = (TextView) view.findViewById(R$id.tv_show_more);
        this.b = textView;
        textView.setOnClickListener(new View$OnClickListenerC0436a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-850155430")) {
            ipChange.ipc$dispatch("-850155430", new Object[]{this});
        } else if (this.e) {
            this.b.setText("收起");
        } else {
            this.b.setText("展开更多");
        }
    }

    public void e(List<RankSquareGroupItemBean> list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1116014395")) {
            ipChange.ipc$dispatch("1116014395", new Object[]{this, list, Boolean.valueOf(z)});
            return;
        }
        int e = wh2.e(list);
        if (e <= 0) {
            return;
        }
        this.b.setTag(Boolean.valueOf(z));
        if (z && e > 9) {
            this.b.setVisibility(0);
            g();
        } else {
            this.b.setVisibility(8);
        }
        RankSquareLocalAdapter rankSquareLocalAdapter = this.d;
        if (rankSquareLocalAdapter != null) {
            rankSquareLocalAdapter.c(this.e);
            this.d.b(list, z);
            this.d.notifyDataSetChanged();
        }
    }
}
