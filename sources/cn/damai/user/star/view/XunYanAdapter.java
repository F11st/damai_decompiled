package cn.damai.user.star.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMLabelView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class XunYanAdapter extends RecyclerView.Adapter<VH> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<String> a;
    private Context b;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static class VH extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        public View a;
        private ViewGroup b;
        private TextView c;

        public VH(View view) {
            super(view);
            this.a = view;
            this.b = (ViewGroup) view.findViewById(R$id.xunyan_item_layout_1);
            this.c = (TextView) view.findViewById(R$id.xunyan_item_tv_1);
        }

        private void b(ViewGroup viewGroup, TextView textView, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-154773035")) {
                ipChange.ipc$dispatch("-154773035", new Object[]{this, viewGroup, textView, str});
            } else if (TextUtils.isEmpty(str)) {
                viewGroup.setVisibility(4);
            } else {
                viewGroup.setVisibility(0);
                textView.setText(str);
            }
        }

        public void a(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "711957071")) {
                ipChange.ipc$dispatch("711957071", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            b(this.b, this.c, str);
            int i2 = i % 3;
            if (i2 == 0) {
                ((DMLabelView) this.a.findViewById(R$id.xunyan_item_laeblview1)).setLabelType(DMLabelType.LABEL_TYPE_CUSTOM).setBgColor("#FFA7AA", "#FF88AE");
            } else if (i2 == 1) {
                ((DMLabelView) this.a.findViewById(R$id.xunyan_item_laeblview1)).setLabelType(DMLabelType.LABEL_TYPE_CUSTOM).setBgColor("#D2CBFE", "#A79AFF");
            } else {
                ((DMLabelView) this.a.findViewById(R$id.xunyan_item_laeblview1)).setLabelType(DMLabelType.LABEL_TYPE_CUSTOM).setBgColor("#B5EFFF", "#74D1FF");
            }
        }
    }

    public XunYanAdapter(Context context) {
        this.b = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull VH vh, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1471037234")) {
            ipChange.ipc$dispatch("1471037234", new Object[]{this, vh, Integer.valueOf(i)});
            return;
        }
        List<String> list = this.a;
        vh.a(list.get(i % list.size()), i % this.a.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: b */
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-888072060")) {
            return (VH) ipChange.ipc$dispatch("-888072060", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.b).inflate(R$layout.mine_starindex_xunyan_flipper_item, viewGroup, false);
        inflate.getLayoutParams().height = t60.a(this.b, 24.0f);
        return new VH(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1625344718")) {
            return ((Integer) ipChange.ipc$dispatch("1625344718", new Object[]{this})).intValue();
        }
        return Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1689301550")) {
            return ((Long) ipChange.ipc$dispatch("-1689301550", new Object[]{this, Integer.valueOf(i)})).longValue();
        }
        return 0L;
    }
}
