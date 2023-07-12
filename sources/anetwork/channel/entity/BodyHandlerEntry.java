package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import anet.channel.request.BodyEntry;
import anetwork.channel.IBodyHandler;
import anetwork.channel.aidl.ParcelableBodyHandler;
import anetwork.channel.aidl.adapter.ParcelableBodyHandlerWrapper;
import java.io.IOException;
import java.io.OutputStream;
import tb.he;
import tb.je;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class BodyHandlerEntry implements BodyEntry {
    public static final Parcelable.Creator<BodyHandlerEntry> CREATOR = new C0244a();
    ParcelableBodyHandler bodyHandler;

    /* compiled from: Taobao */
    /* renamed from: anetwork.channel.entity.BodyHandlerEntry$a */
    /* loaded from: classes.dex */
    static class C0244a implements Parcelable.Creator<BodyHandlerEntry> {
        C0244a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BodyHandlerEntry createFromParcel(Parcel parcel) {
            BodyHandlerEntry bodyHandlerEntry = new BodyHandlerEntry((C0244a) null);
            bodyHandlerEntry.bodyHandler = ParcelableBodyHandler.Stub.asInterface(parcel.readStrongBinder());
            return bodyHandlerEntry;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BodyHandlerEntry[] newArray(int i) {
            return new BodyHandlerEntry[i];
        }
    }

    /* synthetic */ BodyHandlerEntry(C0244a c0244a) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // anet.channel.request.BodyEntry
    public String getContentType() {
        return null;
    }

    @Override // anet.channel.request.BodyEntry
    public int writeTo(OutputStream outputStream) throws IOException {
        try {
            he c = je.a().c(2048);
            int i = 0;
            while (!this.bodyHandler.isCompleted()) {
                int read = this.bodyHandler.read(c.c());
                outputStream.write(c.c(), 0, read);
                i += read;
            }
            c.f();
            return i;
        } catch (RemoteException e) {
            throw new IOException("RemoteException", e);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongInterface(this.bodyHandler);
    }

    public BodyHandlerEntry(IBodyHandler iBodyHandler) {
        this.bodyHandler = null;
        this.bodyHandler = new ParcelableBodyHandlerWrapper(iBodyHandler);
    }

    private BodyHandlerEntry() {
        this.bodyHandler = null;
    }
}
