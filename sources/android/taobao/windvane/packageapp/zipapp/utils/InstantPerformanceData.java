package android.taobao.windvane.packageapp.zipapp.utils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class InstantPerformanceData {
    public String appName;
    public long d_endTime;
    public long d_startTime;
    public boolean isSuccess;
    public String msg;
    public long t_endTime;
    public long t_startTime;
    public long task_wait;
    public String type;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum LoadType {
        LOAD_OTHER_ERROR("-2", "OTHER_ERROR"),
        LOAD_FOR_FILE_NOT_FOUND("-1", "LOAD_FOR_FILE_NOT_FOUND"),
        LOAD_NORMAL("0", "ZCache-D"),
        LOAD_LOCAL("1", "ZCache"),
        LOAD_ERROR_VALIDITY("2", "LOAD_ERROR_VALIDITY"),
        LOAD_BAD_RESOURCE("3", "LOAD_BAD_RESOURCE");
        
        private String code;
        private String msg;

        LoadType(String str, String str2) {
            this.code = str;
            this.msg = str2;
        }

        public String getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }
    }
}
