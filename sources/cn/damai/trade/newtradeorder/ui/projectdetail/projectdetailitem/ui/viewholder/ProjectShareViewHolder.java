package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ShareManagerImpl;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectShareViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView a;
    private ImageView b;
    private ImageView c;
    private ShareManagerImpl d;
    View.OnClickListener e;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1210622804")) {
                ipChange.ipc$dispatch("1210622804", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id == R$id.icon_wx) {
                if (ProjectShareViewHolder.this.d != null) {
                    ProjectShareViewHolder.this.d.shareWX();
                }
            } else if (id == R$id.icon_friend) {
                if (ProjectShareViewHolder.this.d != null) {
                    ProjectShareViewHolder.this.d.shareFriend();
                }
            } else if (id != R$id.icon_help || ProjectShareViewHolder.this.d == null) {
            } else {
                ProjectShareViewHolder.this.d.createPic();
            }
        }
    }

    public ProjectShareViewHolder(Context context, ShareManagerImpl shareManagerImpl, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_share_layout, viewGroup, false));
        this.e = new a();
        this.d = shareManagerImpl;
        b();
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1088962145")) {
            ipChange.ipc$dispatch("1088962145", new Object[]{this});
            return;
        }
        this.a = (ImageView) this.itemView.findViewById(R$id.icon_wx);
        this.b = (ImageView) this.itemView.findViewById(R$id.icon_friend);
        this.c = (ImageView) this.itemView.findViewById(R$id.icon_help);
        this.a.setOnClickListener(this.e);
        this.b.setOnClickListener(this.e);
        this.c.setOnClickListener(this.e);
    }
}
