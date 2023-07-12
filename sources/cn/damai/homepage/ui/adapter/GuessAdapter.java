package cn.damai.homepage.ui.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.component.base.HomePageViewFactory;
import cn.damai.tetris.v2.helper.StaggeredLayoutHelper;
import com.alibaba.android.vlayout.AbstractC3289a;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.fm;
import tb.gh1;
import tb.m62;
import tb.m91;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class GuessAdapter extends DelegateAdapter.Adapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private List<fm> b = new ArrayList();
    private String c;
    private StaggeredLayoutHelper d;

    public GuessAdapter(Activity activity) {
        this.a = activity;
        StaggeredLayoutHelper staggeredLayoutHelper = new StaggeredLayoutHelper(2);
        this.d = staggeredLayoutHelper;
        staggeredLayoutHelper.g(m62.a(this.a, 12.0f));
        this.d.setHGap(m62.a(this.a, 9.0f));
        this.d.setBgColor(Color.parseColor("#f4f5f6"));
    }

    public void a(boolean z, String str, List<fm> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-569792091")) {
            ipChange.ipc$dispatch("-569792091", new Object[]{this, Boolean.valueOf(z), str, list});
            return;
        }
        this.c = str;
        if (list == null) {
            list = new ArrayList<>();
        }
        if (z) {
            this.b.clear();
        }
        int size = this.b.size();
        int size2 = list.size();
        if (!m91.a(list)) {
            this.b.addAll(list);
        }
        notifyItemRangeChanged(size, size2);
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1961388310")) {
            ipChange.ipc$dispatch("1961388310", new Object[]{this});
            return;
        }
        List<fm> list = this.b;
        if (list != null) {
            list.clear();
        }
    }

    public void c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "871798800")) {
            ipChange.ipc$dispatch("871798800", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.b.remove(i);
        notifyItemRemoved(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1074454441") ? ((Integer) ipChange.ipc$dispatch("-1074454441", new Object[]{this})).intValue() : wh2.e(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        fm fmVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-951314562")) {
            return ((Integer) ipChange.ipc$dispatch("-951314562", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        List<fm> list = this.b;
        if (list == null || (fmVar = list.get(i)) == null) {
            return -1;
        }
        return fmVar.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-275930558")) {
            ipChange.ipc$dispatch("-275930558", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        fm fmVar = this.b.get(i);
        if (viewHolder == null || fmVar == null || fmVar.b != 2) {
            return;
        }
        HomePageViewFactory.b(viewHolder, fmVar, i, this);
    }

    @Override // com.alibaba.android.vlayout.DelegateAdapter.Adapter
    public AbstractC3289a onCreateLayoutHelper() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1891227642") ? (AbstractC3289a) ipChange.ipc$dispatch("-1891227642", new Object[]{this}) : this.d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1257900020")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1257900020", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (gh1.a(i) == 2) {
            return HomePageViewFactory.c(viewGroup, this.c, this.a, i);
        }
        return null;
    }
}
