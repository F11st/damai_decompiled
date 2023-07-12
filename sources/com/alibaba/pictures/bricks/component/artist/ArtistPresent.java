package com.alibaba.pictures.bricks.component.artist;

import android.text.TextUtils;
import android.view.View;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import com.alibaba.pictures.bricks.component.artist.ArtistContract;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.EventHandler;
import java.util.Map;
import tb.w72;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistPresent extends AbsPresenter<IItem<ItemValue>, ArtistContract.Model<IItem<ItemValue>>, ArtistContract.View> implements ArtistContract.Presenter<IItem<ItemValue>, ArtistContract.Model<IItem<ItemValue>>> {
    private static transient /* synthetic */ IpChange $ipChange;

    public ArtistPresent(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
    }

    @Override // com.alibaba.pictures.bricks.onearch.AbsPresenter
    public Map<String, String> getTrackArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-787561350")) {
            return (Map) ipChange.ipc$dispatch("-787561350", new Object[]{this});
        }
        Map<String, String> trackArgs = super.getTrackArgs();
        trackArgs.put("biz_type", ErrControlViewInfo.TYPE_ARTIST);
        trackArgs.put("biz_id", ((ArtistContract.Model) this.model).getArtist().damaiId);
        return trackArgs;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.youku.arch.v3.DomainObject, com.youku.arch.v3.IItem] */
    @Override // com.alibaba.pictures.bricks.component.artist.ArtistContract.Presenter
    public void gotoHome() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "281474869")) {
            ipChange.ipc$dispatch("281474869", new Object[]{this});
            return;
        }
        userTrackClick(getTrackArgs(), true);
        Action action = new Action();
        action.setActionType(1);
        if (TextUtils.isEmpty(((ArtistContract.Model) this.model).getArtist().schema)) {
            action.setActionUrl("damai://V1/UserprofilePage?userType=2&userId=" + ((ArtistContract.Model) this.model).getArtist().damaiId);
        } else {
            action.setActionUrl(((ArtistContract.Model) this.model).getArtist().schema);
        }
        NavProviderProxy.getProxy().toUri(getItem().getPageContext().getActivity(), action);
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "931307467")) {
            ipChange.ipc$dispatch("931307467", new Object[]{this, iItem});
            return;
        }
        super.init(iItem);
        ((ArtistContract.View) this.view).renderArtistAvatar(((ArtistContract.Model) this.model).getArtist().headPic);
        ((ArtistContract.View) this.view).renderArtistName(((ArtistContract.Model) this.model).getArtist().name);
        try {
            i = Integer.parseInt(((ArtistContract.Model) this.model).getArtist().performanceCount);
        } catch (Exception unused) {
        }
        ((ArtistContract.View) this.view).renderPerformanceCount(i);
        if (!TextUtils.isEmpty(((ArtistContract.Model) this.model).getArtist().fansCount) && !"null".equals(((ArtistContract.Model) this.model).getArtist().fansCount)) {
            ((ArtistContract.View) this.view).renderFansCount(((ArtistContract.Model) this.model).getArtist().fansCount);
        } else {
            ((ArtistContract.View) this.view).renderFansCount("");
        }
        w72.a(this, ((ArtistContract.View) this.view).getRenderView());
        userTrackExpose(((ArtistContract.View) this.view).getRenderView(), getTrackArgs());
    }
}
