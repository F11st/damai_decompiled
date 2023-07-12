package cn.damai.tetris.component.common;

import cn.damai.tetris.component.common.ActorAlbumContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ActorAlbumPresenter extends BasePresenter<ActorAlbumContract.Model, ActorAlbumContract.View, BaseSection> implements ActorAlbumContract.Presenter<ActorAlbumContract.Model, ActorAlbumContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    public ActorAlbumPresenter(ActorAlbumView actorAlbumView, String str, ja jaVar) {
        super(actorAlbumView, str, jaVar);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1917129897")) {
            ipChange.ipc$dispatch("1917129897", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(ActorAlbumContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1050402627")) {
            ipChange.ipc$dispatch("-1050402627", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        getView().initAblum(getModel().getActors());
    }
}
