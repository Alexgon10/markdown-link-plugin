package com.alexgon.markdown_link_plugin.action.generation;

import static com.alexgon.markdown_link_plugin.utils.StringConverterUtils.convertToMdEngLink;
import static com.alexgon.markdown_link_plugin.utils.StringConverterUtils.convertToMdLink;

public class GenerateTransliteratedLinkAction extends AbstractGenerateLinkAction {

    @Override
    protected boolean withBodyGeneration() {
        return false;
    }

    @Override
    protected String getBody(String selectedText) {
        throw new UnsupportedOperationException("Not supported body.");
    }

    @Override
    protected String getMarkdownLink(String selectedText) {
        String link = convertToMdEngLink(selectedText);
        return String.format("[%s](#%s)", selectedText, link);
    }
}
