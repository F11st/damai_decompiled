package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import java.util.ArrayDeque;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ControllerEventPacket2 extends ControllerEventPacket {
    private boolean hasBatteryEvent;
    private int positionEventCount;
    private long timestampMillis;
    private static ArrayDeque<ControllerEventPacket2> pool = new ArrayDeque<>();
    private static Object poolLock = new Object();
    public static final Parcelable.Creator<ControllerEventPacket2> CREATOR = new C5442a();
    private ControllerPositionEvent[] positionEvents = new ControllerPositionEvent[16];
    private ControllerBatteryEvent batteryEvent = new ControllerBatteryEvent();

    /* compiled from: Taobao */
    /* renamed from: com.google.vr.vrcore.controller.api.ControllerEventPacket2$a */
    /* loaded from: classes10.dex */
    class C5442a implements Parcelable.Creator<ControllerEventPacket2> {
        C5442a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ControllerEventPacket2 createFromParcel(Parcel parcel) {
            ControllerEventPacket2 obtain = ControllerEventPacket2.obtain();
            obtain.readFromParcel(parcel);
            return obtain;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ControllerEventPacket2[] newArray(int i) {
            return new ControllerEventPacket2[i];
        }
    }

    public ControllerEventPacket2() {
        for (int i = 0; i < 16; i++) {
            this.positionEvents[i] = new ControllerPositionEvent();
        }
        clear();
    }

    public static ControllerEventPacket2 obtain() {
        ControllerEventPacket2 controllerEventPacket2;
        synchronized (poolLock) {
            controllerEventPacket2 = pool.isEmpty() ? new ControllerEventPacket2() : pool.remove();
        }
        return controllerEventPacket2;
    }

    public final ControllerBatteryEvent addBatteryEvent() {
        if (!this.hasBatteryEvent) {
            this.hasBatteryEvent = true;
            return this.batteryEvent;
        }
        throw new IllegalStateException("ControllerEventPacket already has battery event.");
    }

    public final ControllerPositionEvent addPositionEvent() {
        int i = this.positionEventCount;
        if (i < 16) {
            ControllerPositionEvent[] controllerPositionEventArr = this.positionEvents;
            this.positionEventCount = i + 1;
            return controllerPositionEventArr[i];
        }
        throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.vr.vrcore.controller.api.ControllerEventPacket
    public final int calculateParcelByteLength() {
        int calculateParcelByteLength = super.calculateParcelByteLength() + 4 + 4;
        for (int i = 0; i < this.positionEventCount; i++) {
            calculateParcelByteLength += this.positionEvents[i].getByteSize();
        }
        int i2 = calculateParcelByteLength + 4;
        if (this.hasBatteryEvent) {
            i2 += this.batteryEvent.getByteSize();
        }
        return i2 + 8;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEventPacket
    public final void clear() {
        super.clear();
        this.positionEventCount = 0;
        this.hasBatteryEvent = false;
        this.timestampMillis = 0L;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEventPacket
    public final void copyFrom(ControllerEventPacket controllerEventPacket) {
        if (controllerEventPacket instanceof ControllerEventPacket2) {
            super.copyFrom(controllerEventPacket);
            ControllerEventPacket2 controllerEventPacket2 = (ControllerEventPacket2) controllerEventPacket;
            this.positionEventCount = controllerEventPacket2.positionEventCount;
            this.hasBatteryEvent = controllerEventPacket2.hasBatteryEvent;
            this.timestampMillis = controllerEventPacket2.timestampMillis;
            this.batteryEvent.copyFrom(controllerEventPacket2.batteryEvent);
            for (int i = 0; i < 16; i++) {
                this.positionEvents[i].copyFrom(controllerEventPacket2.positionEvents[i]);
            }
            return;
        }
        throw new IllegalStateException("Cannot copy ControllerEventPacket2 from non-ControllerEventPacket2 instance.");
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEventPacket, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final ControllerBatteryEvent getBatteryEvent() {
        if (this.hasBatteryEvent) {
            return this.batteryEvent;
        }
        throw new IllegalStateException("ControllerEventPacket doesn't have a battery event.");
    }

    public final ControllerPositionEvent getPositionEvent(int i) {
        if (i >= 0 && i < this.positionEventCount) {
            return this.positionEvents[i];
        }
        throw new IndexOutOfBoundsException();
    }

    public final int getPositionEventCount() {
        return this.positionEventCount;
    }

    public final long getTimestampMillis() {
        return this.timestampMillis;
    }

    public final boolean hasBatteryEvent() {
        return this.hasBatteryEvent;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEventPacket
    public final void readFromParcel(Parcel parcel) {
        int dataPosition = parcel.dataPosition() + parcel.readInt();
        super.readFromParcel(parcel);
        if (parcel.dataPosition() < dataPosition) {
            int readInt = parcel.readInt();
            this.positionEventCount = readInt;
            checkIsValidEventCount(readInt);
            for (int i = 0; i < this.positionEventCount; i++) {
                this.positionEvents[i].readFromParcel(parcel);
            }
        }
        if (parcel.dataPosition() < dataPosition) {
            boolean z = parcel.readInt() != 0;
            this.hasBatteryEvent = z;
            if (z) {
                this.batteryEvent.readFromParcel(parcel);
            }
        }
        if (parcel.dataPosition() < dataPosition) {
            this.timestampMillis = parcel.readLong();
        }
        parcel.setDataPosition(dataPosition);
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEventPacket
    public final void recycle() {
        clear();
        synchronized (poolLock) {
            if (!pool.contains(this)) {
                pool.add(this);
            }
        }
    }

    public final void refreshTimestampMillis() {
        this.timestampMillis = SystemClock.elapsedRealtime();
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEventPacket, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int calculateParcelByteLength = calculateParcelByteLength();
        parcel.writeInt(calculateParcelByteLength);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.positionEventCount);
        for (int i2 = 0; i2 < this.positionEventCount; i2++) {
            this.positionEvents[i2].writeToParcel(parcel, i);
        }
        parcel.writeInt(this.hasBatteryEvent ? 1 : 0);
        if (this.hasBatteryEvent) {
            this.batteryEvent.writeToParcel(parcel, i);
        }
        parcel.writeLong(this.timestampMillis);
        if (parcel.dataPosition() - dataPosition != calculateParcelByteLength) {
            throw new IllegalStateException("Parcelable implemented incorrectly, getByteSize() must return the correct size for each ControllerEvent subclass.");
        }
    }
}
