package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListRecyclerViewAdapter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPChatListRecyclerViewAdapter extends BaseChatListRecyclerViewAdapter<AILPChatBean, ViewHolder> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private Map<String, Object> mShareMap;
    private SpannableStringBuilder shareString;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout mChatLayout;
        public TextView mUserComment;
        public ImageView mUserIcon;
        public ImageView mUserInputIcon;
        public TextView mUserName;
        public ImageView mUserVipIcon;

        public ViewHolder(View view) {
            super(view);
        }
    }

    public AILPChatListRecyclerViewAdapter(Context context) {
        this.mContext = context;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("分享了直播，邀好友来围观\n立即分享，戳这里   ");
        this.shareString = spannableStringBuilder;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-8667649), 12, 22, 33);
        this.shareString.setSpan(new ImageSpan(context, R.C7941drawable.dago_pgc_ailp_live_share), 22, 23, 33);
        HashMap hashMap = new HashMap(2);
        this.mShareMap = hashMap;
        hashMap.put("ilpType", "share");
    }

    private void bindData(ViewHolder viewHolder, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "654168094")) {
            ipChange.ipc$dispatch("654168094", new Object[]{this, viewHolder, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        AILPChatBean aILPChatBean = getLiveCommentItem().get(i);
        if (i2 == 1) {
            viewHolder.mUserComment.setText(aILPChatBean.getData());
            viewHolder.mUserComment.setTextColor(aILPChatBean.getTextColor());
            viewHolder.mUserComment.setTag(1);
        } else if (i2 == 2) {
            this.shareString.setSpan(new ForegroundColorSpan(aILPChatBean.getTextColor()), 0, 12, 33);
            viewHolder.mUserComment.setText(this.shareString);
            viewHolder.mUserComment.setTag(2);
            viewHolder.mUserComment.setOnClickListener(this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1132598345") ? ((Integer) ipChange.ipc$dispatch("1132598345", new Object[]{this, Integer.valueOf(i)})).intValue() : getLiveCommentItem().get(i).getCellType();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340974950")) {
            ipChange.ipc$dispatch("340974950", new Object[]{this, view});
        } else if (view.getId() != R.id.tv_portrait_comment_content || view.getTag() == null) {
        } else {
            int intValue = ((Integer) view.getTag()).intValue();
            OnCellClickListener onCellClickListener = this.mCellClickListener;
            if (onCellClickListener == null || intValue != 2) {
                return;
            }
            onCellClickListener.onCellClick("onCellClicked", this.mShareMap);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "507884095")) {
            ipChange.ipc$dispatch("507884095", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        try {
            synchronized (this) {
                AILPChatBean aILPChatBean = getLiveCommentItem().get(i);
                bindData(viewHolder, i, getItemViewType(i));
                Drawable background = viewHolder.mChatLayout.getBackground();
                if (aILPChatBean.getBgColor() != -1 && (background instanceof GradientDrawable)) {
                    ((GradientDrawable) background).setColor(aILPChatBean.getBgColor());
                    background.setAlpha(aILPChatBean.getBgAlpha());
                } else {
                    viewHolder.mChatLayout.getBackground().setAlpha(76);
                }
                if (!TextUtils.isEmpty(aILPChatBean.getName())) {
                    viewHolder.mUserName.setVisibility(0);
                    viewHolder.mUserName.setText(aILPChatBean.getName());
                    viewHolder.mUserName.setTextColor(aILPChatBean.getNameColor());
                } else {
                    viewHolder.mUserName.setVisibility(8);
                }
                DagoImageLoader.getInstance().showCircle(this.mContext, aILPChatBean.getFace(), viewHolder.mUserIcon, R.C7941drawable.dago_pgc_ailp_gift_user_header_2x);
                if (!TextUtils.isEmpty(aILPChatBean.getFaceIcon())) {
                    viewHolder.mUserVipIcon.setVisibility(0);
                    DagoImageLoader.getInstance().showCircle(this.mContext, aILPChatBean.getFaceIcon(), viewHolder.mUserVipIcon, R.C7941drawable.dago_pgc_ailp_chat_gold_icon);
                } else {
                    viewHolder.mUserVipIcon.setVisibility(8);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "664587479")) {
            return (ViewHolder) ipChange.ipc$dispatch("664587479", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.C7942layout.dago_pgc_ailp_comment_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        viewHolder.mChatLayout = (RelativeLayout) inflate.findViewById(R.id.chat_item_layout);
        viewHolder.mUserComment = (TextView) inflate.findViewById(R.id.tv_portrait_comment_content);
        viewHolder.mUserName = (TextView) inflate.findViewById(R.id.tv_item_comment_username);
        viewHolder.mUserIcon = (ImageView) inflate.findViewById(R.id.iv_user_icon);
        viewHolder.mUserVipIcon = (ImageView) inflate.findViewById(R.id.iv_user_vip_icon);
        return viewHolder;
    }
}
