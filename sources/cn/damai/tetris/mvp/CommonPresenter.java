package cn.damai.tetris.mvp;

import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CommonPresenter extends BasePresenter<CommonContract$Model, CommonView, BaseSection> implements CommonContract$Presenter<CommonContract$Model, CommonView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    public ja mContext;
    public TrackInfo mTrackInfo;
    public CommonView mView;

    public CommonPresenter(CommonView commonView, String str, ja jaVar) {
        super(commonView, str, jaVar);
        this.mView = commonView;
        this.mContext = jaVar;
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "326161748")) {
            ipChange.ipc$dispatch("326161748", new Object[]{this, Integer.valueOf(i), obj});
        } else {
            getView().setMessage(i, obj);
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1524037873") ? ((Boolean) ipChange.ipc$dispatch("1524037873", new Object[]{this})).booleanValue() : getView().rebindAble();
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(CommonContract$Model commonContract$Model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1271501359")) {
            ipChange.ipc$dispatch("-1271501359", new Object[]{this, commonContract$Model});
            return;
        }
        this.mTrackInfo = commonContract$Model.getTrackInfo();
        getView().setCommonPresenter(this);
        getView().setData(commonContract$Model.getData(), getSection().getComponentId(), this.mTrackInfo);
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void rebindData(CommonContract$Model commonContract$Model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1421242137")) {
            ipChange.ipc$dispatch("-1421242137", new Object[]{this, commonContract$Model});
            return;
        }
        NodeData data = getModel().getData();
        getView();
        getView().rebindData(data);
    }
}
