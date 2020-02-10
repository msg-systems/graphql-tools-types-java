/**
 * *****************************************************************************
 *
 * <p>Design and Development by msg Applied Technology Research Copyright (c) 2019-2020 msg systems
 * ag (http://www.msg-systems.com/) All Rights Reserved.
 *
 * <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * <p>The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * <p>****************************************************************************
 */
package com.graphqlio.gtt.types;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;

/**
 * Class for testing library graphql scalar type Date
 *
 * @author Michael Schäfer
 * @author Torsten Kühnert
 */
public class GttDateTypeTest {

  private static final GttDateType gttDateType = new GttDateType();
  private static final Coercing coercing = gttDateType.getCoercing();

  private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
  private static final SimpleDateFormat SDF = new SimpleDateFormat(DATE_FORMAT);

  /*
   * testing parseLiteral
   *
   * String is wrong input type
   */
  @Test
  public void whenParseLiteralGetsWrongInputTypeThenEceptionIsThrown() {
    Assertions.assertThrows(
        CoercingParseLiteralException.class,
        () -> {
          Object result = coercing.parseLiteral("2005-05-05 05:05:05");
        });
  }

  /*
   * testing parseLiteral
   *
   * StringValue is correct input type, but wrong input value format: no time
   */
  @Test
  public void whenParseLiteralGetsWrongInputFormatThenEceptionIsThrown() {
    Assertions.assertThrows(
        CoercingParseLiteralException.class,
        () -> {
          Object result = coercing.parseLiteral(new StringValue("2005-05-05"));
        });
  }

  /*
   * testing parseLiteral
   *
   * wrong input value format: no seconds
   */
  @Test
  public void whenParseLiteralGetsWrongInputFormatThenEceptionIsThrown2() {
    Assertions.assertThrows(
        CoercingParseLiteralException.class,
        () -> {
          Object result = coercing.parseLiteral(new StringValue("2005-05-05 05:05"));
        });
  }

  /*
   * testing parseLiteral
   *
   * correct input type, correct input value format
   */
  @Test
  public void whenParseLiteralGetsCorrectInputThenOutputIsCorrect() throws ParseException {
    Object result = coercing.parseLiteral(new StringValue("2005-05-05 05:05:05"));
    assertEquals(SDF.parse("2005-05-05 05:05:05"), result);
  }

  /*
   * testing parseValue
   *
   * StringValue is wrong input type
   */
  @Test
  public void whenParseValueGetsWrongInputTypeThenEceptionIsThrown() {
    Assertions.assertThrows(
        CoercingParseValueException.class,
        () -> {
          Object result = coercing.parseValue(new StringValue("2005-05-05 05:05:05"));
        });
  }

  /*
   * testing parseValue
   *
   * StringValue is correct input type, but wrong input value format: no time
   */
  @Test
  public void whenParseValueGetsWrongInputFormatThenEceptionIsThrown() {
    Assertions.assertThrows(
        CoercingParseValueException.class,
        () -> {
          Object result = coercing.parseValue("2005-05-05");
        });
  }

  /*
   * testing parseValue
   *
   * wrong input value format: no seconds
   */
  @Test
  public void whenParseValueGetsWrongInputFormatThenEceptionIsThrown2() {
    Assertions.assertThrows(
        CoercingParseValueException.class,
        () -> {
          Object result = coercing.parseValue("2005-05-05 05:05");
        });
  }

  /*
   * testing parseValue
   *
   * correct input type, correct input value format
   */
  @Test
  public void whenParseValueGetsCorrectInputThenOutputIsCorrect() throws ParseException {
    Object result = coercing.parseValue("2005-05-05 05:05:05");
    assertEquals(SDF.parse("2005-05-05 05:05:05"), result);
  }

  /*
   * testing serialize
   *
   * String is wrong input type
   */
  @Test
  public void whenSerializeGetsWrongInputTypeThenEceptionIsThrown() {
    Assertions.assertThrows(
        CoercingSerializeException.class,
        () -> {
          Object result = coercing.serialize("2005-05-05 05:05:05");
        });
  }

  /*
   * testing serialize
   *
   * Date is correct input type
   */
  @Test
  public void whenSerializeGetsCorrectInputThenOutputIsCorrect() throws ParseException {
    Object result = coercing.serialize(new SimpleDateFormat("yyyy-MM-dd").parse("2005-05-05"));
    assertEquals("2005-05-05 00:00:00", result);
  }

  /*
   * testing serialize
   *
   * correct input, compare date formatted to string
   */
  @Test
  public void whenSerializeGetsCorrectInputThenOutputIsCorrect2() {
    Date input = new Date();
    Object result = coercing.serialize(input);
    assertEquals(SDF.format(input), result);
  }

  /*
   * testing serialize
   *
   * correct input, compare date formatted to string
   */
  @Test
  public void whenSerializeGetsCorrectInputThenOutputIsCorrect3() throws ParseException {
    Object result = coercing.serialize(SDF.parse("2005-05-05 05:05:05"));
    assertEquals("2005-05-05 05:05:05", result);
  }
}
