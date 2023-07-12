package cn.damai.launcher.splash;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cn.damai.category.discountticket.adapter.Column3ProjectViewHolder;
import cn.damai.homepage.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public abstract class Column3ProjectViewHolderImpl extends Column3ProjectViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;

    public Column3ProjectViewHolderImpl(View view) {
        super(view);
    }

    public void g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437850250")) {
            ipChange.ipc$dispatch("437850250", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ViewGroup[] viewGroupArr = {(ViewGroup) this.itemView.findViewById(R$id.item_1_layout), (ViewGroup) this.itemView.findViewById(R$id.item_2_layout), (ViewGroup) this.itemView.findViewById(R$id.item_3_layout)};
        for (int i2 = 0; i2 < 3; i2++) {
            ViewGroup viewGroup = viewGroupArr[i2];
            if (viewGroup != null && (viewGroup instanceof LinearLayout)) {
                int a = t60.a(this.itemView.getContext(), 6.0f);
                viewGroup.setPadding(a, i, a, i);
            }
        }
    }
}
