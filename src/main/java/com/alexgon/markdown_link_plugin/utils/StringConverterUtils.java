package com.alexgon.markdown_link_plugin.utils;

import java.text.Normalizer;

public class StringConverterUtils {

    private static final String ENG_PATTERN = "[^a-zA-Z0-9\\s-]";
    private static final String RUS_PATTERN = "[^а-яЁА-ЯЁa-zA-Z0-9\\s-]";

    public static String convertToMdEngLink(String text) {
        return commonConverting(
                TransliterationUtils.convertToTranslit(
                        preConverting(text)
                ));
    }

    public static String convertToMdLink(String text) {
        return commonConverting(
                preConverting(text));
    }


    private static String preConverting(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        return Normalizer.normalize(text, Normalizer.Form.NFD);
    }


    private static String commonConverting(String text) {

        return text
                .replaceAll(RUS_PATTERN, " ")
                .toLowerCase()
                .replaceAll("\\s+", "-")
                .replaceAll("-+", "-")
                .replaceAll("^-|-$", "");
    }
}
