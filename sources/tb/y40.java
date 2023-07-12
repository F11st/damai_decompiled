package tb;

import cn.damai.seatdecoder.common.decoder.serialize.quantumbinrary.binary.model.Chair;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class y40 {
    private static transient /* synthetic */ IpChange $ipChange;
    private cc a;
    private byte g;
    private byte h;
    private byte i;
    private byte j;
    private byte k;
    private byte l;
    private byte m;
    private byte n;
    private byte o;
    private byte p;
    private byte q;
    private ArrayList<Chair> b = new ArrayList<>();
    private ByteBuffer c = null;
    private String d = null;
    private int e = 0;
    private byte f = 0;
    private Chair r = new Chair();
    private List<Long> s = new ArrayList();
    private String t = null;
    public ArrayList<Long> u = new ArrayList<>();
    public ArrayList<Long> v = new ArrayList<>();
    public ArrayList<Long> w = new ArrayList<>();
    public ArrayList<Long> x = new ArrayList<>();
    public ArrayList<Long> y = new ArrayList<>();
    public ArrayList<Long> z = new ArrayList<>();
    public ArrayList<Long> A = new ArrayList<>();
    public ArrayList<Long> B = new ArrayList<>();
    public ArrayList<Long> C = new ArrayList<>();
    public ArrayList<Long> D = new ArrayList<>();
    public ArrayList<Long> E = new ArrayList<>();
    public ArrayList<C9949a> F = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.y40$a */
    /* loaded from: classes7.dex */
    public class C9949a {
        long a;
        long b;
        long c;
        long d;
        long e;
        long f;
        long g;
        long h;
        long i;
        long j;
        long k;

        C9949a(y40 y40Var) {
        }
    }

    public y40(cc ccVar) {
        h();
        this.a = ccVar;
    }

    private int b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1910858865")) {
            return ((Integer) ipChange.ipc$dispatch("1910858865", new Object[]{this})).intValue();
        }
        if (this.e == 1) {
            return 0;
        }
        long j = this.g;
        long j2 = this.h;
        long j3 = this.i;
        long j4 = this.j;
        long j5 = this.k;
        long j6 = this.l;
        long j7 = this.m;
        long j8 = this.n;
        long j9 = this.o;
        long j10 = this.p;
        long j11 = this.q;
        C9269io.a("binary", "decode mask bits=" + j + "|" + j2 + "|" + j3 + "|" + j4 + "|" + j5 + "|" + j6 + "|" + j7 + "|" + j8 + "|" + j9 + "|" + j10 + "|" + j11);
        long j12 = j + j2 + j3 + j4 + j5 + j6 + j7 + j8 + j9 + j10 + j11;
        if (j12 > 0 && j12 <= this.f * 8) {
            long j13 = j12 - j;
            long j14 = j13 - j2;
            long j15 = j14 - j3;
            long j16 = j15 - j4;
            long j17 = j16 - j5;
            long j18 = j17 - j6;
            long j19 = j18 - j7;
            long j20 = j19 - j8;
            long j21 = j20 - j9;
            long j22 = j21 - j10;
            long j23 = j22 - j11;
            C9269io.a("binary", "decode: δChairBits=" + j12 + " ,last offset=" + j23);
            if (j23 != 0) {
                C9269io.b("binary", "decode: compute δ_offset error...!");
                return -1;
            }
            for (Long l : this.s) {
                long longValue = l.longValue();
                C9949a c9949a = new C9949a(this);
                long j24 = j23;
                c9949a.a = (longValue << ((int) ((64 - j13) - j))) >>> ((int) (64 - j));
                c9949a.b = (longValue << ((int) ((64 - j14) - j2))) >>> ((int) (64 - j2));
                c9949a.c = (longValue << ((int) ((64 - j15) - j3))) >>> ((int) (64 - j3));
                c9949a.d = (longValue << ((int) ((64 - j16) - j4))) >>> ((int) (64 - j4));
                c9949a.e = (longValue << ((int) ((64 - j17) - j5))) >>> ((int) (64 - j5));
                c9949a.f = (longValue << ((int) ((64 - j18) - j6))) >>> ((int) (64 - j6));
                c9949a.g = (longValue << ((int) ((64 - j19) - j7))) >>> ((int) (64 - j7));
                c9949a.h = (longValue << ((int) ((64 - j20) - j8))) >>> ((int) (64 - j8));
                c9949a.i = (longValue << ((int) ((64 - j21) - j9))) >>> ((int) (64 - j9));
                c9949a.j = (longValue << ((int) ((64 - j22) - j10))) >>> ((int) (64 - j10));
                c9949a.k = (longValue << ((int) ((64 - j24) - j11))) >>> ((int) (64 - j11));
                this.F.add(c9949a);
                j23 = j24;
                j13 = j13;
            }
            g();
            C9269io.a("binary", "δList size=" + this.u.size() + "|" + this.v.size() + "|" + this.w.size() + "|" + this.x.size() + "|" + this.y.size() + "|" + this.z.size() + "|" + this.A.size() + "|" + this.B.size() + "|" + this.C.size() + "|" + this.D.size() + "|" + this.E.size());
            Chair chair = this.r;
            C9269io.a("binary", "------- base seat ： sid = " + this.r.sid + " x = " + this.r.x + " y = " + this.r.y + " fn = " + this.r.floorOrigin + " rhint = " + this.r.rowOrigin + " chint = " + this.r.chairOrigin + " plid = " + this.r.priceId + " groupId = " + this.r.groupId + " groupPriceId = " + this.r.groupPriceId + " angle = " + this.r.angle + " i = " + this.r.secondIndex);
            StringBuilder sb = new StringBuilder();
            sb.append("δChairList size=");
            sb.append(this.s.size());
            C9269io.a("binary", sb.toString());
            int i = 0;
            while (i < this.s.size()) {
                Chair chair2 = new Chair();
                C9949a c9949a2 = this.F.get(i);
                chair2.sid = chair.sid + this.u.get((int) c9949a2.a).longValue();
                chair2.decodeFloor(chair.floorCode + this.v.get((int) c9949a2.b).intValue(), this.a.b().b());
                chair2.decodeRow(chair.rowCode + this.w.get((int) c9949a2.c).intValue(), this.a.b().e());
                chair2.decodeChair(chair.chairCode + this.x.get((int) c9949a2.d).intValue(), this.a.b().a());
                chair2.x = (int) (chair.x + this.y.get((int) c9949a2.e).longValue());
                chair2.y = (int) (chair.y + this.z.get((int) c9949a2.f).longValue());
                chair2.priceId = chair.priceId + this.A.get((int) c9949a2.g).longValue();
                chair2.groupId = chair.groupId + this.B.get((int) c9949a2.h).longValue();
                chair2.groupPriceId = chair.groupPriceId + this.C.get((int) c9949a2.i).longValue();
                chair2.angle = (int) (chair.angle + this.D.get((int) c9949a2.j).longValue());
                chair2.secondIndex = (int) (chair.secondIndex + this.E.get((int) c9949a2.k).longValue());
                this.b.add(chair2);
                i++;
                chair = chair2;
            }
            return 0;
        }
        C9269io.b("binrary", "decode: compute δ_bits error...!");
        return -1;
    }

    private int f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1452395445")) {
            return ((Integer) ipChange.ipc$dispatch("-1452395445", new Object[]{this})).intValue();
        }
        String str = this.d;
        if (str == null || str.length() == 0) {
            return -1;
        }
        ByteBuffer allocate = ByteBuffer.allocate(this.d.length() / 2);
        this.c = allocate;
        pw0.b(allocate, this.d);
        this.c.rewind();
        if (C9269io.c()) {
            C9269io.a("binary", "decode: dest binary=" + sh2.d(this.c));
        }
        this.c.getLong();
        this.c.getShort();
        this.e = this.c.getInt();
        this.f = this.c.get();
        this.c.get();
        this.g = this.c.get();
        this.h = this.c.get();
        this.i = this.c.get();
        this.j = this.c.get();
        this.k = this.c.get();
        this.l = this.c.get();
        this.m = this.c.get();
        this.n = this.c.get();
        this.o = this.c.get();
        this.p = this.c.get();
        this.q = this.c.get();
        Chair chair = new Chair();
        this.r = chair;
        chair.sid = this.c.getLong();
        this.r.decodeFloor(this.c.getInt(), this.a.b().b());
        this.r.decodeRow(this.c.getInt(), this.a.b().e());
        this.r.decodeChair(this.c.getInt(), this.a.b().a());
        this.r.x = this.c.getInt();
        this.r.y = this.c.getInt();
        this.r.priceId = this.c.getLong();
        this.r.groupId = this.c.getLong();
        this.r.groupPriceId = this.c.getLong();
        this.r.angle = this.c.getInt();
        this.r.secondIndex = this.c.getInt();
        this.b.add(this.r);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.e - 1; i++) {
            ByteBuffer allocate2 = ByteBuffer.allocate(this.f);
            for (int i2 = 0; i2 < this.f; i2++) {
                allocate2.put(this.c.get());
            }
            allocate2.rewind();
            arrayList.add(allocate2);
            this.s.add(Long.valueOf(rd1.a(allocate2.array())));
        }
        q40.a(arrayList, "decode: δChair(ByteBuffer)");
        q40.b(this.s, "decode: δChair(long)");
        C9269io.a("binary", "parserBin() done---------------------------------");
        return 0;
    }

    private void g() {
        y40 y40Var = this;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "322304723")) {
            ipChange.ipc$dispatch("322304723", new Object[]{y40Var});
        } else if (C9269io.c()) {
            String str = "binary";
            C9269io.a("binary", "decoder | δ list--------------->>>");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            ArrayList arrayList8 = new ArrayList();
            ArrayList arrayList9 = new ArrayList();
            ArrayList arrayList10 = new ArrayList();
            ArrayList arrayList11 = new ArrayList();
            Iterator<C9949a> it = y40Var.F.iterator();
            while (it.hasNext()) {
                C9949a next = it.next();
                arrayList.add(Long.valueOf(next.a));
                arrayList2.add(Long.valueOf(next.b));
                arrayList3.add(Long.valueOf(next.c));
                arrayList4.add(Long.valueOf(next.d));
                arrayList5.add(Long.valueOf(next.e));
                arrayList6.add(Long.valueOf(next.f));
                arrayList7.add(Long.valueOf(next.g));
                arrayList8.add(Long.valueOf(next.h));
                arrayList9.add(Long.valueOf(next.i));
                arrayList10.add(Long.valueOf(next.j));
                arrayList11.add(Long.valueOf(next.k));
                y40Var = this;
                str = str;
            }
            q40.c(y40Var.u, "δSid.key");
            q40.c(arrayList, "δSid.index");
            q40.c(y40Var.v, "δFloor.key");
            q40.c(arrayList2, "δFloor.index");
            q40.c(y40Var.w, "δRow.key");
            q40.c(arrayList3, "δRow.index");
            q40.c(y40Var.x, "δChairId.key");
            q40.c(arrayList4, "δChairId.index");
            q40.c(y40Var.y, "δX.key");
            q40.c(arrayList5, "δX.index");
            q40.c(y40Var.z, "δY.key");
            q40.c(arrayList6, "δY.index");
            q40.c(y40Var.A, "δPrice.key");
            q40.c(arrayList7, "δPrice.index");
            q40.c(y40Var.B, "δGroupId.key");
            q40.c(arrayList8, "δGroupId.index");
            q40.c(y40Var.C, "δGroupPriceId.key");
            q40.c(arrayList9, "δGroupPriceId.index");
            q40.c(y40Var.D, "δAngle.key");
            q40.c(arrayList10, "δAngle.index");
            q40.c(y40Var.E, "δI.key");
            q40.c(arrayList11, "δI.index");
            C9269io.a(str, "decoder | δ list--------------- <<<");
        }
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216623315")) {
            ipChange.ipc$dispatch("216623315", new Object[]{this});
        }
    }

    public int a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1867256015")) {
            return ((Integer) ipChange.ipc$dispatch("-1867256015", new Object[]{this})).intValue();
        }
        f();
        k();
        b();
        return 0;
    }

    public ArrayList<Chair> c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1033238196") ? (ArrayList) ipChange.ipc$dispatch("1033238196", new Object[]{this}) : this.b;
    }

    public String d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1426745423") ? (String) ipChange.ipc$dispatch("1426745423", new Object[]{this}) : this.t;
    }

    public int e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1577885017")) {
            return ((Integer) ipChange.ipc$dispatch("1577885017", new Object[]{this, str})).intValue();
        }
        this.t = str;
        return 0;
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1674180497")) {
            ipChange.ipc$dispatch("-1674180497", new Object[]{this});
            return;
        }
        this.b.clear();
        this.c = null;
        this.t = null;
        this.g = (byte) 0;
        this.h = (byte) 0;
        this.i = (byte) 0;
        this.j = (byte) 0;
        this.k = (byte) 0;
        this.l = (byte) 0;
        this.m = (byte) 0;
        this.n = (byte) 0;
        this.o = (byte) 0;
        this.p = (byte) 0;
        this.q = (byte) 0;
        this.r = new Chair();
        this.f = (byte) 0;
        this.F.clear();
        this.u.clear();
        this.v.clear();
        this.w.clear();
        this.x.clear();
        this.y.clear();
        this.z.clear();
        this.A.clear();
        this.B.clear();
        this.C.clear();
        this.D.clear();
        this.E.clear();
    }

    public void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2068195685")) {
            ipChange.ipc$dispatch("-2068195685", new Object[]{this, str});
        } else {
            this.d = str;
        }
    }

    public void j(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1250162325")) {
            ipChange.ipc$dispatch("-1250162325", new Object[]{this, str});
        } else {
            this.t = str;
        }
    }
}
