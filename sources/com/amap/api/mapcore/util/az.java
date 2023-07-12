package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.mapcore.util.br;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class az extends OfflineMapCity implements bi, bz {
    public static final Parcelable.Creator<az> o = new Parcelable.Creator<az>() { // from class: com.amap.api.mapcore.util.az.2
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public az createFromParcel(Parcel parcel) {
            return new az(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public az[] newArray(int i) {
            return new az[i];
        }
    };
    public final AbstractC4497cd a;
    public final AbstractC4497cd b;
    public final AbstractC4497cd c;
    public final AbstractC4497cd d;
    public final AbstractC4497cd e;
    public final AbstractC4497cd f;
    public final AbstractC4497cd g;
    public final AbstractC4497cd h;
    public final AbstractC4497cd i;
    public final AbstractC4497cd j;
    public final AbstractC4497cd k;
    AbstractC4497cd l;
    Context m;
    boolean n;
    private String p;
    private String q;
    private long r;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.az$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ca.EnumC4496a.values().length];
            a = iArr;
            try {
                iArr[ca.EnumC4496a.amap_exception.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ca.EnumC4496a.file_io_exception.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ca.EnumC4496a.network_exception.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public az(Context context, OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        setVersion(offlineMapCity.getVersion());
        setSize(offlineMapCity.getSize());
        setCode(offlineMapCity.getCode());
        setJianpin(offlineMapCity.getJianpin());
        setPinyin(offlineMapCity.getPinyin());
        t();
    }

    @Override // com.amap.api.mapcore.util.bz
    public String A() {
        return getAdcode();
    }

    @Override // com.amap.api.mapcore.util.bt
    public String B() {
        return u();
    }

    @Override // com.amap.api.mapcore.util.bt
    public String C() {
        return v();
    }

    @Override // com.amap.api.mapcore.util.bi
    public String b() {
        return getUrl();
    }

    public AbstractC4497cd c() {
        return this.l;
    }

    public void d() {
        ba a = ba.a(this.m);
        if (a != null) {
            a.c(this);
        }
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e() {
        ba a = ba.a(this.m);
        if (a != null) {
            a.e(this);
            d();
        }
    }

    public void f() {
        bx.a("CityOperation current State==>" + c().b());
        if (this.l.equals(this.d)) {
            this.l.d();
        } else if (this.l.equals(this.c)) {
            this.l.e();
        } else if (!this.l.equals(this.g) && !this.l.equals(this.h)) {
            if (!this.l.equals(this.j) && !this.l.equals(this.i) && !this.l.a(this.k)) {
                c().h();
            } else {
                this.l.c();
            }
        } else {
            k();
            this.n = true;
        }
    }

    public void g() {
        this.l.e();
    }

    public void h() {
        this.l.a(this.k.b());
    }

    public void i() {
        this.l.a();
        if (this.n) {
            this.l.h();
        }
        this.n = false;
    }

    public void j() {
        this.l.equals(this.f);
        this.l.f();
    }

    public void k() {
        ba a = ba.a(this.m);
        if (a != null) {
            a.a(this);
        }
    }

    public void l() {
        ba a = ba.a(this.m);
        if (a != null) {
            a.b(this);
        }
    }

    public void m() {
        ba a = ba.a(this.m);
        if (a != null) {
            a.d(this);
        }
    }

    @Override // com.amap.api.mapcore.util.ca
    public void n() {
        this.r = 0L;
        if (!this.l.equals(this.b)) {
            bx.a("state must be waiting when download onStart");
        }
        this.l.c();
    }

    @Override // com.amap.api.mapcore.util.ca
    public void o() {
        if (!this.l.equals(this.c)) {
            bx.a("state must be Loading when download onFinish");
        }
        this.l.g();
    }

    @Override // com.amap.api.mapcore.util.ca
    public void p() {
        e();
    }

    @Override // com.amap.api.mapcore.util.bs
    public void q() {
        this.r = 0L;
        setCompleteCode(0);
        this.l.equals(this.e);
        this.l.c();
    }

    @Override // com.amap.api.mapcore.util.bs
    public void r() {
        this.l.equals(this.e);
        this.l.a(this.h.b());
    }

    @Override // com.amap.api.mapcore.util.bs
    public void s() {
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        String str = ba.a;
        String c = bx.c(getUrl());
        if (c != null) {
            this.p = str + c + ".zip.tmp";
            return;
        }
        this.p = str + getPinyin() + ".zip.tmp";
    }

    public String u() {
        if (TextUtils.isEmpty(this.p)) {
            return null;
        }
        String str = this.p;
        return str.substring(0, str.lastIndexOf("."));
    }

    public String v() {
        if (TextUtils.isEmpty(this.p)) {
            return null;
        }
        String u = u();
        return u.substring(0, u.lastIndexOf(46));
    }

    public boolean w() {
        bx.a();
        getSize();
        getcompleteCode();
        getSize();
        return false;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.q);
    }

    public bk x() {
        setState(this.l.b());
        bk bkVar = new bk(this, this.m);
        bkVar.a(a());
        bx.a("vMapFileNames: " + a());
        return bkVar;
    }

    @Override // com.amap.api.mapcore.util.bz
    public boolean y() {
        return w();
    }

    @Override // com.amap.api.mapcore.util.bz
    public String z() {
        StringBuffer stringBuffer = new StringBuffer();
        String c = bx.c(getUrl());
        if (c != null) {
            stringBuffer.append(c);
        } else {
            stringBuffer.append(getPinyin());
        }
        stringBuffer.append(".zip");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.mapcore.util.bs
    public void b(String str) {
        this.l.equals(this.e);
        this.q = str;
        String u = u();
        String v = v();
        if (!TextUtils.isEmpty(u) && !TextUtils.isEmpty(v)) {
            File file = new File(v + "/");
            File file2 = new File(eq.a(this.m) + File.separator + "map/");
            File file3 = new File(eq.a(this.m));
            if (file3.exists() || file3.mkdir()) {
                if (file2.exists() || file2.mkdir()) {
                    a(file, file2, u);
                    return;
                }
                return;
            }
            return;
        }
        r();
    }

    public void a(String str) {
        this.q = str;
    }

    public String a() {
        return this.q;
    }

    public void a(int i) {
        if (i == -1) {
            this.l = this.h;
        } else if (i == 0) {
            this.l = this.c;
        } else if (i == 1) {
            this.l = this.e;
        } else if (i == 2) {
            this.l = this.b;
        } else if (i == 3) {
            this.l = this.d;
        } else if (i == 4) {
            this.l = this.f;
        } else if (i == 6) {
            this.l = this.a;
        } else if (i != 7) {
            switch (i) {
                case 101:
                    this.l = this.i;
                    break;
                case 102:
                    this.l = this.j;
                    break;
                case 103:
                    this.l = this.k;
                    break;
                default:
                    if (i < 0) {
                        this.l = this.h;
                        break;
                    }
                    break;
            }
        } else {
            this.l = this.g;
        }
        setState(i);
    }

    public az(Context context, int i) {
        this.a = new cf(6, this);
        this.b = new cm(2, this);
        this.c = new ci(0, this);
        this.d = new ck(3, this);
        this.e = new cl(1, this);
        this.f = new ce(4, this);
        this.g = new cj(7, this);
        this.h = new cg(-1, this);
        this.i = new cg(101, this);
        this.j = new cg(102, this);
        this.k = new cg(103, this);
        this.p = null;
        this.q = "";
        this.n = false;
        this.r = 0L;
        this.m = context;
        a(i);
    }

    public AbstractC4497cd b(int i) {
        switch (i) {
            case 101:
                return this.i;
            case 102:
                return this.j;
            case 103:
                return this.k;
            default:
                return this.h;
        }
    }

    public void a(AbstractC4497cd abstractC4497cd) {
        this.l = abstractC4497cd;
        setState(abstractC4497cd.b());
    }

    @Override // com.amap.api.mapcore.util.ca
    public void a(long j, long j2) {
        int i = (int) ((j2 * 100) / j);
        if (i != getcompleteCode()) {
            setCompleteCode(i);
            d();
        }
    }

    @Override // com.amap.api.mapcore.util.ca
    public void a(ca.EnumC4496a enumC4496a) {
        int b;
        int i = AnonymousClass3.a[enumC4496a.ordinal()];
        if (i == 1) {
            b = this.j.b();
        } else if (i != 2) {
            b = i != 3 ? 6 : this.i.b();
        } else {
            b = this.k.b();
        }
        if (this.l.equals(this.c) || this.l.equals(this.b)) {
            this.l.a(b);
        }
    }

    @Override // com.amap.api.mapcore.util.bs
    public void a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.r > 500) {
            int i = (int) j;
            if (i > getcompleteCode()) {
                setCompleteCode(i);
                d();
            }
            this.r = currentTimeMillis;
        }
    }

    public az(Parcel parcel) {
        super(parcel);
        this.a = new cf(6, this);
        this.b = new cm(2, this);
        this.c = new ci(0, this);
        this.d = new ck(3, this);
        this.e = new cl(1, this);
        this.f = new ce(4, this);
        this.g = new cj(7, this);
        this.h = new cg(-1, this);
        this.i = new cg(101, this);
        this.j = new cg(102, this);
        this.k = new cg(103, this);
        this.p = null;
        this.q = "";
        this.n = false;
        this.r = 0L;
        this.q = parcel.readString();
    }

    private void a(final File file, File file2, final String str) {
        new br().a(file, file2, -1L, bx.a(file), new br.InterfaceC4485a() { // from class: com.amap.api.mapcore.util.az.1
            @Override // com.amap.api.mapcore.util.br.InterfaceC4485a
            public void a(String str2, String str3) {
            }

            @Override // com.amap.api.mapcore.util.br.InterfaceC4485a
            public void a(String str2, String str3, float f) {
                int i = (int) ((f * 0.39d) + 60.0d);
                if (i - az.this.getcompleteCode() <= 0 || System.currentTimeMillis() - az.this.r <= 1000) {
                    return;
                }
                az.this.setCompleteCode(i);
                az.this.r = System.currentTimeMillis();
            }

            @Override // com.amap.api.mapcore.util.br.InterfaceC4485a
            public void b(String str2, String str3) {
                try {
                    if (new File(str).delete()) {
                        bx.b(file);
                        az.this.setCompleteCode(100);
                        az.this.l.g();
                    }
                } catch (Exception unused) {
                    az azVar = az.this;
                    azVar.l.a(azVar.k.b());
                }
            }

            @Override // com.amap.api.mapcore.util.br.InterfaceC4485a
            public void a(String str2, String str3, int i) {
                az azVar = az.this;
                azVar.l.a(azVar.k.b());
            }
        });
    }
}
