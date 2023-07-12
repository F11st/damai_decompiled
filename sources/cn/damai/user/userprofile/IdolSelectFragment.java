package cn.damai.user.userprofile;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.app.base.BaseFragment;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.user.userprofile.bean.IdolData;
import cn.damai.user.userprofile.bean.IdolSelectRequest;
import cn.damai.user.userprofile.bean.IdolSelectResponse;
import cn.damai.user.userprofile.bean.MyIdolSelectRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class IdolSelectFragment extends BaseFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    IdolListAdapter adapter;
    List<IdolData> idolData;
    int pageindex = 1;
    IRecyclerView recyclerView;
    String type;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.userprofile.IdolSelectFragment$a */
    /* loaded from: classes9.dex */
    public class C2742a implements OnLoadMoreListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2742a() {
        }

        @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
        public void onLoadMore(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1663853612")) {
                ipChange.ipc$dispatch("1663853612", new Object[]{this, view});
                return;
            }
            IdolSelectFragment idolSelectFragment = IdolSelectFragment.this;
            idolSelectFragment.pageindex++;
            idolSelectFragment.requestData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void requestData() {
        MyIdolSelectRequest myIdolSelectRequest;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "66352062")) {
            ipChange.ipc$dispatch("66352062", new Object[]{this});
            return;
        }
        if (!"1".equals(this.type)) {
            IdolSelectRequest idolSelectRequest = new IdolSelectRequest();
            idolSelectRequest.pageIndex = this.pageindex;
            idolSelectRequest.targetType = this.type;
            idolSelectRequest.targetId = z20.E();
            myIdolSelectRequest = idolSelectRequest;
        } else {
            MyIdolSelectRequest myIdolSelectRequest2 = new MyIdolSelectRequest();
            myIdolSelectRequest2.targetId = z20.E();
            myIdolSelectRequest2.pageIndex = this.pageindex;
            myIdolSelectRequest = myIdolSelectRequest2;
        }
        DMMtopRequestListener<IdolSelectResponse> dMMtopRequestListener = new DMMtopRequestListener<IdolSelectResponse>(IdolSelectResponse.class) { // from class: cn.damai.user.userprofile.IdolSelectFragment.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1689308632")) {
                    ipChange2.ipc$dispatch("1689308632", new Object[]{this, str, str2});
                    return;
                }
                IdolSelectFragment.this.stopProgressDialog();
                ToastUtil.i(str);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(IdolSelectResponse idolSelectResponse) {
                List<IdolData> list;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2111869826")) {
                    ipChange2.ipc$dispatch("2111869826", new Object[]{this, idolSelectResponse});
                    return;
                }
                IdolSelectFragment.this.stopProgressDialog();
                if (idolSelectResponse == null || (list = idolSelectResponse.circles) == null || list.size() <= 0) {
                    return;
                }
                IdolSelectFragment.this.adapter.a(idolSelectResponse.circles);
            }
        };
        startProgressDialog();
        myIdolSelectRequest.request(dMMtopRequestListener);
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-767903076") ? ((Integer) ipChange.ipc$dispatch("-767903076", new Object[]{this})).intValue() : R$layout.idol_select_list;
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1302207039")) {
            ipChange.ipc$dispatch("1302207039", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-776847106")) {
            ipChange.ipc$dispatch("-776847106", new Object[]{this});
            return;
        }
        IRecyclerView iRecyclerView = (IRecyclerView) this.rootView.findViewById(R$id.idol_list);
        this.recyclerView = iRecyclerView;
        iRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        IdolListAdapter idolListAdapter = new IdolListAdapter(getActivity());
        this.adapter = idolListAdapter;
        this.recyclerView.setAdapter(idolListAdapter);
        this.recyclerView.setLoadMoreEnabled(true);
        this.recyclerView.setOnLoadMoreListener(new C2742a());
        requestData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1337616228")) {
            ipChange.ipc$dispatch("1337616228", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-66300408")) {
            ipChange.ipc$dispatch("-66300408", new Object[]{this, Boolean.valueOf(z)});
        } else {
            super.onHiddenChanged(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-106020217")) {
            ipChange.ipc$dispatch("-106020217", new Object[]{this});
        } else {
            super.onResume();
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-116495979")) {
            ipChange.ipc$dispatch("-116495979", new Object[]{this, view, bundle});
        } else {
            super.onViewCreated(view, bundle);
        }
    }

    public void setType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "489156357")) {
            ipChange.ipc$dispatch("489156357", new Object[]{this, str});
        } else {
            this.type = str;
        }
    }
}
