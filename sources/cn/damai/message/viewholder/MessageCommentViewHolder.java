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
import cn.damai.message.ui.fragment.MessageCommentFragment;
import cn.damai.uikit.view.DMAvatar;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MessageCommentViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private MessageCommentFragment a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private RelativeLayout f;
    private DMAvatar g;

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
            if (AndroidInstantRuntime.support(ipChange, "77126935")) {
                ipChange.ipc$dispatch("77126935", new Object[]{this, view});
            } else if (MessageCommentViewHolder.this.a != null) {
                MessageCommentViewHolder.this.a.onItemClick(this.a, this.b);
            }
        }
    }

    public MessageCommentViewHolder(MessageCommentFragment messageCommentFragment, ViewGroup viewGroup) {
        super(LayoutInflater.from(messageCommentFragment.getActivity()).inflate(R$layout.message_comment_item_layout, viewGroup, false));
        this.a = messageCommentFragment;
        MessageFollowCommentActivity messageFollowCommentActivity = (MessageFollowCommentActivity) messageCommentFragment.getActivity();
        c();
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1069107292")) {
            ipChange.ipc$dispatch("-1069107292", new Object[]{this});
            return;
        }
        this.b = (TextView) this.itemView.findViewById(R$id.comment_user_name);
        this.f = (RelativeLayout) this.itemView.findViewById(R$id.comment_item_layout);
        this.d = (TextView) this.itemView.findViewById(R$id.main_reply_title);
        this.e = (TextView) this.itemView.findViewById(R$id.main_reply_content);
        this.c = (TextView) this.itemView.findViewById(R$id.comment_date);
        DMAvatar dMAvatar = (DMAvatar) this.itemView.findViewById(R$id.comment_header_damai_avatar);
        this.g = dMAvatar;
        dMAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_60x60);
    }

    public void b(MessageItem messageItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1126379660")) {
            ipChange.ipc$dispatch("1126379660", new Object[]{this, messageItem, Integer.valueOf(i)});
        } else if (messageItem == null) {
        } else {
            if (!TextUtils.isEmpty(messageItem.getImageUrl())) {
                this.g.setAvatar(messageItem.getImageUrl());
            } else {
                this.g.setAvatarPlaceholder(R$drawable.uikit_user_default_icon);
            }
            this.g.setAvatarCrownVisibility(8);
            this.g.setAvatarBorderVisibility(8);
            this.g.setYYMemberTagView(false, messageItem.getMemberFlag());
            if (!TextUtils.isEmpty(messageItem.getTitle())) {
                this.b.setText(messageItem.getTitle());
            }
            if (!TextUtils.isEmpty(messageItem.getGmtCreateText())) {
                this.c.setText(messageItem.getGmtCreateText());
            }
            if (!TextUtils.isEmpty(messageItem.getExtJson())) {
                this.e.setText(messageItem.getExtJson());
            }
            this.f.setOnClickListener(new a(messageItem, i));
            if (!TextUtils.isEmpty(messageItem.getMotion())) {
                this.d.setVisibility(0);
                this.d.setText(messageItem.getMotion());
            } else {
                this.d.setVisibility(4);
                this.d.setText("");
            }
            if (messageItem.getvTag() > 0 && !messageItem.isPerformFilmVip()) {
                this.g.setAvatarVTagVisibility(0);
            } else {
                this.g.setAvatarVTagVisibility(8);
            }
        }
    }
}
