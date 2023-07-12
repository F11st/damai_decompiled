package com.alibaba.motu.crashreporter;

import com.alibaba.motu.crashreporter.Options.Option;
import com.alibaba.motu.tbrest.utils.StringUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class Options<T extends Option> {
    Map<String, T> mData;

    Options() {
        this(false);
    }

    public void add(T t) {
        if (t == null || !StringUtils.isNotBlank(t.name) || t.value == null) {
            return;
        }
        T t2 = this.mData.get(t.name);
        if (t2 == null || !(t2 == null || t2.readOnly)) {
            this.mData.put(t.name, t);
        }
    }

    public boolean getBoolean(String str, boolean z) {
        try {
            Object value = getValue(str);
            if (value instanceof Boolean) {
                return ((Boolean) value).booleanValue();
            }
        } catch (Exception unused) {
        }
        return z;
    }

    public int getInt(String str, int i) {
        Object value;
        try {
            value = getValue(str);
        } catch (Exception unused) {
        }
        if (value instanceof Integer) {
            return ((Integer) value).intValue();
        }
        if (value instanceof String) {
            return Integer.parseInt((String) value);
        }
        return i;
    }

    public String getString(String str, String str2) {
        try {
            Object value = getValue(str);
            if (value instanceof String) {
                return (String) value;
            }
        } catch (Exception unused) {
        }
        return str2;
    }

    public Object getValue(String str) {
        T t = this.mData.get(str);
        if (t != null) {
            return t.value;
        }
        return null;
    }

    public void remove(T t) {
        if (t == null || !StringUtils.isBlank(t.name)) {
            return;
        }
        this.mData.remove(t.name);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Options(boolean z) {
        if (z) {
            this.mData = new ConcurrentHashMap();
        } else {
            this.mData = new HashMap();
        }
    }

    public Object getValue(String str, Object obj) {
        Object value = getValue(str);
        return value != null ? value : obj;
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class Option {
        String name;
        boolean readOnly;
        Object value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Option(String str, Object obj, boolean z) {
            this.name = str;
            this.value = obj;
            this.readOnly = z;
        }

        public Option(String str, Object obj) {
            this(str, obj, false);
        }
    }
}
