package android.taobao.windvane.util.log;

import androidx.exifinterface.media.ExifInterface;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface ILog {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum LogLevelEnum {
        VERBOSE(0, "V"),
        DEBUG(1, "D"),
        INFO(2, "I"),
        WARNING(3, ExifInterface.LONGITUDE_WEST),
        ERROR(4, ExifInterface.LONGITUDE_EAST);
        
        private int LogLevel;
        private String LogLevelName;

        LogLevelEnum(int i, String str) {
            this.LogLevelName = str;
            this.LogLevel = i;
        }

        public int getLogLevel() {
            return this.LogLevel;
        }

        public String getLogLevelName() {
            return this.LogLevelName;
        }
    }

    void d(String str, String str2);

    void d(String str, String str2, Throwable th);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    void i(String str, String str2);

    void i(String str, String str2, Throwable th);

    boolean isLogLevelEnabled(int i);

    void log(int i, String str, String str2);

    void v(String str, String str2);

    void v(String str, String str2, Throwable th);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th);
}
