package cn.damai.tetris.component.music.viewholder;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMImageStrategyConfig;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.musicfestival.adapter.OnMarkListener;
import cn.damai.musicfestival.bean.CityFilterBean;
import cn.damai.musicfestival.bean.CityMusicBean;
import cn.damai.musicfestival.bean.MusicDispatchBean;
import cn.damai.musicfestival.bean.MusicFestivalRes;
import cn.damai.musicfestival.bean.MusicIpBean;
import cn.damai.musicfestival.view.MusicFestivalMapView;
import cn.damai.tetris.component.music.adapter.MusicFestivalTabAdapter;
import cn.damai.tetris.component.music.viewholder.MusicFlipperPanel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.ai1;
import tb.cb2;
import tb.m62;
import tb.mu0;
import tb.qd2;
import tb.rm1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class MusicFestivalViewHolder extends BaseViewHolder<MusicFestivalRes> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private MusicFestivalMapView b;
    private ai1 c;
    private MusicFestivalTabAdapter d;
    private MusicFlipperPanel e;
    private OnUtEventListener f;
    private MusicFestivalRes g;
    private List<CityMusicBean> h;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnUtEventListener {
        void onCityClick(CityMusicBean cityMusicBean);

        void onFilterTabClick(MusicIpBean musicIpBean);

        void onHotFlipItemClick(MusicDispatchBean musicDispatchBean);

        void onHotFlipItemExpose(View view, MusicDispatchBean musicDispatchBean);

        void onOpenProjectClick(String str);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder$a */
    /* loaded from: classes7.dex */
    public class C1927a implements MusicFlipperPanel.OnHotFlipListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        C1927a(View view) {
            this.a = view;
        }

        @Override // cn.damai.tetris.component.music.viewholder.MusicFlipperPanel.OnHotFlipListener
        public void onFlipItemClick(MusicDispatchBean musicDispatchBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-491304788")) {
                ipChange.ipc$dispatch("-491304788", new Object[]{this, musicDispatchBean});
                return;
            }
            if (MusicFestivalViewHolder.this.f != null) {
                MusicFestivalViewHolder.this.f.onHotFlipItemClick(musicDispatchBean);
            }
            if (musicDispatchBean.isValidUrl()) {
                Context context = this.a.getContext();
                if (context != null) {
                    DMNav.from(context).toUri(musicDispatchBean.url);
                }
            } else if (musicDispatchBean.isValidProject()) {
                MusicFestivalViewHolder.this.o(musicDispatchBean.projectId, false);
            }
        }

        @Override // cn.damai.tetris.component.music.viewholder.MusicFlipperPanel.OnHotFlipListener
        public void onFlipItemExpose(View view, MusicDispatchBean musicDispatchBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1610803864")) {
                ipChange.ipc$dispatch("1610803864", new Object[]{this, view, musicDispatchBean});
            } else if (MusicFestivalViewHolder.this.f != null) {
                MusicFestivalViewHolder.this.f.onHotFlipItemExpose(view, musicDispatchBean);
            }
        }

        @Override // cn.damai.tetris.component.music.viewholder.MusicFlipperPanel.OnHotFlipListener
        public void onFlipTo(MusicDispatchBean musicDispatchBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1805171614")) {
                ipChange.ipc$dispatch("-1805171614", new Object[]{this, musicDispatchBean});
            } else if (MusicFestivalViewHolder.this.g != null && musicDispatchBean != null) {
                List<CityMusicBean> doShiningChangedEdit = musicDispatchBean.doShiningChangedEdit(MusicFestivalViewHolder.this.h, MusicFestivalViewHolder.this.g.musicIpInfos);
                if (cb2.d(doShiningChangedEdit)) {
                    return;
                }
                int childCount = MusicFestivalViewHolder.this.b.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = MusicFestivalViewHolder.this.b.getChildAt(i);
                    if (childAt != null) {
                        MusicFestivalMapView.C1487e viewHolder = MusicFestivalViewHolder.this.b.getViewHolder(childAt);
                        if (viewHolder instanceof ai1.C8915c) {
                            ai1.C8915c c8915c = (ai1.C8915c) viewHolder;
                            if (doShiningChangedEdit.contains(c8915c.j)) {
                                c8915c.a(c8915c.j, c8915c.k);
                            }
                        }
                    }
                }
            }
        }

        @Override // cn.damai.tetris.component.music.viewholder.MusicFlipperPanel.OnHotFlipListener
        public void onTextUiFlipperExpand() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1099721047")) {
                ipChange.ipc$dispatch("1099721047", new Object[]{this});
            } else if (MusicFestivalViewHolder.this.c.i()) {
                if (MusicFestivalViewHolder.this.c.l()) {
                    MusicFestivalViewHolder.this.c.d();
                }
            } else if (!cb2.d(MusicFestivalViewHolder.this.h)) {
                for (CityMusicBean cityMusicBean : MusicFestivalViewHolder.this.h) {
                    cityMusicBean.high = false;
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder$b */
    /* loaded from: classes7.dex */
    public class C1928b implements OnMarkListener<CityMusicBean, CityFilterBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1928b() {
        }

        @Override // cn.damai.musicfestival.adapter.OnMarkListener
        /* renamed from: a */
        public void onFilterClick(CityFilterBean cityFilterBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "591185866")) {
                ipChange.ipc$dispatch("591185866", new Object[]{this, cityFilterBean, Integer.valueOf(i)});
            } else {
                MusicFestivalViewHolder.this.o(cityFilterBean.projectId, true);
            }
        }

        @Override // cn.damai.musicfestival.adapter.OnMarkListener
        /* renamed from: b */
        public void onMarkClick(CityMusicBean cityMusicBean, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "649308005")) {
                ipChange.ipc$dispatch("649308005", new Object[]{this, cityMusicBean, Integer.valueOf(i), Integer.valueOf(i2)});
            } else if (i == 2) {
                cityMusicBean.high = false;
                MusicFestivalViewHolder.this.c.e(i2);
            } else if (i != 1 || cityMusicBean.high) {
            } else {
                boolean l = MusicFestivalViewHolder.this.c.l();
                cityMusicBean.high = true;
                if (l) {
                    MusicFestivalViewHolder.this.c.d();
                } else {
                    MusicFestivalViewHolder.this.c.e(i2);
                }
                MusicFestivalViewHolder.this.e.o();
                if (MusicFestivalViewHolder.this.f != null) {
                    MusicFestivalViewHolder.this.f.onCityClick(cityMusicBean);
                }
            }
        }

        @Override // cn.damai.musicfestival.adapter.OnMarkListener
        public void onExpandProjectClick(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1368466900")) {
                ipChange.ipc$dispatch("-1368466900", new Object[]{this, str});
            } else {
                MusicFestivalViewHolder.this.o(str, true);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder$c */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1929c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1929c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-596638212")) {
                ipChange.ipc$dispatch("-596638212", new Object[]{this, view});
            } else if (MusicFestivalViewHolder.this.c.l()) {
                MusicFestivalViewHolder.this.c.d();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder$d */
    /* loaded from: classes7.dex */
    public class C1930d implements OnItemClickListener<MusicIpBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1930d() {
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        /* renamed from: a */
        public void onEditClick(MusicIpBean musicIpBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2114443882")) {
                ipChange.ipc$dispatch("2114443882", new Object[]{this, musicIpBean, Integer.valueOf(i)});
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(MusicIpBean musicIpBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "703640371")) {
                ipChange.ipc$dispatch("703640371", new Object[]{this, musicIpBean, Integer.valueOf(i)});
                return;
            }
            MusicFestivalViewHolder.this.d.c();
            musicIpBean.isTabHighlight = true;
            MusicFestivalViewHolder.this.d.notifyDataSetChanged();
            MusicFestivalViewHolder.this.m(musicIpBean);
            if (MusicFestivalViewHolder.this.f != null) {
                MusicFestivalViewHolder.this.f.onFilterTabClick(musicIpBean);
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        public /* synthetic */ void onDnaClick(MusicIpBean musicIpBean, int i) {
            rm1.a(this, musicIpBean, i);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder$e */
    /* loaded from: classes7.dex */
    public class C1931e implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1931e(MusicFestivalViewHolder musicFestivalViewHolder) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1879551311")) {
                ipChange.ipc$dispatch("-1879551311", new Object[]{this, c0501d});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder$f */
    /* loaded from: classes7.dex */
    public class C1932f implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1932f() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "407223174")) {
                ipChange.ipc$dispatch("407223174", new Object[]{this, c0502e});
            } else {
                MusicFestivalViewHolder.this.b.setBackground(c0502e.a);
            }
        }
    }

    public MusicFestivalViewHolder(View view, OnUtEventListener onUtEventListener) {
        super(view);
        this.f = onUtEventListener;
        this.b = (MusicFestivalMapView) view.findViewById(R$id.music_festival_map_view);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.music_festival_map_tab_list);
        this.a = (TextView) view.findViewById(R$id.music_festival_map_tip);
        this.e = new MusicFlipperPanel((ViewGroup) view.findViewById(R$id.music_festival_hot_vf_ui), (ViewFlipper) view.findViewById(R$id.music_festival_vf), (ViewFlipper) view.findViewById(R$id.music_icon_vf), new C1927a(view));
        this.c = new ai1(mu0.a(), new C1928b());
        this.b.setOnClickListener(new View$OnClickListenerC1929c());
        this.b.setAdapter(this.c);
        final int a = m62.a(mu0.a(), 12.0f);
        final int a2 = m62.a(mu0.a(), 9.0f);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView2, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1218391745")) {
                    ipChange.ipc$dispatch("1218391745", new Object[]{this, rect, view2, recyclerView2, state});
                    return;
                }
                int childAdapterPosition = recyclerView2.getChildAdapterPosition(view2);
                boolean z = childAdapterPosition == 0;
                boolean z2 = childAdapterPosition == MusicFestivalViewHolder.this.d.getItemCount() - 1;
                rect.left = z ? a : 0;
                rect.right = z2 ? a : a2;
                if (!z || z2) {
                    return;
                }
                rect.right = 0;
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(mu0.a(), 0, false));
        MusicFestivalTabAdapter musicFestivalTabAdapter = new MusicFestivalTabAdapter(new C1930d());
        this.d = musicFestivalTabAdapter;
        recyclerView.setAdapter(musicFestivalTabAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(MusicIpBean musicIpBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-249904844")) {
            ipChange.ipc$dispatch("-249904844", new Object[]{this, musicIpBean});
            return;
        }
        MusicFestivalRes musicFestivalRes = this.g;
        if (musicFestivalRes == null || musicIpBean == null) {
            return;
        }
        if (musicIpBean.all) {
            this.c.m(this.h);
        } else {
            this.c.m(CityFilterBean.composeFilterBeanList(musicIpBean, musicFestivalRes.cityBaseInfos));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, boolean z) {
        Context context;
        OnUtEventListener onUtEventListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1480103539")) {
            ipChange.ipc$dispatch("-1480103539", new Object[]{this, str, Boolean.valueOf(z)});
        } else if (TextUtils.isEmpty(str) || (context = this.itemView.getContext()) == null) {
        } else {
            if (z && (onUtEventListener = this.f) != null) {
                onUtEventListener.onOpenProjectClick(str);
            }
            qd2.b(context, null, str, null, null);
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
    /* renamed from: l */
    public void a(MusicFestivalRes musicFestivalRes, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1071613007")) {
            ipChange.ipc$dispatch("1071613007", new Object[]{this, musicFestivalRes, Integer.valueOf(i)});
        } else if (this.g == musicFestivalRes) {
        } else {
            this.g = musicFestivalRes;
            this.a.setText(musicFestivalRes.tips);
            this.d.f(musicFestivalRes.musicIpInfos);
            List<CityMusicBean> cityMusicListInAllMode = musicFestivalRes.getCityMusicListInAllMode();
            this.h = cityMusicListInAllMode;
            this.c.m(cityMusicListInAllMode);
            this.e.l(musicFestivalRes.musicDispatchInfos);
            if (musicFestivalRes.bgInfo != null) {
                DisplayMetrics b = m62.b(mu0.a());
                DMImageStrategyConfig dMImageStrategyConfig = new DMImageStrategyConfig();
                dMImageStrategyConfig.a = false;
                dMImageStrategyConfig.g = m62.a(mu0.a(), 270.0f);
                dMImageStrategyConfig.h = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(b);
                C0504a.b().d(musicFestivalRes.bgInfo.mapUrl, dMImageStrategyConfig).n(new C1932f()).e(new C1931e(this)).f();
            }
        }
    }

    public MusicFestivalMapView n() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "507210707") ? (MusicFestivalMapView) ipChange.ipc$dispatch("507210707", new Object[]{this}) : this.b;
    }
}
