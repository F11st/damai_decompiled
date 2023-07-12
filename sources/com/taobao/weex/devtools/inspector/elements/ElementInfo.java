package com.taobao.weex.devtools.inspector.elements;

import com.taobao.weex.devtools.common.ListUtil;
import com.taobao.weex.devtools.common.Util;
import java.util.List;
import javax.annotation.concurrent.Immutable;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes11.dex */
public final class ElementInfo {
    public final List<Object> children;
    public final Object element;
    public final Object parentElement;

    public ElementInfo(Object obj, Object obj2, List<Object> list) {
        this.element = Util.throwIfNull(obj);
        this.parentElement = obj2;
        this.children = ListUtil.copyToImmutableList(list);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ElementInfo) {
            ElementInfo elementInfo = (ElementInfo) obj;
            return this.element == elementInfo.element && this.parentElement == elementInfo.parentElement && ListUtil.identityEquals(this.children, elementInfo.children);
        }
        return false;
    }
}
