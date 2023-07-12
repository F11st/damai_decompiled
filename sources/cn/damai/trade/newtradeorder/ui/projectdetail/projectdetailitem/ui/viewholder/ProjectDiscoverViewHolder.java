package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.view.SpaceItemDecoration;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.adapter.HorizontalDiscoverAdapter;
import cn.damai.uikit.irecycler.HorizontalRecyclerView;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m91;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectDiscoverViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private HorizontalRecyclerView b;
    private HorizontalDiscoverAdapter c;
    private View.OnClickListener d;

    public ProjectDiscoverViewHolder(Context context, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_discover_layout, viewGroup, false));
        this.a = context;
        this.d = onClickListener;
        b();
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-785217274")) {
            ipChange.ipc$dispatch("-785217274", new Object[]{this});
            return;
        }
        this.b = (HorizontalRecyclerView) this.itemView.findViewById(R$id.irc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
        linearLayoutManager.setOrientation(0);
        this.b.setLayoutManager(linearLayoutManager);
        this.c = new HorizontalDiscoverAdapter(this.a, this.d);
        this.b.addItemDecoration(new SpaceItemDecoration(ScreenUtil.dip2px(this.a, 6.0f)));
        this.b.setAdapter(this.c);
    }

    public void a(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "829519531")) {
            ipChange.ipc$dispatch("829519531", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder == null || m91.a(projectDataHolder.inFieldComments)) {
        } else {
            this.c.a(projectDataHolder.inFieldComments, projectDataHolder.getProjectId());
        }
    }
}
