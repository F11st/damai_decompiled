package com.xiaomi.push;

import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.d */
/* loaded from: classes11.dex */
public class C7626d extends IOException {
    public C7626d(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C7626d a() {
        return new C7626d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C7626d b() {
        return new C7626d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C7626d c() {
        return new C7626d("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C7626d d() {
        return new C7626d("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C7626d e() {
        return new C7626d("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C7626d f() {
        return new C7626d("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C7626d g() {
        return new C7626d("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C7626d h() {
        return new C7626d("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
