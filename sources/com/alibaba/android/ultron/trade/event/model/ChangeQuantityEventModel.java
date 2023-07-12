package com.alibaba.android.ultron.trade.event.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class ChangeQuantityEventModel implements Serializable {
    private String max;
    private String min;
    private String quantity;
    private String step;

    public String getMax() {
        return this.max;
    }

    public String getMin() {
        return this.min;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public String getStep() {
        return this.step;
    }

    public void setMax(String str) {
        this.max = str;
    }

    public void setMin(String str) {
        this.min = str;
    }

    public void setQuantity(String str) {
        this.quantity = str;
    }

    public void setStep(String str) {
        this.step = str;
    }
}
