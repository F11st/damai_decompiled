package com.taobao.weex.ui.component.list.template;

import java.util.HashMap;
import java.util.Map;
import tb.x7;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CellRenderContext {
    public int position;
    public CellRenderState renderState;
    public WXRecyclerTemplateList templateList;
    public x7 stack = new x7();
    public Map map = new HashMap(8);

    public void clear() {
        if (this.stack.c().size() > 0) {
            this.stack.c().clear();
        }
        if (this.map.size() > 0) {
            this.map.clear();
        }
        this.renderState = null;
        this.position = 0;
        this.templateList = null;
    }

    public CellRenderState getRenderState() {
        if (this.renderState != null) {
            this.renderState = this.templateList.getCellDataManager().getRenderState(this.position);
        }
        return this.renderState;
    }
}
