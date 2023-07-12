package cn.damai.dramachannel.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.dramachannel.model.DramaCommingParams;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.componentplugin.OnErrClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.db;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DramaCommingFragment extends AbsFragmentV2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static DramaCommingFragment instance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-481876551") ? (DramaCommingFragment) ipChange.ipc$dispatch("-481876551", new Object[0]) : new DramaCommingFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "141176686")) {
            ipChange.ipc$dispatch("141176686", new Object[]{this});
            return;
        }
        startProgressDialog();
        TetrisRequest tetrisRequest = new TetrisRequest(new DramaCommingParams());
        tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) { // from class: cn.damai.dramachannel.fragment.DramaCommingFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.dramachannel.fragment.DramaCommingFragment$1$a */
            /* loaded from: classes5.dex */
            public class a implements OnErrClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                @Override // cn.damai.tetris.v2.componentplugin.OnErrClickListener
                public void onClick() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1643879708")) {
                        ipChange.ipc$dispatch("-1643879708", new Object[]{this});
                    } else {
                        DramaCommingFragment.this.loadPage();
                    }
                }
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1138647477")) {
                    ipChange2.ipc$dispatch("1138647477", new Object[]{this, str, str2});
                    return;
                }
                DramaCommingFragment.this.stopProgressDialog();
                DramaCommingFragment.this.showErrorViewV2(str, str2, new a());
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onSuccessWithWarning(BaseResponse baseResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1870306583")) {
                    ipChange2.ipc$dispatch("-1870306583", new Object[]{this, baseResponse});
                    return;
                }
                DramaCommingFragment.this.stopProgressDialog();
                DramaCommingFragment.this.hideErrorViewV2();
                DramaCommingFragment.this.setData(new db().e(baseResponse));
                DramaCommingFragment.this.updateB(baseResponse);
            }
        });
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1187583017")) {
            ipChange.ipc$dispatch("1187583017", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-502732960")) {
            ipChange.ipc$dispatch("-502732960", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "958348043")) {
            ipChange.ipc$dispatch("958348043", new Object[]{this});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1467123611")) {
            ipChange.ipc$dispatch("-1467123611", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        disableLoadMore();
        disableRefresh();
        enableDividerLine(false);
        loadPage();
    }
}
