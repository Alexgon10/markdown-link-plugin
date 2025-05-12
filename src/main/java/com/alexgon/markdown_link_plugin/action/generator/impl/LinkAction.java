package com.alexgon.markdown_link_plugin.action.generator.impl;

import com.alexgon.markdown_link_plugin.action.generator.AbstractLinkAction;
import com.alexgon.markdown_link_plugin.services.generator.BaseLinkGenerator;
import com.alexgon.markdown_link_plugin.services.generator.LinkGenerator;

public class LinkAction extends AbstractLinkAction {

    private final LinkGenerator linkGenerator = new LinkGenerator();

    @Override
    protected BaseLinkGenerator getLinkGenerator() {
        return linkGenerator;
    }
}