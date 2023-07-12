package tb;

import com.taobao.slide.stat.BizStatData;
import com.taobao.slide.stat.IBizStat;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class mh1 {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class a implements IBizStat {
        IBizStat a;

        public a(IBizStat iBizStat) {
            this.a = null;
            this.a = iBizStat;
        }

        @Override // com.taobao.slide.stat.IBizStat
        public void commitDownload(BizStatData bizStatData) {
            IBizStat iBizStat = this.a;
            if (iBizStat != null) {
                iBizStat.commitDownload(bizStatData);
            }
        }

        @Override // com.taobao.slide.stat.IBizStat
        public void commitUse(BizStatData bizStatData) {
            IBizStat iBizStat = this.a;
            if (iBizStat != null) {
                iBizStat.commitUse(bizStatData);
            }
        }
    }

    public static void a(IBizStat iBizStat) {
        new a(iBizStat);
    }
}
