package com.alexgon.markdown_link_plugin.action.generator.impl;

import com.alexgon.markdown_link_plugin.action.generator.AbstractLinkGeneratorAction;
import com.alexgon.markdown_link_plugin.services.generator.BaseLinkGenerator;
import com.alexgon.markdown_link_plugin.services.generator.LinkBodyGenerator;

public class LinkBodyGeneratorAction extends AbstractLinkGeneratorAction {

    private final LinkBodyGenerator linkBodyGenerator = new LinkBodyGenerator();

    @Override
    protected BaseLinkGenerator getLinkGenerator() {
        return linkBodyGenerator;
    }
}