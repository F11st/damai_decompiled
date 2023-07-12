package com.google.vr.sdk.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class CardboardDevice {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class CardboardInternalParams extends ExtendableMessageNano<CardboardInternalParams> implements Cloneable {
        private static volatile CardboardInternalParams[] _emptyArray;
        private String accelerometer_;
        private int bitField0_;
        public int[] eyeOrientations;
        private String gyroscope_;
        private float screenCenterToLensDistance_;
        private float xPpiOverride_;
        private float yPpiOverride_;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public interface OrientationType {
            public static final int CCW_0_DEGREES = 0;
            public static final int CCW_0_DEGREES_MIRRORED = 4;
            public static final int CCW_180_DEGREES = 2;
            public static final int CCW_180_DEGREES_MIRRORED = 6;
            public static final int CCW_270_DEGREES = 3;
            public static final int CCW_270_DEGREES_MIRRORED = 7;
            public static final int CCW_90_DEGREES = 1;
            public static final int CCW_90_DEGREES_MIRRORED = 5;
        }

        public CardboardInternalParams() {
            clear();
        }

        public static CardboardInternalParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CardboardInternalParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static CardboardInternalParams parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new CardboardInternalParams(), bArr);
        }

        public final CardboardInternalParams clear() {
            this.bitField0_ = 0;
            this.eyeOrientations = WireFormatNano.EMPTY_INT_ARRAY;
            this.screenCenterToLensDistance_ = 0.0f;
            this.xPpiOverride_ = 0.0f;
            this.yPpiOverride_ = 0.0f;
            this.accelerometer_ = "";
            this.gyroscope_ = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final CardboardInternalParams clearAccelerometer() {
            this.accelerometer_ = "";
            this.bitField0_ &= -9;
            return this;
        }

        public final CardboardInternalParams clearGyroscope() {
            this.gyroscope_ = "";
            this.bitField0_ &= -17;
            return this;
        }

        public final CardboardInternalParams clearScreenCenterToLensDistance() {
            this.screenCenterToLensDistance_ = 0.0f;
            this.bitField0_ &= -2;
            return this;
        }

        public final CardboardInternalParams clearXPpiOverride() {
            this.xPpiOverride_ = 0.0f;
            this.bitField0_ &= -3;
            return this;
        }

        public final CardboardInternalParams clearYPpiOverride() {
            this.yPpiOverride_ = 0.0f;
            this.bitField0_ &= -5;
            return this;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            int[] iArr = this.eyeOrientations;
            if (iArr != null && iArr.length > 0) {
                int i = 0;
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.eyeOrientations;
                    if (i >= iArr2.length) {
                        break;
                    }
                    i2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i]);
                    i++;
                }
                computeSerializedSize = computeSerializedSize + i2 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(i2);
            }
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.screenCenterToLensDistance_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.xPpiOverride_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.yPpiOverride_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.accelerometer_);
            }
            return (this.bitField0_ & 16) != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.gyroscope_) : computeSerializedSize;
        }

        public final String getAccelerometer() {
            return this.accelerometer_;
        }

        public final String getGyroscope() {
            return this.gyroscope_;
        }

        public final float getScreenCenterToLensDistance() {
            return this.screenCenterToLensDistance_;
        }

        public final float getXPpiOverride() {
            return this.xPpiOverride_;
        }

        public final float getYPpiOverride() {
            return this.yPpiOverride_;
        }

        public final boolean hasAccelerometer() {
            return (this.bitField0_ & 8) != 0;
        }

        public final boolean hasGyroscope() {
            return (this.bitField0_ & 16) != 0;
        }

        public final boolean hasScreenCenterToLensDistance() {
            return (this.bitField0_ & 1) != 0;
        }

        public final boolean hasXPpiOverride() {
            return (this.bitField0_ & 2) != 0;
        }

        public final boolean hasYPpiOverride() {
            return (this.bitField0_ & 4) != 0;
        }

        public final CardboardInternalParams setAccelerometer(String str) {
            Objects.requireNonNull(str);
            this.bitField0_ |= 8;
            this.accelerometer_ = str;
            return this;
        }

        public final CardboardInternalParams setGyroscope(String str) {
            Objects.requireNonNull(str);
            this.bitField0_ |= 16;
            this.gyroscope_ = str;
            return this;
        }

        public final CardboardInternalParams setScreenCenterToLensDistance(float f) {
            this.bitField0_ |= 1;
            this.screenCenterToLensDistance_ = f;
            return this;
        }

        public final CardboardInternalParams setXPpiOverride(float f) {
            this.bitField0_ |= 2;
            this.xPpiOverride_ = f;
            return this;
        }

        public final CardboardInternalParams setYPpiOverride(float f) {
            this.bitField0_ |= 4;
            this.yPpiOverride_ = f;
            return this;
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            int[] iArr = this.eyeOrientations;
            if (iArr != null && iArr.length > 0) {
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int[] iArr2 = this.eyeOrientations;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    i3 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i2]);
                    i2++;
                }
                codedOutputByteBufferNano.writeRawVarint32(10);
                codedOutputByteBufferNano.writeRawVarint32(i3);
                while (true) {
                    int[] iArr3 = this.eyeOrientations;
                    if (i >= iArr3.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeRawVarint32(iArr3[i]);
                    i++;
                }
            }
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeFloat(2, this.screenCenterToLensDistance_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeFloat(3, this.xPpiOverride_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeFloat(4, this.yPpiOverride_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputByteBufferNano.writeString(5, this.accelerometer_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputByteBufferNano.writeString(6, this.gyroscope_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static CardboardInternalParams parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new CardboardInternalParams().mergeFrom(codedInputByteBufferNano);
        }

        public final CardboardInternalParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                    int[] iArr = new int[repeatedFieldArrayLength];
                    int i = 0;
                    for (int i2 = 0; i2 < repeatedFieldArrayLength; i2++) {
                        if (i2 != 0) {
                            codedInputByteBufferNano.readTag();
                        }
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        switch (readInt32) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                iArr[i] = readInt32;
                                i++;
                                break;
                            default:
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                        }
                    }
                    if (i != 0) {
                        int[] iArr2 = this.eyeOrientations;
                        int length = iArr2 == null ? 0 : iArr2.length;
                        if (length == 0 && i == repeatedFieldArrayLength) {
                            this.eyeOrientations = iArr;
                        } else {
                            int[] iArr3 = new int[length + i];
                            if (length != 0) {
                                System.arraycopy(iArr2, 0, iArr3, 0, length);
                            }
                            System.arraycopy(iArr, 0, iArr3, length, i);
                            this.eyeOrientations = iArr3;
                        }
                    }
                } else if (readTag == 10) {
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position2 = codedInputByteBufferNano.getPosition();
                    int i3 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        switch (codedInputByteBufferNano.readInt32()) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                i3++;
                                break;
                        }
                    }
                    if (i3 != 0) {
                        codedInputByteBufferNano.rewindToPosition(position2);
                        int[] iArr4 = this.eyeOrientations;
                        int length2 = iArr4 == null ? 0 : iArr4.length;
                        int[] iArr5 = new int[i3 + length2];
                        if (length2 != 0) {
                            System.arraycopy(iArr4, 0, iArr5, 0, length2);
                        }
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            int position3 = codedInputByteBufferNano.getPosition();
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            switch (readInt322) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    iArr5[length2] = readInt322;
                                    length2++;
                                    break;
                                default:
                                    codedInputByteBufferNano.rewindToPosition(position3);
                                    storeUnknownField(codedInputByteBufferNano, 8);
                                    break;
                            }
                        }
                        this.eyeOrientations = iArr5;
                    }
                    codedInputByteBufferNano.popLimit(pushLimit);
                } else if (readTag == 21) {
                    this.screenCenterToLensDistance_ = codedInputByteBufferNano.readFloat();
                    this.bitField0_ |= 1;
                } else if (readTag == 29) {
                    this.xPpiOverride_ = codedInputByteBufferNano.readFloat();
                    this.bitField0_ |= 2;
                } else if (readTag == 37) {
                    this.yPpiOverride_ = codedInputByteBufferNano.readFloat();
                    this.bitField0_ |= 4;
                } else if (readTag == 42) {
                    this.accelerometer_ = codedInputByteBufferNano.readString();
                    this.bitField0_ |= 8;
                } else if (readTag != 50) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.gyroscope_ = codedInputByteBufferNano.readString();
                    this.bitField0_ |= 16;
                }
            }
        }

        /* renamed from: clone  reason: collision with other method in class */
        public final CardboardInternalParams m532clone() {
            try {
                CardboardInternalParams cardboardInternalParams = (CardboardInternalParams) super.clone();
                int[] iArr = this.eyeOrientations;
                if (iArr != null && iArr.length > 0) {
                    cardboardInternalParams.eyeOrientations = (int[]) iArr.clone();
                }
                return cardboardInternalParams;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class DaydreamInternalParams extends ExtendableMessageNano<DaydreamInternalParams> implements Cloneable {
        private static volatile DaydreamInternalParams[] _emptyArray;
        public ScreenAlignmentMarker[] alignmentMarkers;
        private int bitField0_;
        private int version_;

        public DaydreamInternalParams() {
            clear();
        }

        public static DaydreamInternalParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DaydreamInternalParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static DaydreamInternalParams parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new DaydreamInternalParams(), bArr);
        }

        public final DaydreamInternalParams clear() {
            this.bitField0_ = 0;
            this.version_ = 0;
            this.alignmentMarkers = ScreenAlignmentMarker.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final DaydreamInternalParams clearVersion() {
            this.version_ = 0;
            this.bitField0_ &= -2;
            return this;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.version_);
            }
            ScreenAlignmentMarker[] screenAlignmentMarkerArr = this.alignmentMarkers;
            if (screenAlignmentMarkerArr != null && screenAlignmentMarkerArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.alignmentMarkers;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, messageNano);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        public final int getVersion() {
            return this.version_;
        }

        public final boolean hasVersion() {
            return (this.bitField0_ & 1) != 0;
        }

        public final DaydreamInternalParams setVersion(int i) {
            this.bitField0_ |= 1;
            this.version_ = i;
            return this;
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt32(1, this.version_);
            }
            ScreenAlignmentMarker[] screenAlignmentMarkerArr = this.alignmentMarkers;
            if (screenAlignmentMarkerArr != null && screenAlignmentMarkerArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.alignmentMarkers;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(2, messageNano);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static DaydreamInternalParams parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new DaydreamInternalParams().mergeFrom(codedInputByteBufferNano);
        }

        public final DaydreamInternalParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.version_ = codedInputByteBufferNano.readInt32();
                    this.bitField0_ |= 1;
                } else if (readTag != 18) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    ScreenAlignmentMarker[] screenAlignmentMarkerArr = this.alignmentMarkers;
                    int length = screenAlignmentMarkerArr == null ? 0 : screenAlignmentMarkerArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new ScreenAlignmentMarker[i];
                    if (length != 0) {
                        System.arraycopy(screenAlignmentMarkerArr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new ScreenAlignmentMarker();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new ScreenAlignmentMarker();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.alignmentMarkers = messageNanoArr;
                }
            }
        }

        /* renamed from: clone  reason: collision with other method in class */
        public final DaydreamInternalParams m536clone() {
            try {
                DaydreamInternalParams daydreamInternalParams = (DaydreamInternalParams) super.clone();
                ScreenAlignmentMarker[] screenAlignmentMarkerArr = this.alignmentMarkers;
                if (screenAlignmentMarkerArr != null && screenAlignmentMarkerArr.length > 0) {
                    daydreamInternalParams.alignmentMarkers = new ScreenAlignmentMarker[screenAlignmentMarkerArr.length];
                    int i = 0;
                    while (true) {
                        ScreenAlignmentMarker[] screenAlignmentMarkerArr2 = this.alignmentMarkers;
                        if (i >= screenAlignmentMarkerArr2.length) {
                            break;
                        }
                        if (screenAlignmentMarkerArr2[i] != null) {
                            daydreamInternalParams.alignmentMarkers[i] = screenAlignmentMarkerArr2[i].m544clone();
                        }
                        i++;
                    }
                }
                return daydreamInternalParams;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class DeviceParams extends ExtendableMessageNano<DeviceParams> implements Cloneable {
        private static volatile DeviceParams[] _emptyArray;
        private int bitField0_;
        public float[] blueDistortionCoefficients;
        public DaydreamInternalParams daydreamInternal;
        public float[] distortionCoefficients;
        public float[] greenDistortionCoefficients;
        private boolean hasMagnet_;
        private float interLensDistance_;
        public CardboardInternalParams internal;
        public float[] leftEyeFieldOfViewAngles;
        private String model_;
        private int primaryButton_;
        private float screenToLensDistance_;
        private float trayToLensDistance_;
        private String vendor_;
        private int verticalAlignment_;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public interface ButtonType {
            public static final int INDIRECT_TOUCH = 3;
            public static final int MAGNET = 1;
            public static final int NONE = 0;
            public static final int TOUCH = 2;
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public interface VerticalAlignmentType {
            public static final int BOTTOM = 0;
            public static final int CENTER = 1;
            public static final int TOP = 2;
        }

        public DeviceParams() {
            clear();
        }

        public static DeviceParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DeviceParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static DeviceParams parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new DeviceParams(), bArr);
        }

        public final DeviceParams clear() {
            this.bitField0_ = 0;
            this.vendor_ = "";
            this.model_ = "";
            this.screenToLensDistance_ = 0.0f;
            this.interLensDistance_ = 0.0f;
            this.leftEyeFieldOfViewAngles = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.verticalAlignment_ = 0;
            this.trayToLensDistance_ = 0.0f;
            this.distortionCoefficients = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.greenDistortionCoefficients = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.blueDistortionCoefficients = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.hasMagnet_ = false;
            this.primaryButton_ = 1;
            this.internal = null;
            this.daydreamInternal = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final DeviceParams clearHasMagnet() {
            this.hasMagnet_ = false;
            this.bitField0_ &= -65;
            return this;
        }

        public final DeviceParams clearInterLensDistance() {
            this.interLensDistance_ = 0.0f;
            this.bitField0_ &= -9;
            return this;
        }

        public final DeviceParams clearModel() {
            this.model_ = "";
            this.bitField0_ &= -3;
            return this;
        }

        public final DeviceParams clearPrimaryButton() {
            this.bitField0_ &= -129;
            this.primaryButton_ = 1;
            return this;
        }

        public final DeviceParams clearScreenToLensDistance() {
            this.screenToLensDistance_ = 0.0f;
            this.bitField0_ &= -5;
            return this;
        }

        public final DeviceParams clearTrayToLensDistance() {
            this.trayToLensDistance_ = 0.0f;
            this.bitField0_ &= -33;
            return this;
        }

        public final DeviceParams clearVendor() {
            this.vendor_ = "";
            this.bitField0_ &= -2;
            return this;
        }

        public final DeviceParams clearVerticalAlignment() {
            this.bitField0_ &= -17;
            this.verticalAlignment_ = 0;
            return this;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.vendor_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.model_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.screenToLensDistance_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.interLensDistance_);
            }
            float[] fArr = this.leftEyeFieldOfViewAngles;
            if (fArr != null && fArr.length > 0) {
                int length = fArr.length * 4;
                computeSerializedSize = computeSerializedSize + length + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length);
            }
            if ((this.bitField0_ & 32) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(6, this.trayToLensDistance_);
            }
            float[] fArr2 = this.distortionCoefficients;
            if (fArr2 != null && fArr2.length > 0) {
                int length2 = fArr2.length * 4;
                computeSerializedSize = computeSerializedSize + length2 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length2);
            }
            float[] fArr3 = this.greenDistortionCoefficients;
            if (fArr3 != null && fArr3.length > 0) {
                int length3 = fArr3.length * 4;
                computeSerializedSize = computeSerializedSize + length3 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length3);
            }
            float[] fArr4 = this.blueDistortionCoefficients;
            if (fArr4 != null && fArr4.length > 0) {
                int length4 = fArr4.length * 4;
                computeSerializedSize = computeSerializedSize + length4 + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(length4);
            }
            if ((this.bitField0_ & 64) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, this.hasMagnet_);
            }
            if ((this.bitField0_ & 16) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, this.verticalAlignment_);
            }
            if ((this.bitField0_ & 128) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, this.primaryButton_);
            }
            CardboardInternalParams cardboardInternalParams = this.internal;
            if (cardboardInternalParams != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1729, cardboardInternalParams);
            }
            DaydreamInternalParams daydreamInternalParams = this.daydreamInternal;
            return daydreamInternalParams != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(196883, daydreamInternalParams) : computeSerializedSize;
        }

        public final boolean getHasMagnet() {
            return this.hasMagnet_;
        }

        public final float getInterLensDistance() {
            return this.interLensDistance_;
        }

        public final String getModel() {
            return this.model_;
        }

        public final int getPrimaryButton() {
            return this.primaryButton_;
        }

        public final float getScreenToLensDistance() {
            return this.screenToLensDistance_;
        }

        public final float getTrayToLensDistance() {
            return this.trayToLensDistance_;
        }

        public final String getVendor() {
            return this.vendor_;
        }

        public final int getVerticalAlignment() {
            return this.verticalAlignment_;
        }

        public final boolean hasHasMagnet() {
            return (this.bitField0_ & 64) != 0;
        }

        public final boolean hasInterLensDistance() {
            return (this.bitField0_ & 8) != 0;
        }

        public final boolean hasModel() {
            return (this.bitField0_ & 2) != 0;
        }

        public final boolean hasPrimaryButton() {
            return (this.bitField0_ & 128) != 0;
        }

        public final boolean hasScreenToLensDistance() {
            return (this.bitField0_ & 4) != 0;
        }

        public final boolean hasTrayToLensDistance() {
            return (this.bitField0_ & 32) != 0;
        }

        public final boolean hasVendor() {
            return (this.bitField0_ & 1) != 0;
        }

        public final boolean hasVerticalAlignment() {
            return (this.bitField0_ & 16) != 0;
        }

        public final DeviceParams setHasMagnet(boolean z) {
            this.bitField0_ |= 64;
            this.hasMagnet_ = z;
            return this;
        }

        public final DeviceParams setInterLensDistance(float f) {
            this.bitField0_ |= 8;
            this.interLensDistance_ = f;
            return this;
        }

        public final DeviceParams setModel(String str) {
            Objects.requireNonNull(str);
            this.bitField0_ |= 2;
            this.model_ = str;
            return this;
        }

        public final DeviceParams setPrimaryButton(int i) {
            this.primaryButton_ = i;
            this.bitField0_ |= 128;
            return this;
        }

        public final DeviceParams setScreenToLensDistance(float f) {
            this.bitField0_ |= 4;
            this.screenToLensDistance_ = f;
            return this;
        }

        public final DeviceParams setTrayToLensDistance(float f) {
            this.bitField0_ |= 32;
            this.trayToLensDistance_ = f;
            return this;
        }

        public final DeviceParams setVendor(String str) {
            Objects.requireNonNull(str);
            this.bitField0_ |= 1;
            this.vendor_ = str;
            return this;
        }

        public final DeviceParams setVerticalAlignment(int i) {
            this.verticalAlignment_ = i;
            this.bitField0_ |= 16;
            return this;
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeString(1, this.vendor_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeString(2, this.model_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeFloat(3, this.screenToLensDistance_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputByteBufferNano.writeFloat(4, this.interLensDistance_);
            }
            float[] fArr = this.leftEyeFieldOfViewAngles;
            int i = 0;
            if (fArr != null && fArr.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(42);
                codedOutputByteBufferNano.writeRawVarint32(fArr.length * 4);
                int i2 = 0;
                while (true) {
                    float[] fArr2 = this.leftEyeFieldOfViewAngles;
                    if (i2 >= fArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloatNoTag(fArr2[i2]);
                    i2++;
                }
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputByteBufferNano.writeFloat(6, this.trayToLensDistance_);
            }
            float[] fArr3 = this.distortionCoefficients;
            if (fArr3 != null && fArr3.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(58);
                codedOutputByteBufferNano.writeRawVarint32(fArr3.length * 4);
                int i3 = 0;
                while (true) {
                    float[] fArr4 = this.distortionCoefficients;
                    if (i3 >= fArr4.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloatNoTag(fArr4[i3]);
                    i3++;
                }
            }
            float[] fArr5 = this.greenDistortionCoefficients;
            if (fArr5 != null && fArr5.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(66);
                codedOutputByteBufferNano.writeRawVarint32(fArr5.length * 4);
                int i4 = 0;
                while (true) {
                    float[] fArr6 = this.greenDistortionCoefficients;
                    if (i4 >= fArr6.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloatNoTag(fArr6[i4]);
                    i4++;
                }
            }
            float[] fArr7 = this.blueDistortionCoefficients;
            if (fArr7 != null && fArr7.length > 0) {
                codedOutputByteBufferNano.writeRawVarint32(74);
                codedOutputByteBufferNano.writeRawVarint32(fArr7.length * 4);
                while (true) {
                    float[] fArr8 = this.blueDistortionCoefficients;
                    if (i >= fArr8.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloatNoTag(fArr8[i]);
                    i++;
                }
            }
            if ((this.bitField0_ & 64) != 0) {
                codedOutputByteBufferNano.writeBool(10, this.hasMagnet_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputByteBufferNano.writeInt32(11, this.verticalAlignment_);
            }
            if ((this.bitField0_ & 128) != 0) {
                codedOutputByteBufferNano.writeInt32(12, this.primaryButton_);
            }
            CardboardInternalParams cardboardInternalParams = this.internal;
            if (cardboardInternalParams != null) {
                codedOutputByteBufferNano.writeMessage(1729, cardboardInternalParams);
            }
            DaydreamInternalParams daydreamInternalParams = this.daydreamInternal;
            if (daydreamInternalParams != null) {
                codedOutputByteBufferNano.writeMessage(196883, daydreamInternalParams);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static DeviceParams parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new DeviceParams().mergeFrom(codedInputByteBufferNano);
        }

        public final DeviceParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 10:
                        this.vendor_ = codedInputByteBufferNano.readString();
                        this.bitField0_ |= 1;
                        break;
                    case 18:
                        this.model_ = codedInputByteBufferNano.readString();
                        this.bitField0_ |= 2;
                        break;
                    case 29:
                        this.screenToLensDistance_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 4;
                        break;
                    case 37:
                        this.interLensDistance_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 8;
                        break;
                    case 42:
                        int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                        int i = readRawVarint32 / 4;
                        float[] fArr = this.leftEyeFieldOfViewAngles;
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
                        this.leftEyeFieldOfViewAngles = fArr2;
                        codedInputByteBufferNano.popLimit(pushLimit);
                        break;
                    case 45:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 45);
                        float[] fArr3 = this.leftEyeFieldOfViewAngles;
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
                        this.leftEyeFieldOfViewAngles = fArr4;
                        break;
                    case 53:
                        this.trayToLensDistance_ = codedInputByteBufferNano.readFloat();
                        this.bitField0_ |= 32;
                        break;
                    case 58:
                        int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                        int i4 = readRawVarint322 / 4;
                        float[] fArr5 = this.distortionCoefficients;
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
                        this.distortionCoefficients = fArr6;
                        codedInputByteBufferNano.popLimit(pushLimit2);
                        break;
                    case 61:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 61);
                        float[] fArr7 = this.distortionCoefficients;
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
                        this.distortionCoefficients = fArr8;
                        break;
                    case 66:
                        int readRawVarint323 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit3 = codedInputByteBufferNano.pushLimit(readRawVarint323);
                        int i7 = readRawVarint323 / 4;
                        float[] fArr9 = this.greenDistortionCoefficients;
                        int length5 = fArr9 == null ? 0 : fArr9.length;
                        int i8 = i7 + length5;
                        float[] fArr10 = new float[i8];
                        if (length5 != 0) {
                            System.arraycopy(fArr9, 0, fArr10, 0, length5);
                        }
                        while (length5 < i8) {
                            fArr10[length5] = codedInputByteBufferNano.readFloat();
                            length5++;
                        }
                        this.greenDistortionCoefficients = fArr10;
                        codedInputByteBufferNano.popLimit(pushLimit3);
                        break;
                    case 69:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 69);
                        float[] fArr11 = this.greenDistortionCoefficients;
                        int length6 = fArr11 == null ? 0 : fArr11.length;
                        int i9 = repeatedFieldArrayLength3 + length6;
                        float[] fArr12 = new float[i9];
                        if (length6 != 0) {
                            System.arraycopy(fArr11, 0, fArr12, 0, length6);
                        }
                        while (length6 < i9 - 1) {
                            fArr12[length6] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length6++;
                        }
                        fArr12[length6] = codedInputByteBufferNano.readFloat();
                        this.greenDistortionCoefficients = fArr12;
                        break;
                    case 74:
                        int readRawVarint324 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit4 = codedInputByteBufferNano.pushLimit(readRawVarint324);
                        int i10 = readRawVarint324 / 4;
                        float[] fArr13 = this.blueDistortionCoefficients;
                        int length7 = fArr13 == null ? 0 : fArr13.length;
                        int i11 = i10 + length7;
                        float[] fArr14 = new float[i11];
                        if (length7 != 0) {
                            System.arraycopy(fArr13, 0, fArr14, 0, length7);
                        }
                        while (length7 < i11) {
                            fArr14[length7] = codedInputByteBufferNano.readFloat();
                            length7++;
                        }
                        this.blueDistortionCoefficients = fArr14;
                        codedInputByteBufferNano.popLimit(pushLimit4);
                        break;
                    case 77:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 77);
                        float[] fArr15 = this.blueDistortionCoefficients;
                        int length8 = fArr15 == null ? 0 : fArr15.length;
                        int i12 = repeatedFieldArrayLength4 + length8;
                        float[] fArr16 = new float[i12];
                        if (length8 != 0) {
                            System.arraycopy(fArr15, 0, fArr16, 0, length8);
                        }
                        while (length8 < i12 - 1) {
                            fArr16[length8] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length8++;
                        }
                        fArr16[length8] = codedInputByteBufferNano.readFloat();
                        this.blueDistortionCoefficients = fArr16;
                        break;
                    case 80:
                        this.hasMagnet_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 64;
                        break;
                    case 88:
                        this.bitField0_ |= 16;
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            break;
                        } else {
                            this.verticalAlignment_ = readInt32;
                            this.bitField0_ |= 16;
                            break;
                        }
                    case 96:
                        this.bitField0_ |= 128;
                        int position2 = codedInputByteBufferNano.getPosition();
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3) {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            break;
                        } else {
                            this.primaryButton_ = readInt322;
                            this.bitField0_ |= 128;
                            break;
                        }
                    case 13834:
                        if (this.internal == null) {
                            this.internal = new CardboardInternalParams();
                        }
                        codedInputByteBufferNano.readMessage(this.internal);
                        break;
                    case 1575066:
                        if (this.daydreamInternal == null) {
                            this.daydreamInternal = new DaydreamInternalParams();
                        }
                        codedInputByteBufferNano.readMessage(this.daydreamInternal);
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

        /* renamed from: clone  reason: collision with other method in class */
        public final DeviceParams m540clone() {
            try {
                DeviceParams deviceParams = (DeviceParams) super.clone();
                float[] fArr = this.leftEyeFieldOfViewAngles;
                if (fArr != null && fArr.length > 0) {
                    deviceParams.leftEyeFieldOfViewAngles = (float[]) fArr.clone();
                }
                float[] fArr2 = this.distortionCoefficients;
                if (fArr2 != null && fArr2.length > 0) {
                    deviceParams.distortionCoefficients = (float[]) fArr2.clone();
                }
                float[] fArr3 = this.greenDistortionCoefficients;
                if (fArr3 != null && fArr3.length > 0) {
                    deviceParams.greenDistortionCoefficients = (float[]) fArr3.clone();
                }
                float[] fArr4 = this.blueDistortionCoefficients;
                if (fArr4 != null && fArr4.length > 0) {
                    deviceParams.blueDistortionCoefficients = (float[]) fArr4.clone();
                }
                CardboardInternalParams cardboardInternalParams = this.internal;
                if (cardboardInternalParams != null) {
                    deviceParams.internal = cardboardInternalParams.m532clone();
                }
                DaydreamInternalParams daydreamInternalParams = this.daydreamInternal;
                if (daydreamInternalParams != null) {
                    deviceParams.daydreamInternal = daydreamInternalParams.m536clone();
                }
                return deviceParams;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class ScreenAlignmentMarker extends ExtendableMessageNano<ScreenAlignmentMarker> implements Cloneable {
        private static volatile ScreenAlignmentMarker[] _emptyArray;
        private int bitField0_;
        private float horizontal_;
        private float vertical_;

        public ScreenAlignmentMarker() {
            clear();
        }

        public static ScreenAlignmentMarker[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ScreenAlignmentMarker[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static ScreenAlignmentMarker parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new ScreenAlignmentMarker(), bArr);
        }

        public final ScreenAlignmentMarker clear() {
            this.bitField0_ = 0;
            this.horizontal_ = 0.0f;
            this.vertical_ = 0.0f;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final ScreenAlignmentMarker clearHorizontal() {
            this.horizontal_ = 0.0f;
            this.bitField0_ &= -2;
            return this;
        }

        public final ScreenAlignmentMarker clearVertical() {
            this.vertical_ = 0.0f;
            this.bitField0_ &= -3;
            return this;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.horizontal_);
            }
            return (this.bitField0_ & 2) != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(2, this.vertical_) : computeSerializedSize;
        }

        public final float getHorizontal() {
            return this.horizontal_;
        }

        public final float getVertical() {
            return this.vertical_;
        }

        public final boolean hasHorizontal() {
            return (this.bitField0_ & 1) != 0;
        }

        public final boolean hasVertical() {
            return (this.bitField0_ & 2) != 0;
        }

        public final ScreenAlignmentMarker setHorizontal(float f) {
            this.bitField0_ |= 1;
            this.horizontal_ = f;
            return this;
        }

        public final ScreenAlignmentMarker setVertical(float f) {
            this.bitField0_ |= 2;
            this.vertical_ = f;
            return this;
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeFloat(1, this.horizontal_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeFloat(2, this.vertical_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static ScreenAlignmentMarker parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new ScreenAlignmentMarker().mergeFrom(codedInputByteBufferNano);
        }

        public final ScreenAlignmentMarker mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 13) {
                    this.horizontal_ = codedInputByteBufferNano.readFloat();
                    this.bitField0_ |= 1;
                } else if (readTag != 21) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.vertical_ = codedInputByteBufferNano.readFloat();
                    this.bitField0_ |= 2;
                }
            }
        }

        /* renamed from: clone  reason: collision with other method in class */
        public final ScreenAlignmentMarker m544clone() {
            try {
                return (ScreenAlignmentMarker) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    private CardboardDevice() {
    }
}
