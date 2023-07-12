package org.apache.commons.text.translate;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class CsvTranslators {
    private static final char CSV_DELIMITER = ',';
    private static final String CSV_ESCAPED_QUOTE_STR;
    private static final char CSV_QUOTE = '\"';
    private static final String CSV_QUOTE_STR;
    private static final char[] CSV_SEARCH_CHARS;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class CsvEscaper extends SinglePassTranslator {
        @Override // org.apache.commons.text.translate.SinglePassTranslator, org.apache.commons.text.translate.CharSequenceTranslator
        public /* bridge */ /* synthetic */ int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
            return super.translate(charSequence, i, writer);
        }

        @Override // org.apache.commons.text.translate.SinglePassTranslator
        void translateWhole(CharSequence charSequence, Writer writer) throws IOException {
            String charSequence2 = charSequence.toString();
            if (StringUtils.containsNone(charSequence2, CsvTranslators.CSV_SEARCH_CHARS)) {
                writer.write(charSequence2);
                return;
            }
            writer.write(34);
            writer.write(StringUtils.replace(charSequence2, CsvTranslators.CSV_QUOTE_STR, CsvTranslators.CSV_ESCAPED_QUOTE_STR));
            writer.write(34);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class CsvUnescaper extends SinglePassTranslator {
        @Override // org.apache.commons.text.translate.SinglePassTranslator, org.apache.commons.text.translate.CharSequenceTranslator
        public /* bridge */ /* synthetic */ int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
            return super.translate(charSequence, i, writer);
        }

        @Override // org.apache.commons.text.translate.SinglePassTranslator
        void translateWhole(CharSequence charSequence, Writer writer) throws IOException {
            if (charSequence.charAt(0) == '\"' && charSequence.charAt(charSequence.length() - 1) == '\"') {
                String charSequence2 = charSequence.subSequence(1, charSequence.length() - 1).toString();
                if (StringUtils.containsAny(charSequence2, CsvTranslators.CSV_SEARCH_CHARS)) {
                    writer.write(StringUtils.replace(charSequence2, CsvTranslators.CSV_ESCAPED_QUOTE_STR, CsvTranslators.CSV_QUOTE_STR));
                    return;
                } else {
                    writer.write(charSequence.toString());
                    return;
                }
            }
            writer.write(charSequence.toString());
        }
    }

    static {
        String valueOf = String.valueOf('\"');
        CSV_QUOTE_STR = valueOf;
        CSV_ESCAPED_QUOTE_STR = valueOf + valueOf;
        CSV_SEARCH_CHARS = new char[]{',', '\"', CharUtils.CR, '\n'};
    }

    private CsvTranslators() {
    }
}
