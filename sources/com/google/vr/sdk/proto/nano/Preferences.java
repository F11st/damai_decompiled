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
public class Preferences {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class DeveloperPrefs extends ExtendableMessageNano<DeveloperPrefs> implements Cloneable {
        private static volatile DeveloperPrefs[] _emptyArray;
        private int bitField0_;
        private boolean captureEnabled_;
        private boolean developerLoggingEnabled_;
        private boolean forceUndistortedRendering_;
        private boolean gvrPlatformLibraryEnabled_;
        private boolean headTrackingServiceEnabled_;
        private boolean motophoPatchEnabled_;
        private boolean performanceHudEnabled_;
        private boolean performanceMonitoringEnabled_;
        public SafetyCylinderParams safetyCylinderParams;
        private boolean sensorLoggingEnabled_;

        public DeveloperPrefs() {
            clear();
        }

        public static DeveloperPrefs[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DeveloperPrefs[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static DeveloperPrefs parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new DeveloperPrefs(), bArr);
        }

        public final DeveloperPrefs clear() {
            this.bitField0_ = 0;
            this.performanceMonitoringEnabled_ = false;
            this.sensorLoggingEnabled_ = false;
            this.motophoPatchEnabled_ = false;
            this.developerLoggingEnabled_ = false;
            this.forceUndistortedRendering_ = false;
            this.performanceHudEnabled_ = false;
            this.gvrPlatformLibraryEnabled_ = false;
            this.headTrackingServiceEnabled_ = false;
            this.captureEnabled_ = false;
            this.safetyCylinderParams = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final DeveloperPrefs clearCaptureEnabled() {
            this.captureEnabled_ = false;
            this.bitField0_ &= -257;
            return this;
        }

        public final DeveloperPrefs clearDeveloperLoggingEnabled() {
            this.developerLoggingEnabled_ = false;
            this.bitField0_ &= -9;
            return this;
        }

        public final DeveloperPrefs clearForceUndistortedRendering() {
            this.forceUndistortedRendering_ = false;
            this.bitField0_ &= -17;
            return this;
        }

        public final DeveloperPrefs clearGvrPlatformLibraryEnabled() {
            this.gvrPlatformLibraryEnabled_ = false;
            this.bitField0_ &= -65;
            return this;
        }

        public final DeveloperPrefs clearHeadTrackingServiceEnabled() {
            this.headTrackingServiceEnabled_ = false;
            this.bitField0_ &= -129;
            return this;
        }

        public final DeveloperPrefs clearMotophoPatchEnabled() {
            this.motophoPatchEnabled_ = false;
            this.bitField0_ &= -5;
            return this;
        }

        public final DeveloperPrefs clearPerformanceHudEnabled() {
            this.performanceHudEnabled_ = false;
            this.bitField0_ &= -33;
            return this;
        }

        public final DeveloperPrefs clearPerformanceMonitoringEnabled() {
            this.performanceMonitoringEnabled_ = false;
            this.bitField0_ &= -2;
            return this;
        }

        public final DeveloperPrefs clearSensorLoggingEnabled() {
            this.sensorLoggingEnabled_ = false;
            this.bitField0_ &= -3;
            return this;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, this.performanceMonitoringEnabled_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, this.sensorLoggingEnabled_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, this.motophoPatchEnabled_);
            }
            if ((this.bitField0_ & 8) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, this.developerLoggingEnabled_);
            }
            if ((this.bitField0_ & 16) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, this.forceUndistortedRendering_);
            }
            if ((this.bitField0_ & 32) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, this.performanceHudEnabled_);
            }
            if ((this.bitField0_ & 64) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, this.gvrPlatformLibraryEnabled_);
            }
            if ((this.bitField0_ & 128) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, this.headTrackingServiceEnabled_);
            }
            if ((this.bitField0_ & 256) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, this.captureEnabled_);
            }
            SafetyCylinderParams safetyCylinderParams = this.safetyCylinderParams;
            return safetyCylinderParams != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, safetyCylinderParams) : computeSerializedSize;
        }

        public final boolean getCaptureEnabled() {
            return this.captureEnabled_;
        }

        public final boolean getDeveloperLoggingEnabled() {
            return this.developerLoggingEnabled_;
        }

        public final boolean getForceUndistortedRendering() {
            return this.forceUndistortedRendering_;
        }

        public final boolean getGvrPlatformLibraryEnabled() {
            return this.gvrPlatformLibraryEnabled_;
        }

        public final boolean getHeadTrackingServiceEnabled() {
            return this.headTrackingServiceEnabled_;
        }

        public final boolean getMotophoPatchEnabled() {
            return this.motophoPatchEnabled_;
        }

        public final boolean getPerformanceHudEnabled() {
            return this.performanceHudEnabled_;
        }

        public final boolean getPerformanceMonitoringEnabled() {
            return this.performanceMonitoringEnabled_;
        }

        public final boolean getSensorLoggingEnabled() {
            return this.sensorLoggingEnabled_;
        }

        public final boolean hasCaptureEnabled() {
            return (this.bitField0_ & 256) != 0;
        }

        public final boolean hasDeveloperLoggingEnabled() {
            return (this.bitField0_ & 8) != 0;
        }

        public final boolean hasForceUndistortedRendering() {
            return (this.bitField0_ & 16) != 0;
        }

        public final boolean hasGvrPlatformLibraryEnabled() {
            return (this.bitField0_ & 64) != 0;
        }

        public final boolean hasHeadTrackingServiceEnabled() {
            return (this.bitField0_ & 128) != 0;
        }

        public final boolean hasMotophoPatchEnabled() {
            return (this.bitField0_ & 4) != 0;
        }

        public final boolean hasPerformanceHudEnabled() {
            return (this.bitField0_ & 32) != 0;
        }

        public final boolean hasPerformanceMonitoringEnabled() {
            return (this.bitField0_ & 1) != 0;
        }

        public final boolean hasSensorLoggingEnabled() {
            return (this.bitField0_ & 2) != 0;
        }

        public final DeveloperPrefs setCaptureEnabled(boolean z) {
            this.bitField0_ |= 256;
            this.captureEnabled_ = z;
            return this;
        }

        public final DeveloperPrefs setDeveloperLoggingEnabled(boolean z) {
            this.bitField0_ |= 8;
            this.developerLoggingEnabled_ = z;
            return this;
        }

        public final DeveloperPrefs setForceUndistortedRendering(boolean z) {
            this.bitField0_ |= 16;
            this.forceUndistortedRendering_ = z;
            return this;
        }

        public final DeveloperPrefs setGvrPlatformLibraryEnabled(boolean z) {
            this.bitField0_ |= 64;
            this.gvrPlatformLibraryEnabled_ = z;
            return this;
        }

        public final DeveloperPrefs setHeadTrackingServiceEnabled(boolean z) {
            this.bitField0_ |= 128;
            this.headTrackingServiceEnabled_ = z;
            return this;
        }

        public final DeveloperPrefs setMotophoPatchEnabled(boolean z) {
            this.bitField0_ |= 4;
            this.motophoPatchEnabled_ = z;
            return this;
        }

        public final DeveloperPrefs setPerformanceHudEnabled(boolean z) {
            this.bitField0_ |= 32;
            this.performanceHudEnabled_ = z;
            return this;
        }

        public final DeveloperPrefs setPerformanceMonitoringEnabled(boolean z) {
            this.bitField0_ |= 1;
            this.performanceMonitoringEnabled_ = z;
            return this;
        }

        public final DeveloperPrefs setSensorLoggingEnabled(boolean z) {
            this.bitField0_ |= 2;
            this.sensorLoggingEnabled_ = z;
            return this;
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeBool(1, this.performanceMonitoringEnabled_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeBool(2, this.sensorLoggingEnabled_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeBool(3, this.motophoPatchEnabled_);
            }
            if ((this.bitField0_ & 8) != 0) {
                codedOutputByteBufferNano.writeBool(4, this.developerLoggingEnabled_);
            }
            if ((this.bitField0_ & 16) != 0) {
                codedOutputByteBufferNano.writeBool(5, this.forceUndistortedRendering_);
            }
            if ((this.bitField0_ & 32) != 0) {
                codedOutputByteBufferNano.writeBool(6, this.performanceHudEnabled_);
            }
            if ((this.bitField0_ & 64) != 0) {
                codedOutputByteBufferNano.writeBool(7, this.gvrPlatformLibraryEnabled_);
            }
            if ((this.bitField0_ & 128) != 0) {
                codedOutputByteBufferNano.writeBool(8, this.headTrackingServiceEnabled_);
            }
            if ((this.bitField0_ & 256) != 0) {
                codedOutputByteBufferNano.writeBool(9, this.captureEnabled_);
            }
            SafetyCylinderParams safetyCylinderParams = this.safetyCylinderParams;
            if (safetyCylinderParams != null) {
                codedOutputByteBufferNano.writeMessage(10, safetyCylinderParams);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static DeveloperPrefs parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new DeveloperPrefs().mergeFrom(codedInputByteBufferNano);
        }

        public final DeveloperPrefs mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 8:
                        this.performanceMonitoringEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 1;
                        break;
                    case 16:
                        this.sensorLoggingEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 2;
                        break;
                    case 24:
                        this.motophoPatchEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 4;
                        break;
                    case 32:
                        this.developerLoggingEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 8;
                        break;
                    case 40:
                        this.forceUndistortedRendering_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 16;
                        break;
                    case 48:
                        this.performanceHudEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 32;
                        break;
                    case 56:
                        this.gvrPlatformLibraryEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 64;
                        break;
                    case 64:
                        this.headTrackingServiceEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 128;
                        break;
                    case 72:
                        this.captureEnabled_ = codedInputByteBufferNano.readBool();
                        this.bitField0_ |= 256;
                        break;
                    case 82:
                        if (this.safetyCylinderParams == null) {
                            this.safetyCylinderParams = new SafetyCylinderParams();
                        }
                        codedInputByteBufferNano.readMessage(this.safetyCylinderParams);
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
        public final DeveloperPrefs m552clone() {
            try {
                DeveloperPrefs developerPrefs = (DeveloperPrefs) super.clone();
                SafetyCylinderParams safetyCylinderParams = this.safetyCylinderParams;
                if (safetyCylinderParams != null) {
                    developerPrefs.safetyCylinderParams = safetyCylinderParams.m556clone();
                }
                return developerPrefs;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class SafetyCylinderParams extends ExtendableMessageNano<SafetyCylinderParams> implements Cloneable {
        private static volatile SafetyCylinderParams[] _emptyArray;
        private int bitField0_;
        private float collisionSphereRadius_;
        public float[] innerFogColor;
        private float innerRadius_;
        public float[] outerFogColor;
        private float outerRadius_;

        public SafetyCylinderParams() {
            clear();
        }

        public static SafetyCylinderParams[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SafetyCylinderParams[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static SafetyCylinderParams parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new SafetyCylinderParams(), bArr);
        }

        public final SafetyCylinderParams clear() {
            this.bitField0_ = 0;
            this.collisionSphereRadius_ = 0.0f;
            this.innerRadius_ = 0.0f;
            this.outerRadius_ = 0.0f;
            this.innerFogColor = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.outerFogColor = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final SafetyCylinderParams clearCollisionSphereRadius() {
            this.collisionSphereRadius_ = 0.0f;
            this.bitField0_ &= -2;
            return this;
        }

        public final SafetyCylinderParams clearInnerRadius() {
            this.innerRadius_ = 0.0f;
            this.bitField0_ &= -3;
            return this;
        }

        public final SafetyCylinderParams clearOuterRadius() {
            this.outerRadius_ = 0.0f;
            this.bitField0_ &= -5;
            return this;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.collisionSphereRadius_);
            }
            if ((this.bitField0_ & 2) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.innerRadius_);
            }
            if ((this.bitField0_ & 4) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.outerRadius_);
            }
            float[] fArr = this.innerFogColor;
            if (fArr != null && fArr.length > 0) {
                computeSerializedSize = computeSerializedSize + (fArr.length * 4) + (fArr.length * 1);
            }
            float[] fArr2 = this.outerFogColor;
            return (fArr2 == null || fArr2.length <= 0) ? computeSerializedSize : computeSerializedSize + (fArr2.length * 4) + (fArr2.length * 1);
        }

        public final float getCollisionSphereRadius() {
            return this.collisionSphereRadius_;
        }

        public final float getInnerRadius() {
            return this.innerRadius_;
        }

        public final float getOuterRadius() {
            return this.outerRadius_;
        }

        public final boolean hasCollisionSphereRadius() {
            return (this.bitField0_ & 1) != 0;
        }

        public final boolean hasInnerRadius() {
            return (this.bitField0_ & 2) != 0;
        }

        public final boolean hasOuterRadius() {
            return (this.bitField0_ & 4) != 0;
        }

        public final SafetyCylinderParams setCollisionSphereRadius(float f) {
            this.bitField0_ |= 1;
            this.collisionSphereRadius_ = f;
            return this;
        }

        public final SafetyCylinderParams setInnerRadius(float f) {
            this.bitField0_ |= 2;
            this.innerRadius_ = f;
            return this;
        }

        public final SafetyCylinderParams setOuterRadius(float f) {
            this.bitField0_ |= 4;
            this.outerRadius_ = f;
            return this;
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeFloat(1, this.collisionSphereRadius_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputByteBufferNano.writeFloat(2, this.innerRadius_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputByteBufferNano.writeFloat(3, this.outerRadius_);
            }
            float[] fArr = this.innerFogColor;
            int i = 0;
            if (fArr != null && fArr.length > 0) {
                int i2 = 0;
                while (true) {
                    float[] fArr2 = this.innerFogColor;
                    if (i2 >= fArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloat(4, fArr2[i2]);
                    i2++;
                }
            }
            float[] fArr3 = this.outerFogColor;
            if (fArr3 != null && fArr3.length > 0) {
                while (true) {
                    float[] fArr4 = this.outerFogColor;
                    if (i >= fArr4.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloat(5, fArr4[i]);
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static SafetyCylinderParams parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new SafetyCylinderParams().mergeFrom(codedInputByteBufferNano);
        }

        public final SafetyCylinderParams mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 13) {
                    this.collisionSphereRadius_ = codedInputByteBufferNano.readFloat();
                    this.bitField0_ |= 1;
                } else if (readTag == 21) {
                    this.innerRadius_ = codedInputByteBufferNano.readFloat();
                    this.bitField0_ |= 2;
                } else if (readTag == 29) {
                    this.outerRadius_ = codedInputByteBufferNano.readFloat();
                    this.bitField0_ |= 4;
                } else if (readTag == 34) {
                    int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                    int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                    int i = readRawVarint32 / 4;
                    float[] fArr = this.innerFogColor;
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
                    this.innerFogColor = fArr2;
                    codedInputByteBufferNano.popLimit(pushLimit);
                } else if (readTag == 37) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 37);
                    float[] fArr3 = this.innerFogColor;
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
                    this.innerFogColor = fArr4;
                } else if (readTag == 42) {
                    int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                    int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                    int i4 = readRawVarint322 / 4;
                    float[] fArr5 = this.outerFogColor;
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
                    this.outerFogColor = fArr6;
                    codedInputByteBufferNano.popLimit(pushLimit2);
                } else if (readTag != 45) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 45);
                    float[] fArr7 = this.outerFogColor;
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
                    this.outerFogColor = fArr8;
                }
            }
        }

        /* renamed from: clone  reason: collision with other method in class */
        public final SafetyCylinderParams m556clone() {
            try {
                SafetyCylinderParams safetyCylinderParams = (SafetyCylinderParams) super.clone();
                float[] fArr = this.innerFogColor;
                if (fArr != null && fArr.length > 0) {
                    safetyCylinderParams.innerFogColor = (float[]) fArr.clone();
                }
                float[] fArr2 = this.outerFogColor;
                if (fArr2 != null && fArr2.length > 0) {
                    safetyCylinderParams.outerFogColor = (float[]) fArr2.clone();
                }
                return safetyCylinderParams;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class UserPrefs extends ExtendableMessageNano<UserPrefs> implements Cloneable {
        private static volatile UserPrefs[] _emptyArray;
        private int bitField0_;
        private int controllerHandedness_;
        public DeveloperPrefs developerPrefs;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public interface Handedness {
            public static final int LEFT_HANDED = 1;
            public static final int RIGHT_HANDED = 0;
        }

        public UserPrefs() {
            clear();
        }

        public static UserPrefs[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new UserPrefs[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static UserPrefs parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return MessageNano.mergeFrom(new UserPrefs(), bArr);
        }

        public final UserPrefs clear() {
            this.bitField0_ = 0;
            this.controllerHandedness_ = 0;
            this.developerPrefs = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final UserPrefs clearControllerHandedness() {
            this.bitField0_ &= -2;
            this.controllerHandedness_ = 0;
            return this;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if ((this.bitField0_ & 1) != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, this.controllerHandedness_);
            }
            DeveloperPrefs developerPrefs = this.developerPrefs;
            return developerPrefs != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, developerPrefs) : computeSerializedSize;
        }

        public final int getControllerHandedness() {
            return this.controllerHandedness_;
        }

        public final boolean hasControllerHandedness() {
            return (this.bitField0_ & 1) != 0;
        }

        public final UserPrefs setControllerHandedness(int i) {
            this.controllerHandedness_ = i;
            this.bitField0_ |= 1;
            return this;
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputByteBufferNano.writeInt32(1, this.controllerHandedness_);
            }
            DeveloperPrefs developerPrefs = this.developerPrefs;
            if (developerPrefs != null) {
                codedOutputByteBufferNano.writeMessage(2, developerPrefs);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static UserPrefs parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new UserPrefs().mergeFrom(codedInputByteBufferNano);
        }

        public final UserPrefs mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.bitField0_ |= 1;
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1) {
                        codedInputByteBufferNano.rewindToPosition(position);
                        storeUnknownField(codedInputByteBufferNano, readTag);
                    } else {
                        this.controllerHandedness_ = readInt32;
                        this.bitField0_ |= 1;
                    }
                } else if (readTag != 18) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    if (this.developerPrefs == null) {
                        this.developerPrefs = new DeveloperPrefs();
                    }
                    codedInputByteBufferNano.readMessage(this.developerPrefs);
                }
            }
        }

        /* renamed from: clone  reason: collision with other method in class */
        public final UserPrefs m560clone() {
            try {
                UserPrefs userPrefs = (UserPrefs) super.clone();
                DeveloperPrefs developerPrefs = this.developerPrefs;
                if (developerPrefs != null) {
                    userPrefs.developerPrefs = developerPrefs.m552clone();
                }
                return userPrefs;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    private Preferences() {
    }
}
