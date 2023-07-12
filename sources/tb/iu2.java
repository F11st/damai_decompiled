package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class iu2 {
    public String arg;
    public String disk_size;
    public long elapsed_time;
    public String errorCode;
    public String errorMsg;
    public String fromVersion;
    public boolean success;
    public String toVersion;
    public String url;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof iu2) {
            iu2 iu2Var = (iu2) obj;
            if (this.success == iu2Var.success && this.arg.equals(iu2Var.arg) && this.fromVersion.equals(iu2Var.fromVersion)) {
                return this.toVersion.equals(iu2Var.toVersion);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.success ? 1 : 0) * 31) + this.arg.hashCode()) * 31) + this.fromVersion.hashCode()) * 31) + this.toVersion.hashCode();
    }
}
