package cn.damai.discover.content.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.discover.content.bean.RelatedBrandOrArtist;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.banner.sub.RoundRadiusImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.m91;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class RelatedArtistAdapter extends RecyclerView.Adapter<RelatedArtistViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private OnRelatedItemClickListener b;
    private List<RelatedBrandOrArtist> d = new ArrayList();
    private OnRelatedItemClickListener c = new C1003a();

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnRelatedItemClickListener {
        void onItemClick(RecyclerView.ViewHolder viewHolder, View view, int i, Object obj);
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class RelatedArtistViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        public TextView a;
        public RoundRadiusImageView b;
        private OnRelatedItemClickListener c;

        public RelatedArtistViewHolder(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.live_content_detail_related_artist_name);
            this.b = (RoundRadiusImageView) view.findViewById(R$id.live_content_detail_related_brand_avatar);
            view.setOnClickListener(this);
        }

        public void a(OnRelatedItemClickListener onRelatedItemClickListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "876643984")) {
                ipChange.ipc$dispatch("876643984", new Object[]{this, onRelatedItemClickListener});
            } else {
                this.c = onRelatedItemClickListener;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1958219972")) {
                ipChange.ipc$dispatch("1958219972", new Object[]{this, view});
                return;
            }
            OnRelatedItemClickListener onRelatedItemClickListener = this.c;
            if (onRelatedItemClickListener != null) {
                onRelatedItemClickListener.onItemClick(this, view, getAdapterPosition(), null);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.discover.content.ui.adapter.RelatedArtistAdapter$a */
    /* loaded from: classes5.dex */
    public class C1003a implements OnRelatedItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1003a() {
        }

        @Override // cn.damai.discover.content.ui.adapter.RelatedArtistAdapter.OnRelatedItemClickListener
        public void onItemClick(RecyclerView.ViewHolder viewHolder, View view, int i, Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1309924604")) {
                ipChange.ipc$dispatch("-1309924604", new Object[]{this, viewHolder, view, Integer.valueOf(i), obj});
            } else if (RelatedArtistAdapter.this.b != null) {
                RelatedArtistAdapter.this.b.onItemClick(viewHolder, view, i, RelatedArtistAdapter.this.getItem(i));
            }
        }
    }

    public RelatedArtistAdapter(Context context, OnRelatedItemClickListener onRelatedItemClickListener) {
        this.a = context;
        this.b = onRelatedItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onBindViewHolder(RelatedArtistViewHolder relatedArtistViewHolder, int i) {
        RelatedBrandOrArtist relatedBrandOrArtist;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585473281")) {
            ipChange.ipc$dispatch("-585473281", new Object[]{this, relatedArtistViewHolder, Integer.valueOf(i)});
        } else if (relatedArtistViewHolder == null || (relatedBrandOrArtist = this.d.get(i)) == null || wh2.j(relatedBrandOrArtist.damaiId)) {
        } else {
            relatedArtistViewHolder.a.setText(relatedBrandOrArtist.name);
            if (wh2.j(relatedBrandOrArtist.headPic)) {
                relatedArtistViewHolder.b.setImageBitmap(null);
            } else {
                C0504a.b().c(relatedBrandOrArtist.headPic).g(relatedArtistViewHolder.b);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public RelatedArtistViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340333929")) {
            return (RelatedArtistViewHolder) ipChange.ipc$dispatch("-1340333929", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i != 1) {
            return null;
        }
        RelatedArtistViewHolder relatedArtistViewHolder = new RelatedArtistViewHolder(LayoutInflater.from(this.a).inflate(R$layout.item_live_content_detail_related_artist, viewGroup, false));
        relatedArtistViewHolder.a(this.c);
        return relatedArtistViewHolder;
    }

    public Object getItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1812471940")) {
            return ipChange.ipc$dispatch("-1812471940", new Object[]{this, Integer.valueOf(i)});
        }
        if (m91.a(this.d)) {
            return null;
        }
        return this.d.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1219368863") ? ((Integer) ipChange.ipc$dispatch("-1219368863", new Object[]{this})).intValue() : wh2.e(this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1282291064")) {
            return ((Integer) ipChange.ipc$dispatch("-1282291064", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        return 1;
    }

    public void setData(List<RelatedBrandOrArtist> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-821855077")) {
            ipChange.ipc$dispatch("-821855077", new Object[]{this, list});
        } else if (wh2.e(list) > 0) {
            this.d = list;
            notifyDataSetChanged();
        } else {
            this.d.clear();
            notifyDataSetChanged();
        }
    }
}
