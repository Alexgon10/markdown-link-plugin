package com.alexgon.markdown_link_plugin.utils;

import java.util.HashMap;
import java.util.Map;

public class TransliterationUtils {

    private static final Map<Character, String> TRANSLIT_MAP = new HashMap<>();

    static {
        // Русская транслитерация (можно расширить по необходимости)
        TRANSLIT_MAP.put('а', "a");
        TRANSLIT_MAP.put('б', "b");
        TRANSLIT_MAP.put('в', "v");
        TRANSLIT_MAP.put('г', "g");
        TRANSLIT_MAP.put('д', "d");
        TRANSLIT_MAP.put('е', "e");
        TRANSLIT_MAP.put('ё', "yo");
        TRANSLIT_MAP.put('ж', "zh");
        TRANSLIT_MAP.put('з', "z");
        TRANSLIT_MAP.put('и', "i");
        TRANSLIT_MAP.put('й', "y");
        TRANSLIT_MAP.put('к', "k");
        TRANSLIT_MAP.put('л', "l");
        TRANSLIT_MAP.put('м', "m");
        TRANSLIT_MAP.put('н', "n");
        TRANSLIT_MAP.put('о', "o");
        TRANSLIT_MAP.put('п', "p");
        TRANSLIT_MAP.put('р', "r");
        TRANSLIT_MAP.put('с', "s");
        TRANSLIT_MAP.put('т', "t");
        TRANSLIT_MAP.put('у', "u");
        TRANSLIT_MAP.put('ф', "f");
        TRANSLIT_MAP.put('х', "kh");
        TRANSLIT_MAP.put('ц', "ts");
        TRANSLIT_MAP.put('ч', "ch");
        TRANSLIT_MAP.put('ш', "sh");
        TRANSLIT_MAP.put('щ', "shch");
        TRANSLIT_MAP.put('ъ', "");
        TRANSLIT_MAP.put('ы', "y");
        TRANSLIT_MAP.put('ь', "");
        TRANSLIT_MAP.put('э', "e");
        TRANSLIT_MAP.put('ю', "yu");
        TRANSLIT_MAP.put('я', "ya");
    }

    /**
     * Преобразует текст в ссылку с транслитерацией русского текста
     * Пример: "Привет, мир! (Русский текст)" → "privet-mir-russkij-tekst"
     */
    public static String convertToTranslit(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        // Приводим к нижнему регистру
        String lowerCase = text.toLowerCase();

        // Транслитерируем русские символы
        StringBuilder transliterated = new StringBuilder();
        for (char c : lowerCase.toCharArray()) {
            if (TRANSLIT_MAP.containsKey(c)) {
                transliterated.append(TRANSLIT_MAP.get(c));
            } else {
                transliterated.append(c);
            }
        }

        return transliterated.toString().trim();
    }

}
