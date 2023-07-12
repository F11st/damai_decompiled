package com.alibaba.mtl.appmonitor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.alibaba.analytics.AnalyticsMgr;
import com.alibaba.analytics.IAnalytics;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.pool.a;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import java.util.UUID;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class Transaction implements Parcelable {
    public static Parcelable.Creator<Transaction> CREATOR = new Parcelable.Creator<Transaction>() { // from class: com.alibaba.mtl.appmonitor.Transaction.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Transaction createFromParcel(Parcel parcel) {
            return Transaction.readFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Transaction[] newArray(int i) {
            return new Transaction[i];
        }
    };
    public DimensionValueSet dimensionValues;
    public Integer eventId;
    private Object lock;
    public String module;
    public String monitorPoint;
    public String transactionId;

    public Transaction(Integer num, String str, String str2, DimensionValueSet dimensionValueSet) {
        this.eventId = num;
        this.module = str;
        this.monitorPoint = str2;
        this.transactionId = UUID.randomUUID().toString();
        this.dimensionValues = dimensionValueSet;
        this.lock = new Object();
    }

    static Transaction readFromParcel(Parcel parcel) {
        Transaction transaction = new Transaction();
        try {
            transaction.dimensionValues = (DimensionValueSet) parcel.readParcelable(Transaction.class.getClassLoader());
            transaction.eventId = Integer.valueOf(parcel.readInt());
            transaction.module = parcel.readString();
            transaction.monitorPoint = parcel.readString();
            transaction.transactionId = parcel.readString();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return transaction;
    }

    public void addDimensionValues(DimensionValueSet dimensionValueSet) {
        synchronized (this.lock) {
            DimensionValueSet dimensionValueSet2 = this.dimensionValues;
            if (dimensionValueSet2 == null) {
                this.dimensionValues = dimensionValueSet;
            } else {
                dimensionValueSet2.addValues(dimensionValueSet);
            }
        }
    }

    public void begin(String str) {
        Logger.d();
        IAnalytics iAnalytics = AnalyticsMgr.b;
        if (iAnalytics == null) {
            return;
        }
        try {
            iAnalytics.transaction_begin(this, str);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void end(String str) {
        Logger.d();
        IAnalytics iAnalytics = AnalyticsMgr.b;
        if (iAnalytics == null) {
            return;
        }
        try {
            iAnalytics.transaction_end(this, str);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.dimensionValues, i);
        parcel.writeInt(this.eventId.intValue());
        parcel.writeString(this.module);
        parcel.writeString(this.monitorPoint);
        parcel.writeString(this.transactionId);
    }

    public void addDimensionValues(String str, String str2) {
        synchronized (this.lock) {
            if (this.dimensionValues == null) {
                this.dimensionValues = (DimensionValueSet) a.a().poll(DimensionValueSet.class, new Object[0]);
            }
            this.dimensionValues.setValue(str, str2);
        }
    }

    public Transaction() {
    }
}
