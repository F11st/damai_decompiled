package cn.damai.tetris.v2.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class CmsDxTemplate implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String dxTemplateName;
    public String url;
    public long version = -1;

    @Nullable
    public static CmsDxTemplate getValidTemplateJson(JSONObject jSONObject, String str) {
        CmsDxTemplate cmsDxTemplate;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-721765006")) {
            return (CmsDxTemplate) ipChange.ipc$dispatch("-721765006", new Object[]{jSONObject, str});
        }
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("dxConfig");
                if (jSONObject2 == null || (cmsDxTemplate = (CmsDxTemplate) JSON.parseObject(jSONObject2.toJSONString(), CmsDxTemplate.class)) == null || !cmsDxTemplate.isValid(str)) {
                    return null;
                }
                cmsDxTemplate.dxTemplateName = str;
                return cmsDxTemplate;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static JSONObject toDxJsonObj(CmsDxTemplate cmsDxTemplate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1009493204")) {
            return (JSONObject) ipChange.ipc$dispatch("1009493204", new Object[]{cmsDxTemplate});
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", (Object) cmsDxTemplate.dxTemplateName);
        jSONObject.put("version", (Object) Long.valueOf(cmsDxTemplate.version));
        jSONObject.put("templateUrl", (Object) cmsDxTemplate.url);
        return jSONObject;
    }

    public boolean isValid(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1063102073") ? ((Boolean) ipChange.ipc$dispatch("-1063102073", new Object[]{this, str})).booleanValue() : !TextUtils.isEmpty(str) && this.version > -1;
    }
}
