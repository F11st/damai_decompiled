package com.taobao.weex.dom;

import android.text.Layout;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import com.taobao.weex.common.Constants;
import com.taobao.weex.dom.binding.ELUtils;
import com.taobao.weex.ui.component.WXTextDecoration;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXStyle implements Map<String, Object>, Cloneable {
    public static final int UNSET = -1;
    private static final long serialVersionUID = 611132641365274134L;
    private ArrayMap<String, Object> mBindingStyle;
    @Nullable
    private Map<String, Object> mPesudoResetStyleMap;
    @Nullable
    private Map<String, Map<String, Object>> mPesudoStyleMap;
    @NonNull
    private Map<String, Object> mStyles;

    public WXStyle() {
        this.mStyles = new ArrayMap();
    }

    private boolean addBindingStyleIfStatement(String str, Object obj) {
        if (ELUtils.isBinding(obj)) {
            if (this.mBindingStyle == null) {
                this.mBindingStyle = new ArrayMap<>();
            }
            this.mBindingStyle.put(str, ELUtils.bindingBlock(obj));
            return true;
        }
        return false;
    }

    public static String getFontFamily(Map<String, Object> map) {
        Object obj;
        if (map == null || (obj = map.get(Constants.Name.FONT_FAMILY)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static int getFontSize(Map<String, Object> map, int i) {
        float realPxByWidth;
        if (map == null) {
            realPxByWidth = WXViewUtils.getRealPxByWidth(32.0f, i);
        } else {
            int i2 = WXUtils.getInt(map.get("fontSize"));
            if (i2 <= 0) {
                i2 = 32;
            }
            realPxByWidth = WXViewUtils.getRealPxByWidth(i2, i);
        }
        return (int) realPxByWidth;
    }

    public static int getFontStyle(Map<String, Object> map) {
        Object obj;
        return (map == null || (obj = map.get(Constants.Name.FONT_STYLE)) == null || !obj.toString().equals(Constants.Value.ITALIC)) ? 0 : 2;
    }

    public static int getFontWeight(Map<String, Object> map) {
        Object obj;
        if (map != null && (obj = map.get(Constants.Name.FONT_WEIGHT)) != null) {
            String obj2 = obj.toString();
            obj2.hashCode();
            char c = 65535;
            switch (obj2.hashCode()) {
                case 53430:
                    if (obj2.equals("600")) {
                        c = 0;
                        break;
                    }
                    break;
                case 54391:
                    if (obj2.equals("700")) {
                        c = 1;
                        break;
                    }
                    break;
                case 55352:
                    if (obj2.equals("800")) {
                        c = 2;
                        break;
                    }
                    break;
                case 56313:
                    if (obj2.equals("900")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3029637:
                    if (obj2.equals(Constants.Value.BOLD)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    return 1;
            }
        }
        return 0;
    }

    public static int getLineHeight(Map<String, Object> map, int i) {
        int i2;
        if (map != null && (i2 = WXUtils.getInt(map.get(Constants.Name.LINE_HEIGHT))) > 0) {
            return (int) WXViewUtils.getRealPxByWidth(i2, i);
        }
        return -1;
    }

    public static int getLines(Map<String, Object> map) {
        return WXUtils.getInt(map.get(Constants.Name.LINES));
    }

    public static Layout.Alignment getTextAlignment(Map<String, Object> map) {
        return getTextAlignment(map, false);
    }

    public static String getTextColor(Map<String, Object> map) {
        Object obj;
        return (map == null || (obj = map.get("color")) == null) ? "" : obj.toString();
    }

    public static WXTextDecoration getTextDecoration(Map<String, Object> map) {
        Object obj;
        if (map != null && (obj = map.get(Constants.Name.TEXT_DECORATION)) != null) {
            String obj2 = obj.toString();
            obj2.hashCode();
            char c = 65535;
            switch (obj2.hashCode()) {
                case -1171789332:
                    if (obj2.equals("line-through")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1026963764:
                    if (obj2.equals("underline")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3387192:
                    if (obj2.equals("none")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return WXTextDecoration.LINETHROUGH;
                case 1:
                    return WXTextDecoration.UNDERLINE;
                case 2:
                    return WXTextDecoration.NONE;
                default:
                    return WXTextDecoration.INVALID;
            }
        }
        return WXTextDecoration.NONE;
    }

    public static TextUtils.TruncateAt getTextOverflow(Map<String, Object> map) {
        if (TextUtils.equals(Constants.Name.ELLIPSIS, (String) map.get(Constants.Name.TEXT_OVERFLOW))) {
            return TextUtils.TruncateAt.END;
        }
        return null;
    }

    private void initPesudoMapsIfNeed(Map<? extends String, ?> map) {
        if (this.mPesudoStyleMap == null) {
            this.mPesudoStyleMap = new ArrayMap();
        }
        if (this.mPesudoResetStyleMap == null) {
            this.mPesudoResetStyleMap = new ArrayMap();
        }
        if (this.mPesudoResetStyleMap.isEmpty()) {
            this.mPesudoResetStyleMap.putAll(map);
        }
    }

    private Map<String, Object> parseBindingStylesStatements(Map map) {
        if (map != null && map.size() != 0) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (addBindingStyleIfStatement((String) entry.getKey(), entry.getValue())) {
                    Map<String, Map<String, Object>> map2 = this.mPesudoStyleMap;
                    if (map2 != null) {
                        map2.remove(entry.getKey());
                    }
                    Map<String, Object> map3 = this.mPesudoResetStyleMap;
                    if (map3 != null) {
                        map3.remove(entry.getKey());
                    }
                    it.remove();
                }
            }
        }
        return map;
    }

    @Override // java.util.Map
    public void clear() {
        this.mStyles.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.mStyles.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.mStyles.containsValue(obj);
    }

    @Override // java.util.Map
    @NonNull
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.mStyles.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.mStyles.equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.mStyles.get(obj);
    }

    public String getBackgroundColor() {
        Object obj = get("backgroundColor");
        return obj == null ? "" : obj.toString();
    }

    public ArrayMap<String, Object> getBindingStyle() {
        return this.mBindingStyle;
    }

    @Nullable
    public String getBlur() {
        if (get(Constants.Name.FILTER) == null) {
            return null;
        }
        return get(Constants.Name.FILTER).toString().trim();
    }

    public String getBorderColor() {
        Object obj = get("borderColor");
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public float getBorderRadius() {
        float f = WXUtils.getFloat(get(Constants.Name.BORDER_RADIUS));
        if (WXUtils.isUndefined(f)) {
            return Float.NaN;
        }
        return f;
    }

    public String getBorderStyle() {
        Object obj = get(Constants.Name.BORDER_STYLE);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public float getBottom() {
        float f = WXUtils.getFloat(get("bottom"));
        if (WXUtils.isUndefined(f)) {
            return Float.NaN;
        }
        return f;
    }

    public float getLeft() {
        float f = WXUtils.getFloat(get("left"));
        if (WXUtils.isUndefined(f)) {
            return Float.NaN;
        }
        return f;
    }

    public float getOpacity() {
        Object obj = get("opacity");
        if (obj == null) {
            return 1.0f;
        }
        return WXUtils.getFloat(obj);
    }

    public String getOverflow() {
        Object obj = get(Constants.Name.OVERFLOW);
        return obj == null ? "visible" : obj.toString();
    }

    public Map<String, Object> getPesudoResetStyles() {
        if (this.mPesudoResetStyleMap == null) {
            this.mPesudoResetStyleMap = new ArrayMap();
        }
        return this.mPesudoResetStyleMap;
    }

    public Map<String, Map<String, Object>> getPesudoStyles() {
        if (this.mPesudoStyleMap == null) {
            this.mPesudoStyleMap = new ArrayMap();
        }
        return this.mPesudoStyleMap;
    }

    public float getRight() {
        float f = WXUtils.getFloat(get("right"));
        if (WXUtils.isUndefined(f)) {
            return Float.NaN;
        }
        return f;
    }

    public int getTimeFontSize() {
        int i = WXUtils.getInt(get("timeFontSize"));
        if (i <= 0) {
            return 32;
        }
        return i;
    }

    public float getTop() {
        float f = WXUtils.getFloat(get("top"));
        if (WXUtils.isUndefined(f)) {
            return Float.NaN;
        }
        return f;
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.mStyles.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.mStyles.isEmpty();
    }

    public boolean isFixed() {
        Object obj = get("position");
        if (obj == null) {
            return false;
        }
        return obj.toString().equals(Constants.Value.FIXED);
    }

    public boolean isSticky() {
        Object obj = get("position");
        if (obj == null) {
            return false;
        }
        return obj.toString().equals("sticky");
    }

    @Override // java.util.Map
    @NonNull
    public Set<String> keySet() {
        return this.mStyles.keySet();
    }

    public void parseStatements() {
        Map<String, Object> map = this.mStyles;
        if (map != null) {
            this.mStyles = parseBindingStylesStatements(map);
        }
    }

    <T extends String, V> void processPesudoClasses(Map<T, V> map) {
        ArrayMap arrayMap = null;
        for (Map.Entry<T, V> entry : map.entrySet()) {
            T key = entry.getKey();
            int indexOf = key.indexOf(":");
            if (indexOf > 0) {
                initPesudoMapsIfNeed(map);
                String substring = key.substring(indexOf);
                if (substring.equals(Constants.PSEUDO.ENABLED)) {
                    String substring2 = key.substring(0, indexOf);
                    if (arrayMap == null) {
                        arrayMap = new ArrayMap();
                    }
                    arrayMap.put(substring2, entry.getValue());
                    this.mPesudoResetStyleMap.put(substring2, entry.getValue());
                } else {
                    String replace = substring.replace(Constants.PSEUDO.ENABLED, "");
                    Map<String, Object> map2 = this.mPesudoStyleMap.get(replace);
                    if (map2 == null) {
                        map2 = new ArrayMap<>();
                        this.mPesudoStyleMap.put(replace, map2);
                    }
                    map2.put(key.substring(0, indexOf), entry.getValue());
                }
            }
        }
        if (arrayMap == null || arrayMap.isEmpty()) {
            return;
        }
        this.mStyles.putAll(arrayMap);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        this.mStyles.putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.mStyles.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.mStyles.size();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String toString() {
        return this.mStyles.toString();
    }

    public void updateStyle(Map<? extends String, ?> map, boolean z) {
        parseBindingStylesStatements(map);
        putAll(map, z);
    }

    @Override // java.util.Map
    @NonNull
    public Collection<Object> values() {
        return this.mStyles.values();
    }

    public static Layout.Alignment getTextAlignment(Map<String, Object> map, boolean z) {
        Layout.Alignment alignment = z ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        String str = (String) map.get(Constants.Name.TEXT_ALIGN);
        if (TextUtils.equals("left", str)) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (TextUtils.equals("center", str)) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        return TextUtils.equals("right", str) ? Layout.Alignment.ALIGN_OPPOSITE : alignment;
    }

    /* renamed from: clone */
    public WXStyle m579clone() {
        WXStyle wXStyle = new WXStyle();
        wXStyle.mStyles.putAll(this.mStyles);
        ArrayMap<String, Object> arrayMap = this.mBindingStyle;
        if (arrayMap != null) {
            wXStyle.mBindingStyle = new ArrayMap<>(arrayMap);
        }
        if (this.mPesudoStyleMap != null) {
            wXStyle.mPesudoStyleMap = new ArrayMap();
            for (Map.Entry<String, Map<String, Object>> entry : this.mPesudoStyleMap.entrySet()) {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.putAll(entry.getValue());
                wXStyle.mPesudoStyleMap.put(entry.getKey(), arrayMap2);
            }
        }
        if (this.mPesudoResetStyleMap != null) {
            ArrayMap arrayMap3 = new ArrayMap();
            wXStyle.mPesudoResetStyleMap = arrayMap3;
            arrayMap3.putAll(this.mPesudoResetStyleMap);
        }
        return wXStyle;
    }

    @Override // java.util.Map
    public Object put(String str, Object obj) {
        if (addBindingStyleIfStatement(str, obj)) {
            return null;
        }
        return this.mStyles.put(str, obj);
    }

    public void putAll(Map<? extends String, ?> map, boolean z) {
        this.mStyles.putAll(map);
        if (z) {
            return;
        }
        processPesudoClasses(map);
    }

    public WXStyle(Map<String, Object> map) {
        this.mStyles = map;
        processPesudoClasses(map);
    }

    public WXStyle(Map<String, Object> map, boolean z) {
        this();
        putAll(map, z);
    }
}
