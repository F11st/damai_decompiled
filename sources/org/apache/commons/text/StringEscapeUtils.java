package org.apache.commons.text;

import com.ali.user.open.core.model.Constants;
import com.youku.uplayer.AliMediaPlayer;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.util.SymbolExpUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.SocketClient;
import org.apache.commons.text.translate.AggregateTranslator;
import org.apache.commons.text.translate.CharSequenceTranslator;
import org.apache.commons.text.translate.CsvTranslators;
import org.apache.commons.text.translate.EntityArrays;
import org.apache.commons.text.translate.JavaUnicodeEscaper;
import org.apache.commons.text.translate.LookupTranslator;
import org.apache.commons.text.translate.NumericEntityEscaper;
import org.apache.commons.text.translate.NumericEntityUnescaper;
import org.apache.commons.text.translate.OctalUnescaper;
import org.apache.commons.text.translate.UnicodeUnescaper;
import org.apache.commons.text.translate.UnicodeUnpairedSurrogateRemover;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class StringEscapeUtils {
    public static final CharSequenceTranslator ESCAPE_CSV;
    public static final CharSequenceTranslator ESCAPE_ECMASCRIPT;
    public static final CharSequenceTranslator ESCAPE_HTML3;
    public static final CharSequenceTranslator ESCAPE_HTML4;
    public static final CharSequenceTranslator ESCAPE_JAVA;
    public static final CharSequenceTranslator ESCAPE_JSON;
    public static final CharSequenceTranslator ESCAPE_XML10;
    public static final CharSequenceTranslator ESCAPE_XML11;
    public static final CharSequenceTranslator ESCAPE_XSI;
    public static final CharSequenceTranslator UNESCAPE_CSV;
    public static final CharSequenceTranslator UNESCAPE_ECMASCRIPT;
    public static final CharSequenceTranslator UNESCAPE_HTML3;
    public static final CharSequenceTranslator UNESCAPE_HTML4;
    public static final CharSequenceTranslator UNESCAPE_JAVA;
    public static final CharSequenceTranslator UNESCAPE_JSON;
    public static final CharSequenceTranslator UNESCAPE_XML;
    public static final CharSequenceTranslator UNESCAPE_XSI;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Builder {
        private final StringBuilder sb;
        private final CharSequenceTranslator translator;

        public Builder append(String str) {
            this.sb.append(str);
            return this;
        }

        public Builder escape(String str) {
            this.sb.append(this.translator.translate(str));
            return this;
        }

        public String toString() {
            return this.sb.toString();
        }

        private Builder(CharSequenceTranslator charSequenceTranslator) {
            this.sb = new StringBuilder();
            this.translator = charSequenceTranslator;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    static class XsiUnescaper extends CharSequenceTranslator {
        private static final char BACKSLASH = '\\';

        XsiUnescaper() {
        }

        @Override // org.apache.commons.text.translate.CharSequenceTranslator
        public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
            if (i == 0) {
                String charSequence2 = charSequence.toString();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int indexOf = charSequence2.indexOf(92, i2);
                    if (indexOf == -1) {
                        break;
                    }
                    if (indexOf > i3) {
                        writer.write(charSequence2.substring(i3, indexOf));
                    }
                    i3 = indexOf + 1;
                    i2 = indexOf + 2;
                }
                if (i3 < charSequence2.length()) {
                    writer.write(charSequence2.substring(i3));
                }
                return Character.codePointCount(charSequence, 0, charSequence.length());
            }
            throw new IllegalStateException("XsiUnescaper should never reach the [1] index");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("\"", "\\\"");
        hashMap.put("\\", "\\\\");
        Map<CharSequence, CharSequence> map = EntityArrays.JAVA_CTRL_CHARS_ESCAPE;
        ESCAPE_JAVA = new AggregateTranslator(new LookupTranslator(Collections.unmodifiableMap(hashMap)), new LookupTranslator(map), JavaUnicodeEscaper.outsideOf(32, 127));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("'", "\\'");
        hashMap2.put("\"", "\\\"");
        hashMap2.put("\\", "\\\\");
        hashMap2.put("/", "\\/");
        ESCAPE_ECMASCRIPT = new AggregateTranslator(new LookupTranslator(Collections.unmodifiableMap(hashMap2)), new LookupTranslator(map), JavaUnicodeEscaper.outsideOf(32, 127));
        HashMap hashMap3 = new HashMap();
        hashMap3.put("\"", "\\\"");
        hashMap3.put("\\", "\\\\");
        hashMap3.put("/", "\\/");
        ESCAPE_JSON = new AggregateTranslator(new LookupTranslator(Collections.unmodifiableMap(hashMap3)), new LookupTranslator(map), JavaUnicodeEscaper.outsideOf(32, 127));
        HashMap hashMap4 = new HashMap();
        hashMap4.put("\u0000", "");
        hashMap4.put("\u0001", "");
        hashMap4.put("\u0002", "");
        hashMap4.put("\u0003", "");
        hashMap4.put("\u0004", "");
        hashMap4.put(Constants.COOKIE_SPLIT, "");
        hashMap4.put("\u0006", "");
        hashMap4.put("\u0007", "");
        hashMap4.put("\b", "");
        hashMap4.put("\u000b", "");
        hashMap4.put("\f", "");
        hashMap4.put("\u000e", "");
        hashMap4.put("\u000f", "");
        hashMap4.put("\u0010", "");
        hashMap4.put("\u0011", "");
        hashMap4.put("\u0012", "");
        hashMap4.put("\u0013", "");
        hashMap4.put("\u0014", "");
        hashMap4.put("\u0015", "");
        hashMap4.put("\u0016", "");
        hashMap4.put("\u0017", "");
        hashMap4.put("\u0018", "");
        hashMap4.put("\u0019", "");
        hashMap4.put("\u001a", "");
        hashMap4.put("\u001b", "");
        hashMap4.put("\u001c", "");
        hashMap4.put("\u001d", "");
        hashMap4.put("\u001e", "");
        hashMap4.put("\u001f", "");
        hashMap4.put("\ufffe", "");
        hashMap4.put("\uffff", "");
        Map<CharSequence, CharSequence> map2 = EntityArrays.BASIC_ESCAPE;
        Map<CharSequence, CharSequence> map3 = EntityArrays.APOS_ESCAPE;
        ESCAPE_XML10 = new AggregateTranslator(new LookupTranslator(map2), new LookupTranslator(map3), new LookupTranslator(Collections.unmodifiableMap(hashMap4)), NumericEntityEscaper.between(127, 132), NumericEntityEscaper.between(134, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_ADAPT_SPEED_MAX_SAFE_BUFFER_FACTOR), new UnicodeUnpairedSurrogateRemover());
        HashMap hashMap5 = new HashMap();
        hashMap5.put("\u0000", "");
        hashMap5.put("\u000b", "&#11;");
        hashMap5.put("\f", "&#12;");
        hashMap5.put("\ufffe", "");
        hashMap5.put("\uffff", "");
        ESCAPE_XML11 = new AggregateTranslator(new LookupTranslator(map2), new LookupTranslator(map3), new LookupTranslator(Collections.unmodifiableMap(hashMap5)), NumericEntityEscaper.between(1, 8), NumericEntityEscaper.between(14, 31), NumericEntityEscaper.between(127, 132), NumericEntityEscaper.between(134, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_ADAPT_SPEED_MAX_SAFE_BUFFER_FACTOR), new UnicodeUnpairedSurrogateRemover());
        Map<CharSequence, CharSequence> map4 = EntityArrays.ISO8859_1_ESCAPE;
        ESCAPE_HTML3 = new AggregateTranslator(new LookupTranslator(map2), new LookupTranslator(map4));
        ESCAPE_HTML4 = new AggregateTranslator(new LookupTranslator(map2), new LookupTranslator(map4), new LookupTranslator(EntityArrays.HTML40_EXTENDED_ESCAPE));
        ESCAPE_CSV = new CsvTranslators.CsvEscaper();
        HashMap hashMap6 = new HashMap();
        hashMap6.put("|", SymbolExpUtil.SYMBOL_VERTICALBAR);
        hashMap6.put("&", "\\&");
        hashMap6.put(";", "\\;");
        hashMap6.put(jn1.L, "\\<");
        hashMap6.put(jn1.G, "\\>");
        hashMap6.put(jn1.BRACKET_START_STR, "\\(");
        hashMap6.put(jn1.BRACKET_END_STR, "\\)");
        hashMap6.put("$", "\\$");
        hashMap6.put("`", "\\`");
        hashMap6.put("\\", "\\\\");
        hashMap6.put("\"", "\\\"");
        hashMap6.put("'", "\\'");
        hashMap6.put(" ", "\\ ");
        hashMap6.put("\t", "\\\t");
        hashMap6.put(SocketClient.NETASCII_EOL, "");
        hashMap6.put(StringUtils.LF, "");
        hashMap6.put(jn1.MUL, "\\*");
        hashMap6.put("?", "\\?");
        hashMap6.put(jn1.ARRAY_START_STR, "\\[");
        hashMap6.put(com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX, "\\#");
        hashMap6.put(com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR, "\\~");
        hashMap6.put("=", "\\=");
        hashMap6.put("%", "\\%");
        ESCAPE_XSI = new LookupTranslator(Collections.unmodifiableMap(hashMap6));
        HashMap hashMap7 = new HashMap();
        hashMap7.put("\\\\", "\\");
        hashMap7.put("\\\"", "\"");
        hashMap7.put("\\'", "'");
        hashMap7.put("\\", "");
        Map<CharSequence, CharSequence> map5 = EntityArrays.JAVA_CTRL_CHARS_UNESCAPE;
        AggregateTranslator aggregateTranslator = new AggregateTranslator(new OctalUnescaper(), new UnicodeUnescaper(), new LookupTranslator(map5), new LookupTranslator(Collections.unmodifiableMap(hashMap7)));
        UNESCAPE_JAVA = aggregateTranslator;
        UNESCAPE_ECMASCRIPT = aggregateTranslator;
        UNESCAPE_JSON = new AggregateTranslator(new OctalUnescaper(), new UnicodeUnescaper(), new LookupTranslator(map5));
        Map<CharSequence, CharSequence> map6 = EntityArrays.BASIC_UNESCAPE;
        Map<CharSequence, CharSequence> map7 = EntityArrays.ISO8859_1_UNESCAPE;
        UNESCAPE_HTML3 = new AggregateTranslator(new LookupTranslator(map6), new LookupTranslator(map7), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        UNESCAPE_HTML4 = new AggregateTranslator(new LookupTranslator(map6), new LookupTranslator(map7), new LookupTranslator(EntityArrays.HTML40_EXTENDED_UNESCAPE), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        UNESCAPE_XML = new AggregateTranslator(new LookupTranslator(map6), new LookupTranslator(EntityArrays.APOS_UNESCAPE), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        UNESCAPE_CSV = new CsvTranslators.CsvUnescaper();
        UNESCAPE_XSI = new XsiUnescaper();
    }

    public static Builder builder(CharSequenceTranslator charSequenceTranslator) {
        return new Builder(charSequenceTranslator);
    }

    public static final String escapeCsv(String str) {
        return ESCAPE_CSV.translate(str);
    }

    public static final String escapeEcmaScript(String str) {
        return ESCAPE_ECMASCRIPT.translate(str);
    }

    public static final String escapeHtml3(String str) {
        return ESCAPE_HTML3.translate(str);
    }

    public static final String escapeHtml4(String str) {
        return ESCAPE_HTML4.translate(str);
    }

    public static final String escapeJava(String str) {
        return ESCAPE_JAVA.translate(str);
    }

    public static final String escapeJson(String str) {
        return ESCAPE_JSON.translate(str);
    }

    public static final String escapeXSI(String str) {
        return ESCAPE_XSI.translate(str);
    }

    public static String escapeXml10(String str) {
        return ESCAPE_XML10.translate(str);
    }

    public static String escapeXml11(String str) {
        return ESCAPE_XML11.translate(str);
    }

    public static final String unescapeCsv(String str) {
        return UNESCAPE_CSV.translate(str);
    }

    public static final String unescapeEcmaScript(String str) {
        return UNESCAPE_ECMASCRIPT.translate(str);
    }

    public static final String unescapeHtml3(String str) {
        return UNESCAPE_HTML3.translate(str);
    }

    public static final String unescapeHtml4(String str) {
        return UNESCAPE_HTML4.translate(str);
    }

    public static final String unescapeJava(String str) {
        return UNESCAPE_JAVA.translate(str);
    }

    public static final String unescapeJson(String str) {
        return UNESCAPE_JSON.translate(str);
    }

    public static final String unescapeXSI(String str) {
        return UNESCAPE_XSI.translate(str);
    }

    public static final String unescapeXml(String str) {
        return UNESCAPE_XML.translate(str);
    }
}
