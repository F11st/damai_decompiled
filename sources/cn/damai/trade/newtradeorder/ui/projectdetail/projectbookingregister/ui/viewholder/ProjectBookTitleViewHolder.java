package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
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
public class ProjectBookTitleViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;

    public ProjectBookTitleViewHolder(Context context, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_book_title_layout, viewGroup, false));
        b();
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794305074")) {
            ipChange.ipc$dispatch("-1794305074", new Object[]{this});
        } else {
            this.a = (TextView) this.itemView.findViewById(R$id.project_item_section_title_tv);
        }
    }

    public void a(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1652960541")) {
            ipChange.ipc$dispatch("-1652960541", new Object[]{this, projectDataHolder});
        } else {
            this.a.setText(projectDataHolder.getSectionTitleContent());
        }
    }
}
