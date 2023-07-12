package com.taobao.weex.ui.component.helper;

import com.taobao.weex.ui.component.Scrollable;
import com.taobao.weex.ui.component.WXComponent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXStickyHelper {
    private Scrollable scrollable;

    public WXStickyHelper(Scrollable scrollable) {
        this.scrollable = scrollable;
    }

    public void bindStickStyle(WXComponent wXComponent, Map<String, Map<String, WXComponent>> map) {
        Scrollable parentScroller = wXComponent.getParentScroller();
        if (parentScroller == null) {
            return;
        }
        Map<String, WXComponent> map2 = map.get(parentScroller.getRef());
        if (map2 == null) {
            map2 = new ConcurrentHashMap<>();
        }
        if (map2.containsKey(wXComponent.getRef())) {
            return;
        }
        map2.put(wXComponent.getRef(), wXComponent);
        map.put(parentScroller.getRef(), map2);
    }

    public void unbindStickStyle(WXComponent wXComponent, Map<String, Map<String, WXComponent>> map) {
        Map<String, WXComponent> map2;
        Scrollable parentScroller = wXComponent.getParentScroller();
        if (parentScroller == null || (map2 = map.get(parentScroller.getRef())) == null) {
            return;
        }
        map2.remove(wXComponent.getRef());
    }
}
