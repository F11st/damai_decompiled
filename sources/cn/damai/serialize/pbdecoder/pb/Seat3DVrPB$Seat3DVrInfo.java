package cn.damai.serialize.pbdecoder.pb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.C5401g;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class Seat3DVrPB$Seat3DVrInfo extends GeneratedMessageLite<Seat3DVrPB$Seat3DVrInfo, Builder> implements Seat3DVrPB$Seat3DVrInfoOrBuilder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int FLOORID_FIELD_NUMBER = 2;
    public static final int FOV_FIELD_NUMBER = 3;
    public static final int HORIZONTAL_FIELD_NUMBER = 4;
    public static final int IMGHASH_FIELD_NUMBER = 8;
    public static final int IMG_FIELD_NUMBER = 6;
    public static final int SID_FIELD_NUMBER = 1;
    public static final int THUMB_FIELD_NUMBER = 7;
    public static final int VERTICAL_FIELD_NUMBER = 5;
    private static final Seat3DVrPB$Seat3DVrInfo l;
    private static volatile Parser<Seat3DVrPB$Seat3DVrInfo> m;
    private long d;
    private long e;
    private double f;
    private double g;
    private double h;
    private String i = "";
    private String j = "";
    private String k = "";

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Seat3DVrPB$Seat3DVrInfo, Builder> implements Seat3DVrPB$Seat3DVrInfoOrBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        /* synthetic */ Builder(C1741a c1741a) {
            this();
        }

        public Builder clearFloorId() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1466757268")) {
                return (Builder) ipChange.ipc$dispatch("1466757268", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).S();
            return this;
        }

        public Builder clearFov() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-69549234")) {
                return (Builder) ipChange.ipc$dispatch("-69549234", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).T();
            return this;
        }

        public Builder clearHorizontal() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-969937173")) {
                return (Builder) ipChange.ipc$dispatch("-969937173", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).U();
            return this;
        }

        public Builder clearImg() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1721303912")) {
                return (Builder) ipChange.ipc$dispatch("-1721303912", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).V();
            return this;
        }

        public Builder clearImgHash() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "33611562")) {
                return (Builder) ipChange.ipc$dispatch("33611562", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).W();
            return this;
        }

        public Builder clearSid() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "932876205")) {
                return (Builder) ipChange.ipc$dispatch("932876205", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).X();
            return this;
        }

        public Builder clearThumb() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1304762405")) {
                return (Builder) ipChange.ipc$dispatch("1304762405", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).Y();
            return this;
        }

        public Builder clearVertical() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1315031847")) {
                return (Builder) ipChange.ipc$dispatch("-1315031847", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).Z();
            return this;
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public long getFloorId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1720344255") ? ((Long) ipChange.ipc$dispatch("-1720344255", new Object[]{this})).longValue() : ((Seat3DVrPB$Seat3DVrInfo) this.instance).getFloorId();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public double getFov() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-294539147") ? ((Double) ipChange.ipc$dispatch("-294539147", new Object[]{this})).doubleValue() : ((Seat3DVrPB$Seat3DVrInfo) this.instance).getFov();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public double getHorizontal() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-601051424") ? ((Double) ipChange.ipc$dispatch("-601051424", new Object[]{this})).doubleValue() : ((Seat3DVrPB$Seat3DVrInfo) this.instance).getHorizontal();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public String getImg() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-203458833") ? (String) ipChange.ipc$dispatch("-203458833", new Object[]{this}) : ((Seat3DVrPB$Seat3DVrInfo) this.instance).getImg();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public ByteString getImgBytes() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1025740578") ? (ByteString) ipChange.ipc$dispatch("1025740578", new Object[]{this}) : ((Seat3DVrPB$Seat3DVrInfo) this.instance).getImgBytes();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public String getImgHash() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2037246179") ? (String) ipChange.ipc$dispatch("-2037246179", new Object[]{this}) : ((Seat3DVrPB$Seat3DVrInfo) this.instance).getImgHash();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public ByteString getImgHashBytes() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1044476980") ? (ByteString) ipChange.ipc$dispatch("1044476980", new Object[]{this}) : ((Seat3DVrPB$Seat3DVrInfo) this.instance).getImgHashBytes();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public long getSid() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "71562458") ? ((Long) ipChange.ipc$dispatch("71562458", new Object[]{this})).longValue() : ((Seat3DVrPB$Seat3DVrInfo) this.instance).getSid();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public String getThumb() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "463148354") ? (String) ipChange.ipc$dispatch("463148354", new Object[]{this}) : ((Seat3DVrPB$Seat3DVrInfo) this.instance).getThumb();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public ByteString getThumbBytes() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1229959663") ? (ByteString) ipChange.ipc$dispatch("1229959663", new Object[]{this}) : ((Seat3DVrPB$Seat3DVrInfo) this.instance).getThumbBytes();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
        public double getVertical() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1240813198") ? ((Double) ipChange.ipc$dispatch("1240813198", new Object[]{this})).doubleValue() : ((Seat3DVrPB$Seat3DVrInfo) this.instance).getVertical();
        }

        public Builder setFloorId(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-272946725")) {
                return (Builder) ipChange.ipc$dispatch("-272946725", new Object[]{this, Long.valueOf(j)});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).c0(j);
            return this;
        }

        public Builder setFov(double d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-592394917")) {
                return (Builder) ipChange.ipc$dispatch("-592394917", new Object[]{this, Double.valueOf(d)});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).d0(d);
            return this;
        }

        public Builder setHorizontal(double d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1233635048")) {
                return (Builder) ipChange.ipc$dispatch("1233635048", new Object[]{this, Double.valueOf(d)});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).e0(d);
            return this;
        }

        public Builder setImg(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-880373321")) {
                return (Builder) ipChange.ipc$dispatch("-880373321", new Object[]{this, str});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).f0(str);
            return this;
        }

        public Builder setImgBytes(ByteString byteString) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2020439788")) {
                return (Builder) ipChange.ipc$dispatch("2020439788", new Object[]{this, byteString});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).g0(byteString);
            return this;
        }

        public Builder setImgHash(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2113994423")) {
                return (Builder) ipChange.ipc$dispatch("-2113994423", new Object[]{this, str});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).h0(str);
            return this;
        }

        public Builder setImgHashBytes(ByteString byteString) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-986387942")) {
                return (Builder) ipChange.ipc$dispatch("-986387942", new Object[]{this, byteString});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).i0(byteString);
            return this;
        }

        public Builder setSid(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1064528738")) {
                return (Builder) ipChange.ipc$dispatch("1064528738", new Object[]{this, Long.valueOf(j)});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).j0(j);
            return this;
        }

        public Builder setThumb(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "815907524")) {
                return (Builder) ipChange.ipc$dispatch("815907524", new Object[]{this, str});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).k0(str);
            return this;
        }

        public Builder setThumbBytes(ByteString byteString) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1286768831")) {
                return (Builder) ipChange.ipc$dispatch("1286768831", new Object[]{this, byteString});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).l0(byteString);
            return this;
        }

        public Builder setVertical(double d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1456742394")) {
                return (Builder) ipChange.ipc$dispatch("1456742394", new Object[]{this, Double.valueOf(d)});
            }
            copyOnWrite();
            ((Seat3DVrPB$Seat3DVrInfo) this.instance).m0(d);
            return this;
        }

        private Builder() {
            super(Seat3DVrPB$Seat3DVrInfo.l);
        }
    }

    static {
        Seat3DVrPB$Seat3DVrInfo seat3DVrPB$Seat3DVrInfo = new Seat3DVrPB$Seat3DVrInfo();
        l = seat3DVrPB$Seat3DVrInfo;
        seat3DVrPB$Seat3DVrInfo.q();
    }

    private Seat3DVrPB$Seat3DVrInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-770912211")) {
            ipChange.ipc$dispatch("-770912211", new Object[]{this});
        } else {
            this.e = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890799463")) {
            ipChange.ipc$dispatch("1890799463", new Object[]{this});
        } else {
            this.f = 0.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1568969746")) {
            ipChange.ipc$dispatch("1568969746", new Object[]{this});
        } else {
            this.g = 0.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1974393009")) {
            ipChange.ipc$dispatch("1974393009", new Object[]{this});
        } else {
            this.i = a0().getImg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-631214397")) {
            ipChange.ipc$dispatch("-631214397", new Object[]{this});
        } else {
            this.k = a0().getImgHash();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2038066234")) {
            ipChange.ipc$dispatch("-2038066234", new Object[]{this});
        } else {
            this.d = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330816510")) {
            ipChange.ipc$dispatch("1330816510", new Object[]{this});
        } else {
            this.j = a0().getThumb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "608435136")) {
            ipChange.ipc$dispatch("608435136", new Object[]{this});
        } else {
            this.h = 0.0d;
        }
    }

    public static Seat3DVrPB$Seat3DVrInfo a0() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-742101330") ? (Seat3DVrPB$Seat3DVrInfo) ipChange.ipc$dispatch("-742101330", new Object[0]) : l;
    }

    public static Parser<Seat3DVrPB$Seat3DVrInfo> b0() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1800467838") ? (Parser) ipChange.ipc$dispatch("-1800467838", new Object[0]) : l.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-684318078")) {
            ipChange.ipc$dispatch("-684318078", new Object[]{this, Long.valueOf(j)});
        } else {
            this.e = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1729384834")) {
            ipChange.ipc$dispatch("1729384834", new Object[]{this, Double.valueOf(d)});
        } else {
            this.f = d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "539766849")) {
            ipChange.ipc$dispatch("539766849", new Object[]{this, Double.valueOf(d)});
        } else {
            this.g = d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-830671920")) {
            ipChange.ipc$dispatch("-830671920", new Object[]{this, str});
            return;
        }
        Objects.requireNonNull(str);
        this.i = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(ByteString byteString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677468781")) {
            ipChange.ipc$dispatch("-1677468781", new Object[]{this, byteString});
            return;
        }
        Objects.requireNonNull(byteString);
        AbstractMessageLite.b(byteString);
        this.i = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373167842")) {
            ipChange.ipc$dispatch("373167842", new Object[]{this, str});
            return;
        }
        Objects.requireNonNull(str);
        this.k = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(ByteString byteString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-61674687")) {
            ipChange.ipc$dispatch("-61674687", new Object[]{this, byteString});
            return;
        }
        Objects.requireNonNull(byteString);
        AbstractMessageLite.b(byteString);
        this.k = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193638281")) {
            ipChange.ipc$dispatch("193638281", new Object[]{this, Long.valueOf(j)});
        } else {
            this.d = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-419539299")) {
            ipChange.ipc$dispatch("-419539299", new Object[]{this, str});
            return;
        }
        Objects.requireNonNull(str);
        this.j = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(ByteString byteString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-91495514")) {
            ipChange.ipc$dispatch("-91495514", new Object[]{this, byteString});
            return;
        }
        Objects.requireNonNull(byteString);
        AbstractMessageLite.b(byteString);
        this.j = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-241029229")) {
            ipChange.ipc$dispatch("-241029229", new Object[]{this, Double.valueOf(d)});
        } else {
            this.h = d;
        }
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public long getFloorId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1350396310") ? ((Long) ipChange.ipc$dispatch("-1350396310", new Object[]{this})).longValue() : this.e;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public double getFov() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-560881122") ? ((Double) ipChange.ipc$dispatch("-560881122", new Object[]{this})).doubleValue() : this.f;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public double getHorizontal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-367903465") ? ((Double) ipChange.ipc$dispatch("-367903465", new Object[]{this})).doubleValue() : this.g;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public String getImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2144201830") ? (String) ipChange.ipc$dispatch("2144201830", new Object[]{this}) : this.i;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public ByteString getImgBytes() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1045847989") ? (ByteString) ipChange.ipc$dispatch("-1045847989", new Object[]{this}) : ByteString.copyFromUtf8(this.i);
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public String getImgHash() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-490014444") ? (String) ipChange.ipc$dispatch("-490014444", new Object[]{this}) : this.k;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public ByteString getImgHashBytes() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "26790109") ? (ByteString) ipChange.ipc$dispatch("26790109", new Object[]{this}) : ByteString.copyFromUtf8(this.k);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778137595")) {
            return ((Integer) ipChange.ipc$dispatch("1778137595", new Object[]{this})).intValue();
        }
        int i = this.c;
        if (i != -1) {
            return i;
        }
        long j = this.d;
        int r = j != 0 ? 0 + CodedOutputStream.r(1, j) : 0;
        long j2 = this.e;
        if (j2 != 0) {
            r += CodedOutputStream.r(2, j2);
        }
        double d = this.f;
        if (d != 0.0d) {
            r += CodedOutputStream.f(3, d);
        }
        double d2 = this.g;
        if (d2 != 0.0d) {
            r += CodedOutputStream.f(4, d2);
        }
        double d3 = this.h;
        if (d3 != 0.0d) {
            r += CodedOutputStream.f(5, d3);
        }
        if (!this.i.isEmpty()) {
            r += CodedOutputStream.m(6, getImg());
        }
        if (!this.j.isEmpty()) {
            r += CodedOutputStream.m(7, getThumb());
        }
        if (!this.k.isEmpty()) {
            r += CodedOutputStream.m(8, getImgHash());
        }
        this.c = r;
        return r;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public long getSid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-194779517") ? ((Long) ipChange.ipc$dispatch("-194779517", new Object[]{this})).longValue() : this.d;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public String getThumb() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1707215097") ? (String) ipChange.ipc$dispatch("1707215097", new Object[]{this}) : this.j;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public ByteString getThumbBytes() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-996795176") ? (ByteString) ipChange.ipc$dispatch("-996795176", new Object[]{this}) : ByteString.copyFromUtf8(this.j);
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfoOrBuilder
    public double getVertical() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-175702395") ? ((Double) ipChange.ipc$dispatch("-175702395", new Object[]{this})).doubleValue() : this.h;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object j(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "261418642")) {
            return ipChange.ipc$dispatch("261418642", new Object[]{this, methodToInvoke, obj, obj2});
        }
        switch (C1741a.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Seat3DVrPB$Seat3DVrInfo();
            case 2:
                return l;
            case 3:
                return null;
            case 4:
                return new Builder(null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Seat3DVrPB$Seat3DVrInfo seat3DVrPB$Seat3DVrInfo = (Seat3DVrPB$Seat3DVrInfo) obj2;
                long j = this.d;
                boolean z2 = j != 0;
                long j2 = seat3DVrPB$Seat3DVrInfo.d;
                this.d = visitor.visitLong(z2, j, j2 != 0, j2);
                long j3 = this.e;
                boolean z3 = j3 != 0;
                long j4 = seat3DVrPB$Seat3DVrInfo.e;
                this.e = visitor.visitLong(z3, j3, j4 != 0, j4);
                double d = this.f;
                boolean z4 = d != 0.0d;
                double d2 = seat3DVrPB$Seat3DVrInfo.f;
                this.f = visitor.visitDouble(z4, d, d2 != 0.0d, d2);
                double d3 = this.g;
                boolean z5 = d3 != 0.0d;
                double d4 = seat3DVrPB$Seat3DVrInfo.g;
                this.g = visitor.visitDouble(z5, d3, d4 != 0.0d, d4);
                double d5 = this.h;
                boolean z6 = d5 != 0.0d;
                double d6 = seat3DVrPB$Seat3DVrInfo.h;
                this.h = visitor.visitDouble(z6, d5, d6 != 0.0d, d6);
                this.i = visitor.visitString(!this.i.isEmpty(), this.i, !seat3DVrPB$Seat3DVrInfo.i.isEmpty(), seat3DVrPB$Seat3DVrInfo.i);
                this.j = visitor.visitString(!this.j.isEmpty(), this.j, !seat3DVrPB$Seat3DVrInfo.j.isEmpty(), seat3DVrPB$Seat3DVrInfo.j);
                this.k = visitor.visitString(!this.k.isEmpty(), this.k, !seat3DVrPB$Seat3DVrInfo.k.isEmpty(), seat3DVrPB$Seat3DVrInfo.k);
                GeneratedMessageLite.C5383g c5383g = GeneratedMessageLite.C5383g.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                C5401g c5401g = (C5401g) obj2;
                while (!z) {
                    try {
                        int v = codedInputStream.v();
                        if (v != 0) {
                            if (v == 8) {
                                this.d = codedInputStream.x();
                            } else if (v == 16) {
                                this.e = codedInputStream.x();
                            } else if (v == 25) {
                                this.f = codedInputStream.k();
                            } else if (v == 33) {
                                this.g = codedInputStream.k();
                            } else if (v == 41) {
                                this.h = codedInputStream.k();
                            } else if (v == 50) {
                                this.i = codedInputStream.u();
                            } else if (v == 58) {
                                this.j = codedInputStream.u();
                            } else if (v != 66) {
                                if (!codedInputStream.A(v)) {
                                }
                            } else {
                                this.k = codedInputStream.u();
                            }
                        }
                        z = true;
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
                if (m == null) {
                    synchronized (Seat3DVrPB$Seat3DVrInfo.class) {
                        if (m == null) {
                            m = new GeneratedMessageLite.C5378b(l);
                        }
                    }
                }
                return m;
            default:
                throw new UnsupportedOperationException();
        }
        return l;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "631959004")) {
            ipChange.ipc$dispatch("631959004", new Object[]{this, codedOutputStream});
            return;
        }
        long j = this.d;
        if (j != 0) {
            codedOutputStream.G(1, j);
        }
        long j2 = this.e;
        if (j2 != 0) {
            codedOutputStream.G(2, j2);
        }
        double d = this.f;
        if (d != 0.0d) {
            codedOutputStream.z(3, d);
        }
        double d2 = this.g;
        if (d2 != 0.0d) {
            codedOutputStream.z(4, d2);
        }
        double d3 = this.h;
        if (d3 != 0.0d) {
            codedOutputStream.z(5, d3);
        }
        if (!this.i.isEmpty()) {
            codedOutputStream.D(6, getImg());
        }
        if (!this.j.isEmpty()) {
            codedOutputStream.D(7, getThumb());
        }
        if (this.k.isEmpty()) {
            return;
        }
        codedOutputStream.D(8, getImgHash());
    }
}
