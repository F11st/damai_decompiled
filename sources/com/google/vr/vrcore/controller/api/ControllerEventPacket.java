package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayDeque;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes10.dex */
public class ControllerEventPacket implements Parcelable {
    protected static final int MAX_EVENTS = 16;
    private static final int SERIALIZED_FORMAT_VERSION = 1;
    private int accelEventCount;
    private ControllerAccelEvent[] accelEvents;
    private int buttonEventCount;
    private ControllerButtonEvent[] buttonEvents;
    private int gyroEventCount;
    private ControllerGyroEvent[] gyroEvents;
    private int orientationEventCount;
    private ControllerOrientationEvent[] orientationEvents;
    private int touchEventCount;
    private ControllerTouchEvent[] touchEvents;
    private static ArrayDeque<ControllerEventPacket> pool = new ArrayDeque<>();
    private static Object poolLock = new Object();
    public static final Parcelable.Creator<ControllerEventPacket> CREATOR = new C5441a();

    /* compiled from: Taobao */
    /* renamed from: com.google.vr.vrcore.controller.api.ControllerEventPacket$a */
    /* loaded from: classes10.dex */
    class C5441a implements Parcelable.Creator<ControllerEventPacket> {
        C5441a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ControllerEventPacket createFromParcel(Parcel parcel) {
            ControllerEventPacket obtain = ControllerEventPacket.obtain();
            obtain.readFromParcel(parcel);
            return obtain;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ControllerEventPacket[] newArray(int i) {
            return new ControllerEventPacket[i];
        }
    }

    public ControllerEventPacket() {
        this.accelEvents = new ControllerAccelEvent[16];
        this.buttonEvents = new ControllerButtonEvent[16];
        this.gyroEvents = new ControllerGyroEvent[16];
        this.orientationEvents = new ControllerOrientationEvent[16];
        this.touchEvents = new ControllerTouchEvent[16];
        for (int i = 0; i < 16; i++) {
            this.accelEvents[i] = new ControllerAccelEvent();
            this.buttonEvents[i] = new ControllerButtonEvent();
            this.gyroEvents[i] = new ControllerGyroEvent();
            this.orientationEvents[i] = new ControllerOrientationEvent();
            this.touchEvents[i] = new ControllerTouchEvent();
        }
        clear();
    }

    public static ControllerEventPacket obtain() {
        ControllerEventPacket controllerEventPacket;
        synchronized (poolLock) {
            controllerEventPacket = pool.isEmpty() ? new ControllerEventPacket() : pool.remove();
        }
        return controllerEventPacket;
    }

    public ControllerAccelEvent addAccelEvent() {
        int i = this.accelEventCount;
        if (i < 16) {
            ControllerAccelEvent[] controllerAccelEventArr = this.accelEvents;
            this.accelEventCount = i + 1;
            return controllerAccelEventArr[i];
        }
        throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
    }

    public ControllerButtonEvent addButtonEvent() {
        int i = this.buttonEventCount;
        if (i < 16) {
            ControllerButtonEvent[] controllerButtonEventArr = this.buttonEvents;
            this.buttonEventCount = i + 1;
            return controllerButtonEventArr[i];
        }
        throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
    }

    public ControllerGyroEvent addGyroEvent() {
        int i = this.gyroEventCount;
        if (i < 16) {
            ControllerGyroEvent[] controllerGyroEventArr = this.gyroEvents;
            this.gyroEventCount = i + 1;
            return controllerGyroEventArr[i];
        }
        throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
    }

    public ControllerOrientationEvent addOrientationEvent() {
        int i = this.orientationEventCount;
        if (i < 16) {
            ControllerOrientationEvent[] controllerOrientationEventArr = this.orientationEvents;
            this.orientationEventCount = i + 1;
            return controllerOrientationEventArr[i];
        }
        throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
    }

