package cn.damai.search.ui.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.helper.SearchListener;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class FlowerViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMIconFontTextView a;
    private FlowLayout b;
    private LayoutInflater c;
    private SearchListener d;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.viewholder.FlowerViewHolder$a */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1620a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1620a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1604539054")) {
                ipChange.ipc$dispatch("1604539054", new Object[]{this, view});
            } else if (FlowerViewHolder.this.d != null) {
                FlowerViewHolder.this.d.onHistoryTextClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.viewholder.FlowerViewHolder$b */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1621b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1621b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-579137873")) {
                ipChange.ipc$dispatch("-579137873", new Object[]{this, view});
            } else if (FlowerViewHolder.this.d != null) {
                FlowerViewHolder.this.d.onDeleteHistoryClick(view);
            }
        }
    }

    public FlowerViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.search_list_history, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.b = (FlowLayout) this.itemView.findViewById(R$id.fl_hotsearch);
        this.a = (DMIconFontTextView) this.itemView.findViewById(R$id.iv_delete);
        this.c = layoutInflater;
    }

    public void b(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1950554431")) {
            ipChange.ipc$dispatch("1950554431", new Object[]{this, list});
        } else if (list != null) {
            this.b.removeAllViews();
            for (int i = 0; i < list.size(); i++) {
                View inflate = this.c.inflate(R$layout.layout_text, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.ll_label);
                ((TextView) inflate.findViewById(R$id.tv_keyname)).setText(list.get(i));
                this.b.addView(inflate);
                linearLayout.setTag(list.get(i) + "," + String.valueOf(i));
                linearLayout.setOnClickListener(new View$OnClickListenerC1620a());
            }
            this.a.setOnClickListener(new View$OnClickListenerC1621b());
        }
    }

    public void c(SearchListener searchListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "780622797")) {
            ipChange.ipc$dispatch("780622797", new Object[]{this, searchListener});
        } else {
            this.d = searchListener;
        }
    }
}
