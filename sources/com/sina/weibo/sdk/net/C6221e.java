package com.sina.weibo.sdk.net;

import android.os.Bundle;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.sina.weibo.sdk.net.e */
/* loaded from: classes7.dex */
public final class C6221e implements InterfaceC6220d {
    private String i;
    private Bundle j = new Bundle();
    private Bundle k = new Bundle();
    private Map<String, Object<File>> l = new HashMap();
    private Map<String, byte[]> m = new HashMap();
    private int n;
    private int o;

    /* compiled from: Taobao */
    /* renamed from: com.sina.weibo.sdk.net.e$a */
    /* loaded from: classes7.dex */
    public static final class C6222a {
        public String i;
        Bundle j = new Bundle();
        Bundle k = new Bundle();
        Map<String, Object<File>> l = new HashMap();
        Map<String, byte[]> m = new HashMap();
        int n = 30000;
        int o = 60000;

        public final C6222a a(String str, Object obj) {
            a(this.j, str, obj);
            return this;
        }

        public final C6222a b(String str, Object obj) {
            a(this.k, str, obj);
            return this;
        }

        public final C6221e e() {
            return new C6221e(this);
        }

        private void a(Bundle bundle, String str, Object obj) {
            if (obj != null) {
                if (obj instanceof String) {
                    bundle.putString(str, String.valueOf(obj));
                } else if (obj instanceof Integer) {
                    bundle.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Short) {
                    bundle.putShort(str, ((Short) obj).shortValue());
                } else if (obj instanceof Character) {
                    bundle.putChar(str, ((Character) obj).charValue());
                } else if (obj instanceof Byte) {
                    bundle.putByte(str, ((Byte) obj).byteValue());
                } else if (obj instanceof Long) {
                    bundle.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof Float) {
                    bundle.putFloat(str, ((Float) obj).floatValue());
                } else if (obj instanceof Double) {
                    bundle.putDouble(str, ((Double) obj).doubleValue());
                } else if (obj instanceof Boolean) {
                    bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof byte[]) {
                    this.m.put(str, (byte[]) obj);
                } else if (obj instanceof Serializable) {
                    bundle.putSerializable(str, (Serializable) obj);
                } else {
                    throw new IllegalArgumentException("Unsupported params type!");
                }
            }
        }
    }

    public C6221e(C6222a c6222a) {
        this.i = c6222a.i;
        this.j.putAll(c6222a.j);
        this.k.putAll(c6222a.k);
        this.l.putAll(c6222a.l);
        this.m.putAll(c6222a.m);
        this.n = c6222a.n;
        this.o = c6222a.o;
    }

    @Override // com.sina.weibo.sdk.net.InterfaceC6220d
    public final Bundle d() {
        return this.k;
    }

    @Override // com.sina.weibo.sdk.net.InterfaceC6220d
    public final int getConnectTimeout() {
        return this.n;
    }

    @Override // com.sina.weibo.sdk.net.InterfaceC6220d
    public final Bundle getParams() {
        return this.j;
    }

    @Override // com.sina.weibo.sdk.net.InterfaceC6220d
    public final int getReadTimeout() {
        return this.o;
    }

    @Override // com.sina.weibo.sdk.net.InterfaceC6220d
    public final String getUrl() {
        return this.i;
    }
}
