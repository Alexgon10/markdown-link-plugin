package com.alexgon.markdown_link_plugin.action.intention;

import com.alexgon.markdown_link_plugin.services.generator.BaseLinkGenerator;
import com.alexgon.markdown_link_plugin.services.generator.TransliteratedLinkBodyGenerator;
import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

public class TransliteratedLinkBodyGeneratorIntention implements IntentionAction {

    BaseLinkGenerator transliteratedLinkBodyGenerator = new TransliteratedLinkBodyGenerator();

    @Override
    public @NotNull String getText() {
        return "Generate transliterated markdown link";
    }

    @Override
    public @NotNull String getFamilyName() {
        return "TransliteratedLinkBodyGenerator";
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
        if (project.isDisposed() || editor.isDisposed()) {
            return false;
        }

        return editor.getSelectionModel().hasSelection()
                && file != null
                && "Markdown".equals(file.getLanguage().getDisplayName());
    }

    @Override
    public void invoke(@NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file) throws IncorrectOperationException {
        try {
            transliteratedLinkBodyGenerator.generateLink(editor, project);
        } catch (Exception e) {
            Logger.getInstance(getClass()).error(e);
        }
    }

    @Override
    public boolean startInWriteAction() {
        return true;
    }
}
