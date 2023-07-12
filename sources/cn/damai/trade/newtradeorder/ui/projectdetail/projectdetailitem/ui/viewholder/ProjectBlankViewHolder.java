package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectBlankViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private DamaiRootRecyclerView b;
    private int c;

    public ProjectBlankViewHolder(Context context, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.project_blank_layout, viewGroup, false));
        this.a = context;
        this.b = (DamaiRootRecyclerView) viewGroup;
    }

    public void a(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "438739824")) {
            ipChange.ipc$dispatch("438739824", new Object[]{this, projectDataHolder});
        } else if (this.c == 0) {
            this.c = this.b.getHeaderContainer().getMeasuredHeight();
            this.itemView.getLayoutParams().height = DisplayMetrics.getheightPixels(t60.b(this.a)) - this.c;
        }
    }
}
