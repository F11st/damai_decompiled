package cn.damai.mine.adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.bean.MyFeedBackDetailDO;
import cn.damai.mine.bean.MyFeedBackDetailDataHolder;
import cn.damai.mine.bean.MyFeedReplyDetailDO;
import cn.damai.uikit.flowlayout.FlowLayout;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.m62;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MyFeedBackDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<MyFeedBackDetailDataHolder> a;
    private Context b;
    private int c;
    private ArrayList<String> d = new ArrayList<>();
    private View.OnClickListener e = new a();

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class MyFeedBackDetailViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private TextView b;
        private FlowLayout c;
        private LayoutInflater d;
        private LinearLayout.LayoutParams e;

        public MyFeedBackDetailViewHolder(LayoutInflater layoutInflater, int i) {
            super(layoutInflater.inflate(R$layout.feed_back_my_detail_item, (ViewGroup) null));
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.d = layoutInflater;
            this.e = new LinearLayout.LayoutParams(i, i);
            b(this.itemView);
        }

        private void b(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1836631591")) {
                ipChange.ipc$dispatch("1836631591", new Object[]{this, view});
                return;
            }
            this.a = (TextView) view.findViewById(R$id.tv_content);
            this.b = (TextView) view.findViewById(R$id.tv_time);
            this.c = (FlowLayout) view.findViewById(R$id.ll_image_container);
        }

        public void a(MyFeedBackDetailDO myFeedBackDetailDO) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "605897827")) {
                ipChange.ipc$dispatch("605897827", new Object[]{this, myFeedBackDetailDO});
            } else if (myFeedBackDetailDO != null) {
                if (TextUtils.isEmpty(myFeedBackDetailDO.bizIdentifiers)) {
                    this.a.setText(myFeedBackDetailDO.content);
                } else {
                    TextView textView = this.a;
                    textView.setText(myFeedBackDetailDO.bizIdentifiers + "：" + myFeedBackDetailDO.content);
                }
                TextView textView2 = this.b;
                textView2.setText(myFeedBackDetailDO.gmtCreate + " " + myFeedBackDetailDO.tips);
                int e = wh2.e(myFeedBackDetailDO.imageAddrs);
                if (e > 0) {
                    MyFeedBackDetailAdapter.this.d.clear();
                    this.c.removeAllViews();
                    for (int i = 0; i < e; i++) {
                        if (!TextUtils.isEmpty(myFeedBackDetailDO.imageAddrs.get(i))) {
                            MyFeedBackDetailAdapter.this.d.add(myFeedBackDetailDO.imageAddrs.get(i));
                            View inflate = this.d.inflate(R$layout.feed_back_image, (ViewGroup) null);
                            ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_quest);
                            imageView.setLayoutParams(this.e);
                            DMImageCreator c = cn.damai.common.image.a.b().c(myFeedBackDetailDO.imageAddrs.get(i));
                            int i2 = R$drawable.uikit_default_image_bg_gradient;
                            c.i(i2).c(i2).g(imageView);
                            this.c.addView(inflate);
                            inflate.setTag(Integer.valueOf(i));
                            inflate.setOnClickListener(MyFeedBackDetailAdapter.this.e);
                        }
                    }
                    this.c.setVisibility(0);
                    return;
                }
                this.c.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class MyFeedBackReplyViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private TextView b;
        private TextView c;
        private View d;
        private View e;
        private ImageView f;

        public MyFeedBackReplyViewHolder(MyFeedBackDetailAdapter myFeedBackDetailAdapter, LayoutInflater layoutInflater) {
            super(layoutInflater.inflate(R$layout.feed_back_my_reply_item, (ViewGroup) null));
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            b(this.itemView);
        }

        private void b(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1299276792")) {
                ipChange.ipc$dispatch("1299276792", new Object[]{this, view});
                return;
            }
            this.a = (TextView) view.findViewById(R$id.tv_replay_title);
            this.b = (TextView) view.findViewById(R$id.tv_replay_content);
            this.c = (TextView) view.findViewById(R$id.tv_replay_time);
            this.d = view.findViewById(R$id.line_top);
            this.e = view.findViewById(R$id.line_bottom);
            this.f = (ImageView) view.findViewById(R$id.iv_replay_icon);
        }

        public void a(MyFeedReplyDetailDO myFeedReplyDetailDO, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1153729968")) {
                ipChange.ipc$dispatch("-1153729968", new Object[]{this, myFeedReplyDetailDO, Integer.valueOf(i)});
            } else if (myFeedReplyDetailDO == null) {
            } else {
                if (i == 0) {
                    this.d.setVisibility(0);
                    this.e.setVisibility(4);
                    this.f.setImageResource(cn.damai.homepage.R$drawable.bg_circle_main_red);
                } else if (i == 1) {
                    this.d.setVisibility(0);
                    this.e.setVisibility(0);
                    this.f.setImageResource(cn.damai.homepage.R$drawable.bg_circle_main_red);
                } else if (i == 2) {
                    this.d.setVisibility(8);
                    this.e.setVisibility(0);
                    this.f.setImageResource(cn.damai.homepage.R$drawable.bg_circle_grey);
                } else if (i == 3) {
                    this.d.setVisibility(8);
                    this.e.setVisibility(4);
                    this.f.setImageResource(cn.damai.homepage.R$drawable.bg_circle_grey);
                }
                this.a.setText(myFeedReplyDetailDO.replyUserNick);
                if (TextUtils.isEmpty(myFeedReplyDetailDO.replyContent)) {
                    this.b.setVisibility(8);
                } else {
                    this.b.setText(myFeedReplyDetailDO.replyContent);
                    this.b.setVisibility(0);
                }
                this.c.setText(myFeedReplyDetailDO.replyTime);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1659109177")) {
                ipChange.ipc$dispatch("-1659109177", new Object[]{this, view});
                return;
            }
            if (view.getTag() != null) {
                try {
                    i = Integer.parseInt(view.getTag() + "");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("images", MyFeedBackDetailAdapter.this.d);
            bundle.putInt("location", i);
            DMNav.from(MyFeedBackDetailAdapter.this.b).withExtras(bundle).toUri(NavUri.b("gallery_images"));
        }
    }

    public MyFeedBackDetailAdapter(Context context, List<MyFeedBackDetailDataHolder> list) {
        this.a = list;
        this.b = context;
        this.c = DisplayMetrics.getwidthPixels(m62.b(context)) / 6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1772236918") ? ((Integer) ipChange.ipc$dispatch("1772236918", new Object[]{this})).intValue() : wh2.e(this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1247412195") ? ((Integer) ipChange.ipc$dispatch("-1247412195", new Object[]{this, Integer.valueOf(i)})).intValue() : this.a.get(i).type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "216806083")) {
            ipChange.ipc$dispatch("216806083", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            MyFeedBackDetailDataHolder myFeedBackDetailDataHolder = this.a.get(i);
            int i3 = myFeedBackDetailDataHolder.type;
            if (i3 == 0) {
                ((MyFeedBackDetailViewHolder) viewHolder).a(myFeedBackDetailDataHolder.myFeedBackDetailDO);
            } else if (i3 != 1) {
            } else {
                if (getItemCount() != 2) {
                    if (i == 1) {
                        i2 = 1;
                    } else {
                        i2 = i == getItemCount() - 1 ? 3 : 2;
                    }
                }
                ((MyFeedBackReplyViewHolder) viewHolder).a(myFeedBackDetailDataHolder.myFeedReplyDetailDO, i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2136974701")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-2136974701", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return new MyFeedBackReplyViewHolder(this, from);
        }
        return new MyFeedBackDetailViewHolder(from, this.c);
    }
}
