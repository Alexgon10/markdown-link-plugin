package com.alexgon.markdown_link_plugin.services.generator;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;

public interface BaseLinkGenerator {

    default void generateLink(Editor editor, Project project) {

        if (editor == null || project == null) return;

        String selectedText = editor.getSelectionModel().getSelectedText();
        if (selectedText == null || selectedText.isEmpty()) return;

        WriteCommandAction.runWriteCommandAction(project, () -> {
            if (project.isDisposed() || editor.isDisposed()) return;
            Document document = editor.getDocument();
            int startSelection = editor.getSelectionModel().getSelectionStart();
            int endSelection = editor.getSelectionModel().getSelectionEnd();

            document.replaceString(startSelection, endSelection, getMarkdownLinkText(selectedText));

            if (withBodyGeneration()) {
                document.insertString(document.getTextLength(),"\n");
                document.insertString(document.getTextLength(), getBodyText(selectedText));
            }

            ApplicationManager.getApplication().invokeLater(() -> {
                FileDocumentManager.getInstance().saveDocument(document);
            });
        });
    }

    boolean withBodyGeneration();

    String getBodyText(String selectedText);

    String getMarkdownLinkText(String selectedText);


}