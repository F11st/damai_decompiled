package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ControllerBatteryEvent extends ControllerEvent {
    public static final int BATTERY_LEVEL_ALMOST_FULL = 4;
    public static final int BATTERY_LEVEL_COUNT = 6;
    public static final int BATTERY_LEVEL_CRITICAL_LOW = 1;
    public static final int BATTERY_LEVEL_FULL = 5;
    public static final int BATTERY_LEVEL_LOW = 2;
    public static final int BATTERY_LEVEL_MEDIUM = 3;
    public static final int BATTERY_LEVEL_UNKNOWN = 0;
    public static final Parcelable.Creator<ControllerBatteryEvent> CREATOR = new a();
    public int batteryLevelBucket;
    public boolean charging;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<ControllerBatteryEvent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ControllerBatteryEvent createFromParcel(Parcel parcel) {
            return new ControllerBatteryEvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ControllerBatteryEvent[] newArray(int i) {
            return new ControllerBatteryEvent[i];
        }
    }

    public ControllerBatteryEvent() {
    }

    public static int getBatteryLevelBucket(int i) {
        if (i < 20) {
            return 1;
        }
        if (i < 40) {
            return 2;
        }
        if (i < 60) {
            return 3;
        }
        return i < 80 ? 4 : 5;
    }

    public static String toString(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                StringBuilder sb = new StringBuilder(28);
                                sb.append("[Unknown level: ");
                                sb.append(i);
                                sb.append(jn1.ARRAY_END_STR);
                                return sb.toString();
                            }
                            return "BATTERY_LEVEL_FULL";
                        }
                        return "BATTERY_LEVEL_ALMOST_FULL";
                    }
                    return "BATTERY_LEVEL_MEDIUM";
                }
                return "BATTERY_LEVEL_LOW";
            }
            return "BATTERY_LEVEL_CRITICAL_LOW";
        }
        return "BATTERY_LEVEL_UNKNOWN";
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void copyFrom(ControllerEvent controllerEvent) {
        if (controllerEvent instanceof ControllerBatteryEvent) {
            super.copyFrom(controllerEvent);
            ControllerBatteryEvent controllerBatteryEvent = (ControllerBatteryEvent) controllerEvent;
            this.batteryLevelBucket = controllerBatteryEvent.batteryLevelBucket;
            this.charging = controllerBatteryEvent.charging;
            return;
        }
        throw new IllegalStateException("Cannot copy ControllerBatteryEvent from non-ControllerBatteryEvent instance.");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final int getByteSize() {
        return super.getByteSize() + 8;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.batteryLevelBucket = parcel.readInt();
        this.charging = parcel.readInt() != 0;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.batteryLevelBucket);
        parcel.writeInt(this.charging ? 1 : 0);
    }

    public ControllerBatteryEvent(Parcel parcel) {
        readFromParcel(parcel);
    }
}
