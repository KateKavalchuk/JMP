package by.epam.kavalchuk.jmp.executor;

import by.epam.kavalchuk.jmp.decorator.base.BaseDecorator;
import by.epam.kavalchuk.jmp.decorator.GreenDecorator;
import by.epam.kavalchuk.jmp.decorator.SimpleButton;
import by.epam.kavalchuk.jmp.frame.AdministrativeFrame;

public class Executor {

    public static void main(String[] args) {
        BaseDecorator button = new GreenDecorator(new SimpleButton());
        new AdministrativeFrame(button.getHoveredButtonColor(), button.getExitedButtonColor()).showWindow();
    }
}
