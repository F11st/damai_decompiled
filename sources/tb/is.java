package tb;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import com.taobao.android.ultron.datamodel.IDMRequester;
import com.taobao.android.ultron.datamodel.imp.DMRequester;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class is {
    public static final String NAMESPACE = "trade_debug";
    String a;
    String b;
    String e;
    String f;
    int g;
    Map<String, String> j;
    Map<String, String> k;
    IDMContext m;
    IDMComponent p;
    Class<?> q;
    Context s;
    SharedPreferences t;
    boolean c = true;
    boolean d = true;
    boolean h = true;
    boolean i = false;
    String l = "default";
    boolean n = false;
    boolean o = false;
    boolean r = true;

    public is(Context context) {
        this.s = context;
        if (r40.a(context)) {
            this.t = this.s.getSharedPreferences(NAMESPACE, 0);
        }
    }

    private boolean g() {
        String str;
        String str2 = this.a;
        return str2 != null && str2.length() > 0 && (str = this.b) != null && str.length() > 0;
    }

    public boolean A() {
        return this.i;
    }

    public is B(boolean z) {
        this.d = z;
        return this;
    }

    public is C(boolean z) {
        this.c = z;
        return this;
    }

    public is D(Map<String, String> map) {
        this.j = map;
        return this;
    }

    public is E(boolean z) {
        this.h = z;
        return this;
    }

    public is F(Map<String, String> map) {
        this.k = map;
        return this;
    }

    public is G(String str) {
        this.f = str;
        return this;
    }

    public is H(boolean z) {
        this.i = z;
        return this;
    }

    public is I(String str) {
        this.b = str;
        return this;
    }

    public is a(String str) {
        this.a = str;
        return this;
    }

    public is b(int i) {
        this.g = i;
        return this;
    }

    public IDMRequester c() {
        if (g()) {
            return new DMRequester(this);
        }
        return null;
    }

    public IDMRequester d(IDMComponent iDMComponent, IDMContext iDMContext) {
        if (g() && iDMContext != null) {
            this.p = iDMComponent;
            this.n = true;
            this.m = iDMContext;
            return new DMRequester(this);
        }
        return null;
    }

    public IDMRequester e(IDMContext iDMContext) {
        if (g() && iDMContext != null) {
            this.m = iDMContext;
            return new DMRequester(this);
        }
        return null;
    }

    public IDMRequester f(Class<?> cls, IDMContext iDMContext) {
        if (g() && iDMContext != null) {
            this.o = true;
            this.q = cls;
            this.m = iDMContext;
            return new DMRequester(this);
        }
        return null;
    }

    public is h(String str) {
        this.e = str;
        return this;
    }

    public String i() {
        if (r40.a(this.s)) {
            SharedPreferences sharedPreferences = this.t;
            String str = this.a;
            return sharedPreferences.getString(str, str);
        }
        return this.a;
    }

    public int j() {
        return this.g;
    }

    public String k() {
        return this.l;
    }

    public Context l() {
        return this.s;
    }

    public IDMContext m() {
        return this.m;
    }

    public String n() {
        return this.e;
    }

    public Map<String, String> o() {
        return this.k;
    }

    public Map<String, String> p() {
        return this.j;
    }

    public Class<?> q() {
        return this.q;
    }

    public IDMComponent r() {
        return this.p;
    }

    public String s() {
        return this.f;
    }

    public String t() {
        if (r40.a(this.s)) {
            SharedPreferences sharedPreferences = this.t;
            return sharedPreferences.getString(this.a + ".version", this.b);
        }
        return this.b;
    }

    public boolean u() {
        return this.n;
    }

    public boolean v() {
        return this.r;
    }

    public boolean w() {
        return this.d;
    }

    public boolean x() {
        return this.c;
    }

    public boolean y() {
        return this.h;
    }

    public boolean z() {
        return this.o;
    }
}
