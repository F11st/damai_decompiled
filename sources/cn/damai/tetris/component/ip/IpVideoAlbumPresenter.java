package cn.damai.tetris.component.ip;

import android.text.TextUtils;
import android.view.View;
import cn.damai.tetris.component.ip.IpVideoAlbumContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.uikit.nav.INav;
import cn.damai.uikit.nav.NavProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;
import tb.mg;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IpVideoAlbumPresenter extends BasePresenter<IpVideoAlbumContract.Model, IpVideoAlbumContract.View, BaseSection> implements IpVideoAlbumContract.Presenter<IpVideoAlbumContract.Model, IpVideoAlbumContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-786832379")) {
                ipChange.ipc$dispatch("-786832379", new Object[]{this, view});
                return;
            }
            String str = IpVideoAlbumPresenter.this.mTrackInfo.getArgsMap().get("repertoire_id");
            if (((BasePresenter) IpVideoAlbumPresenter.this).mContext.getActivity() == null || TextUtils.isEmpty(str)) {
                return;
            }
            INav from = NavProxy.from(((BasePresenter) IpVideoAlbumPresenter.this).mContext.getActivity());
            from.toUri(IpVideoAlbumPresenter.this.getModel().getVideoInfo().schema + str);
        }
    }

    public IpVideoAlbumPresenter(IpVideoAlbumView ipVideoAlbumView, String str, ja jaVar) {
        super(ipVideoAlbumView, str, jaVar);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1669252412")) {
            ipChange.ipc$dispatch("-1669252412", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(IpVideoAlbumContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1744448541")) {
            ipChange.ipc$dispatch("1744448541", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        if (getModel() == null || getModel().getVideoInfo() == null) {
            return;
        }
        getView().initAblum(getModel().getVideoInfo().getResult());
        if (getView().getTitle() != null) {
            mg title = getView().getTitle();
            if (!TextUtils.isEmpty(getModel().getStyleValue("title"))) {
                title.g(true);
                title.c(16);
                title.f(getModel().getStyleValue("title"));
                if (!TextUtils.isEmpty(getModel().getVideoInfo().schema)) {
                    title.d(true);
                    title.e("全部");
                    title.a(new a());
                } else {
                    title.d(false);
                }
                if (TextUtils.isEmpty(getModel().getVideoInfo().latestCount) || "0".equals(getModel().getVideoInfo().latestCount)) {
                    return;
                }
                title.b("• " + getModel().getVideoInfo().latestCount + "条更新");
                return;
            }
            title.g(false);
        }
    }
}
