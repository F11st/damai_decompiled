package cn.damai.tetris.component.category;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.category.CategoryTitleContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.yr2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CategoryTitleView extends AbsView<CategoryTitleContract.Presenter> implements CategoryTitleContract.View<CategoryTitleContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private TextView mNearTv;
    private TextView mTipTv;

    public CategoryTitleView(View view) {
        super(view);
        this.mContext = view.getContext();
        this.mTipTv = (TextView) view.findViewById(R$id.tv_project_tip);
        this.mNearTv = (TextView) view.findViewById(R$id.tv_near_tip);
    }

    @Override // cn.damai.tetris.component.category.CategoryTitleContract.View
    public void setTip(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-107115593")) {
            ipChange.ipc$dispatch("-107115593", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        if (z2) {
            this.mTipTv.setPadding(0, yr2.a(this.mContext, 21.0f), 0, yr2.a(this.mContext, 48.0f));
        } else {
            this.mTipTv.setPadding(0, yr2.a(this.mContext, 48.0f), 0, yr2.a(this.mContext, 48.0f));
        }
        if (z) {
            this.mTipTv.setText("当前城市没有更多演出啦，看看附近城市吧(^з^)-☆");
            this.mNearTv.setPadding(0, 0, 0, 0);
            return;
        }
        this.mTipTv.setText("当前城市暂时没有演出，看看附近城市吧(^з^)-☆");
        this.mNearTv.setPadding(0, 0, 0, 0);
    }
}
