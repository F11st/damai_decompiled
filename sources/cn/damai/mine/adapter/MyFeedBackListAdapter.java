package cn.damai.mine.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.bean.MyFeedBack;
import cn.damai.mine.bean.MyFeedBackDO;
import cn.damai.mine.bean.MyFeedReplyDO;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MyFeedBackListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<MyFeedBack> a;
    private View.OnClickListener b;
    private LayoutInflater c;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class MyFeedBackViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private TextView b;
        private LinearLayout c;
        private TextView d;
        private TextView e;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.mine.adapter.MyFeedBackListAdapter$MyFeedBackViewHolder$a */
        /* loaded from: classes15.dex */
        public class View$OnClickListenerC1428a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC1428a(MyFeedBackListAdapter myFeedBackListAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1341472922")) {
                    ipChange.ipc$dispatch("1341472922", new Object[]{this, view});
                } else if (MyFeedBackListAdapter.this.b != null) {
                    MyFeedBackListAdapter.this.b.onClick(view);
                }
            }
        }

        public MyFeedBackViewHolder(LayoutInflater layoutInflater) {
            super(layoutInflater.inflate(R$layout.feed_back_my_list_item, (ViewGroup) null));
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.a = (TextView) this.itemView.findViewById(R$id.tv_desc);
            this.b = (TextView) this.itemView.findViewById(R$id.tv_time);
            this.c = (LinearLayout) this.itemView.findViewById(R$id.ll_feed_state);
            this.d = (TextView) this.itemView.findViewById(R$id.tv_feed_state);
            this.e = (TextView) this.itemView.findViewById(R$id.tv_feed_state_desc);
            this.itemView.setOnClickListener(new View$OnClickListenerC1428a(MyFeedBackListAdapter.this));
        }

        public void a(MyFeedBack myFeedBack, int i) {
            MyFeedBackDO myFeedBackDO;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1911781072")) {
                ipChange.ipc$dispatch("1911781072", new Object[]{this, myFeedBack, Integer.valueOf(i)});
            } else if (myFeedBack == null || (myFeedBackDO = myFeedBack.feedbackDO) == null) {
            } else {
                myFeedBackDO.index = i;
                this.itemView.setTag(myFeedBackDO);
                if (TextUtils.isEmpty(myFeedBackDO.bizIdentifiers)) {
                    this.a.setText(myFeedBackDO.content);
                } else {
                    TextView textView = this.a;
                    textView.setText(myFeedBackDO.bizIdentifiers + "：" + myFeedBackDO.content);
                }
                TextView textView2 = this.b;
                textView2.setText(myFeedBackDO.gmtCreate + " " + myFeedBackDO.tips);
                MyFeedReplyDO fisrFeedReplyDO = myFeedBack.getFisrFeedReplyDO();
                if (fisrFeedReplyDO == null) {
                    this.c.setVisibility(8);
                    return;
                }
                this.c.setVisibility(0);
                this.d.setText(fisrFeedReplyDO.replyUserNick);
                if (TextUtils.isEmpty(fisrFeedReplyDO.replyContent)) {
                    this.e.setVisibility(8);
                    return;
                }
                this.e.setText(fisrFeedReplyDO.replyContent);
                this.e.setVisibility(0);
            }
        }
    }

    public MyFeedBackListAdapter(Context context, List<MyFeedBack> list, View.OnClickListener onClickListener) {
        this.a = list;
        this.b = onClickListener;
        this.c = LayoutInflater.from(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-32849591") ? ((Integer) ipChange.ipc$dispatch("-32849591", new Object[]{this})).intValue() : this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358282224")) {
            ipChange.ipc$dispatch("-1358282224", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        MyFeedBack myFeedBack = this.a.get(i);
        if (myFeedBack == null) {
            return;
        }
        ((MyFeedBackViewHolder) viewHolder).a(myFeedBack, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "645868518") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("645868518", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new MyFeedBackViewHolder(this.c);
    }
}
