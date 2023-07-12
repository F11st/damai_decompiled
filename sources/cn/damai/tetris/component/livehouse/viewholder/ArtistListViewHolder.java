package cn.damai.tetris.component.livehouse.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.tetris.component.drama.viewholder.OnItemClickListener;
import cn.damai.tetris.component.livehouse.bean.ArtistItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;
import tb.mu0;
import tb.yq;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistListViewHolder extends BaseViewHolderV2<ArtistItemBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView c;
    private ImageView d;
    private OnItemClickListener<ArtistItemBean> e;
    private RelativeLayout f;
    private TextView g;
    private ImageView h;
    private TextView i;
    private Context j;

    public ArtistListViewHolder(Context context, ViewGroup viewGroup, OnItemClickListener<ArtistItemBean> onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.livehouse_actor_item_layout, viewGroup, false));
        this.j = context;
        this.c = (ImageView) this.itemView.findViewById(R$id.actor_image_bg);
        this.d = (ImageView) this.itemView.findViewById(R$id.actor_image);
        this.e = onItemClickListener;
        this.f = (RelativeLayout) this.itemView.findViewById(R$id.actor_layout);
        this.g = (TextView) this.itemView.findViewById(R$id.actor_text);
        this.h = (ImageView) this.itemView.findViewById(R$id.artist_tag_image);
        this.i = (TextView) this.itemView.findViewById(R$id.artist_tag_text);
        this.f.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2
    /* renamed from: d */
    public void c(ArtistItemBean artistItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1961546034")) {
            ipChange.ipc$dispatch("-1961546034", new Object[]{this, artistItemBean, Integer.valueOf(i)});
            return;
        }
        if (artistItemBean != null) {
            int i2 = artistItemBean.artistVo.flag;
            if (i2 == -1 && i == 0) {
                this.c.setVisibility(0);
                this.g.setTextColor(this.j.getResources().getColor(R$color.color_FF2869));
            } else if (i2 == 1) {
                this.c.setVisibility(0);
                this.g.setTextColor(this.j.getResources().getColor(R$color.color_FF2869));
            } else {
                this.c.setVisibility(4);
                this.g.setTextColor(this.j.getResources().getColor(R$color.color_333333));
            }
            DMImageCreator f = C0504a.b().h(mu0.a()).f(artistItemBean.artistVo.headPic, m62.a(mu0.a(), 40.0f), m62.a(mu0.a(), 40.0f));
            int i3 = R$drawable.artist_grey_bg;
            f.i(i3).c(i3).k(new yq()).g(this.d);
        }
        this.g.setText(artistItemBean.artistVo.name);
        if (!TextUtils.isEmpty(artistItemBean.artistVo.tag)) {
            this.h.setVisibility(0);
            this.i.setText(artistItemBean.artistVo.tag);
            return;
        }
        this.h.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        T t;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1406186022")) {
            ipChange.ipc$dispatch("-1406186022", new Object[]{this, view});
            return;
        }
        OnItemClickListener<ArtistItemBean> onItemClickListener = this.e;
        if (onItemClickListener == null || (t = this.a) == 0) {
            return;
        }
        onItemClickListener.onItemClick((ArtistItemBean) t, this.b);
    }
}
