package cn.damai.tetris.component.music.mvp;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cn.damai.musicfestival.bean.CityMusicBean;
import cn.damai.musicfestival.bean.MusicDispatchBean;
import cn.damai.musicfestival.bean.MusicFestivalRes;
import cn.damai.musicfestival.bean.MusicIpBean;
import cn.damai.tetris.component.music.mvp.MusicFestivalContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.d23;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class MusicFestivalPresenter extends BasePresenter<MusicFestivalContract.Model, MusicFestivalView, BaseSection> implements MusicFestivalContract.Presenter<MusicFestivalContract.Model, MusicFestivalView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public MusicFestivalPresenter(MusicFestivalView musicFestivalView, String str, ja jaVar) {
        super(musicFestivalView, str, jaVar);
    }

    @Override // cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder.OnUtEventListener
    public void onCityClick(CityMusicBean cityMusicBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1513062044")) {
            ipChange.ipc$dispatch("1513062044", new Object[]{this, cityMusicBean});
            return;
        }
        HashMap<String, String> d = d23.d();
        d23.b(d, cityMusicBean.cityName);
        userTrackClick("city", d, false);
    }

    @Override // cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder.OnUtEventListener
    public void onFilterTabClick(MusicIpBean musicIpBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "880003938")) {
            ipChange.ipc$dispatch("880003938", new Object[]{this, musicIpBean});
            return;
        }
        HashMap<String, String> d = d23.d();
        d23.b(d, musicIpBean.musicIpName);
        userTrackClick("music_filter", d, false);
    }

    @Override // cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder.OnUtEventListener
    public void onHotFlipItemClick(MusicDispatchBean musicDispatchBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1138853601")) {
            ipChange.ipc$dispatch("-1138853601", new Object[]{this, musicDispatchBean});
            return;
        }
        HashMap<String, String> f = d23.f();
        d23.b(f, musicDispatchBean.title);
        d23.h(f, "item_id", musicDispatchBean.projectId);
        userTrackClick("more_item_" + musicDispatchBean.pos, f, true);
    }

    @Override // cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder.OnUtEventListener
    public void onHotFlipItemExpose(View view, MusicDispatchBean musicDispatchBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-693607541")) {
            ipChange.ipc$dispatch("-693607541", new Object[]{this, view, musicDispatchBean});
            return;
        }
        HashMap<String, String> f = d23.f();
        d23.b(f, musicDispatchBean.title);
        d23.h(f, "item_id", musicDispatchBean.projectId);
        userTrackExpose(view, "more_item_" + musicDispatchBean.pos, f, false);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-414440708")) {
            ipChange.ipc$dispatch("-414440708", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder.OnUtEventListener
    public void onOpenProjectClick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "604018417")) {
            ipChange.ipc$dispatch("604018417", new Object[]{this, str});
            return;
        }
        HashMap<String, String> f = d23.f();
        d23.h(f, "item_id", str);
        userTrackClick(TypedValues.Custom.S_FLOAT, f, true);
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(MusicFestivalContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1173542115")) {
            ipChange.ipc$dispatch("-1173542115", new Object[]{this, model});
            return;
        }
        ISection section = getSection();
        if (section != null) {
            Object extra = section.getExtra();
            if (extra instanceof MusicFestivalRes) {
                getView().setData((MusicFestivalRes) extra);
            }
        }
    }
}
