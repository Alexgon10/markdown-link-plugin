package com.alexgon.markdown_link_plugin.services.generator;

import static com.alexgon.markdown_link_plugin.utils.StringConverterUtils.convertToMdLink;

public class LinkGenerator implements BaseLinkGenerator {

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
        String link = convertToMdLink(selectedText);
        return String.format("[%s](#%s)", selectedText, link);
    }
}