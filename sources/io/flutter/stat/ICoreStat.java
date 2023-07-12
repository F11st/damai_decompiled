package io.flutter.stat;

import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes3.dex */
public interface ICoreStat {

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes3.dex */
    public static abstract class CustomStat {
        private static CustomStat sInstance;

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public enum WALogType {
            SCENE(1),
            EVENT(2);
            
            private int mValue;

            WALogType(int i) {
                this.mValue = 0;
                this.mValue = i;
            }

            public int value() {
                return this.mValue;
            }
        }

        public static CustomStat getInstance() {
            return sInstance;
        }

        public static void setInstance(CustomStat customStat) {
            sInstance = customStat;
        }

        public abstract void WaStat(WaData waData);
    }

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes3.dex */
    public static class WaData {
        public String category;
        public String eventAction;
        public String eventCategory;
        public HashMap<String, String> extValues;
        public HashMap<String, String> values;

        public WaData(String str, String str2, String str3, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
            this.category = null;
            this.eventCategory = null;
            this.eventAction = null;
            this.values = null;
            this.extValues = null;
            this.category = str;
            this.eventCategory = str2;
            this.eventAction = str3;
            this.values = hashMap;
            this.extValues = hashMap2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.category != null) {
                sb.append("`ct=");
                sb.append(this.category);
            }
            if (this.eventCategory != null) {
                sb.append("`ev_ct=");
                sb.append(this.eventCategory);
            }
            if (this.eventAction != null) {
                sb.append("`ev_ac=");
                sb.append(this.eventAction);
            }
            sb.append("`");
            HashMap<String, String> hashMap = this.extValues;
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (key != null && !"".equals(key)) {
                        sb.append(key);
                        sb.append("=");
                        if (value == null) {
                            value = "";
                        }
                        sb.append(value);
                        sb.append("`");
                    }
                }
            }
            HashMap<String, String> hashMap2 = this.values;
            if (hashMap2 != null) {
                for (Map.Entry<String, String> entry2 : hashMap2.entrySet()) {
                    String key2 = entry2.getKey();
                    String value2 = entry2.getValue();
                    if (key2 != null && !"".equals(key2)) {
                        sb.append(key2);
                        sb.append("=");
                        if (value2 == null) {
                            value2 = "";
                        }
                        sb.append(value2);
                        sb.append("`");
                    }
                }
            }
            return sb.toString();
        }
    }
}
