package tb;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.dynamicx.customwidget.scrollerlayout.DMItemDividerDecoration;
import cn.damai.discover.content.bean.RelatedBrandOrArtist;
import cn.damai.discover.content.bean.TwoTuple;
import cn.damai.discover.content.net.ArtistBrandWrap;
import cn.damai.discover.content.net.ContentCard;
import cn.damai.discover.content.ui.adapter.RelatedArtistAdapter;
import cn.damai.discover.content.ui.viewholder.item.ContentDetailRelatedBrand;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class vn extends cp2<TwoTuple<ContentCard, ArtistBrandWrap>> implements RelatedArtistAdapter.OnRelatedItemClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private RecyclerView d;
    private ContentDetailRelatedBrand e;
    private RelatedBrandOrArtist f;
    private TextView g;
    private View h;
    private View i;

    public vn(Context context) {
        super(context);
    }

    private void d(RelatedBrandOrArtist relatedBrandOrArtist, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2053621820")) {
            ipChange.ipc$dispatch("2053621820", new Object[]{this, relatedBrandOrArtist, Integer.valueOf(i)});
        } else if (relatedBrandOrArtist == null || wh2.j(relatedBrandOrArtist.id)) {
        } else {
            Bundle bundle = new Bundle();
            if (relatedBrandOrArtist.type == 4) {
                bundle.putString("brandid", String.valueOf(relatedBrandOrArtist.damaiId));
                C0529c.e().x(getLiveUt().u());
            } else {
                C0529c.e().x(getLiveUt().p(i));
                bundle.putString("artistid", String.valueOf(relatedBrandOrArtist.damaiId));
            }
            DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
        }
    }

    @Override // tb.cp2
    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1796612007") ? ((Integer) ipChange.ipc$dispatch("-1796612007", new Object[]{this})).intValue() : R$layout.live_content_detail_related_brand_or_artist;
    }

    @Override // tb.cp2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1491909286")) {
            ipChange.ipc$dispatch("1491909286", new Object[]{this});
            return;
        }
        this.d = (RecyclerView) this.b.findViewById(R$id.live_content_detail_related_artist_list);
        this.e = (ContentDetailRelatedBrand) this.b.findViewById(R$id.live_content_detail_related_brand);
        this.g = (TextView) this.b.findViewById(R$id.tour_title);
        this.h = this.b.findViewById(R$id.divider_line);
        this.i = this.b.findViewById(R$id.artist_list_layout);
        this.e.setOnClickListener(this);
        this.d.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        int a = m62.a(mu0.a(), 18.0f);
        int a2 = m62.a(mu0.a(), 12.0f);
        this.d.addItemDecoration(new DMItemDividerDecoration(a2, a2, a));
    }

    public void e(TwoTuple<ContentCard, ArtistBrandWrap> twoTuple) {
        ArtistBrandWrap artistBrandWrap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-280204245")) {
            ipChange.ipc$dispatch("-280204245", new Object[]{this, twoTuple});
        } else if (twoTuple != null && (artistBrandWrap = twoTuple.second) != null && !m91.a(artistBrandWrap.artistItem)) {
            ArtistBrandWrap artistBrandWrap2 = twoTuple.second;
            List<RelatedBrandOrArtist> list = artistBrandWrap2.artistItem;
            if (twoTuple.first.isTourTitleType() && !TextUtils.isEmpty(artistBrandWrap2.title)) {
                this.g.setText(artistBrandWrap2.title);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
            } else {
                this.g.setVisibility(8);
                this.h.setVisibility(8);
            }
            int size = list.size();
            RelatedBrandOrArtist relatedBrandOrArtist = list.get(0);
            if (relatedBrandOrArtist.type == 2 && size > 1) {
                RelatedArtistAdapter relatedArtistAdapter = new RelatedArtistAdapter(this.a, this);
                relatedArtistAdapter.setData(list);
                this.d.setAdapter(relatedArtistAdapter);
                this.i.setVisibility(0);
                this.e.setVisibility(8);
            } else {
                this.e.handleView(relatedBrandOrArtist);
                this.f = relatedBrandOrArtist;
                this.i.setVisibility(8);
                this.e.setVisibility(0);
            }
            c(true);
        } else {
            c(false);
        }
    }

    @Override // tb.cp2, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041563578")) {
            ipChange.ipc$dispatch("2041563578", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view.getId() == R$id.live_content_detail_related_brand) {
            d(this.f, 0);
        }
    }

    @Override // cn.damai.discover.content.ui.adapter.RelatedArtistAdapter.OnRelatedItemClickListener
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1053374212")) {
            ipChange.ipc$dispatch("-1053374212", new Object[]{this, viewHolder, view, Integer.valueOf(i), obj});
        } else if (obj == null || !(obj instanceof RelatedBrandOrArtist)) {
        } else {
            d((RelatedBrandOrArtist) obj, i);
        }
    }
}
