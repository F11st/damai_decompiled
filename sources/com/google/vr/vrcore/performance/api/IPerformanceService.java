package com.google.vr.vrcore.performance.api;

import android.content.ComponentName;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;
import com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IPerformanceService extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Stub extends BaseStub implements IPerformanceService {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.performance.api.IPerformanceService";
        static final int TRANSACTION_addTrigger = 3;
        static final int TRANSACTION_getCurrentEstimatedThrottleWarningTime = 2;
        static final int TRANSACTION_getCurrentThrottlingRelativeTemperature = 1;
        static final int TRANSACTION_removeAllTriggers = 4;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class Proxy extends BaseProxy implements IPerformanceService {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            @Override // com.google.vr.vrcore.performance.api.IPerformanceService
            public void addTrigger(ComponentName componentName, IThrottlingTriggerCallback iThrottlingTriggerCallback, long j, float f, int i) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, componentName);
                Codecs.writeStrongBinder(obtainAndWriteInterfaceToken, iThrottlingTriggerCallback);
                obtainAndWriteInterfaceToken.writeLong(j);
                obtainAndWriteInterfaceToken.writeFloat(f);
                obtainAndWriteInterfaceToken.writeInt(i);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.performance.api.IPerformanceService
            public long getCurrentEstimatedThrottleWarningTime() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                long readLong = transactAndReadException.readLong();
                transactAndReadException.recycle();
                return readLong;
            }

            @Override // com.google.vr.vrcore.performance.api.IPerformanceService
            public void getCurrentThrottlingRelativeTemperature(TimestampedTemperature timestampedTemperature) throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
                if (transactAndReadException.readInt() != 0) {
                    timestampedTemperature.readFromParcel(transactAndReadException);
                }
                transactAndReadException.recycle();
            }

            @Override // com.google.vr.vrcore.performance.api.IPerformanceService
            public void removeAllTriggers(ComponentName componentName) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, componentName);
                transactAndReadExceptionReturnVoid(4, obtainAndWriteInterfaceToken);
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPerformanceService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IPerformanceService) {
                return (IPerformanceService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (routeToSuperOrEnforceInterface(i, parcel, parcel2, i2)) {
                return true;
            }
            if (i == 1) {
                TimestampedTemperature timestampedTemperature = new TimestampedTemperature();
                getCurrentThrottlingRelativeTemperature(timestampedTemperature);
                parcel2.writeNoException();
                Codecs.writeParcelableAsReturnValue(parcel2, timestampedTemperature);
            } else if (i == 2) {
                long currentEstimatedThrottleWarningTime = getCurrentEstimatedThrottleWarningTime();
                parcel2.writeNoException();
                parcel2.writeLong(currentEstimatedThrottleWarningTime);
            } else if (i == 3) {
                addTrigger((ComponentName) Codecs.createParcelable(parcel, ComponentName.CREATOR), IThrottlingTriggerCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong(), parcel.readFloat(), parcel.readInt());
                parcel2.writeNoException();
            } else if (i != 4) {
                return false;
            } else {
                removeAllTriggers((ComponentName) Codecs.createParcelable(parcel, ComponentName.CREATOR));
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void addTrigger(ComponentName componentName, IThrottlingTriggerCallback iThrottlingTriggerCallback, long j, float f, int i) throws RemoteException;

    long getCurrentEstimatedThrottleWarningTime() throws RemoteException;

    void getCurrentThrottlingRelativeTemperature(TimestampedTemperature timestampedTemperature) throws RemoteException;

    void removeAllTriggers(ComponentName componentName) throws RemoteException;
}
