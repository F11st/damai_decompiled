package cn.damai.tetris.component.music.mvp;

import android.view.View;
import cn.damai.musicfestival.bean.CityMusicBean;
import cn.damai.musicfestival.bean.MusicDispatchBean;
import cn.damai.musicfestival.bean.MusicFestivalRes;
import cn.damai.musicfestival.bean.MusicIpBean;
import cn.damai.tetris.component.music.mvp.MusicFestivalContract;
import cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder;
import cn.damai.tetris.componentplugin.MusicFestivalEvent;
import cn.damai.tetris.core.AbsView;
import cn.damai.tetris.core.msg.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class MusicFestivalView extends AbsView<MusicFestivalContract.Presenter> implements MusicFestivalContract.View<MusicFestivalContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private MusicFestivalViewHolder mViewHolder;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements MusicFestivalViewHolder.OnUtEventListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder.OnUtEventListener
        public void onCityClick(CityMusicBean cityMusicBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-147642870")) {
                ipChange.ipc$dispatch("-147642870", new Object[]{this, cityMusicBean});
                return;
            }
            MusicFestivalContract.Presenter presenter = MusicFestivalView.this.getPresenter();
            if (presenter != null) {
                presenter.onCityClick(cityMusicBean);
            }
        }

        @Override // cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder.OnUtEventListener
        public void onFilterTabClick(MusicIpBean musicIpBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "548193588")) {
                ipChange.ipc$dispatch("548193588", new Object[]{this, musicIpBean});
                return;
            }
            MusicFestivalContract.Presenter presenter = MusicFestivalView.this.getPresenter();
            if (presenter != null) {
                presenter.onFilterTabClick(musicIpBean);
            }
        }

        @Override // cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder.OnUtEventListener
        public void onHotFlipItemClick(MusicDispatchBean musicDispatchBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "544309489")) {
                ipChange.ipc$dispatch("544309489", new Object[]{this, musicDispatchBean});
                return;
            }
            MusicFestivalContract.Presenter presenter = MusicFestivalView.this.getPresenter();
            if (presenter != null) {
                presenter.onHotFlipItemClick(musicDispatchBean);
            }
        }

        @Override // cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder.OnUtEventListener
        public void onHotFlipItemExpose(View view, MusicDispatchBean musicDispatchBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1470844509")) {
                ipChange.ipc$dispatch("1470844509", new Object[]{this, view, musicDispatchBean});
                return;
            }
            MusicFestivalContract.Presenter presenter = MusicFestivalView.this.getPresenter();
            if (presenter != null) {
                presenter.onHotFlipItemExpose(view, musicDispatchBean);
            }
        }

        @Override // cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder.OnUtEventListener
        public void onOpenProjectClick(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "174251487")) {
                ipChange.ipc$dispatch("174251487", new Object[]{this, str});
                return;
            }
            MusicFestivalContract.Presenter presenter = MusicFestivalView.this.getPresenter();
            if (presenter != null) {
                presenter.onOpenProjectClick(str);
            }
        }
    }

    public MusicFestivalView(View view) {
        super(view);
        this.mViewHolder = new MusicFestivalViewHolder(view, new a());
    }

    @Override // cn.damai.tetris.component.music.mvp.MusicFestivalContract.View
    public void setData(MusicFestivalRes musicFestivalRes) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1007354680")) {
            ipChange.ipc$dispatch("1007354680", new Object[]{this, musicFestivalRes});
            return;
        }
        this.mViewHolder.a(musicFestivalRes, 0);
        ja context = getContext();
        if (context != null) {
            xr.c(context.a(), new Message(1, new MusicFestivalEvent(this.mViewHolder.n())));
        }
    }
}
