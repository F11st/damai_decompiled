package cn.damai.tetris.component.discover.mvp;

import android.os.Bundle;
import cn.damai.tetris.component.discover.bean.ThemeBean;
import cn.damai.tetris.component.discover.mvp.BigThemeContract;
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
import tb.pb;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BigThemePresenter extends BasePresenter<BigThemeModel, BigThemeView, BaseSection> implements BigThemeContract.Presenter<BigThemeModel, BigThemeView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    public BigThemePresenter(BigThemeView bigThemeView, String str, ja jaVar) {
        super(bigThemeView, str, jaVar);
    }

    @Override // cn.damai.tetris.component.discover.mvp.BigThemeContract.Presenter
    public void itemClick(BigThemeContract.View view, ThemeBean themeBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1055842471")) {
            ipChange.ipc$dispatch("-1055842471", new Object[]{this, view, themeBean, Integer.valueOf(i)});
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
            NotePresenter.putMap("topic_id", themeBean.id, hashMap);
            NotePresenter.putMap("index", i + "", hashMap);
            NotePresenter.putMap("quanziid", getModel().getTrackInfo().getArgsMap().get(pb.CNT_CONTENT_ID), hashMap);
            NotePresenter.fillMap(false, this.mTrackInfo, hashMap, themeBean.getCardType(), themeBean.id);
            userTrack(TrackType.click, view.getRootView(), this.mTrackInfo.trackB, "recommend", "theme", hashMap, true);
        }
        Bundle bundle = new Bundle();
        bundle.putString("themeId", themeBean.id);
        NavProxy.from(context.getActivity()).withExtras(bundle).toUri(INavUri.page(cs.DISCOVER_THEME));
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1315070864")) {
            ipChange.ipc$dispatch("-1315070864", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(BigThemeModel bigThemeModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1231384275")) {
            ipChange.ipc$dispatch("1231384275", new Object[]{this, bigThemeModel});
            return;
        }
        this.mTrackInfo = bigThemeModel.getTrackInfo();
        ThemeBean bean = bigThemeModel.getBean();
        BigThemeView view = getView();
        view.setData(bean, bean.pos);
        if (NotePresenter.isTrackInfoValid(this.mTrackInfo)) {
            HashMap hashMap = new HashMap();
            if (this.mTrackInfo.getArgsMap() != null) {
                hashMap.putAll(this.mTrackInfo.getArgsMap());
            }
            NotePresenter.putMap("alg", bean.alg, hashMap);
            NotePresenter.fillMap(true, this.mTrackInfo, hashMap, bean.getCardType(), bean.id);
            userTrack(TrackType.expose, view.getRootView(), this.mTrackInfo.trackB, "recommend", "theme", hashMap, true);
        }
    }
}
