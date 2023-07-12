package com.alibaba.pictures.bricks.component.script.more;

import android.view.View;
import com.alibaba.pictures.bricks.component.footer.SectionFooterPresent;
import com.alient.onearch.adapter.ComponentTypeMapper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.event.EventHandler;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ScriptFooterPresent extends SectionFooterPresent {
    private static transient /* synthetic */ IpChange $ipChange;

    public ScriptFooterPresent(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
    }

    @Override // com.alibaba.pictures.bricks.component.footer.SectionFooterPresent, com.alibaba.pictures.bricks.component.footer.SectionFooterContract.Presenter
    public void dispatchAction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "556380342")) {
            ipChange.ipc$dispatch("556380342", new Object[]{this});
            return;
        }
        switch (this.componentId) {
            case 1008:
                getTrackArgs().put("biz_type", "店铺");
                userTrackClick("scriptkill_store_more", getTrackArgs(), false);
                break;
            case 1009:
                getTrackArgs().put("biz_type", "剧本");
                userTrackClick("scriptkill_more", getTrackArgs(), false);
                break;
            case 1010:
                getTrackArgs().put("biz_type", "团购券");
                userTrackClick("scriptkill_coupon_more", getTrackArgs(), false);
                break;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("componentId", Integer.valueOf(this.componentId));
        if (this.item.getPageContext().getEventDispatcher() != null) {
            this.item.getPageContext().getEventDispatcher().dispatchEvent("script_load_more", hashMap);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.footer.SectionFooterPresent
    protected void renderContentInView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1610909929")) {
            ipChange.ipc$dispatch("-1610909929", new Object[]{this});
            return;
        }
        int convertComponentTypeToInt = ComponentTypeMapper.INSTANCE.convertComponentTypeToInt(((ScriptFooterModel) this.model).getComponentId());
        this.componentId = convertComponentTypeToInt;
        switch (convertComponentTypeToInt) {
            case 1008:
                ((ScriptFooterView) this.view).renderContent("查看更多店铺");
                userTrackExpose(((ScriptFooterView) this.view).getRenderView(), "scriptkill_store_more", getTrackArgs());
                return;
            case 1009:
                ((ScriptFooterView) this.view).renderContent("查看更多剧本");
                userTrackExpose(((ScriptFooterView) this.view).getRenderView(), "scriptkill_script_more", getTrackArgs());
                return;
            case 1010:
                ((ScriptFooterView) this.view).renderContent("查看更多剧本杀券");
                userTrackExpose(((ScriptFooterView) this.view).getRenderView(), "scriptkill_coupon_more", getTrackArgs());
                return;
            default:
                return;
        }
    }
}
