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

public abstract class AbstractGenerateLinkAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        final Editor editor = e.getData(CommonDataKeys.EDITOR);
        final Project project = e.getData(CommonDataKeys.PROJECT);

        if (editor == null || project == null) return;

        String selectedText = editor.getSelectionModel().getSelectedText();
        if (selectedText == null || selectedText.isEmpty()) return;

        WriteCommandAction.runWriteCommandAction(project, () -> {
            Document document = editor.getDocument();
            int startSelection = editor.getSelectionModel().getSelectionStart();
            int endSelection = editor.getSelectionModel().getSelectionEnd();

            document.replaceString(startSelection, endSelection, getMarkdownLink(selectedText));

            if (withBodyGeneration()) {
                document.insertString(document.getTextLength(), getBody(selectedText));
            }

            ApplicationManager.getApplication().invokeLater(() -> {
                FileDocumentManager.getInstance().saveDocument(document);
            });
        });
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        final Editor editor = e.getData(CommonDataKeys.EDITOR);
        e.getPresentation().setEnabledAndVisible(
                editor != null && editor.getSelectionModel().hasSelection()
        );
    }

    protected abstract boolean withBodyGeneration();

    protected abstract String getBody(String selectedText);

    protected abstract String getMarkdownLink(String selectedText);


}