package cn.damai.uikit.calendar;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private boolean n;
    private Drawable b = null;
    private Drawable c = null;
    private final LinkedList<C0088a> d = new LinkedList<>();
    private boolean e = false;
    private boolean f = false;
    private Drawable g = null;
    private Drawable h = null;
    private boolean a = false;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.calendar.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    static class C0088a {
        final Object a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1488502659")) {
            ipChange.ipc$dispatch("-1488502659", new Object[]{this, aVar});
            return;
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            aVar.t(drawable);
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            aVar.r(drawable2);
        }
        aVar.d.addAll(this.d);
        aVar.a |= this.a;
        aVar.e = this.e;
        aVar.f = this.f;
        aVar.g = this.g;
        aVar.h = this.h;
        aVar.i = this.i;
        aVar.j = this.j;
        aVar.k = this.k;
        aVar.l = this.l;
        aVar.m = this.m;
        aVar.n = this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2080579564")) {
            ipChange.ipc$dispatch("-2080579564", new Object[]{this, aVar});
            return;
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            aVar.t(drawable);
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            aVar.r(drawable2);
        }
        aVar.d.addAll(this.d);
        aVar.a |= this.a;
        aVar.e = this.e;
        boolean z = this.f;
        if (z) {
            aVar.f = z;
        }
        Drawable drawable3 = this.g;
        if (drawable3 != null) {
            aVar.g = drawable3;
        }
        Drawable drawable4 = this.h;
        if (drawable4 != null) {
            aVar.h = drawable4;
        }
        String str = this.i;
        if (str != null) {
            aVar.i = str;
        }
        String str2 = this.j;
        if (str2 != null) {
            aVar.j = str2;
        }
        String str3 = this.k;
        if (str3 != null) {
            aVar.k = str3;
        }
        String str4 = this.l;
        if (str4 != null) {
            aVar.l = str4;
        }
        String str5 = this.m;
        if (str5 != null) {
            aVar.m = str5;
        }
        boolean z2 = this.n;
        if (z2) {
            aVar.n = z2;
        }
    }

    public boolean c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1582721224") ? ((Boolean) ipChange.ipc$dispatch("-1582721224", new Object[]{this})).booleanValue() : this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1719669697") ? (Drawable) ipChange.ipc$dispatch("1719669697", new Object[]{this}) : this.b;
    }

    public String e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1328618638") ? (String) ipChange.ipc$dispatch("-1328618638", new Object[]{this}) : this.m;
    }

    public boolean f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-651359414")) {
            return ((Boolean) ipChange.ipc$dispatch("-651359414", new Object[]{this})).booleanValue();
        }
        String str = this.l;
        return str != null && str.equals("1");
    }

    public boolean g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-315719781")) {
            return ((Boolean) ipChange.ipc$dispatch("-315719781", new Object[]{this})).booleanValue();
        }
        String str = this.k;
        return str != null && str.equals("1");
    }

    public boolean h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-537620408")) {
            return ((Boolean) ipChange.ipc$dispatch("-537620408", new Object[]{this})).booleanValue();
        }
        String str = this.j;
        return str != null && str.equals("1");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-414651531") ? (Drawable) ipChange.ipc$dispatch("-414651531", new Object[]{this}) : this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1195499093") ? (Drawable) ipChange.ipc$dispatch("1195499093", new Object[]{this}) : this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1457400096") ? (String) ipChange.ipc$dispatch("-1457400096", new Object[]{this}) : this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2090198977") ? (Drawable) ipChange.ipc$dispatch("-2090198977", new Object[]{this}) : this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<C0088a> m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "491039659") ? (List) ipChange.ipc$dispatch("491039659", new Object[]{this}) : Collections.unmodifiableList(this.d);
    }

    public boolean n() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2032683059") ? ((Boolean) ipChange.ipc$dispatch("2032683059", new Object[]{this})).booleanValue() : this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1168706574") ? ((Boolean) ipChange.ipc$dispatch("-1168706574", new Object[]{this})).booleanValue() : this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2011316466") ? ((Boolean) ipChange.ipc$dispatch("2011316466", new Object[]{this})).booleanValue() : this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "463780044")) {
            ipChange.ipc$dispatch("463780044", new Object[]{this});
            return;
        }
        this.b = null;
        this.c = null;
        this.d.clear();
        this.a = false;
        this.e = false;
        this.f = false;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = false;
    }

    public void r(@NonNull Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-569900431")) {
            ipChange.ipc$dispatch("-569900431", new Object[]{this, drawable});
        } else if (drawable != null) {
            this.b = drawable;
            this.a = true;
        } else {
            throw new IllegalArgumentException("Cannot be null");
        }
    }

    public void s(@NonNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1354209164")) {
            ipChange.ipc$dispatch("-1354209164", new Object[]{this, str});
            return;
        }
        this.m = str;
        this.a = true;
    }

    public void t(@NonNull Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-558457269")) {
            ipChange.ipc$dispatch("-558457269", new Object[]{this, drawable});
        } else if (drawable != null) {
            this.c = drawable;
            this.a = true;
        } else {
            throw new IllegalArgumentException("Cannot be null");
        }
    }
}
