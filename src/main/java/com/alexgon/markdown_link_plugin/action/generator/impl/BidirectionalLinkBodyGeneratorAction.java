package com.alexgon.markdown_link_plugin.action.generator.impl;

import com.alexgon.markdown_link_plugin.action.generator.AbstractLinkGeneratorAction;
import com.alexgon.markdown_link_plugin.services.generator.BaseLinkGenerator;
import com.alexgon.markdown_link_plugin.services.generator.BidirectionalLinkBodyGenerator;
import com.alexgon.markdown_link_plugin.services.generator.LinkBodyGenerator;

public class BidirectionalLinkBodyGeneratorAction extends AbstractLinkGeneratorAction {

    private final BaseLinkGenerator bidirectionalLinkBodyGenerator = new BidirectionalLinkBodyGenerator();

    @Override
    protected BaseLinkGenerator getLinkGenerator() {
        return bidirectionalLinkBodyGenerator;
    }
}