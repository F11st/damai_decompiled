package cn.damai.serialize.pbdecoder.pb;

import cn.damai.serialize.pbdecoder.pb.SeatPB$Seat;
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
public final class SeatPB$FloorSeat extends GeneratedMessageLite<SeatPB$FloorSeat, Builder> implements SeatPB$FloorSeatOrBuilder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int FLOORID_FIELD_NUMBER = 1;
    public static final int SEATLIST_FIELD_NUMBER = 2;
    private static final SeatPB$FloorSeat g;
    private static volatile Parser<SeatPB$FloorSeat> h;
    private int d;
    private long e;
    private Internal.ProtobufList<SeatPB$Seat> f = GeneratedMessageLite.k();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<SeatPB$FloorSeat, Builder> implements SeatPB$FloorSeatOrBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        /* synthetic */ Builder(C1742b c1742b) {
            this();
        }

        public Builder addAllSeatList(Iterable<? extends SeatPB$Seat> iterable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "706758440")) {
                return (Builder) ipChange.ipc$dispatch("706758440", new Object[]{this, iterable});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).K(iterable);
            return this;
        }

        public Builder addSeatList(SeatPB$Seat seatPB$Seat) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-957089905")) {
                return (Builder) ipChange.ipc$dispatch("-957089905", new Object[]{this, seatPB$Seat});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).O(seatPB$Seat);
            return this;
        }

        public Builder clearFloorId() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2015092072")) {
                return (Builder) ipChange.ipc$dispatch("2015092072", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).P();
            return this;
        }

        public Builder clearSeatList() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "754727456")) {
                return (Builder) ipChange.ipc$dispatch("754727456", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).Q();
            return this;
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
        public long getFloorId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1338058697") ? ((Long) ipChange.ipc$dispatch("1338058697", new Object[]{this})).longValue() : ((SeatPB$FloorSeat) this.instance).getFloorId();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
        public SeatPB$Seat getSeatList(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2047302163") ? (SeatPB$Seat) ipChange.ipc$dispatch("-2047302163", new Object[]{this, Integer.valueOf(i)}) : ((SeatPB$FloorSeat) this.instance).getSeatList(i);
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
        public int getSeatListCount() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1904792611") ? ((Integer) ipChange.ipc$dispatch("1904792611", new Object[]{this})).intValue() : ((SeatPB$FloorSeat) this.instance).getSeatListCount();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
        public List<SeatPB$Seat> getSeatListList() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-816772614") ? (List) ipChange.ipc$dispatch("-816772614", new Object[]{this}) : Collections.unmodifiableList(((SeatPB$FloorSeat) this.instance).getSeatListList());
        }

        public Builder removeSeatList(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "751149072")) {
                return (Builder) ipChange.ipc$dispatch("751149072", new Object[]{this, Integer.valueOf(i)});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).T(i);
            return this;
        }

        public Builder setFloorId(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-473530863")) {
                return (Builder) ipChange.ipc$dispatch("-473530863", new Object[]{this, Long.valueOf(j)});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).U(j);
            return this;
        }

        public Builder setSeatList(int i, SeatPB$Seat seatPB$Seat) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1925536723")) {
                return (Builder) ipChange.ipc$dispatch("1925536723", new Object[]{this, Integer.valueOf(i), seatPB$Seat});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).W(i, seatPB$Seat);
            return this;
        }

        private Builder() {
            super(SeatPB$FloorSeat.g);
        }

        public Builder addSeatList(int i, SeatPB$Seat seatPB$Seat) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "10941010")) {
                return (Builder) ipChange.ipc$dispatch("10941010", new Object[]{this, Integer.valueOf(i), seatPB$Seat});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).M(i, seatPB$Seat);
            return this;
        }

        public Builder setSeatList(int i, SeatPB$Seat.Builder builder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-342218966")) {
                return (Builder) ipChange.ipc$dispatch("-342218966", new Object[]{this, Integer.valueOf(i), builder});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).V(i, builder);
            return this;
        }

        public Builder addSeatList(SeatPB$Seat.Builder builder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2093005082")) {
                return (Builder) ipChange.ipc$dispatch("-2093005082", new Object[]{this, builder});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).N(builder);
            return this;
        }

        public Builder addSeatList(int i, SeatPB$Seat.Builder builder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1351037271")) {
                return (Builder) ipChange.ipc$dispatch("-1351037271", new Object[]{this, Integer.valueOf(i), builder});
            }
            copyOnWrite();
            ((SeatPB$FloorSeat) this.instance).L(i, builder);
            return this;
        }
    }

    static {
        SeatPB$FloorSeat seatPB$FloorSeat = new SeatPB$FloorSeat();
        g = seatPB$FloorSeat;
        seatPB$FloorSeat.q();
    }

    private SeatPB$FloorSeat() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(Iterable<? extends SeatPB$Seat> iterable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1883703755")) {
            ipChange.ipc$dispatch("-1883703755", new Object[]{this, iterable});
            return;
        }
        R();
        AbstractMessageLite.a(iterable, this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i, SeatPB$Seat.Builder builder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2080245214")) {
            ipChange.ipc$dispatch("-2080245214", new Object[]{this, Integer.valueOf(i), builder});
            return;
        }
        R();
        this.f.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, SeatPB$Seat seatPB$Seat) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-349309607")) {
            ipChange.ipc$dispatch("-349309607", new Object[]{this, Integer.valueOf(i), seatPB$Seat});
            return;
        }
        Objects.requireNonNull(seatPB$Seat);
        R();
        this.f.add(i, seatPB$Seat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(SeatPB$Seat.Builder builder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-737278217")) {
            ipChange.ipc$dispatch("-737278217", new Object[]{this, builder});
            return;
        }
        R();
        this.f.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(SeatPB$Seat seatPB$Seat) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1450531026")) {
            ipChange.ipc$dispatch("-1450531026", new Object[]{this, seatPB$Seat});
            return;
        }
        Objects.requireNonNull(seatPB$Seat);
        R();
        this.f.add(seatPB$Seat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285090635")) {
            ipChange.ipc$dispatch("-285090635", new Object[]{this});
        } else {
            this.e = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467710027")) {
            ipChange.ipc$dispatch("467710027", new Object[]{this});
        } else {
            this.f = GeneratedMessageLite.k();
        }
    }

    private void R() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-895916640")) {
            ipChange.ipc$dispatch("-895916640", new Object[]{this});
        } else if (this.f.isModifiable()) {
        } else {
            this.f = GeneratedMessageLite.r(this.f);
        }
    }

    public static Parser<SeatPB$FloorSeat> S() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1319412474") ? (Parser) ipChange.ipc$dispatch("1319412474", new Object[0]) : g.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954567323")) {
            ipChange.ipc$dispatch("954567323", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        R();
        this.f.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-391551750")) {
            ipChange.ipc$dispatch("-391551750", new Object[]{this, Long.valueOf(j)});
        } else {
            this.e = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, SeatPB$Seat.Builder builder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "41399937")) {
            ipChange.ipc$dispatch("41399937", new Object[]{this, Integer.valueOf(i), builder});
            return;
        }
        R();
        this.f.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i, SeatPB$Seat seatPB$Seat) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "922321080")) {
            ipChange.ipc$dispatch("922321080", new Object[]{this, Integer.valueOf(i), seatPB$Seat});
            return;
        }
        Objects.requireNonNull(seatPB$Seat);
        R();
        this.f.set(i, seatPB$Seat);
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
    public long getFloorId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-371120910") ? ((Long) ipChange.ipc$dispatch("-371120910", new Object[]{this})).longValue() : this.e;
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
    public SeatPB$Seat getSeatList(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-902429866") ? (SeatPB$Seat) ipChange.ipc$dispatch("-902429866", new Object[]{this, Integer.valueOf(i)}) : this.f.get(i);
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
    public int getSeatListCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1177121140") ? ((Integer) ipChange.ipc$dispatch("-1177121140", new Object[]{this})).intValue() : this.f.size();
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeatOrBuilder
    public List<SeatPB$Seat> getSeatListList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1393547427") ? (List) ipChange.ipc$dispatch("1393547427", new Object[]{this}) : this.f;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2141076877")) {
            return ((Integer) ipChange.ipc$dispatch("-2141076877", new Object[]{this})).intValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-1905483510")) {
            return ipChange.ipc$dispatch("-1905483510", new Object[]{this, methodToInvoke, obj, obj2});
        }
        switch (C1742b.a[methodToInvoke.ordinal()]) {
            case 1:
                return new SeatPB$FloorSeat();
            case 2:
                return g;
            case 3:
                this.f.makeImmutable();
                return null;
            case 4:
                return new Builder(null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                SeatPB$FloorSeat seatPB$FloorSeat = (SeatPB$FloorSeat) obj2;
                long j = this.e;
                boolean z2 = j != 0;
                long j2 = seatPB$FloorSeat.e;
                this.e = visitor.visitLong(z2, j, j2 != 0, j2);
                this.f = visitor.visitList(this.f, seatPB$FloorSeat.f);
                if (visitor == GeneratedMessageLite.C5383g.INSTANCE) {
                    this.d |= seatPB$FloorSeat.d;
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
                                this.f.add(codedInputStream.l(SeatPB$Seat.k0(), c5401g));
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
                    synchronized (SeatPB$FloorSeat.class) {
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
        if (AndroidInstantRuntime.support(ipChange, "-1853695900")) {
            ipChange.ipc$dispatch("-1853695900", new Object[]{this, codedOutputStream});
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
