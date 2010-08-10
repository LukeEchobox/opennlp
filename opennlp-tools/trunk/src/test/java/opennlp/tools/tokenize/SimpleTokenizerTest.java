/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreemnets.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package opennlp.tools.tokenize;

import junit.framework.TestCase;

/**
 * Tests for the {@link SimpleTokenizer} class.
 */
public class SimpleTokenizerTest extends TestCase {

  // The SimpleTokenizer is thread safe
  private SimpleTokenizer mTokenizer = SimpleTokenizer.INSTANCE;

  /**
   * Tests if it can tokenize whitespace separated tokens.
   */
  public void testWhitespaceTokenization() {

    String text = "a b c  d     e                f    ";

    String[] tokenizedText = mTokenizer.tokenize(text);

    assertTrue("a".equals(tokenizedText[0]));
    assertTrue("b".equals(tokenizedText[1]));
    assertTrue("c".equals(tokenizedText[2]));
    assertTrue("d".equals(tokenizedText[3]));
    assertTrue("e".equals(tokenizedText[4]));
    assertTrue("f".equals(tokenizedText[5]));

    assertTrue(tokenizedText.length == 6);
  }

  /**
   * Tests if it can tokenize a word and a dot.
   */
  public void testWordDotTokenization() {
    String text = "a.";

    String[] tokenizedText = mTokenizer.tokenize(text);

    assertTrue("a".equals(tokenizedText[0]));
    assertTrue(".".equals(tokenizedText[1]));

    assertTrue(tokenizedText.length == 2);
  }

  /**
   * Tests if it can tokenize a word and numeric.
   */
  public void testWordNumericTokeniztation() {
    String text = "305KW";

    String[] tokenizedText = mTokenizer.tokenize(text);

    assertTrue("305".equals(tokenizedText[0]));
    assertTrue("KW".equals(tokenizedText[1]));

    assertTrue(tokenizedText.length == 2);
  }

  public void testWordWithOtherTokenization() {
    String text = "rebecca.sleep()";

    String[] tokenizedText = mTokenizer.tokenize(text);

    assertTrue("rebecca".equals(tokenizedText[0]));
    assertTrue(".".equals(tokenizedText[1]));
    assertTrue("sleep".equals(tokenizedText[2]));
    assertTrue("(".equals(tokenizedText[3]));
    assertTrue(")".equals(tokenizedText[4]));

    assertTrue(tokenizedText.length == 5);
  }
}