package cn.damai.tetris.component.home.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.home.bean.HomePageRankBean;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.core.ut.TrackType;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.C9826vr;
import tb.cb1;
import tb.cs;
import tb.d23;
import tb.oy0;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankTopAdapter extends RecyclerView.Adapter<RankTopItemViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<HomePageRankBean.Content.RankLists> a;
    private Context b;
    private String c;
    private int d;
    private TrackInfo e;
    private JSONObject f;
    private String h;
    int g = 0;
    private View.OnClickListener i = new View$OnClickListenerC1849a();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class RankTopItemViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private ImageView a;
        private TextView b;
        private TextView c;

        public RankTopItemViewHolder() {
            super(LayoutInflater.from(RankTopAdapter.this.b).inflate(R$layout.homepage_rank_top_item, (ViewGroup) null));
            this.a = (ImageView) this.itemView.findViewById(R$id.homepage_rank_top_item_image);
            this.b = (TextView) this.itemView.findViewById(R$id.homepage_rank_top_item_title);
            this.c = (TextView) this.itemView.findViewById(R$id.homepage_rank_top_item_subtitle);
            this.itemView.setOnClickListener(RankTopAdapter.this.i);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(t60.a(RankTopAdapter.this.b, 98.0f), -2));
            this.itemView.setPadding(0, t60.a(RankTopAdapter.this.b, RankTopAdapter.this.g), 0, 0);
        }

        public void a(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "247392417")) {
                ipChange.ipc$dispatch("247392417", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            HomePageRankBean.Content.RankLists rankLists = (HomePageRankBean.Content.RankLists) RankTopAdapter.this.a.get(i);
            if (rankLists == null) {
                return;
            }
            rankLists.position = i;
            if (this.a.getTag() instanceof C9826vr) {
                ((C9826vr) this.a.getTag()).cancel();
            }
            this.a.setImageDrawable(null);
            DMImageCreator f = C0504a.b().f(rankLists.pic, t60.a(RankTopAdapter.this.b, 86.0f), t60.a(RankTopAdapter.this.b, 115.0f));
            int i2 = R$drawable.uikit_default_image_bg_gradient;
            this.a.setTag(f.i(i2).c(i2).g(this.a));
            this.b.setText(rankLists.title);
            this.c.setText(rankLists.desc);
            this.itemView.setTag(rankLists);
            if (RankTopAdapter.this.e != null) {
                TrackInfo trackInfo = RankTopAdapter.this.e;
                trackInfo.put("index", (Object) ("tab_" + RankTopAdapter.this.d));
                RankTopAdapter.this.e.put("item_id", (Object) rankLists.id);
                oy0.B().E(RankTopAdapter.this.e, this.itemView, true, RankTopAdapter.this.c, rankLists.alg, rankLists.scm, rankLists.id, RankTopAdapter.this.d, rankLists.position);
                return;
            }
            TrackInfo e = d23.e(RankTopAdapter.this.h + rankLists.position, RankTopAdapter.this.f);
            if (e != null) {
                e.put("index", (Object) ("tab_" + RankTopAdapter.this.d));
                e.put("item_id", (Object) rankLists.id);
                TrackProxy.ITrack a = TrackProxy.a();
                TrackType trackType = TrackType.expose;
                View view = this.itemView;
                String str = e.trackB;
                String str2 = e.trackC;
                a.userTrack(trackType, view, str, str2, e.trackD + rankLists.position, e.getArgsMap(), false);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.home.adapter.RankTopAdapter$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1849a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1849a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "773527908")) {
                ipChange.ipc$dispatch("773527908", new Object[]{this, view});
                return;
            }
            HomePageRankBean.Content.RankLists rankLists = (HomePageRankBean.Content.RankLists) view.getTag();
            Bundle bundle = new Bundle();
            long j = 0;
            try {
                j = Long.parseLong(rankLists.id);
            } catch (Exception e) {
                cb1.b("RankTopAdapter", e.getMessage());
            }
            bundle.putLong(RankListFragment.KEY_RANK_ID, j);
            DMNav.from(RankTopAdapter.this.b).withExtras(bundle).toUri(NavUri.b(cs.C));
            if (RankTopAdapter.this.e != null) {
                TrackInfo trackInfo = RankTopAdapter.this.e;
                trackInfo.put("index", (Object) ("tab_" + RankTopAdapter.this.d));
                RankTopAdapter.this.e.put("item_id", (Object) rankLists.id);
                oy0.B().j(RankTopAdapter.this.e, RankTopAdapter.this.c, rankLists.alg, RankTopAdapter.this.d, rankLists.position, rankLists.id);
                return;
            }
            TrackInfo e2 = d23.e(RankTopAdapter.this.h + rankLists.position, RankTopAdapter.this.f);
            if (e2 != null) {
                e2.put("index", (Object) ("tab_" + RankTopAdapter.this.d));
                e2.put("item_id", (Object) rankLists.id);
                TrackProxy.ITrack a = TrackProxy.a();
                TrackType trackType = TrackType.click;
                String str = e2.trackB;
                String str2 = e2.trackC;
                a.userTrack(trackType, null, str, str2, e2.trackD + rankLists.position, e2.getArgsMap(), true);
            }
        }
    }

    public RankTopAdapter(Context context) {
        this.b = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2023236371")) {
            return ((Integer) ipChange.ipc$dispatch("2023236371", new Object[]{this})).intValue();
        }
        if (wh2.e(this.a) > 10) {
            return 10;
        }
        return wh2.e(this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public void onBindViewHolder(@NonNull RankTopItemViewHolder rankTopItemViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1700352653")) {
            ipChange.ipc$dispatch("1700352653", new Object[]{this, rankTopItemViewHolder, Integer.valueOf(i)});
        } else {
            rankTopItemViewHolder.a(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: j */
    public RankTopItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "959136457") ? (RankTopItemViewHolder) ipChange.ipc$dispatch("959136457", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new RankTopItemViewHolder();
    }

    public void k(String str, int i, List<HomePageRankBean.Content.RankLists> list, TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-122861859")) {
            ipChange.ipc$dispatch("-122861859", new Object[]{this, str, Integer.valueOf(i), list, trackInfo});
            return;
        }
        this.a = list;
        this.c = str;
        this.d = i;
        this.e = trackInfo;
        notifyDataSetChanged();
    }

    public void l(String str, int i, List<HomePageRankBean.Content.RankLists> list, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1751685246")) {
            ipChange.ipc$dispatch("1751685246", new Object[]{this, str, Integer.valueOf(i), list, jSONObject});
            return;
        }
        this.a = list;
        this.c = str;
        this.d = i;
        this.f = jSONObject;
        notifyDataSetChanged();
    }

    public void m(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-993691688")) {
            ipChange.ipc$dispatch("-993691688", new Object[]{this, str});
        } else {
            this.h = str;
        }
    }
}
