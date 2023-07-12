package com.alibaba.pictures.bricks.component.ipbrand;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract;
import com.alibaba.pictures.bricks.onearch.AbsModel;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.EventHandler;
import java.util.HashMap;
import java.util.Map;
import tb.w72;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IpDramaBrandPresent extends AbsPresenter<IItem<ItemValue>, IpDramaBrandContract.Model<IItem<ItemValue>>, IpDramaBrandContract.View> implements IpDramaBrandContract.Presenter<IItem<ItemValue>, IpDramaBrandContract.Model<IItem<ItemValue>>> {
    private static transient /* synthetic */ IpChange $ipChange;

    public IpDramaBrandPresent(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
    }

    private String dName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1102211409")) {
            return (String) ipChange.ipc$dispatch("1102211409", new Object[]{this});
        }
        if ("brand".equals(((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().getIpBrandType())) {
            return "brand_card_" + this.item.getIndex();
        } else if ("music_festival".equals(((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().getIpBrandType())) {
            return "musicip_card_" + this.item.getIndex();
        } else {
            return "repertoire_card_" + this.item.getIndex();
        }
    }

    private void typeMap(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1145205079")) {
            ipChange.ipc$dispatch("-1145205079", new Object[]{this, map});
            return;
        }
        if ("brand".equals(((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().getIpBrandType())) {
            map.put("biz_type", "品牌");
        } else if ("music_festival".equals(((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().getIpBrandType())) {
            map.put("biz_type", "音乐节");
        } else {
            map.put("biz_type", "剧目");
        }
        map.put("biz_id", ((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().damaiId);
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract.Presenter
    public void artistTrackClick(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1075541775")) {
            ipChange.ipc$dispatch("-1075541775", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(getTrackArgsTemp());
        hashMap.put("artist_id", str);
        userTrackClick(((AbsModel) this.model).getCompatTrackInfo().getSpmc() + JSMethod.NOT_SET + this.item.getIndex(), "artist_" + i, hashMap, true);
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract.Presenter
    public void artistTrackExpose(View view, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1974297379")) {
            ipChange.ipc$dispatch("-1974297379", new Object[]{this, view, str, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(getTrackArgsTemp());
        hashMap.put("artist_id", str);
        userTrackExpose(view, ((AbsModel) this.model).getCompatTrackInfo().getSpmc() + JSMethod.NOT_SET + this.item.getIndex(), "artist_" + i, hashMap);
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract.Presenter
    public void contentTrackClick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1957391570")) {
            ipChange.ipc$dispatch("1957391570", new Object[]{this, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(getTrackArgsTemp());
        hashMap.put("content_id", str);
        userTrackClick(((AbsModel) this.model).getCompatTrackInfo().getSpmc() + JSMethod.NOT_SET + this.item.getIndex(), "content_0", hashMap, true);
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract.Presenter
    public void contentTrackExpose(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1987678400")) {
            ipChange.ipc$dispatch("1987678400", new Object[]{this, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(getTrackArgsTemp());
        hashMap.put("content_id", str);
        RelativeLayout contentLayout = ((IpDramaBrandContract.View) this.view).getContentLayout();
        userTrackExpose(contentLayout, ((AbsModel) this.model).getCompatTrackInfo().getSpmc() + JSMethod.NOT_SET + this.item.getIndex(), "content_0", hashMap);
    }

    public Map<String, String> getTrackArgsTemp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "450589083")) {
            return (Map) ipChange.ipc$dispatch("450589083", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(getTrackArgs());
        typeMap(hashMap);
        return hashMap;
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract.Presenter
    public void gotoIpDramaBrandPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "47364595")) {
            ipChange.ipc$dispatch("47364595", new Object[]{this});
        } else if (((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean() == null || this.item.getPageContext() == null || this.item.getPageContext().getActivity() == null || TextUtils.isEmpty(((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().schema)) {
        } else {
            userTrackClick(dName(), getTrackArgsTemp(), true);
            Action action = new Action();
            action.setActionType(1);
            action.setActionUrl(((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().schema);
            NavProviderProxy.getProxy().toUri(this.item.getPageContext().getActivity(), action);
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-221072746")) {
            ipChange.ipc$dispatch("-221072746", new Object[]{this, iItem});
            return;
        }
        super.init(iItem);
        if (((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean() == null) {
            return;
        }
        if ((iItem.getPageContext().getFragment() instanceof ITab) && !TextUtils.isEmpty(((ITab) iItem.getPageContext().getFragment()).getTabTitle())) {
            ((IpDramaBrandContract.View) this.view).setBottomLine(!"全部".equals(((ITab) iItem.getPageContext().getFragment()).getTabTitle()));
        }
        ((IpDramaBrandContract.View) this.view).ipBrandLeftView(((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().getIpBrandType(), ((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().headPic, ((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().isShowVTag());
        ((IpDramaBrandContract.View) this.view).ipBrandRightView(((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().getIpBrandType(), ((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().score);
        ((IpDramaBrandContract.View) this.view).ipBrandCenterView(((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean());
        ((IpDramaBrandContract.View) this.view).informationView(((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().getIpBrandType(), ((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().contentList);
        ((IpDramaBrandContract.View) this.view).artistView(((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().getIpBrandType(), ((IpDramaBrandContract.Model) this.model).getIpDramaBrandArchBean().artistList);
        userTrackExpose(((IpDramaBrandContract.View) this.view).getTopLayout(), dName(), getTrackArgsTemp());
        w72.a(this, ((IpDramaBrandContract.View) this.view).getRenderView());
    }
}
