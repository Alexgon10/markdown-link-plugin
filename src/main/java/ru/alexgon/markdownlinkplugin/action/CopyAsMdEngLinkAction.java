package ru.alexgon.markdownlinkplugin.action;

import ru.alexgon.markdownlinkplugin.StringConverter;
import ru.alexgon.markdownlinkplugin.utils.StringConverterUtils;

public class CopyAsMdEngLinkAction extends AbstractCopyAsMdLink {

    @Override
    protected StringConverter getConverter() {
        return StringConverterUtils::convertToMdEngLink;
    }
}