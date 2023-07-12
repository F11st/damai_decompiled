package cn.damai.message.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.message.bean.MessageItem;
import cn.damai.message.ui.fragment.MessageFollowFragment;
import cn.damai.message.viewholder.MessageFollowViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MessageFollowAdapter extends RecyclerView.Adapter<MessageFollowViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<MessageItem> a = new ArrayList();
    private MessageFollowFragment b;

    public MessageFollowAdapter(MessageFollowFragment messageFollowFragment) {
        this.b = messageFollowFragment;
        LayoutInflater.from(messageFollowFragment.getActivity());
    }

    public void a(List<MessageItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "843557964")) {
            ipChange.ipc$dispatch("843557964", new Object[]{this, list});
            return;
        }
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1973796213")) {
            ipChange.ipc$dispatch("1973796213", new Object[]{this});
            return;
        }
        this.a.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(MessageFollowViewHolder messageFollowViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "370737543")) {
            ipChange.ipc$dispatch("370737543", new Object[]{this, messageFollowViewHolder, Integer.valueOf(i)});
        } else {
            messageFollowViewHolder.b(this.a.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public MessageFollowViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1991241969") ? (MessageFollowViewHolder) ipChange.ipc$dispatch("-1991241969", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new MessageFollowViewHolder(this.b, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1255520367") ? ((Integer) ipChange.ipc$dispatch("-1255520367", new Object[]{this})).intValue() : this.a.size();
    }

    public void setData(List<MessageItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1747402901")) {
            ipChange.ipc$dispatch("-1747402901", new Object[]{this, list});
            return;
        }
        this.a.addAll(list);
        notifyDataSetChanged();
    }
}
