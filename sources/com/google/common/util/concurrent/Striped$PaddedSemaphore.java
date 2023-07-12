package com.google.common.util.concurrent;

import java.util.concurrent.Semaphore;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class Striped$PaddedSemaphore extends Semaphore {
    long unused1;
    long unused2;
    long unused3;

    Striped$PaddedSemaphore(int i) {
        super(i, false);
    }
}
