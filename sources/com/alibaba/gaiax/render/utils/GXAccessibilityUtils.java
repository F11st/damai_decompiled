package com.alibaba.gaiax.render.utils;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class GXAccessibilityUtils {
    @NotNull
    public static final GXAccessibilityUtils INSTANCE = new GXAccessibilityUtils();

    private GXAccessibilityUtils() {
    }

    public final void a(@NotNull View view, @Nullable JSONObject jSONObject) {
        String string;
        Boolean bool;
        final String string2;
        b41.i(view, "view");
        if (jSONObject == null) {
            string = null;
        } else {
            try {
                string = jSONObject.getString("accessibilityDesc");
            } catch (Exception e) {
                GXRegisterCenter.C3334b d = GXRegisterCenter.Companion.a().d();
                if ((d == null || d.e()) ? false : true) {
                    throw e;
                }
                return;
            }
        }
        if (string != null) {
            view.setContentDescription(string);
            view.setImportantForAccessibility(1);
        } else {
            view.setImportantForAccessibility(2);
        }
        if (jSONObject != null && (bool = jSONObject.getBoolean("accessibilityEnable")) != null) {
            view.setImportantForAccessibility(bool.booleanValue() ? 1 : 2);
        }
        if (jSONObject != null && (string2 = jSONObject.getString("accessibilityTraits")) != null) {
            ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: com.alibaba.gaiax.render.utils.GXAccessibilityUtils$accessibilityOfImage$2$1
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(@NotNull View view2, @NotNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    b41.i(view2, "host");
                    b41.i(accessibilityNodeInfoCompat, "info");
                    super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setClassName(GXAccessibilityUtils.INSTANCE.d(string2));
                }
            });
        }
    }

    public final void b(@NotNull View view, @Nullable JSONObject jSONObject, @NotNull CharSequence charSequence) {
        String string;
        Boolean bool;
        final String string2;
        b41.i(view, "view");
        b41.i(charSequence, "content");
        boolean z = false;
        if (jSONObject == null) {
            string = null;
        } else {
            try {
                string = jSONObject.getString("accessibilityDesc");
            } catch (Exception e) {
                GXRegisterCenter.C3334b d = GXRegisterCenter.Companion.a().d();
                if (d != null && !d.e()) {
                    z = true;
                }
                if (z) {
                    throw e;
                }
                return;
            }
        }
        if (string != null) {
            view.setContentDescription(string);
            view.setImportantForAccessibility(1);
        } else {
            view.setContentDescription(null);
            if (charSequence.length() > 0) {
                view.setImportantForAccessibility(1);
            } else {
                view.setImportantForAccessibility(2);
            }
        }
        if (jSONObject != null && (bool = jSONObject.getBoolean("accessibilityEnable")) != null) {
            view.setImportantForAccessibility(bool.booleanValue() ? 1 : 2);
        }
        if (jSONObject != null && (string2 = jSONObject.getString("accessibilityTraits")) != null) {
            ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: com.alibaba.gaiax.render.utils.GXAccessibilityUtils$accessibilityOfText$2$1
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(@NotNull View view2, @NotNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    b41.i(view2, "host");
                    b41.i(accessibilityNodeInfoCompat, "info");
                    super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setClassName(GXAccessibilityUtils.INSTANCE.d(string2));
                }
            });
        }
    }

    public final void c(@NotNull View view, @Nullable JSONObject jSONObject) {
        String string;
        Boolean bool;
        final String string2;
        b41.i(view, "view");
        if (jSONObject == null) {
            string = null;
        } else {
            try {
                string = jSONObject.getString("accessibilityDesc");
            } catch (Exception e) {
                GXRegisterCenter.C3334b d = GXRegisterCenter.Companion.a().d();
                if ((d == null || d.e()) ? false : true) {
                    throw e;
                }
                return;
            }
        }
        if (string != null) {
            view.setContentDescription(string);
            view.setImportantForAccessibility(1);
        } else {
            view.setImportantForAccessibility(2);
        }
        if (jSONObject != null && (bool = jSONObject.getBoolean("accessibilityEnable")) != null) {
            view.setImportantForAccessibility(bool.booleanValue() ? 1 : 2);
        }
        if (jSONObject != null && (string2 = jSONObject.getString("accessibilityTraits")) != null) {
            ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: com.alibaba.gaiax.render.utils.GXAccessibilityUtils$accessibilityOfView$2$1
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(@NotNull View view2, @NotNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    b41.i(view2, "host");
                    b41.i(accessibilityNodeInfoCompat, "info");
                    super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setClassName(GXAccessibilityUtils.INSTANCE.d(string2));
                }
            });
        }
    }

    @NotNull
    public final String d(@NotNull String str) {
        b41.i(str, "traits");
        switch (str.hashCode()) {
            case -1377687758:
                if (str.equals(BaseCellItem.TYPE_BUTTON)) {
                    String name = Button.class.getName();
                    b41.h(name, "Button::class.java.name");
                    return name;
                }
                break;
            case 3387192:
                if (str.equals("none")) {
                    return "";
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    String name2 = TextView.class.getName();
                    b41.h(name2, "TextView::class.java.name");
                    return name2;
                }
                break;
            case 100313435:
                if (str.equals("image")) {
                    String name3 = ImageView.class.getName();
                    b41.h(name3, "ImageView::class.java.name");
                    return name3;
                }
                break;
        }
        String name4 = View.class.getName();
        b41.h(name4, "View::class.java.name");
        return name4;
    }
}
