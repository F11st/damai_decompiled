package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ControllerAccelEvent extends ControllerEvent {
    public static final Parcelable.Creator<ControllerAccelEvent> CREATOR = new C5438a();
    public float x;
    public float y;
    public float z;

    /* compiled from: Taobao */
    /* renamed from: com.google.vr.vrcore.controller.api.ControllerAccelEvent$a */
    /* loaded from: classes10.dex */
    class C5438a implements Parcelable.Creator<ControllerAccelEvent> {
        C5438a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ControllerAccelEvent createFromParcel(Parcel parcel) {
            return new ControllerAccelEvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ControllerAccelEvent[] newArray(int i) {
            return new ControllerAccelEvent[i];
        }
    }

    public ControllerAccelEvent() {
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void copyFrom(ControllerEvent controllerEvent) {
        if (controllerEvent instanceof ControllerAccelEvent) {
            super.copyFrom(controllerEvent);
            ControllerAccelEvent controllerAccelEvent = (ControllerAccelEvent) controllerEvent;
            this.x = controllerAccelEvent.x;
            this.y = controllerAccelEvent.y;
            this.z = controllerAccelEvent.z;
            return;
        }
        throw new IllegalStateException("Cannot copy ControllerAccelEvent from non-ControllerAccelEvent instance.");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final int getByteSize() {
        return super.getByteSize() + 12;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.z = parcel.readFloat();
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.z);
    }

    public ControllerAccelEvent(Parcel parcel) {
        readFromParcel(parcel);
    }
}
