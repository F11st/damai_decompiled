package com.youku.live.dago.widgetlib.interactive.gift.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftNumTemplateAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<GiftNumBean> data;
    private Context mContext;
    private OnItemClickListener mListener;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnItemClickListener {
        void onItemClick(int i, GiftNumBean giftNumBean);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public View clickView;
        public View dividerLine;
        public View otherCountLayout;
        public TextView tvCount;
        public TextView tvName;

        public ViewHolder(View view) {
            super(view);
            this.tvCount = (TextView) view.findViewById(R.id.num_count);
            this.tvName = (TextView) view.findViewById(R.id.num_name);
            this.clickView = view.findViewById(R.id.click_pannel);
            this.dividerLine = view.findViewById(R.id.divider_line);
            this.otherCountLayout = view.findViewById(R.id.other_count_icon);
        }
    }

    public GiftNumTemplateAdapter(Context context) {
        this.data = new ArrayList();
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1975967502")) {
            return ((Integer) ipChange.ipc$dispatch("-1975967502", new Object[]{this})).intValue();
        }
        List<GiftNumBean> list = this.data;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void setData(List<GiftNumBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "763883370")) {
            ipChange.ipc$dispatch("763883370", new Object[]{this, list});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-num", "gift num notify data change");
        this.data = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "788727062")) {
            ipChange.ipc$dispatch("788727062", new Object[]{this, onItemClickListener});
        } else {
            this.mListener = onItemClickListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86461833")) {
            ipChange.ipc$dispatch("86461833", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        List<GiftNumBean> list = this.data;
        if (list == null || list.size() < i) {
            return;
        }
        final GiftNumBean giftNumBean = this.data.get(i);
        if (giftNumBean != null) {
            TextView textView = viewHolder.tvCount;
            textView.setText(giftNumBean.num + "");
            viewHolder.tvName.setText(giftNumBean.name);
            viewHolder.clickView.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.adapter.GiftNumTemplateAdapter.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "605714755")) {
                        ipChange2.ipc$dispatch("605714755", new Object[]{this, view});
                    } else if (GiftNumTemplateAdapter.this.mListener != null) {
                        GiftNumTemplateAdapter.this.mListener.onItemClick(i, giftNumBean);
                    }
                }
            });
            if (giftNumBean.type == 1) {
                viewHolder.otherCountLayout.setVisibility(0);
                viewHolder.tvCount.setVisibility(8);
            } else {
                viewHolder.otherCountLayout.setVisibility(8);
                viewHolder.tvCount.setVisibility(0);
            }
        }
        if (i == 0) {
            viewHolder.dividerLine.setVisibility(0);
        } else {
            viewHolder.dividerLine.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1441111155") ? (ViewHolder) ipChange.ipc$dispatch("-1441111155", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.C7942layout.dago_pgc_ykl_gift_num_item, (ViewGroup) null));
    }

    public GiftNumTemplateAdapter(Context context, List<GiftNumBean> list) {
        this.data = new ArrayList();
        this.data = list;
        this.mContext = context;
    }
}
