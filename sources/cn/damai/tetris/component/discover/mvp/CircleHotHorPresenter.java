package cn.damai.tetris.component.discover.mvp;

import android.os.Bundle;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.discover.bean.CircleBean;
import cn.damai.commonbusiness.discover.bean.CircleListWrapBean;
import cn.damai.tetris.component.discover.mvp.CircleHotHorContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.ut.TrackType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.cs;
import tb.d23;
import tb.g41;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CircleHotHorPresenter extends BasePresenter<CircleHotHorModel, CircleHotHorView, BaseSection> implements CircleHotHorContract.Presenter<CircleHotHorModel, CircleHotHorView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public CircleHotHorPresenter(CircleHotHorView circleHotHorView, String str, ja jaVar) {
        super(circleHotHorView, str, jaVar);
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHotHorContract.Presenter
    public void exposeItem(View view, CircleBean circleBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "252073819")) {
            ipChange.ipc$dispatch("252073819", new Object[]{this, view, circleBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("titlelabel", "关注");
        f.put("index", i + "");
        f.put("id", circleBean.id);
        f.put("type", circleBean.type);
        TrackType trackType = TrackType.expose;
        userTrack(trackType, view, "live", "HotQuanzi", "ditem_" + i, f, false);
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHotHorContract.Presenter
    public void itemClick(CircleBean circleBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "16995887")) {
            ipChange.ipc$dispatch("16995887", new Object[]{this, circleBean, Integer.valueOf(i)});
            return;
        }
        ja context = getContext();
        if (context == null || context.getActivity() == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("themeId", circleBean.id);
        bundle.putString(g41.ISSUE_PARAM_LIVE_THEME_NAME, circleBean.name);
        DMNav.from(context.getActivity()).withExtras(bundle).toHost(cs.DISCOVER_CIRCLE_THEME_PAGE);
        HashMap<String, String> f = d23.f();
        f.put("titlelabel", "关注");
        f.put("index", i + "");
        f.put("quanziid", circleBean.id);
        f.put("type", "圈子");
        TrackType trackType = TrackType.click;
        userTrack(trackType, null, "live", "HotQuanzi", "ditem_" + i, f, true);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1906552629")) {
            ipChange.ipc$dispatch("-1906552629", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(CircleHotHorModel circleHotHorModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1510398221")) {
            ipChange.ipc$dispatch("-1510398221", new Object[]{this, circleHotHorModel});
            return;
        }
        CircleListWrapBean bean = circleHotHorModel.getBean();
        getView().setData(bean, bean.pos);
    }
}
