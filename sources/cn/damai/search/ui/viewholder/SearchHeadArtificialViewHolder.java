package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.bean.youku.ArtificialProxy;
import cn.damai.search.helper.SearchHelper;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchHeadArtificialViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private int c;
    private ArtificialProxy d;
    private Context e;
    private ImageView f;
    private int g;
    private OnItemBindListener<ArtificialProxy> h;

    public SearchHeadArtificialViewHolder(Context context, ViewGroup viewGroup, OnItemBindListener<ArtificialProxy> onItemBindListener) {
        super(LayoutInflater.from(context).inflate(R$layout.item_view_artificial, viewGroup, false));
        this.c = l62.a(mu0.a(), 115.0f);
        this.e = context;
        this.f = (ImageView) this.itemView.findViewById(R$id.artificial_img_1);
        this.b = (TextView) this.itemView.findViewById(R$id.artificial_text);
        this.a = this.itemView.findViewById(R$id.artificial_video_tag);
        this.h = onItemBindListener;
    }

    public void a(ArtificialProxy artificialProxy, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2131354981")) {
            ipChange.ipc$dispatch("2131354981", new Object[]{this, artificialProxy, Integer.valueOf(i)});
        } else if (artificialProxy == null) {
        } else {
            this.d = artificialProxy;
            this.g = i;
            String imgUrl = artificialProxy.getImgUrl();
            this.b.setText(artificialProxy.getTitle());
            this.a.setVisibility(artificialProxy.isShowVideoTag() ? 0 : 8);
            ImageView imageView = this.f;
            int i2 = this.c;
            SearchHelper.s(imageView, imgUrl, i2, i2);
            this.itemView.setOnClickListener(this);
            OnItemBindListener<ArtificialProxy> onItemBindListener = this.h;
            if (onItemBindListener != null) {
                onItemBindListener.exposeItem(this.itemView, this.d, this.g);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ArtificialProxy artificialProxy;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1645397896")) {
            ipChange.ipc$dispatch("1645397896", new Object[]{this, view});
            return;
        }
        OnItemBindListener<ArtificialProxy> onItemBindListener = this.h;
        if (onItemBindListener == null || (artificialProxy = this.d) == null || this.e == null) {
            return;
        }
        onItemBindListener.onItemClick(artificialProxy, this.g);
    }
}
