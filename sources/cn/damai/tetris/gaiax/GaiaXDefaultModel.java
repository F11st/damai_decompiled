package cn.damai.tetris.gaiax;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.gaiax.LoadType;
import com.youku.gaiax.common.utils.ScreenUtils;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class GaiaXDefaultModel extends AbsModel implements GaiaXModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private JSONObject desireRawJson;
    protected GaiaXTemplateInfo templateInfo;

    @Override // cn.damai.tetris.gaiax.GaiaXModel
    public boolean forceCreate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086636704")) {
            return ((Boolean) ipChange.ipc$dispatch("1086636704", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.gaiax.GaiaXModel
    public String getBiz() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1208404362")) {
            return (String) ipChange.ipc$dispatch("-1208404362", new Object[]{this});
        }
        GaiaXTemplateInfo gaiaXTemplateInfo = this.templateInfo;
        return (gaiaXTemplateInfo == null || TextUtils.isEmpty(gaiaXTemplateInfo.bizKey)) ? "damai" : this.templateInfo.bizKey;
    }

    @Override // cn.damai.tetris.gaiax.GaiaXModel
    public Float getDefaultDesireHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1255608838")) {
            return (Float) ipChange.ipc$dispatch("1255608838", new Object[]{this, context});
        }
        return null;
    }

    @Override // cn.damai.tetris.gaiax.GaiaXModel
    public float getDefaultDesireWidth(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "472235302") ? ((Float) ipChange.ipc$dispatch("472235302", new Object[]{this, context})).floatValue() : ScreenUtils.INSTANCE.getScreenWidthPx(context);
    }

    @Override // cn.damai.tetris.gaiax.GaiaXModel
    public JSONObject getDesireRawJson() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1852132855") ? (JSONObject) ipChange.ipc$dispatch("1852132855", new Object[]{this}) : this.desireRawJson;
    }

    @Override // cn.damai.tetris.gaiax.GaiaXModel
    public LoadType getLoadType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1893656859")) {
            return (LoadType) ipChange.ipc$dispatch("1893656859", new Object[]{this});
        }
        return null;
    }

    @Override // cn.damai.tetris.gaiax.GaiaXModel
    public int getType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1698289402")) {
            return ((Integer) ipChange.ipc$dispatch("-1698289402", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // cn.damai.tetris.gaiax.GaiaXModel
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1239348667")) {
            return (String) ipChange.ipc$dispatch("1239348667", new Object[]{this});
        }
        GaiaXTemplateInfo gaiaXTemplateInfo = this.templateInfo;
        if (gaiaXTemplateInfo != null) {
            return gaiaXTemplateInfo.version;
        }
        return null;
    }

    @Override // cn.damai.tetris.gaiax.GaiaXModel
    public boolean openMinHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1460578040")) {
            return ((Boolean) ipChange.ipc$dispatch("1460578040", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1783159864")) {
            ipChange.ipc$dispatch("-1783159864", new Object[]{this, baseNode});
            return;
        }
        try {
            this.templateInfo = (GaiaXTemplateInfo) baseNode.getGaiaxConfig().toJavaObject(GaiaXTemplateInfo.class);
            JSONObject jSONObject = new JSONObject();
            this.desireRawJson = jSONObject;
            jSONObject.put("item", (Object) baseNode.getItem());
            this.desireRawJson.put("style", (Object) baseNode.getStyle());
            this.desireRawJson.put("trackInfo", (Object) baseNode.getTrackInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // cn.damai.tetris.gaiax.GaiaXModel
    public void setContext(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2111792722")) {
            ipChange.ipc$dispatch("-2111792722", new Object[]{this, context});
        }
    }
}
