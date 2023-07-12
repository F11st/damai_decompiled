package org.apache.commons.text;

import java.util.Map;
import java.util.ResourceBundle;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class StrLookup<V> {
    private static final StrLookup<String> NONE_LOOKUP = new MapStrLookup(null);
    private static final StrLookup<String> SYSTEM_PROPERTIES_LOOKUP = new SystemPropertiesStrLookup();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    static class MapStrLookup<V> extends StrLookup<V> {
        private final Map<String, V> map;

        MapStrLookup(Map<String, V> map) {
            this.map = map;
        }

        @Override // org.apache.commons.text.StrLookup
        public String lookup(String str) {
            V v;
            Map<String, V> map = this.map;
            if (map == null || (v = map.get(str)) == null) {
                return null;
            }
            return v.toString();
        }

        public String toString() {
            return super.toString() + " [map=" + this.map + jn1.ARRAY_END_STR;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static final class ResourceBundleLookup extends StrLookup<String> {
        private final ResourceBundle resourceBundle;

        @Override // org.apache.commons.text.StrLookup
        public String lookup(String str) {
            ResourceBundle resourceBundle = this.resourceBundle;
            if (resourceBundle == null || str == null || !resourceBundle.containsKey(str)) {
                return null;
            }
            return this.resourceBundle.getString(str);
        }

        public String toString() {
            return super.toString() + " [resourceBundle=" + this.resourceBundle + jn1.ARRAY_END_STR;
        }

        private ResourceBundleLookup(ResourceBundle resourceBundle) {
            this.resourceBundle = resourceBundle;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static final class SystemPropertiesStrLookup extends StrLookup<String> {
        private SystemPropertiesStrLookup() {
        }

        @Override // org.apache.commons.text.StrLookup
        public String lookup(String str) {
            if (str.length() > 0) {
                try {
                    return System.getProperty(str);
                } catch (SecurityException unused) {
                }
            }
            return null;
        }
    }

    protected StrLookup() {
    }

    public static <V> StrLookup<V> mapLookup(Map<String, V> map) {
        return new MapStrLookup(map);
    }

    public static StrLookup<?> noneLookup() {
        return NONE_LOOKUP;
    }

    public static StrLookup<String> resourceBundleLookup(ResourceBundle resourceBundle) {
        return new ResourceBundleLookup(resourceBundle);
    }

    public static StrLookup<String> systemPropertiesLookup() {
        return SYSTEM_PROPERTIES_LOOKUP;
    }

    public abstract String lookup(String str);
}
