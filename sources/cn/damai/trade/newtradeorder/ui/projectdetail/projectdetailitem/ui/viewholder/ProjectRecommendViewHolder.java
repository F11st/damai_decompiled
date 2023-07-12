package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnRecommendItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.gb;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectRecommendViewHolder extends ProjectItemViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context E;
    private OnRecommendItemClickListener F;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectRecommendViewHolder$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2402a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;

        public View$OnClickListenerC2402a(int i, ProjectItemBean projectItemBean) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1282839114")) {
                ipChange.ipc$dispatch("1282839114", new Object[]{this, view});
            } else if (ProjectRecommendViewHolder.this.F != null) {
                ProjectRecommendViewHolder.this.F.onRecommendItemClick(this.a);
            }
        }
    }

    public ProjectRecommendViewHolder(Context context, OnRecommendItemClickListener onRecommendItemClickListener, ViewGroup viewGroup) {
        super(context, LayoutInflater.from(context));
        this.E = context;
        this.F = onRecommendItemClickListener;
    }

    private void F(ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-974655297")) {
            ipChange.ipc$dispatch("-974655297", new Object[]{this, projectItemBean, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", projectItemBean.id);
        hashMap.put("titlelabel", projectItemBean.name);
        hashMap.put("alg", projectItemBean.alg);
        C0529c e = C0529c.e();
        View view = this.itemView;
        e.G(view, "item_" + i, "rec", gb.PROJECT_PAGE, hashMap);
    }

    private void G(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965550231")) {
            ipChange.ipc$dispatch("965550231", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (i == 0) {
            j().setVisibility(8);
        } else {
            j().setVisibility(0);
        }
        if (i == i2 - 1) {
            View view = this.itemView;
            view.setPadding(view.getPaddingLeft(), this.itemView.getPaddingTop(), this.itemView.getPaddingRight(), t60.a(this.E, 32.0f));
            return;
        }
        View view2 = this.itemView;
        view2.setPadding(view2.getPaddingLeft(), this.itemView.getPaddingTop(), this.itemView.getPaddingRight(), t60.a(this.E, 18.0f));
    }

    public void E(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-982289320")) {
            ipChange.ipc$dispatch("-982289320", new Object[]{this, projectDataHolder});
            return;
        }
        ProjectItemBean recommendItem = projectDataHolder.getRecommendItem();
        int recommendItemPosition = projectDataHolder.getRecommendItemPosition();
        if (recommendItem != null) {
            this.itemView.setTag(recommendItem);
            this.itemView.setOnClickListener(new View$OnClickListenerC2402a(recommendItemPosition, recommendItem));
            F(recommendItem, recommendItemPosition);
            k(recommendItem);
            G(recommendItemPosition, projectDataHolder.getRecommendListSize());
        }
    }
}
