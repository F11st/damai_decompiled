package anetwork.channel.aidl.adapter;

import android.os.RemoteException;
import anetwork.channel.aidl.ParcelableInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import tb.he;
import tb.z12;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ParcelableInputStreamImpl extends ParcelableInputStream.Stub {
    private static final he EOS = he.b(0);
    private static final String TAG = "anet.ParcelableInputStreamImpl";
    private int blockIndex;
    private int blockOffset;
    private int contentLength;
    final ReentrantLock lock;
    final Condition newDataArrive;
    private final AtomicBoolean isClosed = new AtomicBoolean(false);
    private LinkedList<he> byteList = new LinkedList<>();
    private int rto = 10000;
    private String seqNo = "";

    public ParcelableInputStreamImpl() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.newDataArrive = reentrantLock.newCondition();
    }

    private void recycleCurrentItem() {
        this.lock.lock();
        try {
            this.byteList.set(this.blockIndex, EOS).f();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public int available() throws RemoteException {
        if (!this.isClosed.get()) {
            this.lock.lock();
            try {
                int i = 0;
                if (this.blockIndex == this.byteList.size()) {
                    return 0;
                }
                ListIterator<he> listIterator = this.byteList.listIterator(this.blockIndex);
                while (listIterator.hasNext()) {
                    i += listIterator.next().d();
                }
                return i - this.blockOffset;
            } finally {
                this.lock.unlock();
            }
        }
        throw new RuntimeException("Stream is closed");
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public void close() throws RemoteException {
        if (this.isClosed.compareAndSet(false, true)) {
            this.lock.lock();
            try {
                Iterator<he> it = this.byteList.iterator();
                while (it.hasNext()) {
                    he next = it.next();
                    if (next != EOS) {
                        next.f();
                    }
                }
                this.byteList.clear();
                this.byteList = null;
                this.blockIndex = -1;
                this.blockOffset = -1;
                this.contentLength = 0;
            } finally {
                this.lock.unlock();
            }
        }
    }

    public void init(z12 z12Var, int i) {
        this.contentLength = i;
        this.seqNo = z12Var.i;
        this.rto = z12Var.h;
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public int length() throws RemoteException {
        return this.contentLength;
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public int read(byte[] bArr) throws RemoteException {
        return readBytes(bArr, 0, bArr.length);
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public int readByte() throws RemoteException {
        byte b;
        if (!this.isClosed.get()) {
            this.lock.lock();
            while (true) {
                try {
                    try {
                        if (this.blockIndex == this.byteList.size() && !this.newDataArrive.await(this.rto, TimeUnit.MILLISECONDS)) {
                            close();
                            throw new RuntimeException("await timeout.");
                        }
                        he heVar = this.byteList.get(this.blockIndex);
                        if (heVar == EOS) {
                            b = -1;
                            break;
                        } else if (this.blockOffset < heVar.d()) {
                            byte[] c = heVar.c();
                            int i = this.blockOffset;
                            b = c[i];
                            this.blockOffset = i + 1;
                            break;
                        } else {
                            recycleCurrentItem();
                            this.blockIndex++;
                            this.blockOffset = 0;
                        }
                    } catch (InterruptedException unused) {
                        close();
                        throw new RuntimeException("await interrupt");
                    }
                } finally {
                    this.lock.unlock();
                }
            }
            return b;
        }
        throw new RuntimeException("Stream is closed");
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public int readBytes(byte[] bArr, int i, int i2) throws RemoteException {
        int i3;
        if (!this.isClosed.get()) {
            Objects.requireNonNull(bArr);
            if (i >= 0 && i2 >= 0 && (i3 = i2 + i) <= bArr.length) {
                this.lock.lock();
                int i4 = i;
                while (i4 < i3) {
                    try {
                        try {
                            if (this.blockIndex == this.byteList.size() && !this.newDataArrive.await(this.rto, TimeUnit.MILLISECONDS)) {
                                close();
                                throw new RuntimeException("await timeout.");
                            }
                            he heVar = this.byteList.get(this.blockIndex);
                            if (heVar == EOS) {
                                break;
                            }
                            int d = heVar.d() - this.blockOffset;
                            int i5 = i3 - i4;
                            if (d < i5) {
                                System.arraycopy(heVar.c(), this.blockOffset, bArr, i4, d);
                                i4 += d;
                                recycleCurrentItem();
                                this.blockIndex++;
                                this.blockOffset = 0;
                            } else {
                                System.arraycopy(heVar.c(), this.blockOffset, bArr, i4, i5);
                                this.blockOffset += i5;
                                i4 += i5;
                            }
                        } catch (InterruptedException unused) {
                            close();
                            throw new RuntimeException("await interrupt");
                        }
                    } catch (Throwable th) {
                        this.lock.unlock();
                        throw th;
                    }
                }
                this.lock.unlock();
                int i6 = i4 - i;
                if (i6 > 0) {
                    return i6;
                }
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new RuntimeException("Stream is closed");
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public long skip(int i) throws RemoteException {
        he heVar;
        this.lock.lock();
        int i2 = 0;
        while (i2 < i) {
            try {
                if (this.blockIndex != this.byteList.size() && (heVar = this.byteList.get(this.blockIndex)) != EOS) {
                    int d = heVar.d();
                    int i3 = this.blockOffset;
                    int i4 = i - i2;
                    if (d - i3 < i4) {
                        i2 += d - i3;
                        recycleCurrentItem();
                        this.blockIndex++;
                        this.blockOffset = 0;
                    } else {
                        this.blockOffset = i3 + i4;
                        i2 = i;
                    }
                }
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        this.lock.unlock();
        return i2;
    }

    public void write(he heVar) {
        if (this.isClosed.get()) {
            return;
        }
        this.lock.lock();
        try {
            this.byteList.add(heVar);
            this.newDataArrive.signal();
        } finally {
            this.lock.unlock();
        }
    }

    public void writeEnd() {
        write(EOS);
    }
}
