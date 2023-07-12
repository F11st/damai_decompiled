package tb;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.norm.IConfigAdapter;
import com.alibaba.poplayer.trigger.AbstractC3680a;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.trigger.Event;
import com.alibaba.poplayer.trigger.view.C3699d;
import com.alibaba.poplayer.trigger.view.ViewConfigItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class xx2 extends AbstractC3680a<ViewConfigItem> {
    public static final String KEY_CONFIG_VIEW = "poplayer_view_config";

    public xx2(PopLayer popLayer, IConfigAdapter iConfigAdapter) {
        super(iConfigAdapter, KEY_CONFIG_VIEW, AbstractC3680a.KEY_BLACK_LIST);
        dt1.a("ViewConfigMgr use " + ViewConfigItem.LOG);
    }

    private boolean x(Map<String, String> map, BaseConfigItem.C3677a c3677a) {
        JSONObject jSONObject;
        String string;
        String str;
        if (!TextUtils.isEmpty(c3677a.c)) {
            try {
                jSONObject = new JSONObject(c3677a.c);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONObject != null || jSONObject.length() == 0) {
                return true;
            }
            if (map != null && map.size() != 0) {
                Iterator<String> keys = jSONObject.keys();
                do {
                    try {
                        if (!keys.hasNext()) {
                            return true;
                        }
                        String next = keys.next();
                        string = jSONObject.getString(next);
                        str = map.get(next);
                        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(str)) {
                            break;
                        }
                    } catch (Throwable unused) {
                    }
                } while (string.equals(str));
                return false;
            }
            return false;
        }
        jSONObject = null;
        if (jSONObject != null) {
        }
        return true;
    }

    @Override // com.alibaba.poplayer.trigger.AbstractC3680a
    /* renamed from: A */
    public ViewConfigItem s(Event event) {
        Uri parse = Uri.parse(event.originUri);
        if ("directly".equals(parse.getQueryParameter("openType"))) {
            String jSONObject = u(parse).toString();
            ViewConfigItem viewConfigItem = (ViewConfigItem) JSON.parseObject(jSONObject, ViewConfigItem.class);
            viewConfigItem.pageInfo = t(jSONObject, viewConfigItem.uuid);
            return viewConfigItem;
        }
        return null;
    }

    @Override // com.alibaba.poplayer.trigger.AbstractC3680a
    public vw2<ViewConfigItem> h(Event event) {
        ArrayList arrayList = new ArrayList();
        for (ConfigItemType configitemtype : this.b) {
            dt1.b("ViewConfigMgr.findValidConfigs.currentUUID:{%s}.", configitemtype.uuid);
            if (!n(event, configitemtype.pageInfo)) {
                dt1.b("ViewConfigMgr.findValidConfigs.currentUUID:{%s}.isMatchUriOrUris fail.", configitemtype.uuid);
            } else if (e(event, configitemtype.pageInfo)) {
                arrayList.add(configitemtype);
            } else {
                dt1.b("ViewConfigMgr.findValidConfigs.currentUUID:{%s}.checkParamContains fail.", configitemtype.uuid);
            }
        }
        return f(event, arrayList);
    }

    @Override // com.alibaba.poplayer.trigger.AbstractC3680a
    protected void p(List<ViewConfigItem> list, String str, List<String> list2) {
        C3699d.M().w();
    }

    public vw2<ViewConfigItem> y(Event event, Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (ConfigItemType configitemtype : this.b) {
            dt1.b("ViewConfigMgr.findValidConfigs.currentUUID:{%s}.", configitemtype.uuid);
            if (!n(event, configitemtype.pageInfo)) {
                dt1.b("ViewConfigMgr.findValidConfigs.currentUUID:{%s}.isMatchUriOrUris fail.", configitemtype.uuid);
            } else if (x(map, configitemtype.pageInfo)) {
                arrayList.add(configitemtype);
            } else {
                dt1.b("ViewConfigMgr.findValidConfigs.currentUUID:{%s}.checkParamContainsWithFilter fail.", configitemtype.uuid);
            }
        }
        return f(event, arrayList);
    }

    @Override // com.alibaba.poplayer.trigger.AbstractC3680a
    /* renamed from: z */
    public ViewConfigItem r(String str) {
        ViewConfigItem viewConfigItem = (ViewConfigItem) JSON.parseObject(str, ViewConfigItem.class);
        viewConfigItem.pageInfo = t(str, viewConfigItem.uuid);
        return viewConfigItem;
    }
}
