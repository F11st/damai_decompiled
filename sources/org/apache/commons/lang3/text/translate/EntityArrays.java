package org.apache.commons.lang3.text.translate;

import java.lang.reflect.Array;
import org.apache.commons.lang3.StringUtils;
import tb.jn1;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes2.dex */
public class EntityArrays {
    private static final String[][] APOS_ESCAPE;
    private static final String[][] APOS_UNESCAPE;
    private static final String[][] BASIC_ESCAPE;
    private static final String[][] BASIC_UNESCAPE;
    private static final String[][] HTML40_EXTENDED_ESCAPE;
    private static final String[][] HTML40_EXTENDED_UNESCAPE;
    private static final String[][] ISO8859_1_ESCAPE;
    private static final String[][] ISO8859_1_UNESCAPE;
    private static final String[][] JAVA_CTRL_CHARS_ESCAPE;
    private static final String[][] JAVA_CTRL_CHARS_UNESCAPE;

    static {
        String[][] strArr = {new String[]{" ", "&nbsp;"}, new String[]{"¡", "&iexcl;"}, new String[]{"¢", "&cent;"}, new String[]{"£", "&pound;"}, new String[]{"¤", "&curren;"}, new String[]{"¥", "&yen;"}, new String[]{"¦", "&brvbar;"}, new String[]{"§", "&sect;"}, new String[]{"¨", "&uml;"}, new String[]{"©", "&copy;"}, new String[]{"ª", "&ordf;"}, new String[]{"«", "&laquo;"}, new String[]{"¬", "&not;"}, new String[]{"\u00ad", "&shy;"}, new String[]{"®", "&reg;"}, new String[]{"¯", "&macr;"}, new String[]{"°", "&deg;"}, new String[]{"±", "&plusmn;"}, new String[]{"²", "&sup2;"}, new String[]{"³", "&sup3;"}, new String[]{"´", "&acute;"}, new String[]{"µ", "&micro;"}, new String[]{"¶", "&para;"}, new String[]{"·", "&middot;"}, new String[]{"¸", "&cedil;"}, new String[]{"¹", "&sup1;"}, new String[]{"º", "&ordm;"}, new String[]{"»", "&raquo;"}, new String[]{"¼", "&frac14;"}, new String[]{"½", "&frac12;"}, new String[]{"¾", "&frac34;"}, new String[]{"¿", "&iquest;"}, new String[]{"À", "&Agrave;"}, new String[]{"Á", "&Aacute;"}, new String[]{"Â", "&Acirc;"}, new String[]{"Ã", "&Atilde;"}, new String[]{"Ä", "&Auml;"}, new String[]{"Å", "&Aring;"}, new String[]{"Æ", "&AElig;"}, new String[]{"Ç", "&Ccedil;"}, new String[]{"È", "&Egrave;"}, new String[]{"É", "&Eacute;"}, new String[]{"Ê", "&Ecirc;"}, new String[]{"Ë", "&Euml;"}, new String[]{"Ì", "&Igrave;"}, new String[]{"Í", "&Iacute;"}, new String[]{"Î", "&Icirc;"}, new String[]{"Ï", "&Iuml;"}, new String[]{"Ð", "&ETH;"}, new String[]{"Ñ", "&Ntilde;"}, new String[]{"Ò", "&Ograve;"}, new String[]{"Ó", "&Oacute;"}, new String[]{"Ô", "&Ocirc;"}, new String[]{"Õ", "&Otilde;"}, new String[]{"Ö", "&Ouml;"}, new String[]{"×", "&times;"}, new String[]{"Ø", "&Oslash;"}, new String[]{"Ù", "&Ugrave;"}, new String[]{"Ú", "&Uacute;"}, new String[]{"Û", "&Ucirc;"}, new String[]{"Ü", "&Uuml;"}, new String[]{"Ý", "&Yacute;"}, new String[]{"Þ", "&THORN;"}, new String[]{"ß", "&szlig;"}, new String[]{"à", "&agrave;"}, new String[]{"á", "&aacute;"}, new String[]{"â", "&acirc;"}, new String[]{"ã", "&atilde;"}, new String[]{"ä", "&auml;"}, new String[]{"å", "&aring;"}, new String[]{"æ", "&aelig;"}, new String[]{"ç", "&ccedil;"}, new String[]{"è", "&egrave;"}, new String[]{"é", "&eacute;"}, new String[]{"ê", "&ecirc;"}, new String[]{"ë", "&euml;"}, new String[]{"ì", "&igrave;"}, new String[]{"í", "&iacute;"}, new String[]{"î", "&icirc;"}, new String[]{"ï", "&iuml;"}, new String[]{"ð", "&eth;"}, new String[]{"ñ", "&ntilde;"}, new String[]{"ò", "&ograve;"}, new String[]{"ó", "&oacute;"}, new String[]{"ô", "&ocirc;"}, new String[]{"õ", "&otilde;"}, new String[]{"ö", "&ouml;"}, new String[]{"÷", "&divide;"}, new String[]{"ø", "&oslash;"}, new String[]{"ù", "&ugrave;"}, new String[]{"ú", "&uacute;"}, new String[]{"û", "&ucirc;"}, new String[]{"ü", "&uuml;"}, new String[]{"ý", "&yacute;"}, new String[]{"þ", "&thorn;"}, new String[]{"ÿ", "&yuml;"}};
        ISO8859_1_ESCAPE = strArr;
        ISO8859_1_UNESCAPE = invert(strArr);
        String[][] strArr2 = {new String[]{"ƒ", "&fnof;"}, new String[]{"Α", "&Alpha;"}, new String[]{"Β", "&Beta;"}, new String[]{"Γ", "&Gamma;"}, new String[]{"Δ", "&Delta;"}, new String[]{"Ε", "&Epsilon;"}, new String[]{"Ζ", "&Zeta;"}, new String[]{"Η", "&Eta;"}, new String[]{"Θ", "&Theta;"}, new String[]{"Ι", "&Iota;"}, new String[]{"Κ", "&Kappa;"}, new String[]{"Λ", "&Lambda;"}, new String[]{"Μ", "&Mu;"}, new String[]{"Ν", "&Nu;"}, new String[]{"Ξ", "&Xi;"}, new String[]{"Ο", "&Omicron;"}, new String[]{"Π", "&Pi;"}, new String[]{"Ρ", "&Rho;"}, new String[]{"Σ", "&Sigma;"}, new String[]{"Τ", "&Tau;"}, new String[]{"Υ", "&Upsilon;"}, new String[]{"Φ", "&Phi;"}, new String[]{"Χ", "&Chi;"}, new String[]{"Ψ", "&Psi;"}, new String[]{"Ω", "&Omega;"}, new String[]{"α", "&alpha;"}, new String[]{"β", "&beta;"}, new String[]{"γ", "&gamma;"}, new String[]{"δ", "&delta;"}, new String[]{"ε", "&epsilon;"}, new String[]{"ζ", "&zeta;"}, new String[]{"η", "&eta;"}, new String[]{"θ", "&theta;"}, new String[]{"ι", "&iota;"}, new String[]{"κ", "&kappa;"}, new String[]{"λ", "&lambda;"}, new String[]{"μ", "&mu;"}, new String[]{"ν", "&nu;"}, new String[]{"ξ", "&xi;"}, new String[]{"ο", "&omicron;"}, new String[]{"π", "&pi;"}, new String[]{"ρ", "&rho;"}, new String[]{"ς", "&sigmaf;"}, new String[]{"σ", "&sigma;"}, new String[]{"τ", "&tau;"}, new String[]{"υ", "&upsilon;"}, new String[]{"φ", "&phi;"}, new String[]{"χ", "&chi;"}, new String[]{"ψ", "&psi;"}, new String[]{"ω", "&omega;"}, new String[]{"ϑ", "&thetasym;"}, new String[]{"ϒ", "&upsih;"}, new String[]{"ϖ", "&piv;"}, new String[]{"•", "&bull;"}, new String[]{"…", "&hellip;"}, new String[]{"′", "&prime;"}, new String[]{"″", "&Prime;"}, new String[]{"‾", "&oline;"}, new String[]{"⁄", "&frasl;"}, new String[]{"℘", "&weierp;"}, new String[]{"ℑ", "&image;"}, new String[]{"ℜ", "&real;"}, new String[]{"™", "&trade;"}, new String[]{"ℵ", "&alefsym;"}, new String[]{"←", "&larr;"}, new String[]{"↑", "&uarr;"}, new String[]{"→", "&rarr;"}, new String[]{"↓", "&darr;"}, new String[]{"↔", "&harr;"}, new String[]{"↵", "&crarr;"}, new String[]{"⇐", "&lArr;"}, new String[]{"⇑", "&uArr;"}, new String[]{"⇒", "&rArr;"}, new String[]{"⇓", "&dArr;"}, new String[]{"⇔", "&hArr;"}, new String[]{"∀", "&forall;"}, new String[]{"∂", "&part;"}, new String[]{"∃", "&exist;"}, new String[]{"∅", "&empty;"}, new String[]{"∇", "&nabla;"}, new String[]{"∈", "&isin;"}, new String[]{"∉", "&notin;"}, new String[]{"∋", "&ni;"}, new String[]{"∏", "&prod;"}, new String[]{"∑", "&sum;"}, new String[]{"−", "&minus;"}, new String[]{"∗", "&lowast;"}, new String[]{"√", "&radic;"}, new String[]{"∝", "&prop;"}, new String[]{"∞", "&infin;"}, new String[]{"∠", "&ang;"}, new String[]{"∧", "&and;"}, new String[]{"∨", "&or;"}, new String[]{"∩", "&cap;"}, new String[]{"∪", "&cup;"}, new String[]{"∫", "&int;"}, new String[]{"∴", "&there4;"}, new String[]{"∼", "&sim;"}, new String[]{"≅", "&cong;"}, new String[]{"≈", "&asymp;"}, new String[]{"≠", "&ne;"}, new String[]{"≡", "&equiv;"}, new String[]{"≤", "&le;"}, new String[]{"≥", "&ge;"}, new String[]{"⊂", "&sub;"}, new String[]{"⊃", "&sup;"}, new String[]{"⊄", "&nsub;"}, new String[]{"⊆", "&sube;"}, new String[]{"⊇", "&supe;"}, new String[]{"⊕", "&oplus;"}, new String[]{"⊗", "&otimes;"}, new String[]{"⊥", "&perp;"}, new String[]{"⋅", "&sdot;"}, new String[]{"⌈", "&lceil;"}, new String[]{"⌉", "&rceil;"}, new String[]{"⌊", "&lfloor;"}, new String[]{"⌋", "&rfloor;"}, new String[]{"〈", "&lang;"}, new String[]{"〉", "&rang;"}, new String[]{"◊", "&loz;"}, new String[]{"♠", "&spades;"}, new String[]{"♣", "&clubs;"}, new String[]{"♥", "&hearts;"}, new String[]{"♦", "&diams;"}, new String[]{"Œ", "&OElig;"}, new String[]{"œ", "&oelig;"}, new String[]{"Š", "&Scaron;"}, new String[]{"š", "&scaron;"}, new String[]{"Ÿ", "&Yuml;"}, new String[]{"ˆ", "&circ;"}, new String[]{"˜", "&tilde;"}, new String[]{"\u2002", "&ensp;"}, new String[]{"\u2003", "&emsp;"}, new String[]{"\u2009", "&thinsp;"}, new String[]{"\u200c", "&zwnj;"}, new String[]{"\u200d", "&zwj;"}, new String[]{"\u200e", "&lrm;"}, new String[]{"\u200f", "&rlm;"}, new String[]{"–", "&ndash;"}, new String[]{"—", "&mdash;"}, new String[]{"‘", "&lsquo;"}, new String[]{"’", "&rsquo;"}, new String[]{"‚", "&sbquo;"}, new String[]{"“", "&ldquo;"}, new String[]{"”", "&rdquo;"}, new String[]{"„", "&bdquo;"}, new String[]{"†", "&dagger;"}, new String[]{"‡", "&Dagger;"}, new String[]{"‰", "&permil;"}, new String[]{"‹", "&lsaquo;"}, new String[]{"›", "&rsaquo;"}, new String[]{"€", "&euro;"}};
        HTML40_EXTENDED_ESCAPE = strArr2;
        HTML40_EXTENDED_UNESCAPE = invert(strArr2);
        String[][] strArr3 = {new String[]{"\"", "&quot;"}, new String[]{"&", "&amp;"}, new String[]{jn1.L, "&lt;"}, new String[]{jn1.G, "&gt;"}};
        BASIC_ESCAPE = strArr3;
        BASIC_UNESCAPE = invert(strArr3);
        String[][] strArr4 = {new String[]{"'", "&apos;"}};
        APOS_ESCAPE = strArr4;
        APOS_UNESCAPE = invert(strArr4);
        String[][] strArr5 = {new String[]{"\b", "\\b"}, new String[]{StringUtils.LF, "\\n"}, new String[]{"\t", "\\t"}, new String[]{"\f", "\\f"}, new String[]{StringUtils.CR, "\\r"}};
        JAVA_CTRL_CHARS_ESCAPE = strArr5;
        JAVA_CTRL_CHARS_UNESCAPE = invert(strArr5);
    }

