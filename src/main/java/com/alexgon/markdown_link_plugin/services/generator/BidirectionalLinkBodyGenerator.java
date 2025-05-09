package com.alexgon.markdown_link_plugin.services.generator;

import static com.alexgon.markdown_link_plugin.utils.StringConverterUtils.*;
import static java.lang.String.format;

public class BidirectionalLinkBodyGenerator implements BaseLinkGenerator {

    @Override
    public boolean withBodyGeneration() {
        return true;
    }

    @Override
    public String getBodyText(String selectedText) {
        var link = convertToMdEngLink(selectedText);
        var invertedLink = convertToMdLink(selectedText);
        return format("\n#### [%s%s](#%s)\n```text\n```", PREFIX_CHAR, link, invertedLink);
    }

    @Override
    public String getMarkdownLinkText(String selectedText) {
        String link = convertToMdEngLink(selectedText);
        return format("[%s](#%s%s)", selectedText, PREFIX_CHAR, link);
    }

}