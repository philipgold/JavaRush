package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);


    public UndoListener getUndoListener() {
        return undoListener;
    }

    public View(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * вызваться при выборе пунктов меню, у которых наше представление указано в виде слушателя событий.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Получи из события команду с помощью метода getActionCommand(). Это будет обычная строка.
        //По этой строке ты можешь понять какой пункт меню создал данное событие.
        String command = e.getActionCommand();

        switch (command) {

            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;
        }
    }

    public void init(){
        initGui();
        //Добавлять слушателя событий нашего окна
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);

        //Показывать наше окно
        setVisible(true);
    }

    public void exit(){
        this.controller.exit();
    }

    public void initMenuBar(){
        //Создавать новый объект типа JMenuBar. Это и будет наша панель меню
        JMenuBar jMenuBar = new JMenuBar();

        //С помощью MenuHelper инициализировать меню
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);

        //Добавлять в верхнюю часть панели контента текущего фрейма нашу панель меню, аналогично тому, как это мы делали с панелью вкладок
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }

    public void initEditor(){
        //Устанавливает значение «text/html» в качестве типа контента для компонента htmlTextPane.
        this.htmlTextPane.setContentType("text/html");

        //Добавляет вкладку в панель tabbedPane с именем «HTML» и компонентом JScrollPane на базе htmlTextPaneиз.
        this.tabbedPane.addTab("HTML", new JScrollPane(this.htmlTextPane));

        //Добавляет еще одну вкладку в tabbedPane с именем «Текст» и компонентом JScrollPane на базе plainTextPane.
        this.tabbedPane.addTab("Текст", new JScrollPane(this.plainTextPane));

        //Устанавливает предпочтительный размер панели tabbedPane.
        this.tabbedPane.setPreferredSize(new Dimension(500,500));

        //Создает объект класса TabbedPaneChangeListener и устанавливает его в качестве слушателя изменений в tabbedPane.
        this.tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        //Добавляет по центру панели контента текущего фрейма нашу панель с вкладками.
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }

    public void initGui(){
        this.initMenuBar();
        this.initEditor();
        this.pack();
    }

    /**
     * Этот метод вызывается, когда произошла смена выбранной вкладки
     */
    public void selectedTabChanged(){
        //Метод должен проверить, какая вкладка сейчас оказалась выбранной
        //Если выбрана вкладка с индексом 0 (html вкладка)
        if (tabbedPane.getSelectedIndex() ==0){
        //if (isHtmlTabSelected()) {
            //значит нам нужно получить текст из plainTextPane и установить его в контроллер с помощью метода setPlainText
            controller.setPlainText(plainTextPane.getText());
        }
        //eсли выбрана вкладка с индексом 1 (вкладка с html текстом)
        else {
            //необходимо получить текст у контроллера с помощью метода getPlainText() и установить его в панель plainTextPane
            plainTextPane.setText(controller.getPlainText());
        }
        //Сбросить правки
        resetUndo();
    }

    public boolean canUndo(){
        return this.undoManager.canUndo();
    }

    public boolean canRedo(){
        return this.undoManager.canRedo();
    }

    public void undo(){
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo(){
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab(){
        //Выбирать html вкладку (переключаться на нее)
        tabbedPane.setSelectedIndex(0);
        //Сбрасывать все правки с помощью метода
        resetUndo();
    }

    /**
     * получает документ у контроллера и устанавливать его в панель редактирования htmlTextPane
     */
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(this, "HTML Editor", "About", JOptionPane.INFORMATION_MESSAGE);
    }

}
