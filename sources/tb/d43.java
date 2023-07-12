package tb;

import com.heytap.mcssdk.constant.MessageConstant$MessageType;
import com.heytap.msp.push.mode.BaseMode;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class d43 extends BaseMode {
    private String a;
    private String b;
    private int c;
    private String d;
    private int e = -2;
    private String f;

    public static <T> String a(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (T t : list) {
            sb.append(t);
            sb.append("&");
        }
        return sb.toString();
    }

    public void b(int i) {
        this.c = i;
    }

    public void c(String str) {
    }

    public void d(int i) {
        this.e = i;
    }

    public void e(String str) {
    }

    public int f() {
        return this.c;
    }

    public void g(String str) {
        this.d = str;
    }

    @Override // com.heytap.msp.push.mode.BaseMode
    public int getType() {
        return MessageConstant$MessageType.MESSAGE_CALL_BACK;
    }

    public String h() {
        return this.d;
    }

    public void i(String str) {
        this.f = str;
    }

    public int j() {
        return this.e;
    }

    public String toString() {
        return "CallBackResult{, mRegisterID='" + this.a + "', mSdkVersion='" + this.b + "', mCommand=" + this.c + "', mContent='" + this.d + "', mAppPackage=" + this.f + "', mResponseCode=" + this.e + '}';
    }
}
