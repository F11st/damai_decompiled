package logs.proto.wireless.performance.mobile.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.youku.uplayer.AliMediaPlayer;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class MemoryMetric$AndroidMemoryStats extends ExtendableMessageNano<MemoryMetric$AndroidMemoryStats> implements Cloneable {
    private Integer dalvikPssKb = null;
    private Integer nativePssKb = null;
    private Integer otherPssKb = null;
    private Integer dalvikPrivateDirtyKb = null;
    private Integer nativePrivateDirtyKb = null;
    private Integer otherPrivateDirtyKb = null;
    private Integer totalPrivateCleanKb = null;
    private Integer totalSharedDirtyKb = null;
    private Integer totalSwappablePssKb = null;
    private Integer otherGraphicsPssKb = null;
    private Integer summaryJavaHeapKb = null;
    private Integer summaryCodeKb = null;
    private Integer summaryStackKb = null;
    private Integer summaryGraphicsKb = null;
    private Integer summaryPrivateOtherKb = null;
    private Integer summarySystemKb = null;
    private Integer availableMemoryKb = null;
    private Integer totalMemoryMb = null;

    public MemoryMetric$AndroidMemoryStats() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
    }

    protected final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Integer num = this.dalvikPssKb;
        if (num != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
        }
        Integer num2 = this.nativePssKb;
        if (num2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
        }
        Integer num3 = this.otherPssKb;
        if (num3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue());
        }
        Integer num4 = this.dalvikPrivateDirtyKb;
        if (num4 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num4.intValue());
        }
        Integer num5 = this.nativePrivateDirtyKb;
        if (num5 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, num5.intValue());
        }
        Integer num6 = this.otherPrivateDirtyKb;
        if (num6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, num6.intValue());
        }
        Integer num7 = this.totalPrivateCleanKb;
        if (num7 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, num7.intValue());
        }
        Integer num8 = this.totalSharedDirtyKb;
        if (num8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, num8.intValue());
        }
        Integer num9 = this.totalSwappablePssKb;
        if (num9 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, num9.intValue());
        }
        Integer num10 = this.otherGraphicsPssKb;
        if (num10 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, num10.intValue());
        }
        Integer num11 = this.summaryJavaHeapKb;
        if (num11 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, num11.intValue());
        }
        Integer num12 = this.summaryCodeKb;
        if (num12 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, num12.intValue());
        }
        Integer num13 = this.summaryStackKb;
        if (num13 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, num13.intValue());
        }
        Integer num14 = this.summaryGraphicsKb;
        if (num14 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, num14.intValue());
        }
        Integer num15 = this.summaryPrivateOtherKb;
        if (num15 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, num15.intValue());
        }
        Integer num16 = this.summarySystemKb;
        if (num16 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(16, num16.intValue());
        }
        Integer num17 = this.availableMemoryKb;
        if (num17 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(17, num17.intValue());
        }
        Integer num18 = this.totalMemoryMb;
        return num18 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(18, num18.intValue()) : computeSerializedSize;
    }

    public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.dalvikPssKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 16:
                    this.nativePssKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 24:
                    this.otherPssKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 32:
                    this.dalvikPrivateDirtyKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 40:
                    this.nativePrivateDirtyKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 48:
                    this.otherPrivateDirtyKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 56:
                    this.totalPrivateCleanKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 64:
                    this.totalSharedDirtyKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 72:
                    this.totalSwappablePssKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 80:
                    this.otherGraphicsPssKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 88:
                    this.summaryJavaHeapKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 96:
                    this.summaryCodeKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 104:
                    this.summaryStackKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 112:
                    this.summaryGraphicsKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 120:
                    this.summaryPrivateOtherKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 128:
                    this.summarySystemKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case 136:
                    this.availableMemoryKb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_MAX_GEAR_KEEP /* 144 */:
                    this.totalMemoryMb = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    break;
                default:
                    if (super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }

    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Integer num = this.dalvikPssKb;
        if (num != null) {
            codedOutputByteBufferNano.writeInt32(1, num.intValue());
        }
        Integer num2 = this.nativePssKb;
        if (num2 != null) {
            codedOutputByteBufferNano.writeInt32(2, num2.intValue());
        }
        Integer num3 = this.otherPssKb;
        if (num3 != null) {
            codedOutputByteBufferNano.writeInt32(3, num3.intValue());
        }
        Integer num4 = this.dalvikPrivateDirtyKb;
        if (num4 != null) {
            codedOutputByteBufferNano.writeInt32(4, num4.intValue());
        }
        Integer num5 = this.nativePrivateDirtyKb;
        if (num5 != null) {
            codedOutputByteBufferNano.writeInt32(5, num5.intValue());
        }
        Integer num6 = this.otherPrivateDirtyKb;
        if (num6 != null) {
            codedOutputByteBufferNano.writeInt32(6, num6.intValue());
        }
        Integer num7 = this.totalPrivateCleanKb;
        if (num7 != null) {
            codedOutputByteBufferNano.writeInt32(7, num7.intValue());
        }
        Integer num8 = this.totalSharedDirtyKb;
        if (num8 != null) {
            codedOutputByteBufferNano.writeInt32(8, num8.intValue());
        }
        Integer num9 = this.totalSwappablePssKb;
        if (num9 != null) {
            codedOutputByteBufferNano.writeInt32(9, num9.intValue());
        }
        Integer num10 = this.otherGraphicsPssKb;
        if (num10 != null) {
            codedOutputByteBufferNano.writeInt32(10, num10.intValue());
        }
        Integer num11 = this.summaryJavaHeapKb;
        if (num11 != null) {
            codedOutputByteBufferNano.writeInt32(11, num11.intValue());
        }
        Integer num12 = this.summaryCodeKb;
        if (num12 != null) {
            codedOutputByteBufferNano.writeInt32(12, num12.intValue());
        }
        Integer num13 = this.summaryStackKb;
        if (num13 != null) {
            codedOutputByteBufferNano.writeInt32(13, num13.intValue());
        }
        Integer num14 = this.summaryGraphicsKb;
        if (num14 != null) {
            codedOutputByteBufferNano.writeInt32(14, num14.intValue());
        }
        Integer num15 = this.summaryPrivateOtherKb;
        if (num15 != null) {
            codedOutputByteBufferNano.writeInt32(15, num15.intValue());
        }
        Integer num16 = this.summarySystemKb;
        if (num16 != null) {
            codedOutputByteBufferNano.writeInt32(16, num16.intValue());
        }
        Integer num17 = this.availableMemoryKb;
        if (num17 != null) {
            codedOutputByteBufferNano.writeInt32(17, num17.intValue());
        }
        Integer num18 = this.totalMemoryMb;
        if (num18 != null) {
            codedOutputByteBufferNano.writeInt32(18, num18.intValue());
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    /* renamed from: clone  reason: collision with other method in class */
    public final MemoryMetric$AndroidMemoryStats m1287clone() {
        try {
            return (MemoryMetric$AndroidMemoryStats) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
