package cn.damai.tetris.component.music.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.musicfestival.bean.MusicIpBean;
import cn.damai.uikit.image.IImageLoader;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;
import tb.m62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class MusicFestivalTabAdapter extends RecyclerView.Adapter<BaseViewHolderV2> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<MusicIpBean> a;
    private OnItemClickListener<MusicIpBean> b;
    private Object c = new Object();
    private int d = m62.a(mu0.a(), 16.0f);

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class MfTabVh extends BaseViewHolderV2<MusicIpBean> implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView c;
        private RoundImageView d;
        private View e;
        private int f;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.tetris.component.music.adapter.MusicFestivalTabAdapter$MfTabVh$a */
        /* loaded from: classes7.dex */
        public class C1924a implements IImageLoader.IImageSuccListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C1924a() {
            }

            @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
            public void onSuccess(IImageLoader.C2496b c2496b) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1495018969")) {
                    ipChange.ipc$dispatch("-1495018969", new Object[]{this, c2496b});
                } else {
                    MfTabVh.this.d.setImageDrawable(c2496b.a);
                }
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.tetris.component.music.adapter.MusicFestivalTabAdapter$MfTabVh$b */
        /* loaded from: classes7.dex */
        public class C1925b implements IImageLoader.IImageFailListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C1925b(MfTabVh mfTabVh) {
            }

            @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
            public void onFail(IImageLoader.C2495a c2495a) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1685652528")) {
                    ipChange.ipc$dispatch("-1685652528", new Object[]{this, c2495a});
                }
            }
        }

        public MfTabVh(View view) {
            super(view);
            view.setOnClickListener(this);
            this.d = (RoundImageView) view.findViewById(R$id.music_tab_icon);
            this.c = (TextView) view.findViewById(R$id.music_tab_name);
            this.e = view.findViewById(R$id.music_tab_border);
            this.f = Color.parseColor("#FF2869");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2
        /* renamed from: e */
        public void c(MusicIpBean musicIpBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1677696971")) {
                ipChange.ipc$dispatch("-1677696971", new Object[]{this, musicIpBean, Integer.valueOf(i)});
                return;
            }
            if (musicIpBean.isTabHighlight) {
                this.c.setTextColor(this.f);
                this.e.setBackgroundResource(R$drawable.bg_item_city_tab_ring);
            } else {
                this.c.setTextColor(-16777216);
                this.e.setBackgroundResource(R$drawable.bg_item_city_tab_ring_normal);
            }
            C0504a.b().load(musicIpBean.musicIpIcon, MusicFestivalTabAdapter.this.d, MusicFestivalTabAdapter.this.d, new C1924a(), new C1925b(this));
            this.c.setText(musicIpBean.musicIpName);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "105835480")) {
                ipChange.ipc$dispatch("105835480", new Object[]{this, view});
            } else if (this.a == 0 || MusicFestivalTabAdapter.this.b == null || ((MusicIpBean) this.a).isTabHighlight) {
            } else {
                MusicFestivalTabAdapter.this.b.onItemClick((MusicIpBean) this.a, this.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class PrefixVh extends BaseViewHolderV2<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        public PrefixVh(View view) {
            super(view);
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2
        protected void c(Object obj, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-367790072")) {
                ipChange.ipc$dispatch("-367790072", new Object[]{this, obj, Integer.valueOf(i)});
            }
        }
    }

    public MusicFestivalTabAdapter(OnItemClickListener<MusicIpBean> onItemClickListener) {
        this.b = onItemClickListener;
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-418834812")) {
            ipChange.ipc$dispatch("-418834812", new Object[]{this});
        } else if (!cb2.d(this.a)) {
            for (MusicIpBean musicIpBean : this.a) {
                musicIpBean.isTabHighlight = false;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(@NonNull BaseViewHolderV2 baseViewHolderV2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718310307")) {
            ipChange.ipc$dispatch("1718310307", new Object[]{this, baseViewHolderV2, Integer.valueOf(i)});
        } else if (i > 0) {
            baseViewHolderV2.a(this.a.get(i - 1), i);
        } else {
            baseViewHolderV2.a(this.c, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: e */
    public BaseViewHolderV2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "29441459")) {
            return (BaseViewHolderV2) ipChange.ipc$dispatch("29441459", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i == 17) {
            return new PrefixVh(LayoutInflater.from(mu0.a()).inflate(R$layout.item_city_music_festival_brand_prefix, viewGroup, false));
        }
        return new MfTabVh(LayoutInflater.from(mu0.a()).inflate(R$layout.item_city_music_festival_brand_tab, viewGroup, false));
    }

    public void f(List<MusicIpBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1403901147")) {
            ipChange.ipc$dispatch("-1403901147", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1689137354")) {
            return ((Integer) ipChange.ipc$dispatch("1689137354", new Object[]{this})).intValue();
        }
        List<MusicIpBean> list = this.a;
        if (list == null) {
            return 1;
        }
        return 1 + list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1330755185") ? ((Integer) ipChange.ipc$dispatch("1330755185", new Object[]{this, Integer.valueOf(i)})).intValue() : i == 0 ? 17 : 18;
    }
}
