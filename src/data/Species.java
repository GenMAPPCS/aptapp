/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import gui.DatasetParametersPanel;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

/**
 *
 * @author Anurag Sharma, the user
 */
public class Species {

    public String code, name;

    public Species() {
        code = "";
        name = "";
    }

    public Species(String code, String name) {
        this.code = code;
        this.name = name;

    }

    @Override
    public String toString() {
        return "[S:" + code + "," + name + "]";
    }
}
