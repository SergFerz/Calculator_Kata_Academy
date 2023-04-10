public class Number {
    private boolean isRome;
    private Integer value;

    public Number(String str) throws Exception {
        try {
            this.value = Integer.parseInt(str);
            this.isRome = false;
        } catch (Exception e) {
            this.value = Utils.fromRomanToInt(str);
            this.isRome = true;
        }
    }

    public boolean isRome() {
        return isRome;
    }

    public Integer getValue() {
        return value;
    }
}
