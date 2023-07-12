package com.taobao.android.protodb;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import tb.n71;
import tb.r71;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a extends LSDB {
    private final SharedPreferences a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        super(0L, "");
        this.a = context.getSharedPreferences("lsdb", 0);
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean close() {
        return false;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean contains(n71 n71Var) {
        return this.a.contains(n71Var.a());
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean delete(n71 n71Var) {
        this.a.edit().remove(n71Var.a()).apply();
        return true;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean forceCompact() {
        return false;
    }

    @Override // com.taobao.android.protodb.LSDB
    public byte[] getBinary(n71 n71Var) {
        return null;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean getBool(n71 n71Var) {
        return this.a.getBoolean(n71Var.a(), false);
    }

    @Override // com.taobao.android.protodb.LSDB
    public int getDataSize(@NonNull n71 n71Var) {
        return 0;
    }

    @Override // com.taobao.android.protodb.LSDB
    public double getDouble(n71 n71Var) {
        return getFloat(n71Var);
    }

    @Override // com.taobao.android.protodb.LSDB
    public float getFloat(n71 n71Var) {
        return this.a.getFloat(n71Var.a(), 0.0f);
    }

    @Override // com.taobao.android.protodb.LSDB
    public int getInt(n71 n71Var) {
        return this.a.getInt(n71Var.a(), 0);
    }

    @Override // com.taobao.android.protodb.LSDB
    public long getLong(n71 n71Var) {
        return this.a.getLong(n71Var.a(), 0L);
    }

    @Override // com.taobao.android.protodb.LSDB
    public String getString(n71 n71Var) {
        return this.a.getString(n71Var.a(), "");
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean insertBinary(n71 n71Var, byte[] bArr) {
        return false;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean insertBool(n71 n71Var, boolean z) {
        this.a.edit().putBoolean(n71Var.a(), z).apply();
        return true;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean insertDouble(n71 n71Var, double d) {
        this.a.edit().putFloat(n71Var.a(), (float) d).apply();
        return true;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean insertFloat(n71 n71Var, float f) {
        this.a.edit().putFloat(n71Var.a(), f).apply();
        return true;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean insertInt(n71 n71Var, int i) {
        this.a.edit().putInt(n71Var.a(), i).apply();
        return true;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean insertLong(n71 n71Var, long j) {
        this.a.edit().putLong(n71Var.a(), j).apply();
        return true;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean insertString(n71 n71Var, String str) {
        this.a.edit().putString(n71Var.a(), str).apply();
        return true;
    }

    @Override // com.taobao.android.protodb.LSDB
    public Iterator<n71> keyIterator() {
        return new r71((String[]) this.a.getAll().keySet().toArray(new String[0]));
    }

    @Override // com.taobao.android.protodb.LSDB
    public Iterator<n71> keyIterator(n71 n71Var, n71 n71Var2) {
        return null;
    }
}
