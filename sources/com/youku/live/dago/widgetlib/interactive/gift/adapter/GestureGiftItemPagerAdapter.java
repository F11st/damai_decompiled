package com.youku.live.dago.widgetlib.interactive.gift.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.manager.GiftDataManager;
import com.youku.live.dago.widgetlib.interactive.gift.view.GestureGiftWindow;
import com.youku.live.dago.widgetlib.interactive.utils.NumUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GestureGiftItemPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private GestureGiftWindow mGestureGiftWindow;
    private List<GiftInfoBean> mGiftInfoBeans;
    private GiftInfoBean mInitialSelectedBean;
    private int mRowCount;
    private int mInitialSelectedIndex = -1;
    private SelectionManager mSelectionManager = new SelectionManager();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class GiftItemViewHolder {
        View containerView;
        TextView giftCostLabel;
        ImageView giftImageView;
        TextView giftNameLabel;
        private SelectionManager mSelectionManager;
        ImageView tagImageView;

        public GiftItemViewHolder(@NonNull SelectionManager selectionManager, @NonNull View view) {
            this.containerView = view;
            this.mSelectionManager = selectionManager;
            selectionManager.registerSelectableView(view);
            this.giftImageView = (ImageView) view.findViewById(R.id.gift);
            this.tagImageView = (ImageView) view.findViewById(R.id.superscript);
            this.giftNameLabel = (TextView) view.findViewById(R.id.gift_name);
            this.giftCostLabel = (TextView) view.findViewById(R.id.gift_cost);
        }

        public void update(@NonNull final GestureGiftWindow gestureGiftWindow, final GiftInfoBean giftInfoBean) {
            if (giftInfoBean != null) {
                View view = this.containerView;
                view.setSelected(view.isSelected());
                this.containerView.setVisibility(0);
                if (!TextUtils.isEmpty(giftInfoBean.icon)) {
                    if (!giftInfoBean.icon.equals(this.giftImageView.getTag())) {
                        this.giftImageView.setImageDrawable(null);
                    }
                    this.giftImageView.setTag(giftInfoBean.icon);
                    DagoImageLoader.getInstance().showDefault(gestureGiftWindow.getContext(), giftInfoBean.icon, this.giftImageView);
                }
                if (!TextUtils.isEmpty(giftInfoBean.tagIcon)) {
                    if (!giftInfoBean.tagIcon.equals(this.tagImageView.getTag())) {
                        this.tagImageView.setImageDrawable(null);
                    }
                    this.tagImageView.setTag(giftInfoBean.tagIcon);
                    DagoImageLoader.getInstance().showDefault(gestureGiftWindow.getContext(), giftInfoBean.tagIcon, this.tagImageView);
                }
                this.giftNameLabel.setText(giftInfoBean.name);
                String fixCoinsShow = NumUtils.fixCoinsShow(Long.parseLong(giftInfoBean.coins));
                if (GiftDataManager.getInstance().getUsingLaifengCoin()) {
                    this.giftCostLabel.setText(this.containerView.getResources().getString(R.string.dago_pgc_laifeng_send_gift_1, fixCoinsShow));
                } else {
                    this.giftCostLabel.setText(this.containerView.getResources().getString(R.string.dago_pgc_send_gift_1, fixCoinsShow));
                }
                this.containerView.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.adapter.GestureGiftItemPagerAdapter.GiftItemViewHolder.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1390410652")) {
                            ipChange.ipc$dispatch("-1390410652", new Object[]{this, view2});
                            return;
                        }
                        GiftItemViewHolder.this.mSelectionManager.notifySelected(GiftItemViewHolder.this.containerView);
                        gestureGiftWindow.selectGift(giftInfoBean);
                    }
                });
                return;
            }
            this.containerView.setVisibility(4);
            this.giftImageView.setImageDrawable(null);
            this.tagImageView.setImageDrawable(null);
            this.giftNameLabel.setText("");
            this.giftCostLabel.setText("");
            this.containerView.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.adapter.GestureGiftItemPagerAdapter.GiftItemViewHolder.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "720879717")) {
                        ipChange.ipc$dispatch("720879717", new Object[]{this, view2});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class SelectionManager {
        private List<View> mSelectableViews;

        private SelectionManager() {
            this.mSelectableViews = new ArrayList();
        }

        void notifySelected(@NonNull View view) {
            Iterator<View> it = this.mSelectableViews.iterator();
            while (it.hasNext()) {
                View next = it.next();
                next.setSelected(next == view);
            }
        }

        void registerSelectableView(@NonNull View view) {
            this.mSelectableViews.add(view);
        }

        void unregisterSelectableView(@NonNull View view) {
            this.mSelectableViews.remove(view);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private static final int[] itemIdList = {R.id.item_00, R.id.item_01, R.id.item_02, R.id.item_03, R.id.item_04, R.id.item_05, R.id.item_06, R.id.item_07};
        private GiftItemViewHolder[] mItems;
        private int mRowCount;

        public ViewHolder(@NonNull SelectionManager selectionManager, @NonNull View view, int i) {
            super(view);
            this.mRowCount = i;
            this.mItems = new GiftItemViewHolder[i];
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            for (int i2 = 0; i2 < this.mItems.length; i2++) {
                int i3 = itemIdList[i2];
                if (i3 != 0) {
                    this.mItems[i2] = new GiftItemViewHolder(selectionManager, view.findViewById(i3));
                } else {
                    throw new IllegalAccessError("can not find correct item id");
                }
            }
        }

        void update(@NonNull GestureGiftWindow gestureGiftWindow, @NonNull List<GiftInfoBean> list, @NonNull int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1084751053")) {
                ipChange.ipc$dispatch("-1084751053", new Object[]{this, gestureGiftWindow, list, Integer.valueOf(i)});
                return;
            }
            int i2 = i * this.mRowCount;
            int size = list.size();
            int i3 = this.mRowCount;
            int size2 = size > i2 + i3 ? i3 + i2 : list.size();
            for (int i4 = i2; i4 < this.mRowCount + i2; i4++) {
                int i5 = i4 - i2;
                if (i4 < size2) {
                    this.mItems[i5].update(gestureGiftWindow, list.get(i4));
                } else {
                    this.mItems[i5].update(gestureGiftWindow, null);
                }
            }
        }
    }

    public GestureGiftItemPagerAdapter(@NonNull GestureGiftWindow gestureGiftWindow, @NonNull List<GiftInfoBean> list, @Nullable GiftInfoBean giftInfoBean) {
        this.mRowCount = 4;
        this.mGestureGiftWindow = gestureGiftWindow;
        updateGiftInfos(list, giftInfoBean);
        if (gestureGiftWindow.getResources().getConfiguration().orientation == 2) {
            this.mRowCount = 8;
        } else {
            this.mRowCount = 4;
        }
    }

    public int calculateRealPosition(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1968953949") ? ((Integer) ipChange.ipc$dispatch("1968953949", new Object[]{this, Integer.valueOf(i)})).intValue() : (int) (i / this.mRowCount);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330643791")) {
            return ((Integer) ipChange.ipc$dispatch("-1330643791", new Object[]{this})).intValue();
        }
        float size = this.mGiftInfoBeans.size() / this.mRowCount;
        int i = (int) size;
        return size > ((float) i) ? i + 1 : i;
    }

    public void updateGiftInfos(List<GiftInfoBean> list, GiftInfoBean giftInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471362058")) {
            ipChange.ipc$dispatch("-471362058", new Object[]{this, list, giftInfoBean});
            return;
        }
        this.mGiftInfoBeans = list;
        this.mInitialSelectedBean = giftInfoBean;
        if (giftInfoBean != null) {
            int indexOf = list.indexOf(giftInfoBean);
            this.mInitialSelectedIndex = indexOf;
            if (indexOf == -1) {
                Iterator<GiftInfoBean> it = this.mGiftInfoBeans.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GiftInfoBean next = it.next();
                    if (next.id.equals(this.mInitialSelectedBean.id)) {
                        this.mInitialSelectedIndex = this.mGiftInfoBeans.indexOf(next);
                        break;
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2061668063")) {
            ipChange.ipc$dispatch("2061668063", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        viewHolder.update(this.mGestureGiftWindow, this.mGiftInfoBeans, i);
        int i2 = this.mInitialSelectedIndex;
        if (i2 != -1) {
            int i3 = this.mRowCount;
            if (i2 < i * i3 || i2 >= (i + 1) * i3) {
                return;
            }
            this.mSelectionManager.notifySelected(viewHolder.mItems[this.mInitialSelectedIndex % this.mRowCount].containerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1156994889") ? (ViewHolder) ipChange.ipc$dispatch("-1156994889", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder(this.mSelectionManager, LayoutInflater.from(viewGroup.getContext()).inflate(R.C7942layout.dago_pgc_ykl_item_gesture_board, (ViewGroup) null, false), this.mRowCount);
    }
}
