package cn.damai.tetris.v2.adpater;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.tetris.core.IContext;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.v2.structure.section.ISection;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.util.ArrayList;
import tb.m90;
import tb.xl2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VDinamicXViewHolder extends VBaseViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    public DXTemplateItem d;

    public VDinamicXViewHolder(IContext iContext, View view, DXTemplateItem dXTemplateItem) {
        super(view, iContext);
        this.d = dXTemplateItem;
        view.setBackgroundColor(0);
    }

    private JSONObject f(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1170070832") ? (JSONObject) ipChange.ipc$dispatch("1170070832", new Object[]{this, jSONObject}) : jSONObject;
    }

    private void g(DinamicXEngine dinamicXEngine) {
        JSONObject f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1472671412")) {
            ipChange.ipc$dispatch("-1472671412", new Object[]{this, dinamicXEngine});
            return;
        }
        String componentId = ((ISection) this.b).getComponentId();
        if (!xl2.DX_MUSIC_FESTIVAL_HOT_PROJECT_LIST_CID.equals(componentId) && !xl2.DX_MUSIC_FESTIVAL_IP_LIST_CID.equals(componentId)) {
            f = f(((ISection) this.b).getRawData());
        } else {
            f = f(((ISection) this.b).getItem());
        }
        View view = this.itemView;
        if (view instanceof DXRootView) {
            dinamicXEngine.Q((DXRootView) view, f);
        } else if (((ViewGroup) view).getChildAt(0) != null && (((ViewGroup) this.itemView).getChildAt(0) instanceof DXRootView)) {
            dinamicXEngine.Q((DXRootView) ((ViewGroup) this.itemView).getChildAt(0), f);
        } else if (((ViewGroup) this.itemView).getChildCount() == 2 && ((ViewGroup) this.itemView).getChildAt(1) != null && (((ViewGroup) this.itemView).getChildAt(1) instanceof DXRootView)) {
            dinamicXEngine.Q((DXRootView) ((ViewGroup) this.itemView).getChildAt(1), f);
        }
    }

    @Override // cn.damai.tetris.v2.adpater.VBaseViewHolder
    protected IModel b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1386131539")) {
            return (IModel) ipChange.ipc$dispatch("-1386131539", new Object[]{this});
        }
        DinamicXEngine dXEngine = this.a.getDXEngine();
        if (dXEngine == null) {
            return null;
        }
        DXTemplateItem h = dXEngine.h(this.d);
        if (h != null && this.d.version == h.version) {
            g(dXEngine);
        } else {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.d);
            dXEngine.g(arrayList);
            m90.a(this);
        }
        return null;
    }

    public void h(DXTemplateItem dXTemplateItem) {
        DinamicXEngine dXEngine;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "447585553")) {
            ipChange.ipc$dispatch("447585553", new Object[]{this, dXTemplateItem});
        } else if (!dXTemplateItem.equals(this.d) || (dXEngine = this.a.getDXEngine()) == null || this.b == 0) {
        } else {
            g(dXEngine);
        }
    }
}
