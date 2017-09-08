package com.nexxspace.tools;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;

import static com.intellij.openapi.actionSystem.CommonDataKeys.EDITOR;
import static com.intellij.openapi.actionSystem.CommonDataKeys.PROJECT;
import static com.intellij.openapi.command.WriteCommandAction.runWriteCommandAction;

public class JsonTogglerAction extends AnAction {
    public JsonTogglerAction() {
        super("Text _Convert to JSON");
    }

    public void update(AnActionEvent e) {
        Project project = e.getData(PROJECT);
        Editor editor = e.getData(EDITOR);

        e.getPresentation().setVisible(project != null && editor != null && editor.getSelectionModel().hasSelection());
    }

    public void actionPerformed(AnActionEvent e) {
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        Project project = e.getRequiredData(CommonDataKeys.PROJECT);

        Document document = editor.getDocument();
        SelectionModel selectionModel = editor.getSelectionModel();

        int start = selectionModel.getSelectionStart();
        int end = selectionModel.getSelectionEnd();

        String selectedText = document.getText(new TextRange(start, end));

        String convertedText = JsonTogger.toggle(selectedText);

        runWriteCommandAction(project, () -> document.replaceString(start, end, convertedText));

        selectionModel.removeSelection();
    }
}
