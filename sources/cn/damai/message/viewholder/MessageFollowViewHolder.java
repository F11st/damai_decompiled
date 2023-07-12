package cn.damai.message.viewholder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.message.bean.MessageItem;
import cn.damai.message.ui.activity.MessageFollowCommentActivity;
import cn.damai.message.ui.fragment.MessageFollowFragment;
import cn.damai.uikit.view.DMAvatar;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MessageFollowViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private MessageFollowFragment a;
    private TextView b;
    private TextView c;
    private TextView d;
    private RelativeLayout e;
    private DMAvatar f;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ MessageItem a;
        final /* synthetic */ int b;

        a(MessageItem messageItem, int i) {
            this.a = messageItem;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "830371497")) {
                ipChange.ipc$dispatch("830371497", new Object[]{this, view});
            } else if (MessageFollowViewHolder.this.a != null) {
                MessageFollowViewHolder.this.a.onItemClick(this.a, this.b);
            }
        }
    }

    public MessageFollowViewHolder(MessageFollowFragment messageFollowFragment, ViewGroup viewGroup) {
        super(LayoutInflater.from(messageFollowFragment.getActivity()).inflate(R$layout.message_follow_item_layout, viewGroup, false));
        this.a = messageFollowFragment;
        MessageFollowCommentActivity messageFollowCommentActivity = (MessageFollowCommentActivity) messageFollowFragment.getActivity();
        c();
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "639061558")) {
            ipChange.ipc$dispatch("639061558", new Object[]{this});
            return;
        }
        this.b = (TextView) this.itemView.findViewById(R$id.follow_name);
        this.e = (RelativeLayout) this.itemView.findViewById(R$id.follow_userinfo_layout);
        this.c = (TextView) this.itemView.findViewById(R$id.follow_text);
        this.d = (TextView) this.itemView.findViewById(R$id.follow_time);
        DMAvatar dMAvatar = (DMAvatar) this.itemView.findViewById(R$id.follow_header_damai_avatar);
        this.f = dMAvatar;
        dMAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_60x60);
    }

    public void b(MessageItem messageItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "6310302")) {
            ipChange.ipc$dispatch("6310302", new Object[]{this, messageItem, Integer.valueOf(i)});
        } else if (messageItem == null) {
        } else {
            if (!TextUtils.isEmpty(messageItem.getImageUrl())) {
                this.f.setAvatar(messageItem.getImageUrl());
            } else {
                this.f.setAvatarPlaceholder(R$drawable.uikit_user_default_icon);
            }
            this.f.setAvatarCrownVisibility(8);
            this.f.setAvatarBorderVisibility(8);
            this.f.setYYMemberTagView(false, messageItem.getMemberFlag());
            if (!TextUtils.isEmpty(messageItem.getTitle())) {
                this.b.setText(messageItem.getTitle());
            }
            if (!TextUtils.isEmpty(messageItem.getGmtCreateText())) {
                this.d.setText(messageItem.getGmtCreateText());
            }
            this.e.setOnClickListener(new a(messageItem, i));
            if (!TextUtils.isEmpty(messageItem.getMsgBody())) {
                this.c.setVisibility(0);
                this.c.setText(messageItem.getMsgBody());
            }
            if (messageItem.getvTag() > 0 && !messageItem.isPerformFilmVip()) {
                this.f.setAvatarVTagVisibility(0);
            } else {
                this.f.setAvatarVTagVisibility(8);
            }
        }
    }
}
