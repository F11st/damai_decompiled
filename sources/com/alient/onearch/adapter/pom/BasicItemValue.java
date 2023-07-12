package com.alient.onearch.adapter.pom;

import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class BasicItemValue extends ItemValue {
    private Object value;

    public BasicItemValue() {
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public BasicItemValue(@Nullable Node node) {
        super(node);
    }
}
