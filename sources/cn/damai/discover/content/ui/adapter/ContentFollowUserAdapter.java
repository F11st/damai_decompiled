package cn.damai.discover.content.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.discover.viewholder.ImgTicketWrap;
import cn.damai.discover.content.bean.FollowedUser;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.m62;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ContentFollowUserAdapter extends RecyclerView.Adapter<HeadVh> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int HEAD_SIZE_DP = 15;
    public static final int ITEM_OFFSET_SIZE_DP = 4;
    public static final int PADDING_SIZE_DP = 0;
    private Context a;
    private OnItemBindListener<FollowedUser> b;
    private final int c;
    private List<FollowedUser> d;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class HeadVh extends BaseViewHolder<FollowedUser> implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private RoundImageView a;
        private FollowedUser b;
        private int c;

        public HeadVh(View view) {
            super(view);
            view.setOnClickListener(this);
            this.a = (RoundImageView) view.findViewById(R$id.follow_user_head);
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
        /* renamed from: c */
        public void a(FollowedUser followedUser, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-247211088")) {
                ipChange.ipc$dispatch("-247211088", new Object[]{this, followedUser, Integer.valueOf(i)});
                return;
            }
            this.b = followedUser;
            this.c = i;
            this.a.setBorder(0.5f, Color.parseColor("#1A000000"));
            ImgTicketWrap.c(this.a, followedUser.headImg, R$drawable.uikit_user_default_icon, null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "497177864")) {
                ipChange.ipc$dispatch("497177864", new Object[]{this, view});
            } else if (this.b == null || ContentFollowUserAdapter.this.b == null) {
            } else {
                ContentFollowUserAdapter.this.b.onItemClick(this.b, this.c);
            }
        }
    }

    public ContentFollowUserAdapter(Context context, OnItemBindListener<FollowedUser> onItemBindListener) {
        this.a = context;
        this.b = onItemBindListener;
        this.c = m62.a(context, 4.0f);
    }

    private int c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "934726400")) {
            return ((Integer) ipChange.ipc$dispatch("934726400", new Object[]{this})).intValue();
        }
        return (DisplayMetrics.getwidthPixels(m62.b(this.a)) - (m62.a(this.a, 0.0f) * 2)) / m62.a(this.a, 19);
    }

    public int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1320276039") ? ((Integer) ipChange.ipc$dispatch("1320276039", new Object[]{this})).intValue() : this.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(@NonNull HeadVh headVh, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-886888910")) {
            ipChange.ipc$dispatch("-886888910", new Object[]{this, headVh, Integer.valueOf(i)});
        } else {
            headVh.a(this.d.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: e */
    public HeadVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-176477820") ? (HeadVh) ipChange.ipc$dispatch("-176477820", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new HeadVh(LayoutInflater.from(this.a).inflate(R$layout.live_content_detail_head_item, viewGroup, false));
    }

    public void f(List<FollowedUser> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1547767138")) {
            ipChange.ipc$dispatch("-1547767138", new Object[]{this, list});
            return;
        }
        if (cb2.d(list)) {
            this.d = null;
        } else {
            this.d = new ArrayList(list.subList(0, Math.min(wh2.e(list), c())));
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1486904930")) {
            return ((Integer) ipChange.ipc$dispatch("-1486904930", new Object[]{this})).intValue();
        }
        List<FollowedUser> list = this.d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
