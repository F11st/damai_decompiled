package com.youku.live.dago.widgetlib.interactive.gift.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTargetInfoBean;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TargetListAdapter extends RecyclerView.Adapter<TargetItemHolder> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private List<GiftTargetInfoBean> mData;
    private ItemListener mItemListener;
    private final int NONE_SELECTED = 0;
    private int mSelectedPosition = 0;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface ItemListener {
        void onTargetItemClick(GiftTargetInfoBean giftTargetInfoBean);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class TargetItemHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public View root;
        public ImageView targetAvatar;

        public TargetItemHolder(View view) {
            super(view);
            this.root = view;
            this.targetAvatar = (ImageView) view.findViewById(R.id.role_avatar_icon);
            this.name = (TextView) view.findViewById(R.id.role_name);
        }
    }

    public TargetListAdapter(Context context) {
        this.mContext = context;
    }

    public List<GiftTargetInfoBean> getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "676384489") ? (List) ipChange.ipc$dispatch("676384489", new Object[]{this}) : this.mData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-254497799")) {
            return ((Integer) ipChange.ipc$dispatch("-254497799", new Object[]{this})).intValue();
        }
        List<GiftTargetInfoBean> list = this.mData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public GiftTargetInfoBean getSelectedItem() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "194315382")) {
            return (GiftTargetInfoBean) ipChange.ipc$dispatch("194315382", new Object[]{this});
        }
        List<GiftTargetInfoBean> list = this.mData;
        if (list != null) {
            int size = list.size();
            int i = this.mSelectedPosition;
            if (size > i) {
                return this.mData.get(i);
            }
            return null;
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ItemListener itemListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "590850685")) {
            ipChange.ipc$dispatch("590850685", new Object[]{this, view});
            return;
        }
        int intValue = ((Integer) view.getTag()).intValue();
        GiftTargetInfoBean giftTargetInfoBean = null;
        if (this.mSelectedPosition == intValue) {
            return;
        }
        List<GiftTargetInfoBean> list = this.mData;
        if (list != null && intValue < list.size()) {
            giftTargetInfoBean = this.mData.get(intValue);
            this.mSelectedPosition = intValue;
        }
        notifyDataSetChanged();
        List<GiftTargetInfoBean> list2 = this.mData;
        if (list2 == null || intValue >= list2.size() || (itemListener = this.mItemListener) == null) {
            return;
        }
        itemListener.onTargetItemClick(giftTargetInfoBean);
    }

    public void setData(List<GiftTargetInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-760018429")) {
            ipChange.ipc$dispatch("-760018429", new Object[]{this, list});
            return;
        }
        this.mData = list;
        notifyDataSetChanged();
    }

    public void setListener(ItemListener itemListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1199803685")) {
            ipChange.ipc$dispatch("1199803685", new Object[]{this, itemListener});
        } else {
            this.mItemListener = itemListener;
        }
    }

    public void setSelectedPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2035777813")) {
            ipChange.ipc$dispatch("-2035777813", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mSelectedPosition = i;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TargetItemHolder targetItemHolder, int i) {
        GiftTargetInfoBean giftTargetInfoBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1796823298")) {
            ipChange.ipc$dispatch("-1796823298", new Object[]{this, targetItemHolder, Integer.valueOf(i)});
            return;
        }
        List<GiftTargetInfoBean> list = this.mData;
        if (list == null || list.size() <= i || (giftTargetInfoBean = this.mData.get(i)) == null) {
            return;
        }
        if (i == this.mSelectedPosition) {
            targetItemHolder.root.setBackgroundResource(R.C7941drawable.dago_pgc_ykl_target_item_bg_selected);
            targetItemHolder.name.setTextColor(Color.parseColor("#f9f9f9"));
        } else {
            targetItemHolder.root.setBackgroundResource(R.C7941drawable.dago_pgc_ykl_target_item_bg);
            targetItemHolder.name.setTextColor(Color.parseColor("#66f9f9f9"));
        }
        if (TextUtils.isEmpty(giftTargetInfoBean.icon)) {
            targetItemHolder.targetAvatar.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) targetItemHolder.name.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.leftMargin = DensityUtil.dip2px(this.mContext, 9.0f);
            }
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) targetItemHolder.name.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.leftMargin = DensityUtil.dip2px(this.mContext, 5.0f);
            }
            targetItemHolder.targetAvatar.setVisibility(0);
            DagoImageLoader.getInstance().showCircle(this.mContext, giftTargetInfoBean.icon, targetItemHolder.targetAvatar, R.C7941drawable.dago_pgc_ykl_gift_board_bg);
        }
        targetItemHolder.name.setText(giftTargetInfoBean.name);
        targetItemHolder.root.setTag(Integer.valueOf(i));
        targetItemHolder.root.setOnClickListener(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TargetItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2042615560") ? (TargetItemHolder) ipChange.ipc$dispatch("-2042615560", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new TargetItemHolder(LayoutInflater.from(this.mContext).inflate(R.C7942layout.dago_pgc_ykl_target_item, viewGroup, false));
    }

    public TargetListAdapter(Context context, List<GiftTargetInfoBean> list) {
        this.mContext = context;
        this.mData = list;
    }
}
