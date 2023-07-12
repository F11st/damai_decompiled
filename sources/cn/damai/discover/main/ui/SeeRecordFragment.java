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
public class SeeRecordFragment extends Fragment implements OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private DamaiRootRecyclerView mRecyclerView;
    private View mView;

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1176077113")) {
            ipChange.ipc$dispatch("-1176077113", new Object[]{this});
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2129923052")) {
            ipChange.ipc$dispatch("2129923052", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "201342454")) {
            return (View) ipChange.ipc$dispatch("201342454", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        this.mView = layoutInflater.inflate(R$layout.live_see_record_fragment, (ViewGroup) null);
        initView();
        initData();
        return this.mView;
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-301531349")) {
            ipChange.ipc$dispatch("-301531349", new Object[]{this, view});
        }
    }

    public void request(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-606551910")) {
            ipChange.ipc$dispatch("-606551910", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
    }
}
