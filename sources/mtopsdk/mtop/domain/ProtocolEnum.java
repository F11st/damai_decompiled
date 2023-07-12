package mtopsdk.mtop.domain;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum ProtocolEnum {
    HTTP("http://"),
    HTTPSECURE("https://");
    
    private String protocol;

    ProtocolEnum(String str) {
        this.protocol = str;
    }

    public String getProtocol() {
        return this.protocol;
    }
}
