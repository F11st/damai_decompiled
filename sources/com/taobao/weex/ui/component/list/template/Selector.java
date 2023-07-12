package com.taobao.weex.ui.component.list.template;

import android.text.TextUtils;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.component.list.WXCell;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Selector {
    public static void closest(WXComponent wXComponent, String str, List<WXComponent> list) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.replaceAll("\\[|]", "").split("=");
        if (split.length <= 0) {
            return;
        }
        closestByAttrs(wXComponent, split[0], split.length > 1 ? split[1].trim() : null, list);
    }

    private static void closestByAttrs(WXComponent wXComponent, String str, String str2, List<WXComponent> list) {
        if (matchAttrs(wXComponent, str, str2)) {
            list.add(wXComponent);
        }
        if ((wXComponent instanceof WXCell) || (wXComponent instanceof WXRecyclerTemplateList)) {
            return;
        }
        queryElementAllByAttrs(wXComponent.getParent(), str, str2, list);
    }

    private static boolean matchAttrs(WXComponent wXComponent, String str, String str2) {
        if (!wXComponent.isWaste() && wXComponent.getAttrs().containsKey(str)) {
            if (TextUtils.isEmpty(str2)) {
                return true;
            }
            Object obj = wXComponent.getAttrs().get(str);
            if (obj == null) {
                return false;
            }
            return str2.equals(obj.toString());
        }
        return false;
    }

    public static void queryElementAll(WXComponent wXComponent, String str, List<WXComponent> list) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.replaceAll("\\[|]", "").split("=");
        if (split.length <= 0) {
            return;
        }
        String str2 = split[0];
        String trim = split.length > 1 ? split[1].trim() : null;
        if (wXComponent instanceof WXVContainer) {
            WXVContainer wXVContainer = (WXVContainer) wXComponent;
            for (int i = 0; i < wXVContainer.getChildCount(); i++) {
                queryElementAllByAttrs(wXVContainer.getChild(i), str2, trim, list);
            }
        }
    }

    private static void queryElementAllByAttrs(WXComponent wXComponent, String str, String str2, List<WXComponent> list) {
        if (matchAttrs(wXComponent, str, str2)) {
            list.add(wXComponent);
        }
        if (wXComponent instanceof WXVContainer) {
            WXVContainer wXVContainer = (WXVContainer) wXComponent;
            for (int i = 0; i < wXVContainer.getChildCount(); i++) {
                queryElementAllByAttrs(wXVContainer.getChild(i), str, str2, list);
            }
        }
    }
}
