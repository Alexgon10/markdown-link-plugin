package com.alexgon.markdown_link_plugin.action.generator.impl;

import com.alexgon.markdown_link_plugin.action.generator.AbstractLinkAction;
import com.alexgon.markdown_link_plugin.services.generator.BaseLinkGenerator;
import com.alexgon.markdown_link_plugin.services.generator.BidirectionalLinkBodyGenerator;

public class BidirectionalLinkBodyAction extends AbstractLinkAction {

    private final BaseLinkGenerator bidirectionalLinkBodyGenerator = new BidirectionalLinkBodyGenerator();

    @Override
    protected BaseLinkGenerator getLinkGenerator() {
        return bidirectionalLinkBodyGenerator;
    }
}