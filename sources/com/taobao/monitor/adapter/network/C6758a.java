package com.taobao.monitor.adapter.network;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tb.fu0;

/* compiled from: Taobao */
/* renamed from: com.taobao.monitor.adapter.network.a */
/* loaded from: classes11.dex */
class C6758a implements ILiteDb {
    private final File a = new File(fu0.e().a().getCacheDir() + "/apm_db.db");

    private void a() throws Exception {
        if (!this.a.exists()) {
            this.a.createNewFile();
        } else if (this.a.isDirectory()) {
            this.a.delete();
            this.a.createNewFile();
        }
    }

    @Override // com.taobao.monitor.adapter.network.ILiteDb
    public void delete() {
        if (this.a.exists()) {
            this.a.delete();
        }
    }

    @Override // com.taobao.monitor.adapter.network.ILiteDb
    public void insert(String str) {
        FileWriter fileWriter;
        try {
            a();
            if (this.a.length() < 4194304) {
                FileWriter fileWriter2 = null;
                try {
                    fileWriter = new FileWriter(this.a, true);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileWriter.append((CharSequence) str).append((CharSequence) StringUtils.LF);
                    fileWriter.close();
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter2 = fileWriter;
                    if (fileWriter2 != null) {
                        fileWriter2.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.monitor.adapter.network.ILiteDb
    public List<String> select() {
        BufferedReader bufferedReader;
        try {
            a();
            if (this.a.length() > 0) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(this.a));
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = null;
                }
                try {
                    ArrayList arrayList = new ArrayList();
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        arrayList.add(readLine);
                    }
                    bufferedReader.close();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
