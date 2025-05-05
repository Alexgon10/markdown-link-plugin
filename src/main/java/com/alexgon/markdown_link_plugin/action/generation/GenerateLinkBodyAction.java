package com.alexgon.markdown_link_plugin.action.generation;

import static com.alexgon.markdown_link_plugin.utils.StringConverterUtils.PREFIX_CHAR;
import static com.alexgon.markdown_link_plugin.utils.StringConverterUtils.convertToMdLink;
import static java.lang.String.format;

public class GenerateLinkBodyAction extends AbstractGenerateLinkAction {


    @Override
    protected boolean withBodyGeneration() {
        return true;
    }

    @Override
    protected String getBody(String selectedText) {
        return format("\n#### %s%s\n```text\n```", PREFIX_CHAR, selectedText);
    }

    @Override
    protected String getMarkdownLink(String selectedText) {
        String link = convertToMdLink(selectedText);
        return format("[%s](#%s%s)", selectedText, PREFIX_CHAR, link);
    }
}