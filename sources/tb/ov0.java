package tb;

import android.util.Log;
import com.ali.alihadeviceevaluator.old.CalScore;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ov0 implements CalScore {
    String a;
    int b = 4;
    private String c = "SDM845,KIRIN970,MSM8998,EXYNOS8895";
    private String d = "MSM8997,HI3660";
    private String e = "MSM8996,MSM8996PRO,MSM8996 PRO,EXYNOS8890,MT6799";
    private String f = "SDM660,SDM630,MSM8994,MSM8992,HI3650,EXYNOS7420,VBOX86";
    private String g = "MSM8956,MSM8946,MT6797X,MT6797X,MT6797T,MT6797D";
    private String h = "APQ8084,MSM8084,MSM8953,HI3630,EXYNOS5433,HI3635,EXYNOS5";
    private String i = "MSM8X74,MSM8X74AA,MSM8X74AB,MSM8X74AC,MSM8674,MSM8274,MSM8074,EXYNOS5430,EXYNOS7870,EXYNOS7580,EXYNOS5433,MT679X,MT6797T,MT6797,EXYNOS5420,UNIVERSAL5420,RANCHU";
    private String j = "MT675X,MT6795,MT6755,MT6752,MT6753,EXYNOS5800,EXYNOS5422,EXYNOS5410,MSM8952,MSM8940,PXA1936,HI6210SFT";
    private String k = "EXYNOS5260,EXYNOS5250,MT6750,MT6735,MSM8939V2,MSM8937,MSM8929,APQ8064,MSM8917,EXYNOS52,K3V2+,REDHOOKBAY,PXA1908,SC9860,HI6620OEM";
    private String l = "MT6595,MT6592,MT6582,MSM8936,MSM8909,MSM8909V2,MSM8916V2,MSM8208,MSM8960T,MSM8260A,MSM8660A,MSM8960,MSM8X12,MSM8X10,MSM8X30,LC1860";
    private String m = "K3V2E,K3V2,MT6589,EXYNOS4210,EXYNOS4212,MSM8X25Q,MSM8X26,PXA1088,PXA1L88,MSM8260,MSM8660,MSM8625,MSM8225,MSM8655,APQ8055,MSM7230,MSM7630,GOLDFISH,MSM8255T,MSM8655T,MSM7627A,MSM7227A,MSM7627T,MSM7227T,MT6577T,MT6572M,MT6515M,MT6575,QSD8650,QSD8250,OMAP4470,SP8810,SC8810MT6516,MT6573,MT6513,S5PC100,S5L8900,HI3611,HI3620,OMAP4460,OMAP4440,OMAP4430,EXYNOS3475,EXYNOS3110";
    String[] n = {"K3V2E,K3V2,MT6589,EXYNOS4210,EXYNOS4212,MSM8X25Q,MSM8X26,PXA1088,PXA1L88,MSM8260,MSM8660,MSM8625,MSM8225,MSM8655,APQ8055,MSM7230,MSM7630,GOLDFISH,MSM8255T,MSM8655T,MSM7627A,MSM7227A,MSM7627T,MSM7227T,MT6577T,MT6572M,MT6515M,MT6575,QSD8650,QSD8250,OMAP4470,SP8810,SC8810MT6516,MT6573,MT6513,S5PC100,S5L8900,HI3611,HI3620,OMAP4460,OMAP4440,OMAP4430,EXYNOS3475,EXYNOS3110", "MT6595,MT6592,MT6582,MSM8936,MSM8909,MSM8909V2,MSM8916V2,MSM8208,MSM8960T,MSM8260A,MSM8660A,MSM8960,MSM8X12,MSM8X10,MSM8X30,LC1860", "EXYNOS5260,EXYNOS5250,MT6750,MT6735,MSM8939V2,MSM8937,MSM8929,APQ8064,MSM8917,EXYNOS52,K3V2+,REDHOOKBAY,PXA1908,SC9860,HI6620OEM", "MT675X,MT6795,MT6755,MT6752,MT6753,EXYNOS5800,EXYNOS5422,EXYNOS5410,MSM8952,MSM8940,PXA1936,HI6210SFT", "MSM8X74,MSM8X74AA,MSM8X74AB,MSM8X74AC,MSM8674,MSM8274,MSM8074,EXYNOS5430,EXYNOS7870,EXYNOS7580,EXYNOS5433,MT679X,MT6797T,MT6797,EXYNOS5420,UNIVERSAL5420,RANCHU", "APQ8084,MSM8084,MSM8953,HI3630,EXYNOS5433,HI3635,EXYNOS5", "MSM8956,MSM8946,MT6797X,MT6797X,MT6797T,MT6797D", "SDM660,SDM630,MSM8994,MSM8992,HI3650,EXYNOS7420,VBOX86", "MSM8996,MSM8996PRO,MSM8996 PRO,EXYNOS8890,MT6799", "MSM8997,HI3660", "SDM845,KIRIN970,MSM8998,EXYNOS8895"};

    int a(String str) {
        if (this.a == null) {
            return -1;
        }
        for (int length = this.n.length - 1; length >= 0; length--) {
            String str2 = this.n[length];
            if (str2 != null && str2.contains(str)) {
                Log.e("OnlineMonitor", "cpuModel=" + str + ",score=" + length);
                return length;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x00f5, code lost:
        if (r0 >= 1.0f) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00f8, code lost:
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0055, code lost:
        if (r4 >= 1.0f) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c1, code lost:
        if (r0 >= 1.0f) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00c3, code lost:
        r2 = 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int b(com.ali.alihadeviceevaluator.old.HardWareInfo r21) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ov0.b(com.ali.alihadeviceevaluator.old.HardWareInfo):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0185, code lost:
        if (r0 >= 2) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0194, code lost:
        if (r0 >= 2) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01a4, code lost:
        if (r0 >= 2) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x01b3, code lost:
        if (r0 >= 2) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01c8, code lost:
        if (r0 >= 2) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fb, code lost:
        if (r0 >= 2) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x014f, code lost:
        if (r0 >= 2) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0153, code lost:
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0177, code lost:
        if (r1 >= 2) goto L79;
     */
    @Override // com.ali.alihadeviceevaluator.old.CalScore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getScore(com.ali.alihadeviceevaluator.old.HardWareInfo r15) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ov0.getScore(com.ali.alihadeviceevaluator.old.HardWareInfo):int");
    }
}
