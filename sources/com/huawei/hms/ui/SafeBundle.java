package com.huawei.hms.ui;

import android.os.Bundle;
import com.huawei.hms.base.ui.C5543a;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SafeBundle {
    public final Bundle a;

    public SafeBundle() {
        this(new Bundle());
    }

    public boolean containsKey(String str) {
        try {
            return this.a.containsKey(str);
        } catch (Exception unused) {
            C5543a.a("SafeBundle", "containsKey exception. key:");
            return false;
        }
    }

    public Object get(String str) {
        try {
            return this.a.get(str);
        } catch (Exception e) {
            C5543a.a("SafeBundle", "get exception: " + e.getMessage(), true);
            return null;
        }
    }

    public Bundle getBundle() {
        return this.a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public String getString(String str) {
        try {
            return this.a.getString(str);
        } catch (Exception e) {
            C5543a.a("SafeBundle", "getString exception: " + e.getMessage(), true);
            return "";
        }
    }

    public boolean isEmpty() {
        try {
            return this.a.isEmpty();
        } catch (Exception unused) {
            C5543a.a("SafeBundle", "isEmpty exception");
            return true;
        }
    }

    public int size() {
        try {
            return this.a.size();
        } catch (Exception unused) {
            C5543a.a("SafeBundle", "size exception");
            return 0;
        }
    }

    public String toString() {
        return this.a.toString();
    }

    public SafeBundle(Bundle bundle) {
        this.a = bundle == null ? new Bundle() : bundle;
    }

    public int getInt(String str, int i) {
        try {
            return this.a.getInt(str, i);
        } catch (Exception e) {
            C5543a.a("SafeBundle", "getInt exception: " + e.getMessage(), true);
            return i;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.a.getString(str, str2);
        } catch (Exception e) {
            C5543a.a("SafeBundle", "getString exception: " + e.getMessage(), true);
            return str2;
        }
    }
}
