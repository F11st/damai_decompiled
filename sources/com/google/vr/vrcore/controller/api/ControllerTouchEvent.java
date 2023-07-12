package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ControllerTouchEvent extends ControllerEvent {
    public static final int ACTION_CANCEL = 4;
    public static final int ACTION_DOWN = 1;
    public static final int ACTION_MOVE = 2;
    public static final int ACTION_NONE = 0;
    public static final int ACTION_UP = 3;
    public static final Parcelable.Creator<ControllerTouchEvent> CREATOR = new a();
    public int action;
    public int fingerId;
    public float x;
    public float y;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<ControllerTouchEvent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ControllerTouchEvent createFromParcel(Parcel parcel) {
            return new ControllerTouchEvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ControllerTouchEvent[] newArray(int i) {
            return new ControllerTouchEvent[i];
        }
    }

    public ControllerTouchEvent() {
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void copyFrom(ControllerEvent controllerEvent) {
        if (controllerEvent instanceof ControllerTouchEvent) {
            super.copyFrom(controllerEvent);
            ControllerTouchEvent controllerTouchEvent = (ControllerTouchEvent) controllerEvent;
            this.fingerId = controllerTouchEvent.fingerId;
            this.action = controllerTouchEvent.action;
            this.x = controllerTouchEvent.x;
            this.y = controllerTouchEvent.y;
            return;
        }
        throw new IllegalStateException("Cannot copy ControllerTouchEvent from non-ControllerTouchEvent instance.");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final int getByteSize() {
        return super.getByteSize() + 8 + 8;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.fingerId = parcel.readInt();
        this.action = parcel.readInt();
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.fingerId);
        parcel.writeInt(this.action);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
    }

    public ControllerTouchEvent(Parcel parcel) {
        readFromParcel(parcel);
    }
}
