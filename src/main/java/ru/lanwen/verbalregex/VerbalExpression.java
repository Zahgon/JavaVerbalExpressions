package ru.lanwen.verbalregex;

import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerbalExpression {

    private final Pattern pattern;

    public static class Builder {

        private StringBuilder prefixes = new StringBuilder();

        private StringBuilder source = new StringBuilder();

        private StringBuilder suffixes = new StringBuilder();

        private int modifiers = Pattern.MULTILINE;

        private static final Map<Character, Integer> SYMBOL_MAP = new HashMap<Character, Integer>() {

            {
                put('d', Pattern.UNIX_LINES);
                put('i', Pattern.CASE_INSENSITIVE);
                put('x', Pattern.COMMENTS);
                put('m', Pattern.MULTILINE);
                put('s', Pattern.DOTALL);
                put('u', Pattern.UNICODE_CASE);
                put('U', Pattern.UNICODE_CHARACTER_CLASS);
            }
        };

        /**
         * Package private. Use {@link #regex()} to build a new one
         *
         * @since 1.2
         */
        Builder() {
        }

        /**
         * Escapes any non-word char with two backslashes
         * used by any method, except {@link #add(String)}
         *
         * @param pValue - the string for char escaping
         * @return sanitized string value
         */
        private String sanitize(final String pValue) {
            return pValue.replaceAll("[\\W]", "\\\\$0");
        }

        /**
         * Counts occurrences of some substring in whole string
         * Same as org.apache.commons.lang3.StringUtils#countMatches(String, java.lang.String)
         * by effect. Used to count braces for {@link #or(String)} method
         *
         * @param where - where to find
         * @param what  - what needs to count matches
         * @return 0 if nothing found, count of occurrences instead
         */
        private int countOccurrencesOf(String where, String what) {
            return (where.length() - where.replace(what, "").length()) / what.length();
        }

        public VerbalExpression build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Append literal expression
         * Everything added to the expression should go trough this method
         * (keep in mind when creating your own methods).
         * All existing methods already use this, so for basic usage, you can just ignore this method.
         * <p>
         * Example:
         * regex().add("\n.*").build() // produce exact "\n.*" regexp
         *
         * @param pValue - literal expression, not sanitized
         * @return this builder
         */
        public Builder add(final String pValue) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Append a regex from builder and wrap it with unnamed group (?: ... )
         *
         * @param regex - VerbalExpression.Builder, that not changed
         * @return this builder
         * @since 1.2
         */
        public Builder add(final Builder regex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Enable or disable the expression to start at the beginning of the line
         *
         * @param pEnable - enables or disables the line starting
         * @return this builder
         */
        public Builder startOfLine(final boolean pEnable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Mark the expression to start at the beginning of the line
         * Same as {@link #startOfLine(boolean)} with true arg
         *
         * @return this builder
         */
        public Builder startOfLine() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Enable or disable the expression to end at the last character of the line
         *
         * @param pEnable - enables or disables the line ending
         * @return this builder
         */
        public Builder endOfLine(final boolean pEnable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Mark the expression to end at the last character of the line
         * Same as {@link #endOfLine(boolean)} with true arg
         *
         * @return this builder
         */
        public Builder endOfLine() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add a string to the expression
         *
         * @param pValue - the string to be looked for (sanitized)
         * @return this builder
         */
        public Builder then(final String pValue) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add a string to the expression
         * Syntax sugar for {@link #then(String)} - use it in case:
         * regex().find("string") // when it goes first
         *
         * @param value - the string to be looked for (sanitized)
         * @return this builder
         */
        public Builder find(final String value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add a string to the expression that might appear once (or not)
         * Example:
         * The following matches all strings that contain http:// or https://
         * VerbalExpression regex = regex()
         * .find("http")
         * .maybe("s")
         * .then("://")
         * .anythingBut(" ").build();
         * regex.test("http://")    //true
         * regex.test("https://")   //true
         *
         * @param pValue - the string to be looked for
         * @return this builder
         */
        public Builder maybe(final String pValue) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         *  Add a regex to the expression that might appear once (or not)
         *  Example:
         *  The following matches all names that have a prefix or not.
         *  VerbalExpression.Builder namePrefix = regex().oneOf("Mr.", "Ms.");
         *  VerbalExpression name = regex()
         * 	.maybe(namePrefix)
         * 	.space()
         * 	.zeroOrMore()
         * 	.word()
         * 	.oneOrMore()
         * 	.build();
         *  regex.test("Mr. Bond/")    //true
         *  regex.test("James")   //true
         *
         *  @param regex - the string to be looked for
         *  @return this builder
         */
        public Builder maybe(final Builder regex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add expression that matches anything (includes empty string)
         *
         * @return this builder
         */
        public Builder anything() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add expression that matches anything, but not passed argument
         *
         * @param pValue - the string not to match
         * @return this builder
         */
        public Builder anythingBut(final String pValue) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add expression that matches something that might appear once (or more)
         *
         * @return this builder
         */
        public Builder something() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder somethingButNot(final String pValue) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add universal line break expression
         *
         * @return this builder
         */
        public Builder lineBreak() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut for {@link #lineBreak()}
         *
         * @return this builder
         */
        public Builder br() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add expression to match a tab character ('\u0009')
         *
         * @return this builder
         */
        public Builder tab() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add word, same as [a-zA-Z_0-9]+
         *
         * @return this builder
         */
        public Builder word() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /*
           --- Predefined character classes
         */
        /**
         * Add word character, same as [a-zA-Z_0-9]
         *
         * @return this builder
         */
        public Builder wordChar() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add non-word character: [^\w]
         *
         * @return this builder
         */
        public Builder nonWordChar() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add non-digit: [^0-9]
         *
         * @return this builder
         */
        public Builder nonDigit() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add same as [0-9]
         *
         * @return this builder
         */
        public Builder digit() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add whitespace character, same as [ \t\n\x0B\f\r]
         *
         * @return this builder
         */
        public Builder space() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add non-whitespace character: [^\s]
         *
         * @return this builder
         */
        public Builder nonSpace() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add word boundary: \b
         * <p>
         * Example:
         * <pre>{@code
         * VerbalExpression regex = regex()
         *         .wordBoundary().find("abc").wordBoundary()
         *         .build();
         * regex.test("a abc"); // true
         * regex.test("a.abc"); // true
         * regex.test("aabc"); // false
         * }</pre>
         *
         * @return this builder
         */
        public Builder wordBoundary() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /*
           --- / end of predefined character classes
         */
        public Builder anyOf(final String pValue) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut to {@link #anyOf(String)}
         *
         * @param value - CharSequence every char from can be matched
         * @return this builder
         */
        public Builder any(final String value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add expression to match a range (or multiply ranges)
         * Usage: .range(from, to [, from, to ... ])
         * Example: The following matches a hexadecimal number:
         * regex().range( "0", "9", "a", "f") // produce [0-9a-f]
         *
         * @param pArgs - pairs for range
         * @return this builder
         */
        public Builder range(final String... pArgs) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder addModifier(final char pModifier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder removeModifier(final char pModifier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder withAnyCase(final boolean pEnable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Turn ON matching with ignoring case
         * Example:
         * // matches "a"
         * // matches "A"
         * regex().find("a").withAnyCase()
         *
         * @return this builder
         */
        public Builder withAnyCase() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder searchOneLine(final boolean pEnable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Convenient method to show that string usage count is exact count, range count or simply one or more
         * Usage:
         * regex().multiply("abc")                                  // Produce (?:abc)+
         * regex().multiply("abc", null)                            // Produce (?:abc)+
         * regex().multiply("abc", (int)from)                       // Produce (?:abc){from}
         * regex().multiply("abc", (int)from, (int)to)              // Produce (?:abc){from, to}
         * regex().multiply("abc", (int)from, (int)to, (int)...)    // Produce (?:abc)+
         *
         * @param pValue - the string to be looked for
         * @param count  - (optional) if passed one or two numbers, it used to show count or range count
         * @return this builder
         * @see #oneOrMore()
         * @see #then(String)
         * @see #zeroOrMore()
         */
        public Builder multiple(final String pValue, final int... count) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Adds "+" char to regexp
         * Same effect as {@link #atLeast(int)} with "1" argument
         * Also, used by {@link #multiple(String, int...)} when second argument is null, or have length more than 2
         *
         * @return this builder
         * @since 1.2
         */
        public Builder oneOrMore() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Adds "*" char to regexp, means zero or more times repeated
         * Same effect as {@link #atLeast(int)} with "0" argument
         *
         * @return this builder
         * @since 1.2
         */
        public Builder zeroOrMore() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add count of previous group
         * for example:
         * .find("w").count(3) // produce - (?:w){3}
         *
         * @param count - number of occurrences of previous group in expression
         * @return this Builder
         */
        public Builder count(final int count) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Produce range count
         * for example:
         * .find("w").count(1, 3) // produce (?:w){1,3}
         *
         * @param from - minimal number of occurrences
         * @param to   - max number of occurrences
         * @return this Builder
         * @see #count(int)
         */
        public Builder count(final int from, final int to) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Produce range count with only minimal number of occurrences
         * for example:
         * .find("w").atLeast(1) // produce (?:w){1,}
         *
         * @param from - minimal number of occurrences
         * @return this Builder
         * @see #count(int)
         * @see #oneOrMore()
         * @see #zeroOrMore()
         * @since 1.2
         */
        public Builder atLeast(final int from) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add a alternative expression to be matched
         *
         * Issue #32
         *
         * @param pValue - the string to be looked for
         * @return this builder
         */
        public Builder or(final String pValue) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Adds an alternative expression to be matched
         * based on an array of values
         *
         * @param pValues - the strings to be looked for
         * @return this builder
         * @since 1.3
         */
        public Builder oneOf(final String... pValues) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Adds capture - open brace to current position and closed to suffixes
         *
         * @return this builder
         */
        public Builder capture() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Adds named-capture - open brace to current position and closed to suffixes
         * <p>
         * <pre>Example:{@code
         * String text = "test@example.com";
         * VerbalExpression regex = regex()
         *         .find("@")
         *         .capture("domain").anything().build();
         * regex.getText(text, "domain"); // => "example.com"
         * }</pre>
         *
         * @return this builder
         * @since 1.6
         */
        public Builder capture(final String name) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut for {@link #capture()}
         *
         * @return this builder
         * @since 1.2
         */
        public Builder capt() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut for {@link #capture(String)}
         *
         * @return this builder
         * @since 1.6
         */
        public Builder capt(final String name) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Same as {@link #capture()}, but don't save result
         * May be used to set count of duplicated captures, without creating a new saved capture
         * Example:
         * // Without group() - count(2) applies only to second capture
         * regex().group()
         * .capt().range("0", "1").endCapt().tab()
         * .capt().digit().count(5).endCapt()
         * .endGr().count(2);
         *
         * @return this builder
         * @since 1.2
         */
        public Builder group() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Close brace for previous capture and remove last closed brace from suffixes
         * Can be used to continue build regex after capture or to add multiply captures
         *
         * @return this builder
         */
        public Builder endCapture() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Shortcut for {@link #endCapture()}
         *
         * @return this builder
         * @since 1.2
         */
        public Builder endCapt() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Closes current unnamed and unmatching group
         * Shortcut for {@link #endCapture()}
         * Use it with {@link #group()} for prettify code
         * Example:
         * regex().group().maybe("word").count(2).endGr()
         *
         * @return this builder
         * @since 1.2
         */
        public Builder endGr() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Use builder {@link #regex()} (or {@link #regex(ru.lanwen.verbalregex.VerbalExpression.Builder)})
     * to create new instance of VerbalExpression
     *
     * @param pattern - {@link java.util.regex.Pattern} that constructed by builder
     */
    private VerbalExpression(final Pattern pattern) {
        this.pattern = pattern;
    }

    /**
     * Test that full string matches regular expression
     *
     * @param pToTest - string to check match
     * @return true if matches exact string, false otherwise
     */
    public boolean testExact(final String pToTest) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Test that full string contains regex
     *
     * @param pToTest - string to check match
     * @return true if string contains regex, false otherwise
     */
    public boolean test(final String pToTest) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Extract full string that matches regex
     * Same as {@link #getText(String, int)} for 0 group
     *
     * @param toTest - string to extract from
     * @return group 0, extracted from text
     */
    public String getText(final String toTest) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Extract exact group from string
     *
     * @param toTest - string to extract from
     * @param group  - group to extract
     * @return extracted group
     * @since 1.1
     */
    public String getText(final String toTest, final int group) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Extract exact named-group from string
     * <p>
     * Example is see to {@link Builder#capture(String)}
     *
     * @param toTest - string to extract from
     * @param group  - group to extract
     * @return extracted group
     * @since 1.6
     */
    public String getText(final String toTest, final String group) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Extract exact group from string and add it to list
     *
     * Example:
     * String text = "SampleHelloWorldString";
     * VerbalExpression regex = regex().capt().oneOf("Hello", "World").endCapt().maybe("String").build();
     * list = regex.getTextGroups(text, 0) //result: "Hello", "WorldString"
     * list = regex.getTextGroups(text, 1) //result: "Hello", "World"
     *
     * @param toTest - string to extract from
     * @param group  - group to extract
     * @return list of extracted groups
     */
    public List<String> getTextGroups(final String toTest, final int group) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates new instance of VerbalExpression builder from cloned builder
     *
     * @param pBuilder - instance to clone
     * @return new VerbalExpression.Builder copied from passed
     * @since 1.1
     */
    public static Builder regex(final Builder pBuilder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates new instance of VerbalExpression builder
     *
     * @return new VerbalExpression.Builder
     * @since 1.1
     */
    public static Builder regex() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
