package by.epam.kavalchuk.jmp.decorator;

import by.epam.kavalchuk.jmp.decorator.base.BaseDecorator;
import by.epam.kavalchuk.jmp.decorator.component.Component;
import java.awt.Color;

public class GreenDecorator extends BaseDecorator {

    public GreenDecorator(Component component) {
        super(component);
    }

    @Override
    public Color getHoveredButtonColor() {
        return Color.GREEN;
    }

}
