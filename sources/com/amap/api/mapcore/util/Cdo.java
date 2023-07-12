package com.amap.api.mapcore.util;

import com.autonavi.base.ae.gmap.style.StyleItem;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.do  reason: invalid class name */
/* loaded from: classes10.dex */
public class Cdo {
    private Map<Integer, StyleItem> a = new ConcurrentHashMap();
    private Object b = null;
    private StyleItem[] c;

    public Map<Integer, StyleItem> a() {
        return this.a;
    }

    public StyleItem[] b() {
        Map<Integer, StyleItem> map = this.a;
        if (map != null && map.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (StyleItem styleItem : this.a.values()) {
                if (styleItem.isValid()) {
                    arrayList.add(styleItem);
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                StyleItem[] styleItemArr = (StyleItem[]) arrayList.toArray(new StyleItem[size]);
                this.c = styleItemArr;
                return styleItemArr;
            }
        }
        return null;
    }

    public StyleItem[] c() {
        return this.c;
    }

    public Object d() {
        return this.b;
    }
}
