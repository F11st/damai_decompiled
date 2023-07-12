package com.alibaba.wireless.security.aopsdk.e.f;

import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.h.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: ConditionConfig.java */
/* loaded from: classes.dex */
public class b extends a {
    public Map<Integer, Pattern> d;
    public Map<String, Pattern> e;
    public Pattern f;

    public boolean a(Invocation invocation) {
        boolean z;
        boolean z2;
        boolean z3;
        Pattern pattern;
        com.alibaba.wireless.security.aopsdk.i.a.b(a.c, "Argfilter=" + this.d + ", StackFilter=" + this.f);
        Map<Integer, Pattern> map = this.d;
        if (map != null && !map.isEmpty()) {
            Object[] objArr = invocation.args;
            for (int i = 0; i < objArr.length; i++) {
                Pattern pattern2 = this.d.get(Integer.valueOf(i));
                if (pattern2 != null && !pattern2.matcher(com.alibaba.wireless.security.aopsdk.i.b.a(objArr[i])).find()) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            String a = com.alibaba.wireless.security.aopsdk.h.a.a(a.b.STACK_TRACE, invocation);
            z2 = a != null && ((pattern = this.f) == null || pattern.matcher(a).find());
        } else {
            z2 = false;
        }
        Map<String, Pattern> map2 = this.e;
        if (map2 != null) {
            for (String str : map2.keySet()) {
                Pattern pattern3 = this.e.get(str);
                if (pattern3 != null) {
                    com.alibaba.wireless.security.aopsdk.i.a.b(a.c, "Filter for " + str + " = " + pattern3);
                    String a2 = com.alibaba.wireless.security.aopsdk.h.a.a(str, invocation);
                    if (a2 == null || !pattern3.matcher(a2).find()) {
                        z3 = false;
                        break;
                    }
                }
            }
        }
        z3 = true;
        com.alibaba.wireless.security.aopsdk.i.a.b(a.c, "ArgMatch=" + z + ", StackMatch=" + z2 + ", OtherMatch=" + z3);
        return z && z2 && z3;
    }

    @Override // com.alibaba.wireless.security.aopsdk.e.f.a
    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                next.hashCode();
                if (next.equals("arg")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("arg");
                    if (optJSONObject != null) {
                        this.d = new HashMap();
                        Iterator<String> keys2 = optJSONObject.keys();
                        while (keys2.hasNext()) {
                            try {
                                String next2 = keys2.next();
                                Integer valueOf = Integer.valueOf(Integer.parseInt(next2));
                                String string = optJSONObject.getString(next2);
                                if (!TextUtils.isEmpty(string)) {
                                    this.d.put(valueOf, Pattern.compile(string));
                                }
                            } catch (Throwable th) {
                            }
                        }
                    } else {
                        return;
                    }
                } else if (!next.equals("stack")) {
                    if (this.e == null) {
                        this.e = new HashMap();
                    }
                    String optString = jSONObject.optString(next);
                    if (!TextUtils.isEmpty(optString)) {
                        this.e.put(next, Pattern.compile(optString));
                    }
                } else {
                    String optString2 = jSONObject.optString("stack");
                    if (!TextUtils.isEmpty(optString2)) {
                        this.f = Pattern.compile(optString2);
                    }
                }
            }
        }
    }
}
