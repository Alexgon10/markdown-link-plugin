package com.alexgon.markdown_link_plugin.action.generator.impl;

import com.alexgon.markdown_link_plugin.action.generator.AbstractLinkGeneratorAction;
import com.alexgon.markdown_link_plugin.services.generator.BaseLinkGenerator;
import com.alexgon.markdown_link_plugin.services.generator.TransliteratedLinkGenerator;

public class TransliteratedLinkGeneratorAction extends AbstractLinkGeneratorAction {

    private final BaseLinkGenerator transliteratedLinkGenerator
            = new TransliteratedLinkGenerator();

    @Override
    protected BaseLinkGenerator getLinkGenerator() {
        return transliteratedLinkGenerator;
    }
}
