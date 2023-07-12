package com.google.protobuf;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = new a();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a implements MutabilityOracle {
        a() {
        }

        @Override // com.google.protobuf.MutabilityOracle
        public void ensureMutable() {
            throw new UnsupportedOperationException();
        }
    }

    void ensureMutable();
}
