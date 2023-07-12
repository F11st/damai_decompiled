package cn.damai.commonbusiness.notice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.notice.bean.ItemContent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class NoticeAdapter extends RecyclerView.Adapter<NoticeViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ArrayList<ItemContent> a;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NotNull NoticeViewHolder noticeViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "657656586")) {
            ipChange.ipc$dispatch("657656586", new Object[]{this, noticeViewHolder, Integer.valueOf(i)});
            return;
        }
        b41.i(noticeViewHolder, "holder");
        ArrayList<ItemContent> arrayList = this.a;
        noticeViewHolder.b(arrayList != null ? arrayList.get(i) : null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: b */
    public NoticeViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "281028460")) {
            return (NoticeViewHolder) ipChange.ipc$dispatch("281028460", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        b41.i(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.fragment_notice_detail_list_item, viewGroup, false);
        b41.h(inflate, "view");
        return new NoticeViewHolder(inflate);
    }

    public final void c(@NotNull ArrayList<ItemContent> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1861975178")) {
            ipChange.ipc$dispatch("1861975178", new Object[]{this, arrayList});
            return;
        }
        b41.i(arrayList, "list");
        ArrayList<ItemContent> arrayList2 = this.a;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        this.a = arrayList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1245598891")) {
            return ((Integer) ipChange.ipc$dispatch("1245598891", new Object[]{this})).intValue();
        }
        ArrayList<ItemContent> arrayList = this.a;
        if (arrayList == null) {
            return 0;
        }
        Integer valueOf = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
        b41.f(valueOf);
        return valueOf.intValue();
    }
}
