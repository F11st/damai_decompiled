package tb;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.discover.content.bean.ContentTour;
import cn.damai.discover.content.bean.TwoTuple;
import cn.damai.discover.content.net.IpInfoWrap;
import cn.damai.discover.content.ui.viewholder.CityProjectListPanel;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.musicfestival.model.MusicPageNav;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class zc0 extends cp2<TwoTuple<String, IpInfoWrap>> implements OnItemBindListener<ContentTour.ContentRelatedTourListItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private RoundImageView d;
    private TextView e;
    private TextView f;
    private View g;
    private TextView h;
    private CityProjectListPanel i;
    private View j;

    /* compiled from: Taobao */
    /* renamed from: tb.zc0$a */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC10019a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DramaV1Bean a;

        View$OnClickListenerC10019a(DramaV1Bean dramaV1Bean) {
            this.a = dramaV1Bean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            int i = 1;
            if (AndroidInstantRuntime.support(ipChange, "834808328")) {
                ipChange.ipc$dispatch("834808328", new Object[]{this, view});
            } else if (zc0.this.a == null) {
            } else {
                DramaV1Bean dramaV1Bean = this.a;
                String str = dramaV1Bean.id;
                if (dramaV1Bean.isMusicIpType()) {
                    MusicPageNav.openH5MusicIpPage(zc0.this.a, str);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(RepertoireDetailFragment.REPERTOIREID, str);
                    DMNav.from(zc0.this.a).withExtras(bundle).toUri(NavUri.b(u12.REPERTOITE));
                    i = 0;
                }
                C0529c.e().x(zc0.this.getLiveUt().A(i, str));
            }
        }
    }

    public zc0(Context context) {
        super(context);
    }

    @Override // tb.cp2
    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-786255240") ? ((Integer) ipChange.ipc$dispatch("-786255240", new Object[]{this})).intValue() : R$layout.item_content_detail_drama_relate;
    }

    @Override // tb.cp2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-76975035")) {
            ipChange.ipc$dispatch("-76975035", new Object[]{this});
            return;
        }
        this.j = this.b.findViewById(R$id.card_ui);
        this.d = (RoundImageView) this.b.findViewById(R$id.drama_pic);
        this.e = (TextView) this.b.findViewById(R$id.drama_title);
        this.f = (TextView) this.b.findViewById(R$id.drama_desc);
        this.g = this.b.findViewById(R$id.drama_score_ui);
        this.h = (TextView) this.b.findViewById(R$id.drama_score);
        this.i = new CityProjectListPanel(this.b, this);
        this.d.setBorder(1, Color.parseColor("#1A000000"));
    }

    @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
    /* renamed from: d */
    public void exposeItem(View view, ContentTour.ContentRelatedTourListItem contentRelatedTourListItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2058055571")) {
            ipChange.ipc$dispatch("-2058055571", new Object[]{this, view, contentRelatedTourListItem, Integer.valueOf(i)});
        }
    }

    public void e(TwoTuple<String, IpInfoWrap> twoTuple) {
        IpInfoWrap ipInfoWrap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-30379190")) {
            ipChange.ipc$dispatch("-30379190", new Object[]{this, twoTuple});
        } else if (twoTuple != null && (ipInfoWrap = twoTuple.second) != null) {
            IpInfoWrap ipInfoWrap2 = ipInfoWrap;
            DramaV1Bean dramaV1Bean = ipInfoWrap2.ipInfo;
            if (dramaV1Bean != null) {
                this.j.setVisibility(0);
                this.e.setText(dramaV1Bean.title);
                this.f.setText(dramaV1Bean.briefIntroduction);
                if (dramaV1Bean.getScoreValue() > 0.0d) {
                    this.g.setVisibility(0);
                    this.h.setText(dramaV1Bean.itemScore);
                } else {
                    this.g.setVisibility(8);
                }
                DMImageCreator f = C0504a.b().f(dramaV1Bean.pic, m62.a(mu0.a(), 48.0f), m62.a(mu0.a(), 64.0f));
                int i = R$drawable.uikit_default_image_bg_gradient;
                f.i(i).c(i).g(this.d);
                this.j.setOnClickListener(new View$OnClickListenerC10019a(dramaV1Bean));
            } else {
                this.j.setVisibility(8);
            }
            this.i.b(ipInfoWrap2.relateItem, dramaV1Bean != null);
            c(true);
        } else {
            c(false);
        }
    }

    @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
    /* renamed from: f */
    public void onItemClick(ContentTour.ContentRelatedTourListItem contentRelatedTourListItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "238491096")) {
            ipChange.ipc$dispatch("238491096", new Object[]{this, contentRelatedTourListItem, Integer.valueOf(i)});
        } else if (this.a == null) {
        } else {
            C0529c.e().x(getLiveUt().L(contentRelatedTourListItem.itemId, i));
            Bundle bundle = new Bundle();
            bundle.putString("id", contentRelatedTourListItem.itemId);
            qd2.a(this.a, contentRelatedTourListItem.schema, bundle);
        }
    }
}
