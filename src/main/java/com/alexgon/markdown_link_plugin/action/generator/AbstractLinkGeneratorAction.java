package com.alexgon.markdown_link_plugin.action.generator;

import com.alexgon.markdown_link_plugin.services.generator.BaseLinkGenerator;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractLinkGeneratorAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        final Editor editor = e.getData(CommonDataKeys.EDITOR);
        final Project project = e.getData(CommonDataKeys.PROJECT);

        getLinkGenerator().generateLink(editor, project);
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        final Editor editor = e.getData(CommonDataKeys.EDITOR);
        final PsiFile file = e.getData(CommonDataKeys.PSI_FILE);
        e.getPresentation().setEnabledAndVisible(isAvailable(editor, file));

    }

    private boolean isAvailable(Editor editor, PsiFile file) {
        return editor != null
                && editor.getSelectionModel().hasSelection()
                && file != null
                && "Markdown".equals(file.getLanguage().getDisplayName());
    }

    protected abstract BaseLinkGenerator getLinkGenerator();
}
