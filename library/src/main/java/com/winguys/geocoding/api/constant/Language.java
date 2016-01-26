package com.winguys.geocoding.api.constant;

/**
 * Created by Stafiiyevskyi on 22.01.2016.
 */
public enum Language {

    ARABIC("ar"),
    BULGARIAN("bg"),
    BENGALI("bn"),
    CATALAN("ca"),
    CHINESE_SIMPLIFIED("zh-CN"),
    CHINESE_TRADITIONAL("zh-TW"),
    CZECH("cs"),
    DANISH("da"),
    GERMAN("de"),
    GREEK("el"),
    ENGLISH("en"),
    ENGLISH_AUSTRALIAN("en-AU"),
    ENGLISH_GREAT_BRITAIN("en-GB"),
    SPANISH("es"),
    BASQUE("eu"),
    FARSI("fa"),
    FINNISH("fi"),
    FILIPINO("fil"),
    FRENCH("fr"),
    GALICIAN("gl"),
    GUJARATI("gu"),
    HINDI("hi"),
    CROATIAN("hr"),
    HUNGARIAN("hu"),
    INDONESIAN("id"),
    ITALIAN("it"),
    HEBREW("iw"),
    JAPANESE("ja"),
    KANNADA("kn"),
    KOREAN("ko"),
    LITHUANIAN("lt"),
    LATVIAN("lv"),
    MALAYALAM("ml"),
    MARATHI("mr"),
    DUTCH("nl"),
    NORWEGIAN("no"),
    POLISH("pl"),
    PORTUGUESE("pt"),
    PORTUGUESE_BRAZIL("pt-BR"),
    PORTUGUESE_PORTUGAL("pt-PT"),
    ROMANIAN("rp"),
    RUSSIAN("ru"),
    SLOVAK("sk"),
    SLOVENIAN("sl"),
    SERBIAN("sr"),
    SWEDISH("sv"),
    TAMIL("ta"),
    TELUGU("te"),
    THAI("th"),
    TAGALOG("tl"),
    TURKISH("tr"),
    UKRAINIAN("uk"),
    VIETNAMESE("vi");


    final String param;

    Language(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }
}
