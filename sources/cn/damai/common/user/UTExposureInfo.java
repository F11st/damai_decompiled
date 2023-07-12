package cn.damai.common.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class UTExposureInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public ArrayList<UTExposureBean> expdata;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static class UTExposureBean implements Serializable {
        private static final long serialVersionUID = 1;
        public String area;
        public long duration;
        public Map<String, String> exargs;
        public String spm;
        public String viewid;
    }
}
