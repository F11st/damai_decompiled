package com.taobao.android.launcher.statistics.common.processes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ProcFile extends File {
    public final String content;

    /* JADX INFO: Access modifiers changed from: protected */
    public ProcFile(String str) throws IOException {
        super(str);
        this.content = readFile(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String readFile(String str) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            try {
                String str2 = "";
                for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                    sb.append(str2);
                    sb.append(readLine);
                    str2 = StringUtils.LF;
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader2.close();
                } catch (IOException unused) {
                }
                return sb2;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
