package cn.damai.message.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.message.bean.MessageItem;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MessageAdapter extends BaseAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<MessageItem> data;
    private Context mContext;
    private LayoutInflater mInflater;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    class a {
        TextView a;
        TextView b;
        TextView c;
        RoundImageView d;

        a(MessageAdapter messageAdapter) {
        }
    }

    public MessageAdapter(Context context, List<MessageItem> list) {
        this.mContext = context;
        this.data = list;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1079993649") ? ((Integer) ipChange.ipc$dispatch("-1079993649", new Object[]{this})).intValue() : this.data.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1598458") ? ((Long) ipChange.ipc$dispatch("-1598458", new Object[]{this, Integer.valueOf(i)})).longValue() : i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2146099062")) {
            return (View) ipChange.ipc$dispatch("-2146099062", new Object[]{this, Integer.valueOf(i), view, viewGroup});
        }
        if (view == null) {
            aVar = new a(this);
            view2 = this.mInflater.inflate(R$layout.item_msg_content_layout, (ViewGroup) null);
            aVar.d = (RoundImageView) view2.findViewById(R$id.iv_msg_icon);
            aVar.a = (TextView) view2.findViewById(R$id.tv_msg_title);
            aVar.b = (TextView) view2.findViewById(R$id.tv_msg_time);
            aVar.c = (TextView) view2.findViewById(R$id.tv_msg_content);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        MessageItem messageItem = this.data.get(i);
        String gmtCreate = messageItem.getGmtCreate();
        String str = "";
        if (TextUtils.isEmpty(gmtCreate)) {
            aVar.b.setText("");
        } else {
            aVar.b.setText(gmtCreate);
        }
        aVar.a.setText(messageItem.getTitle());
        aVar.c.setText(messageItem.getMsgBody());
        if (messageItem.getActionType() != 3) {
            DMImageCreator c = cn.damai.common.image.a.b().c(messageItem.getImageUrl());
            int i2 = R$drawable.dm_default_logo;
            c.i(i2).c(i2).g(aVar.d);
        } else if (!TextUtils.isEmpty(messageItem.getActionValue())) {
            try {
                str = String.format("https://pimg.dmcdn.cn/perform/project/%s/%s_n.jpg", Integer.valueOf(Integer.valueOf(messageItem.getActionValue()).intValue() / 100), messageItem.getActionValue());
            } catch (NumberFormatException unused) {
            }
            DMImageCreator c2 = cn.damai.common.image.a.b().c(str);
            int i3 = R$drawable.dm_default_logo;
            c2.i(i3).c(i3).g(aVar.d);
        }
        return view2;
    }

    @Override // android.widget.Adapter
    public MessageItem getItem(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-374402582") ? (MessageItem) ipChange.ipc$dispatch("-374402582", new Object[]{this, Integer.valueOf(i)}) : this.data.get(i);
    }
}
