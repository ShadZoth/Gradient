package ru.hse.se.g272.ervo.ooaip.gradient;

import ru.hse.se.g272.ervo.ooaip.Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Форма для рисования градиента.
 *
 * @author Эрво Виктор
 */
public class GradForm extends Form {
    /**
     * Количество рядов на форме.
     */
    public static final int ROW_COUNT = 3;

    /**
     * Количество команд.
     */
    public static final int COMMAND_COUNT = 4;

    /**
     * Создаёт форму.
     */
    GradForm() {
        final GradientRectangle rectangle = new GradientRectangle();
        setLayout(new GridLayout(ROW_COUNT, 1));
        final JColorChooser chooser = new JColorChooser();
        add(chooser);
        JPanel controls = new JPanel(new GridLayout(1, COMMAND_COUNT));
        final JButton firstButton = new JButton("Выбрать первый цвет");
        firstButton.addActionListener(actionEvent -> {
            Color color = chooser.getColor();
            rectangle.setFirst(color);
            firstButton.setBackground(color);
        });
        firstButton.setBackground(rectangle.getFirst());
        final JButton secondButton = new JButton("Выбрать второй цвет");
        secondButton.addActionListener(actionEvent -> {
            Color color = chooser.getColor();
            rectangle.setSecond(color);
            secondButton.setBackground(color);
        });
        secondButton.setBackground(rectangle.getSecond());
        final JTextField nField = new JTextField("Количество сегментов");
        JButton drawButton = new JButton("Нарисовать градиент");
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                rectangle.setN(nFromField());
                repaint();
            }

            private int nFromField() {
                try {
                    int res = Math.abs(Integer.valueOf(nField.getText()));
                    return (res < GradientRectangle.MAX_N)
                            ? (res == 0 ? 2 : res) : GradientRectangle.MAX_N;
                } catch (NumberFormatException e) {
                    return 2;
                }
            }
        });
        controls.add(firstButton);
        controls.add(secondButton);
        controls.add(nField);
        controls.add(drawButton);
        add(controls);
        add(rectangle);
    }

    /**
     * Метод, который вызывается при запуске программы.
     * @param args Параметры командной строки
     */
    public static void main(final String[] args) {
        GradForm form = new GradForm();
        form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        form.setVisible(true);
        form.setDefaultSize(FULLSCREEN);
    }
}
