package com.google.vr.sdk.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class Session {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class Pose extends ExtendableMessageNano<Pose> implements Cloneable {
        private static volatile Pose[] _emptyArray;
        public float[] p;
        public float[] q;

        public Pose() {
            clear();
        }

        public static Pose[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Pose[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static Pose parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new Pose(), bArr);
        }

        public final Pose clear() {
            this.q = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.p = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            float[] fArr = this.q;
            if (fArr != null && fArr.length > 0) {
                int length = fArr.length * 4;
                computeSerializedSize = computeSerializedSize + length + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length);
            }
            float[] fArr2 = this.p;
            if (fArr2 == null || fArr2.length <= 0) {
                return computeSerializedSize;
            }
            int length2 = fArr2.length * 4;
            return computeSerializedSize + length2 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length2);
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            float[] fArr = this.q;
            int i = 0;
            if (fArr != null && fArr.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(10);
                codedOutputByteBufferNano.writeRawVarint32(fArr.length * 4);
                int i2 = 0;
                while (true) {
                    float[] fArr2 = this.q;
                    if (i2 >= fArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloatNoTag(fArr2[i2]);
                    i2++;
                }
            }
            float[] fArr3 = this.p;
            if (fArr3 != null && fArr3.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(18);
                codedOutputByteBufferNano.writeRawVarint32(fArr3.length * 4);
                while (true) {
                    float[] fArr4 = this.p;
                    if (i >= fArr4.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloatNoTag(fArr4[i]);
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static Pose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new Pose().mergeFrom(codedInputByteBufferNano);
        }

        public final Pose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                    int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                    int i = readRawVarint32 / 4;
                    float[] fArr = this.q;
                    int length = fArr == null ? 0 : fArr.length;
                    int i2 = i + length;
                    float[] fArr2 = new float[i2];
                    if (length != 0) {
                        System.arraycopy(fArr, 0, fArr2, 0, length);
                    }
                    while (length < i2) {
                        fArr2[length] = codedInputByteBufferNano.readFloat();
                        length++;
                    }
                    this.q = fArr2;
                    codedInputByteBufferNano.popLimit(pushLimit);
                } else if (readTag == 13) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 13);
                    float[] fArr3 = this.q;
                    int length2 = fArr3 == null ? 0 : fArr3.length;
                    int i3 = repeatedFieldArrayLength + length2;
                    float[] fArr4 = new float[i3];
                    if (length2 != 0) {
                        System.arraycopy(fArr3, 0, fArr4, 0, length2);
                    }
                    while (length2 < i3 - 1) {
                        fArr4[length2] = codedInputByteBufferNano.readFloat();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    fArr4[length2] = codedInputByteBufferNano.readFloat();
                    this.q = fArr4;
                } else if (readTag == 18) {
                    int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                    int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                    int i4 = readRawVarint322 / 4;
                    float[] fArr5 = this.p;
                    int length3 = fArr5 == null ? 0 : fArr5.length;
                    int i5 = i4 + length3;
                    float[] fArr6 = new float[i5];
                    if (length3 != 0) {
                        System.arraycopy(fArr5, 0, fArr6, 0, length3);
                    }
                    while (length3 < i5) {
                        fArr6[length3] = codedInputByteBufferNano.readFloat();
                        length3++;
                    }
                    this.p = fArr6;
                    codedInputByteBufferNano.popLimit(pushLimit2);
                } else if (readTag != 21) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 21);
                    float[] fArr7 = this.p;
                    int length4 = fArr7 == null ? 0 : fArr7.length;
                    int i6 = repeatedFieldArrayLength2 + length4;
                    float[] fArr8 = new float[i6];
                    if (length4 != 0) {
                        System.arraycopy(fArr7, 0, fArr8, 0, length4);
                    }
                    while (length4 < i6 - 1) {
                        fArr8[length4] = codedInputByteBufferNano.readFloat();
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    fArr8[length4] = codedInputByteBufferNano.readFloat();
                    this.p = fArr8;
                }
            }
        }

        /* renamed from: clone  reason: collision with other method in class */
        public final Pose m564clone() {
            try {
                Pose pose = (Pose) super.clone();
                float[] fArr = this.q;
                if (fArr != null && fArr.length > 0) {
                    pose.q = (float[]) fArr.clone();
                }
                float[] fArr2 = this.p;
                if (fArr2 != null && fArr2.length > 0) {
                    pose.p = (float[]) fArr2.clone();
                }
                return pose;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class RecenteredState extends ExtendableMessageNano<RecenteredState> implements Cloneable {
        private static volatile RecenteredState[] _emptyArray;
        private boolean applyDisplayFromSensorRotation_;
        private int bitField0_;
        public Pose headRecenterPoseInTrackingSpace;
        private long timestampNs_;
        private int type_;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public interface Type {
            public static final int TYPE_INVALID = 0;
        }

        public RecenteredState() {
            clear();
        }

        public static RecenteredState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RecenteredState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static RecenteredState parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new RecenteredState(), bArr);
        }

        public final RecenteredState clear() {
            this.bitField0_ = 0;
            this.timestampNs_ = 0L;
            this.type_ = 0;
            this.headRecenterPoseInTrackingSpace = null;
            this.applyDisplayFromSensorRotation_ = true;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final RecenteredState clearApplyDisplayFromSensorRotation() {
            this.applyDisplayFromSensorRotation_ = true;
            this.bitField0_ &= -5;
            return this;
        }

        public final RecenteredState clearTimestampNs() {
            this.timestampNs_ = 0L;
            this.bitField0_ &= -2;
            return this;
        }

        public final RecenteredState clearType() {
            this.bitField0_ &= -3;
            this.type_ = 0;
            return this;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, this.timestampNs_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, this.type_);
            }
            Pose pose = this.headRecenterPoseInTrackingSpace;
            if (pose != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, pose);
            }
            return (this.bitField0_ & 4) != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, this.applyDisplayFromSensorRotation_) : computeSerializedSize;
        }

        public final boolean getApplyDisplayFromSensorRotation() {
            return this.applyDisplayFromSensorRotation_;
        }

        public final long getTimestampNs() {
            return this.timestampNs_;
        }

        public final int getType() {
            return this.type_;
        }

        public final boolean hasApplyDisplayFromSensorRotation() {
            return (this.bitField0_ & 4) != 0;
        }

        public final boolean hasTimestampNs() {
            return (this.bitField0_ & 1) != 0;
        }

        public final boolean hasType() {
            return (this.bitField0_ & 2) != 0;
        }

        public final RecenteredState setApplyDisplayFromSensorRotation(boolean z) {
            this.bitField0_ |= 4;
            this.applyDisplayFromSensorRotation_ = z;
            return this;
        }

        public final RecenteredState setTimestampNs(long j) {
            this.bitField0_ |= 1;
            this.timestampNs_ = j;
            return this;
        }

        public final RecenteredState setType(int i) {
            this.type_ = i;
            this.bitField0_ |= 2;
            return this;
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt64(1, this.timestampNs_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeInt32(2, this.type_);
            }
            Pose pose = this.headRecenterPoseInTrackingSpace;
            if (pose != null) {
                codedOutputByteBufferNano.writeMessage(3, pose);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeBool(4, this.applyDisplayFromSensorRotation_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static RecenteredState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new RecenteredState().mergeFrom(codedInputByteBufferNano);
        }

        public final RecenteredState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.timestampNs_ = codedInputByteBufferNano.readInt64();
                    this.bitField0_ |= 1;
                } else if (readTag == 16) {
                    this.bitField0_ |= 2;
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0) {
                        codedInputByteBufferNano.rewindToPosition(position);
                        storeUnknownField(codedInputByteBufferNano, readTag);
                    } else {
                        this.type_ = readInt32;
                        this.bitField0_ |= 2;
                    }
                } else if (readTag == 26) {
                    if (this.headRecenterPoseInTrackingSpace == null) {
                        this.headRecenterPoseInTrackingSpace = new Pose();
                    }
                    codedInputByteBufferNano.readMessage(this.headRecenterPoseInTrackingSpace);
                } else if (readTag != 32) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.applyDisplayFromSensorRotation_ = codedInputByteBufferNano.readBool();
                    this.bitField0_ |= 4;
                }
            }
        }

        /* renamed from: clone  reason: collision with other method in class */
        public final RecenteredState m568clone() {
            try {
                RecenteredState recenteredState = (RecenteredState) super.clone();
                Pose pose = this.headRecenterPoseInTrackingSpace;
                if (pose != null) {
                    recenteredState.headRecenterPoseInTrackingSpace = pose.m564clone();
                }
                return recenteredState;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class TrackerState extends ExtendableMessageNano<TrackerState> implements Cloneable {
        private static volatile TrackerState[] _emptyArray;
        private int bitField0_;
        public double[] gyroscopeBias;
        public double[] lastGyroscopeSample;
        private double lastGyroscopeTimestamp_;
        public float[] lensOffset;
        private long magCalibrationTimeSinceEpochSeconds_;
        private double magneticFieldStrength_;
        public double[] magnetometerBias;
        public double[] q;
        public float[] rightLensOffset;
        private long timeSinceEpochSeconds_;
        private boolean trackingInVrcore_;

        public TrackerState() {
            clear();
        }

        public static TrackerState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new TrackerState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static TrackerState parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new TrackerState(), bArr);
        }

        public final TrackerState clear() {
            this.bitField0_ = 0;
            this.q = WireFormatNano.EMPTY_DOUBLE_ARRAY;
            this.timeSinceEpochSeconds_ = 0L;
            this.gyroscopeBias = WireFormatNano.EMPTY_DOUBLE_ARRAY;
            this.lensOffset = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.lastGyroscopeSample = WireFormatNano.EMPTY_DOUBLE_ARRAY;
            this.lastGyroscopeTimestamp_ = 0.0d;
            this.trackingInVrcore_ = false;
            this.magnetometerBias = WireFormatNano.EMPTY_DOUBLE_ARRAY;
            this.magneticFieldStrength_ = 0.0d;
            this.magCalibrationTimeSinceEpochSeconds_ = 0L;
            this.rightLensOffset = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final TrackerState clearLastGyroscopeTimestamp() {
            this.lastGyroscopeTimestamp_ = 0.0d;
            this.bitField0_ &= -3;
            return this;
        }

        public final TrackerState clearMagCalibrationTimeSinceEpochSeconds() {
            this.magCalibrationTimeSinceEpochSeconds_ = 0L;
            this.bitField0_ &= -17;
            return this;
        }

        public final TrackerState clearMagneticFieldStrength() {
            this.magneticFieldStrength_ = 0.0d;
            this.bitField0_ &= -9;
            return this;
        }

        public final TrackerState clearTimeSinceEpochSeconds() {
            this.timeSinceEpochSeconds_ = 0L;
            this.bitField0_ &= -2;
            return this;
        }

        public final TrackerState clearTrackingInVrcore() {
            this.trackingInVrcore_ = false;
            this.bitField0_ &= -5;
            return this;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            double[] dArr = this.q;
            if (dArr != null && dArr.length > 0) {
                int length = dArr.length * 8;
                computeSerializedSize = computeSerializedSize + length + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length);
            }
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, this.timeSinceEpochSeconds_);
            }
            double[] dArr2 = this.gyroscopeBias;
            if (dArr2 != null && dArr2.length > 0) {
                int length2 = dArr2.length * 8;
                computeSerializedSize = computeSerializedSize + length2 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length2);
            }
            float[] fArr = this.lensOffset;
            if (fArr != null && fArr.length > 0) {
                int length3 = fArr.length * 4;
                computeSerializedSize = computeSerializedSize + length3 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length3);
            }
            double[] dArr3 = this.lastGyroscopeSample;
            if (dArr3 != null && dArr3.length > 0) {
                int length4 = dArr3.length * 8;
                computeSerializedSize = computeSerializedSize + length4 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length4);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(6, this.lastGyroscopeTimestamp_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, this.trackingInVrcore_);
            }
            double[] dArr4 = this.magnetometerBias;
            if (dArr4 != null && dArr4.length > 0) {
                int length5 = dArr4.length * 8;
                computeSerializedSize = computeSerializedSize + length5 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length5);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(9, this.magneticFieldStrength_);
            }
            if ((this.bitField0_ & 16) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(10, this.magCalibrationTimeSinceEpochSeconds_);
            }
            float[] fArr2 = this.rightLensOffset;
            if (fArr2 == null || fArr2.length <= 0) {
                return computeSerializedSize;
            }
            int length6 = fArr2.length * 4;
            return computeSerializedSize + length6 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length6);
        }

        public final double getLastGyroscopeTimestamp() {
            return this.lastGyroscopeTimestamp_;
        }

        public final long getMagCalibrationTimeSinceEpochSeconds() {
            return this.magCalibrationTimeSinceEpochSeconds_;
        }

        public final double getMagneticFieldStrength() {
            return this.magneticFieldStrength_;
        }

        public final long getTimeSinceEpochSeconds() {
            return this.timeSinceEpochSeconds_;
        }

        public final boolean getTrackingInVrcore() {
            return this.trackingInVrcore_;
        }

        public final boolean hasLastGyroscopeTimestamp() {
            return (this.bitField0_ & 2) != 0;
        }

        public final boolean hasMagCalibrationTimeSinceEpochSeconds() {
            return (this.bitField0_ & 16) != 0;
        }

        public final boolean hasMagneticFieldStrength() {
            return (this.bitField0_ & 8) != 0;
        }

        public final boolean hasTimeSinceEpochSeconds() {
            return (this.bitField0_ & 1) != 0;
        }

        public final boolean hasTrackingInVrcore() {
            return (this.bitField0_ & 4) != 0;
        }

        public final TrackerState setLastGyroscopeTimestamp(double d) {
            this.bitField0_ |= 2;
            this.lastGyroscopeTimestamp_ = d;
            return this;
        }

        public final TrackerState setMagCalibrationTimeSinceEpochSeconds(long j) {
            this.bitField0_ |= 16;
            this.magCalibrationTimeSinceEpochSeconds_ = j;
            return this;
        }

        public final TrackerState setMagneticFieldStrength(double d) {
            this.bitField0_ |= 8;
            this.magneticFieldStrength_ = d;
            return this;
        }

        public final TrackerState setTimeSinceEpochSeconds(long j) {
            this.bitField0_ |= 1;
            this.timeSinceEpochSeconds_ = j;
            return this;
        }

        public final TrackerState setTrackingInVrcore(boolean z) {
            this.bitField0_ |= 4;
            this.trackingInVrcore_ = z;
            return this;
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            double[] dArr = this.q;
            int i = 0;
            if (dArr != null && dArr.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(10);
                codedOutputByteBufferNano.writeRawVarint32(dArr.length * 8);
                int i2 = 0;
                while (true) {
                    double[] dArr2 = this.q;
                    if (i2 >= dArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeDoubleNoTag(dArr2[i2]);
                    i2++;
                }
            }
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt64(2, this.timeSinceEpochSeconds_);
            }
            double[] dArr3 = this.gyroscopeBias;
            if (dArr3 != null && dArr3.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(26);
                codedOutputByteBufferNano.writeRawVarint32(dArr3.length * 8);
                int i3 = 0;
                while (true) {
                    double[] dArr4 = this.gyroscopeBias;
                    if (i3 >= dArr4.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeDoubleNoTag(dArr4[i3]);
                    i3++;
                }
            }
            float[] fArr = this.lensOffset;
            if (fArr != null && fArr.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(34);
                codedOutputByteBufferNano.writeRawVarint32(fArr.length * 4);
                int i4 = 0;
                while (true) {
                    float[] fArr2 = this.lensOffset;
                    if (i4 >= fArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloatNoTag(fArr2[i4]);
                    i4++;
                }
            }
            double[] dArr5 = this.lastGyroscopeSample;
            if (dArr5 != null && dArr5.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(42);
                codedOutputByteBufferNano.writeRawVarint32(dArr5.length * 8);
                int i5 = 0;
                while (true) {
                    double[] dArr6 = this.lastGyroscopeSample;
                    if (i5 >= dArr6.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeDoubleNoTag(dArr6[i5]);
                    i5++;
                }
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeDouble(6, this.lastGyroscopeTimestamp_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeBool(7, this.trackingInVrcore_);
            }
            double[] dArr7 = this.magnetometerBias;
            if (dArr7 != null && dArr7.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(66);
                codedOutputByteBufferNano.writeRawVarint32(dArr7.length * 8);
                int i6 = 0;
                while (true) {
                    double[] dArr8 = this.magnetometerBias;
                    if (i6 >= dArr8.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeDoubleNoTag(dArr8[i6]);
                    i6++;
                }
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputByteBufferNano.writeDouble(9, this.magneticFieldStrength_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputByteBufferNano.writeInt64(10, this.magCalibrationTimeSinceEpochSeconds_);
            }
            float[] fArr3 = this.rightLensOffset;
            if (fArr3 != null && fArr3.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(90);
                codedOutputByteBufferNano.writeRawVarint32(fArr3.length * 4);
                while (true) {
                    float[] fArr4 = this.rightLensOffset;
                    if (i >= fArr4.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloatNoTag(fArr4[i]);
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static TrackerState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new TrackerState().mergeFrom(codedInputByteBufferNano);
        }

        public final TrackerState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 16) {
                    this.timeSinceEpochSeconds_ = codedInputByteBufferNano.readInt64();
                    this.bitField0_ |= 1;
                } else if (readTag == 34) {
                    int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                    int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                    int i = readRawVarint32 / 4;
                    float[] fArr = this.lensOffset;
                    int length = fArr == null ? 0 : fArr.length;
                    int i2 = i + length;
                    float[] fArr2 = new float[i2];
                    if (length != 0) {
                        System.arraycopy(fArr, 0, fArr2, 0, length);
                    }
                    while (length < i2) {
                        fArr2[length] = codedInputByteBufferNano.readFloat();
                        length++;
                    }
                    this.lensOffset = fArr2;
                    codedInputByteBufferNano.popLimit(pushLimit);
                } else if (readTag == 37) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 37);
                    float[] fArr3 = this.lensOffset;
                    int length2 = fArr3 == null ? 0 : fArr3.length;
                    int i3 = repeatedFieldArrayLength + length2;
                    float[] fArr4 = new float[i3];
                    if (length2 != 0) {
                        System.arraycopy(fArr3, 0, fArr4, 0, length2);
                    }
                    while (length2 < i3 - 1) {
                        fArr4[length2] = codedInputByteBufferNano.readFloat();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    fArr4[length2] = codedInputByteBufferNano.readFloat();
                    this.lensOffset = fArr4;
                } else if (readTag == 49) {
                    this.lastGyroscopeTimestamp_ = codedInputByteBufferNano.readDouble();
                    this.bitField0_ |= 2;
                } else if (readTag == 56) {
                    this.trackingInVrcore_ = codedInputByteBufferNano.readBool();
                    this.bitField0_ |= 4;
                } else if (readTag == 73) {
                    this.magneticFieldStrength_ = codedInputByteBufferNano.readDouble();
                    this.bitField0_ |= 8;
                } else if (readTag == 80) {
                    this.magCalibrationTimeSinceEpochSeconds_ = codedInputByteBufferNano.readInt64();
                    this.bitField0_ |= 16;
                } else if (readTag == 90) {
                    int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                    int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                    int i4 = readRawVarint322 / 4;
                    float[] fArr5 = this.rightLensOffset;
                    int length3 = fArr5 == null ? 0 : fArr5.length;
                    int i5 = i4 + length3;
                    float[] fArr6 = new float[i5];
                    if (length3 != 0) {
                        System.arraycopy(fArr5, 0, fArr6, 0, length3);
                    }
                    while (length3 < i5) {
                        fArr6[length3] = codedInputByteBufferNano.readFloat();
                        length3++;
                    }
                    this.rightLensOffset = fArr6;
                    codedInputByteBufferNano.popLimit(pushLimit2);
                } else if (readTag == 93) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 93);
                    float[] fArr7 = this.rightLensOffset;
                    int length4 = fArr7 == null ? 0 : fArr7.length;
                    int i6 = repeatedFieldArrayLength2 + length4;
                    float[] fArr8 = new float[i6];
                    if (length4 != 0) {
                        System.arraycopy(fArr7, 0, fArr8, 0, length4);
                    }
                    while (length4 < i6 - 1) {
                        fArr8[length4] = codedInputByteBufferNano.readFloat();
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    fArr8[length4] = codedInputByteBufferNano.readFloat();
                    this.rightLensOffset = fArr8;
                } else if (readTag == 9) {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 9);
                    double[] dArr = this.q;
                    int length5 = dArr == null ? 0 : dArr.length;
                    int i7 = repeatedFieldArrayLength3 + length5;
                    double[] dArr2 = new double[i7];
                    if (length5 != 0) {
                        System.arraycopy(dArr, 0, dArr2, 0, length5);
                    }
                    while (length5 < i7 - 1) {
                        dArr2[length5] = codedInputByteBufferNano.readDouble();
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    dArr2[length5] = codedInputByteBufferNano.readDouble();
                    this.q = dArr2;
                } else if (readTag == 10) {
                    int readRawVarint323 = codedInputByteBufferNano.readRawVarint32();
                    int pushLimit3 = codedInputByteBufferNano.pushLimit(readRawVarint323);
                    int i8 = readRawVarint323 / 8;
                    double[] dArr3 = this.q;
                    int length6 = dArr3 == null ? 0 : dArr3.length;
                    int i9 = i8 + length6;
                    double[] dArr4 = new double[i9];
                    if (length6 != 0) {
                        System.arraycopy(dArr3, 0, dArr4, 0, length6);
                    }
                    while (length6 < i9) {
                        dArr4[length6] = codedInputByteBufferNano.readDouble();
                        length6++;
                    }
                    this.q = dArr4;
                    codedInputByteBufferNano.popLimit(pushLimit3);
                } else if (readTag == 25) {
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 25);
                    double[] dArr5 = this.gyroscopeBias;
                    int length7 = dArr5 == null ? 0 : dArr5.length;
                    int i10 = repeatedFieldArrayLength4 + length7;
                    double[] dArr6 = new double[i10];
                    if (length7 != 0) {
                        System.arraycopy(dArr5, 0, dArr6, 0, length7);
                    }
                    while (length7 < i10 - 1) {
                        dArr6[length7] = codedInputByteBufferNano.readDouble();
                        codedInputByteBufferNano.readTag();
                        length7++;
                    }
                    dArr6[length7] = codedInputByteBufferNano.readDouble();
                    this.gyroscopeBias = dArr6;
                } else if (readTag == 26) {
                    int readRawVarint324 = codedInputByteBufferNano.readRawVarint32();
                    int pushLimit4 = codedInputByteBufferNano.pushLimit(readRawVarint324);
                    int i11 = readRawVarint324 / 8;
                    double[] dArr7 = this.gyroscopeBias;
                    int length8 = dArr7 == null ? 0 : dArr7.length;
                    int i12 = i11 + length8;
                    double[] dArr8 = new double[i12];
                    if (length8 != 0) {
                        System.arraycopy(dArr7, 0, dArr8, 0, length8);
                    }
                    while (length8 < i12) {
                        dArr8[length8] = codedInputByteBufferNano.readDouble();
                        length8++;
                    }
                    this.gyroscopeBias = dArr8;
                    codedInputByteBufferNano.popLimit(pushLimit4);
                } else if (readTag == 41) {
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 41);
                    double[] dArr9 = this.lastGyroscopeSample;
                    int length9 = dArr9 == null ? 0 : dArr9.length;
                    int i13 = repeatedFieldArrayLength5 + length9;
                    double[] dArr10 = new double[i13];
                    if (length9 != 0) {
                        System.arraycopy(dArr9, 0, dArr10, 0, length9);
                    }
                    while (length9 < i13 - 1) {
                        dArr10[length9] = codedInputByteBufferNano.readDouble();
                        codedInputByteBufferNano.readTag();
                        length9++;
                    }
                    dArr10[length9] = codedInputByteBufferNano.readDouble();
                    this.lastGyroscopeSample = dArr10;
                } else if (readTag == 42) {
                    int readRawVarint325 = codedInputByteBufferNano.readRawVarint32();
                    int pushLimit5 = codedInputByteBufferNano.pushLimit(readRawVarint325);
                    int i14 = readRawVarint325 / 8;
                    double[] dArr11 = this.lastGyroscopeSample;
                    int length10 = dArr11 == null ? 0 : dArr11.length;
                    int i15 = i14 + length10;
                    double[] dArr12 = new double[i15];
                    if (length10 != 0) {
                        System.arraycopy(dArr11, 0, dArr12, 0, length10);
                    }
                    while (length10 < i15) {
                        dArr12[length10] = codedInputByteBufferNano.readDouble();
                        length10++;
                    }
                    this.lastGyroscopeSample = dArr12;
                    codedInputByteBufferNano.popLimit(pushLimit5);
                } else if (readTag == 65) {
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 65);
                    double[] dArr13 = this.magnetometerBias;
                    int length11 = dArr13 == null ? 0 : dArr13.length;
                    int i16 = repeatedFieldArrayLength6 + length11;
                    double[] dArr14 = new double[i16];
                    if (length11 != 0) {
                        System.arraycopy(dArr13, 0, dArr14, 0, length11);
                    }
                    while (length11 < i16 - 1) {
                        dArr14[length11] = codedInputByteBufferNano.readDouble();
                        codedInputByteBufferNano.readTag();
                        length11++;
                    }
                    dArr14[length11] = codedInputByteBufferNano.readDouble();
                    this.magnetometerBias = dArr14;
                } else if (readTag != 66) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    int readRawVarint326 = codedInputByteBufferNano.readRawVarint32();
                    int pushLimit6 = codedInputByteBufferNano.pushLimit(readRawVarint326);
                    int i17 = readRawVarint326 / 8;
                    double[] dArr15 = this.magnetometerBias;
                    int length12 = dArr15 == null ? 0 : dArr15.length;
                    int i18 = i17 + length12;
                    double[] dArr16 = new double[i18];
                    if (length12 != 0) {
                        System.arraycopy(dArr15, 0, dArr16, 0, length12);
                    }
                    while (length12 < i18) {
                        dArr16[length12] = codedInputByteBufferNano.readDouble();
                        length12++;
                    }
                    this.magnetometerBias = dArr16;
                    codedInputByteBufferNano.popLimit(pushLimit6);
                }
            }
        }

        /* renamed from: clone  reason: collision with other method in class */
        public final TrackerState m572clone() {
            try {
                TrackerState trackerState = (TrackerState) super.clone();
                double[] dArr = this.q;
                if (dArr != null && dArr.length > 0) {
                    trackerState.q = (double[]) dArr.clone();
                }
                double[] dArr2 = this.gyroscopeBias;
                if (dArr2 != null && dArr2.length > 0) {
                    trackerState.gyroscopeBias = (double[]) dArr2.clone();
                }
                float[] fArr = this.lensOffset;
                if (fArr != null && fArr.length > 0) {
                    trackerState.lensOffset = (float[]) fArr.clone();
                }
                double[] dArr3 = this.lastGyroscopeSample;
                if (dArr3 != null && dArr3.length > 0) {
                    trackerState.lastGyroscopeSample = (double[]) dArr3.clone();
                }
                double[] dArr4 = this.magnetometerBias;
                if (dArr4 != null && dArr4.length > 0) {
                    trackerState.magnetometerBias = (double[]) dArr4.clone();
                }
                float[] fArr2 = this.rightLensOffset;
                if (fArr2 != null && fArr2.length > 0) {
                    trackerState.rightLensOffset = (float[]) fArr2.clone();
                }
                return trackerState;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    private Session() {
    }
}
