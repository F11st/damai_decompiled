package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class gk implements go {
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private List<gk> f422a;

    /* renamed from: a  reason: collision with other field name */
    private String[] f423a;
    private String b;

    /* renamed from: b  reason: collision with other field name */
    private String[] f424b;
    private String c;

    public gk(String str, String str2, String[] strArr, String[] strArr2) {
        this.f423a = null;
        this.f424b = null;
        this.f422a = null;
        this.a = str;
        this.b = str2;
        this.f423a = strArr;
        this.f424b = strArr2;
    }

    public gk(String str, String str2, String[] strArr, String[] strArr2, String str3, List<gk> list) {
        this.f423a = null;
        this.f424b = null;
        this.f422a = null;
        this.a = str;
        this.b = str2;
        this.f423a = strArr;
        this.f424b = strArr2;
        this.c = str3;
        this.f422a = list;
    }

    public static gk a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            strArr[i] = str;
            strArr2[i] = bundle2.getString(str);
            i++;
        }
        if (bundle.containsKey(RichTextNode.CHILDREN)) {
            Parcelable[] parcelableArray = bundle.getParcelableArray(RichTextNode.CHILDREN);
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new gk(string, string2, strArr, strArr2, string3, arrayList);
    }

    public static Parcelable[] a(List<gk> list) {
        return a((gk[]) list.toArray(new gk[list.size()]));
    }

    public static Parcelable[] a(gk[] gkVarArr) {
        if (gkVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[gkVarArr.length];
        for (int i = 0; i < gkVarArr.length; i++) {
            parcelableArr[i] = gkVarArr[i].m922a();
        }
        return parcelableArr;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.a);
        bundle.putString("ext_ns", this.b);
        bundle.putString("ext_text", this.c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f423a;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.f423a;
                if (i >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i], this.f424b[i]);
                i++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<gk> list = this.f422a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray(RichTextNode.CHILDREN, a(this.f422a));
        }
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Parcelable m922a() {
        return a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m923a() {
        return this.a;
    }

    public String a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f423a == null) {
            return null;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.f423a;
            if (i >= strArr.length) {
                return null;
            }
            if (str.equals(strArr[i])) {
                return this.f424b[i];
            }
            i++;
        }
    }

    public void a(gk gkVar) {
        if (this.f422a == null) {
            this.f422a = new ArrayList();
        }
        if (this.f422a.contains(gkVar)) {
            return;
        }
        this.f422a.add(gkVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m924a(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = gy.a(str);
        }
        this.c = str;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return !TextUtils.isEmpty(this.c) ? gy.b(this.c) : this.c;
    }

    @Override // com.xiaomi.push.go
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.L);
        sb.append(this.a);
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" ");
            sb.append("xmlns=");
            sb.append("\"");
            sb.append(this.b);
            sb.append("\"");
        }
        String[] strArr = this.f423a;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < this.f423a.length; i++) {
                if (!TextUtils.isEmpty(this.f424b[i])) {
                    sb.append(" ");
                    sb.append(this.f423a[i]);
                    sb.append("=\"");
                    sb.append(gy.a(this.f424b[i]));
                    sb.append("\"");
                }
            }
        }
        if (TextUtils.isEmpty(this.c)) {
            List<gk> list = this.f422a;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
                return sb.toString();
            }
            sb.append(jn1.G);
            for (gk gkVar : this.f422a) {
                sb.append(gkVar.d());
            }
        } else {
            sb.append(jn1.G);
            sb.append(this.c);
        }
        sb.append("</");
        sb.append(this.a);
        sb.append(jn1.G);
        return sb.toString();
    }

    public String toString() {
        return d();
    }
}
