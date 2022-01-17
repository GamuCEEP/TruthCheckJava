package domain.Utils;

import Exceptions.NullValueException;

public class Value extends Number implements CharSequence {

    private String string = null;
    private Number number = null;

    public Value(String value) throws NullValueException {
        if (value == null) {
            throw new NullValueException();
        }

        string = value;
    }

    public Value(Number value) throws NullValueException {
        if (value == null) {
            throw new NullValueException();
        }

        number = value;
    }

    public Value(Boolean value) {
        if (value == null) {
            throw new NullValueException();
        }

        string = value.toString();
        number = value ? 1 : 0;
    }

    //Boolean methods -->
    public boolean boolValue() {
        if (string == null
                && (string.equals(Boolean.TRUE.toString())
                || string.equals(Boolean.FALSE.toString()))) {
            throw new NullValueException("The value does not contain a Boolean");
        }
        return Boolean.parseBoolean(string);
    }

    //Number methods -->
    @Override
    public byte byteValue() {
        if (number == null) {
            throw new NullValueException("The value does not contain a byte");
        }
        return number.byteValue();
    }

    @Override
    public short shortValue() {
        if (number == null) {
            throw new NullValueException("The value does not contain a short");
        }
        return number.shortValue();
    }

    @Override
    public int intValue() {
        if (number == null) {
            throw new NullValueException("The value does not contain a int");
        }
        return number.intValue();
    }

    @Override
    public long longValue() {
        if (number == null) {
            throw new NullValueException("The value does not contain a long");
        }
        return number.longValue();
    }

    @Override
    public float floatValue() {
        if (number == null) {
            throw new NullValueException("The value does not contain a float");
        }
        return number.floatValue();
    }

    @Override
    public double doubleValue() {
        if (number == null) {
            throw new NullValueException("The value does not contain a double");
        }
        return number.doubleValue();
    }

    //CharSequence methods -->
    public String stringValue(){
        if (string == null) {
            throw new NullValueException("The value does not contain a String");
        }
        return string;
    }
    @Override
    public int length() {
        if (string == null) {
            throw new NullValueException("The value does not contain a String");
        }
        return string.length();
    }

    @Override
    public char charAt(int index) {
        if (string == null) {
            throw new NullValueException("The value does not contain a String");
        }
        return string.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (string == null) {
            throw new NullValueException("The value does not contain a String");
        }
        return string.subSequence(start, end);
    }

}