    public ControllerTouchEvent addTouchEvent() {
        int i = this.touchEventCount;
        if (i < 16) {
            ControllerTouchEvent[] controllerTouchEventArr = this.touchEvents;
            this.touchEventCount = i + 1;
            return controllerTouchEventArr[i];
        }
        throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int calculateParcelByteLength() {
        int i = 24;
        for (int i2 = 0; i2 < this.accelEventCount; i2++) {
            i += this.accelEvents[i2].getByteSize();
        }
        for (int i3 = 0; i3 < this.buttonEventCount; i3++) {
            i += this.buttonEvents[i3].getByteSize();
        }
        for (int i4 = 0; i4 < this.gyroEventCount; i4++) {
            i += this.gyroEvents[i4].getByteSize();
        }
        for (int i5 = 0; i5 < this.orientationEventCount; i5++) {
            i += this.orientationEvents[i5].getByteSize();
        }
        for (int i6 = 0; i6 < this.touchEventCount; i6++) {
            i += this.touchEvents[i6].getByteSize();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkIsValidEventCount(int i) {
        if (i < 0 || i >= 16) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Invalid event count: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void clear() {
        this.accelEventCount = 0;
        this.buttonEventCount = 0;
        this.gyroEventCount = 0;
        this.orientationEventCount = 0;
        this.touchEventCount = 0;
    }

    public void copyFrom(ControllerEventPacket controllerEventPacket) {
        this.accelEventCount = controllerEventPacket.accelEventCount;
        this.buttonEventCount = controllerEventPacket.buttonEventCount;
        this.gyroEventCount = controllerEventPacket.gyroEventCount;
        this.orientationEventCount = controllerEventPacket.orientationEventCount;
        this.touchEventCount = controllerEventPacket.touchEventCount;
        for (int i = 0; i < 16; i++) {
            this.accelEvents[i].copyFrom(controllerEventPacket.accelEvents[i]);
            this.buttonEvents[i].copyFrom(controllerEventPacket.buttonEvents[i]);
            this.gyroEvents[i].copyFrom(controllerEventPacket.gyroEvents[i]);
            this.orientationEvents[i].copyFrom(controllerEventPacket.orientationEvents[i]);
            this.touchEvents[i].copyFrom(controllerEventPacket.touchEvents[i]);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ControllerAccelEvent getAccelEvent(int i) {
        if (i >= 0 && i < this.accelEventCount) {
            return this.accelEvents[i];
        }
        throw new IndexOutOfBoundsException();
    }

    public int getAccelEventCount() {
        return this.accelEventCount;
    }

    public ControllerButtonEvent getButtonEvent(int i) {
        if (i >= 0 && i < this.buttonEventCount) {
            return this.buttonEvents[i];
        }
        throw new IndexOutOfBoundsException();
    }

    public int getButtonEventCount() {
        return this.buttonEventCount;
    }

    public ControllerGyroEvent getGyroEvent(int i) {
        if (i >= 0 && i < this.gyroEventCount) {
            return this.gyroEvents[i];
        }
        throw new IndexOutOfBoundsException();
    }

    public int getGyroEventCount() {
        return this.gyroEventCount;
    }

    public ControllerOrientationEvent getOrientationEvent(int i) {
        if (i >= 0 && i < this.orientationEventCount) {
            return this.orientationEvents[i];
        }
        throw new IndexOutOfBoundsException();
    }

    public int getOrientationEventCount() {
        return this.orientationEventCount;
    }

    public ControllerTouchEvent getTouchEvent(int i) {
        if (i >= 0 && i < this.touchEventCount) {
            return this.touchEvents[i];
        }
        throw new IndexOutOfBoundsException();
    }

    public int getTouchEventCount() {
        return this.touchEventCount;
    }

    public void readFromParcel(Parcel parcel) {
        parcel.readInt();
        int readInt = parcel.readInt();
        this.accelEventCount = readInt;
        checkIsValidEventCount(readInt);
        for (int i = 0; i < this.accelEventCount; i++) {
            this.accelEvents[i].readFromParcel(parcel);
        }
        int readInt2 = parcel.readInt();
        this.buttonEventCount = readInt2;
        checkIsValidEventCount(readInt2);
        for (int i2 = 0; i2 < this.buttonEventCount; i2++) {
            this.buttonEvents[i2].readFromParcel(parcel);
        }
        int readInt3 = parcel.readInt();
        this.gyroEventCount = readInt3;
        checkIsValidEventCount(readInt3);
        for (int i3 = 0; i3 < this.gyroEventCount; i3++) {
            this.gyroEvents[i3].readFromParcel(parcel);
        }
        int readInt4 = parcel.readInt();
        this.orientationEventCount = readInt4;
        checkIsValidEventCount(readInt4);
        for (int i4 = 0; i4 < this.orientationEventCount; i4++) {
            this.orientationEvents[i4].readFromParcel(parcel);
        }
        int readInt5 = parcel.readInt();
        this.touchEventCount = readInt5;
        checkIsValidEventCount(readInt5);
        for (int i5 = 0; i5 < this.touchEventCount; i5++) {
            this.touchEvents[i5].readFromParcel(parcel);
        }
    }

    public void recycle() {
        clear();
        synchronized (poolLock) {
            if (!pool.contains(this)) {
                pool.add(this);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(1);
        parcel.writeInt(this.accelEventCount);
        for (int i2 = 0; i2 < this.accelEventCount; i2++) {
            this.accelEvents[i2].writeToParcel(parcel, i);
        }
        parcel.writeInt(this.buttonEventCount);
        for (int i3 = 0; i3 < this.buttonEventCount; i3++) {
            this.buttonEvents[i3].writeToParcel(parcel, i);
        }
        parcel.writeInt(this.gyroEventCount);
        for (int i4 = 0; i4 < this.gyroEventCount; i4++) {
            this.gyroEvents[i4].writeToParcel(parcel, i);
        }
        parcel.writeInt(this.orientationEventCount);
        for (int i5 = 0; i5 < this.orientationEventCount; i5++) {
            this.orientationEvents[i5].writeToParcel(parcel, i);
        }
        parcel.writeInt(this.touchEventCount);
        for (int i6 = 0; i6 < this.touchEventCount; i6++) {
            this.touchEvents[i6].writeToParcel(parcel, i);
        }
    }

    protected ControllerEventPacket(Parcel parcel) {
        this();
        readFromParcel(parcel);
    }
}
