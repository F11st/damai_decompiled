package cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTicketGuideDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuideBottomViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuideNoticeViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuidePreInfoViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuidePreLineViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuideTitleViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class TicketGuideAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ProjectTicketGuideDataHolder> a;
    private Activity b;

    public TicketGuideAdapter(Activity activity, List<ProjectTicketGuideDataHolder> list) {
        this.a = list;
        this.b = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1222127135") ? ((Integer) ipChange.ipc$dispatch("-1222127135", new Object[]{this})).intValue() : wh2.e(this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1688800248") ? ((Integer) ipChange.ipc$dispatch("-1688800248", new Object[]{this, Integer.valueOf(i)})).intValue() : this.a.get(i).mType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ProjectTicketGuideDataHolder projectTicketGuideDataHolder;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "784593528")) {
            ipChange.ipc$dispatch("784593528", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder == null || (projectTicketGuideDataHolder = this.a.get(i)) == null) {
        } else {
            int i2 = projectTicketGuideDataHolder.mType;
            if (i2 == 0) {
                ((TicketGuideTitleViewHolder) viewHolder).a(projectTicketGuideDataHolder.mTicketGuideTitle);
            } else if (i2 == 1) {
                ((TicketGuidePreLineViewHolder) viewHolder).d(projectTicketGuideDataHolder.tickGuidePreBean, i);
            } else if (i2 == 2) {
                ((TicketGuidePreInfoViewHolder) viewHolder).b(projectTicketGuideDataHolder.tickGuidePreBean);
            } else if (i2 == 3) {
                ((TicketGuideNoticeViewHolder) viewHolder).e(projectTicketGuideDataHolder.noticeBean, projectTicketGuideDataHolder.hideTopLine, projectTicketGuideDataHolder.hideBottomLine, projectTicketGuideDataHolder.projectId);
            } else if (i2 != 4) {
            } else {
                ((TicketGuideBottomViewHolder) viewHolder).a(projectTicketGuideDataHolder.mTicketGuideTitle);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1034600322")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1034600322", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return new TicketGuideBottomViewHolder(viewGroup.getContext());
                    }
                    return new TicketGuideNoticeViewHolder(viewGroup.getContext());
                }
                return new TicketGuidePreInfoViewHolder(this.b);
            }
            return new TicketGuidePreLineViewHolder(this.b);
        }
        return new TicketGuideTitleViewHolder(this.b);
    }
}
