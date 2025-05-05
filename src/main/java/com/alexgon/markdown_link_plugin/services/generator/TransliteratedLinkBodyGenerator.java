package com.alexgon.markdown_link_plugin.services.generator;

import static com.alexgon.markdown_link_plugin.utils.StringConverterUtils.PREFIX_CHAR;
import static com.alexgon.markdown_link_plugin.utils.StringConverterUtils.convertToMdEngLink;
import static java.lang.String.format;

public class TransliteratedLinkBodyGenerator implements BaseLinkGenerator {

    @Override
    public boolean withBodyGeneration() {
        return true;
    }

    @Override
    public String getBodyText(String selectedText) {
        return format("\n#### %s%s\n```text\n```", PREFIX_CHAR, convertToMdEngLink(selectedText));
    }

    @Override
    public String getMarkdownLinkText(String selectedText) {
        String link = convertToMdEngLink(selectedText);
        return format("[%s](#%s%s)", selectedText, PREFIX_CHAR, link);
    }
}
