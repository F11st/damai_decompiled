package cn.damai.commonbusiness.servicenotice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.PagerAdapter;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ProjectTicketNoticeAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<TicketNoteList> b;

    public ProjectTicketNoticeAdapter(Context context, List<TicketNoteList> list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "361540565")) {
            ipChange.ipc$dispatch("361540565", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
        } else {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1093927340")) {
            return ((Integer) ipChange.ipc$dispatch("1093927340", new Object[]{this})).intValue();
        }
        List<TicketNoteList> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1171363415")) {
            return ipChange.ipc$dispatch("-1171363415", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.a).inflate(R$layout.layout_project_ticket_notice, (ViewGroup) null);
        IRecyclerView iRecyclerView = (IRecyclerView) inflate.findViewById(R$id.project_item_pop_notice_matter_irc);
        iRecyclerView.setLayoutManager(new LinearLayoutManager(this.a));
        iRecyclerView.setAdapter(new ProjectSupportServiceAdapter(this.a, this.b.get(i).getTicketNoteList()));
        iRecyclerView.setRefreshEnabled(false);
        iRecyclerView.setLoadMoreEnabled(false);
        iRecyclerView.setIsAutoToDefault(false);
        iRecyclerView.setOnLoadMoreListener(null);
        viewGroup.addView(inflate);
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-112884584") ? ((Boolean) ipChange.ipc$dispatch("-112884584", new Object[]{this, view, obj})).booleanValue() : view == obj;
    }
}
