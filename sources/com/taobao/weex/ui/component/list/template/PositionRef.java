package com.taobao.weex.ui.component.list.template;

import com.alibaba.fastjson.JSONAware;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PositionRef extends Number implements JSONAware {
    private CellRenderState renderState;

    public PositionRef(CellRenderState cellRenderState) {
        this.renderState = cellRenderState;
    }

    private int getPosition() {
        CellRenderState cellRenderState = this.renderState;
        if (cellRenderState == null) {
            return -1;
        }
        return cellRenderState.position;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return getPosition();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return getPosition();
    }

    @Override // java.lang.Number
    public int intValue() {
        return getPosition();
    }

    @Override // java.lang.Number
    public long longValue() {
        return getPosition();
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        return String.valueOf(getPosition());
    }

    public String toString() {
        return String.valueOf(getPosition());
    }
}
