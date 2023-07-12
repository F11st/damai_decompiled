package cn.damai.mine.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class AcquireScoreDto implements Serializable {
    public List<AcquireScoreModel> acquireScoreDtos;
    public int total;
    public int us;
    public long usercode;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class AcquireScoreModel {
        public long PKID;
        public String acquireTime;
        public String businessAcquireId;
        public String businessId;
        public String businessName;
        public int businessType;
        public String enableTime;
        public String matureTime;
        public String score;
        public int scoreStatus;
        public int scoreType;
    }
}
