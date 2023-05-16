package org.example;

class Card {
    Value value;
    private Sign sign;

    public Card(Value value, Sign sign) {
        this.value = value;
        this.sign = sign;
    }

    @Override
    public String toString() {
        return value.getDisplayValue() + " de " + sign;
    }


    enum Sign {
        pique,
        coeur,
        carreau,
        trefle
    }

    enum Value {
        deux("2"),
        trois("3"),
        quatre("4"),
        cinq("5"),
        six("6"),
        sept("7"),
        huit("8"),
        neuf("9"),
        dix("10"),
        valet("Valet"),
        dame("Dame"),
        roi("Roi"),
        as("As");

        private String displayValue;

        Value(String displayValue) {
            this.displayValue = displayValue;
        }

        public String getDisplayValue() {
            return displayValue;
        }
    }

}
