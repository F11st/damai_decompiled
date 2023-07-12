package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectTitleViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private View b;
    private Context c;

    public ProjectTitleViewHolder(Context context, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_title_layout, viewGroup, false));
        this.c = context;
        b();
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1915005859")) {
            ipChange.ipc$dispatch("-1915005859", new Object[]{this});
            return;
        }
        this.a = (TextView) this.itemView.findViewById(R$id.project_item_section_title_tv);
        this.b = this.itemView.findViewById(R$id.line);
    }

    public void a(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1432500340")) {
            ipChange.ipc$dispatch("1432500340", new Object[]{this, projectDataHolder});
            return;
        }
        this.a.setText(projectDataHolder.getSectionTitleContent());
        if (projectDataHolder.getSectionTitleType() == 7 && this.c != null) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
    }
}
