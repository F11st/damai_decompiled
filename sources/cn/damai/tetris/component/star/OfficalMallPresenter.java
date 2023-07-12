package cn.damai.tetris.component.star;

import cn.damai.tetris.component.star.OfficalMallContract;
import cn.damai.tetris.component.star.officalMall.ProductShopDelegate;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class OfficalMallPresenter extends BasePresenter<OfficalMallContract.Model, OfficalMallView, BaseSection> implements OfficalMallContract.Presenter<OfficalMallContract.Model, OfficalMallView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public OfficalMallPresenter(OfficalMallView officalMallView, String str, ja jaVar) {
        super(officalMallView, str, jaVar);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "786146026")) {
            ipChange.ipc$dispatch("786146026", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(OfficalMallContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1699201283")) {
            ipChange.ipc$dispatch("-1699201283", new Object[]{this, model});
            return;
        }
        model.getData().title = model.getStyleValue("title");
        new ProductShopDelegate(model.getData(), this).a(getView().getMallView(), getContext().getActivity());
    }
}
