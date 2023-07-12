package com.youku.live.dago.widgetlib.interactive.gift.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.manager.GiftDataManager;
import com.youku.live.dago.widgetlib.interactive.gift.view.GestureGiftWindow;
import com.youku.live.dago.widgetlib.interactive.utils.NumUtils;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GestureGiftItemAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private GestureGiftWindow mGestureGiftWindow;
    private List<GiftInfoBean> mGiftItems;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView giftCostLabel;
        TUrlImageView giftImageView;
        TextView giftNameLabel;
        TUrlImageView tagImageView;

        public ViewHolder(View view) {
            super(view);
            this.giftImageView = (TUrlImageView) view.findViewById(R.id.gift);
            this.tagImageView = (TUrlImageView) view.findViewById(R.id.superscript);
            this.giftNameLabel = (TextView) view.findViewById(R.id.gift_name);
            this.giftCostLabel = (TextView) view.findViewById(R.id.gift_cost);
        }
    }

    public GestureGiftItemAdapter(GestureGiftWindow gestureGiftWindow, List<GiftInfoBean> list) {
        this.mGestureGiftWindow = gestureGiftWindow;
        this.mGiftItems = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "155452022") ? ((Integer) ipChange.ipc$dispatch("155452022", new Object[]{this})).intValue() : this.mGiftItems.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529116543")) {
            ipChange.ipc$dispatch("-1529116543", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        GiftInfoBean giftInfoBean = this.mGiftItems.get(i);
        viewHolder.giftImageView.setImageUrl(giftInfoBean.icon);
        viewHolder.tagImageView.setImageUrl(giftInfoBean.tagIcon);
        viewHolder.giftNameLabel.setText(giftInfoBean.name);
        String fixCoinsShow = NumUtils.fixCoinsShow(Long.parseLong(giftInfoBean.coins));
        if (GiftDataManager.getInstance().getUsingLaifengCoin()) {
            viewHolder.giftCostLabel.setText(viewHolder.itemView.getResources().getString(R.string.dago_pgc_laifeng_send_gift_1, fixCoinsShow));
        } else {
            viewHolder.giftCostLabel.setText(viewHolder.itemView.getResources().getString(R.string.dago_pgc_send_gift_1, fixCoinsShow));
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.adapter.GestureGiftItemAdapter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "853136071")) {
                    ipChange2.ipc$dispatch("853136071", new Object[]{this, view});
                } else {
                    GestureGiftItemAdapter.this.mGestureGiftWindow.selectGift((GiftInfoBean) GestureGiftItemAdapter.this.mGiftItems.get(i));
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "580394389") ? (ViewHolder) ipChange.ipc$dispatch("580394389", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.C7942layout.dago_pgc_ykl_item_gift, (ViewGroup) null, false));
    }
}
