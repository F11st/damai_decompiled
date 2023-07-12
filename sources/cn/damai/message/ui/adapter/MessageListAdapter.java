package cn.damai.message.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.message.bean.MessageGroupItem;
import cn.damai.message.viewholder.MessageModelViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MessageListAdapter extends RecyclerView.Adapter<MessageModelViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<MessageGroupItem> a;
    private Context b;

    public MessageListAdapter(Context context, List<MessageGroupItem> list) {
        this.b = context;
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(MessageModelViewHolder messageModelViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2141790744")) {
            ipChange.ipc$dispatch("2141790744", new Object[]{this, messageModelViewHolder, Integer.valueOf(i)});
            return;
        }
        MessageGroupItem messageGroupItem = this.a.get(i);
        if (messageGroupItem != null) {
            messageModelViewHolder.b(messageGroupItem, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public MessageModelViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-355259810") ? (MessageModelViewHolder) ipChange.ipc$dispatch("-355259810", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new MessageModelViewHolder(this.b, viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2054630780") ? ((Integer) ipChange.ipc$dispatch("-2054630780", new Object[]{this})).intValue() : this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1513155371") ? ((Integer) ipChange.ipc$dispatch("1513155371", new Object[]{this, Integer.valueOf(i)})).intValue() : (int) this.a.get(i).getGroupId();
    }
}
