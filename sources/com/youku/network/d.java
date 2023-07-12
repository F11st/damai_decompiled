package com.youku.network;

import anetwork.channel.statist.StatisticData;
import com.youku.network.config.YKNetworkConfig;
import java.util.List;
import java.util.Map;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class d {
    private String b;
    private Throwable c;
    private String e;
    private byte[] f;
    private Map<String, List<String>> g;
    private StatisticData h;
    private MtopResponse i;
    private int a = 0;
    private int d = -1;

    public static d a() {
        return new d();
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(StatisticData statisticData) {
        this.h = statisticData;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(Throwable th) {
        this.c = th;
    }

    public void a(Map<String, List<String>> map) {
        this.g = map;
    }

    public void a(MtopResponse mtopResponse) {
        this.i = mtopResponse;
    }

    public void a(byte[] bArr) {
        this.f = bArr;
    }

    public int b() {
        int i = this.a;
        return i < 0 ? i : this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public boolean c() {
        return this.i != null;
    }

    public int d() {
        return this.d;
    }

    public byte[] e() {
        return this.f;
    }

    public Map<String, List<String>> f() {
        return this.g;
    }

    public StatisticData g() {
        return this.h;
    }

    public boolean h() {
        return c() ? this.i.isApiSuccess() : !com.youku.network.config.b.a(this.a) && this.d > 0;
    }

    public MtopResponse i() {
        return this.i;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("YKResponse{");
        sb2.append(", ykErrorMsg='" + this.b + '\'');
        StringBuilder sb3 = new StringBuilder();
        sb3.append(", error=");
        sb3.append(this.c);
        sb2.append(sb3.toString());
        sb2.append(", responseCode=" + this.d);
        sb2.append(", desc='" + this.e + '\'');
        if (this.f != null) {
            if (YKNetworkConfig.b() == -1 || this.f.length < YKNetworkConfig.b()) {
                sb = new StringBuilder();
                sb.append(", bytedata=");
                sb.append(new String(this.f));
            } else {
                sb = new StringBuilder();
                sb.append(", bytedata=too long in size:");
                sb.append(this.f.length);
            }
            sb2.append(sb.toString());
        }
        sb2.append(", connHeadFields=" + this.g);
        sb2.append(", statisticData=" + this.h + '}');
        return sb2.toString();
    }
}
