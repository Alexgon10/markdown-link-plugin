package com.alexgon.markdown_link_plugin.action;

import com.alexgon.markdown_link_plugin.StringConverter;
import com.alexgon.markdown_link_plugin.utils.StringConverterUtils;

public class CopyAsMdLinkAction extends AbstractCopyAsMdLink {

    @Override
    protected StringConverter getConverter() {
        return StringConverterUtils::convertToMdLink;
    }
}