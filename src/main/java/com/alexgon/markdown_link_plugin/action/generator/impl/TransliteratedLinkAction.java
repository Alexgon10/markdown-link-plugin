package com.alexgon.markdown_link_plugin.action.generator.impl;

import com.alexgon.markdown_link_plugin.action.generator.AbstractLinkAction;
import com.alexgon.markdown_link_plugin.services.generator.BaseLinkGenerator;
import com.alexgon.markdown_link_plugin.services.generator.TransliteratedLinkGenerator;

public class TransliteratedLinkAction extends AbstractLinkAction {

    private final BaseLinkGenerator transliteratedLinkGenerator
            = new TransliteratedLinkGenerator();

    @Override
    protected BaseLinkGenerator getLinkGenerator() {
        return transliteratedLinkGenerator;
    }
}
