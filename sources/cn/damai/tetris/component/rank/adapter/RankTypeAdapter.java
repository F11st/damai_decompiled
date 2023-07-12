package cn.damai.tetris.component.rank.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.rank.bean.TypeTabBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankTypeAdapter extends RecyclerView.Adapter<RTVh> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final int[] e = new int[4];
    private static final int f = Color.parseColor("#9C9CA5");
    private static final int g = Color.parseColor("#EDEDED");
    private Context a;
    private OnItemBindListener<TypeTabBean> b;
    private final List<TypeTabBean> c = new ArrayList();
    private TypeTabBean d;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class RTVh extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private TextView b;
        private TextView c;
        private TypeTabBean d;
        private int e;

        public RTVh(@NonNull View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.id_rank_one_sub_text);
            this.b = (TextView) view.findViewById(R$id.id_rank_one_sub_left_icon);
            this.c = (TextView) view.findViewById(R$id.id_rank_one_sub_right_icon);
            view.setOnClickListener(this);
        }

        public void a(TypeTabBean typeTabBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-243477047")) {
                ipChange.ipc$dispatch("-243477047", new Object[]{this, typeTabBean, Integer.valueOf(i)});
                return;
            }
            this.d = typeTabBean;
            this.e = i;
            this.a.setText(typeTabBean.name);
            if (!(typeTabBean == RankTypeAdapter.this.d)) {
                this.a.setTextColor(RankTypeAdapter.f);
                this.b.setTextColor(RankTypeAdapter.g);
                this.c.setTextColor(RankTypeAdapter.g);
            } else {
                int c = RankTypeAdapter.this.c(i);
                this.a.setTextColor(c);
                this.b.setTextColor(c);
                this.c.setTextColor(c);
            }
            RankTypeAdapter.this.b.exposeItem(this.itemView, typeTabBean, i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1315468653")) {
                ipChange.ipc$dispatch("-1315468653", new Object[]{this, view});
                return;
            }
            TypeTabBean typeTabBean = this.d;
            if (typeTabBean == null || typeTabBean.equals(RankTypeAdapter.this.d)) {
                return;
            }
            RankTypeAdapter.this.b.onItemClick(this.d, this.e);
        }
    }

    public RankTypeAdapter(Context context, OnItemBindListener<TypeTabBean> onItemBindListener) {
        this.a = context;
        this.b = onItemBindListener;
        int[] iArr = e;
        iArr[0] = Color.parseColor("#FF8C51");
        iArr[1] = Color.parseColor("#8F8FFF");
        iArr[2] = Color.parseColor("#61C4FF");
        iArr[3] = Color.parseColor("#FF79BD");
    }

    public int c(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1106788441") ? ((Integer) ipChange.ipc$dispatch("1106788441", new Object[]{this, Integer.valueOf(i)})).intValue() : e[i % 4];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(@NonNull RTVh rTVh, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1274896158")) {
            ipChange.ipc$dispatch("-1274896158", new Object[]{this, rTVh, Integer.valueOf(i)});
        } else {
            rTVh.a(this.c.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: e */
    public RTVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1382499220") ? (RTVh) ipChange.ipc$dispatch("1382499220", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new RTVh(LayoutInflater.from(this.a).inflate(R$layout.item_tetris_rank_one_sub_filter, viewGroup, false));
    }

    public void f(List<TypeTabBean> list, TypeTabBean typeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-174841649")) {
            ipChange.ipc$dispatch("-174841649", new Object[]{this, list, typeTabBean});
            return;
        }
        this.c.clear();
        this.d = typeTabBean;
        if (!cb2.d(list)) {
            this.c.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void g(TypeTabBean typeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-711113816")) {
            ipChange.ipc$dispatch("-711113816", new Object[]{this, typeTabBean});
            return;
        }
        this.d = typeTabBean;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1468646027") ? ((Integer) ipChange.ipc$dispatch("-1468646027", new Object[]{this})).intValue() : this.c.size();
    }
}
