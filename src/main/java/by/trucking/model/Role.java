package by.trucking.model;

public enum Role {
    ADMINISTRATOR("администратор"),
    CLIENT("заказчик"),
    ORGANIZATION("перевозчик"),
    UNDEFINED("неизвестно");


    public static Role getByOrdinal(int ordinal) {
        Role[] values = Role.values();
        if (ordinal >= values.length || ordinal < 0) {
            return UNDEFINED;
        }
        return values[ordinal];
    }


    private String label;

    Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }


}
