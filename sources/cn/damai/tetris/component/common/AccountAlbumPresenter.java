package cn.damai.tetris.component.common;

import android.text.TextUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.tetris.component.common.AccountAlbumContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cb2;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class AccountAlbumPresenter extends BasePresenter<AccountAlbumContract.Model, AccountAlbumContract.View, BaseSection> implements AccountAlbumContract.Presenter<AccountAlbumContract.Model, AccountAlbumContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    public AccountAlbumPresenter(AccountAlbumView accountAlbumView, String str, ja jaVar) {
        super(accountAlbumView, str, jaVar);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1934113887")) {
            ipChange.ipc$dispatch("-1934113887", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2125320318")) {
            return ((Boolean) ipChange.ipc$dispatch("2125320318", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(AccountAlbumContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2027340157")) {
            ipChange.ipc$dispatch("2027340157", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        if (cb2.d(model.getAccounts())) {
            return;
        }
        if (model.getStyleInfo() != null && !TextUtils.isEmpty(model.getStyleInfo().getString("title"))) {
            getView().getTitle().setText(model.getStyleInfo().getString("title"));
        }
        getView().getRecycleView().setVisibility(0);
        getView().getRecycleView().setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext.getActivity());
        linearLayoutManager.setOrientation(0);
        getView().getRecycleView().setLayoutManager(linearLayoutManager);
        getView().getRecycleView().setAdapter(new AccountAlbumAdapter(this.mContext.getActivity(), model.getAccounts(), this));
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void rebindData(AccountAlbumContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "657997927")) {
            ipChange.ipc$dispatch("657997927", new Object[]{this, model});
        } else {
            super.rebindData((AccountAlbumPresenter) model);
        }
    }
}
