package com.taobao.android.ultron.datamodel.imp;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.ISubmitModule;
import com.taobao.android.ultron.datamodel.imp.ParseResponseHelper;
import com.tencent.open.SocialOperation;
import com.youku.arch.v3.data.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class d implements ISubmitModule {
    public JSONObject a(a aVar, Collection<?> collection, IDMComponent iDMComponent, boolean z) {
        JSONObject adjustData;
        JSONObject jSONObject = new JSONObject();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            DMComponent dMComponent = (DMComponent) it.next();
            if (!z) {
                adjustData = dMComponent.submitData();
            } else {
                adjustData = dMComponent.adjustData();
            }
            if (adjustData != null) {
                jSONObject.put(dMComponent.getKey(), (Object) adjustData);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject b = aVar.b();
        if (b != null) {
            JSONObject jSONObject3 = new JSONObject();
            String string = b.getString("validateParams");
            boolean booleanValue = b.getBooleanValue("compress");
            if (!z) {
                String string2 = b.getString("submitParams");
                if (string2 != null || string != null) {
                    if (string2 != null && !string2.isEmpty()) {
                        jSONObject3.put("submitParams", (Object) string2);
                    }
                    if (string != null && !string.isEmpty()) {
                        jSONObject3.put("validateParams", (Object) string);
                    }
                    jSONObject3.put("compress", (Object) Boolean.valueOf(booleanValue));
                    b = jSONObject3;
                }
                jSONObject2.put("common", (Object) b);
            } else {
                String string3 = b.getString("queryParams");
                if (string3 != null || string != null) {
                    if (string3 != null && !string3.isEmpty()) {
                        jSONObject3.put("queryParams", (Object) string3);
                    }
                    if (string != null && !string.isEmpty()) {
                        jSONObject3.put("validateParams", (Object) string);
                    }
                    jSONObject3.put("compress", (Object) Boolean.valueOf(booleanValue));
                    b = jSONObject3;
                }
                jSONObject2.put("common", (Object) b);
            }
        }
        String string4 = aVar.j().getString(SocialOperation.GAME_SIGNATURE);
        if (string4 != null && !string4.isEmpty()) {
            jSONObject2.put(SocialOperation.GAME_SIGNATURE, (Object) string4);
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("structure", (Object) aVar.n());
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("data", (Object) jSONObject);
        jSONObject5.put("linkage", (Object) jSONObject2);
        jSONObject5.put("hierarchy", (Object) jSONObject4);
        JSONObject f = aVar.f();
        if (f != null) {
            JSONObject jSONObject6 = f.getJSONObject("meta");
            if (jSONObject6 == null) {
                jSONObject6 = new JSONObject();
            }
            jSONObject6.remove(Constants.TEMPLATE);
            List<ParseResponseHelper.TemplateInfo> g = ParseResponseHelper.g(aVar.d(), aVar.a());
            if (g != null) {
                jSONObject6.put("templates", (Object) JSON.toJSONString(g));
            }
        }
        jSONObject5.put("endpoint", (Object) f);
        if (iDMComponent != null) {
            jSONObject5.put("operator", (Object) iDMComponent.getKey());
            if (iDMComponent instanceof DMComponent) {
                DMComponent dMComponent2 = (DMComponent) iDMComponent;
                if (!TextUtils.isEmpty(dMComponent2.getTriggerEvent())) {
                    jSONObject5.put("operatorEvent", (Object) dMComponent2.getTriggerEvent());
                }
            }
        }
        return jSONObject5;
    }

    @Override // com.taobao.android.ultron.datamodel.ISubmitModule
    public JSONObject asyncRequestData(a aVar, IDMComponent iDMComponent) {
        if (aVar == null) {
            return null;
        }
        try {
            Map<String, DMComponent> l = aVar.l();
            if (l == null) {
                return null;
            }
            HashSet hashSet = new HashSet();
            if (iDMComponent != null) {
                hashSet.add(iDMComponent);
            }
            JSONArray i = aVar.i();
            if (i != null && !i.isEmpty()) {
                Iterator<Object> it = i.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (l.get(str) != null) {
                        hashSet.add(l.get(str));
                    }
                }
                return a(aVar, hashSet, iDMComponent, true);
            }
            return a(aVar, hashSet, iDMComponent, true);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.taobao.android.ultron.datamodel.ISubmitModule
    public JSONObject submitRequestData(a aVar) {
        Map<String, DMComponent> l;
        if (aVar == null || (l = aVar.l()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(l.size());
        for (DMComponent dMComponent : l.values()) {
            if (dMComponent.shouldSubmit()) {
                arrayList.add(dMComponent);
            }
        }
        return a(aVar, arrayList, null, false);
    }
}
