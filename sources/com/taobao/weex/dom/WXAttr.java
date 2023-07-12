package com.taobao.weex.dom;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.collection.ArrayMap;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXImageSharpen;
import com.taobao.weex.dom.binding.ELUtils;
import com.taobao.weex.dom.binding.WXStatement;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.LiveBundleLayout;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.pq1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXAttr implements Map<String, Object>, Cloneable {
    private static final long serialVersionUID = -2619357510079360946L;
    @NonNull
    private Map<String, Object> attr;
    private ArrayMap<String, Object> mBindingAttrs;
    private WXStatement mStatement;
    private Map<String, Object> writeAttr;

    public WXAttr() {
        this.attr = new HashMap();
    }

    private boolean addBindingAttrIfStatement(String str, Object obj) {
        for (String str2 : ELUtils.EXCLUDES_BINDING) {
            if (str.equals(str2)) {
                return false;
            }
        }
        if (ELUtils.isBinding(obj)) {
            if (this.mBindingAttrs == null) {
                this.mBindingAttrs = new ArrayMap<>();
            }
            this.mBindingAttrs.put(str, ELUtils.bindingBlock(obj));
            return true;
        } else if (WXStatement.WX_IF.equals(str)) {
            if (this.mStatement == null) {
                this.mStatement = new WXStatement();
            }
            if (obj != null) {
                this.mStatement.put(str, pq1.g(obj.toString()));
            }
            return true;
        } else {
            if (WXStatement.WX_FOR.equals(str)) {
                if (this.mStatement == null) {
                    this.mStatement = new WXStatement();
                }
                Object vforBlock = ELUtils.vforBlock(obj);
                if (vforBlock != null) {
                    this.mStatement.put(str, vforBlock);
                    return true;
                }
            }
            if (WXStatement.WX_ONCE.equals(str)) {
                if (this.mStatement == null) {
                    this.mStatement = new WXStatement();
                }
                this.mStatement.put(str, Boolean.TRUE);
            }
            return false;
        }
    }

    private Map<String, Object> filterStatementsFromAttrs(Map map) {
        if (map != null && map.size() != 0) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (ELUtils.COMPONENT_PROPS.equals(entry.getKey())) {
                    entry.setValue(ELUtils.bindingBlock(entry.getValue()));
                } else if (addBindingAttrIfStatement((String) entry.getKey(), entry.getValue())) {
                    it.remove();
                }
            }
        }
        return map;
    }

    public static String getPrefix(Map<String, Object> map) {
        Object obj;
        if (map == null || (obj = map.get(Constants.Name.PREFIX)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static String getSuffix(Map<String, Object> map) {
        Object obj;
        if (map == null || (obj = map.get(Constants.Name.SUFFIX)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static String getValue(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get("value");
        if (obj == null && (obj = map.get("content")) == null) {
            return null;
        }
        return obj.toString();
    }

    public boolean autoPlay() {
        Object obj = get(Constants.Name.AUTO_PLAY);
        if (obj == null) {
            return false;
        }
        try {
            return Boolean.parseBoolean(String.valueOf(obj));
        } catch (Exception e) {
            WXLogUtils.e("[WXAttr] autoPlay:", e);
            return false;
        }
    }

    public boolean canRecycled() {
        Object obj = get(Constants.Name.RECYCLE);
        if (obj == null) {
            return true;
        }
        try {
            return Boolean.parseBoolean(String.valueOf(obj));
        } catch (Exception e) {
            WXLogUtils.e("[WXAttr] recycle:", e);
            return true;
        }
    }

    @Override // java.util.Map
    public void clear() {
        this.attr.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.attr.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.attr.containsValue(obj);
    }

    @Override // java.util.Map
    @NonNull
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.attr.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.attr.equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        Object obj2;
        Map<String, Object> map = this.writeAttr;
        return (map == null || (obj2 = map.get(obj)) == null) ? this.attr.get(obj) : obj2;
    }

    public ArrayMap<String, Object> getBindingAttrs() {
        return this.mBindingAttrs;
    }

    public int getColumnCount() {
        Object obj = get(Constants.Name.COLUMN_COUNT);
        if (obj == null) {
            return -1;
        }
        String valueOf = String.valueOf(obj);
        if ("auto".equals(valueOf)) {
            return -1;
        }
        try {
            int parseInt = Integer.parseInt(valueOf);
            if (parseInt > 0) {
                return parseInt;
            }
            return -1;
        } catch (Exception e) {
            WXLogUtils.e("[WXAttr] getColumnCount:", e);
            return -1;
        }
    }

    public float getColumnGap() {
        Object obj = get(Constants.Name.COLUMN_GAP);
        if (obj == null) {
            return 32.0f;
        }
        String valueOf = String.valueOf(obj);
        if ("normal".equals(valueOf)) {
            return 32.0f;
        }
        try {
            float parseFloat = Float.parseFloat(valueOf);
            if (parseFloat >= 0.0f) {
                return parseFloat;
            }
            return -1.0f;
        } catch (Exception e) {
            WXLogUtils.e("[WXAttr] getColumnGap:", e);
            return 32.0f;
        }
    }

    public float getColumnWidth() {
        Object obj = get(Constants.Name.COLUMN_WIDTH);
        if (obj == null) {
            return -1.0f;
        }
        String valueOf = String.valueOf(obj);
        if ("auto".equals(valueOf)) {
            return -1.0f;
        }
        try {
            float parseFloat = Float.parseFloat(valueOf);
            if (parseFloat > 0.0f) {
                return parseFloat;
            }
            return 0.0f;
        } catch (Exception e) {
            WXLogUtils.e("[WXAttr] getColumnWidth:", e);
            return -1.0f;
        }
    }

    public float getElevation(int i) {
        Object obj = get("elevation");
        if (obj != null) {
            String obj2 = obj.toString();
            if (TextUtils.isEmpty(obj2)) {
                return 0.0f;
            }
            return WXViewUtils.getRealSubPxByWidth(WXUtils.getFloat(obj2), i);
        }
        return Float.NaN;
    }

    public WXImageQuality getImageQuality() {
        String str = Constants.Name.QUALITY;
        if (!containsKey(Constants.Name.QUALITY)) {
            str = Constants.Name.IMAGE_QUALITY;
        }
        Object obj = get(str);
        WXImageQuality wXImageQuality = WXImageQuality.AUTO;
        if (obj != null) {
            String obj2 = obj.toString();
            if (TextUtils.isEmpty(obj2)) {
                return wXImageQuality;
            }
            try {
                return WXImageQuality.valueOf(obj2.toUpperCase(Locale.US));
            } catch (IllegalArgumentException unused) {
                WXLogUtils.e(BizTime.IMAGE, "Invalid value image quality. Only low, normal, high, original are valid");
                return wXImageQuality;
            }
        }
        return wXImageQuality;
    }

    public WXImageSharpen getImageSharpen() {
        Object obj = get(Constants.Name.SHARPEN);
        if (obj == null) {
            obj = get(Constants.Name.IMAGE_SHARPEN);
        }
        if (obj == null) {
            return WXImageSharpen.UNSHARPEN;
        }
        return obj.toString().equals(Constants.Name.SHARPEN) ? WXImageSharpen.SHARPEN : WXImageSharpen.UNSHARPEN;
    }

    public String getImageSrc() {
        Object obj = get("src");
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public boolean getIsRecycleImage() {
        Object obj = get(Constants.Name.RECYCLE_IMAGE);
        if (obj == null) {
            return true;
        }
        try {
            return Boolean.parseBoolean(String.valueOf(obj));
        } catch (Exception e) {
            WXLogUtils.e("[WXAttr] recycleImage:", e);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        if (r2 == 1) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
        return 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getLayoutType() {
        /*
            r5 = this;
            java.lang.String r0 = "layout"
            java.lang.Object r0 = r5.get(r0)
            r1 = 1
            if (r0 != 0) goto La
            return r1
        La:
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Exception -> L3a
            r2 = -1
            int r3 = r0.hashCode()     // Catch: java.lang.Exception -> L3a
            r4 = 3181382(0x308b46, float:4.458066E-39)
            if (r3 == r4) goto L28
            r4 = 674874986(0x2839c66a, float:1.0312587E-14)
            if (r3 == r4) goto L1e
            goto L31
        L1e:
            java.lang.String r3 = "multi-column"
            boolean r0 = r0.equals(r3)     // Catch: java.lang.Exception -> L3a
            if (r0 == 0) goto L31
            r2 = 0
            goto L31
        L28:
            java.lang.String r3 = "grid"
            boolean r0 = r0.equals(r3)     // Catch: java.lang.Exception -> L3a
            if (r0 == 0) goto L31
            r2 = 1
        L31:
            if (r2 == 0) goto L38
            if (r2 == r1) goto L36
            return r1
        L36:
            r0 = 2
            return r0
        L38:
            r0 = 3
            return r0
        L3a:
            r0 = move-exception
            java.lang.String r2 = "[WXAttr] getLayoutType:"
            com.taobao.weex.utils.WXLogUtils.e(r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.dom.WXAttr.getLayoutType():int");
    }

    public String getLoadMoreOffset() {
        Object obj = get("loadmoreoffset");
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public String getLoadMoreRetry() {
        Object obj = get(Constants.Name.LOADMORERETRY);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public int getOrientation() {
        String scrollDirection = getScrollDirection();
        if (TextUtils.isEmpty(scrollDirection) || !scrollDirection.equals(Constants.Value.HORIZONTAL)) {
            Object obj = get("orientation");
            return (obj == null || !Constants.Value.HORIZONTAL.equals(obj.toString())) ? 1 : 0;
        }
        return 0;
    }

    public String getScope() {
        Object obj = get("scope");
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public String getScrollDirection() {
        Object obj = get(Constants.Name.SCROLL_DIRECTION);
        return obj == null ? LiveBundleLayout.TYPE_VERTICAL : obj.toString();
    }

    public WXStatement getStatement() {
        return this.mStatement;
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.attr.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.attr.isEmpty();
    }

    @Override // java.util.Map
    @NonNull
    public Set<String> keySet() {
        return this.attr.keySet();
    }

    @UiThread
    public void mergeAttr() {
        Map<String, Object> map = this.writeAttr;
        if (map != null) {
            this.attr.putAll(map);
            this.writeAttr = null;
        }
    }

    public String optString(String str) {
        if (containsKey(str)) {
            Object obj = get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            return obj != null ? String.valueOf(obj) : "";
        }
        return "";
    }

    public void parseStatements() {
        Map<String, Object> map = this.attr;
        if (map != null) {
            this.attr = filterStatementsFromAttrs(map);
        }
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        if (this.writeAttr == null) {
            this.writeAttr = new ArrayMap();
        }
        this.writeAttr.putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.attr.remove(obj);
    }

    public void setBindingAttrs(ArrayMap<String, Object> arrayMap) {
        this.mBindingAttrs = arrayMap;
    }

    public void setStatement(WXStatement wXStatement) {
        this.mStatement = wXStatement;
    }

    public boolean showIndicators() {
        Object obj = get(Constants.Name.SHOW_INDICATORS);
        if (obj == null) {
            return true;
        }
        try {
            return Boolean.parseBoolean(String.valueOf(obj));
        } catch (Exception e) {
            WXLogUtils.e("[WXAttr] showIndicators:", e);
            return true;
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.attr.size();
    }

    public void skipFilterPutAll(Map<String, Object> map) {
        this.attr.putAll(map);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String toString() {
        return this.attr.toString();
    }

    @Override // java.util.Map
    @NonNull
    public Collection<Object> values() {
        return this.attr.values();
    }

    /* renamed from: clone */
    public WXAttr m578clone() {
        WXAttr wXAttr = new WXAttr();
        wXAttr.skipFilterPutAll(this.attr);
        ArrayMap<String, Object> arrayMap = this.mBindingAttrs;
        if (arrayMap != null) {
            wXAttr.mBindingAttrs = new ArrayMap<>(arrayMap);
        }
        WXStatement wXStatement = this.mStatement;
        if (wXStatement != null) {
            wXAttr.mStatement = new WXStatement(wXStatement);
        }
        return wXAttr;
    }

    @Override // java.util.Map
    public Object put(String str, Object obj) {
        if (addBindingAttrIfStatement(str, obj)) {
            return null;
        }
        return this.attr.put(str, obj);
    }

    public WXAttr(@NonNull Map<String, Object> map) {
        this.attr = map;
    }

    public WXAttr(@NonNull Map<String, Object> map, int i) {
        this.attr = map;
    }
}
