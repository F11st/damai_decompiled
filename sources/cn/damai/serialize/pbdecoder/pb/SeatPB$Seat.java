package cn.damai.serialize.pbdecoder.pb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.g;
import java.io.IOException;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class SeatPB$Seat extends GeneratedMessageLite<SeatPB$Seat, Builder> implements SeatPB$SeatOrBuilder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ANGLE_FIELD_NUMBER = 10;
    public static final int CHINT_FIELD_NUMBER = 7;
    public static final int FN_FIELD_NUMBER = 9;
    public static final int GROUP_ID_FIELD_NUMBER = 5;
    public static final int GROUP_PRICE_ID_FIELD_NUMBER = 6;
    public static final int I_FIELD_NUMBER = 11;
    public static final int PLID_FIELD_NUMBER = 4;
    public static final int RHINT_FIELD_NUMBER = 8;
    public static final int SID_FIELD_NUMBER = 1;
    public static final int X_FIELD_NUMBER = 2;
    public static final int Y_FIELD_NUMBER = 3;
    private static final SeatPB$Seat o;
    private static volatile Parser<SeatPB$Seat> p;
    private long d;
    private int e;
    private int f;
    private long g;
    private long h;
    private long i;
    private String j = "";
    private String k = "";
    private String l = "";
    private double m;
    private int n;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<SeatPB$Seat, Builder> implements SeatPB$SeatOrBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        /* synthetic */ Builder(b bVar) {
            this();
        }

        public Builder clearAngle() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "863481928")) {
                return (Builder) ipChange.ipc$dispatch("863481928", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).Y();
            return this;
        }

        public Builder clearChint() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1382913489")) {
                return (Builder) ipChange.ipc$dispatch("1382913489", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).Z();
            return this;
        }

        public Builder clearFn() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "921136163")) {
                return (Builder) ipChange.ipc$dispatch("921136163", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).a0();
            return this;
        }

        public Builder clearGroupId() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "607681345")) {
                return (Builder) ipChange.ipc$dispatch("607681345", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).b0();
            return this;
        }

        public Builder clearGroupPriceId() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "275376518")) {
                return (Builder) ipChange.ipc$dispatch("275376518", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).c0();
            return this;
        }

        public Builder clearI() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1038056434")) {
                return (Builder) ipChange.ipc$dispatch("1038056434", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).d0();
            return this;
        }

        public Builder clearPlid() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "308933108")) {
                return (Builder) ipChange.ipc$dispatch("308933108", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).e0();
            return this;
        }

        public Builder clearRhint() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1398374302")) {
                return (Builder) ipChange.ipc$dispatch("-1398374302", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).f0();
            return this;
        }

        public Builder clearSid() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "799039469")) {
                return (Builder) ipChange.ipc$dispatch("799039469", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).g0();
            return this;
        }

        public Builder clearX() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1343117059")) {
                return (Builder) ipChange.ipc$dispatch("1343117059", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).h0();
            return this;
        }

        public Builder clearY() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1363454434")) {
                return (Builder) ipChange.ipc$dispatch("1363454434", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).i0();
            return this;
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
        public double getAngle() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1807918913") ? ((Double) ipChange.ipc$dispatch("1807918913", new Object[]{this})).doubleValue() : ((SeatPB$Seat) this.instance).getAngle();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
        public String getChint() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-29177660") ? (String) ipChange.ipc$dispatch("-29177660", new Object[]{this}) : ((SeatPB$Seat) this.instance).getChint();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
        public ByteString getChintBytes() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-933496019") ? (ByteString) ipChange.ipc$dispatch("-933496019", new Object[]{this}) : ((SeatPB$Seat) this.instance).getChintBytes();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
        public String getFn() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1695026588") ? (String) ipChange.ipc$dispatch("-1695026588", new Object[]{this}) : ((SeatPB$Seat) this.instance).getFn();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
        public ByteString getFnBytes() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-301847155") ? (ByteString) ipChange.ipc$dispatch("-301847155", new Object[]{this}) : ((SeatPB$Seat) this.instance).getFnBytes();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
        public long getGroupId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1068335488") ? ((Long) ipChange.ipc$dispatch("-1068335488", new Object[]{this})).longValue() : ((SeatPB$Seat) this.instance).getGroupId();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
        public long getGroupPriceId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-665572909") ? ((Long) ipChange.ipc$dispatch("-665572909", new Object[]{this})).longValue() : ((SeatPB$Seat) this.instance).getGroupPriceId();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
        public int getI() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "997548144") ? ((Integer) ipChange.ipc$dispatch("997548144", new Object[]{this})).intValue() : ((SeatPB$Seat) this.instance).getI();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
        public long getPlid() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "707359809") ? ((Long) ipChange.ipc$dispatch("707359809", new Object[]{this})).longValue() : ((SeatPB$Seat) this.instance).getPlid();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
        public String getRhint() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1122546733") ? (String) ipChange.ipc$dispatch("-1122546733", new Object[]{this}) : ((SeatPB$Seat) this.instance).getRhint();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
        public ByteString getRhintBytes() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "875964350") ? (ByteString) ipChange.ipc$dispatch("875964350", new Object[]{this}) : ((SeatPB$Seat) this.instance).getRhintBytes();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
        public long getSid() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1214107052") ? ((Long) ipChange.ipc$dispatch("1214107052", new Object[]{this})).longValue() : ((SeatPB$Seat) this.instance).getSid();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
        public int getX() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "997995009") ? ((Integer) ipChange.ipc$dispatch("997995009", new Object[]{this})).intValue() : ((SeatPB$Seat) this.instance).getX();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
        public int getY() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "998024800") ? ((Integer) ipChange.ipc$dispatch("998024800", new Object[]{this})).intValue() : ((SeatPB$Seat) this.instance).getY();
        }

        public Builder setAngle(double d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1091172611")) {
                return (Builder) ipChange.ipc$dispatch("-1091172611", new Object[]{this, Double.valueOf(d)});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).l0(d);
            return this;
        }

        public Builder setChint(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "319090672")) {
                return (Builder) ipChange.ipc$dispatch("319090672", new Object[]{this, str});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).m0(str);
            return this;
        }

        public Builder setChintBytes(ByteString byteString) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1771430353")) {
                return (Builder) ipChange.ipc$dispatch("-1771430353", new Object[]{this, byteString});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).n0(byteString);
            return this;
        }

        public Builder setFn(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-599370312")) {
                return (Builder) ipChange.ipc$dispatch("-599370312", new Object[]{this, str});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).o0(str);
            return this;
        }

        public Builder setFnBytes(ByteString byteString) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1804342119")) {
                return (Builder) ipChange.ipc$dispatch("1804342119", new Object[]{this, byteString});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).p0(byteString);
            return this;
        }

        public Builder setGroupId(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1830423574")) {
                return (Builder) ipChange.ipc$dispatch("-1830423574", new Object[]{this, Long.valueOf(j)});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).q0(j);
            return this;
        }

        public Builder setGroupPriceId(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2044017679")) {
                return (Builder) ipChange.ipc$dispatch("2044017679", new Object[]{this, Long.valueOf(j)});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).r0(j);
            return this;
        }

        public Builder setI(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1412515752")) {
                return (Builder) ipChange.ipc$dispatch("-1412515752", new Object[]{this, Integer.valueOf(i)});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).s0(i);
            return this;
        }

        public Builder setPlid(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "305686113")) {
                return (Builder) ipChange.ipc$dispatch("305686113", new Object[]{this, Long.valueOf(j)});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).t0(j);
            return this;
        }

        public Builder setRhint(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1978091455")) {
                return (Builder) ipChange.ipc$dispatch("-1978091455", new Object[]{this, str});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).u0(str);
            return this;
        }

        public Builder setRhintBytes(ByteString byteString) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1646668350")) {
                return (Builder) ipChange.ipc$dispatch("1646668350", new Object[]{this, byteString});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).v0(byteString);
            return this;
        }

        public Builder setSid(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1832559166")) {
                return (Builder) ipChange.ipc$dispatch("1832559166", new Object[]{this, Long.valueOf(j)});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).w0(j);
            return this;
        }

        public Builder setX(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-545570969")) {
                return (Builder) ipChange.ipc$dispatch("-545570969", new Object[]{this, Integer.valueOf(i)});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).x0(i);
            return this;
        }

        public Builder setY(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "84887656")) {
                return (Builder) ipChange.ipc$dispatch("84887656", new Object[]{this, Integer.valueOf(i)});
            }
            copyOnWrite();
            ((SeatPB$Seat) this.instance).y0(i);
            return this;
        }

        private Builder() {
            super(SeatPB$Seat.o);
        }
    }

    static {
        SeatPB$Seat seatPB$Seat = new SeatPB$Seat();
        o = seatPB$Seat;
        seatPB$Seat.q();
    }

    private SeatPB$Seat() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1114885197")) {
            ipChange.ipc$dispatch("-1114885197", new Object[]{this});
        } else {
            this.m = 0.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1400232892")) {
            ipChange.ipc$dispatch("1400232892", new Object[]{this});
        } else {
            this.j = j0().getChint();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "952435036")) {
            ipChange.ipc$dispatch("952435036", new Object[]{this});
        } else {
            this.l = j0().getFn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-974490900")) {
            ipChange.ipc$dispatch("-974490900", new Object[]{this});
        } else {
            this.h = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1150946945")) {
            ipChange.ipc$dispatch("-1150946945", new Object[]{this});
        } else {
            this.i = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2108955869")) {
            ipChange.ipc$dispatch("2108955869", new Object[]{this});
        } else {
            this.n = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "751623149")) {
            ipChange.ipc$dispatch("751623149", new Object[]{this});
        } else {
            this.g = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1772584141")) {
            ipChange.ipc$dispatch("1772584141", new Object[]{this});
        } else {
            this.k = j0().getRhint();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-169938408")) {
            ipChange.ipc$dispatch("-169938408", new Object[]{this});
        } else {
            this.d = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2109402734")) {
            ipChange.ipc$dispatch("2109402734", new Object[]{this});
        } else {
            this.e = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2109432525")) {
            ipChange.ipc$dispatch("2109432525", new Object[]{this});
        } else {
            this.f = 0;
        }
    }

    public static SeatPB$Seat j0() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1751953774") ? (SeatPB$Seat) ipChange.ipc$dispatch("1751953774", new Object[0]) : o;
    }

    public static Parser<SeatPB$Seat> k0() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1335364720") ? (Parser) ipChange.ipc$dispatch("1335364720", new Object[0]) : o.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2117956470")) {
            ipChange.ipc$dispatch("2117956470", new Object[]{this, Double.valueOf(d)});
        } else {
            this.m = d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-760806053")) {
            ipChange.ipc$dispatch("-760806053", new Object[]{this, str});
            return;
        }
        Objects.requireNonNull(str);
        this.j = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(ByteString byteString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-944402392")) {
            ipChange.ipc$dispatch("-944402392", new Object[]{this, byteString});
            return;
        }
        Objects.requireNonNull(byteString);
        AbstractMessageLite.b(byteString);
        this.j = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119573873")) {
            ipChange.ipc$dispatch("119573873", new Object[]{this, str});
            return;
        }
        Objects.requireNonNull(str);
        this.l = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(ByteString byteString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1214739538")) {
            ipChange.ipc$dispatch("1214739538", new Object[]{this, byteString});
            return;
        }
        Objects.requireNonNull(byteString);
        AbstractMessageLite.b(byteString);
        this.l = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-63620317")) {
            ipChange.ipc$dispatch("-63620317", new Object[]{this, Long.valueOf(j)});
        } else {
            this.h = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-728808902")) {
            ipChange.ipc$dispatch("-728808902", new Object[]{this, Long.valueOf(j)});
        } else {
            this.i = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2056175569")) {
            ipChange.ipc$dispatch("2056175569", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.n = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1207601804")) {
            ipChange.ipc$dispatch("1207601804", new Object[]{this, Long.valueOf(j)});
        } else {
            this.g = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295508948")) {
            ipChange.ipc$dispatch("-295508948", new Object[]{this, str});
            return;
        }
        Objects.requireNonNull(str);
        this.k = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(ByteString byteString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-685705801")) {
            ipChange.ipc$dispatch("-685705801", new Object[]{this, byteString});
            return;
        }
        Objects.requireNonNull(byteString);
        AbstractMessageLite.b(byteString);
        this.k = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1824309513")) {
            ipChange.ipc$dispatch("-1824309513", new Object[]{this, Long.valueOf(j)});
        } else {
            this.d = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2070028384")) {
            ipChange.ipc$dispatch("2070028384", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.e = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2070951905")) {
            ipChange.ipc$dispatch("2070951905", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.f = i;
        }
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
    public double getAngle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1644215126") ? ((Double) ipChange.ipc$dispatch("-1644215126", new Object[]{this})).doubleValue() : this.m;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
    public String getChint() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "587827835") ? (String) ipChange.ipc$dispatch("587827835", new Object[]{this}) : this.j;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
    public ByteString getChintBytes() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1994139626") ? (ByteString) ipChange.ipc$dispatch("-1994139626", new Object[]{this}) : ByteString.copyFromUtf8(this.j);
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
    public String getFn() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1621335027") ? (String) ipChange.ipc$dispatch("-1621335027", new Object[]{this}) : this.l;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
    public ByteString getFnBytes() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2137743036") ? (ByteString) ipChange.ipc$dispatch("-2137743036", new Object[]{this}) : ByteString.copyFromUtf8(this.l);
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
    public long getGroupId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1440572841") ? ((Long) ipChange.ipc$dispatch("1440572841", new Object[]{this})).longValue() : this.h;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
    public long getGroupPriceId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1636281270") ? ((Long) ipChange.ipc$dispatch("-1636281270", new Object[]{this})).longValue() : this.i;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
    public int getI() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1885543001") ? ((Integer) ipChange.ipc$dispatch("1885543001", new Object[]{this})).intValue() : this.n;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
    public long getPlid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2036398664") ? ((Long) ipChange.ipc$dispatch("-2036398664", new Object[]{this})).longValue() : this.g;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
    public String getRhint() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-505541238") ? (String) ipChange.ipc$dispatch("-505541238", new Object[]{this}) : this.k;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
    public ByteString getRhintBytes() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-184679257") ? (ByteString) ipChange.ipc$dispatch("-184679257", new Object[]{this}) : ByteString.copyFromUtf8(this.k);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1708316649")) {
            return ((Integer) ipChange.ipc$dispatch("1708316649", new Object[]{this})).intValue();
        }
        int i = this.c;
        if (i != -1) {
            return i;
        }
        long j = this.d;
        int r = j != 0 ? 0 + CodedOutputStream.r(1, j) : 0;
        int i2 = this.e;
        if (i2 != 0) {
            r += CodedOutputStream.p(2, i2);
        }
        int i3 = this.f;
        if (i3 != 0) {
            r += CodedOutputStream.p(3, i3);
        }
        long j2 = this.g;
        if (j2 != 0) {
            r += CodedOutputStream.r(4, j2);
        }
        long j3 = this.h;
        if (j3 != 0) {
            r += CodedOutputStream.r(5, j3);
        }
        long j4 = this.i;
        if (j4 != 0) {
            r += CodedOutputStream.r(6, j4);
        }
        if (!this.j.isEmpty()) {
            r += CodedOutputStream.m(7, getChint());
        }
        if (!this.k.isEmpty()) {
            r += CodedOutputStream.m(8, getRhint());
        }
        if (!this.l.isEmpty()) {
            r += CodedOutputStream.m(9, getFn());
        }
        double d = this.m;
        if (d != 0.0d) {
            r += CodedOutputStream.f(10, d);
        }
        int i4 = this.n;
        if (i4 != 0) {
            r += CodedOutputStream.p(11, i4);
        }
        this.c = r;
        return r;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
    public long getSid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-121327275") ? ((Long) ipChange.ipc$dispatch("-121327275", new Object[]{this})).longValue() : this.d;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
    public int getX() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1885989866") ? ((Integer) ipChange.ipc$dispatch("1885989866", new Object[]{this})).intValue() : this.e;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatOrBuilder
    public int getY() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1886019657") ? ((Integer) ipChange.ipc$dispatch("1886019657", new Object[]{this})).intValue() : this.f;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object j(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "659673856")) {
            return ipChange.ipc$dispatch("659673856", new Object[]{this, methodToInvoke, obj, obj2});
        }
        switch (b.a[methodToInvoke.ordinal()]) {
            case 1:
                return new SeatPB$Seat();
            case 2:
                return o;
            case 3:
                return null;
            case 4:
                return new Builder(null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                SeatPB$Seat seatPB$Seat = (SeatPB$Seat) obj2;
                long j = this.d;
                boolean z = j != 0;
                long j2 = seatPB$Seat.d;
                this.d = visitor.visitLong(z, j, j2 != 0, j2);
                int i = this.e;
                boolean z2 = i != 0;
                int i2 = seatPB$Seat.e;
                this.e = visitor.visitInt(z2, i, i2 != 0, i2);
                int i3 = this.f;
                boolean z3 = i3 != 0;
                int i4 = seatPB$Seat.f;
                this.f = visitor.visitInt(z3, i3, i4 != 0, i4);
                long j3 = this.g;
                boolean z4 = j3 != 0;
                long j4 = seatPB$Seat.g;
                this.g = visitor.visitLong(z4, j3, j4 != 0, j4);
                long j5 = this.h;
                boolean z5 = j5 != 0;
                long j6 = seatPB$Seat.h;
                this.h = visitor.visitLong(z5, j5, j6 != 0, j6);
                long j7 = this.i;
                boolean z6 = j7 != 0;
                long j8 = seatPB$Seat.i;
                this.i = visitor.visitLong(z6, j7, j8 != 0, j8);
                this.j = visitor.visitString(!this.j.isEmpty(), this.j, !seatPB$Seat.j.isEmpty(), seatPB$Seat.j);
                this.k = visitor.visitString(!this.k.isEmpty(), this.k, !seatPB$Seat.k.isEmpty(), seatPB$Seat.k);
                this.l = visitor.visitString(!this.l.isEmpty(), this.l, !seatPB$Seat.l.isEmpty(), seatPB$Seat.l);
                double d = this.m;
                boolean z7 = d != 0.0d;
                double d2 = seatPB$Seat.m;
                this.m = visitor.visitDouble(z7, d, d2 != 0.0d, d2);
                int i5 = this.n;
                boolean z8 = i5 != 0;
                int i6 = seatPB$Seat.n;
                this.n = visitor.visitInt(z8, i5, i6 != 0, i6);
                GeneratedMessageLite.g gVar = GeneratedMessageLite.g.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                g gVar2 = (g) obj2;
                while (!r2) {
                    try {
                        int v = codedInputStream.v();
                        switch (v) {
                            case 0:
                                break;
                            case 8:
                                this.d = codedInputStream.x();
                                continue;
                            case 16:
                                this.e = codedInputStream.w();
                                continue;
                            case 24:
                                this.f = codedInputStream.w();
                                continue;
                            case 32:
                                this.g = codedInputStream.x();
                                continue;
                            case 40:
                                this.h = codedInputStream.x();
                                continue;
                            case 48:
                                this.i = codedInputStream.x();
                                continue;
                            case 58:
                                this.j = codedInputStream.u();
                                continue;
                            case 66:
                                this.k = codedInputStream.u();
                                continue;
                            case 74:
                                this.l = codedInputStream.u();
                                continue;
                            case 81:
                                this.m = codedInputStream.k();
                                continue;
                            case 88:
                                this.n = codedInputStream.w();
                                continue;
                            default:
                                if (!codedInputStream.A(v)) {
                                    break;
                                } else {
                                    continue;
                                }
                        }
                        r2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw new RuntimeException(e.setUnfinishedMessage(this));
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (p == null) {
                    synchronized (SeatPB$Seat.class) {
                        if (p == null) {
                            p = new GeneratedMessageLite.b(o);
                        }
                    }
                }
                return p;
            default:
                throw new UnsupportedOperationException();
        }
        return o;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "123535022")) {
            ipChange.ipc$dispatch("123535022", new Object[]{this, codedOutputStream});
            return;
        }
        long j = this.d;
        if (j != 0) {
            codedOutputStream.G(1, j);
        }
        int i = this.e;
        if (i != 0) {
            codedOutputStream.E(2, i);
        }
        int i2 = this.f;
        if (i2 != 0) {
            codedOutputStream.E(3, i2);
        }
        long j2 = this.g;
        if (j2 != 0) {
            codedOutputStream.G(4, j2);
        }
        long j3 = this.h;
        if (j3 != 0) {
            codedOutputStream.G(5, j3);
        }
        long j4 = this.i;
        if (j4 != 0) {
            codedOutputStream.G(6, j4);
        }
        if (!this.j.isEmpty()) {
            codedOutputStream.D(7, getChint());
        }
        if (!this.k.isEmpty()) {
            codedOutputStream.D(8, getRhint());
        }
        if (!this.l.isEmpty()) {
            codedOutputStream.D(9, getFn());
        }
        double d = this.m;
        if (d != 0.0d) {
            codedOutputStream.z(10, d);
        }
        int i3 = this.n;
        if (i3 != 0) {
            codedOutputStream.E(11, i3);
        }
    }
}
