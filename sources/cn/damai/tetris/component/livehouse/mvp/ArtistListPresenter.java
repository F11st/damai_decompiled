package cn.damai.tetris.component.livehouse.mvp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.tetris.component.livehouse.bean.ArtistItemBean;
import cn.damai.tetris.component.livehouse.mvp.ArtistListContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.cs;
import tb.ja;
import tb.pb;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistListPresenter extends BasePresenter<ArtistListModel, ArtistListView, BaseSection> implements ArtistListContract.Presenter<ArtistListModel, ArtistListView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    public ArtistListView mView;

    public ArtistListPresenter(ArtistListView artistListView, String str, ja jaVar) {
        super(artistListView, str, jaVar);
        this.mView = artistListView;
    }

    @Override // cn.damai.tetris.component.livehouse.mvp.ArtistListContract.Presenter
    public void onArtistAvatarItemViewClick(ArtistListContract.View view, ArtistItemBean artistItemBean, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1894848867")) {
            ipChange.ipc$dispatch("1894848867", new Object[]{this, view, artistItemBean, Integer.valueOf(i), str});
            return;
        }
        HashMap hashMap = new HashMap();
        String d = z20.d();
        if (!TextUtils.isEmpty(d)) {
            hashMap.put("city", d);
        }
        hashMap.put("titlelabel", str);
        hashMap.put("artist_id", String.valueOf(artistItemBean.artistVo.damaiId));
        if (artistItemBean.artistVo.flag == 1) {
            Bundle bundle = new Bundle();
            bundle.putString(FeedsViewModel.ARG_USERID, artistItemBean.artistVo.damaiId);
            bundle.putString("usertype", "2");
            userTrackClick("artist_" + i, hashMap, true);
            DMNav.from(this.mContext.getActivity()).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
            return;
        }
        userTrackClick("artist_" + i, hashMap, false);
    }

    @Override // cn.damai.tetris.component.livehouse.mvp.ArtistListContract.Presenter
    public void onArtistAvatarItemViewExpose(View view, ArtistItemBean artistItemBean, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "150957226")) {
            ipChange.ipc$dispatch("150957226", new Object[]{this, view, artistItemBean, Integer.valueOf(i), str});
            return;
        }
        HashMap hashMap = new HashMap();
        String d = z20.d();
        if (!TextUtils.isEmpty(d)) {
            hashMap.put("city", d);
        }
        hashMap.put("titlelabel", str);
        hashMap.put("artist_id", String.valueOf(artistItemBean.artistVo.damaiId));
        userTrackExpose(view, "artist_" + i, hashMap, false);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        ArtistListView artistListView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529788723")) {
            ipChange.ipc$dispatch("-1529788723", new Object[]{this, Integer.valueOf(i), obj});
        } else if (getView() == null || (artistListView = this.mView) == null || i != 11003) {
        } else {
            artistListView.onCityFreshChanged();
        }
    }

    @Override // cn.damai.tetris.component.livehouse.mvp.ArtistListContract.Presenter
    public void userTrackClick(String str, int i, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "930119781")) {
            ipChange.ipc$dispatch("930119781", new Object[]{this, str, Integer.valueOf(i), str2, str3});
            return;
        }
        HashMap hashMap = new HashMap();
        String d = z20.d();
        if (!TextUtils.isEmpty(d)) {
            hashMap.put("city", d);
        }
        hashMap.put("titlelabel", str2);
        hashMap.put("artist_id", str);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("item_id", str3);
        }
        userTrackClick("item_" + i, hashMap, true);
    }

    @Override // cn.damai.tetris.component.livehouse.mvp.ArtistListContract.Presenter
    public void userTrackExpose(View view, int i, String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1742995857")) {
            ipChange.ipc$dispatch("-1742995857", new Object[]{this, view, Integer.valueOf(i), str, str2, str3, str4});
            return;
        }
        HashMap hashMap = new HashMap();
        String d = z20.d();
        if (!TextUtils.isEmpty(d)) {
            hashMap.put("city", d);
        }
        hashMap.put("titlelabel", str2);
        if (Integer.parseInt(str4) == 1) {
            hashMap.put("item_id", str);
        } else {
            hashMap.put(pb.PRE_CONTENT_ID, str);
            hashMap.put(pb.PRE_CONTENT_TYPE, "note");
        }
        hashMap.put("artist_id", str3);
        userTrackExpose(view, "item_" + i, hashMap, false);
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(ArtistListModel artistListModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1388237933")) {
            ipChange.ipc$dispatch("1388237933", new Object[]{this, artistListModel});
        } else {
            getView().setData(artistListModel.getBean(), 0);
        }
    }
}
