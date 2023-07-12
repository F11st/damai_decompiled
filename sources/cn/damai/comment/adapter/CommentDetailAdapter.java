package cn.damai.comment.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.holder.CommentEmptyViewHolder;
import cn.damai.comment.holder.CommentTitleViewHolder;
import cn.damai.comment.view.DMCommentTitleView;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.evaluate.ui.item.EvaluateItemDataBinder;
import cn.damai.evaluate.ui.item.EvaluateItemViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.al;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class CommentDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<al> a;
    private DamaiBaseActivity b;
    private EvaluateItemDataBinder c;

    public CommentDetailAdapter(DamaiBaseActivity damaiBaseActivity) {
        this.b = damaiBaseActivity;
        EvaluateItemDataBinder evaluateItemDataBinder = new EvaluateItemDataBinder(damaiBaseActivity);
        this.c = evaluateItemDataBinder;
        evaluateItemDataBinder.q(1);
    }

    private void b(CommentTitleViewHolder commentTitleViewHolder, al alVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1104647247")) {
            ipChange.ipc$dispatch("1104647247", new Object[]{this, commentTitleViewHolder, alVar});
            return;
        }
        String b = alVar.b();
        View view = commentTitleViewHolder.itemView;
        if (view instanceof DMCommentTitleView) {
            ((DMCommentTitleView) view).setData(b);
        }
    }

    public void a(List<al> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "771404240")) {
            ipChange.ipc$dispatch("771404240", new Object[]{this, list});
            return;
        }
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    public void c(List<al> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2055996049")) {
            ipChange.ipc$dispatch("2055996049", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    public void d(EvaluateItemDataBinder.EvaluateItemUTReportListener evaluateItemUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "638880428")) {
            ipChange.ipc$dispatch("638880428", new Object[]{this, evaluateItemUTReportListener});
        } else {
            this.c.r(evaluateItemUTReportListener);
        }
    }

    public void e(EvaluateItemDataBinder.EvaluateItemOtherListener evaluateItemOtherListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "950021597")) {
            ipChange.ipc$dispatch("950021597", new Object[]{this, evaluateItemOtherListener});
        } else {
            this.c.s(evaluateItemOtherListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-103621644") ? ((Integer) ipChange.ipc$dispatch("-103621644", new Object[]{this})).intValue() : wh2.e(this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "511229083") ? ((Integer) ipChange.ipc$dispatch("511229083", new Object[]{this, Integer.valueOf(i)})).intValue() : this.a.get(i).j();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "494059653")) {
            ipChange.ipc$dispatch("494059653", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        al alVar = this.a.get(i);
        if (alVar == null) {
            return;
        }
        int j = alVar.j();
        if (j == 1) {
            b((CommentTitleViewHolder) viewHolder, alVar);
        } else if (j == 2 || j == 3) {
            this.c.i((EvaluateItemViewHolder) viewHolder, alVar, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206793489")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("206793489", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i != 1) {
            if (i == 2 || i == 3) {
                return new EvaluateItemViewHolder(this.b);
            }
            if (i != 4) {
                return null;
            }
            return new CommentEmptyViewHolder(this.b);
        }
        return new CommentTitleViewHolder(this.b);
    }
}
