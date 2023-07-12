package cn.damai.mine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.bean.FeedBack;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class FeedBackListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<FeedBack> a;
    private View.OnClickListener b;
    private LayoutInflater c;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class FeedBackViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private View b;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.mine.adapter.FeedBackListAdapter$FeedBackViewHolder$a */
        /* loaded from: classes15.dex */
        public class View$OnClickListenerC1425a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC1425a(FeedBackListAdapter feedBackListAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "840044162")) {
                    ipChange.ipc$dispatch("840044162", new Object[]{this, view});
                } else if (FeedBackListAdapter.this.b != null) {
                    FeedBackListAdapter.this.b.onClick(view);
                }
            }
        }

        public FeedBackViewHolder(LayoutInflater layoutInflater) {
            super(layoutInflater.inflate(R$layout.feed_back_list_item, (ViewGroup) null));
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.a = (TextView) this.itemView.findViewById(R$id.tv_desc);
            this.b = this.itemView.findViewById(R$id.line);
            this.itemView.setOnClickListener(new View$OnClickListenerC1425a(FeedBackListAdapter.this));
        }

        public void a(FeedBack feedBack, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1305716590")) {
                ipChange.ipc$dispatch("-1305716590", new Object[]{this, feedBack, Boolean.valueOf(z)});
            } else if (feedBack == null) {
            } else {
                this.itemView.setTag(feedBack);
                this.a.setText(feedBack.title);
                this.b.setVisibility(z ? 8 : 0);
            }
        }
    }

    public FeedBackListAdapter(Context context, List<FeedBack> list, View.OnClickListener onClickListener) {
        this.a = list;
        this.b = onClickListener;
        this.c = LayoutInflater.from(context);
    }

    public List<FeedBack> b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2065520958") ? (List) ipChange.ipc$dispatch("2065520958", new Object[]{this}) : this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-711035819") ? ((Integer) ipChange.ipc$dispatch("-711035819", new Object[]{this})).intValue() : this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "788019076")) {
            ipChange.ipc$dispatch("788019076", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        FeedBack feedBack = this.a.get(i);
        if (feedBack == null) {
            return;
        }
        ((FeedBackViewHolder) viewHolder).a(feedBack, i == getItemCount() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1312325874") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1312325874", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new FeedBackViewHolder(this.c);
    }
}
