package com.taobao.accs.asp;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ModifiedRecord implements Parcelable {
    public static final Parcelable.Creator<ModifiedRecord> CREATOR = new Parcelable.Creator<ModifiedRecord>() { // from class: com.taobao.accs.asp.ModifiedRecord.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ModifiedRecord createFromParcel(Parcel parcel) {
            return new ModifiedRecord(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ModifiedRecord[] newArray(int i) {
            return new ModifiedRecord[i];
        }
    };
    boolean isClear;
    Bundle modified;
    String name;
    long timestampVersion;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeBundle(this.modified);
        parcel.writeInt(this.isClear ? 1 : 0);
        parcel.writeLong(this.timestampVersion);
    }

    private ModifiedRecord(Parcel parcel) {
        this.name = parcel.readString();
        this.modified = parcel.readBundle(getClass().getClassLoader());
        this.isClear = parcel.readInt() == 1;
        this.timestampVersion = parcel.readLong();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModifiedRecord(String str) {
        this.name = str;
    }
}
