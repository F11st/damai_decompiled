package cn.damai.message.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.message.bean.MessageGroupItem;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MessageModelViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private FrameLayout a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private RelativeLayout f;
    private DMIconFontTextView g;
    private Context h;
    private MessageAdapterCallback i;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface MessageAdapterCallback {
        void onMessageClick(View view, int i);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.message.viewholder.MessageModelViewHolder$a */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1353a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        View$OnClickListenerC1353a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "428964577")) {
                ipChange.ipc$dispatch("428964577", new Object[]{this, view});
            } else {
                MessageModelViewHolder.this.i.onMessageClick(view, this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.message.viewholder.MessageModelViewHolder$b */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1354b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        View$OnClickListenerC1354b(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1754712350")) {
                ipChange.ipc$dispatch("-1754712350", new Object[]{this, view});
            } else {
                MessageModelViewHolder.this.i.onMessageClick(view, this.a);
            }
        }
    }

    public MessageModelViewHolder(Context context, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.item_msg_group_model_layout, viewGroup, false));
        this.h = context;
        this.i = (MessageAdapterCallback) context;
        c();
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1535336850")) {
            ipChange.ipc$dispatch("-1535336850", new Object[]{this});
            return;
        }
        this.a = (FrameLayout) this.itemView.findViewById(R$id.fl_icon);
        this.f = (RelativeLayout) this.itemView.findViewById(R$id.rl_content);
        this.g = (DMIconFontTextView) this.itemView.findViewById(R$id.iv_icon);
        this.b = (TextView) this.itemView.findViewById(R$id.tv_model_name);
        this.c = (TextView) this.itemView.findViewById(R$id.tv_latest_time);
        this.d = (TextView) this.itemView.findViewById(R$id.tv_latest_msg);
        this.e = (TextView) this.itemView.findViewById(R$id.tv_unread_count);
    }

    public void b(MessageGroupItem messageGroupItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1941510555")) {
            ipChange.ipc$dispatch("-1941510555", new Object[]{this, messageGroupItem, Integer.valueOf(i)});
        } else if (messageGroupItem != null) {
            this.f.setVisibility(0);
            if (!TextUtils.isEmpty(messageGroupItem.getMsgTypeName())) {
                this.b.setText(messageGroupItem.getMsgTypeName());
            } else {
                this.b.setText("");
            }
            if (!TextUtils.isEmpty(messageGroupItem.getGmtCreate())) {
                String gmtCreate = messageGroupItem.getGmtCreate();
                try {
                    long time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(gmtCreate).getTime();
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    gregorianCalendar.setTimeInMillis(time);
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
                    gregorianCalendar2.set(11, 0);
                    gregorianCalendar2.set(12, 0);
                    gregorianCalendar2.set(13, 0);
                    if (gregorianCalendar.before(gregorianCalendar2)) {
                        gmtCreate = new SimpleDateFormat("MM月dd日 HH:mm", Locale.CHINA).format(Long.valueOf(time));
                    } else {
                        gmtCreate = new SimpleDateFormat("HH:mm", Locale.CHINA).format(Long.valueOf(time));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.c.setText(gmtCreate);
            } else {
                this.c.setText("");
            }
            if (!TextUtils.isEmpty(messageGroupItem.getMsgBody())) {
                this.d.setText(messageGroupItem.getMsgBody());
            } else {
                this.d.setText("");
            }
            if (messageGroupItem.getUnBadgeReadCount() <= 0) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                if (messageGroupItem.getUnBadgeReadCount() > 9) {
                    this.e.setText("9+");
                    this.e.setBackgroundResource(R$drawable.unread_count_more);
                } else {
                    this.e.setText(String.valueOf(messageGroupItem.getUnBadgeReadCount()));
                    this.e.setBackgroundResource(R$drawable.unread_count_one);
                }
            }
            if (8 == messageGroupItem.getGroupId()) {
                this.g.setText(this.h.getResources().getString(R$string.iconfont_maixiaomi24));
                this.g.setTextSize(45.0f);
                this.g.setBackgroundResource(R$drawable.bg_message_maixiaomi_icon);
            } else if (1 == messageGroupItem.getGroupId()) {
                this.g.setText(this.h.getResources().getString(R$string.iconfont_zan24));
                this.g.setTextSize(32.0f);
                this.g.setBackgroundResource(R$drawable.bg_message_recommend_icon);
            } else if (4 == messageGroupItem.getGroupId()) {
                this.g.setText(this.h.getResources().getString(R$string.iconfont_tongzhi24));
                this.g.setTextSize(32.0f);
                this.g.setBackgroundResource(R$drawable.bg_message_notice_icon);
            } else if (7 == messageGroupItem.getGroupId()) {
                this.g.setText(this.h.getResources().getString(R$string.iconfont_guanzhuhehuifu24));
                this.g.setTextSize(32.0f);
                this.g.setBackgroundResource(R$drawable.bg_message_attend_reply_icon);
            }
            this.f.setOnClickListener(new View$OnClickListenerC1353a(i));
            this.a.setOnClickListener(new View$OnClickListenerC1354b(i));
        }
    }
}
