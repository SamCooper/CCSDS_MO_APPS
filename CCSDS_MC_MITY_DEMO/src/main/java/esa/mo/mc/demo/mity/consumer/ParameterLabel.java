/* ----------------------------------------------------------------------------
 * Copyright (C) 2014      European Space Agency
 *                         European Space Operations Centre
 *                         Darmstadt
 *                         Germany
 * ----------------------------------------------------------------------------
 * System                : CCSDS MO MC Mity Demo Application
 * ----------------------------------------------------------------------------
 * Licensed under the European Space Agency Public License, Version 2.0
 * You may not use this file except in compliance with the License.
 *
 * Except as expressly set forth in this License, the Software is provided to
 * You on an "as is" basis and without warranties of any kind, including without
 * limitation merchantability, fitness for a particular purpose, absence of
 * defects or errors, accuracy or non-infringement of intellectual property rights.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * ----------------------------------------------------------------------------
 */
package esa.mo.mc.demo.mity.consumer;

import java.awt.Color;
import java.io.Serializable;

/**
 * Class that extends the basic Swing label class to add in automatic handling for displaying an update.
 */
class ParameterLabel extends javax.swing.JLabel implements Serializable
{
  private final Color[] colours = new Color[]
  {
    Color.GREEN, Color.BLACK, Color.BLACK, Color.GREEN
  };
  private String value = "";
  private short oldval;

  public ParameterLabel(final int index)
  {
    super();
    oldval = 1;
  }

  public void setNewValue(final String newVal, final long iDiff)
  {
    value = newVal;
    displayValue();
  }

  public void displayValue()
  {
    // display the new value
    setText(value);

    // if we are in error we highlight the label in a different colour
    final int ii = Math.abs(oldval % 2);
    if (!value.equals(""))
    {
      oldval++;
      setBackground(colours[2 + ii]);
    }
    else
    {
      setBackground(Color.WHITE);
    }

    setForeground(colours[ii]);
  }

  public void setRed()
  {
    setBackground(Color.RED);
    setForeground(Color.BLACK);
  }
}
