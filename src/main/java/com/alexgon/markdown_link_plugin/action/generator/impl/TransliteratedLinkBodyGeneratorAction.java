package com.alexgon.markdown_link_plugin.action.generator.impl;

import com.alexgon.markdown_link_plugin.action.generator.AbstractLinkGeneratorAction;
import com.alexgon.markdown_link_plugin.services.generator.BaseLinkGenerator;
import com.alexgon.markdown_link_plugin.services.generator.TransliteratedLinkBodyGenerator;

public class TransliteratedLinkBodyGeneratorAction extends AbstractLinkGeneratorAction {

    private final TransliteratedLinkBodyGenerator transliteratedLinkBodyGenerator
            = new TransliteratedLinkBodyGenerator();

    @Override
    protected BaseLinkGenerator getLinkGenerator() {
        return transliteratedLinkBodyGenerator;
    }
}
