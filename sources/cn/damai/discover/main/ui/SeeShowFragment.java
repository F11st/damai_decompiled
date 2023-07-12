package cn.damai.discover.main.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes5.dex */
public class SeeShowFragment extends Fragment implements OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private DamaiRootRecyclerView mRecyclerView;
    private View mView;

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1668430899")) {
            ipChange.ipc$dispatch("1668430899", new Object[]{this});
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "679463768")) {
            ipChange.ipc$dispatch("679463768", new Object[]{this});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = (DamaiRootRecyclerView) this.mView.findViewById(R$id.recycler_view);
        this.mRecyclerView = damaiRootRecyclerView;
        damaiRootRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1071568994")) {
            return (View) ipChange.ipc$dispatch("1071568994", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        this.mView = layoutInflater.inflate(R$layout.live_see_show_fragment, (ViewGroup) null);
        initView();
        initData();
        return this.mView;
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1073521857")) {
            ipChange.ipc$dispatch("-1073521857", new Object[]{this, view});
        }
    }

    public void request(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1673850542")) {
            ipChange.ipc$dispatch("1673850542", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
    }
}
