package com.alexgon.markdown_link_plugin.services.generator;

import static com.alexgon.markdown_link_plugin.utils.StringConverterUtils.convertToMdEngLink;

public class TransliteratedLinkGenerator implements BaseLinkGenerator {

    @Override
    public boolean withBodyGeneration() {
        return false;
    }

    @Override
    public String getBodyText(String selectedText) {
        throw new UnsupportedOperationException("Not supported body.");
    }

    @Override
    public String getMarkdownLinkText(String selectedText) {
        String link = convertToMdEngLink(selectedText);
        return String.format("[%s](#%s)", selectedText, link);
    }
}
