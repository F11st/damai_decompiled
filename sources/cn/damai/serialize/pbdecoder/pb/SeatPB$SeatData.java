package cn.damai.serialize.pbdecoder.pb;

import cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.g;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class SeatPB$SeatData extends GeneratedMessageLite<SeatPB$SeatData, Builder> implements SeatPB$SeatDataOrBuilder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int FLOORSEAT_FIELD_NUMBER = 1;
    private static final SeatPB$SeatData e;
    private static volatile Parser<SeatPB$SeatData> f;
    private Internal.ProtobufList<SeatPB$FloorSeat> d = GeneratedMessageLite.k();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<SeatPB$SeatData, Builder> implements SeatPB$SeatDataOrBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        /* synthetic */ Builder(b bVar) {
            this();
        }

        public Builder addAllFloorSeat(Iterable<? extends SeatPB$FloorSeat> iterable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2145084860")) {
                return (Builder) ipChange.ipc$dispatch("2145084860", new Object[]{this, iterable});
            }
            copyOnWrite();
            ((SeatPB$SeatData) this.instance).I(iterable);
            return this;
        }

        public Builder addFloorSeat(SeatPB$FloorSeat seatPB$FloorSeat) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1912208749")) {
                return (Builder) ipChange.ipc$dispatch("-1912208749", new Object[]{this, seatPB$FloorSeat});
            }
            copyOnWrite();
            ((SeatPB$SeatData) this.instance).M(seatPB$FloorSeat);
            return this;
        }

        public Builder clearFloorSeat() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1587436950")) {
                return (Builder) ipChange.ipc$dispatch("-1587436950", new Object[]{this});
            }
            copyOnWrite();
            ((SeatPB$SeatData) this.instance).N();
            return this;
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatDataOrBuilder
        public SeatPB$FloorSeat getFloorSeat(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1244008775") ? (SeatPB$FloorSeat) ipChange.ipc$dispatch("1244008775", new Object[]{this, Integer.valueOf(i)}) : ((SeatPB$SeatData) this.instance).getFloorSeat(i);
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatDataOrBuilder
        public int getFloorSeatCount() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1615825969") ? ((Integer) ipChange.ipc$dispatch("-1615825969", new Object[]{this})).intValue() : ((SeatPB$SeatData) this.instance).getFloorSeatCount();
        }

        @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatDataOrBuilder
        public List<SeatPB$FloorSeat> getFloorSeatList() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1403112614") ? (List) ipChange.ipc$dispatch("1403112614", new Object[]{this}) : Collections.unmodifiableList(((SeatPB$SeatData) this.instance).getFloorSeatList());
        }

        public Builder removeFloorSeat(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-29205932")) {
                return (Builder) ipChange.ipc$dispatch("-29205932", new Object[]{this, Integer.valueOf(i)});
            }
            copyOnWrite();
            ((SeatPB$SeatData) this.instance).Q(i);
            return this;
        }

        public Builder setFloorSeat(int i, SeatPB$FloorSeat seatPB$FloorSeat) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-662426207")) {
                return (Builder) ipChange.ipc$dispatch("-662426207", new Object[]{this, Integer.valueOf(i), seatPB$FloorSeat});
            }
            copyOnWrite();
            ((SeatPB$SeatData) this.instance).S(i, seatPB$FloorSeat);
            return this;
        }

        private Builder() {
            super(SeatPB$SeatData.e);
        }

        public Builder addFloorSeat(int i, SeatPB$FloorSeat seatPB$FloorSeat) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1628975486")) {
                return (Builder) ipChange.ipc$dispatch("-1628975486", new Object[]{this, Integer.valueOf(i), seatPB$FloorSeat});
            }
            copyOnWrite();
            ((SeatPB$SeatData) this.instance).K(i, seatPB$FloorSeat);
            return this;
        }

        public Builder setFloorSeat(int i, SeatPB$FloorSeat.Builder builder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-719327382")) {
                return (Builder) ipChange.ipc$dispatch("-719327382", new Object[]{this, Integer.valueOf(i), builder});
            }
            copyOnWrite();
            ((SeatPB$SeatData) this.instance).R(i, builder);
            return this;
        }

        public Builder addFloorSeat(SeatPB$FloorSeat.Builder builder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1312731740")) {
                return (Builder) ipChange.ipc$dispatch("1312731740", new Object[]{this, builder});
            }
            copyOnWrite();
            ((SeatPB$SeatData) this.instance).L(builder);
            return this;
        }

        public Builder addFloorSeat(int i, SeatPB$FloorSeat.Builder builder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1643569333")) {
                return (Builder) ipChange.ipc$dispatch("-1643569333", new Object[]{this, Integer.valueOf(i), builder});
            }
            copyOnWrite();
            ((SeatPB$SeatData) this.instance).J(i, builder);
            return this;
        }
    }

    static {
        SeatPB$SeatData seatPB$SeatData = new SeatPB$SeatData();
        e = seatPB$SeatData;
        seatPB$SeatData.q();
    }

    private SeatPB$SeatData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(Iterable<? extends SeatPB$FloorSeat> iterable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-202926721")) {
            ipChange.ipc$dispatch("-202926721", new Object[]{this, iterable});
            return;
        }
        O();
        AbstractMessageLite.a(iterable, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i, SeatPB$FloorSeat.Builder builder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1118283634")) {
            ipChange.ipc$dispatch("-1118283634", new Object[]{this, Integer.valueOf(i), builder});
            return;
        }
        O();
        this.d.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i, SeatPB$FloorSeat seatPB$FloorSeat) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-456163387")) {
            ipChange.ipc$dispatch("-456163387", new Object[]{this, Integer.valueOf(i), seatPB$FloorSeat});
            return;
        }
        Objects.requireNonNull(seatPB$FloorSeat);
        O();
        this.d.add(i, seatPB$FloorSeat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(SeatPB$FloorSeat.Builder builder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679709999")) {
            ipChange.ipc$dispatch("-1679709999", new Object[]{this, builder});
            return;
        }
        O();
        this.d.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(SeatPB$FloorSeat seatPB$FloorSeat) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1331872520")) {
            ipChange.ipc$dispatch("1331872520", new Object[]{this, seatPB$FloorSeat});
            return;
        }
        Objects.requireNonNull(seatPB$FloorSeat);
        O();
        this.d.add(seatPB$FloorSeat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "234629599")) {
            ipChange.ipc$dispatch("234629599", new Object[]{this});
        } else {
            this.d = GeneratedMessageLite.k();
        }
    }

    private void O() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "370638938")) {
            ipChange.ipc$dispatch("370638938", new Object[]{this});
        } else if (this.d.isModifiable()) {
        } else {
            this.d = GeneratedMessageLite.r(this.d);
        }
    }

    public static SeatPB$SeatData P(byte[] bArr) throws InvalidProtocolBufferException {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1920713028") ? (SeatPB$SeatData) ipChange.ipc$dispatch("-1920713028", new Object[]{bArr}) : (SeatPB$SeatData) GeneratedMessageLite.t(e, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-879418999")) {
            ipChange.ipc$dispatch("-879418999", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        O();
        this.d.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, SeatPB$FloorSeat.Builder builder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2063527507")) {
            ipChange.ipc$dispatch("-2063527507", new Object[]{this, Integer.valueOf(i), builder});
            return;
        }
        O();
        this.d.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i, SeatPB$FloorSeat seatPB$FloorSeat) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1879652380")) {
            ipChange.ipc$dispatch("-1879652380", new Object[]{this, Integer.valueOf(i), seatPB$FloorSeat});
            return;
        }
        Objects.requireNonNull(seatPB$FloorSeat);
        O();
        this.d.set(i, seatPB$FloorSeat);
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatDataOrBuilder
    public SeatPB$FloorSeat getFloorSeat(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-349679632") ? (SeatPB$FloorSeat) ipChange.ipc$dispatch("-349679632", new Object[]{this, Integer.valueOf(i)}) : this.d.get(i);
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatDataOrBuilder
    public int getFloorSeatCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-129944954") ? ((Integer) ipChange.ipc$dispatch("-129944954", new Object[]{this})).intValue() : this.d.size();
    }

    @Override // cn.damai.serialize.pbdecoder.pb.SeatPB$SeatDataOrBuilder
    public List<SeatPB$FloorSeat> getFloorSeatList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2065236195") ? (List) ipChange.ipc$dispatch("-2065236195", new Object[]{this}) : this.d;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1750701857")) {
            return ((Integer) ipChange.ipc$dispatch("-1750701857", new Object[]{this})).intValue();
        }
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.d.size(); i3++) {
            i2 += CodedOutputStream.i(1, this.d.get(i3));
        }
        this.c = i2;
        return i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object j(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "342564982")) {
            return ipChange.ipc$dispatch("342564982", new Object[]{this, methodToInvoke, obj, obj2});
        }
        switch (b.a[methodToInvoke.ordinal()]) {
            case 1:
                return new SeatPB$SeatData();
            case 2:
                return e;
            case 3:
                this.d.makeImmutable();
                return null;
            case 4:
                return new Builder(null);
            case 5:
                this.d = ((GeneratedMessageLite.Visitor) obj).visitList(this.d, ((SeatPB$SeatData) obj2).d);
                GeneratedMessageLite.g gVar = GeneratedMessageLite.g.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                g gVar2 = (g) obj2;
                while (!z) {
                    try {
                        int v = codedInputStream.v();
                        if (v != 0) {
                            if (v != 10) {
                                if (!codedInputStream.A(v)) {
                                }
                            } else {
                                if (!this.d.isModifiable()) {
                                    this.d = GeneratedMessageLite.r(this.d);
                                }
                                this.d.add(codedInputStream.l(SeatPB$FloorSeat.S(), gVar2));
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw new RuntimeException(e2.setUnfinishedMessage(this));
                    } catch (IOException e3) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f == null) {
                    synchronized (SeatPB$SeatData.class) {
                        if (f == null) {
                            f = new GeneratedMessageLite.b(e);
                        }
                    }
                }
                return f;
            default:
                throw new UnsupportedOperationException();
        }
        return e;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1327474312")) {
            ipChange.ipc$dispatch("-1327474312", new Object[]{this, codedOutputStream});
            return;
        }
        for (int i = 0; i < this.d.size(); i++) {
            codedOutputStream.B(1, this.d.get(i));
        }
    }
}
