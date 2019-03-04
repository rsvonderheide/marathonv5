/*******************************************************************************
 * Copyright 2016 Jalian Systems Pvt. Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package net.sourceforge.marathon.javafxagent.components;

import java.util.logging.Logger;

import javafx.scene.Node;
import javafx.scene.control.Cell;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.ComboBoxTreeCell;
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javafx.util.StringConverter;
import net.sourceforge.marathon.javafxagent.IJavaFXAgent;
import net.sourceforge.marathon.javafxagent.JavaFXElement;
import net.sourceforge.marathon.javafxagent.JavaFXTargetLocator.JFXWindow;

public class JavaFXComboBoxCellElement extends JavaFXElement {

    public static final Logger LOGGER = Logger.getLogger(JavaFXComboBoxCellElement.class.getName());

    public JavaFXComboBoxCellElement(Node component, IJavaFXAgent driver, JFXWindow window) {
        super(component, driver, window);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public String _getValue() {
        StringConverter converter = getConverter();
        Object item = ((Cell) node).getItem();
        if (converter != null) {
            return converter.toString(item);
        }
        return item.toString();
    }

    @SuppressWarnings("rawtypes")
    private StringConverter getConverter() {
        if (node instanceof ComboBoxListCell<?>) {
            return ((ComboBoxListCell) node).getConverter();
        } else if (node instanceof ComboBoxTableCell<?, ?>)
            return ((ComboBoxTableCell) node).getConverter();
        else if (node instanceof ComboBoxTreeCell<?>)
            return ((ComboBoxTreeCell) node).getConverter();
        else if (node instanceof ComboBoxTreeTableCell<?, ?>)
            return ((ComboBoxTreeTableCell) node).getConverter();
        return null;
    }

}