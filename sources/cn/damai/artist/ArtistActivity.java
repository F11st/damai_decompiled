package cn.damai.artist;

import android.os.Bundle;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.alibaba.pictures.bricks.artist.ArtistFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ArtistActivity<T extends a<?, ?>, E extends BaseModel> extends DamaiBaseActivity<T, E> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2138577312")) {
            ipChange.ipc$dispatch("2138577312", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1922749514") ? ((Integer) ipChange.ipc$dispatch("1922749514", new Object[]{this})).intValue() : R$layout.activity_artist;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1908661361")) {
            ipChange.ipc$dispatch("1908661361", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "409821146")) {
            ipChange.ipc$dispatch("409821146", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-724654461")) {
            ipChange.ipc$dispatch("-724654461", new Object[]{this});
            return;
        }
        c.e().K(this);
        removeHeadTitleView();
        ArtistFragment artistFragment = new ArtistFragment();
        Bundle bundle = new Bundle();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            bundle.putAll(extras);
        }
        artistFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R$id.fragment_container, artistFragment).commitAllowingStateLoss();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    @NotNull
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1154059970") ? (String) ipChange.ipc$dispatch("-1154059970", new Object[]{this}) : "";
    }
}
