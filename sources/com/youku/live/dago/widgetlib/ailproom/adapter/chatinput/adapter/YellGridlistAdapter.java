package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailproom.manager.BaseInfoBean;
import com.youku.live.dago.widgetlib.ailproom.utils.DensityUtil;
import java.util.ArrayList;
import java.util.List;
import tb.ur1;
import tb.wr1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YellGridlistAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<BaseInfoBean> data;
    private int mColumnNum;
    private Context mContext;
    private int mItemHeight;
    private OnYellItemClickListener mListener;
    private boolean mShowGif;
    private List<Integer> mUserIndex;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnYellItemClickListener {
        void onItemClick(int i, BaseInfoBean baseInfoBean);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public View yellContainer;
        public ImageView yellImage;

        public ViewHolder(View view) {
            super(view);
            this.yellImage = (ImageView) view.findViewById(R.id.yell_image);
            this.yellContainer = view.findViewById(R.id.yell_icon_container);
        }
    }

    public YellGridlistAdapter(Context context) {
        this.data = new ArrayList();
        this.mColumnNum = 4;
        this.mItemHeight = DensityUtil.getScreenHeight() / this.mColumnNum;
        this.mShowGif = false;
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1111103611")) {
            return ((Integer) ipChange.ipc$dispatch("-1111103611", new Object[]{this})).intValue();
        }
        List<BaseInfoBean> list = this.data;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void setOnItemClickListener(OnYellItemClickListener onYellItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2019328578")) {
            ipChange.ipc$dispatch("2019328578", new Object[]{this, onYellItemClickListener});
        } else {
            this.mListener = onYellItemClickListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1195760161")) {
            ipChange.ipc$dispatch("-1195760161", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        List<BaseInfoBean> list = this.data;
        if (list == null || list.size() < i) {
            return;
        }
        final YellInfoBean yellInfoBean = (YellInfoBean) this.data.get(i);
        View view = viewHolder.yellContainer;
        int i2 = this.mItemHeight;
        view.setLayoutParams(new RelativeLayout.LayoutParams(i2, i2));
        if (yellInfoBean != null) {
            String str = yellInfoBean.url;
            if (!this.mShowGif) {
                str = str + "?x-oss-process=image/format,jpg";
            }
            viewHolder.yellImage.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.adapter.YellGridlistAdapter.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1927657942")) {
                        ipChange2.ipc$dispatch("1927657942", new Object[]{this, view2});
                    } else if (YellGridlistAdapter.this.mListener != null) {
                        YellGridlistAdapter.this.mListener.onItemClick(i, yellInfoBean);
                    }
                }
            });
            wr1 s = ur1.o().s(str);
            int i3 = R.drawable.dago_pgc_chat_expression_default_bg;
            s.H(i3).k(i3).y(viewHolder.yellImage);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2109960265") ? (ViewHolder) ipChange.ipc$dispatch("-2109960265", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dago_pgc_yell_item, (ViewGroup) null));
    }

    public YellGridlistAdapter(Context context, List<BaseInfoBean> list) {
        this.data = new ArrayList();
        this.mColumnNum = 4;
        this.mItemHeight = DensityUtil.getScreenHeight() / this.mColumnNum;
        this.mShowGif = false;
        this.data = list;
        this.mContext = context;
    }

    public YellGridlistAdapter(Context context, List<BaseInfoBean> list, int i, boolean z) {
        this.data = new ArrayList();
        this.mColumnNum = 4;
        this.mItemHeight = DensityUtil.getScreenHeight() / this.mColumnNum;
        this.mShowGif = false;
        this.data = list;
        this.mContext = context;
        this.mItemHeight = i;
        this.mShowGif = z;
    }
}
