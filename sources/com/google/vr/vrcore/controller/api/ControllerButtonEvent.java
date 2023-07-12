package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ControllerButtonEvent extends ControllerEvent {
    public static final int BUTTON_APP = 3;
    public static final int BUTTON_CLICK = 1;
    public static final int BUTTON_COUNT = 7;
    public static final int BUTTON_HOME = 2;
    public static final int BUTTON_NONE = 0;
    public static final int BUTTON_VOLUME_DOWN = 6;
    public static final int BUTTON_VOLUME_UP = 5;
    public static final Parcelable.Creator<ControllerButtonEvent> CREATOR = new a();
    public int button;
    public boolean down;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<ControllerButtonEvent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ControllerButtonEvent createFromParcel(Parcel parcel) {
            return new ControllerButtonEvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ControllerButtonEvent[] newArray(int i) {
            return new ControllerButtonEvent[i];
        }
    }

    public ControllerButtonEvent() {
    }

    public static String buttonToString(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 5) {
                            if (i != 6) {
                                StringBuilder sb = new StringBuilder(29);
                                sb.append("[Unknown button: ");
                                sb.append(i);
                                sb.append(jn1.ARRAY_END_STR);
                                return sb.toString();
                            }
                            return "BUTTON_VOLUME_DOWN";
                        }
                        return "BUTTON_VOLUME_UP";
                    }
                    return "BUTTON_APP";
                }
                return "BUTTON_HOME";
            }
            return "BUTTON_CLICK";
        }
        return "BUTTON_NONE";
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void copyFrom(ControllerEvent controllerEvent) {
        if (controllerEvent instanceof ControllerButtonEvent) {
            super.copyFrom(controllerEvent);
            ControllerButtonEvent controllerButtonEvent = (ControllerButtonEvent) controllerEvent;
            this.button = controllerButtonEvent.button;
            this.down = controllerButtonEvent.down;
            return;
        }
        throw new IllegalStateException("Cannot copy ControllerButtonEvent from non-ControllerButtonEvent instance.");
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
        this.button = parcel.readInt();
        this.down = parcel.readInt() != 0;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.button);
        parcel.writeInt(this.down ? 1 : 0);
    }

    public ControllerButtonEvent(Parcel parcel) {
        readFromParcel(parcel);
    }
}
