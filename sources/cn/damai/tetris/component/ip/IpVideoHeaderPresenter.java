package cn.damai.tetris.component.ip;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.ip.IpVideoHeaderContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;
import tb.pb;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IpVideoHeaderPresenter extends BasePresenter<IpVideoHeaderContract.Model, IpVideoHeaderContract.View, BaseSection> implements IpVideoHeaderContract.Presenter<IpVideoHeaderContract.Model, IpVideoHeaderContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    public IpVideoHeaderPresenter(IpVideoHeaderView ipVideoHeaderView, String str, ja jaVar) {
        super(ipVideoHeaderView, str, jaVar);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, final Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1166220676")) {
            ipChange.ipc$dispatch("-1166220676", new Object[]{this, Integer.valueOf(i), obj});
        } else if (getView() == null || getView().getManager() == null) {
        } else {
            if (i != 2000) {
                switch (i) {
                    case 11001:
                        if (obj instanceof Boolean) {
                            ((Boolean) obj).booleanValue();
                            return;
                        }
                        return;
                    case 11002:
                        getView().getRootView().postDelayed(new Runnable() { // from class: cn.damai.tetris.component.ip.IpVideoHeaderPresenter.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "957065363")) {
                                    ipChange2.ipc$dispatch("957065363", new Object[]{this});
                                    return;
                                }
                                ys.d().g();
                                IpVideoHeaderPresenter.this.getView().setMuteIcon(-1);
                            }
                        }, 500L);
                        return;
                    case 11003:
                        ys.d().f();
                        ys.d().n();
                        return;
                    case 11004:
                        ys.d().f();
                        getView().getManager().j();
                        return;
                    default:
                        return;
                }
            }
            final IpVideoHeaderContract.Model model = (IpVideoHeaderContract.Model) this.mModel;
            if (model.getVideoInfo() != null) {
                if (TextUtils.isEmpty(model.getVideoInfo().getVid()) && TextUtils.isEmpty(model.getVideoInfo().getVideoUrl())) {
                    return;
                }
                getView().getRootView().post(new Runnable() { // from class: cn.damai.tetris.component.ip.IpVideoHeaderPresenter.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "760551858")) {
                            ipChange2.ipc$dispatch("760551858", new Object[]{this});
                        } else {
                            IpVideoHeaderPresenter.this.getView().toogleAnim((RecyclerView) obj);
                        }
                    }
                });
                getView().getRootView().postDelayed(new Runnable() { // from class: cn.damai.tetris.component.ip.IpVideoHeaderPresenter.3
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "564038353")) {
                            ipChange2.ipc$dispatch("564038353", new Object[]{this});
                            return;
                        }
                        IpVideoHeaderPresenter.this.getView().hideTip();
                        IpVideoHeaderPresenter.this.getView().setVideoInfo(model.getVideoInfo());
                    }
                }, 500L);
            }
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(IpVideoHeaderContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-45634527")) {
            ipChange.ipc$dispatch("-45634527", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        if (model.getVideoInfo() == null) {
            getView().showTip();
            return;
        }
        View rootView = getView().getRootView();
        int i = R$id.cover_half_bottom;
        if (rootView.findViewById(i) != null) {
            if (getModel().getVideoInfo() != null && getModel().getTrackInfo() != null) {
                getModel().getTrackInfo().put(pb.PRE_CONTENT_ID, (Object) getModel().getVideoInfo().getVid());
                getModel().getTrackInfo().put(pb.PRE_CONTENT_TYPE, (Object) "video");
            }
            userTrackExpose(getView().getRootView().findViewById(i), "video");
        }
    }
}
