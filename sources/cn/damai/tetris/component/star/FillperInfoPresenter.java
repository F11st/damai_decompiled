package cn.damai.tetris.component.star;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.star.FillperInfoContract;
import cn.damai.tetris.component.star.bean.CombineFillperItems;
import cn.damai.tetris.component.star.bean.FillperItemBean;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.ek0;
import tb.ja;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FillperInfoPresenter extends BasePresenter<FillperInfoContract.Model, FillperInfoView, BaseSection> implements FillperInfoContract.Presenter<FillperInfoContract.Model, FillperInfoView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewFlipper mXunYanDynamicFlipper;
    private View mXunYanLayout;

    public FillperInfoPresenter(FillperInfoView fillperInfoView, String str, ja jaVar) {
        super(fillperInfoView, str, jaVar);
    }

    private ArrayList<CombineFillperItems> convert(List<FillperItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-420153963")) {
            return (ArrayList) ipChange.ipc$dispatch("-420153963", new Object[]{this, list});
        }
        ArrayList<CombineFillperItems> arrayList = new ArrayList<>();
        int size = list.size() / 3;
        for (int i = 0; i < size; i += 3) {
            CombineFillperItems combineFillperItems = new CombineFillperItems();
            combineFillperItems.itemBeans[0] = list.get(i);
            combineFillperItems.itemBeans[1] = list.get(i + 1);
            combineFillperItems.itemBeans[2] = list.get(i + 2);
            arrayList.add(combineFillperItems);
        }
        CombineFillperItems combineFillperItems2 = new CombineFillperItems();
        int i2 = size * 3;
        combineFillperItems2.itemBeans[0] = list.get(i2);
        if (list.size() % 3 == 2) {
            combineFillperItems2.itemBeans[1] = list.get(i2 + 1);
        }
        arrayList.add(combineFillperItems2);
        return arrayList;
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1510530230")) {
            ipChange.ipc$dispatch("-1510530230", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(FillperInfoContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896275901")) {
            ipChange.ipc$dispatch("1896275901", new Object[]{this, model});
            return;
        }
        ViewGroup fillperView = getView().getFillperView();
        this.mXunYanLayout = fillperView;
        this.mXunYanDynamicFlipper = (ViewFlipper) fillperView.findViewById(R$id.xunyan_dynamic_flipper);
        this.mXunYanLayout.findViewById(R$id.tv_xuxian3).setVisibility(8);
        if (!TextUtils.isEmpty(model.getStyleValue("title"))) {
            View view = this.mXunYanLayout;
            int i = R$id.xunyan_dynamic_flipper_title;
            view.findViewById(i).setVisibility(0);
            ((TextView) this.mXunYanLayout.findViewById(i)).setText(model.getStyleValue("title"));
        } else {
            this.mXunYanLayout.findViewById(R$id.xunyan_dynamic_flipper_title).setVisibility(8);
        }
        List<FillperItemBean> data = getModel().getData();
        new ArrayList();
        if (wh2.e(data) > 0) {
            this.mXunYanLayout.setVisibility(0);
            ArrayList<CombineFillperItems> convert = convert(data);
            for (int i2 = 0; i2 < convert.size(); i2++) {
                View inflate = LayoutInflater.from(getContext().getActivity()).inflate(R$layout.mine_starindex_xunyan_flipper_block, (ViewGroup) null);
                this.mXunYanDynamicFlipper.addView(inflate);
                new ek0(inflate).a(convert.get(i2));
            }
            if (data.size() < 3) {
                this.mXunYanDynamicFlipper.stopFlipping();
                return;
            }
            return;
        }
        this.mXunYanLayout.setVisibility(8);
    }
}
