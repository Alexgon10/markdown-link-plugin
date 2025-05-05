package com.alexgon.markdown_link_plugin.action.generation;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import static com.alexgon.markdown_link_plugin.utils.StringConverterUtils.convertToMdLink;

public class GenerateLinkAction extends AbstractGenerateLinkAction {

    @Override
    protected boolean withBodyGeneration() {
        return false;
    }

    @Override
    protected String getBody(String selectedText) {
        throw new UnsupportedOperationException("Not supported body.");
    }

    @Override
    protected String getMarkdownLink(String selectedText) {
        String link = convertToMdLink(selectedText);
        return String.format("[%s](#%s)", selectedText, link);
    }
}