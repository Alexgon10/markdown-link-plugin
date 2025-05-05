package com.alexgon.markdown_link_plugin.action.copy.impl;

import com.alexgon.markdown_link_plugin.StringConverter;
import com.alexgon.markdown_link_plugin.action.copy.AbstractCopyAsMdLink;
import com.alexgon.markdown_link_plugin.utils.StringConverterUtils;

public class CopyAsMdEngLinkAction extends AbstractCopyAsMdLink {

    @Override
    protected StringConverter getConverter() {
        return StringConverterUtils::convertToMdEngLink;
    }
}