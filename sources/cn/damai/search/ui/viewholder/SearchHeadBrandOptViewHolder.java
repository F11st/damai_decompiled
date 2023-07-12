package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.brand.BrandOptimizationDO;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.b82;
import tb.cb2;
import tb.cs;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchHeadBrandOptViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private int[] a;
    private Context b;
    private String c;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "101281735")) {
                ipChange.ipc$dispatch("101281735", new Object[]{this, view});
            } else if (view.getTag() instanceof BrandOptimizationDO) {
                BrandOptimizationDO brandOptimizationDO = (BrandOptimizationDO) view.getTag();
                c.e().x(b82.C().o(SearchHeadBrandOptViewHolder.this.c, "", brandOptimizationDO.id, brandOptimizationDO.type, this.a));
                Bundle bundle = new Bundle();
                bundle.putString(IssueConstants.ProjectID, brandOptimizationDO.id);
                DMNav.from(SearchHeadBrandOptViewHolder.this.b).withExtras(bundle).toUri(cs.a());
            }
        }
    }

    public SearchHeadBrandOptViewHolder(Context context, View view) {
        super(view);
        this.b = context;
        this.a = new int[]{R$id.mine_brand_project_1, R$id.mine_brand_project_2, R$id.mine_brand_project_3};
        for (int i = 0; i < 3; i++) {
            View findViewById = this.itemView.findViewById(this.a[i]);
            if (findViewById != null) {
                findViewById.setOnClickListener(new a(i));
            }
        }
    }

    private void e(View view, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-577351283")) {
            ipChange.ipc$dispatch("-577351283", new Object[]{this, view, Integer.valueOf(i), str});
        } else {
            ((TextView) view.findViewById(i)).setText(str);
        }
    }

    public void c(View view, BrandOptimizationDO brandOptimizationDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-404605110")) {
            ipChange.ipc$dispatch("-404605110", new Object[]{this, view, brandOptimizationDO});
        } else if (brandOptimizationDO == null) {
        } else {
            e(view, R$id.brand_you_proj_memo, brandOptimizationDO.lable);
            e(view, R$id.brand_you_proj_title, brandOptimizationDO.itemName);
            brandOptimizationDO.updatePosterView((DMPosterView) view.findViewById(R$id.poster));
        }
    }

    public void d(@Nullable List<BrandOptimizationDO> list, String str) {
        BrandOptimizationDO brandOptimizationDO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1360816457")) {
            ipChange.ipc$dispatch("-1360816457", new Object[]{this, list, str});
        } else if (cb2.d(list)) {
            this.itemView.setVisibility(8);
        } else {
            this.itemView.setVisibility(0);
            this.c = str;
            for (int i = 0; i < 3; i++) {
                View findViewById = this.itemView.findViewById(this.a[i]);
                if (findViewById != null && list.get(i) != null && (brandOptimizationDO = list.get(i)) != null) {
                    findViewById.setTag(brandOptimizationDO);
                    c(findViewById, brandOptimizationDO);
                }
            }
        }
    }
}
