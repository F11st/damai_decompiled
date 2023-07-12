package com.youku.live.dago.liveplayback.widget.plugins.quality;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.android.liveservice.bean.Quality;
import com.youku.live.dago.liveplayback.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class QualityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private LayoutInflater inflater;
    private Context mContext;
    private List<Quality> mList = new ArrayList();
    private int mSelection = -1;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    class MyViewHolder extends RecyclerView.ViewHolder {
        private View definition_list_footer;
        private ImageView item_adv_logo;
        private TextView item_dpi;
        private ImageView item_img;
        private TextView item_txt;

        public MyViewHolder(View view) {
            super(view);
            this.item_txt = (TextView) view.findViewById(R.id.title);
            this.item_img = (ImageView) view.findViewById(R.id.item_img);
            this.item_dpi = (TextView) view.findViewById(R.id.item_dpi);
            this.definition_list_footer = view.findViewById(R.id.definition_list_footer);
            this.item_adv_logo = (ImageView) view.findViewById(R.id.adv_quality_logo);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int i);
    }

    public QualityAdapter(Context context) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1214682831")) {
            return ((Integer) ipChange.ipc$dispatch("1214682831", new Object[]{this})).intValue();
        }
        List<Quality> list = this.mList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "883790326") ? ((Integer) ipChange.ipc$dispatch("883790326", new Object[]{this, Integer.valueOf(i)})).intValue() : super.getItemViewType(i);
    }

    public int getSelection() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-670749441") ? ((Integer) ipChange.ipc$dispatch("-670749441", new Object[]{this})).intValue() : this.mSelection;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1107181366")) {
            ipChange.ipc$dispatch("-1107181366", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder instanceof MyViewHolder) {
            MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
            List<Quality> list = this.mList;
            if (list == null || i >= list.size()) {
                return;
            }
            Quality quality = this.mList.get(i);
            myViewHolder.item_txt.setVisibility(0);
            myViewHolder.item_txt.setTextAppearance(this.mContext, R.C7938style.dago_player_list_item_textview_style);
            myViewHolder.item_img.setVisibility(8);
            if (quality.quality == 6) {
                myViewHolder.item_txt.setTextAppearance(this.mContext, R.C7938style.dago_vip_list_item_textview_style);
                myViewHolder.item_img.setImageResource(R.C7933drawable.quality_vip_icon_3x);
                myViewHolder.item_img.setVisibility(0);
            }
            myViewHolder.item_txt.setText(quality.selectionName);
            myViewHolder.definition_list_footer.setVisibility(8);
            myViewHolder.item_adv_logo.setVisibility(8);
            myViewHolder.itemView.setSelected(this.mSelection == i);
            myViewHolder.item_txt.getPaint().setFakeBoldText(this.mSelection == i);
            myViewHolder.itemView.setTag(Integer.valueOf(i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "361948883")) {
            ipChange.ipc$dispatch("361948883", new Object[]{this, view});
        } else if (this.mOnItemClickListener != null) {
            notifyItemChanged(this.mSelection);
            this.mOnItemClickListener.onItemClick(view, ((Integer) view.getTag()).intValue());
            int intValue = ((Integer) view.getTag()).intValue();
            this.mSelection = intValue;
            notifyItemChanged(intValue);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1513607788")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1513607788", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        MyViewHolder myViewHolder = new MyViewHolder(this.inflater.inflate(R.C7935layout.dago_language_quality_item, viewGroup, false));
        myViewHolder.itemView.setOnClickListener(this);
        return myViewHolder;
    }

    public void setData(List<Quality> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1775559315")) {
            ipChange.ipc$dispatch("-1775559315", new Object[]{this, list});
            return;
        }
        this.mList.clear();
        this.mList.addAll(list);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-130204358")) {
            ipChange.ipc$dispatch("-130204358", new Object[]{this, onRecyclerViewItemClickListener});
        } else {
            this.mOnItemClickListener = onRecyclerViewItemClickListener;
        }
    }

    public void setSelection(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1149809173")) {
            ipChange.ipc$dispatch("-1149809173", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mSelection = i;
        }
    }

    public void setStreamSizeData(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1564496716")) {
            ipChange.ipc$dispatch("1564496716", new Object[]{this, list});
        }
    }
}
