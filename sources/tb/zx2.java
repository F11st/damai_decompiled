package tb;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cn.damai.tetris.R$layout;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.adapter.VerticalAdapter;
import cn.damai.tetris.core.holder.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class zx2 {
    private static transient /* synthetic */ IpChange $ipChange;
    ja a;

    public zx2(Activity activity) {
        ja jaVar = new ja();
        this.a = jaVar;
        jaVar.setActivity(activity);
    }

    public ja a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1372332307") ? (ja) ipChange.ipc$dispatch("1372332307", new Object[]{this}) : this.a;
    }

    public String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1203965371")) {
            return (String) ipChange.ipc$dispatch("1203965371", new Object[]{this});
        }
        ja jaVar = this.a;
        return jaVar == null ? "" : jaVar.a();
    }

    public LinearLayout c(ArrayList<BaseLayer> arrayList, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "796979545")) {
            return (LinearLayout) ipChange.ipc$dispatch("796979545", new Object[]{this, arrayList, viewGroup});
        }
        List<BaseLayer> o = C9039db.o(arrayList);
        VerticalAdapter verticalAdapter = new VerticalAdapter(this.a, new ox2());
        verticalAdapter.b(o);
        ja jaVar = this.a;
        if (jaVar != null && jaVar.getActivity() != null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getActivity()).inflate(R$layout.tetris_core_linear_proxy, viewGroup, false);
            for (int i = 0; i < verticalAdapter.getItemCount(); i++) {
                BaseViewHolder onCreateViewHolder = verticalAdapter.onCreateViewHolder(linearLayout, verticalAdapter.getItemViewType(i));
                verticalAdapter.onBindViewHolder(onCreateViewHolder, i);
                linearLayout.addView(onCreateViewHolder.itemView);
            }
            return linearLayout;
        }
        jb1.b("ViewCreater", " toLinearLayout : baseContext is null ");
        return null;
    }
}
