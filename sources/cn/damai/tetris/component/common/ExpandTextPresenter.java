package cn.damai.tetris.component.common;

import android.text.TextUtils;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.common.ExpandTextContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ExpandTextPresenter extends BasePresenter<ExpandTextContract.Model, ExpandTextContract.View, BaseSection> implements ExpandTextContract.Presenter<ExpandTextContract.Model, ExpandTextContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    public ExpandTextPresenter(ExpandTextView expandTextView, String str, ja jaVar) {
        super(expandTextView, str, jaVar);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1515908380")) {
            ipChange.ipc$dispatch("1515908380", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(ExpandTextContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-915169891")) {
            ipChange.ipc$dispatch("-915169891", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        if (!TextUtils.isEmpty(model.getStyleInfo().getString("title"))) {
            ((TextView) getView().getRootView().findViewById(R$id.common_exptext_title)).setText(model.getStyleInfo().getString("title"));
        }
        if (!TextUtils.isEmpty(getModel().getContent())) {
            getView().getContent().setVisibility(0);
            getView().getContent().setText(getModel().getContent());
            if ("收起".equals(getView().getExtBtn().getText())) {
                return;
            }
            getView().getContent().post(new Runnable() { // from class: cn.damai.tetris.component.common.ExpandTextPresenter.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1983713779")) {
                        ipChange2.ipc$dispatch("1983713779", new Object[]{this});
                    } else if (ExpandTextPresenter.this.getView() == null || ExpandTextPresenter.this.getView().getContent() == null || ExpandTextPresenter.this.getView().getContent().getLayout() == null) {
                    } else {
                        if (ExpandTextPresenter.this.getView().getContent().getLayout().getEllipsisCount(ExpandTextPresenter.this.getView().getContent().getLineCount() - 1) > 0) {
                            ExpandTextPresenter.this.getView().getExtBtn().setVisibility(0);
                        } else {
                            ExpandTextPresenter.this.getView().getExtBtn().setVisibility(8);
                        }
                    }
                }
            });
            return;
        }
        getView().getContent().setVisibility(8);
        getView().getExtBtn().setVisibility(8);
    }
}