    public static String[][] APOS_ESCAPE() {
        return (String[][]) APOS_ESCAPE.clone();
    }

    public static String[][] APOS_UNESCAPE() {
        return (String[][]) APOS_UNESCAPE.clone();
    }

    public static String[][] BASIC_ESCAPE() {
        return (String[][]) BASIC_ESCAPE.clone();
    }

    public static String[][] BASIC_UNESCAPE() {
        return (String[][]) BASIC_UNESCAPE.clone();
    }

    public static String[][] HTML40_EXTENDED_ESCAPE() {
        return (String[][]) HTML40_EXTENDED_ESCAPE.clone();
    }

    public static String[][] HTML40_EXTENDED_UNESCAPE() {
        return (String[][]) HTML40_EXTENDED_UNESCAPE.clone();
    }

    public static String[][] ISO8859_1_ESCAPE() {
        return (String[][]) ISO8859_1_ESCAPE.clone();
    }

    public static String[][] ISO8859_1_UNESCAPE() {
        return (String[][]) ISO8859_1_UNESCAPE.clone();
    }

    public static String[][] JAVA_CTRL_CHARS_ESCAPE() {
        return (String[][]) JAVA_CTRL_CHARS_ESCAPE.clone();
    }

    public static String[][] JAVA_CTRL_CHARS_UNESCAPE() {
        return (String[][]) JAVA_CTRL_CHARS_UNESCAPE.clone();
    }

    public static String[][] invert(String[][] strArr) {
        String[][] strArr2 = (String[][]) Array.newInstance(String.class, strArr.length, 2);
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i][0] = strArr[i][1];
            strArr2[i][1] = strArr[i][0];
        }
        return strArr2;
    }
}
