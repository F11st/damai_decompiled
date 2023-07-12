package tb;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.musicfestival.adapter.OnMarkListener;
import cn.damai.musicfestival.bean.CityFilterBean;
import cn.damai.musicfestival.bean.CityMusicBean;
import cn.damai.musicfestival.bean.MusicIpBean;
import cn.damai.uikit.image.IImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.ai1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class jl1 extends ai1.a<CityMusicBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View d;
    private TextView e;
    private TextView f;
    private List<ViewGroup> g;
    private final int h;
    private OnMarkListener<CityMusicBean, CityFilterBean> i;
    private CityMusicBean j;
    private int k;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        a(jl1 jl1Var, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.b bVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1416839628")) {
                ipChange.ipc$dispatch("-1416839628", new Object[]{this, bVar});
            } else {
                this.a.setImageDrawable(bVar.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class b implements IImageLoader.IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b(jl1 jl1Var) {
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
        public void onFail(IImageLoader.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1545680285")) {
                ipChange.ipc$dispatch("1545680285", new Object[]{this, aVar});
            }
        }
    }

    public jl1(View view, OnMarkListener<CityMusicBean, CityFilterBean> onMarkListener) {
        super(view);
        this.g = new ArrayList();
        this.d = view.findViewById(R$id.mark_s1_layout_normal);
        this.g.add((ViewGroup) view.findViewById(R$id.mark_s1_img_1_ui));
        this.g.add((ViewGroup) view.findViewById(R$id.mark_s1_img_2_ui));
        this.g.add((ViewGroup) view.findViewById(R$id.mark_s1_img_3_ui));
        this.e = (TextView) view.findViewById(R$id.mark_s1_city_name);
        this.f = (TextView) view.findViewById(R$id.mark_s1_city_name_shining);
        this.h = m62.a(mu0.a(), 16.0f);
        this.i = onMarkListener;
    }

    @Override // tb.ai1.a
    /* renamed from: b */
    public void a(CityMusicBean cityMusicBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-93453646")) {
            ipChange.ipc$dispatch("-93453646", new Object[]{this, cityMusicBean, Integer.valueOf(i)});
            return;
        }
        this.j = cityMusicBean;
        this.k = i;
        this.d.setOnClickListener(this);
        this.e.setText(cityMusicBean.cityName);
        this.f.setText(cityMusicBean.cityName);
        List<MusicIpBean> list = cityMusicBean.musicIpInfos;
        if (TextUtils.isEmpty(cityMusicBean.shiningIpId)) {
            this.e.setVisibility(0);
            this.f.setVisibility(8);
        } else {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
        }
        for (int i2 = 0; i2 < 3; i2++) {
            ViewGroup viewGroup = this.g.get(i2);
            MusicIpBean musicIpBean = (MusicIpBean) cb2.b(list, i2);
            if (musicIpBean == null) {
                viewGroup.setVisibility(8);
            } else {
                viewGroup.setVisibility(0);
                View childAt = viewGroup.getChildAt(0);
                if (childAt instanceof ImageView) {
                    cn.damai.common.image.a b2 = cn.damai.common.image.a.b();
                    String str = musicIpBean.musicIpIcon;
                    int i3 = this.h;
                    b2.load(str, i3, i3, new a(this, (ImageView) childAt), new b(this));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CityMusicBean cityMusicBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-650652117")) {
            ipChange.ipc$dispatch("-650652117", new Object[]{this, view});
            return;
        }
        OnMarkListener<CityMusicBean, CityFilterBean> onMarkListener = this.i;
        if (onMarkListener == null || (cityMusicBean = this.j) == null) {
            return;
        }
        onMarkListener.onMarkClick(cityMusicBean, 1, this.k);
    }
}
