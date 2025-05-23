package com.alexgon.markdown_link_plugin.services.generator;

import static com.alexgon.markdown_link_plugin.utils.StringConverterUtils.PREFIX_CHAR;
import static com.alexgon.markdown_link_plugin.utils.StringConverterUtils.convertToMdLink;
import static java.lang.String.format;

public class LinkBodyGenerator implements BaseLinkGenerator {

    @Override
    public boolean withBodyGeneration() {
        return true;
    }

    @Override
    public String getBodyText(String selectedText) {
        return format("\n#### %s%s\n```text\n```", PREFIX_CHAR, selectedText);
    }

    @Override
    public String getMarkdownLinkText(String selectedText) {
        String link = convertToMdLink(selectedText);
        return format("[%s](#%s%s)", selectedText, PREFIX_CHAR, link);
    }

}