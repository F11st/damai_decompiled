package cn.damai.tetris.component.music.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.common.image.C0504a;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.musicfestival.bean.MusicDispatchBean;
import cn.damai.uikit.banner.sub.RoundRadiusImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class MusicFlipHotItemPanel implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final int g = m62.a(mu0.a(), 26.0f);
    private final View a;
    private final TextView b;
    private final View c;
    private final RoundRadiusImageView d;
    private OnOneFlipperItemListener e;
    public MusicDispatchBean f;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnOneFlipperItemListener {
        void onIpIconClick(MusicFlipHotItemPanel musicFlipHotItemPanel, MusicDispatchBean musicDispatchBean);

        void onItemClick(MusicFlipHotItemPanel musicFlipHotItemPanel, MusicDispatchBean musicDispatchBean);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.music.viewholder.MusicFlipHotItemPanel$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1933a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1933a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "443252770")) {
                ipChange.ipc$dispatch("443252770", new Object[]{this, view});
                return;
            }
            OnOneFlipperItemListener onOneFlipperItemListener = MusicFlipHotItemPanel.this.e;
            MusicFlipHotItemPanel musicFlipHotItemPanel = MusicFlipHotItemPanel.this;
            onOneFlipperItemListener.onIpIconClick(musicFlipHotItemPanel, musicFlipHotItemPanel.f);
        }
    }

    public MusicFlipHotItemPanel(ViewGroup viewGroup, OnOneFlipperItemListener onOneFlipperItemListener) {
        this.e = onOneFlipperItemListener;
        View inflate = LayoutInflater.from(mu0.a()).inflate(R$layout.item_tetris_music_festival_hot, viewGroup, false);
        this.a = inflate;
        this.b = (TextView) inflate.findViewById(R$id.mfh_text);
        this.c = inflate.findViewById(R$id.mfh_text_layout);
        RoundRadiusImageView roundRadiusImageView = new RoundRadiusImageView(mu0.a());
        this.d = roundRadiusImageView;
        roundRadiusImageView.setRoundRadius(m62.a(mu0.a(), 13.0f));
        roundRadiusImageView.setOnClickListener(new View$OnClickListenerC1933a());
        inflate.setTag(this);
    }

    public void b(MusicDispatchBean musicDispatchBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-460224734")) {
            ipChange.ipc$dispatch("-460224734", new Object[]{this, musicDispatchBean});
        } else if (musicDispatchBean == null) {
        } else {
            this.f = musicDispatchBean;
            this.b.setText(musicDispatchBean.title);
            this.b.setOnClickListener(this);
            C0504a b = C0504a.b();
            String str = musicDispatchBean.picUrl;
            int i = g;
            b.f(str, i, i).g(this.d);
        }
    }

    public View c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-312510688") ? (View) ipChange.ipc$dispatch("-312510688", new Object[]{this}) : this.d;
    }

    public View d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2079928353") ? (View) ipChange.ipc$dispatch("-2079928353", new Object[]{this}) : this.c;
    }

    public View e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-602271718") ? (View) ipChange.ipc$dispatch("-602271718", new Object[]{this}) : this.a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1904301483")) {
            ipChange.ipc$dispatch("-1904301483", new Object[]{this, view});
        } else if (this.f != null && view.getId() == R$id.mfh_text) {
            this.e.onItemClick(this, this.f);
        }
    }
}
