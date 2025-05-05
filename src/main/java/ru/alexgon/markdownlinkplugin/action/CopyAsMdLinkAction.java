package ru.alexgon.markdownlinkplugin.action;

import ru.alexgon.markdownlinkplugin.StringConverter;
import ru.alexgon.markdownlinkplugin.utils.StringConverterUtils;

public class CopyAsMdLinkAction extends AbstractCopyAsMdLink {

    @Override
    protected StringConverter getConverter() {
        return StringConverterUtils::convertToMdLink;
    }
}