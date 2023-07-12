package com.youku.live.dago.widgetlib.interactive.gift.view.multitarget;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTargetInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.config.GiftTheme;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.interactive.utils.ThemeUtils;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MultiTargetListAdapter extends RecyclerView.Adapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private int basePx;
    private Context mContext;
    private List<GiftTargetInfoBean> mDataList;
    private OnItemClickListener mListener;
    private final String OWNER = "房主";
    private final String HOST = "主持";
    private int bgRingColor = Color.parseColor("#b3000000");

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class AvaterViewHolder extends RecyclerView.ViewHolder {
        private ImageView mAvatar;
        private ImageView mOval;
        private TextView mSeat;
        private int themeColor;

        public AvaterViewHolder(View view) {
            super(view);
            this.mAvatar = (ImageView) view.findViewById(R.id.avatar);
            this.mOval = (ImageView) view.findViewById(R.id.oval);
            this.mSeat = (TextView) view.findViewById(R.id.seat);
        }

        public void updateTheme(Context context, int i) {
            this.themeColor = i;
            int dip2px = DensityUtil.dip2px(context, 1.0f);
            int i2 = dip2px * 2;
            int i3 = dip2px * 30;
            this.mOval.setImageDrawable(ThemeUtils.getOvalDrawable(0, i, i2, i3, i3));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnItemClickListener {
        void onItemClick(int i, View view);
    }

    public MultiTargetListAdapter(Context context, List<GiftTargetInfoBean> list) {
        this.basePx = 1;
        this.mContext = context;
        this.mDataList = list;
        this.basePx = DensityUtil.dip2px(context, 1.0f);
    }

    private String getUserRoles(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1060137437") ? (String) ipChange.ipc$dispatch("-1060137437", new Object[]{this, Integer.valueOf(i)}) : i == 4 ? "房主" : i == 256 ? "主持" : "";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1578727247") ? ((Integer) ipChange.ipc$dispatch("1578727247", new Object[]{this})).intValue() : this.mDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2096902774") ? ((Integer) ipChange.ipc$dispatch("2096902774", new Object[]{this, Integer.valueOf(i)})).intValue() : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1156091978")) {
            ipChange.ipc$dispatch("1156091978", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        final AvaterViewHolder avaterViewHolder = (AvaterViewHolder) viewHolder;
        GiftTargetInfoBean giftTargetInfoBean = this.mDataList.get(i);
        DagoImageLoader.getInstance().showCircle(this.mContext, giftTargetInfoBean.icon, avaterViewHolder.mAvatar);
        avaterViewHolder.mSeat.setText(giftTargetInfoBean.name);
        if (giftTargetInfoBean.isChecked) {
            avaterViewHolder.mOval.setVisibility(0);
            avaterViewHolder.mSeat.setBackground(ThemeUtils.getDrawable(this.bgRingColor, 0, 0, this.basePx * 7));
        } else {
            avaterViewHolder.mOval.setVisibility(8);
            avaterViewHolder.mSeat.setBackground(this.mContext.getResources().getDrawable(R.drawable.dago_pgc_ykl_gift_target_mic_item_unchecked_text_bg));
        }
        avaterViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListAdapter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1773898336")) {
                    ipChange2.ipc$dispatch("-1773898336", new Object[]{this, view});
                } else if (MultiTargetListAdapter.this.mListener != null) {
                    MultiTargetListAdapter.this.mListener.onItemClick(i, avaterViewHolder.itemView);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-386829588")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-386829588", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        AvaterViewHolder avaterViewHolder = new AvaterViewHolder(View.inflate(this.mContext, R.layout.dago_pgc_ykl_gift_target_mic_avatar_item, null));
        avaterViewHolder.updateTheme(this.mContext, this.bgRingColor);
        return avaterViewHolder;
    }

    public void resumeData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-425207157")) {
            ipChange.ipc$dispatch("-425207157", new Object[]{this});
            return;
        }
        List<GiftTargetInfoBean> list = this.mDataList;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = 0;
        while (i < this.mDataList.size()) {
            GiftTargetInfoBean giftTargetInfoBean = this.mDataList.get(i);
            giftTargetInfoBean.isChecked = i == 0 && getUserRoles(giftTargetInfoBean.role).equals("房主");
            i++;
        }
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-751285226")) {
            ipChange.ipc$dispatch("-751285226", new Object[]{this, onItemClickListener});
        } else {
            this.mListener = onItemClickListener;
        }
    }

    public void updateTheme(GiftTheme giftTheme) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1437314844")) {
            ipChange.ipc$dispatch("-1437314844", new Object[]{this, giftTheme});
            return;
        }
        this.bgRingColor = giftTheme.themeColor;
        List<GiftTargetInfoBean> list = this.mDataList;
        if (list == null || list.size() <= 0) {
            return;
        }
        notifyDataSetChanged();
    }
}
