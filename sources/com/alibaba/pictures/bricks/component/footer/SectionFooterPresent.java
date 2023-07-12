package com.alibaba.pictures.bricks.component.footer;

import android.view.View;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import com.alibaba.pictures.bricks.component.footer.SectionFooterContract;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.alient.onearch.adapter.ComponentTypeMapper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.EventHandler;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SectionFooterPresent extends AbsPresenter<IItem<ItemValue>, SectionFooterContract.Model<IItem<ItemValue>>, SectionFooterContract.View> implements SectionFooterContract.Presenter<IItem<ItemValue>, SectionFooterContract.Model<IItem<ItemValue>>> {
    private static transient /* synthetic */ IpChange $ipChange;
    protected int componentId;

    public SectionFooterPresent(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
    }

    @Override // com.alibaba.pictures.bricks.component.footer.SectionFooterContract.Presenter
    public void dispatchAction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "140170502")) {
            ipChange.ipc$dispatch("140170502", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        switch (this.componentId) {
            case 1000:
                hashMap.put("tabIndex", 1);
                userTrackClick("item_more", getTrackArgs(), false);
                break;
            case 1001:
                hashMap.put("tabIndex", 3);
                userTrackClick("artist_more", getTrackArgs(), false);
                break;
            case 1002:
                hashMap.put("tabIndex", 4);
                userTrackClick("ip_more", getTrackArgs(), false);
                break;
            case 1003:
                hashMap.put("tabIndex", 5);
                userTrackClick("venue_more", getTrackArgs(), false);
                break;
            case 1008:
                hashMap.put("tabIndex", 2);
                userTrackClick("scriptkill_store_more", getTrackArgs(), false);
                break;
            case 1009:
                hashMap.put("tabIndex", 2);
                userTrackClick("scriptkill_script_more", getTrackArgs(), false);
                break;
            case 1010:
                hashMap.put("tabIndex", 2);
                userTrackClick("scriptkill_coupon_more", getTrackArgs(), false);
                break;
        }
        this.item.getPageContext().getEventDispatcher().dispatchEvent("switch_search_result_tab", hashMap);
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-296339092")) {
            ipChange.ipc$dispatch("-296339092", new Object[]{this, iItem});
            return;
        }
        super.init(iItem);
        renderContentInView();
    }

    protected void renderContentInView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2040232761")) {
            ipChange.ipc$dispatch("-2040232761", new Object[]{this});
            return;
        }
        int convertComponentTypeToInt = ComponentTypeMapper.INSTANCE.convertComponentTypeToInt(((SectionFooterContract.Model) this.model).getComponentId());
        this.componentId = convertComponentTypeToInt;
        switch (convertComponentTypeToInt) {
            case 1000:
                ((SectionFooterContract.View) this.view).renderContent("查看全部演出");
                getTrackArgs().put("biz_type", "项目");
                userTrackExpose(((SectionFooterContract.View) this.view).getRenderView(), "item_more", getTrackArgs());
                return;
            case 1001:
                ((SectionFooterContract.View) this.view).renderContent("查看全部艺人");
                getTrackArgs().put("biz_type", ErrControlViewInfo.TYPE_ARTIST);
                userTrackExpose(((SectionFooterContract.View) this.view).getRenderView(), "artist_more", getTrackArgs());
                return;
            case 1002:
                ((SectionFooterContract.View) this.view).renderContent("查看全部品牌");
                getTrackArgs().put("biz_type", "品牌");
                userTrackExpose(((SectionFooterContract.View) this.view).getRenderView(), "ip_more", getTrackArgs());
                return;
            case 1003:
                ((SectionFooterContract.View) this.view).renderContent("查看全部场馆");
                getTrackArgs().put("biz_type", ErrControlViewInfo.TYPE_VENUE);
                userTrackExpose(((SectionFooterContract.View) this.view).getRenderView(), "venue_more", getTrackArgs());
                return;
            case 1004:
            case 1005:
            case 1006:
            case 1007:
            default:
                ((SectionFooterContract.View) this.view).renderContent("查看全部");
                return;
            case 1008:
                ((SectionFooterContract.View) this.view).renderContent("查看全部店铺");
                getTrackArgs().put("biz_type", "店铺");
                userTrackExpose(((SectionFooterContract.View) this.view).getRenderView(), "scriptkill_store_more", getTrackArgs());
                return;
            case 1009:
                ((SectionFooterContract.View) this.view).renderContent("查看全部剧本");
                getTrackArgs().put("biz_type", "剧本");
                userTrackExpose(((SectionFooterContract.View) this.view).getRenderView(), "scriptkill_more", getTrackArgs());
                return;
            case 1010:
                ((SectionFooterContract.View) this.view).renderContent("查看全部剧本杀券");
                getTrackArgs().put("biz_type", "团购券");
                userTrackExpose(((SectionFooterContract.View) this.view).getRenderView(), "scriptkill_coupon_more", getTrackArgs());
                return;
        }
    }
}
