package cn.damai.tetris.component.discover.mvp;

import android.os.Bundle;
import android.view.View;
import cn.damai.tetris.component.discover.bean.ThemeBean;
import cn.damai.tetris.component.discover.mvp.ThemeContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.cs;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ThemePresenter extends BasePresenter<ThemeModel, ThemeView, BaseSection> implements ThemeContract.Presenter<ThemeModel, ThemeView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    public ThemePresenter(ThemeView themeView, String str, ja jaVar) {
        super(themeView, str, jaVar);
    }

    @Override // cn.damai.tetris.component.discover.mvp.ThemeContract.Presenter
    public void itemClick(ThemeContract.View view, ThemeBean themeBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "899900047")) {
            ipChange.ipc$dispatch("899900047", new Object[]{this, view, themeBean, Integer.valueOf(i)});
            return;
        }
        ja context = getContext();
        if (themeBean == null || context == null) {
            return;
        }
        if (NotePresenter.isTrackInfoValid(this.mTrackInfo)) {
            HashMap hashMap = new HashMap();
            if (this.mTrackInfo.getArgsMap() != null) {
                hashMap.putAll(this.mTrackInfo.getArgsMap());
            }
            NotePresenter.putMap("alg", themeBean.alg, hashMap);
            NotePresenter.fillMap(false, this.mTrackInfo, hashMap, themeBean.getCardType(), themeBean.id);
            TrackType trackType = TrackType.click;
            View rootView = view.getRootView();
            TrackInfo trackInfo = this.mTrackInfo;
            String str = trackInfo.trackB;
            String str2 = trackInfo.trackC;
            userTrack(trackType, rootView, str, str2, "card_" + i, hashMap, true);
        }
        Bundle bundle = new Bundle();
        bundle.putString("themeId", themeBean.id);
        NavProxy.from(context.getActivity()).withExtras(bundle).toUri(INavUri.page(cs.DISCOVER_THEME));
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-270295846")) {
            ipChange.ipc$dispatch("-270295846", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(ThemeModel themeModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "170638611")) {
            ipChange.ipc$dispatch("170638611", new Object[]{this, themeModel});
            return;
        }
        this.mTrackInfo = themeModel.getTrackInfo();
        ThemeBean bean = themeModel.getBean();
        ThemeView view = getView();
        view.setData(bean, bean.pos);
        if (NotePresenter.isTrackInfoValid(this.mTrackInfo)) {
            HashMap hashMap = new HashMap();
            if (this.mTrackInfo.getArgsMap() != null) {
                hashMap.putAll(this.mTrackInfo.getArgsMap());
            }
            NotePresenter.putMap("alg", bean.alg, hashMap);
            NotePresenter.fillMap(true, this.mTrackInfo, hashMap, bean.getCardType(), bean.id);
            TrackType trackType = TrackType.expose;
            View rootView = view.getRootView();
            TrackInfo trackInfo = this.mTrackInfo;
            String str = trackInfo.trackB;
            String str2 = trackInfo.trackC;
            userTrack(trackType, rootView, str, str2, "card_" + bean.pos, hashMap, true);
        }
    }
}
