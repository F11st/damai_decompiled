package cn.damai.serialize.pbdecoder.pb;

import cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$Seat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.C5401g;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class Seat3DVrPB$FloorSeat3DVrInfo extends GeneratedMessageLite<Seat3DVrPB$FloorSeat3DVrInfo, Builder> implements Seat3DVrPB$FloorSeat3DVrInfoOrBuilder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int FLOORID_FIELD_NUMBER = 1;
    public static final int SEATLIST_FIELD_NUMBER = 2;
    private static final Seat3DVrPB$FloorSeat3DVrInfo g;
    private static volatile Parser<Seat3DVrPB$FloorSeat3DVrInfo> h;
    private int d;
    private long e;
    private Internal.ProtobufList<Seat3DVrPB$Seat3DVrInfo> f = GeneratedMessageLite.k();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Seat3DVrPB$FloorSeat3DVrInfo, Builder> implements Seat3DVrPB$FloorSeat3DVrInfoOrBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        /* synthetic */ Builder(C1741a c1741a) {
            this();
        }

        public Builder addAllSeatList(Iterable<? extends Seat3DVrPB$Seat3DVrInfo> iterable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1207137960")) {
                return (Builder) ipChange.ipc$dispatch("-1207137960", new Object[]{this, iterable});
            }
            copyOnWrite();
            ((Seat3DVrPB$FloorSeat3DVrInfo) this.instance).K(iterable);
            return this;
        }

        public Builder addSeatList(Seat3DVrPB$Seat3DVrInfo seat3DVrPB$Seat3DVrInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1968367853")) {
                return (Builder) ipChange.ipc$dispatch("1968367853", new Object[]{this, seat3DVrPB$Seat3DVrInfo});
            }
            copyOnWrite();
            ((Seat3DVrPB$FloorSeat3DVrInfo) this.instance).O(seat3DVrPB$Seat3DVrInfo);
            return this;
        }

        public Builder clearFloorId() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-425868904")) {
                return (Builder) ipChange.ipc$dispatch("-425868904", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$FloorSeat3DVrInfo) this.instance).P();
            return this;
        }

        public Builder clearSeatList() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1088840672")) {
                return (Builder) ipChange.ipc$dispatch("-1088840672", new Object[]{this});
            }
            copyOnWrite();
            ((Seat3DVrPB$FloorSeat3DVrInfo) this.instance).Q();
            return this;
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$FloorSeat3DVrInfoOrBuilder
        public long getFloorId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "542884401") ? ((Long) ipChange.ipc$dispatch("542884401", new Object[]{this})).longValue() : ((Seat3DVrPB$FloorSeat3DVrInfo) this.instance).getFloorId();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$FloorSeat3DVrInfoOrBuilder
        public Seat3DVrPB$Seat3DVrInfo getSeatList(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1973905127") ? (Seat3DVrPB$Seat3DVrInfo) ipChange.ipc$dispatch("1973905127", new Object[]{this, Integer.valueOf(i)}) : ((Seat3DVrPB$FloorSeat3DVrInfo) this.instance).getSeatList(i);
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$FloorSeat3DVrInfoOrBuilder
        public int getSeatListCount() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-472907637") ? ((Integer) ipChange.ipc$dispatch("-472907637", new Object[]{this})).intValue() : ((Seat3DVrPB$FloorSeat3DVrInfo) this.instance).getSeatListCount();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$FloorSeat3DVrInfoOrBuilder
        public List<Seat3DVrPB$Seat3DVrInfo> getSeatListList() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1891524706") ? (List) ipChange.ipc$dispatch("1891524706", new Object[]{this}) : Collections.unmodifiableList(((Seat3DVrPB$FloorSeat3DVrInfo) this.instance).getSeatListList());
        }

        public Builder removeSeatList(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "636919824")) {
                return (Builder) ipChange.ipc$dispatch("636919824", new Object[]{this, Integer.valueOf(i)});
            }
            copyOnWrite();
            ((Seat3DVrPB$FloorSeat3DVrInfo) this.instance).T(i);
            return this;
        }

        public Builder setFloorId(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-684066671")) {
                return (Builder) ipChange.ipc$dispatch("-684066671", new Object[]{this, Long.valueOf(j)});
            }
            copyOnWrite();
            ((Seat3DVrPB$FloorSeat3DVrInfo) this.instance).U(j);
            return this;
        }

        public Builder setSeatList(int i, Seat3DVrPB$Seat3DVrInfo seat3DVrPB$Seat3DVrInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "600171265")) {
                return (Builder) ipChange.ipc$dispatch("600171265", new Object[]{this, Integer.valueOf(i), seat3DVrPB$Seat3DVrInfo});
            }
            copyOnWrite();
            ((Seat3DVrPB$FloorSeat3DVrInfo) this.instance).W(i, seat3DVrPB$Seat3DVrInfo);
            return this;
        }

        private Builder() {
            super(Seat3DVrPB$FloorSeat3DVrInfo.g);
        }

        public Builder addSeatList(int i, Seat3DVrPB$Seat3DVrInfo seat3DVrPB$Seat3DVrInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1069264000")) {
                return (Builder) ipChange.ipc$dispatch("1069264000", new Object[]{this, Integer.valueOf(i), seat3DVrPB$Seat3DVrInfo});
            }
            copyOnWrite();
            ((Seat3DVrPB$FloorSeat3DVrInfo) this.instance).M(i, seat3DVrPB$Seat3DVrInfo);
            return this;
        }

        public Builder setSeatList(int i, Seat3DVrPB$Seat3DVrInfo.Builder builder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-119607848")) {
                return (Builder) ipChange.ipc$dispatch("-119607848", new Object[]{this, Integer.valueOf(i), builder});
            }
            copyOnWrite();
            ((Seat3DVrPB$FloorSeat3DVrInfo) this.instance).V(i, builder);
            return this;
        }

        public Builder addSeatList(Seat3DVrPB$Seat3DVrInfo.Builder builder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1923958724")) {
                return (Builder) ipChange.ipc$dispatch("1923958724", new Object[]{this, builder});
            }
            copyOnWrite();
            ((Seat3DVrPB$FloorSeat3DVrInfo) this.instance).N(builder);
            return this;
        }

        public Builder addSeatList(int i, Seat3DVrPB$Seat3DVrInfo.Builder builder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1729181609")) {
                return (Builder) ipChange.ipc$dispatch("-1729181609", new Object[]{this, Integer.valueOf(i), builder});
            }
            copyOnWrite();
            ((Seat3DVrPB$FloorSeat3DVrInfo) this.instance).L(i, builder);
            return this;
        }
    }

    static {
        Seat3DVrPB$FloorSeat3DVrInfo seat3DVrPB$FloorSeat3DVrInfo = new Seat3DVrPB$FloorSeat3DVrInfo();
        g = seat3DVrPB$FloorSeat3DVrInfo;
        seat3DVrPB$FloorSeat3DVrInfo.q();
    }

    private Seat3DVrPB$FloorSeat3DVrInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(Iterable<? extends Seat3DVrPB$Seat3DVrInfo> iterable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-522076003")) {
            ipChange.ipc$dispatch("-522076003", new Object[]{this, iterable});
            return;
        }
        R();
        AbstractMessageLite.a(iterable, this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i, Seat3DVrPB$Seat3DVrInfo.Builder builder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-178548148")) {
            ipChange.ipc$dispatch("-178548148", new Object[]{this, Integer.valueOf(i), builder});
            return;
        }
        R();
        this.f.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, Seat3DVrPB$Seat3DVrInfo seat3DVrPB$Seat3DVrInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "131028867")) {
            ipChange.ipc$dispatch("131028867", new Object[]{this, Integer.valueOf(i), seat3DVrPB$Seat3DVrInfo});
            return;
        }
        Objects.requireNonNull(seat3DVrPB$Seat3DVrInfo);
        R();
        this.f.add(i, seat3DVrPB$Seat3DVrInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(Seat3DVrPB$Seat3DVrInfo.Builder builder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "215190385")) {
            ipChange.ipc$dispatch("215190385", new Object[]{this, builder});
            return;
        }
        R();
        this.f.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Seat3DVrPB$Seat3DVrInfo seat3DVrPB$Seat3DVrInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "53560744")) {
            ipChange.ipc$dispatch("53560744", new Object[]{this, seat3DVrPB$Seat3DVrInfo});
            return;
        }
        Objects.requireNonNull(seat3DVrPB$Seat3DVrInfo);
        R();
        this.f.add(seat3DVrPB$Seat3DVrInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2070256355")) {
            ipChange.ipc$dispatch("-2070256355", new Object[]{this});
        } else {
            this.e = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "962147555")) {
            ipChange.ipc$dispatch("962147555", new Object[]{this});
        } else {
            this.f = GeneratedMessageLite.k();
        }
    }

    private void R() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-972616648")) {
            ipChange.ipc$dispatch("-972616648", new Object[]{this});
        } else if (this.f.isModifiable()) {
        } else {
            this.f = GeneratedMessageLite.r(this.f);
        }
    }

    public static Parser<Seat3DVrPB$FloorSeat3DVrInfo> S() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1501883282") ? (Parser) ipChange.ipc$dispatch("1501883282", new Object[0]) : g.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-632338125")) {
            ipChange.ipc$dispatch("-632338125", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        R();
        this.f.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1557516398")) {
            ipChange.ipc$dispatch("-1557516398", new Object[]{this, Long.valueOf(j)});
        } else {
            this.e = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, Seat3DVrPB$Seat3DVrInfo.Builder builder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "666286123")) {
            ipChange.ipc$dispatch("666286123", new Object[]{this, Integer.valueOf(i), builder});
            return;
        }
        R();
        this.f.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i, Seat3DVrPB$Seat3DVrInfo seat3DVrPB$Seat3DVrInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1572746142")) {
            ipChange.ipc$dispatch("-1572746142", new Object[]{this, Integer.valueOf(i), seat3DVrPB$Seat3DVrInfo});
            return;
        }
        Objects.requireNonNull(seat3DVrPB$Seat3DVrInfo);
        R();
        this.f.set(i, seat3DVrPB$Seat3DVrInfo);
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$FloorSeat3DVrInfoOrBuilder
    public long getFloorId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1655658662") ? ((Long) ipChange.ipc$dispatch("-1655658662", new Object[]{this})).longValue() : this.e;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$FloorSeat3DVrInfoOrBuilder
    public Seat3DVrPB$Seat3DVrInfo getSeatList(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1726076624") ? (Seat3DVrPB$Seat3DVrInfo) ipChange.ipc$dispatch("1726076624", new Object[]{this, Integer.valueOf(i)}) : this.f.get(i);
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$FloorSeat3DVrInfoOrBuilder
    public int getSeatListCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1168417524") ? ((Integer) ipChange.ipc$dispatch("1168417524", new Object[]{this})).intValue() : this.f.size();
    }

    @Override // cn.damai.serialize.pbdecoder.pb.Seat3DVrPB$FloorSeat3DVrInfoOrBuilder
    public List<Seat3DVrPB$Seat3DVrInfo> getSeatListList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1009903861") ? (List) ipChange.ipc$dispatch("-1009903861", new Object[]{this}) : this.f;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1851144971")) {
            return ((Integer) ipChange.ipc$dispatch("1851144971", new Object[]{this})).intValue();
        }
        int i = this.c;
        if (i != -1) {
            return i;
        }
        long j = this.e;
        int r = j != 0 ? CodedOutputStream.r(1, j) + 0 : 0;
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            r += CodedOutputStream.i(2, this.f.get(i2));
        }
        this.c = r;
        return r;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object j(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1627659170")) {
            return ipChange.ipc$dispatch("1627659170", new Object[]{this, methodToInvoke, obj, obj2});
        }
        switch (C1741a.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Seat3DVrPB$FloorSeat3DVrInfo();
            case 2:
                return g;
            case 3:
                this.f.makeImmutable();
                return null;
            case 4:
                return new Builder(null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Seat3DVrPB$FloorSeat3DVrInfo seat3DVrPB$FloorSeat3DVrInfo = (Seat3DVrPB$FloorSeat3DVrInfo) obj2;
                long j = this.e;
                boolean z2 = j != 0;
                long j2 = seat3DVrPB$FloorSeat3DVrInfo.e;
                this.e = visitor.visitLong(z2, j, j2 != 0, j2);
                this.f = visitor.visitList(this.f, seat3DVrPB$FloorSeat3DVrInfo.f);
                if (visitor == GeneratedMessageLite.C5383g.INSTANCE) {
                    this.d |= seat3DVrPB$FloorSeat3DVrInfo.d;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                C5401g c5401g = (C5401g) obj2;
                while (!z) {
                    try {
                        int v = codedInputStream.v();
                        if (v != 0) {
                            if (v == 8) {
                                this.e = codedInputStream.x();
                            } else if (v != 18) {
                                if (!codedInputStream.A(v)) {
                                }
                            } else {
                                if (!this.f.isModifiable()) {
                                    this.f = GeneratedMessageLite.r(this.f);
                                }
                                this.f.add(codedInputStream.l(Seat3DVrPB$Seat3DVrInfo.b0(), c5401g));
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
                if (h == null) {
                    synchronized (Seat3DVrPB$FloorSeat3DVrInfo.class) {
                        if (h == null) {
                            h = new GeneratedMessageLite.C5378b(g);
                        }
                    }
                }
                return h;
            default:
                throw new UnsupportedOperationException();
        }
        return g;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358477620")) {
            ipChange.ipc$dispatch("-1358477620", new Object[]{this, codedOutputStream});
            return;
        }
        long j = this.e;
        if (j != 0) {
            codedOutputStream.G(1, j);
        }
        for (int i = 0; i < this.f.size(); i++) {
            codedOutputStream.B(2, this.f.get(i));
        }
    }
}
