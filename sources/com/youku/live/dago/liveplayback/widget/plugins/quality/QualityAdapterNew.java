package com.youku.live.dago.liveplayback.widget.plugins.quality;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.android.liveservice.bean.BizSwitch;
import com.youku.android.liveservice.bean.Quality;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.UIUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class QualityAdapterNew extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DOLBY = 110;
    private static final int HBR = 210;
    private static final String KEY_HIGH_QUALITY_PREF = "0";
    private static final String KEY_SAVE_TRAFFIC_PREF = "1";
    private static final int QUALITY_AUTO = 111;
    private static final String TAG = "QualityAdapter";
    private LayoutInflater inflater;
    private Typeface mAkrobatTypeface;
    private Context mContext;
    private List<Quality> mVideoQualityInfoList = new ArrayList();
    private int mSelection = -1;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    private OnDolbyInfoClickListener mOnDolbyInfoClickListener = null;
    private int mScreenWidth = -1;
    private boolean mIsHorizonFull = true;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class CommonViewHolder extends RecyclerView.ViewHolder {
        public View infoIconView;
        public TextView markView;
        public View qualityInfoContent;
        public TextView qualityTitleView;
        public TextView subTitleView;
        public View titleContentView;

        public CommonViewHolder(View view) {
            super(view);
            this.titleContentView = view.findViewById(R.id.title_content);
            this.qualityInfoContent = view.findViewById(R.id.quality_info_content);
            this.qualityTitleView = (TextView) view.findViewById(R.id.quality_title);
            this.subTitleView = (TextView) view.findViewById(R.id.quality_sub_title);
            this.markView = (TextView) view.findViewById(R.id.mark_tv);
            this.infoIconView = view.findViewById(R.id.quality_info);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnDolbyInfoClickListener {
        void onDolbyInfoClick(View view);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnRecyclerViewItemClickListener {
        void onAutoQualityInfoClick(View view);

        void onCloseAreaClicked();

        void onItemClick(View view, int i);

        void onQualityInfoClick(View view);
    }

    public QualityAdapterNew(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
    }

    private void initScreenWidth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1260203408")) {
            ipChange.ipc$dispatch("-1260203408", new Object[]{this});
        } else if (this.mScreenWidth < 0) {
            this.mScreenWidth = UIUtils.getScreenWidth((Activity) this.mContext);
        }
    }

    private void initTypeface() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-17577559")) {
            ipChange.ipc$dispatch("-17577559", new Object[]{this});
            return;
        }
        Context context = this.mContext;
        if (context != null && this.mAkrobatTypeface == null) {
            try {
                this.mAkrobatTypeface = Typeface.createFromAsset(context.getAssets(), "Akrobat-Bold.ttf");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Quality> getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1219453421") ? (List) ipChange.ipc$dispatch("1219453421", new Object[]{this}) : this.mVideoQualityInfoList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278899197")) {
            return ((Integer) ipChange.ipc$dispatch("1278899197", new Object[]{this})).intValue();
        }
        List<Quality> list = this.mVideoQualityInfoList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int getSelection() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-606533075") ? ((Integer) ipChange.ipc$dispatch("-606533075", new Object[]{this})).intValue() : this.mSelection;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        boolean z;
        boolean z2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-712093988")) {
            ipChange.ipc$dispatch("-712093988", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder instanceof CommonViewHolder) {
            CommonViewHolder commonViewHolder = (CommonViewHolder) viewHolder;
            commonViewHolder.infoIconView.setTag(Integer.valueOf(i));
            commonViewHolder.titleContentView.setSelected(this.mSelection == i);
            commonViewHolder.titleContentView.setTag(Integer.valueOf(i));
            commonViewHolder.qualityInfoContent.setTag(Integer.valueOf(i));
            List<Quality> list = this.mVideoQualityInfoList;
            if (list == null || i >= list.size()) {
                z = false;
                z2 = false;
            } else {
                Quality quality = this.mVideoQualityInfoList.get(i);
                String str = quality.bitStream;
                String str2 = quality.selectionName;
                int i2 = this.mVideoQualityInfoList.get(i).quality;
                commonViewHolder.qualityTitleView.setText(str2);
                commonViewHolder.subTitleView.setVisibility(8);
                commonViewHolder.markView.setVisibility(8);
                commonViewHolder.infoIconView.setVisibility(8);
                if (quality.hbr == 1) {
                    commonViewHolder.infoIconView.setVisibility(0);
                    commonViewHolder.infoIconView.setTag(Integer.valueOf(i));
                    commonViewHolder.subTitleView.setVisibility(0);
                    commonViewHolder.subTitleView.setText("身临其境 视觉盛宴");
                }
                if (quality.bizSwitch.fps50 == 1) {
                    commonViewHolder.subTitleView.setVisibility(0);
                    commonViewHolder.subTitleView.setText("60帧");
                }
                if (quality.bizSwitch.abr == 1) {
                    commonViewHolder.subTitleView.setVisibility(0);
                    commonViewHolder.subTitleView.setText("智能选择清晰度");
                }
                BizSwitch bizSwitch = quality.bizSwitch;
                if (bizSwitch.memberQuality == 1) {
                    if (bizSwitch.fps50 == 1) {
                        commonViewHolder.markView.setText("VIP · 60帧");
                    } else {
                        commonViewHolder.markView.setText("VIP");
                    }
                    commonViewHolder.markView.setVisibility(0);
                    z = true;
                } else {
                    z = false;
                }
                z2 = true;
            }
            if (z) {
                commonViewHolder.qualityTitleView.setTextAppearance(this.mContext, R.C7938style.dago_vip_list_item_title_style);
                commonViewHolder.subTitleView.setTextAppearance(this.mContext, R.C7938style.dago_vip_list_item_subtitle_style);
            } else {
                commonViewHolder.qualityTitleView.setTextAppearance(this.mContext, R.C7938style.dago_normal_list_item_title_style);
                commonViewHolder.subTitleView.setTextAppearance(this.mContext, R.C7938style.dago_normal_list_item_subtitle_style);
            }
            commonViewHolder.titleContentView.setSelected(this.mSelection == i);
            if (z2) {
                commonViewHolder.qualityTitleView.setTextSize(1, 17.0f);
                commonViewHolder.qualityTitleView.setTypeface(null);
                return;
            }
            commonViewHolder.qualityTitleView.setTextSize(1, 20.0f);
            if (this.mAkrobatTypeface == null) {
                initTypeface();
            }
            Typeface typeface = this.mAkrobatTypeface;
            if (typeface != null) {
                commonViewHolder.qualityTitleView.setTypeface(typeface);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-62055551")) {
            ipChange.ipc$dispatch("-62055551", new Object[]{this, view});
        } else if (view.getId() == R.id.quality_info) {
            Integer num = (Integer) view.getTag();
            if (num != null) {
                if (num.intValue() == 110) {
                    OnDolbyInfoClickListener onDolbyInfoClickListener = this.mOnDolbyInfoClickListener;
                    if (onDolbyInfoClickListener != null) {
                        onDolbyInfoClickListener.onDolbyInfoClick(view);
                    }
                } else if (num.intValue() == 111) {
                    OnRecyclerViewItemClickListener onRecyclerViewItemClickListener = this.mOnItemClickListener;
                    if (onRecyclerViewItemClickListener != null) {
                        onRecyclerViewItemClickListener.onAutoQualityInfoClick(view);
                    }
                } else {
                    OnRecyclerViewItemClickListener onRecyclerViewItemClickListener2 = this.mOnItemClickListener;
                    if (onRecyclerViewItemClickListener2 != null) {
                        onRecyclerViewItemClickListener2.onQualityInfoClick(view);
                    }
                }
            }
        } else if (((Integer) view.getTag()) == null || this.mOnItemClickListener == null) {
        } else {
            notifyItemChanged(this.mSelection);
            this.mOnItemClickListener.onItemClick(view, ((Integer) view.getTag()).intValue());
            this.mOnItemClickListener.onCloseAreaClicked();
            int intValue = ((Integer) view.getTag()).intValue();
            this.mSelection = intValue;
            notifyItemChanged(intValue);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1166990490")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1166990490", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        CommonViewHolder commonViewHolder = new CommonViewHolder(this.inflater.inflate(R.C7935layout.dago_quality_item_ly, viewGroup, false));
        commonViewHolder.titleContentView.setOnClickListener(this);
        commonViewHolder.qualityInfoContent.setOnClickListener(this);
        commonViewHolder.infoIconView.setOnClickListener(this);
        ViewGroup.LayoutParams layoutParams = commonViewHolder.qualityInfoContent.getLayoutParams();
        if (layoutParams != null) {
            if (this.mIsHorizonFull) {
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams).width = UIUtils.dp2px(135.0f);
                } else if (layoutParams instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams).width = UIUtils.dp2px(135.0f);
                }
            } else {
                initScreenWidth();
                int i2 = this.mScreenWidth;
                if (i2 > 0) {
                    int dp2px = (int) ((i2 - UIUtils.dp2px(68.0f)) * 0.53d);
                    if (layoutParams instanceof FrameLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) layoutParams).width = dp2px;
                    } else if (layoutParams instanceof LinearLayout.LayoutParams) {
                        ((LinearLayout.LayoutParams) layoutParams).width = dp2px;
                    }
                }
            }
        }
        return commonViewHolder;
    }

    public void setData(List<Quality> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1104750721")) {
            ipChange.ipc$dispatch("-1104750721", new Object[]{this, list});
            return;
        }
        this.mVideoQualityInfoList.clear();
        this.mVideoQualityInfoList.addAll(list);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1372020324")) {
            ipChange.ipc$dispatch("1372020324", new Object[]{this, onRecyclerViewItemClickListener});
        } else {
            this.mOnItemClickListener = onRecyclerViewItemClickListener;
        }
    }

    public void setSelection(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "840898173")) {
            ipChange.ipc$dispatch("840898173", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mSelection = i;
        }
    }

    public void setmOnDolbyInfoClickListener(OnDolbyInfoClickListener onDolbyInfoClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1432571751")) {
            ipChange.ipc$dispatch("-1432571751", new Object[]{this, onDolbyInfoClickListener});
        } else {
            this.mOnDolbyInfoClickListener = onDolbyInfoClickListener;
        }
    }
}
