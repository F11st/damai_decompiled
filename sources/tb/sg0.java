package tb;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.musicfestival.adapter.OnMarkListener;
import cn.damai.musicfestival.bean.CityFilterBean;
import cn.damai.musicfestival.bean.CityMusicBean;
import cn.damai.musicfestival.bean.MusicIpBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.ai1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class sg0 extends ai1.AbstractC8911a<CityMusicBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View d;
    private TextView e;
    private View f;
    private List<View> g;
    private OnMarkListener<CityMusicBean, CityFilterBean> h;
    private CityMusicBean i;
    private int j;

    public sg0(View view, OnMarkListener<CityMusicBean, CityFilterBean> onMarkListener) {
        super(view);
        this.g = new ArrayList();
        this.d = view.findViewById(R$id.mark_s2_layout_highlight);
        this.e = (TextView) view.findViewById(R$id.mark_s2_city_name);
        View findViewById = view.findViewById(R$id.mark_s2_show_layout_1);
        View findViewById2 = view.findViewById(R$id.mark_s2_show_layout_2);
        View findViewById3 = view.findViewById(R$id.mark_s2_show_layout_3);
        this.f = view.findViewById(R$id.mark_s2_close);
        this.g.add(findViewById);
        this.g.add(findViewById2);
        this.g.add(findViewById3);
        this.h = onMarkListener;
    }

    private String c(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1603783552")) {
            return (String) ipChange.ipc$dispatch("1603783552", new Object[]{this, str, str2, str3});
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        return sb.toString();
    }

    @Override // tb.ai1.AbstractC8911a
    /* renamed from: b */
    public void a(CityMusicBean cityMusicBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-978233888")) {
            ipChange.ipc$dispatch("-978233888", new Object[]{this, cityMusicBean, Integer.valueOf(i)});
            return;
        }
        this.i = cityMusicBean;
        this.j = i;
        this.f.setOnClickListener(this);
        this.e.setText(cityMusicBean.cityName);
        List<MusicIpBean> list = cityMusicBean.musicIpInfos;
        for (int i2 = 0; i2 < 3; i2++) {
            View view = this.g.get(i2);
            MusicIpBean musicIpBean = (MusicIpBean) cb2.b(list, i2);
            if (musicIpBean == null) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
                ((TextView) view.findViewById(R$id.item_city_music_p_time)).setText(c(musicIpBean.showTime, musicIpBean.musicIpShortName, " "));
                view.setOnClickListener(this);
                view.setTag(musicIpBean);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1475200729")) {
            ipChange.ipc$dispatch("1475200729", new Object[]{this, view});
        } else if (this.h == null || this.i == null) {
        } else {
            int id = view.getId();
            if (id == R$id.mark_s2_close) {
                this.h.onMarkClick(this.i, 2, this.j);
            } else if (id == R$id.mark_s2_show_layout_1 || id == R$id.mark_s2_show_layout_2 || id == R$id.mark_s2_show_layout_3) {
                Object tag = view.getTag();
                if (tag instanceof MusicIpBean) {
                    MusicIpBean musicIpBean = (MusicIpBean) tag;
                    if (cb2.d(musicIpBean.projects)) {
                        return;
                    }
                    this.h.onExpandProjectClick(musicIpBean.projects.get(0).projectId);
                }
            }
        }
    }
}
