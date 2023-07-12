package cn.damai.trade.newtradeorder.ui.projectdetail.ui.adapter;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectMemberPrompt;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.viewholder.CreditExchangeHeaderViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.viewholder.CreditExchangeInfoViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class VIPCreditExchangeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ProjectMemberPrompt a;
    private boolean b;

    public final void a(@Nullable ProjectMemberPrompt projectMemberPrompt) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1609148597")) {
            ipChange.ipc$dispatch("1609148597", new Object[]{this, projectMemberPrompt});
            return;
        }
        this.a = projectMemberPrompt;
        if (TextUtils.isEmpty(projectMemberPrompt != null ? projectMemberPrompt.getPostImgUrl() : null)) {
            if (TextUtils.isEmpty(projectMemberPrompt != null ? projectMemberPrompt.getProfitName() : null)) {
                z = false;
            }
        }
        this.b = z;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<ProjectMemberPrompt.ProfitDetailContent> contents;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-618523162")) {
            return ((Integer) ipChange.ipc$dispatch("-618523162", new Object[]{this})).intValue();
        }
        boolean z = this.b;
        ProjectMemberPrompt projectMemberPrompt = this.a;
        if (projectMemberPrompt != null && (contents = projectMemberPrompt.getContents()) != null) {
            i = contents.size();
        }
        return (z ? 1 : 0) + i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-254431859")) {
            return ((Integer) ipChange.ipc$dispatch("-254431859", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        super.getItemViewType(i);
        return (i == 0 && this.b) ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        ArrayList<ProjectMemberPrompt.ProfitDetailContent> contents;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-425580717")) {
            ipChange.ipc$dispatch("-425580717", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        b41.i(viewHolder, "holder");
        ProjectMemberPrompt.ProfitDetailContent profitDetailContent = null;
        profitDetailContent = null;
        if (viewHolder instanceof CreditExchangeHeaderViewHolder) {
            CreditExchangeHeaderViewHolder creditExchangeHeaderViewHolder = (CreditExchangeHeaderViewHolder) viewHolder;
            ProjectMemberPrompt projectMemberPrompt = this.a;
            String postImgUrl = projectMemberPrompt != null ? projectMemberPrompt.getPostImgUrl() : null;
            ProjectMemberPrompt projectMemberPrompt2 = this.a;
            String profitName = projectMemberPrompt2 != null ? projectMemberPrompt2.getProfitName() : null;
            ProjectMemberPrompt projectMemberPrompt3 = this.a;
            creditExchangeHeaderViewHolder.d(postImgUrl, profitName, projectMemberPrompt3 != null ? projectMemberPrompt3.getProfitDesc() : null);
        } else if (viewHolder instanceof CreditExchangeInfoViewHolder) {
            CreditExchangeInfoViewHolder creditExchangeInfoViewHolder = (CreditExchangeInfoViewHolder) viewHolder;
            ProjectMemberPrompt projectMemberPrompt4 = this.a;
            if (projectMemberPrompt4 != null && (contents = projectMemberPrompt4.getContents()) != null) {
                if (this.b) {
                    i--;
                }
                profitDetailContent = contents.get(i);
            }
            creditExchangeInfoViewHolder.d(profitDetailContent);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1174165501")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1174165501", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        b41.i(viewGroup, "parent");
        if (i == 1) {
            return CreditExchangeHeaderViewHolder.Companion.a(viewGroup);
        }
        return CreditExchangeInfoViewHolder.Companion.a(viewGroup);
    }
}
