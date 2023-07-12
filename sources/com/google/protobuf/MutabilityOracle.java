package com.google.protobuf;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = new C5384a();

    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.MutabilityOracle$a */
    /* loaded from: classes10.dex */
    static class C5384a implements MutabilityOracle {
        C5384a() {
        }

        @Override // com.google.protobuf.MutabilityOracle
        public void ensureMutable() {
            throw new UnsupportedOperationException();
        }
    }

    void ensureMutable();
}
