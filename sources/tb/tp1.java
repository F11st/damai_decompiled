package tb;

import android.net.Uri;
import com.alibaba.fastjson.JSON;
import com.alibaba.poplayer.norm.IConfigAdapter;
import com.alibaba.poplayer.trigger.AbstractC3680a;
import com.alibaba.poplayer.trigger.Event;
import com.alibaba.poplayer.trigger.page.PageConfigItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class tp1 extends AbstractC3680a<PageConfigItem> {
    public static final String KEY_CONFIG_PAGE = "poplayer_config";

    public tp1(IConfigAdapter iConfigAdapter) {
        super(iConfigAdapter, KEY_CONFIG_PAGE, AbstractC3680a.KEY_BLACK_LIST);
        dt1.a("PageConfigMgr use " + PageConfigItem.LOG);
    }

    @Override // com.alibaba.poplayer.trigger.AbstractC3680a
    public vw2<PageConfigItem> h(Event event) {
        ArrayList arrayList = new ArrayList();
        for (ConfigItemType configitemtype : this.b) {
            dt1.b("PageConfigMgr.findValidConfigs.currentUUID:{%s}.", configitemtype.uuid);
            if (!n(event, configitemtype.pageInfo)) {
                dt1.b("PageConfigMgr.findValidConfigs.currentUUID:{%s}.isMatchUriOrUris fail.", configitemtype.uuid);
            } else if (e(event, configitemtype.pageInfo)) {
                arrayList.add(configitemtype);
            } else {
                dt1.b("PageConfigMgr.findValidConfigs.currentUUID:{%s}.checkParamContains fail.", configitemtype.uuid);
            }
        }
        return f(event, arrayList);
    }

    @Override // com.alibaba.poplayer.trigger.AbstractC3680a
    protected void p(List<PageConfigItem> list, String str, List list2) {
        gq1.A().w();
    }

    @Override // com.alibaba.poplayer.trigger.AbstractC3680a
    /* renamed from: x */
    public PageConfigItem r(String str) {
        PageConfigItem pageConfigItem = (PageConfigItem) JSON.parseObject(str, PageConfigItem.class);
        pageConfigItem.pageInfo = t(str, pageConfigItem.uuid);
        return pageConfigItem;
    }

    @Override // com.alibaba.poplayer.trigger.AbstractC3680a
    /* renamed from: y */
    public PageConfigItem s(Event event) {
        Uri parse = Uri.parse(event.originUri);
        if ("directly".equals(parse.getQueryParameter("openType"))) {
            String jSONObject = u(parse).toString();
            PageConfigItem pageConfigItem = (PageConfigItem) JSON.parseObject(jSONObject, PageConfigItem.class);
            pageConfigItem.pageInfo = t(jSONObject, pageConfigItem.uuid);
            return pageConfigItem;
        }
        return null;
    }
}
