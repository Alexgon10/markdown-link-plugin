package com.alexgon.markdown_link_plugin.action.generation;

import static com.alexgon.markdown_link_plugin.utils.StringConverterUtils.*;
import static java.lang.String.format;

public class GenerateTransliteratedLinkBodyAction extends AbstractGenerateLinkAction {

    @Override
    protected boolean withBodyGeneration() {
        return true;
    }

    @Override
    protected String getBody(String selectedText) {
        return format("\n#### %s%s\n```text\n```", PREFIX_CHAR, convertToMdEngLink(selectedText));
    }

    @Override
    protected String getMarkdownLink(String selectedText) {
        String link = convertToMdEngLink(selectedText);
        return format("[%s](#%s%s)", selectedText, PREFIX_CHAR, link);
    }
}
