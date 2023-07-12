package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.common.image.C0504a;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.musicfestival.adapter.OnMarkListener;
import cn.damai.musicfestival.bean.CityFilterBean;
import cn.damai.musicfestival.bean.CityMusicBean;
import cn.damai.musicfestival.view.MusicFestivalMapView;
import cn.damai.uikit.image.IImageLoader;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.uplayer.AliMediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ai1 extends MusicFestivalMapView.AbstractC1484b<AbstractC8911a> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CLICK_TYPE_CLOSE = 2;
    public static final int CLICK_TYPE_ITEM = 1;
    private Context b;
    private int c;
    private OnMarkListener<CityMusicBean, CityFilterBean> d;
    private List e = new ArrayList();
    private boolean f;

    /* compiled from: Taobao */
    /* renamed from: tb.ai1$a */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC8911a<T> extends MusicFestivalMapView.C1487e {
        public AbstractC8911a(View view) {
            super(view);
        }

        public abstract void a(T t, int i);
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ai1$b */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC8912b extends AbstractC8911a<CityFilterBean> implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private RoundImageView d;
        private TextView e;
        private OnMarkListener<CityMusicBean, CityFilterBean> f;
        private CityFilterBean g;
        private int h;

        /* compiled from: Taobao */
        /* renamed from: tb.ai1$b$a */
        /* loaded from: classes6.dex */
        public class C8913a implements IImageLoader.IImageSuccListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C8913a() {
            }

            @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
            public void onSuccess(IImageLoader.C2496b c2496b) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-358501162")) {
                    ipChange.ipc$dispatch("-358501162", new Object[]{this, c2496b});
                } else {
                    View$OnClickListenerC8912b.this.d.setImageDrawable(c2496b.a);
                }
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.ai1$b$b */
        /* loaded from: classes6.dex */
        public class C8914b implements IImageLoader.IImageFailListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C8914b() {
            }

            @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
            public void onFail(IImageLoader.C2495a c2495a) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-246133313")) {
                    ipChange.ipc$dispatch("-246133313", new Object[]{this, c2495a});
                } else {
                    View$OnClickListenerC8912b.this.d.setImageDrawable(null);
                }
            }
        }

        public View$OnClickListenerC8912b(View view, OnMarkListener<CityMusicBean, CityFilterBean> onMarkListener) {
            super(view);
            this.d = (RoundImageView) view.findViewById(R$id.mark_s4_filter_icon);
            this.e = (TextView) view.findViewById(R$id.mark_s4_filter_title);
            this.f = onMarkListener;
        }

        @Override // tb.ai1.AbstractC8911a
        /* renamed from: c */
        public void a(CityFilterBean cityFilterBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-15072157")) {
                ipChange.ipc$dispatch("-15072157", new Object[]{this, cityFilterBean, Integer.valueOf(i)});
                return;
            }
            this.g = cityFilterBean;
            this.h = i;
            MusicFestivalMapView.MfmLayoutParams.setLocationAndZ(this.c.getLayoutParams(), cityFilterBean.xRatioInWidth, cityFilterBean.yRatioInHeight, 0, m62.a(mu0.a(), 10.0f));
            this.e.setText(cityFilterBean.title);
            C0504a.b().load(cityFilterBean.iconUrl, ai1.this.c, ai1.this.c, new C8913a(), new C8914b());
            this.c.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CityFilterBean cityFilterBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "516193097")) {
                ipChange.ipc$dispatch("516193097", new Object[]{this, view});
                return;
            }
            OnMarkListener<CityMusicBean, CityFilterBean> onMarkListener = this.f;
            if (onMarkListener == null || (cityFilterBean = this.g) == null) {
                return;
            }
            onMarkListener.onFilterClick(cityFilterBean, this.h);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ai1$c */
    /* loaded from: classes6.dex */
    public static class C8915c extends AbstractC8911a<CityMusicBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        private View d;
        private View e;
        private View f;
        private sg0 g;
        private jl1 h;
        private List<View> i;
        public CityMusicBean j;
        public int k;

        public C8915c(View view, OnMarkListener<CityMusicBean, CityFilterBean> onMarkListener) {
            super(view);
            this.i = new ArrayList();
            this.d = view.findViewById(R$id.mark_s1_layout_normal);
            this.e = view.findViewById(R$id.mark_s2_layout_highlight);
            this.f = view.findViewById(R$id.mark_s3_layout_point);
            this.i.add(this.d);
            this.i.add(this.e);
            this.i.add(this.f);
            this.g = new sg0(this.e, onMarkListener);
            this.h = new jl1(this.d, onMarkListener);
        }

        private void c(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "875077443")) {
                ipChange.ipc$dispatch("875077443", new Object[]{this, view});
                return;
            }
            for (View view2 : this.i) {
                if (view2 == view) {
                    view2.setVisibility(0);
                } else {
                    view2.setVisibility(8);
                }
            }
        }

        @Override // tb.ai1.AbstractC8911a
        /* renamed from: b */
        public void a(CityMusicBean cityMusicBean, int i) {
            int i2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-38313800")) {
                ipChange.ipc$dispatch("-38313800", new Object[]{this, cityMusicBean, Integer.valueOf(i)});
            } else if (cityMusicBean == null) {
            } else {
                this.j = cityMusicBean;
                this.k = i;
                if (cityMusicBean.isShowFull()) {
                    if (cityMusicBean.high) {
                        i2 = 100;
                        c(this.e);
                        this.g.a(cityMusicBean, i);
                        MusicFestivalMapView.MfmLayoutParams.setLocationAndZ(this.c.getLayoutParams(), cityMusicBean.getXRatioInWidth(), cityMusicBean.getYRatioInHeight(), i2, 0);
                    }
                    c(this.d);
                    this.h.a(cityMusicBean, i);
                } else {
                    c(this.f);
                }
                i2 = 0;
                MusicFestivalMapView.MfmLayoutParams.setLocationAndZ(this.c.getLayoutParams(), cityMusicBean.getXRatioInWidth(), cityMusicBean.getYRatioInHeight(), i2, 0);
            }
        }
    }

    public ai1(Context context, OnMarkListener<CityMusicBean, CityFilterBean> onMarkListener) {
        this.b = context;
        this.d = onMarkListener;
        this.c = m62.a(context, 16.0f);
    }

    @Override // cn.damai.musicfestival.view.MusicFestivalMapView.AbstractC1484b
    public int b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1305532109")) {
            return ((Integer) ipChange.ipc$dispatch("1305532109", new Object[]{this})).intValue();
        }
        List list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // cn.damai.musicfestival.view.MusicFestivalMapView.AbstractC1484b
    public int c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-86269196")) {
            return ((Integer) ipChange.ipc$dispatch("-86269196", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        Class<?> cls = this.e.get(i).getClass();
        if (cls == CityMusicBean.class) {
            return 136;
        }
        return cls == CityFilterBean.class ? AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX : super.c(i);
    }

    public boolean i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "610849388") ? ((Boolean) ipChange.ipc$dispatch("610849388", new Object[]{this})).booleanValue() : this.f;
    }

    @Override // cn.damai.musicfestival.view.MusicFestivalMapView.AbstractC1484b
    /* renamed from: j */
    public void f(@NonNull AbstractC8911a abstractC8911a, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845551376")) {
            ipChange.ipc$dispatch("1845551376", new Object[]{this, abstractC8911a, Integer.valueOf(i)});
        } else {
            abstractC8911a.a(this.e.get(i), i);
        }
    }

    @Override // cn.damai.musicfestival.view.MusicFestivalMapView.AbstractC1484b
    /* renamed from: k */
    public AbstractC8911a g(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-186175962")) {
            return (AbstractC8911a) ipChange.ipc$dispatch("-186175962", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i == 136) {
            return new C8915c(LayoutInflater.from(this.b).inflate(R$layout.item_city_map_mark, viewGroup, false), this.d);
        }
        if (i == 153) {
            return new View$OnClickListenerC8912b(LayoutInflater.from(this.b).inflate(R$layout.item_city_mark_filter_city, viewGroup, false), this.d);
        }
        return null;
    }

    public boolean l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1793556345")) {
            return ((Boolean) ipChange.ipc$dispatch("-1793556345", new Object[]{this})).booleanValue();
        }
        if (cb2.d(this.e)) {
            return false;
        }
        boolean z = false;
        for (Object obj : this.e) {
            if (obj instanceof CityMusicBean) {
                CityMusicBean cityMusicBean = (CityMusicBean) obj;
                if (cityMusicBean.isHighlight()) {
                    z = true;
                }
                cityMusicBean.high = false;
            }
        }
        return z;
    }

    public void m(List list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "495675752")) {
            ipChange.ipc$dispatch("495675752", new Object[]{this, list});
            return;
        }
        this.e.clear();
        if (!cb2.d(list)) {
            this.e.addAll(list);
            this.f = list.get(0) instanceof CityMusicBean;
        } else {
            this.f = false;
        }
        d();
    }
}
