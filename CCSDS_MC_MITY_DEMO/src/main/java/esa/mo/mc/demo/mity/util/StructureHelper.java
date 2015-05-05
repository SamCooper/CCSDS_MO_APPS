/* ----------------------------------------------------------------------------
 * Copyright (C) 2013      European Space Agency
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
package esa.mo.mc.demo.mity.util;

import org.ccsds.moims.mo.com.archive.structures.ExpressionOperator;
import org.ccsds.moims.mo.mal.structures.Attribute;

/**
 * Helper class that contains useful utility functions.
 *
 */
public abstract class StructureHelper extends esa.mo.mal.support.StructureHelper
{
  public static Boolean evaluateExpression(Attribute leftHandSide, ExpressionOperator operator, Attribute rightHandSide)
  {
    if (leftHandSide.toString().equals("null") || operator == null || rightHandSide.toString().equals("null"))
    {
      return null; // None of the arguments can be null;
    }

    // Verify all the possible validity expression operators
    if (operator.equals(ExpressionOperator.EQUAL))
    {
      return (Double.parseDouble(leftHandSide.toString()) == Double.parseDouble(rightHandSide.toString()));
    }

    if (operator.equals(ExpressionOperator.DIFFER))
    {
      return (Double.parseDouble(leftHandSide.toString()) != Double.parseDouble(rightHandSide.toString()));
    }

    if (operator.equals(ExpressionOperator.GREATER))
    {
      return (Double.parseDouble(leftHandSide.toString()) > Double.parseDouble(rightHandSide.toString()));
    }

    if (operator.equals(ExpressionOperator.GREATER_OR_EQUAL))
    {
      return (Double.parseDouble(leftHandSide.toString()) >= Double.parseDouble(rightHandSide.toString()));
    }

    if (operator.equals(ExpressionOperator.LESS))
    {
      return (Double.parseDouble(leftHandSide.toString()) < Double.parseDouble(rightHandSide.toString()));
    }

    if (operator.equals(ExpressionOperator.LESS_OR_EQUAL))
    {
      return (Double.parseDouble(leftHandSide.toString()) <= Double.parseDouble(rightHandSide.toString()));
    }

    if (operator.equals(ExpressionOperator.CONTAINS))
    {
      return leftHandSide.toString().contains(rightHandSide.toString());
    }

    if (operator.equals(ExpressionOperator.ICONTAINS))
    {
      return leftHandSide.toString().toLowerCase().contains(rightHandSide.toString().toLowerCase());
    }

    return null; // The expression was not evaluated
  }
}
