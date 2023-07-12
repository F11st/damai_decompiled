package cn.damai.tetris.component.star.content.freetest;

import android.widget.GridView;
import android.widget.ListAdapter;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.star.content.freetest.ContentFreeTestContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ContentFreeTestPresenter extends BasePresenter<ContentFreeTestContract.Model, ContentFreeTestView, BaseSection> implements ContentFreeTestContract.Presenter<ContentFreeTestContract.Model, ContentFreeTestView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public ContentFreeTestPresenter(ContentFreeTestView contentFreeTestView, String str, ja jaVar) {
        super(contentFreeTestView, str, jaVar);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1813802738")) {
            ipChange.ipc$dispatch("-1813802738", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(ContentFreeTestContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-641264419")) {
            ipChange.ipc$dispatch("-641264419", new Object[]{this, model});
        } else {
            ((GridView) getView().getGridView().findViewById(R$id.tetris_star_grid_layout)).setAdapter((ListAdapter) new ContentFreeTestAdapter(getContext().getActivity(), model.getData()));
        }
    }
}
