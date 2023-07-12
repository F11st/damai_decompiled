package cn.damai.tetris.component.girl.mvp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.girl.bean.BannerBean;
import cn.damai.tetris.core.AbsView;
import cn.damai.uikit.irecycler.HorizontalRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.th2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BannerView extends AbsView<BannerContract$Presenter> implements BannerContract$View<BannerContract$Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private BannerAdapter mAdapter;
    private Context mContext;
    private HorizontalRecyclerView mGalleyView;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements OnItemBindListener<BannerBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, BannerBean bannerBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-520979095")) {
                ipChange.ipc$dispatch("-520979095", new Object[]{this, view, bannerBean, Integer.valueOf(i)});
            } else {
                BannerView.this.exposeItemView(view, bannerBean, i);
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(BannerBean bannerBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1659777506")) {
                ipChange.ipc$dispatch("-1659777506", new Object[]{this, bannerBean, Integer.valueOf(i)});
            }
        }
    }

    public BannerView(View view) {
        super(view);
        this.mGalleyView = (HorizontalRecyclerView) view.findViewById(R$id.hrv_galley);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        linearLayoutManager.setOrientation(0);
        this.mGalleyView.setLayoutManager(linearLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exposeItemView(View view, BannerBean bannerBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2141320265")) {
            ipChange.ipc$dispatch("-2141320265", new Object[]{this, view, bannerBean, Integer.valueOf(i)});
            return;
        }
        BannerContract$Presenter presenter = getPresenter();
        if (presenter != null) {
            presenter.exposeItemView(view, bannerBean, i);
        }
    }

    @Override // cn.damai.tetris.component.girl.mvp.BannerContract$View
    public void setAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "222957295")) {
            ipChange.ipc$dispatch("222957295", new Object[]{this});
            return;
        }
        Activity activity = getPresenter().getContext().getActivity();
        this.mContext = activity;
        BannerAdapter bannerAdapter = new BannerAdapter(activity, (BannerPresenter) getPresenter(), new a());
        this.mAdapter = bannerAdapter;
        this.mGalleyView.setAdapter(bannerAdapter);
    }

    @Override // cn.damai.tetris.component.girl.mvp.BannerContract$View
    public void setData(List<BannerBean> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-104973571")) {
            ipChange.ipc$dispatch("-104973571", new Object[]{this, list, str});
        } else if (th2.b(list) > 0) {
            this.mGalleyView.setVisibility(0);
            this.mAdapter.a(list, str);
        } else {
            this.mGalleyView.setVisibility(8);
        }
    }
}
