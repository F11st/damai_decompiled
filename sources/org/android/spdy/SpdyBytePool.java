package org.android.spdy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SpdyBytePool {
    private static final int POOL_SIZE = 16;
    private static volatile SpdyBytePool gInstance;
    private static Object lock = new Object();
    private ArrayList<Deque<SpdyByteArray>> bucks;

    private SpdyBytePool() {
        this.bucks = null;
        this.bucks = new ArrayList<>(16);
        for (int i = 0; i < 16; i++) {
            this.bucks.add(null);
        }
    }

    public static SpdyBytePool getInstance() {
        if (gInstance == null) {
            synchronized (lock) {
                if (gInstance == null) {
                    gInstance = new SpdyBytePool();
                }
            }
        }
        return gInstance;
    }

    SpdyByteArray getSpdyByteArray(int i) {
        int i2 = (i + 4095) & (-4096);
        int i3 = i2 > 0 ? i2 >> 12 : 0;
        SpdyByteArray spdyByteArray = null;
        if (i3 < 16) {
            synchronized (lock) {
                Deque<SpdyByteArray> deque = this.bucks.get(i3);
                if (deque != null && deque.size() > 0) {
                    spdyByteArray = deque.pop();
                }
            }
        }
        return spdyByteArray == null ? new SpdyByteArray(i2) : spdyByteArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recycle(SpdyByteArray spdyByteArray) {
        int i = spdyByteArray.length;
        int i2 = i > 0 ? i >> 12 : 0;
        if (i2 < 16) {
            synchronized (lock) {
                Deque<SpdyByteArray> deque = this.bucks.get(i2);
                if (deque == null) {
                    deque = new ArrayDeque<>(16);
                    this.bucks.set(i2, deque);
                }
                deque.push(spdyByteArray);
            }
        }
    }
}
