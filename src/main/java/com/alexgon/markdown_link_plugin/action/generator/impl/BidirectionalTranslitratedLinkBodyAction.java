package com.alexgon.markdown_link_plugin.action.generator.impl;

import com.alexgon.markdown_link_plugin.action.generator.AbstractLinkAction;
import com.alexgon.markdown_link_plugin.services.generator.BaseLinkGenerator;
import com.alexgon.markdown_link_plugin.services.generator.BidirectionalTransliteratedLinkBodyGenerator;

public class BidirectionalTranslitratedLinkBodyAction extends AbstractLinkAction {

    private final BaseLinkGenerator bidirectionalLinkBodyGenerator = new BidirectionalTransliteratedLinkBodyGenerator();

    @Override
    protected BaseLinkGenerator getLinkGenerator() {
        return bidirectionalLinkBodyGenerator;
    }
}