package tb;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class eq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= 'A' && charAt <= 'Z') {
                sb.append((char) ((charAt - 'A') + 97));
            } else if (charAt == '_') {
                sb.append('-');
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String b(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt < 'A' || charAt > 'Z') {
                i++;
            } else {
                StringBuilder sb = new StringBuilder(str.substring(0, i));
                while (true) {
                    int i2 = i + 1;
                    char charAt2 = str.charAt(i);
                    if (charAt2 >= 'A' && charAt2 <= 'Z') {
                        charAt2 = (char) (charAt2 + ' ');
                    }
                    sb.append(charAt2);
                    if (i2 >= length) {
                        return sb.toString();
                    }
                    i = i2;
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(String[] strArr, String str) {
        int length = strArr.length;
        int i = 0;
        if (str == null) {
            while (i < length) {
                if (strArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        String b = b(str);
        while (i < length) {
            if (b.equals(strArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] d(String str, char c) {
        int length = str.length();
        int indexOf = str.indexOf(c, 0);
        int i = 0;
        while (indexOf != -1 && indexOf < length) {
            i++;
            if (indexOf >= 0) {
                indexOf++;
            }
            indexOf = str.indexOf(c, indexOf);
        }
        String[] strArr = new String[i + 1];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int indexOf2 = str.indexOf(c, i2);
            strArr[i3] = str.substring(i2, indexOf2);
            i2 = indexOf2 + 1;
        }
        strArr[i] = str.substring(i2);
        return strArr;
    }
}
